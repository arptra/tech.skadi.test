package com.upuphone.xr.sapp.vu.utils;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import com.upuphone.xr.sapp.MainApplication;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.utils.GlobalExtKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/upuphone/xr/sapp/vu/utils/ArSpaceNotificationUtil;", "", "<init>", "()V", "Landroid/content/Context;", "context", "", "a", "(Landroid/content/Context;)V", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class ArSpaceNotificationUtil {

    /* renamed from: a  reason: collision with root package name */
    public static final ArSpaceNotificationUtil f8087a;

    static {
        ArSpaceNotificationUtil arSpaceNotificationUtil = new ArSpaceNotificationUtil();
        f8087a = arSpaceNotificationUtil;
        arSpaceNotificationUtil.a(MainApplication.k.f());
    }

    public final void a(Context context) {
        String h = GlobalExtKt.h(R.string.channel_glass_record_title);
        String h2 = GlobalExtKt.h(R.string.channel_glass_record_desc);
        NotificationChannel notificationChannel = new NotificationChannel("channel_screen_record", h, 3);
        notificationChannel.setDescription(h2);
        Object systemService = context.getSystemService("notification");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        ((NotificationManager) systemService).createNotificationChannel(notificationChannel);
    }
}
