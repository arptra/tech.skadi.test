package androidx.core.location;

import android.location.GpsSatellite;
import android.location.GpsStatus;
import androidx.annotation.RestrictTo;
import androidx.core.util.Preconditions;
import java.util.Iterator;

@RestrictTo
class GpsStatusWrapper extends GnssStatusCompat {

    /* renamed from: a  reason: collision with root package name */
    public final GpsStatus f734a;
    public int b = -1;
    public Iterator c;
    public int d;
    public GpsSatellite e;

    public GpsStatusWrapper(GpsStatus gpsStatus) {
        GpsStatus gpsStatus2 = (GpsStatus) Preconditions.h(gpsStatus);
        this.f734a = gpsStatus2;
        this.c = gpsStatus2.getSatellites().iterator();
        this.d = -1;
        this.e = null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GpsStatusWrapper)) {
            return false;
        }
        return this.f734a.equals(((GpsStatusWrapper) obj).f734a);
    }

    public int hashCode() {
        return this.f734a.hashCode();
    }
}
