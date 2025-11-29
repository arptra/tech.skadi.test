package androidx.paging;

import android.util.Log;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListUpdateCallback;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000Y\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005*\u0001&\u0018\u0000 -*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0001:\u00010J!\u0010\u0007\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0004\b\u0007\u0010\bR\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\t8\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R \u0010\u001c\u001a\u00020\u00158\u0000X\u0004¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u0012\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0018\u0010\u0019R(\u0010%\u001a\u00020\u001d8\u0000@\u0000X\u000e¢\u0006\u0018\n\u0004\b\u001e\u0010\u001f\u0012\u0004\b$\u0010\u001b\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00000&8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010'R\u0014\u0010+\u001a\u00020)8\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010*R\u0011\u0010/\u001a\u00020,8F¢\u0006\u0006\u001a\u0004\b-\u0010.¨\u00061"}, d2 = {"Landroidx/paging/AsyncPagingDataDiffer;", "", "T", "Lkotlin/Function1;", "Landroidx/paging/CombinedLoadStates;", "", "listener", "i", "(Lkotlin/jvm/functions/Function1;)V", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "a", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "diffCallback", "Landroidx/recyclerview/widget/ListUpdateCallback;", "b", "Landroidx/recyclerview/widget/ListUpdateCallback;", "updateCallback", "Lkotlin/coroutines/CoroutineContext;", "c", "Lkotlin/coroutines/CoroutineContext;", "workerDispatcher", "Landroidx/paging/DifferCallback;", "d", "Landroidx/paging/DifferCallback;", "f", "()Landroidx/paging/DifferCallback;", "getDifferCallback$paging_runtime_release$annotations", "()V", "differCallback", "", "e", "Z", "g", "()Z", "setInGetItem$paging_runtime_release", "(Z)V", "getInGetItem$paging_runtime_release$annotations", "inGetItem", "androidx/paging/AsyncPagingDataDiffer$differBase$1", "Landroidx/paging/AsyncPagingDataDiffer$differBase$1;", "differBase", "Ljava/util/concurrent/atomic/AtomicInteger;", "Ljava/util/concurrent/atomic/AtomicInteger;", "submitDataId", "", "h", "()I", "itemCount", "Companion", "paging-runtime_release"}, k = 1, mv = {1, 8, 0})
public final class AsyncPagingDataDiffer<T> {
    public static final Companion h = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public final DiffUtil.ItemCallback f1516a;
    public final ListUpdateCallback b;
    public final CoroutineContext c;
    public final DifferCallback d;
    public boolean e;
    public final AsyncPagingDataDiffer$differBase$1 f;
    public final AtomicInteger g;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Landroidx/paging/AsyncPagingDataDiffer$Companion;", "", "()V", "paging-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    static {
        Logger a2 = LoggerKt.a();
        if (a2 == null) {
            a2 = new Logger() {
                public void a(int i, String str, Throwable th) {
                    Intrinsics.checkNotNullParameter(str, "message");
                    if (i == 2) {
                        Log.v("Paging", str, th);
                    } else if (i == 3) {
                        Log.d("Paging", str, th);
                    } else {
                        throw new IllegalArgumentException("debug level " + i + " is requested but Paging only supports default logging for level 2 (DEBUG) or level 3 (VERBOSE)");
                    }
                }

                public boolean b(int i) {
                    return Log.isLoggable("Paging", i);
                }
            };
        }
        LoggerKt.b(a2);
    }

    public final DifferCallback f() {
        return this.d;
    }

    public final boolean g() {
        return this.e;
    }

    public final int h() {
        return this.f.r();
    }

    public final void i(Function1 function1) {
        Intrinsics.checkNotNullParameter(function1, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.f.v(function1);
    }
}
