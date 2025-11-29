package io.ktor.http;

import io.ktor.http.ContentType;
import java.util.Comparator;
import kotlin.Metadata;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$thenBy$1"}, k = 3, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nComparisons.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Comparisons.kt\nkotlin/comparisons/ComparisonsKt__ComparisonsKt$thenBy$1\n+ 2 HttpHeaderValueParser.kt\nio/ktor/http/HttpHeaderValueParserKt\n*L\n1#1,328:1\n56#2,9:329\n*E\n"})
public final class HttpHeaderValueParserKt$parseAndSortContentTypeHeader$$inlined$thenBy$1<T> implements Comparator {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Comparator f8964a;

    public final int compare(Object obj, Object obj2) {
        int compare = this.f8964a.compare(obj, obj2);
        if (compare != 0) {
            return compare;
        }
        ContentType.Companion companion = ContentType.f;
        ContentType b = companion.b(((HeaderValue) obj).c());
        int i = 2;
        int i2 = Intrinsics.areEqual((Object) b.f(), (Object) "*") ? 2 : 0;
        if (Intrinsics.areEqual((Object) b.e(), (Object) "*")) {
            i2++;
        }
        Integer valueOf = Integer.valueOf(i2);
        ContentType b2 = companion.b(((HeaderValue) obj2).c());
        if (!Intrinsics.areEqual((Object) b2.f(), (Object) "*")) {
            i = 0;
        }
        if (Intrinsics.areEqual((Object) b2.e(), (Object) "*")) {
            i++;
        }
        return ComparisonsKt.compareValues(valueOf, Integer.valueOf(i));
    }
}
