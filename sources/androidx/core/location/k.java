package androidx.core.location;

import android.location.Location;
import androidx.core.location.LocationManagerCompat;

public final /* synthetic */ class k implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LocationManagerCompat.LocationListenerTransport f760a;
    public final /* synthetic */ Location b;

    public /* synthetic */ k(LocationManagerCompat.LocationListenerTransport locationListenerTransport, Location location) {
        this.f760a = locationListenerTransport;
        this.b = location;
    }

    public final void run() {
        this.f760a.i(this.b);
    }
}
