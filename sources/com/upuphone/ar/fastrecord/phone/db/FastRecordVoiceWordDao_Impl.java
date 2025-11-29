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

public final class FastRecordVoiceWordDao_Impl implements FastRecordVoiceWordDao {
    /* access modifiers changed from: private */
    public final RoomDatabase __db;
    /* access modifiers changed from: private */
    public final EntityDeletionOrUpdateAdapter<RecordVoiceWordEntity> __deletionAdapterOfRecordVoiceWordEntity;
    /* access modifiers changed from: private */
    public final EntityInsertionAdapter<RecordVoiceWordEntity> __insertionAdapterOfRecordVoiceWordEntity;
    /* access modifiers changed from: private */
    public final SharedSQLiteStatement __preparedStmtOfDeleteAllData;
    /* access modifiers changed from: private */
    public final SharedSQLiteStatement __preparedStmtOfDeleteByRecordId;
    /* access modifiers changed from: private */
    public final EntityDeletionOrUpdateAdapter<RecordVoiceWordEntity> __updateAdapterOfRecordVoiceWordEntity;

    public FastRecordVoiceWordDao_Impl(@NonNull RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfRecordVoiceWordEntity = new EntityInsertionAdapter<RecordVoiceWordEntity>(roomDatabase) {
            @NonNull
            public String createQuery() {
                return "INSERT OR REPLACE INTO `RecordVoiceWordEntity` (`wordId`,`userId`,`recordId`,`fileName`,`startTime`,`endTime`,`wordContent`,`wordContentTemp`,`isFinishWord`,`roles`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?)";
            }

            public void bind(@NonNull SupportSQLiteStatement supportSQLiteStatement, @NonNull RecordVoiceWordEntity recordVoiceWordEntity) {
                supportSQLiteStatement.F(1, recordVoiceWordEntity.getWordId());
                if (recordVoiceWordEntity.getUserId() == null) {
                    supportSQLiteStatement.L(2);
                } else {
                    supportSQLiteStatement.B(2, recordVoiceWordEntity.getUserId());
                }
                supportSQLiteStatement.F(3, recordVoiceWordEntity.getRecordId());
                if (recordVoiceWordEntity.getFileName() == null) {
                    supportSQLiteStatement.L(4);
                } else {
                    supportSQLiteStatement.B(4, recordVoiceWordEntity.getFileName());
                }
                supportSQLiteStatement.F(5, recordVoiceWordEntity.getStartTime());
                supportSQLiteStatement.F(6, recordVoiceWordEntity.getEndTime());
                if (recordVoiceWordEntity.getWordContent() == null) {
                    supportSQLiteStatement.L(7);
                } else {
                    supportSQLiteStatement.B(7, recordVoiceWordEntity.getWordContent());
                }
                if (recordVoiceWordEntity.getWordContentTemp() == null) {
                    supportSQLiteStatement.L(8);
                } else {
                    supportSQLiteStatement.B(8, recordVoiceWordEntity.getWordContentTemp());
                }
                supportSQLiteStatement.F(9, recordVoiceWordEntity.isFinishWord() ? 1 : 0);
                if (recordVoiceWordEntity.getRoles() == null) {
                    supportSQLiteStatement.L(10);
                } else {
                    supportSQLiteStatement.B(10, recordVoiceWordEntity.getRoles());
                }
            }
        };
        this.__deletionAdapterOfRecordVoiceWordEntity = new EntityDeletionOrUpdateAdapter<RecordVoiceWordEntity>(roomDatabase) {
            @NonNull
            public String createQuery() {
                return "DELETE FROM `RecordVoiceWordEntity` WHERE `wordId` = ?";
            }

            public void bind(@NonNull SupportSQLiteStatement supportSQLiteStatement, @NonNull RecordVoiceWordEntity recordVoiceWordEntity) {
                supportSQLiteStatement.F(1, recordVoiceWordEntity.getWordId());
            }
        };
        this.__updateAdapterOfRecordVoiceWordEntity = new EntityDeletionOrUpdateAdapter<RecordVoiceWordEntity>(roomDatabase) {
            @NonNull
            public String createQuery() {
                return "UPDATE OR ABORT `RecordVoiceWordEntity` SET `wordId` = ?,`userId` = ?,`recordId` = ?,`fileName` = ?,`startTime` = ?,`endTime` = ?,`wordContent` = ?,`wordContentTemp` = ?,`isFinishWord` = ?,`roles` = ? WHERE `wordId` = ?";
            }

            public void bind(@NonNull SupportSQLiteStatement supportSQLiteStatement, @NonNull RecordVoiceWordEntity recordVoiceWordEntity) {
                supportSQLiteStatement.F(1, recordVoiceWordEntity.getWordId());
                if (recordVoiceWordEntity.getUserId() == null) {
                    supportSQLiteStatement.L(2);
                } else {
                    supportSQLiteStatement.B(2, recordVoiceWordEntity.getUserId());
                }
                supportSQLiteStatement.F(3, recordVoiceWordEntity.getRecordId());
                if (recordVoiceWordEntity.getFileName() == null) {
                    supportSQLiteStatement.L(4);
                } else {
                    supportSQLiteStatement.B(4, recordVoiceWordEntity.getFileName());
                }
                supportSQLiteStatement.F(5, recordVoiceWordEntity.getStartTime());
                supportSQLiteStatement.F(6, recordVoiceWordEntity.getEndTime());
                if (recordVoiceWordEntity.getWordContent() == null) {
                    supportSQLiteStatement.L(7);
                } else {
                    supportSQLiteStatement.B(7, recordVoiceWordEntity.getWordContent());
                }
                if (recordVoiceWordEntity.getWordContentTemp() == null) {
                    supportSQLiteStatement.L(8);
                } else {
                    supportSQLiteStatement.B(8, recordVoiceWordEntity.getWordContentTemp());
                }
                supportSQLiteStatement.F(9, recordVoiceWordEntity.isFinishWord() ? 1 : 0);
                if (recordVoiceWordEntity.getRoles() == null) {
                    supportSQLiteStatement.L(10);
                } else {
                    supportSQLiteStatement.B(10, recordVoiceWordEntity.getRoles());
                }
                supportSQLiteStatement.F(11, recordVoiceWordEntity.getWordId());
            }
        };
        this.__preparedStmtOfDeleteByRecordId = new SharedSQLiteStatement(roomDatabase) {
            @NonNull
            public String createQuery() {
                return "DELETE FROM RecordVoiceWordEntity where recordId=?";
            }
        };
        this.__preparedStmtOfDeleteAllData = new SharedSQLiteStatement(roomDatabase) {
            @NonNull
            public String createQuery() {
                return "DELETE  FROM RecordVoiceWordEntity";
            }
        };
    }

