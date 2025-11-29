package io.netty.handler.codec.compression;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.PromiseNotifier;
import io.netty.util.internal.EmptyArrays;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.SuppressJava6Requirement;
import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.util.concurrent.TimeUnit;
import java.util.zip.CRC32;
import java.util.zip.Deflater;

public class JdkZlibEncoder extends ZlibEncoder {
    private static final int MAX_INITIAL_OUTPUT_BUFFER_SIZE;
    private static final int MAX_INPUT_BUFFER_SIZE;
    private static final int THREAD_POOL_DELAY_SECONDS = 10;
    private static final byte[] gzipHeader = {31, -117, 8, 0, 0, 0, 0, 0, 0, 0};
    private static final InternalLogger logger;
    private final CRC32 crc;
    private volatile ChannelHandlerContext ctx;
    private final Deflater deflater;
    private volatile boolean finished;
    private final ZlibWrapper wrapper;
    private boolean writeHeader;

    /* renamed from: io.netty.handler.codec.compression.JdkZlibEncoder$4  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$compression$ZlibWrapper;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                io.netty.handler.codec.compression.ZlibWrapper[] r0 = io.netty.handler.codec.compression.ZlibWrapper.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$io$netty$handler$codec$compression$ZlibWrapper = r0
                io.netty.handler.codec.compression.ZlibWrapper r1 = io.netty.handler.codec.compression.ZlibWrapper.GZIP     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$io$netty$handler$codec$compression$ZlibWrapper     // Catch:{ NoSuchFieldError -> 0x001d }
                io.netty.handler.codec.compression.ZlibWrapper r1 = io.netty.handler.codec.compression.ZlibWrapper.ZLIB     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.compression.JdkZlibEncoder.AnonymousClass4.<clinit>():void");
        }
    }

    static {
        InternalLogger instance = InternalLoggerFactory.getInstance((Class<?>) JdkZlibEncoder.class);
        logger = instance;
        int i = SystemPropertyUtil.getInt("io.netty.jdkzlib.encoder.maxInitialOutputBufferSize", 65536);
        MAX_INITIAL_OUTPUT_BUFFER_SIZE = i;
        int i2 = SystemPropertyUtil.getInt("io.netty.jdkzlib.encoder.maxInputBufferSize", 65536);
        MAX_INPUT_BUFFER_SIZE = i2;
        if (instance.isDebugEnabled()) {
            instance.debug("-Dio.netty.jdkzlib.encoder.maxInitialOutputBufferSize={}", (Object) Integer.valueOf(i));
            instance.debug("-Dio.netty.jdkzlib.encoder.maxInputBufferSize={}", (Object) Integer.valueOf(i2));
        }
    }

    public JdkZlibEncoder() {
        this(6);
    }

    /* access modifiers changed from: private */
    public ChannelHandlerContext ctx() {
        ChannelHandlerContext channelHandlerContext = this.ctx;
        if (channelHandlerContext != null) {
            return channelHandlerContext;
        }
        throw new IllegalStateException("not added to a pipeline");
    }

    @SuppressJava6Requirement(reason = "Usage guarded by java version check")
    private void deflate(ByteBuf byteBuf) {
        int deflate;
        if (PlatformDependent.javaVersion() < 7) {
            deflateJdk6(byteBuf);
        }
        do {
            int writerIndex = byteBuf.writerIndex();
            deflate = this.deflater.deflate(byteBuf.array(), byteBuf.arrayOffset() + writerIndex, byteBuf.writableBytes(), 2);
            byteBuf.writerIndex(writerIndex + deflate);
        } while (deflate > 0);
    }

    private void deflateJdk6(ByteBuf byteBuf) {
        int deflate;
        do {
            int writerIndex = byteBuf.writerIndex();
            deflate = this.deflater.deflate(byteBuf.array(), byteBuf.arrayOffset() + writerIndex, byteBuf.writableBytes());
            byteBuf.writerIndex(writerIndex + deflate);
        } while (deflate > 0);
    }

    private void encodeSome(ByteBuf byteBuf, ByteBuf byteBuf2) {
        byte[] array = byteBuf.array();
        int arrayOffset = byteBuf.arrayOffset() + byteBuf.readerIndex();
        if (this.writeHeader) {
            this.writeHeader = false;
            if (this.wrapper == ZlibWrapper.GZIP) {
                byteBuf2.writeBytes(gzipHeader);
            }
        }
        int readableBytes = byteBuf.readableBytes();
        if (this.wrapper == ZlibWrapper.GZIP) {
            this.crc.update(array, arrayOffset, readableBytes);
        }
        this.deflater.setInput(array, arrayOffset, readableBytes);
        while (true) {
            deflate(byteBuf2);
            if (!byteBuf2.isWritable()) {
                byteBuf2.ensureWritable(byteBuf2.writerIndex());
            } else if (this.deflater.needsInput()) {
                byteBuf.skipBytes(readableBytes);
                return;
            }
        }
    }

    /* access modifiers changed from: private */
    public ChannelFuture finishEncode(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise) {
        if (this.finished) {
            channelPromise.setSuccess();
            return channelPromise;
        }
        this.finished = true;
        ByteBuf heapBuffer = channelHandlerContext.alloc().heapBuffer();
        if (this.writeHeader && this.wrapper == ZlibWrapper.GZIP) {
            this.writeHeader = false;
            heapBuffer.writeBytes(gzipHeader);
        }
        this.deflater.finish();
        while (!this.deflater.finished()) {
            deflate(heapBuffer);
            if (!heapBuffer.isWritable()) {
                channelHandlerContext.write(heapBuffer);
                heapBuffer = channelHandlerContext.alloc().heapBuffer();
            }
        }
        if (this.wrapper == ZlibWrapper.GZIP) {
            int value = (int) this.crc.getValue();
            int totalIn = this.deflater.getTotalIn();
            heapBuffer.writeByte(value);
            heapBuffer.writeByte(value >>> 8);
            heapBuffer.writeByte(value >>> 16);
            heapBuffer.writeByte(value >>> 24);
            heapBuffer.writeByte(totalIn);
            heapBuffer.writeByte(totalIn >>> 8);
            heapBuffer.writeByte(totalIn >>> 16);
            heapBuffer.writeByte(totalIn >>> 24);
        }
        this.deflater.end();
        return channelHandlerContext.writeAndFlush(heapBuffer, channelPromise);
    }

