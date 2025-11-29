package io.ktor.client.plugins.cookies;

import io.ktor.http.Cookie;
import io.ktor.http.CookieEncoding;
import io.ktor.http.Url;
import io.ktor.util.date.GMTDate;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u001a\u001b\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001b\u0010\u0006\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lio/ktor/http/Cookie;", "Lio/ktor/http/Url;", "requestUrl", "", "b", "(Lio/ktor/http/Cookie;Lio/ktor/http/Url;)Z", "a", "(Lio/ktor/http/Cookie;Lio/ktor/http/Url;)Lio/ktor/http/Cookie;", "ktor-client-core"}, k = 2, mv = {1, 8, 0})
public final class CookiesStorageKt {
    public static final Cookie a(Cookie cookie, Url url) {
        Cookie cookie2 = cookie;
        Intrinsics.checkNotNullParameter(cookie, "<this>");
        Intrinsics.checkNotNullParameter(url, "requestUrl");
        String g = cookie.g();
        if (g == null || !StringsKt.startsWith$default(g, "/", false, 2, (Object) null)) {
            cookie2 = Cookie.b(cookie, (String) null, (String) null, (CookieEncoding) null, 0, (GMTDate) null, (String) null, url.d(), false, false, (Map) null, 959, (Object) null);
        }
        String c = cookie2.c();
        return (c == null || StringsKt.isBlank(c)) ? Cookie.b(cookie2, (String) null, (String) null, (CookieEncoding) null, 0, (GMTDate) null, url.g(), (String) null, false, false, (Map) null, 991, (Object) null) : cookie2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x008c, code lost:
        if (kotlin.text.StringsKt.endsWith$default(r8, '.' + r2, false, 2, (java.lang.Object) null) == false) goto L_0x008e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final boolean b(io.ktor.http.Cookie r11, io.ktor.http.Url r12) {
        /*
            r0 = 0
            r1 = 1
            java.lang.String r2 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r2)
            java.lang.String r2 = "requestUrl"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r2)
            java.lang.String r2 = r11.c()
            if (r2 == 0) goto L_0x00c2
            java.lang.String r2 = io.ktor.util.TextKt.c(r2)
            if (r2 == 0) goto L_0x00c2
            r3 = 46
            char[] r4 = new char[r1]
            r4[r0] = r3
            java.lang.String r2 = kotlin.text.StringsKt.trimStart((java.lang.String) r2, (char[]) r4)
            if (r2 == 0) goto L_0x00c2
            r11.g()
            java.lang.String r4 = r11.g()
            if (r4 == 0) goto L_0x00b6
            r5 = 47
            r6 = 2
            r7 = 0
            boolean r8 = kotlin.text.StringsKt.endsWith$default((java.lang.CharSequence) r4, (char) r5, (boolean) r0, (int) r6, (java.lang.Object) r7)
            if (r8 == 0) goto L_0x0038
            goto L_0x004b
        L_0x0038:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r8 = r11.g()
            r4.append(r8)
            r4.append(r5)
            java.lang.String r4 = r4.toString()
        L_0x004b:
            java.lang.String r8 = r12.g()
            java.lang.String r8 = io.ktor.util.TextKt.c(r8)
            java.lang.String r9 = r12.d()
            boolean r10 = kotlin.text.StringsKt.endsWith$default((java.lang.CharSequence) r9, (char) r5, (boolean) r0, (int) r6, (java.lang.Object) r7)
            if (r10 == 0) goto L_0x005e
            goto L_0x006d
        L_0x005e:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            r10.append(r9)
            r10.append(r5)
            java.lang.String r9 = r10.toString()
        L_0x006d:
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r8, (java.lang.Object) r2)
            if (r5 != 0) goto L_0x008f
            boolean r5 = io.ktor.http.IpParserKt.a(r8)
            if (r5 != 0) goto L_0x008e
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r3)
            r5.append(r2)
            java.lang.String r2 = r5.toString()
            boolean r2 = kotlin.text.StringsKt.endsWith$default(r8, r2, r0, r6, r7)
            if (r2 != 0) goto L_0x008f
        L_0x008e:
            return r0
        L_0x008f:
            java.lang.String r2 = "/"
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) r2)
            if (r2 != 0) goto L_0x00a4
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r9, (java.lang.Object) r4)
            if (r2 != 0) goto L_0x00a4
            boolean r2 = kotlin.text.StringsKt.startsWith$default(r9, r4, r0, r6, r7)
            if (r2 != 0) goto L_0x00a4
            return r0
        L_0x00a4:
            boolean r11 = r11.h()
            if (r11 == 0) goto L_0x00b4
            io.ktor.http.URLProtocol r11 = r12.k()
            boolean r11 = io.ktor.http.URLProtocolKt.a(r11)
            if (r11 == 0) goto L_0x00b5
        L_0x00b4:
            r0 = r1
        L_0x00b5:
            return r0
        L_0x00b6:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "Path field should have the default value"
            java.lang.String r12 = r12.toString()
            r11.<init>(r12)
            throw r11
        L_0x00c2:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "Domain field should have the default value"
            java.lang.String r12 = r12.toString()
            r11.<init>(r12)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.cookies.CookiesStorageKt.b(io.ktor.http.Cookie, io.ktor.http.Url):boolean");
    }
}
