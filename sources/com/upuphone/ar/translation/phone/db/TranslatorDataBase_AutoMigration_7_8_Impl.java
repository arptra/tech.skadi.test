package com.upuphone.ar.translation.phone.db;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

final class TranslatorDataBase_AutoMigration_7_8_Impl extends Migration {
    public TranslatorDataBase_AutoMigration_7_8_Impl() {
        super(7, 8);
    }

    public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        supportSQLiteDatabase.P("ALTER TABLE `IntelExtnTodo` ADD COLUMN `requestId` TEXT NOT NULL DEFAULT ''");
        supportSQLiteDatabase.P("ALTER TABLE `IntelExtnTodo` ADD COLUMN `isReported` INTEGER NOT NULL DEFAULT 0");
        supportSQLiteDatabase.P("ALTER TABLE `IntelExtnSummary` ADD COLUMN `requestId` TEXT NOT NULL DEFAULT ''");
        supportSQLiteDatabase.P("ALTER TABLE `IntelExtnSummary` ADD COLUMN `isReported` INTEGER NOT NULL DEFAULT 0");
    }
}
