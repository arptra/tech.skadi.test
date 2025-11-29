package androidx.appcompat.app;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.app.UiModeManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.LocaleList;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.R;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.view.SupportActionModeWrapper;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.WindowCallbackWrapper;
import androidx.appcompat.view.menu.ListMenuPresenter;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.appcompat.widget.ContentFrameLayout;
import androidx.appcompat.widget.DecorContentParent;
import androidx.appcompat.widget.FitWindowsViewGroup;
import androidx.appcompat.widget.TintTypedArray;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.VectorEnabledTintResources;
import androidx.collection.SimpleArrayMap;
import androidx.core.app.NavUtils;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.os.LocaleListCompat;
import androidx.core.view.KeyEventDispatcher;
import androidx.core.view.LayoutInflaterCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListener;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.google.android.material.internal.ViewUtils;
import com.honey.account.f.b;
import com.honey.account.f.c;
import java.lang.Thread;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import kotlin.time.DurationKt;
import org.xmlpull.v1.XmlPullParser;

@RestrictTo
class AppCompatDelegateImpl extends AppCompatDelegate implements MenuBuilder.Callback, LayoutInflater.Factory2 {
    public static final SimpleArrayMap p0 = new SimpleArrayMap();
    public static final boolean q0 = false;
    public static final int[] r0 = {16842836};
    public static final boolean s0 = (!"robolectric".equals(Build.FINGERPRINT));
    public static final boolean t0 = true;
    public boolean A;
    public ViewGroup B;
    public TextView C;
    public View D;
    public boolean E;
    public boolean F;
    public boolean G;
    public boolean H;
    public boolean I;
    public boolean J;
    public boolean K;
    public boolean L;
    public PanelFeatureState[] M;
    public PanelFeatureState N;
    public boolean O;
    public boolean P;
    public boolean Q;
    public boolean R;
    public Configuration S;
    public int T;
    public int U;
    public int V;
    public boolean W;
    public AutoNightModeManager X;
    public AutoNightModeManager Y;
    public boolean Z;
    public int g0;
    public final Runnable h0;
    public boolean i0;
    public final Object j;
    public Rect j0;
    public final Context k;
    public Rect k0;
    public Window l;
    public AppCompatViewInflater l0;
    public AppCompatWindowCallback m;
    public LayoutIncludeDetector m0;
    public final AppCompatCallback n;
    public OnBackInvokedDispatcher n0;
    public ActionBar o;
    public OnBackInvokedCallback o0;
    public MenuInflater p;
    public CharSequence q;
    public DecorContentParent r;
    public ActionMenuPresenterCallback s;
    public PanelMenuPresenterCallback t;
    public ActionMode u;
    public ActionBarContextView v;
    public PopupWindow w;
    public Runnable x;
    public ViewPropertyAnimatorCompat y;
    public boolean z;

    /* renamed from: androidx.appcompat.app.AppCompatDelegateImpl$1  reason: invalid class name */
    public class AnonymousClass1 implements Thread.UncaughtExceptionHandler {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Thread.UncaughtExceptionHandler f161a;

        public final boolean a(Throwable th) {
            String message;
            if (!(th instanceof Resources.NotFoundException) || (message = th.getMessage()) == null) {
                return false;
            }
            return message.contains("drawable") || message.contains("Drawable");
        }

        public void uncaughtException(Thread thread, Throwable th) {
            if (a(th)) {
                Resources.NotFoundException notFoundException = new Resources.NotFoundException(th.getMessage() + ". If the resource you are trying to use is a vector resource, you may be referencing it in an unsupported way. See AppCompatDelegate.setCompatVectorFromResourcesEnabled() for more info.");
                notFoundException.initCause(th.getCause());
                notFoundException.setStackTrace(th.getStackTrace());
                this.f161a.uncaughtException(thread, notFoundException);
                return;
            }
            this.f161a.uncaughtException(thread, th);
        }
    }

    /* renamed from: androidx.appcompat.app.AppCompatDelegateImpl$4  reason: invalid class name */
    public class AnonymousClass4 implements FitWindowsViewGroup.OnFitSystemWindowsListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AppCompatDelegateImpl f164a;

