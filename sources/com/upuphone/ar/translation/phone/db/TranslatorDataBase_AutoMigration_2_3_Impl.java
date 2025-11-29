package com.upuphone.ar.translation.phone.db;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

final class TranslatorDataBase_AutoMigration_2_3_Impl extends Migration {
    public TranslatorDataBase_AutoMigration_2_3_Impl() {
        super(2, 3);
    }

    public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        supportSQLiteDatabase.P("ALTER TABLE `IntelExtnTodo` ADD COLUMN `title` TEXT NOT NULL DEFAULT ''");
    }
}
