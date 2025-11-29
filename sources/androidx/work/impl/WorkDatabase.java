package androidx.work.impl;

import android.content.Context;
import androidx.annotation.RestrictTo;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.framework.FrameworkSQLiteOpenHelperFactory;
import androidx.work.Clock;
import androidx.work.impl.model.DependencyDao;
import androidx.work.impl.model.PreferenceDao;
import androidx.work.impl.model.RawWorkInfoDao;
import androidx.work.impl.model.SystemIdInfoDao;
import androidx.work.impl.model.WorkNameDao;
import androidx.work.impl.model.WorkProgressDao;
import androidx.work.impl.model.WorkSpecDao;
import androidx.work.impl.model.WorkTagDao;
import com.honey.account.j0.f;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@RestrictTo
@Database
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b'\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001dB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH&¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H&¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H&¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H&¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u001a\u001a\u00020\u0019H&¢\u0006\u0004\b\u001a\u0010\u001b¨\u0006\u001e"}, d2 = {"Landroidx/work/impl/WorkDatabase;", "Landroidx/room/RoomDatabase;", "<init>", "()V", "Landroidx/work/impl/model/WorkSpecDao;", "j", "()Landroidx/work/impl/model/WorkSpecDao;", "Landroidx/work/impl/model/DependencyDao;", "d", "()Landroidx/work/impl/model/DependencyDao;", "Landroidx/work/impl/model/WorkTagDao;", "k", "()Landroidx/work/impl/model/WorkTagDao;", "Landroidx/work/impl/model/SystemIdInfoDao;", "g", "()Landroidx/work/impl/model/SystemIdInfoDao;", "Landroidx/work/impl/model/WorkNameDao;", "h", "()Landroidx/work/impl/model/WorkNameDao;", "Landroidx/work/impl/model/WorkProgressDao;", "i", "()Landroidx/work/impl/model/WorkProgressDao;", "Landroidx/work/impl/model/PreferenceDao;", "e", "()Landroidx/work/impl/model/PreferenceDao;", "Landroidx/work/impl/model/RawWorkInfoDao;", "f", "()Landroidx/work/impl/model/RawWorkInfoDao;", "a", "Companion", "work-runtime_release"}, k = 1, mv = {1, 8, 0})
@TypeConverters
public abstract class WorkDatabase extends RoomDatabase {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f2096a = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J/\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0007¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Landroidx/work/impl/WorkDatabase$Companion;", "", "<init>", "()V", "Landroid/content/Context;", "context", "Ljava/util/concurrent/Executor;", "queryExecutor", "Landroidx/work/Clock;", "clock", "", "useTestDatabase", "Landroidx/work/impl/WorkDatabase;", "b", "(Landroid/content/Context;Ljava/util/concurrent/Executor;Landroidx/work/Clock;Z)Landroidx/work/impl/WorkDatabase;", "work-runtime_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static final SupportSQLiteOpenHelper c(Context context, SupportSQLiteOpenHelper.Configuration configuration) {
            Intrinsics.checkNotNullParameter(context, "$context");
            Intrinsics.checkNotNullParameter(configuration, "configuration");
            SupportSQLiteOpenHelper.Configuration.Builder a2 = SupportSQLiteOpenHelper.Configuration.f.a(context);
            a2.d(configuration.b).c(configuration.c).e(true).a(true);
            return new FrameworkSQLiteOpenHelperFactory().a(a2.b());
        }

        public final WorkDatabase b(Context context, Executor executor, Clock clock, boolean z) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(executor, "queryExecutor");
            Intrinsics.checkNotNullParameter(clock, RtspHeaders.Values.CLOCK);
            Class<WorkDatabase> cls = WorkDatabase.class;
            return (WorkDatabase) (z ? Room.c(context, cls).c() : Room.a(context, cls, "androidx.work.workdb").g(new f(context))).i(executor).a(new CleanupCallback(clock)).b(Migration_1_2.f2084a).b(new RescheduleMigration(context, 2, 3)).b(Migration_3_4.f2085a).b(Migration_4_5.f2086a).b(new RescheduleMigration(context, 5, 6)).b(Migration_6_7.f2087a).b(Migration_7_8.f2088a).b(Migration_8_9.f2089a).b(new WorkMigration9To10(context)).b(new RescheduleMigration(context, 10, 11)).b(Migration_11_12.f2080a).b(Migration_12_13.f2081a).b(Migration_15_16.f2082a).b(Migration_16_17.f2083a).e().d();
        }

        public Companion() {
        }
    }

    public abstract DependencyDao d();

    public abstract PreferenceDao e();

    public abstract RawWorkInfoDao f();

    public abstract SystemIdInfoDao g();

    public abstract WorkNameDao h();

    public abstract WorkProgressDao i();

    public abstract WorkSpecDao j();

    public abstract WorkTagDao k();
}
