package com.upuphone.ar.navi.lite.location;

import android.app.Notification;
import android.content.Context;
import com.here.sdk.core.GeoCoordinates;
import com.here.sdk.core.Location;
import com.here.sdk.core.LocationListener;
import com.here.sdk.location.LocationAccuracy;
import com.here.sdk.location.LocationEngine;
import com.here.sdk.location.LocationEngineStatus;
import com.here.sdk.location.LocationOptions;
import com.here.sdk.location.LocationStatusListener;
import com.here.sdk.location.NotificationOptions;
import com.here.sdk.navigation.VisualNavigator;
import com.upuphone.ar.navi.lite.base.PlaceBean;
import com.upuphone.ar.navi.lite.base.ULatLng;
import com.upuphone.ar.navi.lite.base.ULocation;
import com.upuphone.ar.navi.lite.manger.NaviOperatorManager;
import com.upuphone.ar.navi.lite.model.ILocation;
import com.upuphone.ar.navi.lite.model.ILocationManager;
import com.upuphone.ar.navi.lite.model.IPlace;
import com.upuphone.ar.navi.lite.navi.HereNaviManager;
import com.upuphone.ar.navi.lite.offlinemap.OfflineMapManager;
import com.upuphone.ar.navi.lite.search.PoiSearchManager;
import com.upuphone.ar.navi.lite.util.CLog;
import com.upuphone.ar.navi.lite.util.NaviUtil;
import java.util.List;

public class HereLocation extends AbsLocation implements LocationStatusListener, LocationListener, IPlace {
    public static final String p = ("NAVI-" + HereLocation.class.getSimpleName());
    public static volatile HereLocation q = null;
    public LocationEngine m;
    public LocationListener n;
    public ULatLng o = null;

