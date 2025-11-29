package io.ktor.http;

import com.honey.account.constant.AccountConstantKt;
import com.upuphone.runasone.api.ApiConstant;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u0000 H2\u00020\u0001:\u0001PBk\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\n\u0012\b\b\u0002\u0010\r\u001a\u00020\f\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\r\u0010\u0016\u001a\u00020\u0004¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0018\u0010\u0017J\r\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001a\u0010\u001bR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010!\u001a\u0004\b\"\u0010\u0017\"\u0004\b#\u0010$R\"\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\"\u0010\u0010\u001a\u00020\u000f8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R$\u00103\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b0\u0010!\u001a\u0004\b1\u0010\u0017\"\u0004\b2\u0010$R$\u00106\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b4\u0010!\u001a\u0004\b4\u0010\u0017\"\u0004\b5\u0010$R\"\u00109\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b7\u0010!\u001a\u0004\b*\u0010\u0017\"\u0004\b8\u0010$R(\u0010>\u001a\b\u0012\u0004\u0012\u00020\u00040\n8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b1\u0010:\u001a\u0004\b7\u0010;\"\u0004\b<\u0010=R*\u0010F\u001a\u00020?2\u0006\u0010@\u001a\u00020?8\u0006@FX\u000e¢\u0006\u0012\n\u0004\bA\u0010B\u001a\u0004\b0\u0010C\"\u0004\bD\u0010ER$\u0010\r\u001a\u00020?2\u0006\u0010G\u001a\u00020?8\u0006@BX\u000e¢\u0006\f\n\u0004\b\"\u0010B\u001a\u0004\bH\u0010CR(\u0010\b\u001a\u0004\u0018\u00010\u00042\b\u0010@\u001a\u0004\u0018\u00010\u00048F@FX\u000e¢\u0006\f\u001a\u0004\bI\u0010\u0017\"\u0004\bJ\u0010$R(\u0010\t\u001a\u0004\u0018\u00010\u00042\b\u0010@\u001a\u0004\u0018\u00010\u00048F@FX\u000e¢\u0006\f\u001a\u0004\bK\u0010\u0017\"\u0004\bL\u0010$R$\u0010\u000e\u001a\u00020\u00042\u0006\u0010@\u001a\u00020\u00048F@FX\u000e¢\u0006\f\u001a\u0004\bA\u0010\u0017\"\u0004\bM\u0010$R0\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\n2\f\u0010@\u001a\b\u0012\u0004\u0012\u00020\u00040\n8F@FX\u000e¢\u0006\f\u001a\u0004\bN\u0010;\"\u0004\bO\u0010=¨\u0006Q"}, d2 = {"Lio/ktor/http/URLBuilder;", "", "Lio/ktor/http/URLProtocol;", "protocol", "", "host", "", "port", "user", "password", "", "pathSegments", "Lio/ktor/http/Parameters;", "parameters", "fragment", "", "trailingQuery", "<init>", "(Lio/ktor/http/URLProtocol;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/util/List;Lio/ktor/http/Parameters;Ljava/lang/String;Z)V", "", "a", "()V", "c", "()Ljava/lang/String;", "toString", "Lio/ktor/http/Url;", "b", "()Lio/ktor/http/Url;", "Lio/ktor/http/URLProtocol;", "o", "()Lio/ktor/http/URLProtocol;", "y", "(Lio/ktor/http/URLProtocol;)V", "Ljava/lang/String;", "j", "w", "(Ljava/lang/String;)V", "I", "n", "()I", "x", "(I)V", "d", "Z", "p", "()Z", "z", "(Z)V", "e", "h", "v", "encodedUser", "f", "t", "encodedPassword", "g", "r", "encodedFragment", "Ljava/util/List;", "()Ljava/util/List;", "u", "(Ljava/util/List;)V", "encodedPathSegments", "Lio/ktor/http/ParametersBuilder;", "value", "i", "Lio/ktor/http/ParametersBuilder;", "()Lio/ktor/http/ParametersBuilder;", "s", "(Lio/ktor/http/ParametersBuilder;)V", "encodedParameters", "<set-?>", "k", "q", "A", "l", "setPassword", "setFragment", "m", "setPathSegments", "Companion", "ktor-http"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nURLBuilder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 URLBuilder.kt\nio/ktor/http/URLBuilder\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,308:1\n1549#2:309\n1620#2,3:310\n1549#2:313\n1620#2,3:314\n1549#2:317\n1620#2,3:318\n*S KotlinDebug\n*F\n+ 1 URLBuilder.kt\nio/ktor/http/URLBuilder\n*L\n58#1:309\n58#1:310,3\n61#1:313\n61#1:314,3\n63#1:317\n63#1:318,3\n*E\n"})
public final class URLBuilder {
    public static final Companion k;
    public static final Url l;

    /* renamed from: a  reason: collision with root package name */
    public URLProtocol f8977a;
    public String b;
    public int c;
    public boolean d;
    public String e;
    public String f;
    public String g;
    public List h;
    public ParametersBuilder i;
    public ParametersBuilder j;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lio/ktor/http/URLBuilder$Companion;", "", "()V", "originUrl", "Lio/ktor/http/Url;", "ktor-http"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    static {
        Companion companion = new Companion((DefaultConstructorMarker) null);
        k = companion;
        l = URLUtilsKt.d(URLBuilderJvmKt.a(companion));
    }

    public URLBuilder(URLProtocol uRLProtocol, String str, int i2, String str2, String str3, List list, Parameters parameters, String str4, boolean z) {
        Intrinsics.checkNotNullParameter(uRLProtocol, "protocol");
        Intrinsics.checkNotNullParameter(str, ApiConstant.VALUE_HOST);
        Intrinsics.checkNotNullParameter(list, "pathSegments");
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        Intrinsics.checkNotNullParameter(str4, "fragment");
        this.f8977a = uRLProtocol;
        this.b = str;
        this.c = i2;
        this.d = z;
        String str5 = null;
        this.e = str2 != null ? CodecsKt.m(str2, false, 1, (Object) null) : null;
        this.f = str3 != null ? CodecsKt.m(str3, false, 1, (Object) null) : str5;
        this.g = CodecsKt.r(str4, false, false, (Charset) null, 7, (Object) null);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(CodecsKt.p((String) it.next()));
        }
        this.h = arrayList;
        ParametersBuilder e2 = UrlDecodedParametersBuilderKt.e(parameters);
        this.i = e2;
        this.j = new UrlDecodedParametersBuilder(e2);
    }

    public final void A(String str) {
        String str2 = null;
        if (str != null) {
            str2 = CodecsKt.m(str, false, 1, (Object) null);
        }
        this.e = str2;
    }

    public final void a() {
        if (this.b.length() <= 0 && !Intrinsics.areEqual((Object) this.f8977a.f(), (Object) "file")) {
            Url url = l;
            this.b = url.g();
            if (Intrinsics.areEqual((Object) this.f8977a, (Object) URLProtocol.c.c())) {
                this.f8977a = url.k();
            }
            if (this.c == 0) {
                this.c = url.l();
            }
        }
    }

    public final Url b() {
        a();
        return new Url(this.f8977a, this.b, this.c, m(), this.j.build(), i(), q(), l(), this.d, c());
    }

    public final String c() {
        a();
        String sb = ((StringBuilder) URLBuilderKt.d(this, new StringBuilder(256))).toString();
        Intrinsics.checkNotNullExpressionValue(sb, "appendTo(StringBuilder(256)).toString()");
        return sb;
    }

    public final String d() {
        return this.g;
    }

    public final ParametersBuilder e() {
        return this.i;
    }

    public final String f() {
        return this.f;
    }

    public final List g() {
        return this.h;
    }

    public final String h() {
        return this.e;
    }

    public final String i() {
        return CodecsKt.k(this.g, 0, 0, false, (Charset) null, 15, (Object) null);
    }

    public final String j() {
        return this.b;
    }

    public final ParametersBuilder k() {
        return this.j;
    }

    public final String l() {
        String str = this.f;
        if (str != null) {
            return CodecsKt.i(str, 0, 0, (Charset) null, 7, (Object) null);
        }
        return null;
    }

    public final List m() {
        List<String> list = this.h;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (String i2 : list) {
            arrayList.add(CodecsKt.i(i2, 0, 0, (Charset) null, 7, (Object) null));
        }
        return arrayList;
    }

    public final int n() {
        return this.c;
    }

    public final URLProtocol o() {
        return this.f8977a;
    }

    public final boolean p() {
        return this.d;
    }

    public final String q() {
        String str = this.e;
        if (str != null) {
            return CodecsKt.i(str, 0, 0, (Charset) null, 7, (Object) null);
        }
        return null;
    }

    public final void r(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.g = str;
    }

    public final void s(ParametersBuilder parametersBuilder) {
        Intrinsics.checkNotNullParameter(parametersBuilder, AccountConstantKt.RESPONSE_VALUE);
        this.i = parametersBuilder;
        this.j = new UrlDecodedParametersBuilder(parametersBuilder);
    }

    public final void t(String str) {
        this.f = str;
    }

    public String toString() {
        String sb = ((StringBuilder) URLBuilderKt.d(this, new StringBuilder(256))).toString();
        Intrinsics.checkNotNullExpressionValue(sb, "appendTo(StringBuilder(256)).toString()");
        return sb;
    }

    public final void u(List list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.h = list;
    }

    public final void v(String str) {
        this.e = str;
    }

    public final void w(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.b = str;
    }

    public final void x(int i2) {
        this.c = i2;
    }

    public final void y(URLProtocol uRLProtocol) {
        Intrinsics.checkNotNullParameter(uRLProtocol, "<set-?>");
        this.f8977a = uRLProtocol;
    }

    public final void z(boolean z) {
        this.d = z;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ URLBuilder(io.ktor.http.URLProtocol r12, java.lang.String r13, int r14, java.lang.String r15, java.lang.String r16, java.util.List r17, io.ktor.http.Parameters r18, java.lang.String r19, boolean r20, int r21, kotlin.jvm.internal.DefaultConstructorMarker r22) {
        /*
            r11 = this;
            r0 = r21
            r1 = r0 & 1
            if (r1 == 0) goto L_0x000d
            io.ktor.http.URLProtocol$Companion r1 = io.ktor.http.URLProtocol.c
            io.ktor.http.URLProtocol r1 = r1.c()
            goto L_0x000e
        L_0x000d:
            r1 = r12
        L_0x000e:
            r2 = r0 & 2
            java.lang.String r3 = ""
            if (r2 == 0) goto L_0x0016
            r2 = r3
            goto L_0x0017
        L_0x0016:
            r2 = r13
        L_0x0017:
            r4 = r0 & 4
            r5 = 0
            if (r4 == 0) goto L_0x001e
            r4 = r5
            goto L_0x001f
        L_0x001e:
            r4 = r14
        L_0x001f:
            r6 = r0 & 8
            r7 = 0
            if (r6 == 0) goto L_0x0026
            r6 = r7
            goto L_0x0027
        L_0x0026:
            r6 = r15
        L_0x0027:
            r8 = r0 & 16
            if (r8 == 0) goto L_0x002c
            goto L_0x002e
        L_0x002c:
            r7 = r16
        L_0x002e:
            r8 = r0 & 32
            if (r8 == 0) goto L_0x0037
            java.util.List r8 = kotlin.collections.CollectionsKt.emptyList()
            goto L_0x0039
        L_0x0037:
            r8 = r17
        L_0x0039:
            r9 = r0 & 64
            if (r9 == 0) goto L_0x0044
            io.ktor.http.Parameters$Companion r9 = io.ktor.http.Parameters.b
            io.ktor.http.Parameters r9 = r9.a()
            goto L_0x0046
        L_0x0044:
            r9 = r18
        L_0x0046:
            r10 = r0 & 128(0x80, float:1.794E-43)
            if (r10 == 0) goto L_0x004b
            goto L_0x004d
        L_0x004b:
            r3 = r19
        L_0x004d:
            r0 = r0 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x0052
            goto L_0x0054
        L_0x0052:
            r5 = r20
        L_0x0054:
            r12 = r1
            r13 = r2
            r14 = r4
            r15 = r6
            r16 = r7
            r17 = r8
            r18 = r9
            r19 = r3
            r20 = r5
            r11.<init>(r12, r13, r14, r15, r16, r17, r18, r19, r20)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.http.URLBuilder.<init>(io.ktor.http.URLProtocol, java.lang.String, int, java.lang.String, java.lang.String, java.util.List, io.ktor.http.Parameters, java.lang.String, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
