package io.ktor.client;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u0003\"\b\b\u0002\u0010\u0005*\u00020\u0006*\u00020\u0003H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "TBuilder", "", "TPlugin", "T", "Lio/ktor/client/engine/HttpClientEngineConfig;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
final class HttpClientConfig$install$2 extends Lambda implements Function1<Object, Unit> {
    final /* synthetic */ Function1<Object, Unit> $configure;
    final /* synthetic */ Function1<Object, Unit> $previousConfigBlock;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HttpClientConfig$install$2(Function1<Object, Unit> function1, Function1<Object, Unit> function12) {
        super(1);
        this.$previousConfigBlock = function1;
        this.$configure = function12;
    }

    public final void invoke(@NotNull Object obj) {
        Intrinsics.checkNotNullParameter(obj, "$this$null");
        Function1<Object, Unit> function1 = this.$previousConfigBlock;
        if (function1 != null) {
            function1.invoke(obj);
        }
        this.$configure.invoke(obj);
    }
}
