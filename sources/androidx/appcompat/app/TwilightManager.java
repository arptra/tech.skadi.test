package androidx.appcompat.app;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.util.Log;
import androidx.core.content.PermissionChecker;
import java.util.Calendar;
import org.apache.commons.lang3.time.DateUtils;

class TwilightManager {
    public static TwilightManager d;

    /* renamed from: a  reason: collision with root package name */
    public final Context f190a;
    public final LocationManager b;
    public final TwilightState c = new TwilightState();

    public static class TwilightState {

        /* renamed from: a  reason: collision with root package name */
        public boolean f191a;
        public long b;
    }

    public TwilightManager(Context context, LocationManager locationManager) {
        this.f190a = context;
        this.b = locationManager;
    }

    public static TwilightManager a(Context context) {
        if (d == null) {
            Context applicationContext = context.getApplicationContext();
            d = new TwilightManager(applicationContext, (LocationManager) applicationContext.getSystemService("location"));
        }
        return d;
    }

    public final Location b() {
        Location location = null;
        Location c2 = PermissionChecker.c(this.f190a, "android.permission.ACCESS_COARSE_LOCATION") == 0 ? c("network") : null;
        if (PermissionChecker.c(this.f190a, "android.permission.ACCESS_FINE_LOCATION") == 0) {
            location = c("gps");
        }
        return (location == null || c2 == null) ? location != null ? location : c2 : location.getTime() > c2.getTime() ? location : c2;
    }

    public final Location c(String str) {
        try {
            if (this.b.isProviderEnabled(str)) {
                return this.b.getLastKnownLocation(str);
            }
            return null;
        } catch (Exception e) {
            Log.d("TwilightManager", "Failed to get last known location", e);
            return null;
        }
    }

    public boolean d() {
        TwilightState twilightState = this.c;
        if (e()) {
            return twilightState.f191a;
        }
        Location b2 = b();
        if (b2 != null) {
            f(b2);
            return twilightState.f191a;
        }
        Log.i("TwilightManager", "Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values.");
        int i = Calendar.getInstance().get(11);
        return i < 6 || i >= 22;
    }

    public final boolean e() {
        return this.c.b > System.currentTimeMillis();
    }

    public final void f(Location location) {
        long j;
        TwilightState twilightState = this.c;
        long currentTimeMillis = System.currentTimeMillis();
        TwilightCalculator b2 = TwilightCalculator.b();
        TwilightCalculator twilightCalculator = b2;
        twilightCalculator.a(currentTimeMillis - DateUtils.MILLIS_PER_DAY, location.getLatitude(), location.getLongitude());
        twilightCalculator.a(currentTimeMillis, location.getLatitude(), location.getLongitude());
        boolean z = true;
        if (b2.c != 1) {
            z = false;
        }
        boolean z2 = z;
        long j2 = b2.b;
        long j3 = b2.f189a;
        b2.a(currentTimeMillis + DateUtils.MILLIS_PER_DAY, location.getLatitude(), location.getLongitude());
        long j4 = b2.b;
        if (j2 == -1 || j3 == -1) {
            j = currentTimeMillis + 43200000;
        } else {
            if (currentTimeMillis > j3) {
                j2 = j4;
            } else if (currentTimeMillis > j2) {
                j2 = j3;
            }
            j = j2 + 60000;
        }
        twilightState.f191a = z2;
        twilightState.b = j;
    }
}
