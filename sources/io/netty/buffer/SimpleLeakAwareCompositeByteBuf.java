package io.netty.buffer;

import io.netty.util.ResourceLeakTracker;
import java.nio.ByteOrder;

class SimpleLeakAwareCompositeByteBuf extends WrappedCompositeByteBuf {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    final ResourceLeakTracker<ByteBuf> leak;

    /* JADX WARNING: type inference failed for: r2v0, types: [java.lang.Object, io.netty.util.ResourceLeakTracker<io.netty.buffer.ByteBuf>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public SimpleLeakAwareCompositeByteBuf(io.netty.buffer.CompositeByteBuf r1, io.netty.util.ResourceLeakTracker<io.netty.buffer.ByteBuf> r2) {
        /*
            r0 = this;
            r0.<init>(r1)
            java.lang.String r1 = "leak"
            java.lang.Object r1 = io.netty.util.internal.ObjectUtil.checkNotNull(r2, r1)
            io.netty.util.ResourceLeakTracker r1 = (io.netty.util.ResourceLeakTracker) r1
            r0.leak = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.buffer.SimpleLeakAwareCompositeByteBuf.<init>(io.netty.buffer.CompositeByteBuf, io.netty.util.ResourceLeakTracker):void");
    }

    private void closeLeak(ByteBuf byteBuf) {
        this.leak.close(byteBuf);
    }

    private SimpleLeakAwareByteBuf newLeakAwareByteBuf(ByteBuf byteBuf) {
        return newLeakAwareByteBuf(byteBuf, unwrap(), this.leak);
    }

    public ByteBuf asReadOnly() {
        return newLeakAwareByteBuf(super.asReadOnly());
    }

    public ByteBuf duplicate() {
        return newLeakAwareByteBuf(super.duplicate());
    }

    public ByteBuf order(ByteOrder byteOrder) {
        return order() == byteOrder ? this : newLeakAwareByteBuf(super.order(byteOrder));
    }

    public ByteBuf readRetainedSlice(int i) {
        return newLeakAwareByteBuf(super.readRetainedSlice(i));
    }

    public ByteBuf readSlice(int i) {
        return newLeakAwareByteBuf(super.readSlice(i));
    }

    public boolean release() {
        ByteBuf unwrap = unwrap();
        if (!super.release()) {
            return false;
        }
        closeLeak(unwrap);
        return true;
    }

    public ByteBuf retainedDuplicate() {
        return newLeakAwareByteBuf(super.retainedDuplicate());
    }

    public ByteBuf retainedSlice() {
        return newLeakAwareByteBuf(super.retainedSlice());
    }

    public ByteBuf slice() {
        return newLeakAwareByteBuf(super.slice());
    }

    public SimpleLeakAwareByteBuf newLeakAwareByteBuf(ByteBuf byteBuf, ByteBuf byteBuf2, ResourceLeakTracker<ByteBuf> resourceLeakTracker) {
        return new SimpleLeakAwareByteBuf(byteBuf, byteBuf2, resourceLeakTracker);
    }

    public ByteBuf retainedSlice(int i, int i2) {
        return newLeakAwareByteBuf(super.retainedSlice(i, i2));
    }

    public ByteBuf slice(int i, int i2) {
        return newLeakAwareByteBuf(super.slice(i, i2));
    }

    public boolean release(int i) {
        ByteBuf unwrap = unwrap();
        if (!super.release(i)) {
            return false;
        }
        closeLeak(unwrap);
        return true;
    }
}
