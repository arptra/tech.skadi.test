package io.ktor.http;

import com.honey.account.constant.AccountConstantKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u0000 \u00122\u00020\u0001:\u0001\u0013B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\r\u0010\u000eR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0007¨\u0006\u0014"}, d2 = {"Lio/ktor/http/HttpMethod;", "", "", "value", "<init>", "(Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "Ljava/lang/String;", "c", "b", "Companion", "ktor-http"}, k = 1, mv = {1, 8, 0})
public final class HttpMethod {
    public static final Companion b = new Companion((DefaultConstructorMarker) null);
    public static final HttpMethod c;
    public static final HttpMethod d;
    public static final HttpMethod e;
    public static final HttpMethod f;
    public static final HttpMethod g;
    public static final HttpMethod h;
    public static final HttpMethod i;
    public static final List j;

    /* renamed from: a  reason: collision with root package name */
    public final String f8967a;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\t\u0010\u0006\u001a\u0004\b\n\u0010\b¨\u0006\u000b"}, d2 = {"Lio/ktor/http/HttpMethod$Companion;", "", "<init>", "()V", "Lio/ktor/http/HttpMethod;", "Get", "Lio/ktor/http/HttpMethod;", "a", "()Lio/ktor/http/HttpMethod;", "Head", "b", "ktor-http"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final HttpMethod a() {
            return HttpMethod.c;
        }

        public final HttpMethod b() {
            return HttpMethod.h;
        }

        public Companion() {
        }
    }

    static {
        HttpMethod httpMethod = new HttpMethod("GET");
        c = httpMethod;
        HttpMethod httpMethod2 = new HttpMethod("POST");
        d = httpMethod2;
        HttpMethod httpMethod3 = new HttpMethod("PUT");
        e = httpMethod3;
        HttpMethod httpMethod4 = new HttpMethod("PATCH");
        f = httpMethod4;
        HttpMethod httpMethod5 = new HttpMethod("DELETE");
        g = httpMethod5;
        HttpMethod httpMethod6 = new HttpMethod("HEAD");
        h = httpMethod6;
        HttpMethod httpMethod7 = new HttpMethod("OPTIONS");
        i = httpMethod7;
        j = CollectionsKt.listOf(httpMethod, httpMethod2, httpMethod3, httpMethod4, httpMethod5, httpMethod6, httpMethod7);
    }

    public HttpMethod(String str) {
        Intrinsics.checkNotNullParameter(str, AccountConstantKt.RESPONSE_VALUE);
        this.f8967a = str;
    }

    public final String c() {
        return this.f8967a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof HttpMethod) && Intrinsics.areEqual((Object) this.f8967a, (Object) ((HttpMethod) obj).f8967a);
    }

    public int hashCode() {
        return this.f8967a.hashCode();
    }

    public String toString() {
        return "HttpMethod(value=" + this.f8967a + ')';
    }
}
