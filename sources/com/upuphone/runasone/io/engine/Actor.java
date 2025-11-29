package com.upuphone.runasone.io.engine;

import com.upuphone.runasone.io.engine.message.Message;

public interface Actor {
    void activate();

    void deactivate();

    String getGroup();

    int getMessageCount();

    String getName();

    boolean hasActive();

    boolean hasMessage();

    boolean sendMessage(Message message);

    void setGroup(String str);

    void setName(String str);
}
