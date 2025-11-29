package androidx.core.location;

import android.location.GnssStatus;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.util.Preconditions;

@RequiresApi
@RestrictTo
class GnssStatusWrapper extends GnssStatusCompat {

    /* renamed from: a  reason: collision with root package name */
    public final GnssStatus f733a;

    @RequiresApi
    public static class Api26Impl {
        @DoNotInline
        public static float a(GnssStatus gnssStatus, int i) {
            return gnssStatus.getCarrierFrequencyHz(i);
        }

        @DoNotInline
        public static boolean b(GnssStatus gnssStatus, int i) {
            return gnssStatus.hasCarrierFrequencyHz(i);
        }
    }

    @RequiresApi
    public static class Api30Impl {
        @DoNotInline
        public static float a(GnssStatus gnssStatus, int i) {
            return gnssStatus.getBasebandCn0DbHz(i);
        }

        @DoNotInline
        public static boolean b(GnssStatus gnssStatus, int i) {
            return gnssStatus.hasBasebandCn0DbHz(i);
        }
    }

    public GnssStatusWrapper(Object obj) {
        this.f733a = (GnssStatus) Preconditions.h((GnssStatus) obj);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GnssStatusWrapper)) {
            return false;
        }
        return this.f733a.equals(((GnssStatusWrapper) obj).f733a);
    }

    public int hashCode() {
        return this.f733a.hashCode();
    }
}
