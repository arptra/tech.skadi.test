package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.widget.MenuItemHoverListener;
import androidx.appcompat.widget.MenuPopupWindow;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;

final class CascadingMenuPopup extends MenuPopup implements MenuPresenter, View.OnKeyListener, PopupWindow.OnDismissListener {
    public static final int B = R.layout.abc_cascading_menu_item_layout;
    public boolean A;
    public final Context b;
    public final int c;
    public final int d;
    public final int e;
    public final boolean f;
    public final Handler g;
    public final List h = new ArrayList();
    public final List i = new ArrayList();
    public final ViewTreeObserver.OnGlobalLayoutListener j = new ViewTreeObserver.OnGlobalLayoutListener() {
        public void onGlobalLayout() {
            if (CascadingMenuPopup.this.isShowing() && CascadingMenuPopup.this.i.size() > 0 && !((CascadingMenuInfo) CascadingMenuPopup.this.i.get(0)).f228a.isModal()) {
                View view = CascadingMenuPopup.this.p;
                if (view == null || !view.isShown()) {
                    CascadingMenuPopup.this.dismiss();
                    return;
                }
                for (CascadingMenuInfo cascadingMenuInfo : CascadingMenuPopup.this.i) {
                    cascadingMenuInfo.f228a.show();
                }
            }
        }
    };
    public final View.OnAttachStateChangeListener k = new View.OnAttachStateChangeListener() {
        public void onViewAttachedToWindow(View view) {
        }

        public void onViewDetachedFromWindow(View view) {
            ViewTreeObserver viewTreeObserver = CascadingMenuPopup.this.y;
            if (viewTreeObserver != null) {
                if (!viewTreeObserver.isAlive()) {
                    CascadingMenuPopup.this.y = view.getViewTreeObserver();
                }
                CascadingMenuPopup cascadingMenuPopup = CascadingMenuPopup.this;
                cascadingMenuPopup.y.removeGlobalOnLayoutListener(cascadingMenuPopup.j);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    };
    public final MenuItemHoverListener l = new MenuItemHoverListener() {
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v11, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: androidx.appcompat.view.menu.CascadingMenuPopup$CascadingMenuInfo} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void a(final androidx.appcompat.view.menu.MenuBuilder r6, final android.view.MenuItem r7) {
            /*
                r5 = this;
                androidx.appcompat.view.menu.CascadingMenuPopup r0 = androidx.appcompat.view.menu.CascadingMenuPopup.this
                android.os.Handler r0 = r0.g
                r1 = 0
                r0.removeCallbacksAndMessages(r1)
                androidx.appcompat.view.menu.CascadingMenuPopup r0 = androidx.appcompat.view.menu.CascadingMenuPopup.this
                java.util.List r0 = r0.i
                int r0 = r0.size()
                r2 = 0
            L_0x0011:
                r3 = -1
                if (r2 >= r0) goto L_0x0026
                androidx.appcompat.view.menu.CascadingMenuPopup r4 = androidx.appcompat.view.menu.CascadingMenuPopup.this
                java.util.List r4 = r4.i
                java.lang.Object r4 = r4.get(r2)
                androidx.appcompat.view.menu.CascadingMenuPopup$CascadingMenuInfo r4 = (androidx.appcompat.view.menu.CascadingMenuPopup.CascadingMenuInfo) r4
                androidx.appcompat.view.menu.MenuBuilder r4 = r4.b
                if (r6 != r4) goto L_0x0023
                goto L_0x0027
            L_0x0023:
                int r2 = r2 + 1
                goto L_0x0011
            L_0x0026:
                r2 = r3
            L_0x0027:
                if (r2 != r3) goto L_0x002a
                return
            L_0x002a:
                int r2 = r2 + 1
                androidx.appcompat.view.menu.CascadingMenuPopup r0 = androidx.appcompat.view.menu.CascadingMenuPopup.this
                java.util.List r0 = r0.i
                int r0 = r0.size()
                if (r2 >= r0) goto L_0x0041
                androidx.appcompat.view.menu.CascadingMenuPopup r0 = androidx.appcompat.view.menu.CascadingMenuPopup.this
                java.util.List r0 = r0.i
                java.lang.Object r0 = r0.get(r2)
                r1 = r0
                androidx.appcompat.view.menu.CascadingMenuPopup$CascadingMenuInfo r1 = (androidx.appcompat.view.menu.CascadingMenuPopup.CascadingMenuInfo) r1
            L_0x0041:
                androidx.appcompat.view.menu.CascadingMenuPopup$3$1 r0 = new androidx.appcompat.view.menu.CascadingMenuPopup$3$1
                r0.<init>(r1, r7, r6)
                long r1 = android.os.SystemClock.uptimeMillis()
                r3 = 200(0xc8, double:9.9E-322)
                long r1 = r1 + r3
                androidx.appcompat.view.menu.CascadingMenuPopup r5 = androidx.appcompat.view.menu.CascadingMenuPopup.this
                android.os.Handler r5 = r5.g
                r5.postAtTime(r0, r6, r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.view.menu.CascadingMenuPopup.AnonymousClass3.a(androidx.appcompat.view.menu.MenuBuilder, android.view.MenuItem):void");
        }

        public void d(MenuBuilder menuBuilder, MenuItem menuItem) {
            CascadingMenuPopup.this.g.removeCallbacksAndMessages(menuBuilder);
        }
    };
    public int m = 0;
    public int n = 0;
    public View o;
    public View p;
    public int q;
    public boolean r;
    public boolean s;
    public int t;
    public int u;
    public boolean v;
    public boolean w;
    public MenuPresenter.Callback x;
    public ViewTreeObserver y;
    public PopupWindow.OnDismissListener z;

    public static class CascadingMenuInfo {

        /* renamed from: a  reason: collision with root package name */
        public final MenuPopupWindow f228a;
        public final MenuBuilder b;
        public final int c;

        public CascadingMenuInfo(MenuPopupWindow menuPopupWindow, MenuBuilder menuBuilder, int i) {
            this.f228a = menuPopupWindow;
            this.b = menuBuilder;
            this.c = i;
        }

        public ListView a() {
            return this.f228a.getListView();
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface HorizPosition {
    }

    public CascadingMenuPopup(Context context, View view, int i2, int i3, boolean z2) {
        this.b = context;
        this.o = view;
        this.d = i2;
        this.e = i3;
        this.f = z2;
        this.v = false;
        this.q = s();
        Resources resources = context.getResources();
        this.c = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
        this.g = new Handler();
    }

    public void a(MenuBuilder menuBuilder) {
        menuBuilder.addMenuPresenter(this, this.b);
        if (isShowing()) {
            u(menuBuilder);
        } else {
            this.h.add(menuBuilder);
        }
    }

    public boolean b() {
        return false;
    }

    public void dismiss() {
        int size = this.i.size();
        if (size > 0) {
            CascadingMenuInfo[] cascadingMenuInfoArr = (CascadingMenuInfo[]) this.i.toArray(new CascadingMenuInfo[size]);
            for (int i2 = size - 1; i2 >= 0; i2--) {
                CascadingMenuInfo cascadingMenuInfo = cascadingMenuInfoArr[i2];
                if (cascadingMenuInfo.f228a.isShowing()) {
                    cascadingMenuInfo.f228a.dismiss();
                }
            }
        }
    }

    public void e(View view) {
        if (this.o != view) {
            this.o = view;
            this.n = GravityCompat.b(this.m, ViewCompat.z(view));
        }
    }

    public boolean flagActionItems() {
        return false;
    }

    public void g(boolean z2) {
        this.v = z2;
    }

    public ListView getListView() {
        if (this.i.isEmpty()) {
            return null;
        }
        List list = this.i;
        return ((CascadingMenuInfo) list.get(list.size() - 1)).a();
    }

    public void h(int i2) {
        if (this.m != i2) {
            this.m = i2;
            this.n = GravityCompat.b(i2, ViewCompat.z(this.o));
        }
    }

    public void i(int i2) {
        this.r = true;
        this.t = i2;
    }

    public boolean isShowing() {
        return this.i.size() > 0 && ((CascadingMenuInfo) this.i.get(0)).f228a.isShowing();
    }

    public void j(PopupWindow.OnDismissListener onDismissListener) {
        this.z = onDismissListener;
    }

    public void k(boolean z2) {
        this.w = z2;
    }

    public void l(int i2) {
        this.s = true;
        this.u = i2;
    }

    public final MenuPopupWindow o() {
        MenuPopupWindow menuPopupWindow = new MenuPopupWindow(this.b, (AttributeSet) null, this.d, this.e);
        menuPopupWindow.m(this.l);
        menuPopupWindow.setOnItemClickListener(this);
        menuPopupWindow.setOnDismissListener(this);
        menuPopupWindow.setAnchorView(this.o);
        menuPopupWindow.setDropDownGravity(this.n);
        menuPopupWindow.setModal(true);
        menuPopupWindow.setInputMethodMode(2);
        return menuPopupWindow;
    }

    public void onCloseMenu(MenuBuilder menuBuilder, boolean z2) {
        int p2 = p(menuBuilder);
        if (p2 >= 0) {
            int i2 = p2 + 1;
            if (i2 < this.i.size()) {
                ((CascadingMenuInfo) this.i.get(i2)).b.close(false);
            }
            CascadingMenuInfo cascadingMenuInfo = (CascadingMenuInfo) this.i.remove(p2);
            cascadingMenuInfo.b.removeMenuPresenter(this);
            if (this.A) {
                cascadingMenuInfo.f228a.l((Object) null);
                cascadingMenuInfo.f228a.setAnimationStyle(0);
            }
            cascadingMenuInfo.f228a.dismiss();
            int size = this.i.size();
            if (size > 0) {
                this.q = ((CascadingMenuInfo) this.i.get(size - 1)).c;
            } else {
                this.q = s();
            }
            if (size == 0) {
                dismiss();
                MenuPresenter.Callback callback = this.x;
                if (callback != null) {
                    callback.onCloseMenu(menuBuilder, true);
                }
                ViewTreeObserver viewTreeObserver = this.y;
                if (viewTreeObserver != null) {
                    if (viewTreeObserver.isAlive()) {
                        this.y.removeGlobalOnLayoutListener(this.j);
                    }
                    this.y = null;
                }
                this.p.removeOnAttachStateChangeListener(this.k);
                this.z.onDismiss();
            } else if (z2) {
                ((CascadingMenuInfo) this.i.get(0)).b.close(false);
            }
        }
    }

    public void onDismiss() {
        CascadingMenuInfo cascadingMenuInfo;
        int size = this.i.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                cascadingMenuInfo = null;
                break;
            }
            cascadingMenuInfo = (CascadingMenuInfo) this.i.get(i2);
            if (!cascadingMenuInfo.f228a.isShowing()) {
                break;
            }
            i2++;
        }
        if (cascadingMenuInfo != null) {
            cascadingMenuInfo.b.close(false);
        }
    }

    public boolean onKey(View view, int i2, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i2 != 82) {
            return false;
        }
        dismiss();
        return true;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
    }

    public Parcelable onSaveInstanceState() {
        return null;
    }

    public boolean onSubMenuSelected(SubMenuBuilder subMenuBuilder) {
        for (CascadingMenuInfo cascadingMenuInfo : this.i) {
            if (subMenuBuilder == cascadingMenuInfo.b) {
                cascadingMenuInfo.a().requestFocus();
                return true;
            }
        }
        if (!subMenuBuilder.hasVisibleItems()) {
            return false;
        }
        a(subMenuBuilder);
        MenuPresenter.Callback callback = this.x;
        if (callback != null) {
            callback.a(subMenuBuilder);
        }
        return true;
    }

    public final int p(MenuBuilder menuBuilder) {
        int size = this.i.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (menuBuilder == ((CascadingMenuInfo) this.i.get(i2)).b) {
                return i2;
            }
        }
        return -1;
    }

