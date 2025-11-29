package com.upuphone.xr.sapp.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.honey.account.h8.p8;
import com.honey.account.h8.q8;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.context.SdkContext;
import com.upuphone.xr.sapp.databinding.FragmentReminderPermissionSteerBinding;
import com.upuphone.xr.sapp.datatrack.ReminderDataTrackEvent;
import com.upuphone.xr.sapp.utils.PermissionAndStateCheckUtils;
import com.upuphone.xr.sapp.utils.StaticMethodUtilsKt;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000K\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0007*\u0001 \u0018\u0000 $2\u00020\u0001:\u0001%B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J+\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0012\u0010\u0003J)\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00132\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001f\u001a\u00020\u001a8BX\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b!\u0010\"¨\u0006&"}, d2 = {"Lcom/upuphone/xr/sapp/fragment/ReminderPermissionSteer;", "Lcom/upuphone/xr/sapp/fragment/BaseFragment;", "<init>", "()V", "", "initView", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onDestroy", "", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "Lcom/upuphone/xr/sapp/databinding/FragmentReminderPermissionSteerBinding;", "j", "Lkotlin/Lazy;", "C0", "()Lcom/upuphone/xr/sapp/databinding/FragmentReminderPermissionSteerBinding;", "binding", "com/upuphone/xr/sapp/fragment/ReminderPermissionSteer$callBack$1", "k", "Lcom/upuphone/xr/sapp/fragment/ReminderPermissionSteer$callBack$1;", "callBack", "l", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class ReminderPermissionSteer extends BaseFragment {
    public static final Companion l = new Companion((DefaultConstructorMarker) null);
    public final Lazy j = LazyKt.lazy(new ReminderPermissionSteer$binding$2(this));
    public ReminderPermissionSteer$callBack$1 k = new ReminderPermissionSteer$callBack$1(this);

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/upuphone/xr/sapp/fragment/ReminderPermissionSteer$Companion;", "", "()V", "PERMISSION_NOTIFICATION_REQUEST_CODE", "", "TAG", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public static final void D0(ReminderPermissionSteer reminderPermissionSteer, View view) {
        Intrinsics.checkNotNullParameter(reminderPermissionSteer, "this$0");
        StaticMethodUtilsKt.x(reminderPermissionSteer, R.id.glassManagerFragment);
    }

    public static final void E0(ReminderPermissionSteer reminderPermissionSteer, View view) {
        Intrinsics.checkNotNullParameter(reminderPermissionSteer, "this$0");
        ULog.f6446a.g("ReminderPermissionSteer", "jump To Super App Details");
        reminderPermissionSteer.startActivityForResult(new Intent("android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS"), 300);
        SdkContext.f6675a.d().reportEvent(ReminderDataTrackEvent.APP_CLICK_REMIND_PERMISSION, new HashMap());
    }

    private final void initView() {
        SdkContext.f6675a.d().reportEvent(ReminderDataTrackEvent.APP_REMIND_PERMISSION, new HashMap());
        requireActivity().getOnBackPressedDispatcher().h(this.k);
        C0().b.setOnClickListener(new p8(this));
        C0().e.setOnClickListener(new q8(this));
    }

    public final FragmentReminderPermissionSteerBinding C0() {
        return (FragmentReminderPermissionSteerBinding) this.j.getValue();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("ReminderPermissionSteer", "onActivityResult::requestCode is: " + i + " and resultCode is: " + i2);
        if (i == 300) {
            PermissionAndStateCheckUtils permissionAndStateCheckUtils = PermissionAndStateCheckUtils.f7907a;
            Context requireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
            if (permissionAndStateCheckUtils.g(requireContext)) {
                StaticMethodUtilsKt.q(this);
            }
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        ULog.f6446a.g("ReminderPermissionSteer", "onCreateView");
        ConstraintLayout b = C0().getRoot();
        Intrinsics.checkNotNullExpressionValue(b, "getRoot(...)");
        return b;
    }

    public void onDestroy() {
        super.onDestroy();
        this.k.setEnabled(false);
        ULog.f6446a.g("ReminderPermissionSteer", "onDestroy");
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        ULog.f6446a.g("ReminderPermissionSteer", "onViewCreated");
        initView();
    }
}
