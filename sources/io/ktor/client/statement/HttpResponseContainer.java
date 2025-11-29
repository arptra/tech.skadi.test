package io.ktor.client.statement;

import io.ktor.util.reflect.TypeInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0001HÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0015\u001a\u0004\b\u0016\u0010\bR\u0017\u0010\u0004\u001a\u00020\u00018\u0006¢\u0006\f\n\u0004\b\t\u0010\u0017\u001a\u0004\b\u0018\u0010\n¨\u0006\u0019"}, d2 = {"Lio/ktor/client/statement/HttpResponseContainer;", "", "Lio/ktor/util/reflect/TypeInfo;", "expectedType", "response", "<init>", "(Lio/ktor/util/reflect/TypeInfo;Ljava/lang/Object;)V", "a", "()Lio/ktor/util/reflect/TypeInfo;", "b", "()Ljava/lang/Object;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lio/ktor/util/reflect/TypeInfo;", "getExpectedType", "Ljava/lang/Object;", "c", "ktor-client-core"}, k = 1, mv = {1, 8, 0})
public final class HttpResponseContainer {

    /* renamed from: a  reason: collision with root package name */
    public final TypeInfo f8926a;
    public final Object b;

    public HttpResponseContainer(TypeInfo typeInfo, Object obj) {
        Intrinsics.checkNotNullParameter(typeInfo, "expectedType");
        Intrinsics.checkNotNullParameter(obj, "response");
        this.f8926a = typeInfo;
        this.b = obj;
    }

    public final TypeInfo a() {
        return this.f8926a;
    }

    public final Object b() {
        return this.b;
    }

    public final Object c() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HttpResponseContainer)) {
            return false;
        }
        HttpResponseContainer httpResponseContainer = (HttpResponseContainer) obj;
        return Intrinsics.areEqual((Object) this.f8926a, (Object) httpResponseContainer.f8926a) && Intrinsics.areEqual(this.b, httpResponseContainer.b);
    }

    public int hashCode() {
        return (this.f8926a.hashCode() * 31) + this.b.hashCode();
    }

    public String toString() {
        return "HttpResponseContainer(expectedType=" + this.f8926a + ", response=" + this.b + ')';
    }
}
