package io.ktor.client.plugins;

import io.ktor.client.statement.HttpResponse;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0016\u0018\u00002\u00060\u0001j\u0002`\u0002B\u000f\b\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lio/ktor/client/plugins/ResponseException;", "Ljava/lang/IllegalStateException;", "Lkotlin/IllegalStateException;", "response", "Lio/ktor/client/statement/HttpResponse;", "(Lio/ktor/client/statement/HttpResponse;)V", "cachedResponseText", "", "(Lio/ktor/client/statement/HttpResponse;Ljava/lang/String;)V", "getResponse", "()Lio/ktor/client/statement/HttpResponse;", "ktor-client-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class ResponseException extends IllegalStateException {
    @NotNull
    private final transient HttpResponse response;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ResponseException(@NotNull HttpResponse httpResponse, @NotNull String str) {
        super("Bad response: " + httpResponse + ". Text: \"" + str + '\"');
        Intrinsics.checkNotNullParameter(httpResponse, "response");
        Intrinsics.checkNotNullParameter(str, "cachedResponseText");
        this.response = httpResponse;
    }

    @NotNull
    public final HttpResponse getResponse() {
        return this.response;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @Deprecated(level = DeprecationLevel.ERROR, message = "Please, provide response text in constructor")
    public ResponseException(@NotNull HttpResponse httpResponse) {
        this(httpResponse, "<no response text provided>");
        Intrinsics.checkNotNullParameter(httpResponse, "response");
    }
}
