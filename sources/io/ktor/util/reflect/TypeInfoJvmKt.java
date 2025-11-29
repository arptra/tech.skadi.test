package io.ktor.util.reflect;

import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u001a/\u0010\b\u001a\u00020\u00072\n\u0010\u0002\u001a\u00060\u0000j\u0002`\u00012\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\t\u001a\u001d\u0010\r\u001a\u00020\f*\u00020\n2\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\u0004\b\r\u0010\u000e*\n\u0010\u000f\"\u00020\u00002\u00020\u0000¨\u0006\u0010"}, d2 = {"Ljava/lang/reflect/Type;", "Lio/ktor/util/reflect/Type;", "reifiedType", "Lkotlin/reflect/KClass;", "kClass", "Lkotlin/reflect/KType;", "kType", "Lio/ktor/util/reflect/TypeInfo;", "b", "(Ljava/lang/reflect/Type;Lkotlin/reflect/KClass;Lkotlin/reflect/KType;)Lio/ktor/util/reflect/TypeInfo;", "", "type", "", "a", "(Ljava/lang/Object;Lkotlin/reflect/KClass;)Z", "Type", "ktor-utils"}, k = 2, mv = {1, 8, 0})
public final class TypeInfoJvmKt {
    public static final boolean a(Object obj, KClass kClass) {
        Intrinsics.checkNotNullParameter(obj, "<this>");
        Intrinsics.checkNotNullParameter(kClass, "type");
        return JvmClassMappingKt.getJavaClass(kClass).isInstance(obj);
    }

    public static final TypeInfo b(Type type, KClass kClass, KType kType) {
        Intrinsics.checkNotNullParameter(type, "reifiedType");
        Intrinsics.checkNotNullParameter(kClass, "kClass");
        return new TypeInfo(kClass, type, kType);
    }
}
