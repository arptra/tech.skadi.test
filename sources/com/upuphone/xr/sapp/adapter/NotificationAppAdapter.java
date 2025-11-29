package com.upuphone.xr.sapp.adapter;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.drawable.DrawableKt;
import androidx.navigation.NavController;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.meizu.common.widget.Switch;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.databinding.NotificationAppItemLayoutBinding;
import com.upuphone.xr.sapp.databinding.NotificationAppLetterLayoutBinding;
import com.upuphone.xr.sapp.monitor.notification.AppConfigHelper;
import com.upuphone.xr.sapp.monitor.notification.SuperNotificationManager;
import com.upuphone.xr.sapp.monitor.notification.model.AppInfoModel;
import com.upuphone.xr.sapp.utils.GlobalExtKt;
import flyme.support.v7.widget.MzRecyclerView;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@SourceDebugExtension({"SMAP\nNotificationAppAdapter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NotificationAppAdapter.kt\ncom/upuphone/xr/sapp/adapter/NotificationAppAdapter\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,119:1\n256#2,2:120\n*S KotlinDebug\n*F\n+ 1 NotificationAppAdapter.kt\ncom/upuphone/xr/sapp/adapter/NotificationAppAdapter\n*L\n83#1:120,2\n*E\n"})
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001>B\u001f\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001bH\u0002¢\u0006\u0004\b\u001e\u0010\u001fR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010!R(\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R?\u00102\u001a\u001f\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u0004\u0012\u00020\u0012\u0018\u00010(8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101RT\u0010=\u001a4\u0012\u0013\u0012\u00110\f¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(4\u0012\u0013\u0012\u001105¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(6\u0012\u0004\u0012\u00020\u0012\u0018\u0001038\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<¨\u0006?"}, d2 = {"Lcom/upuphone/xr/sapp/adapter/NotificationAppAdapter;", "Lflyme/support/v7/widget/MzRecyclerView$Adapter;", "Lcom/upuphone/xr/sapp/adapter/NotificationAppAdapter$NotificationAppHolder;", "Landroidx/navigation/NavController;", "navController", "", "Lcom/upuphone/xr/sapp/monitor/notification/model/AppInfoModel;", "mAppList", "<init>", "(Landroidx/navigation/NavController;Ljava/util/List;)V", "Landroid/view/ViewGroup;", "parent", "", "viewType", "k", "(Landroid/view/ViewGroup;I)Lcom/upuphone/xr/sapp/adapter/NotificationAppAdapter$NotificationAppHolder;", "holder", "position", "", "j", "(Lcom/upuphone/xr/sapp/adapter/NotificationAppAdapter$NotificationAppHolder;I)V", "getItemViewType", "(I)I", "getItemCount", "()I", "Landroid/content/Context;", "context", "", "packageName", "Landroid/graphics/Bitmap;", "g", "(Landroid/content/Context;Ljava/lang/String;)Landroid/graphics/Bitmap;", "a", "Landroidx/navigation/NavController;", "b", "Ljava/util/List;", "getMAppList", "()Ljava/util/List;", "setMAppList", "(Ljava/util/List;)V", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "info", "c", "Lkotlin/jvm/functions/Function1;", "h", "()Lkotlin/jvm/functions/Function1;", "l", "(Lkotlin/jvm/functions/Function1;)V", "itemClick", "Lkotlin/Function2;", "index", "", "select", "d", "Lkotlin/jvm/functions/Function2;", "i", "()Lkotlin/jvm/functions/Function2;", "m", "(Lkotlin/jvm/functions/Function2;)V", "switchChange", "NotificationAppHolder", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class NotificationAppAdapter extends MzRecyclerView.Adapter<NotificationAppHolder> {

    /* renamed from: a  reason: collision with root package name */
    public final NavController f6616a;
    public List b;
    public Function1 c;
    public Function2 d;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0006\u0010\b\"\u0004\b\t\u0010\u0005¨\u0006\n"}, d2 = {"Lcom/upuphone/xr/sapp/adapter/NotificationAppAdapter$NotificationAppHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroidx/viewbinding/ViewBinding;", "binding", "<init>", "(Landroidx/viewbinding/ViewBinding;)V", "a", "Landroidx/viewbinding/ViewBinding;", "()Landroidx/viewbinding/ViewBinding;", "setBinding", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static final class NotificationAppHolder extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public ViewBinding f6617a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public NotificationAppHolder(ViewBinding viewBinding) {
            super(viewBinding.getRoot());
            Intrinsics.checkNotNullParameter(viewBinding, "binding");
            this.f6617a = viewBinding;
        }

        public final ViewBinding a() {
            return this.f6617a;
        }
    }

    public NotificationAppAdapter(NavController navController, List list) {
        Intrinsics.checkNotNullParameter(list, "mAppList");
        this.f6616a = navController;
        this.b = list;
    }

    public final Bitmap g(Context context, String str) {
        PackageManager packageManager = context.getPackageManager();
        Drawable loadIcon = packageManager.getPackageInfo(str, 0).applicationInfo.loadIcon(packageManager);
        Intrinsics.checkNotNullExpressionValue(loadIcon, "loadIcon(...)");
        return DrawableKt.b(loadIcon, 0, 0, Bitmap.Config.ARGB_8888, 3, (Object) null);
    }

    public int getItemCount() {
        return this.b.size();
    }

    public int getItemViewType(int i) {
        return ((AppInfoModel) this.b.get(i)).getMIsHeader() ^ true ? 1 : 0;
    }

    public final Function1 h() {
        return this.c;
    }

    public final Function2 i() {
        return this.d;
    }

    /* renamed from: j */
    public void onBindViewHolder(NotificationAppHolder notificationAppHolder, int i) {
        Intrinsics.checkNotNullParameter(notificationAppHolder, "holder");
        AppInfoModel appInfoModel = (AppInfoModel) this.b.get(i);
        if (notificationAppHolder.a() instanceof NotificationAppItemLayoutBinding) {
            ViewBinding a2 = notificationAppHolder.a();
            Intrinsics.checkNotNull(a2, "null cannot be cast to non-null type com.upuphone.xr.sapp.databinding.NotificationAppItemLayoutBinding");
            NotificationAppItemLayoutBinding notificationAppItemLayoutBinding = (NotificationAppItemLayoutBinding) a2;
            notificationAppItemLayoutBinding.f.setChecked(!appInfoModel.getDisableState());
            Switch switchR = notificationAppItemLayoutBinding.f;
            Intrinsics.checkNotNullExpressionValue(switchR, "appSwitch");
            GlobalExtKt.j(switchR, new NotificationAppAdapter$onBindViewHolder$1(this, notificationAppHolder));
            notificationAppItemLayoutBinding.e.setText(appInfoModel.getName());
            if (appInfoModel.getIcon() != null) {
                notificationAppItemLayoutBinding.d.setImageDrawable(appInfoModel.getIcon());
            } else {
                notificationAppItemLayoutBinding.d.setImageBitmap(g(GlobalExtKt.f(), appInfoModel.getPackageName()));
            }
            notificationAppItemLayoutBinding.c.setText(GlobalExtKt.h(AppConfigHelper.d.a().c(appInfoModel.getPackageName()).getShowAllNotify() ? R.string.app_notify_all : R.string.app_notify_important));
            notificationAppItemLayoutBinding.f.setTag(appInfoModel.getPackageName());
            ConstraintLayout constraintLayout = notificationAppItemLayoutBinding.b;
            Intrinsics.checkNotNullExpressionValue(constraintLayout, "appContent");
            GlobalExtKt.l(constraintLayout, this.f6616a, new NotificationAppAdapter$onBindViewHolder$2(this, appInfoModel));
            TextView textView = notificationAppItemLayoutBinding.c;
            Intrinsics.checkNotNullExpressionValue(textView, "appDesc");
            textView.setVisibility(SuperNotificationManager.f7749a.B() ^ true ? 0 : 8);
        }
        if (notificationAppHolder.a() instanceof NotificationAppLetterLayoutBinding) {
            ViewBinding a3 = notificationAppHolder.a();
            Intrinsics.checkNotNull(a3, "null cannot be cast to non-null type com.upuphone.xr.sapp.databinding.NotificationAppLetterLayoutBinding");
            ((NotificationAppLetterLayoutBinding) a3).b.setText(appInfoModel.getLetter());
        }
    }

    /* renamed from: k */
    public NotificationAppHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        ViewBinding viewBinding;
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        if (i == 0) {
            viewBinding = NotificationAppLetterLayoutBinding.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            Intrinsics.checkNotNull(viewBinding);
        } else {
            viewBinding = NotificationAppItemLayoutBinding.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            Intrinsics.checkNotNull(viewBinding);
        }
        return new NotificationAppHolder(viewBinding);
    }

    public final void l(Function1 function1) {
        this.c = function1;
    }

    public final void m(Function2 function2) {
        this.d = function2;
    }
}
