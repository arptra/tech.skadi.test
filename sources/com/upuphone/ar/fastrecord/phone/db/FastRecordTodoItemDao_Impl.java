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
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

public final class FastRecordTodoItemDao_Impl implements FastRecordTodoItemDao {
    /* access modifiers changed from: private */
    public final RoomDatabase __db;
    /* access modifiers changed from: private */
    public final EntityDeletionOrUpdateAdapter<RecordTodoItemEntity> __deletionAdapterOfRecordTodoItemEntity;
    /* access modifiers changed from: private */
    public final EntityInsertionAdapter<RecordTodoItemEntity> __insertionAdapterOfRecordTodoItemEntity;
    /* access modifiers changed from: private */
    public final SharedSQLiteStatement __preparedStmtOfDeleteAllData;
    /* access modifiers changed from: private */
    public final SharedSQLiteStatement __preparedStmtOfDeleteByRecordId;
    /* access modifiers changed from: private */
    public final SharedSQLiteStatement __preparedStmtOfDeleteByToDoId;
    private final SharedSQLiteStatement __preparedStmtOfUpdateFinishDelStateByRecord;
    private final SharedSQLiteStatement __preparedStmtOfUpdateFinishDelStateByTodoId;
    private final SharedSQLiteStatement __preparedStmtOfUpdateNeedRequestServer;
    private final SharedSQLiteStatement __preparedStmtOfUpdateReportStateByRecord;
    /* access modifiers changed from: private */
    public final EntityDeletionOrUpdateAdapter<RecordTodoItemEntity> __updateAdapterOfRecordTodoItemEntity;

