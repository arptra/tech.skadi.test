package com.upuphone.ai.ttsengine.engines.cache.db;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/upuphone/ai/ttsengine/engines/cache/db/CacheDatabase$Companion$MIGRATION_1_2$1", "Landroidx/room/migration/Migration;", "migrate", "", "database", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "aar_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class CacheDatabase$Companion$MIGRATION_1_2$1 extends Migration {
    public CacheDatabase$Companion$MIGRATION_1_2$1() {
        super(1, 2);
    }

    public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        Intrinsics.checkNotNullParameter(supportSQLiteDatabase, "database");
        supportSQLiteDatabase.P("ALTER TABLE pcmCache ADD COLUMN count INTEGER NOT NULL DEFAULT 1");
    }
}
