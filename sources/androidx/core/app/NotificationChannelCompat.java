package androidx.core.app;

import android.app.Notification;
import android.app.NotificationChannel;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.core.util.Preconditions;

public class NotificationChannelCompat {

    /* renamed from: a  reason: collision with root package name */
    public final String f657a;
    public CharSequence b;
    public int c;
    public String d;
    public String e;
    public boolean f = true;
    public Uri g = Settings.System.DEFAULT_NOTIFICATION_URI;
    public AudioAttributes h;
    public boolean i;
    public int j = 0;
    public boolean k;
    public long[] l;
    public String m;
    public String n;

    @RequiresApi
    public static class Api26Impl {
        @DoNotInline
        public static boolean a(NotificationChannel notificationChannel) {
            return notificationChannel.canBypassDnd();
        }

        @DoNotInline
        public static boolean b(NotificationChannel notificationChannel) {
            return notificationChannel.canShowBadge();
        }

        @DoNotInline
        public static NotificationChannel c(String str, CharSequence charSequence, int i) {
            return new NotificationChannel(str, charSequence, i);
        }

        @DoNotInline
        public static void d(NotificationChannel notificationChannel, boolean z) {
            notificationChannel.enableLights(z);
        }

        @DoNotInline
        public static void e(NotificationChannel notificationChannel, boolean z) {
            notificationChannel.enableVibration(z);
        }

        @DoNotInline
        public static AudioAttributes f(NotificationChannel notificationChannel) {
            return notificationChannel.getAudioAttributes();
        }

        @DoNotInline
        public static String g(NotificationChannel notificationChannel) {
            return notificationChannel.getDescription();
        }

        @DoNotInline
        public static String h(NotificationChannel notificationChannel) {
            return notificationChannel.getGroup();
        }

        @DoNotInline
        public static String i(NotificationChannel notificationChannel) {
            return notificationChannel.getId();
        }

        @DoNotInline
        public static int j(NotificationChannel notificationChannel) {
            return notificationChannel.getImportance();
        }

        @DoNotInline
        public static int k(NotificationChannel notificationChannel) {
            return notificationChannel.getLightColor();
        }

        @DoNotInline
        public static int l(NotificationChannel notificationChannel) {
            return notificationChannel.getLockscreenVisibility();
        }

        @DoNotInline
        public static CharSequence m(NotificationChannel notificationChannel) {
            return notificationChannel.getName();
        }

        @DoNotInline
        public static Uri n(NotificationChannel notificationChannel) {
            return notificationChannel.getSound();
        }

        @DoNotInline
        public static long[] o(NotificationChannel notificationChannel) {
            return notificationChannel.getVibrationPattern();
        }

        @DoNotInline
        public static void p(NotificationChannel notificationChannel, String str) {
            notificationChannel.setDescription(str);
        }

        @DoNotInline
        public static void q(NotificationChannel notificationChannel, String str) {
            notificationChannel.setGroup(str);
        }

        @DoNotInline
        public static void r(NotificationChannel notificationChannel, int i) {
            notificationChannel.setLightColor(i);
        }

        @DoNotInline
        public static void s(NotificationChannel notificationChannel, boolean z) {
            notificationChannel.setShowBadge(z);
        }

        @DoNotInline
        public static void t(NotificationChannel notificationChannel, Uri uri, AudioAttributes audioAttributes) {
            notificationChannel.setSound(uri, audioAttributes);
        }

        @DoNotInline
        public static void u(NotificationChannel notificationChannel, long[] jArr) {
            notificationChannel.setVibrationPattern(jArr);
        }

        @DoNotInline
        public static boolean v(NotificationChannel notificationChannel) {
            return notificationChannel.shouldShowLights();
        }

        @DoNotInline
        public static boolean w(NotificationChannel notificationChannel) {
            return notificationChannel.shouldVibrate();
        }
    }

    @RequiresApi
    public static class Api29Impl {
        @DoNotInline
        public static boolean a(NotificationChannel notificationChannel) {
            return notificationChannel.canBubble();
        }
    }

    @RequiresApi
    public static class Api30Impl {
        @DoNotInline
        public static String a(NotificationChannel notificationChannel) {
            return notificationChannel.getConversationId();
        }

        @DoNotInline
        public static String b(NotificationChannel notificationChannel) {
            return notificationChannel.getParentChannelId();
        }

        @DoNotInline
        public static boolean c(NotificationChannel notificationChannel) {
            return notificationChannel.isImportantConversation();
        }

        @DoNotInline
        public static void d(NotificationChannel notificationChannel, String str, String str2) {
            notificationChannel.setConversationId(str, str2);
        }
    }

    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        public final NotificationChannelCompat f658a;

        public Builder(String str, int i) {
            this.f658a = new NotificationChannelCompat(str, i);
        }

        public NotificationChannelCompat a() {
            return this.f658a;
        }

        public Builder b(String str) {
            this.f658a.d = str;
            return this;
        }

        public Builder c(boolean z) {
            this.f658a.i = z;
            return this;
        }

        public Builder d(CharSequence charSequence) {
            this.f658a.b = charSequence;
            return this;
        }

        public Builder e(Uri uri, AudioAttributes audioAttributes) {
            NotificationChannelCompat notificationChannelCompat = this.f658a;
            notificationChannelCompat.g = uri;
            notificationChannelCompat.h = audioAttributes;
            return this;
        }

        public Builder f(boolean z) {
            this.f658a.k = z;
            return this;
        }
    }

    public NotificationChannelCompat(String str, int i2) {
        this.f657a = (String) Preconditions.h(str);
        this.c = i2;
        this.h = Notification.AUDIO_ATTRIBUTES_DEFAULT;
    }

    public NotificationChannel a() {
        String str;
        String str2;
        int i2 = Build.VERSION.SDK_INT;
        NotificationChannel c2 = Api26Impl.c(this.f657a, this.b, this.c);
        Api26Impl.p(c2, this.d);
        Api26Impl.q(c2, this.e);
        Api26Impl.s(c2, this.f);
        Api26Impl.t(c2, this.g, this.h);
        Api26Impl.d(c2, this.i);
        Api26Impl.r(c2, this.j);
        Api26Impl.u(c2, this.l);
        Api26Impl.e(c2, this.k);
        if (!(i2 < 30 || (str = this.m) == null || (str2 = this.n) == null)) {
            Api30Impl.d(c2, str, str2);
        }
        return c2;
    }
}