    public FastRecordTodoItemDao_Impl(@NonNull RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfRecordTodoItemEntity = new EntityInsertionAdapter<RecordTodoItemEntity>(roomDatabase) {
            @NonNull
            public String createQuery() {
                return "INSERT OR REPLACE INTO `RecordTodoItemEntity` (`todoItemId`,`recognizeId`,`recordId`,`start_time`,`end_time`,`todoTitle`,`content`,`contentTemp`,`viewType`,`isAddSchedule`,`isFinish`,`isEdit`,`calendarId`,`calendarEventId`,`isFinishDel`,`isReport`,`requestId`,`isNeedRequestServer`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            public void bind(@NonNull SupportSQLiteStatement supportSQLiteStatement, @NonNull RecordTodoItemEntity recordTodoItemEntity) {
                supportSQLiteStatement.F(1, recordTodoItemEntity.getTodoItemId());
                supportSQLiteStatement.B(2, recordTodoItemEntity.getRecognizeId());
                supportSQLiteStatement.F(3, recordTodoItemEntity.getRecordId());
                supportSQLiteStatement.B(4, recordTodoItemEntity.getStart_time());
                supportSQLiteStatement.B(5, recordTodoItemEntity.getEnd_time());
                supportSQLiteStatement.B(6, recordTodoItemEntity.getTodoTitle());
                supportSQLiteStatement.B(7, recordTodoItemEntity.getContent());
                if (recordTodoItemEntity.getContentTemp() == null) {
                    supportSQLiteStatement.L(8);
                } else {
                    supportSQLiteStatement.B(8, recordTodoItemEntity.getContentTemp());
                }
                supportSQLiteStatement.F(9, (long) recordTodoItemEntity.getViewType());
                supportSQLiteStatement.F(10, recordTodoItemEntity.isAddSchedule() ? 1 : 0);
                supportSQLiteStatement.F(11, recordTodoItemEntity.isFinish() ? 1 : 0);
                supportSQLiteStatement.F(12, recordTodoItemEntity.isEdit() ? 1 : 0);
                supportSQLiteStatement.F(13, recordTodoItemEntity.getCalendarId());
                supportSQLiteStatement.F(14, recordTodoItemEntity.getCalendarEventId());
                supportSQLiteStatement.F(15, recordTodoItemEntity.isFinishDel() ? 1 : 0);
                supportSQLiteStatement.F(16, recordTodoItemEntity.isReport() ? 1 : 0);
                supportSQLiteStatement.B(17, recordTodoItemEntity.getRequestId());
                supportSQLiteStatement.F(18, recordTodoItemEntity.isNeedRequestServer() ? 1 : 0);
            }
        };
        this.__deletionAdapterOfRecordTodoItemEntity = new EntityDeletionOrUpdateAdapter<RecordTodoItemEntity>(roomDatabase) {
            @NonNull
            public String createQuery() {
                return "DELETE FROM `RecordTodoItemEntity` WHERE `todoItemId` = ?";
            }

            public void bind(@NonNull SupportSQLiteStatement supportSQLiteStatement, @NonNull RecordTodoItemEntity recordTodoItemEntity) {
                supportSQLiteStatement.F(1, recordTodoItemEntity.getTodoItemId());
            }
        };
        this.__updateAdapterOfRecordTodoItemEntity = new EntityDeletionOrUpdateAdapter<RecordTodoItemEntity>(roomDatabase) {
            @NonNull
            public String createQuery() {
                return "UPDATE OR ABORT `RecordTodoItemEntity` SET `todoItemId` = ?,`recognizeId` = ?,`recordId` = ?,`start_time` = ?,`end_time` = ?,`todoTitle` = ?,`content` = ?,`contentTemp` = ?,`viewType` = ?,`isAddSchedule` = ?,`isFinish` = ?,`isEdit` = ?,`calendarId` = ?,`calendarEventId` = ?,`isFinishDel` = ?,`isReport` = ?,`requestId` = ?,`isNeedRequestServer` = ? WHERE `todoItemId` = ?";
            }

            public void bind(@NonNull SupportSQLiteStatement supportSQLiteStatement, @NonNull RecordTodoItemEntity recordTodoItemEntity) {
                supportSQLiteStatement.F(1, recordTodoItemEntity.getTodoItemId());
                supportSQLiteStatement.B(2, recordTodoItemEntity.getRecognizeId());
                supportSQLiteStatement.F(3, recordTodoItemEntity.getRecordId());
                supportSQLiteStatement.B(4, recordTodoItemEntity.getStart_time());
                supportSQLiteStatement.B(5, recordTodoItemEntity.getEnd_time());
                supportSQLiteStatement.B(6, recordTodoItemEntity.getTodoTitle());
                supportSQLiteStatement.B(7, recordTodoItemEntity.getContent());
                if (recordTodoItemEntity.getContentTemp() == null) {
                    supportSQLiteStatement.L(8);
                } else {
                    supportSQLiteStatement.B(8, recordTodoItemEntity.getContentTemp());
                }
                supportSQLiteStatement.F(9, (long) recordTodoItemEntity.getViewType());
                supportSQLiteStatement.F(10, recordTodoItemEntity.isAddSchedule() ? 1 : 0);
                supportSQLiteStatement.F(11, recordTodoItemEntity.isFinish() ? 1 : 0);
                supportSQLiteStatement.F(12, recordTodoItemEntity.isEdit() ? 1 : 0);
                supportSQLiteStatement.F(13, recordTodoItemEntity.getCalendarId());
                supportSQLiteStatement.F(14, recordTodoItemEntity.getCalendarEventId());
                supportSQLiteStatement.F(15, recordTodoItemEntity.isFinishDel() ? 1 : 0);
                supportSQLiteStatement.F(16, recordTodoItemEntity.isReport() ? 1 : 0);
                supportSQLiteStatement.B(17, recordTodoItemEntity.getRequestId());
                supportSQLiteStatement.F(18, recordTodoItemEntity.isNeedRequestServer() ? 1 : 0);
                supportSQLiteStatement.F(19, recordTodoItemEntity.getTodoItemId());
            }
        };
        this.__preparedStmtOfDeleteByRecordId = new SharedSQLiteStatement(roomDatabase) {
            @NonNull
            public String createQuery() {
                return "DELETE FROM RecordTodoItemEntity where recordId=?";
            }
        };
        this.__preparedStmtOfDeleteByToDoId = new SharedSQLiteStatement(roomDatabase) {
            @NonNull
            public String createQuery() {
                return "DELETE FROM RecordTodoItemEntity where todoItemId=?";
            }
        };
        this.__preparedStmtOfUpdateFinishDelStateByTodoId = new SharedSQLiteStatement(roomDatabase) {
            @NonNull
            public String createQuery() {
                return "UPDATE  RecordTodoItemEntity SET isFinishDel = ? where todoItemId=?";
            }
        };
        this.__preparedStmtOfUpdateFinishDelStateByRecord = new SharedSQLiteStatement(roomDatabase) {
            @NonNull
            public String createQuery() {
                return "UPDATE  RecordTodoItemEntity SET isFinishDel = ? ,isReport=? where recordId=?";
            }
        };
        this.__preparedStmtOfUpdateReportStateByRecord = new SharedSQLiteStatement(roomDatabase) {
            @NonNull
            public String createQuery() {
                return "UPDATE  RecordTodoItemEntity SET isReport=? where recordId=?";
            }
        };
        this.__preparedStmtOfUpdateNeedRequestServer = new SharedSQLiteStatement(roomDatabase) {
            @NonNull
            public String createQuery() {
                return "UPDATE  RecordTodoItemEntity SET isNeedRequestServer=? where recordId=?";
            }
        };
        this.__preparedStmtOfDeleteAllData = new SharedSQLiteStatement(roomDatabase) {
            @NonNull
            public String createQuery() {
                return "DELETE  FROM RecordTodoItemEntity";
            }
        };
    }

