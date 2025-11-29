package io.ktor.http.content;

import io.ktor.http.ContentDisposition;
import io.ktor.http.HttpHeaders;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lio/ktor/http/ContentDisposition;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nMultipart.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Multipart.kt\nio/ktor/http/content/PartData$contentDisposition$2\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,149:1\n1#2:150\n*E\n"})
final class PartData$contentDisposition$2 extends Lambda implements Function0<ContentDisposition> {
    final /* synthetic */ PartData this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PartData$contentDisposition$2(PartData partData) {
        super(0);
        this.this$0 = partData;
    }

    @Nullable
    public final ContentDisposition invoke() {
        String str = this.this$0.a().get(HttpHeaders.f8966a.h());
        if (str != null) {
            return ContentDisposition.d.a(str);
        }
        return null;
    }
}
