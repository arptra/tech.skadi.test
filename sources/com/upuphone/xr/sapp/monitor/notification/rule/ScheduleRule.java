package com.upuphone.xr.sapp.monitor.notification.rule;

import com.upuphone.sdk.ArSmartReminderModel;
import com.upuphone.xr.sapp.monitor.notification.mode.AiSdkResult;
import com.upuphone.xr.sapp.monitor.notification.utils.NotificationHelper;
import com.upuphone.xr.sapp.monitor.schedule.ScheduleDataSyncManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0011\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/upuphone/xr/sapp/monitor/notification/rule/ScheduleRule;", "Lcom/upuphone/xr/sapp/monitor/notification/rule/Rule;", "Lcom/upuphone/xr/sapp/monitor/notification/mode/AiSdkResult;", "<init>", "()V", "data", "", "d", "(Lcom/upuphone/xr/sapp/monitor/notification/mode/AiSdkResult;)Z", "", "a", "()Ljava/lang/String;", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class ScheduleRule extends Rule<AiSdkResult> {
    public String a() {
        return null;
    }

    /* renamed from: d */
    public boolean c(AiSdkResult aiSdkResult) {
        Intrinsics.checkNotNullParameter(aiSdkResult, "data");
        String e = NotificationHelper.f7775a.e(aiSdkResult.getSbn());
        ArSmartReminderModel model = aiSdkResult.getModel();
        String g = model != null ? model.g() : null;
        if (g == null) {
            g = "";
        }
        return !ScheduleDataSyncManager.f7777a.j(g, e);
    }
}