    public final MenuItem q(MenuBuilder menuBuilder, MenuBuilder menuBuilder2) {
        int size = menuBuilder.size();
        for (int i2 = 0; i2 < size; i2++) {
            MenuItem item = menuBuilder.getItem(i2);
            if (item.hasSubMenu() && menuBuilder2 == item.getSubMenu()) {
                return item;
            }
        }
        return null;
    }

    public final View r(CascadingMenuInfo cascadingMenuInfo, MenuBuilder menuBuilder) {
        int i2;
        MenuAdapter menuAdapter;
        int firstVisiblePosition;
        MenuItem q2 = q(cascadingMenuInfo.b, menuBuilder);
        if (q2 == null) {
            return null;
        }
        ListView a2 = cascadingMenuInfo.a();
        ListAdapter adapter = a2.getAdapter();
        int i3 = 0;
        if (adapter instanceof HeaderViewListAdapter) {
            HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
            i2 = headerViewListAdapter.getHeadersCount();
            menuAdapter = (MenuAdapter) headerViewListAdapter.getWrappedAdapter();
        } else {
            menuAdapter = (MenuAdapter) adapter;
            i2 = 0;
        }
        int count = menuAdapter.getCount();
        while (true) {
            if (i3 >= count) {
                i3 = -1;
                break;
            } else if (q2 == menuAdapter.getItem(i3)) {
                break;
            } else {
                i3++;
            }
        }
        if (i3 != -1 && (firstVisiblePosition = (i3 + i2) - a2.getFirstVisiblePosition()) >= 0 && firstVisiblePosition < a2.getChildCount()) {
            return a2.getChildAt(firstVisiblePosition);
        }
        return null;
    }

