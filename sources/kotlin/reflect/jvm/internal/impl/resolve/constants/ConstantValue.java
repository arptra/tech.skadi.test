package kotlin.reflect.jvm.internal.impl.resolve.constants;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class ConstantValue<T> {
    private final T value;

    public ConstantValue(T t) {
        this.value = t;
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            Object value2 = getValue();
            Object obj2 = null;
            ConstantValue constantValue = obj instanceof ConstantValue ? (ConstantValue) obj : null;
            if (constantValue != null) {
                obj2 = constantValue.getValue();
            }
            return Intrinsics.areEqual(value2, obj2);
        }
    }

    @NotNull
    public abstract KotlinType getType(@NotNull ModuleDescriptor moduleDescriptor);

    public T getValue() {
        return this.value;
    }

    public int hashCode() {
        Object value2 = getValue();
        if (value2 != null) {
            return value2.hashCode();
        }
        return 0;
    }

    @NotNull
    public String toString() {
        return String.valueOf(getValue());
    }
}
