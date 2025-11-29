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

public final class FastRecordVoiceDao_Impl implements FastRecordVoiceDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<RecordVoiceEntity> __deletionAdapterOfRecordVoiceEntity;
    private final EntityInsertionAdapter<RecordVoiceEntity> __insertionAdapterOfRecordVoiceEntity;
    private final SharedSQLiteStatement __preparedStmtOfDeleteAllData;
    private final SharedSQLiteStatement __preparedStmtOfDeleteByIdAndRole;
    private final SharedSQLiteStatement __preparedStmtOfDeleteByRecordId;
    private final EntityDeletionOrUpdateAdapter<RecordVoiceEntity> __updateAdapterOfRecordVoiceEntity;

    public FastRecordVoiceDao_Impl(@NonNull RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfRecordVoiceEntity = new EntityInsertionAdapter<RecordVoiceEntity>(roomDatabase) {
            @NonNull
            public String createQuery() {
                return "INSERT OR REPLACE INTO `RecordVoiceEntity` (`recordVoiceId`,`userId`,`recordId`,`cacheFileDir`,`cachePcmFilePath`,`cacheOPlusFilePath`,`startTag`,`endTag`,`tagInfo`,`role`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?)";
            }

            public void bind(@NonNull SupportSQLiteStatement supportSQLiteStatement, @NonNull RecordVoiceEntity recordVoiceEntity) {
                supportSQLiteStatement.F(1, recordVoiceEntity.getRecordVoiceId());
                if (recordVoiceEntity.getUserId() == null) {
                    supportSQLiteStatement.L(2);
                } else {
                    supportSQLiteStatement.B(2, recordVoiceEntity.getUserId());
                }
                supportSQLiteStatement.F(3, recordVoiceEntity.getRecordId());
                if (recordVoiceEntity.getCacheFileDir() == null) {
                    supportSQLiteStatement.L(4);
                } else {
                    supportSQLiteStatement.B(4, recordVoiceEntity.getCacheFileDir());
                }
                if (recordVoiceEntity.getCachePcmFilePath() == null) {
                    supportSQLiteStatement.L(5);
                } else {
                    supportSQLiteStatement.B(5, recordVoiceEntity.getCachePcmFilePath());
                }
                if (recordVoiceEntity.getCacheOPlusFilePath() == null) {
                    supportSQLiteStatement.L(6);
                } else {
                    supportSQLiteStatement.B(6, recordVoiceEntity.getCacheOPlusFilePath());
                }
                supportSQLiteStatement.F(7, recordVoiceEntity.getStartTag());
                supportSQLiteStatement.F(8, recordVoiceEntity.getEndTag());
                if (recordVoiceEntity.getTagInfo() == null) {
                    supportSQLiteStatement.L(9);
                } else {
                    supportSQLiteStatement.B(9, recordVoiceEntity.getTagInfo());
                }
                if (recordVoiceEntity.getRole() == null) {
                    supportSQLiteStatement.L(10);
                } else {
                    supportSQLiteStatement.B(10, recordVoiceEntity.getRole());
                }
            }
        };
        this.__deletionAdapterOfRecordVoiceEntity = new EntityDeletionOrUpdateAdapter<RecordVoiceEntity>(roomDatabase) {
            @NonNull
            public String createQuery() {
                return "DELETE FROM `RecordVoiceEntity` WHERE `recordVoiceId` = ?";
            }

            public void bind(@NonNull SupportSQLiteStatement supportSQLiteStatement, @NonNull RecordVoiceEntity recordVoiceEntity) {
                supportSQLiteStatement.F(1, recordVoiceEntity.getRecordVoiceId());
            }
        };
        this.__updateAdapterOfRecordVoiceEntity = new EntityDeletionOrUpdateAdapter<RecordVoiceEntity>(roomDatabase) {
            @NonNull
            public String createQuery() {
                return "UPDATE OR ABORT `RecordVoiceEntity` SET `recordVoiceId` = ?,`userId` = ?,`recordId` = ?,`cacheFileDir` = ?,`cachePcmFilePath` = ?,`cacheOPlusFilePath` = ?,`startTag` = ?,`endTag` = ?,`tagInfo` = ?,`role` = ? WHERE `recordVoiceId` = ?";
            }

            public void bind(@NonNull SupportSQLiteStatement supportSQLiteStatement, @NonNull RecordVoiceEntity recordVoiceEntity) {
                supportSQLiteStatement.F(1, recordVoiceEntity.getRecordVoiceId());
                if (recordVoiceEntity.getUserId() == null) {
                    supportSQLiteStatement.L(2);
                } else {
                    supportSQLiteStatement.B(2, recordVoiceEntity.getUserId());
                }
                supportSQLiteStatement.F(3, recordVoiceEntity.getRecordId());
                if (recordVoiceEntity.getCacheFileDir() == null) {
                    supportSQLiteStatement.L(4);
                } else {
                    supportSQLiteStatement.B(4, recordVoiceEntity.getCacheFileDir());
                }
                if (recordVoiceEntity.getCachePcmFilePath() == null) {
                    supportSQLiteStatement.L(5);
                } else {
                    supportSQLiteStatement.B(5, recordVoiceEntity.getCachePcmFilePath());
                }
                if (recordVoiceEntity.getCacheOPlusFilePath() == null) {
                    supportSQLiteStatement.L(6);
                } else {
                    supportSQLiteStatement.B(6, recordVoiceEntity.getCacheOPlusFilePath());
                }
                supportSQLiteStatement.F(7, recordVoiceEntity.getStartTag());
                supportSQLiteStatement.F(8, recordVoiceEntity.getEndTag());
                if (recordVoiceEntity.getTagInfo() == null) {
                    supportSQLiteStatement.L(9);
                } else {
                    supportSQLiteStatement.B(9, recordVoiceEntity.getTagInfo());
                }
                if (recordVoiceEntity.getRole() == null) {
                    supportSQLiteStatement.L(10);
                } else {
                    supportSQLiteStatement.B(10, recordVoiceEntity.getRole());
                }
                supportSQLiteStatement.F(11, recordVoiceEntity.getRecordVoiceId());
            }
        };
        this.__preparedStmtOfDeleteByRecordId = new SharedSQLiteStatement(roomDatabase) {
            @NonNull
            public String createQuery() {
                return "DELETE FROM RecordVoiceEntity where recordId=?";
            }
        };
        this.__preparedStmtOfDeleteByIdAndRole = new SharedSQLiteStatement(roomDatabase) {
            @NonNull
            public String createQuery() {
                return "DELETE FROM RecordVoiceEntity where recordId=? AND  role=?";
            }
        };
        this.__preparedStmtOfDeleteAllData = new SharedSQLiteStatement(roomDatabase) {
            @NonNull
            public String createQuery() {
                return "DELETE  FROM RecordVoiceEntity";
            }
        };
    }

    @NonNull
    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    public void delete(RecordVoiceEntity recordVoiceEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__deletionAdapterOfRecordVoiceEntity.handle(recordVoiceEntity);
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

    public void deleteByIdAndRole(long j, String str) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfDeleteByIdAndRole.acquire();
        acquire.F(1, j);
        acquire.B(2, str);
        try {
            this.__db.beginTransaction();
            acquire.k();
            this.__db.setTransactionSuccessful();
            this.__db.endTransaction();
            this.__preparedStmtOfDeleteByIdAndRole.release(acquire);
        } catch (Throwable th) {
            this.__preparedStmtOfDeleteByIdAndRole.release(acquire);
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

    public List<RecordVoiceEntity> findAllRecordEntity() {
        RoomSQLiteQuery c = RoomSQLiteQuery.c("SELECT * FROM RecordVoiceEntity", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor c2 = DBUtil.c(this.__db, c, false, (CancellationSignal) null);
        try {
            int d = CursorUtil.d(c2, "recordVoiceId");
            int d2 = CursorUtil.d(c2, "userId");
            int d3 = CursorUtil.d(c2, "recordId");
            int d4 = CursorUtil.d(c2, "cacheFileDir");
            int d5 = CursorUtil.d(c2, "cachePcmFilePath");
            int d6 = CursorUtil.d(c2, "cacheOPlusFilePath");
            int d7 = CursorUtil.d(c2, "startTag");
            int d8 = CursorUtil.d(c2, "endTag");
            int d9 = CursorUtil.d(c2, "tagInfo");
            int d10 = CursorUtil.d(c2, "role");
            ArrayList arrayList = new ArrayList(c2.getCount());
            while (c2.moveToNext()) {
                arrayList.add(new RecordVoiceEntity(c2.getLong(d), c2.isNull(d2) ? null : c2.getString(d2), c2.getLong(d3), c2.isNull(d4) ? null : c2.getString(d4), c2.isNull(d5) ? null : c2.getString(d5), c2.isNull(d6) ? null : c2.getString(d6), c2.getLong(d7), c2.getLong(d8), c2.isNull(d9) ? null : c2.getString(d9), c2.isNull(d10) ? null : c2.getString(d10)));
            }
            return arrayList;
        } finally {
            c2.close();
            c.release();
        }
    }

    public List<RecordVoiceEntity> findVoiceEntityByIdAndRoleAsc(long j, String str) {
        RoomSQLiteQuery c = RoomSQLiteQuery.c("SELECT * FROM RecordVoiceEntity where recordId=? AND  role=? ORDER BY startTag ASC", 2);
        c.F(1, j);
        c.B(2, str);
        this.__db.assertNotSuspendingTransaction();
        Cursor c2 = DBUtil.c(this.__db, c, false, (CancellationSignal) null);
        try {
            int d = CursorUtil.d(c2, "recordVoiceId");
            int d2 = CursorUtil.d(c2, "userId");
            int d3 = CursorUtil.d(c2, "recordId");
            int d4 = CursorUtil.d(c2, "cacheFileDir");
            int d5 = CursorUtil.d(c2, "cachePcmFilePath");
            int d6 = CursorUtil.d(c2, "cacheOPlusFilePath");
            int d7 = CursorUtil.d(c2, "startTag");
            int d8 = CursorUtil.d(c2, "endTag");
            int d9 = CursorUtil.d(c2, "tagInfo");
            int d10 = CursorUtil.d(c2, "role");
            ArrayList arrayList = new ArrayList(c2.getCount());
            while (c2.moveToNext()) {
                arrayList.add(new RecordVoiceEntity(c2.getLong(d), c2.isNull(d2) ? null : c2.getString(d2), c2.getLong(d3), c2.isNull(d4) ? null : c2.getString(d4), c2.isNull(d5) ? null : c2.getString(d5), c2.isNull(d6) ? null : c2.getString(d6), c2.getLong(d7), c2.getLong(d8), c2.isNull(d9) ? null : c2.getString(d9), c2.isNull(d10) ? null : c2.getString(d10)));
            }
            return arrayList;
        } finally {
            c2.close();
            c.release();
        }
    }

    public List<RecordVoiceEntity> findVoiceEntityByRecordId(long j) {
        RoomSQLiteQuery c = RoomSQLiteQuery.c("SELECT * FROM RecordVoiceEntity where recordId=?", 1);
        c.F(1, j);
        this.__db.assertNotSuspendingTransaction();
        Cursor c2 = DBUtil.c(this.__db, c, false, (CancellationSignal) null);
        try {
            int d = CursorUtil.d(c2, "recordVoiceId");
            int d2 = CursorUtil.d(c2, "userId");
            int d3 = CursorUtil.d(c2, "recordId");
            int d4 = CursorUtil.d(c2, "cacheFileDir");
            int d5 = CursorUtil.d(c2, "cachePcmFilePath");
            int d6 = CursorUtil.d(c2, "cacheOPlusFilePath");
            int d7 = CursorUtil.d(c2, "startTag");
            int d8 = CursorUtil.d(c2, "endTag");
            int d9 = CursorUtil.d(c2, "tagInfo");
            int d10 = CursorUtil.d(c2, "role");
            ArrayList arrayList = new ArrayList(c2.getCount());
            while (c2.moveToNext()) {
                arrayList.add(new RecordVoiceEntity(c2.getLong(d), c2.isNull(d2) ? null : c2.getString(d2), c2.getLong(d3), c2.isNull(d4) ? null : c2.getString(d4), c2.isNull(d5) ? null : c2.getString(d5), c2.isNull(d6) ? null : c2.getString(d6), c2.getLong(d7), c2.getLong(d8), c2.isNull(d9) ? null : c2.getString(d9), c2.isNull(d10) ? null : c2.getString(d10)));
            }
            return arrayList;
        } finally {
            c2.close();
            c.release();
        }
    }

    public void insert(RecordVoiceEntity recordVoiceEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfRecordVoiceEntity.insert(recordVoiceEntity);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    public void update(RecordVoiceEntity recordVoiceEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__updateAdapterOfRecordVoiceEntity.handle(recordVoiceEntity);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }
}
