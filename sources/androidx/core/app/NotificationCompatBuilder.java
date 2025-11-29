package androidx.core.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Person;
import android.app.RemoteInput;
import android.content.Context;
import android.content.LocusId;
import android.graphics.drawable.Icon;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RemoteViews;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.app.NotificationCompat;
import androidx.core.content.LocusIdCompat;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestrictTo
class NotificationCompatBuilder implements NotificationBuilderWithBuilderAccessor {

    /* renamed from: a  reason: collision with root package name */
    public final Context f667a;
    public final Notification.Builder b;
    public final NotificationCompat.Builder c;
    public RemoteViews d;
    public RemoteViews e;
    public final List f = new ArrayList();
    public final Bundle g = new Bundle();
    public int h;
    public RemoteViews i;

    @RequiresApi
    public static class Api20Impl {
        @DoNotInline
        public static Notification.Builder a(Notification.Builder builder, Notification.Action action) {
            return builder.addAction(action);
        }

        @DoNotInline
        public static Notification.Action.Builder b(Notification.Action.Builder builder, Bundle bundle) {
            return builder.addExtras(bundle);
        }

        @DoNotInline
        public static Notification.Action.Builder c(Notification.Action.Builder builder, RemoteInput remoteInput) {
            return builder.addRemoteInput(remoteInput);
        }

        @DoNotInline
        public static Notification.Action d(Notification.Action.Builder builder) {
            return builder.build();
        }

        @DoNotInline
        public static Notification.Action.Builder e(int i, CharSequence charSequence, PendingIntent pendingIntent) {
            return new Notification.Action.Builder(i, charSequence, pendingIntent);
        }

        @DoNotInline
        public static String f(Notification notification) {
            return notification.getGroup();
        }

        @DoNotInline
        public static Notification.Builder g(Notification.Builder builder, String str) {
            return builder.setGroup(str);
        }

        @DoNotInline
        public static Notification.Builder h(Notification.Builder builder, boolean z) {
            return builder.setGroupSummary(z);
        }

        @DoNotInline
        public static Notification.Builder i(Notification.Builder builder, boolean z) {
            return builder.setLocalOnly(z);
        }

        @DoNotInline
        public static Notification.Builder j(Notification.Builder builder, String str) {
            return builder.setSortKey(str);
        }
    }

    @RequiresApi
    public static class Api21Impl {
        @DoNotInline
        public static Notification.Builder a(Notification.Builder builder, String str) {
            return builder.addPerson(str);
        }

        @DoNotInline
        public static Notification.Builder b(Notification.Builder builder, String str) {
            return builder.setCategory(str);
        }

        @DoNotInline
        public static Notification.Builder c(Notification.Builder builder, int i) {
            return builder.setColor(i);
        }

        @DoNotInline
        public static Notification.Builder d(Notification.Builder builder, Notification notification) {
            return builder.setPublicVersion(notification);
        }

        @DoNotInline
        public static Notification.Builder e(Notification.Builder builder, Uri uri, Object obj) {
            return builder.setSound(uri, (AudioAttributes) obj);
        }

        @DoNotInline
        public static Notification.Builder f(Notification.Builder builder, int i) {
            return builder.setVisibility(i);
        }
    }

    @RequiresApi
    public static class Api23Impl {
        @DoNotInline
        public static Notification.Action.Builder a(Icon icon, CharSequence charSequence, PendingIntent pendingIntent) {
            return new Notification.Action.Builder(icon, charSequence, pendingIntent);
        }

        @DoNotInline
        public static Notification.Builder b(Notification.Builder builder, Icon icon) {
            return builder.setLargeIcon(icon);
        }

        @DoNotInline
        public static Notification.Builder c(Notification.Builder builder, Object obj) {
            return builder.setSmallIcon((Icon) obj);
        }
    }

    @RequiresApi
    public static class Api24Impl {
        @DoNotInline
        public static Notification.Action.Builder a(Notification.Action.Builder builder, boolean z) {
            return builder.setAllowGeneratedReplies(z);
        }

        @DoNotInline
        public static Notification.Builder b(Notification.Builder builder, RemoteViews remoteViews) {
            return builder.setCustomBigContentView(remoteViews);
        }

        @DoNotInline
        public static Notification.Builder c(Notification.Builder builder, RemoteViews remoteViews) {
            return builder.setCustomContentView(remoteViews);
        }

        @DoNotInline
        public static Notification.Builder d(Notification.Builder builder, RemoteViews remoteViews) {
            return builder.setCustomHeadsUpContentView(remoteViews);
        }

        @DoNotInline
        public static Notification.Builder e(Notification.Builder builder, CharSequence[] charSequenceArr) {
            return builder.setRemoteInputHistory(charSequenceArr);
        }
    }

    @RequiresApi
    public static class Api26Impl {
        @DoNotInline
        public static Notification.Builder a(Context context, String str) {
            return new Notification.Builder(context, str);
        }

