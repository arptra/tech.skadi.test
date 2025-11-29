package androidx.room.migration;

import androidx.sqlite.db.SupportSQLiteDatabase;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\b\u0002\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\f\u0010\rR#\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00058\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Landroidx/room/migration/MigrationImpl;", "Landroidx/room/migration/Migration;", "", "startVersion", "endVersion", "Lkotlin/Function1;", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "", "migrateCallback", "<init>", "(IILkotlin/jvm/functions/Function1;)V", "db", "migrate", "(Landroidx/sqlite/db/SupportSQLiteDatabase;)V", "a", "Lkotlin/jvm/functions/Function1;", "getMigrateCallback", "()Lkotlin/jvm/functions/Function1;", "room-ktx_release"}, k = 1, mv = {1, 8, 0})
final class MigrationImpl extends Migration {

    /* renamed from: a  reason: collision with root package name */
    public final Function1 f1764a;

    public MigrationImpl(int i, int i2, Function1 function1) {
        super(i, i2);
        this.f1764a = function1;
    }

    public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        this.f1764a.invoke(supportSQLiteDatabase);
    }
}