    @NonNull
    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    public Object delete(final RecordTodoItemEntity recordTodoItemEntity, Continuation<? super Unit> continuation) {
        return CoroutinesRoom.c(this.__db, true, new Callable<Unit>() {
            @NonNull
            public Unit call() throws Exception {
                FastRecordTodoItemDao_Impl.this.__db.beginTransaction();
                try {
                    FastRecordTodoItemDao_Impl.this.__deletionAdapterOfRecordTodoItemEntity.handle(recordTodoItemEntity);
                    FastRecordTodoItemDao_Impl.this.__db.setTransactionSuccessful();
                    return Unit.INSTANCE;
                } finally {
                    FastRecordTodoItemDao_Impl.this.__db.endTransaction();
                }
            }
        }, continuation);
    }

    public Object deleteAllData(Continuation<? super Unit> continuation) {
        return CoroutinesRoom.c(this.__db, true, new Callable<Unit>() {
            @NonNull
            public Unit call() throws Exception {
                SupportSQLiteStatement acquire = FastRecordTodoItemDao_Impl.this.__preparedStmtOfDeleteAllData.acquire();
                try {
                    FastRecordTodoItemDao_Impl.this.__db.beginTransaction();
                    acquire.k();
                    FastRecordTodoItemDao_Impl.this.__db.setTransactionSuccessful();
                    Unit unit = Unit.INSTANCE;
                    FastRecordTodoItemDao_Impl.this.__db.endTransaction();
                    FastRecordTodoItemDao_Impl.this.__preparedStmtOfDeleteAllData.release(acquire);
                    return unit;
                } catch (Throwable th) {
                    FastRecordTodoItemDao_Impl.this.__preparedStmtOfDeleteAllData.release(acquire);
                    throw th;
                }
            }
        }, continuation);
    }

    public Object deleteByRecordId(final long j, Continuation<? super Unit> continuation) {
        return CoroutinesRoom.c(this.__db, true, new Callable<Unit>() {
            @NonNull
            public Unit call() throws Exception {
                SupportSQLiteStatement acquire = FastRecordTodoItemDao_Impl.this.__preparedStmtOfDeleteByRecordId.acquire();
                acquire.F(1, j);
                try {
                    FastRecordTodoItemDao_Impl.this.__db.beginTransaction();
                    acquire.k();
                    FastRecordTodoItemDao_Impl.this.__db.setTransactionSuccessful();
                    Unit unit = Unit.INSTANCE;
                    FastRecordTodoItemDao_Impl.this.__db.endTransaction();
                    FastRecordTodoItemDao_Impl.this.__preparedStmtOfDeleteByRecordId.release(acquire);
                    return unit;
                } catch (Throwable th) {
                    FastRecordTodoItemDao_Impl.this.__preparedStmtOfDeleteByRecordId.release(acquire);
                    throw th;
                }
            }
        }, continuation);
    }

