package com.upuphone.xr.sapp.monitor.notification.business;

import android.service.notification.StatusBarNotification;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.assistant.VoiceAssistantDelegate;
import com.upuphone.xr.sapp.monitor.notification.AppConfigHelper;
import com.upuphone.xr.sapp.monitor.notification.SuperNotificationManager;
import com.upuphone.xr.sapp.monitor.notification.constants.PackageConfig;
import com.upuphone.xr.sapp.monitor.notification.utils.NotificationHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00112\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/upuphone/xr/sapp/monitor/notification/business/AiBusinessHandle;", "Lcom/upuphone/xr/sapp/monitor/notification/business/BusinessHandle;", "<init>", "()V", "Landroid/service/notification/StatusBarNotification;", "sbn", "", "c", "(Landroid/service/notification/StatusBarNotification;)Z", "", "reason", "", "d", "(Landroid/service/notification/StatusBarNotification;I)V", "Lcom/upuphone/xr/sapp/monitor/notification/business/BusinessType;", "a", "()Lcom/upuphone/xr/sapp/monitor/notification/business/BusinessType;", "b", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class AiBusinessHandle extends BusinessHandle {
    public static final Companion b = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/upuphone/xr/sapp/monitor/notification/business/AiBusinessHandle$Companion;", "", "()V", "TAG", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public BusinessType a() {
        return BusinessType.ASSISTANT;
    }

    public boolean c(StatusBarNotification statusBarNotification) {
        Intrinsics.checkNotNullParameter(statusBarNotification, "sbn");
        String e = NotificationHelper.f7775a.e(statusBarNotification);
        if (!SuperNotificationManager.f7749a.C()) {
            ULog.f6446a.c("AiBusinessHandle", "distributedToAI: notify switch not open");
            return false;
        } else if (!PackageConfig.f7770a.c(e) || !AppConfigHelper.d.a().c(e).getDisableState()) {
            VoiceAssistantDelegate.f6640a.b(statusBarNotification);
            return false;
        } else {
            ULog.Delegate delegate = ULog.f6446a;
            String packageName = statusBarNotification.getPackageName();
            delegate.c("AiBusinessHandle", "distributedToAI:current notification【package:" + packageName + "】 is disabled by the user");
            return false;
        }
    }

    public void d(StatusBarNotification statusBarNotification, int i) {
        Intrinsics.checkNotNullParameter(statusBarNotification, "sbn");
        VoiceAssistantDelegate.f6640a.c(statusBarNotification, i);
    }
}
