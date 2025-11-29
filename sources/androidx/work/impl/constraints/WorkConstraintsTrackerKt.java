package androidx.work.impl.constraints;

import androidx.work.Logger;
import androidx.work.impl.model.WorkSpec;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u001a)\u0010\b\u001a\u00020\u0007*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\t\"\u0014\u0010\r\u001a\u00020\n8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u000e"}, d2 = {"Landroidx/work/impl/constraints/WorkConstraintsTracker;", "Landroidx/work/impl/model/WorkSpec;", "spec", "Lkotlinx/coroutines/CoroutineDispatcher;", "dispatcher", "Landroidx/work/impl/constraints/OnConstraintsStateChangedListener;", "listener", "Lkotlinx/coroutines/Job;", "b", "(Landroidx/work/impl/constraints/WorkConstraintsTracker;Landroidx/work/impl/model/WorkSpec;Lkotlinx/coroutines/CoroutineDispatcher;Landroidx/work/impl/constraints/OnConstraintsStateChangedListener;)Lkotlinx/coroutines/Job;", "", "a", "Ljava/lang/String;", "TAG", "work-runtime_release"}, k = 2, mv = {1, 8, 0})
public final class WorkConstraintsTrackerKt {

    /* renamed from: a  reason: collision with root package name */
    public static final String f2140a;

    static {
        String i = Logger.i("WorkConstraintsTracker");
        Intrinsics.checkNotNullExpressionValue(i, "tagWithPrefix(\"WorkConstraintsTracker\")");
        f2140a = i;
    }

    public static final Job b(WorkConstraintsTracker workConstraintsTracker, WorkSpec workSpec, CoroutineDispatcher coroutineDispatcher, OnConstraintsStateChangedListener onConstraintsStateChangedListener) {
        Intrinsics.checkNotNullParameter(workConstraintsTracker, "<this>");
        Intrinsics.checkNotNullParameter(workSpec, "spec");
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "dispatcher");
        Intrinsics.checkNotNullParameter(onConstraintsStateChangedListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        CompletableJob b = JobKt__JobKt.b((Job) null, 1, (Object) null);
        Job unused = BuildersKt__Builders_commonKt.d(CoroutineScopeKt.a(coroutineDispatcher.plus(b)), (CoroutineContext) null, (CoroutineStart) null, new WorkConstraintsTrackerKt$listen$1(workConstraintsTracker, workSpec, onConstraintsStateChangedListener, (Continuation<? super WorkConstraintsTrackerKt$listen$1>) null), 3, (Object) null);
        return b;
    }
}
