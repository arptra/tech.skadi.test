package com.upuphone.xr.sapp.monitor.schedule.calendar;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.provider.CalendarContract;
import androidx.core.content.ContextCompat;
import com.upuphone.star.core.log.ULog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u000f2\u00020\u0001:\u0001\u0010B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J)\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/upuphone/xr/sapp/monitor/schedule/calendar/CalendarObserver;", "Landroid/database/ContentObserver;", "Landroid/os/Handler;", "handler", "<init>", "(Landroid/os/Handler;)V", "", "selfChange", "Landroid/net/Uri;", "uri", "", "flags", "", "onChange", "(ZLandroid/net/Uri;I)V", "a", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class CalendarObserver extends ContentObserver {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f7783a = new Companion((DefaultConstructorMarker) null);
    public static final String b = CalendarObserver.class.getSimpleName();
    public static CalendarObserver c;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\bR\u001c\u0010\f\u001a\n \u000b*\u0004\u0018\u00010\n0\n8\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/upuphone/xr/sapp/monitor/schedule/calendar/CalendarObserver$Companion;", "", "<init>", "()V", "Landroid/content/Context;", "context", "", "a", "(Landroid/content/Context;)V", "b", "", "kotlin.jvm.PlatformType", "TAG", "Ljava/lang/String;", "Lcom/upuphone/xr/sapp/monitor/schedule/calendar/CalendarObserver;", "observer", "Lcom/upuphone/xr/sapp/monitor/schedule/calendar/CalendarObserver;", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            ULog.Delegate delegate = ULog.f6446a;
            delegate.a(CalendarObserver.b, "registerDateChangeReceiver");
            if (ContextCompat.checkSelfPermission(context, "android.permission.READ_CALENDAR") != 0) {
                delegate.a(CalendarObserver.b, "registerDateChangeReceiver fail  read_calendar permission");
                return;
            }
            Uri uri = CalendarContract.Events.CONTENT_URI;
            ContentResolver contentResolver = context.getContentResolver();
            CalendarObserver.c = new CalendarObserver(new Handler(Looper.getMainLooper()));
            CalendarObserver a2 = CalendarObserver.c;
            Intrinsics.checkNotNull(a2);
            contentResolver.registerContentObserver(uri, true, a2);
        }

        public final void b(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            ULog.f6446a.a(CalendarObserver.b, "unregisterDateChangeObserver");
            if (CalendarObserver.c != null) {
                ContentResolver contentResolver = context.getContentResolver();
                CalendarObserver a2 = CalendarObserver.c;
                Intrinsics.checkNotNull(a2);
                contentResolver.unregisterContentObserver(a2);
            }
        }

        public Companion() {
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CalendarObserver(Handler handler) {
        super(handler);
        Intrinsics.checkNotNullParameter(handler, "handler");
    }

    public void onChange(boolean z, Uri uri, int i) {
        super.onChange(z, uri, i);
        ULog.Delegate delegate = ULog.f6446a;
        String str = b;
        delegate.g(str, "schedule changed selfChange" + z + " uri:" + uri + " flags" + i);
        if (i == 1) {
            CalendarScheduleProvider.f7784a.c();
        }
    }
}
