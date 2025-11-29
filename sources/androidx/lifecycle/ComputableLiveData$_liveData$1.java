package androidx.lifecycle;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"androidx/lifecycle/ComputableLiveData$_liveData$1", "Landroidx/lifecycle/LiveData;", "", "onActive", "()V", "lifecycle-livedata_release"}, k = 1, mv = {1, 8, 0})
public final class ComputableLiveData$_liveData$1 extends LiveData<Object> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ComputableLiveData f1350a;

    public void onActive() {
        this.f1350a.a().execute(this.f1350a.b);
    }
}
