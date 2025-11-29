package io.ktor.client.call;

import io.ktor.http.content.OutgoingContent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"Lio/ktor/client/call/UnsupportedContentTypeException;", "Ljava/lang/IllegalStateException;", "Lkotlin/IllegalStateException;", "content", "Lio/ktor/http/content/OutgoingContent;", "(Lio/ktor/http/content/OutgoingContent;)V", "ktor-client-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class UnsupportedContentTypeException extends IllegalStateException {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UnsupportedContentTypeException(@NotNull OutgoingContent outgoingContent) {
        super("Failed to write body: " + Reflection.getOrCreateKotlinClass(outgoingContent.getClass()));
        Intrinsics.checkNotNullParameter(outgoingContent, "content");
    }
}
