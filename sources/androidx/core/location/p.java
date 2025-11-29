package androidx.core.location;

import androidx.core.location.LocationManagerCompat;
import java.util.concurrent.Executor;

public final /* synthetic */ class p implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LocationManagerCompat.PreRGnssStatusTransport f765a;
    public final /* synthetic */ Executor b;

    public /* synthetic */ p(LocationManagerCompat.PreRGnssStatusTransport preRGnssStatusTransport, Executor executor) {
        this.f765a = preRGnssStatusTransport;
        this.b = executor;
    }

    public final void run() {
        this.f765a.h(this.b);
    }
}
