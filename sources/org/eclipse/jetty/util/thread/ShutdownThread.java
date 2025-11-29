package org.eclipse.jetty.util.thread;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.eclipse.jetty.util.component.Destroyable;
import org.eclipse.jetty.util.component.LifeCycle;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

public class ShutdownThread extends Thread {
    private static final Logger LOG = Log.getLogger((Class<?>) ShutdownThread.class);
    private static final ShutdownThread _thread = new ShutdownThread();
    private boolean _hooked;
    private final List<LifeCycle> _lifeCycles = new CopyOnWriteArrayList();

    private ShutdownThread() {
    }

    public static synchronized void deregister(LifeCycle lifeCycle) {
        synchronized (ShutdownThread.class) {
            ShutdownThread shutdownThread = _thread;
            shutdownThread._lifeCycles.remove(lifeCycle);
            if (shutdownThread._lifeCycles.size() == 0) {
                shutdownThread.unhook();
            }
        }
    }

    public static ShutdownThread getInstance() {
        return _thread;
    }

    private synchronized void hook() {
        try {
            if (!this._hooked) {
                Runtime.getRuntime().addShutdownHook(this);
            }
            this._hooked = true;
        } catch (Exception e) {
            Logger logger = LOG;
            logger.ignore(e);
            logger.info("shutdown already commenced", new Object[0]);
        } catch (Throwable th) {
            throw th;
        }
    }

    public static synchronized void register(LifeCycle... lifeCycleArr) {
        synchronized (ShutdownThread.class) {
            ShutdownThread shutdownThread = _thread;
            shutdownThread._lifeCycles.addAll(Arrays.asList(lifeCycleArr));
            if (shutdownThread._lifeCycles.size() > 0) {
                shutdownThread.hook();
            }
        }
    }

    private synchronized void unhook() {
        try {
            this._hooked = false;
            Runtime.getRuntime().removeShutdownHook(this);
        } catch (Exception e) {
            Logger logger = LOG;
            logger.ignore(e);
            logger.debug("shutdown already commenced", new Object[0]);
        }
        return;
    }

    public void run() {
        for (LifeCycle next : _thread._lifeCycles) {
            try {
                if (next.isStarted()) {
                    next.stop();
                    LOG.debug("Stopped {}", next);
                }
                if (next instanceof Destroyable) {
                    ((Destroyable) next).destroy();
                    LOG.debug("Destroyed {}", next);
                }
            } catch (Exception e) {
                LOG.debug(e);
            }
        }
    }

    public static synchronized void register(int i, LifeCycle... lifeCycleArr) {
        synchronized (ShutdownThread.class) {
            ShutdownThread shutdownThread = _thread;
            shutdownThread._lifeCycles.addAll(i, Arrays.asList(lifeCycleArr));
            if (shutdownThread._lifeCycles.size() > 0) {
                shutdownThread.hook();
            }
        }
    }
}
