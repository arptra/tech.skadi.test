package androidx.work.impl;

import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.work.Clock;
import io.netty.handler.codec.rtsp.RtspHeaders;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0012\u001a\u00020\u000f8BX\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0016\u001a\u00020\u00138BX\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"Landroidx/work/impl/CleanupCallback;", "Landroidx/room/RoomDatabase$Callback;", "Landroidx/work/Clock;", "clock", "<init>", "(Landroidx/work/Clock;)V", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "db", "", "c", "(Landroidx/sqlite/db/SupportSQLiteDatabase;)V", "a", "Landroidx/work/Clock;", "getClock", "()Landroidx/work/Clock;", "", "e", "()Ljava/lang/String;", "pruneSQL", "", "d", "()J", "pruneDate", "work-runtime_release"}, k = 1, mv = {1, 8, 0})
public final class CleanupCallback extends RoomDatabase.Callback {

    /* renamed from: a  reason: collision with root package name */
    public final Clock f2078a;

    public CleanupCallback(Clock clock) {
        Intrinsics.checkNotNullParameter(clock, RtspHeaders.Values.CLOCK);
        this.f2078a = clock;
    }

    public void c(SupportSQLiteDatabase supportSQLiteDatabase) {
        Intrinsics.checkNotNullParameter(supportSQLiteDatabase, "db");
        super.c(supportSQLiteDatabase);
        supportSQLiteDatabase.f();
        try {
            supportSQLiteDatabase.P(e());
            supportSQLiteDatabase.V();
        } finally {
            supportSQLiteDatabase.Z();
        }
    }

    public final long d() {
        return this.f2078a.currentTimeMillis() - WorkDatabaseKt.f2097a;
    }

    public final String e() {
        return "DELETE FROM workspec WHERE state IN (2, 3, 5) AND (last_enqueue_time + minimum_retention_duration) < " + d() + " AND (SELECT COUNT(*)=0 FROM dependency WHERE     prerequisite_id=id AND     work_spec_id NOT IN         (SELECT id FROM workspec WHERE state IN (2, 3, 5)))";
    }
}
