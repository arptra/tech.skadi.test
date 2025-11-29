package io.netty.util;

import io.netty.util.internal.ReferenceCountUpdater;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

public abstract class AbstractReferenceCounted implements ReferenceCounted {
    /* access modifiers changed from: private */
    public static final AtomicIntegerFieldUpdater<AbstractReferenceCounted> AIF_UPDATER;
    /* access modifiers changed from: private */
    public static final long REFCNT_FIELD_OFFSET;
    private static final ReferenceCountUpdater<AbstractReferenceCounted> updater = new ReferenceCountUpdater<AbstractReferenceCounted>() {
        public long unsafeOffset() {
            return AbstractReferenceCounted.REFCNT_FIELD_OFFSET;
        }

        public AtomicIntegerFieldUpdater<AbstractReferenceCounted> updater() {
            return AbstractReferenceCounted.AIF_UPDATER;
        }
    };
    private volatile int refCnt = updater.initialValue();

    static {
        Class<AbstractReferenceCounted> cls = AbstractReferenceCounted.class;
        REFCNT_FIELD_OFFSET = ReferenceCountUpdater.getUnsafeOffset(cls, "refCnt");
        AIF_UPDATER = AtomicIntegerFieldUpdater.newUpdater(cls, "refCnt");
    }

    private boolean handleRelease(boolean z) {
        if (z) {
            deallocate();
        }
        return z;
    }

    public abstract void deallocate();

    public int refCnt() {
        return updater.refCnt(this);
    }

    public boolean release() {
        return handleRelease(updater.release(this));
    }

    public ReferenceCounted retain() {
        return updater.retain(this);
    }

    public final void setRefCnt(int i) {
        updater.setRefCnt(this, i);
    }

    public ReferenceCounted touch() {
        return touch((Object) null);
    }

    public boolean release(int i) {
        return handleRelease(updater.release(this, i));
    }

    public ReferenceCounted retain(int i) {
        return updater.retain(this, i);
    }
}
