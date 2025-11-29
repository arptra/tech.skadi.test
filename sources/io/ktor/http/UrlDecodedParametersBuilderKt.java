package io.ktor.http;

import io.ktor.util.StringValues;
import io.ktor.util.StringValuesBuilder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u001a\u0017\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u0005H\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a\u001b\u0010\n\u001a\u00020\t*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\n\u0010\u000b\u001a\u001b\u0010\f\u001a\u00020\t*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lio/ktor/util/StringValuesBuilder;", "parameters", "Lio/ktor/http/Parameters;", "d", "(Lio/ktor/util/StringValuesBuilder;)Lio/ktor/http/Parameters;", "Lio/ktor/util/StringValues;", "Lio/ktor/http/ParametersBuilder;", "e", "(Lio/ktor/util/StringValues;)Lio/ktor/http/ParametersBuilder;", "", "b", "(Lio/ktor/util/StringValuesBuilder;Lio/ktor/util/StringValuesBuilder;)V", "c", "(Lio/ktor/util/StringValuesBuilder;Lio/ktor/util/StringValues;)V", "ktor-http"}, k = 2, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nUrlDecodedParametersBuilder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 UrlDecodedParametersBuilder.kt\nio/ktor/http/UrlDecodedParametersBuilderKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,88:1\n1#2:89\n1855#3:90\n1549#3:91\n1620#3,3:92\n1856#3:95\n1855#3:96\n1549#3:97\n1620#3,3:98\n1856#3:101\n*S KotlinDebug\n*F\n+ 1 UrlDecodedParametersBuilder.kt\nio/ktor/http/UrlDecodedParametersBuilderKt\n*L\n72#1:90\n76#1:91\n76#1:92,3\n72#1:95\n83#1:96\n85#1:97\n85#1:98,3\n83#1:101\n*E\n"})
public final class UrlDecodedParametersBuilderKt {
    public static final void b(StringValuesBuilder stringValuesBuilder, StringValuesBuilder stringValuesBuilder2) {
        for (String str : stringValuesBuilder2.names()) {
            List<String> a2 = stringValuesBuilder2.a(str);
            if (a2 == null) {
                a2 = CollectionsKt.emptyList();
            }
            String k = CodecsKt.k(str, 0, 0, false, (Charset) null, 15, (Object) null);
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(a2, 10));
            for (String k2 : a2) {
                arrayList.add(CodecsKt.k(k2, 0, 0, true, (Charset) null, 11, (Object) null));
            }
            stringValuesBuilder.c(k, arrayList);
        }
    }

    public static final void c(StringValuesBuilder stringValuesBuilder, StringValues stringValues) {
        for (String str : stringValues.names()) {
            List<String> a2 = stringValues.a(str);
            if (a2 == null) {
                a2 = CollectionsKt.emptyList();
            }
            String m = CodecsKt.m(str, false, 1, (Object) null);
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(a2, 10));
            for (String n : a2) {
                arrayList.add(CodecsKt.n(n));
            }
            stringValuesBuilder.c(m, arrayList);
        }
    }

    public static final Parameters d(StringValuesBuilder stringValuesBuilder) {
        Intrinsics.checkNotNullParameter(stringValuesBuilder, "parameters");
        ParametersBuilder b = ParametersKt.b(0, 1, (Object) null);
        b(b, stringValuesBuilder);
        return b.build();
    }

    public static final ParametersBuilder e(StringValues stringValues) {
        Intrinsics.checkNotNullParameter(stringValues, "parameters");
        ParametersBuilder b = ParametersKt.b(0, 1, (Object) null);
        c(b, stringValues);
        return b;
    }
}
