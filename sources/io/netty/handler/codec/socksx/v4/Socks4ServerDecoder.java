package io.netty.handler.codec.socksx.v4;

import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.DecoderException;
import io.netty.handler.codec.DecoderResult;
import io.netty.handler.codec.ReplayingDecoder;
import io.netty.util.CharsetUtil;
import java.util.List;

public class Socks4ServerDecoder extends ReplayingDecoder<State> {
    private static final int MAX_FIELD_LENGTH = 255;
    private String dstAddr;
    private int dstPort;
    private Socks4CommandType type;
    private String userId;

    /* renamed from: io.netty.handler.codec.socksx.v4.Socks4ServerDecoder$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$socksx$v4$Socks4ServerDecoder$State;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                io.netty.handler.codec.socksx.v4.Socks4ServerDecoder$State[] r0 = io.netty.handler.codec.socksx.v4.Socks4ServerDecoder.State.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$io$netty$handler$codec$socksx$v4$Socks4ServerDecoder$State = r0
                io.netty.handler.codec.socksx.v4.Socks4ServerDecoder$State r1 = io.netty.handler.codec.socksx.v4.Socks4ServerDecoder.State.START     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$io$netty$handler$codec$socksx$v4$Socks4ServerDecoder$State     // Catch:{ NoSuchFieldError -> 0x001d }
                io.netty.handler.codec.socksx.v4.Socks4ServerDecoder$State r1 = io.netty.handler.codec.socksx.v4.Socks4ServerDecoder.State.READ_USERID     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$io$netty$handler$codec$socksx$v4$Socks4ServerDecoder$State     // Catch:{ NoSuchFieldError -> 0x0028 }
                io.netty.handler.codec.socksx.v4.Socks4ServerDecoder$State r1 = io.netty.handler.codec.socksx.v4.Socks4ServerDecoder.State.READ_DOMAIN     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$io$netty$handler$codec$socksx$v4$Socks4ServerDecoder$State     // Catch:{ NoSuchFieldError -> 0x0033 }
                io.netty.handler.codec.socksx.v4.Socks4ServerDecoder$State r1 = io.netty.handler.codec.socksx.v4.Socks4ServerDecoder.State.SUCCESS     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$io$netty$handler$codec$socksx$v4$Socks4ServerDecoder$State     // Catch:{ NoSuchFieldError -> 0x003e }
                io.netty.handler.codec.socksx.v4.Socks4ServerDecoder$State r1 = io.netty.handler.codec.socksx.v4.Socks4ServerDecoder.State.FAILURE     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.socksx.v4.Socks4ServerDecoder.AnonymousClass1.<clinit>():void");
        }
    }

    public enum State {
        START,
        READ_USERID,
        READ_DOMAIN,
        SUCCESS,
        FAILURE
    }

    public Socks4ServerDecoder() {
        super(State.START);
        setSingleDecode(true);
    }

    private void fail(List<Object> list, Exception exc) {
        if (!(exc instanceof DecoderException)) {
            exc = new DecoderException((Throwable) exc);
        }
        Socks4CommandType socks4CommandType = this.type;
        if (socks4CommandType == null) {
            socks4CommandType = Socks4CommandType.CONNECT;
        }
        String str = this.dstAddr;
        String str2 = "";
        if (str == null) {
            str = str2;
        }
        int i = this.dstPort;
        if (i == 0) {
            i = 65535;
        }
        String str3 = this.userId;
        if (str3 != null) {
            str2 = str3;
        }
        DefaultSocks4CommandRequest defaultSocks4CommandRequest = new DefaultSocks4CommandRequest(socks4CommandType, str, i, str2);
        defaultSocks4CommandRequest.setDecoderResult(DecoderResult.failure(exc));
        list.add(defaultSocks4CommandRequest);
        checkpoint(State.FAILURE);
    }

    private static String readString(String str, ByteBuf byteBuf) {
        int bytesBefore = byteBuf.bytesBefore(256, (byte) 0);
        if (bytesBefore >= 0) {
            String byteBuf2 = byteBuf.readSlice(bytesBefore).toString(CharsetUtil.US_ASCII);
            byteBuf.skipBytes(1);
            return byteBuf2;
        }
        throw new DecoderException("field '" + str + "' longer than " + 255 + " chars");
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x009a A[Catch:{ Exception -> 0x0028 }] */
    /* JADX WARNING: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void decode(io.netty.channel.ChannelHandlerContext r5, io.netty.buffer.ByteBuf r6, java.util.List<java.lang.Object> r7) throws java.lang.Exception {
        /*
            r4 = this;
            int[] r5 = io.netty.handler.codec.socksx.v4.Socks4ServerDecoder.AnonymousClass1.$SwitchMap$io$netty$handler$codec$socksx$v4$Socks4ServerDecoder$State     // Catch:{ Exception -> 0x0028 }
            java.lang.Object r0 = r4.state()     // Catch:{ Exception -> 0x0028 }
            io.netty.handler.codec.socksx.v4.Socks4ServerDecoder$State r0 = (io.netty.handler.codec.socksx.v4.Socks4ServerDecoder.State) r0     // Catch:{ Exception -> 0x0028 }
            int r0 = r0.ordinal()     // Catch:{ Exception -> 0x0028 }
            r5 = r5[r0]     // Catch:{ Exception -> 0x0028 }
            r0 = 1
            if (r5 == r0) goto L_0x002b
            r0 = 2
            if (r5 == r0) goto L_0x0056
            r0 = 3
            if (r5 == r0) goto L_0x0063
            r0 = 4
            if (r5 == r0) goto L_0x0094
            r0 = 5
            if (r5 == r0) goto L_0x001f
            goto L_0x00bc
        L_0x001f:
            int r5 = r4.actualReadableBytes()     // Catch:{ Exception -> 0x0028 }
            r6.skipBytes(r5)     // Catch:{ Exception -> 0x0028 }
            goto L_0x00bc
        L_0x0028:
            r5 = move-exception
            goto L_0x00b9
        L_0x002b:
            short r5 = r6.readUnsignedByte()     // Catch:{ Exception -> 0x0028 }
            io.netty.handler.codec.socksx.SocksVersion r0 = io.netty.handler.codec.socksx.SocksVersion.SOCKS4a     // Catch:{ Exception -> 0x0028 }
            byte r0 = r0.byteValue()     // Catch:{ Exception -> 0x0028 }
            if (r5 != r0) goto L_0x00a2
            byte r5 = r6.readByte()     // Catch:{ Exception -> 0x0028 }
            io.netty.handler.codec.socksx.v4.Socks4CommandType r5 = io.netty.handler.codec.socksx.v4.Socks4CommandType.valueOf(r5)     // Catch:{ Exception -> 0x0028 }
            r4.type = r5     // Catch:{ Exception -> 0x0028 }
            int r5 = r6.readUnsignedShort()     // Catch:{ Exception -> 0x0028 }
            r4.dstPort = r5     // Catch:{ Exception -> 0x0028 }
            int r5 = r6.readInt()     // Catch:{ Exception -> 0x0028 }
            java.lang.String r5 = io.netty.util.NetUtil.intToIpAddress(r5)     // Catch:{ Exception -> 0x0028 }
            r4.dstAddr = r5     // Catch:{ Exception -> 0x0028 }
            io.netty.handler.codec.socksx.v4.Socks4ServerDecoder$State r5 = io.netty.handler.codec.socksx.v4.Socks4ServerDecoder.State.READ_USERID     // Catch:{ Exception -> 0x0028 }
            r4.checkpoint(r5)     // Catch:{ Exception -> 0x0028 }
        L_0x0056:
            java.lang.String r5 = "userid"
            java.lang.String r5 = readString(r5, r6)     // Catch:{ Exception -> 0x0028 }
            r4.userId = r5     // Catch:{ Exception -> 0x0028 }
            io.netty.handler.codec.socksx.v4.Socks4ServerDecoder$State r5 = io.netty.handler.codec.socksx.v4.Socks4ServerDecoder.State.READ_DOMAIN     // Catch:{ Exception -> 0x0028 }
            r4.checkpoint(r5)     // Catch:{ Exception -> 0x0028 }
        L_0x0063:
            java.lang.String r5 = "0.0.0.0"
            java.lang.String r0 = r4.dstAddr     // Catch:{ Exception -> 0x0028 }
            boolean r5 = r5.equals(r0)     // Catch:{ Exception -> 0x0028 }
            if (r5 != 0) goto L_0x007f
            java.lang.String r5 = r4.dstAddr     // Catch:{ Exception -> 0x0028 }
            java.lang.String r0 = "0.0.0."
            boolean r5 = r5.startsWith(r0)     // Catch:{ Exception -> 0x0028 }
            if (r5 == 0) goto L_0x007f
            java.lang.String r5 = "dstAddr"
            java.lang.String r5 = readString(r5, r6)     // Catch:{ Exception -> 0x0028 }
            r4.dstAddr = r5     // Catch:{ Exception -> 0x0028 }
        L_0x007f:
            io.netty.handler.codec.socksx.v4.DefaultSocks4CommandRequest r5 = new io.netty.handler.codec.socksx.v4.DefaultSocks4CommandRequest     // Catch:{ Exception -> 0x0028 }
            io.netty.handler.codec.socksx.v4.Socks4CommandType r0 = r4.type     // Catch:{ Exception -> 0x0028 }
            java.lang.String r1 = r4.dstAddr     // Catch:{ Exception -> 0x0028 }
            int r2 = r4.dstPort     // Catch:{ Exception -> 0x0028 }
            java.lang.String r3 = r4.userId     // Catch:{ Exception -> 0x0028 }
            r5.<init>(r0, r1, r2, r3)     // Catch:{ Exception -> 0x0028 }
            r7.add(r5)     // Catch:{ Exception -> 0x0028 }
            io.netty.handler.codec.socksx.v4.Socks4ServerDecoder$State r5 = io.netty.handler.codec.socksx.v4.Socks4ServerDecoder.State.SUCCESS     // Catch:{ Exception -> 0x0028 }
            r4.checkpoint(r5)     // Catch:{ Exception -> 0x0028 }
        L_0x0094:
            int r5 = r4.actualReadableBytes()     // Catch:{ Exception -> 0x0028 }
            if (r5 <= 0) goto L_0x00bc
            io.netty.buffer.ByteBuf r5 = r6.readRetainedSlice(r5)     // Catch:{ Exception -> 0x0028 }
            r7.add(r5)     // Catch:{ Exception -> 0x0028 }
            goto L_0x00bc
        L_0x00a2:
            io.netty.handler.codec.DecoderException r6 = new io.netty.handler.codec.DecoderException     // Catch:{ Exception -> 0x0028 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0028 }
            r0.<init>()     // Catch:{ Exception -> 0x0028 }
            java.lang.String r1 = "unsupported protocol version: "
            r0.append(r1)     // Catch:{ Exception -> 0x0028 }
            r0.append(r5)     // Catch:{ Exception -> 0x0028 }
            java.lang.String r5 = r0.toString()     // Catch:{ Exception -> 0x0028 }
            r6.<init>((java.lang.String) r5)     // Catch:{ Exception -> 0x0028 }
            throw r6     // Catch:{ Exception -> 0x0028 }
        L_0x00b9:
            r4.fail(r7, r5)
        L_0x00bc:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.socksx.v4.Socks4ServerDecoder.decode(io.netty.channel.ChannelHandlerContext, io.netty.buffer.ByteBuf, java.util.List):void");
    }
}
