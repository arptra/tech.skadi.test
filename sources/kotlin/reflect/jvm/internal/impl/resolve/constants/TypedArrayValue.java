package kotlin.reflect.jvm.internal.impl.resolve.constants;

import com.honey.account.constant.AccountConstantKt;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;

public final class TypedArrayValue extends ArrayValue {
    @NotNull
    private final KotlinType type;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TypedArrayValue(@NotNull List<? extends ConstantValue<?>> list, @NotNull final KotlinType kotlinType) {
        super(list, new Function1<ModuleDescriptor, KotlinType>() {
            @NotNull
            public final KotlinType invoke(@NotNull ModuleDescriptor moduleDescriptor) {
                Intrinsics.checkNotNullParameter(moduleDescriptor, "it");
                return kotlinType;
            }
        });
        Intrinsics.checkNotNullParameter(list, AccountConstantKt.RESPONSE_VALUE);
        Intrinsics.checkNotNullParameter(kotlinType, "type");
        this.type = kotlinType;
    }

    @NotNull
    public final KotlinType getType() {
        return this.type;
    }
}
