package io.netty.handler.codec.haproxy;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import io.netty.util.CharsetUtil;
import io.netty.util.NetUtil;
import java.nio.charset.Charset;
import java.util.List;

@ChannelHandler.Sharable
public final class HAProxyMessageEncoder extends MessageToByteEncoder<HAProxyMessage> {
    public static final HAProxyMessageEncoder INSTANCE = new HAProxyMessageEncoder();
    static final int TOTAL_UNIX_ADDRESS_BYTES_LENGTH = 216;
    static final int UNIX_ADDRESS_BYTES_LENGTH = 108;
    private static final int V2_VERSION_BITMASK = 32;

    /* renamed from: io.netty.handler.codec.haproxy.HAProxyMessageEncoder$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$haproxy$HAProxyProtocolVersion;
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$haproxy$HAProxyProxiedProtocol$AddressFamily;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|(2:1|2)|3|5|6|7|8|(2:9|10)|11|13|14|15|16|18) */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0044 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0028 */
        static {
            /*
                io.netty.handler.codec.haproxy.HAProxyProxiedProtocol$AddressFamily[] r0 = io.netty.handler.codec.haproxy.HAProxyProxiedProtocol.AddressFamily.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$io$netty$handler$codec$haproxy$HAProxyProxiedProtocol$AddressFamily = r0
                r1 = 1
                io.netty.handler.codec.haproxy.HAProxyProxiedProtocol$AddressFamily r2 = io.netty.handler.codec.haproxy.HAProxyProxiedProtocol.AddressFamily.AF_IPv4     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = $SwitchMap$io$netty$handler$codec$haproxy$HAProxyProxiedProtocol$AddressFamily     // Catch:{ NoSuchFieldError -> 0x001d }
                io.netty.handler.codec.haproxy.HAProxyProxiedProtocol$AddressFamily r3 = io.netty.handler.codec.haproxy.HAProxyProxiedProtocol.AddressFamily.AF_IPv6     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r2 = $SwitchMap$io$netty$handler$codec$haproxy$HAProxyProxiedProtocol$AddressFamily     // Catch:{ NoSuchFieldError -> 0x0028 }
                io.netty.handler.codec.haproxy.HAProxyProxiedProtocol$AddressFamily r3 = io.netty.handler.codec.haproxy.HAProxyProxiedProtocol.AddressFamily.AF_UNIX     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r4 = 3
                r2[r3] = r4     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r2 = $SwitchMap$io$netty$handler$codec$haproxy$HAProxyProxiedProtocol$AddressFamily     // Catch:{ NoSuchFieldError -> 0x0033 }
                io.netty.handler.codec.haproxy.HAProxyProxiedProtocol$AddressFamily r3 = io.netty.handler.codec.haproxy.HAProxyProxiedProtocol.AddressFamily.AF_UNSPEC     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r4 = 4
                r2[r3] = r4     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                io.netty.handler.codec.haproxy.HAProxyProtocolVersion[] r2 = io.netty.handler.codec.haproxy.HAProxyProtocolVersion.values()
                int r2 = r2.length
                int[] r2 = new int[r2]
                $SwitchMap$io$netty$handler$codec$haproxy$HAProxyProtocolVersion = r2
                io.netty.handler.codec.haproxy.HAProxyProtocolVersion r3 = io.netty.handler.codec.haproxy.HAProxyProtocolVersion.V1     // Catch:{ NoSuchFieldError -> 0x0044 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0044 }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x0044 }
            L_0x0044:
                int[] r1 = $SwitchMap$io$netty$handler$codec$haproxy$HAProxyProtocolVersion     // Catch:{ NoSuchFieldError -> 0x004e }
                io.netty.handler.codec.haproxy.HAProxyProtocolVersion r2 = io.netty.handler.codec.haproxy.HAProxyProtocolVersion.V2     // Catch:{ NoSuchFieldError -> 0x004e }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x004e }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x004e }
            L_0x004e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.haproxy.HAProxyMessageEncoder.AnonymousClass1.<clinit>():void");
        }
    }

    private HAProxyMessageEncoder() {
    }

    private static void encodeTlv(HAProxyTLV hAProxyTLV, ByteBuf byteBuf) {
        if (hAProxyTLV instanceof HAProxySSLTLV) {
            HAProxySSLTLV hAProxySSLTLV = (HAProxySSLTLV) hAProxyTLV;
            byteBuf.writeByte(hAProxyTLV.typeByteValue());
            byteBuf.writeShort(hAProxySSLTLV.contentNumBytes());
            byteBuf.writeByte(hAProxySSLTLV.client());
            byteBuf.writeInt(hAProxySSLTLV.verify());
            encodeTlvs(hAProxySSLTLV.encapsulatedTLVs(), byteBuf);
            return;
        }
        byteBuf.writeByte(hAProxyTLV.typeByteValue());
        ByteBuf content = hAProxyTLV.content();
        int readableBytes = content.readableBytes();
        byteBuf.writeShort(readableBytes);
        byteBuf.writeBytes(content.readSlice(readableBytes));
    }

    private static void encodeTlvs(List<HAProxyTLV> list, ByteBuf byteBuf) {
        for (int i = 0; i < list.size(); i++) {
            encodeTlv(list.get(i), byteBuf);
        }
    }

    private static void encodeV1(HAProxyMessage hAProxyMessage, ByteBuf byteBuf) {
        byteBuf.writeBytes(HAProxyConstants.TEXT_PREFIX);
        byteBuf.writeByte(32);
        String name = hAProxyMessage.proxiedProtocol().name();
        Charset charset = CharsetUtil.US_ASCII;
        byteBuf.writeCharSequence(name, charset);
        byteBuf.writeByte(32);
        byteBuf.writeCharSequence(hAProxyMessage.sourceAddress(), charset);
        byteBuf.writeByte(32);
        byteBuf.writeCharSequence(hAProxyMessage.destinationAddress(), charset);
        byteBuf.writeByte(32);
        byteBuf.writeCharSequence(String.valueOf(hAProxyMessage.sourcePort()), charset);
        byteBuf.writeByte(32);
        byteBuf.writeCharSequence(String.valueOf(hAProxyMessage.destinationPort()), charset);
        byteBuf.writeByte(13);
        byteBuf.writeByte(10);
    }

    private static void encodeV2(HAProxyMessage hAProxyMessage, ByteBuf byteBuf) {
        byteBuf.writeBytes(HAProxyConstants.BINARY_PREFIX);
        byteBuf.writeByte(hAProxyMessage.command().byteValue() | 32);
        byteBuf.writeByte(hAProxyMessage.proxiedProtocol().byteValue());
        int i = AnonymousClass1.$SwitchMap$io$netty$handler$codec$haproxy$HAProxyProxiedProtocol$AddressFamily[hAProxyMessage.proxiedProtocol().addressFamily().ordinal()];
        if (i == 1 || i == 2) {
            byte[] createByteArrayFromIpAddressString = NetUtil.createByteArrayFromIpAddressString(hAProxyMessage.sourceAddress());
            byte[] createByteArrayFromIpAddressString2 = NetUtil.createByteArrayFromIpAddressString(hAProxyMessage.destinationAddress());
            byteBuf.writeShort(createByteArrayFromIpAddressString.length + createByteArrayFromIpAddressString2.length + 4 + hAProxyMessage.tlvNumBytes());
            byteBuf.writeBytes(createByteArrayFromIpAddressString);
            byteBuf.writeBytes(createByteArrayFromIpAddressString2);
            byteBuf.writeShort(hAProxyMessage.sourcePort());
            byteBuf.writeShort(hAProxyMessage.destinationPort());
            encodeTlvs(hAProxyMessage.tlvs(), byteBuf);
        } else if (i == 3) {
            byteBuf.writeShort(hAProxyMessage.tlvNumBytes() + TOTAL_UNIX_ADDRESS_BYTES_LENGTH);
            String sourceAddress = hAProxyMessage.sourceAddress();
            Charset charset = CharsetUtil.US_ASCII;
            byteBuf.writeZero(108 - byteBuf.writeCharSequence(sourceAddress, charset));
            byteBuf.writeZero(108 - byteBuf.writeCharSequence(hAProxyMessage.destinationAddress(), charset));
            encodeTlvs(hAProxyMessage.tlvs(), byteBuf);
        } else if (i == 4) {
            byteBuf.writeShort(0);
        } else {
            throw new HAProxyProtocolException("unexpected addrFamily");
        }
    }

    public void encode(ChannelHandlerContext channelHandlerContext, HAProxyMessage hAProxyMessage, ByteBuf byteBuf) throws Exception {
        int i = AnonymousClass1.$SwitchMap$io$netty$handler$codec$haproxy$HAProxyProtocolVersion[hAProxyMessage.protocolVersion().ordinal()];
        if (i == 1) {
            encodeV1(hAProxyMessage, byteBuf);
        } else if (i == 2) {
            encodeV2(hAProxyMessage, byteBuf);
        } else {
            throw new HAProxyProtocolException("Unsupported version: " + hAProxyMessage.protocolVersion());
        }
    }
}
