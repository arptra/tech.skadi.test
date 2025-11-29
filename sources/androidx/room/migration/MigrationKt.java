package androidx.room.migration;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a1\u0010\b\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"", "startVersion", "endVersion", "Lkotlin/Function1;", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "", "migrate", "Landroidx/room/migration/Migration;", "a", "(IILkotlin/jvm/functions/Function1;)Landroidx/room/migration/Migration;", "room-ktx_release"}, k = 2, mv = {1, 8, 0})
@JvmName(name = "MigrationKt")
public final class MigrationKt {
    public static final Migration a(int i, int i2, Function1 function1) {
        return new MigrationImpl(i, i2, function1);
    }
}
