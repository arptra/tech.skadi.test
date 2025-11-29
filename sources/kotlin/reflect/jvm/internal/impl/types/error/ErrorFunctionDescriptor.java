package kotlin.reflect.jvm.internal.impl.types.error;

import com.upuphone.runasone.relay.api.IntentKey;
import java.util.Collection;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.SimpleFunctionDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.name.Name;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ErrorFunctionDescriptor extends SimpleFunctionDescriptorImpl {
    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ErrorFunctionDescriptor(@org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r18) {
        /*
            r17 = this;
            java.lang.String r0 = "containingDeclaration"
            r2 = r18
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations$Companion r0 = kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations r4 = r0.getEMPTY()
            kotlin.reflect.jvm.internal.impl.types.error.ErrorEntity r0 = kotlin.reflect.jvm.internal.impl.types.error.ErrorEntity.ERROR_FUNCTION
            java.lang.String r0 = r0.getDebugText()
            kotlin.reflect.jvm.internal.impl.name.Name r5 = kotlin.reflect.jvm.internal.impl.name.Name.special(r0)
            kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor$Kind r6 = kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind.DECLARATION
            kotlin.reflect.jvm.internal.impl.descriptors.SourceElement r7 = kotlin.reflect.jvm.internal.impl.descriptors.SourceElement.NO_SOURCE
            r3 = 0
            r1 = r17
            r1.<init>(r2, r3, r4, r5, r6, r7)
            java.util.List r11 = kotlin.collections.CollectionsKt.emptyList()
            java.util.List r12 = kotlin.collections.CollectionsKt.emptyList()
            java.util.List r13 = kotlin.collections.CollectionsKt.emptyList()
            kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind r0 = kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind.RETURN_TYPE_FOR_FUNCTION
            r1 = 0
            java.lang.String[] r1 = new java.lang.String[r1]
            kotlin.reflect.jvm.internal.impl.types.error.ErrorType r14 = kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils.createErrorType(r0, r1)
            kotlin.reflect.jvm.internal.impl.descriptors.Modality r15 = kotlin.reflect.jvm.internal.impl.descriptors.Modality.OPEN
            kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility r16 = kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities.PUBLIC
            r9 = 0
            r10 = 0
            r8 = r17
            r8.initialize((kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor) r9, (kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor) r10, (java.util.List) r11, (java.util.List) r12, (java.util.List) r13, (kotlin.reflect.jvm.internal.impl.types.KotlinType) r14, (kotlin.reflect.jvm.internal.impl.descriptors.Modality) r15, (kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility) r16)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.types.error.ErrorFunctionDescriptor.<init>(kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor):void");
    }

    @NotNull
    public SimpleFunctionDescriptor copy(@NotNull DeclarationDescriptor declarationDescriptor, @NotNull Modality modality, @NotNull DescriptorVisibility descriptorVisibility, @NotNull CallableMemberDescriptor.Kind kind, boolean z) {
        Intrinsics.checkNotNullParameter(declarationDescriptor, "newOwner");
        Intrinsics.checkNotNullParameter(modality, "modality");
        Intrinsics.checkNotNullParameter(descriptorVisibility, "visibility");
        Intrinsics.checkNotNullParameter(kind, "kind");
        return this;
    }

    @NotNull
    public FunctionDescriptorImpl createSubstitutedCopy(@NotNull DeclarationDescriptor declarationDescriptor, @Nullable FunctionDescriptor functionDescriptor, @NotNull CallableMemberDescriptor.Kind kind, @Nullable Name name, @NotNull Annotations annotations, @NotNull SourceElement sourceElement) {
        Intrinsics.checkNotNullParameter(declarationDescriptor, "newOwner");
        Intrinsics.checkNotNullParameter(kind, "kind");
        Intrinsics.checkNotNullParameter(annotations, "annotations");
        Intrinsics.checkNotNullParameter(sourceElement, "source");
        return this;
    }

    @Nullable
    public <V> V getUserData(@NotNull CallableDescriptor.UserDataKey<V> userDataKey) {
        Intrinsics.checkNotNullParameter(userDataKey, IntentKey.ACTIVITY.ACTION_KEY);
        return null;
    }

    public boolean isSuspend() {
        return false;
    }

    @NotNull
    public FunctionDescriptor.CopyBuilder<SimpleFunctionDescriptor> newCopyBuilder() {
        return new ErrorFunctionDescriptor$newCopyBuilder$1(this);
    }

    public void setOverriddenDescriptors(@NotNull Collection<? extends CallableMemberDescriptor> collection) {
        Intrinsics.checkNotNullParameter(collection, "overriddenDescriptors");
    }
}
