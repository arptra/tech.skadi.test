package androidx.core.location;

import androidx.core.location.LocationManagerCompat;

public final /* synthetic */ class l implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LocationManagerCompat.LocationListenerTransport f761a;
    public final /* synthetic */ int b;

    public /* synthetic */ l(LocationManagerCompat.LocationListenerTransport locationListenerTransport, int i) {
        this.f761a = locationListenerTransport;
        this.b = i;
    }

    public final void run() {
        this.f761a.h(this.b);
    }
}
