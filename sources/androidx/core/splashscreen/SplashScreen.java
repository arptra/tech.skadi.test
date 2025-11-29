package androidx.core.splashscreen;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowInsets;
import android.window.SplashScreenView;
import androidx.annotation.RequiresApi;
import com.honey.account.o.a;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u0000 \u000b2\u00020\u0001:\u0005\u0011\u0012\u0013\u0014\u0015B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0016"}, d2 = {"Landroidx/core/splashscreen/SplashScreen;", "", "Landroid/app/Activity;", "activity", "<init>", "(Landroid/app/Activity;)V", "Landroidx/core/splashscreen/SplashScreen$KeepOnScreenCondition;", "condition", "", "c", "(Landroidx/core/splashscreen/SplashScreen$KeepOnScreenCondition;)V", "b", "()V", "Landroidx/core/splashscreen/SplashScreen$Impl;", "a", "Landroidx/core/splashscreen/SplashScreen$Impl;", "impl", "Companion", "Impl", "Impl31", "KeepOnScreenCondition", "OnExitAnimationListener", "core-splashscreen_release"}, k = 1, mv = {1, 6, 0})
@SuppressLint({"CustomSplashScreen"})
public final class SplashScreen {
    public static final Companion b = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public final Impl f809a;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\u00020\u0005*\u00020\u0004H\u0007¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002XT¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Landroidx/core/splashscreen/SplashScreen$Companion;", "", "<init>", "()V", "Landroid/app/Activity;", "Landroidx/core/splashscreen/SplashScreen;", "a", "(Landroid/app/Activity;)Landroidx/core/splashscreen/SplashScreen;", "", "MASK_FACTOR", "F", "core-splashscreen_release"}, k = 1, mv = {1, 6, 0})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SplashScreen a(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "<this>");
            SplashScreen splashScreen = new SplashScreen(activity, (DefaultConstructorMarker) null);
            splashScreen.b();
            return splashScreen;
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0012\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ#\u0010\u000e\u001a\u00020\u00062\n\u0010\u000b\u001a\u00060\tR\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0004¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\"\u0010#\u001a\u00020\u001c8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R$\u0010*\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R$\u0010.\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b+\u0010%\u001a\u0004\b,\u0010'\"\u0004\b-\u0010)R$\u00105\u001a\u0004\u0018\u00010/8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0016\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\"\u0010=\u001a\u0002068\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\"\u0010B\u001a\u00020\u00108\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010>\u001a\u0004\b?\u0010@\"\u0004\bA\u0010\u0013R\u0018\u0010E\u001a\u0004\u0018\u00010C8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b?\u0010DR\u0018\u0010G\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010F¨\u0006H"}, d2 = {"Landroidx/core/splashscreen/SplashScreen$Impl;", "", "Landroid/app/Activity;", "activity", "<init>", "(Landroid/app/Activity;)V", "", "i", "()V", "Landroid/content/res/Resources$Theme;", "Landroid/content/res/Resources;", "currentTheme", "Landroid/util/TypedValue;", "typedValue", "k", "(Landroid/content/res/Resources$Theme;Landroid/util/TypedValue;)V", "Landroidx/core/splashscreen/SplashScreen$KeepOnScreenCondition;", "keepOnScreenCondition", "j", "(Landroidx/core/splashscreen/SplashScreen$KeepOnScreenCondition;)V", "Landroidx/core/splashscreen/SplashScreenViewProvider;", "splashScreenViewProvider", "e", "(Landroidx/core/splashscreen/SplashScreenViewProvider;)V", "a", "Landroid/app/Activity;", "g", "()Landroid/app/Activity;", "", "b", "I", "getFinalThemeId", "()I", "setFinalThemeId", "(I)V", "finalThemeId", "c", "Ljava/lang/Integer;", "getBackgroundResId", "()Ljava/lang/Integer;", "setBackgroundResId", "(Ljava/lang/Integer;)V", "backgroundResId", "d", "getBackgroundColor", "setBackgroundColor", "backgroundColor", "Landroid/graphics/drawable/Drawable;", "Landroid/graphics/drawable/Drawable;", "getIcon", "()Landroid/graphics/drawable/Drawable;", "setIcon", "(Landroid/graphics/drawable/Drawable;)V", "icon", "", "f", "Z", "getHasBackground", "()Z", "setHasBackground", "(Z)V", "hasBackground", "Landroidx/core/splashscreen/SplashScreen$KeepOnScreenCondition;", "h", "()Landroidx/core/splashscreen/SplashScreen$KeepOnScreenCondition;", "l", "splashScreenWaitPredicate", "Landroidx/core/splashscreen/SplashScreen$OnExitAnimationListener;", "Landroidx/core/splashscreen/SplashScreen$OnExitAnimationListener;", "animationListener", "Landroidx/core/splashscreen/SplashScreenViewProvider;", "mSplashScreenViewProvider", "core-splashscreen_release"}, k = 1, mv = {1, 6, 0})
    public static class Impl {

