package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.Method;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

final class Java16RecordComponentsLoader {
    @NotNull
    public static final Java16RecordComponentsLoader INSTANCE = new Java16RecordComponentsLoader();
    @Nullable
    private static Cache _cache;

    public static final class Cache {
        @Nullable
        private final Method getAccessor;
        @Nullable
        private final Method getType;

        public Cache(@Nullable Method method, @Nullable Method method2) {
            this.getType = method;
            this.getAccessor = method2;
        }

        @Nullable
        public final Method getGetAccessor() {
            return this.getAccessor;
        }

        @Nullable
        public final Method getGetType() {
            return this.getType;
        }
    }

    private Java16RecordComponentsLoader() {
    }

    private final Cache buildCache(Object obj) {
        Class<?> cls = obj.getClass();
        try {
            return new Cache(cls.getMethod("getType", (Class[]) null), cls.getMethod("getAccessor", (Class[]) null));
        } catch (NoSuchMethodException unused) {
            return new Cache((Method) null, (Method) null);
        }
    }

    private final Cache initCache(Object obj) {
        Cache cache = _cache;
        if (cache != null) {
            return cache;
        }
        Cache buildCache = buildCache(obj);
        _cache = buildCache;
        return buildCache;
    }

    @Nullable
    public final Method loadGetAccessor(@NotNull Object obj) {
        Intrinsics.checkNotNullParameter(obj, "recordComponent");
        Method getAccessor = initCache(obj).getGetAccessor();
        if (getAccessor == null) {
            return null;
        }
        Object invoke = getAccessor.invoke(obj, (Object[]) null);
        Intrinsics.checkNotNull(invoke, "null cannot be cast to non-null type java.lang.reflect.Method");
        return (Method) invoke;
    }

    @Nullable
    public final Class<?> loadGetType(@NotNull Object obj) {
        Intrinsics.checkNotNullParameter(obj, "recordComponent");
        Method getType = initCache(obj).getGetType();
        if (getType == null) {
            return null;
        }
        Object invoke = getType.invoke(obj, (Object[]) null);
        Intrinsics.checkNotNull(invoke, "null cannot be cast to non-null type java.lang.Class<*>");
        return (Class) invoke;
    }
}
