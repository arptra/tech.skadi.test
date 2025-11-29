package com.upuphone.ar.tici.phone.db;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

final class TiciDatabase_AutoMigration_1_2_Impl extends Migration {
    public TiciDatabase_AutoMigration_1_2_Impl() {
        super(1, 2);
    }

    public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        supportSQLiteDatabase.P("ALTER TABLE `TiciEntity` ADD COLUMN `userId` TEXT DEFAULT NULL");
        supportSQLiteDatabase.P("ALTER TABLE `TiciEntity` ADD COLUMN `currentPage` INTEGER NOT NULL DEFAULT 0");
        supportSQLiteDatabase.P("ALTER TABLE `TiciEntity` ADD COLUMN `totalPage` INTEGER NOT NULL DEFAULT 1");
        supportSQLiteDatabase.P("ALTER TABLE `TiciEntity` ADD COLUMN `totalTextLength` INTEGER NOT NULL DEFAULT 0");
        supportSQLiteDatabase.P("CREATE TABLE IF NOT EXISTS `TiciContentPart` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `ticiId` INTEGER NOT NULL, `contentText` TEXT NOT NULL, `paragraphIndexes` TEXT NOT NULL, `highlightIndex` INTEGER NOT NULL, `partSize` INTEGER NOT NULL, `partIndex` INTEGER NOT NULL, `contentOffsetStart` INTEGER NOT NULL, `contentOffsetEnd` INTEGER NOT NULL)");
    }
}
