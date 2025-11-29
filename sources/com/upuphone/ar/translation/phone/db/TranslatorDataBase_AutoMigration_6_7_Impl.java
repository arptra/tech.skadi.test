package com.upuphone.ar.translation.phone.db;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

final class TranslatorDataBase_AutoMigration_6_7_Impl extends Migration {
    public TranslatorDataBase_AutoMigration_6_7_Impl() {
        super(6, 7);
    }

    public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        supportSQLiteDatabase.P("ALTER TABLE `IntelExtnTodo` ADD COLUMN `originalContent` TEXT NOT NULL DEFAULT ''");
        supportSQLiteDatabase.P("ALTER TABLE `IntelExtnSummary` ADD COLUMN `originalSummary` TEXT NOT NULL DEFAULT ''");
    }
}
