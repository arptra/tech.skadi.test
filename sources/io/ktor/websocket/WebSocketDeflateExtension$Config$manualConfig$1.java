package io.ktor.websocket;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "", "Lio/ktor/websocket/WebSocketExtensionHeader;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
public final class WebSocketDeflateExtension$Config$manualConfig$1 extends Lambda implements Function1<List<WebSocketExtensionHeader>, Unit> {
    public static final WebSocketDeflateExtension$Config$manualConfig$1 INSTANCE = new WebSocketDeflateExtension$Config$manualConfig$1();

    public WebSocketDeflateExtension$Config$manualConfig$1() {
        super(1);
    }

    public final void invoke(@NotNull List<WebSocketExtensionHeader> list) {
        Intrinsics.checkNotNullParameter(list, "it");
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((List<WebSocketExtensionHeader>) (List) obj);
        return Unit.INSTANCE;
    }
}
