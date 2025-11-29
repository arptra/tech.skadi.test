package androidx.startup;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import androidx.tracing.Trace;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class AppInitializer {
    public static volatile AppInitializer d;
    public static final Object e = new Object();

    /* renamed from: a  reason: collision with root package name */
    public final Map f1807a = new HashMap();
    public final Set b = new HashSet();
    public final Context c;

    public AppInitializer(Context context) {
        this.c = context.getApplicationContext();
    }

    public static AppInitializer e(Context context) {
        if (d == null) {
            synchronized (e) {
                try {
                    if (d == null) {
                        d = new AppInitializer(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return d;
    }

    public void a() {
        try {
            Trace.c("Startup");
            b(this.c.getPackageManager().getProviderInfo(new ComponentName(this.c.getPackageName(), InitializationProvider.class.getName()), 128).metaData);
            Trace.f();
        } catch (PackageManager.NameNotFoundException e2) {
            throw new StartupException((Throwable) e2);
        } catch (Throwable th) {
            Trace.f();
            throw th;
        }
    }

    public void b(Bundle bundle) {
        String string = this.c.getString(R.string.androidx_startup);
        if (bundle != null) {
            try {
                HashSet hashSet = new HashSet();
                for (String next : bundle.keySet()) {
                    if (string.equals(bundle.getString(next, (String) null))) {
                        Class<?> cls = Class.forName(next);
                        if (Initializer.class.isAssignableFrom(cls)) {
                            this.b.add(cls);
                        }
                    }
                }
                for (Class d2 : this.b) {
                    d(d2, hashSet);
                }
            } catch (ClassNotFoundException e2) {
                throw new StartupException((Throwable) e2);
            }
        }
    }

    public Object c(Class cls) {
        Object obj;
        synchronized (e) {
            try {
                obj = this.f1807a.get(cls);
                if (obj == null) {
                    obj = d(cls, new HashSet());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return obj;
    }

    public final Object d(Class cls, Set set) {
        Object obj;
        if (Trace.h()) {
            try {
                Trace.c(cls.getSimpleName());
            } catch (Throwable th) {
                Trace.f();
                throw th;
            }
        }
        if (!set.contains(cls)) {
            if (!this.f1807a.containsKey(cls)) {
                set.add(cls);
                Initializer initializer = (Initializer) cls.getDeclaredConstructor((Class[]) null).newInstance((Object[]) null);
                List<Class> dependencies = initializer.dependencies();
                if (!dependencies.isEmpty()) {
                    for (Class cls2 : dependencies) {
                        if (!this.f1807a.containsKey(cls2)) {
                            d(cls2, set);
                        }
                    }
                }
                obj = initializer.a(this.c);
                set.remove(cls);
                this.f1807a.put(cls, obj);
            } else {
                obj = this.f1807a.get(cls);
            }
            Trace.f();
            return obj;
        }
        throw new IllegalStateException(String.format("Cannot initialize %s. Cycle detected.", new Object[]{cls.getName()}));
    }

    public Object f(Class cls) {
        return c(cls);
    }

    public boolean g(Class cls) {
        return this.b.contains(cls);
    }
}
