package com.upuphone.ar.translation.phone.db;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

final class TranslatorDataBase_AutoMigration_4_5_Impl extends Migration {
    public TranslatorDataBase_AutoMigration_4_5_Impl() {
        super(4, 5);
    }

    public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        supportSQLiteDatabase.P("ALTER TABLE `IntelExtnTodo` ADD COLUMN `isAddedSchedule` INTEGER NOT NULL DEFAULT 0");
    }
}
