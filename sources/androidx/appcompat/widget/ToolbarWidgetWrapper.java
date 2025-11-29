package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.menu.ActionMenuItem;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;

@RestrictTo
public class ToolbarWidgetWrapper implements DecorToolbar {

    /* renamed from: a  reason: collision with root package name */
    public Toolbar f371a;
    public int b;
    public View c;
    public View d;
    public Drawable e;
    public Drawable f;
    public Drawable g;
    public boolean h;
    public CharSequence i;
    public CharSequence j;
    public CharSequence k;
    public Window.Callback l;
    public boolean m;
    public ActionMenuPresenter n;
    public int o;
    public int p;
    public Drawable q;

    public ToolbarWidgetWrapper(Toolbar toolbar, boolean z) {
        this(toolbar, z, R.string.abc_action_bar_up_description, R.drawable.abc_ic_ab_back_material);
    }

    public void a(Menu menu, MenuPresenter.Callback callback) {
        if (this.n == null) {
            ActionMenuPresenter actionMenuPresenter = new ActionMenuPresenter(this.f371a.getContext());
            this.n = actionMenuPresenter;
            actionMenuPresenter.h(R.id.action_menu_presenter);
        }
        this.n.setCallback(callback);
        this.f371a.setMenu((MenuBuilder) menu, this.n);
    }

    public void b(ScrollingTabContainerView scrollingTabContainerView) {
        Toolbar toolbar;
        View view = this.c;
        if (view != null && view.getParent() == (toolbar = this.f371a)) {
            toolbar.removeView(this.c);
        }
        this.c = scrollingTabContainerView;
        if (scrollingTabContainerView != null && this.o == 2) {
            this.f371a.addView(scrollingTabContainerView, 0);
            Toolbar.LayoutParams layoutParams = (Toolbar.LayoutParams) this.c.getLayoutParams();
            layoutParams.width = -2;
            layoutParams.height = -2;
            layoutParams.f139a = 8388691;
            scrollingTabContainerView.setAllowCollapse(true);
        }
    }

    public void c(MenuPresenter.Callback callback, MenuBuilder.Callback callback2) {
        this.f371a.setMenuCallbacks(callback, callback2);
    }

    public boolean canShowOverflowMenu() {
        return this.f371a.canShowOverflowMenu();
    }

    public void collapseActionView() {
        this.f371a.collapseActionView();
    }

    public final int d() {
        if (this.f371a.getNavigationIcon() == null) {
            return 11;
        }
        this.q = this.f371a.getNavigationIcon();
        return 15;
    }

    public void dismissPopupMenus() {
        this.f371a.dismissPopupMenus();
    }

    public void e(View view) {
        View view2 = this.d;
        if (!(view2 == null || (this.b & 16) == 0)) {
            this.f371a.removeView(view2);
        }
        this.d = view;
        if (view != null && (this.b & 16) != 0) {
            this.f371a.addView(view);
        }
    }

    public void f(int i2) {
        if (i2 != this.p) {
            this.p = i2;
            if (TextUtils.isEmpty(this.f371a.getNavigationContentDescription())) {
                setNavigationContentDescription(this.p);
            }
        }
    }

    public void g(Drawable drawable) {
        this.f = drawable;
        m();
    }

    public Context getContext() {
        return this.f371a.getContext();
    }

    public int getDisplayOptions() {
        return this.b;
    }

    public Menu getMenu() {
        return this.f371a.getMenu();
    }

    public int getNavigationMode() {
        return this.o;
    }

    public CharSequence getTitle() {
        return this.f371a.getTitle();
    }

    public ViewGroup getViewGroup() {
        return this.f371a;
    }

    public void h(CharSequence charSequence) {
        this.k = charSequence;
        k();
    }

    public boolean hasExpandedActionView() {
        return this.f371a.hasExpandedActionView();
    }

    public boolean hideOverflowMenu() {
        return this.f371a.hideOverflowMenu();
    }

    public void i(CharSequence charSequence) {
        this.j = charSequence;
        if ((this.b & 8) != 0) {
            this.f371a.setSubtitle(charSequence);
        }
    }

    public void initIndeterminateProgress() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    public void initProgress() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    public boolean isOverflowMenuShowPending() {
        return this.f371a.isOverflowMenuShowPending();
    }

