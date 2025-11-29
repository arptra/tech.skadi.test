package androidx.databinding;

import androidx.annotation.RestrictTo;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\bB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Landroidx/databinding/ViewDataBindingKtx;", "", "<init>", "()V", "Landroidx/databinding/CreateWeakListener;", "b", "Landroidx/databinding/CreateWeakListener;", "CREATE_STATE_FLOW_LISTENER", "StateFlowListener", "databindingKtx_release"}, k = 1, mv = {1, 9, 0})
@RestrictTo
public final class ViewDataBindingKtx {

    /* renamed from: a  reason: collision with root package name */
    public static final ViewDataBindingKtx f981a = new ViewDataBindingKtx();
    public static final CreateWeakListener b = new a();

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00020\u0001J!\u0010\u0006\u001a\u00020\u00052\u0010\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\t\u0010\nR\"\u0010\u000f\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00020\f8\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0010"}, d2 = {"Landroidx/databinding/ViewDataBindingKtx$StateFlowListener;", "Landroidx/databinding/ObservableReference;", "Lkotlinx/coroutines/flow/Flow;", "", "target", "", "c", "(Lkotlinx/coroutines/flow/Flow;)V", "Lkotlinx/coroutines/Job;", "a", "Lkotlinx/coroutines/Job;", "observerJob", "Landroidx/databinding/WeakListener;", "b", "Landroidx/databinding/WeakListener;", "listener", "databindingKtx_release"}, k = 1, mv = {1, 9, 0})
    public static final class StateFlowListener implements ObservableReference<Flow<? extends Object>> {

        /* renamed from: a  reason: collision with root package name */
        public Job f982a;
        public final WeakListener b;

        /* renamed from: c */
        public void b(Flow flow) {
            Job job = this.f982a;
            if (job != null) {
                Job.DefaultImpls.a(job, (CancellationException) null, 1, (Object) null);
            }
            this.f982a = null;
        }
    }
}