    @NonNull
    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    public Object delete(final RecordVoiceWordEntity recordVoiceWordEntity, Continuation<? super Unit> continuation) {
        return CoroutinesRoom.c(this.__db, true, new Callable<Unit>() {
            @NonNull
            public Unit call() throws Exception {
                FastRecordVoiceWordDao_Impl.this.__db.beginTransaction();
                try {
                    FastRecordVoiceWordDao_Impl.this.__deletionAdapterOfRecordVoiceWordEntity.handle(recordVoiceWordEntity);
                    FastRecordVoiceWordDao_Impl.this.__db.setTransactionSuccessful();
                    return Unit.INSTANCE;
                } finally {
                    FastRecordVoiceWordDao_Impl.this.__db.endTransaction();
                }
            }
        }, continuation);
    }

    public Object deleteAllData(Continuation<? super Unit> continuation) {
        return CoroutinesRoom.c(this.__db, true, new Callable<Unit>() {
            @NonNull
            public Unit call() throws Exception {
                SupportSQLiteStatement acquire = FastRecordVoiceWordDao_Impl.this.__preparedStmtOfDeleteAllData.acquire();
                try {
                    FastRecordVoiceWordDao_Impl.this.__db.beginTransaction();
                    acquire.k();
                    FastRecordVoiceWordDao_Impl.this.__db.setTransactionSuccessful();
                    Unit unit = Unit.INSTANCE;
                    FastRecordVoiceWordDao_Impl.this.__db.endTransaction();
                    FastRecordVoiceWordDao_Impl.this.__preparedStmtOfDeleteAllData.release(acquire);
                    return unit;
                } catch (Throwable th) {
                    FastRecordVoiceWordDao_Impl.this.__preparedStmtOfDeleteAllData.release(acquire);
                    throw th;
                }
            }
        }, continuation);
    }

