package io.ktor.client.plugins.cache;

import com.meizu.common.widget.MzContactsContract;
import io.ktor.client.engine.UtilsKt;
import io.ktor.http.ContentType;
import io.ktor.http.HttpHeaders;
import io.ktor.http.content.OutgoingContent;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "header", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
public final class HttpCacheKt$mergedHeadersLookup$1 extends Lambda implements Function1<String, String> {
    final /* synthetic */ Function1<String, List<String>> $allHeadersExtractor;
    final /* synthetic */ OutgoingContent $content;
    final /* synthetic */ Function1<String, String> $headerExtractor;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HttpCacheKt$mergedHeadersLookup$1(OutgoingContent outgoingContent, Function1<? super String, String> function1, Function1<? super String, ? extends List<String>> function12) {
        super(1);
        this.$content = outgoingContent;
        this.$headerExtractor = function1;
        this.$allHeadersExtractor = function12;
    }

    @NotNull
    public final String invoke(@NotNull String str) {
        String headerValueWithParameters;
        Intrinsics.checkNotNullParameter(str, "header");
        HttpHeaders httpHeaders = HttpHeaders.f8966a;
        if (Intrinsics.areEqual((Object) str, (Object) httpHeaders.j())) {
            Long a2 = this.$content.a();
            if (a2 == null || (headerValueWithParameters = a2.toString()) == null) {
                return "";
            }
        } else if (Intrinsics.areEqual((Object) str, (Object) httpHeaders.k())) {
            ContentType b = this.$content.b();
            if (b == null || (headerValueWithParameters = b.toString()) == null) {
                return "";
            }
        } else if (Intrinsics.areEqual((Object) str, (Object) httpHeaders.B())) {
            String str2 = this.$content.c().get(httpHeaders.B());
            if (str2 != null) {
                return str2;
            }
            String invoke = this.$headerExtractor.invoke(httpHeaders.B());
            if (invoke == null) {
                return UtilsKt.b();
            }
            return invoke;
        } else {
            List a3 = this.$content.c().a(str);
            if (a3 == null && (a3 = this.$allHeadersExtractor.invoke(str)) == null) {
                a3 = CollectionsKt.emptyList();
            }
            return CollectionsKt.joinToString$default(a3, MzContactsContract.MzGroups.GROUP_SPLIT_MARK_VCARD, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
        }
        return headerValueWithParameters;
    }
}
