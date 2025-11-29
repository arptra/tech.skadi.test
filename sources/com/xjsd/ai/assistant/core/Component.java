package com.xjsd.ai.assistant.core;

import android.app.Application;
import com.xjsd.ai.assistant.log.ILog;

public abstract class Component {
    public abstract void a(Application application);

    public boolean b() {
        return true;
    }

    public abstract String c();

    public void d(Application application) {
        String simpleName = getClass().getSimpleName();
        ILog.a(simpleName, c() + "->init start");
        a(application);
        String simpleName2 = getClass().getSimpleName();
        ILog.a(simpleName2, c() + "->init over");
    }
}
