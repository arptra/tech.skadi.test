package flyme.support.v7.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.ForwardingListener;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ActionProvider;
import com.meizu.common.util.ReflectUtils;
import flyme.support.v7.appcompat.R;
import flyme.support.v7.drawable.RippleDrawableComp;
import flyme.support.v7.view.ActionBarPolicy;
import flyme.support.v7.view.menu.ActionMenuItemView;
import flyme.support.v7.view.menu.BaseMenuPresenter;
import flyme.support.v7.view.menu.MenuBuilder;
import flyme.support.v7.view.menu.MenuItemImpl;
import flyme.support.v7.view.menu.MenuPopupHelper;
import flyme.support.v7.view.menu.MenuPresenter;
import flyme.support.v7.view.menu.MenuView;
import flyme.support.v7.view.menu.SubMenuBuilder;
import flyme.support.v7.widget.ActionMenuView;
import java.util.ArrayList;

@SuppressLint({"RestrictedApi"})
public class ActionMenuPresenter extends BaseMenuPresenter implements ActionProvider.SubUiVisibilityListener {
    private static final float BUTTON_OPACITY_FLOW_MENU_IDLE = 1.0f;
    private static final float BUTTON_OPACITY_FLOW_MENU_SHOWING = 0.2f;
    private static final String TAG = "ActionMenuPresenter";
    private final SparseBooleanArray mActionButtonGroups = new SparseBooleanArray();
    /* access modifiers changed from: private */
    public ActionButtonSubmenu mActionButtonPopup;
    private int mActionItemWidthLimit;
    private boolean mExpandedActionViewsExclusive;
    /* access modifiers changed from: private */
    public boolean mIsSplit;
    private int mMaxItems;
    private boolean mMaxItemsSet;
    private int mMinCellSize;
    private int mMinCellSizeInSplit;
    int mOpenSubMenuId;
    /* access modifiers changed from: private */
    public OverflowMenuButton mOverflowButton;
    /* access modifiers changed from: private */
    public Drawable mOverflowDrawable;
    /* access modifiers changed from: private */
    public OverflowPopup mOverflowPopup;
    private Drawable mPendingOverflowIcon;
    private boolean mPendingOverflowIconSet;
    private ActionMenuPopupCallback mPopupCallback;
    final PopupPresenterCallback mPopupPresenterCallback = new PopupPresenterCallback();
    /* access modifiers changed from: private */
    public OpenOverflowRunnable mPostedOpenRunnable;
    private boolean mReserveOverflow;
    private boolean mReserveOverflowSet;
    private View mScrapActionButtonView;
    private boolean mStrictWidthLimit;
    private int mWidthLimit;
    private boolean mWidthLimitSet;
    /* access modifiers changed from: private */
    public TouchDelegate overflowMenuButtonTouchDelegate;

    public class ActionButtonSubmenu extends MenuPopupHelper {
        private SubMenuBuilder mSubMenu;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ActionButtonSubmenu(Context context, SubMenuBuilder subMenuBuilder) {
            super(context, subMenuBuilder, (View) null, false, ActionMenuPresenter.this.isSplit() ? R.attr.mzActionOverflowMenuSplitStyle : androidx.appcompat.R.attr.actionOverflowMenuStyle);
            this.mSubMenu = subMenuBuilder;
            if (!((MenuItemImpl) subMenuBuilder.getItem()).isActionButton()) {
                setAnchorView(ActionMenuPresenter.this.mOverflowButton == null ? (View) ActionMenuPresenter.this.mMenuView : ActionMenuPresenter.this.mOverflowButton);
            }
            setCallback(ActionMenuPresenter.this.mPopupPresenterCallback);
            int size = subMenuBuilder.size();
            boolean z = false;
            int i = 0;
            while (true) {
                if (i >= size) {
                    break;
                }
                MenuItem item = subMenuBuilder.getItem(i);
                if (item.isVisible() && item.getIcon() != null) {
                    z = true;
                    break;
                }
                i++;
            }
            setForceShowIcon(z);
        }

        public void onDismiss() {
            super.onDismiss();
            ActionButtonSubmenu unused = ActionMenuPresenter.this.mActionButtonPopup = null;
            ActionMenuPresenter.this.mOpenSubMenuId = 0;
        }
    }

    public class ActionMenuPopupCallback extends ActionMenuItemView.PopupCallback {
        private ActionMenuPopupCallback() {
        }

        public ListPopupWindow getPopup() {
            if (ActionMenuPresenter.this.mActionButtonPopup != null) {
                return ActionMenuPresenter.this.mActionButtonPopup.getPopup();
            }
            return null;
        }
    }

    public class ActionMenuRippleDrawable extends RippleDrawableComp {
        public ActionMenuRippleDrawable(View view) {
            super(view, R.attr.mzActionButtonRippleSplitStyle);
        }
    }

    public class OpenOverflowRunnable implements Runnable {
        private OverflowPopup mPopup;

        public OpenOverflowRunnable(OverflowPopup overflowPopup) {
            this.mPopup = overflowPopup;
        }