        @DoNotInline
        public static Notification.Builder b(Notification.Builder builder, int i) {
            return builder.setBadgeIconType(i);
        }

        @DoNotInline
        public static Notification.Builder c(Notification.Builder builder, boolean z) {
            return builder.setColorized(z);
        }

        @DoNotInline
        public static Notification.Builder d(Notification.Builder builder, int i) {
            return builder.setGroupAlertBehavior(i);
        }

        @DoNotInline
        public static Notification.Builder e(Notification.Builder builder, CharSequence charSequence) {
            return builder.setSettingsText(charSequence);
        }

        @DoNotInline
        public static Notification.Builder f(Notification.Builder builder, String str) {
            return builder.setShortcutId(str);
        }

        @DoNotInline
        public static Notification.Builder g(Notification.Builder builder, long j) {
            return builder.setTimeoutAfter(j);
        }
    }

    @RequiresApi
    public static class Api28Impl {
        @DoNotInline
        public static Notification.Builder a(Notification.Builder builder, Person person) {
            return builder.addPerson(person);
        }

        @DoNotInline
        public static Notification.Action.Builder b(Notification.Action.Builder builder, int i) {
            return builder.setSemanticAction(i);
        }
    }

    @RequiresApi
    public static class Api29Impl {
        @DoNotInline
        public static Notification.Builder a(Notification.Builder builder, boolean z) {
            return builder.setAllowSystemGeneratedContextualActions(z);
        }

        @DoNotInline
        public static Notification.Builder b(Notification.Builder builder, Notification.BubbleMetadata bubbleMetadata) {
            return builder.setBubbleMetadata(bubbleMetadata);
        }

        @DoNotInline
        public static Notification.Action.Builder c(Notification.Action.Builder builder, boolean z) {
            return builder.setContextual(z);
        }

        @DoNotInline
        public static Notification.Builder d(Notification.Builder builder, Object obj) {
            return builder.setLocusId((LocusId) obj);
        }
    }

    @RequiresApi
    public static class Api31Impl {
        @DoNotInline
        public static Notification.Action.Builder a(Notification.Action.Builder builder, boolean z) {
            return builder.setAuthenticationRequired(z);
        }

        @DoNotInline
        public static Notification.Builder b(Notification.Builder builder, int i) {
            return builder.setForegroundServiceBehavior(i);
        }
    }

