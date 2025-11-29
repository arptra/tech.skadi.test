package flyme.support.v7.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.MenuRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.appcompat.view.CollapsibleActionView;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.GravityCompat;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.MenuItemCompat;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListener;
import com.meizu.common.util.CommonUtils;
import com.meizu.common.util.ResourceUtils;
import flyme.support.v7.app.ActionBar;
import flyme.support.v7.appcompat.R;
import flyme.support.v7.view.SupportMenuInflater;
import flyme.support.v7.view.menu.MenuBuilder;
import flyme.support.v7.view.menu.MenuItemImpl;
import flyme.support.v7.view.menu.MenuPresenter;
import flyme.support.v7.view.menu.MenuView;
import flyme.support.v7.view.menu.SubMenuBuilder;
import flyme.support.v7.widget.ActionMenuView;
import java.util.ArrayList;
import java.util.List;

@SuppressLint({"RestrictedApi"})
public class Toolbar extends ViewGroup {
    private static final String TAG = "Toolbar";
    private MenuPresenter.Callback mActionMenuPresenterCallback;
    private ActionMenuView mBottomMenuView;
    /* access modifiers changed from: private */
    public int mButtonGravity;
    /* access modifiers changed from: private */
    public ImageButton mCollapseButtonView;
    private CharSequence mCollapseDescription;
    private Drawable mCollapseIcon;
    private boolean mCollapsible;
    private final RtlSpacingHelper mContentInsets;
    private final AppCompatDrawableManager mDrawableManager;
    private boolean mEatingHover;
    private boolean mEatingTouch;
    View mExpandedActionView;
    private ExpandedActionViewMenuPresenter mExpandedMenuPresenter;
    private int mGravity;
    private final ArrayList<View> mHiddenViews;
    private ImageView mLogoView;
    private int mMaxButtonHeight;
    private MenuBuilder.Callback mMenuBuilderCallback;
    /* access modifiers changed from: private */
    public ActionMenuView mMenuView;
    private final ActionMenuView.OnMenuItemClickListener mMenuViewItemClickListener;
    protected ViewPropertyAnimatorCompat mMenuViewVisibilityAnim;
    private ImageButton mNavButtonView;
    /* access modifiers changed from: private */
    public OnMenuItemClickListener mOnMenuItemClickListener;
    private ActionMenuPresenter mOuterActionMenuPresenter;
    private Context mPopupContext;
    private int mPopupTheme;
    private boolean mShowBottomMenu;
    private final Runnable mShowOverflowMenuRunnable;
    protected boolean mSplitActionBar;
    private View mSplitBarCustomView;
    protected ViewGroup mSplitView;
    protected boolean mSplitWhenNarrow;
    private CharSequence mSubtitleText;
    private int mSubtitleTextAppearance;
    private int mSubtitleTextColor;
    private TextView mSubtitleTextView;
    private final int[] mTempMargins;
    private final ArrayList<View> mTempViews;
    private int mTitleMarginBottom;
    private int mTitleMarginEnd;
    private int mTitleMarginStart;
    private int mTitleMarginStartBack;
    private int mTitleMarginStartStyled;
    private int mTitleMarginTop;
    private HorizontalScrollView mTitleScrollView;
    private CharSequence mTitleText;
    private int mTitleTextAppearance;
    private int mTitleTextAppearanceBack;
    private int mTitleTextColor;
    private TextView mTitleTextView;
    protected final VisibilityAnimListener mVisAnimListener;
    private ToolbarWidgetWrapper mWrapper;

    public class ExpandedActionViewMenuPresenter implements MenuPresenter {
        MenuItemImpl mCurrentExpandedItem;
        MenuBuilder mMenu;

        private ExpandedActionViewMenuPresenter() {
        }

        public boolean collapseItemActionView(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
            View view = Toolbar.this.mExpandedActionView;
            if (view instanceof CollapsibleActionView) {
                ((CollapsibleActionView) view).onActionViewCollapsed();
            }
            Toolbar toolbar = Toolbar.this;
            toolbar.removeView(toolbar.mExpandedActionView);
            Toolbar toolbar2 = Toolbar.this;
            toolbar2.removeView(toolbar2.mCollapseButtonView);
            Toolbar toolbar3 = Toolbar.this;
            toolbar3.mExpandedActionView = null;
            toolbar3.addChildrenForExpandedActionView();
            this.mCurrentExpandedItem = null;
            Toolbar.this.requestLayout();
            menuItemImpl.setActionViewExpanded(false);
            return true;
        }

        public boolean expandItemActionView(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
            Toolbar.this.ensureCollapseButtonView();
            ViewParent parent = Toolbar.this.mCollapseButtonView.getParent();
            Toolbar toolbar = Toolbar.this;
            if (parent != toolbar) {
                toolbar.addView(toolbar.mCollapseButtonView);
            }
            Toolbar.this.mExpandedActionView = menuItemImpl.getActionView();
            this.mCurrentExpandedItem = menuItemImpl;
            ViewParent parent2 = Toolbar.this.mExpandedActionView.getParent();
            Toolbar toolbar2 = Toolbar.this;
            if (parent2 != toolbar2) {
                LayoutParams generateDefaultLayoutParams = toolbar2.generateDefaultLayoutParams();
                generateDefaultLayoutParams.gravity = (Toolbar.this.mButtonGravity & 112) | 8388611;
                generateDefaultLayoutParams.mViewType = 2;
                Toolbar.this.mExpandedActionView.setLayoutParams(generateDefaultLayoutParams);
                Toolbar toolbar3 = Toolbar.this;
                toolbar3.addView(toolbar3.mExpandedActionView);
            }
            Toolbar.this.removeChildrenForExpandedActionView();
            Toolbar.this.requestLayout();
            menuItemImpl.setActionViewExpanded(true);
            View view = Toolbar.this.mExpandedActionView;
            if (view instanceof CollapsibleActionView) {
                ((CollapsibleActionView) view).onActionViewExpanded();
            }
            return true;
        }

        public boolean flagActionItems() {
            return false;
        }

        public int getId() {
            return 0;
        }

        public MenuView getMenuView(ViewGroup viewGroup) {
            return null;
        }

        public void initForMenu(Context context, MenuBuilder menuBuilder) {
            MenuItemImpl menuItemImpl;
            MenuBuilder menuBuilder2 = this.mMenu;
            if (!(menuBuilder2 == null || (menuItemImpl = this.mCurrentExpandedItem) == null)) {
                menuBuilder2.collapseItemActionView(menuItemImpl);
            }
            this.mMenu = menuBuilder;
        }

        public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
        }

        public void onRestoreInstanceState(Parcelable parcelable) {
        }

        public Parcelable onSaveInstanceState() {
            return null;
        }

        public boolean onSubMenuSelected(SubMenuBuilder subMenuBuilder) {
            return false;
        }

        public void setCallback(MenuPresenter.Callback callback) {
        }

