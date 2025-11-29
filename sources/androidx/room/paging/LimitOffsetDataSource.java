package androidx.room.paging;

import android.database.Cursor;
import androidx.annotation.RestrictTo;
import androidx.paging.PositionalDataSource;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

@RestrictTo
public abstract class LimitOffsetDataSource<T> extends PositionalDataSource<T> {
    public final RoomSQLiteQuery g;
    public final String h;
    public final String i;
    public final RoomDatabase j;
    public final InvalidationTracker.Observer k;
    public final boolean l;
    public final AtomicBoolean m;

    /* renamed from: androidx.room.paging.LimitOffsetDataSource$1  reason: invalid class name */
    class AnonymousClass1 extends InvalidationTracker.Observer {
        public final /* synthetic */ LimitOffsetDataSource b;

        public void c(Set set) {
            this.b.d();
        }
    }

    public boolean e() {
        u();
        this.j.getInvalidationTracker().p();
        return super.e();
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0059  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void l(androidx.paging.PositionalDataSource.LoadInitialParams r7, androidx.paging.PositionalDataSource.LoadInitialCallback r8) {
        /*
            r6 = this;
            r6.u()
            java.util.List r0 = java.util.Collections.emptyList()
            androidx.room.RoomDatabase r1 = r6.j
            r1.beginTransaction()
            r1 = 0
            int r2 = r6.r()     // Catch:{ all -> 0x0035 }
            if (r2 == 0) goto L_0x0038
            int r0 = androidx.paging.PositionalDataSource.i(r7, r2)     // Catch:{ all -> 0x0035 }
            int r7 = androidx.paging.PositionalDataSource.j(r7, r0, r2)     // Catch:{ all -> 0x0035 }
            androidx.room.RoomSQLiteQuery r7 = r6.s(r0, r7)     // Catch:{ all -> 0x0035 }
            androidx.room.RoomDatabase r3 = r6.j     // Catch:{ all -> 0x0033 }
            android.database.Cursor r1 = r3.query(r7)     // Catch:{ all -> 0x0033 }
            java.util.List r3 = r6.q(r1)     // Catch:{ all -> 0x0033 }
            androidx.room.RoomDatabase r4 = r6.j     // Catch:{ all -> 0x0033 }
            r4.setTransactionSuccessful()     // Catch:{ all -> 0x0033 }
            r5 = r3
            r3 = r7
            r7 = r0
            r0 = r5
            goto L_0x003a
        L_0x0033:
            r8 = move-exception
            goto L_0x004d
        L_0x0035:
            r8 = move-exception
            r7 = r1
            goto L_0x004d
        L_0x0038:
            r7 = 0
            r3 = r1
        L_0x003a:
            if (r1 == 0) goto L_0x003f
            r1.close()
        L_0x003f:
            androidx.room.RoomDatabase r6 = r6.j
            r6.endTransaction()
            if (r3 == 0) goto L_0x0049
            r3.release()
        L_0x0049:
            r8.a(r0, r7, r2)
            return
        L_0x004d:
            if (r1 == 0) goto L_0x0052
            r1.close()
        L_0x0052:
            androidx.room.RoomDatabase r6 = r6.j
            r6.endTransaction()
            if (r7 == 0) goto L_0x005c
            r7.release()
        L_0x005c:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.paging.LimitOffsetDataSource.l(androidx.paging.PositionalDataSource$LoadInitialParams, androidx.paging.PositionalDataSource$LoadInitialCallback):void");
    }

    public void o(PositionalDataSource.LoadRangeParams loadRangeParams, PositionalDataSource.LoadRangeCallback loadRangeCallback) {
        loadRangeCallback.a(t(loadRangeParams.f1624a, loadRangeParams.b));
    }

    public abstract List q(Cursor cursor);

    public int r() {
        u();
        RoomSQLiteQuery c = RoomSQLiteQuery.c(this.h, this.g.g());
        c.d(this.g);
        Cursor query = this.j.query(c);
        try {
            if (query.moveToFirst()) {
                return query.getInt(0);
            }
            query.close();
            c.release();
            return 0;
        } finally {
            query.close();
            c.release();
        }
    }

    public final RoomSQLiteQuery s(int i2, int i3) {
        RoomSQLiteQuery c = RoomSQLiteQuery.c(this.i, this.g.g() + 2);
        c.d(this.g);
        c.F(c.g() - 1, (long) i3);
        c.F(c.g(), (long) i2);
        return c;
    }

    public List t(int i2, int i3) {
        RoomSQLiteQuery s = s(i2, i3);
        if (this.l) {
            this.j.beginTransaction();
            Cursor cursor = null;
            try {
                cursor = this.j.query(s);
                List q = q(cursor);
                this.j.setTransactionSuccessful();
                return q;
            } finally {
                if (cursor != null) {
                    cursor.close();
                }
                this.j.endTransaction();
                s.release();
            }
        } else {
            Cursor query = this.j.query(s);
            try {
                return q(query);
            } finally {
                query.close();
                s.release();
            }
        }
    }

    public final void u() {
        if (this.m.compareAndSet(false, true)) {
            this.j.getInvalidationTracker().d(this.k);
        }
    }
}
