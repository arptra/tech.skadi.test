package com.upuphone.runasone.io.engine.mailbox;

import com.upuphone.runasone.io.engine.message.Message;
import java.util.ArrayDeque;

public class DefaultMailbox implements ActorMailbox {
    private final ArrayDeque<Message> mailbox;

    public DefaultMailbox() {
        this(32);
    }

    public void clear() {
        this.mailbox.clear();
    }

    public boolean isEmpty() {
        return this.mailbox.isEmpty();
    }

    public void offer(Message message) {
        this.mailbox.offer(message);
    }

    public Message poll() {
        return this.mailbox.poll();
    }

    public int size() {
        return this.mailbox.size();
    }

    public DefaultMailbox(int i) {
        this.mailbox = new ArrayDeque<>(i);
    }
}
