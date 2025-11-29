package androidx.room.paging.util;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.RestrictTo;
import androidx.paging.PagingSource;
import androidx.paging.PagingState;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteQuery;
import com.upuphone.starrynet.payload.PayloadConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a#\u0010\u0004\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001a+\u0010\u0007\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0001¢\u0006\u0004\b\u0007\u0010\b\u001ao\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00028\u00000\u0015\"\b\b\u0000\u0010\n*\u00020\t2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u00012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0018\u0010\u0014\u001a\u0014\u0012\u0004\u0012\u00020\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00130\u0011¢\u0006\u0004\b\u0016\u0010\u0017\u001a\u001d\u0010\u0018\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u0018\u0010\u0019\u001a)\u0010\u001b\u001a\u0004\u0018\u00010\u0001\"\b\b\u0000\u0010\n*\u00020\t*\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00028\u00000\u001a¢\u0006\u0004\b\u001b\u0010\u001c\"#\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u001d8\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001e\u001a\u0004\b\u001f\u0010 ¨\u0006\""}, d2 = {"Landroidx/paging/PagingSource$LoadParams;", "", "params", "key", "c", "(Landroidx/paging/PagingSource$LoadParams;I)I", "itemCount", "d", "(Landroidx/paging/PagingSource$LoadParams;II)I", "", "Value", "Landroidx/room/RoomSQLiteQuery;", "sourceQuery", "Landroidx/room/RoomDatabase;", "db", "Landroid/os/CancellationSignal;", "cancellationSignal", "Lkotlin/Function1;", "Landroid/database/Cursor;", "", "convertRows", "Landroidx/paging/PagingSource$LoadResult;", "e", "(Landroidx/paging/PagingSource$LoadParams;Landroidx/room/RoomSQLiteQuery;Landroidx/room/RoomDatabase;ILandroid/os/CancellationSignal;Lkotlin/jvm/functions/Function1;)Landroidx/paging/PagingSource$LoadResult;", "g", "(Landroidx/room/RoomSQLiteQuery;Landroidx/room/RoomDatabase;)I", "Landroidx/paging/PagingState;", "a", "(Landroidx/paging/PagingState;)Ljava/lang/Integer;", "Landroidx/paging/PagingSource$LoadResult$Invalid;", "Landroidx/paging/PagingSource$LoadResult$Invalid;", "b", "()Landroidx/paging/PagingSource$LoadResult$Invalid;", "INVALID", "room-paging_release"}, k = 2, mv = {1, 8, 0})
@RestrictTo
public final class RoomPagingUtilKt {

    /* renamed from: a  reason: collision with root package name */
    public static final PagingSource.LoadResult.Invalid f1765a = new PagingSource.LoadResult.Invalid();

    public static final Integer a(PagingState pagingState) {
        Intrinsics.checkNotNullParameter(pagingState, "<this>");
        Integer d = pagingState.d();
        if (d != null) {
            return Integer.valueOf(Math.max(0, d.intValue() - (pagingState.e().d / 2)));
        }
        return null;
    }

    public static final PagingSource.LoadResult.Invalid b() {
        return f1765a;
    }

    public static final int c(PagingSource.LoadParams loadParams, int i) {
        Intrinsics.checkNotNullParameter(loadParams, PayloadConstant.KEY_PARAMS);
        return loadParams instanceof PagingSource.LoadParams.Prepend ? i < loadParams.b() ? i : loadParams.b() : loadParams.b();
    }

    public static final int d(PagingSource.LoadParams loadParams, int i, int i2) {
        Intrinsics.checkNotNullParameter(loadParams, PayloadConstant.KEY_PARAMS);
        if (loadParams instanceof PagingSource.LoadParams.Prepend) {
            if (i < loadParams.b()) {
                return 0;
            }
            return i - loadParams.b();
        } else if (loadParams instanceof PagingSource.LoadParams.Append) {
            return i;
        } else {
            if (loadParams instanceof PagingSource.LoadParams.Refresh) {
                return i >= i2 ? Math.max(0, i2 - loadParams.b()) : i;
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX INFO: finally extract failed */
    public static final PagingSource.LoadResult e(PagingSource.LoadParams loadParams, RoomSQLiteQuery roomSQLiteQuery, RoomDatabase roomDatabase, int i, CancellationSignal cancellationSignal, Function1 function1) {
        Intrinsics.checkNotNullParameter(loadParams, PayloadConstant.KEY_PARAMS);
        Intrinsics.checkNotNullParameter(roomSQLiteQuery, "sourceQuery");
        Intrinsics.checkNotNullParameter(roomDatabase, "db");
        Intrinsics.checkNotNullParameter(function1, "convertRows");
        Integer num = (Integer) loadParams.a();
        int intValue = num != null ? num.intValue() : 0;
        int c = c(loadParams, intValue);
        int d = d(loadParams, intValue, i);
        RoomSQLiteQuery a2 = RoomSQLiteQuery.i.a("SELECT * FROM ( " + roomSQLiteQuery.a() + " ) LIMIT " + c + " OFFSET " + d, roomSQLiteQuery.g());
        a2.d(roomSQLiteQuery);
        Cursor query = roomDatabase.query((SupportSQLiteQuery) a2, cancellationSignal);
        try {
            List list = (List) function1.invoke(query);
            query.close();
            a2.release();
            int size = list.size() + d;
            Integer num2 = null;
            Integer valueOf = (list.isEmpty() || list.size() < c || size >= i) ? null : Integer.valueOf(size);
            if (d > 0 && !list.isEmpty()) {
                num2 = Integer.valueOf(d);
            }
            return new PagingSource.LoadResult.Page(list, num2, valueOf, d, Math.max(0, i - size));
        } catch (Throwable th) {
            query.close();
            a2.release();
            throw th;
        }
    }

    public static /* synthetic */ PagingSource.LoadResult f(PagingSource.LoadParams loadParams, RoomSQLiteQuery roomSQLiteQuery, RoomDatabase roomDatabase, int i, CancellationSignal cancellationSignal, Function1 function1, int i2, Object obj) {
        if ((i2 & 16) != 0) {
            cancellationSignal = null;
        }
        return e(loadParams, roomSQLiteQuery, roomDatabase, i, cancellationSignal, function1);
    }

    public static final int g(RoomSQLiteQuery roomSQLiteQuery, RoomDatabase roomDatabase) {
        Intrinsics.checkNotNullParameter(roomSQLiteQuery, "sourceQuery");
        Intrinsics.checkNotNullParameter(roomDatabase, "db");
        RoomSQLiteQuery a2 = RoomSQLiteQuery.i.a("SELECT COUNT(*) FROM ( " + roomSQLiteQuery.a() + " )", roomSQLiteQuery.g());
        a2.d(roomSQLiteQuery);
        Cursor query$default = RoomDatabase.query$default(roomDatabase, a2, (CancellationSignal) null, 2, (Object) null);
        try {
            if (query$default.moveToFirst()) {
                return query$default.getInt(0);
            }
            query$default.close();
            a2.release();
            return 0;
        } finally {
            query$default.close();
            a2.release();
        }
    }
}