    public static HereLocation v() {
        if (q == null) {
            synchronized (HereLocation.class) {
                try {
                    if (q == null) {
                        q = new HereLocation();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return q;
    }

    public void a(List list) {
        if (list != null && list.size() != 0) {
            PlaceBean placeBean = (PlaceBean) list.get(0);
            this.c = placeBean;
            NaviUtil.m1(this.f5775a, placeBean.getCountryCode());
            NaviOperatorManager.getInstance(this.f5775a).operatorLocationChanged(placeBean);
            List c = ILocationManager.b().c();
            for (int i = 0; i < c.size(); i++) {
                ((ILocation) c.get(i)).q(this.b, placeBean);
            }
            ILocation locationListener = NaviOperatorManager.getInstance(this.f5775a).getLocationListener();
            if (locationListener != null) {
                locationListener.q(this.b, placeBean);
            }
            NaviOperatorManager.getInstance(this.f5775a).onLocationInfoChange(placeBean);
            list.clear();
            if (OfflineMapManager.b().g()) {
                OfflineMapManager.b().a();
            }
        }
    }

    public void b() {
        this.m.removeLocationListener(this.n);
        VisualNavigator J0 = HereNaviManager.v0().J0();
        this.n = J0;
        this.m.addLocationListener(J0);
    }

    public void c(boolean z) {
        String str = p;
        CLog.b(str, "[disableBackgroundLocation]: disable=" + z + " notification=" + this.i + " backgroundLocation=" + this.j);
    }

    public void d(int i, Notification notification) {
        String str = p;
        CLog.b(str, "[enableBackgroundLocation]: notificationId=" + i + " notification=" + notification);
        this.h = i;
        this.i = notification;
        y();
    }

    public String e() {
        PlaceBean i = i();
        return i != null ? i.getAddress() : "";
    }

    public String f(Context context) {
        return "";
    }

    public ULocation g() {
        Location lastKnownLocation;
        ULocation uLocation = this.b;
        if (uLocation != null) {
            return uLocation;
        }
        LocationEngine locationEngine = this.m;
        if (locationEngine == null || (lastKnownLocation = locationEngine.getLastKnownLocation()) == null) {
            return null;
        }
        return w(lastKnownLocation);
    }

    public PlaceBean i() {
        return this.c;
    }

    public void j(Context context, boolean z) {
        Context applicationContext = context.getApplicationContext();
        this.f5775a = applicationContext;
        this.n = this;
        x(applicationContext, z);
    }

    public boolean k() {
        return this.d;
    }

    public boolean l() {
        return this.e;
    }

    public void m() {
        this.m.removeLocationListener(this.n);
        this.n = this;
        this.m.addLocationListener(this);
    }

    public void n(ULocation uLocation) {
        if (uLocation != null) {
            String str = p;
            CLog.b(str, "[setLocation]: enter. location=" + uLocation.toString());
            this.b = uLocation;
            PoiSearchManager.f().c(this.f5775a, new ULatLng(uLocation.getLatitude(), uLocation.getLongitude()), this);
        }
    }

    public void onFeaturesNotAvailable(List list) {
    }

    public void onLocationUpdated(Location location) {
        s(location);
    }

    public void onStatusChanged(LocationEngineStatus locationEngineStatus) {
    }

    public void p() {
        String str = p;
        CLog.b(str, "[startLocation]: enter. locationEngine=" + this.m);
        LocationEngine locationEngine = this.m;
        if (locationEngine != null) {
            locationEngine.addLocationStatusListener(this);
            this.m.addLocationListener(this.n);
            this.m.start(LocationAccuracy.NAVIGATION);
            this.e = true;
        }
        t();
        CLog.b(str, "[startLocation]: end.");
    }

    public void q() {
        String str = p;
        CLog.b(str, "[startOnceLocation]: enter. locationEngine=" + this.m);
        LocationEngine locationEngine = this.m;
        if (locationEngine != null) {
            locationEngine.addLocationStatusListener(this);
            this.m.addLocationListener(this.n);
            LocationEngine locationEngine2 = this.m;
            LocationAccuracy locationAccuracy = LocationAccuracy.NAVIGATION;
            locationEngine2.start(locationAccuracy);
            this.m.start(u(locationAccuracy, true));
            this.e = true;
        }
        t();
        CLog.b(str, "[startOnceLocation]: end.");
    }

    public void r() {
        int size = NaviOperatorManager.getInstance(this.f5775a).getNaviLocationCallbacks().size();
        ILocation locationListener = NaviOperatorManager.getInstance(this.f5775a).getLocationListener();
        String str = p;
        CLog.b(str, "[stopLocation]: callbacksSize =" + size + " started=" + this.e + " isIsNaviOpened=" + NaviUtil.t0() + " isNaviStarted=" + NaviUtil.B0() + " locationEngine=" + this.m);
        if (!NaviUtil.t0() && !NaviUtil.B0()) {
            if ((size <= 0 || !this.e) && locationListener == null) {
                c(true);
                LocationEngine locationEngine = this.m;
                if (locationEngine != null) {
                    locationEngine.removeLocationStatusListener(this);
                    this.m.removeLocationListener(this.n);
                    this.m.stop();
                    this.e = false;
                }
            }
        }
    }

    public final void s(Location location) {
        if (location != null) {
            this.b = w(location);
            PoiSearchManager f = PoiSearchManager.f();
            Context context = this.f5775a;
            GeoCoordinates geoCoordinates = location.coordinates;
            f.c(context, new ULatLng(geoCoordinates.latitude, geoCoordinates.longitude), this);
            return;
        }
        NaviOperatorManager.getInstance(this.f5775a).operatorLocationChanged((PlaceBean) null);
    }

    public void t() {
        if (this.c != null) {
            NaviOperatorManager.getInstance(this.f5775a).operatorLocationChanged(this.c);
        }
    }

    public final LocationOptions u(LocationAccuracy locationAccuracy, boolean z) {
        LocationOptions locationOptions = new LocationOptions(locationAccuracy);
        locationOptions.wifiPositioningOptions.enabled = true;
        locationOptions.satellitePositioningOptions.enabled = true;
        locationOptions.cellularPositioningOptions.enabled = true;
        long j = z ? 5000 : 1000;
        NotificationOptions notificationOptions = locationOptions.notificationOptions;
        notificationOptions.desiredIntervalMilliseconds = j;
        notificationOptions.smallestIntervalMilliseconds = j;
        return locationOptions;
    }

    public ULocation w(Location location) {
        ULocation uLocation = new ULocation();
        Double d = location.horizontalAccuracyInMeters;
        double d2 = 0.0d;
        uLocation.setAccuracy(d != null ? d.doubleValue() : 0.0d);
        Double d3 = location.coordinates.altitude;
        uLocation.setAltitude(d3 != null ? d3.doubleValue() : 0.0d);
        uLocation.setLatitude(location.coordinates.latitude);
        uLocation.setLongitude(location.coordinates.longitude);
        Double d4 = location.bearingInDegrees;
        if (d4 != null) {
            d2 = d4.doubleValue();
        }
        uLocation.setBearing(d2);
        return uLocation;
    }

    public final synchronized void x(Context context, boolean z) {
        try {
            String str = p;
            CLog.b(str, "initLocation Enter! inited=" + this.d + " context=" + context);
            if (!this.d) {
                this.d = true;
                if (this.m == null) {
                    this.m = new LocationEngine();
                }
                if (z) {
                    q();
                } else {
                    p();
                }
                CLog.b(str, "initLocation End!");
            }
        } catch (Exception e) {
            this.d = false;
            String str2 = p;
            CLog.b(str2, "location excep:" + e);
        } catch (Throwable th) {
            throw th;
        }
    }

    public void y() {
        String str = p;
        CLog.b(str, "[setEnableBackgroundLocation]: backgroundLocation=" + this.j + " notificationId=" + this.h + " notification=" + this.i + " isAppForeground=" + NaviUtil.l0());
    }
}
