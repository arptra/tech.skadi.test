package com.upuphone.starrynetsdk.api;

import com.upuphone.hub.Hub;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public final class Camp {
    private volatile Hub hub;
    private final List<WeakReference<Sentry>> sentries;

    public static class Holder {
        /* access modifiers changed from: private */
        public static final Camp INSTANCE = new Camp();

        private Holder() {
        }
    }

    public static Camp getInstance() {
        return Holder.INSTANCE;
    }

    public void addSentry(Sentry sentry) {
        this.sentries.add(new WeakReference(sentry));
        if (isInstalled()) {
            sentry.onInstalled(this.hub);
        } else {
            sentry.onUninstalled();
        }
    }

    public boolean isInstalled() {
        return this.hub != null;
    }

    public void report(Hub hub2) {
        this.hub = hub2;
        for (WeakReference next : this.sentries) {
            Sentry sentry = (Sentry) next.get();
            if (sentry == null) {
                this.sentries.remove(next);
            } else if (isInstalled()) {
                sentry.onInstalled(hub2);
            } else {
                sentry.onUninstalled();
            }
        }
    }

    private Camp() {
        this.sentries = new CopyOnWriteArrayList();
    }
}
