package com.upuphone.xr.sapp.fragment;

import android.view.View;
import com.upuphone.xr.sapp.databinding.FragmentSmartReminderBinding;
import com.upuphone.xr.sapp.monitor.notification.SuperNotificationManager;
import com.upuphone.xr.sapp.utils.StaticMethodUtilsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class SmartReminderFragment$initView$14 extends Lambda implements Function1<View, Unit> {
    final /* synthetic */ SmartReminderFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SmartReminderFragment$initView$14(SmartReminderFragment smartReminderFragment) {
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
        boolean isChecked = E0.e.getBinding().i.isChecked();
        FragmentSmartReminderBinding E02 = this.this$0.j;
        if (E02 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentSmartReminderBinding = E02;
        }
        fragmentSmartReminderBinding.e.getBinding().i.setChecked(!isChecked);
        SmartReminderFragment smartReminderFragment = this.this$0;
        boolean a2 = StaticMethodUtilsKt.a(smartReminderFragment, smartReminderFragment.O0());
        SuperNotificationManager.f7749a.H(!isChecked);
        if (!a2) {
            this.this$0.X0();
        }
    }
}
