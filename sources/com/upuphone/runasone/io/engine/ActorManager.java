package com.upuphone.runasone.io.engine;

import com.upuphone.runasone.io.engine.message.DefaultMessage;
import com.upuphone.runasone.io.engine.message.Message;
import com.upuphone.runasone.utils.LogUtil;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class ActorManager {
    private static final ActorManager DEFAULT_MANAGER;
    private static final int MAX_DISPATCHER = 12;
    private static final String TAG = "ActorManager";
    private final ConcurrentMap<String, AbstractActor> allActors = new ConcurrentHashMap();
    private final List<Thread> dispatcherThreads = new ArrayList();
    private final List<ActorWorkerDispatcher> dispatchers = new ArrayList();
    private final AtomicInteger distributor = new AtomicInteger(0);
    private final AtomicBoolean running = new AtomicBoolean(false);

    static {
        String simpleName = ActorManager.class.getSimpleName();
        ActorManager actorManager = new ActorManager();
        DEFAULT_MANAGER = actorManager;
        actorManager.initialize(12);
        LogUtil.d(simpleName, (Object) "初始化Actor管理类，maxThreads=" + 12);
    }

    private ActorManager() {
    }

    private Thread createThread(int i, ActorWorkerDispatcher actorWorkerDispatcher) {
        Thread thread = new Thread(actorWorkerDispatcher, "actor-dispatcher-" + i);
        thread.setPriority(10);
        return thread;
    }

    private ActorWorkerDispatcher getDispatcher() {
        return this.dispatchers.get(this.distributor.getAndIncrement() % this.dispatchers.size());
    }

    public static ActorManager getInstance() {
        return DEFAULT_MANAGER;
    }

    public int broadcast(AbstractActor abstractActor, Message message) {
        int i = 0;
        for (AbstractActor next : this.allActors.values()) {
            if (next.hasActive()) {
                next.sendMessage(message);
                i++;
            }
        }
        return i;
    }

    public boolean closeActor(AbstractActor abstractActor) {
        if (!this.running.get()) {
            throw new RuntimeException("Actor manger is not running.");
        } else if (!this.allActors.containsKey(abstractActor.getName())) {
            return false;
        } else {
            this.allActors.remove(abstractActor.getName());
            abstractActor.setActive(false);
            abstractActor.clearMailbox();
            abstractActor.deactivate();
            return true;
        }
    }

    public AbstractActor createActor(Class<? extends AbstractActor> cls, String str) {
        if (this.running.get()) {
            AbstractActor abstractActor = null;
            try {
                Constructor<? extends AbstractActor> declaredConstructor = cls.getDeclaredConstructor((Class[]) null);
                declaredConstructor.setAccessible(true);
                AbstractActor abstractActor2 = (AbstractActor) declaredConstructor.newInstance((Object[]) null);
                try {
                    abstractActor2.setName(str);
                    if (this.allActors.putIfAbsent(str, abstractActor2) == null) {
                        return abstractActor2;
                    }
                    throw new RuntimeException("Actor的名称重复,name:" + str);
                } catch (NoSuchMethodException e) {
                    e = e;
                    abstractActor = abstractActor2;
                    String str2 = TAG;
                    LogUtil.e(str2, (Object) "getDeclaredConstructor 失败:" + e);
                    return abstractActor;
                } catch (IllegalAccessException | InstantiationException e2) {
                    e = e2;
                    abstractActor = abstractActor2;
                    String str3 = TAG;
                    LogUtil.e(str3, (Object) "创建Actor[" + cls.getName() + "]出错:" + e);
                    return abstractActor;
                } catch (InvocationTargetException e3) {
                    e = e3;
                    abstractActor = abstractActor2;
                    e.printStackTrace();
                    return abstractActor;
                }
            } catch (NoSuchMethodException e4) {
                e = e4;
                String str22 = TAG;
                LogUtil.e(str22, (Object) "getDeclaredConstructor 失败:" + e);
                return abstractActor;
            } catch (IllegalAccessException | InstantiationException e5) {
                e = e5;
                String str32 = TAG;
                LogUtil.e(str32, (Object) "创建Actor[" + cls.getName() + "]出错:" + e);
                return abstractActor;
            } catch (InvocationTargetException e6) {
                e = e6;
                e.printStackTrace();
                return abstractActor;
            }
        } else {
            throw new RuntimeException("Actor manger is not running.");
        }
    }

    public AbstractActor createAndStartActor(Class<? extends AbstractActor> cls, String str) {
        if (this.running.get()) {
            AbstractActor createActor = createActor(cls, str);
            if (createActor != null) {
                startActor(createActor);
                return createActor;
            }
            throw new NullPointerException("创建Actor失败。");
        }
        throw new RuntimeException("Actor manger is not running.");
    }

    public List<AbstractActor> getActorByGroupId(String str) {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry next : this.allActors.entrySet()) {
            if (((AbstractActor) next.getValue()).getGroup().equals(str)) {
                arrayList.add((AbstractActor) next.getValue());
            }
        }
        return arrayList;
    }

    public int getActorCount() {
        return this.allActors.size();
    }

    public List<AbstractActor> getActorsByType(Class<? extends AbstractActor> cls) {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry next : this.allActors.entrySet()) {
            if (((AbstractActor) next.getValue()).getClass().equals(cls)) {
                arrayList.add((AbstractActor) next.getValue());
            }
        }
        return arrayList;
    }

    public int getGroupActorCount(String str) {
        int i = 0;
        for (Map.Entry<String, AbstractActor> value : this.allActors.entrySet()) {
            if (((AbstractActor) value.getValue()).getGroup().equals(str)) {
                i++;
            }
        }
        return i;
    }

    public AbstractActor initActor(AbstractActor abstractActor, String str) {
        if (this.running.get()) {
            abstractActor.setName(str);
            if (this.allActors.putIfAbsent(str, abstractActor) == null) {
                return abstractActor;
            }
            throw new RuntimeException("Actor的名称重复,name:" + str);
        }
        throw new RuntimeException("Actor manger is not running.");
    }

    public AbstractActor initAndStartActor(AbstractActor abstractActor, String str) {
        if (this.running.get()) {
            initActor(abstractActor, str);
            if (abstractActor != null) {
                startActor(abstractActor);
                return abstractActor;
            }
            throw new NullPointerException("创建Actor失败。");
        }
        throw new RuntimeException("Actor manger is not running.");
    }

    public void initialize(int i) {
        int i2 = 0;
        while (i2 < i) {
            ActorWorkerDispatcher actorWorkerDispatcher = new ActorWorkerDispatcher(32767, this);
            i2++;
            Thread createThread = createThread(i2, actorWorkerDispatcher);
            createThread.start();
            this.dispatchers.add(actorWorkerDispatcher);
            this.dispatcherThreads.add(createThread);
        }
        this.running.set(true);
    }

    public int sendGroupMessage(AbstractActor abstractActor, String str, Message message) {
        if (str == null || "".equals(str)) {
            throw new NullPointerException("groupId is null");
        }
        List<AbstractActor> actorByGroupId = getActorByGroupId(str);
        int i = 0;
        if (actorByGroupId.isEmpty()) {
            return 0;
        }
        for (AbstractActor next : actorByGroupId) {
            if (next.hasActive()) {
                next.sendMessage(message);
                i++;
            }
        }
        return i;
    }

    public int sendMessage(AbstractActor abstractActor, AbstractActor abstractActor2, Message message) {
        if (abstractActor2 == null) {
            throw new NullPointerException("receiver is null.");
        } else if (!abstractActor2.hasActive()) {
            return 0;
        } else {
            abstractActor2.sendMessage(message);
            return 1;
        }
    }

    public int sendTypeMessage(AbstractActor abstractActor, Class<? extends AbstractActor> cls, Message message) {
        if (cls != null) {
            List<AbstractActor> actorsByType = getActorsByType(cls);
            int i = 0;
            if (actorsByType.isEmpty()) {
                return 0;
            }
            for (AbstractActor next : actorsByType) {
                if (next.hasActive()) {
                    next.sendMessage(message);
                    i++;
                }
            }
            return i;
        }
        throw new NullPointerException("type is null");
    }

    public void shutdown() {
        if (this.running.compareAndSet(true, false)) {
            for (AbstractActor closeActor : this.allActors.values()) {
                closeActor(closeActor);
            }
            this.allActors.clear();
            for (ActorWorkerDispatcher shutdown : this.dispatchers) {
                shutdown.shutdown();
            }
            try {
                Thread.sleep(50);
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
            for (Thread interrupt : this.dispatcherThreads) {
                interrupt.interrupt();
            }
            this.dispatchers.clear();
            this.dispatcherThreads.clear();
        }
    }

    public boolean startActor(AbstractActor abstractActor) {
        if (!this.running.get()) {
            throw new RuntimeException("Actor manger is not running.");
        } else if (!this.allActors.containsKey(abstractActor.getName())) {
            return false;
        } else {
            ActorWorkerDispatcher dispatcher = getDispatcher();
            abstractActor.setActive(true);
            abstractActor.activate();
            abstractActor.registerDispatcher(dispatcher);
            return false;
        }
    }

    public int getActorCount(Class<? extends AbstractActor> cls) {
        int i = 0;
        for (Map.Entry<String, AbstractActor> value : this.allActors.entrySet()) {
            if (((AbstractActor) value.getValue()).getClass().equals(cls)) {
                i++;
            }
        }
        return i;
    }

    public int sendMessage(AbstractActor abstractActor, AbstractActor abstractActor2, Object obj) {
        if (abstractActor2 == null) {
            throw new NullPointerException("receiver is null.");
        } else if (!abstractActor2.hasActive()) {
            return 0;
        } else {
            abstractActor2.sendMessage(new DefaultMessage(abstractActor, obj));
            return 1;
        }
    }

    public int sendMessage(AbstractActor abstractActor, String str, Message message) {
        AbstractActor abstractActor2 = this.allActors.get(str);
        if (abstractActor2 == null || !abstractActor2.hasActive() || !abstractActor2.hasActive()) {
            return 0;
        }
        abstractActor2.sendMessage(message);
        return 1;
    }

    public int sendMessage(AbstractActor abstractActor, AbstractActor[] abstractActorArr, Message message) {
        if (abstractActorArr != null) {
            int i = 0;
            for (AbstractActor abstractActor2 : abstractActorArr) {
                if (abstractActor2 != null && abstractActor2.hasActive()) {
                    abstractActor2.sendMessage(message);
                    i++;
                }
            }
            return i;
        }
        throw new NullPointerException("receivers is null");
    }

    public int sendMessage(AbstractActor abstractActor, Collection<? extends AbstractActor> collection, Message message) {
        if (collection != null) {
            int i = 0;
            for (AbstractActor abstractActor2 : collection) {
                if (abstractActor2 != null && abstractActor2.hasActive()) {
                    abstractActor2.sendMessage(message);
                    i++;
                }
            }
            return i;
        }
        throw new NullPointerException("receivers is null");
    }
}
