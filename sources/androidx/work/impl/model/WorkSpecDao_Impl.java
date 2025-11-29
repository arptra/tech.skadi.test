package androidx.work.impl.model;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.lifecycle.LiveData;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import androidx.work.BackoffPolicy;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.NetworkType;
import androidx.work.OutOfQuotaPolicy;
import androidx.work.WorkInfo;
import androidx.work.impl.model.WorkSpec;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;

public final class WorkSpecDao_Impl implements WorkSpecDao {

    /* renamed from: a  reason: collision with root package name */
    public final RoomDatabase f2191a;
    public final EntityInsertionAdapter b;
    public final EntityDeletionOrUpdateAdapter c;
    public final SharedSQLiteStatement d;
    public final SharedSQLiteStatement e;
    public final SharedSQLiteStatement f;
    public final SharedSQLiteStatement g;
    public final SharedSQLiteStatement h;
    public final SharedSQLiteStatement i;
    public final SharedSQLiteStatement j;
    public final SharedSQLiteStatement k;
    public final SharedSQLiteStatement l;
    public final SharedSQLiteStatement m;
    public final SharedSQLiteStatement n;
    public final SharedSQLiteStatement o;
    public final SharedSQLiteStatement p;
    public final SharedSQLiteStatement q;
    public final SharedSQLiteStatement r;

    /* renamed from: androidx.work.impl.model.WorkSpecDao_Impl$18  reason: invalid class name */
    class AnonymousClass18 implements Callable<List<String>> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ RoomSQLiteQuery f2201a;
        public final /* synthetic */ WorkSpecDao_Impl b;

        /* renamed from: a */
        public List call() {
            Cursor c;
            this.b.f2191a.beginTransaction();
            try {
                c = DBUtil.c(this.b.f2191a, this.f2201a, false, (CancellationSignal) null);
                ArrayList arrayList = new ArrayList(c.getCount());
                while (c.moveToNext()) {
                    arrayList.add(c.isNull(0) ? null : c.getString(0));
                }
                this.b.f2191a.setTransactionSuccessful();
                c.close();
                this.b.f2191a.endTransaction();
                return arrayList;
            } catch (Throwable th) {
                this.b.f2191a.endTransaction();
                throw th;
            }
        }

