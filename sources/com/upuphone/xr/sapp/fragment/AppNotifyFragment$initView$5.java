package com.upuphone.xr.sapp.fragment;

import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import com.upuphone.xr.sapp.context.SdkContext;
import com.upuphone.xr.sapp.datatrack.ReminderDataTrackEvent;
import com.upuphone.xr.sapp.monitor.notification.AppConfigHelper;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@SourceDebugExtension({"SMAP\nAppNotifyFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AppNotifyFragment.kt\ncom/upuphone/xr/sapp/fragment/AppNotifyFragment$initView$5\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,172:1\n256#2,2:173\n256#2,2:175\n*S KotlinDebug\n*F\n+ 1 AppNotifyFragment.kt\ncom/upuphone/xr/sapp/fragment/AppNotifyFragment$initView$5\n*L\n119#1:173,2\n120#1:175,2\n*E\n"})
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class AppNotifyFragment$initView$5 extends Lambda implements Function1<View, Unit> {
    final /* synthetic */ AppNotifyFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AppNotifyFragment$initView$5(AppNotifyFragment appNotifyFragment) {
        super(1);
        this.this$0 = appNotifyFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((View) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "it");
        this.this$0.M0().setShowAllNotify(true);
        AppConfigHelper.d.a().g(this.this$0.M0());
        AppCompatImageView appCompatImageView = this.this$0.N0().i;
        Intrinsics.checkNotNullExpressionValue(appCompatImageView, "appNotifyImportantSelect");
        int i = 8;
        appCompatImageView.setVisibility(true ^ this.this$0.M0().getShowAllNotify() ? 0 : 8);
        AppCompatImageView appCompatImageView2 = this.this$0.N0().c;
        Intrinsics.checkNotNullExpressionValue(appCompatImageView2, "appNotifyAllSelect");
        if (this.this$0.M0().getShowAllNotify()) {
            i = 0;
        }
        appCompatImageView2.setVisibility(i);
        SdkContext.f6675a.d().reportEvent(ReminderDataTrackEvent.APP_CLICK_REMIND_APP_IMPORTANT, MapsKt.hashMapOf(TuplesKt.to("status", "0")));
    }
}
