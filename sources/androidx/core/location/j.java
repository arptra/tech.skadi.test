package androidx.core.location;

import androidx.core.location.LocationManagerCompat;
import java.util.List;

public final /* synthetic */ class j implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LocationManagerCompat.LocationListenerTransport f759a;
    public final /* synthetic */ List b;

    public /* synthetic */ j(LocationManagerCompat.LocationListenerTransport locationListenerTransport, List list) {
        this.f759a = locationListenerTransport;
        this.b = list;
    }

    public final void run() {
        this.f759a.j(this.b);
    }
}
