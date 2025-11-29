package io.ktor.client.plugins.cache;

import io.ktor.http.Headers;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
public /* synthetic */ class HttpCache$findResponse$requestHeaders$2 extends FunctionReferenceImpl implements Function1<String, List<? extends String>> {
    public HttpCache$findResponse$requestHeaders$2(Object obj) {
        super(1, obj, Headers.class, "getAll", "getAll(Ljava/lang/String;)Ljava/util/List;", 0);
    }

    @Nullable
    public final List<String> invoke(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "p0");
        return ((Headers) this.receiver).a(str);
    }
}
