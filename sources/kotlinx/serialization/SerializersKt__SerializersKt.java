package kotlinx.serialization;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.Triple;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.HashMapSerializer;
import kotlinx.serialization.internal.HashSetSerializer;
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.LinkedHashSetSerializer;
import kotlinx.serialization.internal.PlatformKt;
import kotlinx.serialization.internal.Platform_commonKt;
import kotlinx.serialization.internal.PrimitivesKt;
import kotlinx.serialization.modules.SerializersModule;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u001a!\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0005\u0010\u0006\u001a#\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0007\u0010\u0006\u001a-\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\n\u0010\u000b\u001a9\u0010\u000e\u001a\u0012\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003\u0018\u00010\f*\u00020\u00002\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\f2\u0006\u0010\t\u001a\u00020\bH\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001a+\u0010\u0012\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0003\"\b\b\u0000\u0010\u0010*\u00020\u0004*\b\u0012\u0004\u0012\u00028\u00000\u0011H\u0007¢\u0006\u0004\b\u0012\u0010\u0013\u001aI\u0010\u0018\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0004\u0018\u00010\u0003*\b\u0012\u0004\u0012\u00020\u00040\u00112\u0014\u0010\u0014\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00030\f2\u000e\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u0015H\u0000¢\u0006\u0004\b\u0018\u0010\u0019\u001a9\u0010\u001a\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0004\u0018\u00010\u0003*\b\u0012\u0004\u0012\u00020\u00040\u00112\u0014\u0010\u0014\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00030\fH\u0002¢\u0006\u0004\b\u001a\u0010\u001b\u001aI\u0010\u001c\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0004\u0018\u00010\u0003*\b\u0012\u0004\u0012\u00020\u00040\u00112\u0014\u0010\u0014\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00030\f2\u000e\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u0015H\u0002¢\u0006\u0004\b\u001c\u0010\u0019\u001a3\u0010\u001e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0003\"\b\b\u0000\u0010\u0010*\u00020\u0004*\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u001d\u001a\u00020\bH\u0002¢\u0006\u0004\b\u001e\u0010\u001f¨\u0006 "}, d2 = {"Lkotlinx/serialization/modules/SerializersModule;", "Lkotlin/reflect/KType;", "type", "Lkotlinx/serialization/KSerializer;", "", "e", "(Lkotlinx/serialization/modules/SerializersModule;Lkotlin/reflect/KType;)Lkotlinx/serialization/KSerializer;", "h", "", "failOnMissingTypeArgSerializer", "f", "(Lkotlinx/serialization/modules/SerializersModule;Lkotlin/reflect/KType;Z)Lkotlinx/serialization/KSerializer;", "", "typeArguments", "i", "(Lkotlinx/serialization/modules/SerializersModule;Ljava/util/List;Z)Ljava/util/List;", "T", "Lkotlin/reflect/KClass;", "g", "(Lkotlin/reflect/KClass;)Lkotlinx/serialization/KSerializer;", "serializers", "Lkotlin/Function0;", "Lkotlin/reflect/KClassifier;", "elementClassifierIfArray", "d", "(Lkotlin/reflect/KClass;Ljava/util/List;Lkotlin/jvm/functions/Function0;)Lkotlinx/serialization/KSerializer;", "b", "(Lkotlin/reflect/KClass;Ljava/util/List;)Lkotlinx/serialization/KSerializer;", "a", "shouldBeNullable", "c", "(Lkotlinx/serialization/KSerializer;Z)Lkotlinx/serialization/KSerializer;", "kotlinx-serialization-core"}, k = 5, mv = {1, 9, 0}, xs = "kotlinx/serialization/SerializersKt")
@SourceDebugExtension({"SMAP\nSerializers.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Serializers.kt\nkotlinx/serialization/SerializersKt__SerializersKt\n+ 2 Platform.common.kt\nkotlinx/serialization/internal/Platform_commonKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 5 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,379:1\n79#2:380\n79#2:381\n79#2:387\n79#2:388\n1549#3:382\n1620#3,3:383\n1549#3:389\n1620#3,3:390\n1549#3:393\n1620#3,3:394\n1#4:386\n37#5,2:397\n*S KotlinDebug\n*F\n+ 1 Serializers.kt\nkotlinx/serialization/SerializersKt__SerializersKt\n*L\n35#1:380\n54#1:381\n211#1:387\n235#1:388\n190#1:382\n190#1:383,3\n246#1:389\n246#1:390,3\n248#1:393\n248#1:394,3\n313#1:397,2\n*E\n"})
final /* synthetic */ class SerializersKt__SerializersKt {
    public static final KSerializer a(KClass kClass, List list, Function0 function0) {
        Class<List> cls = List.class;
        if (Intrinsics.areEqual((Object) kClass, (Object) Reflection.getOrCreateKotlinClass(Collection.class)) ? true : Intrinsics.areEqual((Object) kClass, (Object) Reflection.getOrCreateKotlinClass(cls)) ? true : Intrinsics.areEqual((Object) kClass, (Object) Reflection.getOrCreateKotlinClass(cls)) ? true : Intrinsics.areEqual((Object) kClass, (Object) Reflection.getOrCreateKotlinClass(ArrayList.class))) {
            return new ArrayListSerializer((KSerializer) list.get(0));
        }
        if (Intrinsics.areEqual((Object) kClass, (Object) Reflection.getOrCreateKotlinClass(HashSet.class))) {
            return new HashSetSerializer((KSerializer) list.get(0));
        }
        Class<Set> cls2 = Set.class;
        if (Intrinsics.areEqual((Object) kClass, (Object) Reflection.getOrCreateKotlinClass(cls2)) ? true : Intrinsics.areEqual((Object) kClass, (Object) Reflection.getOrCreateKotlinClass(cls2)) ? true : Intrinsics.areEqual((Object) kClass, (Object) Reflection.getOrCreateKotlinClass(LinkedHashSet.class))) {
            return new LinkedHashSetSerializer((KSerializer) list.get(0));
        }
        if (Intrinsics.areEqual((Object) kClass, (Object) Reflection.getOrCreateKotlinClass(HashMap.class))) {
            return new HashMapSerializer((KSerializer) list.get(0), (KSerializer) list.get(1));
        }
        Class<Map> cls3 = Map.class;
        if (Intrinsics.areEqual((Object) kClass, (Object) Reflection.getOrCreateKotlinClass(cls3)) ? true : Intrinsics.areEqual((Object) kClass, (Object) Reflection.getOrCreateKotlinClass(cls3)) ? true : Intrinsics.areEqual((Object) kClass, (Object) Reflection.getOrCreateKotlinClass(LinkedHashMap.class))) {
            return new LinkedHashMapSerializer((KSerializer) list.get(0), (KSerializer) list.get(1));
        }
        if (Intrinsics.areEqual((Object) kClass, (Object) Reflection.getOrCreateKotlinClass(Map.Entry.class))) {
            return BuiltinSerializersKt.j((KSerializer) list.get(0), (KSerializer) list.get(1));
        }
        if (Intrinsics.areEqual((Object) kClass, (Object) Reflection.getOrCreateKotlinClass(Pair.class))) {
            return BuiltinSerializersKt.m((KSerializer) list.get(0), (KSerializer) list.get(1));
        }
        if (Intrinsics.areEqual((Object) kClass, (Object) Reflection.getOrCreateKotlinClass(Triple.class))) {
            return BuiltinSerializersKt.o((KSerializer) list.get(0), (KSerializer) list.get(1), (KSerializer) list.get(2));
        }
        if (!PlatformKt.n(kClass)) {
            return null;
        }
        Object invoke = function0.invoke();
        Intrinsics.checkNotNull(invoke, "null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>");
        return BuiltinSerializersKt.a((KClass) invoke, (KSerializer) list.get(0));
    }

    public static final KSerializer b(KClass kClass, List list) {
        KSerializer[] kSerializerArr = (KSerializer[]) list.toArray(new KSerializer[0]);
        return PlatformKt.d(kClass, (KSerializer[]) Arrays.copyOf(kSerializerArr, kSerializerArr.length));
    }

    public static final KSerializer c(KSerializer kSerializer, boolean z) {
        if (z) {
            return BuiltinSerializersKt.t(kSerializer);
        }
        Intrinsics.checkNotNull(kSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.SerializersKt__SerializersKt.nullable?>");
        return kSerializer;
    }

    public static final KSerializer d(KClass kClass, List list, Function0 function0) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        Intrinsics.checkNotNullParameter(list, "serializers");
        Intrinsics.checkNotNullParameter(function0, "elementClassifierIfArray");
        KSerializer a2 = a(kClass, list, function0);
        return a2 == null ? b(kClass, list) : a2;
    }

    public static final KSerializer e(SerializersModule serializersModule, KType kType) {
        Intrinsics.checkNotNullParameter(serializersModule, "<this>");
        Intrinsics.checkNotNullParameter(kType, "type");
        KSerializer f = f(serializersModule, kType, true);
        if (f != null) {
            return f;
        }
        PlatformKt.o(Platform_commonKt.c(kType));
        throw new KotlinNothingValueException();
    }

    public static final KSerializer f(SerializersModule serializersModule, KType kType, boolean z) {
        KSerializer kSerializer;
        KSerializer kSerializer2;
        KClass c = Platform_commonKt.c(kType);
        boolean isMarkedNullable = kType.isMarkedNullable();
        List<KTypeProjection> arguments = kType.getArguments();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(arguments, 10));
        for (KTypeProjection g : arguments) {
            arrayList.add(Platform_commonKt.g(g));
        }
        if (arrayList.isEmpty()) {
            kSerializer = SerializersCacheKt.a(c, isMarkedNullable);
        } else {
            Object b = SerializersCacheKt.b(c, arrayList, isMarkedNullable);
            if (Result.m26isFailureimpl(b)) {
                b = null;
            }
            kSerializer = (KSerializer) b;
        }
        if (kSerializer != null) {
            return kSerializer;
        }
        if (arrayList.isEmpty()) {
            kSerializer2 = SerializersModule.b(serializersModule, c, (List) null, 2, (Object) null);
        } else {
            List e = SerializersKt.e(serializersModule, arrayList, z);
            if (e == null) {
                return null;
            }
            KSerializer a2 = SerializersKt.a(c, e, new SerializersKt__SerializersKt$serializerByKTypeImpl$contextualSerializer$1(arrayList));
            kSerializer2 = a2 == null ? serializersModule.a(c, e) : a2;
        }
        if (kSerializer2 != null) {
            return c(kSerializer2, isMarkedNullable);
        }
        return null;
    }

    public static final KSerializer g(KClass kClass) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        KSerializer b = PlatformKt.b(kClass);
        return b == null ? PrimitivesKt.b(kClass) : b;
    }

    public static final KSerializer h(SerializersModule serializersModule, KType kType) {
        Intrinsics.checkNotNullParameter(serializersModule, "<this>");
        Intrinsics.checkNotNullParameter(kType, "type");
        return f(serializersModule, kType, false);
    }

    public static final List i(SerializersModule serializersModule, List list, boolean z) {
        ArrayList arrayList;
        Intrinsics.checkNotNullParameter(serializersModule, "<this>");
        Intrinsics.checkNotNullParameter(list, "typeArguments");
        if (z) {
            arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(SerializersKt.b(serializersModule, (KType) it.next()));
            }
        } else {
            arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                KSerializer d = SerializersKt.d(serializersModule, (KType) it2.next());
                if (d == null) {
                    return null;
                }
                arrayList.add(d);
            }
        }
        return arrayList;
    }
}
