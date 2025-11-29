package androidx.core.location;

import androidx.core.location.LocationManagerCompat;
import java.util.concurrent.Executor;

public final /* synthetic */ class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LocationManagerCompat.GpsStatusTransport f755a;
    public final /* synthetic */ Executor b;
    public final /* synthetic */ int c;

    public /* synthetic */ f(LocationManagerCompat.GpsStatusTransport gpsStatusTransport, Executor executor, int i) {
        this.f755a = gpsStatusTransport;
        this.b = executor;
        this.c = i;
    }

    public final void run() {
        this.f755a.g(this.b, this.c);
    }
}
