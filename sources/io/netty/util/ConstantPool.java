package io.netty.util;

import io.netty.util.Constant;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class ConstantPool<T extends Constant<T>> {
    private final ConcurrentMap<String, T> constants = PlatformDependent.newConcurrentHashMap();
    private final AtomicInteger nextId = new AtomicInteger(1);

    private T createOrThrow(String str) {
        if (((Constant) this.constants.get(str)) == null) {
            T newConstant = newConstant(nextId(), str);
            if (((Constant) this.constants.putIfAbsent(str, newConstant)) == null) {
                return newConstant;
            }
        }
        throw new IllegalArgumentException(String.format("'%s' is already in use", new Object[]{str}));
    }

    private T getOrCreate(String str) {
        T t = (Constant) this.constants.get(str);
        if (t != null) {
            return t;
        }
        T newConstant = newConstant(nextId(), str);
        T t2 = (Constant) this.constants.putIfAbsent(str, newConstant);
        return t2 == null ? newConstant : t2;
    }

    public boolean exists(String str) {
        return this.constants.containsKey(ObjectUtil.checkNonEmpty(str, "name"));
    }

    public abstract T newConstant(int i, String str);

    public T newInstance(String str) {
        return createOrThrow(ObjectUtil.checkNonEmpty(str, "name"));
    }

    @Deprecated
    public final int nextId() {
        return this.nextId.getAndIncrement();
    }

    public T valueOf(Class<?> cls, String str) {
        return valueOf(((Class) ObjectUtil.checkNotNull(cls, "firstNameComponent")).getName() + '#' + ((String) ObjectUtil.checkNotNull(str, "secondNameComponent")));
    }

    public T valueOf(String str) {
        return getOrCreate(ObjectUtil.checkNonEmpty(str, "name"));
    }
}
