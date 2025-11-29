package com.ucar.protocol.channel;

import com.ucar.protocol.UCarMessage;
import java.io.Closeable;

public interface UCarChannel extends Closeable {

    public interface MessageHandler {
        void a(UCarMessage uCarMessage);
    }
}
