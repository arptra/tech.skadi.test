package androidx.room;

import androidx.annotation.RestrictTo;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b'\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H$¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0014¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0012\u0010\u000eJ\u0017\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0017R\u0014\u0010\u0019\u001a\u00020\u00188\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u001b\u0010\u001e\u001a\u00020\f8BX\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u000e¨\u0006\u001f"}, d2 = {"Landroidx/room/SharedSQLiteStatement;", "", "Landroidx/room/RoomDatabase;", "database", "<init>", "(Landroidx/room/RoomDatabase;)V", "", "createQuery", "()Ljava/lang/String;", "", "assertNotMainThread", "()V", "Landroidx/sqlite/db/SupportSQLiteStatement;", "acquire", "()Landroidx/sqlite/db/SupportSQLiteStatement;", "statement", "release", "(Landroidx/sqlite/db/SupportSQLiteStatement;)V", "a", "", "canUseCached", "c", "(Z)Landroidx/sqlite/db/SupportSQLiteStatement;", "Landroidx/room/RoomDatabase;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "lock", "Ljava/util/concurrent/atomic/AtomicBoolean;", "stmt$delegate", "Lkotlin/Lazy;", "b", "stmt", "room-runtime_release"}, k = 1, mv = {1, 8, 0})
@RestrictTo
public abstract class SharedSQLiteStatement {
    @NotNull
    private final RoomDatabase database;
    @NotNull
    private final AtomicBoolean lock = new AtomicBoolean(false);
    @NotNull
    private final Lazy stmt$delegate = LazyKt.lazy(new SharedSQLiteStatement$stmt$2(this));

    public SharedSQLiteStatement(RoomDatabase roomDatabase) {
        Intrinsics.checkNotNullParameter(roomDatabase, "database");
        this.database = roomDatabase;
    }

    public final SupportSQLiteStatement a() {
        return this.database.compileStatement(createQuery());
    }

    @NotNull
    public SupportSQLiteStatement acquire() {
        assertNotMainThread();
        return c(this.lock.compareAndSet(false, true));
    }

    public void assertNotMainThread() {
        this.database.assertNotMainThread();
    }

    public final SupportSQLiteStatement b() {
        return (SupportSQLiteStatement) this.stmt$delegate.getValue();
    }

    public final SupportSQLiteStatement c(boolean z) {
        return z ? b() : a();
    }

    public abstract String createQuery();

    public void release(@NotNull SupportSQLiteStatement supportSQLiteStatement) {
        Intrinsics.checkNotNullParameter(supportSQLiteStatement, "statement");
        if (supportSQLiteStatement == b()) {
            this.lock.set(false);
        }
    }
}
