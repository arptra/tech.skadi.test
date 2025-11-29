package androidx.core.location;

import android.annotation.SuppressLint;
import android.location.GnssMeasurementsEvent;
import android.location.GnssStatus;
import android.location.GpsStatus;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationRequest;
import android.os.Build;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RequiresPermission;
import androidx.collection.SimpleArrayMap;
import androidx.core.location.GnssStatusCompat;
import androidx.core.util.Consumer;
import androidx.core.util.ObjectsCompat;
import androidx.core.util.Preconditions;
import com.honey.account.n.a;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Objects;
import java.util.WeakHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

public final class LocationManagerCompat {

    /* renamed from: a  reason: collision with root package name */
    public static final WeakHashMap f736a = new WeakHashMap();

    public static class Api19Impl {

        /* renamed from: a  reason: collision with root package name */
        public static Class f737a;
        public static Method b;

        @DoNotInline
        @SuppressLint({"BanUncheckedReflection"})
        public static boolean a(LocationManager locationManager, String str, LocationRequestCompat locationRequestCompat, LocationListenerCompat locationListenerCompat, Looper looper) {
            try {
                if (f737a == null) {
                    f737a = Class.forName("android.location.LocationRequest");
                }
                if (b == null) {
                    Method declaredMethod = LocationManager.class.getDeclaredMethod("requestLocationUpdates", new Class[]{f737a, LocationListener.class, Looper.class});
                    b = declaredMethod;
                    declaredMethod.setAccessible(true);
                }
                LocationRequest i = locationRequestCompat.i(str);
                if (i == null) {
                    return false;
                }
                b.invoke(locationManager, new Object[]{i, locationListenerCompat, looper});
                return true;
            } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | UnsupportedOperationException | InvocationTargetException unused) {
                return false;
            }
        }

