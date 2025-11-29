package io.ktor.http;

import com.geetest.sdk.q;
import com.honey.account.constant.AccountConstantKt;
import com.upuphone.starrynet.payload.PayloadConstant;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0006\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\nR\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0012\u0010\u0017R\u0017\u0010\u001b\u001a\u00020\u00188\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0019\u001a\u0004\b\u0015\u0010\u001a¨\u0006\u001c"}, d2 = {"Lio/ktor/http/HeaderValue;", "", "", "value", "", "Lio/ktor/http/HeaderValueParam;", "params", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "Ljava/lang/String;", "c", "b", "Ljava/util/List;", "()Ljava/util/List;", "", "D", "()D", "quality", "ktor-http"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nHttpHeaderValueParser.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HttpHeaderValueParser.kt\nio/ktor/http/HeaderValue\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,224:1\n288#2,2:225\n1#3:227\n*S KotlinDebug\n*F\n+ 1 HttpHeaderValueParser.kt\nio/ktor/http/HeaderValue\n*L\n38#1:225,2\n*E\n"})
public final class HeaderValue {

    /* renamed from: a  reason: collision with root package name */
    public final String f8958a;
    public final List b;
    public final double c;

    public HeaderValue(String str, List list) {
        Double d;
        Object obj;
        String b2;
        Double doubleOrNull;
        Intrinsics.checkNotNullParameter(str, AccountConstantKt.RESPONSE_VALUE);
        Intrinsics.checkNotNullParameter(list, PayloadConstant.KEY_PARAMS);
        this.f8958a = str;
        this.b = list;
        Iterator it = list.iterator();
        while (true) {
            d = null;
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual((Object) ((HeaderValueParam) obj).a(), (Object) q.f)) {
                break;
            }
        }
        HeaderValueParam headerValueParam = (HeaderValueParam) obj;
        double d2 = 1.0d;
        if (!(headerValueParam == null || (b2 = headerValueParam.b()) == null || (doubleOrNull = StringsKt.toDoubleOrNull(b2)) == null)) {
            double doubleValue = doubleOrNull.doubleValue();
            if (0.0d <= doubleValue && doubleValue <= 1.0d) {
                d = doubleOrNull;
            }
            if (d != null) {
                d2 = d.doubleValue();
            }
        }
        this.c = d2;
    }

    public final List a() {
        return this.b;
    }

    public final double b() {
        return this.c;
    }

    public final String c() {
        return this.f8958a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HeaderValue)) {
            return false;
        }
        HeaderValue headerValue = (HeaderValue) obj;
        return Intrinsics.areEqual((Object) this.f8958a, (Object) headerValue.f8958a) && Intrinsics.areEqual((Object) this.b, (Object) headerValue.b);
    }

    public int hashCode() {
        return (this.f8958a.hashCode() * 31) + this.b.hashCode();
    }

    public String toString() {
        return "HeaderValue(value=" + this.f8958a + ", params=" + this.b + ')';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ HeaderValue(String str, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? CollectionsKt.emptyList() : list);
    }
}
