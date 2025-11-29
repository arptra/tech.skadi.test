package kotlin.reflect.jvm.internal.impl.types;

import org.jetbrains.annotations.NotNull;

public interface CustomTypeParameter {
    boolean isTypeParameter();

    @NotNull
    KotlinType substitutionResult(@NotNull KotlinType kotlinType);
}
