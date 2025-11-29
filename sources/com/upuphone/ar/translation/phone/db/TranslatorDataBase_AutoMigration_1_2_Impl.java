package com.upuphone.ar.translation.phone.db;

import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

final class TranslatorDataBase_AutoMigration_1_2_Impl extends Migration {

    /* renamed from: a  reason: collision with root package name */
    public final AutoMigrationSpec f6271a = new TranslatorAutoMigrationSpec();

    public TranslatorDataBase_AutoMigration_1_2_Impl() {
        super(1, 2);
    }

    public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        supportSQLiteDatabase.P("ALTER TABLE `IntelExtnTodo` ADD COLUMN `calendarId` INTEGER NOT NULL DEFAULT 0");
        supportSQLiteDatabase.P("ALTER TABLE `IntelExtnTodo` ADD COLUMN `calendarEventId` INTEGER NOT NULL DEFAULT 0");
        supportSQLiteDatabase.P("CREATE TABLE IF NOT EXISTS `_new_IntelExtnTodo` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `content` TEXT NOT NULL, `startTime` TEXT NOT NULL, `endTime` TEXT NOT NULL, `accountId` TEXT NOT NULL, `recognizeId` TEXT NOT NULL, `calendarId` INTEGER NOT NULL DEFAULT 0, `calendarEventId` INTEGER NOT NULL DEFAULT 0)");
        supportSQLiteDatabase.P("INSERT INTO `_new_IntelExtnTodo` (`id`,`content`,`startTime`,`endTime`,`accountId`,`recognizeId`) SELECT `id`,`content`,`startTime`,`endTime`,`accountId`,`recognizeId` FROM `IntelExtnTodo`");
        supportSQLiteDatabase.P("DROP TABLE `IntelExtnTodo`");
        supportSQLiteDatabase.P("ALTER TABLE `_new_IntelExtnTodo` RENAME TO `IntelExtnTodo`");
        this.f6271a.onPostMigrate(supportSQLiteDatabase);
    }
}
