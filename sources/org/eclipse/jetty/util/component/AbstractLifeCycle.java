package org.eclipse.jetty.util.component;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import org.eclipse.jetty.util.component.LifeCycle;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

public abstract class AbstractLifeCycle implements LifeCycle {
    public static final String FAILED = "FAILED";
    private static final Logger LOG = Log.getLogger((Class<?>) AbstractLifeCycle.class);
    public static final String RUNNING = "RUNNING";
    public static final String STARTED = "STARTED";
    public static final String STARTING = "STARTING";
    public static final String STOPPED = "STOPPED";
    public static final String STOPPING = "STOPPING";
    private final int __FAILED = -1;
    private final int __STARTED = 2;
    private final int __STARTING = 1;
    private final int __STOPPED = 0;
    private final int __STOPPING = 3;
    protected final CopyOnWriteArrayList<LifeCycle.Listener> _listeners = new CopyOnWriteArrayList<>();
    private final Object _lock = new Object();
    private volatile int _state = 0;

    public static abstract class AbstractLifeCycleListener implements LifeCycle.Listener {
        public void lifeCycleFailure(LifeCycle lifeCycle, Throwable th) {
        }

        public void lifeCycleStarted(LifeCycle lifeCycle) {
        }

        public void lifeCycleStarting(LifeCycle lifeCycle) {
        }

        public void lifeCycleStopped(LifeCycle lifeCycle) {
        }

        public void lifeCycleStopping(LifeCycle lifeCycle) {
        }
    }

    private void setFailed(Throwable th) {
        this._state = -1;
        Logger logger = LOG;
        logger.warn("FAILED " + this + ": " + th, th);
        Iterator<LifeCycle.Listener> it = this._listeners.iterator();
        while (it.hasNext()) {
            it.next().lifeCycleFailure(this, th);
        }
    }

    private void setStarted() {
        this._state = 2;
        LOG.debug("STARTED {}", this);
        Iterator<LifeCycle.Listener> it = this._listeners.iterator();
        while (it.hasNext()) {
            it.next().lifeCycleStarted(this);
        }
    }

    private void setStarting() {
        LOG.debug("starting {}", this);
        this._state = 1;
        Iterator<LifeCycle.Listener> it = this._listeners.iterator();
        while (it.hasNext()) {
            it.next().lifeCycleStarting(this);
        }
    }

    private void setStopped() {
        this._state = 0;
        LOG.debug("{} {}", STOPPED, this);
        Iterator<LifeCycle.Listener> it = this._listeners.iterator();
        while (it.hasNext()) {
            it.next().lifeCycleStopped(this);
        }
    }

    private void setStopping() {
        LOG.debug("stopping {}", this);
        this._state = 3;
        Iterator<LifeCycle.Listener> it = this._listeners.iterator();
        while (it.hasNext()) {
            it.next().lifeCycleStopping(this);
        }
    }

    public void addLifeCycleListener(LifeCycle.Listener listener) {
        this._listeners.add(listener);
    }

    public void doStart() throws Exception {
    }

    public void doStop() throws Exception {
    }

    public String getState() {
        int i = this._state;
        if (i == -1) {
            return FAILED;
        }
        if (i == 0) {
            return STOPPED;
        }
        if (i == 1) {
            return STARTING;
        }
        if (i == 2) {
            return STARTED;
        }
        if (i != 3) {
            return null;
        }
        return STOPPING;
    }

    public boolean isFailed() {
        return this._state == -1;
    }

    public boolean isRunning() {
        int i = this._state;
        return i == 2 || i == 1;
    }

    public boolean isStarted() {
        return this._state == 2;
    }

    public boolean isStarting() {
        return this._state == 1;
    }

    public boolean isStopped() {
        return this._state == 0;
    }

    public boolean isStopping() {
        return this._state == 3;
    }

