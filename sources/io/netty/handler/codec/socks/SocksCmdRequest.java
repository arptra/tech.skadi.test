package io.netty.handler.codec.socks;

import com.upuphone.runasone.api.ApiConstant;
import io.netty.buffer.ByteBuf;
import io.netty.util.CharsetUtil;
import io.netty.util.NetUtil;
import io.netty.util.internal.ObjectUtil;
import java.net.IDN;

public final class SocksCmdRequest extends SocksRequest {
    private final SocksAddressType addressType;
    private final SocksCmdType cmdType;
    private final String host;
    private final int port;

    /* renamed from: io.netty.handler.codec.socks.SocksCmdRequest$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$socks$SocksAddressType;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                io.netty.handler.codec.socks.SocksAddressType[] r0 = io.netty.handler.codec.socks.SocksAddressType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$io$netty$handler$codec$socks$SocksAddressType = r0
                io.netty.handler.codec.socks.SocksAddressType r1 = io.netty.handler.codec.socks.SocksAddressType.IPv4     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$io$netty$handler$codec$socks$SocksAddressType     // Catch:{ NoSuchFieldError -> 0x001d }
                io.netty.handler.codec.socks.SocksAddressType r1 = io.netty.handler.codec.socks.SocksAddressType.DOMAIN     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$io$netty$handler$codec$socks$SocksAddressType     // Catch:{ NoSuchFieldError -> 0x0028 }
                io.netty.handler.codec.socks.SocksAddressType r1 = io.netty.handler.codec.socks.SocksAddressType.IPv6     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$io$netty$handler$codec$socks$SocksAddressType     // Catch:{ NoSuchFieldError -> 0x0033 }
                io.netty.handler.codec.socks.SocksAddressType r1 = io.netty.handler.codec.socks.SocksAddressType.UNKNOWN     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.socks.SocksCmdRequest.AnonymousClass1.<clinit>():void");
        }
    }

    public SocksCmdRequest(SocksCmdType socksCmdType, SocksAddressType socksAddressType, String str, int i) {
        super(SocksRequestType.CMD);
        ObjectUtil.checkNotNull(socksCmdType, "cmdType");
        ObjectUtil.checkNotNull(socksAddressType, "addressType");
        ObjectUtil.checkNotNull(str, ApiConstant.VALUE_HOST);
        int i2 = AnonymousClass1.$SwitchMap$io$netty$handler$codec$socks$SocksAddressType[socksAddressType.ordinal()];
        if (i2 != 1) {
            if (i2 == 2) {
                String ascii = IDN.toASCII(str);
                if (ascii.length() <= 255) {
                    str = ascii;
                } else {
                    throw new IllegalArgumentException(str + " IDN: " + ascii + " exceeds 255 char limit");
                }
            } else if (i2 == 3 && !NetUtil.isValidIpV6Address(str)) {
                throw new IllegalArgumentException(str + " is not a valid IPv6 address");
            }
        } else if (!NetUtil.isValidIpV4Address(str)) {
            throw new IllegalArgumentException(str + " is not a valid IPv4 address");
        }
        if (i <= 0 || i >= 65536) {
            throw new IllegalArgumentException(i + " is not in bounds 0 < x < 65536");
        }
        this.cmdType = socksCmdType;
        this.addressType = socksAddressType;
        this.host = str;
        this.port = i;
    }

    public SocksAddressType addressType() {
        return this.addressType;
    }

    public SocksCmdType cmdType() {
        return this.cmdType;
    }

    public void encodeAsByteBuf(ByteBuf byteBuf) {
        byteBuf.writeByte(protocolVersion().byteValue());
        byteBuf.writeByte(this.cmdType.byteValue());
        byteBuf.writeByte(0);
        byteBuf.writeByte(this.addressType.byteValue());
        int i = AnonymousClass1.$SwitchMap$io$netty$handler$codec$socks$SocksAddressType[this.addressType.ordinal()];
        if (i == 1) {
            byteBuf.writeBytes(NetUtil.createByteArrayFromIpAddressString(this.host));
            byteBuf.writeShort(this.port);
        } else if (i == 2) {
            byteBuf.writeByte(this.host.length());
            byteBuf.writeCharSequence(this.host, CharsetUtil.US_ASCII);
            byteBuf.writeShort(this.port);
        } else if (i == 3) {
            byteBuf.writeBytes(NetUtil.createByteArrayFromIpAddressString(this.host));
            byteBuf.writeShort(this.port);
        }
    }

    public String host() {
        SocksAddressType socksAddressType = this.addressType;
        SocksAddressType socksAddressType2 = SocksAddressType.DOMAIN;
        String str = this.host;
        return socksAddressType == socksAddressType2 ? IDN.toUnicode(str) : str;
    }

    public int port() {
        return this.port;
    }
}
