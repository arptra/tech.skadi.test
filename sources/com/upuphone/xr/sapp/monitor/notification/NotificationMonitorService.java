package com.upuphone.xr.sapp.monitor.notification;

import android.content.Intent;
import android.os.IBinder;
import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ServiceLifecycleDispatcher;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.monitor.notification.business.BusinessManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 *2\u00020\u00012\u00020\u0002:\u0001+B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0004J\u001b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\r\u001a\u00020\f2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000f\u0010\u0004J\u000f\u0010\u0010\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0010\u0010\u0004J\u000f\u0010\u0011\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0011\u0010\u0004J\u0019\u0010\u0012\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J+\u0010\u001a\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ)\u0010 \u001a\u00020\u00182\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020\u0018H\u0016¢\u0006\u0004\b \u0010!R\u0014\u0010%\u001a\u00020\"8\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010)\u001a\u00020&8VX\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(¨\u0006,"}, d2 = {"Lcom/upuphone/xr/sapp/monitor/notification/NotificationMonitorService;", "Landroid/service/notification/NotificationListenerService;", "Landroidx/lifecycle/LifecycleOwner;", "<init>", "()V", "", "onCreate", "Landroid/content/Intent;", "intent", "Landroid/os/IBinder;", "onBind", "(Landroid/content/Intent;)Landroid/os/IBinder;", "", "onUnbind", "(Landroid/content/Intent;)Z", "onDestroy", "onListenerConnected", "onListenerDisconnected", "onRebind", "(Landroid/content/Intent;)V", "Landroid/service/notification/StatusBarNotification;", "sbn", "Landroid/service/notification/NotificationListenerService$RankingMap;", "rankingMap", "", "reason", "onNotificationRemoved", "(Landroid/service/notification/StatusBarNotification;Landroid/service/notification/NotificationListenerService$RankingMap;I)V", "onNotificationPosted", "(Landroid/service/notification/StatusBarNotification;)V", "flags", "startId", "onStartCommand", "(Landroid/content/Intent;II)I", "Landroidx/lifecycle/ServiceLifecycleDispatcher;", "a", "Landroidx/lifecycle/ServiceLifecycleDispatcher;", "dispatcher", "Landroidx/lifecycle/Lifecycle;", "getLifecycle", "()Landroidx/lifecycle/Lifecycle;", "lifecycle", "b", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class NotificationMonitorService extends NotificationListenerService implements LifecycleOwner {
    public static final Companion b = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public final ServiceLifecycleDispatcher f7748a = new ServiceLifecycleDispatcher(this);

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/upuphone/xr/sapp/monitor/notification/NotificationMonitorService$Companion;", "", "()V", "TAG", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public Lifecycle getLifecycle() {
        return this.f7748a.a();
    }

    public IBinder onBind(Intent intent) {
        ULog.f6446a.a("NotificationMonitorService", "NotificationMonitorService on bind");
        this.f7748a.b();
        return super.onBind(intent);
    }

    public void onCreate() {
        super.onCreate();
        this.f7748a.c();
        ULog.f6446a.a("NotificationMonitorService", "NotificationMonitorService on create");
    }

    public void onDestroy() {
        ULog.f6446a.a("NotificationMonitorService", "NotificationMonitorService onDestroy");
        this.f7748a.d();
        super.onDestroy();
    }

    public void onListenerConnected() {
        super.onListenerConnected();
        ULog.f6446a.a("NotificationMonitorService", "NotificationMonitorService onListenerConnected");
        BusinessManager g = SuperNotificationManager.f7749a.g();
        if (g != null) {
            g.b(this);
        }
        NotificationListenerHelper.f7746a.e(true);
    }

    public void onListenerDisconnected() {
        super.onListenerDisconnected();
        ULog.f6446a.a("NotificationMonitorService", "NotificationMonitorService onListenerDisconnected");
        NotificationListenerHelper.f7746a.e(false);
    }

    public void onNotificationPosted(StatusBarNotification statusBarNotification) {
        Intrinsics.checkNotNullParameter(statusBarNotification, "sbn");
        ULog.Delegate delegate = ULog.f6446a;
        String packageName = statusBarNotification.getPackageName();
        int id = statusBarNotification.getId();
        delegate.a("NotificationMonitorService", "onNotificationPosted packageName:" + packageName + " id:" + id);
        if (statusBarNotification.getNotification() != null) {
            BusinessManager g = SuperNotificationManager.f7749a.g();
            if (g != null) {
                g.c(statusBarNotification);
            }
            delegate.a("NotificationMonitorService", "onNotificationPosted end");
        }
    }

    public void onNotificationRemoved(StatusBarNotification statusBarNotification, NotificationListenerService.RankingMap rankingMap, int i) {
        BusinessManager g;
        super.onNotificationRemoved(statusBarNotification);
        if (!(statusBarNotification == null || (g = SuperNotificationManager.f7749a.g()) == null)) {
            g.d(statusBarNotification, i);
        }
        ULog.f6446a.a("NotificationMonitorService", "onNotificationRemoved end");
    }

    public void onRebind(Intent intent) {
        ULog.f6446a.a("NotificationMonitorService", "NotificationMonitorService onRebind");
        super.onRebind(intent);
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        ULog.f6446a.a("NotificationMonitorService", "NotificationMonitorService onStartCommand");
        return super.onStartCommand(intent, i, i2);
    }

    public boolean onUnbind(Intent intent) {
        ULog.f6446a.a("NotificationMonitorService", "NotificationMonitorService on Unbind");
        NotificationListenerHelper.f7746a.e(false);
        return super.onUnbind(intent);
    }
}
