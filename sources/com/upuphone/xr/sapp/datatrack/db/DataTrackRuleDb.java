package com.upuphone.xr.sapp.datatrack.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Database
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b'\u0018\u0000 \u00072\u00020\u0001:\u0001\bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/upuphone/xr/sapp/datatrack/db/DataTrackRuleDb;", "Landroidx/room/RoomDatabase;", "<init>", "()V", "Lcom/upuphone/xr/sapp/datatrack/db/DataTrackRuleDao;", "e", "()Lcom/upuphone/xr/sapp/datatrack/db/DataTrackRuleDao;", "a", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public abstract class DataTrackRuleDb extends RoomDatabase {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f6927a = new Companion((DefaultConstructorMarker) null);
    public static final Lazy b = LazyKt.lazy(DataTrackRuleDb$Companion$instance$2.INSTANCE);

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001b\u0010\t\u001a\u00020\u00048FX\u0002¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/upuphone/xr/sapp/datatrack/db/DataTrackRuleDb$Companion;", "", "<init>", "()V", "Lcom/upuphone/xr/sapp/datatrack/db/DataTrackRuleDb;", "instance$delegate", "Lkotlin/Lazy;", "a", "()Lcom/upuphone/xr/sapp/datatrack/db/DataTrackRuleDb;", "instance", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final DataTrackRuleDb a() {
            return (DataTrackRuleDb) DataTrackRuleDb.b.getValue();
        }

        public Companion() {
        }
    }

    public abstract DataTrackRuleDao e();
}
