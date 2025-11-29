package androidx.work.impl.constraints.trackers;

import android.content.Context;
import android.net.ConnectivityManager;
import androidx.annotation.RequiresApi;
import androidx.work.Logger;
import androidx.work.impl.constraints.NetworkState;
import androidx.work.impl.utils.NetworkApi21;
import androidx.work.impl.utils.NetworkApi24;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@RequiresApi
@Metadata(d1 = {"\u00001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0005*\u0001\u0013\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\rR\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"Landroidx/work/impl/constraints/trackers/NetworkStateTracker24;", "Landroidx/work/impl/constraints/trackers/ConstraintTracker;", "Landroidx/work/impl/constraints/NetworkState;", "Landroid/content/Context;", "context", "Landroidx/work/impl/utils/taskexecutor/TaskExecutor;", "taskExecutor", "<init>", "(Landroid/content/Context;Landroidx/work/impl/utils/taskexecutor/TaskExecutor;)V", "k", "()Landroidx/work/impl/constraints/NetworkState;", "", "h", "()V", "i", "Landroid/net/ConnectivityManager;", "f", "Landroid/net/ConnectivityManager;", "connectivityManager", "androidx/work/impl/constraints/trackers/NetworkStateTracker24$networkCallback$1", "g", "Landroidx/work/impl/constraints/trackers/NetworkStateTracker24$networkCallback$1;", "networkCallback", "work-runtime_release"}, k = 1, mv = {1, 8, 0})
public final class NetworkStateTracker24 extends ConstraintTracker<NetworkState> {
    public final ConnectivityManager f;
    public final NetworkStateTracker24$networkCallback$1 g = new NetworkStateTracker24$networkCallback$1(this);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NetworkStateTracker24(Context context, TaskExecutor taskExecutor) {
        super(context, taskExecutor);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(taskExecutor, "taskExecutor");
        Object systemService = d().getSystemService("connectivity");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        this.f = (ConnectivityManager) systemService;
    }

    public void h() {
        try {
            Logger.e().a(NetworkStateTrackerKt.f2151a, "Registering network callback");
            NetworkApi24.a(this.f, this.g);
        } catch (IllegalArgumentException e) {
            Logger.e().d(NetworkStateTrackerKt.f2151a, "Received exception while registering network callback", e);
        } catch (SecurityException e2) {
            Logger.e().d(NetworkStateTrackerKt.f2151a, "Received exception while registering network callback", e2);
        }
    }

    public void i() {
        try {
            Logger.e().a(NetworkStateTrackerKt.f2151a, "Unregistering network callback");
            NetworkApi21.c(this.f, this.g);
        } catch (IllegalArgumentException e) {
            Logger.e().d(NetworkStateTrackerKt.f2151a, "Received exception while unregistering network callback", e);
        } catch (SecurityException e2) {
            Logger.e().d(NetworkStateTrackerKt.f2151a, "Received exception while unregistering network callback", e2);
        }
    }

    /* renamed from: k */
    public NetworkState e() {
        return NetworkStateTrackerKt.c(this.f);
    }
}
