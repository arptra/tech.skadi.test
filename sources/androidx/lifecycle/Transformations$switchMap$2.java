package androidx.lifecycle;

import androidx.arch.core.util.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0017\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0004\u0010\u0005R*\u0010\r\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00068\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u000e"}, d2 = {"androidx/lifecycle/Transformations$switchMap$2", "Landroidx/lifecycle/Observer;", "value", "", "onChanged", "(Ljava/lang/Object;)V", "Landroidx/lifecycle/LiveData;", "a", "Landroidx/lifecycle/LiveData;", "getLiveData", "()Landroidx/lifecycle/LiveData;", "setLiveData", "(Landroidx/lifecycle/LiveData;)V", "liveData", "lifecycle-livedata_release"}, k = 1, mv = {1, 8, 0})
public final class Transformations$switchMap$2 implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public LiveData f1393a;
    public final /* synthetic */ Function b;
    public final /* synthetic */ MediatorLiveData c;

    public void onChanged(Object obj) {
        LiveData liveData = (LiveData) this.b.apply(obj);
        LiveData liveData2 = this.f1393a;
        if (liveData2 != liveData) {
            if (liveData2 != null) {
                MediatorLiveData mediatorLiveData = this.c;
                Intrinsics.checkNotNull(liveData2);
                mediatorLiveData.d(liveData2);
            }
            this.f1393a = liveData;
            if (liveData != null) {
                MediatorLiveData mediatorLiveData2 = this.c;
                Intrinsics.checkNotNull(liveData);
                mediatorLiveData2.c(liveData, new Transformations$sam$androidx_lifecycle_Observer$0(new Transformations$switchMap$2$onChanged$1(this.c)));
            }
        }
    }
}
