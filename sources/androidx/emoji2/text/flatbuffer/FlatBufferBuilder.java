package androidx.emoji2.text.flatbuffer;

import java.io.InputStream;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;

public class FlatBufferBuilder {

    public static class ByteBufferBackedInputStream extends InputStream {

        /* renamed from: a  reason: collision with root package name */
        public ByteBuffer f1222a;

        public int read() {
            try {
                return this.f1222a.get() & 255;
            } catch (BufferUnderflowException unused) {
                return -1;
            }
        }
    }

    public static abstract class ByteBufferFactory {
    }

    public static final class HeapByteBufferFactory extends ByteBufferFactory {

        /* renamed from: a  reason: collision with root package name */
        public static final HeapByteBufferFactory f1223a = new HeapByteBufferFactory();
    }
}
