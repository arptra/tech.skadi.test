package androidx.core.location;

import androidx.core.location.LocationManagerCompat;
import java.util.concurrent.Executor;

public final /* synthetic */ class g implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LocationManagerCompat.GpsStatusTransport f756a;
    public final /* synthetic */ Executor b;
    public final /* synthetic */ GnssStatusCompat c;

    public /* synthetic */ g(LocationManagerCompat.GpsStatusTransport gpsStatusTransport, Executor executor, GnssStatusCompat gnssStatusCompat) {
        this.f756a = gpsStatusTransport;
        this.b = executor;
        this.c = gnssStatusCompat;
    }

    public final void run() {
        this.f756a.h(this.b, this.c);
    }
}
