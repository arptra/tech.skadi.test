package androidx.lifecycle;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "X", "value", "kotlin.jvm.PlatformType", "invoke", "(Ljava/lang/Object;)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
public final class Transformations$distinctUntilChanged$1 extends Lambda implements Function1<Object, Unit> {
    final /* synthetic */ Ref.BooleanRef $firstTime;
    final /* synthetic */ MediatorLiveData<Object> $outputLiveData;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Transformations$distinctUntilChanged$1(MediatorLiveData<Object> mediatorLiveData, Ref.BooleanRef booleanRef) {
        super(1);
        this.$outputLiveData = mediatorLiveData;
        this.$firstTime = booleanRef;
    }

    public final void invoke(Object obj) {
        Object value = this.$outputLiveData.getValue();
        if (this.$firstTime.element || ((value == null && obj != null) || (value != null && !Intrinsics.areEqual(value, obj)))) {
            this.$firstTime.element = false;
            this.$outputLiveData.setValue(obj);
        }
    }
}
