package kotlin.reflect.jvm.internal.impl.resolve;

import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class DescriptorEquivalenceForOverrides$areCallableDescriptorsEquivalent$overridingUtil$1$1 extends Lambda implements Function2<DeclarationDescriptor, DeclarationDescriptor, Boolean> {
    final /* synthetic */ CallableDescriptor $a;
    final /* synthetic */ CallableDescriptor $b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DescriptorEquivalenceForOverrides$areCallableDescriptorsEquivalent$overridingUtil$1$1(CallableDescriptor callableDescriptor, CallableDescriptor callableDescriptor2) {
        super(2);
        this.$a = callableDescriptor;
        this.$b = callableDescriptor2;
    }

    @NotNull
    public final Boolean invoke(@Nullable DeclarationDescriptor declarationDescriptor, @Nullable DeclarationDescriptor declarationDescriptor2) {
        return Boolean.valueOf(Intrinsics.areEqual((Object) declarationDescriptor, (Object) this.$a) && Intrinsics.areEqual((Object) declarationDescriptor2, (Object) this.$b));
    }
}
