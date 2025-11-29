package io.ktor.http;

import com.honey.account.constant.AccountConstantKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\r\b\b\u0018\u0000 \u00192\u00020\u0001:\u0001\u001aB\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\nR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\fR\u0017\u0010\u0006\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0015\u001a\u0004\b\u0018\u0010\f¨\u0006\u001b"}, d2 = {"Lio/ktor/http/HttpProtocolVersion;", "", "", "name", "", "major", "minor", "<init>", "(Ljava/lang/String;II)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "Ljava/lang/String;", "getName", "b", "I", "getMajor", "c", "getMinor", "d", "Companion", "ktor-http"}, k = 1, mv = {1, 8, 0})
public final class HttpProtocolVersion {
    public static final Companion d = new Companion((DefaultConstructorMarker) null);
    public static final HttpProtocolVersion e = new HttpProtocolVersion("HTTP", 2, 0);
    public static final HttpProtocolVersion f = new HttpProtocolVersion("HTTP", 1, 1);
    public static final HttpProtocolVersion g = new HttpProtocolVersion("HTTP", 1, 0);
    public static final HttpProtocolVersion h = new HttpProtocolVersion("SPDY", 3, 0);
    public static final HttpProtocolVersion i = new HttpProtocolVersion("QUIC", 1, 0);

    /* renamed from: a  reason: collision with root package name */
    public final String f8968a;
    public final int b;
    public final int c;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\f\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\u000e\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0010\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0014\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0011\u001a\u0004\b\u0015\u0010\u0013R\u0017\u0010\u0016\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0017\u0010\u0013¨\u0006\u0018"}, d2 = {"Lio/ktor/http/HttpProtocolVersion$Companion;", "", "<init>", "()V", "", "name", "", "major", "minor", "Lio/ktor/http/HttpProtocolVersion;", "a", "(Ljava/lang/String;II)Lio/ktor/http/HttpProtocolVersion;", "", "value", "e", "(Ljava/lang/CharSequence;)Lio/ktor/http/HttpProtocolVersion;", "HTTP_2_0", "Lio/ktor/http/HttpProtocolVersion;", "d", "()Lio/ktor/http/HttpProtocolVersion;", "HTTP_1_1", "c", "HTTP_1_0", "b", "ktor-http"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final HttpProtocolVersion a(String str, int i, int i2) {
            Intrinsics.checkNotNullParameter(str, "name");
            return (Intrinsics.areEqual((Object) str, (Object) "HTTP") && i == 1 && i2 == 0) ? b() : (Intrinsics.areEqual((Object) str, (Object) "HTTP") && i == 1 && i2 == 1) ? c() : (Intrinsics.areEqual((Object) str, (Object) "HTTP") && i == 2 && i2 == 0) ? d() : new HttpProtocolVersion(str, i, i2);
        }

        public final HttpProtocolVersion b() {
            return HttpProtocolVersion.g;
        }

        public final HttpProtocolVersion c() {
            return HttpProtocolVersion.f;
        }

        public final HttpProtocolVersion d() {
            return HttpProtocolVersion.e;
        }

        public final HttpProtocolVersion e(CharSequence charSequence) {
            Intrinsics.checkNotNullParameter(charSequence, AccountConstantKt.RESPONSE_VALUE);
            List split$default = StringsKt.split$default(charSequence, new String[]{"/", "."}, false, 0, 6, (Object) null);
            if (split$default.size() == 3) {
                return a((String) split$default.get(0), Integer.parseInt((String) split$default.get(1)), Integer.parseInt((String) split$default.get(2)));
            }
            throw new IllegalStateException(("Failed to parse HttpProtocolVersion. Expected format: protocol/major.minor, but actual: " + charSequence).toString());
        }

        public Companion() {
        }
    }

    public HttpProtocolVersion(String str, int i2, int i3) {
        Intrinsics.checkNotNullParameter(str, "name");
        this.f8968a = str;
        this.b = i2;
        this.c = i3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HttpProtocolVersion)) {
            return false;
        }
        HttpProtocolVersion httpProtocolVersion = (HttpProtocolVersion) obj;
        return Intrinsics.areEqual((Object) this.f8968a, (Object) httpProtocolVersion.f8968a) && this.b == httpProtocolVersion.b && this.c == httpProtocolVersion.c;
    }

    public int hashCode() {
        return (((this.f8968a.hashCode() * 31) + Integer.hashCode(this.b)) * 31) + Integer.hashCode(this.c);
    }

    public String toString() {
        return this.f8968a + '/' + this.b + '.' + this.c;
    }
}
