package io.ktor.client.plugins.cache;

import io.ktor.http.Headers;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
public /* synthetic */ class HttpCacheLegacyKt$findResponse$requestHeaders$1 extends FunctionReferenceImpl implements Function1<String, String> {
    public HttpCacheLegacyKt$findResponse$requestHeaders$1(Object obj) {
        super(1, obj, Headers.class, "get", "get(Ljava/lang/String;)Ljava/lang/String;", 0);
    }

    @Nullable
    public final String invoke(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "p0");
        return ((Headers) this.receiver).get(str);
    }
}
