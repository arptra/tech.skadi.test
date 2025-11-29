package androidx.browser.trusted;

import android.app.Notification;
import android.content.ComponentName;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.customtabs.trusted.ITrustedWebActivityService;

public final class TrustedWebActivityServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    public final ITrustedWebActivityService f439a;
    public final ComponentName b;

    public static class ActiveNotificationsArgs {

        /* renamed from: a  reason: collision with root package name */
        public final Parcelable[] f440a;

        public ActiveNotificationsArgs(Parcelable[] parcelableArr) {
            this.f440a = parcelableArr;
        }

        public Bundle a() {
            Bundle bundle = new Bundle();
            bundle.putParcelableArray("android.support.customtabs.trusted.ACTIVE_NOTIFICATIONS", this.f440a);
            return bundle;
        }
    }

    public static class CancelNotificationArgs {

        /* renamed from: a  reason: collision with root package name */
        public final String f441a;
        public final int b;

        public CancelNotificationArgs(String str, int i) {
            this.f441a = str;
            this.b = i;
        }

        public static CancelNotificationArgs a(Bundle bundle) {
            TrustedWebActivityServiceConnection.a(bundle, "android.support.customtabs.trusted.PLATFORM_TAG");
            TrustedWebActivityServiceConnection.a(bundle, "android.support.customtabs.trusted.PLATFORM_ID");
            return new CancelNotificationArgs(bundle.getString("android.support.customtabs.trusted.PLATFORM_TAG"), bundle.getInt("android.support.customtabs.trusted.PLATFORM_ID"));
        }
    }

    public static class NotificationsEnabledArgs {

        /* renamed from: a  reason: collision with root package name */
        public final String f442a;

        public NotificationsEnabledArgs(String str) {
            this.f442a = str;
        }

        public static NotificationsEnabledArgs a(Bundle bundle) {
            TrustedWebActivityServiceConnection.a(bundle, "android.support.customtabs.trusted.CHANNEL_NAME");
            return new NotificationsEnabledArgs(bundle.getString("android.support.customtabs.trusted.CHANNEL_NAME"));
        }
    }

    public static class NotifyNotificationArgs {

        /* renamed from: a  reason: collision with root package name */
        public final String f443a;
        public final int b;
        public final Notification c;
        public final String d;

        public NotifyNotificationArgs(String str, int i, Notification notification, String str2) {
            this.f443a = str;
            this.b = i;
            this.c = notification;
            this.d = str2;
        }

        public static NotifyNotificationArgs a(Bundle bundle) {
            TrustedWebActivityServiceConnection.a(bundle, "android.support.customtabs.trusted.PLATFORM_TAG");
            TrustedWebActivityServiceConnection.a(bundle, "android.support.customtabs.trusted.PLATFORM_ID");
            TrustedWebActivityServiceConnection.a(bundle, "android.support.customtabs.trusted.NOTIFICATION");
            TrustedWebActivityServiceConnection.a(bundle, "android.support.customtabs.trusted.CHANNEL_NAME");
            return new NotifyNotificationArgs(bundle.getString("android.support.customtabs.trusted.PLATFORM_TAG"), bundle.getInt("android.support.customtabs.trusted.PLATFORM_ID"), (Notification) bundle.getParcelable("android.support.customtabs.trusted.NOTIFICATION"), bundle.getString("android.support.customtabs.trusted.CHANNEL_NAME"));
        }
    }

    public static class ResultArgs {

        /* renamed from: a  reason: collision with root package name */
        public final boolean f444a;

        public ResultArgs(boolean z) {
            this.f444a = z;
        }

        public Bundle a() {
            Bundle bundle = new Bundle();
            bundle.putBoolean("android.support.customtabs.trusted.NOTIFICATION_SUCCESS", this.f444a);
            return bundle;
        }
    }

    public TrustedWebActivityServiceConnection(ITrustedWebActivityService iTrustedWebActivityService, ComponentName componentName) {
        this.f439a = iTrustedWebActivityService;
        this.b = componentName;
    }

    public static void a(Bundle bundle, String str) {
        if (!bundle.containsKey(str)) {
            throw new IllegalArgumentException("Bundle must contain " + str);
        }
    }
}