        public void finalize() {
            this.f2201a.release();
        }
    }

    /* renamed from: androidx.work.impl.model.WorkSpecDao_Impl$20  reason: invalid class name */
    class AnonymousClass20 implements Callable<List<WorkSpec.WorkInfoPojo>> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ RoomSQLiteQuery f2204a;
        public final /* synthetic */ WorkSpecDao_Impl b;

        /* renamed from: a */
        public List call() {
            Cursor c;
            this.b.f2191a.beginTransaction();
            try {
                c = DBUtil.c(this.b.f2191a, this.f2204a, true, (CancellationSignal) null);
                HashMap hashMap = new HashMap();
                HashMap hashMap2 = new HashMap();
                while (c.moveToNext()) {
                    String string = c.getString(0);
                    if (((ArrayList) hashMap.get(string)) == null) {
                        hashMap.put(string, new ArrayList());
                    }
                    String string2 = c.getString(0);
                    if (((ArrayList) hashMap2.get(string2)) == null) {
                        hashMap2.put(string2, new ArrayList());
                    }
                }
                c.moveToPosition(-1);
                this.b.J(hashMap);
                this.b.I(hashMap2);
                ArrayList arrayList = new ArrayList(c.getCount());
                while (c.moveToNext()) {
                    String string3 = c.isNull(0) ? null : c.getString(0);
                    WorkInfo.State f = WorkTypeConverters.f(c.getInt(1));
                    Data g = Data.g(c.isNull(2) ? null : c.getBlob(2));
                    int i = c.getInt(3);
                    int i2 = c.getInt(4);
                    long j = c.getLong(13);
                    long j2 = c.getLong(14);
                    long j3 = c.getLong(15);
                    BackoffPolicy c2 = WorkTypeConverters.c(c.getInt(16));
                    long j4 = c.getLong(17);
                    long j5 = c.getLong(18);
                    int i3 = c.getInt(19);
                    long j6 = c.getLong(20);
                    int i4 = c.getInt(21);
                    Constraints constraints = new Constraints(WorkTypeConverters.d(c.getInt(5)), c.getInt(6) != 0, c.getInt(7) != 0, c.getInt(8) != 0, c.getInt(9) != 0, c.getLong(10), c.getLong(11), WorkTypeConverters.b(c.isNull(12) ? null : c.getBlob(12)));
                    ArrayList arrayList2 = (ArrayList) hashMap.get(c.getString(0));
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList();
                    }
                    ArrayList arrayList3 = arrayList2;
                    ArrayList arrayList4 = (ArrayList) hashMap2.get(c.getString(0));
                    if (arrayList4 == null) {
                        arrayList4 = new ArrayList();
                    }
                    arrayList.add(new WorkSpec.WorkInfoPojo(string3, f, g, j, j2, j3, constraints, i, c2, j4, j5, i3, i2, j6, i4, arrayList3, arrayList4));
                }
                this.b.f2191a.setTransactionSuccessful();
                c.close();
                this.b.f2191a.endTransaction();
                return arrayList;
            } catch (Throwable th) {
                this.b.f2191a.endTransaction();
                throw th;
            }
        }

        public void finalize() {
            this.f2204a.release();
        }
    }

    /* renamed from: androidx.work.impl.model.WorkSpecDao_Impl$21  reason: invalid class name */
    class AnonymousClass21 implements Callable<List<WorkSpec.WorkInfoPojo>> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ RoomSQLiteQuery f2205a;
        public final /* synthetic */ WorkSpecDao_Impl b;

        /* renamed from: a */
        public List call() {
            Cursor c;
            this.b.f2191a.beginTransaction();
            try {
                c = DBUtil.c(this.b.f2191a, this.f2205a, true, (CancellationSignal) null);
                HashMap hashMap = new HashMap();
                HashMap hashMap2 = new HashMap();
                while (c.moveToNext()) {
                    String string = c.getString(0);
                    if (((ArrayList) hashMap.get(string)) == null) {
                        hashMap.put(string, new ArrayList());
                    }
                    String string2 = c.getString(0);
                    if (((ArrayList) hashMap2.get(string2)) == null) {
                        hashMap2.put(string2, new ArrayList());
                    }
                }
                c.moveToPosition(-1);
                this.b.J(hashMap);
                this.b.I(hashMap2);
                ArrayList arrayList = new ArrayList(c.getCount());
                while (c.moveToNext()) {
                    String string3 = c.isNull(0) ? null : c.getString(0);
                    WorkInfo.State f = WorkTypeConverters.f(c.getInt(1));
                    Data g = Data.g(c.isNull(2) ? null : c.getBlob(2));
                    int i = c.getInt(3);
                    int i2 = c.getInt(4);
                    long j = c.getLong(13);
                    long j2 = c.getLong(14);
                    long j3 = c.getLong(15);
                    BackoffPolicy c2 = WorkTypeConverters.c(c.getInt(16));
                    long j4 = c.getLong(17);
                    long j5 = c.getLong(18);
                    int i3 = c.getInt(19);
                    long j6 = c.getLong(20);
                    int i4 = c.getInt(21);
                    Constraints constraints = new Constraints(WorkTypeConverters.d(c.getInt(5)), c.getInt(6) != 0, c.getInt(7) != 0, c.getInt(8) != 0, c.getInt(9) != 0, c.getLong(10), c.getLong(11), WorkTypeConverters.b(c.isNull(12) ? null : c.getBlob(12)));
                    ArrayList arrayList2 = (ArrayList) hashMap.get(c.getString(0));
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList();
                    }
                    ArrayList arrayList3 = arrayList2;
                    ArrayList arrayList4 = (ArrayList) hashMap2.get(c.getString(0));
                    if (arrayList4 == null) {
                        arrayList4 = new ArrayList();
                    }
                    arrayList.add(new WorkSpec.WorkInfoPojo(string3, f, g, j, j2, j3, constraints, i, c2, j4, j5, i3, i2, j6, i4, arrayList3, arrayList4));
                }
                this.b.f2191a.setTransactionSuccessful();
                c.close();
                this.b.f2191a.endTransaction();
                return arrayList;
            } catch (Throwable th) {
                this.b.f2191a.endTransaction();
                throw th;
            }
        }

        public void finalize() {
            this.f2205a.release();
        }
    }

    /* renamed from: androidx.work.impl.model.WorkSpecDao_Impl$22  reason: invalid class name */
    class AnonymousClass22 implements Callable<List<WorkSpec.WorkInfoPojo>> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ RoomSQLiteQuery f2206a;
        public final /* synthetic */ WorkSpecDao_Impl b;

        /* renamed from: a */
        public List call() {
            Cursor c;
            this.b.f2191a.beginTransaction();
            try {
                c = DBUtil.c(this.b.f2191a, this.f2206a, true, (CancellationSignal) null);
                HashMap hashMap = new HashMap();
                HashMap hashMap2 = new HashMap();
                while (c.moveToNext()) {
                    String string = c.getString(0);
                    if (((ArrayList) hashMap.get(string)) == null) {
                        hashMap.put(string, new ArrayList());
                    }
                    String string2 = c.getString(0);
                    if (((ArrayList) hashMap2.get(string2)) == null) {
                        hashMap2.put(string2, new ArrayList());
                    }
                }
                c.moveToPosition(-1);
                this.b.J(hashMap);
                this.b.I(hashMap2);
                ArrayList arrayList = new ArrayList(c.getCount());
                while (c.moveToNext()) {
                    String string3 = c.isNull(0) ? null : c.getString(0);
                    WorkInfo.State f = WorkTypeConverters.f(c.getInt(1));
                    Data g = Data.g(c.isNull(2) ? null : c.getBlob(2));
                    int i = c.getInt(3);
                    int i2 = c.getInt(4);
                    long j = c.getLong(13);
                    long j2 = c.getLong(14);
                    long j3 = c.getLong(15);
                    BackoffPolicy c2 = WorkTypeConverters.c(c.getInt(16));
                    long j4 = c.getLong(17);
                    long j5 = c.getLong(18);
                    int i3 = c.getInt(19);
                    long j6 = c.getLong(20);
                    int i4 = c.getInt(21);
                    Constraints constraints = new Constraints(WorkTypeConverters.d(c.getInt(5)), c.getInt(6) != 0, c.getInt(7) != 0, c.getInt(8) != 0, c.getInt(9) != 0, c.getLong(10), c.getLong(11), WorkTypeConverters.b(c.isNull(12) ? null : c.getBlob(12)));
                    ArrayList arrayList2 = (ArrayList) hashMap.get(c.getString(0));
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList();
                    }
                    ArrayList arrayList3 = arrayList2;
                    ArrayList arrayList4 = (ArrayList) hashMap2.get(c.getString(0));
                    if (arrayList4 == null) {
                        arrayList4 = new ArrayList();
                    }
                    arrayList.add(new WorkSpec.WorkInfoPojo(string3, f, g, j, j2, j3, constraints, i, c2, j4, j5, i3, i2, j6, i4, arrayList3, arrayList4));
                }
                this.b.f2191a.setTransactionSuccessful();
                c.close();
                this.b.f2191a.endTransaction();
                return arrayList;
            } catch (Throwable th) {
                this.b.f2191a.endTransaction();
                throw th;
            }
        }

        public void finalize() {
            this.f2206a.release();
        }
    }

    /* renamed from: androidx.work.impl.model.WorkSpecDao_Impl$23  reason: invalid class name */
    class AnonymousClass23 implements Callable<List<WorkSpec.WorkInfoPojo>> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ RoomSQLiteQuery f2207a;
        public final /* synthetic */ WorkSpecDao_Impl b;

        /* renamed from: a */
        public List call() {
            Cursor c;
            this.b.f2191a.beginTransaction();
            try {
                c = DBUtil.c(this.b.f2191a, this.f2207a, true, (CancellationSignal) null);
                HashMap hashMap = new HashMap();
                HashMap hashMap2 = new HashMap();
                while (c.moveToNext()) {
                    String string = c.getString(0);
                    if (((ArrayList) hashMap.get(string)) == null) {
                        hashMap.put(string, new ArrayList());
                    }
                    String string2 = c.getString(0);
                    if (((ArrayList) hashMap2.get(string2)) == null) {
                        hashMap2.put(string2, new ArrayList());
                    }
                }
                c.moveToPosition(-1);
                this.b.J(hashMap);
                this.b.I(hashMap2);
                ArrayList arrayList = new ArrayList(c.getCount());
                while (c.moveToNext()) {
                    String string3 = c.isNull(0) ? null : c.getString(0);
                    WorkInfo.State f = WorkTypeConverters.f(c.getInt(1));
                    Data g = Data.g(c.isNull(2) ? null : c.getBlob(2));
                    int i = c.getInt(3);
                    int i2 = c.getInt(4);
                    long j = c.getLong(13);
                    long j2 = c.getLong(14);
                    long j3 = c.getLong(15);
                    BackoffPolicy c2 = WorkTypeConverters.c(c.getInt(16));
                    long j4 = c.getLong(17);
                    long j5 = c.getLong(18);
                    int i3 = c.getInt(19);
                    long j6 = c.getLong(20);
                    int i4 = c.getInt(21);
                    Constraints constraints = new Constraints(WorkTypeConverters.d(c.getInt(5)), c.getInt(6) != 0, c.getInt(7) != 0, c.getInt(8) != 0, c.getInt(9) != 0, c.getLong(10), c.getLong(11), WorkTypeConverters.b(c.isNull(12) ? null : c.getBlob(12)));
                    ArrayList arrayList2 = (ArrayList) hashMap.get(c.getString(0));
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList();
                    }
                    ArrayList arrayList3 = arrayList2;
                    ArrayList arrayList4 = (ArrayList) hashMap2.get(c.getString(0));
                    if (arrayList4 == null) {
                        arrayList4 = new ArrayList();
                    }
                    arrayList.add(new WorkSpec.WorkInfoPojo(string3, f, g, j, j2, j3, constraints, i, c2, j4, j5, i3, i2, j6, i4, arrayList3, arrayList4));
                }
                this.b.f2191a.setTransactionSuccessful();
                c.close();
                this.b.f2191a.endTransaction();
                return arrayList;
            } catch (Throwable th) {
                this.b.f2191a.endTransaction();
                throw th;
            }
        }

        public void finalize() {
            this.f2207a.release();
        }
    }

    /* renamed from: androidx.work.impl.model.WorkSpecDao_Impl$24  reason: invalid class name */
    class AnonymousClass24 implements Callable<List<WorkSpec.WorkInfoPojo>> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ RoomSQLiteQuery f2208a;
        public final /* synthetic */ WorkSpecDao_Impl b;

        /* renamed from: a */
        public List call() {
            Cursor c;
            this.b.f2191a.beginTransaction();
            try {
                c = DBUtil.c(this.b.f2191a, this.f2208a, true, (CancellationSignal) null);
                HashMap hashMap = new HashMap();
                HashMap hashMap2 = new HashMap();
                while (c.moveToNext()) {
                    String string = c.getString(0);
                    if (((ArrayList) hashMap.get(string)) == null) {
                        hashMap.put(string, new ArrayList());
                    }
                    String string2 = c.getString(0);
                    if (((ArrayList) hashMap2.get(string2)) == null) {
                        hashMap2.put(string2, new ArrayList());
                    }
                }
                c.moveToPosition(-1);
                this.b.J(hashMap);
                this.b.I(hashMap2);
                ArrayList arrayList = new ArrayList(c.getCount());
                while (c.moveToNext()) {
                    String string3 = c.isNull(0) ? null : c.getString(0);
                    WorkInfo.State f = WorkTypeConverters.f(c.getInt(1));
                    Data g = Data.g(c.isNull(2) ? null : c.getBlob(2));
                    int i = c.getInt(3);
                    int i2 = c.getInt(4);
                    long j = c.getLong(13);
                    long j2 = c.getLong(14);
                    long j3 = c.getLong(15);
                    BackoffPolicy c2 = WorkTypeConverters.c(c.getInt(16));
                    long j4 = c.getLong(17);
                    long j5 = c.getLong(18);
                    int i3 = c.getInt(19);
                    long j6 = c.getLong(20);
                    int i4 = c.getInt(21);
                    Constraints constraints = new Constraints(WorkTypeConverters.d(c.getInt(5)), c.getInt(6) != 0, c.getInt(7) != 0, c.getInt(8) != 0, c.getInt(9) != 0, c.getLong(10), c.getLong(11), WorkTypeConverters.b(c.isNull(12) ? null : c.getBlob(12)));
                    ArrayList arrayList2 = (ArrayList) hashMap.get(c.getString(0));
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList();
                    }
                    ArrayList arrayList3 = arrayList2;
                    ArrayList arrayList4 = (ArrayList) hashMap2.get(c.getString(0));
                    if (arrayList4 == null) {
                        arrayList4 = new ArrayList();
                    }
                    arrayList.add(new WorkSpec.WorkInfoPojo(string3, f, g, j, j2, j3, constraints, i, c2, j4, j5, i3, i2, j6, i4, arrayList3, arrayList4));
                }
                this.b.f2191a.setTransactionSuccessful();
                c.close();
                this.b.f2191a.endTransaction();
                return arrayList;
            } catch (Throwable th) {
                this.b.f2191a.endTransaction();
                throw th;
            }
        }

        public void finalize() {
            this.f2208a.release();
        }
    }

    /* renamed from: androidx.work.impl.model.WorkSpecDao_Impl$25  reason: invalid class name */
    class AnonymousClass25 implements Callable<Long> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ RoomSQLiteQuery f2209a;
        public final /* synthetic */ WorkSpecDao_Impl b;

        /* renamed from: a */
        public Long call() {
            Cursor c = DBUtil.c(this.b.f2191a, this.f2209a, false, (CancellationSignal) null);
            try {
                Long valueOf = Long.valueOf(c.moveToFirst() ? c.getLong(0) : 0);
                c.close();
                return valueOf;
            } catch (Throwable th) {
                c.close();
                throw th;
            }
        }

        public void finalize() {
            this.f2209a.release();
        }
    }

    public WorkSpecDao_Impl(RoomDatabase roomDatabase) {
        this.f2191a = roomDatabase;
        this.b = new EntityInsertionAdapter<WorkSpec>(roomDatabase) {
            public String createQuery() {
                return "INSERT OR IGNORE INTO `WorkSpec` (`id`,`state`,`worker_class_name`,`input_merger_class_name`,`input`,`output`,`initial_delay`,`interval_duration`,`flex_duration`,`run_attempt_count`,`backoff_policy`,`backoff_delay_duration`,`last_enqueue_time`,`minimum_retention_duration`,`schedule_requested_at`,`run_in_foreground`,`out_of_quota_policy`,`period_count`,`generation`,`next_schedule_time_override`,`next_schedule_time_override_generation`,`stop_reason`,`required_network_type`,`requires_charging`,`requires_device_idle`,`requires_battery_not_low`,`requires_storage_not_low`,`trigger_content_update_delay`,`trigger_max_content_delay`,`content_uri_triggers`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            /* renamed from: d */
            public void bind(SupportSQLiteStatement supportSQLiteStatement, WorkSpec workSpec) {
                String str = workSpec.f2184a;
                if (str == null) {
                    supportSQLiteStatement.L(1);
                } else {
                    supportSQLiteStatement.B(1, str);
                }
                WorkTypeConverters workTypeConverters = WorkTypeConverters.f2221a;
                supportSQLiteStatement.F(2, (long) WorkTypeConverters.j(workSpec.b));
                String str2 = workSpec.c;
                if (str2 == null) {
                    supportSQLiteStatement.L(3);
                } else {
                    supportSQLiteStatement.B(3, str2);
                }
                String str3 = workSpec.d;
                if (str3 == null) {
                    supportSQLiteStatement.L(4);
                } else {
                    supportSQLiteStatement.B(4, str3);
                }
                byte[] k = Data.k(workSpec.e);
                if (k == null) {
                    supportSQLiteStatement.L(5);
                } else {
                    supportSQLiteStatement.H(5, k);
                }
                byte[] k2 = Data.k(workSpec.f);
                if (k2 == null) {
                    supportSQLiteStatement.L(6);
                } else {
                    supportSQLiteStatement.H(6, k2);
                }
                supportSQLiteStatement.F(7, workSpec.g);
                supportSQLiteStatement.F(8, workSpec.h);
                supportSQLiteStatement.F(9, workSpec.i);
                supportSQLiteStatement.F(10, (long) workSpec.k);
                supportSQLiteStatement.F(11, (long) WorkTypeConverters.a(workSpec.l));
                supportSQLiteStatement.F(12, workSpec.m);
                supportSQLiteStatement.F(13, workSpec.n);
                supportSQLiteStatement.F(14, workSpec.o);
                supportSQLiteStatement.F(15, workSpec.p);
                supportSQLiteStatement.F(16, workSpec.q ? 1 : 0);
                supportSQLiteStatement.F(17, (long) WorkTypeConverters.h(workSpec.r));
                supportSQLiteStatement.F(18, (long) workSpec.g());
                supportSQLiteStatement.F(19, (long) workSpec.d());
                supportSQLiteStatement.F(20, workSpec.e());
                supportSQLiteStatement.F(21, (long) workSpec.f());
                supportSQLiteStatement.F(22, (long) workSpec.h());
                Constraints constraints = workSpec.j;
                if (constraints != null) {
                    supportSQLiteStatement.F(23, (long) WorkTypeConverters.g(constraints.d()));
                    supportSQLiteStatement.F(24, constraints.g() ? 1 : 0);
                    supportSQLiteStatement.F(25, constraints.h() ? 1 : 0);
                    supportSQLiteStatement.F(26, constraints.f() ? 1 : 0);
                    supportSQLiteStatement.F(27, constraints.i() ? 1 : 0);
                    supportSQLiteStatement.F(28, constraints.b());
                    supportSQLiteStatement.F(29, constraints.a());
                    byte[] i = WorkTypeConverters.i(constraints.c());
                    if (i == null) {
                        supportSQLiteStatement.L(30);
                    } else {
                        supportSQLiteStatement.H(30, i);
                    }
                } else {
                    supportSQLiteStatement.L(23);
                    supportSQLiteStatement.L(24);
                    supportSQLiteStatement.L(25);
                    supportSQLiteStatement.L(26);
                    supportSQLiteStatement.L(27);
                    supportSQLiteStatement.L(28);
                    supportSQLiteStatement.L(29);
                    supportSQLiteStatement.L(30);
                }
            }
        };
        this.c = new EntityDeletionOrUpdateAdapter<WorkSpec>(roomDatabase) {
            public String createQuery() {
                return "UPDATE OR ABORT `WorkSpec` SET `id` = ?,`state` = ?,`worker_class_name` = ?,`input_merger_class_name` = ?,`input` = ?,`output` = ?,`initial_delay` = ?,`interval_duration` = ?,`flex_duration` = ?,`run_attempt_count` = ?,`backoff_policy` = ?,`backoff_delay_duration` = ?,`last_enqueue_time` = ?,`minimum_retention_duration` = ?,`schedule_requested_at` = ?,`run_in_foreground` = ?,`out_of_quota_policy` = ?,`period_count` = ?,`generation` = ?,`next_schedule_time_override` = ?,`next_schedule_time_override_generation` = ?,`stop_reason` = ?,`required_network_type` = ?,`requires_charging` = ?,`requires_device_idle` = ?,`requires_battery_not_low` = ?,`requires_storage_not_low` = ?,`trigger_content_update_delay` = ?,`trigger_max_content_delay` = ?,`content_uri_triggers` = ? WHERE `id` = ?";
            }

            /* renamed from: d */
            public void bind(SupportSQLiteStatement supportSQLiteStatement, WorkSpec workSpec) {
                String str = workSpec.f2184a;
                if (str == null) {
                    supportSQLiteStatement.L(1);
                } else {
                    supportSQLiteStatement.B(1, str);
                }
                WorkTypeConverters workTypeConverters = WorkTypeConverters.f2221a;
                supportSQLiteStatement.F(2, (long) WorkTypeConverters.j(workSpec.b));
                String str2 = workSpec.c;
                if (str2 == null) {
                    supportSQLiteStatement.L(3);
                } else {
                    supportSQLiteStatement.B(3, str2);
                }
                String str3 = workSpec.d;
                if (str3 == null) {
                    supportSQLiteStatement.L(4);
                } else {
                    supportSQLiteStatement.B(4, str3);
                }
                byte[] k = Data.k(workSpec.e);
                if (k == null) {
                    supportSQLiteStatement.L(5);
                } else {
                    supportSQLiteStatement.H(5, k);
                }
                byte[] k2 = Data.k(workSpec.f);
                if (k2 == null) {
                    supportSQLiteStatement.L(6);
                } else {
                    supportSQLiteStatement.H(6, k2);
                }
                supportSQLiteStatement.F(7, workSpec.g);
                supportSQLiteStatement.F(8, workSpec.h);
                supportSQLiteStatement.F(9, workSpec.i);
                supportSQLiteStatement.F(10, (long) workSpec.k);
                supportSQLiteStatement.F(11, (long) WorkTypeConverters.a(workSpec.l));
                supportSQLiteStatement.F(12, workSpec.m);
                supportSQLiteStatement.F(13, workSpec.n);
                supportSQLiteStatement.F(14, workSpec.o);
                supportSQLiteStatement.F(15, workSpec.p);
                supportSQLiteStatement.F(16, workSpec.q ? 1 : 0);
                supportSQLiteStatement.F(17, (long) WorkTypeConverters.h(workSpec.r));
                supportSQLiteStatement.F(18, (long) workSpec.g());
                supportSQLiteStatement.F(19, (long) workSpec.d());
                supportSQLiteStatement.F(20, workSpec.e());
                supportSQLiteStatement.F(21, (long) workSpec.f());
                supportSQLiteStatement.F(22, (long) workSpec.h());
                Constraints constraints = workSpec.j;
                if (constraints != null) {
                    supportSQLiteStatement.F(23, (long) WorkTypeConverters.g(constraints.d()));
                    supportSQLiteStatement.F(24, constraints.g() ? 1 : 0);
                    supportSQLiteStatement.F(25, constraints.h() ? 1 : 0);
                    supportSQLiteStatement.F(26, constraints.f() ? 1 : 0);
                    supportSQLiteStatement.F(27, constraints.i() ? 1 : 0);
                    supportSQLiteStatement.F(28, constraints.b());
                    supportSQLiteStatement.F(29, constraints.a());
                    byte[] i = WorkTypeConverters.i(constraints.c());
                    if (i == null) {
                        supportSQLiteStatement.L(30);
                    } else {
                        supportSQLiteStatement.H(30, i);
                    }
                } else {
                    supportSQLiteStatement.L(23);
                    supportSQLiteStatement.L(24);
                    supportSQLiteStatement.L(25);
                    supportSQLiteStatement.L(26);
                    supportSQLiteStatement.L(27);
                    supportSQLiteStatement.L(28);
                    supportSQLiteStatement.L(29);
                    supportSQLiteStatement.L(30);
                }
                String str4 = workSpec.f2184a;
                if (str4 == null) {
                    supportSQLiteStatement.L(31);
                } else {
                    supportSQLiteStatement.B(31, str4);
                }
            }
        };
        this.d = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "DELETE FROM workspec WHERE id=?";
            }
        };
        this.e = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "UPDATE workspec SET state=? WHERE id=?";
            }
        };
        this.f = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "UPDATE workspec SET stop_reason = CASE WHEN state=1 THEN 1 ELSE -256 END, state=5 WHERE id=?";
            }
        };
        this.g = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "UPDATE workspec SET period_count=period_count+1 WHERE id=?";
            }
        };
        this.h = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "UPDATE workspec SET output=? WHERE id=?";
            }
        };
        this.i = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "UPDATE workspec SET last_enqueue_time=? WHERE id=?";
            }
        };
        this.j = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "UPDATE workspec SET run_attempt_count=run_attempt_count+1 WHERE id=?";
            }
        };
        this.k = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "UPDATE workspec SET run_attempt_count=0 WHERE id=?";
            }
        };
        this.l = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "UPDATE workspec SET next_schedule_time_override=? WHERE id=?";
            }
        };
        this.m = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "UPDATE workspec SET next_schedule_time_override=9223372036854775807 WHERE (id=? AND next_schedule_time_override_generation=?)";
            }
        };
        this.n = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "UPDATE workspec SET schedule_requested_at=? WHERE id=?";
            }
        };
        this.o = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "UPDATE workspec SET schedule_requested_at=-1 WHERE state NOT IN (2, 3, 5)";
            }
        };
        this.p = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "DELETE FROM workspec WHERE state IN (2, 3, 5) AND (SELECT COUNT(*)=0 FROM dependency WHERE     prerequisite_id=id AND     work_spec_id NOT IN         (SELECT id FROM workspec WHERE state IN (2, 3, 5)))";
            }
        };
        this.q = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "UPDATE workspec SET generation=generation+1 WHERE id=?";
            }
        };
        this.r = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "UPDATE workspec SET stop_reason=? WHERE id=?";
            }
        };
    }

    public static List N() {
        return Collections.emptyList();
    }

    public int A(String str, long j2) {
        this.f2191a.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.n.acquire();
        acquire.F(1, j2);
        if (str == null) {
            acquire.L(2);
        } else {
            acquire.B(2, str);
        }
        this.f2191a.beginTransaction();
        try {
            int k2 = acquire.k();
            this.f2191a.setTransactionSuccessful();
            return k2;
        } finally {
            this.f2191a.endTransaction();
            this.n.release(acquire);
        }
    }

    public List B(String str) {
        RoomSQLiteQuery c2 = RoomSQLiteQuery.c("SELECT id, state FROM workspec WHERE id IN (SELECT work_spec_id FROM workname WHERE name=?)", 1);
        if (str == null) {
            c2.L(1);
        } else {
            c2.B(1, str);
        }
        this.f2191a.assertNotSuspendingTransaction();
        Cursor c3 = DBUtil.c(this.f2191a, c2, false, (CancellationSignal) null);
        try {
            ArrayList arrayList = new ArrayList(c3.getCount());
            while (c3.moveToNext()) {
                arrayList.add(new WorkSpec.IdAndState(c3.isNull(0) ? null : c3.getString(0), WorkTypeConverters.f(c3.getInt(1))));
            }
            return arrayList;
        } finally {
            c3.close();
            c2.release();
        }
    }

    public List C(int i2) {
        RoomSQLiteQuery roomSQLiteQuery;
        boolean z;
        int i3;
        boolean z2;
        int i4;
        boolean z3;
        int i5;
        boolean z4;
        int i6;
        boolean z5;
        int i7;
        RoomSQLiteQuery c2 = RoomSQLiteQuery.c("SELECT * FROM workspec WHERE state=0 AND schedule_requested_at=-1 ORDER BY last_enqueue_time LIMIT (SELECT MAX(?-COUNT(*), 0) FROM workspec WHERE schedule_requested_at<>-1 AND LENGTH(content_uri_triggers)=0 AND state NOT IN (2, 3, 5))", 1);
        c2.F(1, (long) i2);
        this.f2191a.assertNotSuspendingTransaction();
        Cursor c3 = DBUtil.c(this.f2191a, c2, false, (CancellationSignal) null);
        try {
            int d2 = CursorUtil.d(c3, "id");
            int d3 = CursorUtil.d(c3, "state");
            int d4 = CursorUtil.d(c3, "worker_class_name");
            int d5 = CursorUtil.d(c3, "input_merger_class_name");
            int d6 = CursorUtil.d(c3, "input");
            int d7 = CursorUtil.d(c3, "output");
            int d8 = CursorUtil.d(c3, "initial_delay");
            int d9 = CursorUtil.d(c3, "interval_duration");
            int d10 = CursorUtil.d(c3, "flex_duration");
            int d11 = CursorUtil.d(c3, "run_attempt_count");
            int d12 = CursorUtil.d(c3, "backoff_policy");
            int d13 = CursorUtil.d(c3, "backoff_delay_duration");
            int d14 = CursorUtil.d(c3, "last_enqueue_time");
            int d15 = CursorUtil.d(c3, "minimum_retention_duration");
            roomSQLiteQuery = c2;
            try {
                int d16 = CursorUtil.d(c3, "schedule_requested_at");
                int d17 = CursorUtil.d(c3, "run_in_foreground");
                int d18 = CursorUtil.d(c3, "out_of_quota_policy");
                int d19 = CursorUtil.d(c3, "period_count");
                int d20 = CursorUtil.d(c3, "generation");
                int d21 = CursorUtil.d(c3, "next_schedule_time_override");
                int d22 = CursorUtil.d(c3, "next_schedule_time_override_generation");
                int d23 = CursorUtil.d(c3, "stop_reason");
                int d24 = CursorUtil.d(c3, "required_network_type");
                int d25 = CursorUtil.d(c3, "requires_charging");
                int d26 = CursorUtil.d(c3, "requires_device_idle");
                int d27 = CursorUtil.d(c3, "requires_battery_not_low");
                int d28 = CursorUtil.d(c3, "requires_storage_not_low");
                int d29 = CursorUtil.d(c3, "trigger_content_update_delay");
                int d30 = CursorUtil.d(c3, "trigger_max_content_delay");
                int d31 = CursorUtil.d(c3, "content_uri_triggers");
                int i8 = d15;
                ArrayList arrayList = new ArrayList(c3.getCount());
                while (c3.moveToNext()) {
                    String string = c3.isNull(d2) ? null : c3.getString(d2);
                    WorkInfo.State f2 = WorkTypeConverters.f(c3.getInt(d3));
                    String string2 = c3.isNull(d4) ? null : c3.getString(d4);
                    String string3 = c3.isNull(d5) ? null : c3.getString(d5);
                    Data g2 = Data.g(c3.isNull(d6) ? null : c3.getBlob(d6));
                    Data g3 = Data.g(c3.isNull(d7) ? null : c3.getBlob(d7));
                    long j2 = c3.getLong(d8);
                    long j3 = c3.getLong(d9);
                    long j4 = c3.getLong(d10);
                    int i9 = c3.getInt(d11);
                    BackoffPolicy c4 = WorkTypeConverters.c(c3.getInt(d12));
                    long j5 = c3.getLong(d13);
                    long j6 = c3.getLong(d14);
                    int i10 = i8;
                    long j7 = c3.getLong(i10);
                    int i11 = d2;
                    int i12 = d16;
                    long j8 = c3.getLong(i12);
                    d16 = i12;
                    int i13 = d17;
                    if (c3.getInt(i13) != 0) {
                        d17 = i13;
                        i3 = d18;
                        z = true;
                    } else {
                        d17 = i13;
                        i3 = d18;
                        z = false;
                    }
                    OutOfQuotaPolicy e2 = WorkTypeConverters.e(c3.getInt(i3));
                    d18 = i3;
                    int i14 = d19;
                    int i15 = c3.getInt(i14);
                    d19 = i14;
                    int i16 = d20;
                    int i17 = c3.getInt(i16);
                    d20 = i16;
                    int i18 = d21;
                    long j9 = c3.getLong(i18);
                    d21 = i18;
                    int i19 = d22;
                    int i20 = c3.getInt(i19);
                    d22 = i19;
                    int i21 = d23;
                    int i22 = c3.getInt(i21);
                    d23 = i21;
                    int i23 = d24;
                    NetworkType d32 = WorkTypeConverters.d(c3.getInt(i23));
                    d24 = i23;
                    int i24 = d25;
                    if (c3.getInt(i24) != 0) {
                        d25 = i24;
                        i4 = d26;
                        z2 = true;
                    } else {
                        d25 = i24;
                        i4 = d26;
                        z2 = false;
                    }
                    if (c3.getInt(i4) != 0) {
                        d26 = i4;
                        i5 = d27;
                        z3 = true;
                    } else {
                        d26 = i4;
                        i5 = d27;
                        z3 = false;
                    }
                    if (c3.getInt(i5) != 0) {
                        d27 = i5;
                        i6 = d28;
                        z4 = true;
                    } else {
                        d27 = i5;
                        i6 = d28;
                        z4 = false;
                    }
                    if (c3.getInt(i6) != 0) {
                        d28 = i6;
                        i7 = d29;
                        z5 = true;
                    } else {
                        d28 = i6;
                        i7 = d29;
                        z5 = false;
                    }
                    long j10 = c3.getLong(i7);
                    d29 = i7;
                    int i25 = d30;
                    long j11 = c3.getLong(i25);
                    d30 = i25;
                    int i26 = d31;
                    d31 = i26;
                    arrayList.add(new WorkSpec(string, f2, string2, string3, g2, g3, j2, j3, j4, new Constraints(d32, z2, z3, z4, z5, j10, j11, WorkTypeConverters.b(c3.isNull(i26) ? null : c3.getBlob(i26))), i9, c4, j5, j6, j7, j8, z, e2, i15, i17, j9, i20, i22));
                    d2 = i11;
                    i8 = i10;
                }
                c3.close();
                roomSQLiteQuery.release();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                c3.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = c2;
            c3.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }

    public void D(String str, Data data) {
        this.f2191a.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.h.acquire();
        byte[] k2 = Data.k(data);
        if (k2 == null) {
            acquire.L(1);
        } else {
            acquire.H(1, k2);
        }
        if (str == null) {
            acquire.L(2);
        } else {
            acquire.B(2, str);
        }
        this.f2191a.beginTransaction();
        try {
            acquire.k();
            this.f2191a.setTransactionSuccessful();
        } finally {
            this.f2191a.endTransaction();
            this.h.release(acquire);
        }
    }

    public List E() {
        RoomSQLiteQuery roomSQLiteQuery;
        boolean z;
        int i2;
        boolean z2;
        int i3;
        boolean z3;
        int i4;
        boolean z4;
        int i5;
        boolean z5;
        int i6;
        RoomSQLiteQuery c2 = RoomSQLiteQuery.c("SELECT * FROM workspec WHERE state=1", 0);
        this.f2191a.assertNotSuspendingTransaction();
        Cursor c3 = DBUtil.c(this.f2191a, c2, false, (CancellationSignal) null);
        try {
            int d2 = CursorUtil.d(c3, "id");
            int d3 = CursorUtil.d(c3, "state");
            int d4 = CursorUtil.d(c3, "worker_class_name");
            int d5 = CursorUtil.d(c3, "input_merger_class_name");
            int d6 = CursorUtil.d(c3, "input");
            int d7 = CursorUtil.d(c3, "output");
            int d8 = CursorUtil.d(c3, "initial_delay");
            int d9 = CursorUtil.d(c3, "interval_duration");
            int d10 = CursorUtil.d(c3, "flex_duration");
            int d11 = CursorUtil.d(c3, "run_attempt_count");
            int d12 = CursorUtil.d(c3, "backoff_policy");
            int d13 = CursorUtil.d(c3, "backoff_delay_duration");
            int d14 = CursorUtil.d(c3, "last_enqueue_time");
            int d15 = CursorUtil.d(c3, "minimum_retention_duration");
            roomSQLiteQuery = c2;
            try {
                int d16 = CursorUtil.d(c3, "schedule_requested_at");
                int d17 = CursorUtil.d(c3, "run_in_foreground");
                int d18 = CursorUtil.d(c3, "out_of_quota_policy");
                int d19 = CursorUtil.d(c3, "period_count");
                int d20 = CursorUtil.d(c3, "generation");
                int d21 = CursorUtil.d(c3, "next_schedule_time_override");
                int d22 = CursorUtil.d(c3, "next_schedule_time_override_generation");
                int d23 = CursorUtil.d(c3, "stop_reason");
                int d24 = CursorUtil.d(c3, "required_network_type");
                int d25 = CursorUtil.d(c3, "requires_charging");
                int d26 = CursorUtil.d(c3, "requires_device_idle");
                int d27 = CursorUtil.d(c3, "requires_battery_not_low");
                int d28 = CursorUtil.d(c3, "requires_storage_not_low");
                int d29 = CursorUtil.d(c3, "trigger_content_update_delay");
                int d30 = CursorUtil.d(c3, "trigger_max_content_delay");
                int d31 = CursorUtil.d(c3, "content_uri_triggers");
                int i7 = d15;
                ArrayList arrayList = new ArrayList(c3.getCount());
                while (c3.moveToNext()) {
                    String string = c3.isNull(d2) ? null : c3.getString(d2);
                    WorkInfo.State f2 = WorkTypeConverters.f(c3.getInt(d3));
                    String string2 = c3.isNull(d4) ? null : c3.getString(d4);
                    String string3 = c3.isNull(d5) ? null : c3.getString(d5);
                    Data g2 = Data.g(c3.isNull(d6) ? null : c3.getBlob(d6));
                    Data g3 = Data.g(c3.isNull(d7) ? null : c3.getBlob(d7));
                    long j2 = c3.getLong(d8);
                    long j3 = c3.getLong(d9);
                    long j4 = c3.getLong(d10);
                    int i8 = c3.getInt(d11);
                    BackoffPolicy c4 = WorkTypeConverters.c(c3.getInt(d12));
                    long j5 = c3.getLong(d13);
                    long j6 = c3.getLong(d14);
                    int i9 = i7;
                    long j7 = c3.getLong(i9);
                    int i10 = d2;
                    int i11 = d16;
                    long j8 = c3.getLong(i11);
                    d16 = i11;
                    int i12 = d17;
                    if (c3.getInt(i12) != 0) {
                        d17 = i12;
                        i2 = d18;
                        z = true;
                    } else {
                        d17 = i12;
                        i2 = d18;
                        z = false;
                    }
                    OutOfQuotaPolicy e2 = WorkTypeConverters.e(c3.getInt(i2));
                    d18 = i2;
                    int i13 = d19;
                    int i14 = c3.getInt(i13);
                    d19 = i13;
                    int i15 = d20;
                    int i16 = c3.getInt(i15);
                    d20 = i15;
                    int i17 = d21;
                    long j9 = c3.getLong(i17);
                    d21 = i17;
                    int i18 = d22;
                    int i19 = c3.getInt(i18);
                    d22 = i18;
                    int i20 = d23;
                    int i21 = c3.getInt(i20);
                    d23 = i20;
                    int i22 = d24;
                    NetworkType d32 = WorkTypeConverters.d(c3.getInt(i22));
                    d24 = i22;
                    int i23 = d25;
                    if (c3.getInt(i23) != 0) {
                        d25 = i23;
                        i3 = d26;
                        z2 = true;
                    } else {
                        d25 = i23;
                        i3 = d26;
                        z2 = false;
                    }
                    if (c3.getInt(i3) != 0) {
                        d26 = i3;
                        i4 = d27;
                        z3 = true;
                    } else {
                        d26 = i3;
                        i4 = d27;
                        z3 = false;
                    }
                    if (c3.getInt(i4) != 0) {
                        d27 = i4;
                        i5 = d28;
                        z4 = true;
                    } else {
                        d27 = i4;
                        i5 = d28;
                        z4 = false;
                    }
                    if (c3.getInt(i5) != 0) {
                        d28 = i5;
                        i6 = d29;
                        z5 = true;
                    } else {
                        d28 = i5;
                        i6 = d29;
                        z5 = false;
                    }
                    long j10 = c3.getLong(i6);
                    d29 = i6;
                    int i24 = d30;
                    long j11 = c3.getLong(i24);
                    d30 = i24;
                    int i25 = d31;
                    d31 = i25;
                    arrayList.add(new WorkSpec(string, f2, string2, string3, g2, g3, j2, j3, j4, new Constraints(d32, z2, z3, z4, z5, j10, j11, WorkTypeConverters.b(c3.isNull(i25) ? null : c3.getBlob(i25))), i8, c4, j5, j6, j7, j8, z, e2, i14, i16, j9, i19, i21));
                    d2 = i10;
                    i7 = i9;
                }
                c3.close();
                roomSQLiteQuery.release();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                c3.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = c2;
            c3.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }

    public List F(String str) {
        Cursor c2;
        String str2 = str;
        RoomSQLiteQuery c3 = RoomSQLiteQuery.c("SELECT id, state, output, run_attempt_count, generation, required_network_type, requires_charging,requires_device_idle, requires_battery_not_low, requires_storage_not_low, trigger_content_update_delay, trigger_max_content_delay, content_uri_triggers, initial_delay, interval_duration, flex_duration, backoff_policy, backoff_delay_duration, last_enqueue_time, period_count, next_schedule_time_override, stop_reason FROM workspec WHERE id IN\n            (SELECT work_spec_id FROM worktag WHERE tag=?)", 1);
        if (str2 == null) {
            c3.L(1);
        } else {
            c3.B(1, str2);
        }
        this.f2191a.assertNotSuspendingTransaction();
        this.f2191a.beginTransaction();
        try {
            c2 = DBUtil.c(this.f2191a, c3, true, (CancellationSignal) null);
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            while (c2.moveToNext()) {
                String string = c2.getString(0);
                if (((ArrayList) hashMap.get(string)) == null) {
                    hashMap.put(string, new ArrayList());
                }
                String string2 = c2.getString(0);
                if (((ArrayList) hashMap2.get(string2)) == null) {
                    hashMap2.put(string2, new ArrayList());
                }
            }
            c2.moveToPosition(-1);
            J(hashMap);
            I(hashMap2);
            ArrayList arrayList = new ArrayList(c2.getCount());
            while (c2.moveToNext()) {
                String string3 = c2.isNull(0) ? null : c2.getString(0);
                WorkInfo.State f2 = WorkTypeConverters.f(c2.getInt(1));
                Data g2 = Data.g(c2.isNull(2) ? null : c2.getBlob(2));
                int i2 = c2.getInt(3);
                int i3 = c2.getInt(4);
                long j2 = c2.getLong(13);
                long j3 = c2.getLong(14);
                long j4 = c2.getLong(15);
                BackoffPolicy c4 = WorkTypeConverters.c(c2.getInt(16));
                long j5 = c2.getLong(17);
                long j6 = c2.getLong(18);
                int i4 = c2.getInt(19);
                long j7 = c2.getLong(20);
                int i5 = c2.getInt(21);
                Constraints constraints = new Constraints(WorkTypeConverters.d(c2.getInt(5)), c2.getInt(6) != 0, c2.getInt(7) != 0, c2.getInt(8) != 0, c2.getInt(9) != 0, c2.getLong(10), c2.getLong(11), WorkTypeConverters.b(c2.isNull(12) ? null : c2.getBlob(12)));
                ArrayList arrayList2 = (ArrayList) hashMap.get(c2.getString(0));
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList();
                }
                ArrayList arrayList3 = arrayList2;
                ArrayList arrayList4 = (ArrayList) hashMap2.get(c2.getString(0));
                if (arrayList4 == null) {
                    arrayList4 = new ArrayList();
                }
                arrayList.add(new WorkSpec.WorkInfoPojo(string3, f2, g2, j2, j3, j4, constraints, i2, c4, j5, j6, i4, i3, j7, i5, arrayList3, arrayList4));
            }
            this.f2191a.setTransactionSuccessful();
            c2.close();
            c3.release();
            this.f2191a.endTransaction();
            return arrayList;
        } catch (Throwable th) {
            this.f2191a.endTransaction();
            throw th;
        }
    }

    public int G(String str) {
        this.f2191a.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.j.acquire();
        if (str == null) {
            acquire.L(1);
        } else {
            acquire.B(1, str);
        }
        this.f2191a.beginTransaction();
        try {
            int k2 = acquire.k();
            this.f2191a.setTransactionSuccessful();
            return k2;
        } finally {
            this.f2191a.endTransaction();
            this.j.release(acquire);
        }
    }

    public List H(List list) {
        Cursor c2;
        StringBuilder b2 = StringUtil.b();
        b2.append("SELECT id, state, output, run_attempt_count, generation, required_network_type, requires_charging,requires_device_idle, requires_battery_not_low, requires_storage_not_low, trigger_content_update_delay, trigger_max_content_delay, content_uri_triggers, initial_delay, interval_duration, flex_duration, backoff_policy, backoff_delay_duration, last_enqueue_time, period_count, next_schedule_time_override, stop_reason FROM workspec WHERE id IN (");
        int size = list.size();
        StringUtil.a(b2, size);
        b2.append(")");
        RoomSQLiteQuery c3 = RoomSQLiteQuery.c(b2.toString(), size);
        Iterator it = list.iterator();
        int i2 = 1;
        while (it.hasNext()) {
            String str = (String) it.next();
            if (str == null) {
                c3.L(i2);
            } else {
                c3.B(i2, str);
            }
            i2++;
        }
        this.f2191a.assertNotSuspendingTransaction();
        this.f2191a.beginTransaction();
        try {
            c2 = DBUtil.c(this.f2191a, c3, true, (CancellationSignal) null);
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            while (c2.moveToNext()) {
                String string = c2.getString(0);
                if (((ArrayList) hashMap.get(string)) == null) {
                    hashMap.put(string, new ArrayList());
                }
                String string2 = c2.getString(0);
                if (((ArrayList) hashMap2.get(string2)) == null) {
                    hashMap2.put(string2, new ArrayList());
                }
            }
            c2.moveToPosition(-1);
            J(hashMap);
            I(hashMap2);
            ArrayList arrayList = new ArrayList(c2.getCount());
            while (c2.moveToNext()) {
                String string3 = c2.isNull(0) ? null : c2.getString(0);
                WorkInfo.State f2 = WorkTypeConverters.f(c2.getInt(1));
                Data g2 = Data.g(c2.isNull(2) ? null : c2.getBlob(2));
                int i3 = c2.getInt(3);
                int i4 = c2.getInt(4);
                long j2 = c2.getLong(13);
                long j3 = c2.getLong(14);
                long j4 = c2.getLong(15);
                BackoffPolicy c4 = WorkTypeConverters.c(c2.getInt(16));
                long j5 = c2.getLong(17);
                long j6 = c2.getLong(18);
                int i5 = c2.getInt(19);
                long j7 = c2.getLong(20);
                int i6 = c2.getInt(21);
                Constraints constraints = new Constraints(WorkTypeConverters.d(c2.getInt(5)), c2.getInt(6) != 0, c2.getInt(7) != 0, c2.getInt(8) != 0, c2.getInt(9) != 0, c2.getLong(10), c2.getLong(11), WorkTypeConverters.b(c2.isNull(12) ? null : c2.getBlob(12)));
                ArrayList arrayList2 = (ArrayList) hashMap.get(c2.getString(0));
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList();
                }
                ArrayList arrayList3 = arrayList2;
                ArrayList arrayList4 = (ArrayList) hashMap2.get(c2.getString(0));
                if (arrayList4 == null) {
                    arrayList4 = new ArrayList();
                }
                arrayList.add(new WorkSpec.WorkInfoPojo(string3, f2, g2, j2, j3, j4, constraints, i3, c4, j5, j6, i5, i4, j7, i6, arrayList3, arrayList4));
            }
            this.f2191a.setTransactionSuccessful();
            c2.close();
            c3.release();
            this.f2191a.endTransaction();
            return arrayList;
        } catch (Throwable th) {
            this.f2191a.endTransaction();
            throw th;
        }
    }

    public final void I(HashMap hashMap) {
        int i2;
        Set<String> keySet = hashMap.keySet();
        if (!keySet.isEmpty()) {
            if (hashMap.size() > 999) {
                HashMap hashMap2 = new HashMap(999);
                loop0:
                while (true) {
                    i2 = 0;
                    for (String str : keySet) {
                        hashMap2.put(str, (ArrayList) hashMap.get(str));
                        i2++;
                        if (i2 == 999) {
                            I(hashMap2);
                            hashMap2 = new HashMap(999);
                        }
                    }
                    break loop0;
                }
                if (i2 > 0) {
                    I(hashMap2);
                    return;
                }
                return;
            }
            StringBuilder b2 = StringUtil.b();
            b2.append("SELECT `progress`,`work_spec_id` FROM `WorkProgress` WHERE `work_spec_id` IN (");
            int size = keySet.size();
            StringUtil.a(b2, size);
            b2.append(")");
            RoomSQLiteQuery c2 = RoomSQLiteQuery.c(b2.toString(), size);
            int i3 = 1;
            for (String str2 : keySet) {
                if (str2 == null) {
                    c2.L(i3);
                } else {
                    c2.B(i3, str2);
                }
                i3++;
            }
            Cursor c3 = DBUtil.c(this.f2191a, c2, false, (CancellationSignal) null);
            try {
                int c4 = CursorUtil.c(c3, "work_spec_id");
                if (c4 != -1) {
                    while (c3.moveToNext()) {
                        ArrayList arrayList = (ArrayList) hashMap.get(c3.getString(c4));
                        if (arrayList != null) {
                            arrayList.add(Data.g(c3.isNull(0) ? null : c3.getBlob(0)));
                        }
                    }
                    c3.close();
                }
            } finally {
                c3.close();
            }
        }
    }

    public final void J(HashMap hashMap) {
        int i2;
        Set<String> keySet = hashMap.keySet();
        if (!keySet.isEmpty()) {
            if (hashMap.size() > 999) {
                HashMap hashMap2 = new HashMap(999);
                loop0:
                while (true) {
                    i2 = 0;
                    for (String str : keySet) {
                        hashMap2.put(str, (ArrayList) hashMap.get(str));
                        i2++;
                        if (i2 == 999) {
                            J(hashMap2);
                            hashMap2 = new HashMap(999);
                        }
                    }
                    break loop0;
                }
                if (i2 > 0) {
                    J(hashMap2);
                    return;
                }
                return;
            }
            StringBuilder b2 = StringUtil.b();
            b2.append("SELECT `tag`,`work_spec_id` FROM `WorkTag` WHERE `work_spec_id` IN (");
            int size = keySet.size();
            StringUtil.a(b2, size);
            b2.append(")");
            RoomSQLiteQuery c2 = RoomSQLiteQuery.c(b2.toString(), size);
            int i3 = 1;
            for (String str2 : keySet) {
                if (str2 == null) {
                    c2.L(i3);
                } else {
                    c2.B(i3, str2);
                }
                i3++;
            }
            Cursor c3 = DBUtil.c(this.f2191a, c2, false, (CancellationSignal) null);
            try {
                int c4 = CursorUtil.c(c3, "work_spec_id");
                if (c4 != -1) {
                    while (c3.moveToNext()) {
                        ArrayList arrayList = (ArrayList) hashMap.get(c3.getString(c4));
                        if (arrayList != null) {
                            arrayList.add(c3.isNull(0) ? null : c3.getString(0));
                        }
                    }
                    c3.close();
                }
            } finally {
                c3.close();
            }
        }
    }

    public void a(String str) {
        this.f2191a.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.d.acquire();
        if (str == null) {
            acquire.L(1);
        } else {
            acquire.B(1, str);
        }
        this.f2191a.beginTransaction();
        try {
            acquire.k();
            this.f2191a.setTransactionSuccessful();
        } finally {
            this.f2191a.endTransaction();
            this.d.release(acquire);
        }
    }

    public void b() {
        this.f2191a.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.p.acquire();
        this.f2191a.beginTransaction();
        try {
            acquire.k();
            this.f2191a.setTransactionSuccessful();
        } finally {
            this.f2191a.endTransaction();
            this.p.release(acquire);
        }
    }

    public void c(String str, int i2) {
        this.f2191a.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.r.acquire();
        acquire.F(1, (long) i2);
        if (str == null) {
            acquire.L(2);
        } else {
            acquire.B(2, str);
        }
        this.f2191a.beginTransaction();
        try {
            acquire.k();
            this.f2191a.setTransactionSuccessful();
        } finally {
            this.f2191a.endTransaction();
            this.r.release(acquire);
        }
    }

    public void d(WorkSpec workSpec) {
        this.f2191a.assertNotSuspendingTransaction();
        this.f2191a.beginTransaction();
        try {
            this.b.insert(workSpec);
            this.f2191a.setTransactionSuccessful();
        } finally {
            this.f2191a.endTransaction();
        }
    }

    public List e(String str) {
        RoomSQLiteQuery c2 = RoomSQLiteQuery.c("SELECT id FROM workspec WHERE state NOT IN (2, 3, 5) AND id IN (SELECT work_spec_id FROM workname WHERE name=?)", 1);
        if (str == null) {
            c2.L(1);
        } else {
            c2.B(1, str);
        }
        this.f2191a.assertNotSuspendingTransaction();
        Cursor c3 = DBUtil.c(this.f2191a, c2, false, (CancellationSignal) null);
        try {
            ArrayList arrayList = new ArrayList(c3.getCount());
            while (c3.moveToNext()) {
                arrayList.add(c3.isNull(0) ? null : c3.getString(0));
            }
            return arrayList;
        } finally {
            c3.close();
            c2.release();
        }
    }

    public WorkInfo.State f(String str) {
        RoomSQLiteQuery c2 = RoomSQLiteQuery.c("SELECT state FROM workspec WHERE id=?", 1);
        if (str == null) {
            c2.L(1);
        } else {
            c2.B(1, str);
        }
        this.f2191a.assertNotSuspendingTransaction();
        WorkInfo.State state = null;
        Cursor c3 = DBUtil.c(this.f2191a, c2, false, (CancellationSignal) null);
        try {
            if (c3.moveToFirst()) {
                Integer valueOf = c3.isNull(0) ? null : Integer.valueOf(c3.getInt(0));
                if (valueOf != null) {
                    WorkTypeConverters workTypeConverters = WorkTypeConverters.f2221a;
                    state = WorkTypeConverters.f(valueOf.intValue());
                }
            }
            return state;
        } finally {
            c3.close();
            c2.release();
        }
    }

    public int g(String str) {
        this.f2191a.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.f.acquire();
        if (str == null) {
            acquire.L(1);
        } else {
            acquire.B(1, str);
        }
        this.f2191a.beginTransaction();
        try {
            int k2 = acquire.k();
            this.f2191a.setTransactionSuccessful();
            return k2;
        } finally {
            this.f2191a.endTransaction();
            this.f.release(acquire);
        }
    }

    public List h(String str) {
        RoomSQLiteQuery c2 = RoomSQLiteQuery.c("SELECT id FROM workspec WHERE state NOT IN (2, 3, 5) AND id IN (SELECT work_spec_id FROM worktag WHERE tag=?)", 1);
        if (str == null) {
            c2.L(1);
        } else {
            c2.B(1, str);
        }
        this.f2191a.assertNotSuspendingTransaction();
        Cursor c3 = DBUtil.c(this.f2191a, c2, false, (CancellationSignal) null);
        try {
            ArrayList arrayList = new ArrayList(c3.getCount());
            while (c3.moveToNext()) {
                arrayList.add(c3.isNull(0) ? null : c3.getString(0));
            }
            return arrayList;
        } finally {
            c3.close();
            c2.release();
        }
    }

    public List i(String str) {
        RoomSQLiteQuery c2 = RoomSQLiteQuery.c("SELECT output FROM workspec WHERE id IN\n             (SELECT prerequisite_id FROM dependency WHERE work_spec_id=?)", 1);
        if (str == null) {
            c2.L(1);
        } else {
            c2.B(1, str);
        }
        this.f2191a.assertNotSuspendingTransaction();
        Cursor c3 = DBUtil.c(this.f2191a, c2, false, (CancellationSignal) null);
        try {
            ArrayList arrayList = new ArrayList(c3.getCount());
            while (c3.moveToNext()) {
                arrayList.add(Data.g(c3.isNull(0) ? null : c3.getBlob(0)));
            }
            return arrayList;
        } finally {
            c3.close();
            c2.release();
        }
    }

    public List j(String str) {
        Cursor c2;
        String str2 = str;
        RoomSQLiteQuery c3 = RoomSQLiteQuery.c("SELECT id, state, output, run_attempt_count, generation, required_network_type, requires_charging,requires_device_idle, requires_battery_not_low, requires_storage_not_low, trigger_content_update_delay, trigger_max_content_delay, content_uri_triggers, initial_delay, interval_duration, flex_duration, backoff_policy, backoff_delay_duration, last_enqueue_time, period_count, next_schedule_time_override, stop_reason FROM workspec WHERE id IN (SELECT work_spec_id FROM workname WHERE name=?)", 1);
        if (str2 == null) {
            c3.L(1);
        } else {
            c3.B(1, str2);
        }
        this.f2191a.assertNotSuspendingTransaction();
        this.f2191a.beginTransaction();
        try {
            c2 = DBUtil.c(this.f2191a, c3, true, (CancellationSignal) null);
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            while (c2.moveToNext()) {
                String string = c2.getString(0);
                if (((ArrayList) hashMap.get(string)) == null) {
                    hashMap.put(string, new ArrayList());
                }
                String string2 = c2.getString(0);
                if (((ArrayList) hashMap2.get(string2)) == null) {
                    hashMap2.put(string2, new ArrayList());
                }
            }
            c2.moveToPosition(-1);
            J(hashMap);
            I(hashMap2);
            ArrayList arrayList = new ArrayList(c2.getCount());
            while (c2.moveToNext()) {
                String string3 = c2.isNull(0) ? null : c2.getString(0);
                WorkInfo.State f2 = WorkTypeConverters.f(c2.getInt(1));
                Data g2 = Data.g(c2.isNull(2) ? null : c2.getBlob(2));
                int i2 = c2.getInt(3);
                int i3 = c2.getInt(4);
                long j2 = c2.getLong(13);
                long j3 = c2.getLong(14);
                long j4 = c2.getLong(15);
                BackoffPolicy c4 = WorkTypeConverters.c(c2.getInt(16));
                long j5 = c2.getLong(17);
                long j6 = c2.getLong(18);
                int i4 = c2.getInt(19);
                long j7 = c2.getLong(20);
                int i5 = c2.getInt(21);
                Constraints constraints = new Constraints(WorkTypeConverters.d(c2.getInt(5)), c2.getInt(6) != 0, c2.getInt(7) != 0, c2.getInt(8) != 0, c2.getInt(9) != 0, c2.getLong(10), c2.getLong(11), WorkTypeConverters.b(c2.isNull(12) ? null : c2.getBlob(12)));
                ArrayList arrayList2 = (ArrayList) hashMap.get(c2.getString(0));
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList();
                }
                ArrayList arrayList3 = arrayList2;
                ArrayList arrayList4 = (ArrayList) hashMap2.get(c2.getString(0));
                if (arrayList4 == null) {
                    arrayList4 = new ArrayList();
                }
                arrayList.add(new WorkSpec.WorkInfoPojo(string3, f2, g2, j2, j3, j4, constraints, i2, c4, j5, j6, i4, i3, j7, i5, arrayList3, arrayList4));
            }
            this.f2191a.setTransactionSuccessful();
            c2.close();
            c3.release();
            this.f2191a.endTransaction();
            return arrayList;
        } catch (Throwable th) {
            this.f2191a.endTransaction();
            throw th;
        }
    }

    public List k(int i2) {
        RoomSQLiteQuery roomSQLiteQuery;
        boolean z;
        int i3;
        boolean z2;
        int i4;
        boolean z3;
        int i5;
        boolean z4;
        int i6;
        boolean z5;
        int i7;
        RoomSQLiteQuery c2 = RoomSQLiteQuery.c("SELECT * FROM workspec WHERE state=0 ORDER BY last_enqueue_time LIMIT ?", 1);
        c2.F(1, (long) i2);
        this.f2191a.assertNotSuspendingTransaction();
        Cursor c3 = DBUtil.c(this.f2191a, c2, false, (CancellationSignal) null);
        try {
            int d2 = CursorUtil.d(c3, "id");
            int d3 = CursorUtil.d(c3, "state");
            int d4 = CursorUtil.d(c3, "worker_class_name");
            int d5 = CursorUtil.d(c3, "input_merger_class_name");
            int d6 = CursorUtil.d(c3, "input");
            int d7 = CursorUtil.d(c3, "output");
            int d8 = CursorUtil.d(c3, "initial_delay");
            int d9 = CursorUtil.d(c3, "interval_duration");
            int d10 = CursorUtil.d(c3, "flex_duration");
            int d11 = CursorUtil.d(c3, "run_attempt_count");
            int d12 = CursorUtil.d(c3, "backoff_policy");
            int d13 = CursorUtil.d(c3, "backoff_delay_duration");
            int d14 = CursorUtil.d(c3, "last_enqueue_time");
            int d15 = CursorUtil.d(c3, "minimum_retention_duration");
            roomSQLiteQuery = c2;
            try {
                int d16 = CursorUtil.d(c3, "schedule_requested_at");
                int d17 = CursorUtil.d(c3, "run_in_foreground");
                int d18 = CursorUtil.d(c3, "out_of_quota_policy");
                int d19 = CursorUtil.d(c3, "period_count");
                int d20 = CursorUtil.d(c3, "generation");
                int d21 = CursorUtil.d(c3, "next_schedule_time_override");
                int d22 = CursorUtil.d(c3, "next_schedule_time_override_generation");
                int d23 = CursorUtil.d(c3, "stop_reason");
                int d24 = CursorUtil.d(c3, "required_network_type");
                int d25 = CursorUtil.d(c3, "requires_charging");
                int d26 = CursorUtil.d(c3, "requires_device_idle");
                int d27 = CursorUtil.d(c3, "requires_battery_not_low");
                int d28 = CursorUtil.d(c3, "requires_storage_not_low");
                int d29 = CursorUtil.d(c3, "trigger_content_update_delay");
                int d30 = CursorUtil.d(c3, "trigger_max_content_delay");
                int d31 = CursorUtil.d(c3, "content_uri_triggers");
                int i8 = d15;
                ArrayList arrayList = new ArrayList(c3.getCount());
                while (c3.moveToNext()) {
                    String string = c3.isNull(d2) ? null : c3.getString(d2);
                    WorkInfo.State f2 = WorkTypeConverters.f(c3.getInt(d3));
                    String string2 = c3.isNull(d4) ? null : c3.getString(d4);
                    String string3 = c3.isNull(d5) ? null : c3.getString(d5);
                    Data g2 = Data.g(c3.isNull(d6) ? null : c3.getBlob(d6));
                    Data g3 = Data.g(c3.isNull(d7) ? null : c3.getBlob(d7));
                    long j2 = c3.getLong(d8);
                    long j3 = c3.getLong(d9);
                    long j4 = c3.getLong(d10);
                    int i9 = c3.getInt(d11);
                    BackoffPolicy c4 = WorkTypeConverters.c(c3.getInt(d12));
                    long j5 = c3.getLong(d13);
                    long j6 = c3.getLong(d14);
                    int i10 = i8;
                    long j7 = c3.getLong(i10);
                    int i11 = d2;
                    int i12 = d16;
                    long j8 = c3.getLong(i12);
                    d16 = i12;
                    int i13 = d17;
                    if (c3.getInt(i13) != 0) {
                        d17 = i13;
                        i3 = d18;
                        z = true;
                    } else {
                        d17 = i13;
                        i3 = d18;
                        z = false;
                    }
                    OutOfQuotaPolicy e2 = WorkTypeConverters.e(c3.getInt(i3));
                    d18 = i3;
                    int i14 = d19;
                    int i15 = c3.getInt(i14);
                    d19 = i14;
                    int i16 = d20;
                    int i17 = c3.getInt(i16);
                    d20 = i16;
                    int i18 = d21;
                    long j9 = c3.getLong(i18);
                    d21 = i18;
                    int i19 = d22;
                    int i20 = c3.getInt(i19);
                    d22 = i19;
                    int i21 = d23;
                    int i22 = c3.getInt(i21);
                    d23 = i21;
                    int i23 = d24;
                    NetworkType d32 = WorkTypeConverters.d(c3.getInt(i23));
                    d24 = i23;
                    int i24 = d25;
                    if (c3.getInt(i24) != 0) {
                        d25 = i24;
                        i4 = d26;
                        z2 = true;
                    } else {
                        d25 = i24;
                        i4 = d26;
                        z2 = false;
                    }
                    if (c3.getInt(i4) != 0) {
                        d26 = i4;
                        i5 = d27;
                        z3 = true;
                    } else {
                        d26 = i4;
                        i5 = d27;
                        z3 = false;
                    }
                    if (c3.getInt(i5) != 0) {
                        d27 = i5;
                        i6 = d28;
                        z4 = true;
                    } else {
                        d27 = i5;
                        i6 = d28;
                        z4 = false;
                    }
                    if (c3.getInt(i6) != 0) {
                        d28 = i6;
                        i7 = d29;
                        z5 = true;
                    } else {
                        d28 = i6;
                        i7 = d29;
                        z5 = false;
                    }
                    long j10 = c3.getLong(i7);
                    d29 = i7;
                    int i25 = d30;
                    long j11 = c3.getLong(i25);
                    d30 = i25;
                    int i26 = d31;
                    d31 = i26;
                    arrayList.add(new WorkSpec(string, f2, string2, string3, g2, g3, j2, j3, j4, new Constraints(d32, z2, z3, z4, z5, j10, j11, WorkTypeConverters.b(c3.isNull(i26) ? null : c3.getBlob(i26))), i9, c4, j5, j6, j7, j8, z, e2, i15, i17, j9, i20, i22));
                    d2 = i11;
                    i8 = i10;
                }
                c3.close();
                roomSQLiteQuery.release();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                c3.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = c2;
            c3.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }

    public int l(WorkInfo.State state, String str) {
        this.f2191a.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.e.acquire();
        acquire.F(1, (long) WorkTypeConverters.j(state));
        if (str == null) {
            acquire.L(2);
        } else {
            acquire.B(2, str);
        }
        this.f2191a.beginTransaction();
        try {
            int k2 = acquire.k();
            this.f2191a.setTransactionSuccessful();
            return k2;
        } finally {
            this.f2191a.endTransaction();
            this.e.release(acquire);
        }
    }

    public void m(String str, long j2) {
        this.f2191a.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.i.acquire();
        acquire.F(1, j2);
        if (str == null) {
            acquire.L(2);
        } else {
            acquire.B(2, str);
        }
        this.f2191a.beginTransaction();
        try {
            acquire.k();
            this.f2191a.setTransactionSuccessful();
        } finally {
            this.f2191a.endTransaction();
            this.i.release(acquire);
        }
    }

    public List n() {
        RoomSQLiteQuery c2 = RoomSQLiteQuery.c("SELECT id FROM workspec WHERE state NOT IN (2, 3, 5)", 0);
        this.f2191a.assertNotSuspendingTransaction();
        Cursor c3 = DBUtil.c(this.f2191a, c2, false, (CancellationSignal) null);
        try {
            ArrayList arrayList = new ArrayList(c3.getCount());
            while (c3.moveToNext()) {
                arrayList.add(c3.isNull(0) ? null : c3.getString(0));
            }
            return arrayList;
        } finally {
            c3.close();
            c2.release();
        }
    }

    public boolean o() {
        boolean z = false;
        RoomSQLiteQuery c2 = RoomSQLiteQuery.c("SELECT COUNT(*) > 0 FROM workspec WHERE state NOT IN (2, 3, 5) LIMIT 1", 0);
        this.f2191a.assertNotSuspendingTransaction();
        Cursor c3 = DBUtil.c(this.f2191a, c2, false, (CancellationSignal) null);
        try {
            if (c3.moveToFirst() && c3.getInt(0) != 0) {
                z = true;
            }
            return z;
        } finally {
            c3.close();
            c2.release();
        }
    }

    public List p() {
        RoomSQLiteQuery roomSQLiteQuery;
        boolean z;
        int i2;
        boolean z2;
        int i3;
        boolean z3;
        int i4;
        boolean z4;
        int i5;
        boolean z5;
        int i6;
        RoomSQLiteQuery c2 = RoomSQLiteQuery.c("SELECT * FROM workspec WHERE state=0 AND schedule_requested_at=-1 AND LENGTH(content_uri_triggers)<>0 ORDER BY last_enqueue_time", 0);
        this.f2191a.assertNotSuspendingTransaction();
        Cursor c3 = DBUtil.c(this.f2191a, c2, false, (CancellationSignal) null);
        try {
            int d2 = CursorUtil.d(c3, "id");
            int d3 = CursorUtil.d(c3, "state");
            int d4 = CursorUtil.d(c3, "worker_class_name");
            int d5 = CursorUtil.d(c3, "input_merger_class_name");
            int d6 = CursorUtil.d(c3, "input");
            int d7 = CursorUtil.d(c3, "output");
            int d8 = CursorUtil.d(c3, "initial_delay");
            int d9 = CursorUtil.d(c3, "interval_duration");
            int d10 = CursorUtil.d(c3, "flex_duration");
            int d11 = CursorUtil.d(c3, "run_attempt_count");
            int d12 = CursorUtil.d(c3, "backoff_policy");
            int d13 = CursorUtil.d(c3, "backoff_delay_duration");
            int d14 = CursorUtil.d(c3, "last_enqueue_time");
            int d15 = CursorUtil.d(c3, "minimum_retention_duration");
            roomSQLiteQuery = c2;
            try {
                int d16 = CursorUtil.d(c3, "schedule_requested_at");
                int d17 = CursorUtil.d(c3, "run_in_foreground");
                int d18 = CursorUtil.d(c3, "out_of_quota_policy");
                int d19 = CursorUtil.d(c3, "period_count");
                int d20 = CursorUtil.d(c3, "generation");
                int d21 = CursorUtil.d(c3, "next_schedule_time_override");
                int d22 = CursorUtil.d(c3, "next_schedule_time_override_generation");
                int d23 = CursorUtil.d(c3, "stop_reason");
                int d24 = CursorUtil.d(c3, "required_network_type");
                int d25 = CursorUtil.d(c3, "requires_charging");
                int d26 = CursorUtil.d(c3, "requires_device_idle");
                int d27 = CursorUtil.d(c3, "requires_battery_not_low");
                int d28 = CursorUtil.d(c3, "requires_storage_not_low");
                int d29 = CursorUtil.d(c3, "trigger_content_update_delay");
                int d30 = CursorUtil.d(c3, "trigger_max_content_delay");
                int d31 = CursorUtil.d(c3, "content_uri_triggers");
                int i7 = d15;
                ArrayList arrayList = new ArrayList(c3.getCount());
                while (c3.moveToNext()) {
                    String string = c3.isNull(d2) ? null : c3.getString(d2);
                    WorkInfo.State f2 = WorkTypeConverters.f(c3.getInt(d3));
                    String string2 = c3.isNull(d4) ? null : c3.getString(d4);
                    String string3 = c3.isNull(d5) ? null : c3.getString(d5);
                    Data g2 = Data.g(c3.isNull(d6) ? null : c3.getBlob(d6));
                    Data g3 = Data.g(c3.isNull(d7) ? null : c3.getBlob(d7));
                    long j2 = c3.getLong(d8);
                    long j3 = c3.getLong(d9);
                    long j4 = c3.getLong(d10);
                    int i8 = c3.getInt(d11);
                    BackoffPolicy c4 = WorkTypeConverters.c(c3.getInt(d12));
                    long j5 = c3.getLong(d13);
                    long j6 = c3.getLong(d14);
                    int i9 = i7;
                    long j7 = c3.getLong(i9);
                    int i10 = d2;
                    int i11 = d16;
                    long j8 = c3.getLong(i11);
                    d16 = i11;
                    int i12 = d17;
                    if (c3.getInt(i12) != 0) {
                        d17 = i12;
                        i2 = d18;
                        z = true;
                    } else {
                        d17 = i12;
                        i2 = d18;
                        z = false;
                    }
                    OutOfQuotaPolicy e2 = WorkTypeConverters.e(c3.getInt(i2));
                    d18 = i2;
                    int i13 = d19;
                    int i14 = c3.getInt(i13);
                    d19 = i13;
                    int i15 = d20;
                    int i16 = c3.getInt(i15);
                    d20 = i15;
                    int i17 = d21;
                    long j9 = c3.getLong(i17);
                    d21 = i17;
                    int i18 = d22;
                    int i19 = c3.getInt(i18);
                    d22 = i18;
                    int i20 = d23;
                    int i21 = c3.getInt(i20);
                    d23 = i20;
                    int i22 = d24;
                    NetworkType d32 = WorkTypeConverters.d(c3.getInt(i22));
                    d24 = i22;
                    int i23 = d25;
                    if (c3.getInt(i23) != 0) {
                        d25 = i23;
                        i3 = d26;
                        z2 = true;
                    } else {
                        d25 = i23;
                        i3 = d26;
                        z2 = false;
                    }
                    if (c3.getInt(i3) != 0) {
                        d26 = i3;
                        i4 = d27;
                        z3 = true;
                    } else {
                        d26 = i3;
                        i4 = d27;
                        z3 = false;
                    }
                    if (c3.getInt(i4) != 0) {
                        d27 = i4;
                        i5 = d28;
                        z4 = true;
                    } else {
                        d27 = i4;
                        i5 = d28;
                        z4 = false;
                    }
                    if (c3.getInt(i5) != 0) {
                        d28 = i5;
                        i6 = d29;
                        z5 = true;
                    } else {
                        d28 = i5;
                        i6 = d29;
                        z5 = false;
                    }
                    long j10 = c3.getLong(i6);
                    d29 = i6;
                    int i24 = d30;
                    long j11 = c3.getLong(i24);
                    d30 = i24;
                    int i25 = d31;
                    d31 = i25;
                    arrayList.add(new WorkSpec(string, f2, string2, string3, g2, g3, j2, j3, j4, new Constraints(d32, z2, z3, z4, z5, j10, j11, WorkTypeConverters.b(c3.isNull(i25) ? null : c3.getBlob(i25))), i8, c4, j5, j6, j7, j8, z, e2, i14, i16, j9, i19, i21));
                    d2 = i10;
                    i7 = i9;
                }
                c3.close();
                roomSQLiteQuery.release();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                c3.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = c2;
            c3.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }

    public int q(String str) {
        this.f2191a.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.k.acquire();
        if (str == null) {
            acquire.L(1);
        } else {
            acquire.B(1, str);
        }
        this.f2191a.beginTransaction();
        try {
            int k2 = acquire.k();
            this.f2191a.setTransactionSuccessful();
            return k2;
        } finally {
            this.f2191a.endTransaction();
            this.k.release(acquire);
        }
    }

    public LiveData r(List list) {
        StringBuilder b2 = StringUtil.b();
        b2.append("SELECT id, state, output, run_attempt_count, generation, required_network_type, requires_charging,requires_device_idle, requires_battery_not_low, requires_storage_not_low, trigger_content_update_delay, trigger_max_content_delay, content_uri_triggers, initial_delay, interval_duration, flex_duration, backoff_policy, backoff_delay_duration, last_enqueue_time, period_count, next_schedule_time_override, stop_reason FROM workspec WHERE id IN (");
        int size = list.size();
        StringUtil.a(b2, size);
        b2.append(")");
        final RoomSQLiteQuery c2 = RoomSQLiteQuery.c(b2.toString(), size);
        Iterator it = list.iterator();
        int i2 = 1;
        while (it.hasNext()) {
            String str = (String) it.next();
            if (str == null) {
                c2.L(i2);
            } else {
                c2.B(i2, str);
            }
            i2++;
        }
        return this.f2191a.getInvalidationTracker().e(new String[]{"WorkTag", "WorkProgress", "workspec"}, true, new Callable<List<WorkSpec.WorkInfoPojo>>() {
            /* renamed from: a */
            public List call() {
                Cursor c;
                WorkSpecDao_Impl.this.f2191a.beginTransaction();
                try {
                    c = DBUtil.c(WorkSpecDao_Impl.this.f2191a, c2, true, (CancellationSignal) null);
                    HashMap hashMap = new HashMap();
                    HashMap hashMap2 = new HashMap();
                    while (c.moveToNext()) {
                        String string = c.getString(0);
                        if (((ArrayList) hashMap.get(string)) == null) {
                            hashMap.put(string, new ArrayList());
                        }
                        String string2 = c.getString(0);
                        if (((ArrayList) hashMap2.get(string2)) == null) {
                            hashMap2.put(string2, new ArrayList());
                        }
                    }
                    c.moveToPosition(-1);
                    WorkSpecDao_Impl.this.J(hashMap);
                    WorkSpecDao_Impl.this.I(hashMap2);
                    ArrayList arrayList = new ArrayList(c.getCount());
                    while (c.moveToNext()) {
                        String string3 = c.isNull(0) ? null : c.getString(0);
                        WorkInfo.State f = WorkTypeConverters.f(c.getInt(1));
                        Data g = Data.g(c.isNull(2) ? null : c.getBlob(2));
                        int i = c.getInt(3);
                        int i2 = c.getInt(4);
                        long j = c.getLong(13);
                        long j2 = c.getLong(14);
                        long j3 = c.getLong(15);
                        BackoffPolicy c2 = WorkTypeConverters.c(c.getInt(16));
                        long j4 = c.getLong(17);
                        long j5 = c.getLong(18);
                        int i3 = c.getInt(19);
                        long j6 = c.getLong(20);
                        int i4 = c.getInt(21);
                        Constraints constraints = new Constraints(WorkTypeConverters.d(c.getInt(5)), c.getInt(6) != 0, c.getInt(7) != 0, c.getInt(8) != 0, c.getInt(9) != 0, c.getLong(10), c.getLong(11), WorkTypeConverters.b(c.isNull(12) ? null : c.getBlob(12)));
                        ArrayList arrayList2 = (ArrayList) hashMap.get(c.getString(0));
                        if (arrayList2 == null) {
                            arrayList2 = new ArrayList();
                        }
                        ArrayList arrayList3 = arrayList2;
                        ArrayList arrayList4 = (ArrayList) hashMap2.get(c.getString(0));
                        if (arrayList4 == null) {
                            arrayList4 = new ArrayList();
                        }
                        arrayList.add(new WorkSpec.WorkInfoPojo(string3, f, g, j, j2, j3, constraints, i, c2, j4, j5, i3, i2, j6, i4, arrayList3, arrayList4));
                    }
                    WorkSpecDao_Impl.this.f2191a.setTransactionSuccessful();
                    c.close();
                    WorkSpecDao_Impl.this.f2191a.endTransaction();
                    return arrayList;
                } catch (Throwable th) {
                    WorkSpecDao_Impl.this.f2191a.endTransaction();
                    throw th;
                }
            }

            public void finalize() {
                c2.release();
            }
        });
    }

    public int s() {
        int i2 = 0;
        RoomSQLiteQuery c2 = RoomSQLiteQuery.c("Select COUNT(*) FROM workspec WHERE LENGTH(content_uri_triggers)<>0 AND state NOT IN (2, 3, 5)", 0);
        this.f2191a.assertNotSuspendingTransaction();
        Cursor c3 = DBUtil.c(this.f2191a, c2, false, (CancellationSignal) null);
        try {
            if (c3.moveToFirst()) {
                i2 = c3.getInt(0);
            }
            return i2;
        } finally {
            c3.close();
            c2.release();
        }
    }

    public void t(String str, int i2) {
        this.f2191a.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.m.acquire();
        if (str == null) {
            acquire.L(1);
        } else {
            acquire.B(1, str);
        }
        acquire.F(2, (long) i2);
        this.f2191a.beginTransaction();
        try {
            acquire.k();
            this.f2191a.setTransactionSuccessful();
        } finally {
            this.f2191a.endTransaction();
            this.m.release(acquire);
        }
    }

    public void u(String str) {
        this.f2191a.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.g.acquire();
        if (str == null) {
            acquire.L(1);
        } else {
            acquire.B(1, str);
        }
        this.f2191a.beginTransaction();
        try {
            acquire.k();
            this.f2191a.setTransactionSuccessful();
        } finally {
            this.f2191a.endTransaction();
            this.g.release(acquire);
        }
    }

    public List v(long j2) {
        RoomSQLiteQuery roomSQLiteQuery;
        boolean z;
        int i2;
        boolean z2;
        int i3;
        boolean z3;
        int i4;
        boolean z4;
        int i5;
        boolean z5;
        int i6;
        RoomSQLiteQuery c2 = RoomSQLiteQuery.c("SELECT * FROM workspec WHERE last_enqueue_time >= ? AND state IN (2, 3, 5) ORDER BY last_enqueue_time DESC", 1);
        c2.F(1, j2);
        this.f2191a.assertNotSuspendingTransaction();
        Cursor c3 = DBUtil.c(this.f2191a, c2, false, (CancellationSignal) null);
        try {
            int d2 = CursorUtil.d(c3, "id");
            int d3 = CursorUtil.d(c3, "state");
            int d4 = CursorUtil.d(c3, "worker_class_name");
            int d5 = CursorUtil.d(c3, "input_merger_class_name");
            int d6 = CursorUtil.d(c3, "input");
            int d7 = CursorUtil.d(c3, "output");
            int d8 = CursorUtil.d(c3, "initial_delay");
            int d9 = CursorUtil.d(c3, "interval_duration");
            int d10 = CursorUtil.d(c3, "flex_duration");
            int d11 = CursorUtil.d(c3, "run_attempt_count");
            int d12 = CursorUtil.d(c3, "backoff_policy");
            int d13 = CursorUtil.d(c3, "backoff_delay_duration");
            int d14 = CursorUtil.d(c3, "last_enqueue_time");
            int d15 = CursorUtil.d(c3, "minimum_retention_duration");
            roomSQLiteQuery = c2;
            try {
                int d16 = CursorUtil.d(c3, "schedule_requested_at");
                int d17 = CursorUtil.d(c3, "run_in_foreground");
                int d18 = CursorUtil.d(c3, "out_of_quota_policy");
                int d19 = CursorUtil.d(c3, "period_count");
                int d20 = CursorUtil.d(c3, "generation");
                int d21 = CursorUtil.d(c3, "next_schedule_time_override");
                int d22 = CursorUtil.d(c3, "next_schedule_time_override_generation");
                int d23 = CursorUtil.d(c3, "stop_reason");
                int d24 = CursorUtil.d(c3, "required_network_type");
                int d25 = CursorUtil.d(c3, "requires_charging");
                int d26 = CursorUtil.d(c3, "requires_device_idle");
                int d27 = CursorUtil.d(c3, "requires_battery_not_low");
                int d28 = CursorUtil.d(c3, "requires_storage_not_low");
                int d29 = CursorUtil.d(c3, "trigger_content_update_delay");
                int d30 = CursorUtil.d(c3, "trigger_max_content_delay");
                int d31 = CursorUtil.d(c3, "content_uri_triggers");
                int i7 = d15;
                ArrayList arrayList = new ArrayList(c3.getCount());
                while (c3.moveToNext()) {
                    String string = c3.isNull(d2) ? null : c3.getString(d2);
                    WorkInfo.State f2 = WorkTypeConverters.f(c3.getInt(d3));
                    String string2 = c3.isNull(d4) ? null : c3.getString(d4);
                    String string3 = c3.isNull(d5) ? null : c3.getString(d5);
                    Data g2 = Data.g(c3.isNull(d6) ? null : c3.getBlob(d6));
                    Data g3 = Data.g(c3.isNull(d7) ? null : c3.getBlob(d7));
                    long j3 = c3.getLong(d8);
                    long j4 = c3.getLong(d9);
                    long j5 = c3.getLong(d10);
                    int i8 = c3.getInt(d11);
                    BackoffPolicy c4 = WorkTypeConverters.c(c3.getInt(d12));
                    long j6 = c3.getLong(d13);
                    long j7 = c3.getLong(d14);
                    int i9 = i7;
                    long j8 = c3.getLong(i9);
                    int i10 = d2;
                    int i11 = d16;
                    long j9 = c3.getLong(i11);
                    d16 = i11;
                    int i12 = d17;
                    if (c3.getInt(i12) != 0) {
                        d17 = i12;
                        i2 = d18;
                        z = true;
                    } else {
                        d17 = i12;
                        i2 = d18;
                        z = false;
                    }
                    OutOfQuotaPolicy e2 = WorkTypeConverters.e(c3.getInt(i2));
                    d18 = i2;
                    int i13 = d19;
                    int i14 = c3.getInt(i13);
                    d19 = i13;
                    int i15 = d20;
                    int i16 = c3.getInt(i15);
                    d20 = i15;
                    int i17 = d21;
                    long j10 = c3.getLong(i17);
                    d21 = i17;
                    int i18 = d22;
                    int i19 = c3.getInt(i18);
                    d22 = i18;
                    int i20 = d23;
                    int i21 = c3.getInt(i20);
                    d23 = i20;
                    int i22 = d24;
                    NetworkType d32 = WorkTypeConverters.d(c3.getInt(i22));
                    d24 = i22;
                    int i23 = d25;
                    if (c3.getInt(i23) != 0) {
                        d25 = i23;
                        i3 = d26;
                        z2 = true;
                    } else {
                        d25 = i23;
                        i3 = d26;
                        z2 = false;
                    }
                    if (c3.getInt(i3) != 0) {
                        d26 = i3;
                        i4 = d27;
                        z3 = true;
                    } else {
                        d26 = i3;
                        i4 = d27;
                        z3 = false;
                    }
                    if (c3.getInt(i4) != 0) {
                        d27 = i4;
                        i5 = d28;
                        z4 = true;
                    } else {
                        d27 = i4;
                        i5 = d28;
                        z4 = false;
                    }
                    if (c3.getInt(i5) != 0) {
                        d28 = i5;
                        i6 = d29;
                        z5 = true;
                    } else {
                        d28 = i5;
                        i6 = d29;
                        z5 = false;
                    }
                    long j11 = c3.getLong(i6);
                    d29 = i6;
                    int i24 = d30;
                    long j12 = c3.getLong(i24);
                    d30 = i24;
                    int i25 = d31;
                    d31 = i25;
                    arrayList.add(new WorkSpec(string, f2, string2, string3, g2, g3, j3, j4, j5, new Constraints(d32, z2, z3, z4, z5, j11, j12, WorkTypeConverters.b(c3.isNull(i25) ? null : c3.getBlob(i25))), i8, c4, j6, j7, j8, j9, z, e2, i14, i16, j10, i19, i21));
                    d2 = i10;
                    i7 = i9;
                }
                c3.close();
                roomSQLiteQuery.release();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                c3.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = c2;
            c3.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }

    public List w() {
        RoomSQLiteQuery roomSQLiteQuery;
        boolean z;
        int i2;
        boolean z2;
        int i3;
        boolean z3;
        int i4;
        boolean z4;
        int i5;
        boolean z5;
        int i6;
        RoomSQLiteQuery c2 = RoomSQLiteQuery.c("SELECT * FROM workspec WHERE state=0 AND schedule_requested_at<>-1", 0);
        this.f2191a.assertNotSuspendingTransaction();
        Cursor c3 = DBUtil.c(this.f2191a, c2, false, (CancellationSignal) null);
        try {
            int d2 = CursorUtil.d(c3, "id");
            int d3 = CursorUtil.d(c3, "state");
            int d4 = CursorUtil.d(c3, "worker_class_name");
            int d5 = CursorUtil.d(c3, "input_merger_class_name");
            int d6 = CursorUtil.d(c3, "input");
            int d7 = CursorUtil.d(c3, "output");
            int d8 = CursorUtil.d(c3, "initial_delay");
            int d9 = CursorUtil.d(c3, "interval_duration");
            int d10 = CursorUtil.d(c3, "flex_duration");
            int d11 = CursorUtil.d(c3, "run_attempt_count");
            int d12 = CursorUtil.d(c3, "backoff_policy");
            int d13 = CursorUtil.d(c3, "backoff_delay_duration");
            int d14 = CursorUtil.d(c3, "last_enqueue_time");
            int d15 = CursorUtil.d(c3, "minimum_retention_duration");
            roomSQLiteQuery = c2;
            try {
                int d16 = CursorUtil.d(c3, "schedule_requested_at");
                int d17 = CursorUtil.d(c3, "run_in_foreground");
                int d18 = CursorUtil.d(c3, "out_of_quota_policy");
                int d19 = CursorUtil.d(c3, "period_count");
                int d20 = CursorUtil.d(c3, "generation");
                int d21 = CursorUtil.d(c3, "next_schedule_time_override");
                int d22 = CursorUtil.d(c3, "next_schedule_time_override_generation");
                int d23 = CursorUtil.d(c3, "stop_reason");
                int d24 = CursorUtil.d(c3, "required_network_type");
                int d25 = CursorUtil.d(c3, "requires_charging");
                int d26 = CursorUtil.d(c3, "requires_device_idle");
                int d27 = CursorUtil.d(c3, "requires_battery_not_low");
                int d28 = CursorUtil.d(c3, "requires_storage_not_low");
                int d29 = CursorUtil.d(c3, "trigger_content_update_delay");
                int d30 = CursorUtil.d(c3, "trigger_max_content_delay");
                int d31 = CursorUtil.d(c3, "content_uri_triggers");
                int i7 = d15;
                ArrayList arrayList = new ArrayList(c3.getCount());
                while (c3.moveToNext()) {
                    String string = c3.isNull(d2) ? null : c3.getString(d2);
                    WorkInfo.State f2 = WorkTypeConverters.f(c3.getInt(d3));
                    String string2 = c3.isNull(d4) ? null : c3.getString(d4);
                    String string3 = c3.isNull(d5) ? null : c3.getString(d5);
                    Data g2 = Data.g(c3.isNull(d6) ? null : c3.getBlob(d6));
                    Data g3 = Data.g(c3.isNull(d7) ? null : c3.getBlob(d7));
                    long j2 = c3.getLong(d8);
                    long j3 = c3.getLong(d9);
                    long j4 = c3.getLong(d10);
                    int i8 = c3.getInt(d11);
                    BackoffPolicy c4 = WorkTypeConverters.c(c3.getInt(d12));
                    long j5 = c3.getLong(d13);
                    long j6 = c3.getLong(d14);
                    int i9 = i7;
                    long j7 = c3.getLong(i9);
                    int i10 = d2;
                    int i11 = d16;
                    long j8 = c3.getLong(i11);
                    d16 = i11;
                    int i12 = d17;
                    if (c3.getInt(i12) != 0) {
                        d17 = i12;
                        i2 = d18;
                        z = true;
                    } else {
                        d17 = i12;
                        i2 = d18;
                        z = false;
                    }
                    OutOfQuotaPolicy e2 = WorkTypeConverters.e(c3.getInt(i2));
                    d18 = i2;
                    int i13 = d19;
                    int i14 = c3.getInt(i13);
                    d19 = i13;
                    int i15 = d20;
                    int i16 = c3.getInt(i15);
                    d20 = i15;
                    int i17 = d21;
                    long j9 = c3.getLong(i17);
                    d21 = i17;
                    int i18 = d22;
                    int i19 = c3.getInt(i18);
                    d22 = i18;
                    int i20 = d23;
                    int i21 = c3.getInt(i20);
                    d23 = i20;
                    int i22 = d24;
                    NetworkType d32 = WorkTypeConverters.d(c3.getInt(i22));
                    d24 = i22;
                    int i23 = d25;
                    if (c3.getInt(i23) != 0) {
                        d25 = i23;
                        i3 = d26;
                        z2 = true;
                    } else {
                        d25 = i23;
                        i3 = d26;
                        z2 = false;
                    }
                    if (c3.getInt(i3) != 0) {
                        d26 = i3;
                        i4 = d27;
                        z3 = true;
                    } else {
                        d26 = i3;
                        i4 = d27;
                        z3 = false;
                    }
                    if (c3.getInt(i4) != 0) {
                        d27 = i4;
                        i5 = d28;
                        z4 = true;
                    } else {
                        d27 = i4;
                        i5 = d28;
                        z4 = false;
                    }
                    if (c3.getInt(i5) != 0) {
                        d28 = i5;
                        i6 = d29;
                        z5 = true;
                    } else {
                        d28 = i5;
                        i6 = d29;
                        z5 = false;
                    }
                    long j10 = c3.getLong(i6);
                    d29 = i6;
                    int i24 = d30;
                    long j11 = c3.getLong(i24);
                    d30 = i24;
                    int i25 = d31;
                    d31 = i25;
                    arrayList.add(new WorkSpec(string, f2, string2, string3, g2, g3, j2, j3, j4, new Constraints(d32, z2, z3, z4, z5, j10, j11, WorkTypeConverters.b(c3.isNull(i25) ? null : c3.getBlob(i25))), i8, c4, j5, j6, j7, j8, z, e2, i14, i16, j9, i19, i21));
                    d2 = i10;
                    i7 = i9;
                }
                c3.close();
                roomSQLiteQuery.release();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                c3.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = c2;
            c3.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: androidx.work.impl.model.WorkSpec$WorkInfoPojo} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v2, resolved type: byte[]} */
    /* JADX WARNING: type inference failed for: r4v0 */
    /* JADX WARNING: type inference failed for: r9v5, types: [androidx.work.impl.model.WorkSpec$WorkInfoPojo] */
    /* JADX WARNING: type inference failed for: r4v5 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public androidx.work.impl.model.WorkSpec.WorkInfoPojo x(java.lang.String r43) {
        /*
            r42 = this;
            r1 = r42
            r0 = r43
            java.lang.String r2 = "SELECT id, state, output, run_attempt_count, generation, required_network_type, requires_charging,requires_device_idle, requires_battery_not_low, requires_storage_not_low, trigger_content_update_delay, trigger_max_content_delay, content_uri_triggers, initial_delay, interval_duration, flex_duration, backoff_policy, backoff_delay_duration, last_enqueue_time, period_count, next_schedule_time_override, stop_reason FROM workspec WHERE id=?"
            r3 = 1
            androidx.room.RoomSQLiteQuery r2 = androidx.room.RoomSQLiteQuery.c(r2, r3)
            if (r0 != 0) goto L_0x0011
            r2.L(r3)
            goto L_0x0014
        L_0x0011:
            r2.B(r3, r0)
        L_0x0014:
            androidx.room.RoomDatabase r0 = r1.f2191a
            r0.assertNotSuspendingTransaction()
            androidx.room.RoomDatabase r0 = r1.f2191a
            r0.beginTransaction()
            androidx.room.RoomDatabase r0 = r1.f2191a     // Catch:{ all -> 0x0179 }
            r4 = 0
            android.database.Cursor r5 = androidx.room.util.DBUtil.c(r0, r2, r3, r4)     // Catch:{ all -> 0x0179 }
            java.util.HashMap r0 = new java.util.HashMap     // Catch:{ all -> 0x004b }
            r0.<init>()     // Catch:{ all -> 0x004b }
            java.util.HashMap r6 = new java.util.HashMap     // Catch:{ all -> 0x004b }
            r6.<init>()     // Catch:{ all -> 0x004b }
        L_0x002f:
            boolean r7 = r5.moveToNext()     // Catch:{ all -> 0x004b }
            r8 = 0
            if (r7 == 0) goto L_0x0063
            java.lang.String r7 = r5.getString(r8)     // Catch:{ all -> 0x004b }
            java.lang.Object r9 = r0.get(r7)     // Catch:{ all -> 0x004b }
            java.util.ArrayList r9 = (java.util.ArrayList) r9     // Catch:{ all -> 0x004b }
            if (r9 != 0) goto L_0x004e
            java.util.ArrayList r9 = new java.util.ArrayList     // Catch:{ all -> 0x004b }
            r9.<init>()     // Catch:{ all -> 0x004b }
            r0.put(r7, r9)     // Catch:{ all -> 0x004b }
            goto L_0x004e
        L_0x004b:
            r0 = move-exception
            goto L_0x017b
        L_0x004e:
            java.lang.String r7 = r5.getString(r8)     // Catch:{ all -> 0x004b }
            java.lang.Object r8 = r6.get(r7)     // Catch:{ all -> 0x004b }
            java.util.ArrayList r8 = (java.util.ArrayList) r8     // Catch:{ all -> 0x004b }
            if (r8 != 0) goto L_0x002f
            java.util.ArrayList r8 = new java.util.ArrayList     // Catch:{ all -> 0x004b }
            r8.<init>()     // Catch:{ all -> 0x004b }
            r6.put(r7, r8)     // Catch:{ all -> 0x004b }
            goto L_0x002f
        L_0x0063:
            r7 = -1
            r5.moveToPosition(r7)     // Catch:{ all -> 0x004b }
            r1.J(r0)     // Catch:{ all -> 0x004b }
            r1.I(r6)     // Catch:{ all -> 0x004b }
            boolean r7 = r5.moveToFirst()     // Catch:{ all -> 0x004b }
            if (r7 == 0) goto L_0x0168
            boolean r7 = r5.isNull(r8)     // Catch:{ all -> 0x004b }
            if (r7 == 0) goto L_0x007b
            r10 = r4
            goto L_0x0080
        L_0x007b:
            java.lang.String r7 = r5.getString(r8)     // Catch:{ all -> 0x004b }
            r10 = r7
        L_0x0080:
            int r7 = r5.getInt(r3)     // Catch:{ all -> 0x004b }
            androidx.work.WorkInfo$State r11 = androidx.work.impl.model.WorkTypeConverters.f(r7)     // Catch:{ all -> 0x004b }
            r7 = 2
            boolean r9 = r5.isNull(r7)     // Catch:{ all -> 0x004b }
            if (r9 == 0) goto L_0x0091
            r7 = r4
            goto L_0x0095
        L_0x0091:
            byte[] r7 = r5.getBlob(r7)     // Catch:{ all -> 0x004b }
        L_0x0095:
            androidx.work.Data r12 = androidx.work.Data.g(r7)     // Catch:{ all -> 0x004b }
            r7 = 3
            int r20 = r5.getInt(r7)     // Catch:{ all -> 0x004b }
            r7 = 4
            int r27 = r5.getInt(r7)     // Catch:{ all -> 0x004b }
            r7 = 13
            long r13 = r5.getLong(r7)     // Catch:{ all -> 0x004b }
            r7 = 14
            long r15 = r5.getLong(r7)     // Catch:{ all -> 0x004b }
            r7 = 15
            long r17 = r5.getLong(r7)     // Catch:{ all -> 0x004b }
            r7 = 16
            int r7 = r5.getInt(r7)     // Catch:{ all -> 0x004b }
            androidx.work.BackoffPolicy r21 = androidx.work.impl.model.WorkTypeConverters.c(r7)     // Catch:{ all -> 0x004b }
            r7 = 17
            long r22 = r5.getLong(r7)     // Catch:{ all -> 0x004b }
            r7 = 18
            long r24 = r5.getLong(r7)     // Catch:{ all -> 0x004b }
            r7 = 19
            int r26 = r5.getInt(r7)     // Catch:{ all -> 0x004b }
            r7 = 20
            long r28 = r5.getLong(r7)     // Catch:{ all -> 0x004b }
            r7 = 21
            int r30 = r5.getInt(r7)     // Catch:{ all -> 0x004b }
            r7 = 5
            int r7 = r5.getInt(r7)     // Catch:{ all -> 0x004b }
            androidx.work.NetworkType r32 = androidx.work.impl.model.WorkTypeConverters.d(r7)     // Catch:{ all -> 0x004b }
            r7 = 6
            int r7 = r5.getInt(r7)     // Catch:{ all -> 0x004b }
            if (r7 == 0) goto L_0x00f0
            r33 = r3
            goto L_0x00f2
        L_0x00f0:
            r33 = r8
        L_0x00f2:
            r7 = 7
            int r7 = r5.getInt(r7)     // Catch:{ all -> 0x004b }
            if (r7 == 0) goto L_0x00fc
            r34 = r3
            goto L_0x00fe
        L_0x00fc:
            r34 = r8
        L_0x00fe:
            r7 = 8
            int r7 = r5.getInt(r7)     // Catch:{ all -> 0x004b }
            if (r7 == 0) goto L_0x0109
            r35 = r3
            goto L_0x010b
        L_0x0109:
            r35 = r8
        L_0x010b:
            r7 = 9
            int r7 = r5.getInt(r7)     // Catch:{ all -> 0x004b }
            if (r7 == 0) goto L_0x0116
            r36 = r3
            goto L_0x0118
        L_0x0116:
            r36 = r8
        L_0x0118:
            r3 = 10
            long r37 = r5.getLong(r3)     // Catch:{ all -> 0x004b }
            r3 = 11
            long r39 = r5.getLong(r3)     // Catch:{ all -> 0x004b }
            r3 = 12
            boolean r7 = r5.isNull(r3)     // Catch:{ all -> 0x004b }
            if (r7 == 0) goto L_0x012d
            goto L_0x0131
        L_0x012d:
            byte[] r4 = r5.getBlob(r3)     // Catch:{ all -> 0x004b }
        L_0x0131:
            java.util.Set r41 = androidx.work.impl.model.WorkTypeConverters.b(r4)     // Catch:{ all -> 0x004b }
            androidx.work.Constraints r19 = new androidx.work.Constraints     // Catch:{ all -> 0x004b }
            r31 = r19
            r31.<init>(r32, r33, r34, r35, r36, r37, r39, r41)     // Catch:{ all -> 0x004b }
            java.lang.String r3 = r5.getString(r8)     // Catch:{ all -> 0x004b }
            java.lang.Object r0 = r0.get(r3)     // Catch:{ all -> 0x004b }
            java.util.ArrayList r0 = (java.util.ArrayList) r0     // Catch:{ all -> 0x004b }
            if (r0 != 0) goto L_0x014d
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ all -> 0x004b }
            r0.<init>()     // Catch:{ all -> 0x004b }
        L_0x014d:
            r31 = r0
            java.lang.String r0 = r5.getString(r8)     // Catch:{ all -> 0x004b }
            java.lang.Object r0 = r6.get(r0)     // Catch:{ all -> 0x004b }
            java.util.ArrayList r0 = (java.util.ArrayList) r0     // Catch:{ all -> 0x004b }
            if (r0 != 0) goto L_0x0160
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ all -> 0x004b }
            r0.<init>()     // Catch:{ all -> 0x004b }
        L_0x0160:
            r32 = r0
            androidx.work.impl.model.WorkSpec$WorkInfoPojo r4 = new androidx.work.impl.model.WorkSpec$WorkInfoPojo     // Catch:{ all -> 0x004b }
            r9 = r4
            r9.<init>(r10, r11, r12, r13, r15, r17, r19, r20, r21, r22, r24, r26, r27, r28, r30, r31, r32)     // Catch:{ all -> 0x004b }
        L_0x0168:
            androidx.room.RoomDatabase r0 = r1.f2191a     // Catch:{ all -> 0x004b }
            r0.setTransactionSuccessful()     // Catch:{ all -> 0x004b }
            r5.close()     // Catch:{ all -> 0x0179 }
            r2.release()     // Catch:{ all -> 0x0179 }
            androidx.room.RoomDatabase r0 = r1.f2191a
            r0.endTransaction()
            return r4
        L_0x0179:
            r0 = move-exception
            goto L_0x0182
        L_0x017b:
            r5.close()     // Catch:{ all -> 0x0179 }
            r2.release()     // Catch:{ all -> 0x0179 }
            throw r0     // Catch:{ all -> 0x0179 }
        L_0x0182:
            androidx.room.RoomDatabase r1 = r1.f2191a
            r1.endTransaction()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.model.WorkSpecDao_Impl.x(java.lang.String):androidx.work.impl.model.WorkSpec$WorkInfoPojo");
    }

    public WorkSpec y(String str) {
        RoomSQLiteQuery roomSQLiteQuery;
        WorkSpec workSpec;
        boolean z;
        int i2;
        boolean z2;
        int i3;
        boolean z3;
        int i4;
        boolean z4;
        int i5;
        boolean z5;
        int i6;
        String str2 = str;
        RoomSQLiteQuery c2 = RoomSQLiteQuery.c("SELECT * FROM workspec WHERE id=?", 1);
        if (str2 == null) {
            c2.L(1);
        } else {
            c2.B(1, str2);
        }
        this.f2191a.assertNotSuspendingTransaction();
        Cursor c3 = DBUtil.c(this.f2191a, c2, false, (CancellationSignal) null);
        try {
            int d2 = CursorUtil.d(c3, "id");
            int d3 = CursorUtil.d(c3, "state");
            int d4 = CursorUtil.d(c3, "worker_class_name");
            int d5 = CursorUtil.d(c3, "input_merger_class_name");
            int d6 = CursorUtil.d(c3, "input");
            int d7 = CursorUtil.d(c3, "output");
            int d8 = CursorUtil.d(c3, "initial_delay");
            int d9 = CursorUtil.d(c3, "interval_duration");
            int d10 = CursorUtil.d(c3, "flex_duration");
            int d11 = CursorUtil.d(c3, "run_attempt_count");
            int d12 = CursorUtil.d(c3, "backoff_policy");
            int d13 = CursorUtil.d(c3, "backoff_delay_duration");
            int d14 = CursorUtil.d(c3, "last_enqueue_time");
            int d15 = CursorUtil.d(c3, "minimum_retention_duration");
            roomSQLiteQuery = c2;
            try {
                int d16 = CursorUtil.d(c3, "schedule_requested_at");
                int d17 = CursorUtil.d(c3, "run_in_foreground");
                int d18 = CursorUtil.d(c3, "out_of_quota_policy");
                int d19 = CursorUtil.d(c3, "period_count");
                int d20 = CursorUtil.d(c3, "generation");
                int d21 = CursorUtil.d(c3, "next_schedule_time_override");
                int d22 = CursorUtil.d(c3, "next_schedule_time_override_generation");
                int d23 = CursorUtil.d(c3, "stop_reason");
                int d24 = CursorUtil.d(c3, "required_network_type");
                int d25 = CursorUtil.d(c3, "requires_charging");
                int d26 = CursorUtil.d(c3, "requires_device_idle");
                int d27 = CursorUtil.d(c3, "requires_battery_not_low");
                int d28 = CursorUtil.d(c3, "requires_storage_not_low");
                int d29 = CursorUtil.d(c3, "trigger_content_update_delay");
                int d30 = CursorUtil.d(c3, "trigger_max_content_delay");
                int d31 = CursorUtil.d(c3, "content_uri_triggers");
                if (c3.moveToFirst()) {
                    String string = c3.isNull(d2) ? null : c3.getString(d2);
                    WorkInfo.State f2 = WorkTypeConverters.f(c3.getInt(d3));
                    String string2 = c3.isNull(d4) ? null : c3.getString(d4);
                    String string3 = c3.isNull(d5) ? null : c3.getString(d5);
                    Data g2 = Data.g(c3.isNull(d6) ? null : c3.getBlob(d6));
                    Data g3 = Data.g(c3.isNull(d7) ? null : c3.getBlob(d7));
                    long j2 = c3.getLong(d8);
                    long j3 = c3.getLong(d9);
                    long j4 = c3.getLong(d10);
                    int i7 = c3.getInt(d11);
                    BackoffPolicy c4 = WorkTypeConverters.c(c3.getInt(d12));
                    long j5 = c3.getLong(d13);
                    long j6 = c3.getLong(d14);
                    long j7 = c3.getLong(d15);
                    long j8 = c3.getLong(d16);
                    if (c3.getInt(d17) != 0) {
                        i2 = d18;
                        z = true;
                    } else {
                        i2 = d18;
                        z = false;
                    }
                    OutOfQuotaPolicy e2 = WorkTypeConverters.e(c3.getInt(i2));
                    int i8 = c3.getInt(d19);
                    int i9 = c3.getInt(d20);
                    long j9 = c3.getLong(d21);
                    int i10 = c3.getInt(d22);
                    int i11 = c3.getInt(d23);
                    NetworkType d32 = WorkTypeConverters.d(c3.getInt(d24));
                    if (c3.getInt(d25) != 0) {
                        i3 = d26;
                        z2 = true;
                    } else {
                        i3 = d26;
                        z2 = false;
                    }
                    if (c3.getInt(i3) != 0) {
                        i4 = d27;
                        z3 = true;
                    } else {
                        i4 = d27;
                        z3 = false;
                    }
                    if (c3.getInt(i4) != 0) {
                        i5 = d28;
                        z4 = true;
                    } else {
                        i5 = d28;
                        z4 = false;
                    }
                    if (c3.getInt(i5) != 0) {
                        i6 = d29;
                        z5 = true;
                    } else {
                        i6 = d29;
                        z5 = false;
                    }
                    workSpec = new WorkSpec(string, f2, string2, string3, g2, g3, j2, j3, j4, new Constraints(d32, z2, z3, z4, z5, c3.getLong(i6), c3.getLong(d30), WorkTypeConverters.b(c3.isNull(d31) ? null : c3.getBlob(d31))), i7, c4, j5, j6, j7, j8, z, e2, i8, i9, j9, i10, i11);
                } else {
                    workSpec = null;
                }
                c3.close();
                roomSQLiteQuery.release();
                return workSpec;
            } catch (Throwable th) {
                th = th;
                c3.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = c2;
            c3.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }

    public int z() {
        this.f2191a.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.o.acquire();
        this.f2191a.beginTransaction();
        try {
            int k2 = acquire.k();
            this.f2191a.setTransactionSuccessful();
            return k2;
        } finally {
            this.f2191a.endTransaction();
            this.o.release(acquire);
        }
    }
}