    public Object deleteByRecordId(final long j, Continuation<? super Unit> continuation) {
        return CoroutinesRoom.c(this.__db, true, new Callable<Unit>() {
            @NonNull
            public Unit call() throws Exception {
                SupportSQLiteStatement acquire = FastRecordVoiceWordDao_Impl.this.__preparedStmtOfDeleteByRecordId.acquire();
                acquire.F(1, j);
                try {
                    FastRecordVoiceWordDao_Impl.this.__db.beginTransaction();
                    acquire.k();
                    FastRecordVoiceWordDao_Impl.this.__db.setTransactionSuccessful();
                    Unit unit = Unit.INSTANCE;
                    FastRecordVoiceWordDao_Impl.this.__db.endTransaction();
                    FastRecordVoiceWordDao_Impl.this.__preparedStmtOfDeleteByRecordId.release(acquire);
                    return unit;
                } catch (Throwable th) {
                    FastRecordVoiceWordDao_Impl.this.__preparedStmtOfDeleteByRecordId.release(acquire);
                    throw th;
                }
            }
        }, continuation);
    }

    public Object deleteItems(final List<RecordVoiceWordEntity> list, Continuation<? super Unit> continuation) {
        return CoroutinesRoom.c(this.__db, true, new Callable<Unit>() {
            @NonNull
            public Unit call() throws Exception {
                FastRecordVoiceWordDao_Impl.this.__db.beginTransaction();
                try {
                    FastRecordVoiceWordDao_Impl.this.__deletionAdapterOfRecordVoiceWordEntity.handleMultiple(list);
                    FastRecordVoiceWordDao_Impl.this.__db.setTransactionSuccessful();
                    return Unit.INSTANCE;
                } finally {
                    FastRecordVoiceWordDao_Impl.this.__db.endTransaction();
                }
            }
        }, continuation);
    }

