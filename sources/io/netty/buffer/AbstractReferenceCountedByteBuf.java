package io.netty.buffer;

import io.netty.util.internal.ReferenceCountUpdater;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

public abstract class AbstractReferenceCountedByteBuf extends AbstractByteBuf {
    /* access modifiers changed from: private */
    public static final AtomicIntegerFieldUpdater<AbstractReferenceCountedByteBuf> AIF_UPDATER;
    /* access modifiers changed from: private */
    public static final long REFCNT_FIELD_OFFSET;
    private static final ReferenceCountUpdater<AbstractReferenceCountedByteBuf> updater = new ReferenceCountUpdater<AbstractReferenceCountedByteBuf>() {
        public long unsafeOffset() {
            return AbstractReferenceCountedByteBuf.REFCNT_FIELD_OFFSET;
        }

        public AtomicIntegerFieldUpdater<AbstractReferenceCountedByteBuf> updater() {
            return AbstractReferenceCountedByteBuf.AIF_UPDATER;
        }
    };
    private volatile int refCnt;

    static {
        Class<AbstractReferenceCountedByteBuf> cls = AbstractReferenceCountedByteBuf.class;
        REFCNT_FIELD_OFFSET = ReferenceCountUpdater.getUnsafeOffset(cls, "refCnt");
        AIF_UPDATER = AtomicIntegerFieldUpdater.newUpdater(cls, "refCnt");
    }

    public AbstractReferenceCountedByteBuf(int i) {
        super(i);
        updater.setInitialValue(this);
    }

    private boolean handleRelease(boolean z) {
        if (z) {
            deallocate();
        }
        return z;
    }

    public abstract void deallocate();

    public boolean isAccessible() {
        return updater.isLiveNonVolatile(this);
    }

    public int refCnt() {
        return updater.refCnt(this);
    }

    public boolean release() {
        return handleRelease(updater.release(this));
    }

    public final void resetRefCnt() {
        updater.resetRefCnt(this);
    }

    public final void setRefCnt(int i) {
        updater.setRefCnt(this, i);
    }

    public ByteBuf touch() {
        return this;
    }

    public boolean release(int i) {
        return handleRelease(updater.release(this, i));
    }

    public ByteBuf touch(Object obj) {
        return this;
    }

    public ByteBuf retain() {
        return updater.retain(this);
    }

    public ByteBuf retain(int i) {
        return updater.retain(this, i);
    }
}
