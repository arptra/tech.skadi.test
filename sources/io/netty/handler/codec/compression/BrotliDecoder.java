package io.netty.handler.codec.compression;

import com.aayushatharva.brotli4j.decoder.DecoderJNI;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.util.internal.ObjectUtil;
import java.nio.ByteBuffer;
import java.util.List;

public final class BrotliDecoder extends ByteToMessageDecoder {
    private DecoderJNI.Wrapper decoder;
    private boolean destroyed;
    private final int inputBufferSize;

    /* renamed from: io.netty.handler.codec.compression.BrotliDecoder$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$aayushatharva$brotli4j$decoder$DecoderJNI$Status;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.aayushatharva.brotli4j.decoder.DecoderJNI$Status[] r0 = com.aayushatharva.brotli4j.decoder.DecoderJNI.Status.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$aayushatharva$brotli4j$decoder$DecoderJNI$Status = r0
                com.aayushatharva.brotli4j.decoder.DecoderJNI$Status r1 = com.aayushatharva.brotli4j.decoder.DecoderJNI.Status.DONE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$aayushatharva$brotli4j$decoder$DecoderJNI$Status     // Catch:{ NoSuchFieldError -> 0x001d }
                com.aayushatharva.brotli4j.decoder.DecoderJNI$Status r1 = com.aayushatharva.brotli4j.decoder.DecoderJNI.Status.OK     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$aayushatharva$brotli4j$decoder$DecoderJNI$Status     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.aayushatharva.brotli4j.decoder.DecoderJNI$Status r1 = com.aayushatharva.brotli4j.decoder.DecoderJNI.Status.NEEDS_MORE_INPUT     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$aayushatharva$brotli4j$decoder$DecoderJNI$Status     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.aayushatharva.brotli4j.decoder.DecoderJNI$Status r1 = com.aayushatharva.brotli4j.decoder.DecoderJNI.Status.NEEDS_MORE_OUTPUT     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.compression.BrotliDecoder.AnonymousClass1.<clinit>():void");
        }
    }

    public enum State {
        DONE,
        NEEDS_MORE_INPUT,
        ERROR
    }

    static {
        try {
            Brotli.ensureAvailability();
        } catch (Throwable th) {
            throw new ExceptionInInitializerError(th);
        }
    }

    public BrotliDecoder() {
        this(8192);
    }

    private State decompress(ByteBuf byteBuf, List<Object> list, ByteBufAllocator byteBufAllocator) {
        while (true) {
            int i = AnonymousClass1.$SwitchMap$com$aayushatharva$brotli4j$decoder$DecoderJNI$Status[this.decoder.getStatus().ordinal()];
            if (i == 1) {
                return State.DONE;
            }
            if (i == 2) {
                this.decoder.push(0);
            } else if (i == 3) {
                if (this.decoder.hasOutput()) {
                    list.add(pull(byteBufAllocator));
                }
                if (!byteBuf.isReadable()) {
                    return State.NEEDS_MORE_INPUT;
                }
                ByteBuffer inputBuffer = this.decoder.getInputBuffer();
                inputBuffer.clear();
                this.decoder.push(readBytes(byteBuf, inputBuffer));
            } else if (i != 4) {
                return State.ERROR;
            } else {
                list.add(pull(byteBufAllocator));
            }
        }
    }

    private void destroy() {
        if (!this.destroyed) {
            this.destroyed = true;
            this.decoder.destroy();
        }
    }

    private ByteBuf pull(ByteBufAllocator byteBufAllocator) {
        ByteBuffer pull = this.decoder.pull();
        ByteBuf buffer = byteBufAllocator.buffer(pull.remaining());
        buffer.writeBytes(pull);
        return buffer;
    }

    private static int readBytes(ByteBuf byteBuf, ByteBuffer byteBuffer) {
        int min = Math.min(byteBuf.readableBytes(), byteBuffer.remaining());
        ByteBuffer slice = byteBuffer.slice();
        slice.limit(min);
        byteBuf.readBytes(slice);
        byteBuffer.position(byteBuffer.position() + min);
        return min;
    }

    public void channelInactive(ChannelHandlerContext channelHandlerContext) throws Exception {
        try {
            destroy();
        } finally {
            super.channelInactive(channelHandlerContext);
        }
    }

    public void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        if (this.destroyed) {
            byteBuf.skipBytes(byteBuf.readableBytes());
        } else if (byteBuf.isReadable()) {
            try {
                State decompress = decompress(byteBuf, list, channelHandlerContext.alloc());
                if (decompress == State.DONE) {
                    destroy();
                } else if (decompress == State.ERROR) {
                    throw new DecompressionException("Brotli stream corrupted");
                }
            } catch (Exception e) {
                destroy();
                throw e;
            }
        }
    }

    public void handlerAdded(ChannelHandlerContext channelHandlerContext) throws Exception {
        this.decoder = new DecoderJNI.Wrapper(this.inputBufferSize);
    }

    public void handlerRemoved0(ChannelHandlerContext channelHandlerContext) throws Exception {
        try {
            destroy();
        } finally {
            super.handlerRemoved0(channelHandlerContext);
        }
    }

    public BrotliDecoder(int i) {
        this.inputBufferSize = ObjectUtil.checkPositive(i, "inputBufferSize");
    }
}