    public Object findFastRecordById(long j, Continuation<? super List<RecordVoiceWordEntity>> continuation) {
        final RoomSQLiteQuery c = RoomSQLiteQuery.c("SELECT * FROM RecordVoiceWordEntity where recordId=?", 1);
        c.F(1, j);
        return CoroutinesRoom.b(this.__db, false, DBUtil.a(), new Callable<List<RecordVoiceWordEntity>>() {
            @Nullable
            public List<RecordVoiceWordEntity> call() throws Exception {
                String str;
                String str2;
                String str3;
                String str4;
                String str5;
                Cursor c = DBUtil.c(FastRecordVoiceWordDao_Impl.this.__db, c, false, (CancellationSignal) null);
                try {
                    int d = CursorUtil.d(c, "wordId");
                    int d2 = CursorUtil.d(c, "userId");
                    int d3 = CursorUtil.d(c, "recordId");
                    int d4 = CursorUtil.d(c, "fileName");
                    int d5 = CursorUtil.d(c, "startTime");
                    int d6 = CursorUtil.d(c, "endTime");
                    int d7 = CursorUtil.d(c, "wordContent");
                    int d8 = CursorUtil.d(c, "wordContentTemp");
                    int d9 = CursorUtil.d(c, "isFinishWord");
                    int d10 = CursorUtil.d(c, "roles");
                    ArrayList arrayList = new ArrayList(c.getCount());
                    while (c.moveToNext()) {
                        RecordVoiceWordEntity recordVoiceWordEntity = new RecordVoiceWordEntity();
                        recordVoiceWordEntity.setWordId(c.getLong(d));
                        if (c.isNull(d2)) {
                            str = null;
                        } else {
                            str = c.getString(d2);
                        }
                        recordVoiceWordEntity.setUserId(str);
                        recordVoiceWordEntity.setRecordId(c.getLong(d3));
                        if (c.isNull(d4)) {
                            str2 = null;
                        } else {
                            str2 = c.getString(d4);
                        }
                        recordVoiceWordEntity.setFileName(str2);
                        recordVoiceWordEntity.setStartTime(c.getLong(d5));
                        recordVoiceWordEntity.setEndTime(c.getLong(d6));
                        if (c.isNull(d7)) {
                            str3 = null;
                        } else {
                            str3 = c.getString(d7);
                        }
                        recordVoiceWordEntity.setWordContent(str3);
                        if (c.isNull(d8)) {
                            str4 = null;
                        } else {
                            str4 = c.getString(d8);
                        }
                        recordVoiceWordEntity.setWordContentTemp(str4);
                        recordVoiceWordEntity.setFinishWord(c.getInt(d9) != 0);
                        if (c.isNull(d10)) {
                            str5 = null;
                        } else {
                            str5 = c.getString(d10);
                        }
                        recordVoiceWordEntity.setRoles(str5);
                        arrayList.add(recordVoiceWordEntity);
                    }
                    return arrayList;
                } finally {
                    c.close();
                    c.release();
                }
            }
        }, continuation);
    }

    public Object findFastRecordNumberById(long j, Continuation<? super Integer> continuation) {
        final RoomSQLiteQuery c = RoomSQLiteQuery.c("SELECT count(*) FROM RecordVoiceWordEntity where recordId=?", 1);
        c.F(1, j);
        return CoroutinesRoom.b(this.__db, false, DBUtil.a(), new Callable<Integer>() {
            @NonNull
            public Integer call() throws Exception {
                int i;
                Cursor c = DBUtil.c(FastRecordVoiceWordDao_Impl.this.__db, c, false, (CancellationSignal) null);
                try {
                    if (c.moveToFirst()) {
                        i = Integer.valueOf(c.getInt(0));
                    } else {
                        i = 0;
                    }
                    return i;
                } finally {
                    c.close();
                    c.release();
                }
            }
        }, continuation);
    }

    public int findFastRecordNumberByIdNoSuspend(long j) {
        RoomSQLiteQuery c = RoomSQLiteQuery.c("SELECT count(*) FROM RecordVoiceWordEntity where recordId=?", 1);
        c.F(1, j);
        this.__db.assertNotSuspendingTransaction();
        int i = 0;
        Cursor c2 = DBUtil.c(this.__db, c, false, (CancellationSignal) null);
        try {
            if (c2.moveToFirst()) {
                i = c2.getInt(0);
            }
            return i;
        } finally {
            c2.close();
            c.release();
        }
    }

