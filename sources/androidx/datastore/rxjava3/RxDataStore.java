package androidx.datastore.rxjava3;

import androidx.annotation.RestrictTo;
import androidx.datastore.core.DataStore;
import io.reactivex.rxjava3.disposables.Disposable;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u0000 \u0014*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003:\u0001\u0015B\u001f\b\u0002\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0016"}, d2 = {"Landroidx/datastore/rxjava3/RxDataStore;", "", "T", "Lio/reactivex/rxjava3/disposables/Disposable;", "Landroidx/datastore/core/DataStore;", "delegateDs", "Lkotlinx/coroutines/CoroutineScope;", "scope", "<init>", "(Landroidx/datastore/core/DataStore;Lkotlinx/coroutines/CoroutineScope;)V", "", "dispose", "()V", "", "isDisposed", "()Z", "a", "Landroidx/datastore/core/DataStore;", "b", "Lkotlinx/coroutines/CoroutineScope;", "c", "Companion", "datastore-rxjava3_release"}, k = 1, mv = {1, 5, 1})
public final class RxDataStore<T> implements Disposable {
    public static final Companion c = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public final DataStore f1168a;
    public final CoroutineScope b;

    @RestrictTo
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J3\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00010\t\"\b\b\u0001\u0010\u0004*\u00020\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u00052\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Landroidx/datastore/rxjava3/RxDataStore$Companion;", "", "<init>", "()V", "T", "Landroidx/datastore/core/DataStore;", "delegateDs", "Lkotlinx/coroutines/CoroutineScope;", "scope", "Landroidx/datastore/rxjava3/RxDataStore;", "a", "(Landroidx/datastore/core/DataStore;Lkotlinx/coroutines/CoroutineScope;)Landroidx/datastore/rxjava3/RxDataStore;", "datastore-rxjava3_release"}, k = 1, mv = {1, 5, 1})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final RxDataStore a(DataStore dataStore, CoroutineScope coroutineScope) {
            Intrinsics.checkNotNullParameter(dataStore, "delegateDs");
            Intrinsics.checkNotNullParameter(coroutineScope, "scope");
            return new RxDataStore(dataStore, coroutineScope, (DefaultConstructorMarker) null);
        }

        public Companion() {
        }
    }

    public /* synthetic */ RxDataStore(DataStore dataStore, CoroutineScope coroutineScope, DefaultConstructorMarker defaultConstructorMarker) {
        this(dataStore, coroutineScope);
    }

    public void dispose() {
        Job.DefaultImpls.a(JobKt.k(this.b.getCoroutineContext()), (CancellationException) null, 1, (Object) null);
    }

    public boolean isDisposed() {
        return JobKt.k(this.b.getCoroutineContext()).isActive();
    }

    public RxDataStore(DataStore dataStore, CoroutineScope coroutineScope) {
        this.f1168a = dataStore;
        this.b = coroutineScope;
    }
}
