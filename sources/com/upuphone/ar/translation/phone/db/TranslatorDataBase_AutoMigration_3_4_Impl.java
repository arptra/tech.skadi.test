package com.upuphone.ar.translation.phone.db;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

final class TranslatorDataBase_AutoMigration_3_4_Impl extends Migration {
    public TranslatorDataBase_AutoMigration_3_4_Impl() {
        super(3, 4);
    }

    public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        supportSQLiteDatabase.P("ALTER TABLE `IntelExtnTodo` ADD COLUMN `isIsDone` INTEGER NOT NULL DEFAULT 0");
    }
}
