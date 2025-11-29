package androidx.core.location;

import android.location.GnssMeasurementsEvent;
import androidx.core.location.LocationManagerCompat;
import java.util.concurrent.Executor;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LocationManagerCompat.GnssMeasurementsTransport f751a;
    public final /* synthetic */ Executor b;
    public final /* synthetic */ GnssMeasurementsEvent c;

    public /* synthetic */ b(LocationManagerCompat.GnssMeasurementsTransport gnssMeasurementsTransport, Executor executor, GnssMeasurementsEvent gnssMeasurementsEvent) {
        this.f751a = gnssMeasurementsTransport;
        this.b = executor;
        this.c = gnssMeasurementsEvent;
    }

    public final void run() {
        this.f751a.c(this.b, this.c);
    }
}
