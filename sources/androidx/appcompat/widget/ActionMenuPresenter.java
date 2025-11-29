package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.R;
import androidx.appcompat.view.ActionBarPolicy;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.BaseMenuPresenter;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPopupHelper;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.view.menu.ShowableListMenu;
import androidx.appcompat.view.menu.SubMenuBuilder;
import androidx.appcompat.widget.ActionMenuView;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ActionProvider;
import java.util.ArrayList;

class ActionMenuPresenter extends BaseMenuPresenter implements ActionProvider.SubUiVisibilityListener {
    public OpenOverflowRunnable A;
    public ActionMenuPopupCallback B;
    public final PopupPresenterCallback C = new PopupPresenterCallback();
    public int D;
    public OverflowMenuButton k;
    public Drawable l;
    public boolean m;
    public boolean n;
    public boolean o;
    public int p;
    public int q;
    public int r;
    public boolean s;
    public boolean t;
    public boolean u;
    public boolean v;
    public int w;
    public final SparseBooleanArray x = new SparseBooleanArray();
    public OverflowPopup y;
    public ActionButtonSubmenu z;

    public class ActionButtonSubmenu extends MenuPopupHelper {
        public ActionButtonSubmenu(Context context, SubMenuBuilder subMenuBuilder, View view) {
            super(context, subMenuBuilder, view, false, R.attr.actionOverflowMenuStyle);
            if (!((MenuItemImpl) subMenuBuilder.getItem()).j()) {
                View view2 = ActionMenuPresenter.this.k;
                f(view2 == null ? (View) ActionMenuPresenter.this.i : view2);
            }
            j(ActionMenuPresenter.this.C);
        }

        public void e() {
            ActionMenuPresenter actionMenuPresenter = ActionMenuPresenter.this;
            actionMenuPresenter.z = null;
            actionMenuPresenter.D = 0;
            super.e();
        }
    }

    public class ActionMenuPopupCallback extends ActionMenuItemView.PopupCallback {
        public ActionMenuPopupCallback() {
        }

        public ShowableListMenu a() {
            ActionButtonSubmenu actionButtonSubmenu = ActionMenuPresenter.this.z;
            if (actionButtonSubmenu != null) {
                return actionButtonSubmenu.c();
            }
            return null;
        }
    }

    public class OpenOverflowRunnable implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public OverflowPopup f257a;

        public OpenOverflowRunnable(OverflowPopup overflowPopup) {
            this.f257a = overflowPopup;
        }

