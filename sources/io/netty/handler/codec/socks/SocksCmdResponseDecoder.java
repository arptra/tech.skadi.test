package io.netty.handler.codec.socks;

import io.netty.handler.codec.ReplayingDecoder;

public class SocksCmdResponseDecoder extends ReplayingDecoder<State> {
    private SocksAddressType addressType;
    private SocksCmdStatus cmdStatus;

    /* renamed from: io.netty.handler.codec.socks.SocksCmdResponseDecoder$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$socks$SocksAddressType;
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$socks$SocksCmdResponseDecoder$State;

        /* JADX WARNING: Can't wrap try/catch for region: R(17:0|(2:1|2)|3|(2:5|6)|7|9|10|11|13|14|15|16|17|18|19|20|22) */
        /* JADX WARNING: Can't wrap try/catch for region: R(19:0|1|2|3|5|6|7|9|10|11|13|14|15|16|17|18|19|20|22) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0039 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0043 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x004d */
        static {
            /*
                io.netty.handler.codec.socks.SocksCmdResponseDecoder$State[] r0 = io.netty.handler.codec.socks.SocksCmdResponseDecoder.State.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$io$netty$handler$codec$socks$SocksCmdResponseDecoder$State = r0
                r1 = 1
                io.netty.handler.codec.socks.SocksCmdResponseDecoder$State r2 = io.netty.handler.codec.socks.SocksCmdResponseDecoder.State.CHECK_PROTOCOL_VERSION     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = $SwitchMap$io$netty$handler$codec$socks$SocksCmdResponseDecoder$State     // Catch:{ NoSuchFieldError -> 0x001d }
                io.netty.handler.codec.socks.SocksCmdResponseDecoder$State r3 = io.netty.handler.codec.socks.SocksCmdResponseDecoder.State.READ_CMD_HEADER     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = $SwitchMap$io$netty$handler$codec$socks$SocksCmdResponseDecoder$State     // Catch:{ NoSuchFieldError -> 0x0028 }
                io.netty.handler.codec.socks.SocksCmdResponseDecoder$State r4 = io.netty.handler.codec.socks.SocksCmdResponseDecoder.State.READ_CMD_ADDRESS     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                io.netty.handler.codec.socks.SocksAddressType[] r3 = io.netty.handler.codec.socks.SocksAddressType.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                $SwitchMap$io$netty$handler$codec$socks$SocksAddressType = r3
                io.netty.handler.codec.socks.SocksAddressType r4 = io.netty.handler.codec.socks.SocksAddressType.IPv4     // Catch:{ NoSuchFieldError -> 0x0039 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0039 }
                r3[r4] = r1     // Catch:{ NoSuchFieldError -> 0x0039 }
            L_0x0039:
                int[] r1 = $SwitchMap$io$netty$handler$codec$socks$SocksAddressType     // Catch:{ NoSuchFieldError -> 0x0043 }
                io.netty.handler.codec.socks.SocksAddressType r3 = io.netty.handler.codec.socks.SocksAddressType.DOMAIN     // Catch:{ NoSuchFieldError -> 0x0043 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0043 }
                r1[r3] = r0     // Catch:{ NoSuchFieldError -> 0x0043 }
            L_0x0043:
                int[] r0 = $SwitchMap$io$netty$handler$codec$socks$SocksAddressType     // Catch:{ NoSuchFieldError -> 0x004d }
                io.netty.handler.codec.socks.SocksAddressType r1 = io.netty.handler.codec.socks.SocksAddressType.IPv6     // Catch:{ NoSuchFieldError -> 0x004d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x004d }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x004d }
            L_0x004d:
                int[] r0 = $SwitchMap$io$netty$handler$codec$socks$SocksAddressType     // Catch:{ NoSuchFieldError -> 0x0058 }
                io.netty.handler.codec.socks.SocksAddressType r1 = io.netty.handler.codec.socks.SocksAddressType.UNKNOWN     // Catch:{ NoSuchFieldError -> 0x0058 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0058 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0058 }
            L_0x0058:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.socks.SocksCmdResponseDecoder.AnonymousClass1.<clinit>():void");
        }
    }

    public enum State {
        CHECK_PROTOCOL_VERSION,
        READ_CMD_HEADER,
        READ_CMD_ADDRESS
    }

    public SocksCmdResponseDecoder() {
        super(State.CHECK_PROTOCOL_VERSION);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x005e  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00a6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void decode(io.netty.channel.ChannelHandlerContext r6, io.netty.buffer.ByteBuf r7, java.util.List<java.lang.Object> r8) throws java.lang.Exception {
        /*
            r5 = this;
            int[] r0 = io.netty.handler.codec.socks.SocksCmdResponseDecoder.AnonymousClass1.$SwitchMap$io$netty$handler$codec$socks$SocksCmdResponseDecoder$State
            java.lang.Object r1 = r5.state()
            io.netty.handler.codec.socks.SocksCmdResponseDecoder$State r1 = (io.netty.handler.codec.socks.SocksCmdResponseDecoder.State) r1
            int r1 = r1.ordinal()
            r0 = r0[r1]
            r1 = 3
            r2 = 2
            r3 = 1
            if (r0 == r3) goto L_0x001e
            if (r0 == r2) goto L_0x0036
            if (r0 != r1) goto L_0x0018
            goto L_0x0052
        L_0x0018:
            java.lang.Error r5 = new java.lang.Error
            r5.<init>()
            throw r5
        L_0x001e:
            byte r0 = r7.readByte()
            io.netty.handler.codec.socks.SocksProtocolVersion r4 = io.netty.handler.codec.socks.SocksProtocolVersion.SOCKS5
            byte r4 = r4.byteValue()
            if (r0 == r4) goto L_0x0031
            io.netty.handler.codec.socks.SocksResponse r7 = io.netty.handler.codec.socks.SocksCommonUtils.UNKNOWN_SOCKS_RESPONSE
            r8.add(r7)
            goto L_0x00be
        L_0x0031:
            io.netty.handler.codec.socks.SocksCmdResponseDecoder$State r0 = io.netty.handler.codec.socks.SocksCmdResponseDecoder.State.READ_CMD_HEADER
            r5.checkpoint(r0)
        L_0x0036:
            byte r0 = r7.readByte()
            io.netty.handler.codec.socks.SocksCmdStatus r0 = io.netty.handler.codec.socks.SocksCmdStatus.valueOf((byte) r0)
            r5.cmdStatus = r0
            r7.skipBytes(r3)
            byte r0 = r7.readByte()
            io.netty.handler.codec.socks.SocksAddressType r0 = io.netty.handler.codec.socks.SocksAddressType.valueOf((byte) r0)
            r5.addressType = r0
            io.netty.handler.codec.socks.SocksCmdResponseDecoder$State r0 = io.netty.handler.codec.socks.SocksCmdResponseDecoder.State.READ_CMD_ADDRESS
            r5.checkpoint(r0)
        L_0x0052:
            int[] r0 = io.netty.handler.codec.socks.SocksCmdResponseDecoder.AnonymousClass1.$SwitchMap$io$netty$handler$codec$socks$SocksAddressType
            io.netty.handler.codec.socks.SocksAddressType r4 = r5.addressType
            int r4 = r4.ordinal()
            r0 = r0[r4]
            if (r0 == r3) goto L_0x00a6
            if (r0 == r2) goto L_0x008d
            if (r0 == r1) goto L_0x0071
            r7 = 4
            if (r0 != r7) goto L_0x006b
            io.netty.handler.codec.socks.SocksResponse r7 = io.netty.handler.codec.socks.SocksCommonUtils.UNKNOWN_SOCKS_RESPONSE
            r8.add(r7)
            goto L_0x00be
        L_0x006b:
            java.lang.Error r5 = new java.lang.Error
            r5.<init>()
            throw r5
        L_0x0071:
            r0 = 16
            byte[] r0 = new byte[r0]
            r7.readBytes((byte[]) r0)
            java.lang.String r0 = io.netty.handler.codec.socks.SocksCommonUtils.ipv6toStr(r0)
            int r7 = r7.readUnsignedShort()
            io.netty.handler.codec.socks.SocksCmdResponse r1 = new io.netty.handler.codec.socks.SocksCmdResponse
            io.netty.handler.codec.socks.SocksCmdStatus r2 = r5.cmdStatus
            io.netty.handler.codec.socks.SocksAddressType r3 = r5.addressType
            r1.<init>(r2, r3, r0, r7)
            r8.add(r1)
            goto L_0x00be
        L_0x008d:
            byte r0 = r7.readByte()
            java.lang.String r0 = io.netty.handler.codec.socks.SocksCommonUtils.readUsAscii(r7, r0)
            int r7 = r7.readUnsignedShort()
            io.netty.handler.codec.socks.SocksCmdResponse r1 = new io.netty.handler.codec.socks.SocksCmdResponse
            io.netty.handler.codec.socks.SocksCmdStatus r2 = r5.cmdStatus
            io.netty.handler.codec.socks.SocksAddressType r3 = r5.addressType
            r1.<init>(r2, r3, r0, r7)
            r8.add(r1)
            goto L_0x00be
        L_0x00a6:
            int r0 = r7.readInt()
            java.lang.String r0 = io.netty.util.NetUtil.intToIpAddress(r0)
            int r7 = r7.readUnsignedShort()
            io.netty.handler.codec.socks.SocksCmdResponse r1 = new io.netty.handler.codec.socks.SocksCmdResponse
            io.netty.handler.codec.socks.SocksCmdStatus r2 = r5.cmdStatus
            io.netty.handler.codec.socks.SocksAddressType r3 = r5.addressType
            r1.<init>(r2, r3, r0, r7)
            r8.add(r1)
        L_0x00be:
            io.netty.channel.ChannelPipeline r6 = r6.pipeline()
            r6.remove((io.netty.channel.ChannelHandler) r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.socks.SocksCmdResponseDecoder.decode(io.netty.channel.ChannelHandlerContext, io.netty.buffer.ByteBuf, java.util.List):void");
    }
}
