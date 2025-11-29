package kotlinx.coroutines.rx3;

import io.reactivex.rxjava3.functions.Cancellable;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00058\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lkotlinx/coroutines/rx3/RxCancellable;", "Lio/reactivex/rxjava3/functions/Cancellable;", "", "cancel", "()V", "Lkotlinx/coroutines/Job;", "a", "Lkotlinx/coroutines/Job;", "job", "kotlinx-coroutines-rx3"}, k = 1, mv = {1, 8, 0})
public final class RxCancellable implements Cancellable {

    /* renamed from: a  reason: collision with root package name */
    public final Job f3954a;

    public void cancel() {
        Job.DefaultImpls.a(this.f3954a, (CancellationException) null, 1, (Object) null);
    }
}
