package androidx.work.impl.foreground;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.lifecycle.LifecycleService;
import androidx.work.Logger;
import androidx.work.impl.foreground.SystemForegroundDispatcher;

@RestrictTo
public class SystemForegroundService extends LifecycleService implements SystemForegroundDispatcher.Callback {
    public static final String f = Logger.i("SystemFgService");
    public static SystemForegroundService g = null;
    public Handler b;
    public boolean c;
    public SystemForegroundDispatcher d;
    public NotificationManager e;

    @RequiresApi
    public static class Api29Impl {
        @DoNotInline
        public static void a(Service service, int i, Notification notification, int i2) {
            service.startForeground(i, notification, i2);
        }
    }

    @RequiresApi
    public static class Api31Impl {
        @DoNotInline
        public static void a(Service service, int i, Notification notification, int i2) {
            service.startForeground(i, notification, i2);
        }
    }

    private void f() {
        this.b = new Handler(Looper.getMainLooper());
        this.e = (NotificationManager) getApplicationContext().getSystemService("notification");
        SystemForegroundDispatcher systemForegroundDispatcher = new SystemForegroundDispatcher(getApplicationContext());
        this.d = systemForegroundDispatcher;
        systemForegroundDispatcher.n(this);
    }

    public void a(final int i, final Notification notification) {
        this.b.post(new Runnable() {
            public void run() {
                SystemForegroundService.this.e.notify(i, notification);
            }
        });
    }

    public void c(final int i, final int i2, final Notification notification) {
        this.b.post(new Runnable() {
            public void run() {
                if (Build.VERSION.SDK_INT >= 31) {
                    Api31Impl.a(SystemForegroundService.this, i, notification, i2);
                } else {
                    Api29Impl.a(SystemForegroundService.this, i, notification, i2);
                }
            }
        });
    }

    public void d(final int i) {
        this.b.post(new Runnable() {
            public void run() {
                SystemForegroundService.this.e.cancel(i);
            }
        });
    }

    public void onCreate() {
        super.onCreate();
        g = this;
        f();
    }

    public void onDestroy() {
        super.onDestroy();
        this.d.l();
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        super.onStartCommand(intent, i, i2);
        if (this.c) {
            Logger.e().f(f, "Re-initializing SystemForegroundService after a request to shut-down.");
            this.d.l();
            f();
            this.c = false;
        }
        if (intent == null) {
            return 3;
        }
        this.d.m(intent);
        return 3;
    }

    public void stop() {
        this.c = true;
        Logger.e().a(f, "All commands completed.");
        stopForeground(true);
        g = null;
        stopSelf();
    }
}
