package com.upuphone.xr.sapp.fragment;

import com.upuphone.xr.sapp.monitor.notification.AppConfigHelper;
import com.upuphone.xr.sapp.monitor.notification.model.AppNotifyConfigModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/upuphone/xr/sapp/monitor/notification/model/AppNotifyConfigModel;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class AppNotifyFragment$appConfig$2 extends Lambda implements Function0<AppNotifyConfigModel> {
    final /* synthetic */ AppNotifyFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AppNotifyFragment$appConfig$2(AppNotifyFragment appNotifyFragment) {
        super(0);
        this.this$0 = appNotifyFragment;
    }

    @NotNull
    public final AppNotifyConfigModel invoke() {
        AppConfigHelper a2 = AppConfigHelper.d.a();
        String H0 = this.this$0.k;
        Intrinsics.checkNotNull(H0);
        return a2.c(H0);
    }
}
