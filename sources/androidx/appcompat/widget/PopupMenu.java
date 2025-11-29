package androidx.appcompat.widget;

import android.view.MenuItem;
import android.widget.PopupWindow;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPopupHelper;
import androidx.appcompat.view.menu.ShowableListMenu;

public class PopupMenu {

    /* renamed from: a  reason: collision with root package name */
    public final MenuPopupHelper f330a;
    public OnMenuItemClickListener b;
    public OnDismissListener c;

    /* renamed from: androidx.appcompat.widget.PopupMenu$1  reason: invalid class name */
    class AnonymousClass1 implements MenuBuilder.Callback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PopupMenu f331a;

        public boolean onMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem) {
            OnMenuItemClickListener onMenuItemClickListener = this.f331a.b;
            if (onMenuItemClickListener != null) {
                return onMenuItemClickListener.onMenuItemClick(menuItem);
            }
            return false;
        }

        public void onMenuModeChange(MenuBuilder menuBuilder) {
        }
    }

    /* renamed from: androidx.appcompat.widget.PopupMenu$2  reason: invalid class name */
    class AnonymousClass2 implements PopupWindow.OnDismissListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PopupMenu f332a;

        public void onDismiss() {
            PopupMenu popupMenu = this.f332a;
            OnDismissListener onDismissListener = popupMenu.c;
            if (onDismissListener != null) {
                onDismissListener.a(popupMenu);
            }
        }
    }

    /* renamed from: androidx.appcompat.widget.PopupMenu$3  reason: invalid class name */
    class AnonymousClass3 extends ForwardingListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PopupMenu f333a;

        public ShowableListMenu getPopup() {
            return this.f333a.f330a.c();
        }

        public boolean onForwardingStarted() {
            this.f333a.b();
            return true;
        }

        public boolean onForwardingStopped() {
            this.f333a.a();
            return true;
        }
    }

    public interface OnDismissListener {
        void a(PopupMenu popupMenu);
    }

    public interface OnMenuItemClickListener {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    public void a() {
        this.f330a.b();
    }

    public void b() {
        this.f330a.k();
    }
}
