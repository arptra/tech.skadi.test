package com.upuphone.ar.fastrecord.phone.db;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

public final class FastRecordSummaryDao_Impl implements FastRecordSummaryDao {
    /* access modifiers changed from: private */
    public final RoomDatabase __db;
    /* access modifiers changed from: private */
    public final EntityDeletionOrUpdateAdapter<RecordSummaryEntity> __deletionAdapterOfRecordSummaryEntity;
    /* access modifiers changed from: private */
    public final EntityInsertionAdapter<RecordSummaryEntity> __insertionAdapterOfRecordSummaryEntity;
    /* access modifiers changed from: private */
    public final SharedSQLiteStatement __preparedStmtOfDeleteAllData;
    /* access modifiers changed from: private */
    public final SharedSQLiteStatement __preparedStmtOfDeleteByRecordId;
    private final SharedSQLiteStatement __preparedStmtOfUpdateFinishDelState;
    private final SharedSQLiteStatement __preparedStmtOfUpdateNeedRequestServer;
    private final SharedSQLiteStatement __preparedStmtOfUpdateReportStateByRecord;
    /* access modifiers changed from: private */
    public final EntityDeletionOrUpdateAdapter<RecordSummaryEntity> __updateAdapterOfRecordSummaryEntity;

    public FastRecordSummaryDao_Impl(@NonNull RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfRecordSummaryEntity = new EntityInsertionAdapter<RecordSummaryEntity>(roomDatabase) {
            @NonNull
            public String createQuery() {
                return "INSERT OR REPLACE INTO `RecordSummaryEntity` (`summaryId`,`fileName`,`content`,`contentTemp`,`versionCode`,`appName`,`recognizeId`,`accountId`,`requestId`,`traceId`,`recordId`,`terminalTraceId`,`isFinishDel`,`isReport`,`isNeedRequestServer`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            public void bind(@NonNull SupportSQLiteStatement supportSQLiteStatement, @NonNull RecordSummaryEntity recordSummaryEntity) {
                supportSQLiteStatement.F(1, recordSummaryEntity.getSummaryId());
                if (recordSummaryEntity.getFileName() == null) {
                    supportSQLiteStatement.L(2);
                } else {
                    supportSQLiteStatement.B(2, recordSummaryEntity.getFileName());
                }
                if (recordSummaryEntity.getContent() == null) {
                    supportSQLiteStatement.L(3);
                } else {
                    supportSQLiteStatement.B(3, recordSummaryEntity.getContent());
                }
                if (recordSummaryEntity.getContentTemp() == null) {
                    supportSQLiteStatement.L(4);
                } else {
                    supportSQLiteStatement.B(4, recordSummaryEntity.getContentTemp());
                }
                if (recordSummaryEntity.getVersionCode() == null) {
                    supportSQLiteStatement.L(5);
                } else {
                    supportSQLiteStatement.B(5, recordSummaryEntity.getVersionCode());
                }
                supportSQLiteStatement.B(6, recordSummaryEntity.getAppName());
                if (recordSummaryEntity.getRecognizeId() == null) {
                    supportSQLiteStatement.L(7);
                } else {
                    supportSQLiteStatement.B(7, recordSummaryEntity.getRecognizeId());
                }
                supportSQLiteStatement.B(8, recordSummaryEntity.getAccountId());
                supportSQLiteStatement.B(9, recordSummaryEntity.getRequestId());
                supportSQLiteStatement.B(10, recordSummaryEntity.getTraceId());
                supportSQLiteStatement.F(11, recordSummaryEntity.getRecordId());
                supportSQLiteStatement.B(12, recordSummaryEntity.getTerminalTraceId());
                supportSQLiteStatement.F(13, recordSummaryEntity.isFinishDel() ? 1 : 0);
                supportSQLiteStatement.F(14, recordSummaryEntity.isReport() ? 1 : 0);
                supportSQLiteStatement.F(15, recordSummaryEntity.isNeedRequestServer() ? 1 : 0);
            }
        };
        this.__deletionAdapterOfRecordSummaryEntity = new EntityDeletionOrUpdateAdapter<RecordSummaryEntity>(roomDatabase) {
            @NonNull
            public String createQuery() {
                return "DELETE FROM `RecordSummaryEntity` WHERE `summaryId` = ?";
            }

            public void bind(@NonNull SupportSQLiteStatement supportSQLiteStatement, @NonNull RecordSummaryEntity recordSummaryEntity) {
                supportSQLiteStatement.F(1, recordSummaryEntity.getSummaryId());
            }
        };
        this.__updateAdapterOfRecordSummaryEntity = new EntityDeletionOrUpdateAdapter<RecordSummaryEntity>(roomDatabase) {
            @NonNull
            public String createQuery() {
                return "UPDATE OR ABORT `RecordSummaryEntity` SET `summaryId` = ?,`fileName` = ?,`content` = ?,`contentTemp` = ?,`versionCode` = ?,`appName` = ?,`recognizeId` = ?,`accountId` = ?,`requestId` = ?,`traceId` = ?,`recordId` = ?,`terminalTraceId` = ?,`isFinishDel` = ?,`isReport` = ?,`isNeedRequestServer` = ? WHERE `summaryId` = ?";
            }

            public void bind(@NonNull SupportSQLiteStatement supportSQLiteStatement, @NonNull RecordSummaryEntity recordSummaryEntity) {
                supportSQLiteStatement.F(1, recordSummaryEntity.getSummaryId());
                if (recordSummaryEntity.getFileName() == null) {
                    supportSQLiteStatement.L(2);
                } else {
                    supportSQLiteStatement.B(2, recordSummaryEntity.getFileName());
                }
                if (recordSummaryEntity.getContent() == null) {
                    supportSQLiteStatement.L(3);
                } else {
                    supportSQLiteStatement.B(3, recordSummaryEntity.getContent());
                }
                if (recordSummaryEntity.getContentTemp() == null) {
                    supportSQLiteStatement.L(4);
                } else {
                    supportSQLiteStatement.B(4, recordSummaryEntity.getContentTemp());
                }
                if (recordSummaryEntity.getVersionCode() == null) {
                    supportSQLiteStatement.L(5);
                } else {
                    supportSQLiteStatement.B(5, recordSummaryEntity.getVersionCode());
                }
                supportSQLiteStatement.B(6, recordSummaryEntity.getAppName());
                if (recordSummaryEntity.getRecognizeId() == null) {
                    supportSQLiteStatement.L(7);
                } else {
                    supportSQLiteStatement.B(7, recordSummaryEntity.getRecognizeId());
                }
                supportSQLiteStatement.B(8, recordSummaryEntity.getAccountId());
                supportSQLiteStatement.B(9, recordSummaryEntity.getRequestId());
                supportSQLiteStatement.B(10, recordSummaryEntity.getTraceId());
                supportSQLiteStatement.F(11, recordSummaryEntity.getRecordId());
                supportSQLiteStatement.B(12, recordSummaryEntity.getTerminalTraceId());
                supportSQLiteStatement.F(13, recordSummaryEntity.isFinishDel() ? 1 : 0);
                supportSQLiteStatement.F(14, recordSummaryEntity.isReport() ? 1 : 0);
                supportSQLiteStatement.F(15, recordSummaryEntity.isNeedRequestServer() ? 1 : 0);
                supportSQLiteStatement.F(16, recordSummaryEntity.getSummaryId());
            }
        };
        this.__preparedStmtOfDeleteByRecordId = new SharedSQLiteStatement(roomDatabase) {
            @NonNull
            public String createQuery() {
                return "DELETE FROM RecordSummaryEntity where recordId=?";
            }
        };
        this.__preparedStmtOfUpdateFinishDelState = new SharedSQLiteStatement(roomDatabase) {
            @NonNull
            public String createQuery() {
                return "UPDATE  RecordSummaryEntity SET isFinishDel = ?,isReport=? where recordId=?";
            }
        };
        this.__preparedStmtOfUpdateReportStateByRecord = new SharedSQLiteStatement(roomDatabase) {
            @NonNull
            public String createQuery() {
                return "UPDATE  RecordSummaryEntity SET isReport=? where recordId=?";
            }
        };
        this.__preparedStmtOfUpdateNeedRequestServer = new SharedSQLiteStatement(roomDatabase) {
            @NonNull
            public String createQuery() {
                return "UPDATE  RecordSummaryEntity SET isNeedRequestServer=? where recordId=?";
            }
        };
        this.__preparedStmtOfDeleteAllData = new SharedSQLiteStatement(roomDatabase) {
            @NonNull
            public String createQuery() {
                return "DELETE  FROM RecordSummaryEntity";
            }
        };
    }

