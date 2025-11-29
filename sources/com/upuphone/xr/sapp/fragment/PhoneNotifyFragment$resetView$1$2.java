package com.upuphone.xr.sapp.fragment;

import android.os.Bundle;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.monitor.notification.SuperNotificationManager;
import com.upuphone.xr.sapp.monitor.notification.model.AppInfoModel;
import com.upuphone.xr.sapp.utils.StaticMethodUtilsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import sdk.meizu.account.factor.authentication.sdk.constant.ConstantKt;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/upuphone/xr/sapp/monitor/notification/model/AppInfoModel;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class PhoneNotifyFragment$resetView$1$2 extends Lambda implements Function1<AppInfoModel, Unit> {
    final /* synthetic */ PhoneNotifyFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PhoneNotifyFragment$resetView$1$2(PhoneNotifyFragment phoneNotifyFragment) {
        super(1);
        this.this$0 = phoneNotifyFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((AppInfoModel) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull AppInfoModel appInfoModel) {
        Intrinsics.checkNotNullParameter(appInfoModel, "it");
        if (!SuperNotificationManager.f7749a.B()) {
            PhoneNotifyFragment phoneNotifyFragment = this.this$0;
            int i = R.id.appNotifyFragment;
            Bundle bundle = new Bundle();
            bundle.putString("name", appInfoModel.getName());
            bundle.putString(ConstantKt.FACTOR_PARAMS_PACKAGE_NAME, appInfoModel.getPackageName());
            Unit unit = Unit.INSTANCE;
            StaticMethodUtilsKt.v(phoneNotifyFragment, i, bundle);
            this.this$0.t = appInfoModel.getPackageName();
        }
    }
}
