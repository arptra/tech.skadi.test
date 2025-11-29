package io.ktor.http;

import io.ktor.util.StringValuesKt;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000@\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u001a\u0015\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0015\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\b\u001a\u0015\u0010\t\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\t\u0010\n\u001a\u0015\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b\f\u0010\r\u001a\u0019\u0010\u000e\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u0019\u0010\u0010\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b\u0010\u0010\u0011\u001a-\u0010\u001a\u001a\u00020\u0019*\u00060\u0012j\u0002`\u00132\u0006\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u001a\u0010\u001b\u001a+\u0010 \u001a\u00020\u0019*\u00060\u001cj\u0002`\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u00002\b\u0010\u001f\u001a\u0004\u0018\u00010\u0000H\u0000¢\u0006\u0004\b \u0010!\"\u0015\u0010$\u001a\u00020\u0000*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\"\u0010#¨\u0006%"}, d2 = {"", "urlString", "Lio/ktor/http/Url;", "d", "(Ljava/lang/String;)Lio/ktor/http/Url;", "Lio/ktor/http/URLBuilder;", "builder", "c", "(Lio/ktor/http/URLBuilder;)Lio/ktor/http/Url;", "b", "(Ljava/lang/String;)Lio/ktor/http/URLBuilder;", "url", "a", "(Lio/ktor/http/Url;)Lio/ktor/http/URLBuilder;", "h", "(Lio/ktor/http/URLBuilder;Lio/ktor/http/URLBuilder;)Lio/ktor/http/URLBuilder;", "i", "(Lio/ktor/http/URLBuilder;Lio/ktor/http/Url;)Lio/ktor/http/URLBuilder;", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "encodedPath", "Lio/ktor/http/ParametersBuilder;", "encodedQueryParameters", "", "trailingQuery", "", "e", "(Ljava/lang/Appendable;Ljava/lang/String;Lio/ktor/http/ParametersBuilder;Z)V", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "encodedUser", "encodedPassword", "f", "(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V", "g", "(Lio/ktor/http/Url;)Ljava/lang/String;", "hostWithPort", "ktor-http"}, k = 2, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nURLUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 URLUtils.kt\nio/ktor/http/URLUtilsKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,165:1\n1#2:166\n1360#3:167\n1446#3,2:168\n1549#3:170\n1620#3,3:171\n1448#3,3:174\n*S KotlinDebug\n*F\n+ 1 URLUtils.kt\nio/ktor/http/URLUtilsKt\n*L\n118#1:167\n118#1:168,2\n119#1:170\n119#1:171,3\n118#1:174,3\n*E\n"})
public final class URLUtilsKt {
    public static final URLBuilder a(Url url) {
        Intrinsics.checkNotNullParameter(url, "url");
        return i(new URLBuilder((URLProtocol) null, (String) null, 0, (String) null, (String) null, (List) null, (Parameters) null, (String) null, false, 511, (DefaultConstructorMarker) null), url);
    }

    public static final URLBuilder b(String str) {
        Intrinsics.checkNotNullParameter(str, "urlString");
        return URLParserKt.j(new URLBuilder((URLProtocol) null, (String) null, 0, (String) null, (String) null, (List) null, (Parameters) null, (String) null, false, 511, (DefaultConstructorMarker) null), str);
    }

    public static final Url c(URLBuilder uRLBuilder) {
        Intrinsics.checkNotNullParameter(uRLBuilder, "builder");
        return h(new URLBuilder((URLProtocol) null, (String) null, 0, (String) null, (String) null, (List) null, (Parameters) null, (String) null, false, 511, (DefaultConstructorMarker) null), uRLBuilder).b();
    }

    public static final Url d(String str) {
        Intrinsics.checkNotNullParameter(str, "urlString");
        return b(str).b();
    }

    public static final void e(Appendable appendable, String str, ParametersBuilder parametersBuilder, boolean z) {
        List list;
        Intrinsics.checkNotNullParameter(appendable, "<this>");
        Intrinsics.checkNotNullParameter(str, "encodedPath");
        Intrinsics.checkNotNullParameter(parametersBuilder, "encodedQueryParameters");
        if ((!StringsKt.isBlank(str)) && !StringsKt.startsWith$default(str, "/", false, 2, (Object) null)) {
            appendable.append('/');
        }
        appendable.append(str);
        if (!parametersBuilder.isEmpty() || z) {
            appendable.append("?");
        }
        Set<Map.Entry> entries = parametersBuilder.entries();
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : entries) {
            String str2 = (String) entry.getKey();
            List<String> list2 = (List) entry.getValue();
            if (list2.isEmpty()) {
                list = CollectionsKt.listOf(TuplesKt.to(str2, null));
            } else {
                ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
                for (String str3 : list2) {
                    arrayList2.add(TuplesKt.to(str2, str3));
                }
                list = arrayList2;
            }
            CollectionsKt.addAll(arrayList, list);
        }
        CollectionsKt.joinTo$default(arrayList, appendable, "&", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, URLUtilsKt$appendUrlFullPath$2.INSTANCE, 60, (Object) null);
    }

    public static final void f(StringBuilder sb, String str, String str2) {
        Intrinsics.checkNotNullParameter(sb, "<this>");
        if (str != null) {
            sb.append(str);
            if (str2 != null) {
                sb.append(':');
                sb.append(str2);
            }
            sb.append("@");
        }
    }

    public static final String g(Url url) {
        Intrinsics.checkNotNullParameter(url, "<this>");
        return url.g() + ':' + url.j();
    }

    public static final URLBuilder h(URLBuilder uRLBuilder, URLBuilder uRLBuilder2) {
        Intrinsics.checkNotNullParameter(uRLBuilder, "<this>");
        Intrinsics.checkNotNullParameter(uRLBuilder2, "url");
        uRLBuilder.y(uRLBuilder2.o());
        uRLBuilder.w(uRLBuilder2.j());
        uRLBuilder.x(uRLBuilder2.n());
        uRLBuilder.u(uRLBuilder2.g());
        uRLBuilder.v(uRLBuilder2.h());
        uRLBuilder.t(uRLBuilder2.f());
        ParametersBuilder b = ParametersKt.b(0, 1, (Object) null);
        StringValuesKt.c(b, uRLBuilder2.e());
        uRLBuilder.s(b);
        uRLBuilder.r(uRLBuilder2.d());
        uRLBuilder.z(uRLBuilder2.p());
        return uRLBuilder;
    }

    public static final URLBuilder i(URLBuilder uRLBuilder, Url url) {
        Intrinsics.checkNotNullParameter(uRLBuilder, "<this>");
        Intrinsics.checkNotNullParameter(url, "url");
        uRLBuilder.y(url.k());
        uRLBuilder.w(url.g());
        uRLBuilder.x(url.j());
        URLBuilderKt.k(uRLBuilder, url.d());
        uRLBuilder.v(url.f());
        uRLBuilder.t(url.c());
        ParametersBuilder b = ParametersKt.b(0, 1, (Object) null);
        b.d(QueryKt.d(url.e(), 0, 0, false, 6, (Object) null));
        uRLBuilder.s(b);
        uRLBuilder.r(url.b());
        uRLBuilder.z(url.m());
        return uRLBuilder;
    }
}
