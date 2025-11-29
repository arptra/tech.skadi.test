package androidx.core.location;

import android.location.GnssStatus;
import androidx.core.location.LocationManagerCompat;
import java.util.concurrent.Executor;

public final /* synthetic */ class o implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LocationManagerCompat.PreRGnssStatusTransport f764a;
    public final /* synthetic */ Executor b;
    public final /* synthetic */ GnssStatus c;

    public /* synthetic */ o(LocationManagerCompat.PreRGnssStatusTransport preRGnssStatusTransport, Executor executor, GnssStatus gnssStatus) {
        this.f764a = preRGnssStatusTransport;
        this.b = executor;
        this.c = gnssStatus;
    }

    public final void run() {
        this.f764a.f(this.b, this.c);
    }
}