        public void run() {
            ActionMenuPresenter.this.mMenu.changeMenuMode();
            View view = (View) ActionMenuPresenter.this.mMenuView;
            if (!(view == null || view.getWindowToken() == null || !this.mPopup.tryShow())) {
                OverflowPopup unused = ActionMenuPresenter.this.mOverflowPopup = this.mPopup;
                ActionMenuPresenter.this.mOverflowButton.setAlpha(0.2f);
            }
            OpenOverflowRunnable unused2 = ActionMenuPresenter.this.mPostedOpenRunnable = null;
        }
    }

    public class OverflowMenuButton extends AppCompatImageView implements ActionMenuView.ActionMenuChildView {
        private final Paint mPaint;
        private final int mSpotColor;
        private final float mSpotRadius;
        private boolean mSpotVisible;
        private final float[] mTempPts;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public OverflowMenuButton(Context context) {
            super(context, (AttributeSet) null, ActionMenuPresenter.this.mIsSplit ? R.attr.mzActionOverflowButtonSplitStyle : androidx.appcompat.R.attr.actionOverflowButtonStyle);
            this.mTempPts = new float[2];
            this.mSpotColor = -65536;
            setId(R.id.mz_action_overflow_button);
            setClickable(true);
            setFocusable(true);
            setVisibility(0);
            setEnabled(true);
            setOnTouchListener(new ForwardingListener(this, ActionMenuPresenter.this) {
                public boolean onForwardingStarted() {
                    ActionMenuPresenter.this.showOverflowMenu();
                    return true;
                }

                public boolean onForwardingStopped() {
                    if (ActionMenuPresenter.this.mPostedOpenRunnable != null) {
                        return false;
                    }
                    ActionMenuPresenter.this.hideOverflowMenu();
                    return true;
                }

                public ListPopupWindow getPopup() {
                    if (ActionMenuPresenter.this.mOverflowPopup == null) {
                        return null;
                    }
                    return ActionMenuPresenter.this.mOverflowPopup.getPopup();
                }
            });
            if (ActionMenuPresenter.this.isSplit()) {
                setBackgroundDrawable(new ActionMenuRippleDrawable(this));
            }
            if (ActionMenuPresenter.this.mOverflowDrawable != null) {
                setImageDrawable(ActionMenuPresenter.this.mOverflowDrawable);
            }
            setContentDescription(getResources().getString(androidx.appcompat.R.string.abc_action_menu_overflow_description));
            this.mSpotRadius = context.getResources().getDimension(com.meizu.common.R.dimen.mc_new_message_view_radius);
            Paint paint = new Paint();
            this.mPaint = paint;
            paint.setAntiAlias(true);
            paint.setColor(-65536);
            paint.setStyle(Paint.Style.FILL);
        }

        public boolean needsDividerAfter() {
            return false;
        }

        public boolean needsDividerBefore() {
            return false;
        }

        public void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            if (this.mSpotVisible) {
                try {
                    Matrix matrix = (Matrix) ReflectUtils.from((Object) this).field("mDrawMatrix").get(this);
                    canvas.save();
                    canvas.translate((float) getPaddingLeft(), (float) getPaddingTop());
                    if (matrix != null) {
                        canvas.concat(matrix);
                    }
                    Rect bounds = getDrawable().getBounds();
                    float f = this.mSpotRadius;
                    canvas.drawCircle(((float) bounds.right) + f, ((float) bounds.top) + f, f, this.mPaint);
                    canvas.restore();
                } catch (Exception unused) {
                }
            }
        }

