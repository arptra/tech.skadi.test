package com.upuphone.xr.sapp.fragment;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.meizu.common.widget.Switch;
import com.upuphone.xr.sapp.databinding.FragmentSmartReminderBinding;
import com.upuphone.xr.sapp.monitor.notification.SuperNotificationManager;
import com.upuphone.xr.sapp.utils.DataStoreUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@SourceDebugExtension({"SMAP\nSmartReminderFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SmartReminderFragment.kt\ncom/upuphone/xr/sapp/fragment/SmartReminderFragment$initView$6\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,489:1\n256#2,2:490\n*S KotlinDebug\n*F\n+ 1 SmartReminderFragment.kt\ncom/upuphone/xr/sapp/fragment/SmartReminderFragment$initView$6\n*L\n171#1:490,2\n*E\n"})
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Lcom/meizu/common/widget/Switch;", "isChecked", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class SmartReminderFragment$initView$6 extends Lambda implements Function2<Switch, Boolean, Unit> {
    final /* synthetic */ SmartReminderFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SmartReminderFragment$initView$6(SmartReminderFragment smartReminderFragment) {
        super(2);
        this.this$0 = smartReminderFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Switch) obj, ((Boolean) obj2).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Switch switchR, boolean z) {
        Intrinsics.checkNotNullParameter(switchR, "<anonymous parameter 0>");
        SuperNotificationManager superNotificationManager = SuperNotificationManager.f7749a;
        superNotificationManager.J(z);
        boolean z2 = true;
        DataStoreUtils.e.a().p("hearing_assist_notify_status_change", Boolean.TRUE, true);
        FragmentSmartReminderBinding E0 = this.this$0.j;
        if (E0 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            E0 = null;
        }
        ConstraintLayout constraintLayout = E0.s;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "phoneBroadcastPauseLay");
        int i = 0;
        if (!this.this$0.T0() || !superNotificationManager.m()) {
            z2 = false;
        }
        if (!z2) {
            i = 8;
        }
        constraintLayout.setVisibility(i);
    }
}
