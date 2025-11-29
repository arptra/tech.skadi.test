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

public final class FastRecordTagDao_Impl implements FastRecordTagDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<RecordContentTagEntity> __deletionAdapterOfRecordContentTagEntity;
    private final EntityInsertionAdapter<RecordContentTagEntity> __insertionAdapterOfRecordContentTagEntity;
    private final SharedSQLiteStatement __preparedStmtOfDeleteAllData;
    private final SharedSQLiteStatement __preparedStmtOfDeleteAllNormalTag;
    private final SharedSQLiteStatement __preparedStmtOfDeleteAllNormalTagByContentName;
    private final SharedSQLiteStatement __preparedStmtOfDeleteByRecordId;
    private final SharedSQLiteStatement __preparedStmtOfDeleteNormalContentTag;
    private final EntityDeletionOrUpdateAdapter<RecordContentTagEntity> __updateAdapterOfRecordContentTagEntity;

    public FastRecordTagDao_Impl(@NonNull RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfRecordContentTagEntity = new EntityInsertionAdapter<RecordContentTagEntity>(roomDatabase) {
            @NonNull
            public String createQuery() {
                return "INSERT OR REPLACE INTO `RecordContentTagEntity` (`contentTagId`,`recordId`,`contentName`,`createTime`,`accountId`) VALUES (nullif(?, 0),?,?,?,?)";
            }

            public void bind(@NonNull SupportSQLiteStatement supportSQLiteStatement, @NonNull RecordContentTagEntity recordContentTagEntity) {
                supportSQLiteStatement.F(1, recordContentTagEntity.getContentTagId());
                supportSQLiteStatement.F(2, recordContentTagEntity.getRecordId());
                if (recordContentTagEntity.getContentName() == null) {
                    supportSQLiteStatement.L(3);
                } else {
                    supportSQLiteStatement.B(3, recordContentTagEntity.getContentName());
                }
                supportSQLiteStatement.F(4, recordContentTagEntity.getCreateTime());
                supportSQLiteStatement.B(5, recordContentTagEntity.getAccountId());
            }
        };
        this.__deletionAdapterOfRecordContentTagEntity = new EntityDeletionOrUpdateAdapter<RecordContentTagEntity>(roomDatabase) {
            @NonNull
            public String createQuery() {
                return "DELETE FROM `RecordContentTagEntity` WHERE `contentTagId` = ?";
            }

            public void bind(@NonNull SupportSQLiteStatement supportSQLiteStatement, @NonNull RecordContentTagEntity recordContentTagEntity) {
                supportSQLiteStatement.F(1, recordContentTagEntity.getContentTagId());
            }
        };
        this.__updateAdapterOfRecordContentTagEntity = new EntityDeletionOrUpdateAdapter<RecordContentTagEntity>(roomDatabase) {
            @NonNull
            public String createQuery() {
                return "UPDATE OR ABORT `RecordContentTagEntity` SET `contentTagId` = ?,`recordId` = ?,`contentName` = ?,`createTime` = ?,`accountId` = ? WHERE `contentTagId` = ?";
            }

            public void bind(@NonNull SupportSQLiteStatement supportSQLiteStatement, @NonNull RecordContentTagEntity recordContentTagEntity) {
                supportSQLiteStatement.F(1, recordContentTagEntity.getContentTagId());
                supportSQLiteStatement.F(2, recordContentTagEntity.getRecordId());
                if (recordContentTagEntity.getContentName() == null) {
                    supportSQLiteStatement.L(3);
                } else {
                    supportSQLiteStatement.B(3, recordContentTagEntity.getContentName());
                }
                supportSQLiteStatement.F(4, recordContentTagEntity.getCreateTime());
                supportSQLiteStatement.B(5, recordContentTagEntity.getAccountId());
                supportSQLiteStatement.F(6, recordContentTagEntity.getContentTagId());
            }
        };
        this.__preparedStmtOfDeleteByRecordId = new SharedSQLiteStatement(roomDatabase) {
            @NonNull
            public String createQuery() {
                return "DELETE FROM RecordContentTagEntity where recordId=?";
            }
        };
        this.__preparedStmtOfDeleteNormalContentTag = new SharedSQLiteStatement(roomDatabase) {
            @NonNull
            public String createQuery() {
                return "DELETE FROM RecordContentTagEntity where recordId=? AND contentName=? ";
            }
        };
        this.__preparedStmtOfDeleteAllNormalTag = new SharedSQLiteStatement(roomDatabase) {
            @NonNull
            public String createQuery() {
                return "DELETE FROM RecordContentTagEntity where recordId=? ";
            }
        };
        this.__preparedStmtOfDeleteAllData = new SharedSQLiteStatement(roomDatabase) {
            @NonNull
            public String createQuery() {
                return "DELETE  FROM RecordContentTagEntity";
            }
        };
        this.__preparedStmtOfDeleteAllNormalTagByContentName = new SharedSQLiteStatement(roomDatabase) {
            @NonNull
            public String createQuery() {
                return "DELETE FROM RecordContentTagEntity where  accountId=? AND contentName =?";
            }
        };
    }

    @NonNull
    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    public void delete(RecordContentTagEntity recordContentTagEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__deletionAdapterOfRecordContentTagEntity.handle(recordContentTagEntity);
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

    public void deleteAllNormalTag(long j) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfDeleteAllNormalTag.acquire();
        acquire.F(1, j);
        try {
            this.__db.beginTransaction();
            acquire.k();
            this.__db.setTransactionSuccessful();
            this.__db.endTransaction();
            this.__preparedStmtOfDeleteAllNormalTag.release(acquire);
        } catch (Throwable th) {
            this.__preparedStmtOfDeleteAllNormalTag.release(acquire);
            throw th;
        }
    }

    public void deleteAllNormalTagByContentName(String str, String str2) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfDeleteAllNormalTagByContentName.acquire();
        acquire.B(1, str);
        acquire.B(2, str2);
        try {
            this.__db.beginTransaction();
            acquire.k();
            this.__db.setTransactionSuccessful();
            this.__db.endTransaction();
            this.__preparedStmtOfDeleteAllNormalTagByContentName.release(acquire);
        } catch (Throwable th) {
            this.__preparedStmtOfDeleteAllNormalTagByContentName.release(acquire);
            throw th;
        }
    }

    public void deleteByRecordId(long j) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfDeleteByRecordId.acquire();
        acquire.F(1, j);
        try {
            this.__db.beginTransaction();
            acquire.k();
            this.__db.setTransactionSuccessful();
            this.__db.endTransaction();
            this.__preparedStmtOfDeleteByRecordId.release(acquire);
        } catch (Throwable th) {
            this.__preparedStmtOfDeleteByRecordId.release(acquire);
            throw th;
        }
    }

    public void deleteNormalContentTag(String str, long j) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfDeleteNormalContentTag.acquire();
        acquire.F(1, j);
        acquire.B(2, str);
        try {
            this.__db.beginTransaction();
            acquire.k();
            this.__db.setTransactionSuccessful();
            this.__db.endTransaction();
            this.__preparedStmtOfDeleteNormalContentTag.release(acquire);
        } catch (Throwable th) {
            this.__preparedStmtOfDeleteNormalContentTag.release(acquire);
            throw th;
        }
    }

    public List<RecordContentTagEntity> findAllRecordPersonEntity(String str) {
        RoomSQLiteQuery c = RoomSQLiteQuery.c("SELECT * FROM RecordContentTagEntity where accountId = ?", 1);
        c.B(1, str);
        this.__db.assertNotSuspendingTransaction();
        Cursor c2 = DBUtil.c(this.__db, c, false, (CancellationSignal) null);
        try {
            int d = CursorUtil.d(c2, "contentTagId");
            int d2 = CursorUtil.d(c2, "recordId");
            int d3 = CursorUtil.d(c2, "contentName");
            int d4 = CursorUtil.d(c2, "createTime");
            int d5 = CursorUtil.d(c2, "accountId");
            ArrayList arrayList = new ArrayList(c2.getCount());
            while (c2.moveToNext()) {
                RecordContentTagEntity recordContentTagEntity = new RecordContentTagEntity();
                recordContentTagEntity.setContentTagId(c2.getLong(d));
                recordContentTagEntity.setRecordId(c2.getLong(d2));
                recordContentTagEntity.setContentName(c2.isNull(d3) ? null : c2.getString(d3));
                recordContentTagEntity.setCreateTime(c2.getLong(d4));
                recordContentTagEntity.setAccountId(c2.getString(d5));
                arrayList.add(recordContentTagEntity);
            }
            return arrayList;
        } finally {
            c2.close();
            c.release();
        }
    }

    public List<RecordContentTagEntity> findAllTagData(String str) {
        RoomSQLiteQuery c = RoomSQLiteQuery.c("SELECT * FROM RecordContentTagEntity where accountId = ?", 1);
        c.B(1, str);
        this.__db.assertNotSuspendingTransaction();
        Cursor c2 = DBUtil.c(this.__db, c, false, (CancellationSignal) null);
        try {
            int d = CursorUtil.d(c2, "contentTagId");
            int d2 = CursorUtil.d(c2, "recordId");
            int d3 = CursorUtil.d(c2, "contentName");
            int d4 = CursorUtil.d(c2, "createTime");
            int d5 = CursorUtil.d(c2, "accountId");
            ArrayList arrayList = new ArrayList(c2.getCount());
            while (c2.moveToNext()) {
                RecordContentTagEntity recordContentTagEntity = new RecordContentTagEntity();
                recordContentTagEntity.setContentTagId(c2.getLong(d));
                recordContentTagEntity.setRecordId(c2.getLong(d2));
                recordContentTagEntity.setContentName(c2.isNull(d3) ? null : c2.getString(d3));
                recordContentTagEntity.setCreateTime(c2.getLong(d4));
                recordContentTagEntity.setAccountId(c2.getString(d5));
                arrayList.add(recordContentTagEntity);
            }
            return arrayList;
        } finally {
            c2.close();
            c.release();
        }
    }

    public List<RecordContentTagEntity> findNormalTagEntityByRecord(long j, String str) {
        RoomSQLiteQuery c = RoomSQLiteQuery.c("SELECT * FROM RecordContentTagEntity where recordId=?  AND accountId = ?  ORDER BY createTime ASC", 2);
        c.F(1, j);
        c.B(2, str);
        this.__db.assertNotSuspendingTransaction();
        Cursor c2 = DBUtil.c(this.__db, c, false, (CancellationSignal) null);
        try {
            int d = CursorUtil.d(c2, "contentTagId");
            int d2 = CursorUtil.d(c2, "recordId");
            int d3 = CursorUtil.d(c2, "contentName");
            int d4 = CursorUtil.d(c2, "createTime");
            int d5 = CursorUtil.d(c2, "accountId");
            ArrayList arrayList = new ArrayList(c2.getCount());
            while (c2.moveToNext()) {
                RecordContentTagEntity recordContentTagEntity = new RecordContentTagEntity();
                recordContentTagEntity.setContentTagId(c2.getLong(d));
                recordContentTagEntity.setRecordId(c2.getLong(d2));
                recordContentTagEntity.setContentName(c2.isNull(d3) ? null : c2.getString(d3));
                recordContentTagEntity.setCreateTime(c2.getLong(d4));
                recordContentTagEntity.setAccountId(c2.getString(d5));
                arrayList.add(recordContentTagEntity);
            }
            return arrayList;
        } finally {
            c2.close();
            c.release();
        }
    }

    public List<RecordContentTagEntity> findTagEntityByRecord(long j, String str) {
        RoomSQLiteQuery c = RoomSQLiteQuery.c("SELECT * FROM RecordContentTagEntity where recordId=? AND accountId = ?", 2);
        c.F(1, j);
        c.B(2, str);
        this.__db.assertNotSuspendingTransaction();
        Cursor c2 = DBUtil.c(this.__db, c, false, (CancellationSignal) null);
        try {
            int d = CursorUtil.d(c2, "contentTagId");
            int d2 = CursorUtil.d(c2, "recordId");
            int d3 = CursorUtil.d(c2, "contentName");
            int d4 = CursorUtil.d(c2, "createTime");
            int d5 = CursorUtil.d(c2, "accountId");
            ArrayList arrayList = new ArrayList(c2.getCount());
            while (c2.moveToNext()) {
                RecordContentTagEntity recordContentTagEntity = new RecordContentTagEntity();
                recordContentTagEntity.setContentTagId(c2.getLong(d));
                recordContentTagEntity.setRecordId(c2.getLong(d2));
                recordContentTagEntity.setContentName(c2.isNull(d3) ? null : c2.getString(d3));
                recordContentTagEntity.setCreateTime(c2.getLong(d4));
                recordContentTagEntity.setAccountId(c2.getString(d5));
                arrayList.add(recordContentTagEntity);
            }
            return arrayList;
        } finally {
            c2.close();
            c.release();
        }
    }

    public void insert(RecordContentTagEntity recordContentTagEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfRecordContentTagEntity.insert(recordContentTagEntity);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    public void update(RecordContentTagEntity recordContentTagEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__updateAdapterOfRecordContentTagEntity.handle(recordContentTagEntity);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }
}
