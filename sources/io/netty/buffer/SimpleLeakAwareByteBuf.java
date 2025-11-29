package io.netty.buffer;

import io.netty.util.ResourceLeakTracker;
import java.nio.ByteOrder;

class SimpleLeakAwareByteBuf extends WrappedByteBuf {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    final ResourceLeakTracker<ByteBuf> leak;
    private final ByteBuf trackedByteBuf;

    /* JADX WARNING: type inference failed for: r3v0, types: [java.lang.Object, io.netty.util.ResourceLeakTracker<io.netty.buffer.ByteBuf>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public SimpleLeakAwareByteBuf(io.netty.buffer.ByteBuf r1, io.netty.buffer.ByteBuf r2, io.netty.util.ResourceLeakTracker<io.netty.buffer.ByteBuf> r3) {
        /*
            r0 = this;
            r0.<init>(r1)
            java.lang.String r1 = "trackedByteBuf"
            java.lang.Object r1 = io.netty.util.internal.ObjectUtil.checkNotNull(r2, r1)
            io.netty.buffer.ByteBuf r1 = (io.netty.buffer.ByteBuf) r1
            r0.trackedByteBuf = r1
            java.lang.String r1 = "leak"
            java.lang.Object r1 = io.netty.util.internal.ObjectUtil.checkNotNull(r3, r1)
            io.netty.util.ResourceLeakTracker r1 = (io.netty.util.ResourceLeakTracker) r1
            r0.leak = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.buffer.SimpleLeakAwareByteBuf.<init>(io.netty.buffer.ByteBuf, io.netty.buffer.ByteBuf, io.netty.util.ResourceLeakTracker):void");
    }

    private void closeLeak() {
        this.leak.close(this.trackedByteBuf);
    }

    private SimpleLeakAwareByteBuf newLeakAwareByteBuf(ByteBuf byteBuf, ResourceLeakTracker<ByteBuf> resourceLeakTracker) {
        return newLeakAwareByteBuf(byteBuf, byteBuf, resourceLeakTracker);
    }

    private SimpleLeakAwareByteBuf newSharedLeakAwareByteBuf(ByteBuf byteBuf) {
        return newLeakAwareByteBuf(byteBuf, this.trackedByteBuf, this.leak);
    }

    private static ByteBuf unwrapSwapped(ByteBuf byteBuf) {
        if (byteBuf instanceof SwappedByteBuf) {
            do {
                byteBuf = byteBuf.unwrap();
            } while (byteBuf instanceof SwappedByteBuf);
        }
        return byteBuf;
    }

    private ByteBuf unwrappedDerived(ByteBuf byteBuf) {
        ByteBuf unwrapSwapped = unwrapSwapped(byteBuf);
        if (!(unwrapSwapped instanceof AbstractPooledDerivedByteBuf)) {
            return newSharedLeakAwareByteBuf(byteBuf);
        }
        ((AbstractPooledDerivedByteBuf) unwrapSwapped).parent(this);
        ResourceLeakTracker<ByteBuf> track = AbstractByteBuf.leakDetector.track(byteBuf);
        return track == null ? byteBuf : newLeakAwareByteBuf(byteBuf, track);
    }

    public ByteBuf asReadOnly() {
        return newSharedLeakAwareByteBuf(super.asReadOnly());
    }

    public ByteBuf duplicate() {
        return newSharedLeakAwareByteBuf(super.duplicate());
    }

    public ByteBuf order(ByteOrder byteOrder) {
        return order() == byteOrder ? this : newSharedLeakAwareByteBuf(super.order(byteOrder));
    }

    public ByteBuf readRetainedSlice(int i) {
        return unwrappedDerived(super.readRetainedSlice(i));
    }

    public ByteBuf readSlice(int i) {
        return newSharedLeakAwareByteBuf(super.readSlice(i));
    }

    public boolean release() {
        if (!super.release()) {
            return false;
        }
        closeLeak();
        return true;
    }

    public ByteBuf retainedDuplicate() {
        return unwrappedDerived(super.retainedDuplicate());
    }

    public ByteBuf retainedSlice() {
        return unwrappedDerived(super.retainedSlice());
    }

    public ByteBuf slice() {
        return newSharedLeakAwareByteBuf(super.slice());
    }

    public ByteBuf touch() {
        return this;
    }

    public SimpleLeakAwareByteBuf newLeakAwareByteBuf(ByteBuf byteBuf, ByteBuf byteBuf2, ResourceLeakTracker<ByteBuf> resourceLeakTracker) {
        return new SimpleLeakAwareByteBuf(byteBuf, byteBuf2, resourceLeakTracker);
    }

    public ByteBuf retainedSlice(int i, int i2) {
        return unwrappedDerived(super.retainedSlice(i, i2));
    }

    public ByteBuf slice(int i, int i2) {
        return newSharedLeakAwareByteBuf(super.slice(i, i2));
    }

    public ByteBuf touch(Object obj) {
        return this;
    }

    public boolean release(int i) {
        if (!super.release(i)) {
            return false;
        }
        closeLeak();
        return true;
    }

    public SimpleLeakAwareByteBuf(ByteBuf byteBuf, ResourceLeakTracker<ByteBuf> resourceLeakTracker) {
        this(byteBuf, byteBuf, resourceLeakTracker);
    }
}
