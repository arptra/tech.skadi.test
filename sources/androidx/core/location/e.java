package androidx.core.location;

import androidx.core.location.LocationManagerCompat;
import java.util.concurrent.Executor;

public final /* synthetic */ class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LocationManagerCompat.GpsStatusTransport f754a;
    public final /* synthetic */ Executor b;

    public /* synthetic */ e(LocationManagerCompat.GpsStatusTransport gpsStatusTransport, Executor executor) {
        this.f754a = gpsStatusTransport;
        this.b = executor;
    }

    public final void run() {
        this.f754a.f(this.b);
    }
}
