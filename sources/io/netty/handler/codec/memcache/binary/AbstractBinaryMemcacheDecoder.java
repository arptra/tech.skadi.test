package io.netty.handler.codec.memcache.binary;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.DecoderResult;
import io.netty.handler.codec.memcache.AbstractMemcacheObjectDecoder;
import io.netty.handler.codec.memcache.DefaultLastMemcacheContent;
import io.netty.handler.codec.memcache.MemcacheContent;
import io.netty.handler.codec.memcache.binary.BinaryMemcacheMessage;
import io.netty.util.internal.ObjectUtil;

public abstract class AbstractBinaryMemcacheDecoder<M extends BinaryMemcacheMessage> extends AbstractMemcacheObjectDecoder {
    public static final int DEFAULT_MAX_CHUNK_SIZE = 8192;
    private int alreadyReadChunkSize;
    private final int chunkSize;
    private M currentMessage;
    private State state;

    /* renamed from: io.netty.handler.codec.memcache.binary.AbstractBinaryMemcacheDecoder$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$memcache$binary$AbstractBinaryMemcacheDecoder$State;

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
                io.netty.handler.codec.memcache.binary.AbstractBinaryMemcacheDecoder$State[] r0 = io.netty.handler.codec.memcache.binary.AbstractBinaryMemcacheDecoder.State.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$io$netty$handler$codec$memcache$binary$AbstractBinaryMemcacheDecoder$State = r0
                io.netty.handler.codec.memcache.binary.AbstractBinaryMemcacheDecoder$State r1 = io.netty.handler.codec.memcache.binary.AbstractBinaryMemcacheDecoder.State.READ_HEADER     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$io$netty$handler$codec$memcache$binary$AbstractBinaryMemcacheDecoder$State     // Catch:{ NoSuchFieldError -> 0x001d }
                io.netty.handler.codec.memcache.binary.AbstractBinaryMemcacheDecoder$State r1 = io.netty.handler.codec.memcache.binary.AbstractBinaryMemcacheDecoder.State.READ_EXTRAS     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$io$netty$handler$codec$memcache$binary$AbstractBinaryMemcacheDecoder$State     // Catch:{ NoSuchFieldError -> 0x0028 }
                io.netty.handler.codec.memcache.binary.AbstractBinaryMemcacheDecoder$State r1 = io.netty.handler.codec.memcache.binary.AbstractBinaryMemcacheDecoder.State.READ_KEY     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$io$netty$handler$codec$memcache$binary$AbstractBinaryMemcacheDecoder$State     // Catch:{ NoSuchFieldError -> 0x0033 }
                io.netty.handler.codec.memcache.binary.AbstractBinaryMemcacheDecoder$State r1 = io.netty.handler.codec.memcache.binary.AbstractBinaryMemcacheDecoder.State.READ_CONTENT     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$io$netty$handler$codec$memcache$binary$AbstractBinaryMemcacheDecoder$State     // Catch:{ NoSuchFieldError -> 0x003e }
                io.netty.handler.codec.memcache.binary.AbstractBinaryMemcacheDecoder$State r1 = io.netty.handler.codec.memcache.binary.AbstractBinaryMemcacheDecoder.State.BAD_MESSAGE     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.memcache.binary.AbstractBinaryMemcacheDecoder.AnonymousClass1.<clinit>():void");
        }
    }

    public enum State {
        READ_HEADER,
        READ_EXTRAS,
        READ_KEY,
        READ_CONTENT,
        BAD_MESSAGE
    }

    public AbstractBinaryMemcacheDecoder() {
        this(8192);
    }

    private MemcacheContent invalidChunk(Exception exc) {
        this.state = State.BAD_MESSAGE;
        DefaultLastMemcacheContent defaultLastMemcacheContent = new DefaultLastMemcacheContent(Unpooled.EMPTY_BUFFER);
        defaultLastMemcacheContent.setDecoderResult(DecoderResult.failure(exc));
        return defaultLastMemcacheContent;
    }

    private M invalidMessage(Exception exc) {
        this.state = State.BAD_MESSAGE;
        M buildInvalidMessage = buildInvalidMessage();
        buildInvalidMessage.setDecoderResult(DecoderResult.failure(exc));
        return buildInvalidMessage;
    }

    public abstract M buildInvalidMessage();

    public void channelInactive(ChannelHandlerContext channelHandlerContext) throws Exception {
        super.channelInactive(channelHandlerContext);
        resetDecoder();
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x0078 A[Catch:{ Exception -> 0x0089 }] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00b2 A[Catch:{ Exception -> 0x00d2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00e1 A[Catch:{ Exception -> 0x00d2 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void decode(io.netty.channel.ChannelHandlerContext r3, io.netty.buffer.ByteBuf r4, java.util.List<java.lang.Object> r5) throws java.lang.Exception {
        /*
            r2 = this;
            int[] r3 = io.netty.handler.codec.memcache.binary.AbstractBinaryMemcacheDecoder.AnonymousClass1.$SwitchMap$io$netty$handler$codec$memcache$binary$AbstractBinaryMemcacheDecoder$State
            io.netty.handler.codec.memcache.binary.AbstractBinaryMemcacheDecoder$State r0 = r2.state
            int r0 = r0.ordinal()
            r3 = r3[r0]
            r0 = 1
            if (r3 == r0) goto L_0x003a
            r0 = 2
            if (r3 == r0) goto L_0x0050
            r0 = 3
            if (r3 == r0) goto L_0x0070
            r0 = 4
            if (r3 == r0) goto L_0x0098
            r5 = 5
            if (r3 != r5) goto L_0x0021
            int r2 = r2.actualReadableBytes()
            r4.skipBytes(r2)
            return
        L_0x0021:
            java.lang.Error r3 = new java.lang.Error
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "Unknown state reached: "
            r4.append(r5)
            io.netty.handler.codec.memcache.binary.AbstractBinaryMemcacheDecoder$State r2 = r2.state
            r4.append(r2)
            java.lang.String r2 = r4.toString()
            r3.<init>(r2)
            throw r3
        L_0x003a:
            int r3 = r4.readableBytes()     // Catch:{ Exception -> 0x010f }
            r0 = 24
            if (r3 >= r0) goto L_0x0043
            return
        L_0x0043:
            r2.resetDecoder()     // Catch:{ Exception -> 0x010f }
            io.netty.handler.codec.memcache.binary.BinaryMemcacheMessage r3 = r2.decodeHeader(r4)     // Catch:{ Exception -> 0x010f }
            r2.currentMessage = r3     // Catch:{ Exception -> 0x010f }
            io.netty.handler.codec.memcache.binary.AbstractBinaryMemcacheDecoder$State r3 = io.netty.handler.codec.memcache.binary.AbstractBinaryMemcacheDecoder.State.READ_EXTRAS     // Catch:{ Exception -> 0x010f }
            r2.state = r3     // Catch:{ Exception -> 0x010f }
        L_0x0050:
            M r3 = r2.currentMessage     // Catch:{ Exception -> 0x0069 }
            byte r3 = r3.extrasLength()     // Catch:{ Exception -> 0x0069 }
            if (r3 <= 0) goto L_0x006c
            int r0 = r4.readableBytes()     // Catch:{ Exception -> 0x0069 }
            if (r0 >= r3) goto L_0x005f
            return
        L_0x005f:
            M r0 = r2.currentMessage     // Catch:{ Exception -> 0x0069 }
            io.netty.buffer.ByteBuf r3 = r4.readRetainedSlice(r3)     // Catch:{ Exception -> 0x0069 }
            r0.setExtras(r3)     // Catch:{ Exception -> 0x0069 }
            goto L_0x006c
        L_0x0069:
            r3 = move-exception
            goto L_0x0104
        L_0x006c:
            io.netty.handler.codec.memcache.binary.AbstractBinaryMemcacheDecoder$State r3 = io.netty.handler.codec.memcache.binary.AbstractBinaryMemcacheDecoder.State.READ_KEY     // Catch:{ Exception -> 0x0069 }
            r2.state = r3     // Catch:{ Exception -> 0x0069 }
        L_0x0070:
            M r3 = r2.currentMessage     // Catch:{ Exception -> 0x0089 }
            short r3 = r3.keyLength()     // Catch:{ Exception -> 0x0089 }
            if (r3 <= 0) goto L_0x008b
            int r0 = r4.readableBytes()     // Catch:{ Exception -> 0x0089 }
            if (r0 >= r3) goto L_0x007f
            return
        L_0x007f:
            M r0 = r2.currentMessage     // Catch:{ Exception -> 0x0089 }
            io.netty.buffer.ByteBuf r3 = r4.readRetainedSlice(r3)     // Catch:{ Exception -> 0x0089 }
            r0.setKey(r3)     // Catch:{ Exception -> 0x0089 }
            goto L_0x008b
        L_0x0089:
            r3 = move-exception
            goto L_0x00f9
        L_0x008b:
            M r3 = r2.currentMessage     // Catch:{ Exception -> 0x0089 }
            io.netty.handler.codec.memcache.binary.BinaryMemcacheMessage r3 = r3.retain()     // Catch:{ Exception -> 0x0089 }
            r5.add(r3)     // Catch:{ Exception -> 0x0089 }
            io.netty.handler.codec.memcache.binary.AbstractBinaryMemcacheDecoder$State r3 = io.netty.handler.codec.memcache.binary.AbstractBinaryMemcacheDecoder.State.READ_CONTENT     // Catch:{ Exception -> 0x0089 }
            r2.state = r3     // Catch:{ Exception -> 0x0089 }
        L_0x0098:
            M r3 = r2.currentMessage     // Catch:{ Exception -> 0x00d2 }
            int r3 = r3.totalBodyLength()     // Catch:{ Exception -> 0x00d2 }
            M r0 = r2.currentMessage     // Catch:{ Exception -> 0x00d2 }
            short r0 = r0.keyLength()     // Catch:{ Exception -> 0x00d2 }
            int r3 = r3 - r0
            M r0 = r2.currentMessage     // Catch:{ Exception -> 0x00d2 }
            byte r0 = r0.extrasLength()     // Catch:{ Exception -> 0x00d2 }
            int r3 = r3 - r0
            int r0 = r4.readableBytes()     // Catch:{ Exception -> 0x00d2 }
            if (r3 <= 0) goto L_0x00e1
            if (r0 != 0) goto L_0x00b5
            return
        L_0x00b5:
            int r1 = r2.chunkSize     // Catch:{ Exception -> 0x00d2 }
            if (r0 <= r1) goto L_0x00ba
            r0 = r1
        L_0x00ba:
            int r1 = r2.alreadyReadChunkSize     // Catch:{ Exception -> 0x00d2 }
            int r1 = r3 - r1
            if (r0 <= r1) goto L_0x00c1
            r0 = r1
        L_0x00c1:
            io.netty.buffer.ByteBuf r4 = r4.readRetainedSlice(r0)     // Catch:{ Exception -> 0x00d2 }
            int r1 = r2.alreadyReadChunkSize     // Catch:{ Exception -> 0x00d2 }
            int r1 = r1 + r0
            r2.alreadyReadChunkSize = r1     // Catch:{ Exception -> 0x00d2 }
            if (r1 < r3) goto L_0x00d4
            io.netty.handler.codec.memcache.DefaultLastMemcacheContent r0 = new io.netty.handler.codec.memcache.DefaultLastMemcacheContent     // Catch:{ Exception -> 0x00d2 }
            r0.<init>(r4)     // Catch:{ Exception -> 0x00d2 }
            goto L_0x00d9
        L_0x00d2:
            r3 = move-exception
            goto L_0x00ee
        L_0x00d4:
            io.netty.handler.codec.memcache.DefaultMemcacheContent r0 = new io.netty.handler.codec.memcache.DefaultMemcacheContent     // Catch:{ Exception -> 0x00d2 }
            r0.<init>(r4)     // Catch:{ Exception -> 0x00d2 }
        L_0x00d9:
            r5.add(r0)     // Catch:{ Exception -> 0x00d2 }
            int r4 = r2.alreadyReadChunkSize     // Catch:{ Exception -> 0x00d2 }
            if (r4 >= r3) goto L_0x00e6
            return
        L_0x00e1:
            io.netty.handler.codec.memcache.LastMemcacheContent r3 = io.netty.handler.codec.memcache.LastMemcacheContent.EMPTY_LAST_CONTENT     // Catch:{ Exception -> 0x00d2 }
            r5.add(r3)     // Catch:{ Exception -> 0x00d2 }
        L_0x00e6:
            r2.resetDecoder()     // Catch:{ Exception -> 0x00d2 }
            io.netty.handler.codec.memcache.binary.AbstractBinaryMemcacheDecoder$State r3 = io.netty.handler.codec.memcache.binary.AbstractBinaryMemcacheDecoder.State.READ_HEADER     // Catch:{ Exception -> 0x00d2 }
            r2.state = r3     // Catch:{ Exception -> 0x00d2 }
            return
        L_0x00ee:
            r2.resetDecoder()
            io.netty.handler.codec.memcache.MemcacheContent r2 = r2.invalidChunk(r3)
            r5.add(r2)
            return
        L_0x00f9:
            r2.resetDecoder()
            io.netty.handler.codec.memcache.binary.BinaryMemcacheMessage r2 = r2.invalidMessage(r3)
            r5.add(r2)
            return
        L_0x0104:
            r2.resetDecoder()
            io.netty.handler.codec.memcache.binary.BinaryMemcacheMessage r2 = r2.invalidMessage(r3)
            r5.add(r2)
            return
        L_0x010f:
            r3 = move-exception
            r2.resetDecoder()
            io.netty.handler.codec.memcache.binary.BinaryMemcacheMessage r2 = r2.invalidMessage(r3)
            r5.add(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.memcache.binary.AbstractBinaryMemcacheDecoder.decode(io.netty.channel.ChannelHandlerContext, io.netty.buffer.ByteBuf, java.util.List):void");
    }

    public abstract M decodeHeader(ByteBuf byteBuf);

    public void resetDecoder() {
        M m = this.currentMessage;
        if (m != null) {
            m.release();
            this.currentMessage = null;
        }
        this.alreadyReadChunkSize = 0;
    }

    public AbstractBinaryMemcacheDecoder(int i) {
        this.state = State.READ_HEADER;
        ObjectUtil.checkPositiveOrZero(i, "chunkSize");
        this.chunkSize = i;
    }
}
