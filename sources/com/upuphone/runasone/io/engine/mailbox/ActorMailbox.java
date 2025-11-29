package com.upuphone.runasone.io.engine.mailbox;

import com.upuphone.runasone.io.engine.message.Message;

public interface ActorMailbox {
    void clear();

    boolean isEmpty();

    void offer(Message message);

    Message poll();

    int size();
}