    public ChannelFuture close() {
        return close(ctx().newPromise());
    }

    public void handlerAdded(ChannelHandlerContext channelHandlerContext) throws Exception {
        this.ctx = channelHandlerContext;
    }

    public boolean isClosed() {
        return this.finished;
    }

    public JdkZlibEncoder(int i) {
        this(ZlibWrapper.ZLIB, i);
    }

    public final ByteBuf allocateBuffer(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, boolean z) throws Exception {
        int ceil = (int) Math.ceil(((double) byteBuf.readableBytes()) * 1.001d);
        int i = ceil + 12;
        if (this.writeHeader) {
            int i2 = AnonymousClass4.$SwitchMap$io$netty$handler$codec$compression$ZlibWrapper[this.wrapper.ordinal()];
            if (i2 == 1) {
                i += gzipHeader.length;
            } else if (i2 == 2) {
                i = ceil + 14;
            }
        }
        if (i < 0 || i > MAX_INITIAL_OUTPUT_BUFFER_SIZE) {
            return channelHandlerContext.alloc().heapBuffer(MAX_INITIAL_OUTPUT_BUFFER_SIZE);
        }
        return channelHandlerContext.alloc().heapBuffer(i);
    }

    public ChannelFuture close(final ChannelPromise channelPromise) {
        ChannelHandlerContext ctx2 = ctx();
        EventExecutor executor = ctx2.executor();
        if (executor.inEventLoop()) {
            return finishEncode(ctx2, channelPromise);
        }
        final ChannelPromise newPromise = ctx2.newPromise();
        executor.execute(new Runnable() {
            public void run() {
                JdkZlibEncoder jdkZlibEncoder = JdkZlibEncoder.this;
                PromiseNotifier.cascade(jdkZlibEncoder.finishEncode(jdkZlibEncoder.ctx(), newPromise), channelPromise);
            }
        });
        return newPromise;
    }

    public void encode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, ByteBuf byteBuf2) throws Exception {
        if (this.finished) {
            byteBuf2.writeBytes(byteBuf);
            return;
        }
        int readableBytes = byteBuf.readableBytes();
        if (readableBytes != 0) {
            if (byteBuf.hasArray()) {
                encodeSome(byteBuf, byteBuf2);
            } else {
                int min = Math.min(readableBytes, MAX_INPUT_BUFFER_SIZE);
                ByteBuf heapBuffer = channelHandlerContext.alloc().heapBuffer(min, min);
                while (byteBuf.isReadable()) {
                    try {
                        byteBuf.readBytes(heapBuffer, Math.min(heapBuffer.writableBytes(), byteBuf.readableBytes()));
                        encodeSome(heapBuffer, byteBuf2);
                        heapBuffer.clear();
                    } finally {
                        heapBuffer.release();
                    }
                }
            }
            this.deflater.setInput(EmptyArrays.EMPTY_BYTES);
        }
    }

    public JdkZlibEncoder(ZlibWrapper zlibWrapper) {
        this(zlibWrapper, 6);
    }

    public JdkZlibEncoder(ZlibWrapper zlibWrapper, int i) {
        this.crc = new CRC32();
        boolean z = true;
        this.writeHeader = true;
        ObjectUtil.checkInRange(i, 0, 9, "compressionLevel");
        ObjectUtil.checkNotNull(zlibWrapper, "wrapper");
        ZlibWrapper zlibWrapper2 = ZlibWrapper.ZLIB_OR_NONE;
        if (zlibWrapper != zlibWrapper2) {
            this.wrapper = zlibWrapper;
            this.deflater = new Deflater(i, zlibWrapper == ZlibWrapper.ZLIB ? false : z);
            return;
        }
        throw new IllegalArgumentException("wrapper '" + zlibWrapper2 + "' is not allowed for compression.");
    }

    public void close(final ChannelHandlerContext channelHandlerContext, final ChannelPromise channelPromise) throws Exception {
        ChannelFuture finishEncode = finishEncode(channelHandlerContext, channelHandlerContext.newPromise());
        finishEncode.addListener(new ChannelFutureListener() {
            public void operationComplete(ChannelFuture channelFuture) throws Exception {
                channelHandlerContext.close(channelPromise);
            }
        });
        if (!finishEncode.isDone()) {
            channelHandlerContext.executor().schedule((Runnable) new Runnable() {
                public void run() {
                    channelHandlerContext.close(channelPromise);
                }
            }, 10, TimeUnit.SECONDS);
        }
    }

    public JdkZlibEncoder(byte[] bArr) {
        this(6, bArr);
    }

    public JdkZlibEncoder(int i, byte[] bArr) {
        this.crc = new CRC32();
        this.writeHeader = true;
        ObjectUtil.checkInRange(i, 0, 9, "compressionLevel");
        ObjectUtil.checkNotNull(bArr, "dictionary");
        this.wrapper = ZlibWrapper.ZLIB;
        Deflater deflater2 = new Deflater(i);
        this.deflater = deflater2;
        deflater2.setDictionary(bArr);
    }
}
