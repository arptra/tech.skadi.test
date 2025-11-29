package com.xjsd.ai.assistant.phone;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.xjsd.ai.assistant.log.ILog;

public class AssistantLifecycle implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a  reason: collision with root package name */
    public static int f8516a;

    public static boolean a() {
        return f8516a > 0;
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public void onActivityDestroyed(Activity activity) {
    }

    public void onActivityPaused(Activity activity) {
    }

    public void onActivityResumed(Activity activity) {
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
        ILog.a("AppLifecycle", "onActivityStarted");
        f8516a++;
    }

    public void onActivityStopped(Activity activity) {
        ILog.a("AppLifecycle", "onActivityStopped");
        f8516a--;
    }
}
