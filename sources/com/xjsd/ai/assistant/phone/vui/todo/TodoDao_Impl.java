package com.xjsd.ai.assistant.phone.vui.todo;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.lifecycle.LiveData;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.xjsd.ai.assistant.protocol.VuiModelType;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

public final class TodoDao_Impl implements TodoDao {

    /* renamed from: a  reason: collision with root package name */
    public final RoomDatabase f8636a;
    public final EntityInsertionAdapter b;
    public final DateConverter c = new DateConverter();
    public final EntityDeletionOrUpdateAdapter d;
    public final EntityDeletionOrUpdateAdapter e;
    public final SharedSQLiteStatement f;
    public final SharedSQLiteStatement g;

    /* renamed from: com.xjsd.ai.assistant.phone.vui.todo.TodoDao_Impl$10  reason: invalid class name */
    class AnonymousClass10 implements Callable<List<TodoEntry>> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ RoomSQLiteQuery f8638a;
        public final /* synthetic */ TodoDao_Impl b;

        /* renamed from: a */
        public List call() {
            Long l = null;
            Cursor c = DBUtil.c(this.b.f8636a, this.f8638a, false, (CancellationSignal) null);
            try {
                int d = CursorUtil.d(c, "id");
                int d2 = CursorUtil.d(c, "target");
                int d3 = CursorUtil.d(c, "completed");
                int d4 = CursorUtil.d(c, "startTime");
                int d5 = CursorUtil.d(c, "endTime");
                int d6 = CursorUtil.d(c, RtspHeaders.Values.TIME);
                int d7 = CursorUtil.d(c, "time_text");
                int d8 = CursorUtil.d(c, "origin_query");
                int d9 = CursorUtil.d(c, "create_time");
                int d10 = CursorUtil.d(c, "update_time");
                int d11 = CursorUtil.d(c, "account_id");
                ArrayList arrayList = new ArrayList(c.getCount());
                while (c.moveToNext()) {
                    arrayList.add(new TodoEntry(c.getLong(d), c.getString(d2), c.getInt(d3) != 0, this.b.c.b(c.isNull(d4) ? l : Long.valueOf(c.getLong(d4))), this.b.c.b(c.isNull(d5) ? null : Long.valueOf(c.getLong(d5))), c.getString(d6), c.getString(d7), c.getString(d8), c.getString(d9), c.isNull(d10) ? null : c.getString(d10), c.isNull(d11) ? null : c.getString(d11)));
                    l = null;
                }
                return arrayList;
            } finally {
                c.close();
                this.f8638a.release();
            }
        }
    }

    /* renamed from: com.xjsd.ai.assistant.phone.vui.todo.TodoDao_Impl$12  reason: invalid class name */
    class AnonymousClass12 implements Callable<List<TodoEntry>> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ RoomSQLiteQuery f8640a;
        public final /* synthetic */ TodoDao_Impl b;

        /* renamed from: a */
        public List call() {
            Long l = null;
            Cursor c = DBUtil.c(this.b.f8636a, this.f8640a, false, (CancellationSignal) null);
            try {
                int d = CursorUtil.d(c, "id");
                int d2 = CursorUtil.d(c, "target");
                int d3 = CursorUtil.d(c, "completed");
                int d4 = CursorUtil.d(c, "startTime");
                int d5 = CursorUtil.d(c, "endTime");
                int d6 = CursorUtil.d(c, RtspHeaders.Values.TIME);
                int d7 = CursorUtil.d(c, "time_text");
                int d8 = CursorUtil.d(c, "origin_query");
                int d9 = CursorUtil.d(c, "create_time");
                int d10 = CursorUtil.d(c, "update_time");
                int d11 = CursorUtil.d(c, "account_id");
                ArrayList arrayList = new ArrayList(c.getCount());
                while (c.moveToNext()) {
                    arrayList.add(new TodoEntry(c.getLong(d), c.getString(d2), c.getInt(d3) != 0, this.b.c.b(c.isNull(d4) ? l : Long.valueOf(c.getLong(d4))), this.b.c.b(c.isNull(d5) ? null : Long.valueOf(c.getLong(d5))), c.getString(d6), c.getString(d7), c.getString(d8), c.getString(d9), c.isNull(d10) ? null : c.getString(d10), c.isNull(d11) ? null : c.getString(d11)));
                    l = null;
                }
                return arrayList;
            } finally {
                c.close();
                this.f8640a.release();
            }
        }
    }

    /* renamed from: com.xjsd.ai.assistant.phone.vui.todo.TodoDao_Impl$14  reason: invalid class name */
    class AnonymousClass14 implements Callable<List<TodoEntry>> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ RoomSQLiteQuery f8642a;
        public final /* synthetic */ TodoDao_Impl b;

        /* renamed from: a */
        public List call() {
            Long l = null;
            Cursor c = DBUtil.c(this.b.f8636a, this.f8642a, false, (CancellationSignal) null);
            try {
                int d = CursorUtil.d(c, "id");
                int d2 = CursorUtil.d(c, "target");
                int d3 = CursorUtil.d(c, "completed");
                int d4 = CursorUtil.d(c, "startTime");
                int d5 = CursorUtil.d(c, "endTime");
                int d6 = CursorUtil.d(c, RtspHeaders.Values.TIME);
                int d7 = CursorUtil.d(c, "time_text");
                int d8 = CursorUtil.d(c, "origin_query");
                int d9 = CursorUtil.d(c, "create_time");
                int d10 = CursorUtil.d(c, "update_time");
                int d11 = CursorUtil.d(c, "account_id");
                ArrayList arrayList = new ArrayList(c.getCount());
                while (c.moveToNext()) {
                    arrayList.add(new TodoEntry(c.getLong(d), c.getString(d2), c.getInt(d3) != 0, this.b.c.b(c.isNull(d4) ? l : Long.valueOf(c.getLong(d4))), this.b.c.b(c.isNull(d5) ? null : Long.valueOf(c.getLong(d5))), c.getString(d6), c.getString(d7), c.getString(d8), c.getString(d9), c.isNull(d10) ? null : c.getString(d10), c.isNull(d11) ? null : c.getString(d11)));
                    l = null;
                }
                return arrayList;
            } finally {
                c.close();
                this.f8642a.release();
            }
        }
    }

    /* renamed from: com.xjsd.ai.assistant.phone.vui.todo.TodoDao_Impl$9  reason: invalid class name */
    class AnonymousClass9 implements Callable<Unit> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f8653a;
        public final /* synthetic */ TodoDao_Impl b;

        /* renamed from: a */
        public Unit call() {
            SupportSQLiteStatement acquire = this.b.f.acquire();
            acquire.F(1, (long) this.f8653a);
            try {
                this.b.f8636a.beginTransaction();
                acquire.k();
                this.b.f8636a.setTransactionSuccessful();
                Unit unit = Unit.INSTANCE;
                this.b.f8636a.endTransaction();
                this.b.f.release(acquire);
                return unit;
            } catch (Throwable th) {
                this.b.f.release(acquire);
                throw th;
            }
        }
    }

    public TodoDao_Impl(RoomDatabase roomDatabase) {
        this.f8636a = roomDatabase;
        this.b = new EntityInsertionAdapter<TodoEntry>(roomDatabase) {
            public String createQuery() {
                return "INSERT OR ABORT INTO `todo` (`id`,`target`,`completed`,`startTime`,`endTime`,`time`,`time_text`,`origin_query`,`create_time`,`update_time`,`account_id`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?)";
            }

            /* renamed from: d */
            public void bind(SupportSQLiteStatement supportSQLiteStatement, TodoEntry todoEntry) {
                supportSQLiteStatement.F(1, todoEntry.getId());
                supportSQLiteStatement.B(2, todoEntry.getTarget());
                supportSQLiteStatement.F(3, todoEntry.getCompleted() ? 1 : 0);
                Long a2 = TodoDao_Impl.this.c.a(todoEntry.getStartTime());
                if (a2 == null) {
                    supportSQLiteStatement.L(4);
                } else {
                    supportSQLiteStatement.F(4, a2.longValue());
                }
                Long a3 = TodoDao_Impl.this.c.a(todoEntry.getEndTime());
                if (a3 == null) {
                    supportSQLiteStatement.L(5);
                } else {
                    supportSQLiteStatement.F(5, a3.longValue());
                }
                supportSQLiteStatement.B(6, todoEntry.getTime());
                supportSQLiteStatement.B(7, todoEntry.getTimeText());
                supportSQLiteStatement.B(8, todoEntry.getOriginQuery());
                supportSQLiteStatement.B(9, todoEntry.getCreateTime());
                if (todoEntry.getUpdateTime() == null) {
                    supportSQLiteStatement.L(10);
                } else {
                    supportSQLiteStatement.B(10, todoEntry.getUpdateTime());
                }
                if (todoEntry.getAccountId() == null) {
                    supportSQLiteStatement.L(11);
                } else {
                    supportSQLiteStatement.B(11, todoEntry.getAccountId());
                }
            }
        };
        this.d = new EntityDeletionOrUpdateAdapter<TodoEntry>(roomDatabase) {
            public String createQuery() {
                return "DELETE FROM `todo` WHERE `id` = ?";
            }

            /* renamed from: d */
            public void bind(SupportSQLiteStatement supportSQLiteStatement, TodoEntry todoEntry) {
                supportSQLiteStatement.F(1, todoEntry.getId());
            }
        };
        this.e = new EntityDeletionOrUpdateAdapter<TodoEntry>(roomDatabase) {
            public String createQuery() {
                return "UPDATE OR ABORT `todo` SET `id` = ?,`target` = ?,`completed` = ?,`startTime` = ?,`endTime` = ?,`time` = ?,`time_text` = ?,`origin_query` = ?,`create_time` = ?,`update_time` = ?,`account_id` = ? WHERE `id` = ?";
            }

            /* renamed from: d */
            public void bind(SupportSQLiteStatement supportSQLiteStatement, TodoEntry todoEntry) {
                supportSQLiteStatement.F(1, todoEntry.getId());
                supportSQLiteStatement.B(2, todoEntry.getTarget());
                supportSQLiteStatement.F(3, todoEntry.getCompleted() ? 1 : 0);
                Long a2 = TodoDao_Impl.this.c.a(todoEntry.getStartTime());
                if (a2 == null) {
                    supportSQLiteStatement.L(4);
                } else {
                    supportSQLiteStatement.F(4, a2.longValue());
                }
                Long a3 = TodoDao_Impl.this.c.a(todoEntry.getEndTime());
                if (a3 == null) {
                    supportSQLiteStatement.L(5);
                } else {
                    supportSQLiteStatement.F(5, a3.longValue());
                }
                supportSQLiteStatement.B(6, todoEntry.getTime());
                supportSQLiteStatement.B(7, todoEntry.getTimeText());
                supportSQLiteStatement.B(8, todoEntry.getOriginQuery());
                supportSQLiteStatement.B(9, todoEntry.getCreateTime());
                if (todoEntry.getUpdateTime() == null) {
                    supportSQLiteStatement.L(10);
                } else {
                    supportSQLiteStatement.B(10, todoEntry.getUpdateTime());
                }
                if (todoEntry.getAccountId() == null) {
                    supportSQLiteStatement.L(11);
                } else {
                    supportSQLiteStatement.B(11, todoEntry.getAccountId());
                }
                supportSQLiteStatement.F(12, todoEntry.getId());
            }
        };
        this.f = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "DELETE FROM todo WHERE id = ?";
            }
        };
        this.g = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "UPDATE todo SET account_id = ?";
            }
        };
    }

    public static List p() {
        return Collections.emptyList();
    }

    public Object a(final TodoEntry todoEntry, Continuation continuation) {
        return CoroutinesRoom.c(this.f8636a, true, new Callable<Long>() {
            /* renamed from: a */
            public Long call() {
                TodoDao_Impl.this.f8636a.beginTransaction();
                try {
                    Long valueOf = Long.valueOf(TodoDao_Impl.this.b.insertAndReturnId(todoEntry));
                    TodoDao_Impl.this.f8636a.setTransactionSuccessful();
                    return valueOf;
                } finally {
                    TodoDao_Impl.this.f8636a.endTransaction();
                }
            }
        }, continuation);
    }

    public Object b(String str, Continuation continuation) {
        final RoomSQLiteQuery c2 = RoomSQLiteQuery.c("SELECT * FROM todo WHERE account_id = ? ORDER BY id DESC", 1);
        c2.B(1, str);
        return CoroutinesRoom.b(this.f8636a, false, DBUtil.a(), new Callable<List<TodoEntry>>() {
            /* renamed from: a */
            public List call() {
                Long l = null;
                Cursor c = DBUtil.c(TodoDao_Impl.this.f8636a, c2, false, (CancellationSignal) null);
                try {
                    int d = CursorUtil.d(c, "id");
                    int d2 = CursorUtil.d(c, "target");
                    int d3 = CursorUtil.d(c, "completed");
                    int d4 = CursorUtil.d(c, "startTime");
                    int d5 = CursorUtil.d(c, "endTime");
                    int d6 = CursorUtil.d(c, RtspHeaders.Values.TIME);
                    int d7 = CursorUtil.d(c, "time_text");
                    int d8 = CursorUtil.d(c, "origin_query");
                    int d9 = CursorUtil.d(c, "create_time");
                    int d10 = CursorUtil.d(c, "update_time");
                    int d11 = CursorUtil.d(c, "account_id");
                    ArrayList arrayList = new ArrayList(c.getCount());
                    while (c.moveToNext()) {
                        arrayList.add(new TodoEntry(c.getLong(d), c.getString(d2), c.getInt(d3) != 0, TodoDao_Impl.this.c.b(c.isNull(d4) ? l : Long.valueOf(c.getLong(d4))), TodoDao_Impl.this.c.b(c.isNull(d5) ? null : Long.valueOf(c.getLong(d5))), c.getString(d6), c.getString(d7), c.getString(d8), c.getString(d9), c.isNull(d10) ? null : c.getString(d10), c.isNull(d11) ? null : c.getString(d11)));
                        l = null;
                    }
                    return arrayList;
                } finally {
                    c.close();
                    c2.release();
                }
            }
        }, continuation);
    }

    public Object c(final TodoEntry[] todoEntryArr, Continuation continuation) {
        return CoroutinesRoom.c(this.f8636a, true, new Callable<Unit>() {
            /* renamed from: a */
            public Unit call() {
                TodoDao_Impl.this.f8636a.beginTransaction();
                try {
                    TodoDao_Impl.this.e.handleMultiple((T[]) todoEntryArr);
                    TodoDao_Impl.this.f8636a.setTransactionSuccessful();
                    return Unit.INSTANCE;
                } finally {
                    TodoDao_Impl.this.f8636a.endTransaction();
                }
            }
        }, continuation);
    }

    public Object d(final TodoEntry[] todoEntryArr, Continuation continuation) {
        return CoroutinesRoom.c(this.f8636a, true, new Callable<Unit>() {
            /* renamed from: a */
            public Unit call() {
                TodoDao_Impl.this.f8636a.beginTransaction();
                try {
                    TodoDao_Impl.this.d.handleMultiple((T[]) todoEntryArr);
                    TodoDao_Impl.this.f8636a.setTransactionSuccessful();
                    return Unit.INSTANCE;
                } finally {
                    TodoDao_Impl.this.f8636a.endTransaction();
                }
            }
        }, continuation);
    }

    public Object e(String str, Date date, Date date2, Continuation continuation) {
        final RoomSQLiteQuery c2 = RoomSQLiteQuery.c("SELECT * FROM todo WHERE account_id = ? AND startTime BETWEEN ? AND ? ORDER BY id DESC", 3);
        c2.B(1, str);
        Long a2 = this.c.a(date);
        if (a2 == null) {
            c2.L(2);
        } else {
            c2.F(2, a2.longValue());
        }
        Long a3 = this.c.a(date2);
        if (a3 == null) {
            c2.L(3);
        } else {
            c2.F(3, a3.longValue());
        }
        return CoroutinesRoom.b(this.f8636a, false, DBUtil.a(), new Callable<List<TodoEntry>>() {
            /* renamed from: a */
            public List call() {
                Long l = null;
                Cursor c = DBUtil.c(TodoDao_Impl.this.f8636a, c2, false, (CancellationSignal) null);
                try {
                    int d = CursorUtil.d(c, "id");
                    int d2 = CursorUtil.d(c, "target");
                    int d3 = CursorUtil.d(c, "completed");
                    int d4 = CursorUtil.d(c, "startTime");
                    int d5 = CursorUtil.d(c, "endTime");
                    int d6 = CursorUtil.d(c, RtspHeaders.Values.TIME);
                    int d7 = CursorUtil.d(c, "time_text");
                    int d8 = CursorUtil.d(c, "origin_query");
                    int d9 = CursorUtil.d(c, "create_time");
                    int d10 = CursorUtil.d(c, "update_time");
                    int d11 = CursorUtil.d(c, "account_id");
                    ArrayList arrayList = new ArrayList(c.getCount());
                    while (c.moveToNext()) {
                        arrayList.add(new TodoEntry(c.getLong(d), c.getString(d2), c.getInt(d3) != 0, TodoDao_Impl.this.c.b(c.isNull(d4) ? l : Long.valueOf(c.getLong(d4))), TodoDao_Impl.this.c.b(c.isNull(d5) ? null : Long.valueOf(c.getLong(d5))), c.getString(d6), c.getString(d7), c.getString(d8), c.getString(d9), c.isNull(d10) ? null : c.getString(d10), c.isNull(d11) ? null : c.getString(d11)));
                        l = null;
                    }
                    return arrayList;
                } finally {
                    c.close();
                    c2.release();
                }
            }
        }, continuation);
    }

    public LiveData f() {
        final RoomSQLiteQuery c2 = RoomSQLiteQuery.c("SELECT * FROM todo ORDER BY id DESC", 0);
        return this.f8636a.getInvalidationTracker().e(new String[]{VuiModelType.TODO}, false, new Callable<List<TodoEntry>>() {
            /* renamed from: a */
            public List call() {
                Long l = null;
                Cursor c = DBUtil.c(TodoDao_Impl.this.f8636a, c2, false, (CancellationSignal) null);
                try {
                    int d = CursorUtil.d(c, "id");
                    int d2 = CursorUtil.d(c, "target");
                    int d3 = CursorUtil.d(c, "completed");
                    int d4 = CursorUtil.d(c, "startTime");
                    int d5 = CursorUtil.d(c, "endTime");
                    int d6 = CursorUtil.d(c, RtspHeaders.Values.TIME);
                    int d7 = CursorUtil.d(c, "time_text");
                    int d8 = CursorUtil.d(c, "origin_query");
                    int d9 = CursorUtil.d(c, "create_time");
                    int d10 = CursorUtil.d(c, "update_time");
                    int d11 = CursorUtil.d(c, "account_id");
                    ArrayList arrayList = new ArrayList(c.getCount());
                    while (c.moveToNext()) {
                        arrayList.add(new TodoEntry(c.getLong(d), c.getString(d2), c.getInt(d3) != 0, TodoDao_Impl.this.c.b(c.isNull(d4) ? l : Long.valueOf(c.getLong(d4))), TodoDao_Impl.this.c.b(c.isNull(d5) ? null : Long.valueOf(c.getLong(d5))), c.getString(d6), c.getString(d7), c.getString(d8), c.getString(d9), c.isNull(d10) ? null : c.getString(d10), c.isNull(d11) ? null : c.getString(d11)));
                        l = null;
                    }
                    return arrayList;
                } finally {
                    c.close();
                }
            }

            public void finalize() {
                c2.release();
            }
        });
    }

    public LiveData g(String str) {
        final RoomSQLiteQuery c2 = RoomSQLiteQuery.c("SELECT * FROM todo WHERE account_id = ? ORDER BY id DESC", 1);
        c2.B(1, str);
        return this.f8636a.getInvalidationTracker().e(new String[]{VuiModelType.TODO}, false, new Callable<List<TodoEntry>>() {
            /* renamed from: a */
            public List call() {
                Long l = null;
                Cursor c = DBUtil.c(TodoDao_Impl.this.f8636a, c2, false, (CancellationSignal) null);
                try {
                    int d = CursorUtil.d(c, "id");
                    int d2 = CursorUtil.d(c, "target");
                    int d3 = CursorUtil.d(c, "completed");
                    int d4 = CursorUtil.d(c, "startTime");
                    int d5 = CursorUtil.d(c, "endTime");
                    int d6 = CursorUtil.d(c, RtspHeaders.Values.TIME);
                    int d7 = CursorUtil.d(c, "time_text");
                    int d8 = CursorUtil.d(c, "origin_query");
                    int d9 = CursorUtil.d(c, "create_time");
                    int d10 = CursorUtil.d(c, "update_time");
                    int d11 = CursorUtil.d(c, "account_id");
                    ArrayList arrayList = new ArrayList(c.getCount());
                    while (c.moveToNext()) {
                        arrayList.add(new TodoEntry(c.getLong(d), c.getString(d2), c.getInt(d3) != 0, TodoDao_Impl.this.c.b(c.isNull(d4) ? l : Long.valueOf(c.getLong(d4))), TodoDao_Impl.this.c.b(c.isNull(d5) ? null : Long.valueOf(c.getLong(d5))), c.getString(d6), c.getString(d7), c.getString(d8), c.getString(d9), c.isNull(d10) ? null : c.getString(d10), c.isNull(d11) ? null : c.getString(d11)));
                        l = null;
                    }
                    return arrayList;
                } finally {
                    c.close();
                }
            }

            public void finalize() {
                c2.release();
            }
        });
    }

    public Object h(String str, Date date, Continuation continuation) {
        final RoomSQLiteQuery c2 = RoomSQLiteQuery.c("SELECT * FROM todo WHERE account_id = ? AND startTime = ? ORDER BY id DESC", 2);
        c2.B(1, str);
        Long a2 = this.c.a(date);
        if (a2 == null) {
            c2.L(2);
        } else {
            c2.F(2, a2.longValue());
        }
        return CoroutinesRoom.b(this.f8636a, false, DBUtil.a(), new Callable<List<TodoEntry>>() {
            /* renamed from: a */
            public List call() {
                Long l = null;
                Cursor c = DBUtil.c(TodoDao_Impl.this.f8636a, c2, false, (CancellationSignal) null);
                try {
                    int d = CursorUtil.d(c, "id");
                    int d2 = CursorUtil.d(c, "target");
                    int d3 = CursorUtil.d(c, "completed");
                    int d4 = CursorUtil.d(c, "startTime");
                    int d5 = CursorUtil.d(c, "endTime");
                    int d6 = CursorUtil.d(c, RtspHeaders.Values.TIME);
                    int d7 = CursorUtil.d(c, "time_text");
                    int d8 = CursorUtil.d(c, "origin_query");
                    int d9 = CursorUtil.d(c, "create_time");
                    int d10 = CursorUtil.d(c, "update_time");
                    int d11 = CursorUtil.d(c, "account_id");
                    ArrayList arrayList = new ArrayList(c.getCount());
                    while (c.moveToNext()) {
                        arrayList.add(new TodoEntry(c.getLong(d), c.getString(d2), c.getInt(d3) != 0, TodoDao_Impl.this.c.b(c.isNull(d4) ? l : Long.valueOf(c.getLong(d4))), TodoDao_Impl.this.c.b(c.isNull(d5) ? null : Long.valueOf(c.getLong(d5))), c.getString(d6), c.getString(d7), c.getString(d8), c.getString(d9), c.isNull(d10) ? null : c.getString(d10), c.isNull(d11) ? null : c.getString(d11)));
                        l = null;
                    }
                    return arrayList;
                } finally {
                    c.close();
                    c2.release();
                }
            }
        }, continuation);
    }

    public int i(String str) {
        this.f8636a.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.g.acquire();
        acquire.B(1, str);
        try {
            this.f8636a.beginTransaction();
            int k = acquire.k();
            this.f8636a.setTransactionSuccessful();
            this.f8636a.endTransaction();
            this.g.release(acquire);
            return k;
        } catch (Throwable th) {
            this.g.release(acquire);
            throw th;
        }
    }
}
