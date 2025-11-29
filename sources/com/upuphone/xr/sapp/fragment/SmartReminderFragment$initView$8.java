package com.upuphone.xr.sapp.fragment;

import android.content.DialogInterface;
import android.view.View;
import android.widget.TextView;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.databinding.FragmentSmartReminderBinding;
import com.upuphone.xr.sapp.monitor.notification.SuperNotificationManager;
import flyme.support.v7.app.AlertDialog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class SmartReminderFragment$initView$8 extends Lambda implements Function1<View, Unit> {
    final /* synthetic */ SmartReminderFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SmartReminderFragment$initView$8(SmartReminderFragment smartReminderFragment) {
        super(1);
        this.this$0 = smartReminderFragment;
    }

    /* access modifiers changed from: private */
    public static final void invoke$lambda$0(SmartReminderFragment smartReminderFragment, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(smartReminderFragment, "this$0");
        FragmentSmartReminderBinding E0 = smartReminderFragment.j;
        String[] strArr = null;
        if (E0 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            E0 = null;
        }
        TextView textView = E0.t;
        String[] F0 = smartReminderFragment.s;
        if (F0 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("broadcastPauseArray");
        } else {
            strArr = F0;
        }
        textView.setText(strArr[i]);
        dialogInterface.dismiss();
        SuperNotificationManager.f7749a.K(i + 1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((View) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "it");
        int n = SuperNotificationManager.f7749a.n() - 1;
        AlertDialog.Builder builder = new AlertDialog.Builder(this.this$0.requireContext());
        String[] F0 = this.this$0.s;
        if (F0 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("broadcastPauseArray");
            F0 = null;
        }
        AlertDialog.Builder singleChoiceItems = builder.setSingleChoiceItems((CharSequence[]) F0, n, (DialogInterface.OnClickListener) new e(this.this$0));
        singleChoiceItems.setTitle((CharSequence) this.this$0.getString(R.string.phone_broadcast_pause));
        singleChoiceItems.create().show();
    }
}
