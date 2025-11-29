package flyme.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;
import androidx.appcompat.widget.LinearLayoutCompat;
import flyme.support.v7.appcompat.R;
import flyme.support.v7.view.ActionBarPolicy;
import flyme.support.v7.view.menu.ActionMenuItemView;
import flyme.support.v7.view.menu.MenuBuilder;
import flyme.support.v7.view.menu.MenuItemImpl;
import flyme.support.v7.view.menu.MenuPresenter;
import flyme.support.v7.view.menu.MenuView;

public class ActionMenuView extends LinearLayoutCompat implements MenuBuilder.ItemInvoker, MenuView {
    static final int GENERATED_ITEM_PADDING = 4;
    static final int MIN_CELL_SIZE = 56;
    static final int MIN_CELL_SIZE_IN_SPLIT = 60;
    public static final int MIN_DELEGATE_WIDTH = 52;
    private static final String TAG = "ActionMenuView";
    private MenuPresenter.Callback mActionMenuPresenterCallback;
    private boolean mFormatItems;
    private int mFormatItemsWidth;
    private int mGeneratedItemPadding;
    private boolean mHasOverflow;
    private MenuBuilder mMenu;
    /* access modifiers changed from: private */
    public MenuBuilder.Callback mMenuBuilderCallback;
    private int mMinCellSize;
    /* access modifiers changed from: private */
    public OnMenuItemClickListener mOnMenuItemClickListener;
    private Context mPopupContext;
    private int mPopupTheme;
    private ActionMenuPresenter mPresenter;
    private boolean mReserveOverflow;

    public interface ActionMenuChildView {
        boolean needsDividerAfter();

        boolean needsDividerBefore();
    }

    public class ActionMenuPresenterCallback implements MenuPresenter.Callback {
        private ActionMenuPresenterCallback() {
        }

        public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
        }

