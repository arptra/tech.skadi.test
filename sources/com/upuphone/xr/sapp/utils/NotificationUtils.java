package com.upuphone.xr.sapp.utils;

import android.app.NotificationChannel;
import android.app.PendingIntent;
import android.content.Context;
import android.media.AudioAttributes;
import android.net.Uri;
import androidx.core.app.NotificationChannelCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;
import com.upuphone.xr.sapp.MainApplication;
import com.upuphone.xr.sapp.R;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003Jw\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\u00042\b\b\u0002\u0010\f\u001a\u00020\u00042\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00102\b\b\u0002\u0010\u0013\u001a\u00020\u0010¢\u0006\u0004\b\u0015\u0010\u0016J6\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0017\u0010\u001a\u001a\u0013\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00140\u0017¢\u0006\u0002\b\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ\u0019\u0010\u001f\u001a\u00020\u00142\n\u0010\u001e\u001a\u00020\u001d\"\u00020\u0004¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010\"\u001a\u0004\u0018\u00010!2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\"\u0010#J\u0017\u0010$\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b$\u0010%JO\u0010,\u001a\u00020\u00142\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010&\u001a\u00020\u00062\u0006\u0010'\u001a\u00020\u00062\b\b\u0002\u0010(\u001a\u00020\u00042\b\b\u0002\u0010)\u001a\u00020\u00102\b\b\u0002\u0010*\u001a\u00020\u00102\b\b\u0002\u0010+\u001a\u00020\u0010H\u0002¢\u0006\u0004\b,\u0010-R\u0011\u00100\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b.\u0010/R\u0014\u00104\u001a\u0002018BX\u0004¢\u0006\u0006\u001a\u0004\b2\u00103¨\u00065"}, d2 = {"Lcom/upuphone/xr/sapp/utils/NotificationUtils;", "", "<init>", "()V", "", "id", "", "channelId", "", "title", "content", "smallIcon", "priority", "Landroid/app/PendingIntent;", "contentIntent", "progress", "", "autoCancel", "silent", "onGoing", "", "h", "(ILjava/lang/String;Ljava/lang/CharSequence;Ljava/lang/CharSequence;IILandroid/app/PendingIntent;Ljava/lang/Integer;ZZZ)V", "Lkotlin/Function1;", "Landroidx/core/app/NotificationCompat$Builder;", "Lkotlin/ExtensionFunctionType;", "builderAction", "i", "(ILjava/lang/String;Lkotlin/jvm/functions/Function1;)V", "", "ids", "a", "([I)V", "Landroid/app/NotificationChannel;", "f", "(Ljava/lang/String;)Landroid/app/NotificationChannel;", "g", "(Ljava/lang/String;)Ljava/lang/Boolean;", "channelName", "channelDesc", "importance", "vibration", "lights", "noSound", "b", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZZZ)V", "d", "()Z", "canShowNotification", "Landroid/content/Context;", "e", "()Landroid/content/Context;", "context", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nNotificationUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NotificationUtils.kt\ncom/upuphone/xr/sapp/utils/NotificationUtils\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,169:1\n13330#2,2:170\n*S KotlinDebug\n*F\n+ 1 NotificationUtils.kt\ncom/upuphone/xr/sapp/utils/NotificationUtils\n*L\n113#1:170,2\n*E\n"})
public final class NotificationUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final NotificationUtils f7900a;

    static {
        NotificationUtils notificationUtils = new NotificationUtils();
        f7900a = notificationUtils;
        c(notificationUtils, "channel_download", GlobalExtKt.h(R.string.channel_download_title), GlobalExtKt.h(R.string.channel_download_desc), 0, false, false, false, 120, (Object) null);
        c(notificationUtils, "channel_glass_update", GlobalExtKt.h(R.string.channel_glass_update_title), GlobalExtKt.h(R.string.channel_glass_update_desc), 0, false, false, false, 120, (Object) null);
        c(notificationUtils, "channel_app_update", GlobalExtKt.h(R.string.channel_app_update_title), GlobalExtKt.h(R.string.channel_app_update_title), 0, false, false, true, 8, (Object) null);
    }

    public static /* synthetic */ void c(NotificationUtils notificationUtils, String str, String str2, String str3, int i, boolean z, boolean z2, boolean z3, int i2, Object obj) {
        notificationUtils.b(str, str2, str3, (i2 & 8) != 0 ? 4 : i, (i2 & 16) != 0 ? true : z, (i2 & 32) != 0 ? true : z2, (i2 & 64) != 0 ? false : z3);
    }

    public static /* synthetic */ void j(NotificationUtils notificationUtils, int i, String str, CharSequence charSequence, CharSequence charSequence2, int i2, int i3, PendingIntent pendingIntent, Integer num, boolean z, boolean z2, boolean z3, int i4, Object obj) {
        int i5 = i4;
        notificationUtils.h(i, str, charSequence, charSequence2, (i5 & 16) != 0 ? R.drawable.notification_logo_mini : i2, (i5 & 32) != 0 ? 1 : i3, (i5 & 64) != 0 ? null : pendingIntent, (i5 & 128) != 0 ? null : num, (i5 & 256) != 0 ? true : z, (i5 & 512) != 0 ? false : z2, (i5 & 1024) != 0 ? false : z3);
    }

    public final void a(int... iArr) {
        Intrinsics.checkNotNullParameter(iArr, "ids");
        NotificationManagerCompat g = NotificationManagerCompat.g(e());
        for (int b : iArr) {
            g.b(b);
        }
    }

    public final void b(String str, String str2, String str3, int i, boolean z, boolean z2, boolean z3) {
        NotificationManagerCompat g = NotificationManagerCompat.g(e());
        if (g.i(str) == null) {
            NotificationChannelCompat.Builder builder = new NotificationChannelCompat.Builder(str, i);
            builder.d(str2);
            builder.b(str3);
            builder.f(z);
            builder.c(z2);
            if (z3) {
                builder.e((Uri) null, (AudioAttributes) null);
            }
            NotificationChannelCompat a2 = builder.a();
            Intrinsics.checkNotNullExpressionValue(a2, "build(...)");
            g.f(a2);
        }
    }

    public final boolean d() {
        if (ContextCompat.checkSelfPermission(e(), "android.permission.POST_NOTIFICATIONS") != 0) {
            return false;
        }
        return NotificationManagerCompat.g(e()).a();
    }

    public final Context e() {
        Context applicationContext = MainApplication.k.f().getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        return applicationContext;
    }

    public final NotificationChannel f(String str) {
        Intrinsics.checkNotNullParameter(str, "channelId");
        return NotificationManagerCompat.g(e()).i(str);
    }

    public final Boolean g(String str) {
        Intrinsics.checkNotNullParameter(str, "channelId");
        NotificationChannel f = f(str);
        if (f == null) {
            return null;
        }
        return Boolean.valueOf(f.getImportance() > 0);
    }

    public final void h(int i, String str, CharSequence charSequence, CharSequence charSequence2, int i2, int i3, PendingIntent pendingIntent, Integer num, boolean z, boolean z2, boolean z3) {
        String str2 = str;
        Intrinsics.checkNotNullParameter(str, "channelId");
        Intrinsics.checkNotNullParameter(charSequence, "title");
        CharSequence charSequence3 = charSequence2;
        Intrinsics.checkNotNullParameter(charSequence3, "content");
        NotificationUtils$showNotification$1 notificationUtils$showNotification$1 = new NotificationUtils$showNotification$1(i2, charSequence, charSequence3, num, pendingIntent, i3, z, z2, z3);
        int i4 = i;
        i(i, str, notificationUtils$showNotification$1);
    }

    public final void i(int i, String str, Function1 function1) {
        Intrinsics.checkNotNullParameter(str, "channelId");
        Intrinsics.checkNotNullParameter(function1, "builderAction");
        if (ContextCompat.checkSelfPermission(e(), "android.permission.POST_NOTIFICATIONS") == 0) {
            NotificationCompat.Builder builder = new NotificationCompat.Builder(e(), str);
            function1.invoke(builder);
            NotificationManagerCompat.g(e()).k(i, builder.c());
        }
    }
}
