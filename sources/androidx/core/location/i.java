package androidx.core.location;

import androidx.core.location.LocationManagerCompat;

public final /* synthetic */ class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LocationManagerCompat.LocationListenerTransport f758a;
    public final /* synthetic */ String b;

    public /* synthetic */ i(LocationManagerCompat.LocationListenerTransport locationListenerTransport, String str) {
        this.f758a = locationListenerTransport;
        this.b = str;
    }

    public final void run() {
        this.f758a.k(this.b);
    }
}