    public NotificationCompatBuilder(NotificationCompat.Builder builder) {
        int i2;
        this.c = builder;
        Context context = builder.f663a;
        this.f667a = context;
        Notification.Builder a2 = Api26Impl.a(context, builder.L);
        this.b = a2;
        Notification notification = builder.U;
        a2.setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, builder.i).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(builder.e).setContentText(builder.f).setContentInfo(builder.k).setContentIntent(builder.g).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(builder.h, (notification.flags & 128) != 0).setNumber(builder.l).setProgress(builder.u, builder.v, builder.w);
        IconCompat iconCompat = builder.j;
        Api23Impl.b(a2, iconCompat == null ? null : iconCompat.x(context));
        a2.setSubText(builder.r).setUsesChronometer(builder.o).setPriority(builder.m);
        NotificationCompat.Style style = builder.q;
        if (style instanceof NotificationCompat.CallStyle) {
            for (NotificationCompat.Action b2 : ((NotificationCompat.CallStyle) style).n()) {
                b(b2);
            }
        } else {
            Iterator it = builder.b.iterator();
            while (it.hasNext()) {
                b((NotificationCompat.Action) it.next());
            }
        }
        Bundle bundle = builder.E;
        if (bundle != null) {
            this.g.putAll(bundle);
        }
        this.d = builder.I;
        this.e = builder.J;
        this.b.setShowWhen(builder.n);
        Api20Impl.i(this.b, builder.A);
        Api20Impl.g(this.b, builder.x);
        Api20Impl.j(this.b, builder.z);
        Api20Impl.h(this.b, builder.y);
        this.h = builder.Q;
        Api21Impl.b(this.b, builder.D);
        Api21Impl.c(this.b, builder.F);
        Api21Impl.f(this.b, builder.G);
        Api21Impl.d(this.b, builder.H);
        Api21Impl.e(this.b, notification.sound, notification.audioAttributes);
        ArrayList<String> arrayList = builder.X;
        if (arrayList != null && !arrayList.isEmpty()) {
            for (String a3 : arrayList) {
                Api21Impl.a(this.b, a3);
            }
        }
        this.i = builder.K;
        if (builder.d.size() > 0) {
            Bundle bundle2 = builder.d().getBundle("android.car.EXTENSIONS");
            bundle2 = bundle2 == null ? new Bundle() : bundle2;
            Bundle bundle3 = new Bundle(bundle2);
            Bundle bundle4 = new Bundle();
            for (int i3 = 0; i3 < builder.d.size(); i3++) {
                bundle4.putBundle(Integer.toString(i3), NotificationCompatJellybean.a((NotificationCompat.Action) builder.d.get(i3)));
            }
            bundle2.putBundle("invisible_actions", bundle4);
            bundle3.putBundle("invisible_actions", bundle4);
            builder.d().putBundle("android.car.EXTENSIONS", bundle2);
            this.g.putBundle("android.car.EXTENSIONS", bundle3);
        }
        Object obj = builder.W;
        if (obj != null) {
            Api23Impl.c(this.b, obj);
        }
        this.b.setExtras(builder.E);
        Api24Impl.e(this.b, builder.t);
        RemoteViews remoteViews = builder.I;
        if (remoteViews != null) {
            Api24Impl.c(this.b, remoteViews);
        }
        RemoteViews remoteViews2 = builder.J;
        if (remoteViews2 != null) {
            Api24Impl.b(this.b, remoteViews2);
        }
        RemoteViews remoteViews3 = builder.K;
        if (remoteViews3 != null) {
            Api24Impl.d(this.b, remoteViews3);
        }
        Api26Impl.b(this.b, builder.M);
        Api26Impl.e(this.b, builder.s);
        Api26Impl.f(this.b, builder.N);
        Api26Impl.g(this.b, builder.P);
        Api26Impl.d(this.b, builder.Q);
        if (builder.C) {
            Api26Impl.c(this.b, builder.B);
        }
        if (!TextUtils.isEmpty(builder.L)) {
            this.b.setSound((Uri) null).setDefaults(0).setLights(0, 0, 0).setVibrate((long[]) null);
        }
        Iterator it2 = builder.c.iterator();
        while (it2.hasNext()) {
            Api28Impl.a(this.b, ((Person) it2.next()).i());
        }
        int i4 = Build.VERSION.SDK_INT;
        Api29Impl.a(this.b, builder.S);
        Api29Impl.b(this.b, NotificationCompat.BubbleMetadata.i(builder.T));
        LocusIdCompat locusIdCompat = builder.O;
        if (locusIdCompat != null) {
            Api29Impl.d(this.b, locusIdCompat.b());
        }
        if (i4 >= 31 && (i2 = builder.R) != 0) {
            Api31Impl.b(this.b, i2);
        }
        if (builder.V) {
            if (this.c.y) {
                this.h = 2;
            } else {
                this.h = 1;
            }
            this.b.setVibrate((long[]) null);
            this.b.setSound((Uri) null);
            int i5 = notification.defaults & -4;
            notification.defaults = i5;
            this.b.setDefaults(i5);
            if (TextUtils.isEmpty(this.c.x)) {
                Api20Impl.g(this.b, "silent");
            }
            Api26Impl.d(this.b, this.h);
        }
    }

    public Notification.Builder a() {
        return this.b;
    }

    public final void b(NotificationCompat.Action action) {
        IconCompat d2 = action.d();
        Notification.Action.Builder a2 = Api23Impl.a(d2 != null ? d2.w() : null, action.h(), action.a());
        if (action.e() != null) {
            for (RemoteInput c2 : RemoteInput.b(action.e())) {
                Api20Impl.c(a2, c2);
            }
        }
        Bundle bundle = action.c() != null ? new Bundle(action.c()) : new Bundle();
        bundle.putBoolean("android.support.allowGeneratedReplies", action.b());
        int i2 = Build.VERSION.SDK_INT;
        Api24Impl.a(a2, action.b());
        bundle.putInt("android.support.action.semanticAction", action.f());
        Api28Impl.b(a2, action.f());
        Api29Impl.c(a2, action.j());
        if (i2 >= 31) {
            Api31Impl.a(a2, action.i());
        }
        bundle.putBoolean("android.support.action.showsUserInterface", action.g());
        Api20Impl.b(a2, bundle);
        Api20Impl.a(this.b, Api20Impl.d(a2));
    }

    public Notification c() {
        Bundle b2;
        RemoteViews k;
        RemoteViews i2;
        NotificationCompat.Style style = this.c.q;
        if (style != null) {
            style.b(this);
        }
        RemoteViews j = style != null ? style.j(this) : null;
        Notification d2 = d();
        if (j != null) {
            d2.contentView = j;
        } else {
            RemoteViews remoteViews = this.c.I;
            if (remoteViews != null) {
                d2.contentView = remoteViews;
            }
        }
        if (!(style == null || (i2 = style.i(this)) == null)) {
            d2.bigContentView = i2;
        }
        if (!(style == null || (k = this.c.q.k(this)) == null)) {
            d2.headsUpContentView = k;
        }
        if (!(style == null || (b2 = NotificationCompat.b(d2)) == null)) {
            style.a(b2);
        }
        return d2;
    }

    public Notification d() {
        return this.b.build();
    }

    public Context e() {
        return this.f667a;
    }
}