    public boolean isOverflowMenuShowing() {
        return this.f371a.isOverflowMenuShowing();
    }

    public final void j(CharSequence charSequence) {
        this.i = charSequence;
        if ((this.b & 8) != 0) {
            this.f371a.setTitle(charSequence);
            if (this.h) {
                ViewCompat.x0(this.f371a.getRootView(), charSequence);
            }
        }
    }

    public final void k() {
        if ((this.b & 4) == 0) {
            return;
        }
        if (TextUtils.isEmpty(this.k)) {
            this.f371a.setNavigationContentDescription(this.p);
        } else {
            this.f371a.setNavigationContentDescription(this.k);
        }
    }

    public final void l() {
        if ((this.b & 4) != 0) {
            Toolbar toolbar = this.f371a;
            Drawable drawable = this.g;
            if (drawable == null) {
                drawable = this.q;
            }
            toolbar.setNavigationIcon(drawable);
            return;
        }
        this.f371a.setNavigationIcon((Drawable) null);
    }

    public final void m() {
        Drawable drawable;
        int i2 = this.b;
        if ((i2 & 2) == 0) {
            drawable = null;
        } else if ((i2 & 1) != 0) {
            drawable = this.f;
            if (drawable == null) {
                drawable = this.e;
            }
        } else {
            drawable = this.e;
        }
        this.f371a.setLogo(drawable);
    }

    public void setBackgroundDrawable(Drawable drawable) {
        ViewCompat.z0(this.f371a, drawable);
    }

    public void setCollapsible(boolean z) {
        this.f371a.setCollapsible(z);
    }

    public void setDisplayOptions(int i2) {
        View view;
        int i3 = this.b ^ i2;
        this.b = i2;
        if (i3 != 0) {
            if ((i3 & 4) != 0) {
                if ((i2 & 4) != 0) {
                    k();
                }
                l();
            }
            if ((i3 & 3) != 0) {
                m();
            }
            if ((i3 & 8) != 0) {
                if ((i2 & 8) != 0) {
                    this.f371a.setTitle(this.i);
                    this.f371a.setSubtitle(this.j);
                } else {
                    this.f371a.setTitle((CharSequence) null);
                    this.f371a.setSubtitle((CharSequence) null);
                }
            }
            if ((i3 & 16) != 0 && (view = this.d) != null) {
                if ((i2 & 16) != 0) {
                    this.f371a.addView(view);
                } else {
                    this.f371a.removeView(view);
                }
            }
        }
    }

    public void setHomeButtonEnabled(boolean z) {
    }

    public void setIcon(int i2) {
        setIcon(i2 != 0 ? AppCompatResources.b(getContext(), i2) : null);
    }

    public void setLogo(int i2) {
        g(i2 != 0 ? AppCompatResources.b(getContext(), i2) : null);
    }

    public void setMenuPrepared() {
        this.m = true;
    }

    public void setNavigationContentDescription(int i2) {
        h(i2 == 0 ? null : getContext().getString(i2));
    }

    public void setNavigationIcon(Drawable drawable) {
        this.g = drawable;
        l();
    }

    public void setTitle(CharSequence charSequence) {
        this.h = true;
        j(charSequence);
    }

    public void setVisibility(int i2) {
        this.f371a.setVisibility(i2);
    }

    public void setWindowCallback(Window.Callback callback) {
        this.l = callback;
    }

    public void setWindowTitle(CharSequence charSequence) {
        if (!this.h) {
            j(charSequence);
        }
    }

    public ViewPropertyAnimatorCompat setupAnimatorToVisibility(final int i2, long j2) {
        return ViewCompat.e(this.f371a).b(i2 == 0 ? 1.0f : 0.0f).i(j2).k(new ViewPropertyAnimatorListenerAdapter() {

            /* renamed from: a  reason: collision with root package name */
            public boolean f373a = false;

            public void onAnimationCancel(View view) {
                this.f373a = true;
            }

            public void onAnimationEnd(View view) {
                if (!this.f373a) {
                    ToolbarWidgetWrapper.this.f371a.setVisibility(i2);
                }
            }

            public void onAnimationStart(View view) {
                ToolbarWidgetWrapper.this.f371a.setVisibility(0);
            }
        });
    }

