package kotlin.reflect.jvm.internal.calls;

import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nInlineClassAwareCaller.kt\nKotlin\n*S Kotlin\n*F\n+ 1 InlineClassAwareCaller.kt\nkotlin/reflect/jvm/internal/calls/InlineClassAwareCaller\n+ 2 ArrayIntrinsics.kt\nkotlin/ArrayIntrinsicsKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,219:1\n26#2:220\n1620#3,3:221\n*S KotlinDebug\n*F\n+ 1 InlineClassAwareCaller.kt\nkotlin/reflect/jvm/internal/calls/InlineClassAwareCaller\n*L\n53#1:220\n94#1:221,3\n*E\n"})
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0000\u0018\u0000*\f\b\u0000\u0010\u0001 \u0001*\u0004\u0018\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0001\u001cB#\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u001b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\u0010\u0019\u001a\u0006\u0012\u0002\b\u00030\u001aH\u0016¢\u0006\u0002\u0010\u001bR\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00028\u00008VX\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108VX\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u00118VX\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001d"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/InlineClassAwareCaller;", "M", "Ljava/lang/reflect/Member;", "Lkotlin/reflect/jvm/internal/calls/Caller;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;", "caller", "isDefault", "", "(Lorg/jetbrains/kotlin/descriptors/CallableMemberDescriptor;Lkotlin/reflect/jvm/internal/calls/Caller;Z)V", "data", "Lkotlin/reflect/jvm/internal/calls/InlineClassAwareCaller$BoxUnboxData;", "member", "getMember", "()Ljava/lang/reflect/Member;", "parameterTypes", "", "Ljava/lang/reflect/Type;", "getParameterTypes", "()Ljava/util/List;", "returnType", "getReturnType", "()Ljava/lang/reflect/Type;", "call", "", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "BoxUnboxData", "kotlin-reflection"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class InlineClassAwareCaller<M extends Member> implements Caller<M> {
    @NotNull
    private final Caller<M> caller;
    @NotNull
    private final BoxUnboxData data;
    private final boolean isDefault;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\r\b\u0002\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\bJ\t\u0010\u0010\u001a\u00020\u0003H\u0002J\u0016\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005H\u0002¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0006H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0013"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/InlineClassAwareCaller$BoxUnboxData;", "", "argumentRange", "Lkotlin/ranges/IntRange;", "unbox", "", "Ljava/lang/reflect/Method;", "box", "(Lkotlin/ranges/IntRange;[Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;)V", "getArgumentRange", "()Lkotlin/ranges/IntRange;", "getBox", "()Ljava/lang/reflect/Method;", "getUnbox", "()[Ljava/lang/reflect/Method;", "[Ljava/lang/reflect/Method;", "component1", "component2", "component3", "kotlin-reflection"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class BoxUnboxData {
        @NotNull
        private final IntRange argumentRange;
        @Nullable
        private final Method box;
        @NotNull
        private final Method[] unbox;

        public BoxUnboxData(@NotNull IntRange intRange, @NotNull Method[] methodArr, @Nullable Method method) {
            Intrinsics.checkNotNullParameter(intRange, "argumentRange");
            Intrinsics.checkNotNullParameter(methodArr, "unbox");
            this.argumentRange = intRange;
            this.unbox = methodArr;
            this.box = method;
        }

        @NotNull
        public final IntRange component1() {
            return this.argumentRange;
        }

        @NotNull
        public final Method[] component2() {
            return this.unbox;
        }

        @Nullable
        public final Method component3() {
            return this.box;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x004a, code lost:
        if ((r10 instanceof kotlin.reflect.jvm.internal.calls.BoundCaller) != false) goto L_0x0068;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public InlineClassAwareCaller(@org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor r9, @org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.calls.Caller<? extends M> r10, boolean r11) {
        /*
            r8 = this;
            java.lang.String r0 = "descriptor"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "caller"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            r8.<init>()
            r8.caller = r10
            r8.isDefault = r11
            kotlin.reflect.jvm.internal.impl.types.KotlinType r11 = r9.getReturnType()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r11)
            java.lang.Class r11 = kotlin.reflect.jvm.internal.calls.InlineClassAwareCallerKt.toInlineClass((kotlin.reflect.jvm.internal.impl.types.KotlinType) r11)
            r0 = 0
            if (r11 == 0) goto L_0x0024
            java.lang.reflect.Method r11 = kotlin.reflect.jvm.internal.calls.InlineClassAwareCallerKt.getBoxMethod(r11, r9)
            goto L_0x0025
        L_0x0024:
            r11 = r0
        L_0x0025:
            boolean r1 = kotlin.reflect.jvm.internal.impl.resolve.InlineClassesUtilsKt.isGetterOfUnderlyingPropertyOfInlineClass(r9)
            r2 = 0
            if (r1 == 0) goto L_0x003b
            kotlin.reflect.jvm.internal.calls.InlineClassAwareCaller$BoxUnboxData r9 = new kotlin.reflect.jvm.internal.calls.InlineClassAwareCaller$BoxUnboxData
            kotlin.ranges.IntRange$Companion r10 = kotlin.ranges.IntRange.Companion
            kotlin.ranges.IntRange r10 = r10.getEMPTY()
            java.lang.reflect.Method[] r0 = new java.lang.reflect.Method[r2]
            r9.<init>(r10, r0, r11)
            goto L_0x0149
        L_0x003b:
            boolean r1 = r10 instanceof kotlin.reflect.jvm.internal.calls.CallerImpl.Method.BoundStatic
            java.lang.String r3 = "descriptor.containingDeclaration"
            r4 = -1
            r5 = 1
            if (r1 == 0) goto L_0x0044
            goto L_0x0068
        L_0x0044:
            boolean r1 = r9 instanceof kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor
            if (r1 == 0) goto L_0x004f
            boolean r10 = r10 instanceof kotlin.reflect.jvm.internal.calls.BoundCaller
            if (r10 == 0) goto L_0x004d
            goto L_0x0068
        L_0x004d:
            r4 = r2
            goto L_0x0068
        L_0x004f:
            kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor r1 = r9.getDispatchReceiverParameter()
            if (r1 == 0) goto L_0x004d
            boolean r10 = r10 instanceof kotlin.reflect.jvm.internal.calls.BoundCaller
            if (r10 != 0) goto L_0x004d
            kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r10 = r9.getContainingDeclaration()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r3)
            boolean r10 = kotlin.reflect.jvm.internal.impl.resolve.InlineClassesUtilsKt.isInlineClass(r10)
            if (r10 == 0) goto L_0x0067
            goto L_0x004d
        L_0x0067:
            r4 = r5
        L_0x0068:
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>()
            kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor r1 = r9.getExtensionReceiverParameter()
            if (r1 == 0) goto L_0x0078
            kotlin.reflect.jvm.internal.impl.types.KotlinType r1 = r1.getType()
            goto L_0x0079
        L_0x0078:
            r1 = r0
        L_0x0079:
            if (r1 == 0) goto L_0x007f
            r10.add(r1)
            goto L_0x00c2
        L_0x007f:
            boolean r1 = r9 instanceof kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor
            if (r1 == 0) goto L_0x00a8
            r1 = r9
            kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor r1 = (kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor) r1
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r1 = r1.getConstructedClass()
            java.lang.String r3 = "descriptor.constructedClass"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r3)
            boolean r3 = r1.isInner()
            if (r3 == 0) goto L_0x00c2
            kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r1 = r1.getContainingDeclaration()
            java.lang.String r3 = "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1, r3)
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r1 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) r1
            kotlin.reflect.jvm.internal.impl.types.SimpleType r1 = r1.getDefaultType()
            r10.add(r1)
            goto L_0x00c2
        L_0x00a8:
            kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r1 = r9.getContainingDeclaration()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r3)
            boolean r3 = r1 instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
            if (r3 == 0) goto L_0x00c2
            boolean r3 = kotlin.reflect.jvm.internal.impl.resolve.InlineClassesUtilsKt.isInlineClass(r1)
            if (r3 == 0) goto L_0x00c2
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r1 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) r1
            kotlin.reflect.jvm.internal.impl.types.SimpleType r1 = r1.getDefaultType()
            r10.add(r1)
        L_0x00c2:
            java.util.List r1 = r9.getValueParameters()
            java.lang.String r3 = "descriptor.valueParameters"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r3)
            java.util.Iterator r1 = r1.iterator()
        L_0x00cf:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x00e3
            java.lang.Object r3 = r1.next()
            kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor r3 = (kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor) r3
            kotlin.reflect.jvm.internal.impl.types.KotlinType r3 = r3.getType()
            r10.add(r3)
            goto L_0x00cf
        L_0x00e3:
            boolean r1 = r8.isDefault
            if (r1 == 0) goto L_0x00f1
            int r1 = r10.size()
            int r1 = r1 + 31
            int r1 = r1 / 32
            int r1 = r1 + r5
            goto L_0x00f2
        L_0x00f1:
            r1 = r2
        L_0x00f2:
            boolean r3 = r9 instanceof kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor
            if (r3 == 0) goto L_0x0100
            r3 = r9
            kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor r3 = (kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor) r3
            boolean r3 = r3.isSuspend()
            if (r3 == 0) goto L_0x0100
            goto L_0x0101
        L_0x0100:
            r5 = r2
        L_0x0101:
            int r1 = r1 + r5
            int r3 = r10.size()
            int r3 = r3 + r4
            int r3 = r3 + r1
            int r1 = kotlin.reflect.jvm.internal.calls.CallerKt.getArity(r8)
            if (r1 != r3) goto L_0x014c
            int r1 = java.lang.Math.max(r4, r2)
            int r5 = r10.size()
            int r5 = r5 + r4
            kotlin.ranges.IntRange r1 = kotlin.ranges.RangesKt.until((int) r1, (int) r5)
            java.lang.reflect.Method[] r5 = new java.lang.reflect.Method[r3]
        L_0x011d:
            if (r2 >= r3) goto L_0x0144
            int r6 = r1.getFirst()
            int r7 = r1.getLast()
            if (r2 > r7) goto L_0x013e
            if (r6 > r2) goto L_0x013e
            int r6 = r2 - r4
            java.lang.Object r6 = r10.get(r6)
            kotlin.reflect.jvm.internal.impl.types.KotlinType r6 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r6
            java.lang.Class r6 = kotlin.reflect.jvm.internal.calls.InlineClassAwareCallerKt.toInlineClass((kotlin.reflect.jvm.internal.impl.types.KotlinType) r6)
            if (r6 == 0) goto L_0x013e
            java.lang.reflect.Method r6 = kotlin.reflect.jvm.internal.calls.InlineClassAwareCallerKt.getUnboxMethod(r6, r9)
            goto L_0x013f
        L_0x013e:
            r6 = r0
        L_0x013f:
            r5[r2] = r6
            int r2 = r2 + 1
            goto L_0x011d
        L_0x0144:
            kotlin.reflect.jvm.internal.calls.InlineClassAwareCaller$BoxUnboxData r9 = new kotlin.reflect.jvm.internal.calls.InlineClassAwareCaller$BoxUnboxData
            r9.<init>(r1, r5, r11)
        L_0x0149:
            r8.data = r9
            return
        L_0x014c:
            kotlin.reflect.jvm.internal.KotlinReflectionInternalError r10 = new kotlin.reflect.jvm.internal.KotlinReflectionInternalError
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r0 = "Inconsistent number of parameters in the descriptor and Java reflection object: "
            r11.append(r0)
            int r0 = kotlin.reflect.jvm.internal.calls.CallerKt.getArity(r8)
            r11.append(r0)
            java.lang.String r0 = " != "
            r11.append(r0)
            r11.append(r3)
            java.lang.String r0 = "\nCalling: "
            r11.append(r0)
            r11.append(r9)
            java.lang.String r9 = "\nParameter types: "
            r11.append(r9)
            java.util.List r9 = r8.getParameterTypes()
            r11.append(r9)
            java.lang.String r9 = ")\nDefault: "
            r11.append(r9)
            boolean r8 = r8.isDefault
            r11.append(r8)
            java.lang.String r8 = r11.toString()
            r10.<init>(r8)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.calls.InlineClassAwareCaller.<init>(kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor, kotlin.reflect.jvm.internal.calls.Caller, boolean):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0051, code lost:
        r9 = r0.invoke((java.lang.Object) null, new java.lang.Object[]{r8});
     */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object call(@org.jetbrains.annotations.NotNull java.lang.Object[] r9) {
        /*
            r8 = this;
            java.lang.String r0 = "args"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            kotlin.reflect.jvm.internal.calls.InlineClassAwareCaller$BoxUnboxData r0 = r8.data
            kotlin.ranges.IntRange r1 = r0.component1()
            java.lang.reflect.Method[] r2 = r0.component2()
            java.lang.reflect.Method r0 = r0.component3()
            int r3 = r9.length
            java.lang.Object[] r3 = java.util.Arrays.copyOf(r9, r3)
            java.lang.String r4 = "copyOf(this, size)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            int r4 = r1.getFirst()
            int r1 = r1.getLast()
            r5 = 0
            if (r4 > r1) goto L_0x0049
        L_0x0028:
            r6 = r2[r4]
            r7 = r9[r4]
            if (r6 == 0) goto L_0x0042
            if (r7 == 0) goto L_0x0035
            java.lang.Object r7 = r6.invoke(r7, r5)
            goto L_0x0042
        L_0x0035:
            java.lang.Class r6 = r6.getReturnType()
            java.lang.String r7 = "method.returnType"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r7)
            java.lang.Object r7 = kotlin.reflect.jvm.internal.UtilKt.defaultPrimitiveValue(r6)
        L_0x0042:
            r3[r4] = r7
            if (r4 == r1) goto L_0x0049
            int r4 = r4 + 1
            goto L_0x0028
        L_0x0049:
            kotlin.reflect.jvm.internal.calls.Caller<M> r8 = r8.caller
            java.lang.Object r8 = r8.call(r3)
            if (r0 == 0) goto L_0x005d
            java.lang.Object[] r9 = new java.lang.Object[]{r8}
            java.lang.Object r9 = r0.invoke(r5, r9)
            if (r9 != 0) goto L_0x005c
            goto L_0x005d
        L_0x005c:
            r8 = r9
        L_0x005d:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.calls.InlineClassAwareCaller.call(java.lang.Object[]):java.lang.Object");
    }

    public M getMember() {
        return this.caller.getMember();
    }

    @NotNull
    public List<Type> getParameterTypes() {
        return this.caller.getParameterTypes();
    }

    @NotNull
    public Type getReturnType() {
        return this.caller.getReturnType();
    }
}
