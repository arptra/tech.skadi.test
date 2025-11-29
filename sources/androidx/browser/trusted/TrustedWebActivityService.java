package androidx.browser.trusted;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.BitmapFactory;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.support.customtabs.trusted.ITrustedWebActivityService;
import androidx.annotation.RequiresPermission;
import androidx.browser.trusted.TrustedWebActivityServiceConnection;
import androidx.core.app.NotificationManagerCompat;
import java.util.Locale;

public abstract class TrustedWebActivityService extends Service {

    /* renamed from: a  reason: collision with root package name */
    public NotificationManager f438a;
    public int b = -1;
    public final ITrustedWebActivityService.Stub c = new ITrustedWebActivityService.Stub() {
        private void checkCaller() {
            TrustedWebActivityService trustedWebActivityService = TrustedWebActivityService.this;
            if (trustedWebActivityService.b == -1) {
                String[] packagesForUid = trustedWebActivityService.getPackageManager().getPackagesForUid(Binder.getCallingUid());
                int i = 0;
                if (packagesForUid == null) {
                    packagesForUid = new String[0];
                }
                Token load = TrustedWebActivityService.this.c().load();
                PackageManager packageManager = TrustedWebActivityService.this.getPackageManager();
                if (load != null) {
                    int length = packagesForUid.length;
                    while (true) {
                        if (i >= length) {
                            break;
                        } else if (load.a(packagesForUid[i], packageManager)) {
                            TrustedWebActivityService.this.b = Binder.getCallingUid();
                            break;
                        } else {
                            i++;
                        }
                    }
                }
            }
            if (TrustedWebActivityService.this.b != Binder.getCallingUid()) {
                throw new SecurityException("Caller is not verified as Trusted Web Activity provider.");
            }
        }

        public Bundle areNotificationsEnabled(Bundle bundle) {
            checkCaller();
            return new TrustedWebActivityServiceConnection.ResultArgs(TrustedWebActivityService.this.d(TrustedWebActivityServiceConnection.NotificationsEnabledArgs.a(bundle).f442a)).a();
        }

        public void cancelNotification(Bundle bundle) {
            checkCaller();
            TrustedWebActivityServiceConnection.CancelNotificationArgs a2 = TrustedWebActivityServiceConnection.CancelNotificationArgs.a(bundle);
            TrustedWebActivityService.this.e(a2.f441a, a2.b);
        }

        public Bundle extraCommand(String str, Bundle bundle, IBinder iBinder) {
            checkCaller();
            return TrustedWebActivityService.this.f(str, bundle, TrustedWebActivityCallbackRemote.a(iBinder));
        }

        public Bundle getActiveNotifications() {
            checkCaller();
            return new TrustedWebActivityServiceConnection.ActiveNotificationsArgs(TrustedWebActivityService.this.g()).a();
        }

        public Bundle getSmallIconBitmap() {
            checkCaller();
            return TrustedWebActivityService.this.h();
        }

        public int getSmallIconId() {
            checkCaller();
            return TrustedWebActivityService.this.i();
        }

        @RequiresPermission
        public Bundle notifyNotificationWithChannel(Bundle bundle) {
            checkCaller();
            TrustedWebActivityServiceConnection.NotifyNotificationArgs a2 = TrustedWebActivityServiceConnection.NotifyNotificationArgs.a(bundle);
            return new TrustedWebActivityServiceConnection.ResultArgs(TrustedWebActivityService.this.j(a2.f443a, a2.b, a2.c, a2.d)).a();
        }
    };

    public static String a(String str) {
        return str.toLowerCase(Locale.ROOT).replace(' ', '_') + "_channel_id";
    }

    public final void b() {
        if (this.f438a == null) {
            throw new IllegalStateException("TrustedWebActivityService has not been properly initialized. Did onCreate() call super.onCreate()?");
        }
    }

    public abstract TokenStore c();

    public boolean d(String str) {
        b();
        if (!NotificationManagerCompat.g(this).a()) {
            return false;
        }
        return NotificationApiHelperForO.b(this.f438a, a(str));
    }

    public void e(String str, int i) {
        b();
        this.f438a.cancel(str, i);
    }

    public Bundle f(String str, Bundle bundle, TrustedWebActivityCallbackRemote trustedWebActivityCallbackRemote) {
        return null;
    }

    public Parcelable[] g() {
        b();
        return NotificationApiHelperForM.a(this.f438a);
    }

    public Bundle h() {
        int i = i();
        Bundle bundle = new Bundle();
        if (i == -1) {
            return bundle;
        }
        bundle.putParcelable("android.support.customtabs.trusted.SMALL_ICON_BITMAP", BitmapFactory.decodeResource(getResources(), i));
        return bundle;
    }

    public int i() {
        try {
            Bundle bundle = getPackageManager().getServiceInfo(new ComponentName(this, getClass()), 128).metaData;
            if (bundle == null) {
                return -1;
            }
            return bundle.getInt("android.support.customtabs.trusted.SMALL_ICON", -1);
        } catch (PackageManager.NameNotFoundException unused) {
            return -1;
        }
    }

    public boolean j(String str, int i, Notification notification, String str2) {
        b();
        if (!NotificationManagerCompat.g(this).a()) {
            return false;
        }
        String a2 = a(str2);
        Notification a3 = NotificationApiHelperForO.a(this, this.f438a, notification, a2, str2);
        if (!NotificationApiHelperForO.b(this.f438a, a2)) {
            return false;
        }
        this.f438a.notify(str, i, a3);
        return true;
    }

    public final IBinder onBind(Intent intent) {
        return this.c;
    }

    public void onCreate() {
        super.onCreate();
        this.f438a = (NotificationManager) getSystemService("notification");
    }

    public final boolean onUnbind(Intent intent) {
        this.b = -1;
        return super.onUnbind(intent);
    }
}
