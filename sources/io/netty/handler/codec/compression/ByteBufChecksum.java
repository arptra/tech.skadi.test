package io.netty.handler.codec.compression;

import io.netty.buffer.ByteBuf;
import io.netty.util.ByteProcessor;
import io.netty.util.internal.PlatformDependent;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.zip.Adler32;
import java.util.zip.CRC32;
import java.util.zip.Checksum;

abstract class ByteBufChecksum implements Checksum {
    private static final Method ADLER32_UPDATE_METHOD = updateByteBuffer(new Adler32());
    private static final Method CRC32_UPDATE_METHOD = updateByteBuffer(new CRC32());
    private final ByteProcessor updateProcessor = new ByteProcessor() {
        public boolean process(byte b) throws Exception {
            ByteBufChecksum.this.update(b);
            return true;
        }
    };

    public static final class ReflectiveByteBufChecksum extends SlowByteBufChecksum {
        private final Method method;

        public ReflectiveByteBufChecksum(Checksum checksum, Method method2) {
            super(checksum);
            this.method = method2;
        }

        public void update(ByteBuf byteBuf, int i, int i2) {
            if (byteBuf.hasArray()) {
                update(byteBuf.array(), byteBuf.arrayOffset() + i, i2);
                return;
            }
            try {
                this.method.invoke(this.checksum, new Object[]{CompressionUtil.safeNioBuffer(byteBuf, i, i2)});
            } catch (Throwable unused) {
                throw new Error();
            }
        }
    }

    public static class SlowByteBufChecksum extends ByteBufChecksum {
        protected final Checksum checksum;

        public SlowByteBufChecksum(Checksum checksum2) {
            this.checksum = checksum2;
        }

        public long getValue() {
            return this.checksum.getValue();
        }

        public void reset() {
            this.checksum.reset();
        }

        public void update(int i) {
            this.checksum.update(i);
        }

        public void update(byte[] bArr, int i, int i2) {
            this.checksum.update(bArr, i, i2);
        }
    }

    private static Method updateByteBuffer(Checksum checksum) {
        if (PlatformDependent.javaVersion() >= 8) {
            try {
                Method declaredMethod = checksum.getClass().getDeclaredMethod("update", new Class[]{ByteBuffer.class});
                declaredMethod.invoke(checksum, new Object[]{ByteBuffer.allocate(1)});
                return declaredMethod;
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001e, code lost:
        r0 = CRC32_UPDATE_METHOD;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static io.netty.handler.codec.compression.ByteBufChecksum wrapChecksum(java.util.zip.Checksum r2) {
        /*
            java.lang.String r0 = "checksum"
            io.netty.util.internal.ObjectUtil.checkNotNull(r2, r0)
            boolean r0 = r2 instanceof io.netty.handler.codec.compression.ByteBufChecksum
            if (r0 == 0) goto L_0x000c
            io.netty.handler.codec.compression.ByteBufChecksum r2 = (io.netty.handler.codec.compression.ByteBufChecksum) r2
            return r2
        L_0x000c:
            boolean r0 = r2 instanceof java.util.zip.Adler32
            if (r0 == 0) goto L_0x001a
            java.lang.reflect.Method r0 = ADLER32_UPDATE_METHOD
            if (r0 == 0) goto L_0x001a
            io.netty.handler.codec.compression.ByteBufChecksum$ReflectiveByteBufChecksum r1 = new io.netty.handler.codec.compression.ByteBufChecksum$ReflectiveByteBufChecksum
            r1.<init>(r2, r0)
            return r1
        L_0x001a:
            boolean r0 = r2 instanceof java.util.zip.CRC32
            if (r0 == 0) goto L_0x0028
            java.lang.reflect.Method r0 = CRC32_UPDATE_METHOD
            if (r0 == 0) goto L_0x0028
            io.netty.handler.codec.compression.ByteBufChecksum$ReflectiveByteBufChecksum r1 = new io.netty.handler.codec.compression.ByteBufChecksum$ReflectiveByteBufChecksum
            r1.<init>(r2, r0)
            return r1
        L_0x0028:
            io.netty.handler.codec.compression.ByteBufChecksum$SlowByteBufChecksum r0 = new io.netty.handler.codec.compression.ByteBufChecksum$SlowByteBufChecksum
            r0.<init>(r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.compression.ByteBufChecksum.wrapChecksum(java.util.zip.Checksum):io.netty.handler.codec.compression.ByteBufChecksum");
    }

    public void update(ByteBuf byteBuf, int i, int i2) {
        if (byteBuf.hasArray()) {
            update(byteBuf.array(), byteBuf.arrayOffset() + i, i2);
        } else {
            byteBuf.forEachByte(i, i2, this.updateProcessor);
        }
    }
}
