package com.upuphone.ar.translation.phone.db;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

final class TranslatorDataBase_AutoMigration_5_6_Impl extends Migration {
    public TranslatorDataBase_AutoMigration_5_6_Impl() {
        super(5, 6);
    }

    public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        supportSQLiteDatabase.P("ALTER TABLE `IntelExtnTodo` ADD COLUMN `deleteStatus` INTEGER NOT NULL DEFAULT 0");
        supportSQLiteDatabase.P("ALTER TABLE `IntelExtnSummary` ADD COLUMN `deleteStatus` INTEGER NOT NULL DEFAULT 0");
    }
}