        /* renamed from: a  reason: collision with root package name */
        public final Activity f810a;
        public int b;
        public Integer c;
        public Integer d;
        public Drawable e;
        public boolean f;
        public KeepOnScreenCondition g = new b();
        public OnExitAnimationListener h;
        public SplashScreenViewProvider i;

        public Impl(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            this.f810a = activity;
        }

        public static final void f(SplashScreenViewProvider splashScreenViewProvider, OnExitAnimationListener onExitAnimationListener) {
            Intrinsics.checkNotNullParameter(splashScreenViewProvider, "$splashScreenViewProvider");
            Intrinsics.checkNotNullParameter(onExitAnimationListener, "$finalListener");
            splashScreenViewProvider.a().bringToFront();
            onExitAnimationListener.a(splashScreenViewProvider);
        }

        public static final boolean m() {
            return false;
        }

        public final void e(SplashScreenViewProvider splashScreenViewProvider) {
            Intrinsics.checkNotNullParameter(splashScreenViewProvider, "splashScreenViewProvider");
            OnExitAnimationListener onExitAnimationListener = this.h;
            if (onExitAnimationListener != null) {
                this.h = null;
                splashScreenViewProvider.a().postOnAnimation(new a(splashScreenViewProvider, onExitAnimationListener));
            }
        }

        public final Activity g() {
            return this.f810a;
        }

        public final KeepOnScreenCondition h() {
            return this.g;
        }

        public void i() {
            TypedValue typedValue = new TypedValue();
            Resources.Theme theme = this.f810a.getTheme();
            boolean z = true;
            if (theme.resolveAttribute(R.attr.windowSplashScreenBackground, typedValue, true)) {
                this.c = Integer.valueOf(typedValue.resourceId);
                this.d = Integer.valueOf(typedValue.data);
            }
            if (theme.resolveAttribute(R.attr.windowSplashScreenAnimatedIcon, typedValue, true)) {
                this.e = theme.getDrawable(typedValue.resourceId);
            }
            if (theme.resolveAttribute(R.attr.splashScreenIconSize, typedValue, true)) {
                if (typedValue.resourceId != R.dimen.splashscreen_icon_size_with_background) {
                    z = false;
                }
                this.f = z;
            }
            Intrinsics.checkNotNullExpressionValue(theme, "currentTheme");
            k(theme, typedValue);
        }

        public void j(KeepOnScreenCondition keepOnScreenCondition) {
            Intrinsics.checkNotNullParameter(keepOnScreenCondition, "keepOnScreenCondition");
            this.g = keepOnScreenCondition;
            View findViewById = this.f810a.findViewById(16908290);
            findViewById.getViewTreeObserver().addOnPreDrawListener(new SplashScreen$Impl$setKeepOnScreenCondition$1(this, findViewById));
        }

        public final void k(Resources.Theme theme, TypedValue typedValue) {
            Intrinsics.checkNotNullParameter(theme, "currentTheme");
            Intrinsics.checkNotNullParameter(typedValue, "typedValue");
            if (theme.resolveAttribute(R.attr.postSplashScreenTheme, typedValue, true)) {
                int i2 = typedValue.resourceId;
                this.b = i2;
                if (i2 != 0) {
                    this.f810a.setTheme(i2);
                }
            }
        }

        public final void l(KeepOnScreenCondition keepOnScreenCondition) {
            Intrinsics.checkNotNullParameter(keepOnScreenCondition, "<set-?>");
            this.g = keepOnScreenCondition;
        }
    }

