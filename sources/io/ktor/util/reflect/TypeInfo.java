package io.ktor.util.reflect;

import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\b\b\u0018\u00002\u00020\u0001B+\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002\u0012\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001b\u0010\u0006\u001a\u00060\u0004j\u0002`\u00058\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0019\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u0015\u0010\u001e¨\u0006\u001f"}, d2 = {"Lio/ktor/util/reflect/TypeInfo;", "", "Lkotlin/reflect/KClass;", "type", "Ljava/lang/reflect/Type;", "Lio/ktor/util/reflect/Type;", "reifiedType", "Lkotlin/reflect/KType;", "kotlinType", "<init>", "(Lkotlin/reflect/KClass;Ljava/lang/reflect/Type;Lkotlin/reflect/KType;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "Lkotlin/reflect/KClass;", "b", "()Lkotlin/reflect/KClass;", "Ljava/lang/reflect/Type;", "getReifiedType", "()Ljava/lang/reflect/Type;", "c", "Lkotlin/reflect/KType;", "()Lkotlin/reflect/KType;", "ktor-utils"}, k = 1, mv = {1, 8, 0})
public final class TypeInfo {

    /* renamed from: a  reason: collision with root package name */
    public final KClass f9075a;
    public final Type b;
    public final KType c;

    public TypeInfo(KClass kClass, Type type, KType kType) {
        Intrinsics.checkNotNullParameter(kClass, "type");
        Intrinsics.checkNotNullParameter(type, "reifiedType");
        this.f9075a = kClass;
        this.b = type;
        this.c = kType;
    }

    public final KType a() {
        return this.c;
    }

    public final KClass b() {
        return this.f9075a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TypeInfo)) {
            return false;
        }
        TypeInfo typeInfo = (TypeInfo) obj;
        return Intrinsics.areEqual((Object) this.f9075a, (Object) typeInfo.f9075a) && Intrinsics.areEqual((Object) this.b, (Object) typeInfo.b) && Intrinsics.areEqual((Object) this.c, (Object) typeInfo.c);
    }

    public int hashCode() {
        int hashCode = ((this.f9075a.hashCode() * 31) + this.b.hashCode()) * 31;
        KType kType = this.c;
        return hashCode + (kType == null ? 0 : kType.hashCode());
    }

    public String toString() {
        return "TypeInfo(type=" + this.f9075a + ", reifiedType=" + this.b + ", kotlinType=" + this.c + ')';
    }
}
