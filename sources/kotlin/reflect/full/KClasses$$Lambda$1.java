package kotlin.reflect.full;

import kotlin.reflect.KClass;
import kotlin.reflect.KProperty1;
import kotlin.reflect.jvm.internal.impl.utils.DFS;

class KClasses$$Lambda$1 implements DFS.Neighbors {
    private final KProperty1 arg$0;

    public KClasses$$Lambda$1(KProperty1 kProperty1) {
        this.arg$0 = kProperty1;
    }

    public Iterable getNeighbors(Object obj) {
        return KClasses.isSubclassOf$lambda$16(this.arg$0, (KClass) obj);
    }
}
