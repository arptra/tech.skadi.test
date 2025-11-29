package androidx.datastore.preferences.protobuf;

import java.nio.ByteBuffer;

abstract class BufferAllocator {

    /* renamed from: a  reason: collision with root package name */
    public static final BufferAllocator f1058a = new BufferAllocator() {
        public AllocatedBuffer a(int i) {
            return AllocatedBuffer.i(ByteBuffer.allocateDirect(i));
        }

        public AllocatedBuffer b(int i) {
            return AllocatedBuffer.j(new byte[i]);
        }
    };

    public abstract AllocatedBuffer a(int i);

    public abstract AllocatedBuffer b(int i);
}
