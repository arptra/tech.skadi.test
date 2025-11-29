package io.ktor.client.plugins;

import io.ktor.client.statement.HttpResponse;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lio/ktor/client/plugins/ServerResponseException;", "Lio/ktor/client/plugins/ResponseException;", "response", "Lio/ktor/client/statement/HttpResponse;", "(Lio/ktor/client/statement/HttpResponse;)V", "cachedResponseText", "", "(Lio/ktor/client/statement/HttpResponse;Ljava/lang/String;)V", "message", "getMessage", "()Ljava/lang/String;", "ktor-client-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ServerResponseException extends ResponseException {
    @NotNull
    private final String message;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ServerResponseException(@NotNull HttpResponse httpResponse, @NotNull String str) {
        super(httpResponse, str);
        Intrinsics.checkNotNullParameter(httpResponse, "response");
        Intrinsics.checkNotNullParameter(str, "cachedResponseText");
        this.message = "Server error(" + httpResponse.p0().f().getMethod().c() + ' ' + httpResponse.p0().f().T() + ": " + httpResponse.f() + ". Text: \"" + str + '\"';
    }

    @NotNull
    public String getMessage() {
        return this.message;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @Deprecated(level = DeprecationLevel.ERROR, message = "Please, provide response text in constructor")
    public ServerResponseException(@NotNull HttpResponse httpResponse) {
        this(httpResponse, "<no response text provided>");
        Intrinsics.checkNotNullParameter(httpResponse, "response");
    }
}
