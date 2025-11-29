package com.upuphone.xr.sapp.monitor.notification.cache;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import com.upuphone.xr.sapp.MainApplication;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Database
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b'\u0018\u0000 \u00072\u00020\u0001:\u0001\bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/upuphone/xr/sapp/monitor/notification/cache/NotificationDataBase;", "Landroidx/room/RoomDatabase;", "<init>", "()V", "Lcom/upuphone/xr/sapp/monitor/notification/cache/WechatMissedCallDao;", "f", "()Lcom/upuphone/xr/sapp/monitor/notification/cache/WechatMissedCallDao;", "a", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public abstract class NotificationDataBase extends RoomDatabase {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f7758a = new Companion((DefaultConstructorMarker) null);
    public static NotificationDataBase b;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R$\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\u0006\"\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/upuphone/xr/sapp/monitor/notification/cache/NotificationDataBase$Companion;", "", "<init>", "()V", "Lcom/upuphone/xr/sapp/monitor/notification/cache/NotificationDataBase;", "a", "()Lcom/upuphone/xr/sapp/monitor/notification/cache/NotificationDataBase;", "instance", "Lcom/upuphone/xr/sapp/monitor/notification/cache/NotificationDataBase;", "b", "c", "(Lcom/upuphone/xr/sapp/monitor/notification/cache/NotificationDataBase;)V", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final NotificationDataBase a() {
            if (b() == null) {
                c((NotificationDataBase) Room.a(MainApplication.k.f(), NotificationDataBase.class, "reminder.db").e().a(new NotificationDataBase$Companion$getDB$1()).d());
            }
            NotificationDataBase b = b();
            Intrinsics.checkNotNull(b);
            return b;
        }

        public final NotificationDataBase b() {
            return NotificationDataBase.b;
        }

        public final void c(NotificationDataBase notificationDataBase) {
            NotificationDataBase.b = notificationDataBase;
        }

        public Companion() {
        }
    }

    public abstract WechatMissedCallDao f();
}
