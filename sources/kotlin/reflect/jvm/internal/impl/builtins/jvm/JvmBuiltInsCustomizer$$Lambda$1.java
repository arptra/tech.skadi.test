package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.utils.DFS;

class JvmBuiltInsCustomizer$$Lambda$1 implements DFS.Neighbors {
    private final JvmBuiltInsCustomizer arg$0;

    public JvmBuiltInsCustomizer$$Lambda$1(JvmBuiltInsCustomizer jvmBuiltInsCustomizer) {
        this.arg$0 = jvmBuiltInsCustomizer;
    }

    public Iterable getNeighbors(Object obj) {
        return JvmBuiltInsCustomizer.getJdkMethodStatus$lambda$9(this.arg$0, (ClassDescriptor) obj);
    }
}