    @RequiresApi
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R$\u0010\u0018\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u001f\u001a\u00020\b8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0017\u0010%\u001a\u00020 8\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$¨\u0006&"}, d2 = {"Landroidx/core/splashscreen/SplashScreen$Impl31;", "Landroidx/core/splashscreen/SplashScreen$Impl;", "Landroid/app/Activity;", "activity", "<init>", "(Landroid/app/Activity;)V", "Landroid/window/SplashScreenView;", "child", "", "n", "(Landroid/window/SplashScreenView;)Z", "", "i", "()V", "Landroidx/core/splashscreen/SplashScreen$KeepOnScreenCondition;", "keepOnScreenCondition", "j", "(Landroidx/core/splashscreen/SplashScreen$KeepOnScreenCondition;)V", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "getPreDrawListener", "()Landroid/view/ViewTreeObserver$OnPreDrawListener;", "setPreDrawListener", "(Landroid/view/ViewTreeObserver$OnPreDrawListener;)V", "preDrawListener", "k", "Z", "getMDecorFitWindowInsets", "()Z", "o", "(Z)V", "mDecorFitWindowInsets", "Landroid/view/ViewGroup$OnHierarchyChangeListener;", "l", "Landroid/view/ViewGroup$OnHierarchyChangeListener;", "getHierarchyListener", "()Landroid/view/ViewGroup$OnHierarchyChangeListener;", "hierarchyListener", "core-splashscreen_release"}, k = 1, mv = {1, 6, 0})
    public static final class Impl31 extends Impl {
        public ViewTreeObserver.OnPreDrawListener j;
        public boolean k = true;
        public final ViewGroup.OnHierarchyChangeListener l;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Impl31(Activity activity) {
            super(activity);
            Intrinsics.checkNotNullParameter(activity, "activity");
            this.l = new SplashScreen$Impl31$hierarchyListener$1(this, activity);
        }

        public void i() {
            Resources.Theme theme = g().getTheme();
            Intrinsics.checkNotNullExpressionValue(theme, "activity.theme");
            k(theme, new TypedValue());
            ((ViewGroup) g().getWindow().getDecorView()).setOnHierarchyChangeListener(this.l);
        }

        public void j(KeepOnScreenCondition keepOnScreenCondition) {
            Intrinsics.checkNotNullParameter(keepOnScreenCondition, "keepOnScreenCondition");
            l(keepOnScreenCondition);
            View findViewById = g().findViewById(16908290);
            ViewTreeObserver viewTreeObserver = findViewById.getViewTreeObserver();
            if (this.j != null && viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnPreDrawListener(this.j);
            }
            SplashScreen$Impl31$setKeepOnScreenCondition$1 splashScreen$Impl31$setKeepOnScreenCondition$1 = new SplashScreen$Impl31$setKeepOnScreenCondition$1(this, findViewById);
            this.j = splashScreen$Impl31$setKeepOnScreenCondition$1;
            viewTreeObserver.addOnPreDrawListener(splashScreen$Impl31$setKeepOnScreenCondition$1);
        }

        public final boolean n(SplashScreenView splashScreenView) {
            Intrinsics.checkNotNullParameter(splashScreenView, "child");
            WindowInsets build = new WindowInsets.Builder().build();
            Intrinsics.checkNotNullExpressionValue(build, "Builder().build()");
            Rect rect = new Rect(Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE);
            return build != a.a(splashScreenView).computeSystemWindowInsets(build, rect) || !rect.isEmpty();
        }

        public final void o(boolean z) {
            this.k = z;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bæ\u0001\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Landroidx/core/splashscreen/SplashScreen$KeepOnScreenCondition;", "", "", "a", "()Z", "core-splashscreen_release"}, k = 1, mv = {1, 6, 0})
    public interface KeepOnScreenCondition {
        boolean a();
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bæ\u0001\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroidx/core/splashscreen/SplashScreen$OnExitAnimationListener;", "", "Landroidx/core/splashscreen/SplashScreenViewProvider;", "splashScreenViewProvider", "", "a", "(Landroidx/core/splashscreen/SplashScreenViewProvider;)V", "core-splashscreen_release"}, k = 1, mv = {1, 6, 0})
    public interface OnExitAnimationListener {
        void a(SplashScreenViewProvider splashScreenViewProvider);
    }

    public /* synthetic */ SplashScreen(Activity activity, DefaultConstructorMarker defaultConstructorMarker) {
        this(activity);
    }

    public final void b() {
        this.f809a.i();
    }

    public final void c(KeepOnScreenCondition keepOnScreenCondition) {
        Intrinsics.checkNotNullParameter(keepOnScreenCondition, "condition");
        this.f809a.j(keepOnScreenCondition);
    }

    public SplashScreen(Activity activity) {
        Impl impl;
        if (Build.VERSION.SDK_INT >= 31) {
            impl = new Impl31(activity);
        } else {
            impl = new Impl(activity);
        }
        this.f809a = impl;
    }
}
