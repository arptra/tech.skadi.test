package com.upuphone.runasone.io;

import com.upuphone.runasone.io.engine.AbstractActor;

public interface PortOps {
    void clearAllMessage();

    void close();

    void open(AbstractActor abstractActor, String str);

    void write(Object obj);
}
