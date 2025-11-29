package com.upuphone.runasone.io;

import com.upuphone.runasone.io.engine.AbstractActor;
import com.upuphone.runasone.io.engine.ActorManager;
import com.upuphone.runasone.io.engine.message.DefaultMessage;

public class Port implements PortOps {
    ActorManager mActorManager = ActorManager.getInstance();
    AbstractActor mQueue;

    public void clearAllMessage() {
        this.mQueue.clearAllMessage();
    }

    public void close() {
        this.mActorManager.closeActor(this.mQueue);
    }

    public void open(AbstractActor abstractActor, String str) {
        ActorManager actorManager = this.mActorManager;
        this.mQueue = actorManager.initAndStartActor(abstractActor, "RunAsOne-" + str);
    }

    public void write(Object obj) {
        AbstractActor abstractActor = this.mQueue;
        abstractActor.sendMessage(new DefaultMessage(abstractActor, obj));
    }
}
