package com.upuphone.xr.sapp.fragment;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.databinding.FragmentSmartReminderBinding;
import com.upuphone.xr.sapp.monitor.notification.SuperNotificationManager;
import com.upuphone.xr.sapp.view.GenericMenuView;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class SmartReminderFragment$initView$5 extends Lambda implements Function1<View, Unit> {
    final /* synthetic */ SmartReminderFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SmartReminderFragment$initView$5(SmartReminderFragment smartReminderFragment) {
        super(1);
        this.this$0 = smartReminderFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((View) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "it");
        SmartReminderFragment smartReminderFragment = this.this$0;
        Context requireContext = this.this$0.requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
        List H0 = this.this$0.P0();
        final SmartReminderFragment smartReminderFragment2 = this.this$0;
        smartReminderFragment.l = new GenericMenuView(requireContext, H0, true, new GenericMenuView.MenuItemClickListener() {
            public void a(GenericMenuView.MenuItem menuItem) {
                Intrinsics.checkNotNullParameter(menuItem, "item");
                FragmentSmartReminderBinding E0 = smartReminderFragment2.j;
                if (E0 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    E0 = null;
                }
                E0.i.setText(menuItem.a());
                SuperNotificationManager.f7749a.L((long) menuItem.c());
            }
        }, this.this$0.getString(R.string.notify_dismiss_popup_title));
        GenericMenuView G0 = this.this$0.l;
        if (G0 != null) {
            FragmentActivity requireActivity = this.this$0.requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
            G0.h(requireActivity);
        }
    }
}
