package com.upuphone.xr.sapp.monitor.notification.rule;

import android.service.notification.StatusBarNotification;
import com.upuphone.xr.interconnect.util.log.ILog;
import com.upuphone.xr.sapp.monitor.notification.constants.PackageConfig;
import com.upuphone.xr.sapp.monitor.notification.mode.AiSdkResult;
import com.upuphone.xr.sapp.monitor.notification.utils.NotificationHelper;
import com.upuphone.xr.sapp.utils.OSHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/upuphone/xr/sapp/monitor/notification/rule/MmsRule;", "Lcom/upuphone/xr/sapp/monitor/notification/rule/Rule;", "Lcom/upuphone/xr/sapp/monitor/notification/mode/AiSdkResult;", "<init>", "()V", "data", "", "d", "(Lcom/upuphone/xr/sapp/monitor/notification/mode/AiSdkResult;)Z", "", "a", "()Ljava/lang/String;", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class MmsRule extends Rule<AiSdkResult> {
    public String a() {
        return "com.android.mms";
    }

    /* renamed from: d */
    public boolean c(AiSdkResult aiSdkResult) {
        Intrinsics.checkNotNullParameter(aiSdkResult, "data");
        StatusBarNotification sbn = aiSdkResult.getSbn();
        String e = NotificationHelper.f7775a.e(sbn);
        if (OSHelper.f7904a.g() && PackageConfig.f7770a.b(e) && sbn.getId() == 999) {
            return false;
        }
        if (!Intrinsics.areEqual((Object) sbn.getNotification().getChannelId(), (Object) "Channel_Foreground_Service")) {
            return true;
        }
        ILog.e(b(), "current notify is wechat Foreground_Service");
        return false;
    }
}
