package androidx.appcompat.app;

import android.app.Activity;
import android.app.Dialog;
import android.app.LocaleManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.LocaleList;
import android.util.Log;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.window.OnBackInvokedDispatcher;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppLocalesStorageHelper;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.VectorEnabledTintResources;
import androidx.collection.ArraySet;
import androidx.core.os.BuildCompat;
import androidx.core.os.LocaleListCompat;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.Iterator;

public abstract class AppCompatDelegate {

    /* renamed from: a  reason: collision with root package name */
    public static AppLocalesStorageHelper.SerialExecutor f160a = new AppLocalesStorageHelper.SerialExecutor(new AppLocalesStorageHelper.ThreadPerTaskExecutor());
    public static int b = -100;
    public static LocaleListCompat c = null;
    public static LocaleListCompat d = null;
    public static Boolean e = null;
    public static boolean f = false;
    public static final ArraySet g = new ArraySet();
    public static final Object h = new Object();
    public static final Object i = new Object();

    @RequiresApi
    public static class Api24Impl {
        @DoNotInline
        public static LocaleList a(String str) {
            return LocaleList.forLanguageTags(str);
        }
    }

    @RequiresApi
    public static class Api33Impl {
        @DoNotInline
        public static LocaleList a(Object obj) {
            return ((LocaleManager) obj).getApplicationLocales();
        }

        @DoNotInline
        public static void b(Object obj, LocaleList localeList) {
            ((LocaleManager) obj).setApplicationLocales(localeList);
        }
    }

    @RestrictTo
    @Retention(RetentionPolicy.SOURCE)
    public @interface NightMode {
    }

    public static void D(AppCompatDelegate appCompatDelegate) {
        synchronized (h) {
            E(appCompatDelegate);
        }
    }

    public static void E(AppCompatDelegate appCompatDelegate) {
        synchronized (h) {
            try {
                Iterator it = g.iterator();
                while (it.hasNext()) {
                    AppCompatDelegate appCompatDelegate2 = (AppCompatDelegate) ((WeakReference) it.next()).get();
                    if (appCompatDelegate2 == appCompatDelegate || appCompatDelegate2 == null) {
                        it.remove();
                    }
                }
            } finally {
            }
        }
    }

