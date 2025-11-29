package androidx.work.impl.utils;

import androidx.work.impl.WorkDatabase;
import com.honey.account.p0.e;
import com.honey.account.p0.f;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Landroidx/work/impl/utils/IdGenerator;", "", "Landroidx/work/impl/WorkDatabase;", "workDatabase", "<init>", "(Landroidx/work/impl/WorkDatabase;)V", "", "minInclusive", "maxInclusive", "e", "(II)I", "c", "()I", "a", "Landroidx/work/impl/WorkDatabase;", "work-runtime_release"}, k = 1, mv = {1, 8, 0})
public final class IdGenerator {

    /* renamed from: a  reason: collision with root package name */
    public final WorkDatabase f2231a;

    public IdGenerator(WorkDatabase workDatabase) {
        Intrinsics.checkNotNullParameter(workDatabase, "workDatabase");
        this.f2231a = workDatabase;
    }

    public static final Integer d(IdGenerator idGenerator) {
        Intrinsics.checkNotNullParameter(idGenerator, "this$0");
        return Integer.valueOf(IdGeneratorKt.d(idGenerator.f2231a, "next_alarm_manager_id"));
    }

    public static final Integer f(IdGenerator idGenerator, int i, int i2) {
        Intrinsics.checkNotNullParameter(idGenerator, "this$0");
        int a2 = IdGeneratorKt.d(idGenerator.f2231a, "next_job_scheduler_id");
        if (i > a2 || a2 > i2) {
            IdGeneratorKt.e(idGenerator.f2231a, "next_job_scheduler_id", i + 1);
        } else {
            i = a2;
        }
        return Integer.valueOf(i);
    }

    public final int c() {
        Object runInTransaction = this.f2231a.runInTransaction(new e(this));
        Intrinsics.checkNotNullExpressionValue(runInTransaction, "workDatabase.runInTransa…ANAGER_ID_KEY)\n        })");
        return ((Number) runInTransaction).intValue();
    }

    public final int e(int i, int i2) {
        Object runInTransaction = this.f2231a.runInTransaction(new f(this, i, i2));
        Intrinsics.checkNotNullExpressionValue(runInTransaction, "workDatabase.runInTransa…            id\n        })");
        return ((Number) runInTransaction).intValue();
    }
}
