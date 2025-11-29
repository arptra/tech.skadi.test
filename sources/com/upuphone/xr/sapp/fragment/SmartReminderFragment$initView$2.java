package com.upuphone.xr.sapp.fragment;

import android.view.View;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.utils.StaticMethodUtilsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class SmartReminderFragment$initView$2 extends Lambda implements Function1<View, Unit> {
    final /* synthetic */ SmartReminderFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SmartReminderFragment$initView$2(SmartReminderFragment smartReminderFragment) {
        super(1);
        this.this$0 = smartReminderFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((View) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "it");
        StaticMethodUtilsKt.t(this.this$0, R.id.wiseNotifyFragment);
    }
}
