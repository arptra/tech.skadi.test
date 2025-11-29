package com.upuphone.xr.sapp.ring2;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import androidx.core.app.NotificationCompat;
import androidx.core.app.ServiceCompat;
import com.meizu.common.widget.CircleProgressBar;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.MainApplication;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.utils.GlobalExtKt;
import com.xjmz.myvu.MYVUActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00192\u00020\u0001:\u0001\u001aB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0003J\u001b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ)\u0010\u000e\u001a\u00020\u000b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0010\u0010\u0003J\u000f\u0010\u0011\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0011\u0010\u0003J\u000f\u0010\u0012\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0012\u0010\u0003J\u000f\u0010\u0013\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J!\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\u0015\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0017\u0010\u0018¨\u0006\u001b"}, d2 = {"Lcom/upuphone/xr/sapp/ring2/SportService;", "Landroid/app/Service;", "<init>", "()V", "", "onCreate", "Landroid/content/Intent;", "intent", "Landroid/os/IBinder;", "onBind", "(Landroid/content/Intent;)Landroid/os/IBinder;", "", "flags", "startId", "onStartCommand", "(Landroid/content/Intent;II)I", "onDestroy", "f", "b", "c", "()Landroid/content/Intent;", "code", "Landroid/app/PendingIntent;", "d", "(Landroid/content/Intent;I)Landroid/app/PendingIntent;", "a", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class SportService extends Service {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f7826a = new Companion((DefaultConstructorMarker) null);
    public static boolean b;

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0010\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0011\u0010\fR\u0014\u0010\u0013\u001a\u00020\u00128\u0006XT¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u00128\u0006XT¢\u0006\u0006\n\u0004\b\u0015\u0010\u0014R\u0014\u0010\u0017\u001a\u00020\u00168\u0006XT¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u00128\u0006XT¢\u0006\u0006\n\u0004\b\u0019\u0010\u0014R\u0016\u0010\u001a\u001a\u00020\r8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lcom/upuphone/xr/sapp/ring2/SportService$Companion;", "", "<init>", "()V", "", "data", "", "a", "([B)V", "Landroid/content/Context;", "context", "e", "(Landroid/content/Context;)V", "", "c", "([B)Z", "b", "d", "", "SPORT_SERVICE_NOTIFICATION_CHANNEL_ID", "Ljava/lang/String;", "SPORT_SERVICE_NOTIFICATION_CHANNEL_NAME", "", "SPORT_SERVICE_NOTIFICATION_ID", "I", "TAG", "isSportServiceRunning", "Z", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(byte[] bArr) {
            Intrinsics.checkNotNullParameter(bArr, "data");
            if (c(bArr)) {
                if (bArr[1] != -1) {
                    d(MainApplication.k.d());
                } else {
                    e(MainApplication.k.d());
                }
            } else if (b(bArr) && bArr[1] == 0) {
                e(MainApplication.k.d());
            }
        }

        public final boolean b(byte[] bArr) {
            return bArr[0] == 25;
        }

        public final boolean c(byte[] bArr) {
            return bArr[0] == 24;
        }

        public final void d(Context context) {
            if (!SportService.b) {
                ULog.f6446a.g("SportService", "开启运动服务");
                context.startForegroundService(new Intent(context, SportService.class));
            }
        }

        public final void e(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            ULog.f6446a.g("SportService", "停止运动服务");
            context.stopService(new Intent(context, SportService.class));
        }

        public Companion() {
        }
    }

    public static /* synthetic */ PendingIntent e(SportService sportService, Intent intent, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return sportService.d(intent, i);
    }

    public final void b() {
        ULog.f6446a.g("SportService", "创建通知通道");
        NotificationChannel notificationChannel = new NotificationChannel("sport_service_notification_channel_id", "sport_service_notification_channel_name", 3);
        NotificationManager notificationManager = (NotificationManager) getSystemService(NotificationManager.class);
        if (notificationManager != null) {
            notificationManager.createNotificationChannel(notificationChannel);
        }
    }

    public final Intent c() {
        return new Intent(this, MYVUActivity.class);
    }

    public final PendingIntent d(Intent intent, int i) {
        PendingIntent activity = PendingIntent.getActivity(GlobalExtKt.f(), i, intent, CircleProgressBar.RIM_COLOR_DEF);
        Intrinsics.checkNotNullExpressionValue(activity, "getActivity(...)");
        return activity;
    }

    public final void f() {
        try {
            b();
            int i = 0;
            Notification c = new NotificationCompat.Builder(this, "sport_service_notification_channel_id").n("STARV Ring2").m(MainApplication.k.d().getString(R.string.sport_service_notification_content)).H(R.drawable.notification_logo).l(e(this, c(), 0, 2, (Object) null)).c();
            Intrinsics.checkNotNullExpressionValue(c, "build(...)");
            if (Build.VERSION.SDK_INT >= 30) {
                i = 8;
            }
            ServiceCompat.a(this, 100, c, i);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        super.onCreate();
        b = true;
        f();
    }

    public void onDestroy() {
        super.onDestroy();
        b = false;
        stopForeground(1);
        stopSelf();
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        return 1;
    }
}
