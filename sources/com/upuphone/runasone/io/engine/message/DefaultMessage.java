package com.upuphone.runasone.io.engine.message;

import com.upuphone.runasone.io.engine.Actor;

public class DefaultMessage implements Message {
    private final Object data;
    private final Actor sender;

    public DefaultMessage(Actor actor, Object obj) {
        this.sender = actor;
        this.data = obj;
    }

    public String bodyString() {
        return "sender=" + this.sender + ", data=" + this.data;
    }

    public Object getData() {
        return this.data;
    }

    public Actor getSender() {
        return this.sender;
    }

    public String toString() {
        return getClass().getSimpleName() + "[" + bodyString() + "]";
    }
}
