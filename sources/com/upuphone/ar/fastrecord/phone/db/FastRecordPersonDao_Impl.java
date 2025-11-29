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

public final class FastRecordPersonDao_Impl implements FastRecordPersonDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<RecordPersonEntity> __deletionAdapterOfRecordPersonEntity;
    private final EntityInsertionAdapter<RecordPersonEntity> __insertionAdapterOfRecordPersonEntity;
    private final SharedSQLiteStatement __preparedStmtOfDeleteAllData;
    private final SharedSQLiteStatement __preparedStmtOfDeleteAllNormalTag;
    private final SharedSQLiteStatement __preparedStmtOfDeleteAllNormalTagByPersonName;
    private final SharedSQLiteStatement __preparedStmtOfDeleteByRecordId;
    private final SharedSQLiteStatement __preparedStmtOfDeleteNormalTagByContent;
    private final EntityDeletionOrUpdateAdapter<RecordPersonEntity> __updateAdapterOfRecordPersonEntity;

    public FastRecordPersonDao_Impl(@NonNull RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfRecordPersonEntity = new EntityInsertionAdapter<RecordPersonEntity>(roomDatabase) {
            @NonNull
            public String createQuery() {
                return "INSERT OR REPLACE INTO `RecordPersonEntity` (`personTagId`,`recordId`,`personName`,`personType`,`createTime`,`accountId`) VALUES (nullif(?, 0),?,?,?,?,?)";
            }

            public void bind(@NonNull SupportSQLiteStatement supportSQLiteStatement, @NonNull RecordPersonEntity recordPersonEntity) {
                supportSQLiteStatement.F(1, recordPersonEntity.getPersonTagId());
                supportSQLiteStatement.F(2, recordPersonEntity.getRecordId());
                if (recordPersonEntity.getPersonName() == null) {
                    supportSQLiteStatement.L(3);
                } else {
                    supportSQLiteStatement.B(3, recordPersonEntity.getPersonName());
                }
                supportSQLiteStatement.B(4, recordPersonEntity.getPersonType());
                supportSQLiteStatement.F(5, recordPersonEntity.getCreateTime());
                supportSQLiteStatement.B(6, recordPersonEntity.getAccountId());
            }
        };
        this.__deletionAdapterOfRecordPersonEntity = new EntityDeletionOrUpdateAdapter<RecordPersonEntity>(roomDatabase) {
            @NonNull
            public String createQuery() {
                return "DELETE FROM `RecordPersonEntity` WHERE `personTagId` = ?";
            }

            public void bind(@NonNull SupportSQLiteStatement supportSQLiteStatement, @NonNull RecordPersonEntity recordPersonEntity) {
                supportSQLiteStatement.F(1, recordPersonEntity.getPersonTagId());
            }
        };
        this.__updateAdapterOfRecordPersonEntity = new EntityDeletionOrUpdateAdapter<RecordPersonEntity>(roomDatabase) {
            @NonNull
            public String createQuery() {
                return "UPDATE OR ABORT `RecordPersonEntity` SET `personTagId` = ?,`recordId` = ?,`personName` = ?,`personType` = ?,`createTime` = ?,`accountId` = ? WHERE `personTagId` = ?";
            }

            public void bind(@NonNull SupportSQLiteStatement supportSQLiteStatement, @NonNull RecordPersonEntity recordPersonEntity) {
                supportSQLiteStatement.F(1, recordPersonEntity.getPersonTagId());
                supportSQLiteStatement.F(2, recordPersonEntity.getRecordId());
                if (recordPersonEntity.getPersonName() == null) {
                    supportSQLiteStatement.L(3);
                } else {
                    supportSQLiteStatement.B(3, recordPersonEntity.getPersonName());
                }
                supportSQLiteStatement.B(4, recordPersonEntity.getPersonType());
                supportSQLiteStatement.F(5, recordPersonEntity.getCreateTime());
                supportSQLiteStatement.B(6, recordPersonEntity.getAccountId());
                supportSQLiteStatement.F(7, recordPersonEntity.getPersonTagId());
            }
        };
        this.__preparedStmtOfDeleteAllNormalTagByPersonName = new SharedSQLiteStatement(roomDatabase) {
            @NonNull
            public String createQuery() {
                return "DELETE FROM RecordPersonEntity where  accountId=? AND personName =?";
            }
        };
        this.__preparedStmtOfDeleteAllNormalTag = new SharedSQLiteStatement(roomDatabase) {
            @NonNull
            public String createQuery() {
                return "DELETE FROM RecordPersonEntity where  recordId=? AND personType =?";
            }
        };
        this.__preparedStmtOfDeleteNormalTagByContent = new SharedSQLiteStatement(roomDatabase) {
            @NonNull
            public String createQuery() {
                return "DELETE FROM RecordPersonEntity where  recordId=? AND  personName=? ";
            }
        };
        this.__preparedStmtOfDeleteByRecordId = new SharedSQLiteStatement(roomDatabase) {
            @NonNull
            public String createQuery() {
                return "DELETE FROM RecordPersonEntity where recordId=?";
            }
        };
        this.__preparedStmtOfDeleteAllData = new SharedSQLiteStatement(roomDatabase) {
            @NonNull
            public String createQuery() {
                return "DELETE  FROM RecordPersonEntity";
            }
        };
    }

    @NonNull
    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    public void delete(RecordPersonEntity recordPersonEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__deletionAdapterOfRecordPersonEntity.handle(recordPersonEntity);
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

    public void deleteAllNormalTag(long j, String str) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfDeleteAllNormalTag.acquire();
        acquire.F(1, j);
        acquire.B(2, str);
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

    public void deleteAllNormalTagByPersonName(String str, String str2) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfDeleteAllNormalTagByPersonName.acquire();
        acquire.B(1, str);
        acquire.B(2, str2);
        try {
            this.__db.beginTransaction();
            acquire.k();
            this.__db.setTransactionSuccessful();
            this.__db.endTransaction();
            this.__preparedStmtOfDeleteAllNormalTagByPersonName.release(acquire);
        } catch (Throwable th) {
            this.__preparedStmtOfDeleteAllNormalTagByPersonName.release(acquire);
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

    public void deleteNormalTagByContent(String str, long j) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfDeleteNormalTagByContent.acquire();
        acquire.F(1, j);
        acquire.B(2, str);
        try {
            this.__db.beginTransaction();
            acquire.k();
            this.__db.setTransactionSuccessful();
            this.__db.endTransaction();
            this.__preparedStmtOfDeleteNormalTagByContent.release(acquire);
        } catch (Throwable th) {
            this.__preparedStmtOfDeleteNormalTagByContent.release(acquire);
            throw th;
        }
    }

    public List<RecordPersonEntity> findAllHistoryPersonWithOutSelf(long j, String str) {
        RoomSQLiteQuery c = RoomSQLiteQuery.c("SELECT * FROM RecordPersonEntity Where recordId != ?  AND accountId = ?  ORDER BY createTime DESC", 2);
        c.F(1, j);
        c.B(2, str);
        this.__db.assertNotSuspendingTransaction();
        Cursor c2 = DBUtil.c(this.__db, c, false, (CancellationSignal) null);
        try {
            int d = CursorUtil.d(c2, "personTagId");
            int d2 = CursorUtil.d(c2, "recordId");
            int d3 = CursorUtil.d(c2, "personName");
            int d4 = CursorUtil.d(c2, "personType");
            int d5 = CursorUtil.d(c2, "createTime");
            int d6 = CursorUtil.d(c2, "accountId");
            ArrayList arrayList = new ArrayList(c2.getCount());
            while (c2.moveToNext()) {
                RecordPersonEntity recordPersonEntity = new RecordPersonEntity();
                recordPersonEntity.setPersonTagId(c2.getLong(d));
                recordPersonEntity.setRecordId(c2.getLong(d2));
                recordPersonEntity.setPersonName(c2.isNull(d3) ? null : c2.getString(d3));
                recordPersonEntity.setPersonType(c2.getString(d4));
                recordPersonEntity.setCreateTime(c2.getLong(d5));
                recordPersonEntity.setAccountId(c2.getString(d6));
                arrayList.add(recordPersonEntity);
            }
            return arrayList;
        } finally {
            c2.close();
            c.release();
        }
    }

    public List<RecordPersonEntity> findAllNormalPersonByRecord(long j, String str) {
        RoomSQLiteQuery c = RoomSQLiteQuery.c("SELECT * FROM RecordPersonEntity where recordId=? AND accountId = ?  ORDER BY createTime ASC", 2);
        c.F(1, j);
        c.B(2, str);
        this.__db.assertNotSuspendingTransaction();
        Cursor c2 = DBUtil.c(this.__db, c, false, (CancellationSignal) null);
        try {
            int d = CursorUtil.d(c2, "personTagId");
            int d2 = CursorUtil.d(c2, "recordId");
            int d3 = CursorUtil.d(c2, "personName");
            int d4 = CursorUtil.d(c2, "personType");
            int d5 = CursorUtil.d(c2, "createTime");
            int d6 = CursorUtil.d(c2, "accountId");
            ArrayList arrayList = new ArrayList(c2.getCount());
            while (c2.moveToNext()) {
                RecordPersonEntity recordPersonEntity = new RecordPersonEntity();
                recordPersonEntity.setPersonTagId(c2.getLong(d));
                recordPersonEntity.setRecordId(c2.getLong(d2));
                recordPersonEntity.setPersonName(c2.isNull(d3) ? null : c2.getString(d3));
                recordPersonEntity.setPersonType(c2.getString(d4));
                recordPersonEntity.setCreateTime(c2.getLong(d5));
                recordPersonEntity.setAccountId(c2.getString(d6));
                arrayList.add(recordPersonEntity);
            }
            return arrayList;
        } finally {
            c2.close();
            c.release();
        }
    }

    public List<RecordPersonEntity> findAllRecordPersonEntity(String str) {
        RoomSQLiteQuery c = RoomSQLiteQuery.c("SELECT * FROM RecordPersonEntity Where accountId = ?", 1);
        c.B(1, str);
        this.__db.assertNotSuspendingTransaction();
        Cursor c2 = DBUtil.c(this.__db, c, false, (CancellationSignal) null);
        try {
            int d = CursorUtil.d(c2, "personTagId");
            int d2 = CursorUtil.d(c2, "recordId");
            int d3 = CursorUtil.d(c2, "personName");
            int d4 = CursorUtil.d(c2, "personType");
            int d5 = CursorUtil.d(c2, "createTime");
            int d6 = CursorUtil.d(c2, "accountId");
            ArrayList arrayList = new ArrayList(c2.getCount());
            while (c2.moveToNext()) {
                RecordPersonEntity recordPersonEntity = new RecordPersonEntity();
                recordPersonEntity.setPersonTagId(c2.getLong(d));
                recordPersonEntity.setRecordId(c2.getLong(d2));
                recordPersonEntity.setPersonName(c2.isNull(d3) ? null : c2.getString(d3));
                recordPersonEntity.setPersonType(c2.getString(d4));
                recordPersonEntity.setCreateTime(c2.getLong(d5));
                recordPersonEntity.setAccountId(c2.getString(d6));
                arrayList.add(recordPersonEntity);
            }
            return arrayList;
        } finally {
            c2.close();
            c.release();
        }
    }

    public List<RecordPersonEntity> findNormalPersonByRecord(long j, String str, String str2) {
        RoomSQLiteQuery c = RoomSQLiteQuery.c("SELECT * FROM RecordPersonEntity where recordId=? AND personType =? AND accountId = ?    ORDER BY createTime ASC", 3);
        c.F(1, j);
        c.B(2, str);
        c.B(3, str2);
        this.__db.assertNotSuspendingTransaction();
        Cursor c2 = DBUtil.c(this.__db, c, false, (CancellationSignal) null);
        try {
            int d = CursorUtil.d(c2, "personTagId");
            int d2 = CursorUtil.d(c2, "recordId");
            int d3 = CursorUtil.d(c2, "personName");
            int d4 = CursorUtil.d(c2, "personType");
            int d5 = CursorUtil.d(c2, "createTime");
            int d6 = CursorUtil.d(c2, "accountId");
            ArrayList arrayList = new ArrayList(c2.getCount());
            while (c2.moveToNext()) {
                RecordPersonEntity recordPersonEntity = new RecordPersonEntity();
                recordPersonEntity.setPersonTagId(c2.getLong(d));
                recordPersonEntity.setRecordId(c2.getLong(d2));
                recordPersonEntity.setPersonName(c2.isNull(d3) ? null : c2.getString(d3));
                recordPersonEntity.setPersonType(c2.getString(d4));
                recordPersonEntity.setCreateTime(c2.getLong(d5));
                recordPersonEntity.setAccountId(c2.getString(d6));
                arrayList.add(recordPersonEntity);
            }
            return arrayList;
        } finally {
            c2.close();
            c.release();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v3, resolved type: com.upuphone.ar.fastrecord.phone.db.RecordPersonEntity} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v4, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r9v2 */
    /* JADX WARNING: type inference failed for: r9v5 */
    /* JADX WARNING: type inference failed for: r9v7 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.upuphone.ar.fastrecord.phone.db.RecordPersonEntity findNormalPersonEntityByName(java.lang.String r8, long r9, java.lang.String r11) {
        /*
            r7 = this;
            java.lang.String r0 = "SELECT * FROM RecordPersonEntity where  recordId=? AND  personName=? AND accountId = ?"
            r1 = 3
            androidx.room.RoomSQLiteQuery r0 = androidx.room.RoomSQLiteQuery.c(r0, r1)
            r2 = 1
            r0.F(r2, r9)
            r9 = 2
            r0.B(r9, r8)
            r0.B(r1, r11)
            androidx.room.RoomDatabase r8 = r7.__db
            r8.assertNotSuspendingTransaction()
            androidx.room.RoomDatabase r7 = r7.__db
            r8 = 0
            r9 = 0
            android.database.Cursor r7 = androidx.room.util.DBUtil.c(r7, r0, r8, r9)
            java.lang.String r8 = "personTagId"
            int r8 = androidx.room.util.CursorUtil.d(r7, r8)     // Catch:{ all -> 0x0081 }
            java.lang.String r10 = "recordId"
            int r10 = androidx.room.util.CursorUtil.d(r7, r10)     // Catch:{ all -> 0x0081 }
            java.lang.String r11 = "personName"
            int r11 = androidx.room.util.CursorUtil.d(r7, r11)     // Catch:{ all -> 0x0081 }
            java.lang.String r1 = "personType"
            int r1 = androidx.room.util.CursorUtil.d(r7, r1)     // Catch:{ all -> 0x0081 }
            java.lang.String r2 = "createTime"
            int r2 = androidx.room.util.CursorUtil.d(r7, r2)     // Catch:{ all -> 0x0081 }
            java.lang.String r3 = "accountId"
            int r3 = androidx.room.util.CursorUtil.d(r7, r3)     // Catch:{ all -> 0x0081 }
            boolean r4 = r7.moveToFirst()     // Catch:{ all -> 0x0081 }
            if (r4 == 0) goto L_0x0083
            com.upuphone.ar.fastrecord.phone.db.RecordPersonEntity r4 = new com.upuphone.ar.fastrecord.phone.db.RecordPersonEntity     // Catch:{ all -> 0x0081 }
            r4.<init>()     // Catch:{ all -> 0x0081 }
            long r5 = r7.getLong(r8)     // Catch:{ all -> 0x0081 }
            r4.setPersonTagId(r5)     // Catch:{ all -> 0x0081 }
            long r5 = r7.getLong(r10)     // Catch:{ all -> 0x0081 }
            r4.setRecordId(r5)     // Catch:{ all -> 0x0081 }
            boolean r8 = r7.isNull(r11)     // Catch:{ all -> 0x0081 }
            if (r8 == 0) goto L_0x0063
            goto L_0x0067
        L_0x0063:
            java.lang.String r9 = r7.getString(r11)     // Catch:{ all -> 0x0081 }
        L_0x0067:
            r4.setPersonName(r9)     // Catch:{ all -> 0x0081 }
            java.lang.String r8 = r7.getString(r1)     // Catch:{ all -> 0x0081 }
            r4.setPersonType(r8)     // Catch:{ all -> 0x0081 }
            long r8 = r7.getLong(r2)     // Catch:{ all -> 0x0081 }
            r4.setCreateTime(r8)     // Catch:{ all -> 0x0081 }
            java.lang.String r8 = r7.getString(r3)     // Catch:{ all -> 0x0081 }
            r4.setAccountId(r8)     // Catch:{ all -> 0x0081 }
            r9 = r4
            goto L_0x0083
        L_0x0081:
            r8 = move-exception
            goto L_0x008a
        L_0x0083:
            r7.close()
            r0.release()
            return r9
        L_0x008a:
            r7.close()
            r0.release()
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.fastrecord.phone.db.FastRecordPersonDao_Impl.findNormalPersonEntityByName(java.lang.String, long, java.lang.String):com.upuphone.ar.fastrecord.phone.db.RecordPersonEntity");
    }

    public List<RecordPersonEntity> findPersonEntityByRecord(long j, String str) {
        RoomSQLiteQuery c = RoomSQLiteQuery.c("SELECT * FROM RecordPersonEntity where recordId=? AND accountId = ?", 2);
        c.F(1, j);
        c.B(2, str);
        this.__db.assertNotSuspendingTransaction();
        Cursor c2 = DBUtil.c(this.__db, c, false, (CancellationSignal) null);
        try {
            int d = CursorUtil.d(c2, "personTagId");
            int d2 = CursorUtil.d(c2, "recordId");
            int d3 = CursorUtil.d(c2, "personName");
            int d4 = CursorUtil.d(c2, "personType");
            int d5 = CursorUtil.d(c2, "createTime");
            int d6 = CursorUtil.d(c2, "accountId");
            ArrayList arrayList = new ArrayList(c2.getCount());
            while (c2.moveToNext()) {
                RecordPersonEntity recordPersonEntity = new RecordPersonEntity();
                recordPersonEntity.setPersonTagId(c2.getLong(d));
                recordPersonEntity.setRecordId(c2.getLong(d2));
                recordPersonEntity.setPersonName(c2.isNull(d3) ? null : c2.getString(d3));
                recordPersonEntity.setPersonType(c2.getString(d4));
                recordPersonEntity.setCreateTime(c2.getLong(d5));
                recordPersonEntity.setAccountId(c2.getString(d6));
                arrayList.add(recordPersonEntity);
            }
            return arrayList;
        } finally {
            c2.close();
            c.release();
        }
    }

    public void insert(RecordPersonEntity recordPersonEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfRecordPersonEntity.insert(recordPersonEntity);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    public void update(RecordPersonEntity recordPersonEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__updateAdapterOfRecordPersonEntity.handle(recordPersonEntity);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }
}
