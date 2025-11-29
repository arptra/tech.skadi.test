package com.upuphone.runasone.io.engine;

import com.upuphone.runasone.io.engine.mailbox.PriorityMailbox;

public abstract class PriorityActor extends AbstractActor {
    public PriorityActor() {
        super(new PriorityMailbox());
    }
}
