package com.upuphone.xr.sapp.fragment;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.honey.account.h8.s0;
import com.honey.account.h8.t0;
import com.meizu.common.widget.Switch;
import com.upuphone.xr.interconnect.listener.SendMessageListener;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.context.SdkContext;
import com.upuphone.xr.sapp.databinding.FragmentAppNotifyBinding;
import com.upuphone.xr.sapp.datatrack.ReminderDataTrackEvent;
import com.upuphone.xr.sapp.monitor.notification.AppConfigHelper;
import com.upuphone.xr.sapp.monitor.notification.algorithm.TaxiParse;
import com.upuphone.xr.sapp.monitor.notification.model.AppNotifyConfigModel;
import com.upuphone.xr.sapp.monitor.notification.utils.NotificationHelper;
import com.upuphone.xr.sapp.monitor.starry.StarryMessageHelper;
import com.upuphone.xr.sapp.monitor.starry.StarryNotificationBase;
import com.upuphone.xr.sapp.utils.GlobalExtKt;
import com.upuphone.xr.sapp.utils.PermissionAndStateCheckUtils;
import com.upuphone.xr.sapp.utils.StaticMethodUtilsKt;
import flyme.support.v7.app.AlertDialog;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import sdk.meizu.account.factor.authentication.sdk.constant.ConstantKt;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 &2\u00020\u0001:\u0001'B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J+\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000f\u0010\u0003J!\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0013\u0010\u0003J\u0017\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0018\u0010\u0003R\u001b\u0010\u001e\u001a\u00020\u00198BX\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u001b\u0010%\u001a\u00020!8BX\u0002¢\u0006\f\n\u0004\b\"\u0010\u001b\u001a\u0004\b#\u0010$¨\u0006("}, d2 = {"Lcom/upuphone/xr/sapp/fragment/AppNotifyFragment;", "Lcom/upuphone/xr/sapp/fragment/BaseFragment;", "<init>", "()V", "", "initView", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "onResume", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "I0", "", "packageName", "K0", "(Ljava/lang/String;)V", "L0", "Lcom/upuphone/xr/sapp/databinding/FragmentAppNotifyBinding;", "j", "Lkotlin/Lazy;", "N0", "()Lcom/upuphone/xr/sapp/databinding/FragmentAppNotifyBinding;", "binding", "k", "Ljava/lang/String;", "Lcom/upuphone/xr/sapp/monitor/notification/model/AppNotifyConfigModel;", "l", "M0", "()Lcom/upuphone/xr/sapp/monitor/notification/model/AppNotifyConfigModel;", "appConfig", "m", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nAppNotifyFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AppNotifyFragment.kt\ncom/upuphone/xr/sapp/fragment/AppNotifyFragment\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,172:1\n256#2,2:173\n256#2,2:175\n256#2,2:177\n*S KotlinDebug\n*F\n+ 1 AppNotifyFragment.kt\ncom/upuphone/xr/sapp/fragment/AppNotifyFragment\n*L\n74#1:173,2\n103#1:175,2\n104#1:177,2\n*E\n"})
public final class AppNotifyFragment extends BaseFragment {
    public static final Companion m = new Companion((DefaultConstructorMarker) null);
    public final Lazy j = LazyKt.lazy(new AppNotifyFragment$binding$2(this));
    public String k = "";
    public final Lazy l = LazyKt.lazy(new AppNotifyFragment$appConfig$2(this));

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/upuphone/xr/sapp/fragment/AppNotifyFragment$Companion;", "", "()V", "TAG", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public static final void J0(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
    }

    public static final void O0(AppNotifyFragment appNotifyFragment, View view) {
        Intrinsics.checkNotNullParameter(appNotifyFragment, "this$0");
        StaticMethodUtilsKt.q(appNotifyFragment);
    }

    private final void initView() {
        SdkContext.f6675a.d().reportEvent(ReminderDataTrackEvent.APP_REMIND_APP_NOTICE, new HashMap());
        Bundle arguments = getArguments();
        String string = arguments != null ? arguments.getString("name") : null;
        N0().e.setOnClickListener(new t0(this));
        LinearLayout linearLayout = N0().k;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "appNotifySetting");
        int i = 8;
        linearLayout.setVisibility(M0().getDisableState() ^ true ? 0 : 8);
        N0().e.setText(string);
        N0().l.setChecked(!M0().getDisableState());
        Switch switchR = N0().l;
        Intrinsics.checkNotNullExpressionValue(switchR, "appNotifySwitch");
        GlobalExtKt.j(switchR, new AppNotifyFragment$initView$2(this));
        N0().g.setText(NotificationHelper.f7775a.c(M0().getPackageName()));
        ConstraintLayout constraintLayout = N0().n;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "phoneNotifyItem");
        GlobalExtKt.l(constraintLayout, StaticMethodUtilsKt.i(this), new AppNotifyFragment$initView$3(this));
        AppCompatImageView appCompatImageView = N0().i;
        Intrinsics.checkNotNullExpressionValue(appCompatImageView, "appNotifyImportantSelect");
        appCompatImageView.setVisibility(M0().getShowAllNotify() ^ true ? 0 : 8);
        AppCompatImageView appCompatImageView2 = N0().c;
        Intrinsics.checkNotNullExpressionValue(appCompatImageView2, "appNotifyAllSelect");
        if (M0().getShowAllNotify()) {
            i = 0;
        }
        appCompatImageView2.setVisibility(i);
        ConstraintLayout constraintLayout2 = N0().h;
        Intrinsics.checkNotNullExpressionValue(constraintLayout2, "appNotifyImportantLay");
        GlobalExtKt.d(constraintLayout2, new AppNotifyFragment$initView$4(this));
        ConstraintLayout constraintLayout3 = N0().b;
        Intrinsics.checkNotNullExpressionValue(constraintLayout3, "appNotifyAllLay");
        GlobalExtKt.d(constraintLayout3, new AppNotifyFragment$initView$5(this));
    }

    public final void I0() {
        if (ArraysKt.contains((T[]) AppConfigHelper.d.a().d(), this.k)) {
            new AlertDialog.Builder(requireContext()).setCancelable(false).setMessage((CharSequence) getString(R.string.reminder_app_notify_tips)).setNeutralButton((CharSequence) getString(R.string.standby_not_add_component_button_text), (DialogInterface.OnClickListener) new s0()).show();
        }
    }

    public final void K0(String str) {
        StarryMessageHelper.t(StarryMessageHelper.f7799a, (byte[]) null, new StarryNotificationBase("DISMISS_NOTIFICATION", MapsKt.hashMapOf(TuplesKt.to("ids", ArraysKt.toList((T[]) new String[]{"phone-" + str})), TuplesKt.to("type", 0))), (SendMessageListener) null, 5, (Object) null);
    }

    public final void L0() {
        if (ArraysKt.contains((T[]) TaxiParse.f7753a.a(), this.k)) {
            StarryMessageHelper.t(StarryMessageHelper.f7799a, (byte[]) null, new StarryNotificationBase("DISMISS_REMINDER", MapsKt.hashMapOf(TuplesKt.to("packages", ArraysKt.toList((T[]) new String[]{this.k})))), (SendMessageListener) null, 5, (Object) null);
        }
    }

    public final AppNotifyConfigModel M0() {
        return (AppNotifyConfigModel) this.l.getValue();
    }

    public final FragmentAppNotifyBinding N0() {
        return (FragmentAppNotifyBinding) this.j.getValue();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        ConstraintLayout b = N0().getRoot();
        Intrinsics.checkNotNullExpressionValue(b, "getRoot(...)");
        return b;
    }

    public void onResume() {
        super.onResume();
        PermissionAndStateCheckUtils.f7907a.h(this);
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        Bundle arguments = getArguments();
        this.k = arguments != null ? arguments.getString(ConstantKt.FACTOR_PARAMS_PACKAGE_NAME) : null;
        initView();
    }
}
