package androidx.room;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.honey.account.c0.a;
import com.honey.account.c0.b;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\t\b\u0000\u0018\u0000 \u001c2\u00020\u0001:\u0001MB\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ'\u0010\u0013\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u000f2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00028\u00000\u0010¢\u0006\u0004\b\u0013\u0010\u0014J\r\u0010\u0015\u001a\u00020\u0011¢\u0006\u0004\b\u0015\u0010\u0016J\r\u0010\u0017\u001a\u00020\f¢\u0006\u0004\b\u0017\u0010\u0018J\r\u0010\u0019\u001a\u00020\f¢\u0006\u0004\b\u0019\u0010\u0018J\u0015\u0010\u001c\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001c\u0010\u001dR\"\u0010\u000b\u001a\u00020\n8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010\u000eR\u0014\u0010&\u001a\u00020#8\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010%R$\u0010,\u001a\u0004\u0018\u00010\u001a8\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010\u001dR\u0014\u0010.\u001a\u00020\u00018\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010-R\u0016\u00100\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010/R\u0014\u00103\u001a\u00020\u00068\u0002X\u0004¢\u0006\u0006\n\u0004\b1\u00102R\"\u0010:\u001a\u0002048\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b\u0013\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\"\u0010@\u001a\u00020\u00028\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b;\u0010/\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R$\u0010D\u001a\u0004\u0018\u00010\u00118\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b \u0010A\u001a\u0004\b;\u0010\u0016\"\u0004\bB\u0010CR\u0016\u0010G\u001a\u00020E8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010FR\u0014\u0010H\u001a\u00020\u001a8\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010(R\u0014\u0010J\u001a\u00020\u001a8\u0002X\u0004¢\u0006\u0006\n\u0004\bI\u0010(R\u0011\u0010L\u001a\u00020E8F¢\u0006\u0006\u001a\u0004\bI\u0010K¨\u0006N"}, d2 = {"Landroidx/room/AutoCloser;", "", "", "autoCloseTimeoutAmount", "Ljava/util/concurrent/TimeUnit;", "autoCloseTimeUnit", "Ljava/util/concurrent/Executor;", "autoCloseExecutor", "<init>", "(JLjava/util/concurrent/TimeUnit;Ljava/util/concurrent/Executor;)V", "Landroidx/sqlite/db/SupportSQLiteOpenHelper;", "delegateOpenHelper", "", "k", "(Landroidx/sqlite/db/SupportSQLiteOpenHelper;)V", "V", "Lkotlin/Function1;", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "block", "g", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "j", "()Landroidx/sqlite/db/SupportSQLiteDatabase;", "e", "()V", "d", "Ljava/lang/Runnable;", "onAutoClose", "m", "(Ljava/lang/Runnable;)V", "a", "Landroidx/sqlite/db/SupportSQLiteOpenHelper;", "i", "()Landroidx/sqlite/db/SupportSQLiteOpenHelper;", "n", "Landroid/os/Handler;", "b", "Landroid/os/Handler;", "handler", "c", "Ljava/lang/Runnable;", "getOnAutoCloseCallback$room_runtime_release", "()Ljava/lang/Runnable;", "setOnAutoCloseCallback$room_runtime_release", "onAutoCloseCallback", "Ljava/lang/Object;", "lock", "J", "autoCloseTimeoutInMs", "f", "Ljava/util/concurrent/Executor;", "executor", "", "I", "getRefCount$room_runtime_release", "()I", "setRefCount$room_runtime_release", "(I)V", "refCount", "h", "getLastDecrementRefCountTimeStamp$room_runtime_release", "()J", "setLastDecrementRefCountTimeStamp$room_runtime_release", "(J)V", "lastDecrementRefCountTimeStamp", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "setDelegateDatabase$room_runtime_release", "(Landroidx/sqlite/db/SupportSQLiteDatabase;)V", "delegateDatabase", "", "Z", "manuallyClosed", "executeAutoCloser", "l", "autoCloser", "()Z", "isActive", "Companion", "room-runtime_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nAutoCloser.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AutoCloser.kt\nandroidx/room/AutoCloser\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,228:1\n1#2:229\n*E\n"})
public final class AutoCloser {
    public static final Companion m = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public SupportSQLiteOpenHelper f1723a;
    public final Handler b = new Handler(Looper.getMainLooper());
    public Runnable c;
    public final Object d = new Object();
    public long e;
    public final Executor f;
    public int g;
    public long h;
    public SupportSQLiteDatabase i;
    public boolean j;
    public final Runnable k;
    public final Runnable l;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Landroidx/room/AutoCloser$Companion;", "", "()V", "autoCloseBug", "", "room-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public AutoCloser(long j2, TimeUnit timeUnit, Executor executor) {
        Intrinsics.checkNotNullParameter(timeUnit, "autoCloseTimeUnit");
        Intrinsics.checkNotNullParameter(executor, "autoCloseExecutor");
        this.e = timeUnit.toMillis(j2);
        this.f = executor;
        this.h = SystemClock.uptimeMillis();
        this.k = new a(this);
        this.l = new b(this);
    }

