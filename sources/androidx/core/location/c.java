package androidx.core.location;

import androidx.core.location.LocationManagerCompat;
import java.util.concurrent.Executor;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LocationManagerCompat.GnssMeasurementsTransport f752a;
    public final /* synthetic */ Executor b;
    public final /* synthetic */ int c;

    public /* synthetic */ c(LocationManagerCompat.GnssMeasurementsTransport gnssMeasurementsTransport, Executor executor, int i) {
        this.f752a = gnssMeasurementsTransport;
        this.b = executor;
        this.c = i;
    }

    public final void run() {
        this.f752a.d(this.b, this.c);
    }
}