        public void run() {
            if (ActionMenuPresenter.this.c != null) {
                ActionMenuPresenter.this.c.changeMenuMode();
            }
            View view = (View) ActionMenuPresenter.this.i;
            if (!(view == null || view.getWindowToken() == null || !this.f257a.m())) {
                ActionMenuPresenter.this.y = this.f257a;
            }
            ActionMenuPresenter.this.A = null;
        }
    }

    public class OverflowMenuButton extends AppCompatImageView implements ActionMenuView.ActionMenuChildView {
        public OverflowMenuButton(Context context) {
            super(context, (AttributeSet) null, R.attr.actionOverflowButtonStyle);
            setClickable(true);
            setFocusable(true);
            setVisibility(0);
            setEnabled(true);
            TooltipCompat.a(this, getContentDescription());
            setOnTouchListener(new ForwardingListener(this, ActionMenuPresenter.this) {
                public ShowableListMenu getPopup() {
                    OverflowPopup overflowPopup = ActionMenuPresenter.this.y;
                    if (overflowPopup == null) {
                        return null;
                    }
                    return overflowPopup.c();
                }

                public boolean onForwardingStarted() {
                    ActionMenuPresenter.this.C();
                    return true;
                }

                public boolean onForwardingStopped() {
                    ActionMenuPresenter actionMenuPresenter = ActionMenuPresenter.this;
                    if (actionMenuPresenter.A != null) {
                        return false;
                    }
                    actionMenuPresenter.t();
                    return true;
                }
            });
        }

        public boolean needsDividerAfter() {
            return false;
        }

        public boolean needsDividerBefore() {
            return false;
        }

        public boolean performClick() {
            if (super.performClick()) {
                return true;
            }
            playSoundEffect(0);
            ActionMenuPresenter.this.C();
            return true;
        }

        public boolean setFrame(int i, int i2, int i3, int i4) {
            boolean frame = super.setFrame(i, i2, i3, i4);
            Drawable drawable = getDrawable();
            Drawable background = getBackground();
            if (!(drawable == null || background == null)) {
                int width = getWidth();
                int height = getHeight();
                int max = Math.max(width, height) / 2;
                int paddingLeft = (width + (getPaddingLeft() - getPaddingRight())) / 2;
                int paddingTop = (height + (getPaddingTop() - getPaddingBottom())) / 2;
                DrawableCompat.l(background, paddingLeft - max, paddingTop - max, paddingLeft + max, paddingTop + max);
            }
            return frame;
        }
    }

    public class OverflowPopup extends MenuPopupHelper {
        public OverflowPopup(Context context, MenuBuilder menuBuilder, View view, boolean z) {
            super(context, menuBuilder, view, z, R.attr.actionOverflowMenuStyle);
            h(8388613);
            j(ActionMenuPresenter.this.C);
        }

        public void e() {
            if (ActionMenuPresenter.this.c != null) {
                ActionMenuPresenter.this.c.close();
            }
            ActionMenuPresenter.this.y = null;
            super.e();
        }
    }

    public class PopupPresenterCallback implements MenuPresenter.Callback {
        public PopupPresenterCallback() {
        }

        public boolean a(MenuBuilder menuBuilder) {
            if (menuBuilder == ActionMenuPresenter.this.c) {
                return false;
            }
            ActionMenuPresenter.this.D = ((SubMenuBuilder) menuBuilder).getItem().getItemId();
            MenuPresenter.Callback e = ActionMenuPresenter.this.e();
            if (e != null) {
                return e.a(menuBuilder);
            }
            return false;
        }

        public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
            if (menuBuilder instanceof SubMenuBuilder) {
                menuBuilder.getRootMenu().close(false);
            }
            MenuPresenter.Callback e = ActionMenuPresenter.this.e();
            if (e != null) {
                e.onCloseMenu(menuBuilder, z);
            }
        }
    }

    @SuppressLint({"BanParcelableUsage"})
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* renamed from: b */
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
        super(context, R.layout.abc_action_menu_layout, R.layout.abc_action_menu_item_layout);
    }

    public void A(Drawable drawable) {
        OverflowMenuButton overflowMenuButton = this.k;
        if (overflowMenuButton != null) {
            overflowMenuButton.setImageDrawable(drawable);
            return;
        }
        this.m = true;
        this.l = drawable;
    }

    public void B(boolean z2) {
        this.n = z2;
        this.o = true;
    }

    public boolean C() {
        MenuBuilder menuBuilder;
        if (!this.n || w() || (menuBuilder = this.c) == null || this.i == null || this.A != null || menuBuilder.getNonActionItems().isEmpty()) {
            return false;
        }
        OpenOverflowRunnable openOverflowRunnable = new OpenOverflowRunnable(new OverflowPopup(this.b, this.c, this.k, true));
        this.A = openOverflowRunnable;
        ((View) this.i).post(openOverflowRunnable);
        return true;
    }

    public void b(MenuItemImpl menuItemImpl, MenuView.ItemView itemView) {
        itemView.initialize(menuItemImpl, 0);
        ActionMenuItemView actionMenuItemView = (ActionMenuItemView) itemView;
        actionMenuItemView.setItemInvoker((ActionMenuView) this.i);
        if (this.B == null) {
            this.B = new ActionMenuPopupCallback();
        }
        actionMenuItemView.setPopupCallback(this.B);
    }

    public boolean d(ViewGroup viewGroup, int i) {
        if (viewGroup.getChildAt(i) == this.k) {
            return false;
        }
        return super.d(viewGroup, i);
    }

    public View f(MenuItemImpl menuItemImpl, View view, ViewGroup viewGroup) {
        View actionView = menuItemImpl.getActionView();
        if (actionView == null || menuItemImpl.h()) {
            actionView = super.f(menuItemImpl, view, viewGroup);
        }
        actionView.setVisibility(menuItemImpl.isActionViewExpanded() ? 8 : 0);
        ActionMenuView actionMenuView = (ActionMenuView) viewGroup;
        ViewGroup.LayoutParams layoutParams = actionView.getLayoutParams();
        if (!actionMenuView.checkLayoutParams(layoutParams)) {
            actionView.setLayoutParams(actionMenuView.generateLayoutParams(layoutParams));
        }
        return actionView;
    }

    public boolean flagActionItems() {
        int i;
        ArrayList<MenuItemImpl> arrayList;
        int i2;
        int i3;
        int i4;
        boolean z2;
        ActionMenuPresenter actionMenuPresenter = this;
        MenuBuilder menuBuilder = actionMenuPresenter.c;
        View view = null;
        boolean z3 = false;
        if (menuBuilder != null) {
            arrayList = menuBuilder.getVisibleItems();
            i = arrayList.size();
        } else {
            arrayList = null;
            i = 0;
        }
        int i5 = actionMenuPresenter.r;
        int i6 = actionMenuPresenter.q;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup viewGroup = (ViewGroup) actionMenuPresenter.i;
        boolean z4 = false;
        int i7 = 0;
        int i8 = 0;
        for (int i9 = 0; i9 < i; i9++) {
            MenuItemImpl menuItemImpl = arrayList.get(i9);
            if (menuItemImpl.requiresActionButton()) {
                i7++;
            } else if (menuItemImpl.l()) {
                i8++;
            } else {
                z4 = true;
            }
            if (actionMenuPresenter.v && menuItemImpl.isActionViewExpanded()) {
                i5 = 0;
            }
        }
        if (actionMenuPresenter.n && (z4 || i8 + i7 > i5)) {
            i5--;
        }
        int i10 = i5 - i7;
        SparseBooleanArray sparseBooleanArray = actionMenuPresenter.x;
        sparseBooleanArray.clear();
        if (actionMenuPresenter.t) {
            int i11 = actionMenuPresenter.w;
            i2 = i6 / i11;
            i3 = i11 + ((i6 % i11) / i2);
        } else {
            i3 = 0;
            i2 = 0;
        }
        int i12 = 0;
        int i13 = 0;
        while (i12 < i) {
            MenuItemImpl menuItemImpl2 = arrayList.get(i12);
            if (menuItemImpl2.requiresActionButton()) {
                View f = actionMenuPresenter.f(menuItemImpl2, view, viewGroup);
                if (actionMenuPresenter.t) {
                    i2 -= ActionMenuView.measureChildForCells(f, i3, i2, makeMeasureSpec, z3 ? 1 : 0);
                } else {
                    f.measure(makeMeasureSpec, makeMeasureSpec);
                }
                int measuredWidth = f.getMeasuredWidth();
                i6 -= measuredWidth;
                if (i13 == 0) {
                    i13 = measuredWidth;
                }
                int groupId = menuItemImpl2.getGroupId();
                if (groupId != 0) {
                    sparseBooleanArray.put(groupId, true);
                }
                menuItemImpl2.r(true);
                z2 = z3;
                i4 = i;
            } else if (menuItemImpl2.l()) {
                int groupId2 = menuItemImpl2.getGroupId();
                boolean z5 = sparseBooleanArray.get(groupId2);
                boolean z6 = (i10 > 0 || z5) && i6 > 0 && (!actionMenuPresenter.t || i2 > 0);
                boolean z7 = z6;
                i4 = i;
                if (z6) {
                    View f2 = actionMenuPresenter.f(menuItemImpl2, (View) null, viewGroup);
                    if (actionMenuPresenter.t) {
                        int measureChildForCells = ActionMenuView.measureChildForCells(f2, i3, i2, makeMeasureSpec, 0);
                        i2 -= measureChildForCells;
                        if (measureChildForCells == 0) {
                            z7 = false;
                        }
                    } else {
                        f2.measure(makeMeasureSpec, makeMeasureSpec);
                    }
                    boolean z8 = z7;
                    int measuredWidth2 = f2.getMeasuredWidth();
                    i6 -= measuredWidth2;
                    if (i13 == 0) {
                        i13 = measuredWidth2;
                    }
                    z6 = z8 & (!actionMenuPresenter.t ? i6 + i13 > 0 : i6 >= 0);
                }
                if (z6 && groupId2 != 0) {
                    sparseBooleanArray.put(groupId2, true);
                } else if (z5) {
                    sparseBooleanArray.put(groupId2, false);
                    int i14 = 0;
                    while (i14 < i12) {
                        MenuItemImpl menuItemImpl3 = arrayList.get(i14);
                        if (menuItemImpl3.getGroupId() == groupId2) {
                            if (menuItemImpl3.j()) {
                                i10++;
                            }
                            menuItemImpl3.r(false);
                        }
                        i14++;
                    }
                }
                if (z6) {
                    i10--;
                }
                menuItemImpl2.r(z6);
                z2 = false;
            } else {
                z2 = z3;
                i4 = i;
                menuItemImpl2.r(z2);
            }
            i12++;
            z3 = z2;
            i = i4;
            view = null;
            actionMenuPresenter = this;
        }
        return true;
    }

    public MenuView g(ViewGroup viewGroup) {
        MenuView menuView = this.i;
        MenuView g = super.g(viewGroup);
        if (menuView != g) {
            ((ActionMenuView) g).setPresenter(this);
        }
        return g;
    }

    public boolean i(int i, MenuItemImpl menuItemImpl) {
        return menuItemImpl.j();
    }

    public void initForMenu(Context context, MenuBuilder menuBuilder) {
        super.initForMenu(context, menuBuilder);
        Resources resources = context.getResources();
        ActionBarPolicy b = ActionBarPolicy.b(context);
        if (!this.o) {
            this.n = b.h();
        }
        if (!this.u) {
            this.p = b.c();
        }
        if (!this.s) {
            this.r = b.d();
        }
        int i = this.p;
        if (this.n) {
            if (this.k == null) {
                OverflowMenuButton overflowMenuButton = new OverflowMenuButton(this.f222a);
                this.k = overflowMenuButton;
                if (this.m) {
                    overflowMenuButton.setImageDrawable(this.l);
                    this.l = null;
                    this.m = false;
                }
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                this.k.measure(makeMeasureSpec, makeMeasureSpec);
            }
            i -= this.k.getMeasuredWidth();
        } else {
            this.k = null;
        }
        this.q = i;
        this.w = (int) (resources.getDisplayMetrics().density * 56.0f);
    }

    public void onCloseMenu(MenuBuilder menuBuilder, boolean z2) {
        q();
        super.onCloseMenu(menuBuilder, z2);
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        int i;
        MenuItem findItem;
        if ((parcelable instanceof SavedState) && (i = ((SavedState) parcelable).openSubMenuId) > 0 && (findItem = this.c.findItem(i)) != null) {
            onSubMenuSelected((SubMenuBuilder) findItem.getSubMenu());
        }
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState();
        savedState.openSubMenuId = this.D;
        return savedState;
    }

    public boolean onSubMenuSelected(SubMenuBuilder subMenuBuilder) {
        boolean z2 = false;
        if (!subMenuBuilder.hasVisibleItems()) {
            return false;
        }
        SubMenuBuilder subMenuBuilder2 = subMenuBuilder;
        while (subMenuBuilder2.getParentMenu() != this.c) {
            subMenuBuilder2 = (SubMenuBuilder) subMenuBuilder2.getParentMenu();
        }
        View r2 = r(subMenuBuilder2.getItem());
        if (r2 == null) {
            return false;
        }
        this.D = subMenuBuilder.getItem().getItemId();
        int size = subMenuBuilder.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                break;
            }
            MenuItem item = subMenuBuilder.getItem(i);
            if (item.isVisible() && item.getIcon() != null) {
                z2 = true;
                break;
            }
            i++;
        }
        ActionButtonSubmenu actionButtonSubmenu = new ActionButtonSubmenu(this.b, subMenuBuilder, r2);
        this.z = actionButtonSubmenu;
        actionButtonSubmenu.g(z2);
        this.z.k();
        super.onSubMenuSelected(subMenuBuilder);
        return true;
    }

    public void onSubUiVisibilityChanged(boolean z2) {
        if (z2) {
            super.onSubMenuSelected((SubMenuBuilder) null);
            return;
        }
        MenuBuilder menuBuilder = this.c;
        if (menuBuilder != null) {
            menuBuilder.close(false);
        }
    }

    public boolean q() {
        return u() | t();
    }

    public final View r(MenuItem menuItem) {
        ViewGroup viewGroup = (ViewGroup) this.i;
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

    public Drawable s() {
        OverflowMenuButton overflowMenuButton = this.k;
        if (overflowMenuButton != null) {
            return overflowMenuButton.getDrawable();
        }
        if (this.m) {
            return this.l;
        }
        return null;
    }

    public boolean t() {
        MenuView menuView;
        OpenOverflowRunnable openOverflowRunnable = this.A;
        if (openOverflowRunnable == null || (menuView = this.i) == null) {
            OverflowPopup overflowPopup = this.y;
            if (overflowPopup == null) {
                return false;
            }
            overflowPopup.b();
            return true;
        }
        ((View) menuView).removeCallbacks(openOverflowRunnable);
        this.A = null;
        return true;
    }

    public boolean u() {
        ActionButtonSubmenu actionButtonSubmenu = this.z;
        if (actionButtonSubmenu == null) {
            return false;
        }
        actionButtonSubmenu.b();
        return true;
    }

    public void updateMenuView(boolean z2) {
        MenuView menuView;
        super.updateMenuView(z2);
        ((View) this.i).requestLayout();
        MenuBuilder menuBuilder = this.c;
        boolean z3 = false;
        if (menuBuilder != null) {
            ArrayList<MenuItemImpl> actionItems = menuBuilder.getActionItems();
            int size = actionItems.size();
            for (int i = 0; i < size; i++) {
                ActionProvider supportActionProvider = actionItems.get(i).getSupportActionProvider();
                if (supportActionProvider != null) {
                    supportActionProvider.setSubUiVisibilityListener(this);
                }
            }
        }
        MenuBuilder menuBuilder2 = this.c;
        ArrayList<MenuItemImpl> nonActionItems = menuBuilder2 != null ? menuBuilder2.getNonActionItems() : null;
        if (this.n && nonActionItems != null) {
            int size2 = nonActionItems.size();
            if (size2 == 1) {
                z3 = !nonActionItems.get(0).isActionViewExpanded();
            } else if (size2 > 0) {
                z3 = true;
            }
        }
        if (z3) {
            if (this.k == null) {
                this.k = new OverflowMenuButton(this.f222a);
            }
            ViewGroup viewGroup = (ViewGroup) this.k.getParent();
            if (viewGroup != this.i) {
                if (viewGroup != null) {
                    viewGroup.removeView(this.k);
                }
                ActionMenuView actionMenuView = (ActionMenuView) this.i;
                actionMenuView.addView(this.k, actionMenuView.g());
            }
        } else {
            OverflowMenuButton overflowMenuButton = this.k;
            if (overflowMenuButton != null && overflowMenuButton.getParent() == (menuView = this.i)) {
                ((ViewGroup) menuView).removeView(this.k);
            }
        }
        ((ActionMenuView) this.i).setOverflowReserved(this.n);
    }

    public boolean v() {
        return this.A != null || w();
    }

    public boolean w() {
        OverflowPopup overflowPopup = this.y;
        return overflowPopup != null && overflowPopup.d();
    }

    public void x(Configuration configuration) {
        if (!this.s) {
            this.r = ActionBarPolicy.b(this.b).d();
        }
        MenuBuilder menuBuilder = this.c;
        if (menuBuilder != null) {
            menuBuilder.onItemsChanged(true);
        }
    }

    public void y(boolean z2) {
        this.v = z2;
    }

    public void z(ActionMenuView actionMenuView) {
        this.i = actionMenuView;
        actionMenuView.initialize(this.c);
    }
}