    @NonNull
    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    public Object delete(final RecordSummaryEntity recordSummaryEntity, Continuation<? super Unit> continuation) {
        return CoroutinesRoom.c(this.__db, true, new Callable<Unit>() {
            @NonNull
            public Unit call() throws Exception {
                FastRecordSummaryDao_Impl.this.__db.beginTransaction();
                try {
                    FastRecordSummaryDao_Impl.this.__deletionAdapterOfRecordSummaryEntity.handle(recordSummaryEntity);
                    FastRecordSummaryDao_Impl.this.__db.setTransactionSuccessful();
                    return Unit.INSTANCE;
                } finally {
                    FastRecordSummaryDao_Impl.this.__db.endTransaction();
                }
            }
        }, continuation);
    }

    public Object deleteAllData(Continuation<? super Unit> continuation) {
        return CoroutinesRoom.c(this.__db, true, new Callable<Unit>() {
            @NonNull
            public Unit call() throws Exception {
                SupportSQLiteStatement acquire = FastRecordSummaryDao_Impl.this.__preparedStmtOfDeleteAllData.acquire();
                try {
                    FastRecordSummaryDao_Impl.this.__db.beginTransaction();
                    acquire.k();
                    FastRecordSummaryDao_Impl.this.__db.setTransactionSuccessful();
                    Unit unit = Unit.INSTANCE;
                    FastRecordSummaryDao_Impl.this.__db.endTransaction();
                    FastRecordSummaryDao_Impl.this.__preparedStmtOfDeleteAllData.release(acquire);
                    return unit;
                } catch (Throwable th) {
                    FastRecordSummaryDao_Impl.this.__preparedStmtOfDeleteAllData.release(acquire);
                    throw th;
                }
            }
        }, continuation);
    }

