package com.upuphone.ar.fastrecord.phone.db;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class FastRecordTagHistoryDao_Impl implements FastRecordTagHistoryDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<RecordContentHistoryTagEntity> __deletionAdapterOfRecordContentHistoryTagEntity;
    private final EntityInsertionAdapter<RecordContentHistoryTagEntity> __insertionAdapterOfRecordContentHistoryTagEntity;
    private final SharedSQLiteStatement __preparedStmtOfDeleteAllData;
    private final EntityDeletionOrUpdateAdapter<RecordContentHistoryTagEntity> __updateAdapterOfRecordContentHistoryTagEntity;

    public FastRecordTagHistoryDao_Impl(@NonNull RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfRecordContentHistoryTagEntity = new EntityInsertionAdapter<RecordContentHistoryTagEntity>(roomDatabase) {
            @NonNull
            public String createQuery() {
                return "INSERT OR REPLACE INTO `RecordContentHistoryTagEntity` (`contentTagId`,`contentName`,`createTime`,`accountId`) VALUES (nullif(?, 0),?,?,?)";
            }

            public void bind(@NonNull SupportSQLiteStatement supportSQLiteStatement, @NonNull RecordContentHistoryTagEntity recordContentHistoryTagEntity) {
                supportSQLiteStatement.F(1, recordContentHistoryTagEntity.getContentTagId());
                if (recordContentHistoryTagEntity.getContentName() == null) {
                    supportSQLiteStatement.L(2);
                } else {
                    supportSQLiteStatement.B(2, recordContentHistoryTagEntity.getContentName());
                }
                supportSQLiteStatement.F(3, recordContentHistoryTagEntity.getCreateTime());
                supportSQLiteStatement.B(4, recordContentHistoryTagEntity.getAccountId());
            }
        };
        this.__deletionAdapterOfRecordContentHistoryTagEntity = new EntityDeletionOrUpdateAdapter<RecordContentHistoryTagEntity>(roomDatabase) {
            @NonNull
            public String createQuery() {
                return "DELETE FROM `RecordContentHistoryTagEntity` WHERE `contentTagId` = ?";
            }

            public void bind(@NonNull SupportSQLiteStatement supportSQLiteStatement, @NonNull RecordContentHistoryTagEntity recordContentHistoryTagEntity) {
                supportSQLiteStatement.F(1, recordContentHistoryTagEntity.getContentTagId());
            }
        };
        this.__updateAdapterOfRecordContentHistoryTagEntity = new EntityDeletionOrUpdateAdapter<RecordContentHistoryTagEntity>(roomDatabase) {
            @NonNull
            public String createQuery() {
                return "UPDATE OR ABORT `RecordContentHistoryTagEntity` SET `contentTagId` = ?,`contentName` = ?,`createTime` = ?,`accountId` = ? WHERE `contentTagId` = ?";
            }

            public void bind(@NonNull SupportSQLiteStatement supportSQLiteStatement, @NonNull RecordContentHistoryTagEntity recordContentHistoryTagEntity) {
                supportSQLiteStatement.F(1, recordContentHistoryTagEntity.getContentTagId());
                if (recordContentHistoryTagEntity.getContentName() == null) {
                    supportSQLiteStatement.L(2);
                } else {
                    supportSQLiteStatement.B(2, recordContentHistoryTagEntity.getContentName());
                }
                supportSQLiteStatement.F(3, recordContentHistoryTagEntity.getCreateTime());
                supportSQLiteStatement.B(4, recordContentHistoryTagEntity.getAccountId());
                supportSQLiteStatement.F(5, recordContentHistoryTagEntity.getContentTagId());
            }
        };
        this.__preparedStmtOfDeleteAllData = new SharedSQLiteStatement(roomDatabase) {
            @NonNull
            public String createQuery() {
                return "DELETE  FROM RecordContentHistoryTagEntity";
            }
        };
    }

    @NonNull
    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    public void delete(RecordContentHistoryTagEntity recordContentHistoryTagEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__deletionAdapterOfRecordContentHistoryTagEntity.handle(recordContentHistoryTagEntity);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    public void deleteAllData() {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfDeleteAllData.acquire();
        try {
            this.__db.beginTransaction();
            acquire.k();
            this.__db.setTransactionSuccessful();
            this.__db.endTransaction();
            this.__preparedStmtOfDeleteAllData.release(acquire);
        } catch (Throwable th) {
            this.__preparedStmtOfDeleteAllData.release(acquire);
            throw th;
        }
    }

    public List<RecordContentHistoryTagEntity> findAllRecordPersonEntity(String str) {
        RoomSQLiteQuery c = RoomSQLiteQuery.c("SELECT * FROM RecordContentHistoryTagEntity  where  accountId = ?", 1);
        c.B(1, str);
        this.__db.assertNotSuspendingTransaction();
        Cursor c2 = DBUtil.c(this.__db, c, false, (CancellationSignal) null);
        try {
            int d = CursorUtil.d(c2, "contentTagId");
            int d2 = CursorUtil.d(c2, "contentName");
            int d3 = CursorUtil.d(c2, "createTime");
            int d4 = CursorUtil.d(c2, "accountId");
            ArrayList arrayList = new ArrayList(c2.getCount());
            while (c2.moveToNext()) {
                arrayList.add(new RecordContentHistoryTagEntity(c2.getLong(d), c2.isNull(d2) ? null : c2.getString(d2), c2.getLong(d3), c2.getString(d4)));
            }
            return arrayList;
        } finally {
            c2.close();
            c.release();
        }
    }

    public List<RecordContentHistoryTagEntity> findAllTagData(String str) {
        RoomSQLiteQuery c = RoomSQLiteQuery.c("SELECT * FROM RecordContentHistoryTagEntity where  accountId = ? ORDER BY createTime DESC", 1);
        c.B(1, str);
        this.__db.assertNotSuspendingTransaction();
        Cursor c2 = DBUtil.c(this.__db, c, false, (CancellationSignal) null);
        try {
            int d = CursorUtil.d(c2, "contentTagId");
            int d2 = CursorUtil.d(c2, "contentName");
            int d3 = CursorUtil.d(c2, "createTime");
            int d4 = CursorUtil.d(c2, "accountId");
            ArrayList arrayList = new ArrayList(c2.getCount());
            while (c2.moveToNext()) {
                arrayList.add(new RecordContentHistoryTagEntity(c2.getLong(d), c2.isNull(d2) ? null : c2.getString(d2), c2.getLong(d3), c2.getString(d4)));
            }
            return arrayList;
        } finally {
            c2.close();
            c.release();
        }
    }

    public void insert(RecordContentHistoryTagEntity recordContentHistoryTagEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfRecordContentHistoryTagEntity.insert(recordContentHistoryTagEntity);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    public void update(RecordContentHistoryTagEntity recordContentHistoryTagEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__updateAdapterOfRecordContentHistoryTagEntity.handle(recordContentHistoryTagEntity);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }
}
