package com.upuphone.xr.sapp.fragment;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.meizu.common.widget.Switch;
import com.upuphone.xr.sapp.databinding.FragmentSmartReminderBinding;
import com.upuphone.xr.sapp.monitor.notification.SuperNotificationManager;
import com.upuphone.xr.sapp.utils.DataStoreUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@SourceDebugExtension({"SMAP\nSmartReminderFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SmartReminderFragment.kt\ncom/upuphone/xr/sapp/fragment/SmartReminderFragment$initView$7\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,489:1\n256#2,2:490\n*S KotlinDebug\n*F\n+ 1 SmartReminderFragment.kt\ncom/upuphone/xr/sapp/fragment/SmartReminderFragment$initView$7\n*L\n182#1:490,2\n*E\n"})
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class SmartReminderFragment$initView$7 extends Lambda implements Function1<View, Unit> {
    final /* synthetic */ SmartReminderFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SmartReminderFragment$initView$7(SmartReminderFragment smartReminderFragment) {
        super(1);
        this.this$0 = smartReminderFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((View) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "it");
        FragmentSmartReminderBinding E0 = this.this$0.j;
        FragmentSmartReminderBinding fragmentSmartReminderBinding = null;
        if (E0 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            E0 = null;
        }
        Switch switchR = E0.u;
        FragmentSmartReminderBinding E02 = this.this$0.j;
        if (E02 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            E02 = null;
        }
        boolean z = true;
        switchR.setChecked(!E02.u.isChecked());
        SuperNotificationManager superNotificationManager = SuperNotificationManager.f7749a;
        FragmentSmartReminderBinding E03 = this.this$0.j;
        if (E03 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            E03 = null;
        }
        superNotificationManager.J(E03.u.isChecked());
        DataStoreUtils.e.a().p("hearing_assist_notify_status_change", Boolean.TRUE, true);
        FragmentSmartReminderBinding E04 = this.this$0.j;
        if (E04 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentSmartReminderBinding = E04;
        }
        ConstraintLayout constraintLayout = fragmentSmartReminderBinding.s;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "phoneBroadcastPauseLay");
        int i = 0;
        if (!this.this$0.T0() || !superNotificationManager.m()) {
            z = false;
        }
        if (!z) {
            i = 8;
        }
        constraintLayout.setVisibility(i);
    }
}