    public List<RecordVoiceWordEntity> findFastRecordOrderByStartTime(long j) {
        RoomSQLiteQuery c = RoomSQLiteQuery.c("SELECT * FROM RecordVoiceWordEntity where recordId=? ORDER BY startTime ASC", 1);
        c.F(1, j);
        this.__db.assertNotSuspendingTransaction();
        Cursor c2 = DBUtil.c(this.__db, c, false, (CancellationSignal) null);
        try {
            int d = CursorUtil.d(c2, "wordId");
            int d2 = CursorUtil.d(c2, "userId");
            int d3 = CursorUtil.d(c2, "recordId");
            int d4 = CursorUtil.d(c2, "fileName");
            int d5 = CursorUtil.d(c2, "startTime");
            int d6 = CursorUtil.d(c2, "endTime");
            int d7 = CursorUtil.d(c2, "wordContent");
            int d8 = CursorUtil.d(c2, "wordContentTemp");
            int d9 = CursorUtil.d(c2, "isFinishWord");
            int d10 = CursorUtil.d(c2, "roles");
            ArrayList arrayList = new ArrayList(c2.getCount());
            while (c2.moveToNext()) {
                RecordVoiceWordEntity recordVoiceWordEntity = new RecordVoiceWordEntity();
                recordVoiceWordEntity.setWordId(c2.getLong(d));
                recordVoiceWordEntity.setUserId(c2.isNull(d2) ? null : c2.getString(d2));
                recordVoiceWordEntity.setRecordId(c2.getLong(d3));
                recordVoiceWordEntity.setFileName(c2.isNull(d4) ? null : c2.getString(d4));
                recordVoiceWordEntity.setStartTime(c2.getLong(d5));
                recordVoiceWordEntity.setEndTime(c2.getLong(d6));
                recordVoiceWordEntity.setWordContent(c2.isNull(d7) ? null : c2.getString(d7));
                recordVoiceWordEntity.setWordContentTemp(c2.isNull(d8) ? null : c2.getString(d8));
                recordVoiceWordEntity.setFinishWord(c2.getInt(d9) != 0);
                recordVoiceWordEntity.setRoles(c2.isNull(d10) ? null : c2.getString(d10));
                arrayList.add(recordVoiceWordEntity);
            }
            return arrayList;
        } finally {
            c2.close();
            c.release();
        }
    }

    public Object insert(final RecordVoiceWordEntity recordVoiceWordEntity, Continuation<? super Unit> continuation) {
        return CoroutinesRoom.c(this.__db, true, new Callable<Unit>() {
            @NonNull
            public Unit call() throws Exception {
                FastRecordVoiceWordDao_Impl.this.__db.beginTransaction();
                try {
                    FastRecordVoiceWordDao_Impl.this.__insertionAdapterOfRecordVoiceWordEntity.insert(recordVoiceWordEntity);
                    FastRecordVoiceWordDao_Impl.this.__db.setTransactionSuccessful();
                    return Unit.INSTANCE;
                } finally {
                    FastRecordVoiceWordDao_Impl.this.__db.endTransaction();
                }
            }
        }, continuation);
    }

    public void insertDbNoSuspend(RecordVoiceWordEntity recordVoiceWordEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfRecordVoiceWordEntity.insert(recordVoiceWordEntity);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    public Object update(final RecordVoiceWordEntity recordVoiceWordEntity, Continuation<? super Unit> continuation) {
        return CoroutinesRoom.c(this.__db, true, new Callable<Unit>() {
            @NonNull
            public Unit call() throws Exception {
                FastRecordVoiceWordDao_Impl.this.__db.beginTransaction();
                try {
                    FastRecordVoiceWordDao_Impl.this.__updateAdapterOfRecordVoiceWordEntity.handle(recordVoiceWordEntity);
                    FastRecordVoiceWordDao_Impl.this.__db.setTransactionSuccessful();
                    return Unit.INSTANCE;
                } finally {
                    FastRecordVoiceWordDao_Impl.this.__db.endTransaction();
                }
            }
        }, continuation);
    }

    public Object updateList(final List<RecordVoiceWordEntity> list, Continuation<? super Unit> continuation) {
        return CoroutinesRoom.c(this.__db, true, new Callable<Unit>() {
            @NonNull
            public Unit call() throws Exception {
                FastRecordVoiceWordDao_Impl.this.__db.beginTransaction();
                try {
                    FastRecordVoiceWordDao_Impl.this.__updateAdapterOfRecordVoiceWordEntity.handleMultiple(list);
                    FastRecordVoiceWordDao_Impl.this.__db.setTransactionSuccessful();
                    return Unit.INSTANCE;
                } finally {
                    FastRecordVoiceWordDao_Impl.this.__db.endTransaction();
                }
            }
        }, continuation);
    }
}
