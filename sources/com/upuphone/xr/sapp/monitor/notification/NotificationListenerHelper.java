package com.upuphone.xr.sapp.monitor.notification;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import androidx.work.WorkRequest;
import com.honey.account.constant.AccountConstantKt;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.MainApplication;
import com.upuphone.xr.sapp.utils.GlobalExtKt;
import com.upuphone.xr.sapp.utils.PermissionAndStateCheckUtils;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0003J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\u0003R\u0014\u0010\n\u001a\u00020\b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\tR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0014\u001a\u00020\u000f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0011R*\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00158\u0006@FX\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0010\u0010\u0019\"\u0004\b\u0017\u0010\u001aR*\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u0016\u001a\u00020\u001c8\u0006@FX\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b\u0013\u0010 R\u0014\u0010!\u001a\u00020\u001c8BX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\u001f¨\u0006\""}, d2 = {"Lcom/upuphone/xr/sapp/monitor/notification/NotificationListenerHelper;", "", "<init>", "()V", "", "a", "g", "b", "Landroid/content/Intent;", "Landroid/content/Intent;", "intent", "Landroidx/work/WorkRequest;", "c", "Landroidx/work/WorkRequest;", "mWorkRequest", "", "d", "I", "MAX_RETRY_NUMBER", "e", "retryNumber", "Lcom/upuphone/xr/sapp/monitor/notification/NotificationListenerState;", "value", "f", "Lcom/upuphone/xr/sapp/monitor/notification/NotificationListenerState;", "()Lcom/upuphone/xr/sapp/monitor/notification/NotificationListenerState;", "(Lcom/upuphone/xr/sapp/monitor/notification/NotificationListenerState;)V", "state", "", "Z", "isConnected", "()Z", "(Z)V", "hasListenerPermission", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nNotificationListenerHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NotificationListenerHelper.kt\ncom/upuphone/xr/sapp/monitor/notification/NotificationListenerHelper\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,169:1\n1855#2,2:170\n*S KotlinDebug\n*F\n+ 1 NotificationListenerHelper.kt\ncom/upuphone/xr/sapp/monitor/notification/NotificationListenerHelper\n*L\n87#1:170,2\n*E\n"})
public final class NotificationListenerHelper {

    /* renamed from: a  reason: collision with root package name */
    public static final NotificationListenerHelper f7746a = new NotificationListenerHelper();
    public static final Intent b = new Intent(MainApplication.k.f(), NotificationMonitorService.class);
    public static WorkRequest c;
    public static int d = 5;
    public static int e;
    public static NotificationListenerState f = NotificationListenerState.DISCONNECTED;
    public static boolean g;

    public final void a() {
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("NotificationListenerHelper", "checkServerState");
        if (!c()) {
            f(NotificationListenerState.NO_PERMISSION);
            delegate.a("NotificationListenerHelper", "Notification Listener no Permission");
            return;
        }
        Object systemService = GlobalExtKt.f().getSystemService("activity");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
        List<ActivityManager.RunningServiceInfo> runningServices = ((ActivityManager) systemService).getRunningServices(100);
        Intrinsics.checkNotNullExpressionValue(runningServices, "getRunningServices(...)");
        boolean z = false;
        for (ActivityManager.RunningServiceInfo runningServiceInfo : runningServices) {
            if (Intrinsics.areEqual((Object) runningServiceInfo.service.getClassName(), (Object) "com.upuphone.xr.sapp.monitor.notification.NotificationMonitorService")) {
                z = true;
            }
        }
        ULog.f6446a.a("NotificationListenerHelper", "notification listener service is running:" + z);
        if (!z) {
            GlobalExtKt.f().startService(b);
        } else {
            MainApplication.Companion companion = MainApplication.k;
            PackageManager packageManager = companion.f().getPackageManager();
            Class<NotificationMonitorService> cls = NotificationMonitorService.class;
            packageManager.setComponentEnabledSetting(new ComponentName(companion.f(), cls), 2, 1);
            packageManager.setComponentEnabledSetting(new ComponentName(companion.f(), cls), 1, 1);
        }
        g();
    }

    public final void b() {
        ULog.f6446a.a("NotificationListenerHelper", "closeCheckWork");
        WorkManager.d(GlobalExtKt.f()).a("NotificationStateWorker");
    }

    public final boolean c() {
        return PermissionAndStateCheckUtils.f7907a.g(GlobalExtKt.f());
    }

    public final NotificationListenerState d() {
        return f;
    }

    public final void e(boolean z) {
        g = z;
        ULog.f6446a.a("NotificationListenerHelper", g ? "NotificationListener可用" : "NotificationListener不可用");
        f(g ? NotificationListenerState.CONNECTED : NotificationListenerState.DISCONNECTED);
        if (!z) {
            e = 0;
            g();
            return;
        }
        b();
    }

    public final void f(NotificationListenerState notificationListenerState) {
        Intrinsics.checkNotNullParameter(notificationListenerState, AccountConstantKt.RESPONSE_VALUE);
        ULog.Delegate delegate = ULog.f6446a;
        String name = notificationListenerState.name();
        String name2 = f.name();
        delegate.a("NotificationListenerHelper", "状态发生变化:" + name + " odl:" + name2);
        f = notificationListenerState;
    }

    public final void g() {
        b();
        ULog.f6446a.a("NotificationListenerHelper", "starCheckWork 1 MINUTES retryNumber " + e);
        if (e < d) {
            c = ((OneTimeWorkRequest.Builder) ((OneTimeWorkRequest.Builder) new OneTimeWorkRequest.Builder(RetryNotificationListenerWorker.class).j(60, TimeUnit.SECONDS)).a("NotificationStateWorker")).b();
            WorkManager d2 = WorkManager.d(GlobalExtKt.f());
            WorkRequest workRequest = c;
            Intrinsics.checkNotNull(workRequest);
            d2.b(workRequest);
            e++;
        }
    }
}
