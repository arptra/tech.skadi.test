package androidx.core.location;

import androidx.core.location.LocationManagerCompat;

public final /* synthetic */ class h implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LocationManagerCompat.LocationListenerTransport f757a;
    public final /* synthetic */ String b;

    public /* synthetic */ h(LocationManagerCompat.LocationListenerTransport locationListenerTransport, String str) {
        this.f757a = locationListenerTransport;
        this.b = str;
    }

    public final void run() {
        this.f757a.l(this.b);
    }
}
