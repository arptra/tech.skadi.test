package androidx.work.impl.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001d\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroidx/work/impl/model/WorkGenerationalId;", "generationalId", "", "systemId", "Landroidx/work/impl/model/SystemIdInfo;", "a", "(Landroidx/work/impl/model/WorkGenerationalId;I)Landroidx/work/impl/model/SystemIdInfo;", "work-runtime_release"}, k = 2, mv = {1, 8, 0})
public final class SystemIdInfoKt {
    public static final SystemIdInfo a(WorkGenerationalId workGenerationalId, int i) {
        Intrinsics.checkNotNullParameter(workGenerationalId, "generationalId");
        return new SystemIdInfo(workGenerationalId.b(), workGenerationalId.a(), i);
    }
}
