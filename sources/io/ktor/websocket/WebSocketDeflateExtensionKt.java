package io.ktor.websocket;

import io.ktor.websocket.Frame;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lio/ktor/websocket/Frame;", "", "b", "(Lio/ktor/websocket/Frame;)Z", "ktor-websockets"}, k = 2, mv = {1, 8, 0})
public final class WebSocketDeflateExtensionKt {
    public static final boolean b(Frame frame) {
        return frame.e() && ((frame instanceof Frame.Text) || (frame instanceof Frame.Binary));
    }
}
