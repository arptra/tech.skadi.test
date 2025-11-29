package io.ktor.http;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000f\b&\u0018\u0000 \n2\u00020\u0001:\u0001\u0013B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\f\u0010\rR\u001a\u0010\u0003\u001a\u00020\u00028\u0004X\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\rR\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0010\u0010\u0012¨\u0006\u0014"}, d2 = {"Lio/ktor/http/HeaderValueWithParameters;", "", "", "content", "", "Lio/ktor/http/HeaderValueParam;", "parameters", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "name", "c", "(Ljava/lang/String;)Ljava/lang/String;", "toString", "()Ljava/lang/String;", "a", "Ljava/lang/String;", "b", "Ljava/util/List;", "()Ljava/util/List;", "Companion", "ktor-http"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nHeaderValueWithParameters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HeaderValueWithParameters.kt\nio/ktor/http/HeaderValueWithParameters\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 HeaderValueWithParameters.kt\nio/ktor/http/HeaderValueWithParametersKt\n*L\n1#1,152:1\n1#2:153\n86#3,5:154\n*S KotlinDebug\n*F\n+ 1 HeaderValueWithParameters.kt\nio/ktor/http/HeaderValueWithParameters\n*L\n52#1:154,5\n*E\n"})
public abstract class HeaderValueWithParameters {
    public static final Companion c = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public final String f8960a;
    public final List b;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lio/ktor/http/HeaderValueWithParameters$Companion;", "", "<init>", "()V", "ktor-http"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public HeaderValueWithParameters(String str, List list) {
        Intrinsics.checkNotNullParameter(str, "content");
        Intrinsics.checkNotNullParameter(list, "parameters");
        this.f8960a = str;
        this.b = list;
    }

    public final String a() {
        return this.f8960a;
    }

    public final List b() {
        return this.b;
    }

    public final String c(String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        int lastIndex = CollectionsKt.getLastIndex(this.b);
        if (lastIndex < 0) {
            return null;
        }
        int i = 0;
        while (true) {
            HeaderValueParam headerValueParam = (HeaderValueParam) this.b.get(i);
            if (StringsKt.equals(headerValueParam.a(), str, true)) {
                return headerValueParam.b();
            }
            if (i == lastIndex) {
                return null;
            }
            i++;
        }
    }

    public String toString() {
        if (this.b.isEmpty()) {
            return this.f8960a;
        }
        int length = this.f8960a.length();
        int i = 0;
        int i2 = 0;
        for (HeaderValueParam headerValueParam : this.b) {
            i2 += headerValueParam.a().length() + headerValueParam.b().length() + 3;
        }
        StringBuilder sb = new StringBuilder(length + i2);
        sb.append(this.f8960a);
        int lastIndex = CollectionsKt.getLastIndex(this.b);
        if (lastIndex >= 0) {
            while (true) {
                HeaderValueParam headerValueParam2 = (HeaderValueParam) this.b.get(i);
                sb.append("; ");
                sb.append(headerValueParam2.a());
                sb.append("=");
                String b2 = headerValueParam2.b();
                if (HeaderValueWithParametersKt.d(b2)) {
                    sb.append(HeaderValueWithParametersKt.e(b2));
                } else {
                    sb.append(b2);
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "{\n            val size =…   }.toString()\n        }");
        return sb2;
    }
}
