package com.upuphone.xr.sapp.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.honey.account.x8.c;
import com.honey.account.x8.d;
import com.honey.account.x8.e;
import com.honey.account.x8.f;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.databinding.GenericMenuLayoutBinding;
import com.upuphone.xr.sapp.databinding.MenuItemLayoutBinding;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0007\u0018\u0000 12\u00020\u0001:\u00072345678B9\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0011\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0013\u001a\u00020\u0010¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\u0019\u0010\u001b\u001a\u00020\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ5\u0010\u001d\u001a\u00020\u00102\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0019\u0010\u001f\u001a\u00020\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0002¢\u0006\u0004\b\u001f\u0010\u001cR$\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010,\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010+R\u0016\u0010.\u001a\u00020\t8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u0013\u0010-R\u0018\u00100\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010/¨\u00069"}, d2 = {"Lcom/upuphone/xr/sapp/view/GenericMenuView;", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", "context", "", "Lcom/upuphone/xr/sapp/view/GenericMenuView$MenuItem;", "menuItemList", "", "multipleSelection", "Lcom/upuphone/xr/sapp/view/GenericMenuView$MenuItemClickListener;", "listener", "", "title", "<init>", "(Landroid/content/Context;Ljava/util/List;ZLcom/upuphone/xr/sapp/view/GenericMenuView$MenuItemClickListener;Ljava/lang/String;)V", "Lcom/upuphone/xr/sapp/view/GenericMenuView$MenuDismissListener;", "", "setDismissListener", "(Lcom/upuphone/xr/sapp/view/GenericMenuView$MenuDismissListener;)V", "d", "()V", "Landroidx/fragment/app/FragmentActivity;", "activity", "h", "(Landroidx/fragment/app/FragmentActivity;)V", "Landroid/view/KeyEvent;", "event", "dispatchKeyEvent", "(Landroid/view/KeyEvent;)Z", "e", "(Ljava/util/List;Landroid/content/Context;ZLcom/upuphone/xr/sapp/view/GenericMenuView$MenuItemClickListener;)V", "c", "a", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "Lcom/upuphone/xr/sapp/databinding/GenericMenuLayoutBinding;", "b", "Lcom/upuphone/xr/sapp/databinding/GenericMenuLayoutBinding;", "binding", "Landroid/view/ViewGroup;", "Landroid/view/ViewGroup;", "viewGroup", "Lcom/upuphone/xr/sapp/view/GenericMenuView$MenuItemClickListener;", "menuItemListener", "Lcom/upuphone/xr/sapp/view/GenericMenuView$MenuDismissListener;", "dismissListener", "f", "Companion", "MenuAdapter", "MenuDismissListener", "MenuItem", "MenuItemClickListener", "MenuItemView", "ViewHolder", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SuppressLint({"NotifyDataSetChanged", "ViewConstructor"})
public final class GenericMenuView extends LinearLayout {
    public static final Companion f = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public String f7955a;
    public GenericMenuLayoutBinding b;
    public ViewGroup c;
    public MenuItemClickListener d;
    public MenuDismissListener e;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/upuphone/xr/sapp/view/GenericMenuView$Companion;", "", "()V", "TAG", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006\u001d"}, d2 = {"Lcom/upuphone/xr/sapp/view/GenericMenuView$MenuAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/upuphone/xr/sapp/view/GenericMenuView$ViewHolder;", "Landroid/view/ViewGroup;", "parent", "", "viewType", "j", "(Landroid/view/ViewGroup;I)Lcom/upuphone/xr/sapp/view/GenericMenuView$ViewHolder;", "holder", "position", "", "h", "(Lcom/upuphone/xr/sapp/view/GenericMenuView$ViewHolder;I)V", "getItemCount", "()I", "", "Lcom/upuphone/xr/sapp/view/GenericMenuView$MenuItem;", "a", "Ljava/util/List;", "menuItemList", "Lcom/upuphone/xr/sapp/view/GenericMenuView$MenuItemClickListener;", "b", "Lcom/upuphone/xr/sapp/view/GenericMenuView$MenuItemClickListener;", "itemClickListener", "", "c", "Z", "multipleSelection", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static final class MenuAdapter extends RecyclerView.Adapter<ViewHolder> {

        /* renamed from: a  reason: collision with root package name */
        public final List f7956a;
        public MenuItemClickListener b;
        public boolean c;

        public static final void i(MenuAdapter menuAdapter, int i, View view) {
            Intrinsics.checkNotNullParameter(menuAdapter, "this$0");
            if (!menuAdapter.c) {
                for (MenuItem d : menuAdapter.f7956a) {
                    d.d(false);
                }
            }
            ((MenuItem) menuAdapter.f7956a.get(i)).d(true);
            menuAdapter.notifyDataSetChanged();
            MenuItemClickListener menuItemClickListener = menuAdapter.b;
            if (menuItemClickListener != null) {
                menuItemClickListener.a((MenuItem) menuAdapter.f7956a.get(i));
            }
        }

        public int getItemCount() {
            return this.f7956a.size();
        }

        /* renamed from: h */
        public void onBindViewHolder(ViewHolder viewHolder, int i) {
            Intrinsics.checkNotNullParameter(viewHolder, "holder");
            viewHolder.a().b.setText(((MenuItem) this.f7956a.get(i)).a());
            viewHolder.a().c.setVisibility(((MenuItem) this.f7956a.get(i)).b() ? 0 : 4);
            viewHolder.a().getRoot().setSelected(((MenuItem) this.f7956a.get(i)).b());
            viewHolder.a().getRoot().setOnClickListener(new e(this, i));
        }

        /* renamed from: j */
        public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            Intrinsics.checkNotNullParameter(viewGroup, "parent");
            MenuItemLayoutBinding c2 = MenuItemLayoutBinding.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(c2, "inflate(...)");
            return new ViewHolder(c2);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/upuphone/xr/sapp/view/GenericMenuView$MenuDismissListener;", "", "", "a", "()V", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
    public interface MenuDismissListener {
        void a();
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0014\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u000bR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\f\u0010\u000b\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0016\u001a\u0004\b\u0010\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Lcom/upuphone/xr/sapp/view/GenericMenuView$MenuItem;", "", "", "itemName", "", "value", "", "selected", "<init>", "(Ljava/lang/String;IZ)V", "toString", "()Ljava/lang/String;", "a", "Ljava/lang/String;", "setItemName", "(Ljava/lang/String;)V", "b", "I", "c", "()I", "setValue", "(I)V", "Z", "()Z", "d", "(Z)V", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static final class MenuItem {

        /* renamed from: a  reason: collision with root package name */
        public String f7957a;
        public int b;
        public boolean c;

        public MenuItem(String str, int i, boolean z) {
            Intrinsics.checkNotNullParameter(str, "itemName");
            this.f7957a = str;
            this.b = i;
            this.c = z;
        }

        public final String a() {
            return this.f7957a;
        }

        public final boolean b() {
            return this.c;
        }

        public final int c() {
            return this.b;
        }

        public final void d(boolean z) {
            this.c = z;
        }

        public String toString() {
            String str = this.f7957a;
            int i = this.b;
            boolean z = this.c;
            return "MenuItem(itemName='" + str + "', value=" + i + ", selected=" + z + ")";
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/upuphone/xr/sapp/view/GenericMenuView$MenuItemClickListener;", "", "Lcom/upuphone/xr/sapp/view/GenericMenuView$MenuItem;", "item", "", "a", "(Lcom/upuphone/xr/sapp/view/GenericMenuView$MenuItem;)V", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
    public interface MenuItemClickListener {
        void a(MenuItem menuItem);
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/upuphone/xr/sapp/view/GenericMenuView$MenuItemView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/content/Context;", "context", "Lcom/upuphone/xr/sapp/view/GenericMenuView$MenuItem;", "menuItem", "Lcom/upuphone/xr/sapp/view/GenericMenuView$MenuItemClickListener;", "listener", "<init>", "(Landroid/content/Context;Lcom/upuphone/xr/sapp/view/GenericMenuView$MenuItem;Lcom/upuphone/xr/sapp/view/GenericMenuView$MenuItemClickListener;)V", "", "h", "(Lcom/upuphone/xr/sapp/view/GenericMenuView$MenuItem;Lcom/upuphone/xr/sapp/view/GenericMenuView$MenuItemClickListener;)V", "Lcom/upuphone/xr/sapp/databinding/MenuItemLayoutBinding;", "a", "Lcom/upuphone/xr/sapp/databinding/MenuItemLayoutBinding;", "binding", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static final class MenuItemView extends ConstraintLayout {

        /* renamed from: a  reason: collision with root package name */
        public MenuItemLayoutBinding f7958a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public MenuItemView(Context context, MenuItem menuItem, MenuItemClickListener menuItemClickListener) {
            super(context);
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(menuItem, "menuItem");
            Intrinsics.checkNotNullParameter(menuItemClickListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
            MenuItemLayoutBinding c = MenuItemLayoutBinding.c(LayoutInflater.from(context), this, true);
            Intrinsics.checkNotNullExpressionValue(c, "inflate(...)");
            this.f7958a = c;
            h(menuItem, menuItemClickListener);
        }

        public static final void i(MenuItem menuItem, MenuItemClickListener menuItemClickListener, View view) {
            Intrinsics.checkNotNullParameter(menuItem, "$menuItem");
            Intrinsics.checkNotNullParameter(menuItemClickListener, "$listener");
            menuItem.d(true);
            menuItemClickListener.a(menuItem);
            ULog.Delegate delegate = ULog.f6446a;
            delegate.a("GenericMenuView", "click " + menuItem);
        }

        public final void h(MenuItem menuItem, MenuItemClickListener menuItemClickListener) {
            this.f7958a.b.setText(menuItem.a());
            this.f7958a.getRoot().setSelected(menuItem.b());
            this.f7958a.c.setVisibility(menuItem.b() ? 0 : 4);
            if (menuItem.b()) {
                this.f7958a.b.setTextColor(getContext().getColor(R.color.mz_theme_color_blue));
                this.f7958a.getRoot().setBackground(getContext().getDrawable(R.drawable.menu_item_bg));
            } else {
                this.f7958a.b.setTextColor(getContext().getColor(R.color.title_text_color));
                this.f7958a.getRoot().setBackgroundColor(getContext().getColor(R.color.transparent));
            }
            this.f7958a.getRoot().setOnClickListener(new f(menuItem, menuItemClickListener));
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0006\u0010\b\"\u0004\b\t\u0010\u0005¨\u0006\n"}, d2 = {"Lcom/upuphone/xr/sapp/view/GenericMenuView$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/upuphone/xr/sapp/databinding/MenuItemLayoutBinding;", "binding", "<init>", "(Lcom/upuphone/xr/sapp/databinding/MenuItemLayoutBinding;)V", "a", "Lcom/upuphone/xr/sapp/databinding/MenuItemLayoutBinding;", "()Lcom/upuphone/xr/sapp/databinding/MenuItemLayoutBinding;", "setBinding", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static final class ViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public MenuItemLayoutBinding f7959a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ViewHolder(MenuItemLayoutBinding menuItemLayoutBinding) {
            super(menuItemLayoutBinding.getRoot());
            Intrinsics.checkNotNullParameter(menuItemLayoutBinding, "binding");
            this.f7959a = menuItemLayoutBinding;
        }

        public final MenuItemLayoutBinding a() {
            return this.f7959a;
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GenericMenuView(Context context, List list, boolean z, MenuItemClickListener menuItemClickListener, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, list, z, menuItemClickListener, (i & 16) != 0 ? null : str);
    }

    public static final void f(GenericMenuView genericMenuView, View view) {
        Intrinsics.checkNotNullParameter(genericMenuView, "this$0");
        genericMenuView.d();
    }

    public static final void g(GenericMenuView genericMenuView, View view) {
        Intrinsics.checkNotNullParameter(genericMenuView, "this$0");
        genericMenuView.d();
    }

    public final boolean c(KeyEvent keyEvent) {
        return (keyEvent != null && keyEvent.getKeyCode() == 67) || (keyEvent != null && keyEvent.getKeyCode() == 66) || ((keyEvent != null && keyEvent.getKeyCode() == 7) || ((keyEvent != null && keyEvent.getKeyCode() == 8) || ((keyEvent != null && keyEvent.getKeyCode() == 9) || ((keyEvent != null && keyEvent.getKeyCode() == 10) || ((keyEvent != null && keyEvent.getKeyCode() == 11) || ((keyEvent != null && keyEvent.getKeyCode() == 12) || ((keyEvent != null && keyEvent.getKeyCode() == 13) || ((keyEvent != null && keyEvent.getKeyCode() == 14) || ((keyEvent != null && keyEvent.getKeyCode() == 15) || (keyEvent != null && keyEvent.getKeyCode() == 16))))))))));
    }

    public final void d() {
        MenuDismissListener menuDismissListener = this.e;
        if (menuDismissListener != null) {
            menuDismissListener.a();
        }
        this.b.b.removeAllViews();
        ViewGroup viewGroup = this.c;
        if (viewGroup != null) {
            viewGroup.removeView(this);
        }
        this.c = null;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        ULog.Delegate delegate = ULog.f6446a;
        Integer valueOf = keyEvent != null ? Integer.valueOf(keyEvent.getKeyCode()) : null;
        delegate.a("GenericMenuView", "dispatchKeyEvent::keyCode is: " + valueOf);
        if (c(keyEvent)) {
            return super.dispatchKeyEvent(keyEvent);
        }
        d();
        return true;
    }

    public final void e(List list, Context context, boolean z, MenuItemClickListener menuItemClickListener) {
        String str = this.f7955a;
        if (str != null) {
            this.b.e.setText(str);
        }
        this.d = new GenericMenuView$initView$2(this, z, list, menuItemClickListener);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            MenuItem menuItem = (MenuItem) it.next();
            MenuItemClickListener menuItemClickListener2 = this.d;
            if (menuItemClickListener2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("menuItemListener");
                menuItemClickListener2 = null;
            }
            this.b.b.addView(new MenuItemView(context, menuItem, menuItemClickListener2), list.indexOf(menuItem));
        }
        this.b.c.setOnClickListener(new c(this));
        this.b.getRoot().setOnClickListener(new d(this));
    }

    @Nullable
    public final String getTitle() {
        return this.f7955a;
    }

    public final void h(FragmentActivity fragmentActivity) {
        Intrinsics.checkNotNullParameter(fragmentActivity, "activity");
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        requestFocusFromTouch();
        layoutParams.gravity = 80;
        View decorView = fragmentActivity.getWindow().getDecorView();
        Intrinsics.checkNotNull(decorView, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup = (ViewGroup) decorView;
        this.c = viewGroup;
        if (viewGroup != null) {
            viewGroup.addView(this, layoutParams);
        }
    }

    public final void setDismissListener(@NotNull MenuDismissListener menuDismissListener) {
        Intrinsics.checkNotNullParameter(menuDismissListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.e = menuDismissListener;
    }

    public final void setTitle(@Nullable String str) {
        this.f7955a = str;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GenericMenuView(Context context, List list, boolean z, MenuItemClickListener menuItemClickListener, String str) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(list, "menuItemList");
        Intrinsics.checkNotNullParameter(menuItemClickListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.f7955a = str;
        GenericMenuLayoutBinding c2 = GenericMenuLayoutBinding.c(LayoutInflater.from(context), this, true);
        Intrinsics.checkNotNullExpressionValue(c2, "inflate(...)");
        this.b = c2;
        e(list, context, z, menuItemClickListener);
    }
}
