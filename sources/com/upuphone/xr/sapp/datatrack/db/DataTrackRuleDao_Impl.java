package com.upuphone.xr.sapp.datatrack.db;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.upuphone.xr.sapp.datatrack.DataTrackRule;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

public final class DataTrackRuleDao_Impl implements DataTrackRuleDao {

    /* renamed from: a  reason: collision with root package name */
    public final RoomDatabase f6919a;
    public final EntityInsertionAdapter b;
    public final SharedSQLiteStatement c;

    /* renamed from: com.upuphone.xr.sapp.datatrack.db.DataTrackRuleDao_Impl$5  reason: invalid class name */
    class AnonymousClass5 implements Callable<List<DataTrackRule>> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ RoomSQLiteQuery f6924a;
        public final /* synthetic */ DataTrackRuleDao_Impl b;

        /* renamed from: a */
        public List call() {
            Cursor c = DBUtil.c(this.b.f6919a, this.f6924a, false, (CancellationSignal) null);
            try {
                int d = CursorUtil.d(c, "ruleId");
                int d2 = CursorUtil.d(c, "deviceType");
                int d3 = CursorUtil.d(c, "eventName");
                int d4 = CursorUtil.d(c, "eventUseType");
                ArrayList arrayList = new ArrayList(c.getCount());
                while (c.moveToNext()) {
                    arrayList.add(new DataTrackRule(c.getInt(d), c.getString(d2), c.getString(d3), c.getInt(d4)));
                }
                return arrayList;
            } finally {
                c.close();
                this.f6924a.release();
            }
        }
    }

    public DataTrackRuleDao_Impl(RoomDatabase roomDatabase) {
        this.f6919a = roomDatabase;
        this.b = new EntityInsertionAdapter<DataTrackRule>(roomDatabase) {
            public String createQuery() {
                return "INSERT OR REPLACE INTO `DataTrackRule` (`ruleId`,`deviceType`,`eventName`,`eventUseType`) VALUES (?,?,?,?)";
            }

            /* renamed from: d */
            public void bind(SupportSQLiteStatement supportSQLiteStatement, DataTrackRule dataTrackRule) {
                supportSQLiteStatement.F(1, (long) dataTrackRule.getRuleId());
                supportSQLiteStatement.B(2, dataTrackRule.getDeviceType());
                supportSQLiteStatement.B(3, dataTrackRule.getEventName());
                supportSQLiteStatement.F(4, (long) dataTrackRule.getEventUseType());
            }
        };
        this.c = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "delete from datatrackrule";
            }
        };
    }

    public static List h() {
        return Collections.emptyList();
    }

    public Object a(Continuation continuation) {
        return CoroutinesRoom.c(this.f6919a, true, new Callable<Unit>() {
            /* renamed from: a */
            public Unit call() {
                SupportSQLiteStatement acquire = DataTrackRuleDao_Impl.this.c.acquire();
                try {
                    DataTrackRuleDao_Impl.this.f6919a.beginTransaction();
                    acquire.k();
                    DataTrackRuleDao_Impl.this.f6919a.setTransactionSuccessful();
                    Unit unit = Unit.INSTANCE;
                    DataTrackRuleDao_Impl.this.f6919a.endTransaction();
                    DataTrackRuleDao_Impl.this.c.release(acquire);
                    return unit;
                } catch (Throwable th) {
                    DataTrackRuleDao_Impl.this.c.release(acquire);
                    throw th;
                }
            }
        }, continuation);
    }

    public Object b(final List list, Continuation continuation) {
        return CoroutinesRoom.c(this.f6919a, true, new Callable<Unit>() {
            /* renamed from: a */
            public Unit call() {
                DataTrackRuleDao_Impl.this.f6919a.beginTransaction();
                try {
                    DataTrackRuleDao_Impl.this.b.insert(list);
                    DataTrackRuleDao_Impl.this.f6919a.setTransactionSuccessful();
                    return Unit.INSTANCE;
                } finally {
                    DataTrackRuleDao_Impl.this.f6919a.endTransaction();
                }
            }
        }, continuation);
    }

    public Object c(String str, List list, Continuation continuation) {
        StringBuilder b2 = StringUtil.b();
        b2.append("select * from datatrackrule where deviceType=");
        b2.append("?");
        b2.append(" and eventUseType in(");
        int size = list.size();
        StringUtil.a(b2, size);
        b2.append(")");
        final RoomSQLiteQuery c2 = RoomSQLiteQuery.c(b2.toString(), size + 1);
        c2.B(1, str);
        Iterator it = list.iterator();
        int i = 2;
        while (it.hasNext()) {
            c2.F(i, (long) ((Integer) it.next()).intValue());
            i++;
        }
        return CoroutinesRoom.b(this.f6919a, false, DBUtil.a(), new Callable<List<DataTrackRule>>() {
            /* renamed from: a */
            public List call() {
                Cursor c = DBUtil.c(DataTrackRuleDao_Impl.this.f6919a, c2, false, (CancellationSignal) null);
                try {
                    int d = CursorUtil.d(c, "ruleId");
                    int d2 = CursorUtil.d(c, "deviceType");
                    int d3 = CursorUtil.d(c, "eventName");
                    int d4 = CursorUtil.d(c, "eventUseType");
                    ArrayList arrayList = new ArrayList(c.getCount());
                    while (c.moveToNext()) {
                        arrayList.add(new DataTrackRule(c.getInt(d), c.getString(d2), c.getString(d3), c.getInt(d4)));
                    }
                    return arrayList;
                } finally {
                    c.close();
                    c2.release();
                }
            }
        }, continuation);
    }

    public Object d(String str, String str2, List list, Continuation continuation) {
        StringBuilder b2 = StringUtil.b();
        b2.append("select COUNT(*) from datatrackrule where eventName=");
        b2.append("?");
        b2.append(" and deviceType=");
        b2.append("?");
        b2.append(" and eventUseType in(");
        int size = list.size();
        StringUtil.a(b2, size);
        b2.append(")");
        final RoomSQLiteQuery c2 = RoomSQLiteQuery.c(b2.toString(), size + 2);
        c2.B(1, str);
        c2.B(2, str2);
        Iterator it = list.iterator();
        int i = 3;
        while (it.hasNext()) {
            c2.F(i, (long) ((Integer) it.next()).intValue());
            i++;
        }
        return CoroutinesRoom.b(this.f6919a, false, DBUtil.a(), new Callable<Integer>() {
            /* renamed from: a */
            public Integer call() {
                Cursor c = DBUtil.c(DataTrackRuleDao_Impl.this.f6919a, c2, false, (CancellationSignal) null);
                try {
                    return c.moveToFirst() ? Integer.valueOf(c.getInt(0)) : 0;
                } finally {
                    c.close();
                    c2.release();
                }
            }
        }, continuation);
    }
}
