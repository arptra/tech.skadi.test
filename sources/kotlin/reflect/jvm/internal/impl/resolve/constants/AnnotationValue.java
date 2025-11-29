package kotlin.reflect.jvm.internal.impl.resolve.constants;

import com.honey.account.constant.AccountConstantKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;

public final class AnnotationValue extends ConstantValue<AnnotationDescriptor> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AnnotationValue(@NotNull AnnotationDescriptor annotationDescriptor) {
        super(annotationDescriptor);
        Intrinsics.checkNotNullParameter(annotationDescriptor, AccountConstantKt.RESPONSE_VALUE);
    }

    @NotNull
    public KotlinType getType(@NotNull ModuleDescriptor moduleDescriptor) {
        Intrinsics.checkNotNullParameter(moduleDescriptor, "module");
        return ((AnnotationDescriptor) getValue()).getType();
    }
}
