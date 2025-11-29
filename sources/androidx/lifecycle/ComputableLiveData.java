package androidx.lifecycle;

import androidx.annotation.RestrictTo;
import java.util.concurrent.Executor;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b'\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002R\u001a\u0010\u0007\u001a\u00020\u00038\u0000X\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0004\u0010\u0006R\u001a\u0010\r\u001a\u00020\b8\u0000X\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u0012\u0004\b\u000b\u0010\f¨\u0006\u000e"}, d2 = {"Landroidx/lifecycle/ComputableLiveData;", "T", "", "Ljava/util/concurrent/Executor;", "a", "Ljava/util/concurrent/Executor;", "()Ljava/util/concurrent/Executor;", "executor", "Ljava/lang/Runnable;", "b", "Ljava/lang/Runnable;", "getRefreshRunnable$lifecycle_livedata_release$annotations", "()V", "refreshRunnable", "lifecycle-livedata_release"}, k = 1, mv = {1, 8, 0})
@RestrictTo
public abstract class ComputableLiveData<T> {

    /* renamed from: a  reason: collision with root package name */
    public final Executor f1349a;
    public final Runnable b;

    public final Executor a() {
        return this.f1349a;
    }
}