        public void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
            int i5 = (int) (getResources().getDisplayMetrics().density * 52.0f);
            int i6 = i3 - i;
            if (i6 < i5) {
                int i7 = (i5 - i6) / 2;
                TouchDelegate unused = ActionMenuPresenter.this.overflowMenuButtonTouchDelegate = new TouchDelegate(new Rect(i - i7, i2, i3 + i7, i4), this);
                ((View) getParent()).setTouchDelegate(ActionMenuPresenter.this.overflowMenuButtonTouchDelegate);
            }
        }

        public boolean performClick() {
            if (super.performClick()) {
                return true;
            }
            playSoundEffect(0);
            ActionMenuPresenter.this.showOverflowMenu();
            return true;
        }

        public boolean setFrame(int i, int i2, int i3, int i4) {
            boolean frame = super.setFrame(i, i2, i3, i4);
            Drawable drawable = getDrawable();
            Drawable background = getBackground();
            int paddingLeft = getPaddingLeft() - getPaddingRight();
            int paddingTop = getPaddingTop() - getPaddingBottom();
            if (!(drawable == null || background == null || (paddingLeft == 0 && paddingTop == 0))) {
                int width = getWidth();
                int height = getHeight();
                int i5 = width / 2;
                int i6 = height / 2;
                int i7 = (width + paddingLeft) / 2;
                int i8 = (height + paddingTop) / 2;
                DrawableCompat.l(background, i7 - i5, i8 - i6, i7 + i5, i8 + i6);
            }
            return frame;
        }

        public void setSpotVisible(boolean z) {
            if (this.mSpotVisible != z) {
                this.mSpotVisible = z;
                invalidate();
            }
        }
    }

    public class OverflowPopup extends MenuPopupHelper {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public OverflowPopup(Context context, MenuBuilder menuBuilder, View view, boolean z) {
            super(context, menuBuilder, view, z, ActionMenuPresenter.this.isSplit() ? R.attr.mzActionOverflowMenuSplitStyle : androidx.appcompat.R.attr.actionOverflowMenuStyle);
            applyFlymeAnimation(ActionMenuPresenter.this.isSplit() ? 4 : 3);
            setGravity(8388613);
            setCallback(ActionMenuPresenter.this.mPopupPresenterCallback);
        }

        public void onDismiss() {
            super.onDismiss();
            if (ActionMenuPresenter.this.mMenu != null) {
                ActionMenuPresenter.this.mMenu.close();
            }
            OverflowPopup unused = ActionMenuPresenter.this.mOverflowPopup = null;
            ActionMenuPresenter.this.mOverflowButton.setAlpha(1.0f);
        }
    }

    public class PopupPresenterCallback implements MenuPresenter.Callback {
        private PopupPresenterCallback() {
        }

        public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
            if (menuBuilder instanceof SubMenuBuilder) {
                menuBuilder.getRootMenu().close(false);
            }
            MenuPresenter.Callback callback = ActionMenuPresenter.this.getCallback();
            if (callback != null) {
                callback.onCloseMenu(menuBuilder, z);
            }
        }

        public boolean onOpenSubMenu(MenuBuilder menuBuilder) {
            if (menuBuilder == null) {
                return false;
            }
            ActionMenuPresenter.this.mOpenSubMenuId = ((SubMenuBuilder) menuBuilder).getItem().getItemId();
            MenuPresenter.Callback callback = ActionMenuPresenter.this.getCallback();
            return callback != null && callback.onOpenSubMenu(menuBuilder);
        }
    }

    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        public int openSubMenuId;

        public SavedState() {
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.openSubMenuId);
        }

        public SavedState(Parcel parcel) {
            this.openSubMenuId = parcel.readInt();
        }
    }

    public ActionMenuPresenter(Context context) {
        super(context, R.layout.mz_abc_action_menu_layout, R.layout.mz_action_menu_item_layout);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x002b A[Catch:{ Exception -> 0x0032 }] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0034 A[Catch:{ Exception -> 0x0032 }] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x003c A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.view.View findAnchor(android.view.View r5) {
        /*
            r4 = this;
            android.content.Context r0 = r4.mContext     // Catch:{ Exception -> 0x003d }
            boolean r1 = r0 instanceof androidx.appcompat.view.ContextThemeWrapper     // Catch:{ Exception -> 0x003d }
            if (r1 == 0) goto L_0x0010
            androidx.appcompat.view.ContextThemeWrapper r0 = (androidx.appcompat.view.ContextThemeWrapper) r0     // Catch:{ Exception -> 0x003d }
            android.content.Context r0 = r0.getBaseContext()     // Catch:{ Exception -> 0x003d }
            android.app.Activity r0 = (android.app.Activity) r0     // Catch:{ Exception -> 0x003d }
        L_0x000e:
            r1 = r5
            goto L_0x0025
        L_0x0010:
            boolean r1 = r0 instanceof android.app.Activity     // Catch:{ Exception -> 0x003d }
            if (r1 == 0) goto L_0x0023
            r1 = r0
            android.app.Activity r1 = (android.app.Activity) r1     // Catch:{ Exception -> 0x003d }
            android.app.Activity r0 = (android.app.Activity) r0     // Catch:{ Exception -> 0x003d }
            int r2 = flyme.support.v7.appcompat.R.id.action_bar     // Catch:{ Exception -> 0x003d }
            android.view.View r0 = r0.findViewById(r2)     // Catch:{ Exception -> 0x003d }
            r3 = r1
            r1 = r0
            r0 = r3
            goto L_0x0025
        L_0x0023:
            r0 = 0
            goto L_0x000e
        L_0x0025:
            boolean r4 = r4.isSplit()     // Catch:{ Exception -> 0x0032 }
            if (r4 != 0) goto L_0x0034
            int r4 = flyme.support.v7.appcompat.R.id.action_bar     // Catch:{ Exception -> 0x0032 }
            android.view.View r4 = r0.findViewById(r4)     // Catch:{ Exception -> 0x0032 }
            goto L_0x003a
        L_0x0032:
            r5 = r1
            goto L_0x003d
        L_0x0034:
            int r4 = flyme.support.v7.appcompat.R.id.split_action_bar     // Catch:{ Exception -> 0x0032 }
            android.view.View r4 = r0.findViewById(r4)     // Catch:{ Exception -> 0x0032 }
        L_0x003a:
            if (r4 != 0) goto L_0x003e
            return r5
        L_0x003d:
            r4 = r5
        L_0x003e:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: flyme.support.v7.widget.ActionMenuPresenter.findAnchor(android.view.View):android.view.View");
    }

    private View findViewForItem(MenuItem menuItem) {
        ViewGroup viewGroup = (ViewGroup) this.mMenuView;
        if (viewGroup == null) {
            return null;
        }
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if ((childAt instanceof MenuView.ItemView) && ((MenuView.ItemView) childAt).getItemData() == menuItem) {
                return childAt;
            }
        }
        return null;
    }

    private boolean flagActionItemsInSplit() {
        ArrayList<MenuItemImpl> visibleItems = this.mMenu.getVisibleItems();
        int size = visibleItems.size();
        int i = this.mWidthLimit;
        boolean z = false;
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            MenuItemImpl menuItemImpl = visibleItems.get(i4);
            if (menuItemImpl.requiresActionButton()) {
                i2++;
            } else if (menuItemImpl.requestsActionButton()) {
                i3++;
            } else {
                z = true;
            }
        }
        boolean z2 = this.mReserveOverflow && z;
        SparseBooleanArray sparseBooleanArray = this.mActionButtonGroups;
        sparseBooleanArray.clear();
        int i5 = this.mStrictWidthLimit ? i / this.mMinCellSizeInSplit : 0;
        int i6 = i2 + i3;
        if ((i6 > i5) || z2) {
            i5--;
        }
        if (i6 >= i5) {
            i6 = i5;
        }
        int i7 = 0;
        while (i7 < size && i6 > 0) {
            MenuItemImpl menuItemImpl2 = visibleItems.get(i7);
            if (menuItemImpl2.requiresActionButton() || menuItemImpl2.requestsActionButton()) {
                i6--;
                menuItemImpl2.setIsActionButton(true);
                int groupId = menuItemImpl2.getGroupId();
                if (groupId != 0) {
                    sparseBooleanArray.put(groupId, true);
                }
            } else {
                menuItemImpl2.setIsActionButton(false);
            }
            i7++;
        }
        for (int i8 = i7; i8 < size; i8++) {
            visibleItems.get(i7).setIsActionButton(false);
        }
        return true;
    }

    public void addItemView(View view, int i) {
        super.addItemView(view, i);
        if ((this.mMenuView instanceof ActionMenuView) && (view instanceof ActionMenuItemView)) {
            ((ActionMenuView.LayoutParams) view.getLayoutParams()).isOverflowButton = ((ActionMenuItemView) view).isOverflowActor();
        }
    }

    public void bindItemView(MenuItemImpl menuItemImpl, MenuView.ItemView itemView) {
        ((ActionMenuItemView) itemView).setIsInSplit(this.mIsSplit);
        itemView.initialize(menuItemImpl, 0);
        ActionMenuItemView actionMenuItemView = (ActionMenuItemView) itemView;
        actionMenuItemView.setItemInvoker((ActionMenuView) this.mMenuView);
        if (this.mPopupCallback == null) {
            this.mPopupCallback = new ActionMenuPopupCallback();
        }
        actionMenuItemView.setPopupCallback(this.mPopupCallback);
    }

    public MenuView.ItemView createItemView(ViewGroup viewGroup) {
        MenuView.ItemView createItemView = super.createItemView(viewGroup);
        if (createItemView instanceof View) {
            View view = (View) createItemView;
        }
        return createItemView;
    }

    public boolean dismissPopupMenus() {
        return hideSubMenus() | hideOverflowMenu();
    }

    public boolean filterLeftoverView(ViewGroup viewGroup, int i) {
        if (viewGroup.getChildAt(i) == this.mOverflowButton) {
            return false;
        }
        return super.filterLeftoverView(viewGroup, i);
    }

    public boolean flagActionItems() {
        int i;
        int i2;
        int i3;
        boolean z;
        int i4;
        if (this.mIsSplit) {
            return flagActionItemsInSplit();
        }
        ArrayList<MenuItemImpl> visibleItems = this.mMenu.getVisibleItems();
        int size = visibleItems.size();
        int i5 = this.mMaxItems;
        int i6 = this.mActionItemWidthLimit;
        boolean z2 = false;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup viewGroup = (ViewGroup) this.mMenuView;
        boolean z3 = false;
        int i7 = 0;
        int i8 = 0;
        for (int i9 = 0; i9 < size; i9++) {
            MenuItemImpl menuItemImpl = visibleItems.get(i9);
            if (menuItemImpl.requiresActionButton()) {
                i7++;
            } else if (menuItemImpl.requestsActionButton()) {
                i8++;
            } else {
                z3 = true;
            }
            if (this.mExpandedActionViewsExclusive && menuItemImpl.isActionViewExpanded()) {
                i5 = 0;
            }
        }
        if (this.mReserveOverflow && (z3 || i8 + i7 > i5)) {
            i5--;
        }
        int i10 = i5 - i7;
        SparseBooleanArray sparseBooleanArray = this.mActionButtonGroups;
        sparseBooleanArray.clear();
        if (this.mStrictWidthLimit) {
            int i11 = this.mMinCellSize;
            i = i6 / i11;
            i2 = i11 + ((i6 % i11) / i);
        } else {
            i2 = 0;
            i = 0;
        }
        int i12 = 0;
        int i13 = 0;
        while (i12 < size) {
            MenuItemImpl menuItemImpl2 = visibleItems.get(i12);
            if (menuItemImpl2.requiresActionButton()) {
                View itemView = getItemView(menuItemImpl2, this.mScrapActionButtonView, viewGroup);
                if (this.mScrapActionButtonView == null) {
                    this.mScrapActionButtonView = itemView;
                }
                if (this.mStrictWidthLimit) {
                    i -= ActionMenuView.measureChildForCells(itemView, i2, i, makeMeasureSpec, z2 ? 1 : 0);
                } else {
                    itemView.measure(makeMeasureSpec, makeMeasureSpec);
                }
                int measuredWidth = itemView.getMeasuredWidth();
                i6 -= measuredWidth;
                if (i13 == 0) {
                    i13 = measuredWidth;
                }
                int groupId = menuItemImpl2.getGroupId();
                if (groupId != 0) {
                    sparseBooleanArray.put(groupId, true);
                }
                menuItemImpl2.setIsActionButton(true);
                i3 = size;
                z = z2;
            } else if (menuItemImpl2.requestsActionButton()) {
                int groupId2 = menuItemImpl2.getGroupId();
                boolean z4 = sparseBooleanArray.get(groupId2);
                boolean z5 = (i10 > 0 || z4) && i6 > 0 && (!this.mStrictWidthLimit || i > 0);
                i3 = size;
                if (z5) {
                    View itemView2 = getItemView(menuItemImpl2, this.mScrapActionButtonView, viewGroup);
                    i4 = i10;
                    if (this.mScrapActionButtonView == null) {
                        this.mScrapActionButtonView = itemView2;
                    }
                    if (this.mStrictWidthLimit) {
                        int measureChildForCells = ActionMenuView.measureChildForCells(itemView2, i2, i, makeMeasureSpec, 0);
                        i -= measureChildForCells;
                        if (measureChildForCells == 0) {
                            z5 = false;
                        }
                    } else {
                        itemView2.measure(makeMeasureSpec, makeMeasureSpec);
                    }
                    int measuredWidth2 = itemView2.getMeasuredWidth();
                    i6 -= measuredWidth2;
                    if (i13 == 0) {
                        i13 = measuredWidth2;
                    }
                    z5 &= !this.mStrictWidthLimit ? !(i12 != 0 ? i6 < 0 : i6 + i13 <= 0) : i6 >= 0;
                } else {
                    i4 = i10;
                }
                if (z5 && groupId2 != 0) {
                    sparseBooleanArray.put(groupId2, true);
                } else if (z4) {
                    sparseBooleanArray.put(groupId2, false);
                    for (int i14 = 0; i14 < i12; i14++) {
                        MenuItemImpl menuItemImpl3 = visibleItems.get(i14);
                        if (menuItemImpl3.getGroupId() == groupId2) {
                            if (menuItemImpl3.isActionButton()) {
                                i4++;
                            }
                            menuItemImpl3.setIsActionButton(false);
                        }
                    }
                }
                i10 = i4;
                if (z5) {
                    i10--;
                }
                menuItemImpl2.setIsActionButton(z5);
                z = false;
            } else {
                i3 = size;
                int i15 = i10;
                z = z2;
                menuItemImpl2.setIsActionButton(z);
            }
            i12++;
            z2 = z;
            size = i3;
        }
        return true;
    }

    public View getItemView(MenuItemImpl menuItemImpl, View view, ViewGroup viewGroup) {
        View actionView = menuItemImpl.getActionView();
        if (actionView == null || menuItemImpl.hasCollapsibleActionView()) {
            actionView = super.getItemView(menuItemImpl, view, viewGroup);
        }
        actionView.setVisibility(menuItemImpl.isActionViewExpanded() ? 8 : 0);
        ActionMenuView actionMenuView = (ActionMenuView) viewGroup;
        ViewGroup.LayoutParams layoutParams = actionView.getLayoutParams();
        if (!actionMenuView.checkLayoutParams(layoutParams)) {
            actionView.setLayoutParams(actionMenuView.generateLayoutParams(layoutParams));
        } else if ((layoutParams instanceof ActionMenuView.LayoutParams) && (actionView instanceof ActionMenuItemView)) {
            ((ActionMenuView.LayoutParams) layoutParams).isOverflowButton = ((ActionMenuItemView) actionView).isOverflowActor();
        }
        return actionView;
    }

    public MenuView getMenuView(ViewGroup viewGroup) {
        MenuView menuView = super.getMenuView(viewGroup);
        ((ActionMenuView) menuView).setPresenter(this);
        return menuView;
    }

    public Drawable getOverflowIcon() {
        OverflowMenuButton overflowMenuButton = this.mOverflowButton;
        if (overflowMenuButton != null) {
            return overflowMenuButton.getDrawable();
        }
        if (this.mPendingOverflowIconSet) {
            return this.mPendingOverflowIcon;
        }
        return null;
    }

    public boolean hideOverflowMenu() {
        MenuView menuView;
        OpenOverflowRunnable openOverflowRunnable = this.mPostedOpenRunnable;
        if (openOverflowRunnable == null || (menuView = this.mMenuView) == null) {
            OverflowPopup overflowPopup = this.mOverflowPopup;
            if (overflowPopup == null) {
                return false;
            }
            overflowPopup.dismiss();
            return true;
        }
        ((View) menuView).removeCallbacks(openOverflowRunnable);
        this.mPostedOpenRunnable = null;
        return true;
    }

    public boolean hideSubMenus() {
        ActionButtonSubmenu actionButtonSubmenu = this.mActionButtonPopup;
        if (actionButtonSubmenu == null) {
            return false;
        }
        actionButtonSubmenu.dismiss();
        return true;
    }

    public void initForMenu(Context context, MenuBuilder menuBuilder) {
        super.initForMenu(context, menuBuilder);
        Resources resources = context.getResources();
        ActionBarPolicy actionBarPolicy = ActionBarPolicy.get(context);
        if (!this.mReserveOverflowSet) {
            this.mReserveOverflow = actionBarPolicy.showsOverflowMenuButton();
        }
        if (!this.mWidthLimitSet) {
            this.mWidthLimit = actionBarPolicy.getEmbeddedMenuWidthLimit();
        }
        if (!this.mMaxItemsSet) {
            this.mMaxItems = actionBarPolicy.getMaxActionButtons();
        }
        int i = this.mWidthLimit;
        if (this.mReserveOverflow) {
            if (this.mOverflowButton == null) {
                OverflowMenuButton overflowMenuButton = new OverflowMenuButton(this.mSystemContext);
                this.mOverflowButton = overflowMenuButton;
                if (this.mPendingOverflowIconSet) {
                    overflowMenuButton.setImageDrawable(this.mPendingOverflowIcon);
                    this.mPendingOverflowIcon = null;
                    this.mPendingOverflowIconSet = false;
                }
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                this.mOverflowButton.measure(makeMeasureSpec, makeMeasureSpec);
            }
            i -= this.mOverflowButton.getMeasuredWidth();
        } else {
            this.mOverflowButton = null;
        }
        this.mActionItemWidthLimit = i;
        this.mMinCellSize = (int) (resources.getDisplayMetrics().density * 56.0f);
        this.mScrapActionButtonView = null;
        this.mMinCellSizeInSplit = (int) (resources.getDisplayMetrics().density * 60.0f);
    }

    public boolean isOverflowMenuShowPending() {
        return this.mPostedOpenRunnable != null || isOverflowMenuShowing();
    }

    public boolean isOverflowMenuShowing() {
        OverflowPopup overflowPopup = this.mOverflowPopup;
        return overflowPopup != null && overflowPopup.isShowing();
    }

    public boolean isOverflowReserved() {
        return this.mReserveOverflow;
    }

    public boolean isSplit() {
        return this.mIsSplit;
    }

    public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
        dismissPopupMenus();
        super.onCloseMenu(menuBuilder, z);
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (!this.mMaxItemsSet) {
            this.mMaxItems = this.mContext.getResources().getInteger(R.integer.abc_max_action_buttons);
        }
        MenuBuilder menuBuilder = this.mMenu;
        if (menuBuilder != null) {
            menuBuilder.onItemsChanged(true);
        }
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        int i;
        MenuItem findItem;
        if ((parcelable instanceof SavedState) && (i = ((SavedState) parcelable).openSubMenuId) > 0 && (findItem = this.mMenu.findItem(i)) != null) {
            onSubMenuSelected((SubMenuBuilder) findItem.getSubMenu());
        }
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState();
        savedState.openSubMenuId = this.mOpenSubMenuId;
        return savedState;
    }

    public boolean onSubMenuSelected(SubMenuBuilder subMenuBuilder) {
        if (!subMenuBuilder.hasVisibleItems()) {
            return false;
        }
        SubMenuBuilder subMenuBuilder2 = subMenuBuilder;
        while (subMenuBuilder2.getParentMenu() != this.mMenu) {
            subMenuBuilder2 = (SubMenuBuilder) subMenuBuilder2.getParentMenu();
        }
        final View findViewForItem = findViewForItem(subMenuBuilder2.getItem());
        if (findViewForItem == null && (findViewForItem = this.mOverflowButton) == null) {
            return false;
        }
        this.mOpenSubMenuId = subMenuBuilder.getItem().getItemId();
        ActionButtonSubmenu actionButtonSubmenu = new ActionButtonSubmenu(this.mContext, subMenuBuilder);
        this.mActionButtonPopup = actionButtonSubmenu;
        actionButtonSubmenu.setGravity(8388613);
        this.mActionButtonPopup.applyFlymeAnimation(4);
        this.mActionButtonPopup.setAnchorView(findViewForItem);
        this.mActionButtonPopup.show();
        findViewForItem.post(new Runnable() {
            public void run() {
                View view = findViewForItem;
                if (view != null && view.getWindowToken() != null && ActionMenuPresenter.this.mActionButtonPopup.isShowing()) {
                    findViewForItem.setAlpha(0.2f);
                }
            }
        });
        this.mActionButtonPopup.getPopup().setOnDismissListener(new PopupWindow.OnDismissListener() {
            public void onDismiss() {
                findViewForItem.setAlpha(1.0f);
            }
        });
        super.onSubMenuSelected(subMenuBuilder);
        return true;
    }

    public void onSubUiVisibilityChanged(boolean z) {
        if (z) {
            super.onSubMenuSelected((SubMenuBuilder) null);
        } else {
            this.mMenu.close(false);
        }
    }

    public void setExpandedActionViewsExclusive(boolean z) {
        this.mExpandedActionViewsExclusive = z;
    }

    public void setIsSplit(boolean z) {
        if (this.mIsSplit != z) {
            this.mIsSplit = z;
            setItemLayoutRes(z ? R.layout.mz_action_menu_item_split_layout : R.layout.mz_action_menu_item_layout);
            MenuView menuView = this.mMenuView;
            if (menuView != null) {
                ((ViewGroup) menuView).removeAllViews();
            }
            if (!z) {
                this.mReserveOverflowSet = false;
                this.mWidthLimitSet = false;
                this.mMaxItemsSet = false;
                initForMenu(this.mContext, this.mMenu);
            }
        }
    }

    public void setItemLimit(int i) {
        this.mMaxItems = i;
        this.mMaxItemsSet = true;
    }

    public void setMenuView(ActionMenuView actionMenuView) {
        this.mMenuView = actionMenuView;
        actionMenuView.initialize(this.mMenu);
    }

    public void setOverflowDrawable(Drawable drawable) {
        this.mOverflowDrawable = drawable;
        OverflowMenuButton overflowMenuButton = this.mOverflowButton;
        if (overflowMenuButton != null) {
            overflowMenuButton.setImageDrawable(drawable);
        }
    }

    public void setOverflowIcon(Drawable drawable) {
        OverflowMenuButton overflowMenuButton = this.mOverflowButton;
        if (overflowMenuButton != null) {
            overflowMenuButton.setImageDrawable(drawable);
            return;
        }
        this.mPendingOverflowIconSet = true;
        this.mPendingOverflowIcon = drawable;
    }

    public void setReserveOverflow(boolean z) {
        this.mReserveOverflow = z;
        this.mReserveOverflowSet = true;
    }

    public void setWidthLimit(int i, boolean z) {
        this.mWidthLimit = i;
        this.mStrictWidthLimit = z;
        this.mWidthLimitSet = true;
    }

    public boolean shouldIncludeItem(int i, MenuItemImpl menuItemImpl) {
        return menuItemImpl.isActionButton();
    }

    public boolean showOverflowMenu() {
        MenuBuilder menuBuilder;
        if (!this.mReserveOverflow || isOverflowMenuShowing() || (menuBuilder = this.mMenu) == null || this.mMenuView == null || this.mPostedOpenRunnable != null || menuBuilder.getNonActionItems().isEmpty()) {
            return false;
        }
        OpenOverflowRunnable openOverflowRunnable = new OpenOverflowRunnable(new OverflowPopup(this.mContext, this.mMenu, this.mOverflowButton, true));
        this.mPostedOpenRunnable = openOverflowRunnable;
        ((View) this.mMenuView).post(openOverflowRunnable);
        super.onSubMenuSelected((SubMenuBuilder) null);
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00ad  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00c9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void updateMenuView(boolean r8) {
        /*
            r7 = this;
            super.updateMenuView(r8)
            flyme.support.v7.view.menu.MenuView r8 = r7.mMenuView
            android.view.View r8 = (android.view.View) r8
            r8.requestLayout()
            flyme.support.v7.view.menu.MenuBuilder r8 = r7.mMenu
            r0 = 0
            if (r8 == 0) goto L_0x002c
            java.util.ArrayList r8 = r8.getActionItems()
            int r1 = r8.size()
            r2 = r0
        L_0x0018:
            if (r2 >= r1) goto L_0x002c
            java.lang.Object r3 = r8.get(r2)
            flyme.support.v7.view.menu.MenuItemImpl r3 = (flyme.support.v7.view.menu.MenuItemImpl) r3
            androidx.core.view.ActionProvider r3 = r3.getSupportActionProvider()
            if (r3 == 0) goto L_0x0029
            r3.setSubUiVisibilityListener(r7)
        L_0x0029:
            int r2 = r2 + 1
            goto L_0x0018
        L_0x002c:
            flyme.support.v7.view.menu.MenuBuilder r8 = r7.mMenu
            r1 = 0
            if (r8 == 0) goto L_0x0036
            java.util.ArrayList r8 = r8.getNonActionItems()
            goto L_0x0037
        L_0x0036:
            r8 = r1
        L_0x0037:
            boolean r2 = r7.mReserveOverflow
            r3 = 1
            if (r2 == 0) goto L_0x0054
            if (r8 == 0) goto L_0x0054
            int r2 = r8.size()
            if (r2 != r3) goto L_0x0050
            java.lang.Object r2 = r8.get(r0)
            flyme.support.v7.view.menu.MenuItemImpl r2 = (flyme.support.v7.view.menu.MenuItemImpl) r2
            boolean r2 = r2.isActionViewExpanded()
            r2 = r2 ^ r3
            goto L_0x0055
        L_0x0050:
            if (r2 <= 0) goto L_0x0054
            r2 = r3
            goto L_0x0055
        L_0x0054:
            r2 = r0
        L_0x0055:
            if (r2 == 0) goto L_0x00ad
            flyme.support.v7.widget.ActionMenuPresenter$OverflowMenuButton r4 = r7.mOverflowButton
            if (r4 != 0) goto L_0x0064
            flyme.support.v7.widget.ActionMenuPresenter$OverflowMenuButton r4 = new flyme.support.v7.widget.ActionMenuPresenter$OverflowMenuButton
            android.content.Context r5 = r7.mSystemContext
            r4.<init>(r5)
            r7.mOverflowButton = r4
        L_0x0064:
            flyme.support.v7.widget.ActionMenuPresenter$OverflowMenuButton r4 = r7.mOverflowButton
            android.view.ViewParent r4 = r4.getParent()
            android.view.ViewGroup r4 = (android.view.ViewGroup) r4
            flyme.support.v7.view.menu.MenuView r5 = r7.mMenuView
            if (r4 == r5) goto L_0x008c
            if (r4 == 0) goto L_0x007a
            flyme.support.v7.widget.ActionMenuPresenter$OverflowMenuButton r5 = r7.mOverflowButton
            r4.removeView(r5)
            r4.setTouchDelegate(r1)
        L_0x007a:
            flyme.support.v7.view.menu.MenuView r4 = r7.mMenuView
            flyme.support.v7.widget.ActionMenuView r4 = (flyme.support.v7.widget.ActionMenuView) r4
            flyme.support.v7.widget.ActionMenuPresenter$OverflowMenuButton r5 = r7.mOverflowButton
            flyme.support.v7.widget.ActionMenuView$LayoutParams r6 = r4.generateOverflowButtonLayoutParams()
            r4.addView(r5, r6)
            android.view.TouchDelegate r5 = r7.overflowMenuButtonTouchDelegate
            r4.setTouchDelegate(r5)
        L_0x008c:
            flyme.support.v7.widget.ActionMenuPresenter$OverflowMenuButton r4 = r7.mOverflowButton
            r4.setSpotVisible(r0)
            java.util.Iterator r8 = r8.iterator()
        L_0x0095:
            boolean r0 = r8.hasNext()
            if (r0 == 0) goto L_0x00c7
            java.lang.Object r0 = r8.next()
            flyme.support.v7.view.menu.MenuItemImpl r0 = (flyme.support.v7.view.menu.MenuItemImpl) r0
            boolean r0 = r0.isLittleSpotVisible()
            if (r0 == 0) goto L_0x0095
            flyme.support.v7.widget.ActionMenuPresenter$OverflowMenuButton r8 = r7.mOverflowButton
            r8.setSpotVisible(r3)
            goto L_0x00c7
        L_0x00ad:
            flyme.support.v7.widget.ActionMenuPresenter$OverflowMenuButton r8 = r7.mOverflowButton
            if (r8 == 0) goto L_0x00c7
            android.view.ViewParent r8 = r8.getParent()
            flyme.support.v7.view.menu.MenuView r0 = r7.mMenuView
            if (r8 != r0) goto L_0x00c7
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            flyme.support.v7.widget.ActionMenuPresenter$OverflowMenuButton r8 = r7.mOverflowButton
            r0.removeView(r8)
            flyme.support.v7.view.menu.MenuView r8 = r7.mMenuView
            android.view.ViewGroup r8 = (android.view.ViewGroup) r8
            r8.setTouchDelegate(r1)
        L_0x00c7:
            if (r2 != 0) goto L_0x00ee
            flyme.support.v7.view.menu.MenuBuilder r8 = r7.mMenu
            if (r8 == 0) goto L_0x00d1
            java.util.ArrayList r1 = r8.getVisibleItems()
        L_0x00d1:
            if (r1 == 0) goto L_0x00ee
            int r8 = r1.size()
            if (r8 <= 0) goto L_0x00ee
            java.util.Iterator r8 = r1.iterator()
        L_0x00dd:
            boolean r0 = r8.hasNext()
            if (r0 == 0) goto L_0x00ee
            java.lang.Object r0 = r8.next()
            flyme.support.v7.view.menu.MenuItemImpl r0 = (flyme.support.v7.view.menu.MenuItemImpl) r0
            boolean r2 = r0.isOverflowActor()
            goto L_0x00dd
        L_0x00ee:
            flyme.support.v7.view.menu.MenuView r8 = r7.mMenuView
            flyme.support.v7.widget.ActionMenuView r8 = (flyme.support.v7.widget.ActionMenuView) r8
            boolean r0 = r7.mReserveOverflow
            r8.setOverflowReserved(r0)
            flyme.support.v7.view.menu.MenuView r7 = r7.mMenuView
            flyme.support.v7.widget.ActionMenuView r7 = (flyme.support.v7.widget.ActionMenuView) r7
            r7.setHasOverflow(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: flyme.support.v7.widget.ActionMenuPresenter.updateMenuView(boolean):void");
    }
}
