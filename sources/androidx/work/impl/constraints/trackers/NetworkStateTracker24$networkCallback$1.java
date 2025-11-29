package androidx.work.impl.constraints.trackers;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import androidx.work.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\t"}, d2 = {"androidx/work/impl/constraints/trackers/NetworkStateTracker24$networkCallback$1", "Landroid/net/ConnectivityManager$NetworkCallback;", "onCapabilitiesChanged", "", "network", "Landroid/net/Network;", "capabilities", "Landroid/net/NetworkCapabilities;", "onLost", "work-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class NetworkStateTracker24$networkCallback$1 extends ConnectivityManager.NetworkCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ NetworkStateTracker24 f2150a;

    public NetworkStateTracker24$networkCallback$1(NetworkStateTracker24 networkStateTracker24) {
        this.f2150a = networkStateTracker24;
    }

    public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
        Intrinsics.checkNotNullParameter(network, "network");
        Intrinsics.checkNotNullParameter(networkCapabilities, "capabilities");
        Logger e = Logger.e();
        String b = NetworkStateTrackerKt.f2151a;
        e.a(b, "Network capabilities changed: " + networkCapabilities);
        NetworkStateTracker24 networkStateTracker24 = this.f2150a;
        networkStateTracker24.g(NetworkStateTrackerKt.c(networkStateTracker24.f));
    }

    public void onLost(Network network) {
        Intrinsics.checkNotNullParameter(network, "network");
        Logger.e().a(NetworkStateTrackerKt.f2151a, "Network connection lost");
        NetworkStateTracker24 networkStateTracker24 = this.f2150a;
        networkStateTracker24.g(NetworkStateTrackerKt.c(networkStateTracker24.f));
    }
}
