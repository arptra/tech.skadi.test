package com.upuphone.xr.sapp.fragment;

import android.view.View;
import android.widget.LinearLayout;
import com.upuphone.xr.sapp.monitor.notification.AppConfigHelper;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@SourceDebugExtension({"SMAP\nAppNotifyFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AppNotifyFragment.kt\ncom/upuphone/xr/sapp/fragment/AppNotifyFragment$initView$3\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,172:1\n256#2,2:173\n*S KotlinDebug\n*F\n+ 1 AppNotifyFragment.kt\ncom/upuphone/xr/sapp/fragment/AppNotifyFragment$initView$3\n*L\n101#1:173,2\n*E\n"})
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class AppNotifyFragment$initView$3 extends Lambda implements Function1<View, Unit> {
    final /* synthetic */ AppNotifyFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AppNotifyFragment$initView$3(AppNotifyFragment appNotifyFragment) {
        super(1);
        this.this$0 = appNotifyFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((View) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "it");
        this.this$0.N0().l.setChecked(!this.this$0.N0().l.isChecked());
        boolean isChecked = this.this$0.N0().l.isChecked();
        if (!isChecked) {
            AppNotifyFragment appNotifyFragment = this.this$0;
            appNotifyFragment.K0(appNotifyFragment.M0().getPackageName());
            this.this$0.L0();
        }
        this.this$0.M0().setDisableState(!isChecked);
        AppConfigHelper.d.a().g(this.this$0.M0());
        LinearLayout linearLayout = this.this$0.N0().k;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "appNotifySetting");
        linearLayout.setVisibility(this.this$0.M0().getDisableState() ^ true ? 0 : 8);
    }
}
