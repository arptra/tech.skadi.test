package com.upuphone.ar.navi.lite.mapview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.AttributeSet;
import com.here.sdk.core.Anchor2D;
import com.here.sdk.core.GeoCoordinates;
import com.here.sdk.core.LanguageCode;
import com.here.sdk.core.Location;
import com.here.sdk.core.Metadata;
import com.here.sdk.core.Point2D;
import com.here.sdk.core.Rectangle2D;
import com.here.sdk.core.Size2D;
import com.here.sdk.mapview.LocationIndicator;
import com.here.sdk.mapview.MapError;
import com.here.sdk.mapview.MapFeatureModes;
import com.here.sdk.mapview.MapFeatures;
import com.here.sdk.mapview.MapImage;
import com.here.sdk.mapview.MapImageFactory;
import com.here.sdk.mapview.MapMarker;
import com.here.sdk.mapview.MapMeasure;
import com.here.sdk.mapview.MapScene;
import com.here.sdk.mapview.MapScheme;
import com.here.sdk.mapview.MapView;
import com.here.sdk.mapview.PickMapContentResult;
import com.here.sdk.mapview.PickMapItemsResult;
import com.honey.account.i4.a;
import com.honey.account.i4.b;
import com.honey.account.i4.c;
import com.honey.account.i4.d;
import com.honey.account.i4.e;
import com.upuphone.ar.navi.lite.R;
import com.upuphone.ar.navi.lite.base.PlaceBean;
import com.upuphone.ar.navi.lite.base.ULatLng;
import com.upuphone.ar.navi.lite.base.ULocation;
import com.upuphone.ar.navi.lite.location.LocationManager;
import com.upuphone.ar.navi.lite.navi.HereNaviManager;
import com.upuphone.ar.navi.lite.util.CLog;
import com.upuphone.ar.navi.lite.util.NaviUtil;
import com.upuphone.ar.navi.lite.util.SensorEventHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class HereMapView extends MapView implements IMapView {
    public static final String f = ("NAVI-" + HereMapView.class.getSimpleName());

    /* renamed from: a  reason: collision with root package name */
    public MapMarker f5781a;
    public LocationIndicator b;
    public ArrayList c = new ArrayList();
    public boolean d = false;
    public int e = 0;

    public HereMapView(Context context) {
        super(context);
    }

    public static Bitmap p(Context context, int i, String str, boolean z) {
        try {
            Resources resources = context.getResources();
            float f2 = resources.getDisplayMetrics().density;
            Bitmap decodeResource = BitmapFactory.decodeResource(resources, i);
            Bitmap.Config config = decodeResource.getConfig();
            if (config == null) {
                config = Bitmap.Config.ARGB_8888;
            }
            Bitmap copy = decodeResource.copy(config, true);
            String str2 = f;
            CLog.b(str2, "getTextBitmap  scale=" + f2 + " bitmap.getWidth=" + copy.getWidth() + " bitmap.getHeight=" + copy.getHeight());
            Canvas canvas = new Canvas(copy);
            Paint paint = new Paint(1);
            paint.setColor(-1);
            paint.setTextSize(f2 * (z ? 17.0f : 10.0f));
            Rect rect = new Rect();
            paint.getTextBounds(str, 0, str.length(), rect);
            canvas.drawText(str, (float) ((copy.getWidth() / 2) - (rect.width() / 2)), (float) ((copy.getHeight() / 2) + (rect.height() / 10)), paint);
            return copy;
        } catch (Exception unused) {
            return null;
        }
    }

    public static /* synthetic */ void s(IPoiClickListener iPoiClickListener, PickMapContentResult pickMapContentResult) {
        PickMapContentResult.PoiResult poiResult;
        if (pickMapContentResult == null) {
            CLog.b("onPickMapContent", "An error occurred while performing the pick operation.");
        } else if (pickMapContentResult.getPois() != null && pickMapContentResult.getPois().size() > 0 && (poiResult = pickMapContentResult.getPois().get(0)) != null) {
            PlaceBean placeBean = new PlaceBean();
            placeBean.setLatitude(poiResult.coordinates.latitude);
            placeBean.setLongitude(poiResult.coordinates.longitude);
            placeBean.setPoiName(poiResult.name);
            if (iPoiClickListener != null) {
                iPoiClickListener.a(placeBean);
            }
        }
    }

    private void setMarkSelect(int i) {
        String str = f;
        CLog.b(str, " setMarkSelect() index=" + i + " selected=" + this.e);
        F(this.e, false);
        this.e = i;
        F(i, true);
    }

    public final void A(GeoCoordinates geoCoordinates) {
        if (isValid()) {
            getCamera().lookAt(geoCoordinates, new MapMeasure(MapMeasure.Kind.DISTANCE, 2000.0d));
        }
    }

    public void B(Bundle bundle) {
        onCreate(bundle);
    }

    /* renamed from: C */
    public final void v(Point2D point2D, IPoiClickListener iPoiClickListener) {
        pickMapContent(new Rectangle2D(point2D, new Size2D(50.0d, 50.0d)), new d(iPoiClickListener));
    }

    /* renamed from: D */
    public final void u(Point2D point2D, IMarkerClick iMarkerClick) {
        pickMapItems(point2D, (double) 2.0f, new e(this, iMarkerClick));
    }

    public final void E() {
        this.f5781a = null;
        this.d = false;
    }

    public final void F(int i, boolean z) {
        MapMarker mapMarker = (MapMarker) this.c.get(i);
        getMapScene().removeMapMarker(mapMarker);
        MapMarker mapMarker2 = new MapMarker(mapMarker.getCoordinates(), o(z, (i + 1) + ""));
        Metadata metadata = new Metadata();
        metadata.setInteger("metadata_index_key", this.e);
        mapMarker2.setMetadata(metadata);
        getMapScene().addMapMarker(mapMarker2);
        this.c.add(i, mapMarker2);
        this.c.remove(mapMarker);
    }

    public boolean G(boolean z) {
        boolean containsKey = getMapScene().getActiveFeatures().containsKey(MapFeatures.TRAFFIC_FLOW);
        String str = f;
        CLog.b(str, "setTrafficStatus  enabled=" + containsKey + " status=" + z);
        if (z) {
            HashMap hashMap = new HashMap();
            hashMap.put(MapFeatures.TRAFFIC_FLOW, MapFeatureModes.TRAFFIC_FLOW_WITH_FREE_FLOW);
            getMapScene().enableFeatures(hashMap);
        } else {
            ArrayList arrayList = new ArrayList();
            arrayList.add(MapFeatures.TRAFFIC_FLOW);
            getMapScene().disableFeatures(arrayList);
        }
        return containsKey;
    }

    public final void H(Location location, boolean z, boolean z2) {
        if (location != null) {
            if (this.b == null) {
                LocationIndicator locationIndicator = new LocationIndicator();
                this.b = locationIndicator;
                locationIndicator.setAccuracyVisualized(true);
                this.b.setLocationIndicatorStyle(z2 ? LocationIndicator.IndicatorStyle.NAVIGATION : LocationIndicator.IndicatorStyle.PEDESTRIAN);
            }
            if (NaviUtil.u0()) {
                this.b.disable();
            } else {
                this.b.enable(this);
            }
            this.b.updateLocation(location);
            if (z) {
                z(this);
            }
        }
    }

    public void I(ULocation uLocation, SensorEventHelper sensorEventHelper, boolean z, boolean z2, boolean z3) {
        if (z) {
            if (this.f5781a != null) {
                getMapScene().removeMapMarker(this.f5781a);
            }
            E();
        }
        if (!this.d) {
            this.d = true;
            H(n(uLocation), z2, z3);
        }
    }

    public void J(ULocation uLocation, boolean z, boolean z2) {
        H(n(uLocation), z, z2);
    }

    public boolean getTrafficstatus() {
        return getMapScene().getActiveFeatures().containsKey(MapFeatures.TRAFFIC_FLOW);
    }

    public void i(ULatLng uLatLng) {
        if (this.f5781a != null) {
            getMapScene().removeMapMarker(this.f5781a);
        }
        this.f5781a = new MapMarker(new GeoCoordinates(uLatLng.getLatitude(), uLatLng.getLongitude()), MapImageFactory.fromResource(getResources(), R.drawable.poi_mark), new Anchor2D(0.5d, 1.0d));
        getMapScene().addMapMarker(this.f5781a);
    }

    public void j(ULatLng uLatLng, int i) {
        MapMarker mapMarker = new MapMarker(new GeoCoordinates(uLatLng.getLatitude(), uLatLng.getLongitude()), MapImageFactory.fromResource(getResources(), i), new Anchor2D(0.5d, 1.0d));
        getMapScene().addMapMarker(mapMarker);
        this.c.add(mapMarker);
    }

    public int k(ULatLng uLatLng, int i, int i2) {
        GeoCoordinates geoCoordinates = new GeoCoordinates(uLatLng.getLatitude(), uLatLng.getLongitude());
        boolean z = i == 0;
        MapMarker mapMarker = new MapMarker(geoCoordinates, o(z, (i + 1) + ""));
        Metadata metadata = new Metadata();
        metadata.setInteger("metadata_index_key", i);
        mapMarker.setMetadata(metadata);
        getMapScene().addMapMarker(mapMarker);
        this.c.add(mapMarker);
        return i;
    }

    public void l(ULatLng uLatLng) {
        if (uLatLng != null) {
            MapMarker mapMarker = new MapMarker(new GeoCoordinates(uLatLng.getLatitude(), uLatLng.getLongitude()), MapImageFactory.fromResource(getResources(), R.drawable.poi_mark_small), new Anchor2D(0.5d, 1.0d));
            getMapScene().addMapMarker(mapMarker);
            this.c.add(mapMarker);
        }
    }

    public void m() {
        if (this.f5781a != null) {
            getMapScene().removeMapMarker(this.f5781a);
        }
        Iterator it = this.c.iterator();
        while (it.hasNext()) {
            getMapScene().removeMapMarker((MapMarker) it.next());
        }
    }

    public final Location n(ULocation uLocation) {
        Location location = new Location(new GeoCoordinates(uLocation.getLatitude(), uLocation.getLongitude()));
        location.bearingInDegrees = Double.valueOf(uLocation.getBearing());
        location.horizontalAccuracyInMeters = Double.valueOf(uLocation.getAccuracy());
        return location;
    }

    public final MapImage o(boolean z, String str) {
        return MapImageFactory.fromBitmap(p(getContext(), z ? R.drawable.poi_mark_l : R.drawable.poi_mark_s, str, z));
    }

    public void q() {
        if (isValid()) {
            LanguageCode y0 = HereNaviManager.v0().y0();
            String str = f;
            CLog.d(str, "initMap  languageCode: " + y0);
            MapView.setPrimaryLanguage(y0);
            try {
                getMapScene().loadScene(NaviUtil.E0(getContext()) ? MapScheme.NORMAL_NIGHT : MapScheme.NORMAL_DAY, (MapScene.LoadSceneCallback) new a(this));
            } catch (Exception e2) {
                String str2 = f;
                CLog.d(str2, "loadMapScene exception: " + e2);
            }
        }
    }

    public final /* synthetic */ void r(MapError mapError) {
        String str = f;
        CLog.d(str, "onLoadScene  mapError: " + mapError);
        if (mapError == null) {
            z(this);
            return;
        }
        CLog.d(str, "Loading map failed: mapError: " + mapError.name());
    }

    public void setCameraChangeListener(ICameraChangeListener iCameraChangeListener) {
    }

    public void setOnMarkerClickListener(IMarkerClick iMarkerClick) {
        getGestures().setTapListener(new c(this, iMarkerClick));
    }

    public void setPoiClickListener(IPoiClickListener iPoiClickListener) {
        getGestures().setTapListener(new b(this, iPoiClickListener));
    }

    public final /* synthetic */ void t(IMarkerClick iMarkerClick, PickMapItemsResult pickMapItemsResult) {
        if (pickMapItemsResult != null) {
            List<MapMarker> markers = pickMapItemsResult.getMarkers();
            if (markers.size() != 0) {
                MapMarker mapMarker = markers.get(0);
                int intValue = mapMarker.getMetadata().getInteger("metadata_index_key").intValue();
                String str = f;
                CLog.b(str, "onPickMapItems() latitude=" + mapMarker.getCoordinates().latitude + ", longitude=" + mapMarker.getCoordinates().longitude + " index=" + intValue);
                if (iMarkerClick != null) {
                    iMarkerClick.s(intValue);
                }
                setMarkSelect(intValue);
                A(mapMarker.getCoordinates());
            }
        }
    }

    public void w() {
        LocationIndicator locationIndicator = this.b;
        if (locationIndicator != null) {
            locationIndicator.disable();
        }
    }

    public void x() {
        LocationIndicator locationIndicator = this.b;
        if (locationIndicator != null) {
            locationIndicator.enable(this);
        }
    }

    public void y(ULatLng uLatLng) {
        if (isValid()) {
            getCamera().lookAt(new GeoCoordinates(uLatLng.latitude, uLatLng.longitude), new MapMeasure(MapMeasure.Kind.DISTANCE, 2000.0d));
        }
    }

    public final void z(MapView mapView) {
        ULocation g = LocationManager.f().g();
        if (g != null && mapView != null && mapView.isValid()) {
            mapView.getCamera().lookAt(new GeoCoordinates(g.getLatitude(), g.getLongitude()), new MapMeasure(MapMeasure.Kind.DISTANCE, 2000.0d));
        }
    }

    public HereMapView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public HereMapView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
