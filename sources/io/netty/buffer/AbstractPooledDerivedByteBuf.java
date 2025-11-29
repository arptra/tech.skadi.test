package io.netty.buffer;

import io.netty.util.internal.ObjectPool;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

abstract class AbstractPooledDerivedByteBuf extends AbstractReferenceCountedByteBuf {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private ByteBuf parent;
    private final ObjectPool.Handle<AbstractPooledDerivedByteBuf> recyclerHandle;
    private AbstractByteBuf rootParent;

    public static final class PooledNonRetainedDuplicateByteBuf extends UnpooledDuplicatedByteBuf {
        private final ByteBuf referenceCountDelegate;

        public PooledNonRetainedDuplicateByteBuf(ByteBuf byteBuf, AbstractByteBuf abstractByteBuf) {
            super(abstractByteBuf);
            this.referenceCountDelegate = byteBuf;
        }

        public ByteBuf duplicate() {
            ensureAccessible();
            return new PooledNonRetainedDuplicateByteBuf(this.referenceCountDelegate, this);
        }

        public boolean isAccessible0() {
            return this.referenceCountDelegate.isAccessible();
        }

        public int refCnt0() {
            return this.referenceCountDelegate.refCnt();
        }

        public boolean release0() {
            return this.referenceCountDelegate.release();
        }

        public ByteBuf retain0() {
            this.referenceCountDelegate.retain();
            return this;
        }

        public ByteBuf retainedDuplicate() {
            return PooledDuplicatedByteBuf.newInstance(unwrap(), this, readerIndex(), writerIndex());
        }

        public ByteBuf retainedSlice() {
            return retainedSlice(readerIndex(), capacity());
        }

        public ByteBuf slice(int i, int i2) {
            checkIndex(i, i2);
            return new PooledNonRetainedSlicedByteBuf(this.referenceCountDelegate, unwrap(), i, i2);
        }

        public ByteBuf touch0() {
            this.referenceCountDelegate.touch();
            return this;
        }

        public boolean release0(int i) {
            return this.referenceCountDelegate.release(i);
        }

        public ByteBuf retain0(int i) {
            this.referenceCountDelegate.retain(i);
            return this;
        }

        public ByteBuf retainedSlice(int i, int i2) {
            return PooledSlicedByteBuf.newInstance(unwrap(), this, i, i2);
        }

        public ByteBuf touch0(Object obj) {
            this.referenceCountDelegate.touch(obj);
            return this;
        }
    }

    public static final class PooledNonRetainedSlicedByteBuf extends UnpooledSlicedByteBuf {
        private final ByteBuf referenceCountDelegate;

        public PooledNonRetainedSlicedByteBuf(ByteBuf byteBuf, AbstractByteBuf abstractByteBuf, int i, int i2) {
            super(abstractByteBuf, i, i2);
            this.referenceCountDelegate = byteBuf;
        }

        public ByteBuf duplicate() {
            ensureAccessible();
            return new PooledNonRetainedDuplicateByteBuf(this.referenceCountDelegate, unwrap()).setIndex(idx(readerIndex()), idx(writerIndex()));
        }

        public boolean isAccessible0() {
            return this.referenceCountDelegate.isAccessible();
        }

        public int refCnt0() {
            return this.referenceCountDelegate.refCnt();
        }

        public boolean release0() {
            return this.referenceCountDelegate.release();
        }

        public ByteBuf retain0() {
            this.referenceCountDelegate.retain();
            return this;
        }

        public ByteBuf retainedDuplicate() {
            return PooledDuplicatedByteBuf.newInstance(unwrap(), this, idx(readerIndex()), idx(writerIndex()));
        }

        public ByteBuf retainedSlice() {
            return retainedSlice(0, capacity());
        }

        public ByteBuf slice(int i, int i2) {
            checkIndex(i, i2);
            return new PooledNonRetainedSlicedByteBuf(this.referenceCountDelegate, unwrap(), idx(i), i2);
        }

        public ByteBuf touch0() {
            this.referenceCountDelegate.touch();
            return this;
        }

        public boolean release0(int i) {
            return this.referenceCountDelegate.release(i);
        }

        public ByteBuf retain0(int i) {
            this.referenceCountDelegate.retain(i);
            return this;
        }

        public ByteBuf retainedSlice(int i, int i2) {
            return PooledSlicedByteBuf.newInstance(unwrap(), this, idx(i), i2);
        }

        public ByteBuf touch0(Object obj) {
            this.referenceCountDelegate.touch(obj);
            return this;
        }
    }

    public AbstractPooledDerivedByteBuf(ObjectPool.Handle<? extends AbstractPooledDerivedByteBuf> handle) {
        super(0);
        this.recyclerHandle = handle;
    }

    public final ByteBufAllocator alloc() {
        return unwrap().alloc();
    }

    public byte[] array() {
        return unwrap().array();
    }

    public final void deallocate() {
        ByteBuf byteBuf = this.parent;
        this.recyclerHandle.recycle(this);
        byteBuf.release();
    }

    public final ByteBuf duplicate0() {
        ensureAccessible();
        return new PooledNonRetainedDuplicateByteBuf(this, unwrap());
    }

    public boolean hasArray() {
        return unwrap().hasArray();
    }

    public boolean hasMemoryAddress() {
        return unwrap().hasMemoryAddress();
    }

    public final <U extends AbstractPooledDerivedByteBuf> U init(AbstractByteBuf abstractByteBuf, ByteBuf byteBuf, int i, int i2, int i3) {
        byteBuf.retain();
        this.parent = byteBuf;
        this.rootParent = abstractByteBuf;
        try {
            maxCapacity(i3);
            setIndex0(i, i2);
            resetRefCnt();
            return this;
        } catch (Throwable th) {
            this.rootParent = null;
            this.parent = null;
            byteBuf.release();
            throw th;
        }
    }

    public final ByteBuffer internalNioBuffer(int i, int i2) {
        return nioBuffer(i, i2);
    }

    public boolean isContiguous() {
        return unwrap().isContiguous();
    }

    public final boolean isDirect() {
        return unwrap().isDirect();
    }

    public boolean isReadOnly() {
        return unwrap().isReadOnly();
    }

    public final int nioBufferCount() {
        return unwrap().nioBufferCount();
    }

    @Deprecated
    public final ByteOrder order() {
        return unwrap().order();
    }

    public final void parent(ByteBuf byteBuf) {
        this.parent = byteBuf;
    }

    public final ByteBuf retainedSlice() {
        int readerIndex = readerIndex();
        return retainedSlice(readerIndex, writerIndex() - readerIndex);
    }

    public ByteBuf slice(int i, int i2) {
        ensureAccessible();
        return new PooledNonRetainedSlicedByteBuf(this, unwrap(), i, i2);
    }

    public final AbstractByteBuf unwrap() {
        return this.rootParent;
    }
}
