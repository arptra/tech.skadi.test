package com.upuphone.runasone.io.engine;

import com.upuphone.runasone.utils.LogUtil;
import java.util.concurrent.ArrayBlockingQueue;

public class ActorWorkerDispatcher implements Runnable {
    private static final String TAG = "ActorWorkerDispatcher";
    private final ArrayBlockingQueue<AbstractActor> actorQueue;
    private ActorManager parent;
    private volatile boolean run = true;

    public ActorWorkerDispatcher(int i, ActorManager actorManager) {
        this.parent = actorManager;
        this.actorQueue = new ArrayBlockingQueue<>(i);
    }

    public boolean addActor(AbstractActor abstractActor) {
        if (!this.run) {
            return false;
        }
        return this.actorQueue.offer(abstractActor);
    }

    public ActorManager getParent() {
        return this.parent;
    }

    public boolean isShutdown() {
        return this.run;
    }

    public void run() {
        while (this.run) {
            try {
                AbstractActor take = this.actorQueue.take();
                if (take.hasActive()) {
                    if (take.getActorState() == ActorState.WORKER) {
                        take.worker();
                    } else if (take.getActorState() == ActorState.START) {
                        take.startup();
                    } else {
                        String str = TAG;
                        LogUtil.w(str, (Object) "Actor[{" + take.toString() + "}] 处于状态[{" + take.getActorState() + "}], 没有对应的操作执行。");
                    }
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                String str2 = TAG;
                LogUtil.e(str2, (Object) "线程中断。" + e);
                shutdown();
                return;
            } catch (Throwable th) {
                String str3 = TAG;
                LogUtil.e(str3, (Object) "ActorWorkerDispatch run error." + th);
            }
        }
    }

    public void shutdown() {
        this.run = false;
        this.actorQueue.clear();
        this.parent = null;
    }
}
