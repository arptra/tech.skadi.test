package io.netty.util.internal;

import io.netty.util.ReferenceCountUtil;
import io.netty.util.concurrent.Promise;
import io.netty.util.internal.ObjectPool;

public final class PendingWrite {
    private static final ObjectPool<PendingWrite> RECYCLER = ObjectPool.newPool(new ObjectPool.ObjectCreator<PendingWrite>() {
        public PendingWrite newObject(ObjectPool.Handle<PendingWrite> handle) {
            return new PendingWrite(handle);
        }
    });
    private final ObjectPool.Handle<PendingWrite> handle;
    private Object msg;
    private Promise<Void> promise;

    public static PendingWrite newInstance(Object obj, Promise<Void> promise2) {
        PendingWrite pendingWrite = RECYCLER.get();
        pendingWrite.msg = obj;
        pendingWrite.promise = promise2;
        return pendingWrite;
    }

    public boolean failAndRecycle(Throwable th) {
        ReferenceCountUtil.release(this.msg);
        Promise<Void> promise2 = this.promise;
        if (promise2 != null) {
            promise2.setFailure(th);
        }
        return recycle();
    }

    public Object msg() {
        return this.msg;
    }

    public Promise<Void> promise() {
        return this.promise;
    }

    public boolean recycle() {
        this.msg = null;
        this.promise = null;
        this.handle.recycle(this);
        return true;
    }

    public Promise<Void> recycleAndGet() {
        Promise<Void> promise2 = this.promise;
        recycle();
        return promise2;
    }

    public boolean successAndRecycle() {
        Promise<Void> promise2 = this.promise;
        if (promise2 != null) {
            promise2.setSuccess(null);
        }
        return recycle();
    }

    private PendingWrite(ObjectPool.Handle<PendingWrite> handle2) {
        this.handle = handle2;
    }
}
