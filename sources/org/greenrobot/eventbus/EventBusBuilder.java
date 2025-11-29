package org.greenrobot.eventbus;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.greenrobot.eventbus.Logger;
import org.greenrobot.eventbus.android.AndroidComponents;

public class EventBusBuilder {
    public static final ExecutorService m = Executors.newCachedThreadPool();

    /* renamed from: a  reason: collision with root package name */
    public boolean f3370a = true;
    public boolean b = true;
    public boolean c = true;
    public boolean d = true;
    public boolean e;
    public boolean f = true;
    public boolean g;
    public boolean h;
    public ExecutorService i = m;
    public List j;
    public Logger k;
    public MainThreadSupport l;

    public Logger a() {
        Logger logger = this.k;
        return logger != null ? logger : Logger.Default.a();
    }

    public MainThreadSupport b() {
        MainThreadSupport mainThreadSupport = this.l;
        if (mainThreadSupport != null) {
            return mainThreadSupport;
        }
        if (AndroidComponents.a()) {
            return AndroidComponents.b().b;
        }
        return null;
    }
}
