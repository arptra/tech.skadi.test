package com.upuphone.xr.sapp.monitor.notification.business;

import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;
import kotlin.Metadata;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0013\u001a\u00020\u000b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R$\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0014¨\u0006\u0019"}, d2 = {"Lcom/upuphone/xr/sapp/monitor/notification/business/BusinessHandle;", "", "<init>", "()V", "Landroid/service/notification/StatusBarNotification;", "sbn", "", "c", "(Landroid/service/notification/StatusBarNotification;)Z", "", "reason", "", "d", "(Landroid/service/notification/StatusBarNotification;I)V", "Lcom/upuphone/xr/sapp/monitor/notification/business/BusinessType;", "a", "()Lcom/upuphone/xr/sapp/monitor/notification/business/BusinessType;", "Landroid/service/notification/NotificationListenerService;", "mServices", "e", "(Landroid/service/notification/NotificationListenerService;)V", "Landroid/service/notification/NotificationListenerService;", "b", "()Landroid/service/notification/NotificationListenerService;", "f", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public abstract class BusinessHandle {

    /* renamed from: a  reason: collision with root package name */
    public NotificationListenerService f7755a;

    public abstract BusinessType a();

    public NotificationListenerService b() {
        return this.f7755a;
    }

    public abstract boolean c(StatusBarNotification statusBarNotification);

    public abstract void d(StatusBarNotification statusBarNotification, int i);

    public void e(NotificationListenerService notificationListenerService) {
        f(notificationListenerService);
    }

    public void f(NotificationListenerService notificationListenerService) {
        this.f7755a = notificationListenerService;
    }
}