    public Object deleteByRecordId(final long j, Continuation<? super Unit> continuation) {
        return CoroutinesRoom.c(this.__db, true, new Callable<Unit>() {
            @NonNull
            public Unit call() throws Exception {
                SupportSQLiteStatement acquire = FastRecordSummaryDao_Impl.this.__preparedStmtOfDeleteByRecordId.acquire();
                acquire.F(1, j);
                try {
                    FastRecordSummaryDao_Impl.this.__db.beginTransaction();
                    acquire.k();
                    FastRecordSummaryDao_Impl.this.__db.setTransactionSuccessful();
                    Unit unit = Unit.INSTANCE;
                    FastRecordSummaryDao_Impl.this.__db.endTransaction();
                    FastRecordSummaryDao_Impl.this.__preparedStmtOfDeleteByRecordId.release(acquire);
                    return unit;
                } catch (Throwable th) {
                    FastRecordSummaryDao_Impl.this.__preparedStmtOfDeleteByRecordId.release(acquire);
                    throw th;
                }
            }
        }, continuation);
    }

    public Object insert(final RecordSummaryEntity recordSummaryEntity, Continuation<? super Unit> continuation) {
        return CoroutinesRoom.c(this.__db, true, new Callable<Unit>() {
            @NonNull
            public Unit call() throws Exception {
                FastRecordSummaryDao_Impl.this.__db.beginTransaction();
                try {
                    FastRecordSummaryDao_Impl.this.__insertionAdapterOfRecordSummaryEntity.insert(recordSummaryEntity);
                    FastRecordSummaryDao_Impl.this.__db.setTransactionSuccessful();
                    return Unit.INSTANCE;
                } finally {
                    FastRecordSummaryDao_Impl.this.__db.endTransaction();
                }
            }
        }, continuation);
    }

