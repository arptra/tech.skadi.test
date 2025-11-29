package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.transition.Transition;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.menu.ListMenuItemView;
import androidx.appcompat.view.menu.MenuAdapter;
import androidx.appcompat.view.menu.MenuBuilder;

@RestrictTo
public class MenuPopupWindow extends ListPopupWindow implements MenuItemHoverListener {

    /* renamed from: a  reason: collision with root package name */
    public MenuItemHoverListener f329a;

    @RequiresApi
    public static class Api23Impl {
        @DoNotInline
        public static void a(PopupWindow popupWindow, Transition transition) {
            popupWindow.setEnterTransition(transition);
        }

        @DoNotInline
        public static void b(PopupWindow popupWindow, Transition transition) {
            popupWindow.setExitTransition(transition);
        }
    }

    @RequiresApi
    public static class Api29Impl {
        @DoNotInline
        public static void a(PopupWindow popupWindow, boolean z) {
            popupWindow.setTouchModal(z);
        }
    }

    @RestrictTo
    public static class MenuDropDownListView extends DropDownListView {
        public final int n;
        public final int o;
        public MenuItemHoverListener p;
        public MenuItem q;

        @RequiresApi
        public static class Api17Impl {
            @DoNotInline
            public static int a(Configuration configuration) {
                return configuration.getLayoutDirection();
            }
        }

        public MenuDropDownListView(Context context, boolean z) {
            super(context, z);
            if (1 == Api17Impl.a(context.getResources().getConfiguration())) {
                this.n = 21;
                this.o = 22;
                return;
            }
            this.n = 22;
            this.o = 21;
        }

        public /* bridge */ /* synthetic */ int d(int i, boolean z) {
            return super.d(i, z);
        }

        public /* bridge */ /* synthetic */ int e(int i, int i2, int i3, int i4, int i5) {
            return super.e(i, i2, i3, i4, i5);
        }

        public /* bridge */ /* synthetic */ boolean f(MotionEvent motionEvent, int i) {
            return super.f(motionEvent, i);
        }

        public /* bridge */ /* synthetic */ boolean hasFocus() {
            return super.hasFocus();
        }

        public /* bridge */ /* synthetic */ boolean hasWindowFocus() {
            return super.hasWindowFocus();
        }

        public /* bridge */ /* synthetic */ boolean isFocused() {
            return super.isFocused();
        }

        public /* bridge */ /* synthetic */ boolean isInTouchMode() {
            return super.isInTouchMode();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0035, code lost:
            r2 = (r2 = pointToPosition((int) r5.getX(), (int) r5.getY())) - r1;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onHoverEvent(android.view.MotionEvent r5) {
            /*
                r4 = this;
                androidx.appcompat.widget.MenuItemHoverListener r0 = r4.p
                if (r0 == 0) goto L_0x005c
                android.widget.ListAdapter r0 = r4.getAdapter()
                boolean r1 = r0 instanceof android.widget.HeaderViewListAdapter
                if (r1 == 0) goto L_0x0019
                android.widget.HeaderViewListAdapter r0 = (android.widget.HeaderViewListAdapter) r0
                int r1 = r0.getHeadersCount()
                android.widget.ListAdapter r0 = r0.getWrappedAdapter()
                androidx.appcompat.view.menu.MenuAdapter r0 = (androidx.appcompat.view.menu.MenuAdapter) r0
                goto L_0x001c
            L_0x0019:
                androidx.appcompat.view.menu.MenuAdapter r0 = (androidx.appcompat.view.menu.MenuAdapter) r0
                r1 = 0
            L_0x001c:
                int r2 = r5.getAction()
                r3 = 10
                if (r2 == r3) goto L_0x0043
                float r2 = r5.getX()
                int r2 = (int) r2
                float r3 = r5.getY()
                int r3 = (int) r3
                int r2 = r4.pointToPosition(r2, r3)
                r3 = -1
                if (r2 == r3) goto L_0x0043
                int r2 = r2 - r1
                if (r2 < 0) goto L_0x0043
                int r1 = r0.getCount()
                if (r2 >= r1) goto L_0x0043
                androidx.appcompat.view.menu.MenuItemImpl r1 = r0.getItem(r2)
                goto L_0x0044
            L_0x0043:
                r1 = 0
            L_0x0044:
                android.view.MenuItem r2 = r4.q
                if (r2 == r1) goto L_0x005c
                androidx.appcompat.view.menu.MenuBuilder r0 = r0.b()
                if (r2 == 0) goto L_0x0053
                androidx.appcompat.widget.MenuItemHoverListener r3 = r4.p
                r3.d(r0, r2)
            L_0x0053:
                r4.q = r1
                if (r1 == 0) goto L_0x005c
                androidx.appcompat.widget.MenuItemHoverListener r2 = r4.p
                r2.a(r0, r1)
            L_0x005c:
                boolean r4 = super.onHoverEvent(r5)
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.MenuPopupWindow.MenuDropDownListView.onHoverEvent(android.view.MotionEvent):boolean");
        }

        public boolean onKeyDown(int i, KeyEvent keyEvent) {
            ListMenuItemView listMenuItemView = (ListMenuItemView) getSelectedView();
            if (listMenuItemView != null && i == this.n) {
                if (listMenuItemView.isEnabled() && listMenuItemView.getItemData().hasSubMenu()) {
                    performItemClick(listMenuItemView, getSelectedItemPosition(), getSelectedItemId());
                }
                return true;
            } else if (listMenuItemView == null || i != this.o) {
                return super.onKeyDown(i, keyEvent);
            } else {
                setSelection(-1);
                ListAdapter adapter = getAdapter();
                (adapter instanceof HeaderViewListAdapter ? (MenuAdapter) ((HeaderViewListAdapter) adapter).getWrappedAdapter() : (MenuAdapter) adapter).b().close(false);
                return true;
            }
        }

        public /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent motionEvent) {
            return super.onTouchEvent(motionEvent);
        }

        public void setHoverListener(MenuItemHoverListener menuItemHoverListener) {
            this.p = menuItemHoverListener;
        }

        public /* bridge */ /* synthetic */ void setSelector(Drawable drawable) {
            super.setSelector(drawable);
        }
    }

    public MenuPopupWindow(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    public void a(MenuBuilder menuBuilder, MenuItem menuItem) {
        MenuItemHoverListener menuItemHoverListener = this.f329a;
        if (menuItemHoverListener != null) {
            menuItemHoverListener.a(menuBuilder, menuItem);
        }
    }

    public DropDownListView createDropDownListView(Context context, boolean z) {
        MenuDropDownListView menuDropDownListView = new MenuDropDownListView(context, z);
        menuDropDownListView.setHoverListener(this);
        return menuDropDownListView;
    }

    public void d(MenuBuilder menuBuilder, MenuItem menuItem) {
        MenuItemHoverListener menuItemHoverListener = this.f329a;
        if (menuItemHoverListener != null) {
            menuItemHoverListener.d(menuBuilder, menuItem);
        }
    }

    public void k(Object obj) {
        Api23Impl.a(this.mPopup, (Transition) obj);
    }

    public void l(Object obj) {
        Api23Impl.b(this.mPopup, (Transition) obj);
    }

    public void m(MenuItemHoverListener menuItemHoverListener) {
        this.f329a = menuItemHoverListener;
    }

    public void n(boolean z) {
        Api29Impl.a(this.mPopup, z);
    }
}
