package io.ktor.http;

import com.honey.account.constant.AccountConstantKt;
import io.ktor.util.date.GMTDate;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b#\b\b\u0018\u00002\u00020\u0001B{\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r\u0012\b\b\u0002\u0010\u000f\u001a\u00020\r\u0012\u0016\b\u0002\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u0001\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\r2\u0016\b\u0002\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0010HÆ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u001b\u001a\u00020\r2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001b\u0010\u001cR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u001d\u001a\u0004\b\u001e\u0010\u0017R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001f\u0010\u001d\u001a\u0004\b \u0010\u0017R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u0017\u0010\b\u001a\u00020\u00078\u0007¢\u0006\f\n\u0004\b#\u0010%\u001a\u0004\b&\u0010\u0019R\u0019\u0010\n\u001a\u0004\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b'\u0010)R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001d\u001a\u0004\b!\u0010\u0017R\u0019\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b*\u0010\u001d\u001a\u0004\b*\u0010\u0017R\u0017\u0010\u000e\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b+\u0010-R\u0017\u0010\u000f\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b \u0010,\u001a\u0004\b.\u0010-R%\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00108\u0006¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102¨\u00063"}, d2 = {"Lio/ktor/http/Cookie;", "", "", "name", "value", "Lio/ktor/http/CookieEncoding;", "encoding", "", "maxAge", "Lio/ktor/util/date/GMTDate;", "expires", "domain", "path", "", "secure", "httpOnly", "", "extensions", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lio/ktor/http/CookieEncoding;ILio/ktor/util/date/GMTDate;Ljava/lang/String;Ljava/lang/String;ZZLjava/util/Map;)V", "a", "(Ljava/lang/String;Ljava/lang/String;Lio/ktor/http/CookieEncoding;ILio/ktor/util/date/GMTDate;Ljava/lang/String;Ljava/lang/String;ZZLjava/util/Map;)Lio/ktor/http/Cookie;", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "f", "b", "i", "c", "Lio/ktor/http/CookieEncoding;", "d", "()Lio/ktor/http/CookieEncoding;", "I", "getMaxAgeInt", "e", "Lio/ktor/util/date/GMTDate;", "()Lio/ktor/util/date/GMTDate;", "g", "h", "Z", "()Z", "getHttpOnly", "j", "Ljava/util/Map;", "getExtensions", "()Ljava/util/Map;", "ktor-http"}, k = 1, mv = {1, 8, 0})
public final class Cookie {

    /* renamed from: a  reason: collision with root package name */
    public final String f8953a;
    public final String b;
    public final CookieEncoding c;
    public final int d;
    public final GMTDate e;
    public final String f;
    public final String g;
    public final boolean h;
    public final boolean i;
    public final Map j;

