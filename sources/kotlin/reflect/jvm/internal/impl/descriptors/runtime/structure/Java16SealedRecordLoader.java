package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.Method;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

final class Java16SealedRecordLoader {
    @NotNull
    public static final Java16SealedRecordLoader INSTANCE = new Java16SealedRecordLoader();
    @Nullable
    private static Cache _cache;

    public static final class Cache {
        @Nullable
        private final Method getPermittedSubclasses;
        @Nullable
        private final Method getRecordComponents;
        @Nullable
        private final Method isRecord;
        @Nullable
        private final Method isSealed;

        public Cache(@Nullable Method method, @Nullable Method method2, @Nullable Method method3, @Nullable Method method4) {
            this.isSealed = method;
            this.getPermittedSubclasses = method2;
            this.isRecord = method3;
            this.getRecordComponents = method4;
        }

        @Nullable
        public final Method getGetPermittedSubclasses() {
            return this.getPermittedSubclasses;
        }

        @Nullable
        public final Method getGetRecordComponents() {
            return this.getRecordComponents;
        }

        @Nullable
        public final Method isRecord() {
            return this.isRecord;
        }

        @Nullable
        public final Method isSealed() {
            return this.isSealed;
        }
    }

    private Java16SealedRecordLoader() {
    }

    private final Cache buildCache() {
        Class<Class> cls = Class.class;
        try {
            return new Cache(cls.getMethod("isSealed", (Class[]) null), cls.getMethod("getPermittedSubclasses", (Class[]) null), cls.getMethod("isRecord", (Class[]) null), cls.getMethod("getRecordComponents", (Class[]) null));
        } catch (NoSuchMethodException unused) {
            return new Cache((Method) null, (Method) null, (Method) null, (Method) null);
        }
    }

    private final Cache initCache() {
        Cache cache = _cache;
        if (cache != null) {
            return cache;
        }
        Cache buildCache = buildCache();
        _cache = buildCache;
        return buildCache;
    }

    @Nullable
    public final Class<?>[] loadGetPermittedSubclasses(@NotNull Class<?> cls) {
        Intrinsics.checkNotNullParameter(cls, "clazz");
        Method getPermittedSubclasses = initCache().getGetPermittedSubclasses();
        if (getPermittedSubclasses == null) {
            return null;
        }
        Object invoke = getPermittedSubclasses.invoke(cls, (Object[]) null);
        Intrinsics.checkNotNull(invoke, "null cannot be cast to non-null type kotlin.Array<java.lang.Class<*>>");
        return (Class[]) invoke;
    }

    @Nullable
    public final Object[] loadGetRecordComponents(@NotNull Class<?> cls) {
        Intrinsics.checkNotNullParameter(cls, "clazz");
        Method getRecordComponents = initCache().getGetRecordComponents();
        if (getRecordComponents == null) {
            return null;
        }
        return (Object[]) getRecordComponents.invoke(cls, (Object[]) null);
    }

    @Nullable
    public final Boolean loadIsRecord(@NotNull Class<?> cls) {
        Intrinsics.checkNotNullParameter(cls, "clazz");
        Method isRecord = initCache().isRecord();
        if (isRecord == null) {
            return null;
        }
        Object invoke = isRecord.invoke(cls, (Object[]) null);
        Intrinsics.checkNotNull(invoke, "null cannot be cast to non-null type kotlin.Boolean");
        return (Boolean) invoke;
    }

    @Nullable
    public final Boolean loadIsSealed(@NotNull Class<?> cls) {
        Intrinsics.checkNotNullParameter(cls, "clazz");
        Method isSealed = initCache().isSealed();
        if (isSealed == null) {
            return null;
        }
        Object invoke = isSealed.invoke(cls, (Object[]) null);
        Intrinsics.checkNotNull(invoke, "null cannot be cast to non-null type kotlin.Boolean");
        return (Boolean) invoke;
    }
}
