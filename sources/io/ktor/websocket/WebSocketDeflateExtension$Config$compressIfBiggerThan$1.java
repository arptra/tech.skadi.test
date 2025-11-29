package io.ktor.websocket;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "frame", "Lio/ktor/websocket/Frame;", "invoke", "(Lio/ktor/websocket/Frame;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 8, 0}, xi = 48)
final class WebSocketDeflateExtension$Config$compressIfBiggerThan$1 extends Lambda implements Function1<Frame, Boolean> {
    final /* synthetic */ int $bytes;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WebSocketDeflateExtension$Config$compressIfBiggerThan$1(int i) {
        super(1);
        this.$bytes = i;
    }

    @NotNull
    public final Boolean invoke(@NotNull Frame frame) {
        Intrinsics.checkNotNullParameter(frame, "frame");
        return Boolean.valueOf(frame.b().length > this.$bytes);
    }
}