        @RequiresPermission
        @DoNotInline
        @SuppressLint({"BanUncheckedReflection"})
        public static boolean b(LocationManager locationManager, String str, LocationRequestCompat locationRequestCompat, LocationListenerTransport locationListenerTransport) {
            try {
                if (f737a == null) {
                    f737a = Class.forName("android.location.LocationRequest");
                }
                if (b == null) {
                    Method declaredMethod = LocationManager.class.getDeclaredMethod("requestLocationUpdates", new Class[]{f737a, LocationListener.class, Looper.class});
                    b = declaredMethod;
                    declaredMethod.setAccessible(true);
                }
                LocationRequest i = locationRequestCompat.i(str);
                if (i == null) {
                    return false;
                }
                synchronized (LocationManagerCompat.f736a) {
                    b.invoke(locationManager, new Object[]{i, locationListenerTransport, Looper.getMainLooper()});
                    LocationManagerCompat.a(locationManager, locationListenerTransport);
                }
                return true;
            } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | UnsupportedOperationException | InvocationTargetException unused) {
                return false;
            }
        }
    }

    @RequiresApi
    public static class Api24Impl {
        @RequiresPermission
        @DoNotInline
        public static boolean a(@NonNull LocationManager locationManager, @NonNull GnssMeasurementsEvent.Callback callback) {
            return locationManager.registerGnssMeasurementsCallback(callback);
        }

        @RequiresPermission
        @DoNotInline
        public static boolean b(@NonNull LocationManager locationManager, @NonNull GnssMeasurementsEvent.Callback callback, @NonNull Handler handler) {
            return locationManager.registerGnssMeasurementsCallback(callback, handler);
        }

        @RequiresPermission
        @DoNotInline
        public static boolean c(LocationManager locationManager, Handler handler, Executor executor, GnssStatusCompat.Callback callback) {
            Preconditions.a(handler != null);
            SimpleArrayMap simpleArrayMap = GnssListenersHolder.f740a;
            synchronized (simpleArrayMap) {
                try {
                    PreRGnssStatusTransport preRGnssStatusTransport = (PreRGnssStatusTransport) simpleArrayMap.get(callback);
                    if (preRGnssStatusTransport == null) {
                        preRGnssStatusTransport = new PreRGnssStatusTransport(callback);
                    } else {
                        preRGnssStatusTransport.j();
                    }
                    preRGnssStatusTransport.i(executor);
                    if (!locationManager.registerGnssStatusCallback(preRGnssStatusTransport, handler)) {
                        return false;
                    }
                    simpleArrayMap.put(callback, preRGnssStatusTransport);
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @DoNotInline
        public static void d(@NonNull LocationManager locationManager, @NonNull GnssMeasurementsEvent.Callback callback) {
            locationManager.unregisterGnssMeasurementsCallback(callback);
        }

        @DoNotInline
        public static void e(LocationManager locationManager, Object obj) {
            if (obj instanceof PreRGnssStatusTransport) {
                ((PreRGnssStatusTransport) obj).j();
            }
            locationManager.unregisterGnssStatusCallback((GnssStatus.Callback) obj);
        }
    }

    @RequiresApi
    public static class Api28Impl {
        @DoNotInline
        public static String a(LocationManager locationManager) {
            return locationManager.getGnssHardwareModelName();
        }

        @DoNotInline
        public static int b(LocationManager locationManager) {
            return locationManager.getGnssYearOfHardware();
        }

        @DoNotInline
        public static boolean c(LocationManager locationManager) {
            return locationManager.isLocationEnabled();
        }
    }

    @RequiresApi
    public static class Api30Impl {

        /* renamed from: a  reason: collision with root package name */
        public static Class f738a;
        public static Method b;

        @RequiresPermission
        @DoNotInline
        public static void a(LocationManager locationManager, @NonNull String str, @Nullable CancellationSignal cancellationSignal, @NonNull Executor executor, @NonNull Consumer<Location> consumer) {
            Objects.requireNonNull(consumer);
            locationManager.getCurrentLocation(str, cancellationSignal, executor, new a(consumer));
        }

        @RequiresPermission
        @DoNotInline
        public static boolean b(LocationManager locationManager, Handler handler, Executor executor, GnssStatusCompat.Callback callback) {
            SimpleArrayMap simpleArrayMap = GnssListenersHolder.f740a;
            synchronized (simpleArrayMap) {
                try {
                    GnssStatusTransport gnssStatusTransport = (GnssStatusTransport) simpleArrayMap.get(callback);
                    if (gnssStatusTransport == null) {
                        gnssStatusTransport = new GnssStatusTransport(callback);
                    }
                    if (!locationManager.registerGnssStatusCallback(executor, gnssStatusTransport)) {
                        return false;
                    }
                    simpleArrayMap.put(callback, gnssStatusTransport);
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @DoNotInline
        public static boolean c(LocationManager locationManager, String str, LocationRequestCompat locationRequestCompat, Executor executor, LocationListenerCompat locationListenerCompat) {
            if (Build.VERSION.SDK_INT < 30) {
                return false;
            }
            try {
                if (f738a == null) {
                    f738a = Class.forName("android.location.LocationRequest");
                }
                if (b == null) {
                    Method declaredMethod = LocationManager.class.getDeclaredMethod("requestLocationUpdates", new Class[]{f738a, Executor.class, LocationListener.class});
                    b = declaredMethod;
                    declaredMethod.setAccessible(true);
                }
                LocationRequest i = locationRequestCompat.i(str);
                if (i == null) {
                    return false;
                }
                b.invoke(locationManager, new Object[]{i, executor, locationListenerCompat});
                return true;
            } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | UnsupportedOperationException | InvocationTargetException unused) {
                return false;
            }
        }
    }

    @RequiresApi
    public static class Api31Impl {
        @DoNotInline
        public static boolean a(LocationManager locationManager, @NonNull String str) {
            return locationManager.hasProvider(str);
        }

        @RequiresPermission
        @DoNotInline
        public static boolean b(@NonNull LocationManager locationManager, @NonNull Executor executor, @NonNull GnssMeasurementsEvent.Callback callback) {
            return locationManager.registerGnssMeasurementsCallback(executor, callback);
        }

        @RequiresPermission
        @DoNotInline
        public static void c(LocationManager locationManager, @NonNull String str, @NonNull LocationRequest locationRequest, @NonNull Executor executor, @NonNull LocationListener locationListener) {
            locationManager.requestLocationUpdates(str, locationRequest, executor, locationListener);
        }
    }

    public static final class CancellableLocationListener implements LocationListener {

        /* renamed from: a  reason: collision with root package name */
        public final LocationManager f739a;
        public final Executor b;
        public final Handler c;
        public Consumer d;
        public boolean e;
        public Runnable f;

        public final void b() {
            this.d = null;
            this.f739a.removeUpdates(this);
            Runnable runnable = this.f;
            if (runnable != null) {
                this.c.removeCallbacks(runnable);
                this.f = null;
            }
        }

        public void onLocationChanged(Location location) {
            synchronized (this) {
                try {
                    if (!this.e) {
                        this.e = true;
                        this.b.execute(new a(this.d, location));
                        b();
                    }
                } catch (Throwable th) {
                    while (true) {
                        throw th;
                    }
                }
            }
        }

        public void onProviderDisabled(String str) {
            onLocationChanged((Location) null);
        }

        public void onProviderEnabled(String str) {
        }

        public void onStatusChanged(String str, int i, Bundle bundle) {
        }
    }

    public static class GnssListenersHolder {

        /* renamed from: a  reason: collision with root package name */
        public static final SimpleArrayMap f740a = new SimpleArrayMap();
        public static final SimpleArrayMap b = new SimpleArrayMap();
    }

    @RequiresApi
    public static class GnssMeasurementsTransport extends GnssMeasurementsEvent.Callback {

        /* renamed from: a  reason: collision with root package name */
        public final GnssMeasurementsEvent.Callback f741a;
        public volatile Executor b;

        public final /* synthetic */ void c(Executor executor, GnssMeasurementsEvent gnssMeasurementsEvent) {
            if (this.b == executor) {
                this.f741a.onGnssMeasurementsReceived(gnssMeasurementsEvent);
            }
        }

        public final /* synthetic */ void d(Executor executor, int i) {
            if (this.b == executor) {
                this.f741a.onStatusChanged(i);
            }
        }

        public void onGnssMeasurementsReceived(GnssMeasurementsEvent gnssMeasurementsEvent) {
            Executor executor = this.b;
            if (executor != null) {
                executor.execute(new b(this, executor, gnssMeasurementsEvent));
            }
        }

        public void onStatusChanged(int i) {
            Executor executor = this.b;
            if (executor != null) {
                executor.execute(new c(this, executor, i));
            }
        }
    }

    @RequiresApi
    public static class GnssStatusTransport extends GnssStatus.Callback {

        /* renamed from: a  reason: collision with root package name */
        public final GnssStatusCompat.Callback f742a;

        public GnssStatusTransport(GnssStatusCompat.Callback callback) {
            Preconditions.b(callback != null, "invalid null callback");
            this.f742a = callback;
        }

        public void onFirstFix(int i) {
            this.f742a.a(i);
        }

        public void onSatelliteStatusChanged(GnssStatus gnssStatus) {
            this.f742a.b(GnssStatusCompat.a(gnssStatus));
        }

        public void onStarted() {
            this.f742a.c();
        }

        public void onStopped() {
            this.f742a.d();
        }
    }

    public static class GpsStatusTransport implements GpsStatus.Listener {

        /* renamed from: a  reason: collision with root package name */
        public final LocationManager f743a;
        public final GnssStatusCompat.Callback b;
        public volatile Executor c;

        public final /* synthetic */ void e(Executor executor) {
            if (this.c == executor) {
                this.b.c();
            }
        }

        public final /* synthetic */ void f(Executor executor) {
            if (this.c == executor) {
                this.b.d();
            }
        }

        public final /* synthetic */ void g(Executor executor, int i) {
            if (this.c == executor) {
                this.b.a(i);
            }
        }

        public final /* synthetic */ void h(Executor executor, GnssStatusCompat gnssStatusCompat) {
            if (this.c == executor) {
                this.b.b(gnssStatusCompat);
            }
        }

        public void onGpsStatusChanged(int i) {
            GpsStatus gpsStatus;
            Executor executor = this.c;
            if (executor != null) {
                if (i == 1) {
                    executor.execute(new d(this, executor));
                } else if (i == 2) {
                    executor.execute(new e(this, executor));
                } else if (i == 3) {
                    GpsStatus gpsStatus2 = this.f743a.getGpsStatus((GpsStatus) null);
                    if (gpsStatus2 != null) {
                        executor.execute(new f(this, executor, gpsStatus2.getTimeToFirstFix()));
                    }
                } else if (i == 4 && (gpsStatus = this.f743a.getGpsStatus((GpsStatus) null)) != null) {
                    executor.execute(new g(this, executor, GnssStatusCompat.b(gpsStatus)));
                }
            }
        }
    }

    public static final class InlineHandlerExecutor implements Executor {

        /* renamed from: a  reason: collision with root package name */
        public final Handler f744a;

        public void execute(Runnable runnable) {
            if (Looper.myLooper() == this.f744a.getLooper()) {
                runnable.run();
            } else if (!this.f744a.post((Runnable) Preconditions.h(runnable))) {
                throw new RejectedExecutionException(this.f744a + " is shutting down");
            }
        }
    }

    public static class LocationListenerKey {

        /* renamed from: a  reason: collision with root package name */
        public final String f745a;
        public final LocationListenerCompat b;

        public boolean equals(Object obj) {
            if (!(obj instanceof LocationListenerKey)) {
                return false;
            }
            LocationListenerKey locationListenerKey = (LocationListenerKey) obj;
            return this.f745a.equals(locationListenerKey.f745a) && this.b.equals(locationListenerKey.b);
        }

        public int hashCode() {
            return ObjectsCompat.b(this.f745a, this.b);
        }
    }

    @RequiresApi
    public static class PreRGnssStatusTransport extends GnssStatus.Callback {

        /* renamed from: a  reason: collision with root package name */
        public final GnssStatusCompat.Callback f747a;
        public volatile Executor b;

        public PreRGnssStatusTransport(GnssStatusCompat.Callback callback) {
            Preconditions.b(callback != null, "invalid null callback");
            this.f747a = callback;
        }

        public final /* synthetic */ void e(Executor executor, int i) {
            if (this.b == executor) {
                this.f747a.a(i);
            }
        }

        public final /* synthetic */ void f(Executor executor, GnssStatus gnssStatus) {
            if (this.b == executor) {
                this.f747a.b(GnssStatusCompat.a(gnssStatus));
            }
        }

        public final /* synthetic */ void g(Executor executor) {
            if (this.b == executor) {
                this.f747a.c();
            }
        }

        public final /* synthetic */ void h(Executor executor) {
            if (this.b == executor) {
                this.f747a.d();
            }
        }

        public void i(Executor executor) {
            boolean z = false;
            Preconditions.b(executor != null, "invalid null executor");
            if (this.b == null) {
                z = true;
            }
            Preconditions.j(z);
            this.b = executor;
        }

        public void j() {
            this.b = null;
        }

        public void onFirstFix(int i) {
            Executor executor = this.b;
            if (executor != null) {
                executor.execute(new n(this, executor, i));
            }
        }

        public void onSatelliteStatusChanged(GnssStatus gnssStatus) {
            Executor executor = this.b;
            if (executor != null) {
                executor.execute(new o(this, executor, gnssStatus));
            }
        }

        public void onStarted() {
            Executor executor = this.b;
            if (executor != null) {
                executor.execute(new q(this, executor));
            }
        }

        public void onStopped() {
            Executor executor = this.b;
            if (executor != null) {
                executor.execute(new p(this, executor));
            }
        }
    }

    public static void a(LocationManager locationManager, LocationListenerTransport locationListenerTransport) {
        WeakReference weakReference = (WeakReference) f736a.put(locationListenerTransport.g(), new WeakReference(locationListenerTransport));
        LocationListenerTransport locationListenerTransport2 = weakReference != null ? (LocationListenerTransport) weakReference.get() : null;
        if (locationListenerTransport2 != null) {
            locationListenerTransport2.n();
            locationManager.removeUpdates(locationListenerTransport2);
        }
    }

    public static class LocationListenerTransport implements LocationListener {

        /* renamed from: a  reason: collision with root package name */
        public volatile LocationListenerKey f746a;
        public final Executor b;

        public LocationListenerKey g() {
            return (LocationListenerKey) ObjectsCompat.c(this.f746a);
        }

        public final /* synthetic */ void h(int i) {
            LocationListenerKey locationListenerKey = this.f746a;
            if (locationListenerKey != null) {
                locationListenerKey.b.onFlushComplete(i);
            }
        }

        public final /* synthetic */ void i(Location location) {
            LocationListenerKey locationListenerKey = this.f746a;
            if (locationListenerKey != null) {
                locationListenerKey.b.onLocationChanged(location);
            }
        }

        public final /* synthetic */ void j(List list) {
            LocationListenerKey locationListenerKey = this.f746a;
            if (locationListenerKey != null) {
                locationListenerKey.b.onLocationChanged(list);
            }
        }

        public final /* synthetic */ void k(String str) {
            LocationListenerKey locationListenerKey = this.f746a;
            if (locationListenerKey != null) {
                locationListenerKey.b.onProviderDisabled(str);
            }
        }

        public final /* synthetic */ void l(String str) {
            LocationListenerKey locationListenerKey = this.f746a;
            if (locationListenerKey != null) {
                locationListenerKey.b.onProviderEnabled(str);
            }
        }

        public final /* synthetic */ void m(String str, int i, Bundle bundle) {
            LocationListenerKey locationListenerKey = this.f746a;
            if (locationListenerKey != null) {
                locationListenerKey.b.onStatusChanged(str, i, bundle);
            }
        }

        public void n() {
            this.f746a = null;
        }

        public void onFlushComplete(int i) {
            if (this.f746a != null) {
                this.b.execute(new l(this, i));
            }
        }

        public void onLocationChanged(Location location) {
            if (this.f746a != null) {
                this.b.execute(new k(this, location));
            }
        }

        public void onProviderDisabled(String str) {
            if (this.f746a != null) {
                this.b.execute(new i(this, str));
            }
        }

        public void onProviderEnabled(String str) {
            if (this.f746a != null) {
                this.b.execute(new h(this, str));
            }
        }

        public void onStatusChanged(String str, int i, Bundle bundle) {
            if (this.f746a != null) {
                this.b.execute(new m(this, str, i, bundle));
            }
        }

        public void onLocationChanged(List list) {
            if (this.f746a != null) {
                this.b.execute(new j(this, list));
            }
        }
    }
}
