package kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil;

import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.utils.DFS;

class DescriptorUtilsKt$$Lambda$0 implements DFS.Neighbors {
    public static final DescriptorUtilsKt$$Lambda$0 INSTANCE = new DescriptorUtilsKt$$Lambda$0();

    public Iterable getNeighbors(Object obj) {
        return DescriptorUtilsKt.declaresOrInheritsDefaultValue$lambda$5((ValueParameterDescriptor) obj);
    }
}