    public Cookie(String str, String str2, CookieEncoding cookieEncoding, int i2, GMTDate gMTDate, String str3, String str4, boolean z, boolean z2, Map map) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, AccountConstantKt.RESPONSE_VALUE);
        Intrinsics.checkNotNullParameter(cookieEncoding, "encoding");
        Intrinsics.checkNotNullParameter(map, "extensions");
        this.f8953a = str;
        this.b = str2;
        this.c = cookieEncoding;
        this.d = i2;
        this.e = gMTDate;
        this.f = str3;
        this.g = str4;
        this.h = z;
        this.i = z2;
        this.j = map;
    }

    public static /* synthetic */ Cookie b(Cookie cookie, String str, String str2, CookieEncoding cookieEncoding, int i2, GMTDate gMTDate, String str3, String str4, boolean z, boolean z2, Map map, int i3, Object obj) {
        Cookie cookie2 = cookie;
        int i4 = i3;
        return cookie.a((i4 & 1) != 0 ? cookie2.f8953a : str, (i4 & 2) != 0 ? cookie2.b : str2, (i4 & 4) != 0 ? cookie2.c : cookieEncoding, (i4 & 8) != 0 ? cookie2.d : i2, (i4 & 16) != 0 ? cookie2.e : gMTDate, (i4 & 32) != 0 ? cookie2.f : str3, (i4 & 64) != 0 ? cookie2.g : str4, (i4 & 128) != 0 ? cookie2.h : z, (i4 & 256) != 0 ? cookie2.i : z2, (i4 & 512) != 0 ? cookie2.j : map);
    }

    public final Cookie a(String str, String str2, CookieEncoding cookieEncoding, int i2, GMTDate gMTDate, String str3, String str4, boolean z, boolean z2, Map map) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, AccountConstantKt.RESPONSE_VALUE);
        Intrinsics.checkNotNullParameter(cookieEncoding, "encoding");
        Map map2 = map;
        Intrinsics.checkNotNullParameter(map2, "extensions");
        return new Cookie(str, str2, cookieEncoding, i2, gMTDate, str3, str4, z, z2, map2);
    }

    public final String c() {
        return this.f;
    }

    public final CookieEncoding d() {
        return this.c;
    }

    public final GMTDate e() {
        return this.e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Cookie)) {
            return false;
        }
        Cookie cookie = (Cookie) obj;
        return Intrinsics.areEqual((Object) this.f8953a, (Object) cookie.f8953a) && Intrinsics.areEqual((Object) this.b, (Object) cookie.b) && this.c == cookie.c && this.d == cookie.d && Intrinsics.areEqual((Object) this.e, (Object) cookie.e) && Intrinsics.areEqual((Object) this.f, (Object) cookie.f) && Intrinsics.areEqual((Object) this.g, (Object) cookie.g) && this.h == cookie.h && this.i == cookie.i && Intrinsics.areEqual((Object) this.j, (Object) cookie.j);
    }

    public final String f() {
        return this.f8953a;
    }

    public final String g() {
        return this.g;
    }

    public final boolean h() {
        return this.h;
    }

    public int hashCode() {
        int hashCode = ((((((this.f8953a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + Integer.hashCode(this.d)) * 31;
        GMTDate gMTDate = this.e;
        int i2 = 0;
        int hashCode2 = (hashCode + (gMTDate == null ? 0 : gMTDate.hashCode())) * 31;
        String str = this.f;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.g;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = (hashCode3 + i2) * 31;
        boolean z = this.h;
        boolean z2 = true;
        if (z) {
            z = true;
        }
        int i4 = (i3 + (z ? 1 : 0)) * 31;
        boolean z3 = this.i;
        if (!z3) {
            z2 = z3;
        }
        return ((i4 + (z2 ? 1 : 0)) * 31) + this.j.hashCode();
    }

    public final String i() {
        return this.b;
    }

    public String toString() {
        return "Cookie(name=" + this.f8953a + ", value=" + this.b + ", encoding=" + this.c + ", maxAge=" + this.d + ", expires=" + this.e + ", domain=" + this.f + ", path=" + this.g + ", secure=" + this.h + ", httpOnly=" + this.i + ", extensions=" + this.j + ')';
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ Cookie(java.lang.String r14, java.lang.String r15, io.ktor.http.CookieEncoding r16, int r17, io.ktor.util.date.GMTDate r18, java.lang.String r19, java.lang.String r20, boolean r21, boolean r22, java.util.Map r23, int r24, kotlin.jvm.internal.DefaultConstructorMarker r25) {
        /*
            r13 = this;
            r0 = r24
            r1 = r0 & 4
            if (r1 == 0) goto L_0x000a
            io.ktor.http.CookieEncoding r1 = io.ktor.http.CookieEncoding.URI_ENCODING
            r5 = r1
            goto L_0x000c
        L_0x000a:
            r5 = r16
        L_0x000c:
            r1 = r0 & 8
            r2 = 0
            if (r1 == 0) goto L_0x0013
            r6 = r2
            goto L_0x0015
        L_0x0013:
            r6 = r17
        L_0x0015:
            r1 = r0 & 16
            r3 = 0
            if (r1 == 0) goto L_0x001c
            r7 = r3
            goto L_0x001e
        L_0x001c:
            r7 = r18
        L_0x001e:
            r1 = r0 & 32
            if (r1 == 0) goto L_0x0024
            r8 = r3
            goto L_0x0026
        L_0x0024:
            r8 = r19
        L_0x0026:
            r1 = r0 & 64
            if (r1 == 0) goto L_0x002c
            r9 = r3
            goto L_0x002e
        L_0x002c:
            r9 = r20
        L_0x002e:
            r1 = r0 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x0034
            r10 = r2
            goto L_0x0036
        L_0x0034:
            r10 = r21
        L_0x0036:
            r1 = r0 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x003c
            r11 = r2
            goto L_0x003e
        L_0x003c:
            r11 = r22
        L_0x003e:
            r0 = r0 & 512(0x200, float:7.175E-43)
            if (r0 == 0) goto L_0x0048
            java.util.Map r0 = kotlin.collections.MapsKt.emptyMap()
            r12 = r0
            goto L_0x004a
        L_0x0048:
            r12 = r23
        L_0x004a:
            r2 = r13
            r3 = r14
            r4 = r15
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.http.Cookie.<init>(java.lang.String, java.lang.String, io.ktor.http.CookieEncoding, int, io.ktor.util.date.GMTDate, java.lang.String, java.lang.String, boolean, boolean, java.util.Map, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
