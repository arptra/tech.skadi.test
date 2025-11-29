package kotlin.reflect.jvm.internal.impl.resolve.constants;

import com.honey.account.constant.AccountConstantKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import org.jetbrains.annotations.NotNull;

public final class StringValue extends ConstantValue<String> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StringValue(@NotNull String str) {
        super(str);
        Intrinsics.checkNotNullParameter(str, AccountConstantKt.RESPONSE_VALUE);
    }

    @NotNull
    public String toString() {
        return '\"' + ((String) getValue()) + '\"';
    }

    @NotNull
    public SimpleType getType(@NotNull ModuleDescriptor moduleDescriptor) {
        Intrinsics.checkNotNullParameter(moduleDescriptor, "module");
        SimpleType stringType = moduleDescriptor.getBuiltIns().getStringType();
        Intrinsics.checkNotNullExpressionValue(stringType, "module.builtIns.stringType");
        return stringType;
    }
}
