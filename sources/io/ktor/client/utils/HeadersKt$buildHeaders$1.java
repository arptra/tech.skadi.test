package io.ktor.client.utils;

import io.ktor.http.HeadersBuilder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lio/ktor/http/HeadersBuilder;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
final class HeadersKt$buildHeaders$1 extends Lambda implements Function1<HeadersBuilder, Unit> {
    public static final HeadersKt$buildHeaders$1 INSTANCE = new HeadersKt$buildHeaders$1();

    public HeadersKt$buildHeaders$1() {
        super(1);
    }

    public final void invoke(@NotNull HeadersBuilder headersBuilder) {
        Intrinsics.checkNotNullParameter(headersBuilder, "$this$null");
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((HeadersBuilder) obj);
        return Unit.INSTANCE;
    }
}
