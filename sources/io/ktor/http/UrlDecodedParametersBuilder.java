package io.ktor.http;

import com.honey.account.constant.AccountConstantKt;
import io.ktor.util.StringValues;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0004\n\u0002\u0010&\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001c\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\n2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\b0\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J'\u0010\u0016\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\n0\u00150\u0010H\u0016¢\u0006\u0004\b\u0016\u0010\u0012J\u001f\u0010\u0019\u001a\u00020\u00182\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ%\u0010!\u001a\u00020\u00182\u0006\u0010\t\u001a\u00020\b2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\b0\u001fH\u0016¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\u0018H\u0016¢\u0006\u0004\b#\u0010$R\u0014\u0010\u0002\u001a\u00020\u00018\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010%R\u001a\u0010(\u001a\u00020\r8\u0016X\u0004¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b&\u0010\u0014¨\u0006)"}, d2 = {"Lio/ktor/http/UrlDecodedParametersBuilder;", "Lio/ktor/http/ParametersBuilder;", "encodedParametersBuilder", "<init>", "(Lio/ktor/http/ParametersBuilder;)V", "Lio/ktor/http/Parameters;", "build", "()Lio/ktor/http/Parameters;", "", "name", "", "a", "(Ljava/lang/String;)Ljava/util/List;", "", "contains", "(Ljava/lang/String;)Z", "", "names", "()Ljava/util/Set;", "isEmpty", "()Z", "", "entries", "value", "", "e", "(Ljava/lang/String;Ljava/lang/String;)V", "Lio/ktor/util/StringValues;", "stringValues", "d", "(Lio/ktor/util/StringValues;)V", "", "values", "c", "(Ljava/lang/String;Ljava/lang/Iterable;)V", "clear", "()V", "Lio/ktor/http/ParametersBuilder;", "b", "Z", "caseInsensitiveName", "ktor-http"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nUrlDecodedParametersBuilder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 UrlDecodedParametersBuilder.kt\nio/ktor/http/UrlDecodedParametersBuilder\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,88:1\n1549#2:89\n1620#2,3:90\n1549#2:93\n1620#2,3:94\n1549#2:97\n1620#2,3:98\n1549#2:101\n1620#2,3:102\n*S KotlinDebug\n*F\n+ 1 UrlDecodedParametersBuilder.kt\nio/ktor/http/UrlDecodedParametersBuilder\n*L\n18#1:89\n18#1:90,3\n26#1:93\n26#1:94,3\n44#1:97\n44#1:98,3\n50#1:101\n50#1:102,3\n*E\n"})
public final class UrlDecodedParametersBuilder implements ParametersBuilder {

    /* renamed from: a  reason: collision with root package name */
    public final ParametersBuilder f8981a;
    public final boolean b;

    public UrlDecodedParametersBuilder(ParametersBuilder parametersBuilder) {
        Intrinsics.checkNotNullParameter(parametersBuilder, "encodedParametersBuilder");
        this.f8981a = parametersBuilder;
        this.b = parametersBuilder.b();
    }

    public List a(String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        ArrayList arrayList = null;
        List<String> a2 = this.f8981a.a(CodecsKt.m(str, false, 1, (Object) null));
        if (a2 != null) {
            arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(a2, 10));
            for (String k : a2) {
                arrayList.add(CodecsKt.k(k, 0, 0, true, (Charset) null, 11, (Object) null));
            }
        }
        return arrayList;
    }

    public boolean b() {
        return this.b;
    }

    public Parameters build() {
        return UrlDecodedParametersBuilderKt.d(this.f8981a);
    }

    public void c(String str, Iterable iterable) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(iterable, "values");
        ParametersBuilder parametersBuilder = this.f8981a;
        String m = CodecsKt.m(str, false, 1, (Object) null);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(CodecsKt.n((String) it.next()));
        }
        parametersBuilder.c(m, arrayList);
    }

    public void clear() {
        this.f8981a.clear();
    }

    public boolean contains(String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        return this.f8981a.contains(CodecsKt.m(str, false, 1, (Object) null));
    }

    public void d(StringValues stringValues) {
        Intrinsics.checkNotNullParameter(stringValues, "stringValues");
        UrlDecodedParametersBuilderKt.c(this.f8981a, stringValues);
    }

    public void e(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, AccountConstantKt.RESPONSE_VALUE);
        this.f8981a.e(CodecsKt.m(str, false, 1, (Object) null), CodecsKt.n(str2));
    }

    public Set entries() {
        return UrlDecodedParametersBuilderKt.d(this.f8981a).entries();
    }

    public boolean isEmpty() {
        return this.f8981a.isEmpty();
    }

    public Set names() {
        Set<String> names = this.f8981a.names();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(names, 10));
        for (String k : names) {
            arrayList.add(CodecsKt.k(k, 0, 0, false, (Charset) null, 15, (Object) null));
        }
        return CollectionsKt.toSet(arrayList);
    }
}
