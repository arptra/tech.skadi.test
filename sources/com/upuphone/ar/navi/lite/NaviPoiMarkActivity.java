package com.upuphone.ar.navi.lite;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.honey.account.d4.s0;
import com.honey.account.d4.t0;
import com.upuphone.ar.navi.lite.adapter.MapPoiListAdapter;
import com.upuphone.ar.navi.lite.base.PlaceBean;
import com.upuphone.ar.navi.lite.base.SearchModel;
import com.upuphone.ar.navi.lite.base.ULatLng;
import com.upuphone.ar.navi.lite.base.ULocation;
import com.upuphone.ar.navi.lite.location.LocationManager;
import com.upuphone.ar.navi.lite.manger.ActivityManager;
import com.upuphone.ar.navi.lite.mapview.BaseMapView;
import com.upuphone.ar.navi.lite.mapview.IMarkerClick;
import com.upuphone.ar.navi.lite.model.ILocation;
import com.upuphone.ar.navi.lite.model.ILocationManager;
import com.upuphone.ar.navi.lite.search.PoiSearchManager;
import com.upuphone.ar.navi.lite.util.CLog;
import com.upuphone.ar.navi.lite.util.DensityUtils;
import com.upuphone.ar.navi.lite.util.LocationUtil;
import com.upuphone.star.common.phone.UToast;
import java.util.ArrayList;
import java.util.List;

public class NaviPoiMarkActivity extends BaseActivity implements ILocation, MapPoiListAdapter.ItemClickListener, IMarkerClick {
    public static final String s = ("NAVI-" + NaviPoiMarkActivity.class.getName());
    public BaseMapView h;
    public FrameLayout i;
    public ConstraintLayout j;
    public boolean k = false;
    public MapPoiListAdapter l;
    public List m = new ArrayList();
    public String n = "";
    public String o = "";
    public boolean p = false;
    public boolean q = false;
    public RecyclerView r;

    private void U0(ULocation uLocation, boolean z) {
        this.h.o(uLocation, this.b, z, true, false);
    }

    private void a1() {
        this.i.addView(DensityUtils.d(this));
    }

    private void b1(Bundle bundle) {
        BaseMapView baseMapView = (BaseMapView) findViewById(R.id.map);
        this.h = baseMapView;
        baseMapView.i(bundle);
        this.i = (FrameLayout) findViewById(R.id.statusBarFrame);
        this.j = (ConstraintLayout) findViewById(R.id.poi_search_layout);
        ((TextView) findViewById(R.id.poi_search_title)).setText(this.q ? R.string.navi_start_position_desp : R.string.navi_end_position_desp);
    }

    /* access modifiers changed from: private */
    /* renamed from: f1 */
    public void c1(List list) {
        if (list != null) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                PlaceBean placeBean = (PlaceBean) list.get(i2);
                SearchModel h2 = PoiSearchManager.f().h(placeBean);
                h2.setKeywords(this.n);
                h2.setType(1);
                CLog.a(s, "onPoiSearched: " + h2);
                this.m.add(h2);
                this.h.b(new ULatLng(placeBean.getLatitude(), placeBean.getLongitude()), i2, 20);
            }
            s(0);
            list.clear();
            CLog.a(s, "onPoiSearched: mapPoiList.size()=" + this.m.size());
            this.j.setVisibility(0);
            this.l.l(this.m);
        }
        this.l.notifyDataSetChanged();
    }

    public void O0(int i2) {
        LocationUtil.e(this, i2, new LocationUtil.LocationCallback() {
            public void a() {
                UToast.e(NaviPoiMarkActivity.this.getApplicationContext(), R.string.open_gps_title, 1);
            }

            public void b() {
            }
        });
    }

    public void R0(float f) {
        runOnUiThread(new t0(this, f));
    }

    public void V0() {
        ULocation g = LocationManager.f().g();
        if (g == null) {
            CLog.b(s, " doPoiQuery() location object is null. ");
            return;
        }
        String city = g.getCity();
        ULatLng uLatLng = new ULatLng(g.getLatitude(), g.getLongitude());
        String str = s;
        CLog.b(str, " doSearchQuery() typeCode=" + this.o + "  needSort=" + this.p + " city=" + city + " latLng=" + uLatLng.toString());
        PoiSearchManager.f().k(1);
        PoiSearchManager.f().d(getApplicationContext(), city, this.n, "", uLatLng, 2, this.p, new s0(this));
    }

    public final void W0() {
        Intent intent = getIntent();
        if (intent != null) {
            this.n = intent.getStringExtra("ext_keyword");
            this.o = intent.getStringExtra("type_code");
            this.p = intent.getBooleanExtra("need_sort", this.p);
            this.q = intent.getBooleanExtra("is_start", false);
        }
    }

    public final void X0() {
        this.r = (RecyclerView) findViewById(R.id.poi_search_recycler);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, 1);
        dividerItemDecoration.setDrawable(getDrawable(R.drawable.divider_bg));
        this.r.addItemDecoration(dividerItemDecoration);
        this.r.setLayoutManager(new LinearLayoutManager(this));
        MapPoiListAdapter mapPoiListAdapter = new MapPoiListAdapter(this, this.m);
        this.l = mapPoiListAdapter;
        mapPoiListAdapter.m(this);
        this.r.setAdapter(this.l);
    }

    public final void Y0() {
        this.h.f();
        this.h.setOnMarkerClickListener(this);
    }

    public final void Z0() {
        I0();
        ILocationManager.b().a(this);
    }

    public void d(RecyclerView recyclerView, View view, int i2, SearchModel searchModel) {
        String str = s;
        CLog.b(str, " onItemClick() position=" + i2 + "  data=" + searchModel.toString());
        e1(searchModel);
    }

    public final /* synthetic */ void d1(float f) {
        ULocation g = LocationManager.f().g();
        if (g != null) {
            g.setBearing(((double) f) * 1.0d);
            this.h.p(g, false, false);
        }
    }

    public final void e1(SearchModel searchModel) {
        Intent intent = new Intent();
        intent.putExtra("result_data", searchModel);
        setResult(2000, intent);
        finish();
    }

    public void initViewModel() {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ActivityManager.getInstance().add(this);
        setContentView(R.layout.activity_navi_poi_mark);
        W0();
        b1(bundle);
        a1();
        Y0();
        X0();
        Z0();
        V0();
    }

    public void onDestroy() {
        super.onDestroy();
        ActivityManager.getInstance().remove(this);
        this.h.j();
        ILocationManager.b().d(this);
    }

    public void onPause() {
        super.onPause();
        this.h.k();
    }

    public void onResume() {
        super.onResume();
        this.h.l();
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.h.m(bundle);
    }

    public void q(ULocation uLocation, PlaceBean placeBean) {
        if (uLocation != null && !this.k) {
            this.k = true;
            O0(1003);
        }
        if (uLocation != null && uLocation.getErrorCode() == 0) {
            U0(uLocation, false);
        }
    }

    public void s(int i2) {
        ((LinearLayoutManager) this.r.getLayoutManager()).scrollToPositionWithOffset(i2, 0);
        this.l.n(i2);
        this.l.notifyDataSetChanged();
    }
}
