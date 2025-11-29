package org.java_websocket.extensions;

import org.java_websocket.exceptions.InvalidFrameException;
import org.java_websocket.framing.ControlFrame;
import org.java_websocket.framing.DataFrame;
import org.java_websocket.framing.Framedata;

public abstract class CompressionExtension extends DefaultExtension {
    public void h(Framedata framedata) {
        if ((framedata instanceof DataFrame) && (framedata.c() || framedata.e())) {
            throw new InvalidFrameException("bad rsv RSV1: " + framedata.b() + " RSV2: " + framedata.c() + " RSV3: " + framedata.e());
        } else if (!(framedata instanceof ControlFrame)) {
        } else {
            if (framedata.b() || framedata.c() || framedata.e()) {
                throw new InvalidFrameException("bad rsv RSV1: " + framedata.b() + " RSV2: " + framedata.c() + " RSV3: " + framedata.e());
            }
        }
    }
}
