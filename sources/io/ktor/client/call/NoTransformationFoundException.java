package io.ktor.client.call;

import io.ktor.client.statement.HttpResponse;
import io.ktor.client.statement.HttpResponseKt;
import io.ktor.http.Headers;
import io.ktor.http.HttpHeaders;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00060\u0001j\u0002`\u0002B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0006\u0012\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u0006¢\u0006\u0002\u0010\bR\u0016\u0010\t\u001a\u0004\u0018\u00010\nX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lio/ktor/client/call/NoTransformationFoundException;", "Ljava/lang/UnsupportedOperationException;", "Lkotlin/UnsupportedOperationException;", "response", "Lio/ktor/client/statement/HttpResponse;", "from", "Lkotlin/reflect/KClass;", "to", "(Lio/ktor/client/statement/HttpResponse;Lkotlin/reflect/KClass;Lkotlin/reflect/KClass;)V", "message", "", "getMessage", "()Ljava/lang/String;", "ktor-client-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class NoTransformationFoundException extends UnsupportedOperationException {
    @Nullable
    private final String message;

    public NoTransformationFoundException(@NotNull HttpResponse httpResponse, @NotNull KClass<?> kClass, @NotNull KClass<?> kClass2) {
        Intrinsics.checkNotNullParameter(httpResponse, "response");
        Intrinsics.checkNotNullParameter(kClass, "from");
        Intrinsics.checkNotNullParameter(kClass2, "to");
        StringBuilder sb = new StringBuilder();
        sb.append("\n        Expected response body of the type '");
        sb.append(kClass2);
        sb.append("' but was '");
        sb.append(kClass);
        sb.append("'\n        In response from `");
        sb.append(HttpResponseKt.e(httpResponse).T());
        sb.append("`\n        Response status `");
        sb.append(httpResponse.f());
        sb.append("`\n        Response header `ContentType: ");
        Headers a2 = httpResponse.a();
        HttpHeaders httpHeaders = HttpHeaders.f8966a;
        sb.append(a2.get(httpHeaders.k()));
        sb.append("` \n        Request header `Accept: ");
        sb.append(HttpResponseKt.e(httpResponse).a().get(httpHeaders.c()));
        sb.append("`\n        \n        You can read how to resolve NoTransformationFoundException at FAQ: \n        https://ktor.io/docs/faq.html#no-transformation-found-exception\n    ");
        this.message = StringsKt.trimIndent(sb.toString());
    }

    @Nullable
    public String getMessage() {
        return this.message;
    }
}
