package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.widget.LinearLayoutCompat;

public class ActionMenuView extends LinearLayoutCompat implements MenuBuilder.ItemInvoker, MenuView {

    /* renamed from: a  reason: collision with root package name */
    public MenuBuilder f261a;
    public Context b;
    public int c;
    public boolean d;
    public ActionMenuPresenter e;
    public MenuPresenter.Callback f;
    public MenuBuilder.Callback g;
    public boolean h;
    public int i;
    public int j;
    public int k;
    public OnMenuItemClickListener l;

    @RestrictTo
    public interface ActionMenuChildView {
        boolean needsDividerAfter();

        boolean needsDividerBefore();
    }

    public static class ActionMenuPresenterCallback implements MenuPresenter.Callback {
        public boolean a(MenuBuilder menuBuilder) {
            return false;
        }

        public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
        }
    }

    public static class LayoutParams extends LinearLayoutCompat.LayoutParams {

        /* renamed from: a  reason: collision with root package name */
        public boolean f262a;
        public int b;
        public int c;
        public boolean d;
        public boolean e;
        public boolean f;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(LayoutParams layoutParams) {
            super(layoutParams);
            this.f262a = layoutParams.f262a;
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.f262a = false;
        }
    }

    public class MenuBuilderCallback implements MenuBuilder.Callback {
        public MenuBuilderCallback() {
        }

        public boolean onMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem) {
            OnMenuItemClickListener onMenuItemClickListener = ActionMenuView.this.l;
            return onMenuItemClickListener != null && onMenuItemClickListener.onMenuItemClick(menuItem);
        }

        public void onMenuModeChange(MenuBuilder menuBuilder) {
            MenuBuilder.Callback callback = ActionMenuView.this.g;
            if (callback != null) {
                callback.onMenuModeChange(menuBuilder);
            }
        }
    }

    public interface OnMenuItemClickListener {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    public ActionMenuView(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    public static int measureChildForCells(View view, int i2, int i3, int i4, int i5) {
        int i6;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i4) - i5, View.MeasureSpec.getMode(i4));
        ActionMenuItemView actionMenuItemView = view instanceof ActionMenuItemView ? (ActionMenuItemView) view : null;
        boolean z = false;
        boolean z2 = actionMenuItemView != null && actionMenuItemView.hasText();
        if (i3 > 0) {
            i6 = 2;
            if (!z2 || i3 >= 2) {
                view.measure(View.MeasureSpec.makeMeasureSpec(i3 * i2, Integer.MIN_VALUE), makeMeasureSpec);
                int measuredWidth = view.getMeasuredWidth();
                int i7 = measuredWidth / i2;
                if (measuredWidth % i2 != 0) {
                    i7++;
                }
                if (!z2 || i7 >= 2) {
                    i6 = i7;
                }
                if (!layoutParams.f262a && z2) {
                    z = true;
                }
                layoutParams.d = z;
                layoutParams.b = i6;
                view.measure(View.MeasureSpec.makeMeasureSpec(i2 * i6, 1073741824), makeMeasureSpec);
                return i6;
            }
        }
        i6 = 0;
        z = true;
        layoutParams.d = z;
        layoutParams.b = i6;
        view.measure(View.MeasureSpec.makeMeasureSpec(i2 * i6, 1073741824), makeMeasureSpec);
        return i6;
    }

    public boolean a(MenuItemImpl menuItemImpl) {
        return this.f261a.performItemAction(menuItemImpl, 0);
    }

    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    /* renamed from: d */
    public LayoutParams generateDefaultLayoutParams() {
        LayoutParams layoutParams = new LayoutParams(-2, -2);
        layoutParams.gravity = 16;
        return layoutParams;
    }

    public void dismissPopupMenus() {
        ActionMenuPresenter actionMenuPresenter = this.e;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.q();
        }
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return false;
    }

    /* renamed from: e */
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* renamed from: f */
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams == null) {
            return generateDefaultLayoutParams();
        }
        LayoutParams layoutParams2 = layoutParams instanceof LayoutParams ? new LayoutParams((LayoutParams) layoutParams) : new LayoutParams(layoutParams);
        if (layoutParams2.gravity <= 0) {
            layoutParams2.gravity = 16;
        }
        return layoutParams2;
    }

    public LayoutParams g() {
        LayoutParams d2 = generateDefaultLayoutParams();
        d2.f262a = true;
        return d2;
    }

    public Menu getMenu() {
        if (this.f261a == null) {
            Context context = getContext();
            MenuBuilder menuBuilder = new MenuBuilder(context);
            this.f261a = menuBuilder;
            menuBuilder.setCallback(new MenuBuilderCallback());
            ActionMenuPresenter actionMenuPresenter = new ActionMenuPresenter(context);
            this.e = actionMenuPresenter;
            actionMenuPresenter.B(true);
            ActionMenuPresenter actionMenuPresenter2 = this.e;
            MenuPresenter.Callback callback = this.f;
            if (callback == null) {
                callback = new ActionMenuPresenterCallback();
            }
            actionMenuPresenter2.setCallback(callback);
            this.f261a.addMenuPresenter(this.e, this.b);
            this.e.z(this);
        }
        return this.f261a;
    }

    @Nullable
    public Drawable getOverflowIcon() {
        getMenu();
        return this.e.s();
    }

    public int getPopupTheme() {
        return this.c;
    }

    @RestrictTo
    public int getWindowAnimations() {
        return 0;
    }

    public MenuBuilder h() {
        return this.f261a;
    }

    public boolean hasSupportDividerBeforeChildAt(int i2) {
        boolean z = false;
        if (i2 == 0) {
            return false;
        }
        View childAt = getChildAt(i2 - 1);
        View childAt2 = getChildAt(i2);
        if (i2 < getChildCount() && (childAt instanceof ActionMenuChildView)) {
            z = ((ActionMenuChildView) childAt).needsDividerAfter();
        }
        return (i2 <= 0 || !(childAt2 instanceof ActionMenuChildView)) ? z : z | ((ActionMenuChildView) childAt2).needsDividerBefore();
    }

    public boolean hideOverflowMenu() {
        ActionMenuPresenter actionMenuPresenter = this.e;
        return actionMenuPresenter != null && actionMenuPresenter.t();
    }

    public void i(MenuPresenter.Callback callback, MenuBuilder.Callback callback2) {
        this.f = callback;
        this.g = callback2;
    }

    public void initialize(MenuBuilder menuBuilder) {
        this.f261a = menuBuilder;
    }

    public boolean isOverflowMenuShowPending() {
        ActionMenuPresenter actionMenuPresenter = this.e;
        return actionMenuPresenter != null && actionMenuPresenter.v();
    }

    public boolean isOverflowMenuShowing() {
        ActionMenuPresenter actionMenuPresenter = this.e;
        return actionMenuPresenter != null && actionMenuPresenter.w();
    }

    public boolean isOverflowReserved() {
        return this.d;
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        ActionMenuPresenter actionMenuPresenter = this.e;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.updateMenuView(false);
            if (this.e.w()) {
                this.e.t();
                this.e.C();
            }
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        dismissPopupMenus();
    }

    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int i6;
        int i7;
        if (!this.h) {
            super.onLayout(z, i2, i3, i4, i5);
            return;
        }
        int childCount = getChildCount();
        int i8 = (i5 - i3) / 2;
        int dividerWidth = getDividerWidth();
        int i9 = i4 - i2;
        int paddingRight = (i9 - getPaddingRight()) - getPaddingLeft();
        boolean b2 = ViewUtils.b(this);
        int i10 = 0;
        int i11 = 0;
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt = getChildAt(i12);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.f262a) {
                    int measuredWidth = childAt.getMeasuredWidth();
                    if (hasSupportDividerBeforeChildAt(i12)) {
                        measuredWidth += dividerWidth;
                    }
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (b2) {
                        i6 = getPaddingLeft() + layoutParams.leftMargin;
                        i7 = i6 + measuredWidth;
                    } else {
                        i7 = (getWidth() - getPaddingRight()) - layoutParams.rightMargin;
                        i6 = i7 - measuredWidth;
                    }
                    int i13 = i8 - (measuredHeight / 2);
                    childAt.layout(i6, i13, i7, measuredHeight + i13);
                    paddingRight -= measuredWidth;
                    i10 = 1;
                } else {
                    paddingRight -= (childAt.getMeasuredWidth() + layoutParams.leftMargin) + layoutParams.rightMargin;
                    hasSupportDividerBeforeChildAt(i12);
                    i11++;
                }
            }
        }
        if (childCount == 1 && i10 == 0) {
            View childAt2 = getChildAt(0);
            int measuredWidth2 = childAt2.getMeasuredWidth();
            int measuredHeight2 = childAt2.getMeasuredHeight();
            int i14 = (i9 / 2) - (measuredWidth2 / 2);
            int i15 = i8 - (measuredHeight2 / 2);
            childAt2.layout(i14, i15, measuredWidth2 + i14, measuredHeight2 + i15);
            return;
        }
        int i16 = i11 - (i10 ^ 1);
        int max = Math.max(0, i16 > 0 ? paddingRight / i16 : 0);
        if (b2) {
            int width = getWidth() - getPaddingRight();
            for (int i17 = 0; i17 < childCount; i17++) {
                View childAt3 = getChildAt(i17);
                LayoutParams layoutParams2 = (LayoutParams) childAt3.getLayoutParams();
                if (childAt3.getVisibility() != 8 && !layoutParams2.f262a) {
                    int i18 = width - layoutParams2.rightMargin;
                    int measuredWidth3 = childAt3.getMeasuredWidth();
                    int measuredHeight3 = childAt3.getMeasuredHeight();
                    int i19 = i8 - (measuredHeight3 / 2);
                    childAt3.layout(i18 - measuredWidth3, i19, i18, measuredHeight3 + i19);
                    width = i18 - ((measuredWidth3 + layoutParams2.leftMargin) + max);
                }
            }
            return;
        }
        int paddingLeft = getPaddingLeft();
        for (int i20 = 0; i20 < childCount; i20++) {
            View childAt4 = getChildAt(i20);
            LayoutParams layoutParams3 = (LayoutParams) childAt4.getLayoutParams();
            if (childAt4.getVisibility() != 8 && !layoutParams3.f262a) {
                int i21 = paddingLeft + layoutParams3.leftMargin;
                int measuredWidth4 = childAt4.getMeasuredWidth();
                int measuredHeight4 = childAt4.getMeasuredHeight();
                int i22 = i8 - (measuredHeight4 / 2);
                childAt4.layout(i21, i22, i21 + measuredWidth4, measuredHeight4 + i22);
                paddingLeft = i21 + measuredWidth4 + layoutParams3.rightMargin + max;
            }
        }
    }

    public void onMeasure(int i2, int i3) {
        MenuBuilder menuBuilder;
        boolean z = this.h;
        boolean z2 = View.MeasureSpec.getMode(i2) == 1073741824;
        this.h = z2;
        if (z != z2) {
            this.i = 0;
        }
        int size = View.MeasureSpec.getSize(i2);
        if (!(!this.h || (menuBuilder = this.f261a) == null || size == this.i)) {
            this.i = size;
            menuBuilder.onItemsChanged(true);
        }
        int childCount = getChildCount();
        if (!this.h || childCount <= 0) {
            for (int i4 = 0; i4 < childCount; i4++) {
                LayoutParams layoutParams = (LayoutParams) getChildAt(i4).getLayoutParams();
                layoutParams.rightMargin = 0;
                layoutParams.leftMargin = 0;
            }
            super.onMeasure(i2, i3);
            return;
        }
        onMeasureExactFormat(i2, i3);
    }

    public final void onMeasureExactFormat(int i2, int i3) {
        int i4;
        boolean z;
        int i5;
        int i6;
        int i7;
        boolean z2;
        boolean z3;
        int i8;
        boolean z4;
        int mode = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i2);
        int size2 = View.MeasureSpec.getSize(i3);
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i3, paddingTop, -2);
        int i9 = size - paddingLeft;
        int i10 = this.j;
        int i11 = i9 / i10;
        int i12 = i9 % i10;
        if (i11 == 0) {
            setMeasuredDimension(i9, 0);
            return;
        }
        int i13 = i10 + (i12 / i11);
        int childCount = getChildCount();
        int i14 = 0;
        int i15 = 0;
        boolean z5 = false;
        int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        long j2 = 0;
        while (i15 < childCount) {
            View childAt = getChildAt(i15);
            int i19 = size2;
            if (childAt.getVisibility() != 8) {
                boolean z6 = childAt instanceof ActionMenuItemView;
                int i20 = i16 + 1;
                if (z6) {
                    int i21 = this.k;
                    i8 = i20;
                    z4 = false;
                    childAt.setPadding(i21, 0, i21, 0);
                } else {
                    i8 = i20;
                    z4 = false;
                }
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                layoutParams.f = z4;
                layoutParams.c = z4 ? 1 : 0;
                layoutParams.b = z4;
                layoutParams.d = z4;
                layoutParams.leftMargin = z4;
                layoutParams.rightMargin = z4;
                layoutParams.e = z6 && ((ActionMenuItemView) childAt).hasText();
                int measureChildForCells = measureChildForCells(childAt, i13, layoutParams.f262a ? 1 : i11, childMeasureSpec, paddingTop);
                i17 = Math.max(i17, measureChildForCells);
                if (layoutParams.d) {
                    i18++;
                }
                if (layoutParams.f262a) {
                    z5 = true;
                }
                i11 -= measureChildForCells;
                i14 = Math.max(i14, childAt.getMeasuredHeight());
                if (measureChildForCells == 1) {
                    j2 |= (long) (1 << i15);
                    i14 = i14;
                } else {
                    int i22 = i14;
                }
                i16 = i8;
            }
            i15++;
            size2 = i19;
        }
        int i23 = size2;
        boolean z7 = z5 && i16 == 2;
        boolean z8 = false;
        while (true) {
            if (i18 <= 0 || i11 <= 0) {
                i6 = mode;
                i4 = i9;
                z = z8;
                i5 = i14;
            } else {
                int i24 = Integer.MAX_VALUE;
                int i25 = 0;
                int i26 = 0;
                long j3 = 0;
                while (i26 < childCount) {
                    boolean z9 = z8;
                    LayoutParams layoutParams2 = (LayoutParams) getChildAt(i26).getLayoutParams();
                    int i27 = i14;
                    if (layoutParams2.d) {
                        int i28 = layoutParams2.b;
                        if (i28 < i24) {
                            j3 = 1 << i26;
                            i24 = i28;
                            i25 = 1;
                        } else if (i28 == i24) {
                            i25++;
                            j3 |= 1 << i26;
                        }
                    }
                    i26++;
                    i14 = i27;
                    z8 = z9;
                }
                z = z8;
                i5 = i14;
                j2 |= j3;
                if (i25 > i11) {
                    i6 = mode;
                    i4 = i9;
                    break;
                }
                int i29 = i24 + 1;
                int i30 = 0;
                while (i30 < childCount) {
                    View childAt2 = getChildAt(i30);
                    LayoutParams layoutParams3 = (LayoutParams) childAt2.getLayoutParams();
                    int i31 = i9;
                    int i32 = mode;
                    long j4 = (long) (1 << i30);
                    if ((j3 & j4) == 0) {
                        if (layoutParams3.b == i29) {
                            j2 |= j4;
                        }
                        z3 = z7;
                    } else {
                        if (!z7 || !layoutParams3.e || i11 != 1) {
                            z3 = z7;
                        } else {
                            int i33 = this.k;
                            z3 = z7;
                            childAt2.setPadding(i33 + i13, 0, i33, 0);
                        }
                        layoutParams3.b++;
                        layoutParams3.f = true;
                        i11--;
                    }
                    i30++;
                    mode = i32;
                    i9 = i31;
                    z7 = z3;
                }
                i14 = i5;
                z8 = true;
            }
        }
        boolean z10 = !z5 && i16 == 1;
        if (i11 <= 0 || j2 == 0 || (i11 >= i16 - 1 && !z10 && i17 <= 1)) {
            i7 = 0;
            z2 = z;
        } else {
            float bitCount = (float) Long.bitCount(j2);
            if (!z10) {
                i7 = 0;
                if ((j2 & 1) != 0 && !((LayoutParams) getChildAt(0).getLayoutParams()).e) {
                    bitCount -= 0.5f;
                }
                int i34 = childCount - 1;
                if ((j2 & ((long) (1 << i34))) != 0 && !((LayoutParams) getChildAt(i34).getLayoutParams()).e) {
                    bitCount -= 0.5f;
                }
            } else {
                i7 = 0;
            }
            int i35 = bitCount > 0.0f ? (int) (((float) (i11 * i13)) / bitCount) : i7;
            z2 = z;
            for (int i36 = i7; i36 < childCount; i36++) {
                if ((j2 & ((long) (1 << i36))) != 0) {
                    View childAt3 = getChildAt(i36);
                    LayoutParams layoutParams4 = (LayoutParams) childAt3.getLayoutParams();
                    if (childAt3 instanceof ActionMenuItemView) {
                        layoutParams4.c = i35;
                        layoutParams4.f = true;
                        if (i36 == 0 && !layoutParams4.e) {
                            layoutParams4.leftMargin = (-i35) / 2;
                        }
                        z2 = true;
                    } else if (layoutParams4.f262a) {
                        layoutParams4.c = i35;
                        layoutParams4.f = true;
                        layoutParams4.rightMargin = (-i35) / 2;
                        z2 = true;
                    } else {
                        if (i36 != 0) {
                            layoutParams4.leftMargin = i35 / 2;
                        }
                        if (i36 != childCount - 1) {
                            layoutParams4.rightMargin = i35 / 2;
                        }
                    }
                }
            }
        }
        if (z2) {
            for (int i37 = i7; i37 < childCount; i37++) {
                View childAt4 = getChildAt(i37);
                LayoutParams layoutParams5 = (LayoutParams) childAt4.getLayoutParams();
                if (layoutParams5.f) {
                    childAt4.measure(View.MeasureSpec.makeMeasureSpec((layoutParams5.b * i13) + layoutParams5.c, 1073741824), childMeasureSpec);
                }
            }
        }
        setMeasuredDimension(i4, i6 != 1073741824 ? i5 : i23);
    }

    @RestrictTo
    public void setExpandedActionViewsExclusive(boolean z) {
        this.e.y(z);
    }

    public void setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        this.l = onMenuItemClickListener;
    }

    public void setOverflowIcon(@Nullable Drawable drawable) {
        getMenu();
        this.e.A(drawable);
    }

    @RestrictTo
    public void setOverflowReserved(boolean z) {
        this.d = z;
    }

    public void setPopupTheme(@StyleRes int i2) {
        if (this.c != i2) {
            this.c = i2;
            if (i2 == 0) {
                this.b = getContext();
            } else {
                this.b = new ContextThemeWrapper(getContext(), i2);
            }
        }
    }

    @RestrictTo
    public void setPresenter(ActionMenuPresenter actionMenuPresenter) {
        this.e = actionMenuPresenter;
        actionMenuPresenter.z(this);
    }

    public boolean showOverflowMenu() {
        ActionMenuPresenter actionMenuPresenter = this.e;
        return actionMenuPresenter != null && actionMenuPresenter.C();
    }

    public ActionMenuView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        setBaselineAligned(false);
        float f2 = context.getResources().getDisplayMetrics().density;
        this.j = (int) (56.0f * f2);
        this.k = (int) (f2 * 4.0f);
        this.b = context;
        this.c = 0;
    }
}
