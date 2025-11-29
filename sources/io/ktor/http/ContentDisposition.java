package io.ktor.http;

import com.honey.account.constant.AccountConstantKt;
import io.ktor.http.HeaderValueWithParameters;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 \u00112\u00020\u0001:\u0002\u0013\u0014B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0003\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lio/ktor/http/ContentDisposition;", "Lio/ktor/http/HeaderValueWithParameters;", "", "disposition", "", "Lio/ktor/http/HeaderValueParam;", "parameters", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "d", "()Ljava/lang/String;", "Companion", "Parameters", "ktor-http"}, k = 1, mv = {1, 8, 0})
public final class ContentDisposition extends HeaderValueWithParameters {
    public static final Companion d = new Companion((DefaultConstructorMarker) null);
    public static final ContentDisposition e = new ContentDisposition("file", (List) null, 2, (DefaultConstructorMarker) null);
    public static final ContentDisposition f = new ContentDisposition("mixed", (List) null, 2, (DefaultConstructorMarker) null);
    public static final ContentDisposition g = new ContentDisposition("attachment", (List) null, 2, (DefaultConstructorMarker) null);
    public static final ContentDisposition h = new ContentDisposition("inline", (List) null, 2, (DefaultConstructorMarker) null);

    @SourceDebugExtension({"SMAP\nContentDisposition.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ContentDisposition.kt\nio/ktor/http/ContentDisposition$Companion\n+ 2 HeaderValueWithParameters.kt\nio/ktor/http/HeaderValueWithParameters$Companion\n*L\n1#1,103:1\n63#2,2:104\n*S KotlinDebug\n*F\n+ 1 ContentDisposition.kt\nio/ktor/http/ContentDisposition$Companion\n*L\n76#1:104,2\n*E\n"})
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lio/ktor/http/ContentDisposition$Companion;", "", "<init>", "()V", "", "value", "Lio/ktor/http/ContentDisposition;", "a", "(Ljava/lang/String;)Lio/ktor/http/ContentDisposition;", "ktor-http"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ContentDisposition a(String str) {
            Intrinsics.checkNotNullParameter(str, AccountConstantKt.RESPONSE_VALUE);
            HeaderValueWithParameters.Companion companion = HeaderValueWithParameters.c;
            HeaderValue headerValue = (HeaderValue) CollectionsKt.last(HttpHeaderValueParserKt.b(str));
            return new ContentDisposition(headerValue.c(), headerValue.a());
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lio/ktor/http/ContentDisposition$Parameters;", "", "<init>", "()V", "ktor-http"}, k = 1, mv = {1, 8, 0})
    public static final class Parameters {

        /* renamed from: a  reason: collision with root package name */
        public static final Parameters f8941a = new Parameters();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ContentDisposition(String str, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? CollectionsKt.emptyList() : list);
    }

    public final String d() {
        return a();
    }

    public boolean equals(Object obj) {
        if (obj instanceof ContentDisposition) {
            ContentDisposition contentDisposition = (ContentDisposition) obj;
            return Intrinsics.areEqual((Object) d(), (Object) contentDisposition.d()) && Intrinsics.areEqual((Object) b(), (Object) contentDisposition.b());
        }
    }

    public int hashCode() {
        return (d().hashCode() * 31) + b().hashCode();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ContentDisposition(String str, List list) {
        super(str, list);
        Intrinsics.checkNotNullParameter(str, "disposition");
        Intrinsics.checkNotNullParameter(list, "parameters");
    }
}
