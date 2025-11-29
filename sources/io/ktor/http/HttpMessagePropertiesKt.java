package io.ktor.http;

import com.meizu.common.widget.MzContactsContract;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0001*\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u0019\u0010\t\u001a\n\u0018\u00010\u0007j\u0004\u0018\u0001`\b*\u00020\u0004¢\u0006\u0004\b\t\u0010\n\u001a\u0019\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b*\u00020\u0004¢\u0006\u0004\b\r\u0010\u000e\u001a\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u000f*\u00020\u0004¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u000b*\u00020\u0004¢\u0006\u0004\b\u0013\u0010\u000e\u001a\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u000b*\u00020\u0004¢\u0006\u0004\b\u0015\u0010\u000e\u001a\u0019\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\f0\u000b*\u00020\fH\u0000¢\u0006\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lio/ktor/http/HttpMessageBuilder;", "Lio/ktor/http/ContentType;", "e", "(Lio/ktor/http/HttpMessageBuilder;)Lio/ktor/http/ContentType;", "Lio/ktor/http/HttpMessage;", "d", "(Lio/ktor/http/HttpMessage;)Lio/ktor/http/ContentType;", "Ljava/nio/charset/Charset;", "Lio/ktor/utils/io/charsets/Charset;", "b", "(Lio/ktor/http/HttpMessage;)Ljava/nio/charset/Charset;", "", "", "h", "(Lio/ktor/http/HttpMessage;)Ljava/util/List;", "", "c", "(Lio/ktor/http/HttpMessage;)Ljava/lang/Long;", "Lio/ktor/http/Cookie;", "f", "Lio/ktor/http/HeaderValue;", "a", "g", "(Ljava/lang/String;)Ljava/util/List;", "ktor-http"}, k = 2, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nHttpMessageProperties.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HttpMessageProperties.kt\nio/ktor/http/HttpMessagePropertiesKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,172:1\n1#2:173\n1360#3:174\n1446#3,2:175\n1549#3:177\n1620#3,3:178\n1448#3,3:181\n1360#3:184\n1446#3,2:185\n1549#3:187\n1620#3,3:188\n1448#3,3:191\n1360#3:194\n1446#3,5:195\n1549#3:200\n1620#3,3:201\n1549#3:204\n1620#3,3:205\n*S KotlinDebug\n*F\n+ 1 HttpMessageProperties.kt\nio/ktor/http/HttpMessagePropertiesKt\n*L\n64#1:174\n64#1:175,2\n65#1:177\n65#1:178,3\n64#1:181,3\n91#1:184\n91#1:185,2\n92#1:187\n92#1:188,3\n91#1:191,3\n104#1:194\n104#1:195,5\n105#1:200\n105#1:201,3\n112#1:204\n112#1:205,3\n*E\n"})
public final class HttpMessagePropertiesKt {
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0015, code lost:
        r1 = io.ktor.http.HttpHeaderValueParserKt.b(r1);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.util.List a(io.ktor.http.HttpMessage r1) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            io.ktor.http.Headers r1 = r1.a()
            io.ktor.http.HttpHeaders r0 = io.ktor.http.HttpHeaders.f8966a
            java.lang.String r0 = r0.f()
            java.lang.String r1 = r1.get(r0)
            if (r1 == 0) goto L_0x001b
            java.util.List r1 = io.ktor.http.HttpHeaderValueParserKt.b(r1)
            if (r1 != 0) goto L_0x001f
        L_0x001b:
            java.util.List r1 = kotlin.collections.CollectionsKt.emptyList()
        L_0x001f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.http.HttpMessagePropertiesKt.a(io.ktor.http.HttpMessage):java.util.List");
    }

    public static final Charset b(HttpMessage httpMessage) {
        Intrinsics.checkNotNullParameter(httpMessage, "<this>");
        ContentType d = d(httpMessage);
        if (d != null) {
            return ContentTypesKt.a(d);
        }
        return null;
    }

    public static final Long c(HttpMessage httpMessage) {
        Intrinsics.checkNotNullParameter(httpMessage, "<this>");
        String str = httpMessage.a().get(HttpHeaders.f8966a.j());
        if (str != null) {
            return Long.valueOf(Long.parseLong(str));
        }
        return null;
    }

    public static final ContentType d(HttpMessage httpMessage) {
        Intrinsics.checkNotNullParameter(httpMessage, "<this>");
        String str = httpMessage.a().get(HttpHeaders.f8966a.k());
        if (str != null) {
            return ContentType.f.b(str);
        }
        return null;
    }

    public static final ContentType e(HttpMessageBuilder httpMessageBuilder) {
        Intrinsics.checkNotNullParameter(httpMessageBuilder, "<this>");
        String h = httpMessageBuilder.a().h(HttpHeaders.f8966a.k());
        if (h != null) {
            return ContentType.f.b(h);
        }
        return null;
    }

    public static final List f(HttpMessage httpMessage) {
        Intrinsics.checkNotNullParameter(httpMessage, "<this>");
        List<String> a2 = httpMessage.a().a(HttpHeaders.f8966a.y());
        if (a2 == null) {
            return CollectionsKt.emptyList();
        }
        ArrayList<String> arrayList = new ArrayList<>();
        for (String g : a2) {
            CollectionsKt.addAll(arrayList, g(g));
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
        for (String e : arrayList) {
            arrayList2.add(CookieKt.e(e));
        }
        return arrayList2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0068  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.util.List g(java.lang.String r14) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            r5 = 6
            r6 = 0
            r2 = 44
            r3 = 0
            r4 = 0
            r1 = r14
            int r0 = kotlin.text.StringsKt.indexOf$default((java.lang.CharSequence) r1, (char) r2, (int) r3, (boolean) r4, (int) r5, (java.lang.Object) r6)
            r1 = -1
            if (r0 != r1) goto L_0x0018
            java.util.List r14 = kotlin.collections.CollectionsKt.listOf(r14)
            return r14
        L_0x0018:
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            r11 = 4
            r12 = 0
            r8 = 61
            r10 = 0
            r7 = r14
            r9 = r0
            int r3 = kotlin.text.StringsKt.indexOf$default((java.lang.CharSequence) r7, (char) r8, (int) r9, (boolean) r10, (int) r11, (java.lang.Object) r12)
            r8 = 59
            int r4 = kotlin.text.StringsKt.indexOf$default((java.lang.CharSequence) r7, (char) r8, (int) r9, (boolean) r10, (int) r11, (java.lang.Object) r12)
            r5 = 0
        L_0x002f:
            int r6 = r14.length()
            java.lang.String r12 = "this as java.lang.String).substring(startIndex)"
            if (r5 >= r6) goto L_0x0095
            if (r0 <= 0) goto L_0x0095
            if (r3 >= r0) goto L_0x0047
            r10 = 4
            r11 = 0
            r7 = 61
            r9 = 0
            r6 = r14
            r8 = r0
            int r3 = kotlin.text.StringsKt.indexOf$default((java.lang.CharSequence) r6, (char) r7, (int) r8, (boolean) r9, (int) r10, (java.lang.Object) r11)
        L_0x0047:
            int r8 = r0 + 1
            r10 = 4
            r11 = 0
            r7 = 44
            r9 = 0
            r6 = r14
            int r6 = kotlin.text.StringsKt.indexOf$default((java.lang.CharSequence) r6, (char) r7, (int) r8, (boolean) r9, (int) r10, (java.lang.Object) r11)
        L_0x0053:
            r13 = r0
            r0 = r6
            if (r0 < 0) goto L_0x0066
            if (r0 >= r3) goto L_0x0066
            int r8 = r0 + 1
            r10 = 4
            r11 = 0
            r7 = 44
            r9 = 0
            r6 = r14
            int r6 = kotlin.text.StringsKt.indexOf$default((java.lang.CharSequence) r6, (char) r7, (int) r8, (boolean) r9, (int) r10, (java.lang.Object) r11)
            goto L_0x0053
        L_0x0066:
            if (r4 >= r13) goto L_0x0073
            r10 = 4
            r11 = 0
            r7 = 59
            r9 = 0
            r6 = r14
            r8 = r13
            int r4 = kotlin.text.StringsKt.indexOf$default((java.lang.CharSequence) r6, (char) r7, (int) r8, (boolean) r9, (int) r10, (java.lang.Object) r11)
        L_0x0073:
            if (r3 >= 0) goto L_0x0080
            java.lang.String r14 = r14.substring(r5)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r14, r12)
            r2.add(r14)
            return r2
        L_0x0080:
            if (r4 == r1) goto L_0x0084
            if (r4 <= r3) goto L_0x002f
        L_0x0084:
            java.lang.String r5 = r14.substring(r5, r13)
            java.lang.String r6 = "this as java.lang.String…ing(startIndex, endIndex)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r6)
            r2.add(r5)
            int r13 = r13 + 1
            r5 = r13
            goto L_0x002f
        L_0x0095:
            int r0 = r14.length()
            if (r5 >= r0) goto L_0x00a5
            java.lang.String r14 = r14.substring(r5)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r14, r12)
            r2.add(r14)
        L_0x00a5:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.http.HttpMessagePropertiesKt.g(java.lang.String):java.util.List");
    }

    public static final List h(HttpMessage httpMessage) {
        Intrinsics.checkNotNullParameter(httpMessage, "<this>");
        List<String> a2 = httpMessage.a().a(HttpHeaders.f8966a.C());
        if (a2 == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (String split$default : a2) {
            List<String> split$default2 = StringsKt.split$default((CharSequence) split$default, new String[]{MzContactsContract.MzGroups.GROUP_SPLIT_MARK_EXTRA}, false, 0, 6, (Object) null);
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(split$default2, 10));
            for (String trim : split$default2) {
                arrayList2.add(StringsKt.trim((CharSequence) trim).toString());
            }
            CollectionsKt.addAll(arrayList, arrayList2);
        }
        return arrayList;
    }
}
