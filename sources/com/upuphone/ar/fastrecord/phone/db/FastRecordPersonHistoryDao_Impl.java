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

public final class FastRecordPersonHistoryDao_Impl implements FastRecordPersonHistoryDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<RecordHistoryPersonEntity> __deletionAdapterOfRecordHistoryPersonEntity;
    private final EntityInsertionAdapter<RecordHistoryPersonEntity> __insertionAdapterOfRecordHistoryPersonEntity;
    private final SharedSQLiteStatement __preparedStmtOfDeleteAllData;
    private final EntityDeletionOrUpdateAdapter<RecordHistoryPersonEntity> __updateAdapterOfRecordHistoryPersonEntity;

    public FastRecordPersonHistoryDao_Impl(@NonNull RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfRecordHistoryPersonEntity = new EntityInsertionAdapter<RecordHistoryPersonEntity>(roomDatabase) {
            @NonNull
            public String createQuery() {
                return "INSERT OR REPLACE INTO `RecordHistoryPersonEntity` (`personTagId`,`personName`,`createTime`,`accountId`) VALUES (nullif(?, 0),?,?,?)";
            }

            public void bind(@NonNull SupportSQLiteStatement supportSQLiteStatement, @NonNull RecordHistoryPersonEntity recordHistoryPersonEntity) {
                supportSQLiteStatement.F(1, recordHistoryPersonEntity.getPersonTagId());
                if (recordHistoryPersonEntity.getPersonName() == null) {
                    supportSQLiteStatement.L(2);
                } else {
                    supportSQLiteStatement.B(2, recordHistoryPersonEntity.getPersonName());
                }
                supportSQLiteStatement.F(3, recordHistoryPersonEntity.getCreateTime());
                supportSQLiteStatement.B(4, recordHistoryPersonEntity.getAccountId());
            }
        };
        this.__deletionAdapterOfRecordHistoryPersonEntity = new EntityDeletionOrUpdateAdapter<RecordHistoryPersonEntity>(roomDatabase) {
            @NonNull
            public String createQuery() {
                return "DELETE FROM `RecordHistoryPersonEntity` WHERE `personTagId` = ?";
            }

            public void bind(@NonNull SupportSQLiteStatement supportSQLiteStatement, @NonNull RecordHistoryPersonEntity recordHistoryPersonEntity) {
                supportSQLiteStatement.F(1, recordHistoryPersonEntity.getPersonTagId());
            }
        };
        this.__updateAdapterOfRecordHistoryPersonEntity = new EntityDeletionOrUpdateAdapter<RecordHistoryPersonEntity>(roomDatabase) {
            @NonNull
            public String createQuery() {
                return "UPDATE OR ABORT `RecordHistoryPersonEntity` SET `personTagId` = ?,`personName` = ?,`createTime` = ?,`accountId` = ? WHERE `personTagId` = ?";
            }

            public void bind(@NonNull SupportSQLiteStatement supportSQLiteStatement, @NonNull RecordHistoryPersonEntity recordHistoryPersonEntity) {
                supportSQLiteStatement.F(1, recordHistoryPersonEntity.getPersonTagId());
                if (recordHistoryPersonEntity.getPersonName() == null) {
                    supportSQLiteStatement.L(2);
                } else {
                    supportSQLiteStatement.B(2, recordHistoryPersonEntity.getPersonName());
                }
                supportSQLiteStatement.F(3, recordHistoryPersonEntity.getCreateTime());
                supportSQLiteStatement.B(4, recordHistoryPersonEntity.getAccountId());
                supportSQLiteStatement.F(5, recordHistoryPersonEntity.getPersonTagId());
            }
        };
        this.__preparedStmtOfDeleteAllData = new SharedSQLiteStatement(roomDatabase) {
            @NonNull
            public String createQuery() {
                return "DELETE  FROM RecordHistoryPersonEntity";
            }
        };
    }

    @NonNull
    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    public void delete(RecordHistoryPersonEntity recordHistoryPersonEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__deletionAdapterOfRecordHistoryPersonEntity.handle(recordHistoryPersonEntity);
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

    public List<RecordHistoryPersonEntity> findAllRecordPersonEntity(String str) {
        RoomSQLiteQuery c = RoomSQLiteQuery.c("SELECT * FROM RecordHistoryPersonEntity  where accountId = ? ORDER BY createTime DESC", 1);
        c.B(1, str);
        this.__db.assertNotSuspendingTransaction();
        Cursor c2 = DBUtil.c(this.__db, c, false, (CancellationSignal) null);
        try {
            int d = CursorUtil.d(c2, "personTagId");
            int d2 = CursorUtil.d(c2, "personName");
            int d3 = CursorUtil.d(c2, "createTime");
            int d4 = CursorUtil.d(c2, "accountId");
            ArrayList arrayList = new ArrayList(c2.getCount());
            while (c2.moveToNext()) {
                arrayList.add(new RecordHistoryPersonEntity(c2.getLong(d), c2.isNull(d2) ? null : c2.getString(d2), c2.getLong(d3), c2.getString(d4)));
            }
            return arrayList;
        } finally {
            c2.close();
            c.release();
        }
    }

    public void insert(RecordHistoryPersonEntity recordHistoryPersonEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfRecordHistoryPersonEntity.insert(recordHistoryPersonEntity);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    public void update(RecordHistoryPersonEntity recordHistoryPersonEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__updateAdapterOfRecordHistoryPersonEntity.handle(recordHistoryPersonEntity);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }
}
