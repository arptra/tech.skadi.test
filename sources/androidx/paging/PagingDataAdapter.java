package androidx.paging;

import androidx.paging.LoadState;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0004*\u00020\u00032\b\u0012\u0004\u0012\u00028\u00010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J!\u0010\u0019\u001a\u00020\b2\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\b0\u0016¢\u0006\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001d\u001a\u00020\u00108\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u001a\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00000\u001e8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 ¨\u0006\""}, d2 = {"Landroidx/paging/PagingDataAdapter;", "", "T", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "VH", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter$StateRestorationPolicy;", "strategy", "", "setStateRestorationPolicy", "(Landroidx/recyclerview/widget/RecyclerView$Adapter$StateRestorationPolicy;)V", "", "position", "", "getItemId", "(I)J", "", "hasStableIds", "setHasStableIds", "(Z)V", "getItemCount", "()I", "Lkotlin/Function1;", "Landroidx/paging/CombinedLoadStates;", "listener", "i", "(Lkotlin/jvm/functions/Function1;)V", "a", "Z", "userSetRestorationPolicy", "Landroidx/paging/AsyncPagingDataDiffer;", "b", "Landroidx/paging/AsyncPagingDataDiffer;", "differ", "paging-runtime_release"}, k = 1, mv = {1, 8, 0})
public abstract class PagingDataAdapter<T, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {

    /* renamed from: a  reason: collision with root package name */
    public boolean f1598a;
    public final AsyncPagingDataDiffer b;

    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"androidx/paging/PagingDataAdapter$1", "Landroidx/recyclerview/widget/RecyclerView$AdapterDataObserver;", "", "positionStart", "itemCount", "", "onItemRangeInserted", "(II)V", "paging-runtime_release"}, k = 1, mv = {1, 8, 0})
    /* renamed from: androidx.paging.PagingDataAdapter$1  reason: invalid class name */
    public final class AnonymousClass1 extends RecyclerView.AdapterDataObserver {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PagingDataAdapter f1599a;

        public void onItemRangeInserted(int i, int i2) {
            PagingDataAdapter.g(this.f1599a);
            this.f1599a.unregisterAdapterDataObserver(this);
            super.onItemRangeInserted(i, i2);
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0018\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\t\u001a\u00020\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\b¨\u0006\n"}, d2 = {"androidx/paging/PagingDataAdapter$2", "Lkotlin/Function1;", "Landroidx/paging/CombinedLoadStates;", "", "loadStates", "a", "(Landroidx/paging/CombinedLoadStates;)V", "", "Z", "ignoreNextEvent", "paging-runtime_release"}, k = 1, mv = {1, 8, 0})
    /* renamed from: androidx.paging.PagingDataAdapter$2  reason: invalid class name */
    public final class AnonymousClass2 implements Function1<CombinedLoadStates, Unit> {

        /* renamed from: a  reason: collision with root package name */
        public boolean f1600a;
        public final /* synthetic */ PagingDataAdapter b;

        public void a(CombinedLoadStates combinedLoadStates) {
            Intrinsics.checkNotNullParameter(combinedLoadStates, "loadStates");
            if (this.f1600a) {
                this.f1600a = false;
            } else if (combinedLoadStates.e().f() instanceof LoadState.NotLoading) {
                PagingDataAdapter.g(this.b);
                this.b.i(this);
            }
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((CombinedLoadStates) obj);
            return Unit.INSTANCE;
        }
    }

    public static final void g(PagingDataAdapter pagingDataAdapter) {
        if (pagingDataAdapter.getStateRestorationPolicy() == RecyclerView.Adapter.StateRestorationPolicy.PREVENT && !pagingDataAdapter.f1598a) {
            pagingDataAdapter.setStateRestorationPolicy(RecyclerView.Adapter.StateRestorationPolicy.ALLOW);
        }
    }

    public int getItemCount() {
        return this.b.h();
    }

    public final long getItemId(int i) {
        return super.getItemId(i);
    }

    public final void i(Function1 function1) {
        Intrinsics.checkNotNullParameter(function1, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.b.i(function1);
    }

    public final void setHasStableIds(boolean z) {
        throw new UnsupportedOperationException("Stable ids are unsupported on PagingDataAdapter.");
    }

    public void setStateRestorationPolicy(RecyclerView.Adapter.StateRestorationPolicy stateRestorationPolicy) {
        Intrinsics.checkNotNullParameter(stateRestorationPolicy, "strategy");
        this.f1598a = true;
        super.setStateRestorationPolicy(stateRestorationPolicy);
    }
}
