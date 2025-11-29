package com.upuphone.star.download.manager.db;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Database
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b!\u0018\u0000 \u00072\u00020\u0001:\u0001\bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/upuphone/star/download/manager/db/DownloadDb;", "Landroidx/room/RoomDatabase;", "<init>", "()V", "Lcom/upuphone/star/download/manager/db/DownloadDao;", "f", "()Lcom/upuphone/star/download/manager/db/DownloadDao;", "a", "Companion", "lib_download_manager_release"}, k = 1, mv = {1, 9, 0})
public abstract class DownloadDb extends RoomDatabase {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f6469a = new Companion((DefaultConstructorMarker) null);
    public static volatile DownloadDb b;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/upuphone/star/download/manager/db/DownloadDb$Companion;", "", "<init>", "()V", "Landroid/content/Context;", "context", "Lcom/upuphone/star/download/manager/db/DownloadDb;", "b", "(Landroid/content/Context;)Lcom/upuphone/star/download/manager/db/DownloadDb;", "instance", "Lcom/upuphone/star/download/manager/db/DownloadDb;", "a", "()Lcom/upuphone/star/download/manager/db/DownloadDb;", "c", "(Lcom/upuphone/star/download/manager/db/DownloadDb;)V", "lib_download_manager_release"}, k = 1, mv = {1, 9, 0})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final DownloadDb a() {
            return DownloadDb.b;
        }

        public final DownloadDb b(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            DownloadDb a2 = a();
            if (a2 == null) {
                synchronized (this) {
                    Companion companion = DownloadDb.f6469a;
                    DownloadDb a3 = companion.a();
                    if (a3 == null) {
                        RoomDatabase d = Room.a(context, DownloadDb.class, "myvu_dm.db").e().d();
                        companion.c((DownloadDb) d);
                        a2 = (DownloadDb) d;
                    } else {
                        a2 = a3;
                    }
                }
            }
            return a2;
        }

        public final void c(DownloadDb downloadDb) {
            DownloadDb.b = downloadDb;
        }

        public Companion() {
        }
    }

    public abstract DownloadDao f();
}
