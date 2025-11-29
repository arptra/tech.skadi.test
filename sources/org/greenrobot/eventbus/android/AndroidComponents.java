package org.greenrobot.eventbus.android;

import org.greenrobot.eventbus.Logger;
import org.greenrobot.eventbus.MainThreadSupport;

public abstract class AndroidComponents {
    public static final AndroidComponents c = (AndroidDependenciesDetector.c() ? AndroidDependenciesDetector.b() : null);

    /* renamed from: a  reason: collision with root package name */
    public final Logger f3381a;
    public final MainThreadSupport b;

    public AndroidComponents(Logger logger, MainThreadSupport mainThreadSupport) {
        this.f3381a = logger;
        this.b = mainThreadSupport;
    }

    public static boolean a() {
        return c != null;
    }

    public static AndroidComponents b() {
        return c;
    }
}
