package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.utils.DFS;

class JvmBuiltInsCustomizer$$Lambda$0 implements DFS.Neighbors {
    public static final JvmBuiltInsCustomizer$$Lambda$0 INSTANCE = new JvmBuiltInsCustomizer$$Lambda$0();

    public Iterable getNeighbors(Object obj) {
        return JvmBuiltInsCustomizer.isMutabilityViolation$lambda$7((CallableMemberDescriptor) obj);
    }
}
