package kotlin.reflect.jvm.internal;

import java.util.Comparator;
import kotlin.jvm.functions.Function2;

class KDeclarationContainerImpl$$Lambda$0 implements Comparator {
    private final Function2 arg$0;

    public KDeclarationContainerImpl$$Lambda$0(Function2 function2) {
        this.arg$0 = function2;
    }

    public int compare(Object obj, Object obj2) {
        return KDeclarationContainerImpl.findPropertyDescriptor$lambda$3(this.arg$0, obj, obj2);
    }
}