        public boolean onOpenSubMenu(MenuBuilder menuBuilder) {
            return false;
        }
    }

    public static class LayoutParams extends LinearLayoutCompat.LayoutParams {
        @ViewDebug.ExportedProperty
        public int cellsUsed;
        @ViewDebug.ExportedProperty
        public boolean expandable;
        boolean expanded;
        @ViewDebug.ExportedProperty
        public int extraPixels;
        @ViewDebug.ExportedProperty
        public boolean isOverflowButton;
        @ViewDebug.ExportedProperty
        public boolean preventEdgeOffset;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(LayoutParams layoutParams) {
            super(layoutParams);
            this.isOverflowButton = layoutParams.isOverflowButton;
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.isOverflowButton = false;
        }

        public LayoutParams(int i, int i2, boolean z) {
            super(i, i2);
            this.isOverflowButton = z;
        }
    }

    public class MenuBuilderCallback implements MenuBuilder.Callback {
        private MenuBuilderCallback() {
        }

        public boolean onMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem) {
            return ActionMenuView.this.mOnMenuItemClickListener != null && ActionMenuView.this.mOnMenuItemClickListener.onMenuItemClick(menuItem);
        }

        public void onMenuModeChange(MenuBuilder menuBuilder) {
            if (ActionMenuView.this.mMenuBuilderCallback != null) {
                ActionMenuView.this.mMenuBuilderCallback.onMenuModeChange(menuBuilder);
            }
        }
    }

    public interface OnMenuItemClickListener {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    public ActionMenuView(Context context) {
        this(context, (AttributeSet) null);
    }

    private void applyFlymeStyle(LayoutParams layoutParams, int i, int i2) {
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.mz_action_overflow_btn_margin_right);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.mz_action_menu_item_last_margin_right);
        int dimensionPixelSize3 = getResources().getDimensionPixelSize(R.dimen.mz_action_menu_item_next_overflow_margin_right);
        int dimensionPixelSize4 = getResources().getDimensionPixelSize(R.dimen.mz_action_menu_item_margin_right);
        if (layoutParams.isOverflowButton) {
            layoutParams.setMarginEnd(dimensionPixelSize);
            layoutParams.resolveLayoutDirection(getLayoutDirection());
            return;
        }
        boolean z = this.mHasOverflow;
        if (z && i == i2 - 2) {
            dimensionPixelSize2 = dimensionPixelSize3;
        } else if (z || i != i2 - 1) {
            dimensionPixelSize2 = dimensionPixelSize4;
        }
        layoutParams.setMarginEnd(dimensionPixelSize2);
        layoutParams.resolveLayoutDirection(getLayoutDirection());
    }

    private int getExtraPadding() {
        for (int i = 0; i < getChildCount(); i++) {
            if ((getChildAt(i) instanceof ActionMenuItemView) && ((ActionMenuItemView) getChildAt(i)).getItemData().getIcon() != null) {
                return ActionBarPolicy.get(getContext()).getSplitActionBarPadding();
            }
        }
        return 0;
    }

    public static int measureChildForCells(View view, int i, int i2, int i3, int i4) {
        int i5;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i3) - i4, View.MeasureSpec.getMode(i3));
        ActionMenuItemView actionMenuItemView = view instanceof ActionMenuItemView ? (ActionMenuItemView) view : null;
        boolean z = false;
        boolean z2 = actionMenuItemView != null && actionMenuItemView.hasText();
        if (i2 > 0) {
            i5 = 2;
            if (!z2 || i2 >= 2) {
                view.measure(View.MeasureSpec.makeMeasureSpec(i2 * i, Integer.MIN_VALUE), makeMeasureSpec);
                int measuredWidth = view.getMeasuredWidth();
                int i6 = measuredWidth / i;
                if (measuredWidth % i != 0) {
                    i6++;
                }
                if (!z2 || i6 >= 2) {
                    i5 = i6;
                }
                if (!layoutParams.isOverflowButton && z2) {
                    z = true;
                }
                layoutParams.expandable = z;
                layoutParams.cellsUsed = i5;
                view.measure(View.MeasureSpec.makeMeasureSpec(i * i5, 1073741824), makeMeasureSpec);
                return i5;
            }
        }
        i5 = 0;
        z = true;
        layoutParams.expandable = z;
        layoutParams.cellsUsed = i5;
        view.measure(View.MeasureSpec.makeMeasureSpec(i * i5, 1073741824), makeMeasureSpec);
        return i5;
    }

    public static int measureChildForCellsInSplit(View view, int i, int i2, int i3) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i2) - i3, View.MeasureSpec.getMode(i2));
        ((LayoutParams) view.getLayoutParams()).cellsUsed = 1;
        view.measure(View.MeasureSpec.makeMeasureSpec(i, 1073741824), makeMeasureSpec);
        return 1;
    }

    private void onMeasureExactFormat(int i, int i2) {
        int i3;
        int i4;
        int i5;
        boolean z;
        int i6;
        int i7;
        boolean z2;
        int i8;
        int i9;
        boolean z3;
        if (this.mPresenter.isSplit()) {
            onMeasureExactFormatInSplit(i, i2);
            return;
        }
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i2, paddingTop, -2);
        int i10 = size - paddingLeft;
        int i11 = this.mMinCellSize;
        int i12 = i10 / i11;
        int i13 = i10 % i11;
        if (i12 == 0) {
            setMeasuredDimension(i10, 0);
            return;
        }
        int i14 = i11 + (i13 / i12);
        int childCount = getChildCount();
        int i15 = 0;
        int i16 = 0;
        boolean z4 = false;
        int i17 = 0;
        int i18 = 0;
        int i19 = 0;
        long j = 0;
        while (i16 < childCount) {
            View childAt = getChildAt(i16);
            int i20 = size2;
            if (childAt.getVisibility() != 8) {
                boolean z5 = childAt instanceof ActionMenuItemView;
                int i21 = i17 + 1;
                if (z5) {
                    int i22 = this.mGeneratedItemPadding;
                    i9 = i21;
                    z3 = false;
                    childAt.setPadding(i22, 0, i22, 0);
                } else {
                    i9 = i21;
                    z3 = false;
                }
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                layoutParams.expanded = z3;
                layoutParams.extraPixels = z3 ? 1 : 0;
                layoutParams.cellsUsed = z3;
                layoutParams.expandable = z3;
                layoutParams.leftMargin = z3;
                layoutParams.rightMargin = z3;
                layoutParams.preventEdgeOffset = z5 && ((ActionMenuItemView) childAt).hasText();
                int measureChildForCells = measureChildForCells(childAt, i14, layoutParams.isOverflowButton ? 1 : i12, childMeasureSpec, paddingTop);
                i18 = Math.max(i18, measureChildForCells);
                if (layoutParams.expandable) {
                    i19++;
                }
                if (layoutParams.isOverflowButton) {
                    z4 = true;
                }
                i12 -= measureChildForCells;
                i15 = Math.max(i15, childAt.getMeasuredHeight());
                if (measureChildForCells == 1) {
                    j |= (long) (1 << i16);
                    i15 = i15;
                } else {
                    int i23 = i15;
                }
                i17 = i9;
            }
            i16++;
            size2 = i20;
        }
        int i24 = size2;
        boolean z6 = z4 && i17 == 2;
        boolean z7 = false;
        while (true) {
            if (i19 <= 0 || i12 <= 0) {
                i3 = mode;
                i4 = i10;
                i5 = childMeasureSpec;
                z = z7;
                i6 = i15;
            } else {
                z = z7;
                i6 = i15;
                int i25 = Integer.MAX_VALUE;
                int i26 = 0;
                int i27 = 0;
                long j2 = 0;
                while (i27 < childCount) {
                    int i28 = i10;
                    LayoutParams layoutParams2 = (LayoutParams) getChildAt(i27).getLayoutParams();
                    int i29 = mode;
                    if (layoutParams2.expandable) {
                        int i30 = layoutParams2.cellsUsed;
                        if (i30 < i25) {
                            j2 = (long) (1 << i27);
                            i26 = 1;
                            i25 = i30;
                        } else if (i30 == i25) {
                            i26++;
                            j2 = ((long) (1 << i27)) | j2;
                        }
                    }
                    i27++;
                    mode = i29;
                    i10 = i28;
                }
                i3 = mode;
                i4 = i10;
                j |= j2;
                if (i26 > i12) {
                    i5 = childMeasureSpec;
                    break;
                }
                int i31 = i25 + 1;
                int i32 = 0;
                while (i32 < childCount) {
                    View childAt2 = getChildAt(i32);
                    LayoutParams layoutParams3 = (LayoutParams) childAt2.getLayoutParams();
                    int i33 = childMeasureSpec;
                    int i34 = i17;
                    int i35 = i18;
                    long j3 = (long) (1 << i32);
                    if ((j2 & j3) != 0) {
                        if (z6 && layoutParams3.preventEdgeOffset && i12 == 1) {
                            int i36 = this.mGeneratedItemPadding;
                            childAt2.setPadding(i36 + i14, 0, i36, 0);
                        }
                        layoutParams3.cellsUsed++;
                        layoutParams3.expanded = true;
                        i12--;
                    } else if (layoutParams3.cellsUsed == i31) {
                        j |= j3;
                    }
                    i32++;
                    i17 = i34;
                    childMeasureSpec = i33;
                    i18 = i35;
                }
                i15 = i6;
                mode = i3;
                i10 = i4;
                z7 = true;
            }
        }
        int i37 = i17;
        int i38 = i18;
        boolean z8 = !z4 && i37 == 1;
        if (i12 <= 0 || j == 0 || (i12 >= i37 - 1 && !z8 && i38 <= 1)) {
            i7 = 0;
            z2 = z;
        } else {
            float bitCount = (float) Long.bitCount(j);
            if (!z8) {
                i7 = 0;
                if ((j & 1) != 0 && !((LayoutParams) getChildAt(0).getLayoutParams()).preventEdgeOffset) {
                    bitCount -= 0.5f;
                }
                int i39 = childCount - 1;
                if ((j & ((long) (1 << i39))) != 0 && !((LayoutParams) getChildAt(i39).getLayoutParams()).preventEdgeOffset) {
                    bitCount -= 0.5f;
                }
            } else {
                i7 = 0;
            }
            int i40 = bitCount > 0.0f ? (int) (((float) (i12 * i14)) / bitCount) : i7;
            z2 = z;
            for (int i41 = i7; i41 < childCount; i41++) {
                if ((j & ((long) (1 << i41))) != 0) {
                    View childAt3 = getChildAt(i41);
                    LayoutParams layoutParams4 = (LayoutParams) childAt3.getLayoutParams();
                    if (childAt3 instanceof ActionMenuItemView) {
                        layoutParams4.extraPixels = i40;
                        layoutParams4.expanded = true;
                        if (i41 == 0 && !layoutParams4.preventEdgeOffset) {
                            layoutParams4.leftMargin = (-i40) / 2;
                        }
                        z2 = true;
                    } else if (layoutParams4.isOverflowButton) {
                        layoutParams4.extraPixels = i40;
                        layoutParams4.expanded = true;
                        layoutParams4.rightMargin = (-i40) / 2;
                        z2 = true;
                    } else {
                        if (i41 != 0) {
                            layoutParams4.leftMargin = i40 / 2;
                        }
                        if (i41 != childCount - 1) {
                            layoutParams4.rightMargin = i40 / 2;
                        }
                    }
                }
            }
        }
        if (z2) {
            int i42 = i7;
            while (i42 < childCount) {
                View childAt4 = getChildAt(i42);
                LayoutParams layoutParams5 = (LayoutParams) childAt4.getLayoutParams();
                if (!layoutParams5.expanded) {
                    i8 = i5;
                } else {
                    i8 = i5;
                    childAt4.measure(View.MeasureSpec.makeMeasureSpec((layoutParams5.cellsUsed * i14) + layoutParams5.extraPixels, 1073741824), i8);
                }
                i42++;
                i5 = i8;
            }
        }
        setMeasuredDimension(i4, i3 != 1073741824 ? i6 : i24);
    }

    private void onMeasureExactFormatInSplit(int i, int i2) {
        int extraPadding = getExtraPadding();
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int paddingLeft = getPaddingLeft() + getPaddingRight() + (extraPadding * 2);
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i2, paddingTop, -2);
        int i3 = size - paddingLeft;
        int childCount = getChildCount();
        if (childCount == 0) {
            setMeasuredDimension(i3, 0);
            return;
        }
        int i4 = i3 / childCount;
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            if (childAt.getVisibility() != 8) {
                boolean z = childAt instanceof ActionMenuItemView;
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                layoutParams.expanded = false;
                layoutParams.extraPixels = 0;
                layoutParams.cellsUsed = 0;
                layoutParams.expandable = false;
                layoutParams.leftMargin = 0;
                layoutParams.rightMargin = 0;
                layoutParams.preventEdgeOffset = z && ((ActionMenuItemView) childAt).hasText();
                i6 = Math.max(i6, measureChildForCellsInSplit(childAt, i4, childMeasureSpec, paddingTop));
                i5 = Math.max(i5, childAt.getMeasuredHeight());
            }
        }
        if (mode != 1073741824) {
            size2 = i5;
        }
        setMeasuredDimension(View.MeasureSpec.getSize(i), size2);
    }

    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams != null && (layoutParams instanceof LayoutParams);
    }

    public void dismissPopupMenus() {
        ActionMenuPresenter actionMenuPresenter = this.mPresenter;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.dismissPopupMenus();
        }
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return false;
    }

    public LayoutParams generateOverflowButtonLayoutParams() {
        LayoutParams generateDefaultLayoutParams = generateDefaultLayoutParams();
        generateDefaultLayoutParams.isOverflowButton = true;
        return generateDefaultLayoutParams;
    }

    public Menu getMenu() {
        if (this.mMenu == null) {
            Context context = getContext();
            MenuBuilder menuBuilder = new MenuBuilder(context);
            this.mMenu = menuBuilder;
            menuBuilder.setCallback(new MenuBuilderCallback());
            ActionMenuPresenter actionMenuPresenter = new ActionMenuPresenter(context);
            this.mPresenter = actionMenuPresenter;
            actionMenuPresenter.setReserveOverflow(true);
            ActionMenuPresenter actionMenuPresenter2 = this.mPresenter;
            MenuPresenter.Callback callback = this.mActionMenuPresenterCallback;
            if (callback == null) {
                callback = new ActionMenuPresenterCallback();
            }
            actionMenuPresenter2.setCallback(callback);
            this.mMenu.addMenuPresenter(this.mPresenter, this.mPopupContext);
            this.mPresenter.setMenuView(this);
        }
        return this.mMenu;
    }

    @Nullable
    public Drawable getOverflowIcon() {
        getMenu();
        return this.mPresenter.getOverflowIcon();
    }

    public int getPopupTheme() {
        return this.mPopupTheme;
    }

    public int getWindowAnimations() {
        return 0;
    }

    public boolean hasSupportDividerBeforeChildAt(int i) {
        boolean z = false;
        if (i == 0) {
            return false;
        }
        View childAt = getChildAt(i - 1);
        View childAt2 = getChildAt(i);
        if (i < getChildCount() && (childAt instanceof ActionMenuChildView)) {
            z = ((ActionMenuChildView) childAt).needsDividerAfter();
        }
        return (i <= 0 || !(childAt2 instanceof ActionMenuChildView)) ? z : z | ((ActionMenuChildView) childAt2).needsDividerBefore();
    }

    public boolean hideOverflowMenu() {
        ActionMenuPresenter actionMenuPresenter = this.mPresenter;
        return actionMenuPresenter != null && actionMenuPresenter.hideOverflowMenu();
    }

    public void initialize(MenuBuilder menuBuilder) {
        this.mMenu = menuBuilder;
    }

    public boolean invokeItem(MenuItemImpl menuItemImpl) {
        return this.mMenu.performItemAction(menuItemImpl, 0);
    }

    public boolean isOverflowMenuShowPending() {
        ActionMenuPresenter actionMenuPresenter = this.mPresenter;
        return actionMenuPresenter != null && actionMenuPresenter.isOverflowMenuShowPending();
    }

    public boolean isOverflowMenuShowing() {
        ActionMenuPresenter actionMenuPresenter = this.mPresenter;
        return actionMenuPresenter != null && actionMenuPresenter.isOverflowMenuShowing();
    }

    public boolean isOverflowReserved() {
        return this.mReserveOverflow;
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        ActionMenuPresenter actionMenuPresenter = this.mPresenter;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.updateMenuView(false);
            if (this.mPresenter.isOverflowMenuShowing()) {
                this.mPresenter.hideOverflowMenu();
                this.mPresenter.showOverflowMenu();
            }
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        dismissPopupMenus();
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        int i9 = i;
        int i10 = i2;
        int i11 = i3;
        int i12 = i4;
        if (!this.mFormatItems) {
            super.onLayout(z, i, i2, i3, i4);
        } else if (this.mPresenter.isSplit()) {
            onLayoutInSplit(i9, i10, i11, i12);
        } else {
            int childCount = getChildCount();
            int i13 = (i12 - i10) / 2;
            int dividerWidth = getDividerWidth();
            int i14 = i11 - i9;
            int paddingRight = (i14 - getPaddingRight()) - getPaddingLeft();
            boolean isLayoutRtl = ViewUtils.isLayoutRtl(this);
            int i15 = 0;
            int i16 = 0;
            for (int i17 = 0; i17 < childCount; i17++) {
                View childAt = getChildAt(i17);
                if (childAt.getVisibility() != 8) {
                    LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                    if (layoutParams.isOverflowButton) {
                        int measuredWidth = childAt.getMeasuredWidth();
                        if (hasSupportDividerBeforeChildAt(i17)) {
                            measuredWidth += dividerWidth;
                        }
                        int measuredHeight = childAt.getMeasuredHeight();
                        if (isLayoutRtl) {
                            i7 = getPaddingLeft() + layoutParams.leftMargin;
                            i8 = i7 + measuredWidth;
                        } else {
                            i8 = (getWidth() - getPaddingRight()) - layoutParams.rightMargin;
                            i7 = i8 - measuredWidth;
                        }
                        int i18 = i13 - (measuredHeight / 2);
                        childAt.layout(i7, i18, i8, measuredHeight + i18);
                        paddingRight -= measuredWidth;
                        i15 = 1;
                    } else {
                        paddingRight -= (childAt.getMeasuredWidth() + layoutParams.leftMargin) + layoutParams.rightMargin;
                        hasSupportDividerBeforeChildAt(i17);
                        i16++;
                    }
                }
            }
            if (childCount == 1 && i15 == 0) {
                View childAt2 = getChildAt(0);
                int measuredWidth2 = childAt2.getMeasuredWidth();
                int measuredHeight2 = childAt2.getMeasuredHeight();
                int i19 = (i14 / 2) - (measuredWidth2 / 2);
                int i20 = i13 - (measuredHeight2 / 2);
                childAt2.layout(i19, i20, measuredWidth2 + i19, measuredHeight2 + i20);
                return;
            }
            int i21 = i16 - (i15 ^ 1);
            if (i21 > 0) {
                i5 = paddingRight / i21;
                i6 = 0;
            } else {
                i6 = 0;
                i5 = 0;
            }
            int max = Math.max(i6, i5);
            if (isLayoutRtl) {
                int width = getWidth() - getPaddingRight();
                for (int i22 = i6; i22 < childCount; i22++) {
                    View childAt3 = getChildAt(i22);
                    LayoutParams layoutParams2 = (LayoutParams) childAt3.getLayoutParams();
                    if (childAt3.getVisibility() != 8 && !layoutParams2.isOverflowButton) {
                        int i23 = width - layoutParams2.rightMargin;
                        int measuredWidth3 = childAt3.getMeasuredWidth();
                        int measuredHeight3 = childAt3.getMeasuredHeight();
                        int i24 = i13 - (measuredHeight3 / 2);
                        childAt3.layout(i23 - measuredWidth3, i24, i23, measuredHeight3 + i24);
                        width = i23 - ((measuredWidth3 + layoutParams2.leftMargin) + max);
                    }
                }
                return;
            }
            int paddingLeft = getPaddingLeft();
            for (int i25 = i6; i25 < childCount; i25++) {
                View childAt4 = getChildAt(i25);
                LayoutParams layoutParams3 = (LayoutParams) childAt4.getLayoutParams();
                if (childAt4.getVisibility() != 8 && !layoutParams3.isOverflowButton) {
                    int i26 = paddingLeft + layoutParams3.leftMargin;
                    int measuredWidth4 = childAt4.getMeasuredWidth();
                    int measuredHeight4 = childAt4.getMeasuredHeight();
                    int i27 = i13 - (measuredHeight4 / 2);
                    childAt4.layout(i26, i27, i26 + measuredWidth4, measuredHeight4 + i27);
                    paddingLeft = i26 + measuredWidth4 + layoutParams3.rightMargin + max;
                }
            }
        }
    }

    public void onLayoutInSplit(int i, int i2, int i3, int i4) {
        int i5;
        int width;
        int i6;
        int extraPadding = getExtraPadding();
        int childCount = getChildCount();
        int i7 = (i4 - i2) / 2;
        int dividerWidth = getDividerWidth();
        int i8 = i3 - i;
        int paddingRight = ((i8 - getPaddingRight()) - getPaddingLeft()) - (extraPadding * 2);
        boolean isLayoutRtl = ViewUtils.isLayoutRtl(this);
        int i9 = 0;
        int i10 = 0;
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.isOverflowButton) {
                    int measuredWidth = childAt.getMeasuredWidth();
                    if (hasSupportDividerBeforeChildAt(i11)) {
                        measuredWidth += dividerWidth;
                    }
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (isLayoutRtl) {
                        i6 = extraPadding + getPaddingLeft() + layoutParams.leftMargin;
                        width = i6 + measuredWidth;
                    } else {
                        width = ((getWidth() - extraPadding) - getPaddingRight()) - layoutParams.rightMargin;
                        i6 = width - measuredWidth;
                    }
                    int i12 = i7 - (measuredHeight / 2);
                    childAt.layout(i6, i12, width, measuredHeight + i12);
                    paddingRight -= measuredWidth;
                    i9 = 1;
                } else {
                    paddingRight -= (childAt.getMeasuredWidth() + layoutParams.leftMargin) + layoutParams.rightMargin;
                    hasSupportDividerBeforeChildAt(i11);
                    i10++;
                }
            }
        }
        if (childCount != 1) {
            i5 = 1;
        } else if (i9 == 0) {
            View childAt2 = getChildAt(0);
            int measuredWidth2 = childAt2.getMeasuredWidth();
            int measuredHeight2 = childAt2.getMeasuredHeight();
            int i13 = (i8 / 2) - (measuredWidth2 / 2);
            int i14 = i7 - (measuredHeight2 / 2);
            childAt2.layout(i13, i14, measuredWidth2 + i13, measuredHeight2 + i14);
            return;
        } else {
            i5 = 1;
        }
        int i15 = i10 - (i5 ^ i9);
        int max = Math.max(0, i15 > 0 ? paddingRight / i15 : 0);
        if (isLayoutRtl) {
            int width2 = (getWidth() - getPaddingRight()) - extraPadding;
            for (int i16 = 0; i16 < childCount; i16++) {
                View childAt3 = getChildAt(i16);
                LayoutParams layoutParams2 = (LayoutParams) childAt3.getLayoutParams();
                if (childAt3.getVisibility() != 8 && !layoutParams2.isOverflowButton) {
                    int i17 = width2 - layoutParams2.rightMargin;
                    int measuredWidth3 = childAt3.getMeasuredWidth();
                    int measuredHeight3 = childAt3.getMeasuredHeight();
                    int i18 = i7 - (measuredHeight3 / 2);
                    childAt3.layout(i17 - measuredWidth3, i18, i17, measuredHeight3 + i18);
                    width2 = i17 - ((measuredWidth3 + layoutParams2.leftMargin) + max);
                }
            }
            return;
        }
        int paddingLeft = getPaddingLeft() + extraPadding;
        for (int i19 = 0; i19 < childCount; i19++) {
            View childAt4 = getChildAt(i19);
            LayoutParams layoutParams3 = (LayoutParams) childAt4.getLayoutParams();
            if (childAt4.getVisibility() != 8 && !layoutParams3.isOverflowButton) {
                int i20 = paddingLeft + layoutParams3.leftMargin;
                int measuredWidth4 = childAt4.getMeasuredWidth();
                int measuredHeight4 = childAt4.getMeasuredHeight();
                int i21 = i7 - (measuredHeight4 / 2);
                childAt4.layout(i20, i21, i20 + measuredWidth4, measuredHeight4 + i21);
                paddingLeft = i20 + measuredWidth4 + layoutParams3.rightMargin + max;
            }
        }
    }

    public void onMeasure(int i, int i2) {
        MenuBuilder menuBuilder;
        boolean z = this.mFormatItems;
        boolean z2 = View.MeasureSpec.getMode(i) == 1073741824;
        this.mFormatItems = z2;
        if (z != z2) {
            this.mFormatItemsWidth = 0;
        }
        int size = View.MeasureSpec.getSize(i);
        if (!(!this.mFormatItems || (menuBuilder = this.mMenu) == null || size == this.mFormatItemsWidth)) {
            this.mFormatItemsWidth = size;
            menuBuilder.onItemsChanged(true);
        }
        int childCount = getChildCount();
        if (!this.mFormatItems || childCount <= 0) {
            for (int i3 = 0; i3 < childCount; i3++) {
                LayoutParams layoutParams = (LayoutParams) getChildAt(i3).getLayoutParams();
                layoutParams.rightMargin = 0;
                layoutParams.leftMargin = 0;
                applyFlymeStyle(layoutParams, i3, childCount);
            }
            super.onMeasure(i, i2);
            return;
        }
        onMeasureExactFormat(i, i2);
    }

    public MenuBuilder peekMenu() {
        return this.mMenu;
    }

    public void setBottonBarStyleDivider() {
        setButtonBarStyleDivider();
    }

    public void setButtonBarStyleDivider() {
        setShowDividers(2);
        setDividerDrawable(getResources().getDrawable(R.drawable.mz_button_bar_style_divider));
        setDividerPadding(getResources().getDimensionPixelSize(R.dimen.mz_button_bar_style_divider_padding));
    }

    public void setExpandedActionViewsExclusive(boolean z) {
        this.mPresenter.setExpandedActionViewsExclusive(z);
    }

    public void setHasOverflow(boolean z) {
        this.mHasOverflow = z;
    }

    public void setMenuCallbacks(MenuPresenter.Callback callback, MenuBuilder.Callback callback2) {
        this.mActionMenuPresenterCallback = callback;
        this.mMenuBuilderCallback = callback2;
    }

    public void setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        this.mOnMenuItemClickListener = onMenuItemClickListener;
    }

    public void setOverflowDrawable(Drawable drawable) {
        ActionMenuPresenter actionMenuPresenter = this.mPresenter;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.setOverflowDrawable(drawable);
        }
    }

    public void setOverflowIcon(@Nullable Drawable drawable) {
        getMenu();
        this.mPresenter.setOverflowIcon(drawable);
    }

    public void setOverflowReserved(boolean z) {
        this.mReserveOverflow = z;
    }

    public void setPopupTheme(@StyleRes int i) {
        if (this.mPopupTheme != i) {
            this.mPopupTheme = i;
            if (i == 0) {
                this.mPopupContext = getContext();
            } else {
                this.mPopupContext = new ContextThemeWrapper(getContext(), i);
            }
        }
    }

    public void setPresenter(ActionMenuPresenter actionMenuPresenter) {
        this.mPresenter = actionMenuPresenter;
        actionMenuPresenter.setMenuView(this);
    }

    public boolean showOverflowMenu() {
        ActionMenuPresenter actionMenuPresenter = this.mPresenter;
        return actionMenuPresenter != null && actionMenuPresenter.showOverflowMenu();
    }

    public ActionMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBaselineAligned(false);
        float f = context.getResources().getDisplayMetrics().density;
        this.mMinCellSize = (int) (56.0f * f);
        this.mGeneratedItemPadding = (int) (f * 4.0f);
        this.mPopupContext = context;
        this.mPopupTheme = 0;
        setMotionEventSplittingEnabled(false);
    }

    public LayoutParams generateDefaultLayoutParams() {
        LayoutParams layoutParams = new LayoutParams(-2, -2);
        layoutParams.gravity = 16;
        return layoutParams;
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        LayoutParams layoutParams2;
        if (layoutParams == null) {
            return generateDefaultLayoutParams();
        }
        if (layoutParams instanceof LayoutParams) {
            layoutParams2 = new LayoutParams((LayoutParams) layoutParams);
        } else {
            layoutParams2 = new LayoutParams(layoutParams);
        }
        if (layoutParams2.gravity <= 0) {
            layoutParams2.gravity = 16;
        }
        return layoutParams2;
    }
}
