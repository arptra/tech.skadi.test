package io.ktor.http;

import com.upuphone.runasone.api.ApiConstant;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b3\u0018\u0000 @2\u00020\u0001:\u0001ABc\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\u0004\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u0004¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0017\u001a\u00020\u000f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0019\u0010\u001aR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\u0015R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010\u001aR\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\b8\u0006¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u0017\u0010\u000b\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\u0017\u0010\f\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b-\u0010 \u001a\u0004\b.\u0010\u0015R\u0019\u0010\r\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b!\u0010 \u001a\u0004\b/\u0010\u0015R\u0019\u0010\u000e\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b0\u0010 \u001a\u0004\b0\u0010\u0015R\u0017\u0010\u0010\u001a\u00020\u000f8\u0006¢\u0006\f\n\u0004\b'\u00101\u001a\u0004\b2\u00103R\u0014\u0010\u0011\u001a\u00020\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b4\u0010 R\u001b\u00106\u001a\u00020\u00048FX\u0002¢\u0006\f\n\u0004\b\u001d\u00105\u001a\u0004\b%\u0010\u0015R\u001b\u00107\u001a\u00020\u00048FX\u0002¢\u0006\f\n\u0004\b$\u00105\u001a\u0004\b)\u0010\u0015R\u001b\u00109\u001a\u00020\u00048FX\u0002¢\u0006\f\n\u0004\b2\u00105\u001a\u0004\b8\u0010\u0015R\u001d\u0010:\u001a\u0004\u0018\u00010\u00048FX\u0002¢\u0006\f\n\u0004\b/\u00105\u001a\u0004\b-\u0010\u0015R\u001d\u0010<\u001a\u0004\u0018\u00010\u00048FX\u0002¢\u0006\f\n\u0004\b;\u00105\u001a\u0004\b\"\u0010\u0015R\u001b\u0010>\u001a\u00020\u00048FX\u0002¢\u0006\f\n\u0004\b=\u00105\u001a\u0004\b\u001f\u0010\u0015R\u0011\u0010?\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b4\u0010\u001a¨\u0006B"}, d2 = {"Lio/ktor/http/Url;", "", "Lio/ktor/http/URLProtocol;", "protocol", "", "host", "", "specifiedPort", "", "pathSegments", "Lio/ktor/http/Parameters;", "parameters", "fragment", "user", "password", "", "trailingQuery", "urlString", "<init>", "(Lio/ktor/http/URLProtocol;Ljava/lang/String;ILjava/util/List;Lio/ktor/http/Parameters;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V", "toString", "()Ljava/lang/String;", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "a", "Lio/ktor/http/URLProtocol;", "k", "()Lio/ktor/http/URLProtocol;", "b", "Ljava/lang/String;", "g", "c", "I", "l", "d", "Ljava/util/List;", "i", "()Ljava/util/List;", "e", "Lio/ktor/http/Parameters;", "getParameters", "()Lio/ktor/http/Parameters;", "f", "getFragment", "n", "h", "Z", "m", "()Z", "j", "Lkotlin/Lazy;", "encodedPath", "encodedQuery", "getEncodedPathAndQuery", "encodedPathAndQuery", "encodedUser", "o", "encodedPassword", "p", "encodedFragment", "port", "q", "Companion", "ktor-http"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nUrl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Url.kt\nio/ktor/http/Url\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,174:1\n1#2:175\n*E\n"})
public final class Url {
    public static final Companion q = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public final URLProtocol f8980a;
    public final String b;
    public final int c;
    public final List d;
    public final Parameters e;
    public final String f;
    public final String g;
    public final String h;
    public final boolean i;
    public final String j;
    public final Lazy k;
    public final Lazy l;
    public final Lazy m;
    public final Lazy n;
    public final Lazy o;
    public final Lazy p;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lio/ktor/http/Url$Companion;", "", "()V", "ktor-http"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public Url(URLProtocol uRLProtocol, String str, int i2, List list, Parameters parameters, String str2, String str3, String str4, boolean z, String str5) {
        Intrinsics.checkNotNullParameter(uRLProtocol, "protocol");
        Intrinsics.checkNotNullParameter(str, ApiConstant.VALUE_HOST);
        Intrinsics.checkNotNullParameter(list, "pathSegments");
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        Intrinsics.checkNotNullParameter(str2, "fragment");
        Intrinsics.checkNotNullParameter(str5, "urlString");
        this.f8980a = uRLProtocol;
        this.b = str;
        this.c = i2;
        this.d = list;
        this.e = parameters;
        this.f = str2;
        this.g = str3;
        this.h = str4;
        this.i = z;
        this.j = str5;
        if ((i2 < 0 || i2 >= 65536) && i2 != 0) {
            throw new IllegalArgumentException("port must be between 0 and 65535, or 0 if not set".toString());
        }
        this.k = LazyKt.lazy(new Url$encodedPath$2(this));
        this.l = LazyKt.lazy(new Url$encodedQuery$2(this));
        this.m = LazyKt.lazy(new Url$encodedPathAndQuery$2(this));
        this.n = LazyKt.lazy(new Url$encodedUser$2(this));
        this.o = LazyKt.lazy(new Url$encodedPassword$2(this));
        this.p = LazyKt.lazy(new Url$encodedFragment$2(this));
    }

    public final String b() {
        return (String) this.p.getValue();
    }

    public final String c() {
        return (String) this.o.getValue();
    }

    public final String d() {
        return (String) this.k.getValue();
    }

    public final String e() {
        return (String) this.l.getValue();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && Url.class == obj.getClass() && Intrinsics.areEqual((Object) this.j, (Object) ((Url) obj).j);
    }

    public final String f() {
        return (String) this.n.getValue();
    }

    public final String g() {
        return this.b;
    }

    public final String h() {
        return this.h;
    }

    public int hashCode() {
        return this.j.hashCode();
    }

    public final List i() {
        return this.d;
    }

    public final int j() {
        Integer valueOf = Integer.valueOf(this.c);
        if (valueOf.intValue() == 0) {
            valueOf = null;
        }
        return valueOf != null ? valueOf.intValue() : this.f8980a.e();
    }

    public final URLProtocol k() {
        return this.f8980a;
    }

    public final int l() {
        return this.c;
    }

    public final boolean m() {
        return this.i;
    }

    public final String n() {
        return this.g;
    }

    public String toString() {
        return this.j;
    }
}
