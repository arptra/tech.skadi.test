package androidx.core.location;

import androidx.core.location.LocationManagerCompat;
import java.util.concurrent.Executor;

public final /* synthetic */ class q implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LocationManagerCompat.PreRGnssStatusTransport f766a;
    public final /* synthetic */ Executor b;

    public /* synthetic */ q(LocationManagerCompat.PreRGnssStatusTransport preRGnssStatusTransport, Executor executor) {
        this.f766a = preRGnssStatusTransport;
        this.b = executor;
    }

    public final void run() {
        this.f766a.g(this.b);
    }
}