    public Object deleteByToDoId(final long j, Continuation<? super Unit> continuation) {
        return CoroutinesRoom.c(this.__db, true, new Callable<Unit>() {
            @NonNull
            public Unit call() throws Exception {
                SupportSQLiteStatement acquire = FastRecordTodoItemDao_Impl.this.__preparedStmtOfDeleteByToDoId.acquire();
                acquire.F(1, j);
                try {
                    FastRecordTodoItemDao_Impl.this.__db.beginTransaction();
                    acquire.k();
                    FastRecordTodoItemDao_Impl.this.__db.setTransactionSuccessful();
                    Unit unit = Unit.INSTANCE;
                    FastRecordTodoItemDao_Impl.this.__db.endTransaction();
                    FastRecordTodoItemDao_Impl.this.__preparedStmtOfDeleteByToDoId.release(acquire);
                    return unit;
                } catch (Throwable th) {
                    FastRecordTodoItemDao_Impl.this.__preparedStmtOfDeleteByToDoId.release(acquire);
                    throw th;
                }
            }
        }, continuation);
    }

    public Object insert(final RecordTodoItemEntity recordTodoItemEntity, Continuation<? super Unit> continuation) {
        return CoroutinesRoom.c(this.__db, true, new Callable<Unit>() {
            @NonNull
            public Unit call() throws Exception {
                FastRecordTodoItemDao_Impl.this.__db.beginTransaction();
                try {
                    FastRecordTodoItemDao_Impl.this.__insertionAdapterOfRecordTodoItemEntity.insert(recordTodoItemEntity);
                    FastRecordTodoItemDao_Impl.this.__db.setTransactionSuccessful();
                    return Unit.INSTANCE;
                } finally {
                    FastRecordTodoItemDao_Impl.this.__db.endTransaction();
                }
            }
        }, continuation);
    }

