package com.upuphone.xr.sapp.monitor.notification.cache;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.upuphone.xr.sapp.monitor.notification.model.WechatMissedCallModel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

public final class WechatMissedCallDao_Impl implements WechatMissedCallDao {

    /* renamed from: a  reason: collision with root package name */
    public final RoomDatabase f7760a;
    public final EntityInsertionAdapter b;
    public final EntityDeletionOrUpdateAdapter c;
    public final EntityDeletionOrUpdateAdapter d;
    public final SharedSQLiteStatement e;
    public final SharedSQLiteStatement f;

    public WechatMissedCallDao_Impl(RoomDatabase roomDatabase) {
        this.f7760a = roomDatabase;
        this.b = new EntityInsertionAdapter<WechatMissedCallModel>(roomDatabase) {
            public String createQuery() {
                return "INSERT OR REPLACE INTO `WechatMissedCall` (`name`,`date`) VALUES (?,?)";
            }

            /* renamed from: d */
            public void bind(SupportSQLiteStatement supportSQLiteStatement, WechatMissedCallModel wechatMissedCallModel) {
                supportSQLiteStatement.B(1, wechatMissedCallModel.getName());
                supportSQLiteStatement.F(2, wechatMissedCallModel.getDate());
            }
        };
        this.c = new EntityDeletionOrUpdateAdapter<WechatMissedCallModel>(roomDatabase) {
            public String createQuery() {
                return "DELETE FROM `WechatMissedCall` WHERE `date` = ?";
            }

            /* renamed from: d */
            public void bind(SupportSQLiteStatement supportSQLiteStatement, WechatMissedCallModel wechatMissedCallModel) {
                supportSQLiteStatement.F(1, wechatMissedCallModel.getDate());
            }
        };
        this.d = new EntityDeletionOrUpdateAdapter<WechatMissedCallModel>(roomDatabase) {
            public String createQuery() {
                return "UPDATE OR ABORT `WechatMissedCall` SET `name` = ?,`date` = ? WHERE `date` = ?";
            }

            /* renamed from: d */
            public void bind(SupportSQLiteStatement supportSQLiteStatement, WechatMissedCallModel wechatMissedCallModel) {
                supportSQLiteStatement.B(1, wechatMissedCallModel.getName());
                supportSQLiteStatement.F(2, wechatMissedCallModel.getDate());
                supportSQLiteStatement.F(3, wechatMissedCallModel.getDate());
            }
        };
        this.e = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "delete from WechatMissedCall where name = ?";
            }
        };
        this.f = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "delete from WechatMissedCall";
            }
        };
    }

    public static List i() {
        return Collections.emptyList();
    }

    public Object a(final String str, Continuation continuation) {
        return CoroutinesRoom.c(this.f7760a, true, new Callable<Unit>() {
            /* renamed from: a */
            public Unit call() {
                SupportSQLiteStatement acquire = WechatMissedCallDao_Impl.this.e.acquire();
                acquire.B(1, str);
                try {
                    WechatMissedCallDao_Impl.this.f7760a.beginTransaction();
                    acquire.k();
                    WechatMissedCallDao_Impl.this.f7760a.setTransactionSuccessful();
                    Unit unit = Unit.INSTANCE;
                    WechatMissedCallDao_Impl.this.f7760a.endTransaction();
                    WechatMissedCallDao_Impl.this.e.release(acquire);
                    return unit;
                } catch (Throwable th) {
                    WechatMissedCallDao_Impl.this.e.release(acquire);
                    throw th;
                }
            }
        }, continuation);
    }

    public Object b(final WechatMissedCallModel wechatMissedCallModel, Continuation continuation) {
        return CoroutinesRoom.c(this.f7760a, true, new Callable<Unit>() {
            /* renamed from: a */
            public Unit call() {
                WechatMissedCallDao_Impl.this.f7760a.beginTransaction();
                try {
                    WechatMissedCallDao_Impl.this.b.insert(wechatMissedCallModel);
                    WechatMissedCallDao_Impl.this.f7760a.setTransactionSuccessful();
                    return Unit.INSTANCE;
                } finally {
                    WechatMissedCallDao_Impl.this.f7760a.endTransaction();
                }
            }
        }, continuation);
    }

    public Object c(Continuation continuation) {
        final RoomSQLiteQuery c2 = RoomSQLiteQuery.c("select * from WechatMissedCall order by date desc", 0);
        return CoroutinesRoom.b(this.f7760a, false, DBUtil.a(), new Callable<List<WechatMissedCallModel>>() {
            /* renamed from: a */
            public List call() {
                Cursor c = DBUtil.c(WechatMissedCallDao_Impl.this.f7760a, c2, false, (CancellationSignal) null);
                try {
                    int d = CursorUtil.d(c, "name");
                    int d2 = CursorUtil.d(c, "date");
                    ArrayList arrayList = new ArrayList(c.getCount());
                    while (c.moveToNext()) {
                        arrayList.add(new WechatMissedCallModel(c.getString(d), c.getLong(d2)));
                    }
                    return arrayList;
                } finally {
                    c.close();
                    c2.release();
                }
            }
        }, continuation);
    }

    public Object d(Continuation continuation) {
        return CoroutinesRoom.c(this.f7760a, true, new Callable<Unit>() {
            /* renamed from: a */
            public Unit call() {
                SupportSQLiteStatement acquire = WechatMissedCallDao_Impl.this.f.acquire();
                try {
                    WechatMissedCallDao_Impl.this.f7760a.beginTransaction();
                    acquire.k();
                    WechatMissedCallDao_Impl.this.f7760a.setTransactionSuccessful();
                    Unit unit = Unit.INSTANCE;
                    WechatMissedCallDao_Impl.this.f7760a.endTransaction();
                    WechatMissedCallDao_Impl.this.f.release(acquire);
                    return unit;
                } catch (Throwable th) {
                    WechatMissedCallDao_Impl.this.f.release(acquire);
                    throw th;
                }
            }
        }, continuation);
    }
}
