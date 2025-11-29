package io.netty.util.internal;

import io.netty.util.internal.ObjectPool;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;

public final class RecyclableArrayList extends ArrayList<Object> {
    private static final int DEFAULT_INITIAL_CAPACITY = 8;
    private static final ObjectPool<RecyclableArrayList> RECYCLER = ObjectPool.newPool(new ObjectPool.ObjectCreator<RecyclableArrayList>() {
        public RecyclableArrayList newObject(ObjectPool.Handle<RecyclableArrayList> handle) {
            return new RecyclableArrayList((ObjectPool.Handle) handle);
        }
    });
    private static final long serialVersionUID = -8605125654176467947L;
    private final ObjectPool.Handle<RecyclableArrayList> handle;
    private boolean insertSinceRecycled;

    private static void checkNullElements(Collection<?> collection) {
        if (!(collection instanceof RandomAccess) || !(collection instanceof List)) {
            for (Object obj : collection) {
                if (obj == null) {
                    throw new IllegalArgumentException("c contains null values");
                }
            }
            return;
        }
        List list = (List) collection;
        int size = list.size();
        int i = 0;
        while (i < size) {
            if (list.get(i) != null) {
                i++;
            } else {
                throw new IllegalArgumentException("c contains null values");
            }
        }
    }

    public static RecyclableArrayList newInstance() {
        return newInstance(8);
    }

    public boolean add(Object obj) {
        if (!super.add(ObjectUtil.checkNotNull(obj, "element"))) {
            return false;
        }
        this.insertSinceRecycled = true;
        return true;
    }

    public boolean addAll(Collection<?> collection) {
        checkNullElements(collection);
        if (!super.addAll(collection)) {
            return false;
        }
        this.insertSinceRecycled = true;
        return true;
    }

    public boolean insertSinceRecycled() {
        return this.insertSinceRecycled;
    }

    public boolean recycle() {
        clear();
        this.insertSinceRecycled = false;
        this.handle.recycle(this);
        return true;
    }

    public Object set(int i, Object obj) {
        Object obj2 = super.set(i, ObjectUtil.checkNotNull(obj, "element"));
        this.insertSinceRecycled = true;
        return obj2;
    }

    private RecyclableArrayList(ObjectPool.Handle<RecyclableArrayList> handle2) {
        this(handle2, 8);
    }

    public static RecyclableArrayList newInstance(int i) {
        RecyclableArrayList recyclableArrayList = RECYCLER.get();
        recyclableArrayList.ensureCapacity(i);
        return recyclableArrayList;
    }

    private RecyclableArrayList(ObjectPool.Handle<RecyclableArrayList> handle2, int i) {
        super(i);
        this.handle = handle2;
    }

    public void add(int i, Object obj) {
        super.add(i, ObjectUtil.checkNotNull(obj, "element"));
        this.insertSinceRecycled = true;
    }

    public boolean addAll(int i, Collection<?> collection) {
        checkNullElements(collection);
        if (!super.addAll(i, collection)) {
            return false;
        }
        this.insertSinceRecycled = true;
        return true;
    }
}
