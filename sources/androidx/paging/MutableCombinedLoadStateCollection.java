package androidx.paging;

import androidx.paging.LoadState;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001J\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0006\u0010\u0007J%\u0010\u000e\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0013\u001a\u00020\u00052\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00050\u0010¢\u0006\u0004\b\u0013\u0010\u0014J4\u0010\u0019\u001a\u00020\u00052#\u0010\u0018\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0011¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u00110\u0010H\u0002¢\u0006\u0004\b\u0019\u0010\u0014J+\u0010\u001d\u001a\u00020\u00112\b\u0010\u001a\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u001b\u001a\u00020\u00022\b\u0010\u001c\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ1\u0010\"\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\f2\u0006\u0010 \u001a\u00020\f2\b\u0010!\u001a\u0004\u0018\u00010\fH\u0002¢\u0006\u0004\b\"\u0010#R&\u0010'\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00050\u00100$8\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u001c\u0010*\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110(8\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010)R\u001f\u0010/\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110+8\u0006¢\u0006\f\n\u0004\b\u001d\u0010,\u001a\u0004\b-\u0010.¨\u00060"}, d2 = {"Landroidx/paging/MutableCombinedLoadStateCollection;", "", "Landroidx/paging/LoadStates;", "sourceLoadStates", "remoteLoadStates", "", "g", "(Landroidx/paging/LoadStates;Landroidx/paging/LoadStates;)V", "Landroidx/paging/LoadType;", "type", "", "remote", "Landroidx/paging/LoadState;", "state", "h", "(Landroidx/paging/LoadType;ZLandroidx/paging/LoadState;)V", "Lkotlin/Function1;", "Landroidx/paging/CombinedLoadStates;", "listener", "f", "(Lkotlin/jvm/functions/Function1;)V", "Lkotlin/ParameterName;", "name", "currState", "computeNewState", "d", "previousState", "newSource", "newRemote", "c", "(Landroidx/paging/CombinedLoadStates;Landroidx/paging/LoadStates;Landroidx/paging/LoadStates;)Landroidx/paging/CombinedLoadStates;", "sourceRefreshState", "sourceState", "remoteState", "b", "(Landroidx/paging/LoadState;Landroidx/paging/LoadState;Landroidx/paging/LoadState;Landroidx/paging/LoadState;)Landroidx/paging/LoadState;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "a", "Ljava/util/concurrent/CopyOnWriteArrayList;", "listeners", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lkotlinx/coroutines/flow/MutableStateFlow;", "_stateFlow", "Lkotlinx/coroutines/flow/StateFlow;", "Lkotlinx/coroutines/flow/StateFlow;", "e", "()Lkotlinx/coroutines/flow/StateFlow;", "stateFlow", "paging-common"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nMutableCombinedLoadStateCollection.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MutableCombinedLoadStateCollection.kt\nandroidx/paging/MutableCombinedLoadStateCollection\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 StateFlow.kt\nkotlinx/coroutines/flow/StateFlowKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,168:1\n1#2:169\n230#3,5:170\n1855#4,2:175\n*S KotlinDebug\n*F\n+ 1 MutableCombinedLoadStateCollection.kt\nandroidx/paging/MutableCombinedLoadStateCollection\n*L\n96#1:170,5\n106#1:175,2\n*E\n"})
public final class MutableCombinedLoadStateCollection {

    /* renamed from: a  reason: collision with root package name */
    public final CopyOnWriteArrayList f1559a;
    public final MutableStateFlow b;
    public final StateFlow c;

    public final LoadState b(LoadState loadState, LoadState loadState2, LoadState loadState3, LoadState loadState4) {
        return loadState4 == null ? loadState3 : (!(loadState instanceof LoadState.Loading) || ((loadState2 instanceof LoadState.NotLoading) && (loadState4 instanceof LoadState.NotLoading)) || (loadState4 instanceof LoadState.Error)) ? loadState4 : loadState;
    }

    public final CombinedLoadStates c(CombinedLoadStates combinedLoadStates, LoadStates loadStates, LoadStates loadStates2) {
        LoadState loadState;
        LoadState loadState2;
        LoadState loadState3;
        if (combinedLoadStates == null || (loadState = combinedLoadStates.d()) == null) {
            loadState = LoadState.NotLoading.b.b();
        }
        LoadState loadState4 = null;
        LoadState b2 = b(loadState, loadStates.f(), loadStates.f(), loadStates2 != null ? loadStates2.f() : null);
        if (combinedLoadStates == null || (loadState2 = combinedLoadStates.c()) == null) {
            loadState2 = LoadState.NotLoading.b.b();
        }
        LoadState b3 = b(loadState2, loadStates.f(), loadStates.e(), loadStates2 != null ? loadStates2.e() : null);
        if (combinedLoadStates == null || (loadState3 = combinedLoadStates.a()) == null) {
            loadState3 = LoadState.NotLoading.b.b();
        }
        LoadState f = loadStates.f();
        LoadState d = loadStates.d();
        if (loadStates2 != null) {
            loadState4 = loadStates2.d();
        }
        return new CombinedLoadStates(b2, b3, b(loadState3, f, d, loadState4), loadStates, loadStates2);
    }

    public final void d(Function1 function1) {
        Object value;
        CombinedLoadStates combinedLoadStates;
        MutableStateFlow mutableStateFlow = this.b;
        do {
            value = mutableStateFlow.getValue();
            CombinedLoadStates combinedLoadStates2 = (CombinedLoadStates) value;
            combinedLoadStates = (CombinedLoadStates) function1.invoke(combinedLoadStates2);
            if (Intrinsics.areEqual((Object) combinedLoadStates2, (Object) combinedLoadStates)) {
                return;
            }
        } while (!mutableStateFlow.compareAndSet(value, combinedLoadStates));
        if (combinedLoadStates != null) {
            for (Function1 invoke : this.f1559a) {
                invoke.invoke(combinedLoadStates);
            }
        }
    }

    public final StateFlow e() {
        return this.c;
    }

    public final void f(Function1 function1) {
        Intrinsics.checkNotNullParameter(function1, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.f1559a.remove(function1);
    }

    public final void g(LoadStates loadStates, LoadStates loadStates2) {
        Intrinsics.checkNotNullParameter(loadStates, "sourceLoadStates");
        d(new MutableCombinedLoadStateCollection$set$1(this, loadStates, loadStates2));
    }

    public final void h(LoadType loadType, boolean z, LoadState loadState) {
        Intrinsics.checkNotNullParameter(loadType, "type");
        Intrinsics.checkNotNullParameter(loadState, "state");
        d(new MutableCombinedLoadStateCollection$set$2(z, loadType, loadState, this));
    }
}