    public static void G(boolean z) {
        VectorEnabledTintResources.c(z);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void P(android.content.Context r3) {
        /*
            boolean r0 = t(r3)
            if (r0 != 0) goto L_0x0007
            return
        L_0x0007:
            boolean r0 = androidx.core.os.BuildCompat.b()
            if (r0 == 0) goto L_0x001c
            boolean r0 = f
            if (r0 != 0) goto L_0x0057
            androidx.appcompat.app.AppLocalesStorageHelper$SerialExecutor r0 = f160a
            com.honey.account.f.a r1 = new com.honey.account.f.a
            r1.<init>(r3)
            r0.execute(r1)
            goto L_0x0057
        L_0x001c:
            java.lang.Object r0 = i
            monitor-enter(r0)
            androidx.core.os.LocaleListCompat r1 = c     // Catch:{ all -> 0x0032 }
            if (r1 != 0) goto L_0x0043
            androidx.core.os.LocaleListCompat r1 = d     // Catch:{ all -> 0x0032 }
            if (r1 != 0) goto L_0x0034
            java.lang.String r3 = androidx.appcompat.app.AppLocalesStorageHelper.b(r3)     // Catch:{ all -> 0x0032 }
            androidx.core.os.LocaleListCompat r3 = androidx.core.os.LocaleListCompat.c(r3)     // Catch:{ all -> 0x0032 }
            d = r3     // Catch:{ all -> 0x0032 }
            goto L_0x0034
        L_0x0032:
            r3 = move-exception
            goto L_0x0058
        L_0x0034:
            androidx.core.os.LocaleListCompat r3 = d     // Catch:{ all -> 0x0032 }
            boolean r3 = r3.f()     // Catch:{ all -> 0x0032 }
            if (r3 == 0) goto L_0x003e
            monitor-exit(r0)     // Catch:{ all -> 0x0032 }
            return
        L_0x003e:
            androidx.core.os.LocaleListCompat r3 = d     // Catch:{ all -> 0x0032 }
            c = r3     // Catch:{ all -> 0x0032 }
            goto L_0x0056
        L_0x0043:
            androidx.core.os.LocaleListCompat r2 = d     // Catch:{ all -> 0x0032 }
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0032 }
            if (r1 != 0) goto L_0x0056
            androidx.core.os.LocaleListCompat r1 = c     // Catch:{ all -> 0x0032 }
            d = r1     // Catch:{ all -> 0x0032 }
            java.lang.String r1 = r1.h()     // Catch:{ all -> 0x0032 }
            androidx.appcompat.app.AppLocalesStorageHelper.a(r3, r1)     // Catch:{ all -> 0x0032 }
        L_0x0056:
            monitor-exit(r0)     // Catch:{ all -> 0x0032 }
        L_0x0057:
            return
        L_0x0058:
            monitor-exit(r0)     // Catch:{ all -> 0x0032 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegate.P(android.content.Context):void");
    }

    public static void b(AppCompatDelegate appCompatDelegate) {
        synchronized (h) {
            E(appCompatDelegate);
            g.add(new WeakReference(appCompatDelegate));
        }
    }

    public static AppCompatDelegate f(Activity activity, AppCompatCallback appCompatCallback) {
        return new AppCompatDelegateImpl(activity, appCompatCallback);
    }

    public static AppCompatDelegate g(Dialog dialog, AppCompatCallback appCompatCallback) {
        return new AppCompatDelegateImpl(dialog, appCompatCallback);
    }

    public static LocaleListCompat i() {
        if (BuildCompat.b()) {
            Object n = n();
            if (n != null) {
                return LocaleListCompat.j(Api33Impl.a(n));
            }
        } else {
            LocaleListCompat localeListCompat = c;
            if (localeListCompat != null) {
                return localeListCompat;
            }
        }
        return LocaleListCompat.e();
    }

    public static int k() {
        return b;
    }

    public static Object n() {
        Context j;
        Iterator it = g.iterator();
        while (it.hasNext()) {
            AppCompatDelegate appCompatDelegate = (AppCompatDelegate) ((WeakReference) it.next()).get();
            if (appCompatDelegate != null && (j = appCompatDelegate.j()) != null) {
                return j.getSystemService("locale");
            }
        }
        return null;
    }

    public static LocaleListCompat p() {
        return c;
    }

    public static boolean t(Context context) {
        if (e == null) {
            try {
                Bundle bundle = AppLocalesMetadataHolderService.a(context).metaData;
                if (bundle != null) {
                    e = Boolean.valueOf(bundle.getBoolean("autoStoreLocales"));
                }
            } catch (PackageManager.NameNotFoundException unused) {
                Log.d("AppCompatDelegate", "Checking for metadata for AppLocalesMetadataHolderService : Service not found");
                e = Boolean.FALSE;
            }
        }
        return e.booleanValue();
    }

    public static /* synthetic */ void u(Context context) {
        AppLocalesStorageHelper.c(context);
        f = true;
    }

    public abstract void A(Bundle bundle);

    public abstract void B();

    public abstract void C();

    public abstract boolean F(int i2);

    public abstract void H(int i2);

    public abstract void I(View view);

    public abstract void J(View view, ViewGroup.LayoutParams layoutParams);

    public void K(OnBackInvokedDispatcher onBackInvokedDispatcher) {
    }

    public abstract void L(Toolbar toolbar);

    public void M(int i2) {
    }

    public abstract void N(CharSequence charSequence);

    public abstract ActionMode O(ActionMode.Callback callback);

    public abstract void c(View view, ViewGroup.LayoutParams layoutParams);

    public void d(Context context) {
    }

    public Context e(Context context) {
        d(context);
        return context;
    }

    public abstract View h(int i2);

    public Context j() {
        return null;
    }

    public abstract ActionBarDrawerToggle.Delegate l();

    public int m() {
        return -100;
    }

    public abstract MenuInflater o();

    public abstract ActionBar q();

    public abstract void r();

    public abstract void s();

    public abstract void v(Configuration configuration);

    public abstract void w(Bundle bundle);

    public abstract void x();

    public abstract void y(Bundle bundle);

    public abstract void z();
}