    public final int s() {
        return ViewCompat.z(this.o) == 1 ? 0 : 1;
    }

    public void setCallback(MenuPresenter.Callback callback) {
        this.x = callback;
    }

    public void show() {
        if (!isShowing()) {
            for (MenuBuilder u2 : this.h) {
                u(u2);
            }
            this.h.clear();
            View view = this.o;
            this.p = view;
            if (view != null) {
                boolean z2 = this.y == null;
                ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
                this.y = viewTreeObserver;
                if (z2) {
                    viewTreeObserver.addOnGlobalLayoutListener(this.j);
                }
                this.p.addOnAttachStateChangeListener(this.k);
            }
        }
    }

    public final int t(int i2) {
        List list = this.i;
        ListView a2 = ((CascadingMenuInfo) list.get(list.size() - 1)).a();
        int[] iArr = new int[2];
        a2.getLocationOnScreen(iArr);
        Rect rect = new Rect();
        this.p.getWindowVisibleDisplayFrame(rect);
        return this.q == 1 ? (iArr[0] + a2.getWidth()) + i2 > rect.right ? 0 : 1 : iArr[0] - i2 < 0 ? 1 : 0;
    }

    public final void u(MenuBuilder menuBuilder) {
        View view;
        CascadingMenuInfo cascadingMenuInfo;
        LayoutInflater from = LayoutInflater.from(this.b);
        MenuAdapter menuAdapter = new MenuAdapter(menuBuilder, from, this.f, B);
        if (!isShowing() && this.v) {
            menuAdapter.d(true);
        } else if (isShowing()) {
            menuAdapter.d(MenuPopup.m(menuBuilder));
        }
        int d2 = MenuPopup.d(menuAdapter, (ViewGroup) null, this.b, this.c);
        MenuPopupWindow o2 = o();
        o2.setAdapter(menuAdapter);
        o2.setContentWidth(d2);
        o2.setDropDownGravity(this.n);
        if (this.i.size() > 0) {
            List list = this.i;
            cascadingMenuInfo = (CascadingMenuInfo) list.get(list.size() - 1);
            view = r(cascadingMenuInfo, menuBuilder);
        } else {
            cascadingMenuInfo = null;
            view = null;
        }
        if (view != null) {
            o2.n(false);
            o2.k((Object) null);
            int t2 = t(d2);
            boolean z2 = t2 == 1;
            this.q = t2;
            o2.setAnchorView(view);
            if ((this.n & 5) != 5) {
                d2 = z2 ? view.getWidth() : 0 - d2;
            } else if (!z2) {
                d2 = 0 - view.getWidth();
            }
            o2.setHorizontalOffset(d2);
            o2.setOverlapAnchor(true);
            o2.setVerticalOffset(0);
        } else {
            if (this.r) {
                o2.setHorizontalOffset(this.t);
            }
            if (this.s) {
                o2.setVerticalOffset(this.u);
            }
            o2.setEpicenterBounds(c());
        }
        this.i.add(new CascadingMenuInfo(o2, menuBuilder, this.q));
        o2.show();
        ListView listView = o2.getListView();
        listView.setOnKeyListener(this);
        if (cascadingMenuInfo == null && this.w && menuBuilder.getHeaderTitle() != null) {
            FrameLayout frameLayout = (FrameLayout) from.inflate(R.layout.abc_popup_menu_header_item_layout, listView, false);
            frameLayout.setEnabled(false);
            ((TextView) frameLayout.findViewById(16908310)).setText(menuBuilder.getHeaderTitle());
            listView.addHeaderView(frameLayout, (Object) null, false);
            o2.show();
        }
    }

    public void updateMenuView(boolean z2) {
        for (CascadingMenuInfo a2 : this.i) {
            MenuPopup.n(a2.a().getAdapter()).notifyDataSetChanged();
        }
    }
}