    public boolean showOverflowMenu() {
        return this.f371a.showOverflowMenu();
    }

    public ToolbarWidgetWrapper(Toolbar toolbar, boolean z, int i2, int i3) {
        Drawable drawable;
        this.o = 0;
        this.p = 0;
        this.f371a = toolbar;
        this.i = toolbar.getTitle();
        this.j = toolbar.getSubtitle();
        this.h = this.i != null;
        this.g = toolbar.getNavigationIcon();
        TintTypedArray v = TintTypedArray.v(toolbar.getContext(), (AttributeSet) null, R.styleable.ActionBar, R.attr.actionBarStyle, 0);
        this.q = v.g(R.styleable.ActionBar_homeAsUpIndicator);
        if (z) {
            CharSequence p2 = v.p(R.styleable.ActionBar_title);
            if (!TextUtils.isEmpty(p2)) {
                setTitle(p2);
            }
            CharSequence p3 = v.p(R.styleable.ActionBar_subtitle);
            if (!TextUtils.isEmpty(p3)) {
                i(p3);
            }
            Drawable g2 = v.g(R.styleable.ActionBar_logo);
            if (g2 != null) {
                g(g2);
            }
            Drawable g3 = v.g(R.styleable.ActionBar_icon);
            if (g3 != null) {
                setIcon(g3);
            }
            if (this.g == null && (drawable = this.q) != null) {
                setNavigationIcon(drawable);
            }
            setDisplayOptions(v.k(R.styleable.ActionBar_displayOptions, 0));
            int n2 = v.n(R.styleable.ActionBar_customNavigationLayout, 0);
            if (n2 != 0) {
                e(LayoutInflater.from(this.f371a.getContext()).inflate(n2, this.f371a, false));
                setDisplayOptions(this.b | 16);
            }
            int m2 = v.m(R.styleable.ActionBar_height, 0);
            if (m2 > 0) {
                ViewGroup.LayoutParams layoutParams = this.f371a.getLayoutParams();
                layoutParams.height = m2;
                this.f371a.setLayoutParams(layoutParams);
            }
            int e2 = v.e(R.styleable.ActionBar_contentInsetStart, -1);
            int e3 = v.e(R.styleable.ActionBar_contentInsetEnd, -1);
            if (e2 >= 0 || e3 >= 0) {
                this.f371a.setContentInsetsRelative(Math.max(e2, 0), Math.max(e3, 0));
            }
            int n3 = v.n(R.styleable.ActionBar_titleTextStyle, 0);
            if (n3 != 0) {
                Toolbar toolbar2 = this.f371a;
                toolbar2.setTitleTextAppearance(toolbar2.getContext(), n3);
            }
            int n4 = v.n(R.styleable.ActionBar_subtitleTextStyle, 0);
            if (n4 != 0) {
                Toolbar toolbar3 = this.f371a;
                toolbar3.setSubtitleTextAppearance(toolbar3.getContext(), n4);
            }
            int n5 = v.n(R.styleable.ActionBar_popupTheme, 0);
            if (n5 != 0) {
                this.f371a.setPopupTheme(n5);
            }
        } else {
            this.b = d();
        }
        v.w();
        f(i2);
        this.k = this.f371a.getNavigationContentDescription();
        this.f371a.setNavigationOnClickListener(new View.OnClickListener() {

            /* renamed from: a  reason: collision with root package name */
            public final ActionMenuItem f372a;

            {
                this.f372a = new ActionMenuItem(ToolbarWidgetWrapper.this.f371a.getContext(), 0, 16908332, 0, 0, ToolbarWidgetWrapper.this.i);
            }

            public void onClick(View view) {
                ToolbarWidgetWrapper toolbarWidgetWrapper = ToolbarWidgetWrapper.this;
                Window.Callback callback = toolbarWidgetWrapper.l;
                if (callback != null && toolbarWidgetWrapper.m) {
                    callback.onMenuItemSelected(0, this.f372a);
                }
            }
        });
    }

    public void setIcon(Drawable drawable) {
        this.e = drawable;
        m();
    }

    public void setNavigationIcon(int i2) {
        setNavigationIcon(i2 != 0 ? AppCompatResources.b(getContext(), i2) : null);
    }
}