        public void onFitSystemWindows(Rect rect) {
            rect.top = this.f164a.d1((WindowInsetsCompat) null, rect);
        }
    }

    public class ActionBarDrawableToggleImpl implements ActionBarDrawerToggle.Delegate {
        public ActionBarDrawableToggleImpl() {
        }

        public void setActionBarDescription(int i) {
            ActionBar q = AppCompatDelegateImpl.this.q();
            if (q != null) {
                q.s(i);
            }
        }

        public void setActionBarUpIndicator(Drawable drawable, int i) {
            ActionBar q = AppCompatDelegateImpl.this.q();
            if (q != null) {
                q.u(drawable);
                q.s(i);
            }
        }
    }

    public interface ActionBarMenuCallback {
        boolean a(int i);

        View onCreatePanelView(int i);
    }

    public final class ActionMenuPresenterCallback implements MenuPresenter.Callback {
        public ActionMenuPresenterCallback() {
        }

        public boolean a(MenuBuilder menuBuilder) {
            Window.Callback u0 = AppCompatDelegateImpl.this.u0();
            if (u0 == null) {
                return true;
            }
            u0.onMenuOpened(108, menuBuilder);
            return true;
        }

        public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
            AppCompatDelegateImpl.this.Y(menuBuilder);
        }
    }

    public class ActionModeCallbackWrapperV9 implements ActionMode.Callback {

        /* renamed from: a  reason: collision with root package name */
        public ActionMode.Callback f171a;

        public ActionModeCallbackWrapperV9(ActionMode.Callback callback) {
            this.f171a = callback;
        }

        public boolean a(ActionMode actionMode, Menu menu) {
            return this.f171a.a(actionMode, menu);
        }

        public boolean b(ActionMode actionMode, MenuItem menuItem) {
            return this.f171a.b(actionMode, menuItem);
        }

        public boolean c(ActionMode actionMode, Menu menu) {
            ViewCompat.q0(AppCompatDelegateImpl.this.B);
            return this.f171a.c(actionMode, menu);
        }

        public void d(ActionMode actionMode) {
            this.f171a.d(actionMode);
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            if (appCompatDelegateImpl.w != null) {
                appCompatDelegateImpl.l.getDecorView().removeCallbacks(AppCompatDelegateImpl.this.x);
            }
            AppCompatDelegateImpl appCompatDelegateImpl2 = AppCompatDelegateImpl.this;
            if (appCompatDelegateImpl2.v != null) {
                appCompatDelegateImpl2.i0();
                AppCompatDelegateImpl appCompatDelegateImpl3 = AppCompatDelegateImpl.this;
                appCompatDelegateImpl3.y = ViewCompat.e(appCompatDelegateImpl3.v).b(0.0f);
                AppCompatDelegateImpl.this.y.k(new ViewPropertyAnimatorListenerAdapter() {
                    public void onAnimationEnd(View view) {
                        AppCompatDelegateImpl.this.v.setVisibility(8);
                        AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
                        PopupWindow popupWindow = appCompatDelegateImpl.w;
                        if (popupWindow != null) {
                            popupWindow.dismiss();
                        } else if (appCompatDelegateImpl.v.getParent() instanceof View) {
                            ViewCompat.q0((View) AppCompatDelegateImpl.this.v.getParent());
                        }
                        AppCompatDelegateImpl.this.v.l();
                        AppCompatDelegateImpl.this.y.k((ViewPropertyAnimatorListener) null);
                        AppCompatDelegateImpl appCompatDelegateImpl2 = AppCompatDelegateImpl.this;
                        appCompatDelegateImpl2.y = null;
                        ViewCompat.q0(appCompatDelegateImpl2.B);
                    }
                });
            }
            AppCompatDelegateImpl appCompatDelegateImpl4 = AppCompatDelegateImpl.this;
            AppCompatCallback appCompatCallback = appCompatDelegateImpl4.n;
            if (appCompatCallback != null) {
                appCompatCallback.onSupportActionModeFinished(appCompatDelegateImpl4.u);
            }
            AppCompatDelegateImpl appCompatDelegateImpl5 = AppCompatDelegateImpl.this;
            appCompatDelegateImpl5.u = null;
            ViewCompat.q0(appCompatDelegateImpl5.B);
            AppCompatDelegateImpl.this.b1();
        }
    }

    @RequiresApi
    public static class Api17Impl {
        public static Context a(Context context, Configuration configuration) {
            return context.createConfigurationContext(configuration);
        }

        public static void b(Configuration configuration, Configuration configuration2, Configuration configuration3) {
            int i = configuration.densityDpi;
            int i2 = configuration2.densityDpi;
            if (i != i2) {
                configuration3.densityDpi = i2;
            }
        }

        @DoNotInline
        public static void c(Configuration configuration, Locale locale) {
            configuration.setLayoutDirection(locale);
        }

        @DoNotInline
        public static void d(Configuration configuration, Locale locale) {
            configuration.setLocale(locale);
        }
    }

    @RequiresApi
    public static class Api21Impl {
        public static boolean a(PowerManager powerManager) {
            return powerManager.isPowerSaveMode();
        }

        @DoNotInline
        public static String b(Locale locale) {
            return locale.toLanguageTag();
        }
    }

    @RequiresApi
    public static class Api24Impl {
        @DoNotInline
        public static void a(@NonNull Configuration configuration, @NonNull Configuration configuration2, @NonNull Configuration configuration3) {
            LocaleList locales = configuration.getLocales();
            LocaleList locales2 = configuration2.getLocales();
            if (!locales.equals(locales2)) {
                configuration3.setLocales(locales2);
                configuration3.locale = configuration2.locale;
            }
        }

        @DoNotInline
        public static LocaleListCompat b(Configuration configuration) {
            return LocaleListCompat.c(configuration.getLocales().toLanguageTags());
        }

        @DoNotInline
        public static void c(LocaleListCompat localeListCompat) {
            LocaleList.setDefault(LocaleList.forLanguageTags(localeListCompat.h()));
        }

        @DoNotInline
        public static void d(Configuration configuration, LocaleListCompat localeListCompat) {
            configuration.setLocales(LocaleList.forLanguageTags(localeListCompat.h()));
        }
    }

    @RequiresApi
    public static class Api26Impl {
        public static void a(Configuration configuration, Configuration configuration2, Configuration configuration3) {
            int i = configuration.colorMode & 3;
            int i2 = configuration2.colorMode;
            if (i != (i2 & 3)) {
                configuration3.colorMode |= i2 & 3;
            }
            int i3 = configuration.colorMode & 12;
            int i4 = configuration2.colorMode;
            if (i3 != (i4 & 12)) {
                configuration3.colorMode |= i4 & 12;
            }
        }
    }

    @RequiresApi
    public static class Api33Impl {
        @DoNotInline
        public static OnBackInvokedDispatcher a(Activity activity) {
            return activity.getOnBackInvokedDispatcher();
        }

        @DoNotInline
        public static OnBackInvokedCallback b(Object obj, AppCompatDelegateImpl appCompatDelegateImpl) {
            Objects.requireNonNull(appCompatDelegateImpl);
            a aVar = new a(appCompatDelegateImpl);
            c.a(obj).registerOnBackInvokedCallback(DurationKt.NANOS_IN_MILLIS, aVar);
            return aVar;
        }

        @DoNotInline
        public static void c(Object obj, Object obj2) {
            c.a(obj).unregisterOnBackInvokedCallback(b.a(obj2));
        }
    }

    public class AppCompatWindowCallback extends WindowCallbackWrapper {

        /* renamed from: a  reason: collision with root package name */
        public ActionBarMenuCallback f173a;
        public boolean b;
        public boolean c;
        public boolean d;

        public AppCompatWindowCallback(Window.Callback callback) {
            super(callback);
        }

        /* JADX INFO: finally extract failed */
        public boolean a(Window.Callback callback, KeyEvent keyEvent) {
            try {
                this.c = true;
                boolean dispatchKeyEvent = callback.dispatchKeyEvent(keyEvent);
                this.c = false;
                return dispatchKeyEvent;
            } catch (Throwable th) {
                this.c = false;
                throw th;
            }
        }

        /* JADX INFO: finally extract failed */
        public void b(Window.Callback callback) {
            try {
                this.b = true;
                callback.onContentChanged();
                this.b = false;
            } catch (Throwable th) {
                this.b = false;
                throw th;
            }
        }

        /* JADX INFO: finally extract failed */
        public void c(Window.Callback callback, int i, Menu menu) {
            try {
                this.d = true;
                callback.onPanelClosed(i, menu);
                this.d = false;
            } catch (Throwable th) {
                this.d = false;
                throw th;
            }
        }

        public void d(ActionBarMenuCallback actionBarMenuCallback) {
            this.f173a = actionBarMenuCallback;
        }

        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return this.c ? getWrapped().dispatchKeyEvent(keyEvent) : AppCompatDelegateImpl.this.g0(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
            return super.dispatchKeyShortcutEvent(keyEvent) || AppCompatDelegateImpl.this.F0(keyEvent.getKeyCode(), keyEvent);
        }

        public void onContentChanged() {
            if (this.b) {
                getWrapped().onContentChanged();
            }
        }

        public boolean onCreatePanelMenu(int i, Menu menu) {
            if (i != 0 || (menu instanceof MenuBuilder)) {
                return super.onCreatePanelMenu(i, menu);
            }
            return false;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
            r0 = r0.onCreatePanelView(r2);
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public android.view.View onCreatePanelView(int r2) {
            /*
                r1 = this;
                androidx.appcompat.app.AppCompatDelegateImpl$ActionBarMenuCallback r0 = r1.f173a
                if (r0 == 0) goto L_0x000b
                android.view.View r0 = r0.onCreatePanelView(r2)
                if (r0 == 0) goto L_0x000b
                return r0
            L_0x000b:
                android.view.View r1 = super.onCreatePanelView(r2)
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.AppCompatWindowCallback.onCreatePanelView(int):android.view.View");
        }

        public boolean onMenuOpened(int i, Menu menu) {
            super.onMenuOpened(i, menu);
            AppCompatDelegateImpl.this.I0(i);
            return true;
        }

        public void onPanelClosed(int i, Menu menu) {
            if (this.d) {
                getWrapped().onPanelClosed(i, menu);
                return;
            }
            super.onPanelClosed(i, menu);
            AppCompatDelegateImpl.this.J0(i);
        }

        public boolean onPreparePanel(int i, View view, Menu menu) {
            MenuBuilder menuBuilder = menu instanceof MenuBuilder ? (MenuBuilder) menu : null;
            if (i == 0 && menuBuilder == null) {
                return false;
            }
            boolean z = true;
            if (menuBuilder != null) {
                menuBuilder.setOverrideVisibleItems(true);
            }
            ActionBarMenuCallback actionBarMenuCallback = this.f173a;
            if (actionBarMenuCallback == null || !actionBarMenuCallback.a(i)) {
                z = false;
            }
            if (!z) {
                z = super.onPreparePanel(i, view, menu);
            }
            if (menuBuilder != null) {
                menuBuilder.setOverrideVisibleItems(false);
            }
            return z;
        }

        public void onProvideKeyboardShortcuts(List list, Menu menu, int i) {
            MenuBuilder menuBuilder;
            PanelFeatureState s0 = AppCompatDelegateImpl.this.s0(0, true);
            if (s0 == null || (menuBuilder = s0.j) == null) {
                super.onProvideKeyboardShortcuts(list, menu, i);
            } else {
                super.onProvideKeyboardShortcuts(list, menuBuilder, i);
            }
        }

        public android.view.ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
            return null;
        }

        public final android.view.ActionMode startAsSupportActionMode(ActionMode.Callback callback) {
            SupportActionModeWrapper.CallbackWrapper callbackWrapper = new SupportActionModeWrapper.CallbackWrapper(AppCompatDelegateImpl.this.k, callback);
            androidx.appcompat.view.ActionMode O = AppCompatDelegateImpl.this.O(callbackWrapper);
            if (O != null) {
                return callbackWrapper.e(O);
            }
            return null;
        }

        public android.view.ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i) {
            if (!AppCompatDelegateImpl.this.A0() || i != 0) {
                return super.onWindowStartingActionMode(callback, i);
            }
            return startAsSupportActionMode(callback);
        }
    }

    public class AutoBatteryNightModeManager extends AutoNightModeManager {
        public final PowerManager c;

        public AutoBatteryNightModeManager(Context context) {
            super();
            this.c = (PowerManager) context.getApplicationContext().getSystemService("power");
        }

        public IntentFilter b() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.os.action.POWER_SAVE_MODE_CHANGED");
            return intentFilter;
        }

        public int c() {
            return Api21Impl.a(this.c) ? 2 : 1;
        }

        public void d() {
            AppCompatDelegateImpl.this.S();
        }
    }

    @RestrictTo
    @VisibleForTesting
    public abstract class AutoNightModeManager {

        /* renamed from: a  reason: collision with root package name */
        public BroadcastReceiver f174a;

        public AutoNightModeManager() {
        }

        public void a() {
            BroadcastReceiver broadcastReceiver = this.f174a;
            if (broadcastReceiver != null) {
                try {
                    AppCompatDelegateImpl.this.k.unregisterReceiver(broadcastReceiver);
                } catch (IllegalArgumentException unused) {
                }
                this.f174a = null;
            }
        }

        public abstract IntentFilter b();

        public abstract int c();

        public abstract void d();

        public void e() {
            a();
            IntentFilter b2 = b();
            if (b2 != null && b2.countActions() != 0) {
                if (this.f174a == null) {
                    this.f174a = new BroadcastReceiver() {
                        public void onReceive(Context context, Intent intent) {
                            AutoNightModeManager.this.d();
                        }
                    };
                }
                AppCompatDelegateImpl.this.k.registerReceiver(this.f174a, b2);
            }
        }
    }

    public class AutoTimeNightModeManager extends AutoNightModeManager {
        public final TwilightManager c;

        public AutoTimeNightModeManager(TwilightManager twilightManager) {
            super();
            this.c = twilightManager;
        }

        public IntentFilter b() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.TIME_SET");
            intentFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
            intentFilter.addAction("android.intent.action.TIME_TICK");
            return intentFilter;
        }

        public int c() {
            return this.c.d() ? 2 : 1;
        }

        public void d() {
            AppCompatDelegateImpl.this.S();
        }
    }

    @RequiresApi
    public static class ContextThemeWrapperCompatApi17Impl {
        public static void a(ContextThemeWrapper contextThemeWrapper, Configuration configuration) {
            contextThemeWrapper.applyOverrideConfiguration(configuration);
        }
    }

    public class ListMenuDecorView extends ContentFrameLayout {
        public ListMenuDecorView(Context context) {
            super(context);
        }

        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return AppCompatDelegateImpl.this.g0(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        public final boolean isOutOfBounds(int i, int i2) {
            return i < -5 || i2 < -5 || i > getWidth() + 5 || i2 > getHeight() + 5;
        }

        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (motionEvent.getAction() != 0 || !isOutOfBounds((int) motionEvent.getX(), (int) motionEvent.getY())) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            AppCompatDelegateImpl.this.a0(0);
            return true;
        }

        public void setBackgroundResource(int i) {
            setBackgroundDrawable(AppCompatResources.b(getContext(), i));
        }
    }

    public static final class PanelFeatureState {

        /* renamed from: a  reason: collision with root package name */
        public int f177a;
        public int b;
        public int c;
        public int d;
        public int e;
        public int f;
        public ViewGroup g;
        public View h;
        public View i;
        public MenuBuilder j;
        public ListMenuPresenter k;
        public Context l;
        public boolean m;
        public boolean n;
        public boolean o;
        public boolean p;
        public boolean q = false;
        public boolean r;
        public Bundle s;

        @SuppressLint({"BanParcelableUsage"})
        public static class SavedState implements Parcelable {
            public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() {
                /* renamed from: a */
                public SavedState createFromParcel(Parcel parcel) {
                    return SavedState.readFromParcel(parcel, (ClassLoader) null);
                }

                /* renamed from: b */
                public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                    return SavedState.readFromParcel(parcel, classLoader);
                }

                /* renamed from: c */
                public SavedState[] newArray(int i) {
                    return new SavedState[i];
                }
            };
            int featureId;
            boolean isOpen;
            Bundle menuState;

            public static SavedState readFromParcel(Parcel parcel, ClassLoader classLoader) {
                SavedState savedState = new SavedState();
                savedState.featureId = parcel.readInt();
                boolean z = true;
                if (parcel.readInt() != 1) {
                    z = false;
                }
                savedState.isOpen = z;
                if (z) {
                    savedState.menuState = parcel.readBundle(classLoader);
                }
                return savedState;
            }

            public int describeContents() {
                return 0;
            }

            public void writeToParcel(Parcel parcel, int i) {
                parcel.writeInt(this.featureId);
                parcel.writeInt(this.isOpen ? 1 : 0);
                if (this.isOpen) {
                    parcel.writeBundle(this.menuState);
                }
            }
        }

        public PanelFeatureState(int i2) {
            this.f177a = i2;
        }

        public MenuView a(MenuPresenter.Callback callback) {
            if (this.j == null) {
                return null;
            }
            if (this.k == null) {
                ListMenuPresenter listMenuPresenter = new ListMenuPresenter(this.l, R.layout.abc_list_menu_item_layout);
                this.k = listMenuPresenter;
                listMenuPresenter.setCallback(callback);
                this.j.addMenuPresenter(this.k);
            }
            return this.k.b(this.g);
        }

        public boolean b() {
            if (this.h == null) {
                return false;
            }
            if (this.i != null) {
                return true;
            }
            return this.k.a().getCount() > 0;
        }

        public void c(MenuBuilder menuBuilder) {
            ListMenuPresenter listMenuPresenter;
            MenuBuilder menuBuilder2 = this.j;
            if (menuBuilder != menuBuilder2) {
                if (menuBuilder2 != null) {
                    menuBuilder2.removeMenuPresenter(this.k);
                }
                this.j = menuBuilder;
                if (menuBuilder != null && (listMenuPresenter = this.k) != null) {
                    menuBuilder.addMenuPresenter(listMenuPresenter);
                }
            }
        }

        public void d(Context context) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme newTheme = context.getResources().newTheme();
            newTheme.setTo(context.getTheme());
            newTheme.resolveAttribute(R.attr.actionBarPopupTheme, typedValue, true);
            int i2 = typedValue.resourceId;
            if (i2 != 0) {
                newTheme.applyStyle(i2, true);
            }
            newTheme.resolveAttribute(R.attr.panelMenuListTheme, typedValue, true);
            int i3 = typedValue.resourceId;
            if (i3 != 0) {
                newTheme.applyStyle(i3, true);
            } else {
                newTheme.applyStyle(R.style.Theme_AppCompat_CompactMenu, true);
            }
            androidx.appcompat.view.ContextThemeWrapper contextThemeWrapper = new androidx.appcompat.view.ContextThemeWrapper(context, 0);
            contextThemeWrapper.getTheme().setTo(newTheme);
            this.l = contextThemeWrapper;
            TypedArray obtainStyledAttributes = contextThemeWrapper.obtainStyledAttributes(R.styleable.AppCompatTheme);
            this.b = obtainStyledAttributes.getResourceId(R.styleable.AppCompatTheme_panelBackground, 0);
            this.f = obtainStyledAttributes.getResourceId(R.styleable.AppCompatTheme_android_windowAnimationStyle, 0);
            obtainStyledAttributes.recycle();
        }
    }

    public final class PanelMenuPresenterCallback implements MenuPresenter.Callback {
        public PanelMenuPresenterCallback() {
        }

        public boolean a(MenuBuilder menuBuilder) {
            Window.Callback u0;
            if (menuBuilder != menuBuilder.getRootMenu()) {
                return true;
            }
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            if (!appCompatDelegateImpl.G || (u0 = appCompatDelegateImpl.u0()) == null || AppCompatDelegateImpl.this.R) {
                return true;
            }
            u0.onMenuOpened(108, menuBuilder);
            return true;
        }

        public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
            MenuBuilder rootMenu = menuBuilder.getRootMenu();
            boolean z2 = rootMenu != menuBuilder;
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            if (z2) {
                menuBuilder = rootMenu;
            }
            PanelFeatureState l0 = appCompatDelegateImpl.l0(menuBuilder);
            if (l0 == null) {
                return;
            }
            if (z2) {
                AppCompatDelegateImpl.this.X(l0.f177a, l0, rootMenu);
                AppCompatDelegateImpl.this.b0(l0, true);
                return;
            }
            AppCompatDelegateImpl.this.b0(l0, z);
        }
    }

    public AppCompatDelegateImpl(Activity activity, AppCompatCallback appCompatCallback) {
        this(activity, (Window) null, appCompatCallback, activity);
    }

    public static Configuration m0(Configuration configuration, Configuration configuration2) {
        Configuration configuration3 = new Configuration();
        configuration3.fontScale = 0.0f;
        if (!(configuration2 == null || configuration.diff(configuration2) == 0)) {
            float f = configuration.fontScale;
            float f2 = configuration2.fontScale;
            if (f != f2) {
                configuration3.fontScale = f2;
            }
            int i = configuration.mcc;
            int i2 = configuration2.mcc;
            if (i != i2) {
                configuration3.mcc = i2;
            }
            int i3 = configuration.mnc;
            int i4 = configuration2.mnc;
            if (i3 != i4) {
                configuration3.mnc = i4;
            }
            Api24Impl.a(configuration, configuration2, configuration3);
            int i5 = configuration.touchscreen;
            int i6 = configuration2.touchscreen;
            if (i5 != i6) {
                configuration3.touchscreen = i6;
            }
            int i7 = configuration.keyboard;
            int i8 = configuration2.keyboard;
            if (i7 != i8) {
                configuration3.keyboard = i8;
            }
            int i9 = configuration.keyboardHidden;
            int i10 = configuration2.keyboardHidden;
            if (i9 != i10) {
                configuration3.keyboardHidden = i10;
            }
            int i11 = configuration.navigation;
            int i12 = configuration2.navigation;
            if (i11 != i12) {
                configuration3.navigation = i12;
            }
            int i13 = configuration.navigationHidden;
            int i14 = configuration2.navigationHidden;
            if (i13 != i14) {
                configuration3.navigationHidden = i14;
            }
            int i15 = configuration.orientation;
            int i16 = configuration2.orientation;
            if (i15 != i16) {
                configuration3.orientation = i16;
            }
            int i17 = configuration.screenLayout & 15;
            int i18 = configuration2.screenLayout;
            if (i17 != (i18 & 15)) {
                configuration3.screenLayout |= i18 & 15;
            }
            int i19 = configuration.screenLayout & 192;
            int i20 = configuration2.screenLayout;
            if (i19 != (i20 & 192)) {
                configuration3.screenLayout |= i20 & 192;
            }
            int i21 = configuration.screenLayout & 48;
            int i22 = configuration2.screenLayout;
            if (i21 != (i22 & 48)) {
                configuration3.screenLayout |= i22 & 48;
            }
            int i23 = configuration.screenLayout & ViewUtils.EDGE_TO_EDGE_FLAGS;
            int i24 = configuration2.screenLayout;
            if (i23 != (i24 & ViewUtils.EDGE_TO_EDGE_FLAGS)) {
                configuration3.screenLayout |= i24 & ViewUtils.EDGE_TO_EDGE_FLAGS;
            }
            Api26Impl.a(configuration, configuration2, configuration3);
            int i25 = configuration.uiMode & 15;
            int i26 = configuration2.uiMode;
            if (i25 != (i26 & 15)) {
                configuration3.uiMode |= i26 & 15;
            }
            int i27 = configuration.uiMode & 48;
            int i28 = configuration2.uiMode;
            if (i27 != (i28 & 48)) {
                configuration3.uiMode |= i28 & 48;
            }
            int i29 = configuration.screenWidthDp;
            int i30 = configuration2.screenWidthDp;
            if (i29 != i30) {
                configuration3.screenWidthDp = i30;
            }
            int i31 = configuration.screenHeightDp;
            int i32 = configuration2.screenHeightDp;
            if (i31 != i32) {
                configuration3.screenHeightDp = i32;
            }
            int i33 = configuration.smallestScreenWidthDp;
            int i34 = configuration2.smallestScreenWidthDp;
            if (i33 != i34) {
                configuration3.smallestScreenWidthDp = i34;
            }
            Api17Impl.b(configuration, configuration2, configuration3);
        }
        return configuration3;
    }

    public void A(Bundle bundle) {
    }

    public boolean A0() {
        return this.z;
    }

    public void B() {
        R(true, false);
    }

    public int B0(Context context, int i) {
        if (i == -100) {
            return -1;
        }
        if (i != -1) {
            if (i != 0) {
                if (!(i == 1 || i == 2)) {
                    if (i == 3) {
                        return p0(context).c();
                    }
                    throw new IllegalStateException("Unknown value set for night mode. Please use one of the MODE_NIGHT values from AppCompatDelegate.");
                }
            } else if (((UiModeManager) context.getApplicationContext().getSystemService("uimode")).getNightMode() == 0) {
                return -1;
            } else {
                return q0(context).c();
            }
        }
        return i;
    }

    public void C() {
        ActionBar q2 = q();
        if (q2 != null) {
            q2.w(false);
        }
    }

    public boolean C0() {
        boolean z2 = this.O;
        this.O = false;
        PanelFeatureState s02 = s0(0, false);
        if (s02 == null || !s02.o) {
            androidx.appcompat.view.ActionMode actionMode = this.u;
            if (actionMode != null) {
                actionMode.a();
                return true;
            }
            ActionBar q2 = q();
            return q2 != null && q2.b();
        }
        if (!z2) {
            b0(s02, true);
        }
        return true;
    }

    public boolean D0(int i, KeyEvent keyEvent) {
        boolean z2 = true;
        if (i == 4) {
            if ((keyEvent.getFlags() & 128) == 0) {
                z2 = false;
            }
            this.O = z2;
        } else if (i == 82) {
            E0(0, keyEvent);
            return true;
        }
        return false;
    }

    public final boolean E0(int i, KeyEvent keyEvent) {
        if (keyEvent.getRepeatCount() != 0) {
            return false;
        }
        PanelFeatureState s02 = s0(i, true);
        if (!s02.o) {
            return O0(s02, keyEvent);
        }
        return false;
    }

    public boolean F(int i) {
        int Q0 = Q0(i);
        if (this.K && Q0 == 108) {
            return false;
        }
        if (this.G && Q0 == 1) {
            this.G = false;
        }
        if (Q0 == 1) {
            X0();
            this.K = true;
            return true;
        } else if (Q0 == 2) {
            X0();
            this.E = true;
            return true;
        } else if (Q0 == 5) {
            X0();
            this.F = true;
            return true;
        } else if (Q0 == 10) {
            X0();
            this.I = true;
            return true;
        } else if (Q0 == 108) {
            X0();
            this.G = true;
            return true;
        } else if (Q0 != 109) {
            return this.l.requestFeature(Q0);
        } else {
            X0();
            this.H = true;
            return true;
        }
    }

    public boolean F0(int i, KeyEvent keyEvent) {
        ActionBar q2 = q();
        if (q2 != null && q2.k(i, keyEvent)) {
            return true;
        }
        PanelFeatureState panelFeatureState = this.N;
        if (panelFeatureState == null || !N0(panelFeatureState, keyEvent.getKeyCode(), keyEvent, 1)) {
            if (this.N == null) {
                PanelFeatureState s02 = s0(0, true);
                O0(s02, keyEvent);
                boolean N0 = N0(s02, keyEvent.getKeyCode(), keyEvent, 1);
                s02.m = false;
                if (N0) {
                    return true;
                }
            }
            return false;
        }
        PanelFeatureState panelFeatureState2 = this.N;
        if (panelFeatureState2 != null) {
            panelFeatureState2.n = true;
        }
        return true;
    }

    public boolean G0(int i, KeyEvent keyEvent) {
        if (i != 4) {
            if (i == 82) {
                H0(0, keyEvent);
                return true;
            }
        } else if (C0()) {
            return true;
        }
        return false;
    }

    public void H(int i) {
        j0();
        ViewGroup viewGroup = (ViewGroup) this.B.findViewById(16908290);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.k).inflate(i, viewGroup);
        this.m.b(this.l.getCallback());
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x006a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean H0(int r5, android.view.KeyEvent r6) {
        /*
            r4 = this;
            androidx.appcompat.view.ActionMode r0 = r4.u
            r1 = 0
            if (r0 == 0) goto L_0x0006
            return r1
        L_0x0006:
            r0 = 1
            androidx.appcompat.app.AppCompatDelegateImpl$PanelFeatureState r2 = r4.s0(r5, r0)
            if (r5 != 0) goto L_0x0043
            androidx.appcompat.widget.DecorContentParent r5 = r4.r
            if (r5 == 0) goto L_0x0043
            boolean r5 = r5.canShowOverflowMenu()
            if (r5 == 0) goto L_0x0043
            android.content.Context r5 = r4.k
            android.view.ViewConfiguration r5 = android.view.ViewConfiguration.get(r5)
            boolean r5 = r5.hasPermanentMenuKey()
            if (r5 != 0) goto L_0x0043
            androidx.appcompat.widget.DecorContentParent r5 = r4.r
            boolean r5 = r5.isOverflowMenuShowing()
            if (r5 != 0) goto L_0x003c
            boolean r5 = r4.R
            if (r5 != 0) goto L_0x0062
            boolean r5 = r4.O0(r2, r6)
            if (r5 == 0) goto L_0x0062
            androidx.appcompat.widget.DecorContentParent r5 = r4.r
            boolean r0 = r5.showOverflowMenu()
            goto L_0x0068
        L_0x003c:
            androidx.appcompat.widget.DecorContentParent r5 = r4.r
            boolean r0 = r5.hideOverflowMenu()
            goto L_0x0068
        L_0x0043:
            boolean r5 = r2.o
            if (r5 != 0) goto L_0x0064
            boolean r3 = r2.n
            if (r3 == 0) goto L_0x004c
            goto L_0x0064
        L_0x004c:
            boolean r5 = r2.m
            if (r5 == 0) goto L_0x0062
            boolean r5 = r2.r
            if (r5 == 0) goto L_0x005b
            r2.m = r1
            boolean r5 = r4.O0(r2, r6)
            goto L_0x005c
        L_0x005b:
            r5 = r0
        L_0x005c:
            if (r5 == 0) goto L_0x0062
            r4.L0(r2, r6)
            goto L_0x0068
        L_0x0062:
            r0 = r1
            goto L_0x0068
        L_0x0064:
            r4.b0(r2, r0)
            r0 = r5
        L_0x0068:
            if (r0 == 0) goto L_0x0085
            android.content.Context r4 = r4.k
            android.content.Context r4 = r4.getApplicationContext()
            java.lang.String r5 = "audio"
            java.lang.Object r4 = r4.getSystemService(r5)
            android.media.AudioManager r4 = (android.media.AudioManager) r4
            if (r4 == 0) goto L_0x007e
            r4.playSoundEffect(r1)
            goto L_0x0085
        L_0x007e:
            java.lang.String r4 = "AppCompatDelegate"
            java.lang.String r5 = "Couldn't get audio manager"
            android.util.Log.w(r4, r5)
        L_0x0085:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.H0(int, android.view.KeyEvent):boolean");
    }

    public void I(View view) {
        j0();
        ViewGroup viewGroup = (ViewGroup) this.B.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.m.b(this.l.getCallback());
    }

    public void I0(int i) {
        ActionBar q2;
        if (i == 108 && (q2 = q()) != null) {
            q2.c(true);
        }
    }

    public void J(View view, ViewGroup.LayoutParams layoutParams) {
        j0();
        ViewGroup viewGroup = (ViewGroup) this.B.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.m.b(this.l.getCallback());
    }

    public void J0(int i) {
        if (i == 108) {
            ActionBar q2 = q();
            if (q2 != null) {
                q2.c(false);
            }
        } else if (i == 0) {
            PanelFeatureState s02 = s0(i, true);
            if (s02.o) {
                b0(s02, false);
            }
        }
    }

    public void K(OnBackInvokedDispatcher onBackInvokedDispatcher) {
        OnBackInvokedCallback onBackInvokedCallback;
        super.K(onBackInvokedDispatcher);
        OnBackInvokedDispatcher onBackInvokedDispatcher2 = this.n0;
        if (!(onBackInvokedDispatcher2 == null || (onBackInvokedCallback = this.o0) == null)) {
            Api33Impl.c(onBackInvokedDispatcher2, onBackInvokedCallback);
            this.o0 = null;
        }
        if (onBackInvokedDispatcher == null) {
            Object obj = this.j;
            if ((obj instanceof Activity) && ((Activity) obj).getWindow() != null) {
                this.n0 = Api33Impl.a((Activity) this.j);
                b1();
            }
        }
        this.n0 = onBackInvokedDispatcher;
        b1();
    }

    public void K0(ViewGroup viewGroup) {
    }

    public void L(Toolbar toolbar) {
        if (this.j instanceof Activity) {
            ActionBar q2 = q();
            if (!(q2 instanceof WindowDecorActionBar)) {
                this.p = null;
                if (q2 != null) {
                    q2.j();
                }
                this.o = null;
                if (toolbar != null) {
                    ToolbarActionBar toolbarActionBar = new ToolbarActionBar(toolbar, t0(), this.m);
                    this.o = toolbarActionBar;
                    this.m.d(toolbarActionBar.c);
                    toolbar.setBackInvokedCallbackEnabled(true);
                } else {
                    this.m.d((ActionBarMenuCallback) null);
                }
                s();
                return;
            }
            throw new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:58:0x00ed  */
    /* JADX WARNING: Removed duplicated region for block: B:63:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void L0(androidx.appcompat.app.AppCompatDelegateImpl.PanelFeatureState r12, android.view.KeyEvent r13) {
        /*
            r11 = this;
            boolean r0 = r12.o
            if (r0 != 0) goto L_0x00f3
            boolean r0 = r11.R
            if (r0 == 0) goto L_0x000a
            goto L_0x00f3
        L_0x000a:
            int r0 = r12.f177a
            if (r0 != 0) goto L_0x0020
            android.content.Context r0 = r11.k
            android.content.res.Resources r0 = r0.getResources()
            android.content.res.Configuration r0 = r0.getConfiguration()
            int r0 = r0.screenLayout
            r0 = r0 & 15
            r1 = 4
            if (r0 != r1) goto L_0x0020
            return
        L_0x0020:
            android.view.Window$Callback r0 = r11.u0()
            r1 = 1
            if (r0 == 0) goto L_0x0035
            int r2 = r12.f177a
            androidx.appcompat.view.menu.MenuBuilder r3 = r12.j
            boolean r0 = r0.onMenuOpened(r2, r3)
            if (r0 != 0) goto L_0x0035
            r11.b0(r12, r1)
            return
        L_0x0035:
            android.content.Context r0 = r11.k
            java.lang.String r2 = "window"
            java.lang.Object r0 = r0.getSystemService(r2)
            android.view.WindowManager r0 = (android.view.WindowManager) r0
            if (r0 != 0) goto L_0x0042
            return
        L_0x0042:
            boolean r13 = r11.O0(r12, r13)
            if (r13 != 0) goto L_0x0049
            return
        L_0x0049:
            android.view.ViewGroup r13 = r12.g
            r2 = -2
            if (r13 == 0) goto L_0x0064
            boolean r3 = r12.q
            if (r3 == 0) goto L_0x0053
            goto L_0x0064
        L_0x0053:
            android.view.View r13 = r12.i
            if (r13 == 0) goto L_0x00c6
            android.view.ViewGroup$LayoutParams r13 = r13.getLayoutParams()
            if (r13 == 0) goto L_0x00c6
            int r13 = r13.width
            r3 = -1
            if (r13 != r3) goto L_0x00c6
            r4 = r3
            goto L_0x00c7
        L_0x0064:
            if (r13 != 0) goto L_0x0071
            boolean r13 = r11.x0(r12)
            if (r13 == 0) goto L_0x0070
            android.view.ViewGroup r13 = r12.g
            if (r13 != 0) goto L_0x0080
        L_0x0070:
            return
        L_0x0071:
            boolean r3 = r12.q
            if (r3 == 0) goto L_0x0080
            int r13 = r13.getChildCount()
            if (r13 <= 0) goto L_0x0080
            android.view.ViewGroup r13 = r12.g
            r13.removeAllViews()
        L_0x0080:
            boolean r13 = r11.w0(r12)
            if (r13 == 0) goto L_0x00f1
            boolean r13 = r12.b()
            if (r13 != 0) goto L_0x008d
            goto L_0x00f1
        L_0x008d:
            android.view.View r13 = r12.h
            android.view.ViewGroup$LayoutParams r13 = r13.getLayoutParams()
            if (r13 != 0) goto L_0x009a
            android.view.ViewGroup$LayoutParams r13 = new android.view.ViewGroup$LayoutParams
            r13.<init>(r2, r2)
        L_0x009a:
            int r3 = r12.b
            android.view.ViewGroup r4 = r12.g
            r4.setBackgroundResource(r3)
            android.view.View r3 = r12.h
            android.view.ViewParent r3 = r3.getParent()
            boolean r4 = r3 instanceof android.view.ViewGroup
            if (r4 == 0) goto L_0x00b2
            android.view.ViewGroup r3 = (android.view.ViewGroup) r3
            android.view.View r4 = r12.h
            r3.removeView(r4)
        L_0x00b2:
            android.view.ViewGroup r3 = r12.g
            android.view.View r4 = r12.h
            r3.addView(r4, r13)
            android.view.View r13 = r12.h
            boolean r13 = r13.hasFocus()
            if (r13 != 0) goto L_0x00c6
            android.view.View r13 = r12.h
            r13.requestFocus()
        L_0x00c6:
            r4 = r2
        L_0x00c7:
            r13 = 0
            r12.n = r13
            android.view.WindowManager$LayoutParams r13 = new android.view.WindowManager$LayoutParams
            int r6 = r12.d
            int r7 = r12.e
            r9 = 8519680(0x820000, float:1.1938615E-38)
            r10 = -3
            r5 = -2
            r8 = 1002(0x3ea, float:1.404E-42)
            r3 = r13
            r3.<init>(r4, r5, r6, r7, r8, r9, r10)
            int r2 = r12.c
            r13.gravity = r2
            int r2 = r12.f
            r13.windowAnimations = r2
            android.view.ViewGroup r2 = r12.g
            r0.addView(r2, r13)
            r12.o = r1
            int r12 = r12.f177a
            if (r12 != 0) goto L_0x00f0
            r11.b1()
        L_0x00f0:
            return
        L_0x00f1:
            r12.q = r1
        L_0x00f3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.L0(androidx.appcompat.app.AppCompatDelegateImpl$PanelFeatureState, android.view.KeyEvent):void");
    }

    public void M(int i) {
        this.U = i;
    }

    public final ActionBar M0() {
        return this.o;
    }

    public final void N(CharSequence charSequence) {
        this.q = charSequence;
        DecorContentParent decorContentParent = this.r;
        if (decorContentParent != null) {
            decorContentParent.setWindowTitle(charSequence);
        } else if (M0() != null) {
            M0().y(charSequence);
        } else {
            TextView textView = this.C;
            if (textView != null) {
                textView.setText(charSequence);
            }
        }
    }

    public final boolean N0(PanelFeatureState panelFeatureState, int i, KeyEvent keyEvent, int i2) {
        MenuBuilder menuBuilder;
        boolean z2 = false;
        if (keyEvent.isSystem()) {
            return false;
        }
        if ((panelFeatureState.m || O0(panelFeatureState, keyEvent)) && (menuBuilder = panelFeatureState.j) != null) {
            z2 = menuBuilder.performShortcut(i, keyEvent, i2);
        }
        if (z2 && (i2 & 1) == 0 && this.r == null) {
            b0(panelFeatureState, true);
        }
        return z2;
    }

    public androidx.appcompat.view.ActionMode O(ActionMode.Callback callback) {
        AppCompatCallback appCompatCallback;
        if (callback != null) {
            androidx.appcompat.view.ActionMode actionMode = this.u;
            if (actionMode != null) {
                actionMode.a();
            }
            ActionModeCallbackWrapperV9 actionModeCallbackWrapperV9 = new ActionModeCallbackWrapperV9(callback);
            ActionBar q2 = q();
            if (q2 != null) {
                androidx.appcompat.view.ActionMode z2 = q2.z(actionModeCallbackWrapperV9);
                this.u = z2;
                if (!(z2 == null || (appCompatCallback = this.n) == null)) {
                    appCompatCallback.onSupportActionModeStarted(z2);
                }
            }
            if (this.u == null) {
                this.u = W0(actionModeCallbackWrapperV9);
            }
            b1();
            return this.u;
        }
        throw new IllegalArgumentException("ActionMode callback can not be null.");
    }

    public final boolean O0(PanelFeatureState panelFeatureState, KeyEvent keyEvent) {
        DecorContentParent decorContentParent;
        DecorContentParent decorContentParent2;
        DecorContentParent decorContentParent3;
        if (this.R) {
            return false;
        }
        if (panelFeatureState.m) {
            return true;
        }
        PanelFeatureState panelFeatureState2 = this.N;
        if (!(panelFeatureState2 == null || panelFeatureState2 == panelFeatureState)) {
            b0(panelFeatureState2, false);
        }
        Window.Callback u0 = u0();
        if (u0 != null) {
            panelFeatureState.i = u0.onCreatePanelView(panelFeatureState.f177a);
        }
        int i = panelFeatureState.f177a;
        boolean z2 = i == 0 || i == 108;
        if (z2 && (decorContentParent3 = this.r) != null) {
            decorContentParent3.setMenuPrepared();
        }
        if (panelFeatureState.i == null && (!z2 || !(M0() instanceof ToolbarActionBar))) {
            MenuBuilder menuBuilder = panelFeatureState.j;
            if (menuBuilder == null || panelFeatureState.r) {
                if (menuBuilder == null && (!y0(panelFeatureState) || panelFeatureState.j == null)) {
                    return false;
                }
                if (z2 && this.r != null) {
                    if (this.s == null) {
                        this.s = new ActionMenuPresenterCallback();
                    }
                    this.r.a(panelFeatureState.j, this.s);
                }
                panelFeatureState.j.stopDispatchingItemsChanged();
                if (!u0.onCreatePanelMenu(panelFeatureState.f177a, panelFeatureState.j)) {
                    panelFeatureState.c((MenuBuilder) null);
                    if (z2 && (decorContentParent2 = this.r) != null) {
                        decorContentParent2.a((Menu) null, this.s);
                    }
                    return false;
                }
                panelFeatureState.r = false;
            }
            panelFeatureState.j.stopDispatchingItemsChanged();
            Bundle bundle = panelFeatureState.s;
            if (bundle != null) {
                panelFeatureState.j.restoreActionViewStates(bundle);
                panelFeatureState.s = null;
            }
            if (!u0.onPreparePanel(0, panelFeatureState.i, panelFeatureState.j)) {
                if (z2 && (decorContentParent = this.r) != null) {
                    decorContentParent.a((Menu) null, this.s);
                }
                panelFeatureState.j.startDispatchingItemsChanged();
                return false;
            }
            boolean z3 = KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1;
            panelFeatureState.p = z3;
            panelFeatureState.j.setQwertyMode(z3);
            panelFeatureState.j.startDispatchingItemsChanged();
        }
        panelFeatureState.m = true;
        panelFeatureState.n = false;
        this.N = panelFeatureState;
        return true;
    }

    public final void P0(boolean z2) {
        DecorContentParent decorContentParent = this.r;
        if (decorContentParent == null || !decorContentParent.canShowOverflowMenu() || (ViewConfiguration.get(this.k).hasPermanentMenuKey() && !this.r.isOverflowMenuShowPending())) {
            PanelFeatureState s02 = s0(0, true);
            s02.q = true;
            b0(s02, false);
            L0(s02, (KeyEvent) null);
            return;
        }
        Window.Callback u0 = u0();
        if (this.r.isOverflowMenuShowing() && z2) {
            this.r.hideOverflowMenu();
            if (!this.R) {
                u0.onPanelClosed(108, s0(0, true).j);
            }
        } else if (u0 != null && !this.R) {
            if (this.Z && (this.g0 & 1) != 0) {
                this.l.getDecorView().removeCallbacks(this.h0);
                this.h0.run();
            }
            PanelFeatureState s03 = s0(0, true);
            MenuBuilder menuBuilder = s03.j;
            if (menuBuilder != null && !s03.r && u0.onPreparePanel(0, s03.i, menuBuilder)) {
                u0.onMenuOpened(108, s03.j);
                this.r.showOverflowMenu();
            }
        }
    }

    public final boolean Q(boolean z2) {
        return R(z2, true);
    }

    public final int Q0(int i) {
        if (i == 8) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
            return 108;
        } else if (i != 9) {
            return i;
        } else {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
            return 109;
        }
    }

    public final boolean R(boolean z2, boolean z3) {
        if (this.R) {
            return false;
        }
        int W2 = W();
        int B0 = B0(this.k, W2);
        LocaleListCompat V2 = Build.VERSION.SDK_INT < 33 ? V(this.k) : null;
        if (!z3 && V2 != null) {
            V2 = r0(this.k.getResources().getConfiguration());
        }
        boolean a1 = a1(B0, V2, z2);
        if (W2 == 0) {
            q0(this.k).e();
        } else {
            AutoNightModeManager autoNightModeManager = this.X;
            if (autoNightModeManager != null) {
                autoNightModeManager.a();
            }
        }
        if (W2 == 3) {
            p0(this.k).e();
        } else {
            AutoNightModeManager autoNightModeManager2 = this.Y;
            if (autoNightModeManager2 != null) {
                autoNightModeManager2.a();
            }
        }
        return a1;
    }

    public void R0(Configuration configuration, LocaleListCompat localeListCompat) {
        Api24Impl.d(configuration, localeListCompat);
    }

    public boolean S() {
        return Q(true);
    }

    public void S0(LocaleListCompat localeListCompat) {
        Api24Impl.c(localeListCompat);
    }

    public final void T() {
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) this.B.findViewById(16908290);
        View decorView = this.l.getDecorView();
        contentFrameLayout.setDecorPadding(decorView.getPaddingLeft(), decorView.getPaddingTop(), decorView.getPaddingRight(), decorView.getPaddingBottom());
        TypedArray obtainStyledAttributes = this.k.obtainStyledAttributes(R.styleable.AppCompatTheme);
        obtainStyledAttributes.getValue(R.styleable.AppCompatTheme_windowMinWidthMajor, contentFrameLayout.getMinWidthMajor());
        obtainStyledAttributes.getValue(R.styleable.AppCompatTheme_windowMinWidthMinor, contentFrameLayout.getMinWidthMinor());
        if (obtainStyledAttributes.hasValue(R.styleable.AppCompatTheme_windowFixedWidthMajor)) {
            obtainStyledAttributes.getValue(R.styleable.AppCompatTheme_windowFixedWidthMajor, contentFrameLayout.getFixedWidthMajor());
        }
        if (obtainStyledAttributes.hasValue(R.styleable.AppCompatTheme_windowFixedWidthMinor)) {
            obtainStyledAttributes.getValue(R.styleable.AppCompatTheme_windowFixedWidthMinor, contentFrameLayout.getFixedWidthMinor());
        }
        if (obtainStyledAttributes.hasValue(R.styleable.AppCompatTheme_windowFixedHeightMajor)) {
            obtainStyledAttributes.getValue(R.styleable.AppCompatTheme_windowFixedHeightMajor, contentFrameLayout.getFixedHeightMajor());
        }
        if (obtainStyledAttributes.hasValue(R.styleable.AppCompatTheme_windowFixedHeightMinor)) {
            obtainStyledAttributes.getValue(R.styleable.AppCompatTheme_windowFixedHeightMinor, contentFrameLayout.getFixedHeightMinor());
        }
        obtainStyledAttributes.recycle();
        contentFrameLayout.requestLayout();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r1 = r1.B;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean T0() {
        /*
            r1 = this;
            boolean r0 = r1.A
            if (r0 == 0) goto L_0x0010
            android.view.ViewGroup r1 = r1.B
            if (r1 == 0) goto L_0x0010
            boolean r1 = androidx.core.view.ViewCompat.W(r1)
            if (r1 == 0) goto L_0x0010
            r1 = 1
            goto L_0x0011
        L_0x0010:
            r1 = 0
        L_0x0011:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.T0():boolean");
    }

    public final void U(Window window) {
        if (this.l == null) {
            Window.Callback callback = window.getCallback();
            if (!(callback instanceof AppCompatWindowCallback)) {
                AppCompatWindowCallback appCompatWindowCallback = new AppCompatWindowCallback(callback);
                this.m = appCompatWindowCallback;
                window.setCallback(appCompatWindowCallback);
                TintTypedArray u2 = TintTypedArray.u(this.k, (AttributeSet) null, r0);
                Drawable h = u2.h(0);
                if (h != null) {
                    window.setBackgroundDrawable(h);
                }
                u2.w();
                this.l = window;
                if (Build.VERSION.SDK_INT >= 33 && this.n0 == null) {
                    K((OnBackInvokedDispatcher) null);
                    return;
                }
                return;
            }
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        throw new IllegalStateException("AppCompat has already installed itself into the Window");
    }

    public final boolean U0(ViewParent viewParent) {
        if (viewParent == null) {
            return false;
        }
        View decorView = this.l.getDecorView();
        while (viewParent != null) {
            if (viewParent == decorView || !(viewParent instanceof View) || ViewCompat.V((View) viewParent)) {
                return false;
            }
            viewParent = viewParent.getParent();
        }
        return true;
    }

    public LocaleListCompat V(Context context) {
        LocaleListCompat p2;
        if (Build.VERSION.SDK_INT >= 33 || (p2 = AppCompatDelegate.p()) == null) {
            return null;
        }
        LocaleListCompat r02 = r0(context.getApplicationContext().getResources().getConfiguration());
        LocaleListCompat b = LocaleOverlayHelper.b(p2, r02);
        return b.f() ? r02 : b;
    }

    public boolean V0() {
        if (this.n0 == null) {
            return false;
        }
        PanelFeatureState s02 = s0(0, false);
        return (s02 != null && s02.o) || this.u != null;
    }

    public final int W() {
        int i = this.T;
        return i != -100 ? i : AppCompatDelegate.k();
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0025  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0029  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public androidx.appcompat.view.ActionMode W0(androidx.appcompat.view.ActionMode.Callback r8) {
        /*
            r7 = this;
            r7.i0()
            androidx.appcompat.view.ActionMode r0 = r7.u
            if (r0 == 0) goto L_0x000a
            r0.a()
        L_0x000a:
            boolean r0 = r8 instanceof androidx.appcompat.app.AppCompatDelegateImpl.ActionModeCallbackWrapperV9
            if (r0 != 0) goto L_0x0014
            androidx.appcompat.app.AppCompatDelegateImpl$ActionModeCallbackWrapperV9 r0 = new androidx.appcompat.app.AppCompatDelegateImpl$ActionModeCallbackWrapperV9
            r0.<init>(r8)
            r8 = r0
        L_0x0014:
            androidx.appcompat.app.AppCompatCallback r0 = r7.n
            r1 = 0
            if (r0 == 0) goto L_0x0022
            boolean r2 = r7.R
            if (r2 != 0) goto L_0x0022
            androidx.appcompat.view.ActionMode r0 = r0.onWindowStartingSupportActionMode(r8)     // Catch:{ AbstractMethodError -> 0x0022 }
            goto L_0x0023
        L_0x0022:
            r0 = r1
        L_0x0023:
            if (r0 == 0) goto L_0x0029
            r7.u = r0
            goto L_0x015b
        L_0x0029:
            androidx.appcompat.widget.ActionBarContextView r0 = r7.v
            r2 = 0
            r3 = 1
            if (r0 != 0) goto L_0x00d4
            boolean r0 = r7.J
            if (r0 == 0) goto L_0x00b5
            android.util.TypedValue r0 = new android.util.TypedValue
            r0.<init>()
            android.content.Context r4 = r7.k
            android.content.res.Resources$Theme r4 = r4.getTheme()
            int r5 = androidx.appcompat.R.attr.actionBarTheme
            r4.resolveAttribute(r5, r0, r3)
            int r5 = r0.resourceId
            if (r5 == 0) goto L_0x0068
            android.content.Context r5 = r7.k
            android.content.res.Resources r5 = r5.getResources()
            android.content.res.Resources$Theme r5 = r5.newTheme()
            r5.setTo(r4)
            int r4 = r0.resourceId
            r5.applyStyle(r4, r3)
            androidx.appcompat.view.ContextThemeWrapper r4 = new androidx.appcompat.view.ContextThemeWrapper
            android.content.Context r6 = r7.k
            r4.<init>((android.content.Context) r6, (int) r2)
            android.content.res.Resources$Theme r6 = r4.getTheme()
            r6.setTo(r5)
            goto L_0x006a
        L_0x0068:
            android.content.Context r4 = r7.k
        L_0x006a:
            androidx.appcompat.widget.ActionBarContextView r5 = new androidx.appcompat.widget.ActionBarContextView
            r5.<init>(r4)
            r7.v = r5
            android.widget.PopupWindow r5 = new android.widget.PopupWindow
            int r6 = androidx.appcompat.R.attr.actionModePopupWindowStyle
            r5.<init>(r4, r1, r6)
            r7.w = r5
            r6 = 2
            androidx.core.widget.PopupWindowCompat.c(r5, r6)
            android.widget.PopupWindow r5 = r7.w
            androidx.appcompat.widget.ActionBarContextView r6 = r7.v
            r5.setContentView(r6)
            android.widget.PopupWindow r5 = r7.w
            r6 = -1
            r5.setWidth(r6)
            android.content.res.Resources$Theme r5 = r4.getTheme()
            int r6 = androidx.appcompat.R.attr.actionBarSize
            r5.resolveAttribute(r6, r0, r3)
            int r0 = r0.data
            android.content.res.Resources r4 = r4.getResources()
            android.util.DisplayMetrics r4 = r4.getDisplayMetrics()
            int r0 = android.util.TypedValue.complexToDimensionPixelSize(r0, r4)
            androidx.appcompat.widget.ActionBarContextView r4 = r7.v
            r4.setContentHeight(r0)
            android.widget.PopupWindow r0 = r7.w
            r4 = -2
            r0.setHeight(r4)
            androidx.appcompat.app.AppCompatDelegateImpl$6 r0 = new androidx.appcompat.app.AppCompatDelegateImpl$6
            r0.<init>()
            r7.x = r0
            goto L_0x00d4
        L_0x00b5:
            android.view.ViewGroup r0 = r7.B
            int r4 = androidx.appcompat.R.id.action_mode_bar_stub
            android.view.View r0 = r0.findViewById(r4)
            androidx.appcompat.widget.ViewStubCompat r0 = (androidx.appcompat.widget.ViewStubCompat) r0
            if (r0 == 0) goto L_0x00d4
            android.content.Context r4 = r7.n0()
            android.view.LayoutInflater r4 = android.view.LayoutInflater.from(r4)
            r0.setLayoutInflater(r4)
            android.view.View r0 = r0.a()
            androidx.appcompat.widget.ActionBarContextView r0 = (androidx.appcompat.widget.ActionBarContextView) r0
            r7.v = r0
        L_0x00d4:
            androidx.appcompat.widget.ActionBarContextView r0 = r7.v
            if (r0 == 0) goto L_0x015b
            r7.i0()
            androidx.appcompat.widget.ActionBarContextView r0 = r7.v
            r0.l()
            androidx.appcompat.view.StandaloneActionMode r0 = new androidx.appcompat.view.StandaloneActionMode
            androidx.appcompat.widget.ActionBarContextView r4 = r7.v
            android.content.Context r4 = r4.getContext()
            androidx.appcompat.widget.ActionBarContextView r5 = r7.v
            android.widget.PopupWindow r6 = r7.w
            if (r6 != 0) goto L_0x00ef
            goto L_0x00f0
        L_0x00ef:
            r3 = r2
        L_0x00f0:
            r0.<init>(r4, r5, r8, r3)
            android.view.Menu r3 = r0.c()
            boolean r8 = r8.a(r0, r3)
            if (r8 == 0) goto L_0x0159
            r0.i()
            androidx.appcompat.widget.ActionBarContextView r8 = r7.v
            r8.i(r0)
            r7.u = r0
            boolean r8 = r7.T0()
            r0 = 1065353216(0x3f800000, float:1.0)
            if (r8 == 0) goto L_0x012a
            androidx.appcompat.widget.ActionBarContextView r8 = r7.v
            r1 = 0
            r8.setAlpha(r1)
            androidx.appcompat.widget.ActionBarContextView r8 = r7.v
            androidx.core.view.ViewPropertyAnimatorCompat r8 = androidx.core.view.ViewCompat.e(r8)
            androidx.core.view.ViewPropertyAnimatorCompat r8 = r8.b(r0)
            r7.y = r8
            androidx.appcompat.app.AppCompatDelegateImpl$7 r0 = new androidx.appcompat.app.AppCompatDelegateImpl$7
            r0.<init>()
            r8.k(r0)
            goto L_0x0149
        L_0x012a:
            androidx.appcompat.widget.ActionBarContextView r8 = r7.v
            r8.setAlpha(r0)
            androidx.appcompat.widget.ActionBarContextView r8 = r7.v
            r8.setVisibility(r2)
            androidx.appcompat.widget.ActionBarContextView r8 = r7.v
            android.view.ViewParent r8 = r8.getParent()
            boolean r8 = r8 instanceof android.view.View
            if (r8 == 0) goto L_0x0149
            androidx.appcompat.widget.ActionBarContextView r8 = r7.v
            android.view.ViewParent r8 = r8.getParent()
            android.view.View r8 = (android.view.View) r8
            androidx.core.view.ViewCompat.q0(r8)
        L_0x0149:
            android.widget.PopupWindow r8 = r7.w
            if (r8 == 0) goto L_0x015b
            android.view.Window r8 = r7.l
            android.view.View r8 = r8.getDecorView()
            java.lang.Runnable r0 = r7.x
            r8.post(r0)
            goto L_0x015b
        L_0x0159:
            r7.u = r1
        L_0x015b:
            androidx.appcompat.view.ActionMode r8 = r7.u
            if (r8 == 0) goto L_0x0166
            androidx.appcompat.app.AppCompatCallback r0 = r7.n
            if (r0 == 0) goto L_0x0166
            r0.onSupportActionModeStarted(r8)
        L_0x0166:
            r7.b1()
            androidx.appcompat.view.ActionMode r7 = r7.u
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.W0(androidx.appcompat.view.ActionMode$Callback):androidx.appcompat.view.ActionMode");
    }

    public void X(int i, PanelFeatureState panelFeatureState, Menu menu) {
        if (menu == null) {
            if (panelFeatureState == null && i >= 0) {
                PanelFeatureState[] panelFeatureStateArr = this.M;
                if (i < panelFeatureStateArr.length) {
                    panelFeatureState = panelFeatureStateArr[i];
                }
            }
            if (panelFeatureState != null) {
                menu = panelFeatureState.j;
            }
        }
        if ((panelFeatureState == null || panelFeatureState.o) && !this.R) {
            this.m.c(this.l.getCallback(), i, menu);
        }
    }

    public final void X0() {
        if (this.A) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    public void Y(MenuBuilder menuBuilder) {
        if (!this.L) {
            this.L = true;
            this.r.dismissPopups();
            Window.Callback u0 = u0();
            if (u0 != null && !this.R) {
                u0.onPanelClosed(108, menuBuilder);
            }
            this.L = false;
        }
    }

    public final AppCompatActivity Y0() {
        Context context = this.k;
        while (context != null) {
            if (!(context instanceof AppCompatActivity)) {
                if (!(context instanceof ContextWrapper)) {
                    break;
                }
                context = ((ContextWrapper) context).getBaseContext();
            } else {
                return (AppCompatActivity) context;
            }
        }
        return null;
    }

    public final void Z() {
        AutoNightModeManager autoNightModeManager = this.X;
        if (autoNightModeManager != null) {
            autoNightModeManager.a();
        }
        AutoNightModeManager autoNightModeManager2 = this.Y;
        if (autoNightModeManager2 != null) {
            autoNightModeManager2.a();
        }
    }

    public final void Z0(Configuration configuration) {
        Activity activity = (Activity) this.j;
        if (activity instanceof LifecycleOwner) {
            if (((LifecycleOwner) activity).getLifecycle().b().isAtLeast(Lifecycle.State.CREATED)) {
                activity.onConfigurationChanged(configuration);
            }
        } else if (this.Q && !this.R) {
            activity.onConfigurationChanged(configuration);
        }
    }

    public void a0(int i) {
        b0(s0(i, true), true);
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x0080  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a1(int r9, androidx.core.os.LocaleListCompat r10, boolean r11) {
        /*
            r8 = this;
            android.content.Context r1 = r8.k
            r4 = 0
            r5 = 0
            r0 = r8
            r2 = r9
            r3 = r10
            android.content.res.Configuration r0 = r0.c0(r1, r2, r3, r4, r5)
            android.content.Context r1 = r8.k
            int r1 = r8.o0(r1)
            android.content.res.Configuration r2 = r8.S
            if (r2 != 0) goto L_0x001f
            android.content.Context r2 = r8.k
            android.content.res.Resources r2 = r2.getResources()
            android.content.res.Configuration r2 = r2.getConfiguration()
        L_0x001f:
            int r3 = r2.uiMode
            r3 = r3 & 48
            int r4 = r0.uiMode
            r4 = r4 & 48
            androidx.core.os.LocaleListCompat r2 = r8.r0(r2)
            r5 = 0
            if (r10 != 0) goto L_0x0030
            r0 = r5
            goto L_0x0034
        L_0x0030:
            androidx.core.os.LocaleListCompat r0 = r8.r0(r0)
        L_0x0034:
            r6 = 0
            if (r3 == r4) goto L_0x003a
            r3 = 512(0x200, float:7.175E-43)
            goto L_0x003b
        L_0x003a:
            r3 = r6
        L_0x003b:
            if (r0 == 0) goto L_0x0045
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L_0x0045
            r3 = r3 | 8196(0x2004, float:1.1485E-41)
        L_0x0045:
            int r2 = ~r1
            r2 = r2 & r3
            r7 = 1
            if (r2 == 0) goto L_0x006f
            if (r11 == 0) goto L_0x006f
            boolean r11 = r8.P
            if (r11 == 0) goto L_0x006f
            boolean r11 = s0
            if (r11 != 0) goto L_0x0058
            boolean r11 = r8.Q
            if (r11 == 0) goto L_0x006f
        L_0x0058:
            java.lang.Object r11 = r8.j
            boolean r2 = r11 instanceof android.app.Activity
            if (r2 == 0) goto L_0x006f
            android.app.Activity r11 = (android.app.Activity) r11
            boolean r11 = r11.isChild()
            if (r11 != 0) goto L_0x006f
            java.lang.Object r11 = r8.j
            android.app.Activity r11 = (android.app.Activity) r11
            androidx.core.app.ActivityCompat.d(r11)
            r11 = r7
            goto L_0x0070
        L_0x006f:
            r11 = r6
        L_0x0070:
            if (r11 != 0) goto L_0x007d
            if (r3 == 0) goto L_0x007d
            r11 = r3 & r1
            if (r11 != r3) goto L_0x0079
            r6 = r7
        L_0x0079:
            r8.c1(r4, r0, r6, r5)
            goto L_0x007e
        L_0x007d:
            r7 = r11
        L_0x007e:
            if (r7 == 0) goto L_0x009a
            java.lang.Object r11 = r8.j
            boolean r1 = r11 instanceof androidx.appcompat.app.AppCompatActivity
            if (r1 == 0) goto L_0x009a
            r1 = r3 & 512(0x200, float:7.175E-43)
            if (r1 == 0) goto L_0x008f
            androidx.appcompat.app.AppCompatActivity r11 = (androidx.appcompat.app.AppCompatActivity) r11
            r11.onNightModeChanged(r9)
        L_0x008f:
            r9 = r3 & 4
            if (r9 == 0) goto L_0x009a
            java.lang.Object r9 = r8.j
            androidx.appcompat.app.AppCompatActivity r9 = (androidx.appcompat.app.AppCompatActivity) r9
            r9.onLocalesChanged(r10)
        L_0x009a:
            if (r7 == 0) goto L_0x00af
            if (r0 == 0) goto L_0x00af
            android.content.Context r9 = r8.k
            android.content.res.Resources r9 = r9.getResources()
            android.content.res.Configuration r9 = r9.getConfiguration()
            androidx.core.os.LocaleListCompat r9 = r8.r0(r9)
            r8.S0(r9)
        L_0x00af:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.a1(int, androidx.core.os.LocaleListCompat, boolean):boolean");
    }

    public void b0(PanelFeatureState panelFeatureState, boolean z2) {
        ViewGroup viewGroup;
        DecorContentParent decorContentParent;
        if (!z2 || panelFeatureState.f177a != 0 || (decorContentParent = this.r) == null || !decorContentParent.isOverflowMenuShowing()) {
            WindowManager windowManager = (WindowManager) this.k.getSystemService("window");
            if (!(windowManager == null || !panelFeatureState.o || (viewGroup = panelFeatureState.g) == null)) {
                windowManager.removeView(viewGroup);
                if (z2) {
                    X(panelFeatureState.f177a, panelFeatureState, (Menu) null);
                }
            }
            panelFeatureState.m = false;
            panelFeatureState.n = false;
            panelFeatureState.o = false;
            panelFeatureState.h = null;
            panelFeatureState.q = true;
            if (this.N == panelFeatureState) {
                this.N = null;
            }
            if (panelFeatureState.f177a == 0) {
                b1();
                return;
            }
            return;
        }
        Y(panelFeatureState.j);
    }

    public void b1() {
        OnBackInvokedCallback onBackInvokedCallback;
        if (Build.VERSION.SDK_INT >= 33) {
            boolean V0 = V0();
            if (V0 && this.o0 == null) {
                this.o0 = Api33Impl.b(this.n0, this);
            } else if (!V0 && (onBackInvokedCallback = this.o0) != null) {
                Api33Impl.c(this.n0, onBackInvokedCallback);
            }
        }
    }

    public void c(View view, ViewGroup.LayoutParams layoutParams) {
        j0();
        ((ViewGroup) this.B.findViewById(16908290)).addView(view, layoutParams);
        this.m.b(this.l.getCallback());
    }

    public final Configuration c0(Context context, int i, LocaleListCompat localeListCompat, Configuration configuration, boolean z2) {
        int i2 = i != 1 ? i != 2 ? z2 ? 0 : context.getApplicationContext().getResources().getConfiguration().uiMode & 48 : 32 : 16;
        Configuration configuration2 = new Configuration();
        configuration2.fontScale = 0.0f;
        if (configuration != null) {
            configuration2.setTo(configuration);
        }
        configuration2.uiMode = i2 | (configuration2.uiMode & -49);
        if (localeListCompat != null) {
            R0(configuration2, localeListCompat);
        }
        return configuration2;
    }

    public final void c1(int i, LocaleListCompat localeListCompat, boolean z2, Configuration configuration) {
        Resources resources = this.k.getResources();
        Configuration configuration2 = new Configuration(resources.getConfiguration());
        if (configuration != null) {
            configuration2.updateFrom(configuration);
        }
        configuration2.uiMode = i | (resources.getConfiguration().uiMode & -49);
        if (localeListCompat != null) {
            R0(configuration2, localeListCompat);
        }
        resources.updateConfiguration(configuration2, (DisplayMetrics) null);
        int i2 = this.U;
        if (i2 != 0) {
            this.k.setTheme(i2);
            this.k.getTheme().applyStyle(this.U, true);
        }
        if (z2 && (this.j instanceof Activity)) {
            Z0(configuration2);
        }
    }

    public final ViewGroup d0() {
        ViewGroup viewGroup;
        TypedArray obtainStyledAttributes = this.k.obtainStyledAttributes(R.styleable.AppCompatTheme);
        if (obtainStyledAttributes.hasValue(R.styleable.AppCompatTheme_windowActionBar)) {
            if (obtainStyledAttributes.getBoolean(R.styleable.AppCompatTheme_windowNoTitle, false)) {
                F(1);
            } else if (obtainStyledAttributes.getBoolean(R.styleable.AppCompatTheme_windowActionBar, false)) {
                F(108);
            }
            if (obtainStyledAttributes.getBoolean(R.styleable.AppCompatTheme_windowActionBarOverlay, false)) {
                F(109);
            }
            if (obtainStyledAttributes.getBoolean(R.styleable.AppCompatTheme_windowActionModeOverlay, false)) {
                F(10);
            }
            this.J = obtainStyledAttributes.getBoolean(R.styleable.AppCompatTheme_android_windowIsFloating, false);
            obtainStyledAttributes.recycle();
            k0();
            this.l.getDecorView();
            LayoutInflater from = LayoutInflater.from(this.k);
            if (this.K) {
                viewGroup = this.I ? (ViewGroup) from.inflate(R.layout.abc_screen_simple_overlay_action_mode, (ViewGroup) null) : (ViewGroup) from.inflate(R.layout.abc_screen_simple, (ViewGroup) null);
            } else if (this.J) {
                viewGroup = (ViewGroup) from.inflate(R.layout.abc_dialog_title_material, (ViewGroup) null);
                this.H = false;
                this.G = false;
            } else if (this.G) {
                TypedValue typedValue = new TypedValue();
                this.k.getTheme().resolveAttribute(R.attr.actionBarTheme, typedValue, true);
                viewGroup = (ViewGroup) LayoutInflater.from(typedValue.resourceId != 0 ? new androidx.appcompat.view.ContextThemeWrapper(this.k, typedValue.resourceId) : this.k).inflate(R.layout.abc_screen_toolbar, (ViewGroup) null);
                DecorContentParent decorContentParent = (DecorContentParent) viewGroup.findViewById(R.id.decor_content_parent);
                this.r = decorContentParent;
                decorContentParent.setWindowCallback(u0());
                if (this.H) {
                    this.r.initFeature(109);
                }
                if (this.E) {
                    this.r.initFeature(2);
                }
                if (this.F) {
                    this.r.initFeature(5);
                }
            } else {
                viewGroup = null;
            }
            if (viewGroup != null) {
                ViewCompat.M0(viewGroup, new OnApplyWindowInsetsListener() {
                    public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                        int l = windowInsetsCompat.l();
                        int d1 = AppCompatDelegateImpl.this.d1(windowInsetsCompat, (Rect) null);
                        if (l != d1) {
                            windowInsetsCompat = windowInsetsCompat.r(windowInsetsCompat.j(), d1, windowInsetsCompat.k(), windowInsetsCompat.i());
                        }
                        return ViewCompat.f0(view, windowInsetsCompat);
                    }
                });
                if (this.r == null) {
                    this.C = (TextView) viewGroup.findViewById(R.id.title);
                }
                androidx.appcompat.widget.ViewUtils.c(viewGroup);
                ContentFrameLayout contentFrameLayout = (ContentFrameLayout) viewGroup.findViewById(R.id.action_bar_activity_content);
                ViewGroup viewGroup2 = (ViewGroup) this.l.findViewById(16908290);
                if (viewGroup2 != null) {
                    while (viewGroup2.getChildCount() > 0) {
                        View childAt = viewGroup2.getChildAt(0);
                        viewGroup2.removeViewAt(0);
                        contentFrameLayout.addView(childAt);
                    }
                    viewGroup2.setId(-1);
                    contentFrameLayout.setId(16908290);
                    if (viewGroup2 instanceof FrameLayout) {
                        ((FrameLayout) viewGroup2).setForeground((Drawable) null);
                    }
                }
                this.l.setContentView(viewGroup);
                contentFrameLayout.setAttachListener(new ContentFrameLayout.OnAttachListener() {
                    public void onAttachedFromWindow() {
                    }

                    public void onDetachedFromWindow() {
                        AppCompatDelegateImpl.this.f0();
                    }
                });
                return viewGroup;
            }
            throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.G + ", windowActionBarOverlay: " + this.H + ", android:windowIsFloating: " + this.J + ", windowActionModeOverlay: " + this.I + ", windowNoTitle: " + this.K + " }");
        }
        obtainStyledAttributes.recycle();
        throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
    }

    public final int d1(WindowInsetsCompat windowInsetsCompat, Rect rect) {
        boolean z2;
        boolean z3;
        ViewGroup.MarginLayoutParams marginLayoutParams;
        int i;
        int i2 = 0;
        int l2 = windowInsetsCompat != null ? windowInsetsCompat.l() : rect != null ? rect.top : 0;
        ActionBarContextView actionBarContextView = this.v;
        if (actionBarContextView == null || !(actionBarContextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            z2 = false;
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.v.getLayoutParams();
            boolean z4 = true;
            if (this.v.isShown()) {
                if (this.j0 == null) {
                    this.j0 = new Rect();
                    this.k0 = new Rect();
                }
                Rect rect2 = this.j0;
                Rect rect3 = this.k0;
                if (windowInsetsCompat == null) {
                    rect2.set(rect);
                } else {
                    rect2.set(windowInsetsCompat.j(), windowInsetsCompat.l(), windowInsetsCompat.k(), windowInsetsCompat.i());
                }
                androidx.appcompat.widget.ViewUtils.a(this.B, rect2, rect3);
                int i3 = rect2.top;
                int i4 = rect2.left;
                int i5 = rect2.right;
                WindowInsetsCompat H2 = ViewCompat.H(this.B);
                int j2 = H2 == null ? 0 : H2.j();
                int k2 = H2 == null ? 0 : H2.k();
                if (marginLayoutParams2.topMargin == i3 && marginLayoutParams2.leftMargin == i4 && marginLayoutParams2.rightMargin == i5) {
                    z3 = false;
                } else {
                    marginLayoutParams2.topMargin = i3;
                    marginLayoutParams2.leftMargin = i4;
                    marginLayoutParams2.rightMargin = i5;
                    z3 = true;
                }
                if (i3 <= 0 || this.D != null) {
                    View view = this.D;
                    if (!(view == null || ((marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams()).height == (i = marginLayoutParams2.topMargin) && marginLayoutParams.leftMargin == j2 && marginLayoutParams.rightMargin == k2))) {
                        marginLayoutParams.height = i;
                        marginLayoutParams.leftMargin = j2;
                        marginLayoutParams.rightMargin = k2;
                        this.D.setLayoutParams(marginLayoutParams);
                    }
                } else {
                    View view2 = new View(this.k);
                    this.D = view2;
                    view2.setVisibility(8);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, marginLayoutParams2.topMargin, 51);
                    layoutParams.leftMargin = j2;
                    layoutParams.rightMargin = k2;
                    this.B.addView(this.D, -1, layoutParams);
                }
                View view3 = this.D;
                if (view3 == null) {
                    z4 = false;
                }
                if (z4 && view3.getVisibility() != 0) {
                    e1(this.D);
                }
                if (!this.I && z4) {
                    l2 = 0;
                }
                z2 = z4;
                z4 = z3;
            } else if (marginLayoutParams2.topMargin != 0) {
                marginLayoutParams2.topMargin = 0;
                z2 = false;
            } else {
                z2 = false;
                z4 = false;
            }
            if (z4) {
                this.v.setLayoutParams(marginLayoutParams2);
            }
        }
        View view4 = this.D;
        if (view4 != null) {
            if (!z2) {
                i2 = 8;
            }
            view4.setVisibility(i2);
        }
        return l2;
    }

    public Context e(Context context) {
        this.P = true;
        int B0 = B0(context, W());
        if (AppCompatDelegate.t(context)) {
            AppCompatDelegate.P(context);
        }
        LocaleListCompat V2 = V(context);
        if (t0 && (context instanceof ContextThemeWrapper)) {
            try {
                ContextThemeWrapperCompatApi17Impl.a((ContextThemeWrapper) context, c0(context, B0, V2, (Configuration) null, false));
                return context;
            } catch (IllegalStateException unused) {
            }
        }
        if (context instanceof androidx.appcompat.view.ContextThemeWrapper) {
            try {
                ((androidx.appcompat.view.ContextThemeWrapper) context).a(c0(context, B0, V2, (Configuration) null, false));
                return context;
            } catch (IllegalStateException unused2) {
            }
        }
        if (!s0) {
            return super.e(context);
        }
        Configuration configuration = new Configuration();
        configuration.uiMode = -1;
        configuration.fontScale = 0.0f;
        Configuration configuration2 = Api17Impl.a(context, configuration).getResources().getConfiguration();
        Configuration configuration3 = context.getResources().getConfiguration();
        configuration2.uiMode = configuration3.uiMode;
        Configuration c0 = c0(context, B0, V2, !configuration2.equals(configuration3) ? m0(configuration2, configuration3) : null, true);
        androidx.appcompat.view.ContextThemeWrapper contextThemeWrapper = new androidx.appcompat.view.ContextThemeWrapper(context, R.style.Theme_AppCompat_Empty);
        contextThemeWrapper.a(c0);
        try {
            if (context.getTheme() != null) {
                ResourcesCompat.ThemeCompat.a(contextThemeWrapper.getTheme());
            }
        } catch (NullPointerException unused3) {
        }
        return super.e(contextThemeWrapper);
    }

    public View e0(View view, String str, Context context, AttributeSet attributeSet) {
        boolean z2;
        if (this.l0 == null) {
            String string = this.k.obtainStyledAttributes(R.styleable.AppCompatTheme).getString(R.styleable.AppCompatTheme_viewInflaterClass);
            if (string == null) {
                this.l0 = new AppCompatViewInflater();
            } else {
                try {
                    this.l0 = (AppCompatViewInflater) this.k.getClassLoader().loadClass(string).getDeclaredConstructor((Class[]) null).newInstance((Object[]) null);
                } catch (Throwable th) {
                    Log.i("AppCompatDelegate", "Failed to instantiate custom view inflater " + string + ". Falling back to default.", th);
                    this.l0 = new AppCompatViewInflater();
                }
            }
        }
        boolean z3 = q0;
        boolean z4 = false;
        if (z3) {
            if (this.m0 == null) {
                this.m0 = new LayoutIncludeDetector();
            }
            if (this.m0.a(attributeSet)) {
                z2 = true;
                return this.l0.createView(view, str, context, attributeSet, z2, z3, true, VectorEnabledTintResources.d());
            } else if (!(attributeSet instanceof XmlPullParser)) {
                z4 = U0((ViewParent) view);
            } else if (((XmlPullParser) attributeSet).getDepth() > 1) {
                z4 = true;
            }
        }
        z2 = z4;
        return this.l0.createView(view, str, context, attributeSet, z2, z3, true, VectorEnabledTintResources.d());
    }

    public final void e1(View view) {
        view.setBackgroundColor((ViewCompat.O(view) & 8192) != 0 ? ContextCompat.getColor(this.k, R.color.abc_decor_view_status_guard_light) : ContextCompat.getColor(this.k, R.color.abc_decor_view_status_guard));
    }

    public void f0() {
        MenuBuilder menuBuilder;
        DecorContentParent decorContentParent = this.r;
        if (decorContentParent != null) {
            decorContentParent.dismissPopups();
        }
        if (this.w != null) {
            this.l.getDecorView().removeCallbacks(this.x);
            if (this.w.isShowing()) {
                try {
                    this.w.dismiss();
                } catch (IllegalArgumentException unused) {
                }
            }
            this.w = null;
        }
        i0();
        PanelFeatureState s02 = s0(0, false);
        if (s02 != null && (menuBuilder = s02.j) != null) {
            menuBuilder.close();
        }
    }

    public boolean g0(KeyEvent keyEvent) {
        View decorView;
        Object obj = this.j;
        if (((obj instanceof KeyEventDispatcher.Component) || (obj instanceof AppCompatDialog)) && (decorView = this.l.getDecorView()) != null && KeyEventDispatcher.a(decorView, keyEvent)) {
            return true;
        }
        if (keyEvent.getKeyCode() == 82 && this.m.a(this.l.getCallback(), keyEvent)) {
            return true;
        }
        int keyCode = keyEvent.getKeyCode();
        return keyEvent.getAction() == 0 ? D0(keyCode, keyEvent) : G0(keyCode, keyEvent);
    }

    public View h(int i) {
        j0();
        return this.l.findViewById(i);
    }

    public void h0(int i) {
        PanelFeatureState s02;
        PanelFeatureState s03 = s0(i, true);
        if (s03.j != null) {
            Bundle bundle = new Bundle();
            s03.j.saveActionViewStates(bundle);
            if (bundle.size() > 0) {
                s03.s = bundle;
            }
            s03.j.stopDispatchingItemsChanged();
            s03.j.clear();
        }
        s03.r = true;
        s03.q = true;
        if ((i == 108 || i == 0) && this.r != null && (s02 = s0(0, false)) != null) {
            s02.m = false;
            O0(s02, (KeyEvent) null);
        }
    }

    public void i0() {
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = this.y;
        if (viewPropertyAnimatorCompat != null) {
            viewPropertyAnimatorCompat.c();
        }
    }

    public Context j() {
        return this.k;
    }

    public final void j0() {
        if (!this.A) {
            this.B = d0();
            CharSequence t02 = t0();
            if (!TextUtils.isEmpty(t02)) {
                DecorContentParent decorContentParent = this.r;
                if (decorContentParent != null) {
                    decorContentParent.setWindowTitle(t02);
                } else if (M0() != null) {
                    M0().y(t02);
                } else {
                    TextView textView = this.C;
                    if (textView != null) {
                        textView.setText(t02);
                    }
                }
            }
            T();
            K0(this.B);
            this.A = true;
            PanelFeatureState s02 = s0(0, false);
            if (this.R) {
                return;
            }
            if (s02 == null || s02.j == null) {
                z0(108);
            }
        }
    }

    public final void k0() {
        if (this.l == null) {
            Object obj = this.j;
            if (obj instanceof Activity) {
                U(((Activity) obj).getWindow());
            }
        }
        if (this.l == null) {
            throw new IllegalStateException("We have not been given a Window");
        }
    }

    public final ActionBarDrawerToggle.Delegate l() {
        return new ActionBarDrawableToggleImpl();
    }

    public PanelFeatureState l0(Menu menu) {
        PanelFeatureState[] panelFeatureStateArr = this.M;
        int length = panelFeatureStateArr != null ? panelFeatureStateArr.length : 0;
        for (int i = 0; i < length; i++) {
            PanelFeatureState panelFeatureState = panelFeatureStateArr[i];
            if (panelFeatureState != null && panelFeatureState.j == menu) {
                return panelFeatureState;
            }
        }
        return null;
    }

    public int m() {
        return this.T;
    }

    public final Context n0() {
        ActionBar q2 = q();
        Context e = q2 != null ? q2.e() : null;
        return e == null ? this.k : e;
    }

    public MenuInflater o() {
        if (this.p == null) {
            v0();
            ActionBar actionBar = this.o;
            this.p = new SupportMenuInflater(actionBar != null ? actionBar.e() : this.k);
        }
        return this.p;
    }

    public final int o0(Context context) {
        if (!this.W && (this.j instanceof Activity)) {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                return 0;
            }
            try {
                ActivityInfo activityInfo = packageManager.getActivityInfo(new ComponentName(context, this.j.getClass()), 269221888);
                if (activityInfo != null) {
                    this.V = activityInfo.configChanges;
                }
            } catch (PackageManager.NameNotFoundException e) {
                Log.d("AppCompatDelegate", "Exception while getting ActivityInfo", e);
                this.V = 0;
            }
        }
        this.W = true;
        return this.V;
    }

    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return e0(view, str, context, attributeSet);
    }

    public boolean onMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem) {
        PanelFeatureState l02;
        Window.Callback u0 = u0();
        if (u0 == null || this.R || (l02 = l0(menuBuilder.getRootMenu())) == null) {
            return false;
        }
        return u0.onMenuItemSelected(l02.f177a, menuItem);
    }

    public void onMenuModeChange(MenuBuilder menuBuilder) {
        P0(true);
    }

    public final AutoNightModeManager p0(Context context) {
        if (this.Y == null) {
            this.Y = new AutoBatteryNightModeManager(context);
        }
        return this.Y;
    }

    public ActionBar q() {
        v0();
        return this.o;
    }

    public final AutoNightModeManager q0(Context context) {
        if (this.X == null) {
            this.X = new AutoTimeNightModeManager(TwilightManager.a(context));
        }
        return this.X;
    }

    public void r() {
        LayoutInflater from = LayoutInflater.from(this.k);
        if (from.getFactory() == null) {
            LayoutInflaterCompat.a(from, this);
        } else if (!(from.getFactory2() instanceof AppCompatDelegateImpl)) {
            Log.i("AppCompatDelegate", "The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's");
        }
    }

    public LocaleListCompat r0(Configuration configuration) {
        return Api24Impl.b(configuration);
    }

    public void s() {
        if (M0() != null && !q().h()) {
            z0(0);
        }
    }

    public PanelFeatureState s0(int i, boolean z2) {
        PanelFeatureState[] panelFeatureStateArr = this.M;
        if (panelFeatureStateArr == null || panelFeatureStateArr.length <= i) {
            PanelFeatureState[] panelFeatureStateArr2 = new PanelFeatureState[(i + 1)];
            if (panelFeatureStateArr != null) {
                System.arraycopy(panelFeatureStateArr, 0, panelFeatureStateArr2, 0, panelFeatureStateArr.length);
            }
            this.M = panelFeatureStateArr2;
            panelFeatureStateArr = panelFeatureStateArr2;
        }
        PanelFeatureState panelFeatureState = panelFeatureStateArr[i];
        if (panelFeatureState != null) {
            return panelFeatureState;
        }
        PanelFeatureState panelFeatureState2 = new PanelFeatureState(i);
        panelFeatureStateArr[i] = panelFeatureState2;
        return panelFeatureState2;
    }

    public final CharSequence t0() {
        Object obj = this.j;
        return obj instanceof Activity ? ((Activity) obj).getTitle() : this.q;
    }

    public final Window.Callback u0() {
        return this.l.getCallback();
    }

    public void v(Configuration configuration) {
        ActionBar q2;
        if (this.G && this.A && (q2 = q()) != null) {
            q2.i(configuration);
        }
        AppCompatDrawableManager.b().g(this.k);
        this.S = new Configuration(this.k.getResources().getConfiguration());
        R(false, false);
    }

    public final void v0() {
        j0();
        if (this.G && this.o == null) {
            Object obj = this.j;
            if (obj instanceof Activity) {
                this.o = new WindowDecorActionBar((Activity) this.j, this.H);
            } else if (obj instanceof Dialog) {
                this.o = new WindowDecorActionBar((Dialog) this.j);
            }
            ActionBar actionBar = this.o;
            if (actionBar != null) {
                actionBar.o(this.i0);
            }
        }
    }

    public void w(Bundle bundle) {
        String str;
        this.P = true;
        Q(false);
        k0();
        Object obj = this.j;
        if (obj instanceof Activity) {
            try {
                str = NavUtils.c((Activity) obj);
            } catch (IllegalArgumentException unused) {
                str = null;
            }
            if (str != null) {
                ActionBar M0 = M0();
                if (M0 == null) {
                    this.i0 = true;
                } else {
                    M0.o(true);
                }
            }
            AppCompatDelegate.b(this);
        }
        this.S = new Configuration(this.k.getResources().getConfiguration());
        this.Q = true;
    }

    public final boolean w0(PanelFeatureState panelFeatureState) {
        View view = panelFeatureState.i;
        if (view != null) {
            panelFeatureState.h = view;
            return true;
        } else if (panelFeatureState.j == null) {
            return false;
        } else {
            if (this.t == null) {
                this.t = new PanelMenuPresenterCallback();
            }
            View view2 = (View) panelFeatureState.a(this.t);
            panelFeatureState.h = view2;
            return view2 != null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0058  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void x() {
        /*
            r3 = this;
            java.lang.Object r0 = r3.j
            boolean r0 = r0 instanceof android.app.Activity
            if (r0 == 0) goto L_0x0009
            androidx.appcompat.app.AppCompatDelegate.D(r3)
        L_0x0009:
            boolean r0 = r3.Z
            if (r0 == 0) goto L_0x0018
            android.view.Window r0 = r3.l
            android.view.View r0 = r0.getDecorView()
            java.lang.Runnable r1 = r3.h0
            r0.removeCallbacks(r1)
        L_0x0018:
            r0 = 1
            r3.R = r0
            int r0 = r3.T
            r1 = -100
            if (r0 == r1) goto L_0x0045
            java.lang.Object r0 = r3.j
            boolean r1 = r0 instanceof android.app.Activity
            if (r1 == 0) goto L_0x0045
            android.app.Activity r0 = (android.app.Activity) r0
            boolean r0 = r0.isChangingConfigurations()
            if (r0 == 0) goto L_0x0045
            androidx.collection.SimpleArrayMap r0 = p0
            java.lang.Object r1 = r3.j
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = r1.getName()
            int r2 = r3.T
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r0.put(r1, r2)
            goto L_0x0054
        L_0x0045:
            androidx.collection.SimpleArrayMap r0 = p0
            java.lang.Object r1 = r3.j
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = r1.getName()
            r0.remove(r1)
        L_0x0054:
            androidx.appcompat.app.ActionBar r0 = r3.o
            if (r0 == 0) goto L_0x005b
            r0.j()
        L_0x005b:
            r3.Z()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.x():void");
    }

    public final boolean x0(PanelFeatureState panelFeatureState) {
        panelFeatureState.d(n0());
        panelFeatureState.g = new ListMenuDecorView(panelFeatureState.l);
        panelFeatureState.c = 81;
        return true;
    }

    public void y(Bundle bundle) {
        j0();
    }

    public final boolean y0(PanelFeatureState panelFeatureState) {
        Resources.Theme theme;
        Context context = this.k;
        int i = panelFeatureState.f177a;
        if ((i == 0 || i == 108) && this.r != null) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme theme2 = context.getTheme();
            theme2.resolveAttribute(R.attr.actionBarTheme, typedValue, true);
            if (typedValue.resourceId != 0) {
                theme = context.getResources().newTheme();
                theme.setTo(theme2);
                theme.applyStyle(typedValue.resourceId, true);
                theme.resolveAttribute(R.attr.actionBarWidgetTheme, typedValue, true);
            } else {
                theme2.resolveAttribute(R.attr.actionBarWidgetTheme, typedValue, true);
                theme = null;
            }
            if (typedValue.resourceId != 0) {
                if (theme == null) {
                    theme = context.getResources().newTheme();
                    theme.setTo(theme2);
                }
                theme.applyStyle(typedValue.resourceId, true);
            }
            if (theme != null) {
                androidx.appcompat.view.ContextThemeWrapper contextThemeWrapper = new androidx.appcompat.view.ContextThemeWrapper(context, 0);
                contextThemeWrapper.getTheme().setTo(theme);
                context = contextThemeWrapper;
            }
        }
        MenuBuilder menuBuilder = new MenuBuilder(context);
        menuBuilder.setCallback(this);
        panelFeatureState.c(menuBuilder);
        return true;
    }

    public void z() {
        ActionBar q2 = q();
        if (q2 != null) {
            q2.w(true);
        }
    }

    public final void z0(int i) {
        this.g0 = (1 << i) | this.g0;
        if (!this.Z) {
            ViewCompat.l0(this.l.getDecorView(), this.h0);
            this.Z = true;
        }
    }

    public AppCompatDelegateImpl(Dialog dialog, AppCompatCallback appCompatCallback) {
        this(dialog.getContext(), dialog.getWindow(), appCompatCallback, dialog);
    }

    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView((View) null, str, context, attributeSet);
    }

    public AppCompatDelegateImpl(Context context, Window window, AppCompatCallback appCompatCallback, Object obj) {
        AppCompatActivity Y0;
        this.y = null;
        this.z = true;
        this.T = -100;
        this.h0 = new Runnable() {
            public void run() {
                AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
                if ((appCompatDelegateImpl.g0 & 1) != 0) {
                    appCompatDelegateImpl.h0(0);
                }
                AppCompatDelegateImpl appCompatDelegateImpl2 = AppCompatDelegateImpl.this;
                if ((appCompatDelegateImpl2.g0 & 4096) != 0) {
                    appCompatDelegateImpl2.h0(108);
                }
                AppCompatDelegateImpl appCompatDelegateImpl3 = AppCompatDelegateImpl.this;
                appCompatDelegateImpl3.Z = false;
                appCompatDelegateImpl3.g0 = 0;
            }
        };
        this.k = context;
        this.n = appCompatCallback;
        this.j = obj;
        if (this.T == -100 && (obj instanceof Dialog) && (Y0 = Y0()) != null) {
            this.T = Y0.getDelegate().m();
        }
        if (this.T == -100) {
            SimpleArrayMap simpleArrayMap = p0;
            Integer num = (Integer) simpleArrayMap.get(obj.getClass().getName());
            if (num != null) {
                this.T = num.intValue();
                simpleArrayMap.remove(obj.getClass().getName());
            }
        }
        if (window != null) {
            U(window);
        }
        AppCompatDrawableManager.h();
    }
}
