package com.bumptech.glide;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.util.Log;
import androidx.fragment.app.FragmentActivity;
import com.bumptech.glide.load.engine.Engine;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.engine.cache.MemoryCache;
import com.bumptech.glide.manager.ConnectivityMonitorFactory;
import com.bumptech.glide.manager.RequestManagerRetriever;
import com.bumptech.glide.module.AppGlideModule;
import com.bumptech.glide.module.GlideModule;
import com.bumptech.glide.module.ManifestParser;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.ImageViewTargetFactory;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Glide implements ComponentCallbacks2 {
    public static volatile Glide k;
    public static volatile boolean l;

    /* renamed from: a  reason: collision with root package name */
    public final Engine f2415a;
    public final BitmapPool b;
    public final MemoryCache c;
    public final GlideContext d;
    public final ArrayPool e;
    public final RequestManagerRetriever f;
    public final ConnectivityMonitorFactory g;
    public final List h = new ArrayList();
    public final RequestOptionsFactory i;
    public MemoryCategory j = MemoryCategory.NORMAL;

    public interface RequestOptionsFactory {
        RequestOptions build();
    }

    public Glide(Context context, Engine engine, MemoryCache memoryCache, BitmapPool bitmapPool, ArrayPool arrayPool, RequestManagerRetriever requestManagerRetriever, ConnectivityMonitorFactory connectivityMonitorFactory, int i2, RequestOptionsFactory requestOptionsFactory, Map map, List list, List list2, AppGlideModule appGlideModule, GlideExperiments glideExperiments) {
        this.f2415a = engine;
        this.b = bitmapPool;
        ArrayPool arrayPool2 = arrayPool;
        this.e = arrayPool2;
        this.c = memoryCache;
        this.f = requestManagerRetriever;
        this.g = connectivityMonitorFactory;
        RequestOptionsFactory requestOptionsFactory2 = requestOptionsFactory;
        this.i = requestOptionsFactory2;
        this.d = new GlideContext(context, arrayPool2, RegistryFactory.d(this, list2, appGlideModule), new ImageViewTargetFactory(), requestOptionsFactory2, map, list, engine, glideExperiments, i2);
    }

    public static void a(Context context, GeneratedAppGlideModule generatedAppGlideModule) {
        if (!l) {
            l = true;
            try {
                m(context, generatedAppGlideModule);
            } finally {
                l = false;
            }
        } else {
            throw new IllegalStateException("Glide has been called recursively, this is probably an internal library error!");
        }
    }

    public static Glide c(Context context) {
        if (k == null) {
            GeneratedAppGlideModule d2 = d(context.getApplicationContext());
            synchronized (Glide.class) {
                try {
                    if (k == null) {
                        a(context, d2);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return k;
    }

    public static GeneratedAppGlideModule d(Context context) {
        try {
            return (GeneratedAppGlideModule) Class.forName("com.bumptech.glide.GeneratedAppGlideModuleImpl").getDeclaredConstructor(new Class[]{Context.class}).newInstance(new Object[]{context.getApplicationContext()});
        } catch (ClassNotFoundException unused) {
            if (Log.isLoggable("Glide", 5)) {
                Log.w("Glide", "Failed to find GeneratedAppGlideModule. You should include an annotationProcessor compile dependency on com.github.bumptech.glide:compiler in your application and a @GlideModule annotated AppGlideModule implementation or LibraryGlideModules will be silently ignored");
            }
        } catch (InstantiationException e2) {
            q(e2);
        } catch (IllegalAccessException e3) {
            q(e3);
        } catch (NoSuchMethodException e4) {
            q(e4);
        } catch (InvocationTargetException e5) {
            q(e5);
        }
        return null;
    }

    public static RequestManagerRetriever l(Context context) {
        Preconditions.e(context, "You cannot start a load on a not yet attached View or a Fragment where getActivity() returns null (which usually occurs when getActivity() is called before the Fragment is attached or after the Fragment is destroyed).");
        return c(context).k();
    }

    public static void m(Context context, GeneratedAppGlideModule generatedAppGlideModule) {
        n(context, new GlideBuilder(), generatedAppGlideModule);
    }

    public static void n(Context context, GlideBuilder glideBuilder, GeneratedAppGlideModule generatedAppGlideModule) {
        Context applicationContext = context.getApplicationContext();
        List<GlideModule> emptyList = Collections.emptyList();
        if (generatedAppGlideModule == null || generatedAppGlideModule.c()) {
            emptyList = new ManifestParser(applicationContext).b();
        }
        if (generatedAppGlideModule != null && !generatedAppGlideModule.d().isEmpty()) {
            Set d2 = generatedAppGlideModule.d();
            Iterator it = emptyList.iterator();
            while (it.hasNext()) {
                GlideModule glideModule = (GlideModule) it.next();
                if (d2.contains(glideModule.getClass())) {
                    if (Log.isLoggable("Glide", 3)) {
                        Log.d("Glide", "AppGlideModule excludes manifest GlideModule: " + glideModule);
                    }
                    it.remove();
                }
            }
        }
        if (Log.isLoggable("Glide", 3)) {
            for (GlideModule glideModule2 : emptyList) {
                Log.d("Glide", "Discovered GlideModule from manifest: " + glideModule2.getClass());
            }
        }
        glideBuilder.b(generatedAppGlideModule != null ? generatedAppGlideModule.e() : null);
        for (GlideModule a2 : emptyList) {
            a2.a(applicationContext, glideBuilder);
        }
        if (generatedAppGlideModule != null) {
            generatedAppGlideModule.a(applicationContext, glideBuilder);
        }
        Glide a3 = glideBuilder.a(applicationContext, emptyList, generatedAppGlideModule);
        applicationContext.registerComponentCallbacks(a3);
        k = a3;
    }

    public static void q(Exception exc) {
        throw new IllegalStateException("GeneratedAppGlideModuleImpl is implemented incorrectly. If you've manually implemented this class, remove your implementation. The Annotation processor will generate a correct implementation.", exc);
    }

    public static RequestManager t(Context context) {
        return l(context).d(context);
    }

    public static RequestManager u(FragmentActivity fragmentActivity) {
        return l(fragmentActivity).e(fragmentActivity);
    }

    public void b() {
        Util.b();
        this.c.b();
        this.b.b();
        this.e.b();
    }

    public ArrayPool e() {
        return this.e;
    }

    public BitmapPool f() {
        return this.b;
    }

    public ConnectivityMonitorFactory g() {
        return this.g;
    }

    public Context h() {
        return this.d.getBaseContext();
    }

    public GlideContext i() {
        return this.d;
    }

    public Registry j() {
        return this.d.i();
    }

    public RequestManagerRetriever k() {
        return this.f;
    }

    public void o(RequestManager requestManager) {
        synchronized (this.h) {
            try {
                if (!this.h.contains(requestManager)) {
                    this.h.add(requestManager);
                } else {
                    throw new IllegalStateException("Cannot register already registered manager");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
    }

    public void onLowMemory() {
        b();
    }

    public void onTrimMemory(int i2) {
        r(i2);
    }

    public boolean p(Target target) {
        synchronized (this.h) {
            try {
                for (RequestManager z : this.h) {
                    if (z.z(target)) {
                        return true;
                    }
                }
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void r(int i2) {
        Util.b();
        synchronized (this.h) {
            try {
                for (RequestManager onTrimMemory : this.h) {
                    onTrimMemory.onTrimMemory(i2);
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        this.c.a(i2);
        this.b.a(i2);
        this.e.a(i2);
    }

    public void s(RequestManager requestManager) {
        synchronized (this.h) {
            try {
                if (this.h.contains(requestManager)) {
                    this.h.remove(requestManager);
                } else {
                    throw new IllegalStateException("Cannot unregister not yet registered manager");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
