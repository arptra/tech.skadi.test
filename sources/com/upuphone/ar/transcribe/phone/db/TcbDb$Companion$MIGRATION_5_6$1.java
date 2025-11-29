package com.upuphone.ar.transcribe.phone.db;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/upuphone/ar/transcribe/phone/db/TcbDb$Companion$MIGRATION_5_6$1", "Landroidx/room/migration/Migration;", "migrate", "", "db", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class TcbDb$Companion$MIGRATION_5_6$1 extends Migration {
    public TcbDb$Companion$MIGRATION_5_6$1() {
        super(5, 6);
    }

    public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        Intrinsics.checkNotNullParameter(supportSQLiteDatabase, "db");
        supportSQLiteDatabase.P("ALTER TABLE summary ADD COLUMN src TEXT");
        supportSQLiteDatabase.P("ALTER TABLE summary ADD COLUMN deleted INTEGER");
        supportSQLiteDatabase.P("ALTER TABLE todo_list ADD COLUMN src TEXT");
        supportSQLiteDatabase.P("ALTER TABLE todo_list ADD COLUMN deleted INTEGER");
    }
}
