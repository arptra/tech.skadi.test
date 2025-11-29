package io.netty.handler.codec.socksx.v5;

import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.EncoderException;
import io.netty.util.CharsetUtil;
import io.netty.util.NetUtil;

public interface Socks5AddressEncoder {
    public static final Socks5AddressEncoder DEFAULT = new Socks5AddressEncoder() {
        public void encodeAddress(Socks5AddressType socks5AddressType, String str, ByteBuf byteBuf) throws Exception {
            byte byteValue = socks5AddressType.byteValue();
            if (byteValue == Socks5AddressType.IPv4.byteValue()) {
                if (str != null) {
                    byteBuf.writeBytes(NetUtil.createByteArrayFromIpAddressString(str));
                } else {
                    byteBuf.writeInt(0);
                }
            } else if (byteValue == Socks5AddressType.DOMAIN.byteValue()) {
                if (str != null) {
                    byteBuf.writeByte(str.length());
                    byteBuf.writeCharSequence(str, CharsetUtil.US_ASCII);
                    return;
                }
                byteBuf.writeByte(0);
            } else if (byteValue != Socks5AddressType.IPv6.byteValue()) {
                throw new EncoderException("unsupported addrType: " + (socks5AddressType.byteValue() & 255));
            } else if (str != null) {
                byteBuf.writeBytes(NetUtil.createByteArrayFromIpAddressString(str));
            } else {
                byteBuf.writeLong(0);
                byteBuf.writeLong(0);
            }
        }
    };

    void encodeAddress(Socks5AddressType socks5AddressType, String str, ByteBuf byteBuf) throws Exception;
}
