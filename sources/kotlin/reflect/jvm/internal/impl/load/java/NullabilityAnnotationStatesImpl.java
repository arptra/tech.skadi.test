package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class NullabilityAnnotationStatesImpl<T> implements NullabilityAnnotationStates<T> {
    @NotNull
    private final MemoizedFunctionToNullable<FqName, T> cache;
    @NotNull
    private final Map<FqName, T> states;
    @NotNull
    private final LockBasedStorageManager storageManager;

    public NullabilityAnnotationStatesImpl(@NotNull Map<FqName, ? extends T> map) {
        Intrinsics.checkNotNullParameter(map, "states");
        this.states = map;
        LockBasedStorageManager lockBasedStorageManager = new LockBasedStorageManager("Java nullability annotation states");
        this.storageManager = lockBasedStorageManager;
        MemoizedFunctionToNullable<FqName, T> createMemoizedFunctionWithNullableValues = lockBasedStorageManager.createMemoizedFunctionWithNullableValues(new NullabilityAnnotationStatesImpl$cache$1(this));
        Intrinsics.checkNotNullExpressionValue(createMemoizedFunctionWithNullableValues, "storageManager.createMem…cificFqname(states)\n    }");
        this.cache = createMemoizedFunctionWithNullableValues;
    }

    @Nullable
    public T get(@NotNull FqName fqName) {
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        return this.cache.invoke(fqName);
    }

    @NotNull
    public final Map<FqName, T> getStates() {
        return this.states;
    }
}
