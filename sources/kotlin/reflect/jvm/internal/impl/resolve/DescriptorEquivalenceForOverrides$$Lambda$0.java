package kotlin.reflect.jvm.internal.impl.resolve;

import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker;

class DescriptorEquivalenceForOverrides$$Lambda$0 implements KotlinTypeChecker.TypeConstructorEquality {
    private final boolean arg$0;
    private final CallableDescriptor arg$1;
    private final CallableDescriptor arg$2;

    public DescriptorEquivalenceForOverrides$$Lambda$0(boolean z, CallableDescriptor callableDescriptor, CallableDescriptor callableDescriptor2) {
        this.arg$0 = z;
        this.arg$1 = callableDescriptor;
        this.arg$2 = callableDescriptor2;
    }

    public boolean equals(TypeConstructor typeConstructor, TypeConstructor typeConstructor2) {
        return DescriptorEquivalenceForOverrides.areCallableDescriptorsEquivalent$lambda$0(this.arg$0, this.arg$1, this.arg$2, typeConstructor, typeConstructor2);
    }
}