    public static final void c(AutoCloser autoCloser) {
        Unit unit;
        Intrinsics.checkNotNullParameter(autoCloser, "this$0");
        synchronized (autoCloser.d) {
            try {
                if (SystemClock.uptimeMillis() - autoCloser.h >= autoCloser.e) {
                    if (autoCloser.g == 0) {
                        Runnable runnable = autoCloser.c;
                        if (runnable != null) {
                            runnable.run();
                            unit = Unit.INSTANCE;
                        } else {
                            unit = null;
                        }
                        if (unit != null) {
                            SupportSQLiteDatabase supportSQLiteDatabase = autoCloser.i;
                            if (supportSQLiteDatabase != null && supportSQLiteDatabase.isOpen()) {
                                supportSQLiteDatabase.close();
                            }
                            autoCloser.i = null;
                            Unit unit2 = Unit.INSTANCE;
                            return;
                        }
                        throw new IllegalStateException("onAutoCloseCallback is null but it should have been set before use. Please file a bug against Room at: https://issuetracker.google.com/issues/new?component=413107&template=1096568".toString());
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static final void f(AutoCloser autoCloser) {
        Intrinsics.checkNotNullParameter(autoCloser, "this$0");
        autoCloser.f.execute(autoCloser.l);
    }

    public final void d() {
        synchronized (this.d) {
            try {
                this.j = true;
                SupportSQLiteDatabase supportSQLiteDatabase = this.i;
                if (supportSQLiteDatabase != null) {
                    supportSQLiteDatabase.close();
                }
                this.i = null;
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void e() {
        synchronized (this.d) {
            try {
                int i2 = this.g;
                if (i2 > 0) {
                    int i3 = i2 - 1;
                    this.g = i3;
                    if (i3 == 0) {
                        if (this.i != null) {
                            this.b.postDelayed(this.k, this.e);
                        } else {
                            return;
                        }
                    }
                    Unit unit = Unit.INSTANCE;
                    return;
                }
                throw new IllegalStateException("ref count is 0 or lower but we're supposed to decrement".toString());
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final Object g(Function1 function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        try {
            return function1.invoke(j());
        } finally {
            e();
        }
    }

    public final SupportSQLiteDatabase h() {
        return this.i;
    }

    public final SupportSQLiteOpenHelper i() {
        SupportSQLiteOpenHelper supportSQLiteOpenHelper = this.f1723a;
        if (supportSQLiteOpenHelper != null) {
            return supportSQLiteOpenHelper;
        }
        Intrinsics.throwUninitializedPropertyAccessException("delegateOpenHelper");
        return null;
    }

    public final SupportSQLiteDatabase j() {
        synchronized (this.d) {
            this.b.removeCallbacks(this.k);
            this.g++;
            if (!this.j) {
                SupportSQLiteDatabase supportSQLiteDatabase = this.i;
                if (supportSQLiteDatabase != null && supportSQLiteDatabase.isOpen()) {
                    return supportSQLiteDatabase;
                }
                SupportSQLiteDatabase I = i().I();
                this.i = I;
                return I;
            }
            throw new IllegalStateException("Attempting to open already closed database.".toString());
        }
    }

    public final void k(SupportSQLiteOpenHelper supportSQLiteOpenHelper) {
        Intrinsics.checkNotNullParameter(supportSQLiteOpenHelper, "delegateOpenHelper");
        n(supportSQLiteOpenHelper);
    }

    public final boolean l() {
        return !this.j;
    }

    public final void m(Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "onAutoClose");
        this.c = runnable;
    }

    public final void n(SupportSQLiteOpenHelper supportSQLiteOpenHelper) {
        Intrinsics.checkNotNullParameter(supportSQLiteOpenHelper, "<set-?>");
        this.f1723a = supportSQLiteOpenHelper;
    }
}
