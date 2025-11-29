package com.upuphone.runasone.io.engine;

import com.upuphone.runasone.io.engine.mailbox.DefaultMailbox;

public abstract class DefaultActor extends AbstractActor {
    public DefaultActor() {
        super(new DefaultMailbox());
    }
}
