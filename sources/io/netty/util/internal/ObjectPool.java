package io.netty.util.internal;

import io.netty.util.Recycler;

public abstract class ObjectPool<T> {

    public interface Handle<T> {
        void recycle(T t);
    }

    public interface ObjectCreator<T> {
        T newObject(Handle<T> handle);
    }

    public static final class RecyclerObjectPool<T> extends ObjectPool<T> {
        private final Recycler<T> recycler;

        public RecyclerObjectPool(final ObjectCreator<T> objectCreator) {
            this.recycler = new Recycler<T>() {
                public T newObject(Recycler.Handle<T> handle) {
                    return objectCreator.newObject(handle);
                }
            };
        }

        public T get() {
            return this.recycler.get();
        }
    }

    public static <T> ObjectPool<T> newPool(ObjectCreator<T> objectCreator) {
        return new RecyclerObjectPool((ObjectCreator) ObjectUtil.checkNotNull(objectCreator, "creator"));
    }

    public abstract T get();
}
