package kotlinx.serialization.internal;

import java.util.HashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeParameter;
import kotlin.reflect.KTypeProjection;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.SerialDescriptor;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0019\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a!\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00000\u0006*\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u0005H\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a\u0017\u0010\u000b\u001a\u00020\n*\u0006\u0012\u0002\b\u00030\tH\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a\u0017\u0010\r\u001a\u00020\u0002*\u0006\u0012\u0002\b\u00030\tH\u0000¢\u0006\u0004\b\r\u0010\u000e\u001a\u0017\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u0019\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\t*\u00020\u0012H\u0000¢\u0006\u0004\b\u0014\u0010\u0015\u001a\u0013\u0010\u0017\u001a\u00020\u0012*\u00020\u0016H\u0000¢\u0006\u0004\b\u0017\u0010\u0018\"\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00000\u00068\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0019¨\u0006\u001b"}, d2 = {"Lkotlinx/serialization/descriptors/SerialDescriptor;", "", "", "a", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)Ljava/util/Set;", "", "", "b", "(Ljava/util/List;)[Lkotlinx/serialization/descriptors/SerialDescriptor;", "Lkotlin/reflect/KClass;", "", "f", "(Lkotlin/reflect/KClass;)Ljava/lang/Void;", "e", "(Lkotlin/reflect/KClass;)Ljava/lang/String;", "className", "d", "(Ljava/lang/String;)Ljava/lang/String;", "Lkotlin/reflect/KType;", "", "c", "(Lkotlin/reflect/KType;)Lkotlin/reflect/KClass;", "Lkotlin/reflect/KTypeProjection;", "g", "(Lkotlin/reflect/KTypeProjection;)Lkotlin/reflect/KType;", "[Lkotlinx/serialization/descriptors/SerialDescriptor;", "EMPTY_DESCRIPTOR_ARRAY", "kotlinx-serialization-core"}, k = 2, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nPlatform.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Platform.common.kt\nkotlinx/serialization/internal/Platform_commonKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,182:1\n1#2:183\n37#3,2:184\n1789#4,3:186\n*S KotlinDebug\n*F\n+ 1 Platform.common.kt\nkotlinx/serialization/internal/Platform_commonKt\n*L\n75#1:184,2\n159#1:186,3\n*E\n"})
public final class Platform_commonKt {

    /* renamed from: a  reason: collision with root package name */
    public static final SerialDescriptor[] f4052a = new SerialDescriptor[0];

    public static final Set a(SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "<this>");
        if (serialDescriptor instanceof CachedNames) {
            return ((CachedNames) serialDescriptor).a();
        }
        HashSet hashSet = new HashSet(serialDescriptor.e());
        int e = serialDescriptor.e();
        for (int i = 0; i < e; i++) {
            hashSet.add(serialDescriptor.f(i));
        }
        return hashSet;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x000b, code lost:
        r1 = (kotlinx.serialization.descriptors.SerialDescriptor[]) r1.toArray(new kotlinx.serialization.descriptors.SerialDescriptor[0]);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final kotlinx.serialization.descriptors.SerialDescriptor[] b(java.util.List r1) {
        /*
            if (r1 == 0) goto L_0x0008
            boolean r0 = r1.isEmpty()
            if (r0 == 0) goto L_0x0009
        L_0x0008:
            r1 = 0
        L_0x0009:
            if (r1 == 0) goto L_0x0016
            r0 = 0
            kotlinx.serialization.descriptors.SerialDescriptor[] r0 = new kotlinx.serialization.descriptors.SerialDescriptor[r0]
            java.lang.Object[] r1 = r1.toArray(r0)
            kotlinx.serialization.descriptors.SerialDescriptor[] r1 = (kotlinx.serialization.descriptors.SerialDescriptor[]) r1
            if (r1 != 0) goto L_0x0018
        L_0x0016:
            kotlinx.serialization.descriptors.SerialDescriptor[] r1 = f4052a
        L_0x0018:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.serialization.internal.Platform_commonKt.b(java.util.List):kotlinx.serialization.descriptors.SerialDescriptor[]");
    }

    public static final KClass c(KType kType) {
        Intrinsics.checkNotNullParameter(kType, "<this>");
        KClassifier classifier = kType.getClassifier();
        if (classifier instanceof KClass) {
            return (KClass) classifier;
        }
        if (classifier instanceof KTypeParameter) {
            throw new IllegalArgumentException("Captured type parameter " + classifier + " from generic non-reified function. Such functionality cannot be supported because " + classifier + " is erased, either specify serializer explicitly or make calling function inline with reified " + classifier + '.');
        }
        throw new IllegalArgumentException("Only KClass supported as classifier, got " + classifier);
    }

    public static final String d(String str) {
        Intrinsics.checkNotNullParameter(str, "className");
        return "Serializer for class '" + str + "' is not found.\nPlease ensure that class is marked as '@Serializable' and that the serialization compiler plugin is applied.\n";
    }

    public static final String e(KClass kClass) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        String simpleName = kClass.getSimpleName();
        if (simpleName == null) {
            simpleName = "<local class name not available>";
        }
        return d(simpleName);
    }

    public static final Void f(KClass kClass) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        throw new SerializationException(e(kClass));
    }

    public static final KType g(KTypeProjection kTypeProjection) {
        Intrinsics.checkNotNullParameter(kTypeProjection, "<this>");
        KType type = kTypeProjection.getType();
        if (type != null) {
            return type;
        }
        throw new IllegalArgumentException(("Star projections in type arguments are not allowed, but had " + kTypeProjection.getType()).toString());
    }
}
