package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.utils.DFS;

class LazyJavaStaticClassScope$$Lambda$0 implements DFS.Neighbors {
    public static final LazyJavaStaticClassScope$$Lambda$0 INSTANCE = new LazyJavaStaticClassScope$$Lambda$0();

    public Iterable getNeighbors(Object obj) {
        return LazyJavaStaticClassScope.flatMapJavaStaticSupertypesScopes$lambda$6((ClassDescriptor) obj);
    }
}
