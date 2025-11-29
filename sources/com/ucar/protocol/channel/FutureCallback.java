package com.ucar.protocol.channel;

import com.ucar.protocol.UCarMessage;

public interface FutureCallback<T> {
    void a(Object obj);

    Object b(UCarMessage uCarMessage);

    void c(Exception exc);
}
