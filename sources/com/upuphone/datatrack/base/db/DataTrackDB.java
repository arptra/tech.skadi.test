package com.upuphone.datatrack.base.db;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Database
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b'\u0018\u0000 \n2\u00020\u0001:\u0001\u000bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/upuphone/datatrack/base/db/DataTrackDB;", "Landroidx/room/RoomDatabase;", "<init>", "()V", "Lcom/upuphone/datatrack/base/db/ReportTypeDao;", "g", "()Lcom/upuphone/datatrack/base/db/ReportTypeDao;", "Lcom/upuphone/datatrack/base/db/AppTrackDao;", "f", "()Lcom/upuphone/datatrack/base/db/AppTrackDao;", "a", "Companion", "datatrack-base_release"}, k = 1, mv = {1, 7, 1})
public abstract class DataTrackDB extends RoomDatabase {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f6387a = new Companion((DefaultConstructorMarker) null);
    public static volatile DataTrackDB b;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/upuphone/datatrack/base/db/DataTrackDB$Companion;", "", "<init>", "()V", "Landroid/content/Context;", "context", "Lcom/upuphone/datatrack/base/db/DataTrackDB;", "a", "(Landroid/content/Context;)Lcom/upuphone/datatrack/base/db/DataTrackDB;", "instance", "Lcom/upuphone/datatrack/base/db/DataTrackDB;", "datatrack-base_release"}, k = 1, mv = {1, 7, 1})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final DataTrackDB a(Context context) {
            DataTrackDB dataTrackDB;
            Intrinsics.checkNotNullParameter(context, "context");
            DataTrackDB d = DataTrackDB.b;
            if (d != null) {
                return d;
            }
            synchronized (DataTrackDB.class) {
                DataTrackDB d2 = DataTrackDB.b;
                if (d2 == null) {
                    RoomDatabase d3 = Room.a(context, DataTrackDB.class, "data_track").e().d();
                    DataTrackDB.b = (DataTrackDB) d3;
                    dataTrackDB = (DataTrackDB) d3;
                } else {
                    dataTrackDB = d2;
                }
            }
            return dataTrackDB;
        }

        public Companion() {
        }
    }

    public abstract AppTrackDao f();

    public abstract ReportTypeDao g();
}
