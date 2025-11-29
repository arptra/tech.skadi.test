package androidx.work.impl.workers;

import androidx.work.ListenableWorker;
import androidx.work.Logger;
import androidx.work.impl.utils.futures.SettableFuture;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\u001a\u0019\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\u0002¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0019\u0010\u0005\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\u0002¢\u0006\u0004\b\u0005\u0010\u0004\"\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Landroidx/work/impl/utils/futures/SettableFuture;", "Landroidx/work/ListenableWorker$Result;", "", "d", "(Landroidx/work/impl/utils/futures/SettableFuture;)Z", "e", "", "a", "Ljava/lang/String;", "TAG", "work-runtime_release"}, k = 2, mv = {1, 8, 0})
public final class ConstraintTrackingWorkerKt {

    /* renamed from: a  reason: collision with root package name */
    public static final String f2262a;

    static {
        String i = Logger.i("ConstraintTrkngWrkr");
        Intrinsics.checkNotNullExpressionValue(i, "tagWithPrefix(\"ConstraintTrkngWrkr\")");
        f2262a = i;
    }

    public static final boolean d(SettableFuture settableFuture) {
        return settableFuture.o(ListenableWorker.Result.a());
    }

    public static final boolean e(SettableFuture settableFuture) {
        return settableFuture.o(ListenableWorker.Result.b());
    }
}
