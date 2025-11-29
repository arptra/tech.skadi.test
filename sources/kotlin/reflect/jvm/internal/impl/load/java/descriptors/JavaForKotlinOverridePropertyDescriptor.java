package kotlin.reflect.jvm.internal.impl.load.java.descriptors;

import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class JavaForKotlinOverridePropertyDescriptor extends JavaPropertyDescriptor {
    @NotNull
    private final SimpleFunctionDescriptor getterMethod;
    @NotNull
    private final PropertyDescriptor overriddenProperty;
    @Nullable
    private final SimpleFunctionDescriptor setterMethod;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public JavaForKotlinOverridePropertyDescriptor(@org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r17, @org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor r18, @org.jetbrains.annotations.Nullable kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor r19, @org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor r20) {
        /*
            r16 = this;
            r12 = r16
            r13 = r18
            r14 = r19
            r15 = r20
            java.lang.String r0 = "ownerDescriptor"
            r1 = r17
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            java.lang.String r0 = "getterMethod"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            java.lang.String r0 = "overriddenProperty"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations$Companion r0 = kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations r2 = r0.getEMPTY()
            kotlin.reflect.jvm.internal.impl.descriptors.Modality r3 = r18.getModality()
            kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility r4 = r18.getVisibility()
            if (r14 == 0) goto L_0x002c
            r0 = 1
        L_0x002a:
            r5 = r0
            goto L_0x002e
        L_0x002c:
            r0 = 0
            goto L_0x002a
        L_0x002e:
            kotlin.reflect.jvm.internal.impl.name.Name r6 = r20.getName()
            kotlin.reflect.jvm.internal.impl.descriptors.SourceElement r7 = r18.getSource()
            kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor$Kind r9 = kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind.DECLARATION
            r10 = 0
            r11 = 0
            r8 = 0
            r0 = r16
            r1 = r17
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            r12.getterMethod = r13
            r12.setterMethod = r14
            r12.overriddenProperty = r15
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaForKotlinOverridePropertyDescriptor.<init>(kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor):void");
    }
}
