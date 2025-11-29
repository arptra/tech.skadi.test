package com.upuphone.runasone.io.engine;

import com.upuphone.runasone.io.engine.mailbox.ActorMailbox;
import com.upuphone.runasone.io.engine.message.Message;
import java.util.concurrent.locks.ReentrantLock;

public abstract class AbstractActor implements Actor {
    private static final String TAG = "AbstractActor";
    protected volatile boolean active = false;
    protected ActorWorkerDispatcher dispatcher;
    protected String groupName = "";
    protected boolean inDispatcher = false;
    protected ReentrantLock lock = new ReentrantLock();
    protected ActorMailbox mailbox;
    protected String name = "";
    protected ActorState state = ActorState.NONE;

    public AbstractActor(ActorMailbox actorMailbox) {
        this.mailbox = actorMailbox;
    }

    private final void dispatcherActor() {
        if (!this.inDispatcher) {
            this.dispatcher.addActor(this);
            this.inDispatcher = true;
        }
    }

    public void activate() {
    }

    public void clearAllMessage() {
        clearMailbox();
    }

    public void clearMailbox() {
        this.lock.lock();
        try {
            this.mailbox.clear();
        } finally {
            this.lock.unlock();
        }
    }

    public void deactivate() {
    }

    public final ActorState getActorState() {
        return this.state;
    }

    public final ActorWorkerDispatcher getDispatcher() {
        return this.dispatcher;
    }

    public String getGroup() {
        return this.groupName;
    }

    public int getMessageCount() {
        return this.mailbox.size();
    }

    public String getName() {
        return this.name;
    }

    public final boolean hasActive() {
        return this.active;
    }

    public boolean hasMessage() {
        return this.mailbox.size() > 0;
    }

    public abstract void onStartup();

    public Message pollMessage() {
        this.lock.lock();
        try {
            return this.mailbox.poll();
        } finally {
            this.lock.unlock();
        }
    }

    public abstract void receive(Message message);

    public final void registerDispatcher(ActorWorkerDispatcher actorWorkerDispatcher) {
        this.dispatcher = actorWorkerDispatcher;
        setState(ActorState.START);
        this.lock.lock();
        try {
            dispatcherActor();
        } finally {
            this.lock.unlock();
        }
    }

    /* JADX INFO: finally extract failed */
    public boolean sendMessage(Message message) {
        if (!hasActive()) {
            return false;
        }
        this.lock.lock();
        try {
            this.mailbox.offer(message);
            dispatcherActor();
            this.lock.unlock();
            return true;
        } catch (Throwable th) {
            this.lock.unlock();
            throw th;
        }
    }

    public void setActive(boolean z) {
        this.active = z;
    }

    public void setGroup(String str) {
        this.groupName = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public final void setState(ActorState actorState) {
        this.state = actorState;
    }

    public final void startup() {
        try {
            onStartup();
            setState(ActorState.WORKER);
            this.lock.lock();
            try {
                if (hasMessage()) {
                    this.dispatcher.addActor(this);
                } else {
                    this.inDispatcher = false;
                }
            } finally {
                this.lock.unlock();
            }
        } catch (Throwable th) {
            this.lock.unlock();
            throw th;
        }
    }

    public final void worker() {
        try {
            Message pollMessage = pollMessage();
            if (pollMessage != null) {
                receive(pollMessage);
            }
            this.lock.lock();
            try {
                if (hasMessage()) {
                    this.dispatcher.addActor(this);
                } else {
                    this.inDispatcher = false;
                }
            } finally {
                this.lock.unlock();
            }
        } catch (Throwable th) {
            this.lock.unlock();
            throw th;
        }
    }
}
