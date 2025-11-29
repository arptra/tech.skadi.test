package androidx.core.location;

import androidx.core.location.LocationManagerCompat;
import java.util.concurrent.Executor;

public final /* synthetic */ class n implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LocationManagerCompat.PreRGnssStatusTransport f763a;
    public final /* synthetic */ Executor b;
    public final /* synthetic */ int c;

    public /* synthetic */ n(LocationManagerCompat.PreRGnssStatusTransport preRGnssStatusTransport, Executor executor, int i) {
        this.f763a = preRGnssStatusTransport;
        this.b = executor;
        this.c = i;
    }

    public final void run() {
        this.f763a.e(this.b, this.c);
    }
}