    public void removeLifeCycleListener(LifeCycle.Listener listener) {
        this._listeners.remove(listener);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0020, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void start() throws java.lang.Exception {
        /*
            r3 = this;
            java.lang.Object r0 = r3._lock
            monitor-enter(r0)
            int r1 = r3._state     // Catch:{ Exception -> 0x001d, Error -> 0x001b }
            r2 = 2
            if (r1 == r2) goto L_0x001f
            int r1 = r3._state     // Catch:{ Exception -> 0x001d, Error -> 0x001b }
            r2 = 1
            if (r1 != r2) goto L_0x000e
            goto L_0x001f
        L_0x000e:
            r3.setStarting()     // Catch:{ Exception -> 0x001d, Error -> 0x001b }
            r3.doStart()     // Catch:{ Exception -> 0x001d, Error -> 0x001b }
            r3.setStarted()     // Catch:{ Exception -> 0x001d, Error -> 0x001b }
            monitor-exit(r0)     // Catch:{ all -> 0x0019 }
            return
        L_0x0019:
            r3 = move-exception
            goto L_0x0029
        L_0x001b:
            r1 = move-exception
            goto L_0x0021
        L_0x001d:
            r1 = move-exception
            goto L_0x0025
        L_0x001f:
            monitor-exit(r0)     // Catch:{ all -> 0x0019 }
            return
        L_0x0021:
            r3.setFailed(r1)     // Catch:{ all -> 0x0019 }
            throw r1     // Catch:{ all -> 0x0019 }
        L_0x0025:
            r3.setFailed(r1)     // Catch:{ all -> 0x0019 }
            throw r1     // Catch:{ all -> 0x0019 }
        L_0x0029:
            monitor-exit(r0)     // Catch:{ all -> 0x0019 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: org.eclipse.jetty.util.component.AbstractLifeCycle.start():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x001f, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void stop() throws java.lang.Exception {
        /*
            r3 = this;
            java.lang.Object r0 = r3._lock
            monitor-enter(r0)
            int r1 = r3._state     // Catch:{ Exception -> 0x001c, Error -> 0x001a }
            r2 = 3
            if (r1 == r2) goto L_0x001e
            int r1 = r3._state     // Catch:{ Exception -> 0x001c, Error -> 0x001a }
            if (r1 != 0) goto L_0x000d
            goto L_0x001e
        L_0x000d:
            r3.setStopping()     // Catch:{ Exception -> 0x001c, Error -> 0x001a }
            r3.doStop()     // Catch:{ Exception -> 0x001c, Error -> 0x001a }
            r3.setStopped()     // Catch:{ Exception -> 0x001c, Error -> 0x001a }
            monitor-exit(r0)     // Catch:{ all -> 0x0018 }
            return
        L_0x0018:
            r3 = move-exception
            goto L_0x0028
        L_0x001a:
            r1 = move-exception
            goto L_0x0020
        L_0x001c:
            r1 = move-exception
            goto L_0x0024
        L_0x001e:
            monitor-exit(r0)     // Catch:{ all -> 0x0018 }
            return
        L_0x0020:
            r3.setFailed(r1)     // Catch:{ all -> 0x0018 }
            throw r1     // Catch:{ all -> 0x0018 }
        L_0x0024:
            r3.setFailed(r1)     // Catch:{ all -> 0x0018 }
            throw r1     // Catch:{ all -> 0x0018 }
        L_0x0028:
            monitor-exit(r0)     // Catch:{ all -> 0x0018 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: org.eclipse.jetty.util.component.AbstractLifeCycle.stop():void");
    }

    public static String getState(LifeCycle lifeCycle) {
        if (lifeCycle.isStarting()) {
            return STARTING;
        }
        if (lifeCycle.isStarted()) {
            return STARTED;
        }
        if (lifeCycle.isStopping()) {
            return STOPPING;
        }
        if (lifeCycle.isStopped()) {
            return STOPPED;
        }
        return FAILED;
    }
}
