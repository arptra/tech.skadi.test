package androidx.work.impl.model;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

public final class PreferenceDao_Impl implements PreferenceDao {

    /* renamed from: a  reason: collision with root package name */
    public final RoomDatabase f2164a;
    public final EntityInsertionAdapter b;

    /* renamed from: androidx.work.impl.model.PreferenceDao_Impl$2  reason: invalid class name */
    class AnonymousClass2 implements Callable<Long> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ RoomSQLiteQuery f2166a;
        public final /* synthetic */ PreferenceDao_Impl b;

        /* renamed from: a */
        public Long call() {
            Long l = null;
            Cursor c = DBUtil.c(this.b.f2164a, this.f2166a, false, (CancellationSignal) null);
            try {
                if (c.moveToFirst()) {
                    if (!c.isNull(0)) {
                        l = Long.valueOf(c.getLong(0));
                    }
                }
                return l;
            } finally {
                c.close();
            }
        }

        public void finalize() {
            this.f2166a.release();
        }
    }

    public PreferenceDao_Impl(RoomDatabase roomDatabase) {
        this.f2164a = roomDatabase;
        this.b = new EntityInsertionAdapter<Preference>(roomDatabase) {
            public String createQuery() {
                return "INSERT OR REPLACE INTO `Preference` (`key`,`long_value`) VALUES (?,?)";
            }

            /* renamed from: d */
            public void bind(SupportSQLiteStatement supportSQLiteStatement, Preference preference) {
                if (preference.a() == null) {
                    supportSQLiteStatement.L(1);
                } else {
                    supportSQLiteStatement.B(1, preference.a());
                }
                if (preference.b() == null) {
                    supportSQLiteStatement.L(2);
                } else {
                    supportSQLiteStatement.F(2, preference.b().longValue());
                }
            }
        };
    }

    public static List d() {
        return Collections.emptyList();
    }

    public void a(Preference preference) {
        this.f2164a.assertNotSuspendingTransaction();
        this.f2164a.beginTransaction();
        try {
            this.b.insert(preference);
            this.f2164a.setTransactionSuccessful();
        } finally {
            this.f2164a.endTransaction();
        }
    }

    public Long b(String str) {
        RoomSQLiteQuery c = RoomSQLiteQuery.c("SELECT long_value FROM Preference where `key`=?", 1);
        if (str == null) {
            c.L(1);
        } else {
            c.B(1, str);
        }
        this.f2164a.assertNotSuspendingTransaction();
        Long l = null;
        Cursor c2 = DBUtil.c(this.f2164a, c, false, (CancellationSignal) null);
        try {
            if (c2.moveToFirst()) {
                if (!c2.isNull(0)) {
                    l = Long.valueOf(c2.getLong(0));
                }
            }
            return l;
        } finally {
            c2.close();
            c.release();
        }
    }
}
