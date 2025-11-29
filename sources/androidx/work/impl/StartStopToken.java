package androidx.work.impl;

import androidx.work.impl.model.WorkGenerationalId;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0006\u0010\b¨\u0006\t"}, d2 = {"Landroidx/work/impl/StartStopToken;", "", "Landroidx/work/impl/model/WorkGenerationalId;", "id", "<init>", "(Landroidx/work/impl/model/WorkGenerationalId;)V", "a", "Landroidx/work/impl/model/WorkGenerationalId;", "()Landroidx/work/impl/model/WorkGenerationalId;", "work-runtime_release"}, k = 1, mv = {1, 8, 0})
public final class StartStopToken {

    /* renamed from: a  reason: collision with root package name */
    public final WorkGenerationalId f2093a;

    public StartStopToken(WorkGenerationalId workGenerationalId) {
        Intrinsics.checkNotNullParameter(workGenerationalId, "id");
        this.f2093a = workGenerationalId;
    }

    public final WorkGenerationalId a() {
        return this.f2093a;
    }
}
