package androidx.appcompat.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.view.ActionBarPolicy;
import androidx.appcompat.widget.LinearLayoutCompat;

@RestrictTo
public class ScrollingTabContainerView extends HorizontalScrollView implements AdapterView.OnItemSelectedListener {
    public static final Interpolator l = new DecelerateInterpolator();

    /* renamed from: a  reason: collision with root package name */
    public Runnable f337a;
    public TabClickListener b;
    public LinearLayoutCompat c;
    public Spinner d;
    public boolean e;
    public int f;
    public int g;
    public int h;
    public int i;
    public ViewPropertyAnimator j;
    public final VisibilityAnimListener k = new VisibilityAnimListener();

    public class TabAdapter extends BaseAdapter {
        public TabAdapter() {
        }

        public int getCount() {
            return ScrollingTabContainerView.this.c.getChildCount();
        }

        public Object getItem(int i) {
            return ((TabView) ScrollingTabContainerView.this.c.getChildAt(i)).b();
        }

        public long getItemId(int i) {
            return (long) i;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                return ScrollingTabContainerView.this.d((ActionBar.Tab) getItem(i), true);
            }
            ((TabView) view).a((ActionBar.Tab) getItem(i));
            return view;
        }
    }

    public class TabClickListener implements View.OnClickListener {
        public TabClickListener() {
        }

        public void onClick(View view) {
            ((TabView) view).b().f();
            int childCount = ScrollingTabContainerView.this.c.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = ScrollingTabContainerView.this.c.getChildAt(i);
                childAt.setSelected(childAt == view);
            }
        }
    }

    public class TabView extends LinearLayout {

        /* renamed from: a  reason: collision with root package name */
        public final int[] f341a;
        public ActionBar.Tab b;
        public TextView c;
        public ImageView d;
        public View e;

        public TabView(Context context, ActionBar.Tab tab, boolean z) {
            super(context, (AttributeSet) null, R.attr.actionBarTabStyle);
            int[] iArr = {16842964};
            this.f341a = iArr;
            this.b = tab;
            TintTypedArray v = TintTypedArray.v(context, (AttributeSet) null, iArr, R.attr.actionBarTabStyle, 0);
            if (v.s(0)) {
                setBackgroundDrawable(v.g(0));
            }
            v.w();
            if (z) {
                setGravity(8388627);
            }
            c();
        }

        public void a(ActionBar.Tab tab) {
            this.b = tab;
            c();
        }

        public ActionBar.Tab b() {
            return this.b;
        }

        public void c() {
            ActionBar.Tab tab = this.b;
            View b2 = tab.b();
            CharSequence charSequence = null;
            if (b2 != null) {
                ViewParent parent = b2.getParent();
                if (parent != this) {
                    if (parent != null) {
                        ((ViewGroup) parent).removeView(b2);
                    }
                    addView(b2);
                }
                this.e = b2;
                TextView textView = this.c;
                if (textView != null) {
                    textView.setVisibility(8);
                }
                ImageView imageView = this.d;
                if (imageView != null) {
                    imageView.setVisibility(8);
                    this.d.setImageDrawable((Drawable) null);
                    return;
                }
                return;
            }
            View view = this.e;
            if (view != null) {
                removeView(view);
                this.e = null;
            }
            Drawable c2 = tab.c();
            CharSequence e2 = tab.e();
            if (c2 != null) {
                if (this.d == null) {
                    AppCompatImageView appCompatImageView = new AppCompatImageView(getContext());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 16;
                    appCompatImageView.setLayoutParams(layoutParams);
                    addView(appCompatImageView, 0);
                    this.d = appCompatImageView;
                }
                this.d.setImageDrawable(c2);
                this.d.setVisibility(0);
            } else {
                ImageView imageView2 = this.d;
                if (imageView2 != null) {
                    imageView2.setVisibility(8);
                    this.d.setImageDrawable((Drawable) null);
                }
            }
            boolean z = !TextUtils.isEmpty(e2);
            if (z) {
                if (this.c == null) {
                    AppCompatTextView appCompatTextView = new AppCompatTextView(getContext(), (AttributeSet) null, R.attr.actionBarTabTextStyle);
                    appCompatTextView.setEllipsize(TextUtils.TruncateAt.END);
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams2.gravity = 16;
                    appCompatTextView.setLayoutParams(layoutParams2);
                    addView(appCompatTextView);
                    this.c = appCompatTextView;
                }
                this.c.setText(e2);
                this.c.setVisibility(0);
            } else {
                TextView textView2 = this.c;
                if (textView2 != null) {
                    textView2.setVisibility(8);
                    this.c.setText((CharSequence) null);
                }
            }
            ImageView imageView3 = this.d;
            if (imageView3 != null) {
                imageView3.setContentDescription(tab.a());
            }
            if (!z) {
                charSequence = tab.a();
            }
            TooltipCompat.a(this, charSequence);
        }

        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName("androidx.appcompat.app.ActionBar$Tab");
        }

        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName("androidx.appcompat.app.ActionBar$Tab");
        }

        public void onMeasure(int i, int i2) {
            int i3;
            super.onMeasure(i, i2);
            if (ScrollingTabContainerView.this.f > 0 && getMeasuredWidth() > (i3 = ScrollingTabContainerView.this.f)) {
                super.onMeasure(View.MeasureSpec.makeMeasureSpec(i3, 1073741824), i2);
            }
        }

        public void setSelected(boolean z) {
            boolean z2 = isSelected() != z;
            super.setSelected(z);
            if (z2 && z) {
                sendAccessibilityEvent(4);
            }
        }
    }

    public class VisibilityAnimListener extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        public boolean f342a = false;
        public int b;

        public VisibilityAnimListener() {
        }

        public void onAnimationCancel(Animator animator) {
            this.f342a = true;
        }

        public void onAnimationEnd(Animator animator) {
            if (!this.f342a) {
                ScrollingTabContainerView scrollingTabContainerView = ScrollingTabContainerView.this;
                scrollingTabContainerView.j = null;
                scrollingTabContainerView.setVisibility(this.b);
            }
        }

        public void onAnimationStart(Animator animator) {
            ScrollingTabContainerView.this.setVisibility(0);
            this.f342a = false;
        }
    }

    public ScrollingTabContainerView(@NonNull Context context) {
        super(context);
        setHorizontalScrollBarEnabled(false);
        ActionBarPolicy b2 = ActionBarPolicy.b(context);
        setContentHeight(b2.f());
        this.g = b2.e();
        LinearLayoutCompat c2 = c();
        this.c = c2;
        addView(c2, new ViewGroup.LayoutParams(-2, -1));
    }

    public void a(int i2) {
        final View childAt = this.c.getChildAt(i2);
        Runnable runnable = this.f337a;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
        AnonymousClass1 r0 = new Runnable() {
            public void run() {
                ScrollingTabContainerView.this.smoothScrollTo(childAt.getLeft() - ((ScrollingTabContainerView.this.getWidth() - childAt.getWidth()) / 2), 0);
                ScrollingTabContainerView.this.f337a = null;
            }
        };
        this.f337a = r0;
        post(r0);
    }

    public final Spinner b() {
        AppCompatSpinner appCompatSpinner = new AppCompatSpinner(getContext(), (AttributeSet) null, R.attr.actionDropDownStyle);
        appCompatSpinner.setLayoutParams(new LinearLayoutCompat.LayoutParams(-2, -1));
        appCompatSpinner.setOnItemSelectedListener(this);
        return appCompatSpinner;
    }

    public final LinearLayoutCompat c() {
        LinearLayoutCompat linearLayoutCompat = new LinearLayoutCompat(getContext(), (AttributeSet) null, R.attr.actionBarTabBarStyle);
        linearLayoutCompat.setMeasureWithLargestChildEnabled(true);
        linearLayoutCompat.setGravity(17);
        linearLayoutCompat.setLayoutParams(new LinearLayoutCompat.LayoutParams(-2, -1));
        return linearLayoutCompat;
    }

    public TabView d(ActionBar.Tab tab, boolean z) {
        TabView tabView = new TabView(getContext(), tab, z);
        if (z) {
            tabView.setBackgroundDrawable((Drawable) null);
            tabView.setLayoutParams(new AbsListView.LayoutParams(-1, this.h));
        } else {
            tabView.setFocusable(true);
            if (this.b == null) {
                this.b = new TabClickListener();
            }
            tabView.setOnClickListener(this.b);
        }
        return tabView;
    }

    public final boolean e() {
        Spinner spinner = this.d;
        return spinner != null && spinner.getParent() == this;
    }

    public final void f() {
        if (!e()) {
            if (this.d == null) {
                this.d = b();
            }
            removeView(this.c);
            addView(this.d, new ViewGroup.LayoutParams(-2, -1));
            if (this.d.getAdapter() == null) {
                this.d.setAdapter(new TabAdapter());
            }
            Runnable runnable = this.f337a;
            if (runnable != null) {
                removeCallbacks(runnable);
                this.f337a = null;
            }
            this.d.setSelection(this.i);
        }
    }

    public final boolean g() {
        if (!e()) {
            return false;
        }
        removeView(this.d);
        addView(this.c, new ViewGroup.LayoutParams(-2, -1));
        setTabSelected(this.d.getSelectedItemPosition());
        return false;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Runnable runnable = this.f337a;
        if (runnable != null) {
            post(runnable);
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        ActionBarPolicy b2 = ActionBarPolicy.b(getContext());
        setContentHeight(b2.f());
        this.g = b2.e();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Runnable runnable = this.f337a;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
    }

    public void onItemSelected(AdapterView adapterView, View view, int i2, long j2) {
        ((TabView) view).b().f();
    }

    public void onMeasure(int i2, int i3) {
        int mode = View.MeasureSpec.getMode(i2);
        boolean z = mode == 1073741824;
        setFillViewport(z);
        int childCount = this.c.getChildCount();
        if (childCount <= 1 || !(mode == 1073741824 || mode == Integer.MIN_VALUE)) {
            this.f = -1;
        } else {
            if (childCount > 2) {
                this.f = (int) (((float) View.MeasureSpec.getSize(i2)) * 0.4f);
            } else {
                this.f = View.MeasureSpec.getSize(i2) / 2;
            }
            this.f = Math.min(this.f, this.g);
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.h, 1073741824);
        if (z || !this.e) {
            g();
        } else {
            this.c.measure(0, makeMeasureSpec);
            if (this.c.getMeasuredWidth() > View.MeasureSpec.getSize(i2)) {
                f();
            } else {
                g();
            }
        }
        int measuredWidth = getMeasuredWidth();
        super.onMeasure(i2, makeMeasureSpec);
        int measuredWidth2 = getMeasuredWidth();
        if (z && measuredWidth != measuredWidth2) {
            setTabSelected(this.i);
        }
    }

    public void onNothingSelected(AdapterView adapterView) {
    }

    public void setAllowCollapse(boolean z) {
        this.e = z;
    }

    public void setContentHeight(int i2) {
        this.h = i2;
        requestLayout();
    }

    public void setTabSelected(int i2) {
        this.i = i2;
        int childCount = this.c.getChildCount();
        int i3 = 0;
        while (i3 < childCount) {
            View childAt = this.c.getChildAt(i3);
            boolean z = i3 == i2;
            childAt.setSelected(z);
            if (z) {
                a(i2);
            }
            i3++;
        }
        Spinner spinner = this.d;
        if (spinner != null && i2 >= 0) {
            spinner.setSelection(i2);
        }
    }
}