    public Object queryByRecordId(long j, Continuation<? super RecordSummaryEntity> continuation) {
        final RoomSQLiteQuery c = RoomSQLiteQuery.c("SELECT * FROM RecordSummaryEntity where recordId=?", 1);
        c.F(1, j);
        return CoroutinesRoom.b(this.__db, false, DBUtil.a(), new Callable<RecordSummaryEntity>() {
            @Nullable
            public RecordSummaryEntity call() throws Exception {
                RecordSummaryEntity recordSummaryEntity;
                String str;
                String str2;
                String str3;
                String str4;
                String str5;
                AnonymousClass15 r1 = this;
                Cursor c = DBUtil.c(FastRecordSummaryDao_Impl.this.__db, c, false, (CancellationSignal) null);
                try {
                    int d = CursorUtil.d(c, "summaryId");
                    int d2 = CursorUtil.d(c, "fileName");
                    int d3 = CursorUtil.d(c, "content");
                    int d4 = CursorUtil.d(c, "contentTemp");
                    int d5 = CursorUtil.d(c, "versionCode");
                    int d6 = CursorUtil.d(c, "appName");
                    int d7 = CursorUtil.d(c, "recognizeId");
                    int d8 = CursorUtil.d(c, "accountId");
                    int d9 = CursorUtil.d(c, "requestId");
                    int d10 = CursorUtil.d(c, "traceId");
                    int d11 = CursorUtil.d(c, "recordId");
                    int d12 = CursorUtil.d(c, "terminalTraceId");
                    int d13 = CursorUtil.d(c, "isFinishDel");
                    int d14 = CursorUtil.d(c, "isReport");
                    try {
                        int d15 = CursorUtil.d(c, "isNeedRequestServer");
                        if (c.moveToFirst()) {
                            long j = c.getLong(d);
                            if (c.isNull(d2)) {
                                str = null;
                            } else {
                                str = c.getString(d2);
                            }
                            if (c.isNull(d3)) {
                                str2 = null;
                            } else {
                                str2 = c.getString(d3);
                            }
                            if (c.isNull(d4)) {
                                str3 = null;
                            } else {
                                str3 = c.getString(d4);
                            }
                            if (c.isNull(d5)) {
                                str4 = null;
                            } else {
                                str4 = c.getString(d5);
                            }
                            String string = c.getString(d6);
                            if (c.isNull(d7)) {
                                str5 = null;
                            } else {
                                str5 = c.getString(d7);
                            }
                            recordSummaryEntity = new RecordSummaryEntity(j, str, str2, str3, str4, string, str5, c.getString(d8), c.getString(d9), c.getString(d10), c.getLong(d11), c.getString(d12), c.getInt(d13) != 0, c.getInt(d14) != 0, c.getInt(d15) != 0);
                        } else {
                            recordSummaryEntity = null;
                        }
                        c.close();
                        c.release();
                        return recordSummaryEntity;
                    } catch (Throwable th) {
                        th = th;
                        r1 = this;
                        c.close();
                        c.release();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    c.close();
                    c.release();
                    throw th;
                }
            }
        }, continuation);
    }

    public Object queryNoFinishByRecordId(long j, boolean z, Continuation<? super RecordSummaryEntity> continuation) {
        final RoomSQLiteQuery c = RoomSQLiteQuery.c("SELECT * FROM RecordSummaryEntity where recordId=? AND isFinishDel = ?", 2);
        c.F(1, j);
        c.F(2, z ? 1 : 0);
        return CoroutinesRoom.b(this.__db, false, DBUtil.a(), new Callable<RecordSummaryEntity>() {
            @Nullable
            public RecordSummaryEntity call() throws Exception {
                RecordSummaryEntity recordSummaryEntity;
                String str;
                String str2;
                String str3;
                String str4;
                String str5;
                AnonymousClass14 r1 = this;
                Cursor c = DBUtil.c(FastRecordSummaryDao_Impl.this.__db, c, false, (CancellationSignal) null);
                try {
                    int d = CursorUtil.d(c, "summaryId");
                    int d2 = CursorUtil.d(c, "fileName");
                    int d3 = CursorUtil.d(c, "content");
                    int d4 = CursorUtil.d(c, "contentTemp");
                    int d5 = CursorUtil.d(c, "versionCode");
                    int d6 = CursorUtil.d(c, "appName");
                    int d7 = CursorUtil.d(c, "recognizeId");
                    int d8 = CursorUtil.d(c, "accountId");
                    int d9 = CursorUtil.d(c, "requestId");
                    int d10 = CursorUtil.d(c, "traceId");
                    int d11 = CursorUtil.d(c, "recordId");
                    int d12 = CursorUtil.d(c, "terminalTraceId");
                    int d13 = CursorUtil.d(c, "isFinishDel");
                    int d14 = CursorUtil.d(c, "isReport");
                    try {
                        int d15 = CursorUtil.d(c, "isNeedRequestServer");
                        if (c.moveToFirst()) {
                            long j = c.getLong(d);
                            if (c.isNull(d2)) {
                                str = null;
                            } else {
                                str = c.getString(d2);
                            }
                            if (c.isNull(d3)) {
                                str2 = null;
                            } else {
                                str2 = c.getString(d3);
                            }
                            if (c.isNull(d4)) {
                                str3 = null;
                            } else {
                                str3 = c.getString(d4);
                            }
                            if (c.isNull(d5)) {
                                str4 = null;
                            } else {
                                str4 = c.getString(d5);
                            }
                            String string = c.getString(d6);
                            if (c.isNull(d7)) {
                                str5 = null;
                            } else {
                                str5 = c.getString(d7);
                            }
                            recordSummaryEntity = new RecordSummaryEntity(j, str, str2, str3, str4, string, str5, c.getString(d8), c.getString(d9), c.getString(d10), c.getLong(d11), c.getString(d12), c.getInt(d13) != 0, c.getInt(d14) != 0, c.getInt(d15) != 0);
                        } else {
                            recordSummaryEntity = null;
                        }
                        c.close();
                        c.release();
                        return recordSummaryEntity;
                    } catch (Throwable th) {
                        th = th;
                        r1 = this;
                        c.close();
                        c.release();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    c.close();
                    c.release();
                    throw th;
                }
            }
        }, continuation);
    }

    public Object update(final RecordSummaryEntity recordSummaryEntity, Continuation<? super Unit> continuation) {
        return CoroutinesRoom.c(this.__db, true, new Callable<Unit>() {
            @NonNull
            public Unit call() throws Exception {
                FastRecordSummaryDao_Impl.this.__db.beginTransaction();
                try {
                    FastRecordSummaryDao_Impl.this.__updateAdapterOfRecordSummaryEntity.handle(recordSummaryEntity);
                    FastRecordSummaryDao_Impl.this.__db.setTransactionSuccessful();
                    return Unit.INSTANCE;
                } finally {
                    FastRecordSummaryDao_Impl.this.__db.endTransaction();
                }
            }
        }, continuation);
    }

    public void updateFinishDelState(long j, boolean z, boolean z2) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfUpdateFinishDelState.acquire();
        acquire.F(1, z ? 1 : 0);
        acquire.F(2, z2 ? 1 : 0);
        acquire.F(3, j);
        try {
            this.__db.beginTransaction();
            acquire.k();
            this.__db.setTransactionSuccessful();
            this.__db.endTransaction();
            this.__preparedStmtOfUpdateFinishDelState.release(acquire);
        } catch (Throwable th) {
            this.__preparedStmtOfUpdateFinishDelState.release(acquire);
            throw th;
        }
    }

    public void updateNeedRequestServer(long j, boolean z) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfUpdateNeedRequestServer.acquire();
        acquire.F(1, z ? 1 : 0);
        acquire.F(2, j);
        try {
            this.__db.beginTransaction();
            acquire.k();
            this.__db.setTransactionSuccessful();
            this.__db.endTransaction();
            this.__preparedStmtOfUpdateNeedRequestServer.release(acquire);
        } catch (Throwable th) {
            this.__preparedStmtOfUpdateNeedRequestServer.release(acquire);
            throw th;
        }
    }

    public void updateReportStateByRecord(long j, boolean z) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfUpdateReportStateByRecord.acquire();
        acquire.F(1, z ? 1 : 0);
        acquire.F(2, j);
        try {
            this.__db.beginTransaction();
            acquire.k();
            this.__db.setTransactionSuccessful();
            this.__db.endTransaction();
            this.__preparedStmtOfUpdateReportStateByRecord.release(acquire);
        } catch (Throwable th) {
            this.__preparedStmtOfUpdateReportStateByRecord.release(acquire);
            throw th;
        }
    }
}
