package androidx.core.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Person;
import android.app.RemoteInput;
import android.content.Context;
import android.content.LocusId;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Icon;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.widget.RemoteViews;
import androidx.annotation.ColorInt;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.R;
import androidx.core.app.Person;
import androidx.core.content.ContextCompat;
import androidx.core.content.LocusIdCompat;
import androidx.core.graphics.drawable.IconCompat;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class NotificationCompat {

    public static class Action {

        /* renamed from: a  reason: collision with root package name */
        public final Bundle f659a;
        public IconCompat b;
        public final RemoteInput[] c;
        public final RemoteInput[] d;
        public boolean e;
        public boolean f;
        public final int g;
        public final boolean h;
        public int i;
        public CharSequence j;
        public PendingIntent k;
        public boolean l;

        public static final class Builder {

            /* renamed from: a  reason: collision with root package name */
            public final IconCompat f660a;
            public final CharSequence b;
            public final PendingIntent c;
            public boolean d;
            public final Bundle e;
            public ArrayList f;
            public int g;
            public boolean h;
            public boolean i;
            public boolean j;

            @RequiresApi
            public static class Api20Impl {
                @DoNotInline
                public static Bundle a(Notification.Action action) {
                    return action.getExtras();
                }

                @DoNotInline
                public static RemoteInput[] b(Notification.Action action) {
                    return action.getRemoteInputs();
                }
            }

            @RequiresApi
            public static class Api23Impl {
                @DoNotInline
                public static Icon a(Notification.Action action) {
                    return action.getIcon();
                }
            }

            @RequiresApi
            public static class Api24Impl {
                @DoNotInline
                public static boolean a(Notification.Action action) {
                    return action.getAllowGeneratedReplies();
                }
            }

            @RequiresApi
            public static class Api28Impl {
                @DoNotInline
                public static int a(Notification.Action action) {
                    return action.getSemanticAction();
                }
            }

            @RequiresApi
            public static class Api29Impl {
                @DoNotInline
                public static boolean a(Notification.Action action) {
                    return action.isContextual();
                }
            }

            @RequiresApi
            public static class Api31Impl {
                @DoNotInline
                public static boolean a(Notification.Action action) {
                    return action.isAuthenticationRequired();
                }
            }

            public Builder(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent) {
                this(iconCompat, charSequence, pendingIntent, new Bundle(), (RemoteInput[]) null, true, 0, true, false, false);
            }

            public Builder a(RemoteInput remoteInput) {
                if (this.f == null) {
                    this.f = new ArrayList();
                }
                if (remoteInput != null) {
                    this.f.add(remoteInput);
                }
                return this;
            }

            /* JADX WARNING: type inference failed for: r1v4, types: [java.lang.Object[]] */
            /* JADX WARNING: Multi-variable type inference failed */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public androidx.core.app.NotificationCompat.Action b() {
                /*
                    r17 = this;
                    r0 = r17
                    r17.c()
                    java.util.ArrayList r1 = new java.util.ArrayList
                    r1.<init>()
                    java.util.ArrayList r2 = new java.util.ArrayList
                    r2.<init>()
                    java.util.ArrayList r3 = r0.f
                    if (r3 == 0) goto L_0x0031
                    java.util.Iterator r3 = r3.iterator()
                L_0x0017:
                    boolean r4 = r3.hasNext()
                    if (r4 == 0) goto L_0x0031
                    java.lang.Object r4 = r3.next()
                    androidx.core.app.RemoteInput r4 = (androidx.core.app.RemoteInput) r4
                    boolean r5 = r4.k()
                    if (r5 == 0) goto L_0x002d
                    r1.add(r4)
                    goto L_0x0017
                L_0x002d:
                    r2.add(r4)
                    goto L_0x0017
                L_0x0031:
                    boolean r3 = r1.isEmpty()
                    r4 = 0
                    if (r3 == 0) goto L_0x003a
                    r11 = r4
                    goto L_0x0047
                L_0x003a:
                    int r3 = r1.size()
                    androidx.core.app.RemoteInput[] r3 = new androidx.core.app.RemoteInput[r3]
                    java.lang.Object[] r1 = r1.toArray(r3)
                    androidx.core.app.RemoteInput[] r1 = (androidx.core.app.RemoteInput[]) r1
                    r11 = r1
                L_0x0047:
                    boolean r1 = r2.isEmpty()
                    if (r1 == 0) goto L_0x004f
                L_0x004d:
                    r10 = r4
                    goto L_0x005d
                L_0x004f:
                    int r1 = r2.size()
                    androidx.core.app.RemoteInput[] r1 = new androidx.core.app.RemoteInput[r1]
                    java.lang.Object[] r1 = r2.toArray(r1)
                    r4 = r1
                    androidx.core.app.RemoteInput[] r4 = (androidx.core.app.RemoteInput[]) r4
                    goto L_0x004d
                L_0x005d:
                    androidx.core.app.NotificationCompat$Action r1 = new androidx.core.app.NotificationCompat$Action
                    androidx.core.graphics.drawable.IconCompat r6 = r0.f660a
                    java.lang.CharSequence r7 = r0.b
                    android.app.PendingIntent r8 = r0.c
                    android.os.Bundle r9 = r0.e
                    boolean r12 = r0.d
                    int r13 = r0.g
                    boolean r14 = r0.h
                    boolean r15 = r0.i
                    boolean r0 = r0.j
                    r5 = r1
                    r16 = r0
                    r5.<init>((androidx.core.graphics.drawable.IconCompat) r6, (java.lang.CharSequence) r7, (android.app.PendingIntent) r8, (android.os.Bundle) r9, (androidx.core.app.RemoteInput[]) r10, (androidx.core.app.RemoteInput[]) r11, (boolean) r12, (int) r13, (boolean) r14, (boolean) r15, (boolean) r16)
                    return r1
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.core.app.NotificationCompat.Action.Builder.b():androidx.core.app.NotificationCompat$Action");
            }

            public final void c() {
                if (this.i && this.c == null) {
                    throw new NullPointerException("Contextual Actions must contain a valid PendingIntent");
                }
            }

            public Builder d(boolean z) {
                this.d = z;
                return this;
            }

            public Builder e(boolean z) {
                this.i = z;
                return this;
            }

            public Builder f(boolean z) {
                this.h = z;
                return this;
            }

            public Builder(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle, RemoteInput[] remoteInputArr, boolean z, int i2, boolean z2, boolean z3, boolean z4) {
                ArrayList arrayList;
                this.d = true;
                this.h = true;
                this.f660a = iconCompat;
                this.b = Builder.e(charSequence);
                this.c = pendingIntent;
                this.e = bundle;
                if (remoteInputArr == null) {
                    arrayList = null;
                } else {
                    arrayList = new ArrayList(Arrays.asList(remoteInputArr));
                }
                this.f = arrayList;
                this.d = z;
                this.g = i2;
                this.h = z2;
                this.i = z3;
                this.j = z4;
            }
        }

        public interface Extender {
        }

        @Retention(RetentionPolicy.SOURCE)
        public @interface SemanticAction {
        }

        public static final class WearableExtender implements Extender {

            /* renamed from: a  reason: collision with root package name */
            public int f661a = 1;
            public CharSequence b;
            public CharSequence c;
            public CharSequence d;

            /* renamed from: a */
            public WearableExtender clone() {
                WearableExtender wearableExtender = new WearableExtender();
                wearableExtender.f661a = this.f661a;
                wearableExtender.b = this.b;
                wearableExtender.c = this.c;
                wearableExtender.d = this.d;
                return wearableExtender;
            }
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public Action(int i2, CharSequence charSequence, PendingIntent pendingIntent) {
            this(i2 != 0 ? IconCompat.m((Resources) null, "", i2) : null, charSequence, pendingIntent);
        }

        public PendingIntent a() {
            return this.k;
        }

        public boolean b() {
            return this.e;
        }

        public Bundle c() {
            return this.f659a;
        }

        public IconCompat d() {
            int i2;
            if (this.b == null && (i2 = this.i) != 0) {
                this.b = IconCompat.m((Resources) null, "", i2);
            }
            return this.b;
        }

        public RemoteInput[] e() {
            return this.c;
        }

        public int f() {
            return this.g;
        }

        public boolean g() {
            return this.f;
        }

        public CharSequence h() {
            return this.j;
        }

        public boolean i() {
            return this.l;
        }

        public boolean j() {
            return this.h;
        }

        public Action(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent) {
            this(iconCompat, charSequence, pendingIntent, new Bundle(), (RemoteInput[]) null, (RemoteInput[]) null, true, 0, true, false, false);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public Action(int i2, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle, RemoteInput[] remoteInputArr, RemoteInput[] remoteInputArr2, boolean z, int i3, boolean z2, boolean z3, boolean z4) {
            this(i2 != 0 ? IconCompat.m((Resources) null, "", i2) : null, charSequence, pendingIntent, bundle, remoteInputArr, remoteInputArr2, z, i3, z2, z3, z4);
        }

        public Action(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle, RemoteInput[] remoteInputArr, RemoteInput[] remoteInputArr2, boolean z, int i2, boolean z2, boolean z3, boolean z4) {
            this.f = true;
            this.b = iconCompat;
            if (iconCompat != null && iconCompat.q() == 2) {
                this.i = iconCompat.o();
            }
            this.j = Builder.e(charSequence);
            this.k = pendingIntent;
            this.f659a = bundle == null ? new Bundle() : bundle;
            this.c = remoteInputArr;
            this.d = remoteInputArr2;
            this.e = z;
            this.g = i2;
            this.f = z2;
            this.h = z3;
            this.l = z4;
        }
    }

    @RequiresApi
    public static class Api20Impl {
        @DoNotInline
        public static boolean a(RemoteInput remoteInput) {
            return remoteInput.getAllowFreeFormInput();
        }

        @DoNotInline
        public static CharSequence[] b(RemoteInput remoteInput) {
            return remoteInput.getChoices();
        }

        @DoNotInline
        public static Bundle c(Notification.Action action) {
            return action.getExtras();
        }

        @DoNotInline
        public static Bundle d(RemoteInput remoteInput) {
            return remoteInput.getExtras();
        }

        @DoNotInline
        public static String e(Notification notification) {
            return notification.getGroup();
        }

        @DoNotInline
        public static CharSequence f(RemoteInput remoteInput) {
            return remoteInput.getLabel();
        }

        @DoNotInline
        public static RemoteInput[] g(Notification.Action action) {
            return action.getRemoteInputs();
        }

        @DoNotInline
        public static String h(RemoteInput remoteInput) {
            return remoteInput.getResultKey();
        }

        @DoNotInline
        public static String i(Notification notification) {
            return notification.getSortKey();
        }
    }

    @RequiresApi
    public static class Api23Impl {
        @DoNotInline
        public static Icon a(Notification.Action action) {
            return action.getIcon();
        }
    }

    @RequiresApi
    public static class Api24Impl {
        @DoNotInline
        public static boolean a(Notification.Action action) {
            return action.getAllowGeneratedReplies();
        }
    }

    @RequiresApi
    public static class Api26Impl {
        @DoNotInline
        public static int a(Notification notification) {
            return notification.getBadgeIconType();
        }

        @DoNotInline
        public static String b(Notification notification) {
            return notification.getChannelId();
        }

        @DoNotInline
        public static int c(Notification notification) {
            return notification.getGroupAlertBehavior();
        }

        @DoNotInline
        public static CharSequence d(Notification notification) {
            return notification.getSettingsText();
        }

        @DoNotInline
        public static String e(Notification notification) {
            return notification.getShortcutId();
        }

        @DoNotInline
        public static long f(Notification notification) {
            return notification.getTimeoutAfter();
        }
    }

    @RequiresApi
    public static class Api28Impl {
        @DoNotInline
        public static int a(Notification.Action action) {
            return action.getSemanticAction();
        }
    }

    @RequiresApi
    public static class Api29Impl {
        @DoNotInline
        public static boolean a(Notification notification) {
            return notification.getAllowSystemGeneratedContextualActions();
        }

        @DoNotInline
        public static Notification.BubbleMetadata b(Notification notification) {
            return notification.getBubbleMetadata();
        }

        @DoNotInline
        public static int c(RemoteInput remoteInput) {
            return remoteInput.getEditChoicesBeforeSending();
        }

        @DoNotInline
        public static LocusId d(Notification notification) {
            return notification.getLocusId();
        }

        @DoNotInline
        public static boolean e(Notification.Action action) {
            return action.isContextual();
        }
    }

    @RequiresApi
    public static class Api31Impl {
        @DoNotInline
        public static boolean a(Notification.Action action) {
            return action.isAuthenticationRequired();
        }
    }

    @RestrictTo
    @Retention(RetentionPolicy.SOURCE)
    public @interface BadgeIconType {
    }

    public static class BigPictureStyle extends Style {
        public IconCompat e;
        public IconCompat f;
        public boolean g;
        public CharSequence h;
        public boolean i;

        @RequiresApi
        public static class Api23Impl {
            @RequiresApi
            public static void a(Notification.BigPictureStyle bigPictureStyle, Icon icon) {
                bigPictureStyle.bigLargeIcon(icon);
            }
        }

        @RequiresApi
        public static class Api31Impl {
            @RequiresApi
            public static void a(Notification.BigPictureStyle bigPictureStyle, Icon icon) {
                bigPictureStyle.bigPicture(icon);
            }

            @RequiresApi
            public static void b(Notification.BigPictureStyle bigPictureStyle, CharSequence charSequence) {
                bigPictureStyle.setContentDescription(charSequence);
            }

            @RequiresApi
            public static void c(Notification.BigPictureStyle bigPictureStyle, boolean z) {
                bigPictureStyle.showBigPictureWhenCollapsed(z);
            }
        }

        public static IconCompat n(Parcelable parcelable) {
            if (parcelable == null) {
                return null;
            }
            if (parcelable instanceof Icon) {
                return IconCompat.c((Icon) parcelable);
            }
            if (parcelable instanceof Bitmap) {
                return IconCompat.h((Bitmap) parcelable);
            }
            return null;
        }

        public static IconCompat q(Bundle bundle) {
            if (bundle == null) {
                return null;
            }
            Parcelable parcelable = bundle.getParcelable("android.picture");
            return parcelable != null ? n(parcelable) : n(bundle.getParcelable("android.pictureIcon"));
        }

        public void b(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            Notification.BigPictureStyle bigContentTitle = new Notification.BigPictureStyle(notificationBuilderWithBuilderAccessor.a()).setBigContentTitle(this.b);
            IconCompat iconCompat = this.e;
            Context context = null;
            if (iconCompat != null) {
                if (Build.VERSION.SDK_INT >= 31) {
                    Api31Impl.a(bigContentTitle, this.e.x(notificationBuilderWithBuilderAccessor instanceof NotificationCompatBuilder ? ((NotificationCompatBuilder) notificationBuilderWithBuilderAccessor).e() : null));
                } else if (iconCompat.q() == 1) {
                    bigContentTitle = bigContentTitle.bigPicture(this.e.n());
                }
            }
            if (this.g) {
                if (this.f == null) {
                    bigContentTitle.bigLargeIcon((Bitmap) null);
                } else {
                    if (notificationBuilderWithBuilderAccessor instanceof NotificationCompatBuilder) {
                        context = ((NotificationCompatBuilder) notificationBuilderWithBuilderAccessor).e();
                    }
                    Api23Impl.a(bigContentTitle, this.f.x(context));
                }
            }
            if (this.d) {
                bigContentTitle.setSummaryText(this.c);
            }
            if (Build.VERSION.SDK_INT >= 31) {
                Api31Impl.c(bigContentTitle, this.i);
                Api31Impl.b(bigContentTitle, this.h);
            }
        }

        public String h() {
            return "androidx.core.app.NotificationCompat$BigPictureStyle";
        }

        public void l(Bundle bundle) {
            super.l(bundle);
            if (bundle.containsKey("android.largeIcon.big")) {
                this.f = n(bundle.getParcelable("android.largeIcon.big"));
                this.g = true;
            }
            this.e = q(bundle);
            this.i = bundle.getBoolean("android.showBigPictureWhenCollapsed");
        }

        public BigPictureStyle o(Bitmap bitmap) {
            this.f = bitmap == null ? null : IconCompat.h(bitmap);
            this.g = true;
            return this;
        }

        public BigPictureStyle p(Bitmap bitmap) {
            this.e = bitmap == null ? null : IconCompat.h(bitmap);
            return this;
        }

        public BigPictureStyle r(CharSequence charSequence) {
            this.b = Builder.e(charSequence);
            return this;
        }

        public BigPictureStyle s(CharSequence charSequence) {
            this.c = Builder.e(charSequence);
            this.d = true;
            return this;
        }
    }

    public static class BigTextStyle extends Style {
        public CharSequence e;

        public void a(Bundle bundle) {
            super.a(bundle);
        }

        public void b(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            Notification.BigTextStyle bigText = new Notification.BigTextStyle(notificationBuilderWithBuilderAccessor.a()).setBigContentTitle(this.b).bigText(this.e);
            if (this.d) {
                bigText.setSummaryText(this.c);
            }
        }

        public String h() {
            return "androidx.core.app.NotificationCompat$BigTextStyle";
        }

        public void l(Bundle bundle) {
            super.l(bundle);
            this.e = bundle.getCharSequence("android.bigText");
        }

        public BigTextStyle n(CharSequence charSequence) {
            this.e = Builder.e(charSequence);
            return this;
        }

        public BigTextStyle o(CharSequence charSequence) {
            this.b = Builder.e(charSequence);
            return this;
        }

        public BigTextStyle p(CharSequence charSequence) {
            this.c = Builder.e(charSequence);
            this.d = true;
            return this;
        }
    }

    public static final class BubbleMetadata {

        /* renamed from: a  reason: collision with root package name */
        public PendingIntent f662a;
        public PendingIntent b;
        public IconCompat c;
        public int d;
        public int e;
        public int f;
        public String g;

        @RequiresApi
        public static class Api29Impl {
            @RequiresApi
            @Nullable
            public static Notification.BubbleMetadata a(@Nullable BubbleMetadata bubbleMetadata) {
                if (bubbleMetadata == null || bubbleMetadata.f() == null) {
                    return null;
                }
                Notification.BubbleMetadata.Builder suppressNotification = new Notification.BubbleMetadata.Builder().setIcon(bubbleMetadata.e().w()).setIntent(bubbleMetadata.f()).setDeleteIntent(bubbleMetadata.b()).setAutoExpandBubble(bubbleMetadata.a()).setSuppressNotification(bubbleMetadata.h());
                if (bubbleMetadata.c() != 0) {
                    suppressNotification.setDesiredHeight(bubbleMetadata.c());
                }
                if (bubbleMetadata.d() != 0) {
                    suppressNotification.setDesiredHeightResId(bubbleMetadata.d());
                }
                return suppressNotification.build();
            }
        }

        @RequiresApi
        public static class Api30Impl {
            @RequiresApi
            @Nullable
            public static Notification.BubbleMetadata a(@Nullable BubbleMetadata bubbleMetadata) {
                if (bubbleMetadata == null) {
                    return null;
                }
                Notification.BubbleMetadata.Builder builder = bubbleMetadata.g() != null ? new Notification.BubbleMetadata.Builder(bubbleMetadata.g()) : new Notification.BubbleMetadata.Builder(bubbleMetadata.f(), bubbleMetadata.e().w());
                builder.setDeleteIntent(bubbleMetadata.b()).setAutoExpandBubble(bubbleMetadata.a()).setSuppressNotification(bubbleMetadata.h());
                if (bubbleMetadata.c() != 0) {
                    builder.setDesiredHeight(bubbleMetadata.c());
                }
                if (bubbleMetadata.d() != 0) {
                    builder.setDesiredHeightResId(bubbleMetadata.d());
                }
                return builder.build();
            }
        }

        public static final class Builder {
        }

        public static Notification.BubbleMetadata i(BubbleMetadata bubbleMetadata) {
            if (bubbleMetadata == null) {
                return null;
            }
            int i = Build.VERSION.SDK_INT;
            if (i >= 30) {
                return Api30Impl.a(bubbleMetadata);
            }
            if (i == 29) {
                return Api29Impl.a(bubbleMetadata);
            }
            return null;
        }

        public boolean a() {
            return (this.f & 1) != 0;
        }

        public PendingIntent b() {
            return this.b;
        }

        public int c() {
            return this.d;
        }

        public int d() {
            return this.e;
        }

        public IconCompat e() {
            return this.c;
        }

        public PendingIntent f() {
            return this.f662a;
        }

        public String g() {
            return this.g;
        }

        public boolean h() {
            return (this.f & 2) != 0;
        }
    }

    public static class CallStyle extends Style {
        public int e;
        public Person f;
        public PendingIntent g;
        public PendingIntent h;
        public PendingIntent i;
        public boolean j;
        public Integer k;
        public Integer l;
        public IconCompat m;
        public CharSequence n;

        @RequiresApi
        public static class Api20Impl {
            @DoNotInline
            public static Notification.Action.Builder a(Notification.Action.Builder builder, Bundle bundle) {
                return builder.addExtras(bundle);
            }

            @DoNotInline
            public static Notification.Action.Builder b(Notification.Action.Builder builder, RemoteInput remoteInput) {
                return builder.addRemoteInput(remoteInput);
            }

            @DoNotInline
            public static Notification.Action c(Notification.Action.Builder builder) {
                return builder.build();
            }

            @DoNotInline
            public static Notification.Action.Builder d(int i, CharSequence charSequence, PendingIntent pendingIntent) {
                return new Notification.Action.Builder(i, charSequence, pendingIntent);
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
        }

        @RequiresApi
        public static class Api23Impl {
            @DoNotInline
            public static Parcelable a(Icon icon) {
                return icon;
            }

            @DoNotInline
            public static Notification.Action.Builder b(Icon icon, CharSequence charSequence, PendingIntent pendingIntent) {
                return new Notification.Action.Builder(icon, charSequence, pendingIntent);
            }

            @DoNotInline
            public static void c(Notification.Builder builder, Icon icon) {
                builder.setLargeIcon(icon);
            }
        }

        @RequiresApi
        public static class Api24Impl {
            @DoNotInline
            public static Notification.Action.Builder a(Notification.Action.Builder builder, boolean z) {
                return builder.setAllowGeneratedReplies(z);
            }
        }

        @RequiresApi
        public static class Api28Impl {
            @DoNotInline
            public static Notification.Builder a(Notification.Builder builder, Person person) {
                return builder.addPerson(person);
            }

            @DoNotInline
            public static Parcelable b(Person person) {
                return person;
            }
        }

        @RequiresApi
        public static class Api31Impl {
            @DoNotInline
            public static Notification.CallStyle a(@NonNull Person person, @NonNull PendingIntent pendingIntent, @NonNull PendingIntent pendingIntent2) {
                return Notification.CallStyle.forIncomingCall(person, pendingIntent, pendingIntent2);
            }

            @DoNotInline
            public static Notification.CallStyle b(@NonNull Person person, @NonNull PendingIntent pendingIntent) {
                return Notification.CallStyle.forOngoingCall(person, pendingIntent);
            }

            @DoNotInline
            public static Notification.CallStyle c(@NonNull Person person, @NonNull PendingIntent pendingIntent, @NonNull PendingIntent pendingIntent2) {
                return Notification.CallStyle.forScreeningCall(person, pendingIntent, pendingIntent2);
            }

            @DoNotInline
            public static Notification.CallStyle d(Notification.CallStyle callStyle, @ColorInt int i) {
                return callStyle.setAnswerButtonColorHint(i);
            }

            @DoNotInline
            public static Notification.Action.Builder e(Notification.Action.Builder builder, boolean z) {
                return builder.setAuthenticationRequired(z);
            }

            @DoNotInline
            public static Notification.CallStyle f(Notification.CallStyle callStyle, @ColorInt int i) {
                return callStyle.setDeclineButtonColorHint(i);
            }

            @DoNotInline
            public static Notification.CallStyle g(Notification.CallStyle callStyle, boolean z) {
                return callStyle.setIsVideo(z);
            }

            @DoNotInline
            public static Notification.CallStyle h(Notification.CallStyle callStyle, @Nullable Icon icon) {
                return callStyle.setVerificationIcon(icon);
            }

            @DoNotInline
            public static Notification.CallStyle i(Notification.CallStyle callStyle, @Nullable CharSequence charSequence) {
                return callStyle.setVerificationText(charSequence);
            }
        }

        @RestrictTo
        @Retention(RetentionPolicy.SOURCE)
        public @interface CallType {
        }

        public void a(Bundle bundle) {
            super.a(bundle);
            bundle.putInt("android.callType", this.e);
            bundle.putBoolean("android.callIsVideo", this.j);
            Person person = this.f;
            if (person != null) {
                bundle.putParcelable("android.callPerson", Api28Impl.b(person.i()));
            }
            IconCompat iconCompat = this.m;
            if (iconCompat != null) {
                bundle.putParcelable("android.verificationIcon", Api23Impl.a(iconCompat.x(this.f665a.f663a)));
            }
            bundle.putCharSequence("android.verificationText", this.n);
            bundle.putParcelable("android.answerIntent", this.g);
            bundle.putParcelable("android.declineIntent", this.h);
            bundle.putParcelable("android.hangUpIntent", this.i);
            Integer num = this.k;
            if (num != null) {
                bundle.putInt("android.answerColor", num.intValue());
            }
            Integer num2 = this.l;
            if (num2 != null) {
                bundle.putInt("android.declineColor", num2.intValue());
            }
        }

        public void b(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            Notification.CallStyle callStyle = null;
            if (Build.VERSION.SDK_INT >= 31) {
                int i2 = this.e;
                if (i2 == 1) {
                    callStyle = Api31Impl.a(this.f.i(), this.h, this.g);
                } else if (i2 == 2) {
                    callStyle = Api31Impl.b(this.f.i(), this.i);
                } else if (i2 == 3) {
                    callStyle = Api31Impl.c(this.f.i(), this.i, this.g);
                } else if (Log.isLoggable("NotifCompat", 3)) {
                    Log.d("NotifCompat", "Unrecognized call type in CallStyle: " + String.valueOf(this.e));
                }
                if (callStyle != null) {
                    callStyle.setBuilder(notificationBuilderWithBuilderAccessor.a());
                    Integer num = this.k;
                    if (num != null) {
                        Api31Impl.d(callStyle, num.intValue());
                    }
                    Integer num2 = this.l;
                    if (num2 != null) {
                        Api31Impl.f(callStyle, num2.intValue());
                    }
                    Api31Impl.i(callStyle, this.n);
                    IconCompat iconCompat = this.m;
                    if (iconCompat != null) {
                        Api31Impl.h(callStyle, iconCompat.x(this.f665a.f663a));
                    }
                    Api31Impl.g(callStyle, this.j);
                    return;
                }
                return;
            }
            Notification.Builder a2 = notificationBuilderWithBuilderAccessor.a();
            Person person = this.f;
            a2.setContentTitle(person != null ? person.e() : null);
            Bundle bundle = this.f665a.E;
            if (bundle != null && bundle.containsKey("android.text")) {
                callStyle = this.f665a.E.getCharSequence("android.text");
            }
            if (callStyle == null) {
                callStyle = o();
            }
            a2.setContentText(callStyle);
            Person person2 = this.f;
            if (person2 != null) {
                if (person2.c() != null) {
                    Api23Impl.c(a2, this.f.c().x(this.f665a.f663a));
                }
                Api28Impl.a(a2, this.f.i());
            }
            Api21Impl.b(a2, "call");
        }

        public String h() {
            return "androidx.core.app.NotificationCompat$CallStyle";
        }

        public void l(Bundle bundle) {
            super.l(bundle);
            this.e = bundle.getInt("android.callType");
            this.j = bundle.getBoolean("android.callIsVideo");
            if (bundle.containsKey("android.callPerson")) {
                this.f = Person.a((Person) bundle.getParcelable("android.callPerson"));
            } else if (bundle.containsKey("android.callPersonCompat")) {
                this.f = Person.b(bundle.getBundle("android.callPersonCompat"));
            }
            if (bundle.containsKey("android.verificationIcon")) {
                this.m = IconCompat.c((Icon) bundle.getParcelable("android.verificationIcon"));
            } else if (bundle.containsKey("android.verificationIconCompat")) {
                this.m = IconCompat.b(bundle.getBundle("android.verificationIconCompat"));
            }
            this.n = bundle.getCharSequence("android.verificationText");
            this.g = (PendingIntent) bundle.getParcelable("android.answerIntent");
            this.h = (PendingIntent) bundle.getParcelable("android.declineIntent");
            this.i = (PendingIntent) bundle.getParcelable("android.hangUpIntent");
            Integer num = null;
            this.k = bundle.containsKey("android.answerColor") ? Integer.valueOf(bundle.getInt("android.answerColor")) : null;
            if (bundle.containsKey("android.declineColor")) {
                num = Integer.valueOf(bundle.getInt("android.declineColor"));
            }
            this.l = num;
        }

        public ArrayList n() {
            Action s = s();
            Action r = r();
            ArrayList arrayList = new ArrayList(3);
            arrayList.add(s);
            ArrayList<Action> arrayList2 = this.f665a.b;
            int i2 = 2;
            if (arrayList2 != null) {
                for (Action action : arrayList2) {
                    if (action.j()) {
                        arrayList.add(action);
                    } else if (!p(action) && i2 > 1) {
                        arrayList.add(action);
                        i2--;
                    }
                    if (r != null && i2 == 1) {
                        arrayList.add(r);
                        i2--;
                    }
                }
            }
            if (r != null && i2 >= 1) {
                arrayList.add(r);
            }
            return arrayList;
        }

        public final String o() {
            int i2 = this.e;
            if (i2 == 1) {
                return this.f665a.f663a.getResources().getString(R.string.call_notification_incoming_text);
            }
            if (i2 == 2) {
                return this.f665a.f663a.getResources().getString(R.string.call_notification_ongoing_text);
            }
            if (i2 != 3) {
                return null;
            }
            return this.f665a.f663a.getResources().getString(R.string.call_notification_screening_text);
        }

        public final boolean p(Action action) {
            return action != null && action.c().getBoolean("key_action_priority");
        }

        public final Action q(int i2, int i3, Integer num, int i4, PendingIntent pendingIntent) {
            if (num == null) {
                num = Integer.valueOf(ContextCompat.getColor(this.f665a.f663a, i4));
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append(this.f665a.f663a.getResources().getString(i3));
            spannableStringBuilder.setSpan(new ForegroundColorSpan(num.intValue()), 0, spannableStringBuilder.length(), 18);
            Action b = new Action.Builder(IconCompat.l(this.f665a.f663a, i2), spannableStringBuilder, pendingIntent).b();
            b.c().putBoolean("key_action_priority", true);
            return b;
        }

        public final Action r() {
            int i2 = R.drawable.ic_call_answer_video;
            int i3 = R.drawable.ic_call_answer;
            PendingIntent pendingIntent = this.g;
            if (pendingIntent == null) {
                return null;
            }
            boolean z = this.j;
            return q(z ? i2 : i3, z ? R.string.call_notification_answer_video_action : R.string.call_notification_answer_action, this.k, R.color.call_notification_answer_color, pendingIntent);
        }

        public final Action s() {
            int i2 = R.drawable.ic_call_decline;
            PendingIntent pendingIntent = this.h;
            if (pendingIntent == null) {
                return q(i2, R.string.call_notification_hang_up_action, this.l, R.color.call_notification_decline_color, this.i);
            }
            return q(i2, R.string.call_notification_decline_action, this.l, R.color.call_notification_decline_color, pendingIntent);
        }
    }

    public static final class CarExtender implements Extender {

        @RequiresApi
        public static class Api20Impl {
            @DoNotInline
            public static RemoteInput.Builder a(RemoteInput.Builder builder, Bundle bundle) {
                return builder.addExtras(bundle);
            }

            @DoNotInline
            public static RemoteInput b(RemoteInput.Builder builder) {
                return builder.build();
            }

            @DoNotInline
            public static Parcelable c(RemoteInput remoteInput) {
                return remoteInput;
            }

            @DoNotInline
            public static RemoteInput.Builder d(String str) {
                return new RemoteInput.Builder(str);
            }

            @DoNotInline
            public static boolean e(RemoteInput remoteInput) {
                return remoteInput.getAllowFreeFormInput();
            }

            @DoNotInline
            public static CharSequence[] f(RemoteInput remoteInput) {
                return remoteInput.getChoices();
            }

            @DoNotInline
            public static Bundle g(RemoteInput remoteInput) {
                return remoteInput.getExtras();
            }

            @DoNotInline
            public static CharSequence h(RemoteInput remoteInput) {
                return remoteInput.getLabel();
            }

            @DoNotInline
            public static String i(RemoteInput remoteInput) {
                return remoteInput.getResultKey();
            }

            @DoNotInline
            public static RemoteInput.Builder j(RemoteInput.Builder builder, boolean z) {
                return builder.setAllowFreeFormInput(z);
            }

            @DoNotInline
            public static RemoteInput.Builder k(RemoteInput.Builder builder, CharSequence[] charSequenceArr) {
                return builder.setChoices(charSequenceArr);
            }

            @DoNotInline
            public static RemoteInput.Builder l(RemoteInput.Builder builder, CharSequence charSequence) {
                return builder.setLabel(charSequence);
            }
        }

        @RequiresApi
        public static class Api29Impl {
            @DoNotInline
            public static int a(RemoteInput remoteInput) {
                return remoteInput.getEditChoicesBeforeSending();
            }
        }

        @Deprecated
        public static class UnreadConversation {

            public static class Builder {
            }
        }
    }

    public static class DecoratedCustomViewStyle extends Style {

        @RequiresApi
        public static class Api24Impl {
            @DoNotInline
            public static Notification.Style a() {
                return new Notification.DecoratedCustomViewStyle();
            }
        }

        public void b(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            notificationBuilderWithBuilderAccessor.a().setStyle(Api24Impl.a());
        }

        public String h() {
            return "androidx.core.app.NotificationCompat$DecoratedCustomViewStyle";
        }

        public RemoteViews i(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            return null;
        }

        public RemoteViews j(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            return null;
        }

        public RemoteViews k(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            return null;
        }
    }

    public interface Extender {
    }

    @RestrictTo
    @Retention(RetentionPolicy.SOURCE)
    public @interface GroupAlertBehavior {
    }

    public static class InboxStyle extends Style {
        public ArrayList e = new ArrayList();

        public void b(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            Notification.InboxStyle bigContentTitle = new Notification.InboxStyle(notificationBuilderWithBuilderAccessor.a()).setBigContentTitle(this.b);
            if (this.d) {
                bigContentTitle.setSummaryText(this.c);
            }
            Iterator it = this.e.iterator();
            while (it.hasNext()) {
                bigContentTitle.addLine((CharSequence) it.next());
            }
        }

        public String h() {
            return "androidx.core.app.NotificationCompat$InboxStyle";
        }

        public void l(Bundle bundle) {
            super.l(bundle);
            this.e.clear();
            if (bundle.containsKey("android.textLines")) {
                Collections.addAll(this.e, bundle.getCharSequenceArray("android.textLines"));
            }
        }

        public InboxStyle n(CharSequence charSequence) {
            if (charSequence != null) {
                this.e.add(Builder.e(charSequence));
            }
            return this;
        }

        public InboxStyle o(CharSequence charSequence) {
            this.b = Builder.e(charSequence);
            return this;
        }

        public InboxStyle p(CharSequence charSequence) {
            this.c = Builder.e(charSequence);
            this.d = true;
            return this;
        }
    }

    @RestrictTo
    @Retention(RetentionPolicy.SOURCE)
    public @interface NotificationVisibility {
    }

    @RestrictTo
    @Retention(RetentionPolicy.SOURCE)
    public @interface ServiceNotificationBehavior {
    }

    @RestrictTo
    @Retention(RetentionPolicy.SOURCE)
    public @interface StreamType {
    }

    public static abstract class Style {

        /* renamed from: a  reason: collision with root package name */
        public Builder f665a;
        public CharSequence b;
        public CharSequence c;
        public boolean d = false;

        @RequiresApi
        public static class Api24Impl {
            @DoNotInline
            public static void a(RemoteViews remoteViews, int i, boolean z) {
                remoteViews.setChronometerCountDown(i, z);
            }
        }

        public static Style c(String str) {
            if (str == null) {
                return null;
            }
            char c2 = 65535;
            switch (str.hashCode()) {
                case -716705180:
                    if (str.equals("androidx.core.app.NotificationCompat$DecoratedCustomViewStyle")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case -171946061:
                    if (str.equals("androidx.core.app.NotificationCompat$BigPictureStyle")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 714386739:
                    if (str.equals("androidx.core.app.NotificationCompat$CallStyle")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 912942987:
                    if (str.equals("androidx.core.app.NotificationCompat$InboxStyle")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 919595044:
                    if (str.equals("androidx.core.app.NotificationCompat$BigTextStyle")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case 2090799565:
                    if (str.equals("androidx.core.app.NotificationCompat$MessagingStyle")) {
                        c2 = 5;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    return new DecoratedCustomViewStyle();
                case 1:
                    return new BigPictureStyle();
                case 2:
                    return new CallStyle();
                case 3:
                    return new InboxStyle();
                case 4:
                    return new BigTextStyle();
                case 5:
                    return new MessagingStyle();
                default:
                    return null;
            }
        }

        public static Style d(String str) {
            if (str == null) {
                return null;
            }
            if (str.equals(Notification.BigPictureStyle.class.getName())) {
                return new BigPictureStyle();
            }
            if (str.equals(Notification.BigTextStyle.class.getName())) {
                return new BigTextStyle();
            }
            if (str.equals(Notification.InboxStyle.class.getName())) {
                return new InboxStyle();
            }
            if (str.equals(Notification.MessagingStyle.class.getName())) {
                return new MessagingStyle();
            }
            if (str.equals(Notification.DecoratedCustomViewStyle.class.getName())) {
                return new DecoratedCustomViewStyle();
            }
            return null;
        }

        public static Style e(Bundle bundle) {
            Style c2 = c(bundle.getString("androidx.core.app.extra.COMPAT_TEMPLATE"));
            return c2 != null ? c2 : (bundle.containsKey("android.selfDisplayName") || bundle.containsKey("android.messagingStyleUser")) ? new MessagingStyle() : (bundle.containsKey("android.picture") || bundle.containsKey("android.pictureIcon")) ? new BigPictureStyle() : bundle.containsKey("android.bigText") ? new BigTextStyle() : bundle.containsKey("android.textLines") ? new InboxStyle() : bundle.containsKey("android.callType") ? new CallStyle() : d(bundle.getString("android.template"));
        }

        public static Style f(Bundle bundle) {
            Style e = e(bundle);
            if (e == null) {
                return null;
            }
            try {
                e.l(bundle);
                return e;
            } catch (ClassCastException unused) {
                return null;
            }
        }

        public static Style g(Notification notification) {
            Bundle b2 = NotificationCompat.b(notification);
            if (b2 == null) {
                return null;
            }
            return f(b2);
        }

        public void a(Bundle bundle) {
            if (this.d) {
                bundle.putCharSequence("android.summaryText", this.c);
            }
            CharSequence charSequence = this.b;
            if (charSequence != null) {
                bundle.putCharSequence("android.title.big", charSequence);
            }
            String h = h();
            if (h != null) {
                bundle.putString("androidx.core.app.extra.COMPAT_TEMPLATE", h);
            }
        }

        public void b(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
        }

        public String h() {
            return null;
        }

        public RemoteViews i(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            return null;
        }

        public RemoteViews j(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            return null;
        }

        public RemoteViews k(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            return null;
        }

        public void l(Bundle bundle) {
            if (bundle.containsKey("android.summaryText")) {
                this.c = bundle.getCharSequence("android.summaryText");
                this.d = true;
            }
            this.b = bundle.getCharSequence("android.title.big");
        }

        public void m(Builder builder) {
            if (this.f665a != builder) {
                this.f665a = builder;
                if (builder != null) {
                    builder.J(this);
                }
            }
        }
    }

    public static final class TvExtender implements Extender {
    }

    public static final class WearableExtender implements Extender {

        /* renamed from: a  reason: collision with root package name */
        public ArrayList f666a = new ArrayList();
        public int b = 1;
        public PendingIntent c;
        public ArrayList d = new ArrayList();
        public Bitmap e;
        public int f;
        public int g = 8388613;
        public int h = -1;
        public int i = 0;
        public int j;
        public int k = 80;
        public int l;
        public String m;
        public String n;

        @RequiresApi
        public static class Api20Impl {
            @DoNotInline
            public static Notification.Action.Builder a(Notification.Action.Builder builder, Bundle bundle) {
                return builder.addExtras(bundle);
            }

            @DoNotInline
            public static Notification.Action.Builder b(Notification.Action.Builder builder, RemoteInput remoteInput) {
                return builder.addRemoteInput(remoteInput);
            }

            @DoNotInline
            public static Notification.Action c(Notification.Action.Builder builder) {
                return builder.build();
            }

            @DoNotInline
            public static Notification.Action.Builder d(int i, CharSequence charSequence, PendingIntent pendingIntent) {
                return new Notification.Action.Builder(i, charSequence, pendingIntent);
            }

            @DoNotInline
            public static Action e(ArrayList<Parcelable> arrayList, int i) {
                return NotificationCompat.a((Notification.Action) arrayList.get(i));
            }
        }

        @RequiresApi
        public static class Api23Impl {
            @DoNotInline
            public static Notification.Action.Builder a(Icon icon, CharSequence charSequence, PendingIntent pendingIntent) {
                return new Notification.Action.Builder(icon, charSequence, pendingIntent);
            }
        }

        @RequiresApi
        public static class Api24Impl {
            @DoNotInline
            public static Notification.Action.Builder a(Notification.Action.Builder builder, boolean z) {
                return builder.setAllowGeneratedReplies(z);
            }
        }

        @RequiresApi
        public static class Api31Impl {
            @DoNotInline
            public static Notification.Action.Builder a(Notification.Action.Builder builder, boolean z) {
                return builder.setAuthenticationRequired(z);
            }
        }

        /* renamed from: a */
        public WearableExtender clone() {
            WearableExtender wearableExtender = new WearableExtender();
            wearableExtender.f666a = new ArrayList(this.f666a);
            wearableExtender.b = this.b;
            wearableExtender.c = this.c;
            wearableExtender.d = new ArrayList(this.d);
            wearableExtender.e = this.e;
            wearableExtender.f = this.f;
            wearableExtender.g = this.g;
            wearableExtender.h = this.h;
            wearableExtender.i = this.i;
            wearableExtender.j = this.j;
            wearableExtender.k = this.k;
            wearableExtender.l = this.l;
            wearableExtender.m = this.m;
            wearableExtender.n = this.n;
            return wearableExtender;
        }
    }

    public static Action a(Notification.Action action) {
        RemoteInput[] remoteInputArr;
        int i;
        Notification.Action action2 = action;
        RemoteInput[] g = Api20Impl.g(action);
        IconCompat iconCompat = null;
        boolean z = false;
        if (g == null) {
            remoteInputArr = null;
        } else {
            RemoteInput[] remoteInputArr2 = new RemoteInput[g.length];
            for (int i2 = 0; i2 < g.length; i2++) {
                RemoteInput remoteInput = g[i2];
                remoteInputArr2[i2] = new RemoteInput(Api20Impl.h(remoteInput), Api20Impl.f(remoteInput), Api20Impl.b(remoteInput), Api20Impl.a(remoteInput), Api29Impl.c(remoteInput), Api20Impl.d(remoteInput), (Set) null);
            }
            remoteInputArr = remoteInputArr2;
        }
        int i3 = Build.VERSION.SDK_INT;
        boolean z2 = Api20Impl.c(action).getBoolean("android.support.allowGeneratedReplies") || Api24Impl.a(action);
        boolean z3 = Api20Impl.c(action).getBoolean("android.support.action.showsUserInterface", true);
        int a2 = Api28Impl.a(action);
        boolean e = Api29Impl.e(action);
        if (i3 >= 31) {
            z = Api31Impl.a(action);
        }
        boolean z4 = z;
        if (Api23Impl.a(action) == null && (i = action2.icon) != 0) {
            return new Action(i, action2.title, action2.actionIntent, Api20Impl.c(action), remoteInputArr, (RemoteInput[]) null, z2, a2, z3, e, z4);
        }
        if (Api23Impl.a(action) != null) {
            iconCompat = IconCompat.d(Api23Impl.a(action));
        }
        return new Action(iconCompat, action2.title, action2.actionIntent, Api20Impl.c(action), remoteInputArr, (RemoteInput[]) null, z2, a2, z3, e, z4);
    }

    public static Bundle b(Notification notification) {
        return notification.extras;
    }

    public static Bitmap c(Context context, Bitmap bitmap) {
        return bitmap;
    }

    public static class MessagingStyle extends Style {
        public final List e = new ArrayList();
        public final List f = new ArrayList();
        public Person g;
        public CharSequence h;
        public Boolean i;

        @RequiresApi
        public static class Api24Impl {
            @DoNotInline
            public static Notification.MessagingStyle a(Notification.MessagingStyle messagingStyle, Notification.MessagingStyle.Message message) {
                return messagingStyle.addMessage(message);
            }

            @DoNotInline
            public static Notification.MessagingStyle b(CharSequence charSequence) {
                return new Notification.MessagingStyle(charSequence);
            }

            @DoNotInline
            public static Notification.MessagingStyle c(Notification.MessagingStyle messagingStyle, CharSequence charSequence) {
                return messagingStyle.setConversationTitle(charSequence);
            }
        }

        @RequiresApi
        public static class Api26Impl {
            @DoNotInline
            public static Notification.MessagingStyle a(Notification.MessagingStyle messagingStyle, Notification.MessagingStyle.Message message) {
                return messagingStyle.addHistoricMessage(message);
            }
        }

        @RequiresApi
        public static class Api28Impl {
            @DoNotInline
            public static Notification.MessagingStyle a(Person person) {
                return new Notification.MessagingStyle(person);
            }

            @DoNotInline
            public static Notification.MessagingStyle b(Notification.MessagingStyle messagingStyle, boolean z) {
                return messagingStyle.setGroupConversation(z);
            }
        }

        public static final class Message {

            /* renamed from: a  reason: collision with root package name */
            public final CharSequence f664a;
            public final long b;
            public final Person c;
            public Bundle d = new Bundle();
            public String e;
            public Uri f;

            @RequiresApi
            public static class Api24Impl {
                @DoNotInline
                public static Notification.MessagingStyle.Message a(CharSequence charSequence, long j, CharSequence charSequence2) {
                    return new Notification.MessagingStyle.Message(charSequence, j, charSequence2);
                }

                @DoNotInline
                public static Notification.MessagingStyle.Message b(Notification.MessagingStyle.Message message, String str, Uri uri) {
                    return message.setData(str, uri);
                }
            }

            @RequiresApi
            public static class Api28Impl {
                @DoNotInline
                public static Parcelable a(Person person) {
                    return person;
                }

                @DoNotInline
                public static Notification.MessagingStyle.Message b(CharSequence charSequence, long j, Person person) {
                    return new Notification.MessagingStyle.Message(charSequence, j, person);
                }
            }

            public Message(CharSequence charSequence, long j, Person person) {
                this.f664a = charSequence;
                this.b = j;
                this.c = person;
            }

            public static Bundle[] a(List list) {
                Bundle[] bundleArr = new Bundle[list.size()];
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    bundleArr[i] = ((Message) list.get(i)).l();
                }
                return bundleArr;
            }

            public static Message e(Bundle bundle) {
                try {
                    if (bundle.containsKey("text")) {
                        if (bundle.containsKey(RtspHeaders.Values.TIME)) {
                            Message message = new Message(bundle.getCharSequence("text"), bundle.getLong(RtspHeaders.Values.TIME), bundle.containsKey("person") ? Person.b(bundle.getBundle("person")) : bundle.containsKey("sender_person") ? Person.a((Person) bundle.getParcelable("sender_person")) : bundle.containsKey("sender") ? new Person.Builder().f(bundle.getCharSequence("sender")).a() : null);
                            if (bundle.containsKey("type") && bundle.containsKey("uri")) {
                                message.j(bundle.getString("type"), (Uri) bundle.getParcelable("uri"));
                            }
                            if (bundle.containsKey("extras")) {
                                message.d().putAll(bundle.getBundle("extras"));
                            }
                            return message;
                        }
                    }
                } catch (ClassCastException unused) {
                }
                return null;
            }

            public static List f(Parcelable[] parcelableArr) {
                Message e2;
                ArrayList arrayList = new ArrayList(parcelableArr.length);
                for (Bundle bundle : parcelableArr) {
                    if ((bundle instanceof Bundle) && (e2 = e(bundle)) != null) {
                        arrayList.add(e2);
                    }
                }
                return arrayList;
            }

            public String b() {
                return this.e;
            }

            public Uri c() {
                return this.f;
            }

            public Bundle d() {
                return this.d;
            }

            public Person g() {
                return this.c;
            }

            public CharSequence h() {
                return this.f664a;
            }

            public long i() {
                return this.b;
            }

            public Message j(String str, Uri uri) {
                this.e = str;
                this.f = uri;
                return this;
            }

            public Notification.MessagingStyle.Message k() {
                Person g = g();
                Notification.MessagingStyle.Message b2 = Api28Impl.b(h(), i(), g == null ? null : g.i());
                if (b() != null) {
                    Api24Impl.b(b2, b(), c());
                }
                return b2;
            }

            public final Bundle l() {
                Bundle bundle = new Bundle();
                CharSequence charSequence = this.f664a;
                if (charSequence != null) {
                    bundle.putCharSequence("text", charSequence);
                }
                bundle.putLong(RtspHeaders.Values.TIME, this.b);
                Person person = this.c;
                if (person != null) {
                    bundle.putCharSequence("sender", person.e());
                    bundle.putParcelable("sender_person", Api28Impl.a(this.c.i()));
                }
                String str = this.e;
                if (str != null) {
                    bundle.putString("type", str);
                }
                Uri uri = this.f;
                if (uri != null) {
                    bundle.putParcelable("uri", uri);
                }
                Bundle bundle2 = this.d;
                if (bundle2 != null) {
                    bundle.putBundle("extras", bundle2);
                }
                return bundle;
            }
        }

        public MessagingStyle() {
        }

        public static MessagingStyle o(Notification notification) {
            Style g2 = Style.g(notification);
            if (g2 instanceof MessagingStyle) {
                return (MessagingStyle) g2;
            }
            return null;
        }

        public void a(Bundle bundle) {
            super.a(bundle);
            bundle.putCharSequence("android.selfDisplayName", this.g.e());
            bundle.putBundle("android.messagingStyleUser", this.g.j());
            bundle.putCharSequence("android.hiddenConversationTitle", this.h);
            if (this.h != null && this.i.booleanValue()) {
                bundle.putCharSequence("android.conversationTitle", this.h);
            }
            if (!this.e.isEmpty()) {
                bundle.putParcelableArray("android.messages", Message.a(this.e));
            }
            if (!this.f.isEmpty()) {
                bundle.putParcelableArray("android.messages.historic", Message.a(this.f));
            }
            Boolean bool = this.i;
            if (bool != null) {
                bundle.putBoolean("android.isGroupConversation", bool.booleanValue());
            }
        }

        public void b(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            u(s());
            Notification.MessagingStyle a2 = Api28Impl.a(this.g.i());
            for (Message k : this.e) {
                Api24Impl.a(a2, k.k());
            }
            for (Message k2 : this.f) {
                Api26Impl.a(a2, k2.k());
            }
            this.i.booleanValue();
            Api24Impl.c(a2, this.h);
            Api28Impl.b(a2, this.i.booleanValue());
            a2.setBuilder(notificationBuilderWithBuilderAccessor.a());
        }

        public String h() {
            return "androidx.core.app.NotificationCompat$MessagingStyle";
        }

        public void l(Bundle bundle) {
            super.l(bundle);
            this.e.clear();
            if (bundle.containsKey("android.messagingStyleUser")) {
                this.g = Person.b(bundle.getBundle("android.messagingStyleUser"));
            } else {
                this.g = new Person.Builder().f(bundle.getString("android.selfDisplayName")).a();
            }
            CharSequence charSequence = bundle.getCharSequence("android.conversationTitle");
            this.h = charSequence;
            if (charSequence == null) {
                this.h = bundle.getCharSequence("android.hiddenConversationTitle");
            }
            Parcelable[] parcelableArray = bundle.getParcelableArray("android.messages");
            if (parcelableArray != null) {
                this.e.addAll(Message.f(parcelableArray));
            }
            Parcelable[] parcelableArray2 = bundle.getParcelableArray("android.messages.historic");
            if (parcelableArray2 != null) {
                this.f.addAll(Message.f(parcelableArray2));
            }
            if (bundle.containsKey("android.isGroupConversation")) {
                this.i = Boolean.valueOf(bundle.getBoolean("android.isGroupConversation"));
            }
        }

        public MessagingStyle n(Message message) {
            if (message != null) {
                this.e.add(message);
                if (this.e.size() > 25) {
                    this.e.remove(0);
                }
            }
            return this;
        }

        public CharSequence p() {
            return this.h;
        }

        public List q() {
            return this.e;
        }

        public Person r() {
            return this.g;
        }

        public boolean s() {
            Builder builder = this.f665a;
            if (builder != null && builder.f663a.getApplicationInfo().targetSdkVersion < 28 && this.i == null) {
                return this.h != null;
            }
            Boolean bool = this.i;
            if (bool != null) {
                return bool.booleanValue();
            }
            return false;
        }

        public MessagingStyle t(CharSequence charSequence) {
            this.h = charSequence;
            return this;
        }

        public MessagingStyle u(boolean z) {
            this.i = Boolean.valueOf(z);
            return this;
        }

        public MessagingStyle(Person person) {
            if (!TextUtils.isEmpty(person.e())) {
                this.g = person;
                return;
            }
            throw new IllegalArgumentException("User's name must not be empty.");
        }
    }

    public static class Builder {
        public boolean A;
        public boolean B;
        public boolean C;
        public String D;
        public Bundle E;
        public int F;
        public int G;
        public Notification H;
        public RemoteViews I;
        public RemoteViews J;
        public RemoteViews K;
        public String L;
        public int M;
        public String N;
        public LocusIdCompat O;
        public long P;
        public int Q;
        public int R;
        public boolean S;
        public BubbleMetadata T;
        public Notification U;
        public boolean V;
        public Object W;
        public ArrayList X;

        /* renamed from: a  reason: collision with root package name */
        public Context f663a;
        public ArrayList b;
        public ArrayList c;
        public ArrayList d;
        public CharSequence e;
        public CharSequence f;
        public PendingIntent g;
        public PendingIntent h;
        public RemoteViews i;
        public IconCompat j;
        public CharSequence k;
        public int l;
        public int m;
        public boolean n;
        public boolean o;
        public boolean p;
        public Style q;
        public CharSequence r;
        public CharSequence s;
        public CharSequence[] t;
        public int u;
        public int v;
        public boolean w;
        public String x;
        public boolean y;
        public String z;

        @RequiresApi
        public static class Api21Impl {
            @DoNotInline
            public static AudioAttributes a(AudioAttributes.Builder builder) {
                return builder.build();
            }

            @DoNotInline
            public static AudioAttributes.Builder b() {
                return new AudioAttributes.Builder();
            }

            @DoNotInline
            public static AudioAttributes.Builder c(AudioAttributes.Builder builder, int i) {
                return builder.setContentType(i);
            }

            @DoNotInline
            public static AudioAttributes.Builder d(AudioAttributes.Builder builder, int i) {
                return builder.setLegacyStreamType(i);
            }

            @DoNotInline
            public static AudioAttributes.Builder e(AudioAttributes.Builder builder, int i) {
                return builder.setUsage(i);
            }
        }

        @RequiresApi
        public static class Api23Impl {
            @DoNotInline
            public static Icon a(Notification notification) {
                return notification.getLargeIcon();
            }

            @DoNotInline
            public static Icon b(Notification notification) {
                return notification.getSmallIcon();
            }
        }

        @RequiresApi
        public static class Api24Impl {
            @DoNotInline
            public static RemoteViews a(Notification.Builder builder) {
                return builder.createHeadsUpContentView();
            }

            @DoNotInline
            public static RemoteViews b(Notification.Builder builder) {
                return builder.createContentView();
            }

            @DoNotInline
            public static RemoteViews c(Notification.Builder builder) {
                return builder.createHeadsUpContentView();
            }

            @DoNotInline
            public static Notification.Builder d(Context context, Notification notification) {
                return Notification.Builder.recoverBuilder(context, notification);
            }
        }

        public Builder(Context context, String str) {
            this.b = new ArrayList();
            this.c = new ArrayList();
            this.d = new ArrayList();
            this.n = true;
            this.A = false;
            this.F = 0;
            this.G = 0;
            this.M = 0;
            this.Q = 0;
            this.R = 0;
            Notification notification = new Notification();
            this.U = notification;
            this.f663a = context;
            this.L = str;
            notification.when = System.currentTimeMillis();
            this.U.audioStreamType = -1;
            this.m = 0;
            this.X = new ArrayList();
            this.S = true;
        }

        public static CharSequence e(CharSequence charSequence) {
            return (charSequence != null && charSequence.length() > 5120) ? charSequence.subSequence(0, 5120) : charSequence;
        }

        public Builder A(boolean z2) {
            r(2, z2);
            return this;
        }

        public Builder B(boolean z2) {
            r(8, z2);
            return this;
        }

        public Builder C(int i2) {
            this.m = i2;
            return this;
        }

        public Builder D(int i2, int i3, boolean z2) {
            this.u = i2;
            this.v = i3;
            this.w = z2;
            return this;
        }

        public Builder E(String str) {
            this.N = str;
            return this;
        }

        public Builder F(boolean z2) {
            this.n = z2;
            return this;
        }

        public Builder G(boolean z2) {
            this.V = z2;
            return this;
        }

        public Builder H(int i2) {
            this.U.icon = i2;
            return this;
        }

        public Builder I(Uri uri) {
            Notification notification = this.U;
            notification.sound = uri;
            notification.audioStreamType = -1;
            AudioAttributes.Builder e2 = Api21Impl.e(Api21Impl.c(Api21Impl.b(), 4), 5);
            this.U.audioAttributes = Api21Impl.a(e2);
            return this;
        }

        public Builder J(Style style) {
            if (this.q != style) {
                this.q = style;
                if (style != null) {
                    style.m(this);
                }
            }
            return this;
        }

        public Builder K(CharSequence charSequence) {
            this.r = e(charSequence);
            return this;
        }

        public Builder L(CharSequence charSequence) {
            this.U.tickerText = e(charSequence);
            return this;
        }

        public Builder M(long j2) {
            this.P = j2;
            return this;
        }

        public Builder N(boolean z2) {
            this.o = z2;
            return this;
        }

        public Builder O(long[] jArr) {
            this.U.vibrate = jArr;
            return this;
        }

        public Builder P(int i2) {
            this.G = i2;
            return this;
        }

        public Builder Q(long j2) {
            this.U.when = j2;
            return this;
        }

        public Builder a(int i2, CharSequence charSequence, PendingIntent pendingIntent) {
            this.b.add(new Action(i2, charSequence, pendingIntent));
            return this;
        }

        public Builder b(Action action) {
            if (action != null) {
                this.b.add(action);
            }
            return this;
        }

        public Notification c() {
            return new NotificationCompatBuilder(this).c();
        }

        public Bundle d() {
            if (this.E == null) {
                this.E = new Bundle();
            }
            return this.E;
        }

        public Builder f(boolean z2) {
            r(16, z2);
            return this;
        }

        public Builder g(String str) {
            this.D = str;
            return this;
        }

        public Builder h(String str) {
            this.L = str;
            return this;
        }

        public Builder i(boolean z2) {
            this.p = z2;
            d().putBoolean("android.chronometerCountDown", z2);
            return this;
        }

        public Builder j(int i2) {
            this.F = i2;
            return this;
        }

        public Builder k(boolean z2) {
            this.B = z2;
            this.C = true;
            return this;
        }

        public Builder l(PendingIntent pendingIntent) {
            this.g = pendingIntent;
            return this;
        }

        public Builder m(CharSequence charSequence) {
            this.f = e(charSequence);
            return this;
        }

        public Builder n(CharSequence charSequence) {
            this.e = e(charSequence);
            return this;
        }

        public Builder o(RemoteViews remoteViews) {
            this.J = remoteViews;
            return this;
        }

        public Builder p(RemoteViews remoteViews) {
            this.I = remoteViews;
            return this;
        }

        public Builder q(int i2) {
            Notification notification = this.U;
            notification.defaults = i2;
            if ((i2 & 4) != 0) {
                notification.flags |= 1;
            }
            return this;
        }

        public final void r(int i2, boolean z2) {
            if (z2) {
                Notification notification = this.U;
                notification.flags = i2 | notification.flags;
                return;
            }
            Notification notification2 = this.U;
            notification2.flags = (~i2) & notification2.flags;
        }

        public Builder s(PendingIntent pendingIntent, boolean z2) {
            this.h = pendingIntent;
            r(128, z2);
            return this;
        }

        public Builder t(String str) {
            this.x = str;
            return this;
        }

        public Builder u(int i2) {
            this.Q = i2;
            return this;
        }

        public Builder v(boolean z2) {
            this.y = z2;
            return this;
        }

        public Builder w(Bitmap bitmap) {
            this.j = bitmap == null ? null : IconCompat.h(NotificationCompat.c(this.f663a, bitmap));
            return this;
        }

        public Builder x(int i2, int i3, int i4) {
            Notification notification = this.U;
            notification.ledARGB = i2;
            notification.ledOnMS = i3;
            notification.ledOffMS = i4;
            notification.flags = ((i3 == 0 || i4 == 0) ? 0 : 1) | (notification.flags & -2);
            return this;
        }

        public Builder y(boolean z2) {
            this.A = z2;
            return this;
        }

        public Builder z(int i2) {
            this.l = i2;
            return this;
        }

        public Builder(Context context) {
            this(context, (String) null);
        }
    }
}
