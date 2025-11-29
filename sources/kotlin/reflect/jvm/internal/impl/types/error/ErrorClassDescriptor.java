package kotlin.reflect.jvm.internal.impl.types.error;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitution;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import org.jetbrains.annotations.NotNull;

public final class ErrorClassDescriptor extends ClassDescriptorImpl {
    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ErrorClassDescriptor(@org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.name.Name r13) {
        /*
            r12 = this;
            java.lang.String r0 = "name"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils r0 = kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils.INSTANCE
            kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor r2 = r0.getErrorModule()
            kotlin.reflect.jvm.internal.impl.descriptors.Modality r4 = kotlin.reflect.jvm.internal.impl.descriptors.Modality.OPEN
            kotlin.reflect.jvm.internal.impl.descriptors.ClassKind r5 = kotlin.reflect.jvm.internal.impl.descriptors.ClassKind.CLASS
            java.util.List r6 = kotlin.collections.CollectionsKt.emptyList()
            kotlin.reflect.jvm.internal.impl.descriptors.SourceElement r10 = kotlin.reflect.jvm.internal.impl.descriptors.SourceElement.NO_SOURCE
            r8 = 0
            kotlin.reflect.jvm.internal.impl.storage.StorageManager r9 = kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.NO_LOCKS
            r1 = r12
            r3 = r13
            r7 = r10
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9)
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations$Companion r13 = kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations r13 = r13.getEMPTY()
            r1 = 1
            kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassConstructorDescriptorImpl r13 = kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassConstructorDescriptorImpl.create(r12, r13, r1, r10)
            java.util.List r1 = kotlin.collections.CollectionsKt.emptyList()
            kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility r2 = kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities.INTERNAL
            r13.initialize(r1, r2)
            java.lang.String r1 = "create(this, Annotations…          )\n            }"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r13, r1)
            kotlin.reflect.jvm.internal.impl.types.error.ErrorScopeKind r1 = kotlin.reflect.jvm.internal.impl.types.error.ErrorScopeKind.SCOPE_FOR_ERROR_CLASS
            kotlin.reflect.jvm.internal.impl.name.Name r2 = r13.getName()
            java.lang.String r2 = r2.toString()
            java.lang.String r3 = "errorConstructor.name.toString()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            java.lang.String r3 = ""
            java.lang.String[] r2 = new java.lang.String[]{r2, r3}
            kotlin.reflect.jvm.internal.impl.types.error.ErrorScope r1 = kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils.createErrorScope(r1, r2)
            kotlin.reflect.jvm.internal.impl.types.error.ErrorType r2 = new kotlin.reflect.jvm.internal.impl.types.error.ErrorType
            kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind r6 = kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind.ERROR_CLASS
            r3 = 0
            java.lang.String[] r4 = new java.lang.String[r3]
            kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeConstructor r4 = r0.createErrorTypeConstructor(r6, r4)
            java.lang.String[] r9 = new java.lang.String[r3]
            r10 = 24
            r11 = 0
            r7 = 0
            r3 = r2
            r5 = r1
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11)
            r13.setReturnType(r2)
            java.util.Set r0 = kotlin.collections.SetsKt.setOf(r13)
            r12.initialize(r1, r0, r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.types.error.ErrorClassDescriptor.<init>(kotlin.reflect.jvm.internal.impl.name.Name):void");
    }

    @NotNull
    public MemberScope getMemberScope(@NotNull TypeSubstitution typeSubstitution, @NotNull KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics.checkNotNullParameter(typeSubstitution, "typeSubstitution");
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        ErrorScopeKind errorScopeKind = ErrorScopeKind.SCOPE_FOR_ERROR_CLASS;
        String name = getName().toString();
        Intrinsics.checkNotNullExpressionValue(name, "name.toString()");
        return ErrorUtils.createErrorScope(errorScopeKind, name, typeSubstitution.toString());
    }

    @NotNull
    public ClassDescriptor substitute(@NotNull TypeSubstitutor typeSubstitutor) {
        Intrinsics.checkNotNullParameter(typeSubstitutor, "substitutor");
        return this;
    }

    @NotNull
    public String toString() {
        String asString = getName().asString();
        Intrinsics.checkNotNullExpressionValue(asString, "name.asString()");
        return asString;
    }
}
