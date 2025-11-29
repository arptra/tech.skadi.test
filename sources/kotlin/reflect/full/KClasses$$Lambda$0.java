package kotlin.reflect.full;

import kotlin.reflect.KType;
import kotlin.reflect.jvm.internal.impl.utils.DFS;

class KClasses$$Lambda$0 implements DFS.Neighbors {
    public static final KClasses$$Lambda$0 INSTANCE = new KClasses$$Lambda$0();

    public Iterable getNeighbors(Object obj) {
        return KClasses._get_allSupertypes_$lambda$14((KType) obj);
    }
}
