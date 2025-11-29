package com.upuphone.runasone.io.engine.message;

import com.upuphone.runasone.io.engine.Actor;

public interface Message {
    Object getData();

    Actor getSender();
}
