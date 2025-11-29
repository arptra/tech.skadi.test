package com.upuphone.ar.navi.lite.navi;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Handler;
import android.util.Log;
import com.here.sdk.animation.AnimationState;
import com.here.sdk.animation.Easing;
import com.here.sdk.animation.EasingFunction;
import com.here.sdk.consent.Consent;
import com.here.sdk.consent.ConsentActivity;
import com.here.sdk.consent.ConsentEngine;
import com.here.sdk.core.Color;
import com.here.sdk.core.GeoCoordinates;
import com.here.sdk.core.GeoOrientationUpdate;
import com.here.sdk.core.LanguageCode;
import com.here.sdk.core.Point2D;
import com.here.sdk.core.Rectangle2D;
import com.here.sdk.core.Size2D;
import com.here.sdk.core.UnitSystem;
import com.here.sdk.core.engine.SDKNativeEngine;
import com.here.sdk.core.engine.SDKOptions;
import com.here.sdk.core.errors.InstantiationErrorException;
import com.here.sdk.core.threading.TaskHandle;
import com.here.sdk.mapview.MapCameraAnimationFactory;
import com.here.sdk.mapview.MapCameraUpdateFactory;
import com.here.sdk.mapview.MapPolyline;
import com.here.sdk.mapview.MapScene;
import com.here.sdk.mapview.MapView;
import com.here.sdk.navigation.DynamicCameraBehavior;
import com.here.sdk.navigation.JunctionViewLaneAssistance;
import com.here.sdk.navigation.Lane;
import com.here.sdk.navigation.LaneDirectionCategory;
import com.here.sdk.navigation.LaneRecommendationState;
import com.here.sdk.navigation.ManeuverNotificationOptions;
import com.here.sdk.navigation.ManeuverProgress;
import com.here.sdk.navigation.ManeuverViewLaneAssistance;
import com.here.sdk.navigation.MapMatchedLocation;
import com.here.sdk.navigation.NavigableLocation;
import com.here.sdk.navigation.RealisticViewWarning;
import com.here.sdk.navigation.RoadAttributes;
import com.here.sdk.navigation.RouteDeviation;
import com.here.sdk.navigation.RouteDeviationListener;
import com.here.sdk.navigation.RouteProgress;
import com.here.sdk.navigation.SectionProgress;
import com.here.sdk.navigation.SpeedBasedCameraBehavior;
import com.here.sdk.navigation.SpeedLimit;
import com.here.sdk.navigation.SpeedWarningStatus;
import com.here.sdk.navigation.VisualNavigator;
import com.here.sdk.prefetcher.RoutePrefetcher;
import com.here.sdk.routing.BicycleOptions;
import com.here.sdk.routing.CalculateRouteCallback;
import com.here.sdk.routing.CarOptions;
import com.here.sdk.routing.Maneuver;
import com.here.sdk.routing.ManeuverAction;
import com.here.sdk.routing.OptimizationMode;
import com.here.sdk.routing.PedestrianOptions;
import com.here.sdk.routing.RefreshRouteOptions;
import com.here.sdk.routing.RoadFeatures;
import com.here.sdk.routing.RoadTexts;
import com.here.sdk.routing.RoadType;
import com.here.sdk.routing.Route;
import com.here.sdk.routing.RouteHandle;
import com.here.sdk.routing.RouteOptions;
import com.here.sdk.routing.RoutingEngine;
import com.here.sdk.routing.RoutingError;
import com.here.sdk.routing.Section;
import com.here.sdk.routing.TrafficOptimizationMode;
import com.here.sdk.routing.Waypoint;
import com.here.sdk.trafficawarenavigation.DynamicRoutingEngine;
import com.here.sdk.trafficawarenavigation.DynamicRoutingEngineOptions;
import com.here.sdk.trafficawarenavigation.DynamicRoutingListener;
import com.here.time.Duration;
import com.honey.account.j4.a;
import com.honey.account.j4.b;
import com.honey.account.j4.c;
import com.honey.account.j4.d;
import com.honey.account.j4.e;
import com.honey.account.j4.f;
import com.honey.account.j4.g;
import com.honey.account.j4.h;
import com.honey.account.j4.i;
import com.honey.account.j4.j;
import com.honey.account.j4.k;
import com.honey.account.j4.l;
import com.honey.account.j4.m;
import com.honey.account.j4.n;
import com.honey.account.j4.o;
import com.honey.account.j4.p;
import com.honey.account.j4.q;
import com.honey.account.j4.r;
import com.honey.account.j4.s;
import com.upuphone.ar.navi.lite.R;
import com.upuphone.ar.navi.lite.base.LanguageCodeConverter;
import com.upuphone.ar.navi.lite.base.NaviLaneInfo;
import com.upuphone.ar.navi.lite.base.ULocation;
import com.upuphone.ar.navi.lite.base.UNaviPoi;
import com.upuphone.ar.navi.lite.location.HereLocation;
import com.upuphone.ar.navi.lite.location.LocationManager;
import com.upuphone.ar.navi.lite.manger.ConnectionManager;
import com.upuphone.ar.navi.lite.manger.NaviTtsManager;
import com.upuphone.ar.navi.lite.manger.StarryNetManger;
import com.upuphone.ar.navi.lite.mapview.HereMapView;
import com.upuphone.ar.navi.lite.model.INaviEvent;
import com.upuphone.ar.navi.lite.naviview.NaviView;
import com.upuphone.ar.navi.lite.offlinemap.OfflineMapManager;
import com.upuphone.ar.navi.lite.protocol.NaviInfoBean;
import com.upuphone.ar.navi.lite.protocol.ProtocolUtils;
import com.upuphone.ar.navi.lite.simulate.NaviSimulateManager;
import com.upuphone.ar.navi.lite.util.CLog;
import com.upuphone.ar.navi.lite.util.CSharedPreferences;
import com.upuphone.xr.interconnect.listener.SendMessageListener;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class HereNaviManager extends AbsNaviManager {
    public static final String P = ("NAVI-" + HereNaviManager.class.getSimpleName());
    public MapMatchedLocation A;
    public DynamicRoutingEngine B;
    public RoutePrefetcher C;
    public RoutingEngine D;
    public VisualNavigator E;
    public RoutingError F;
    public MapPolyline G = null;
    public List H;
    public List I;
    public List J = new ArrayList();
    public RouteHandle K = null;
    public Route L;
    public RoadAttributes M;
    public TaskHandle N;
    public ConsentEngine O;
    public Color o = Color.valueOf(android.graphics.Color.parseColor("#0F53FF"));
    public Color p = Color.valueOf(android.graphics.Color.parseColor("#0019F7"));
    public Color q = Color.valueOf(android.graphics.Color.parseColor("#8BACFF"));
    public Color r = Color.valueOf(android.graphics.Color.parseColor("#758FEB"));
    public Color s = Color.valueOf(android.graphics.Color.parseColor("#1FAD36"));
    public Color t = Color.valueOf(android.graphics.Color.parseColor("#088238"));
    public Color u = Color.valueOf(android.graphics.Color.parseColor("#94D09D"));
    public Color v = Color.valueOf(android.graphics.Color.parseColor("#72B38C"));
    public Color w = Color.valueOf(android.graphics.Color.parseColor("#1FAD36"));
    public Color x = Color.valueOf(android.graphics.Color.parseColor("#088238"));
    public Color y = Color.valueOf(android.graphics.Color.parseColor("#94D09D"));
    public Color z = Color.valueOf(android.graphics.Color.parseColor("#72B38C"));

    /* renamed from: com.upuphone.ar.navi.lite.navi.HereNaviManager$1  reason: invalid class name */
    class AnonymousClass1 implements DynamicRoutingListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ HereNaviManager f5787a;

        public void onBetterRouteFound(Route route, int i, int i2) {
            String k0 = HereNaviManager.P;
            Log.e(k0, "DynamicRoutingEngine: Calculated a new route. etaDifferenceInSeconds=" + i + " distanceDifferenceInMeters=" + i2);
            if (this.f5787a.C0() != null) {
                this.f5787a.C0().clear();
                this.f5787a.C0().add(route);
            }
            this.f5787a.s1(route);
            this.f5787a.E.setRoute(route);
        }

        public void onRoutingError(RoutingError routingError) {
            String k0 = HereNaviManager.P;
            Log.e(k0, "DynamicRoutingEngine: Error while dynamically searching for a better route: " + routingError.name());
        }
    }

    public static final class InstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        public static final HereNaviManager f5789a = new HereNaviManager();
    }

    public static /* synthetic */ void S0(AnimationState animationState) {
        String str = P;
        CLog.a(str, "animateToRoute  animationState=" + animationState);
    }

    public static /* synthetic */ void g1(RealisticViewWarning realisticViewWarning) {
        double d = realisticViewWarning.distanceToRealisticViewInMeters;
        if (realisticViewWarning.realisticView == null) {
            CLog.a(P, "A RealisticView just passed. No SVG data delivered.");
        }
    }

    public static HereNaviManager v0() {
        return InstanceHolder.f5789a;
    }

    public boolean A(int i, int i2) {
        String str = P;
        CLog.a(str, " refreshRoute() enter! mode=" + i + " strategy=" + i2);
        ULocation g = LocationManager.f().g();
        int i3 = 0;
        if (g == null) {
            CLog.a(str, " refreshRoute() location object is null.");
            return false;
        }
        int i4 = 10;
        if (i2 < 1) {
            i2 = 10;
        }
        if (i2 <= 1000) {
            i4 = i2;
        }
        if (i == 0) {
            i3 = i4;
        }
        RouteHandle routeHandle = t0().getRouteHandle();
        GeoCoordinates geoCoordinates = new GeoCoordinates(g.getLatitude(), g.getLongitude());
        CLog.a(str, " refreshRoute() enter! startPoint.latitude=" + geoCoordinates.latitude + " startPoint.longitude=" + geoCoordinates.longitude + " strategy=" + i3);
        this.D.refreshRoute(routeHandle, new Waypoint(geoCoordinates), E0(i, i3), new k(this));
        return true;
    }

    public final Resources A0() {
        Locale locale = Locale.getDefault();
        Configuration configuration = this.f5786a.getResources().getConfiguration();
        String str = P;
        CLog.b(str, "###### getLocaleResources  getCountry()=" + locale.getCountry() + " getLanguage=" + locale.getLanguage() + " locale getCountry()=" + configuration.locale.getCountry() + " locale getLanguage=" + configuration.locale.getLanguage());
        configuration.setLocale(locale);
        StringBuilder sb = new StringBuilder();
        sb.append("&&&&& getLocaleResources   getCountry()=");
        sb.append(configuration.locale.getCountry());
        sb.append(" getLanguage=");
        sb.append(configuration.locale.getLanguage());
        CLog.b(str, sb.toString());
        return this.f5786a.createConfigurationContext(configuration).getResources();
    }

    public final void A1() {
        this.E.setRealisticViewWarningListener(new h());
    }

    public void B(int i) {
        C1(i);
    }

    public List B0() {
        return this.I;
    }

    public final void B1() {
        this.E.setRoadAttributesListener(new p(this));
    }

    public void C(boolean z2, int i, boolean z3) {
        if (!z2) {
            CLog.b(P, "sendManualRefreshMsg() current state is not Naving, not need send refresh message.");
        } else {
            StarryNetManger.getInstance().sendMessage(ProtocolUtils.g("route_refresh", i, z3 ? "1" : "0"), (SendMessageListener) null);
        }
    }

    public List C0() {
        return this.H;
    }

    public void C1(int i) {
        List list = this.H;
        if (list != null && list.size() != 0 && i < this.H.size()) {
            this.L = (Route) this.H.get(i);
            this.f = i;
        }
    }

    public void D() {
    }

    public final PedestrianOptions D0() {
        PedestrianOptions pedestrianOptions = new PedestrianOptions();
        RouteOptions routeOptions = pedestrianOptions.routeOptions;
        routeOptions.enableRouteHandle = true;
        routeOptions.alternatives = 2;
        return pedestrianOptions;
    }

    public final void D1() {
        this.E.setRouteDeviationListener(new RouteDeviationListener() {
            public final /* synthetic */ void b() {
                HereNaviManager.this.l = false;
            }

            public void onRouteDeviation(RouteDeviation routeDeviation) {
                GeoCoordinates geoCoordinates;
                Route route = HereNaviManager.this.E.getRoute();
                if (route != null) {
                    NavigableLocation navigableLocation = routeDeviation.currentLocation;
                    MapMatchedLocation mapMatchedLocation = navigableLocation.mapMatchedLocation;
                    GeoCoordinates geoCoordinates2 = mapMatchedLocation == null ? navigableLocation.originalLocation.coordinates : mapMatchedLocation.coordinates;
                    NavigableLocation navigableLocation2 = routeDeviation.lastLocationOnRoute;
                    if (navigableLocation2 != null) {
                        MapMatchedLocation mapMatchedLocation2 = navigableLocation2.mapMatchedLocation;
                        geoCoordinates = mapMatchedLocation2 == null ? navigableLocation2.originalLocation.coordinates : mapMatchedLocation2.coordinates;
                    } else {
                        Log.d(HereNaviManager.P, "User was never following the route. So, we take the start of the route instead.");
                        geoCoordinates = route.getSections().get(0).getDeparturePlace().originalCoordinates;
                    }
                    int distanceTo = (int) geoCoordinates2.distanceTo(geoCoordinates);
                    String k0 = HereNaviManager.P;
                    Log.d(k0, "RouteDeviation in meters is " + distanceTo);
                    if (distanceTo <= 0 || distanceTo > 30 || mapMatchedLocation == null) {
                        HereNaviManager hereNaviManager = HereNaviManager.this;
                        if (hereNaviManager.e != null && distanceTo > 30 && !hereNaviManager.l) {
                            hereNaviManager.l = true;
                            new Handler().postDelayed(new a(this), 5000);
                            HereNaviManager.this.e.h(distanceTo);
                            return;
                        }
                        return;
                    }
                    HereNaviManager.this.L0(routeDeviation, distanceTo, geoCoordinates2, mapMatchedLocation);
                }
            }
        });
    }

    public void E(NaviView naviView) {
        this.b = naviView;
    }

    public final RefreshRouteOptions E0(int i, int i2) {
        return i == 1 ? new RefreshRouteOptions(q0()) : i == 2 ? new RefreshRouteOptions(D0()) : new RefreshRouteOptions(r0(i2));
    }

    public final void E1() {
        this.E.setRouteProgressListener(new c(this));
    }

    public void F() {
        CLog.b(P, "setEmulatorNaviSpeed  Enter.");
    }

    public final String F0(Maneuver maneuver) {
        RoadTexts roadTexts = maneuver.getRoadTexts();
        RoadTexts nextRoadTexts = maneuver.getNextRoadTexts();
        String defaultValue = roadTexts.names.getDefaultValue();
        String defaultValue2 = roadTexts.numbersWithDirection.getDefaultValue();
        String defaultValue3 = nextRoadTexts.names.getDefaultValue();
        String defaultValue4 = nextRoadTexts.numbersWithDirection.getDefaultValue();
        String str = defaultValue3 == null ? defaultValue4 : defaultValue3;
        if (maneuver.getNextRoadType() == RoadType.HIGHWAY) {
            if (defaultValue4 != null) {
                defaultValue3 = defaultValue4;
            }
            str = defaultValue3;
        }
        if (maneuver.getAction() == ManeuverAction.ARRIVE) {
            if (defaultValue == null) {
                defaultValue = defaultValue2;
            }
            str = defaultValue;
        }
        return str == null ? A0().getString(R.string.unname_road) : str;
    }

    public void F1(RoutingError routingError) {
        this.F = routingError;
    }

    public void G(INaviEvent iNaviEvent) {
        this.e = iNaviEvent;
    }

    public final Color G0(int i, boolean z2) {
        return i == 1 ? z2 ? this.t : this.v : i == 2 ? z2 ? this.x : this.z : z2 ? this.p : this.r;
    }

    public final void G1() {
        this.E.setSpeedLimitListener(new f(this));
    }

    public void H(int i) {
    }

    public Route H0(int i) {
        List list = this.H;
        if (list == null || list.size() == 0 || i >= this.H.size()) {
            return null;
        }
        List list2 = this.H;
        if (i == -1) {
            i = 0;
        }
        return (Route) list2.get(i);
    }

    public final void H1() {
        this.E.setSpeedWarningListener(new d(this));
    }

    public void I(int i) {
        this.c = i;
    }

    public final Color I0(int i, boolean z2) {
        return i == 1 ? z2 ? this.s : this.u : i == 2 ? z2 ? this.w : this.y : z2 ? this.o : this.q;
    }

    public final void I1() {
        VisualNavigator visualNavigator = this.E;
        if (visualNavigator != null) {
            visualNavigator.setRoute((Route) null);
            this.E.setCameraBehavior(new SpeedBasedCameraBehavior());
            this.E.stopRendering();
        }
    }

    public void J(NaviView naviView) {
        String str = P;
        CLog.b(str, "setRouteAndRender, ######### ");
        this.b = naviView;
        this.E.startRendering(naviView.getHereMapNaviView());
        this.E.setRoute(t0());
        CLog.b(str, "setRouteAndRender, &&&&&&&&&&");
    }

    public VisualNavigator J0() {
        return this.E;
    }

    public void K() {
    }

    public final void K0() {
        Class<ConsentActivity> cls = ConsentActivity.class;
        try {
            int i = ConsentActivity.$r8$clinit;
            Method declaredMethod = cls.getDeclaredMethod("onConsentGranted", (Class[]) null);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(cls.newInstance(), (Object[]) null);
        } catch (ClassNotFoundException e) {
            String str = P;
            CLog.b(str, "grantUserConsent  exception=" + e);
        } catch (NoSuchMethodException e2) {
            String str2 = P;
            CLog.b(str2, "NoSuchMethodException  exception=" + e2);
        } catch (SecurityException e3) {
            String str3 = P;
            CLog.b(str3, "SecurityException  exception=" + e3);
        } catch (IllegalAccessException e4) {
            String str4 = P;
            CLog.b(str4, "IllegalAccessException  exception=" + e4);
        } catch (IllegalArgumentException e5) {
            String str5 = P;
            CLog.b(str5, "IllegalArgumentException  exception=" + e5);
        } catch (InvocationTargetException e6) {
            String str6 = P;
            CLog.b(str6, "InvocationTargetException  exception=" + e6);
        } catch (InstantiationException e7) {
            String str7 = P;
            CLog.b(str7, "InstantiationException  exception=" + e7);
        }
    }

    public void L(int i) {
        boolean b = CSharedPreferences.b(this.f5786a.getApplicationContext(), "gps_mode", true);
        String str = P;
        CLog.b(str, "startNavi()  gpsMode=" + b + " navMode=" + i);
        y1();
        p1(t0().getGeometry().vertices.get(0));
        this.E.setCameraBehavior(new DynamicCameraBehavior());
        if (b) {
            LocationManager.f().a();
        } else {
            NaviSimulateManager.d().b();
        }
    }

    public final void L0(RouteDeviation routeDeviation, int i, GeoCoordinates geoCoordinates, MapMatchedLocation mapMatchedLocation) {
        int i2 = this.h + 1;
        this.h = i2;
        if (this.m) {
            Log.d(P, "Rerouting is ongoing ...");
        } else if (i > 0 && i2 >= 3) {
            this.m = true;
            Waypoint waypoint = new Waypoint(geoCoordinates);
            Double d = mapMatchedLocation.bearingInDegrees;
            if (d != null) {
                waypoint.headingInDegrees = d;
            }
            Log.d(P, "Rerouting: Calculating a new route.");
            n0();
            this.D.returnToRoute(t0(), waypoint, routeDeviation.lastTraveledSectionIndex, routeDeviation.traveledDistanceOnLastSectionInMeters, new e(this));
        }
    }

    public void M() {
        this.k = true;
    }

    public final void M0(RoutingError routingError, List list) {
        if (routingError == null && list.size() > 0) {
            F1(routingError);
            z1(list);
            s1((Route) list.get(0));
            this.E.setRoute((Route) list.get(0));
        }
        this.m = false;
        this.h = 0;
    }

    public void N() {
        boolean b = CSharedPreferences.b(this.f5786a.getApplicationContext(), "gps_mode", true);
        String str = P;
        CLog.b(str, "stopNavi()  Enter. gpsMode=" + b);
        LocationManager.f().n();
        NaviSimulateManager.d().a();
        I1();
        this.C.stopPrefetchAroundRoute();
        OfflineMapManager.b().i();
    }

    /* renamed from: N0 */
    public final void X0() {
        StarryNetManger.getInstance().sendMessage(ProtocolUtils.a("hide_lane_info", ""), (SendMessageListener) null);
        INaviEvent iNaviEvent = this.e;
        if (iNaviEvent != null) {
            iNaviEvent.v();
        }
    }

    public void O() {
        this.k = false;
        Context context = this.f5786a;
        if (context != null) {
            NaviTtsManager.getInstance(context).stopSpeak();
        }
    }

    public final void O0() {
        try {
            this.D = new RoutingEngine();
        } catch (InstantiationErrorException e) {
            throw new RuntimeException("Initialization of RoutingEngine failed: " + e.error.name());
        }
    }

    public final void P0() {
        try {
            this.E = new VisualNavigator();
        } catch (InstantiationErrorException e) {
            throw new RuntimeException("Initialization of VisualNavigator failed: " + e.error.name());
        }
    }

    public boolean Q0() {
        RoadAttributes roadAttributes = this.M;
        if (roadAttributes == null) {
            return false;
        }
        return roadAttributes.isControlledAccess;
    }

    public boolean R0() {
        return false;
    }

    public final /* synthetic */ void W0(RoutingError routingError, List list) {
        M0(routingError, list);
        Log.d(P, "Rerouting: New route set.");
    }

    public final /* synthetic */ void Y0(MapView mapView) {
        l0(t0(), mapView);
    }

    public final /* synthetic */ void Z0(RoutingError routingError, List list) {
        String str = P;
        CLog.b(str, "refreshRoute() onRouteCalculated  routingError." + routingError);
        boolean z2 = false;
        if (routingError == null) {
            F1(routingError);
            z1(list);
            s1((Route) list.get(0));
            this.E.setRoute((Route) list.get(0));
        }
        if (this.e != null) {
            CLog.b(str, "refreshRoute() onRouteCalculated  naviEvent is null.");
            INaviEvent iNaviEvent = this.e;
            if (routingError == null) {
                z2 = true;
            }
            iNaviEvent.f(z2);
        }
    }

    public void a(UNaviPoi uNaviPoi, UNaviPoi uNaviPoi2, int i) {
        CLog.a(P, " calculateDriveRoute() enter!");
        GeoCoordinates geoCoordinates = new GeoCoordinates(uNaviPoi.getLatitude(), uNaviPoi.getLongitude());
        GeoCoordinates geoCoordinates2 = new GeoCoordinates(uNaviPoi2.getLatitude(), uNaviPoi2.getLongitude());
        Waypoint waypoint = new Waypoint(geoCoordinates);
        Waypoint waypoint2 = new Waypoint(geoCoordinates2);
        n0();
        this.N = this.D.calculateRoute((List<Waypoint>) new ArrayList(Arrays.asList(new Waypoint[]{waypoint, waypoint2})), r0(i), (CalculateRouteCallback) new n(this));
    }

    public final /* synthetic */ void a1() {
        INaviEvent iNaviEvent = this.e;
        if (iNaviEvent != null) {
            iNaviEvent.l();
        }
    }

    public void b(UNaviPoi uNaviPoi, UNaviPoi uNaviPoi2) {
        CLog.a(P, " calculateRideRoute() enter!");
        GeoCoordinates geoCoordinates = new GeoCoordinates(uNaviPoi.getLatitude(), uNaviPoi.getLongitude());
        GeoCoordinates geoCoordinates2 = new GeoCoordinates(uNaviPoi2.getLatitude(), uNaviPoi2.getLongitude());
        Waypoint waypoint = new Waypoint(geoCoordinates);
        Waypoint waypoint2 = new Waypoint(geoCoordinates2);
        n0();
        this.N = this.D.calculateRoute((List<Waypoint>) new ArrayList(Arrays.asList(new Waypoint[]{waypoint, waypoint2})), q0(), (CalculateRouteCallback) new a(this));
    }

    public final /* synthetic */ void b1(ManeuverViewLaneAssistance maneuverViewLaneAssistance) {
        if (maneuverViewLaneAssistance.lanesForNextManeuver != null) {
            String str = P;
            CLog.d(str, " onLaneAssistanceUpdated() lanesForNextManeuver.size() =" + maneuverViewLaneAssistance.lanesForNextManeuver.size());
            CLog.d(str, " onLaneAssistanceUpdated() lane.type =" + maneuverViewLaneAssistance.lanesForNextManeuver.get(0).type);
            m1(maneuverViewLaneAssistance.lanesForNextManeuver);
        }
    }

    public void c(UNaviPoi uNaviPoi, UNaviPoi uNaviPoi2) {
        CLog.a(P, " calculateWalkRoute() enter!");
        GeoCoordinates geoCoordinates = new GeoCoordinates(uNaviPoi.getLatitude(), uNaviPoi.getLongitude());
        GeoCoordinates geoCoordinates2 = new GeoCoordinates(uNaviPoi2.getLatitude(), uNaviPoi2.getLongitude());
        Waypoint waypoint = new Waypoint(geoCoordinates);
        Waypoint waypoint2 = new Waypoint(geoCoordinates2);
        n0();
        this.N = this.D.calculateRoute((List<Waypoint>) new ArrayList(Arrays.asList(new Waypoint[]{waypoint, waypoint2})), D0(), (CalculateRouteCallback) new m(this));
    }

    public final /* synthetic */ void c1(JunctionViewLaneAssistance junctionViewLaneAssistance) {
        List<Lane> list = junctionViewLaneAssistance.lanesForNextJunction;
        if (list.isEmpty()) {
            CLog.a(P, "You have passed the complex junction.");
            return;
        }
        CLog.a(P, "Attention, a complex junction is ahead.");
        m1(list);
    }

    public void d(NaviView naviView) {
        MapScene s0 = s0(naviView);
        if (s0 != null) {
            s0.removeMapPolylines(this.J);
            this.J.clear();
            return;
        }
        CLog.b(P, "cleanMapPolyline mapView.mapScene is null.");
    }

    public final /* synthetic */ void d1() {
        this.l = false;
    }

    public void e() {
        NaviView naviView = this.b;
        if (naviView == null) {
            CLog.b(P, "destroyedNavi curNaviView object is null.");
            return;
        }
        HereMapView hereMapNaviView = naviView.getHereMapNaviView();
        if (hereMapNaviView != null) {
            try {
                if (hereMapNaviView.isValid()) {
                    hereMapNaviView.onDestroy();
                }
            } catch (Exception e) {
                String str = P;
                CLog.b(str, "destroyNavi excep=" + e);
            }
        }
        E((NaviView) null);
    }

    public final /* synthetic */ void e1(NavigableLocation navigableLocation) {
        if (navigableLocation.originalLocation != null) {
            LocationManager.f().o(HereLocation.v().w(navigableLocation.originalLocation));
        }
        MapMatchedLocation mapMatchedLocation = navigableLocation.mapMatchedLocation;
        this.A = mapMatchedLocation;
        if (mapMatchedLocation == null) {
            Log.d(P, "setLocationChangeListener() The currentNavigableLocation could not be map-matched. Are you off-road?");
            if (this.e != null && !this.l) {
                this.l = true;
                new Handler().postDelayed(new i(this), 5000);
                this.e.h(-1);
                return;
            }
            return;
        }
        Double d = navigableLocation.originalLocation.speedInMetersPerSecond;
        if (d != null) {
            int intValue = (BigDecimal.valueOf(d.doubleValue()).intValue() * 3600) / 1000;
            this.g = intValue;
            GeoCoordinates geoCoordinates = navigableLocation.originalLocation.coordinates;
            String str = P;
            CLog.b(str, "setLocationChangeListener()  curSpeed=" + this.g + " geoCoordinates.latitude=" + geoCoordinates.latitude + " longitude=" + geoCoordinates.longitude);
            INaviEvent iNaviEvent = this.e;
            if (iNaviEvent != null) {
                iNaviEvent.s(intValue);
            }
        }
    }

    public void f(NaviView naviView, int i) {
        HereMapView hereMapNaviView = naviView.getHereMapNaviView();
        List C0 = C0();
        for (int i2 = 0; i2 < C0.size(); i2++) {
            Route route = (Route) C0.get(i2);
            if (i2 != this.f) {
                p0(naviView, route, G0(i, false), I0(i, false));
            }
        }
        p0(naviView, t0(), G0(i, true), I0(i, true));
        o1(hereMapNaviView, 250);
    }

    public final /* synthetic */ void f1(String str) {
        boolean m = CSharedPreferences.m(this.f5786a.getApplicationContext());
        boolean isCallStateIdle = ConnectionManager.getInstance(this.f5786a).isCallStateIdle();
        String str2 = P;
        CLog.d(str2, " onManeuverNotification() voiceText =" + str + " enableSpeak=" + this.k + " voiceState=" + m + " stateIdle=" + isCallStateIdle);
        INaviEvent iNaviEvent = this.e;
        if (iNaviEvent != null) {
            iNaviEvent.D(0, str);
        }
        if (this.k && m && isCallStateIdle) {
            NaviTtsManager.getInstance(this.f5786a).startSpeak(str);
        }
    }

    public int g(int i) {
        Route H0 = H0(i);
        if (H0 != null) {
            return H0.getLengthInMeters();
        }
        return 0;
    }

    public int h(int i) {
        Route H0 = H0(i);
        if (H0 != null) {
            return (int) H0.getDuration().getSeconds();
        }
        return 0;
    }

    public final /* synthetic */ void h1(RoadAttributes roadAttributes) {
        String str = P;
        CLog.a(str, "Received road attributes update.");
        this.M = roadAttributes;
        if (roadAttributes.isBridge) {
            CLog.a(str, "Road attributes: This is a bridge.");
        }
        if (roadAttributes.isControlledAccess) {
            CLog.a(str, "Road attributes: This is a controlled access road.");
        }
        if (roadAttributes.isDirtRoad) {
            CLog.a(str, "Road attributes: This is a dirt road.");
        }
        if (roadAttributes.isDividedRoad) {
            CLog.a(str, "Road attributes: This is a divided road.");
        }
        if (roadAttributes.isNoThrough) {
            CLog.a(str, "Road attributes: This is a no through road.");
        }
        if (roadAttributes.isPrivate) {
            CLog.a(str, "Road attributes: This is a private road.");
        }
        if (roadAttributes.isRamp) {
            CLog.a(str, "Road attributes: This is a ramp.");
        }
        if (roadAttributes.isRightDrivingSide) {
            CLog.a(str, "Road attributes: isRightDrivingSide = " + roadAttributes.isRightDrivingSide);
        }
        if (roadAttributes.isRoundabout) {
            CLog.a(str, "Road attributes: This is a roundabout.");
        }
        if (roadAttributes.isTollway) {
            CLog.a(str, "Road attributes change: This is a road with toll costs.");
        }
        if (roadAttributes.isTunnel) {
            CLog.a(str, "Road attributes: This is a tunnel.");
        }
    }

    public NaviView i() {
        return this.b;
    }

    public final /* synthetic */ void i1(RouteProgress routeProgress) {
        NaviInfoBean naviInfoBean = new NaviInfoBean();
        List<SectionProgress> list = routeProgress.sectionProgress;
        SectionProgress sectionProgress = list.get(list.size() - 1);
        String str = P;
        CLog.a(str, "Distance to destination in meters: " + sectionProgress.remainingDistanceInMeters + " Traffic delay ahead in seconds: " + sectionProgress.remainingDuration.getSeconds() + " routeProgress.sectionIndex=" + routeProgress.sectionIndex);
        naviInfoBean.setPathDistance(g(this.f));
        naviInfoBean.setPathRetainDistance(sectionProgress.remainingDistanceInMeters);
        naviInfoBean.setPathRemainTime((int) sectionProgress.remainingDuration.getSeconds());
        StringBuilder sb = new StringBuilder();
        sb.append(this.g);
        sb.append("");
        naviInfoBean.setNaviSpeed(sb.toString());
        naviInfoBean.setRoadClass(Q0() ? 1 : 0);
        naviInfoBean.setAdjustBrightness(n1() ? 1 : 0);
        ManeuverProgress maneuverProgress = routeProgress.maneuverProgress.get(0);
        if (maneuverProgress != null) {
            naviInfoBean.setNextRoadDistance(maneuverProgress.remainingDistanceInMeters);
            Maneuver maneuver = this.E.getManeuver(maneuverProgress.maneuverIndex);
            if (maneuver != null) {
                naviInfoBean.setIconType(maneuver.getAction().value);
                naviInfoBean.setNextRoadName(F0(maneuver));
            }
        } else {
            CLog.a(str, "No next maneuver available.");
        }
        MapMatchedLocation mapMatchedLocation = this.A;
        if (mapMatchedLocation != null) {
            this.B.updateCurrentLocation(mapMatchedLocation, routeProgress.sectionIndex);
        }
        q1(naviInfoBean);
        if (this.e != null && naviInfoBean.getIconType() == 1 && naviInfoBean.getPathRetainDistance() <= 10) {
            this.e.l();
        }
    }

    public String j(String str) {
        String str2 = P;
        CLog.b(str2, " getErrorDesp  routingErrore " + this.F);
        RoutingError routingError = this.F;
        return routingError == RoutingError.ROUTE_LENGTH_LIMIT_EXCEEDED ? A0().getString(R.string.result_distance_too_long) : routingError == RoutingError.ROUTE_CALCULATION_FAILED ? A0().getString(R.string.calculate_route_failed) : (routingError == RoutingError.HTTP_ERROR || routingError == RoutingError.PROXY_SERVER_UNREACHABLE || routingError == RoutingError.SERVER_UNREACHABLE || routingError == RoutingError.OFFLINE) ? A0().getString(R.string.network_anomaly) : A0().getString(R.string.calculate_route_failed);
    }

    public final /* synthetic */ void j1(SpeedLimit speedLimit) {
        Double u0 = u0(speedLimit);
        if (u0 == null) {
            CLog.a(P, "Warning: Speed limits unknown, data could not be retrieved.");
            this.d = 0;
        } else if (u0.doubleValue() == 0.0d) {
            CLog.a(P, "No speed limits on this road! Drive as fast as you feel safe ...");
            this.d = 1;
        } else {
            int round = (int) Math.round(u0.doubleValue());
            this.d = (round * 3600) / 1000;
            String str = P;
            CLog.a(str, "Current speed limit (m/s):" + u0 + " curSpeedLimit=" + this.d + " kiloMetes=" + round);
        }
    }

    public String k(int i) {
        H0(i);
        return "";
    }

    public final /* synthetic */ void k1(SpeedWarningStatus speedWarningStatus) {
        if (speedWarningStatus == SpeedWarningStatus.SPEED_LIMIT_EXCEEDED) {
            StarryNetManger.getInstance().sendMessage(ProtocolUtils.b(this.d, 2), (SendMessageListener) null);
        }
        if (speedWarningStatus == SpeedWarningStatus.SPEED_LIMIT_RESTORED) {
            CLog.a(P, "Driver is again slower than current speed limit (plus an optional offset).");
            StarryNetManger.getInstance().sendMessage(ProtocolUtils.b(this.d, 3), (SendMessageListener) null);
        }
    }

    public int l() {
        return this.c;
    }

    public final void l0(Route route, MapView mapView) {
        if (mapView != null) {
            if (!mapView.isValid()) {
                CLog.a(P, "animateToRoute mapView is inValid!");
                return;
            }
            mapView.getCamera().startAnimation(MapCameraAnimationFactory.createAnimation(MapCameraUpdateFactory.lookAt(route.getBoundingBox(), new GeoOrientationUpdate(Double.valueOf(0.0d), Double.valueOf(0.0d)), new Rectangle2D(new Point2D(200.0d, 800.0d), new Size2D((double) (mapView.getWidth() - 400), (double) (mapView.getHeight() - 1600)))), Duration.ofMillis(500), new Easing(EasingFunction.IN_CUBIC)), new q());
        }
    }

    public final void l1(int i, Lane lane) {
        LaneDirectionCategory laneDirectionCategory = lane.directionCategory;
        String str = P;
        CLog.a(str, "Directions for lane laneNumber=" + i + " straight: " + laneDirectionCategory.straight + " slightlyLeft: " + laneDirectionCategory.slightlyLeft + " quiteLeft: " + laneDirectionCategory.quiteLeft + " hardLeft: " + laneDirectionCategory.hardLeft + " uTurnLeft: " + laneDirectionCategory.uTurnLeft + " slightlyRight: " + laneDirectionCategory.slightlyRight + " quiteRight: " + laneDirectionCategory.quiteRight + " hardRight: " + laneDirectionCategory.hardRight + " uTurnRight: " + laneDirectionCategory.uTurnRight);
    }

    public NaviInfoBean m() {
        List<Section> sections = t0().getSections();
        if (sections == null) {
            return null;
        }
        String str = P;
        CLog.d(str, "getPreNaviInfo sectionList.size(): " + sections.size());
        Section section = sections.get(0);
        CLog.d(str, "getPreNaviInfo sectionList.size(): " + section.getDuration().getSeconds() + " getLengthInMeters = " + section.getLengthInMeters());
        List<Maneuver> maneuvers = section.getManeuvers();
        if (maneuvers == null) {
            return null;
        }
        Maneuver maneuver = maneuvers.get(0);
        NaviInfoBean naviInfoBean = new NaviInfoBean();
        naviInfoBean.setPathDistance(g(this.f));
        naviInfoBean.setPathRetainDistance(g(this.f));
        naviInfoBean.setPathRemainTime(h(this.f));
        naviInfoBean.setRouteRemainLightCount(sections.size());
        naviInfoBean.setNaviSpeed(this.g + "");
        naviInfoBean.setNextRoadDistance(maneuver.getLengthInMeters());
        naviInfoBean.setIconType(maneuver.getAction().value);
        naviInfoBean.setNextRoadName(maneuver.getNextRoadTexts().names.getDefaultValue());
        CLog.d(str, "getPreNaviInfo naviInfoBean: " + naviInfoBean.toString());
        return naviInfoBean;
    }

    /* renamed from: m0 */
    public final void V0(RoutingError routingError, List list) {
        this.F = routingError;
        this.H = list;
        String str = P;
        CLog.b(str, "calculateRouteresult  routingError=" + routingError + " isRouteDeviation=" + this.l);
        INaviEvent iNaviEvent = this.e;
        if (iNaviEvent == null) {
            CLog.b(str, "calculateRouteresult  naviEvent is null.");
        } else if (routingError != null && routingError == RoutingError.OPERATION_CANCELLED) {
            CLog.b(str, "calculateRouteresult  OPERATION_CANCELLED.");
        } else if (routingError == null) {
            iNaviEvent.U();
        } else {
            iNaviEvent.G();
        }
    }

    public final void m1(List list) {
        String str = P;
        CLog.a(str, "logLaneRecommendations lanes.size()=" + list.size());
        x1(list);
        ArrayList<Integer> x0 = x0();
        NaviLaneInfo naviLaneInfo = new NaviLaneInfo();
        naviLaneInfo.lanesIconList = x0;
        StarryNetManger.getInstance().sendMessage(ProtocolUtils.d(naviLaneInfo), (SendMessageListener) null);
        INaviEvent iNaviEvent = this.e;
        if (iNaviEvent != null) {
            iNaviEvent.m(naviLaneInfo);
            new Handler().postDelayed(new j(this), 5000);
        }
        Iterator it = list.iterator();
        int i = 0;
        while (it.hasNext()) {
            Lane lane = (Lane) it.next();
            if (lane.recommendationState == LaneRecommendationState.RECOMMENDED) {
                String str2 = P;
                CLog.a(str2, "Lane " + i + " leads to next maneuver, but not to the next next maneuver.");
            }
            if (lane.recommendationState == LaneRecommendationState.HIGHLY_RECOMMENDED) {
                String str3 = P;
                CLog.a(str3, "Lane " + i + " leads to next maneuver and eventually to the next next maneuver.");
            }
            if (lane.recommendationState == LaneRecommendationState.NOT_RECOMMENDED) {
                String str4 = P;
                CLog.a(str4, "Do not take lane " + i + " to follow the route.");
            }
            l1(i, lane);
            i++;
        }
    }

    public String n(boolean z2, int i) {
        return i == 1 ? A0().getString(R.string.best_route) : z2 ? A0().getString(R.string.route_refresh) : "";
    }

    public final void n0() {
        TaskHandle taskHandle = this.N;
        if (taskHandle != null && !taskHandle.isFinished()) {
            this.N.cancel();
        }
    }

    public boolean n1() {
        return R0();
    }

    public int[] o() {
        List list = this.H;
        if (list == null || list.size() == 0) {
            return null;
        }
        int[] iArr = new int[this.H.size()];
        for (int i = 0; i < this.H.size(); i++) {
            iArr[i] = i;
        }
        return iArr;
    }

    public final void o0() {
        DynamicRoutingEngineOptions dynamicRoutingEngineOptions = new DynamicRoutingEngineOptions();
        dynamicRoutingEngineOptions.minTimeDifference = Duration.ofSeconds(1);
        dynamicRoutingEngineOptions.minTimeDifferencePercentage = Double.valueOf(0.1d);
        dynamicRoutingEngineOptions.pollInterval = Duration.ofMinutes(5);
        try {
            this.B = new DynamicRoutingEngine(dynamicRoutingEngineOptions);
        } catch (InstantiationErrorException e) {
            throw new RuntimeException("Initialization of DynamicRoutingEngine failed: " + e.error.name());
        }
    }

    public void o1(MapView mapView, long j) {
        if (mapView != null && mapView.isValid()) {
            mapView.postDelayed(new l(this, mapView), j);
        }
    }

    public int p() {
        RoutingError routingError = this.F;
        if (routingError == null) {
            return -1;
        }
        return routingError.value;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x005e  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0065  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void p0(com.upuphone.ar.navi.lite.naviview.NaviView r9, com.here.sdk.routing.Route r10, com.here.sdk.core.Color r11, com.here.sdk.core.Color r12) {
        /*
            r8 = this;
            com.here.sdk.core.GeoPolyline r10 = r10.getGeometry()
            r0 = 0
            com.here.sdk.mapview.MapPolyline r1 = new com.here.sdk.mapview.MapPolyline     // Catch:{ InstantiationException -> 0x0034, InstantiationException -> 0x0031 }
            com.here.sdk.mapview.MapPolyline$SolidRepresentation r2 = new com.here.sdk.mapview.MapPolyline$SolidRepresentation     // Catch:{ InstantiationException -> 0x0034, InstantiationException -> 0x0031 }
            com.here.sdk.mapview.MapMeasureDependentRenderSize r3 = new com.here.sdk.mapview.MapMeasureDependentRenderSize     // Catch:{ InstantiationException -> 0x0034, InstantiationException -> 0x0031 }
            com.here.sdk.mapview.RenderSize$Unit r4 = com.here.sdk.mapview.RenderSize.Unit.PIXELS     // Catch:{ InstantiationException -> 0x0034, InstantiationException -> 0x0031 }
            r5 = 4628574517030027264(0x403c000000000000, double:28.0)
            r3.<init>(r4, r5)     // Catch:{ InstantiationException -> 0x0034, InstantiationException -> 0x0031 }
            com.here.sdk.mapview.LineCap r5 = com.here.sdk.mapview.LineCap.ROUND     // Catch:{ InstantiationException -> 0x0034, InstantiationException -> 0x0031 }
            r2.<init>(r3, r11, r5)     // Catch:{ InstantiationException -> 0x0034, InstantiationException -> 0x0031 }
            r1.<init>((com.here.sdk.core.GeoPolyline) r10, (com.here.sdk.mapview.MapPolyline.Representation) r2)     // Catch:{ InstantiationException -> 0x0034, InstantiationException -> 0x0031 }
            com.here.sdk.mapview.MapPolyline r11 = new com.here.sdk.mapview.MapPolyline     // Catch:{ InstantiationException -> 0x002f, InstantiationException -> 0x002d }
            com.here.sdk.mapview.MapPolyline$SolidRepresentation r2 = new com.here.sdk.mapview.MapPolyline$SolidRepresentation     // Catch:{ InstantiationException -> 0x002f, InstantiationException -> 0x002d }
            com.here.sdk.mapview.MapMeasureDependentRenderSize r3 = new com.here.sdk.mapview.MapMeasureDependentRenderSize     // Catch:{ InstantiationException -> 0x002f, InstantiationException -> 0x002d }
            r6 = 4627730092099895296(0x4039000000000000, double:25.0)
            r3.<init>(r4, r6)     // Catch:{ InstantiationException -> 0x002f, InstantiationException -> 0x002d }
            r2.<init>(r3, r12, r5)     // Catch:{ InstantiationException -> 0x002f, InstantiationException -> 0x002d }
            r11.<init>((com.here.sdk.core.GeoPolyline) r10, (com.here.sdk.mapview.MapPolyline.Representation) r2)     // Catch:{ InstantiationException -> 0x002f, InstantiationException -> 0x002d }
            r0 = r11
            goto L_0x004e
        L_0x002d:
            r10 = move-exception
            goto L_0x0037
        L_0x002f:
            r10 = move-exception
            goto L_0x0043
        L_0x0031:
            r10 = move-exception
            r1 = r0
            goto L_0x0037
        L_0x0034:
            r10 = move-exception
            r1 = r0
            goto L_0x0043
        L_0x0037:
            com.here.sdk.mapview.MapMeasureDependentRenderSize$InstantiationErrorCode r10 = r10.error
            java.lang.String r10 = r10.name()
            java.lang.String r11 = "MapMeasureDependentRenderSize Exception:"
            com.upuphone.ar.navi.lite.util.CLog.b(r11, r10)
            goto L_0x004e
        L_0x0043:
            com.here.sdk.mapview.MapPolyline$Representation$InstantiationErrorCode r10 = r10.error
            java.lang.String r10 = r10.name()
            java.lang.String r11 = "MapPolyline Representation Exception:"
            com.upuphone.ar.navi.lite.util.CLog.b(r11, r10)
        L_0x004e:
            java.util.List r10 = r8.J
            r10.add(r1)
            java.util.List r10 = r8.J
            r10.add(r0)
            com.here.sdk.mapview.MapScene r8 = r8.s0(r9)
            if (r8 == 0) goto L_0x0065
            r8.addMapPolyline(r1)
            r8.addMapPolyline(r0)
            goto L_0x006c
        L_0x0065:
            java.lang.String r8 = P
            java.lang.String r9 = "MapMeasureDependentRenderSize mapView.mapScene is null."
            com.upuphone.ar.navi.lite.util.CLog.b(r8, r9)
        L_0x006c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.navi.lite.navi.HereNaviManager.p0(com.upuphone.ar.navi.lite.naviview.NaviView, com.here.sdk.routing.Route, com.here.sdk.core.Color, com.here.sdk.core.Color):void");
    }

    public final void p1(GeoCoordinates geoCoordinates) {
        this.C.prefetchAroundLocationWithRadius(geoCoordinates, Double.valueOf(2000.0d));
        this.C.prefetchAroundRouteOnIntervals(this.E);
    }

    public String q() {
        RoutingError routingError = this.F;
        return routingError == null ? "" : routingError.name();
    }

    public final BicycleOptions q0() {
        BicycleOptions bicycleOptions = new BicycleOptions();
        RouteOptions routeOptions = bicycleOptions.routeOptions;
        routeOptions.enableRouteHandle = true;
        routeOptions.alternatives = 2;
        return bicycleOptions;
    }

    public final void q1(NaviInfoBean naviInfoBean) {
        INaviEvent iNaviEvent = this.e;
        if (iNaviEvent != null) {
            iNaviEvent.x(naviInfoBean, true);
        }
        if (naviInfoBean.getIconType() != 0) {
            StarryNetManger.getInstance().sendMessage(ProtocolUtils.h(naviInfoBean), (SendMessageListener) null);
        }
    }

    public int r(int i) {
        Route H0 = H0(i);
        if (H0 != null) {
            return H0.getSections().size();
        }
        return 0;
    }

    public final CarOptions r0(int i) {
        CarOptions carOptions = new CarOptions();
        RouteOptions routeOptions = carOptions.routeOptions;
        routeOptions.enableRouteHandle = true;
        routeOptions.alternatives = 2;
        r1(carOptions, i);
        String str = P;
        CLog.d(str, " getCarOptions() @@@@@@@@@@@@@@ roadFeatures=" + carOptions.avoidanceOptions.roadFeatures + " enableTolls=" + carOptions.routeOptions.enableTolls + " alternatives=" + carOptions.routeOptions.alternatives + " occupantsNumber=" + carOptions.routeOptions.occupantsNumber + " enableTrafficOptimization=" + carOptions.routeOptions.enableTrafficOptimization + " optimizationMode=" + carOptions.routeOptions.optimizationMode + " trafficOptimizationMode=" + carOptions.routeOptions.trafficOptimizationMode);
        return carOptions;
    }

    public final void r1(CarOptions carOptions, int i) {
        if (i == 10) {
            RouteOptions routeOptions = carOptions.routeOptions;
            routeOptions.optimizationMode = OptimizationMode.FASTEST;
            routeOptions.trafficOptimizationMode = TrafficOptimizationMode.TIME_DEPENDENT;
        } else if (i == 20) {
            RouteOptions routeOptions2 = carOptions.routeOptions;
            routeOptions2.optimizationMode = OptimizationMode.FASTEST;
            routeOptions2.trafficOptimizationMode = TrafficOptimizationMode.TIME_DEPENDENT;
            routeOptions2.enableTolls = true;
        } else if (i == 18) {
            RouteOptions routeOptions3 = carOptions.routeOptions;
            routeOptions3.optimizationMode = OptimizationMode.FASTEST;
            routeOptions3.trafficOptimizationMode = TrafficOptimizationMode.TIME_DEPENDENT;
            routeOptions3.enableTolls = false;
            carOptions.avoidanceOptions.roadFeatures.add(RoadFeatures.CONTROLLED_ACCESS_HIGHWAY);
            carOptions.avoidanceOptions.roadFeatures.add(RoadFeatures.TOLL_ROAD);
        } else if (i == 15) {
            RouteOptions routeOptions4 = carOptions.routeOptions;
            routeOptions4.optimizationMode = OptimizationMode.FASTEST;
            routeOptions4.trafficOptimizationMode = TrafficOptimizationMode.TIME_DEPENDENT;
            routeOptions4.enableTolls = false;
            carOptions.avoidanceOptions.roadFeatures.add(RoadFeatures.CONTROLLED_ACCESS_HIGHWAY);
        } else if (i == 17) {
            RouteOptions routeOptions5 = carOptions.routeOptions;
            routeOptions5.optimizationMode = OptimizationMode.FASTEST;
            routeOptions5.trafficOptimizationMode = TrafficOptimizationMode.TIME_DEPENDENT;
            routeOptions5.enableTolls = false;
            carOptions.avoidanceOptions.roadFeatures.add(RoadFeatures.TOLL_ROAD);
        } else if (i == 1011) {
            RouteOptions routeOptions6 = carOptions.routeOptions;
            routeOptions6.optimizationMode = OptimizationMode.FASTEST;
            routeOptions6.trafficOptimizationMode = TrafficOptimizationMode.TIME_DEPENDENT;
            routeOptions6.enableTolls = true;
            carOptions.avoidanceOptions.roadFeatures.add(RoadFeatures.DIRT_ROAD);
        } else if (i == 1012) {
            RouteOptions routeOptions7 = carOptions.routeOptions;
            routeOptions7.optimizationMode = OptimizationMode.FASTEST;
            routeOptions7.trafficOptimizationMode = TrafficOptimizationMode.TIME_DEPENDENT;
            routeOptions7.enableTolls = true;
        } else if (i == 19) {
            RouteOptions routeOptions8 = carOptions.routeOptions;
            routeOptions8.optimizationMode = OptimizationMode.FASTEST;
            routeOptions8.trafficOptimizationMode = TrafficOptimizationMode.TIME_DEPENDENT;
            routeOptions8.enableTolls = true;
            carOptions.avoidanceOptions.roadFeatures.add(RoadFeatures.TOLL_ROAD);
        } else if (i == 16) {
            RouteOptions routeOptions9 = carOptions.routeOptions;
            routeOptions9.optimizationMode = OptimizationMode.FASTEST;
            routeOptions9.trafficOptimizationMode = TrafficOptimizationMode.LONG_TERM_CLOSURES_ONLY;
            routeOptions9.enableTolls = false;
            carOptions.avoidanceOptions.roadFeatures.add(RoadFeatures.CONTROLLED_ACCESS_HIGHWAY);
            carOptions.avoidanceOptions.roadFeatures.add(RoadFeatures.TOLL_ROAD);
        } else if (i == 13) {
            RouteOptions routeOptions10 = carOptions.routeOptions;
            routeOptions10.optimizationMode = OptimizationMode.SHORTEST;
            routeOptions10.trafficOptimizationMode = TrafficOptimizationMode.LONG_TERM_CLOSURES_ONLY;
            routeOptions10.enableTolls = false;
            carOptions.avoidanceOptions.roadFeatures.add(RoadFeatures.CONTROLLED_ACCESS_HIGHWAY);
        } else if (i == 14) {
            RouteOptions routeOptions11 = carOptions.routeOptions;
            routeOptions11.optimizationMode = OptimizationMode.SHORTEST;
            routeOptions11.trafficOptimizationMode = TrafficOptimizationMode.LONG_TERM_CLOSURES_ONLY;
            routeOptions11.enableTolls = true;
            carOptions.avoidanceOptions.roadFeatures.add(RoadFeatures.TOLL_ROAD);
        } else if (i == 1013) {
            RouteOptions routeOptions12 = carOptions.routeOptions;
            routeOptions12.optimizationMode = OptimizationMode.SHORTEST;
            routeOptions12.trafficOptimizationMode = TrafficOptimizationMode.LONG_TERM_CLOSURES_ONLY;
            routeOptions12.enableTolls = true;
            carOptions.avoidanceOptions.roadFeatures.add(RoadFeatures.DIRT_ROAD);
        } else if (i == 1014) {
            RouteOptions routeOptions13 = carOptions.routeOptions;
            routeOptions13.optimizationMode = OptimizationMode.SHORTEST;
            routeOptions13.trafficOptimizationMode = TrafficOptimizationMode.TIME_DEPENDENT;
            routeOptions13.enableTolls = true;
        } else if (i == 4) {
            RouteOptions routeOptions14 = carOptions.routeOptions;
            routeOptions14.optimizationMode = OptimizationMode.FASTEST;
            routeOptions14.trafficOptimizationMode = TrafficOptimizationMode.LONG_TERM_CLOSURES_ONLY;
            routeOptions14.enableTolls = true;
        }
    }

    public int s(int i) {
        Route H0 = H0(i);
        if (H0 != null) {
            return H0.getSections().size();
        }
        return 0;
    }

    public final MapScene s0(NaviView naviView) {
        if (naviView == null) {
            CLog.b(P, "getCurMapScene naviView object is null.");
            return null;
        }
        HereMapView hereMapNaviView = naviView.getHereMapNaviView();
        if (hereMapNaviView == null) {
            CLog.b(P, "getCurMapScene mapView object is null.");
            return null;
        } else if (hereMapNaviView.isValid()) {
            return hereMapNaviView.getMapScene();
        } else {
            CLog.b(P, "getCurMapScene mapView is not Valid.");
            return null;
        }
    }

    public void s1(Route route) {
        this.L = route;
    }

    public void t(Context context) {
        this.f5786a = context;
        this.k = CSharedPreferences.m(context.getApplicationContext());
        if (this.D == null) {
            O0();
            this.C = new RoutePrefetcher(SDKNativeEngine.getSharedInstance());
            P0();
            o0();
        }
    }

    public Route t0() {
        return this.L;
    }

    public final void t1() {
        this.E.setDestinationReachedListener(new o(this));
    }

    public void u(NaviView naviView) {
    }

    public final Double u0(SpeedLimit speedLimit) {
        String str = P;
        CLog.a(str, "speedLimitInMetersPerSecond: " + speedLimit.speedLimitInMetersPerSecond + " schoolZoneSpeedLimitInMetersPerSecond: " + speedLimit.schoolZoneSpeedLimitInMetersPerSecond + " timeDependentSpeedLimitInMetersPerSecond: " + speedLimit.timeDependentSpeedLimitInMetersPerSecond + " advisorySpeedLimitInMetersPerSecond: " + speedLimit.advisorySpeedLimitInMetersPerSecond + " fogSpeedLimitInMetersPerSecond: " + speedLimit.fogSpeedLimitInMetersPerSecond + " rainSpeedLimitInMetersPerSecond: " + speedLimit.rainSpeedLimitInMetersPerSecond + " snowSpeedLimitInMetersPerSecond: " + speedLimit.snowSpeedLimitInMetersPerSecond);
        return speedLimit.effectiveSpeedLimitInMetersPerSecond();
    }

    public final void u1() {
        this.E.setManeuverViewLaneAssistanceListener(new s(this));
        this.E.setJunctionViewLaneAssistanceListener(new b(this));
    }

    public void v(int i, boolean z2) {
    }

    public final void v1() {
        this.E.setNavigableLocationListener(new r(this));
    }

    public void w(Context context) {
        String str = P;
        CLog.b(str, "initSdk() Enter.");
        if (SDKNativeEngine.getSharedInstance() != null) {
            CLog.b(str, "initSdk() HERE SDK has inited");
            return;
        }
        try {
            SDKNativeEngine.makeSharedInstance(context, new SDKOptions("an9zXu2Xiigcb-0e2ByLKw", "lI038l6yTuMJNxNXi4cXv_Eg7EddtNZhVkMPlJgrFqHFz7ybm-LY2R_fz6pGvE7tBw1zTXsvChtzC98sCkJGDA", OfflineMapManager.b().d(context)));
            if (this.O == null) {
                this.O = new ConsentEngine();
            }
            CLog.b(str, "initSdk getUserConsentState()=" + this.O.getUserConsentState());
            if (this.O.getUserConsentState() == Consent.UserReply.NOT_HANDLED) {
                K0();
            }
        } catch (InstantiationErrorException e) {
            String str2 = P;
            CLog.b(str2, "initSdk() Initialization of HERE SDK failed: " + e.error.name());
        }
    }

    public int w0(Lane lane) {
        LaneDirectionCategory laneDirectionCategory = lane.directionCategory;
        String str = P;
        CLog.d(str, "getLaneIconType Enter lane show!");
        if (laneDirectionCategory.straight) {
            return 0;
        }
        if (laneDirectionCategory.slightlyLeft) {
            return 1;
        }
        if (laneDirectionCategory.slightlyRight) {
            return 2;
        }
        if (laneDirectionCategory.quiteLeft) {
            return 3;
        }
        if (laneDirectionCategory.quiteRight) {
            return 4;
        }
        if (laneDirectionCategory.hardLeft) {
            return 5;
        }
        if (laneDirectionCategory.hardRight) {
            return 6;
        }
        if (laneDirectionCategory.uTurnLeft) {
            return 7;
        }
        if (laneDirectionCategory.uTurnRight) {
            return 8;
        }
        CLog.d(str, "getGuideImg no lane show!");
        return -1;
    }

    public final void w1() {
        LanguageCode z0 = z0();
        this.E.setManeuverNotificationOptions(new ManeuverNotificationOptions(z0, UnitSystem.METRIC));
        String str = P;
        CLog.d(str, "setManeuverNotificationListener() ttsLanguageCode: " + z0);
        this.E.setManeuverNotificationListener(new g(this));
    }

    public boolean x() {
        RoutingError routingError = this.F;
        return routingError != null && routingError == RoutingError.ROUTE_LENGTH_LIMIT_EXCEEDED;
    }

    public ArrayList x0() {
        List B0 = v0().B0();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < B0.size(); i++) {
            arrayList.add(Integer.valueOf(w0((Lane) B0.get(i))));
        }
        return arrayList;
    }

    public void x1(List list) {
        this.I = list;
    }

    public boolean y() {
        return NaviTtsManager.getInstance(this.f5786a).isPlayDone();
    }

    public LanguageCode y0() {
        return LanguageCodeConverter.a(Locale.getDefault());
    }

    public final void y1() {
        CLog.b(P, "setNaviListener()  Enter.");
        E1();
        v1();
        D1();
        u1();
        w1();
        B1();
        t1();
        A1();
        H1();
        G1();
    }

    public boolean z(int i) {
        return CSharedPreferences.b(this.f5786a.getApplicationContext(), "navi_traffic_state", true);
    }

    public LanguageCode z0() {
        List<LanguageCode> availableLanguagesForManeuverNotifications = VisualNavigator.getAvailableLanguagesForManeuverNotifications();
        LanguageCode a2 = LanguageCodeConverter.a(Locale.getDefault());
        if (availableLanguagesForManeuverNotifications.contains(a2)) {
            return a2;
        }
        String str = P;
        CLog.b(str, "No voice skins available for " + a2 + ", falling back to EN_US.");
        return LanguageCode.EN_US;
    }

    public void z1(List list) {
        this.H = list;
    }
}