    public Object queryAllNoFinishByRecordId(long j, boolean z, Continuation<? super List<RecordTodoItemEntity>> continuation) {
        final RoomSQLiteQuery c = RoomSQLiteQuery.c("SELECT * FROM RecordTodoItemEntity where recordId=? AND isFinishDel = ?", 2);
        c.F(1, j);
        c.F(2, z ? 1 : 0);
        return CoroutinesRoom.b(this.__db, false, DBUtil.a(), new Callable<List<RecordTodoItemEntity>>() {
            @Nullable
            public List<RecordTodoItemEntity> call() throws Exception {
                AnonymousClass18 r3;
                String str;
                boolean z;
                int i;
                boolean z2;
                int i2;
                boolean z3;
                Cursor c = DBUtil.c(FastRecordTodoItemDao_Impl.this.__db, c, false, (CancellationSignal) null);
                try {
                    int d = CursorUtil.d(c, "todoItemId");
                    int d2 = CursorUtil.d(c, "recognizeId");
                    int d3 = CursorUtil.d(c, "recordId");
                    int d4 = CursorUtil.d(c, "start_time");
                    int d5 = CursorUtil.d(c, "end_time");
                    int d6 = CursorUtil.d(c, "todoTitle");
                    int d7 = CursorUtil.d(c, "content");
                    int d8 = CursorUtil.d(c, "contentTemp");
                    int d9 = CursorUtil.d(c, "viewType");
                    int d10 = CursorUtil.d(c, "isAddSchedule");
                    int d11 = CursorUtil.d(c, "isFinish");
                    int d12 = CursorUtil.d(c, "isEdit");
                    int d13 = CursorUtil.d(c, "calendarId");
                    int d14 = CursorUtil.d(c, "calendarEventId");
                    try {
                        int d15 = CursorUtil.d(c, "isFinishDel");
                        int d16 = CursorUtil.d(c, "isReport");
                        int d17 = CursorUtil.d(c, "requestId");
                        int d18 = CursorUtil.d(c, "isNeedRequestServer");
                        int i3 = d14;
                        ArrayList arrayList = new ArrayList(c.getCount());
                        while (c.moveToNext()) {
                            long j = c.getLong(d);
                            String string = c.getString(d2);
                            long j2 = c.getLong(d3);
                            String string2 = c.getString(d4);
                            String string3 = c.getString(d5);
                            String string4 = c.getString(d6);
                            String string5 = c.getString(d7);
                            if (c.isNull(d8)) {
                                str = null;
                            } else {
                                str = c.getString(d8);
                            }
                            int i4 = c.getInt(d9);
                            boolean z4 = c.getInt(d10) != 0;
                            boolean z5 = c.getInt(d11) != 0;
                            boolean z6 = c.getInt(d12) != 0;
                            long j3 = c.getLong(d13);
                            int i5 = i3;
                            long j4 = c.getLong(i5);
                            int i6 = d;
                            int i7 = d15;
                            if (c.getInt(i7) != 0) {
                                d15 = i7;
                                i = d16;
                                z = true;
                            } else {
                                d15 = i7;
                                i = d16;
                                z = false;
                            }
                            if (c.getInt(i) != 0) {
                                d16 = i;
                                i2 = d17;
                                z2 = true;
                            } else {
                                d16 = i;
                                i2 = d17;
                                z2 = false;
                            }
                            String string6 = c.getString(i2);
                            d17 = i2;
                            int i8 = d18;
                            if (c.getInt(i8) != 0) {
                                d18 = i8;
                                z3 = true;
                            } else {
                                d18 = i8;
                                z3 = false;
                            }
                            arrayList.add(new RecordTodoItemEntity(j, string, j2, string2, string3, string4, string5, str, i4, z4, z5, z6, j3, j4, z, z2, string6, z3));
                            d = i6;
                            i3 = i5;
                        }
                        c.close();
                        c.release();
                        return arrayList;
                    } catch (Throwable th) {
                        th = th;
                        r3 = this;
                        c.close();
                        c.release();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    r3 = this;
                    c.close();
                    c.release();
                    throw th;
                }
            }
        }, continuation);
    }

    public Object queryByRecordId(long j, Continuation<? super List<RecordTodoItemEntity>> continuation) {
        final RoomSQLiteQuery c = RoomSQLiteQuery.c("SELECT * FROM RecordTodoItemEntity where recordId=?", 1);
        c.F(1, j);
        return CoroutinesRoom.b(this.__db, false, DBUtil.a(), new Callable<List<RecordTodoItemEntity>>() {
            @Nullable
            public List<RecordTodoItemEntity> call() throws Exception {
                AnonymousClass17 r3;
                String str;
                boolean z;
                int i;
                boolean z2;
                int i2;
                boolean z3;
                Cursor c = DBUtil.c(FastRecordTodoItemDao_Impl.this.__db, c, false, (CancellationSignal) null);
                try {
                    int d = CursorUtil.d(c, "todoItemId");
                    int d2 = CursorUtil.d(c, "recognizeId");
                    int d3 = CursorUtil.d(c, "recordId");
                    int d4 = CursorUtil.d(c, "start_time");
                    int d5 = CursorUtil.d(c, "end_time");
                    int d6 = CursorUtil.d(c, "todoTitle");
                    int d7 = CursorUtil.d(c, "content");
                    int d8 = CursorUtil.d(c, "contentTemp");
                    int d9 = CursorUtil.d(c, "viewType");
                    int d10 = CursorUtil.d(c, "isAddSchedule");
                    int d11 = CursorUtil.d(c, "isFinish");
                    int d12 = CursorUtil.d(c, "isEdit");
                    int d13 = CursorUtil.d(c, "calendarId");
                    int d14 = CursorUtil.d(c, "calendarEventId");
                    try {
                        int d15 = CursorUtil.d(c, "isFinishDel");
                        int d16 = CursorUtil.d(c, "isReport");
                        int d17 = CursorUtil.d(c, "requestId");
                        int d18 = CursorUtil.d(c, "isNeedRequestServer");
                        int i3 = d14;
                        ArrayList arrayList = new ArrayList(c.getCount());
                        while (c.moveToNext()) {
                            long j = c.getLong(d);
                            String string = c.getString(d2);
                            long j2 = c.getLong(d3);
                            String string2 = c.getString(d4);
                            String string3 = c.getString(d5);
                            String string4 = c.getString(d6);
                            String string5 = c.getString(d7);
                            if (c.isNull(d8)) {
                                str = null;
                            } else {
                                str = c.getString(d8);
                            }
                            int i4 = c.getInt(d9);
                            boolean z4 = c.getInt(d10) != 0;
                            boolean z5 = c.getInt(d11) != 0;
                            boolean z6 = c.getInt(d12) != 0;
                            long j3 = c.getLong(d13);
                            int i5 = i3;
                            long j4 = c.getLong(i5);
                            int i6 = d;
                            int i7 = d15;
                            if (c.getInt(i7) != 0) {
                                d15 = i7;
                                i = d16;
                                z = true;
                            } else {
                                d15 = i7;
                                i = d16;
                                z = false;
                            }
                            if (c.getInt(i) != 0) {
                                d16 = i;
                                i2 = d17;
                                z2 = true;
                            } else {
                                d16 = i;
                                i2 = d17;
                                z2 = false;
                            }
                            String string6 = c.getString(i2);
                            d17 = i2;
                            int i8 = d18;
                            if (c.getInt(i8) != 0) {
                                d18 = i8;
                                z3 = true;
                            } else {
                                d18 = i8;
                                z3 = false;
                            }
                            arrayList.add(new RecordTodoItemEntity(j, string, j2, string2, string3, string4, string5, str, i4, z4, z5, z6, j3, j4, z, z2, string6, z3));
                            d = i6;
                            i3 = i5;
                        }
                        c.close();
                        c.release();
                        return arrayList;
                    } catch (Throwable th) {
                        th = th;
                        r3 = this;
                        c.close();
                        c.release();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    r3 = this;
                    c.close();
                    c.release();
                    throw th;
                }
            }
        }, continuation);
    }

    public Object update(final RecordTodoItemEntity recordTodoItemEntity, Continuation<? super Unit> continuation) {
        return CoroutinesRoom.c(this.__db, true, new Callable<Unit>() {
            @NonNull
            public Unit call() throws Exception {
                FastRecordTodoItemDao_Impl.this.__db.beginTransaction();
                try {
                    FastRecordTodoItemDao_Impl.this.__updateAdapterOfRecordTodoItemEntity.handle(recordTodoItemEntity);
                    FastRecordTodoItemDao_Impl.this.__db.setTransactionSuccessful();
                    return Unit.INSTANCE;
                } finally {
                    FastRecordTodoItemDao_Impl.this.__db.endTransaction();
                }
            }
        }, continuation);
    }

    public void updateFinishDelStateByRecord(long j, boolean z, boolean z2) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfUpdateFinishDelStateByRecord.acquire();
        acquire.F(1, z ? 1 : 0);
        acquire.F(2, z2 ? 1 : 0);
        acquire.F(3, j);
        try {
            this.__db.beginTransaction();
            acquire.k();
            this.__db.setTransactionSuccessful();
            this.__db.endTransaction();
            this.__preparedStmtOfUpdateFinishDelStateByRecord.release(acquire);
        } catch (Throwable th) {
            this.__preparedStmtOfUpdateFinishDelStateByRecord.release(acquire);
            throw th;
        }
    }

    public void updateFinishDelStateByTodoId(long j, boolean z) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfUpdateFinishDelStateByTodoId.acquire();
        acquire.F(1, z ? 1 : 0);
        acquire.F(2, j);
        try {
            this.__db.beginTransaction();
            acquire.k();
            this.__db.setTransactionSuccessful();
            this.__db.endTransaction();
            this.__preparedStmtOfUpdateFinishDelStateByTodoId.release(acquire);
        } catch (Throwable th) {
            this.__preparedStmtOfUpdateFinishDelStateByTodoId.release(acquire);
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
