package androidx.appcompat.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.view.ActionBarPolicy;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.ViewPropertyAnimatorCompatSet;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.ActionBarContainer;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.appcompat.widget.DecorToolbar;
import androidx.appcompat.widget.ScrollingTabContainerView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListener;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;
import androidx.core.view.ViewPropertyAnimatorUpdateListener;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

@RestrictTo
public class WindowDecorActionBar extends ActionBar implements ActionBarOverlayLayout.ActionBarVisibilityCallback {
    public static final Interpolator F = new AccelerateInterpolator();
    public static final Interpolator G = new DecelerateInterpolator();
    public boolean A;
    public boolean B;
    public final ViewPropertyAnimatorListener C = new ViewPropertyAnimatorListenerAdapter() {
        public void onAnimationEnd(View view) {
            View view2;
            WindowDecorActionBar windowDecorActionBar = WindowDecorActionBar.this;
            if (windowDecorActionBar.u && (view2 = windowDecorActionBar.h) != null) {
                view2.setTranslationY(0.0f);
                WindowDecorActionBar.this.e.setTranslationY(0.0f);
            }
            WindowDecorActionBar.this.e.setVisibility(8);
            WindowDecorActionBar.this.e.setTransitioning(false);
            WindowDecorActionBar windowDecorActionBar2 = WindowDecorActionBar.this;
            windowDecorActionBar2.z = null;
            windowDecorActionBar2.C();
            ActionBarOverlayLayout actionBarOverlayLayout = WindowDecorActionBar.this.d;
            if (actionBarOverlayLayout != null) {
                ViewCompat.q0(actionBarOverlayLayout);
            }
        }
    };
    public final ViewPropertyAnimatorListener D = new ViewPropertyAnimatorListenerAdapter() {
        public void onAnimationEnd(View view) {
            WindowDecorActionBar windowDecorActionBar = WindowDecorActionBar.this;
            windowDecorActionBar.z = null;
            windowDecorActionBar.e.requestLayout();
        }
    };
    public final ViewPropertyAnimatorUpdateListener E = new ViewPropertyAnimatorUpdateListener() {
        public void onAnimationUpdate(View view) {
            ((View) WindowDecorActionBar.this.e.getParent()).invalidate();
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public Context f192a;
    public Context b;
    public Activity c;
    public ActionBarOverlayLayout d;
    public ActionBarContainer e;
    public DecorToolbar f;
    public ActionBarContextView g;
    public View h;
    public ScrollingTabContainerView i;
    public ArrayList j = new ArrayList();
    public TabImpl k;
    public int l = -1;
    public boolean m;
    public ActionModeImpl n;
    public ActionMode o;
    public ActionMode.Callback p;
    public boolean q;
    public ArrayList r = new ArrayList();
    public boolean s;
    public int t = 0;
    public boolean u = true;
    public boolean v;
    public boolean w;
    public boolean x;
    public boolean y = true;
    public ViewPropertyAnimatorCompatSet z;

    @RestrictTo
    public class ActionModeImpl extends ActionMode implements MenuBuilder.Callback {
        public final Context c;
        public final MenuBuilder d;
        public ActionMode.Callback e;
        public WeakReference f;

        public ActionModeImpl(Context context, ActionMode.Callback callback) {
            this.c = context;
            this.e = callback;
            MenuBuilder defaultShowAsAction = new MenuBuilder(context).setDefaultShowAsAction(1);
            this.d = defaultShowAsAction;
            defaultShowAsAction.setCallback(this);
        }

        public void a() {
            WindowDecorActionBar windowDecorActionBar = WindowDecorActionBar.this;
            if (windowDecorActionBar.n == this) {
                if (!WindowDecorActionBar.B(windowDecorActionBar.v, windowDecorActionBar.w, false)) {
                    WindowDecorActionBar windowDecorActionBar2 = WindowDecorActionBar.this;
                    windowDecorActionBar2.o = this;
                    windowDecorActionBar2.p = this.e;
                } else {
                    this.e.d(this);
                }
                this.e = null;
                WindowDecorActionBar.this.A(false);
                WindowDecorActionBar.this.g.h();
                WindowDecorActionBar windowDecorActionBar3 = WindowDecorActionBar.this;
                windowDecorActionBar3.d.setHideOnContentScrollEnabled(windowDecorActionBar3.B);
                WindowDecorActionBar.this.n = null;
            }
        }

        public View b() {
            WeakReference weakReference = this.f;
            if (weakReference != null) {
                return (View) weakReference.get();
            }
            return null;
        }

        public Menu c() {
            return this.d;
        }

        public MenuInflater d() {
            return new SupportMenuInflater(this.c);
        }

        public CharSequence e() {
            return WindowDecorActionBar.this.g.getSubtitle();
        }

        public CharSequence g() {
            return WindowDecorActionBar.this.g.getTitle();
        }

        public void i() {
            if (WindowDecorActionBar.this.n == this) {
                this.d.stopDispatchingItemsChanged();
                try {
                    this.e.c(this, this.d);
                } finally {
                    this.d.startDispatchingItemsChanged();
                }
            }
        }

        public boolean j() {
            return WindowDecorActionBar.this.g.k();
        }

        public void k(View view) {
            WindowDecorActionBar.this.g.setCustomView(view);
            this.f = new WeakReference(view);
        }

        public void l(int i) {
            m(WindowDecorActionBar.this.f192a.getResources().getString(i));
        }

        public void m(CharSequence charSequence) {
            WindowDecorActionBar.this.g.setSubtitle(charSequence);
        }

        public void o(int i) {
            p(WindowDecorActionBar.this.f192a.getResources().getString(i));
        }

        public boolean onMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem) {
            ActionMode.Callback callback = this.e;
            if (callback != null) {
                return callback.b(this, menuItem);
            }
            return false;
        }

        public void onMenuModeChange(MenuBuilder menuBuilder) {
            if (this.e != null) {
                i();
                WindowDecorActionBar.this.g.g();
            }
        }

        public void p(CharSequence charSequence) {
            WindowDecorActionBar.this.g.setTitle(charSequence);
        }

        public void q(boolean z) {
            super.q(z);
            WindowDecorActionBar.this.g.setTitleOptional(z);
        }

        public boolean r() {
            this.d.stopDispatchingItemsChanged();
            try {
                return this.e.a(this, this.d);
            } finally {
                this.d.startDispatchingItemsChanged();
            }
        }
    }

    @RestrictTo
    public class TabImpl extends ActionBar.Tab {

        /* renamed from: a  reason: collision with root package name */
        public ActionBar.TabListener f196a;
        public Drawable b;
        public CharSequence c;
        public CharSequence d;
        public int e;
        public View f;
        public final /* synthetic */ WindowDecorActionBar g;

        public CharSequence a() {
            return this.d;
        }

        public View b() {
            return this.f;
        }

        public Drawable c() {
            return this.b;
        }

        public int d() {
            return this.e;
        }

        public CharSequence e() {
            return this.c;
        }

        public void f() {
            this.g.J(this);
        }

        public ActionBar.TabListener g() {
            return this.f196a;
        }
    }

    public WindowDecorActionBar(Activity activity, boolean z2) {
        this.c = activity;
        View decorView = activity.getWindow().getDecorView();
        I(decorView);
        if (!z2) {
            this.h = decorView.findViewById(16908290);
        }
    }

    public static boolean B(boolean z2, boolean z3, boolean z4) {
        if (z4) {
            return true;
        }
        return !z2 && !z3;
    }

    public void A(boolean z2) {
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat;
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat2;
        if (z2) {
            P();
        } else {
            H();
        }
        if (O()) {
            if (z2) {
                viewPropertyAnimatorCompat = this.f.setupAnimatorToVisibility(4, 100);
                viewPropertyAnimatorCompat2 = this.g.f(0, 200);
            } else {
                ViewPropertyAnimatorCompat viewPropertyAnimatorCompat3 = this.f.setupAnimatorToVisibility(0, 200);
                viewPropertyAnimatorCompat = this.g.f(8, 100);
                viewPropertyAnimatorCompat2 = viewPropertyAnimatorCompat3;
            }
            ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet = new ViewPropertyAnimatorCompatSet();
            viewPropertyAnimatorCompatSet.d(viewPropertyAnimatorCompat, viewPropertyAnimatorCompat2);
            viewPropertyAnimatorCompatSet.h();
        } else if (z2) {
            this.f.setVisibility(4);
            this.g.setVisibility(0);
        } else {
            this.f.setVisibility(0);
            this.g.setVisibility(8);
        }
    }

    public void C() {
        ActionMode.Callback callback = this.p;
        if (callback != null) {
            callback.d(this.o);
            this.o = null;
            this.p = null;
        }
    }

    public void D(boolean z2) {
        View view;
        ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet = this.z;
        if (viewPropertyAnimatorCompatSet != null) {
            viewPropertyAnimatorCompatSet.a();
        }
        if (this.t != 0 || (!this.A && !z2)) {
            this.C.onAnimationEnd((View) null);
            return;
        }
        this.e.setAlpha(1.0f);
        this.e.setTransitioning(true);
        ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet2 = new ViewPropertyAnimatorCompatSet();
        float f2 = (float) (-this.e.getHeight());
        if (z2) {
            int[] iArr = {0, 0};
            this.e.getLocationInWindow(iArr);
            f2 -= (float) iArr[1];
        }
        ViewPropertyAnimatorCompat q2 = ViewCompat.e(this.e).q(f2);
        q2.n(this.E);
        viewPropertyAnimatorCompatSet2.c(q2);
        if (this.u && (view = this.h) != null) {
            viewPropertyAnimatorCompatSet2.c(ViewCompat.e(view).q(f2));
        }
        viewPropertyAnimatorCompatSet2.f(F);
        viewPropertyAnimatorCompatSet2.e(250);
        viewPropertyAnimatorCompatSet2.g(this.C);
        this.z = viewPropertyAnimatorCompatSet2;
        viewPropertyAnimatorCompatSet2.h();
    }

    public void E(boolean z2) {
        View view;
        View view2;
        ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet = this.z;
        if (viewPropertyAnimatorCompatSet != null) {
            viewPropertyAnimatorCompatSet.a();
        }
        this.e.setVisibility(0);
        if (this.t != 0 || (!this.A && !z2)) {
            this.e.setAlpha(1.0f);
            this.e.setTranslationY(0.0f);
            if (this.u && (view = this.h) != null) {
                view.setTranslationY(0.0f);
            }
            this.D.onAnimationEnd((View) null);
        } else {
            this.e.setTranslationY(0.0f);
            float f2 = (float) (-this.e.getHeight());
            if (z2) {
                int[] iArr = {0, 0};
                this.e.getLocationInWindow(iArr);
                f2 -= (float) iArr[1];
            }
            this.e.setTranslationY(f2);
            ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet2 = new ViewPropertyAnimatorCompatSet();
            ViewPropertyAnimatorCompat q2 = ViewCompat.e(this.e).q(0.0f);
            q2.n(this.E);
            viewPropertyAnimatorCompatSet2.c(q2);
            if (this.u && (view2 = this.h) != null) {
                view2.setTranslationY(f2);
                viewPropertyAnimatorCompatSet2.c(ViewCompat.e(this.h).q(0.0f));
            }
            viewPropertyAnimatorCompatSet2.f(G);
            viewPropertyAnimatorCompatSet2.e(250);
            viewPropertyAnimatorCompatSet2.g(this.D);
            this.z = viewPropertyAnimatorCompatSet2;
            viewPropertyAnimatorCompatSet2.h();
        }
        ActionBarOverlayLayout actionBarOverlayLayout = this.d;
        if (actionBarOverlayLayout != null) {
            ViewCompat.q0(actionBarOverlayLayout);
        }
    }

    public final DecorToolbar F(View view) {
        if (view instanceof DecorToolbar) {
            return (DecorToolbar) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Can't make a decor toolbar out of ");
        sb.append(view != null ? view.getClass().getSimpleName() : "null");
        throw new IllegalStateException(sb.toString());
    }

    public int G() {
        return this.f.getNavigationMode();
    }

    public final void H() {
        if (this.x) {
            this.x = false;
            ActionBarOverlayLayout actionBarOverlayLayout = this.d;
            if (actionBarOverlayLayout != null) {
                actionBarOverlayLayout.setShowingForActionMode(false);
            }
            Q(false);
        }
    }

    public final void I(View view) {
        ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) view.findViewById(R.id.decor_content_parent);
        this.d = actionBarOverlayLayout;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setActionBarVisibilityCallback(this);
        }
        this.f = F(view.findViewById(R.id.action_bar));
        this.g = (ActionBarContextView) view.findViewById(R.id.action_context_bar);
        ActionBarContainer actionBarContainer = (ActionBarContainer) view.findViewById(R.id.action_bar_container);
        this.e = actionBarContainer;
        DecorToolbar decorToolbar = this.f;
        if (decorToolbar == null || this.g == null || actionBarContainer == null) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with a compatible window decor layout");
        }
        this.f192a = decorToolbar.getContext();
        boolean z2 = (this.f.getDisplayOptions() & 4) != 0;
        if (z2) {
            this.m = true;
        }
        ActionBarPolicy b2 = ActionBarPolicy.b(this.f192a);
        v(b2.a() || z2);
        M(b2.g());
        TypedArray obtainStyledAttributes = this.f192a.obtainStyledAttributes((AttributeSet) null, R.styleable.ActionBar, R.attr.actionBarStyle, 0);
        if (obtainStyledAttributes.getBoolean(R.styleable.ActionBar_hideOnContentScroll, false)) {
            N(true);
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ActionBar_elevation, 0);
        if (dimensionPixelSize != 0) {
            L((float) dimensionPixelSize);
        }
        obtainStyledAttributes.recycle();
    }

    public void J(ActionBar.Tab tab) {
        int i2 = -1;
        if (G() != 2) {
            if (tab != null) {
                i2 = tab.d();
            }
            this.l = i2;
            return;
        }
        FragmentTransaction o2 = (!(this.c instanceof FragmentActivity) || this.f.getViewGroup().isInEditMode()) ? null : ((FragmentActivity) this.c).getSupportFragmentManager().s().o();
        TabImpl tabImpl = this.k;
        if (tabImpl != tab) {
            ScrollingTabContainerView scrollingTabContainerView = this.i;
            if (tab != null) {
                i2 = tab.d();
            }
            scrollingTabContainerView.setTabSelected(i2);
            TabImpl tabImpl2 = this.k;
            if (tabImpl2 != null) {
                tabImpl2.g().c(this.k, o2);
            }
            TabImpl tabImpl3 = (TabImpl) tab;
            this.k = tabImpl3;
            if (tabImpl3 != null) {
                tabImpl3.g().a(this.k, o2);
            }
        } else if (tabImpl != null) {
            tabImpl.g().b(this.k, o2);
            this.i.a(tab.d());
        }
        if (o2 != null && !o2.r()) {
            o2.j();
        }
    }

    public void K(int i2, int i3) {
        int displayOptions = this.f.getDisplayOptions();
        if ((i3 & 4) != 0) {
            this.m = true;
        }
        this.f.setDisplayOptions((i2 & i3) | ((~i3) & displayOptions));
    }

    public void L(float f2) {
        ViewCompat.D0(this.e, f2);
    }

    public final void M(boolean z2) {
        this.s = z2;
        if (!z2) {
            this.f.b((ScrollingTabContainerView) null);
            this.e.setTabContainer(this.i);
        } else {
            this.e.setTabContainer((ScrollingTabContainerView) null);
            this.f.b(this.i);
        }
        boolean z3 = true;
        boolean z4 = G() == 2;
        ScrollingTabContainerView scrollingTabContainerView = this.i;
        if (scrollingTabContainerView != null) {
            if (z4) {
                scrollingTabContainerView.setVisibility(0);
                ActionBarOverlayLayout actionBarOverlayLayout = this.d;
                if (actionBarOverlayLayout != null) {
                    ViewCompat.q0(actionBarOverlayLayout);
                }
            } else {
                scrollingTabContainerView.setVisibility(8);
            }
        }
        this.f.setCollapsible(!this.s && z4);
        ActionBarOverlayLayout actionBarOverlayLayout2 = this.d;
        if (this.s || !z4) {
            z3 = false;
        }
        actionBarOverlayLayout2.setHasNonEmbeddedTabs(z3);
    }

    public void N(boolean z2) {
        if (!z2 || this.d.i()) {
            this.B = z2;
            this.d.setHideOnContentScrollEnabled(z2);
            return;
        }
        throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
    }

    public final boolean O() {
        return ViewCompat.W(this.e);
    }

    public final void P() {
        if (!this.x) {
            this.x = true;
            ActionBarOverlayLayout actionBarOverlayLayout = this.d;
            if (actionBarOverlayLayout != null) {
                actionBarOverlayLayout.setShowingForActionMode(true);
            }
            Q(false);
        }
    }

    public final void Q(boolean z2) {
        if (B(this.v, this.w, this.x)) {
            if (!this.y) {
                this.y = true;
                E(z2);
            }
        } else if (this.y) {
            this.y = false;
            D(z2);
        }
    }

    public boolean b() {
        DecorToolbar decorToolbar = this.f;
        if (decorToolbar == null || !decorToolbar.hasExpandedActionView()) {
            return false;
        }
        this.f.collapseActionView();
        return true;
    }

    public void c(boolean z2) {
        if (z2 != this.q) {
            this.q = z2;
            int size = this.r.size();
            for (int i2 = 0; i2 < size; i2++) {
                ((ActionBar.OnMenuVisibilityListener) this.r.get(i2)).onMenuVisibilityChanged(z2);
            }
        }
    }

    public int d() {
        return this.f.getDisplayOptions();
    }

    public Context e() {
        if (this.b == null) {
            TypedValue typedValue = new TypedValue();
            this.f192a.getTheme().resolveAttribute(R.attr.actionBarWidgetTheme, typedValue, true);
            int i2 = typedValue.resourceId;
            if (i2 != 0) {
                this.b = new ContextThemeWrapper(this.f192a, i2);
            } else {
                this.b = this.f192a;
            }
        }
        return this.b;
    }

    public void enableContentAnimations(boolean z2) {
        this.u = z2;
    }

    public CharSequence f() {
        return this.f.getTitle();
    }

    public void g() {
        if (!this.v) {
            this.v = true;
            Q(false);
        }
    }

    public void hideForSystem() {
        if (!this.w) {
            this.w = true;
            Q(true);
        }
    }

    public void i(Configuration configuration) {
        M(ActionBarPolicy.b(this.f192a).g());
    }

    public boolean k(int i2, KeyEvent keyEvent) {
        Menu c2;
        ActionModeImpl actionModeImpl = this.n;
        if (actionModeImpl == null || (c2 = actionModeImpl.c()) == null) {
            return false;
        }
        boolean z2 = true;
        if (KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() == 1) {
            z2 = false;
        }
        c2.setQwertyMode(z2);
        return c2.performShortcut(i2, keyEvent, 0);
    }

    public void n(Drawable drawable) {
        this.e.setPrimaryBackground(drawable);
    }

    public void o(boolean z2) {
        if (!this.m) {
            p(z2);
        }
    }

    public void onContentScrollStarted() {
        ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet = this.z;
        if (viewPropertyAnimatorCompatSet != null) {
            viewPropertyAnimatorCompatSet.a();
            this.z = null;
        }
    }

    public void onContentScrollStopped() {
    }

    public void onWindowVisibilityChanged(int i2) {
        this.t = i2;
    }

    public void p(boolean z2) {
        K(z2 ? 4 : 0, 4);
    }

    public void q(boolean z2) {
        K(z2 ? 2 : 0, 2);
    }

    public void r(boolean z2) {
        K(z2 ? 8 : 0, 8);
    }

    public void s(int i2) {
        this.f.setNavigationContentDescription(i2);
    }

    public void showForSystem() {
        if (this.w) {
            this.w = false;
            Q(true);
        }
    }

    public void t(int i2) {
        this.f.setNavigationIcon(i2);
    }

    public void u(Drawable drawable) {
        this.f.setNavigationIcon(drawable);
    }

    public void v(boolean z2) {
        this.f.setHomeButtonEnabled(z2);
    }

    public void w(boolean z2) {
        ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet;
        this.A = z2;
        if (!z2 && (viewPropertyAnimatorCompatSet = this.z) != null) {
            viewPropertyAnimatorCompatSet.a();
        }
    }

    public void x(CharSequence charSequence) {
        this.f.setTitle(charSequence);
    }

    public void y(CharSequence charSequence) {
        this.f.setWindowTitle(charSequence);
    }

    public ActionMode z(ActionMode.Callback callback) {
        ActionModeImpl actionModeImpl = this.n;
        if (actionModeImpl != null) {
            actionModeImpl.a();
        }
        this.d.setHideOnContentScrollEnabled(false);
        this.g.l();
        ActionModeImpl actionModeImpl2 = new ActionModeImpl(this.g.getContext(), callback);
        if (!actionModeImpl2.r()) {
            return null;
        }
        this.n = actionModeImpl2;
        actionModeImpl2.i();
        this.g.i(actionModeImpl2);
        A(true);
        return actionModeImpl2;
    }

    public WindowDecorActionBar(Dialog dialog) {
        I(dialog.getWindow().getDecorView());
    }
}
