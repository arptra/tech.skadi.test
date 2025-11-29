package com.ucar.protocol.channel;

import java.io.IOException;

public class ChannelException extends IOException {
    public ChannelException(String str, Throwable th) {
        super(str, th);
    }

    public ChannelException(String str) {
        super(str);
    }
}
