package androidx.core.app;

import android.app.Activity;
import android.app.Application;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.RestrictTo;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

@RestrictTo
final class ActivityRecreator {

    /* renamed from: a  reason: collision with root package name */
    public static final Class f642a;
    public static final Field b = b();
    public static final Field c = f();
    public static final Method d;
    public static final Method e;
    public static final Method f;
    public static final Handler g = new Handler(Looper.getMainLooper());

    /* renamed from: androidx.core.app.ActivityRecreator$1  reason: invalid class name */
    class AnonymousClass1 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LifecycleCheckCallbacks f643a;
        public final /* synthetic */ Object b;

        public void run() {
            this.f643a.f646a = this.b;
        }
    }

    /* renamed from: androidx.core.app.ActivityRecreator$2  reason: invalid class name */
    class AnonymousClass2 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Application f644a;
        public final /* synthetic */ LifecycleCheckCallbacks b;

        public void run() {
            this.f644a.unregisterActivityLifecycleCallbacks(this.b);
        }
    }

    public static final class LifecycleCheckCallbacks implements Application.ActivityLifecycleCallbacks {

        /* renamed from: a  reason: collision with root package name */
        public Object f646a;
        public Activity b;
        public final int c;
        public boolean d;
        public boolean e;
        public boolean f;

        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        public void onActivityDestroyed(Activity activity) {
            if (this.b == activity) {
                this.b = null;
                this.e = true;
            }
        }

        public void onActivityPaused(Activity activity) {
            if (this.e && !this.f && !this.d && ActivityRecreator.h(this.f646a, this.c, activity)) {
                this.f = true;
                this.f646a = null;
            }
        }

        public void onActivityResumed(Activity activity) {
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityStarted(Activity activity) {
            if (this.b == activity) {
                this.d = true;
            }
        }

        public void onActivityStopped(Activity activity) {
        }
    }

    static {
        Class a2 = a();
        f642a = a2;
        d = d(a2);
        e = c(a2);
        f = e(a2);
    }

    public static Class a() {
        try {
            return Class.forName("android.app.ActivityThread");
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Field b() {
        try {
            Field declaredField = Activity.class.getDeclaredField("mMainThread");
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Method c(Class cls) {
        if (cls == null) {
            return null;
        }
        try {
            Method declaredMethod = cls.getDeclaredMethod("performStopActivity", new Class[]{IBinder.class, Boolean.TYPE});
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Method d(Class cls) {
        if (cls == null) {
            return null;
        }
        try {
            Method declaredMethod = cls.getDeclaredMethod("performStopActivity", new Class[]{IBinder.class, Boolean.TYPE, String.class});
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Method e(Class cls) {
        if (g() && cls != null) {
            Class<IBinder> cls2 = IBinder.class;
            Class<List> cls3 = List.class;
            Class<List> cls4 = List.class;
            try {
                Class cls5 = Integer.TYPE;
                Class cls6 = Boolean.TYPE;
                Method declaredMethod = cls.getDeclaredMethod("requestRelaunchActivity", new Class[]{cls2, cls3, cls4, cls5, cls6, Configuration.class, Configuration.class, cls6, cls6});
                declaredMethod.setAccessible(true);
                return declaredMethod;
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    public static Field f() {
        try {
            Field declaredField = Activity.class.getDeclaredField("mToken");
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean g() {
        return false;
    }

    public static boolean h(Object obj, int i, Activity activity) {
        try {
            final Object obj2 = c.get(activity);
            if (obj2 == obj) {
                if (activity.hashCode() == i) {
                    final Object obj3 = b.get(activity);
                    g.postAtFrontOfQueue(new Runnable() {
                        public void run() {
                            try {
                                Method method = ActivityRecreator.d;
                                if (method != null) {
                                    method.invoke(obj3, new Object[]{obj2, Boolean.FALSE, "AppCompat recreation"});
                                } else {
                                    ActivityRecreator.e.invoke(obj3, new Object[]{obj2, Boolean.FALSE});
                                }
                            } catch (RuntimeException e) {
                                if (e.getClass() == RuntimeException.class && e.getMessage() != null && e.getMessage().startsWith("Unable to stop")) {
                                    throw e;
                                }
                            } catch (Throwable th) {
                                Log.e("ActivityRecreator", "Exception while invoking performStopActivity", th);
                            }
                        }
                    });
                    return true;
                }
            }
            return false;
        } catch (Throwable th) {
            Log.e("ActivityRecreator", "Exception while fetching field values", th);
            return false;
        }
    }
}
