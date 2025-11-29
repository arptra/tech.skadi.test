package com.upuphone.xr.sapp.monitor.notification;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.utils.GlobalExtKt;
import com.upuphone.xr.sapp.utils.PermissionAndStateCheckUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/upuphone/xr/sapp/monitor/notification/RetryNotificationListenerWorker;", "Landroidx/work/Worker;", "Landroid/content/Context;", "context", "Landroidx/work/WorkerParameters;", "workerParams", "<init>", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "Landroidx/work/ListenableWorker$Result;", "p", "()Landroidx/work/ListenableWorker$Result;", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class RetryNotificationListenerWorker extends Worker {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RetryNotificationListenerWorker(@NotNull Context context, @NotNull WorkerParameters workerParameters) {
        super(context, workerParameters);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(workerParameters, "workerParams");
    }

    public ListenableWorker.Result p() {
        boolean g = PermissionAndStateCheckUtils.f7907a.g(GlobalExtKt.f());
        ULog.Delegate delegate = ULog.f6446a;
        NotificationListenerHelper notificationListenerHelper = NotificationListenerHelper.f7746a;
        String name = notificationListenerHelper.d().name();
        delegate.a("NotificationListenerHelper", "CheckNotificationListenerWorker hasPermission:" + g + " state:" + name + " ");
        if (!g || notificationListenerHelper.d() != NotificationListenerState.DISCONNECTED) {
            ListenableWorker.Result a2 = ListenableWorker.Result.a();
            Intrinsics.checkNotNullExpressionValue(a2, "failure(...)");
            return a2;
        }
        notificationListenerHelper.a();
        ListenableWorker.Result c = ListenableWorker.Result.c();
        Intrinsics.checkNotNullExpressionValue(c, "success(...)");
        return c;
    }
}