        public void updateMenuView(boolean z) {
            if (this.mCurrentExpandedItem != null) {
                MenuBuilder menuBuilder = this.mMenu;
                if (menuBuilder != null) {
                    int size = menuBuilder.size();
                    int i = 0;
                    while (i < size) {
                        if (this.mMenu.getItem(i) != this.mCurrentExpandedItem) {
                            i++;
                        } else {
                            return;
                        }
                    }
                }
                collapseItemActionView(this.mMenu, this.mCurrentExpandedItem);
            }
        }
    }

    public interface OnMenuItemClickListener {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    public class VisibilityAnimListener implements ViewPropertyAnimatorListener {
        private boolean mCanceled = false;
        int mFinalVisibility;

        public VisibilityAnimListener() {
        }

        public void onAnimationCancel(View view) {
            this.mCanceled = true;
        }

        public void onAnimationEnd(View view) {
            if (!this.mCanceled) {
                Toolbar toolbar = Toolbar.this;
                toolbar.mMenuViewVisibilityAnim = null;
                if (toolbar.mMenuView != null) {
                    Toolbar.this.mMenuView.setVisibility(this.mFinalVisibility);
                }
            }
        }

        public void onAnimationStart(View view) {
            if (Toolbar.this.mMenuView != null) {
                Toolbar.this.mMenuView.setVisibility(0);
            }
            this.mCanceled = false;
        }

        public VisibilityAnimListener withFinalVisibility(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, int i) {
            Toolbar.this.mMenuViewVisibilityAnim = viewPropertyAnimatorCompat;
            this.mFinalVisibility = i;
            return this;
        }
    }

    public Toolbar(Context context) {
        this(context, (AttributeSet) null);
    }

    private void addCustomViewsWithGravity(List<View> list, int i) {
        boolean z = ViewCompat.z(this) == 1;
        int childCount = getChildCount();
        int b = GravityCompat.b(i, ViewCompat.z(this));
        list.clear();
        if (z) {
            for (int i2 = childCount - 1; i2 >= 0; i2--) {
                View childAt = getChildAt(i2);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.mViewType == 0 && shouldLayout(childAt) && getChildHorizontalGravity(layoutParams.gravity) == b) {
                    list.add(childAt);
                }
            }
            return;
        }
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt2 = getChildAt(i3);
            LayoutParams layoutParams2 = (LayoutParams) childAt2.getLayoutParams();
            if (layoutParams2.mViewType == 0 && shouldLayout(childAt2) && getChildHorizontalGravity(layoutParams2.gravity) == b) {
                list.add(childAt2);
            }
        }
    }

    private void addSystemView(View view, boolean z) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        LayoutParams generateDefaultLayoutParams = layoutParams == null ? generateDefaultLayoutParams() : !checkLayoutParams(layoutParams) ? generateLayoutParams(layoutParams) : (LayoutParams) layoutParams;
        generateDefaultLayoutParams.mViewType = 1;
        if (!z || this.mExpandedActionView == null) {
            addView(view, generateDefaultLayoutParams);
            return;
        }
        view.setLayoutParams(generateDefaultLayoutParams);
        this.mHiddenViews.add(view);
    }

    private void ensureBottomMenuView() {
        if (this.mBottomMenuView == null) {
            ActionMenuView actionMenuView = new ActionMenuView(getContext());
            this.mBottomMenuView = actionMenuView;
            actionMenuView.setPopupTheme(this.mPopupTheme);
            this.mBottomMenuView.setOnMenuItemClickListener(this.mMenuViewItemClickListener);
            LayoutParams generateDefaultLayoutParams = generateDefaultLayoutParams();
            generateDefaultLayoutParams.gravity = (this.mButtonGravity & 112) | 8388613;
            this.mBottomMenuView.setLayoutParams(generateDefaultLayoutParams);
            this.mBottomMenuView.setId(R.id.mz_action_bottom_menu_view);
            ViewGroup viewGroup = this.mSplitView;
            if (viewGroup != null) {
                generateDefaultLayoutParams.width = -1;
                viewGroup.addView(this.mBottomMenuView, 0, generateDefaultLayoutParams);
            }
        }
    }

    /* access modifiers changed from: private */
    public void ensureCollapseButtonView() {
        if (this.mCollapseButtonView == null) {
            ImageButton imageButton = new ImageButton(getContext(), (AttributeSet) null, androidx.appcompat.R.attr.toolbarNavigationButtonStyle);
            this.mCollapseButtonView = imageButton;
            imageButton.setImageDrawable(this.mCollapseIcon);
            this.mCollapseButtonView.setContentDescription(this.mCollapseDescription);
            LayoutParams generateDefaultLayoutParams = generateDefaultLayoutParams();
            generateDefaultLayoutParams.gravity = (this.mButtonGravity & 112) | 8388611;
            generateDefaultLayoutParams.mViewType = 2;
            this.mCollapseButtonView.setLayoutParams(generateDefaultLayoutParams);
            this.mCollapseButtonView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Toolbar.this.collapseActionView();
                }
            });
        }
    }

    private void ensureLogoView() {
        if (this.mLogoView == null) {
            this.mLogoView = new ImageView(getContext());
        }
    }

    private void ensureMenu() {
        ensureMenuView();
        if (this.mMenuView.peekMenu() == null) {
            MenuBuilder menuBuilder = (MenuBuilder) this.mMenuView.getMenu();
            if (this.mExpandedMenuPresenter == null) {
                this.mExpandedMenuPresenter = new ExpandedActionViewMenuPresenter();
            }
            this.mMenuView.setExpandedActionViewsExclusive(true);
            menuBuilder.addMenuPresenter(this.mExpandedMenuPresenter, this.mPopupContext);
        }
    }

    private void ensureMenuView() {
        if (this.mMenuView == null) {
            ActionMenuView actionMenuView = new ActionMenuView(getContext());
            this.mMenuView = actionMenuView;
            actionMenuView.setPopupTheme(this.mPopupTheme);
            this.mMenuView.setOnMenuItemClickListener(this.mMenuViewItemClickListener);
            this.mMenuView.setMenuCallbacks(this.mActionMenuPresenterCallback, this.mMenuBuilderCallback);
            LayoutParams generateDefaultLayoutParams = generateDefaultLayoutParams();
            generateDefaultLayoutParams.gravity = (this.mButtonGravity & 112) | 8388613;
            this.mMenuView.setLayoutParams(generateDefaultLayoutParams);
            this.mMenuView.setId(R.id.mz_action_menu_view);
            if (this.mSplitActionBar) {
                generateDefaultLayoutParams.width = -1;
                this.mSplitView.addView(this.mMenuView, 0, generateDefaultLayoutParams);
                return;
            }
            addSystemView(this.mMenuView, false);
        }
    }

    private void ensureNavButtonView() {
        if (this.mNavButtonView == null) {
            this.mNavButtonView = new ImageButton(getContext(), (AttributeSet) null, androidx.appcompat.R.attr.toolbarNavigationButtonStyle);
            LayoutParams generateDefaultLayoutParams = generateDefaultLayoutParams();
            generateDefaultLayoutParams.gravity = (this.mButtonGravity & 112) | 8388611;
            this.mNavButtonView.setLayoutParams(generateDefaultLayoutParams);
            this.mNavButtonView.setImageDrawable(ResourcesCompat.f(getResources(), com.meizu.common.R.drawable.mz_titlebar_ic_back_dark, (Resources.Theme) null));
            this.mNavButtonView.setLayoutDirection(3);
            this.mNavButtonView.setId(R.id.mz_toolbar_nav_button);
            this.mNavButtonView.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
                public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                    View view2 = (View) view.getParent();
                    int i9 = (int) (Toolbar.this.getResources().getDisplayMetrics().density * 56.0f);
                    int i10 = i3 - i;
                    if (i10 < i9) {
                        int i11 = (i9 - i10) / 2;
                        view2.setTouchDelegate(new TouchDelegate(new Rect(i - i11, i2, i3 + i11, i4), view));
                    }
                }
            });
        }
    }

    private int getChildHorizontalGravity(int i) {
        int z = ViewCompat.z(this);
        int b = GravityCompat.b(i, z) & 7;
        return (b == 1 || b == 3 || b == 5) ? b : z == 1 ? 5 : 3;
    }

    private int getChildTop(View view, int i) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int measuredHeight = view.getMeasuredHeight();
        int i2 = i > 0 ? (measuredHeight - i) / 2 : 0;
        int childVerticalGravity = getChildVerticalGravity(layoutParams.gravity);
        if (childVerticalGravity == 48) {
            return getPaddingTop() - i2;
        }
        if (childVerticalGravity == 80) {
            return (((getHeight() - getPaddingBottom()) - measuredHeight) - layoutParams.bottomMargin) - i2;
        }
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int height = getHeight();
        int i3 = (((height - paddingTop) - paddingBottom) - measuredHeight) / 2;
        int i4 = layoutParams.topMargin;
        if (i3 < i4) {
            i3 = i4;
        } else {
            int i5 = (((height - paddingBottom) - measuredHeight) - i3) - paddingTop;
            int i6 = layoutParams.bottomMargin;
            if (i5 < i6) {
                i3 = Math.max(0, i3 - (i6 - i5));
            }
        }
        return paddingTop + i3;
    }

    private int getChildVerticalGravity(int i) {
        int i2 = i & 112;
        return (i2 == 16 || i2 == 48 || i2 == 80) ? i2 : this.mGravity & 112;
    }

    private int getHorizontalMargins(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return MarginLayoutParamsCompat.b(marginLayoutParams) + MarginLayoutParamsCompat.a(marginLayoutParams);
    }

    private MenuInflater getMenuInflater() {
        return new SupportMenuInflater(getContext());
    }

    private int getVerticalMargins(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    private int getViewListMeasuredWidth(List<View> list, int[] iArr) {
        int i = iArr[0];
        int i2 = iArr[1];
        int size = list.size();
        int i3 = 0;
        int i4 = 0;
        while (i3 < size) {
            View view = list.get(i3);
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            int i5 = layoutParams.leftMargin - i;
            int i6 = layoutParams.rightMargin - i2;
            int max = Math.max(0, i5);
            int max2 = Math.max(0, i6);
            int max3 = Math.max(0, -i5);
            int max4 = Math.max(0, -i6);
            i4 += max + view.getMeasuredWidth() + max2;
            i3++;
            i2 = max4;
            i = max3;
        }
        return i4;
    }

    private boolean isButtonInViewGroup(ViewGroup viewGroup) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof Button) {
                return true;
            }
            if ((childAt instanceof ViewGroup) && isButtonInViewGroup((ViewGroup) childAt)) {
                return true;
            }
        }
        return false;
    }

    private boolean isChildOrHidden(View view) {
        return view.getParent() == this || this.mHiddenViews.contains(view);
    }

    private static boolean isCustomView(View view) {
        return ((LayoutParams) view.getLayoutParams()).mViewType == 0;
    }

    private int layoutChildLeft(View view, int i, int[] iArr, int i2) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int i3 = layoutParams.leftMargin - iArr[0];
        int max = i + Math.max(0, i3);
        iArr[0] = Math.max(0, -i3);
        int childTop = getChildTop(view, i2);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max, childTop, max + measuredWidth, view.getMeasuredHeight() + childTop);
        return max + measuredWidth + layoutParams.rightMargin;
    }

    private int layoutChildRight(View view, int i, int[] iArr, int i2) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int i3 = layoutParams.rightMargin - iArr[1];
        int max = i - Math.max(0, i3);
        iArr[1] = Math.max(0, -i3);
        int childTop = getChildTop(view, i2);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max - measuredWidth, childTop, max, view.getMeasuredHeight() + childTop);
        return max - (measuredWidth + layoutParams.leftMargin);
    }

    private int measureChildCollapseMargins(View view, int i, int i2, int i3, int i4, int[] iArr) {
        return measureChildCollapseMargins(view, i, i2, i3, i4, iArr, false);
    }

    private void measureChildConstrained(View view, int i, int i2, int i3, int i4, int i5) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i2, marginLayoutParams.width);
        int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i3, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i4, marginLayoutParams.height);
        int mode = View.MeasureSpec.getMode(childMeasureSpec2);
        if (mode != 1073741824 && i5 >= 0) {
            if (mode != 0) {
                i5 = Math.min(View.MeasureSpec.getSize(childMeasureSpec2), i5);
            }
            childMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i5, 1073741824);
        }
        view.measure(childMeasureSpec, childMeasureSpec2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:116:0x02e3 A[LOOP:0: B:115:0x02e1->B:116:0x02e3, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x0305 A[LOOP:1: B:118:0x0303->B:119:0x0305, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x032f  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x033e A[LOOP:2: B:126:0x033c->B:127:0x033e, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00ae  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00c5  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00e2  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00f9  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00fe  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0116  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0126  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0129  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x012d  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0130  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0163  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x01a1  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x01b2  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0223  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void onLayoutForFlyme(boolean r20, int r21, int r22, int r23, int r24) {
        /*
            r19 = this;
            r0 = r19
            int r1 = androidx.core.view.ViewCompat.z(r19)
            r2 = 0
            r3 = 1
            if (r1 != r3) goto L_0x000c
            r1 = r3
            goto L_0x000d
        L_0x000c:
            r1 = r2
        L_0x000d:
            int r4 = r19.getWidth()
            int r5 = r19.getHeight()
            int r6 = r19.getPaddingLeft()
            int r7 = r19.getPaddingRight()
            int r8 = r19.getPaddingTop()
            int r9 = r19.getPaddingBottom()
            int r10 = r4 - r7
            int[] r11 = r0.mTempMargins
            r11[r3] = r2
            r11[r2] = r2
            int r12 = androidx.core.view.ViewCompat.B(r19)
            android.widget.ImageButton r13 = r0.mNavButtonView
            boolean r13 = r0.shouldLayout(r13)
            if (r13 == 0) goto L_0x004c
            if (r1 == 0) goto L_0x0044
            android.widget.ImageButton r13 = r0.mNavButtonView
            int r13 = r0.layoutChildRight(r13, r10, r11, r12)
            r14 = r13
            r13 = r6
            goto L_0x004e
        L_0x0044:
            android.widget.ImageButton r13 = r0.mNavButtonView
            int r13 = r0.layoutChildLeft(r13, r6, r11, r12)
        L_0x004a:
            r14 = r10
            goto L_0x004e
        L_0x004c:
            r13 = r6
            goto L_0x004a
        L_0x004e:
            android.widget.ImageButton r15 = r0.mCollapseButtonView
            boolean r15 = r0.shouldLayout(r15)
            if (r15 == 0) goto L_0x0065
            if (r1 == 0) goto L_0x005f
            android.widget.ImageButton r15 = r0.mCollapseButtonView
            int r14 = r0.layoutChildRight(r15, r14, r11, r12)
            goto L_0x0065
        L_0x005f:
            android.widget.ImageButton r15 = r0.mCollapseButtonView
            int r13 = r0.layoutChildLeft(r15, r13, r11, r12)
        L_0x0065:
            flyme.support.v7.widget.ActionMenuView r15 = r0.mMenuView
            boolean r15 = r0.shouldLayout(r15)
            if (r15 == 0) goto L_0x007c
            if (r1 == 0) goto L_0x0076
            flyme.support.v7.widget.ActionMenuView r15 = r0.mMenuView
            int r13 = r0.layoutChildLeft(r15, r13, r11, r12)
            goto L_0x007c
        L_0x0076:
            flyme.support.v7.widget.ActionMenuView r15 = r0.mMenuView
            int r14 = r0.layoutChildRight(r15, r14, r11, r12)
        L_0x007c:
            int r15 = r19.getContentInsetLeft()
            int r15 = r15 - r13
            int r15 = java.lang.Math.max(r2, r15)
            r11[r2] = r15
            int r15 = r19.getContentInsetRight()
            int r16 = r10 - r14
            int r15 = r15 - r16
            int r15 = java.lang.Math.max(r2, r15)
            r11[r3] = r15
            int r15 = r19.getContentInsetLeft()
            int r13 = java.lang.Math.max(r13, r15)
            int r15 = r19.getContentInsetRight()
            int r10 = r10 - r15
            int r10 = java.lang.Math.min(r14, r10)
            android.view.View r14 = r0.mExpandedActionView
            boolean r14 = r0.shouldLayout(r14)
            if (r14 == 0) goto L_0x00bd
            if (r1 == 0) goto L_0x00b7
            android.view.View r14 = r0.mExpandedActionView
            int r10 = r0.layoutChildRight(r14, r10, r11, r12)
            goto L_0x00bd
        L_0x00b7:
            android.view.View r14 = r0.mExpandedActionView
            int r13 = r0.layoutChildLeft(r14, r13, r11, r12)
        L_0x00bd:
            android.widget.ImageView r14 = r0.mLogoView
            boolean r14 = r0.shouldLayout(r14)
            if (r14 == 0) goto L_0x00d4
            if (r1 == 0) goto L_0x00ce
            android.widget.ImageView r14 = r0.mLogoView
            int r10 = r0.layoutChildRight(r14, r10, r11, r12)
            goto L_0x00d4
        L_0x00ce:
            android.widget.ImageView r14 = r0.mLogoView
            int r13 = r0.layoutChildLeft(r14, r13, r11, r12)
        L_0x00d4:
            android.widget.HorizontalScrollView r14 = r0.mTitleScrollView
            boolean r14 = r0.shouldLayout(r14)
            android.widget.TextView r15 = r0.mSubtitleTextView
            boolean r15 = r0.shouldLayout(r15)
            if (r14 == 0) goto L_0x00f9
            android.widget.HorizontalScrollView r3 = r0.mTitleScrollView
            android.view.ViewGroup$LayoutParams r3 = r3.getLayoutParams()
            flyme.support.v7.widget.Toolbar$LayoutParams r3 = (flyme.support.v7.widget.Toolbar.LayoutParams) r3
            int r2 = r3.topMargin
            r22 = r7
            android.widget.HorizontalScrollView r7 = r0.mTitleScrollView
            int r7 = r7.getMeasuredHeight()
            int r2 = r2 + r7
            int r3 = r3.bottomMargin
            int r2 = r2 + r3
            goto L_0x00fc
        L_0x00f9:
            r22 = r7
            r2 = 0
        L_0x00fc:
            if (r15 == 0) goto L_0x0116
            android.widget.TextView r3 = r0.mSubtitleTextView
            android.view.ViewGroup$LayoutParams r3 = r3.getLayoutParams()
            flyme.support.v7.widget.Toolbar$LayoutParams r3 = (flyme.support.v7.widget.Toolbar.LayoutParams) r3
            int r7 = r3.topMargin
            r23 = r6
            android.widget.TextView r6 = r0.mSubtitleTextView
            int r6 = r6.getMeasuredHeight()
            int r7 = r7 + r6
            int r3 = r3.bottomMargin
            int r7 = r7 + r3
            int r2 = r2 + r7
            goto L_0x0118
        L_0x0116:
            r23 = r6
        L_0x0118:
            if (r14 != 0) goto L_0x0124
            if (r15 == 0) goto L_0x011d
            goto L_0x0124
        L_0x011d:
            r16 = r4
            r24 = r12
        L_0x0121:
            r2 = 0
            goto L_0x02d4
        L_0x0124:
            if (r14 == 0) goto L_0x0129
            android.widget.HorizontalScrollView r3 = r0.mTitleScrollView
            goto L_0x012b
        L_0x0129:
            android.widget.TextView r3 = r0.mSubtitleTextView
        L_0x012b:
            if (r15 == 0) goto L_0x0130
            android.widget.TextView r6 = r0.mSubtitleTextView
            goto L_0x0132
        L_0x0130:
            android.widget.HorizontalScrollView r6 = r0.mTitleScrollView
        L_0x0132:
            android.view.ViewGroup$LayoutParams r3 = r3.getLayoutParams()
            flyme.support.v7.widget.Toolbar$LayoutParams r3 = (flyme.support.v7.widget.Toolbar.LayoutParams) r3
            android.view.ViewGroup$LayoutParams r6 = r6.getLayoutParams()
            flyme.support.v7.widget.Toolbar$LayoutParams r6 = (flyme.support.v7.widget.Toolbar.LayoutParams) r6
            if (r14 == 0) goto L_0x0148
            android.widget.HorizontalScrollView r7 = r0.mTitleScrollView
            int r7 = r7.getMeasuredWidth()
            if (r7 > 0) goto L_0x0152
        L_0x0148:
            if (r15 == 0) goto L_0x0156
            android.widget.TextView r7 = r0.mSubtitleTextView
            int r7 = r7.getMeasuredWidth()
            if (r7 <= 0) goto L_0x0156
        L_0x0152:
            r24 = r12
            r7 = 1
            goto L_0x0159
        L_0x0156:
            r24 = r12
            r7 = 0
        L_0x0159:
            int r12 = r0.mGravity
            r12 = r12 & 112(0x70, float:1.57E-43)
            r16 = r4
            r4 = 48
            if (r12 == r4) goto L_0x01a1
            r4 = 80
            if (r12 == r4) goto L_0x0193
            int r4 = r5 - r8
            int r4 = r4 - r9
            int r4 = r4 - r2
            int r4 = r4 / 2
            int r12 = r3.topMargin
            r17 = r13
            int r13 = r0.mTitleMarginTop
            r18 = r15
            int r15 = r12 + r13
            if (r4 >= r15) goto L_0x017c
            int r4 = r12 + r13
            goto L_0x0191
        L_0x017c:
            int r5 = r5 - r9
            int r5 = r5 - r2
            int r5 = r5 - r4
            int r5 = r5 - r8
            int r2 = r3.bottomMargin
            int r3 = r0.mTitleMarginBottom
            int r2 = r2 + r3
            if (r5 >= r2) goto L_0x0191
            int r2 = r6.bottomMargin
            int r2 = r2 + r3
            int r2 = r2 - r5
            int r4 = r4 - r2
            r2 = 0
            int r4 = java.lang.Math.max(r2, r4)
        L_0x0191:
            int r8 = r8 + r4
            goto L_0x01b0
        L_0x0193:
            r17 = r13
            r18 = r15
            int r5 = r5 - r9
            int r3 = r6.bottomMargin
            int r5 = r5 - r3
            int r3 = r0.mTitleMarginBottom
            int r5 = r5 - r3
            int r8 = r5 - r2
            goto L_0x01b0
        L_0x01a1:
            r17 = r13
            r18 = r15
            int r2 = r19.getPaddingTop()
            int r3 = r3.topMargin
            int r2 = r2 + r3
            int r3 = r0.mTitleMarginTop
            int r8 = r2 + r3
        L_0x01b0:
            if (r1 == 0) goto L_0x0223
            if (r7 == 0) goto L_0x01b8
            int r1 = r0.mTitleMarginStart
        L_0x01b6:
            r2 = 1
            goto L_0x01ba
        L_0x01b8:
            r1 = 0
            goto L_0x01b6
        L_0x01ba:
            r3 = r11[r2]
            int r1 = r1 - r3
            r3 = 0
            int r4 = java.lang.Math.max(r3, r1)
            int r10 = r10 - r4
            int r1 = -r1
            int r1 = java.lang.Math.max(r3, r1)
            r11[r2] = r1
            if (r14 == 0) goto L_0x01f0
            android.widget.HorizontalScrollView r1 = r0.mTitleScrollView
            android.view.ViewGroup$LayoutParams r1 = r1.getLayoutParams()
            flyme.support.v7.widget.Toolbar$LayoutParams r1 = (flyme.support.v7.widget.Toolbar.LayoutParams) r1
            android.widget.HorizontalScrollView r2 = r0.mTitleScrollView
            int r2 = r2.getMeasuredWidth()
            int r2 = r10 - r2
            android.widget.HorizontalScrollView r3 = r0.mTitleScrollView
            int r3 = r3.getMeasuredHeight()
            int r3 = r3 + r8
            android.widget.HorizontalScrollView r4 = r0.mTitleScrollView
            r4.layout(r2, r8, r10, r3)
            int r4 = r0.mTitleMarginEnd
            int r2 = r2 - r4
            int r1 = r1.bottomMargin
            int r8 = r3 + r1
            goto L_0x01f1
        L_0x01f0:
            r2 = r10
        L_0x01f1:
            if (r18 == 0) goto L_0x0217
            android.widget.TextView r1 = r0.mSubtitleTextView
            android.view.ViewGroup$LayoutParams r1 = r1.getLayoutParams()
            flyme.support.v7.widget.Toolbar$LayoutParams r1 = (flyme.support.v7.widget.Toolbar.LayoutParams) r1
            int r1 = r1.topMargin
            int r8 = r8 + r1
            android.widget.TextView r1 = r0.mSubtitleTextView
            int r1 = r1.getMeasuredWidth()
            int r1 = r10 - r1
            android.widget.TextView r3 = r0.mSubtitleTextView
            int r3 = r3.getMeasuredHeight()
            int r3 = r3 + r8
            android.widget.TextView r4 = r0.mSubtitleTextView
            r4.layout(r1, r8, r10, r3)
            int r1 = r0.mTitleMarginEnd
            int r1 = r10 - r1
            goto L_0x0218
        L_0x0217:
            r1 = r10
        L_0x0218:
            if (r7 == 0) goto L_0x021f
            int r1 = java.lang.Math.min(r2, r1)
            r10 = r1
        L_0x021f:
            r13 = r17
            goto L_0x0121
        L_0x0223:
            int r1 = r0.mGravity
            r1 = r1 & 7
            r2 = 1
            if (r1 == r2) goto L_0x024d
            if (r7 == 0) goto L_0x0231
            int r2 = r0.mTitleMarginStart
            r1 = r2
        L_0x022f:
            r2 = 0
            goto L_0x0233
        L_0x0231:
            r1 = 0
            goto L_0x022f
        L_0x0233:
            r3 = r11[r2]
            int r1 = r1 - r3
            if (r3 <= 0) goto L_0x023d
            int r3 = r0.mTitleMarginStart
        L_0x023a:
            int r13 = r17 + r3
            goto L_0x0242
        L_0x023d:
            int r3 = java.lang.Math.max(r2, r1)
            goto L_0x023a
        L_0x0242:
            int r1 = -r1
            int r1 = java.lang.Math.max(r2, r1)
            r11[r2] = r1
            r1 = r13
            r17 = r1
            goto L_0x026b
        L_0x024d:
            r2 = 0
            if (r14 == 0) goto L_0x025b
            android.widget.HorizontalScrollView r1 = r0.mTitleScrollView
            int r1 = r1.getMeasuredWidth()
            int r4 = r16 - r1
            int r1 = r4 / 2
            goto L_0x025c
        L_0x025b:
            r1 = r2
        L_0x025c:
            if (r18 == 0) goto L_0x026a
            android.widget.TextView r3 = r0.mSubtitleTextView
            int r3 = r3.getMeasuredWidth()
            int r4 = r16 - r3
            int r3 = r4 / 2
            r13 = r3
            goto L_0x026b
        L_0x026a:
            r13 = r2
        L_0x026b:
            if (r14 == 0) goto L_0x028f
            android.widget.HorizontalScrollView r3 = r0.mTitleScrollView
            android.view.ViewGroup$LayoutParams r3 = r3.getLayoutParams()
            flyme.support.v7.widget.Toolbar$LayoutParams r3 = (flyme.support.v7.widget.Toolbar.LayoutParams) r3
            android.widget.HorizontalScrollView r4 = r0.mTitleScrollView
            int r4 = r4.getMeasuredWidth()
            int r4 = r4 + r1
            android.widget.HorizontalScrollView r5 = r0.mTitleScrollView
            int r5 = r5.getMeasuredHeight()
            int r5 = r5 + r8
            android.widget.HorizontalScrollView r6 = r0.mTitleScrollView
            r6.layout(r1, r8, r4, r5)
            int r1 = r0.mTitleMarginEnd
            int r1 = r1 + r4
            int r3 = r3.bottomMargin
            int r8 = r5 + r3
        L_0x028f:
            if (r18 == 0) goto L_0x02b3
            android.widget.TextView r3 = r0.mSubtitleTextView
            android.view.ViewGroup$LayoutParams r3 = r3.getLayoutParams()
            flyme.support.v7.widget.Toolbar$LayoutParams r3 = (flyme.support.v7.widget.Toolbar.LayoutParams) r3
            int r3 = r3.topMargin
            int r8 = r8 + r3
            android.widget.TextView r3 = r0.mSubtitleTextView
            int r3 = r3.getMeasuredWidth()
            int r3 = r3 + r13
            android.widget.TextView r4 = r0.mSubtitleTextView
            int r4 = r4.getMeasuredHeight()
            int r4 = r4 + r8
            android.widget.TextView r5 = r0.mSubtitleTextView
            r5.layout(r13, r8, r3, r4)
            int r4 = r0.mTitleMarginEnd
            int r13 = r3 + r4
        L_0x02b3:
            if (r7 == 0) goto L_0x02bb
            int r1 = java.lang.Math.max(r1, r13)
            r13 = r1
            goto L_0x02bd
        L_0x02bb:
            r13 = r17
        L_0x02bd:
            int r1 = r0.mGravity
            r1 = r1 & 112(0x70, float:1.57E-43)
            r3 = 17
            if (r1 != r3) goto L_0x02d4
            android.content.Context r1 = r19.getContext()
            android.content.res.Resources r1 = r1.getResources()
            int r3 = flyme.support.v7.appcompat.R.dimen.mz_toolbar_title_margin_end
            int r1 = r1.getDimensionPixelSize(r3)
            int r13 = r13 + r1
        L_0x02d4:
            java.util.ArrayList<android.view.View> r1 = r0.mTempViews
            r3 = 3
            r0.addCustomViewsWithGravity(r1, r3)
            java.util.ArrayList<android.view.View> r1 = r0.mTempViews
            int r1 = r1.size()
            r3 = r2
        L_0x02e1:
            if (r3 >= r1) goto L_0x02f4
            java.util.ArrayList<android.view.View> r4 = r0.mTempViews
            java.lang.Object r4 = r4.get(r3)
            android.view.View r4 = (android.view.View) r4
            r5 = r24
            int r13 = r0.layoutChildLeft(r4, r13, r11, r5)
            int r3 = r3 + 1
            goto L_0x02e1
        L_0x02f4:
            r5 = r24
            java.util.ArrayList<android.view.View> r1 = r0.mTempViews
            r3 = 5
            r0.addCustomViewsWithGravity(r1, r3)
            java.util.ArrayList<android.view.View> r1 = r0.mTempViews
            int r1 = r1.size()
            r3 = r2
        L_0x0303:
            if (r3 >= r1) goto L_0x0314
            java.util.ArrayList<android.view.View> r4 = r0.mTempViews
            java.lang.Object r4 = r4.get(r3)
            android.view.View r4 = (android.view.View) r4
            int r10 = r0.layoutChildRight(r4, r10, r11, r5)
            int r3 = r3 + 1
            goto L_0x0303
        L_0x0314:
            java.util.ArrayList<android.view.View> r1 = r0.mTempViews
            r3 = 1
            r0.addCustomViewsWithGravity(r1, r3)
            java.util.ArrayList<android.view.View> r1 = r0.mTempViews
            int r1 = r0.getViewListMeasuredWidth(r1, r11)
            int r4 = r16 - r23
            int r4 = r4 - r22
            int r4 = r4 / 2
            int r6 = r23 + r4
            int r3 = r1 / 2
            int r6 = r6 - r3
            int r1 = r1 + r6
            if (r6 >= r13) goto L_0x032f
            goto L_0x0336
        L_0x032f:
            if (r1 <= r10) goto L_0x0335
            int r1 = r1 - r10
            int r13 = r6 - r1
            goto L_0x0336
        L_0x0335:
            r13 = r6
        L_0x0336:
            java.util.ArrayList<android.view.View> r1 = r0.mTempViews
            int r1 = r1.size()
        L_0x033c:
            if (r2 >= r1) goto L_0x034d
            java.util.ArrayList<android.view.View> r3 = r0.mTempViews
            java.lang.Object r3 = r3.get(r2)
            android.view.View r3 = (android.view.View) r3
            int r13 = r0.layoutChildLeft(r3, r13, r11, r5)
            int r2 = r2 + 1
            goto L_0x033c
        L_0x034d:
            java.util.ArrayList<android.view.View> r0 = r0.mTempViews
            r0.clear()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: flyme.support.v7.widget.Toolbar.onLayoutForFlyme(boolean, int, int, int, int):void");
    }

    private void onMeasureForFlyme(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int[] iArr = this.mTempMargins;
        char isLayoutRtl = ViewUtils.isLayoutRtl(this);
        char c = isLayoutRtl ^ 1;
        int i10 = this.mTitleMarginStartStyled;
        int i11 = 0;
        if (shouldLayout(this.mNavButtonView)) {
            measureChildConstrained(this.mNavButtonView, i, 0, i2, 0, this.mMaxButtonHeight);
            int measuredWidth = this.mNavButtonView.getMeasuredWidth() + getHorizontalMargins(this.mNavButtonView);
            i4 = Math.max(0, this.mNavButtonView.getMeasuredHeight() + getVerticalMargins(this.mNavButtonView));
            i3 = ViewUtils.combineMeasuredStates(0, ViewCompat.A(this.mNavButtonView));
            i5 = measuredWidth;
            i10 = this.mTitleMarginStartBack;
        } else {
            i5 = 0;
            i4 = 0;
            i3 = 0;
        }
        this.mTitleMarginStart = i10;
        if (shouldLayout(this.mCollapseButtonView)) {
            measureChildConstrained(this.mCollapseButtonView, i, 0, i2, 0, this.mMaxButtonHeight);
            i5 = getHorizontalMargins(this.mCollapseButtonView) + this.mCollapseButtonView.getMeasuredWidth();
            i4 = Math.max(i4, this.mCollapseButtonView.getMeasuredHeight() + getVerticalMargins(this.mCollapseButtonView));
            i3 = ViewUtils.combineMeasuredStates(i3, ViewCompat.A(this.mCollapseButtonView));
        }
        int contentInsetStart = getContentInsetStart();
        int max = Math.max(contentInsetStart, i5);
        iArr[isLayoutRtl] = Math.max(0, contentInsetStart - i5);
        if (shouldLayout(this.mMenuView)) {
            measureChildConstrained(this.mMenuView, i, max, i2, 0, this.mMaxButtonHeight);
            int measuredWidth2 = this.mMenuView.getMeasuredWidth() + getHorizontalMargins(this.mMenuView);
            i4 = Math.max(i4, this.mMenuView.getMeasuredHeight() + getVerticalMargins(this.mMenuView));
            i3 = ViewUtils.combineMeasuredStates(i3, ViewCompat.A(this.mMenuView));
            i6 = measuredWidth2;
        } else {
            i6 = 0;
        }
        int contentInsetEnd = getContentInsetEnd();
        int max2 = max + Math.max(contentInsetEnd, i6);
        iArr[c] = Math.max(0, contentInsetEnd - i6);
        if (shouldLayout(this.mExpandedActionView)) {
            max2 += measureChildCollapseMargins(this.mExpandedActionView, i, max2, i2, 0, iArr);
            i4 = Math.max(i4, this.mExpandedActionView.getMeasuredHeight() + getVerticalMargins(this.mExpandedActionView));
            i3 = ViewUtils.combineMeasuredStates(i3, ViewCompat.A(this.mExpandedActionView));
        }
        if (shouldLayout(this.mLogoView)) {
            max2 += measureChildCollapseMargins(this.mLogoView, i, max2, i2, 0, iArr);
            i4 = Math.max(i4, this.mLogoView.getMeasuredHeight() + getVerticalMargins(this.mLogoView));
            i3 = ViewUtils.combineMeasuredStates(i3, ViewCompat.A(this.mLogoView));
        }
        int childCount = getChildCount();
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt = getChildAt(i12);
            if (((LayoutParams) childAt.getLayoutParams()).mViewType == 0 && shouldLayout(childAt)) {
                View view = childAt;
                max2 += measureChildCollapseMargins(childAt, i, max2, i2, 0, iArr);
                View view2 = view;
                i4 = Math.max(i4, view.getMeasuredHeight() + getVerticalMargins(view2));
                i3 = ViewUtils.combineMeasuredStates(i3, ViewCompat.A(view2));
            }
        }
        int i13 = this.mTitleMarginTop + this.mTitleMarginBottom;
        int i14 = this.mTitleMarginStart + this.mTitleMarginEnd;
        int i15 = (this.mGravity & 7) != 1 ? max2 : i6 * 2;
        if (shouldLayout(this.mTitleScrollView)) {
            measureChildCollapseMargins(this.mTitleScrollView, i, i15 + i14, i2, i13, iArr, true);
            int measuredWidth3 = this.mTitleScrollView.getMeasuredWidth() + getHorizontalMargins(this.mTitleScrollView);
            int measuredHeight = this.mTitleScrollView.getMeasuredHeight() + getVerticalMargins(this.mTitleScrollView);
            i8 = measuredWidth3;
            i9 = ViewUtils.combineMeasuredStates(i3, ViewCompat.A(this.mTitleScrollView));
            i7 = measuredHeight;
        } else {
            i8 = 0;
            i9 = i3;
            i7 = 0;
        }
        if (shouldLayout(this.mSubtitleTextView)) {
            i8 = Math.max(i8, measureChildCollapseMargins(this.mSubtitleTextView, i, i15 + i14, i2, i7 + i13, iArr));
            i7 += this.mSubtitleTextView.getMeasuredHeight() + getVerticalMargins(this.mSubtitleTextView);
            i9 = ViewUtils.combineMeasuredStates(i9, ViewCompat.A(this.mSubtitleTextView));
        } else {
            int i16 = i9;
        }
        int max3 = Math.max(i4, i7);
        int paddingLeft = max2 + i8 + getPaddingLeft() + getPaddingRight();
        int paddingTop = max3 + getPaddingTop() + getPaddingBottom();
        int r0 = ViewCompat.r0(Math.max(paddingLeft, getSuggestedMinimumWidth()), i, -16777216 & i9);
        int r02 = ViewCompat.r0(Math.max(paddingTop, getSuggestedMinimumHeight()), i2, i9 << 16);
        if (!shouldCollapse()) {
            i11 = r02;
        }
        setMeasuredDimension(r0, i11);
    }

    private void postShowOverflowMenu() {
        removeCallbacks(this.mShowOverflowMenuRunnable);
        post(this.mShowOverflowMenuRunnable);
    }

    private boolean shouldCollapse() {
        if (!this.mCollapsible) {
            return false;
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (shouldLayout(childAt) && childAt.getMeasuredWidth() > 0 && childAt.getMeasuredHeight() > 0) {
                return false;
            }
        }
        return true;
    }

    private boolean shouldLayout(View view) {
        return (view == null || view.getParent() != this || view.getVisibility() == 8) ? false : true;
    }

    public void addChildrenForExpandedActionView() {
        for (int size = this.mHiddenViews.size() - 1; size >= 0; size--) {
            addView(this.mHiddenViews.get(size));
        }
        this.mHiddenViews.clear();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r1 = r1.mMenuView;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean canShowOverflowMenu() {
        /*
            r1 = this;
            int r0 = r1.getVisibility()
            if (r0 != 0) goto L_0x0012
            flyme.support.v7.widget.ActionMenuView r1 = r1.mMenuView
            if (r1 == 0) goto L_0x0012
            boolean r1 = r1.isOverflowReserved()
            if (r1 == 0) goto L_0x0012
            r1 = 1
            goto L_0x0013
        L_0x0012:
            r1 = 0
        L_0x0013:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: flyme.support.v7.widget.Toolbar.canShowOverflowMenu():boolean");
    }

    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof LayoutParams);
    }

    public void collapseActionView() {
        ExpandedActionViewMenuPresenter expandedActionViewMenuPresenter = this.mExpandedMenuPresenter;
        MenuItemImpl menuItemImpl = expandedActionViewMenuPresenter == null ? null : expandedActionViewMenuPresenter.mCurrentExpandedItem;
        if (menuItemImpl != null) {
            menuItemImpl.collapseActionView();
        }
    }

    public void dismissPopupMenus() {
        ActionMenuView actionMenuView = this.mMenuView;
        if (actionMenuView != null) {
            actionMenuView.dismissPopupMenus();
        }
    }

    public int getContentInsetEnd() {
        return this.mContentInsets.getEnd();
    }

    public int getContentInsetLeft() {
        return this.mContentInsets.getLeft();
    }

    public int getContentInsetRight() {
        return this.mContentInsets.getRight();
    }

    public int getContentInsetStart() {
        return this.mContentInsets.getStart();
    }

    public Drawable getLogo() {
        ImageView imageView = this.mLogoView;
        if (imageView != null) {
            return imageView.getDrawable();
        }
        return null;
    }

    public CharSequence getLogoDescription() {
        ImageView imageView = this.mLogoView;
        if (imageView != null) {
            return imageView.getContentDescription();
        }
        return null;
    }

    public Menu getMenu() {
        ensureMenu();
        return this.mMenuView.getMenu();
    }

    @Nullable
    public CharSequence getNavigationContentDescription() {
        ImageButton imageButton = this.mNavButtonView;
        if (imageButton != null) {
            return imageButton.getContentDescription();
        }
        return null;
    }

    @Nullable
    public Drawable getNavigationIcon() {
        ImageButton imageButton = this.mNavButtonView;
        if (imageButton != null) {
            return imageButton.getDrawable();
        }
        return null;
    }

    @Nullable
    public Drawable getOverflowIcon() {
        ensureMenu();
        return this.mMenuView.getOverflowIcon();
    }

    public int getPopupTheme() {
        return this.mPopupTheme;
    }

    public View getSplitBarCustomView() {
        return this.mSplitBarCustomView;
    }

    public CharSequence getSubtitle() {
        return this.mSubtitleText;
    }

    public CharSequence getTitle() {
        return this.mTitleText;
    }

    public int getTitleMarginBottom() {
        return this.mTitleMarginBottom;
    }

    public int getTitleMarginEnd() {
        return this.mTitleMarginEnd;
    }

    public int getTitleMarginStart() {
        return this.mTitleMarginStart;
    }

    public int getTitleMarginTop() {
        return this.mTitleMarginTop;
    }

    public DecorToolbar getWrapper() {
        if (this.mWrapper == null) {
            this.mWrapper = new ToolbarWidgetWrapper(this, true);
        }
        return this.mWrapper;
    }

    public boolean hasExpandedActionView() {
        ExpandedActionViewMenuPresenter expandedActionViewMenuPresenter = this.mExpandedMenuPresenter;
        return (expandedActionViewMenuPresenter == null || expandedActionViewMenuPresenter.mCurrentExpandedItem == null) ? false : true;
    }

    public boolean hideOverflowMenu() {
        ActionMenuView actionMenuView = this.mMenuView;
        return actionMenuView != null && actionMenuView.hideOverflowMenu();
    }

    public void inflateMenu(@MenuRes int i) {
        getMenuInflater().inflate(i, getMenu());
    }

    public boolean isOverflowMenuShowPending() {
        ActionMenuView actionMenuView = this.mMenuView;
        return actionMenuView != null && actionMenuView.isOverflowMenuShowPending();
    }

    public boolean isOverflowMenuShowing() {
        ActionMenuView actionMenuView = this.mMenuView;
        return actionMenuView != null && actionMenuView.isOverflowMenuShowing();
    }

    public boolean isShowBottomMenu() {
        return this.mShowBottomMenu;
    }

    public boolean isTitleTruncated() {
        Layout layout;
        TextView textView = this.mTitleTextView;
        if (textView == null || (layout = textView.getLayout()) == null) {
            return false;
        }
        int lineCount = layout.getLineCount();
        for (int i = 0; i < lineCount; i++) {
            if (layout.getEllipsisCount(i) > 0) {
                return true;
            }
        }
        return false;
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.mSplitWhenNarrow) {
            setSplitToolbar(getContext().getResources().getBoolean(R.bool.mz_split_action_bar_is_narrow));
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.mShowOverflowMenuRunnable);
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        int a2 = MotionEventCompat.a(motionEvent);
        if (a2 == 9) {
            this.mEatingHover = false;
        }
        if (!this.mEatingHover) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (a2 == 9 && !onHoverEvent) {
                this.mEatingHover = true;
            }
        }
        if (a2 == 10 || a2 == 3) {
            this.mEatingHover = false;
        }
        return true;
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        onLayoutForFlyme(z, i, i2, i3, i4);
    }

    public void onMeasure(int i, int i2) {
        onMeasureForFlyme(i, i2);
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        MenuItem findItem;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        ActionMenuView actionMenuView = this.mMenuView;
        MenuBuilder peekMenu = actionMenuView != null ? actionMenuView.peekMenu() : null;
        int i = savedState.expandedMenuItemId;
        if (!(i == 0 || this.mExpandedMenuPresenter == null || peekMenu == null || (findItem = peekMenu.findItem(i)) == null)) {
            MenuItemCompat.a(findItem);
        }
        if (savedState.isOverflowOpen) {
            postShowOverflowMenu();
        }
    }

    public void onRtlPropertiesChanged(int i) {
        super.onRtlPropertiesChanged(i);
        RtlSpacingHelper rtlSpacingHelper = this.mContentInsets;
        if (rtlSpacingHelper != null) {
            boolean z = true;
            if (i != 1) {
                z = false;
            }
            rtlSpacingHelper.setDirection(z);
        }
    }

    public Parcelable onSaveInstanceState() {
        MenuItemImpl menuItemImpl;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        ExpandedActionViewMenuPresenter expandedActionViewMenuPresenter = this.mExpandedMenuPresenter;
        if (!(expandedActionViewMenuPresenter == null || (menuItemImpl = expandedActionViewMenuPresenter.mCurrentExpandedItem) == null)) {
            savedState.expandedMenuItemId = menuItemImpl.getItemId();
        }
        savedState.isOverflowOpen = isOverflowMenuShowing();
        return savedState;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int a2 = MotionEventCompat.a(motionEvent);
        if (a2 == 0) {
            this.mEatingTouch = false;
        }
        if (!this.mEatingTouch) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (a2 == 0 && !onTouchEvent) {
                this.mEatingTouch = true;
            }
        }
        if (a2 == 1 || a2 == 3) {
            this.mEatingTouch = false;
        }
        return true;
    }

    public void reSetSplitViewHeight(ViewGroup viewGroup) {
        ViewGroup viewGroup2 = this.mSplitView;
        if (viewGroup2 != null && viewGroup != null && isButtonInViewGroup(viewGroup2)) {
            ViewGroup.LayoutParams layoutParams = this.mSplitView.getLayoutParams();
            layoutParams.height = ((int) ResourceUtils.dp2px(78.0f, getContext())) + viewGroup.getPaddingBottom();
            this.mSplitView.setLayoutParams(layoutParams);
        }
    }

    public void removeChildrenForExpandedActionView() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (!(((LayoutParams) childAt.getLayoutParams()).mViewType == 2 || childAt == this.mMenuView)) {
                removeViewAt(childCount);
                this.mHiddenViews.add(childAt);
            }
        }
    }

    public void setBottomMenu(MenuBuilder menuBuilder, ActionMenuPresenter actionMenuPresenter) {
        ensureBottomMenuView();
        MenuBuilder peekMenu = this.mBottomMenuView.peekMenu();
        if (peekMenu != menuBuilder) {
            if (peekMenu != null) {
                peekMenu.removeMenuPresenter(this.mOuterActionMenuPresenter);
            }
            actionMenuPresenter.setExpandedActionViewsExclusive(true);
            if (menuBuilder != null) {
                menuBuilder.addMenuPresenter(actionMenuPresenter, this.mPopupContext);
            }
            this.mBottomMenuView.setPopupTheme(this.mPopupTheme);
            this.mBottomMenuView.setPresenter(actionMenuPresenter);
        }
    }

    public void setCollapsible(boolean z) {
        this.mCollapsible = z;
        requestLayout();
    }

    public void setContentInsetsAbsolute(int i, int i2) {
        this.mContentInsets.setAbsolute(i, i2);
    }

    public void setContentInsetsRelative(int i, int i2) {
        this.mContentInsets.setRelative(i, i2);
    }

    public void setLogo(@DrawableRes int i) {
        setLogo(this.mDrawableManager.c(getContext(), i));
    }

    public void setLogoDescription(@StringRes int i) {
        setLogoDescription(getContext().getText(i));
    }

    public void setMenu(MenuBuilder menuBuilder, ActionMenuPresenter actionMenuPresenter) {
        if (menuBuilder != null || this.mMenuView != null) {
            ensureMenuView();
            MenuBuilder peekMenu = this.mMenuView.peekMenu();
            if (peekMenu != menuBuilder) {
                if (peekMenu != null) {
                    peekMenu.removeMenuPresenter(this.mOuterActionMenuPresenter);
                    peekMenu.removeMenuPresenter(this.mExpandedMenuPresenter);
                }
                if (this.mExpandedMenuPresenter == null) {
                    this.mExpandedMenuPresenter = new ExpandedActionViewMenuPresenter();
                }
                actionMenuPresenter.setExpandedActionViewsExclusive(true);
                if (menuBuilder != null) {
                    menuBuilder.addMenuPresenter(actionMenuPresenter, this.mPopupContext);
                    menuBuilder.addMenuPresenter(this.mExpandedMenuPresenter, this.mPopupContext);
                } else {
                    actionMenuPresenter.initForMenu(this.mPopupContext, (MenuBuilder) null);
                    this.mExpandedMenuPresenter.initForMenu(this.mPopupContext, (MenuBuilder) null);
                    actionMenuPresenter.updateMenuView(true);
                    this.mExpandedMenuPresenter.updateMenuView(true);
                }
                this.mMenuView.setPopupTheme(this.mPopupTheme);
                this.mMenuView.setPresenter(actionMenuPresenter);
                this.mOuterActionMenuPresenter = actionMenuPresenter;
            }
        }
    }

    public void setMenuCallbacks(MenuPresenter.Callback callback, MenuBuilder.Callback callback2) {
        this.mActionMenuPresenterCallback = callback;
        this.mMenuBuilderCallback = callback2;
        ActionMenuView actionMenuView = this.mMenuView;
        if (actionMenuView != null) {
            actionMenuView.setMenuCallbacks(callback, callback2);
        }
    }

    public void setMenuViewAnimateToVisibility(int i, long j) {
        if ((this.mSplitActionBar && this.mMenuView != null) || this.mBottomMenuView != null || this.mSplitBarCustomView == null) {
            View view = this.mSplitBarCustomView;
            if (view == null && (view = this.mBottomMenuView) == null) {
                view = this.mMenuView;
            }
            if (i == 0) {
                ViewCompat.y0(view, 0.0f);
                ViewPropertyAnimatorCompat b = ViewCompat.e(view).b(1.0f);
                b.i(j);
                b.k(this.mVisAnimListener.withFinalVisibility(b, i));
                b.o();
                return;
            }
            ViewPropertyAnimatorCompat b2 = ViewCompat.e(view).b(0.0f);
            b2.i(j);
            b2.k(this.mVisAnimListener.withFinalVisibility(b2, i));
            b2.o();
        }
    }

    public void setMenuVisibility(int i) {
        ActionMenuView actionMenuView = this.mMenuView;
        if (actionMenuView != null && this.mSplitActionBar) {
            actionMenuView.setVisibility(i);
        }
    }

    public void setNavigationContentDescription(@StringRes int i) {
        setNavigationContentDescription(i != 0 ? getContext().getText(i) : null);
    }

    public void setNavigationIcon(@DrawableRes int i) {
        setNavigationIcon(this.mDrawableManager.c(getContext(), i));
    }

    public void setNavigationOnClickListener(View.OnClickListener onClickListener) {
        ensureNavButtonView();
        this.mNavButtonView.setOnClickListener(onClickListener);
    }

    public void setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        this.mOnMenuItemClickListener = onMenuItemClickListener;
    }

    public void setOverflowIcon(@Nullable Drawable drawable) {
        ensureMenu();
        this.mMenuView.setOverflowIcon(drawable);
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

    public void setShowBottomMenu(boolean z) {
        if (this.mShowBottomMenu != z) {
            this.mShowBottomMenu = z;
            ActionMenuView actionMenuView = this.mBottomMenuView;
            if (actionMenuView != null) {
                ViewGroup viewGroup = (ViewGroup) actionMenuView.getParent();
                if (viewGroup != null) {
                    viewGroup.removeView(this.mBottomMenuView);
                }
                if (this.mShowBottomMenu) {
                    ViewGroup viewGroup2 = this.mSplitView;
                    if (viewGroup2 != null) {
                        viewGroup2.addView(this.mBottomMenuView);
                    }
                    this.mBottomMenuView.getLayoutParams().width = -1;
                }
                this.mBottomMenuView.requestLayout();
            }
        }
    }

    public void setSplitCustomView(View view) {
        FrameLayout.LayoutParams layoutParams;
        if (this.mSplitView != null) {
            View view2 = this.mSplitBarCustomView;
            if (view2 != null) {
                ((ViewGroup) view2.getParent()).removeView(this.mSplitBarCustomView);
            }
            if (!(view == null || view.getParent() == null)) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            this.mSplitBarCustomView = view;
            if (view != null) {
                ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
                if (layoutParams2 != null) {
                    layoutParams = new FrameLayout.LayoutParams(layoutParams2);
                    if (!(layoutParams2 instanceof FrameLayout.LayoutParams)) {
                        layoutParams.gravity = 17;
                    }
                } else {
                    layoutParams = new FrameLayout.LayoutParams(-1, -1);
                    layoutParams.gravity = 17;
                }
                this.mSplitView.addView(view, layoutParams);
            }
        }
    }

    public void setSplitToolbar(boolean z) {
        if (this.mSplitActionBar != z) {
            this.mSplitActionBar = z;
            ActionMenuView actionMenuView = this.mMenuView;
            if (actionMenuView != null) {
                ViewGroup viewGroup = (ViewGroup) actionMenuView.getParent();
                if (viewGroup != null) {
                    viewGroup.removeView(this.mMenuView);
                }
                if (z) {
                    ViewGroup viewGroup2 = this.mSplitView;
                    if (viewGroup2 != null) {
                        viewGroup2.addView(this.mMenuView);
                    }
                    this.mMenuView.getLayoutParams().width = -1;
                } else {
                    addSystemView(this.mMenuView, false);
                    this.mMenuView.getLayoutParams().width = -2;
                }
                this.mMenuView.requestLayout();
            }
        }
    }

    public void setSplitView(ViewGroup viewGroup) {
        this.mSplitView = viewGroup;
    }

    public void setSubtitle(@StringRes int i) {
        setSubtitle(getContext().getText(i));
    }

    public void setSubtitleTextAppearance(Context context, @StyleRes int i) {
        this.mSubtitleTextAppearance = i;
        TextView textView = this.mSubtitleTextView;
        if (textView != null) {
            textView.setTextAppearance(context, i);
        }
    }

    public void setSubtitleTextColor(@ColorInt int i) {
        this.mSubtitleTextColor = i;
        TextView textView = this.mSubtitleTextView;
        if (textView != null) {
            textView.setTextColor(i);
        }
    }

    public void setTitle(@StringRes int i) {
        setTitle(getContext().getText(i));
    }

    public void setTitleTextAppearance(Context context, @StyleRes int i) {
        this.mTitleTextAppearance = i;
        TextView textView = this.mTitleTextView;
        if (textView != null) {
            textView.setTextAppearance(context, i);
        }
    }

    public void setTitleTextColor(@ColorInt int i) {
        this.mTitleTextColor = i;
        TextView textView = this.mTitleTextView;
        if (textView != null) {
            textView.setTextColor(i);
        }
    }

    public boolean showOverflowMenu() {
        ActionMenuView actionMenuView = this.mMenuView;
        return actionMenuView != null && actionMenuView.showOverflowMenu();
    }

    public static class LayoutParams extends ActionBar.LayoutParams {
        static final int CUSTOM = 0;
        static final int EXPANDED = 2;
        static final int SYSTEM = 1;
        int mViewType;

        public LayoutParams(@NonNull Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.mViewType = 0;
        }

        public void copyMarginsFromCompat(ViewGroup.MarginLayoutParams marginLayoutParams) {
            this.leftMargin = marginLayoutParams.leftMargin;
            this.topMargin = marginLayoutParams.topMargin;
            this.rightMargin = marginLayoutParams.rightMargin;
            this.bottomMargin = marginLayoutParams.bottomMargin;
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.mViewType = 0;
            this.gravity = 8388627;
        }

        public LayoutParams(int i, int i2, int i3) {
            super(i, i2);
            this.mViewType = 0;
            this.gravity = i3;
        }

        public LayoutParams(int i) {
            this(-2, -1, i);
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((ActionBar.LayoutParams) layoutParams);
            this.mViewType = 0;
            this.mViewType = layoutParams.mViewType;
        }

        public LayoutParams(ActionBar.LayoutParams layoutParams) {
            super(layoutParams);
            this.mViewType = 0;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super((ViewGroup.LayoutParams) marginLayoutParams);
            this.mViewType = 0;
            copyMarginsFromCompat(marginLayoutParams);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.mViewType = 0;
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public Toolbar(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, CommonUtils.hasFullDisplay() ? R.attr.mzToolbarStyleFullScreen : androidx.appcompat.R.attr.toolbarStyle);
    }

    private int measureChildCollapseMargins(View view, int i, int i2, int i3, int i4, int[] iArr, boolean z) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int i5 = marginLayoutParams.leftMargin - iArr[0];
        int i6 = marginLayoutParams.rightMargin - iArr[1];
        int max = Math.max(0, i5) + Math.max(0, i6);
        iArr[0] = Math.max(0, -i5);
        iArr[1] = Math.max(0, -i6);
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight() + max + i2, marginLayoutParams.width);
        int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i3, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i4, marginLayoutParams.height);
        if (z && view.getMinimumWidth() > View.MeasureSpec.getSize(childMeasureSpec)) {
            childMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.getMode(childMeasureSpec));
        }
        view.measure(childMeasureSpec, childMeasureSpec2);
        return view.getMeasuredWidth() + max;
    }

    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    public void setLogo(Drawable drawable) {
        if (drawable != null) {
            ensureLogoView();
            if (!isChildOrHidden(this.mLogoView)) {
                addSystemView(this.mLogoView, true);
            }
        } else {
            ImageView imageView = this.mLogoView;
            if (imageView != null && isChildOrHidden(imageView)) {
                removeView(this.mLogoView);
                this.mHiddenViews.remove(this.mLogoView);
            }
        }
        ImageView imageView2 = this.mLogoView;
        if (imageView2 != null) {
            imageView2.setImageDrawable(drawable);
        }
    }

    public void setLogoDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            ensureLogoView();
        }
        ImageView imageView = this.mLogoView;
        if (imageView != null) {
            imageView.setContentDescription(charSequence);
        }
    }

    public void setNavigationContentDescription(@Nullable CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            ensureNavButtonView();
        }
        ImageButton imageButton = this.mNavButtonView;
        if (imageButton != null) {
            imageButton.setContentDescription(charSequence);
        }
    }

    public void setNavigationIcon(@Nullable Drawable drawable) {
        TextView textView;
        TextView textView2;
        if (drawable != null) {
            ensureNavButtonView();
            if (!isChildOrHidden(this.mNavButtonView)) {
                addSystemView(this.mNavButtonView, true);
            }
            if (!(this.mTitleTextAppearanceBack == 0 || (textView2 = this.mTitleTextView) == null)) {
                textView2.setTextAppearance(getContext(), this.mTitleTextAppearanceBack);
            }
        } else {
            ImageButton imageButton = this.mNavButtonView;
            if (imageButton != null && isChildOrHidden(imageButton)) {
                removeView(this.mNavButtonView);
                this.mHiddenViews.remove(this.mNavButtonView);
                setTouchDelegate((TouchDelegate) null);
                if (!(this.mTitleTextAppearance == 0 || (textView = this.mTitleTextView) == null)) {
                    textView.setTextAppearance(getContext(), this.mTitleTextAppearance);
                }
            }
        }
        ImageButton imageButton2 = this.mNavButtonView;
        if (imageButton2 != null) {
            imageButton2.setImageDrawable(drawable);
        }
    }

    public void setSubtitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.mSubtitleTextView == null) {
                Context context = getContext();
                TextView textView = new TextView(context);
                this.mSubtitleTextView = textView;
                textView.setSingleLine();
                this.mSubtitleTextView.setEllipsize(TextUtils.TruncateAt.END);
                int i = this.mSubtitleTextAppearance;
                if (i != 0) {
                    this.mSubtitleTextView.setTextAppearance(context, i);
                }
                int i2 = this.mSubtitleTextColor;
                if (i2 != 0) {
                    this.mSubtitleTextView.setTextColor(i2);
                }
            }
            if (!isChildOrHidden(this.mSubtitleTextView)) {
                addSystemView(this.mSubtitleTextView, true);
            }
        } else {
            TextView textView2 = this.mSubtitleTextView;
            if (textView2 != null && isChildOrHidden(textView2)) {
                removeView(this.mSubtitleTextView);
                this.mHiddenViews.remove(this.mSubtitleTextView);
            }
        }
        TextView textView3 = this.mSubtitleTextView;
        if (textView3 != null) {
            textView3.setText(charSequence);
        }
        this.mSubtitleText = charSequence;
    }

    public void setTitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.mTitleScrollView == null) {
                HorizontalScrollView horizontalScrollView = new HorizontalScrollView(getContext());
                this.mTitleScrollView = horizontalScrollView;
                horizontalScrollView.setHorizontalFadingEdgeEnabled(true);
                this.mTitleScrollView.setOverScrollMode(2);
                this.mTitleScrollView.setHorizontalScrollBarEnabled(false);
                this.mTitleScrollView.setMinimumWidth(getContext().getResources().getDimensionPixelSize(R.dimen.mz_toolbar_title_min_width));
            }
            if (this.mTitleTextView == null) {
                TextView textView = new TextView(getContext());
                this.mTitleTextView = textView;
                textView.setSingleLine();
            }
            if (shouldLayout(this.mNavButtonView) && this.mTitleTextAppearanceBack != 0) {
                this.mTitleTextView.setTextAppearance(getContext(), this.mTitleTextAppearanceBack);
            } else if (this.mTitleTextAppearance != 0) {
                this.mTitleTextView.setTextAppearance(getContext(), this.mTitleTextAppearance);
            }
            int i = this.mTitleTextColor;
            if (i != 0) {
                this.mTitleTextView.setTextColor(i);
            }
            this.mTitleScrollView.removeAllViews();
            this.mTitleScrollView.addView(this.mTitleTextView);
            if (!isChildOrHidden(this.mTitleScrollView)) {
                addSystemView(this.mTitleScrollView, true);
            }
        } else {
            HorizontalScrollView horizontalScrollView2 = this.mTitleScrollView;
            if (horizontalScrollView2 != null && isChildOrHidden(horizontalScrollView2)) {
                removeView(this.mTitleScrollView);
                this.mHiddenViews.remove(this.mTitleScrollView);
            }
        }
        TextView textView2 = this.mTitleTextView;
        if (textView2 != null) {
            textView2.setText(charSequence);
        }
        this.mTitleText = charSequence;
    }

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int expandedMenuItemId;
        boolean isOverflowOpen;

        public SavedState(Parcel parcel) {
            super(parcel);
            this.expandedMenuItemId = parcel.readInt();
            this.isOverflowOpen = parcel.readInt() != 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.expandedMenuItemId);
            parcel.writeInt(this.isOverflowOpen ? 1 : 0);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public Toolbar(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        RtlSpacingHelper rtlSpacingHelper = new RtlSpacingHelper();
        this.mContentInsets = rtlSpacingHelper;
        this.mGravity = 8388627;
        this.mTempViews = new ArrayList<>();
        this.mHiddenViews = new ArrayList<>();
        this.mTempMargins = new int[2];
        this.mMenuViewItemClickListener = new ActionMenuView.OnMenuItemClickListener() {
            public boolean onMenuItemClick(MenuItem menuItem) {
                if (Toolbar.this.mOnMenuItemClickListener != null) {
                    return Toolbar.this.mOnMenuItemClickListener.onMenuItemClick(menuItem);
                }
                return false;
            }
        };
        this.mShowOverflowMenuRunnable = new Runnable() {
            public void run() {
                Toolbar.this.showOverflowMenu();
            }
        };
        this.mVisAnimListener = new VisibilityAnimListener();
        TintTypedArray v = TintTypedArray.v(getContext(), attributeSet, androidx.appcompat.R.styleable.Toolbar, i, 0);
        this.mTitleTextAppearance = v.n(androidx.appcompat.R.styleable.Toolbar_titleTextAppearance, 0);
        this.mTitleTextAppearanceBack = v.n(R.styleable.Toolbar_mzTitleTextAppearanceBack, 0);
        this.mSubtitleTextAppearance = v.n(androidx.appcompat.R.styleable.Toolbar_subtitleTextAppearance, 0);
        this.mGravity = v.l(androidx.appcompat.R.styleable.Toolbar_android_gravity, this.mGravity);
        this.mButtonGravity = v.l(R.styleable.Toolbar_mzButtonGravity, 48);
        int e = v.e(androidx.appcompat.R.styleable.Toolbar_titleMargins, 0);
        this.mTitleMarginBottom = e;
        this.mTitleMarginTop = e;
        this.mTitleMarginEnd = e;
        this.mTitleMarginStartStyled = e;
        int e2 = v.e(androidx.appcompat.R.styleable.Toolbar_titleMarginStart, -1);
        if (e2 >= 0) {
            this.mTitleMarginStartStyled = e2;
        }
        int e3 = v.e(androidx.appcompat.R.styleable.Toolbar_titleMarginEnd, -1);
        if (e3 >= 0) {
            this.mTitleMarginEnd = e3;
        }
        int e4 = v.e(androidx.appcompat.R.styleable.Toolbar_titleMarginTop, -1);
        if (e4 >= 0) {
            this.mTitleMarginTop = e4;
        }
        int e5 = v.e(androidx.appcompat.R.styleable.Toolbar_titleMarginBottom, -1);
        if (e5 >= 0) {
            this.mTitleMarginBottom = e5;
        }
        this.mMaxButtonHeight = v.f(androidx.appcompat.R.styleable.Toolbar_maxButtonHeight, -1);
        int e6 = v.e(androidx.appcompat.R.styleable.Toolbar_contentInsetStart, Integer.MIN_VALUE);
        int e7 = v.e(androidx.appcompat.R.styleable.Toolbar_contentInsetEnd, Integer.MIN_VALUE);
        rtlSpacingHelper.setAbsolute(v.f(androidx.appcompat.R.styleable.Toolbar_contentInsetLeft, 0), v.f(androidx.appcompat.R.styleable.Toolbar_contentInsetRight, 0));
        if (!(e6 == Integer.MIN_VALUE && e7 == Integer.MIN_VALUE)) {
            rtlSpacingHelper.setRelative(e6, e7);
        }
        this.mCollapseIcon = v.g(androidx.appcompat.R.styleable.Toolbar_collapseIcon);
        this.mCollapseDescription = v.p(androidx.appcompat.R.styleable.Toolbar_collapseContentDescription);
        CharSequence p = v.p(androidx.appcompat.R.styleable.Toolbar_title);
        if (!TextUtils.isEmpty(p)) {
            setTitle(p);
        }
        CharSequence p2 = v.p(androidx.appcompat.R.styleable.Toolbar_subtitle);
        if (!TextUtils.isEmpty(p2)) {
            setSubtitle(p2);
        }
        this.mPopupContext = getContext();
        setPopupTheme(v.n(androidx.appcompat.R.styleable.Toolbar_popupTheme, 0));
        Drawable g = v.g(androidx.appcompat.R.styleable.Toolbar_navigationIcon);
        if (g != null) {
            setNavigationIcon(g);
        }
        CharSequence p3 = v.p(androidx.appcompat.R.styleable.Toolbar_navigationContentDescription);
        if (!TextUtils.isEmpty(p3)) {
            setNavigationContentDescription(p3);
        }
        Drawable g2 = v.g(androidx.appcompat.R.styleable.Toolbar_logo);
        if (g2 != null) {
            setLogo(g2);
        }
        CharSequence p4 = v.p(androidx.appcompat.R.styleable.Toolbar_logoDescription);
        if (!TextUtils.isEmpty(p4)) {
            setLogoDescription(p4);
        }
        if (v.s(androidx.appcompat.R.styleable.Toolbar_titleTextColor)) {
            setTitleTextColor(v.b(androidx.appcompat.R.styleable.Toolbar_titleTextColor, -1));
        }
        if (v.s(androidx.appcompat.R.styleable.Toolbar_subtitleTextColor)) {
            setSubtitleTextColor(v.b(androidx.appcompat.R.styleable.Toolbar_subtitleTextColor, -1));
        }
        this.mTitleMarginStartBack = v.f(R.styleable.Toolbar_mzTitleMarginStartBack, this.mTitleMarginStart);
        this.mTitleMarginStart = this.mTitleMarginStartStyled;
        v.w();
        this.mDrawableManager = AppCompatDrawableManager.b();
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LayoutParams) {
            return new LayoutParams((LayoutParams) layoutParams);
        }
        if (layoutParams instanceof ActionBar.LayoutParams) {
            return new LayoutParams((ActionBar.LayoutParams) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }
}
