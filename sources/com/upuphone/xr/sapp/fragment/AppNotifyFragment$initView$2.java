package com.upuphone.xr.sapp.fragment;

import android.widget.LinearLayout;
import com.android.dingtalk.openauth.utils.DDAuthConstant;
import com.meizu.common.widget.Switch;
import com.upuphone.xr.sapp.context.SdkContext;
import com.upuphone.xr.sapp.datatrack.ReminderDataTrackEvent;
import com.upuphone.xr.sapp.monitor.notification.AppConfigHelper;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@SourceDebugExtension({"SMAP\nAppNotifyFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AppNotifyFragment.kt\ncom/upuphone/xr/sapp/fragment/AppNotifyFragment$initView$2\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,172:1\n256#2,2:173\n*S KotlinDebug\n*F\n+ 1 AppNotifyFragment.kt\ncom/upuphone/xr/sapp/fragment/AppNotifyFragment$initView$2\n*L\n88#1:173,2\n*E\n"})
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Lcom/meizu/common/widget/Switch;", "isChecked", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class AppNotifyFragment$initView$2 extends Lambda implements Function2<Switch, Boolean, Unit> {
    final /* synthetic */ AppNotifyFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AppNotifyFragment$initView$2(AppNotifyFragment appNotifyFragment) {
        super(2);
        this.this$0 = appNotifyFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Switch) obj, ((Boolean) obj2).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Switch switchR, boolean z) {
        Intrinsics.checkNotNullParameter(switchR, "<anonymous parameter 0>");
        SdkContext.f6675a.d().reportEvent(ReminderDataTrackEvent.APP_CLICK_REMIND_APP, MapsKt.hashMapOf(TuplesKt.to("status", z ? "1" : "0"), TuplesKt.to(DDAuthConstant.AUTH_LOGIN_TYPE_APP, this.this$0.M0().getPackageName())));
        if (!z) {
            AppNotifyFragment appNotifyFragment = this.this$0;
            appNotifyFragment.K0(appNotifyFragment.M0().getPackageName());
            this.this$0.L0();
        }
        this.this$0.M0().setDisableState(!z);
        AppConfigHelper.d.a().g(this.this$0.M0());
        LinearLayout linearLayout = this.this$0.N0().k;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "appNotifySetting");
        linearLayout.setVisibility(this.this$0.M0().getDisableState() ^ true ? 0 : 8);
    }
}
