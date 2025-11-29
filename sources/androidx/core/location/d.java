package androidx.core.location;

import androidx.core.location.LocationManagerCompat;
import java.util.concurrent.Executor;

public final /* synthetic */ class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LocationManagerCompat.GpsStatusTransport f753a;
    public final /* synthetic */ Executor b;

    public /* synthetic */ d(LocationManagerCompat.GpsStatusTransport gpsStatusTransport, Executor executor) {
        this.f753a = gpsStatusTransport;
        this.b = executor;
    }

    public final void run() {
        this.f753a.e(this.b);
    }
}
