package androidx.room;

import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.honey.account.c0.p;
import com.honey.account.c0.q;
import com.honey.account.c0.r;
import com.honey.account.c0.s;
import com.honey.account.c0.t;
import com.honey.account.constant.AccountConstantKt;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\n\n\u0002\u0010!\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ!\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u000fH\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0014\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u001a\u0010\u0019J\u0011\u0010\u001b\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u001f\u0010 \u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u0017H\u0016¢\u0006\u0004\b \u0010!J\u001f\u0010#\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\"H\u0016¢\u0006\u0004\b#\u0010$J\u001f\u0010%\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u0003H\u0016¢\u0006\u0004\b%\u0010&J\u001f\u0010(\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020'H\u0016¢\u0006\u0004\b(\u0010)R\u0014\u0010\u0002\u001a\u00020\u00018\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u001c\u00105\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r028\u0002X\u0004¢\u0006\u0006\n\u0004\b3\u00104¨\u00066"}, d2 = {"Landroidx/room/QueryInterceptorStatement;", "Landroidx/sqlite/db/SupportSQLiteStatement;", "delegate", "", "sqlStatement", "Ljava/util/concurrent/Executor;", "queryCallbackExecutor", "Landroidx/room/RoomDatabase$QueryCallback;", "queryCallback", "<init>", "(Landroidx/sqlite/db/SupportSQLiteStatement;Ljava/lang/String;Ljava/util/concurrent/Executor;Landroidx/room/RoomDatabase$QueryCallback;)V", "", "bindIndex", "", "value", "", "o", "(ILjava/lang/Object;)V", "close", "()V", "execute", "k", "()I", "", "e0", "()J", "A", "Y", "()Ljava/lang/String;", "index", "L", "(I)V", "F", "(IJ)V", "", "R", "(ID)V", "B", "(ILjava/lang/String;)V", "", "H", "(I[B)V", "a", "Landroidx/sqlite/db/SupportSQLiteStatement;", "b", "Ljava/lang/String;", "c", "Ljava/util/concurrent/Executor;", "d", "Landroidx/room/RoomDatabase$QueryCallback;", "", "e", "Ljava/util/List;", "bindArgsCache", "room-runtime_release"}, k = 1, mv = {1, 8, 0})
public final class QueryInterceptorStatement implements SupportSQLiteStatement {

    /* renamed from: a  reason: collision with root package name */
    public final SupportSQLiteStatement f1749a;
    public final String b;
    public final Executor c;
    public final RoomDatabase.QueryCallback d;
    public final List e = new ArrayList();

    public QueryInterceptorStatement(SupportSQLiteStatement supportSQLiteStatement, String str, Executor executor, RoomDatabase.QueryCallback queryCallback) {
        Intrinsics.checkNotNullParameter(supportSQLiteStatement, "delegate");
        Intrinsics.checkNotNullParameter(str, "sqlStatement");
        Intrinsics.checkNotNullParameter(executor, "queryCallbackExecutor");
        Intrinsics.checkNotNullParameter(queryCallback, "queryCallback");
        this.f1749a = supportSQLiteStatement;
        this.b = str;
        this.c = executor;
        this.d = queryCallback;
    }

    public static final void i(QueryInterceptorStatement queryInterceptorStatement) {
        Intrinsics.checkNotNullParameter(queryInterceptorStatement, "this$0");
        queryInterceptorStatement.d.a(queryInterceptorStatement.b, queryInterceptorStatement.e);
    }

    public static final void j(QueryInterceptorStatement queryInterceptorStatement) {
        Intrinsics.checkNotNullParameter(queryInterceptorStatement, "this$0");
        queryInterceptorStatement.d.a(queryInterceptorStatement.b, queryInterceptorStatement.e);
    }

    public static final void n(QueryInterceptorStatement queryInterceptorStatement) {
        Intrinsics.checkNotNullParameter(queryInterceptorStatement, "this$0");
        queryInterceptorStatement.d.a(queryInterceptorStatement.b, queryInterceptorStatement.e);
    }

    private final void o(int i, Object obj) {
        int i2 = i - 1;
        if (i2 >= this.e.size()) {
            int size = (i2 - this.e.size()) + 1;
            for (int i3 = 0; i3 < size; i3++) {
                this.e.add((Object) null);
            }
        }
        this.e.set(i2, obj);
    }

    public static final void r(QueryInterceptorStatement queryInterceptorStatement) {
        Intrinsics.checkNotNullParameter(queryInterceptorStatement, "this$0");
        queryInterceptorStatement.d.a(queryInterceptorStatement.b, queryInterceptorStatement.e);
    }

    public static final void s(QueryInterceptorStatement queryInterceptorStatement) {
        Intrinsics.checkNotNullParameter(queryInterceptorStatement, "this$0");
        queryInterceptorStatement.d.a(queryInterceptorStatement.b, queryInterceptorStatement.e);
    }

    public long A() {
        this.c.execute(new p(this));
        return this.f1749a.A();
    }

    public void B(int i, String str) {
        Intrinsics.checkNotNullParameter(str, AccountConstantKt.RESPONSE_VALUE);
        o(i, str);
        this.f1749a.B(i, str);
    }

    public void F(int i, long j) {
        o(i, Long.valueOf(j));
        this.f1749a.F(i, j);
    }

    public void H(int i, byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, AccountConstantKt.RESPONSE_VALUE);
        o(i, bArr);
        this.f1749a.H(i, bArr);
    }

    public void L(int i) {
        o(i, (Object) null);
        this.f1749a.L(i);
    }

    public void R(int i, double d2) {
        o(i, Double.valueOf(d2));
        this.f1749a.R(i, d2);
    }

    public String Y() {
        this.c.execute(new r(this));
        return this.f1749a.Y();
    }

    public void close() {
        this.f1749a.close();
    }

    public long e0() {
        this.c.execute(new q(this));
        return this.f1749a.e0();
    }

    public void execute() {
        this.c.execute(new s(this));
        this.f1749a.execute();
    }

    public int k() {
        this.c.execute(new t(this));
        return this.f1749a.k();
    }
}
