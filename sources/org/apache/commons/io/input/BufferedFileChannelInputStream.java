package org.apache.commons.io.input;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Objects;

public final class BufferedFileChannelInputStream extends InputStream {
    private static final Class<?> DIRECT_BUFFER_CLASS = getDirectBufferClass();
    private final ByteBuffer byteBuffer;
    private final FileChannel fileChannel;

    public BufferedFileChannelInputStream(File file) throws IOException {
        this(file, 8192);
    }

    private void clean(ByteBuffer byteBuffer2) {
        if (isDirectBuffer(byteBuffer2)) {
            cleanDirectBuffer(byteBuffer2);
        }
    }

    private void cleanDirectBuffer(ByteBuffer byteBuffer2) {
        if ("1.8".equals(System.getProperty("java.specification.version"))) {
            try {
                Class<?> cls = Class.forName("sun.misc.Cleaner");
                Object invoke = DIRECT_BUFFER_CLASS.getMethod("cleaner", (Class[]) null).invoke(byteBuffer2, (Object[]) null);
                if (invoke != null) {
                    cls.getMethod("clean", (Class[]) null).invoke(invoke, (Object[]) null);
                }
            } catch (ReflectiveOperationException e) {
                throw new IllegalStateException(e);
            }
        } else {
            try {
                Class<?> cls2 = Class.forName("sun.misc.Unsafe");
                Method method = cls2.getMethod("invokeCleaner", new Class[]{ByteBuffer.class});
                Field declaredField = cls2.getDeclaredField("theUnsafe");
                declaredField.setAccessible(true);
                method.invoke(declaredField.get((Object) null), new Object[]{byteBuffer2});
            } catch (ReflectiveOperationException e2) {
                throw new IllegalStateException(e2);
            }
        }
    }

    private static Class<?> getDirectBufferClass() {
        try {
            return Class.forName("sun.nio.ch.DirectBuffer");
        } catch (ClassNotFoundException | IllegalAccessError unused) {
            return null;
        }
    }

    private static boolean isDirectBuffer(Object obj) {
        Class<?> cls = DIRECT_BUFFER_CLASS;
        return cls != null && cls.isInstance(obj);
    }

    private boolean refill() throws IOException {
        if (this.byteBuffer.hasRemaining()) {
            return true;
        }
        this.byteBuffer.clear();
        int i = 0;
        while (i == 0) {
            i = this.fileChannel.read(this.byteBuffer);
        }
        this.byteBuffer.flip();
        return i >= 0;
    }

    private long skipFromFileChannel(long j) throws IOException {
        long position = this.fileChannel.position();
        long size = this.fileChannel.size();
        long j2 = size - position;
        if (j > j2) {
            this.fileChannel.position(size);
            return j2;
        }
        this.fileChannel.position(position + j);
        return j;
    }

    public synchronized int available() throws IOException {
        return this.byteBuffer.remaining();
    }

    public synchronized void close() throws IOException {
        try {
            this.fileChannel.close();
            clean(this.byteBuffer);
        } catch (Throwable th) {
            clean(this.byteBuffer);
            throw th;
        }
    }

    public synchronized int read() throws IOException {
        if (!refill()) {
            return -1;
        }
        return this.byteBuffer.get() & 255;
    }

    public synchronized long skip(long j) throws IOException {
        if (j <= 0) {
            return 0;
        }
        if (((long) this.byteBuffer.remaining()) >= j) {
            ByteBuffer byteBuffer2 = this.byteBuffer;
            byteBuffer2.position(byteBuffer2.position() + ((int) j));
            return j;
        }
        long remaining = (long) this.byteBuffer.remaining();
        this.byteBuffer.position(0);
        this.byteBuffer.flip();
        return remaining + skipFromFileChannel(j - remaining);
    }

    public BufferedFileChannelInputStream(File file, int i) throws IOException {
        this(file.toPath(), i);
    }

    public BufferedFileChannelInputStream(Path path) throws IOException {
        this(path, 8192);
    }

    public BufferedFileChannelInputStream(Path path, int i) throws IOException {
        Objects.requireNonNull(path, "path");
        this.fileChannel = FileChannel.open(path, new OpenOption[]{StandardOpenOption.READ});
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(i);
        this.byteBuffer = allocateDirect;
        allocateDirect.flip();
    }

    public synchronized int read(byte[] bArr, int i, int i2) throws IOException {
        int i3;
        if (i >= 0 && i2 >= 0 && (i3 = i + i2) >= 0) {
            if (i3 <= bArr.length) {
                if (!refill()) {
                    return -1;
                }
                int min = Math.min(i2, this.byteBuffer.remaining());
                this.byteBuffer.get(bArr, i, min);
                return min;
            }
        }
        throw new IndexOutOfBoundsException();
    }
}
