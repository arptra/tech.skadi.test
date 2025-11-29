package com.upuphone.xr.sapp.fragment;

import com.upuphone.xr.sapp.adapter.NotificationAppAdapter;
import com.upuphone.xr.sapp.monitor.notification.AppConfigHelper;
import com.upuphone.xr.sapp.monitor.notification.model.AppInfoModel;
import com.upuphone.xr.sapp.monitor.notification.model.AppNotifyConfigModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "index", "", "<anonymous parameter 1>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class PhoneNotifyFragment$resetView$1$1 extends Lambda implements Function2<Integer, Boolean, Unit> {
    final /* synthetic */ PhoneNotifyFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PhoneNotifyFragment$resetView$1$1(PhoneNotifyFragment phoneNotifyFragment) {
        super(2);
        this.this$0 = phoneNotifyFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke(((Number) obj).intValue(), ((Boolean) obj2).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int i, boolean z) {
        Object obj = this.this$0.m.get(i);
        Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
        AppInfoModel appInfoModel = (AppInfoModel) obj;
        AppConfigHelper.Companion companion = AppConfigHelper.d;
        AppNotifyConfigModel c = companion.a().c(appInfoModel.getPackageName());
        appInfoModel.setDisableState(!appInfoModel.getDisableState());
        c.setDisableState(appInfoModel.getDisableState());
        companion.a().g(c);
        if (!appInfoModel.getDisableState()) {
            this.this$0.Q0(appInfoModel.getPackageName());
            this.this$0.T0(appInfoModel.getPackageName());
        }
        NotificationAppAdapter J0 = this.this$0.r;
        if (J0 != null) {
            J0.notifyItemChanged(i);
        }
    }
}
