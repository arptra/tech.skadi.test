package androidx.lifecycle;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u000e\u0010\u0004\u001a\n \u0005*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", "X", "Y", "x", "kotlin.jvm.PlatformType", "invoke", "(Ljava/lang/Object;)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
public final class Transformations$map$1 extends Lambda implements Function1<Object, Unit> {
    final /* synthetic */ MediatorLiveData<Object> $result;
    final /* synthetic */ Function1<Object, Object> $transform;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Transformations$map$1(MediatorLiveData<Object> mediatorLiveData, Function1<Object, Object> function1) {
        super(1);
        this.$result = mediatorLiveData;
        this.$transform = function1;
    }

    public final void invoke(Object obj) {
        this.$result.setValue(this.$transform.invoke(obj));
    }
}
