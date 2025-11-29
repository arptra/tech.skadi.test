package kotlin.reflect.jvm.internal.calls;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;

class AnnotationConstructorCallerKt$$Lambda$0 implements InvocationHandler {
    private final Class arg$0;
    private final Map arg$1;
    private final Lazy arg$2;
    private final Lazy arg$3;
    private final List arg$4;

    public AnnotationConstructorCallerKt$$Lambda$0(Class cls, Map map, Lazy lazy, Lazy lazy2, List list) {
        this.arg$0 = cls;
        this.arg$1 = map;
        this.arg$2 = lazy;
        this.arg$3 = lazy2;
        this.arg$4 = list;
    }

    public Object invoke(Object obj, Method method, Object[] objArr) {
        return AnnotationConstructorCallerKt.createAnnotationInstance$lambda$4(this.arg$0, this.arg$1, this.arg$2, this.arg$3, this.arg$4, obj, method, objArr);
    }
}
