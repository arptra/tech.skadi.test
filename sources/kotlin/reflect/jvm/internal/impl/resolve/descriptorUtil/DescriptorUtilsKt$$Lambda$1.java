package kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil;

import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.utils.DFS;

class DescriptorUtilsKt$$Lambda$1 implements DFS.Neighbors {
    private final boolean arg$0;

    public DescriptorUtilsKt$$Lambda$1(boolean z) {
        this.arg$0 = z;
    }

    public Iterable getNeighbors(Object obj) {
        return DescriptorUtilsKt.firstOverridden$lambda$9(this.arg$0, (CallableMemberDescriptor) obj);
    }
}
