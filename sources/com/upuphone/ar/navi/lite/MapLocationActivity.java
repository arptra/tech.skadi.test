package com.upuphone.ar.navi.lite;

import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationSet;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.honey.account.d4.a0;
import com.honey.account.d4.b0;
import com.honey.account.d4.c0;
import com.honey.account.d4.d0;
import com.honey.account.d4.z;
import com.upuphone.ar.navi.lite.adapter.MapPoiListAdapter;
import com.upuphone.ar.navi.lite.base.BaseViewModel;
import com.upuphone.ar.navi.lite.base.CommonAddress;
import com.upuphone.ar.navi.lite.base.PlaceBean;
import com.upuphone.ar.navi.lite.base.SearchModel;
import com.upuphone.ar.navi.lite.base.ULatLng;
import com.upuphone.ar.navi.lite.base.ULocation;
import com.upuphone.ar.navi.lite.location.LocationManager;
import com.upuphone.ar.navi.lite.manger.ActivityManager;
import com.upuphone.ar.navi.lite.mapview.BaseMapView;
import com.upuphone.ar.navi.lite.mapview.ICameraChangeListener;
import com.upuphone.ar.navi.lite.model.ILocation;
import com.upuphone.ar.navi.lite.model.ILocationManager;
import com.upuphone.ar.navi.lite.search.PoiSearchManager;
import com.upuphone.ar.navi.lite.util.CLog;
import com.upuphone.ar.navi.lite.util.DensityUtils;
import com.upuphone.ar.navi.lite.util.LocationUtil;
import com.upuphone.ar.navi.lite.view.ContentRecyclerView;
import com.upuphone.ar.navi.lite.view.ScrollLayout;
import com.upuphone.ar.navi.lite.view.TitleView;
import com.upuphone.star.common.phone.UToast;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MapLocationActivity extends BaseActivity implements ICameraChangeListener, MapPoiListAdapter.ItemClickListener, ScrollLayout.OnScrollChangedListener, ILocation {
    public static final String u = ("NAVI-" + MapLocationActivity.class.getSimpleName());
    public BaseMapView h;
    public MapPoiListAdapter i;
    public List j = new ArrayList();
    public boolean k;
    public String l = "";
    public String m = "";
    public boolean n = true;
    public boolean o = false;
    public AnimationSet p;
    public TextView q;
    public FrameLayout r;
    public ScrollLayout s;
    public ContentRecyclerView t;

    /* access modifiers changed from: private */
    public /* synthetic */ void i1(View view) {
        O0(1003);
    }

    private void initData() {
        this.l = getIntent().getStringExtra("MODEL");
        this.m = getIntent().getStringExtra("name").trim();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void j1(View view) {
        a1();
    }

    private void w1(SearchModel searchModel) {
        CommonAddress commonAddress = new CommonAddress();
        commonAddress.q(searchModel.getCity());
        commonAddress.o(searchModel.getAddress());
        commonAddress.n(searchModel.getAcode());
        commonAddress.p(this.l);
        commonAddress.t(searchModel.getLatitude());
        commonAddress.u(searchModel.getLongitude());
        commonAddress.s(searchModel.getDistrict());
        commonAddress.v(PoiSearchManager.f().i(searchModel.getName()) ? searchModel.getAddress() : searchModel.getName());
        commonAddress.x(System.currentTimeMillis());
        this.f5635a.d().c(commonAddress);
        setResult(1);
        finish();
    }

    public void H(float f) {
    }

    public void I(int i2) {
    }

    public void O0(int i2) {
        LocationUtil.e(this, i2, new LocationUtil.LocationCallback() {
            public void a() {
                UToast.e(MapLocationActivity.this.getApplicationContext(), R.string.open_gps_title, 1);
            }

            public void b() {
                ULocation g = LocationManager.f().g();
                if (g != null) {
                    MapLocationActivity.this.h.h(new ULatLng(g.getLatitude(), g.getLongitude()));
                }
            }
        });
    }

    public void R0(float f) {
        runOnUiThread(new d0(this, f));
    }

    public final void Y0(ULocation uLocation, boolean z) {
        this.h.o(uLocation, this.b, z, true, false);
    }

    public final void Z0(SearchModel searchModel) {
        this.h.a(new ULatLng(searchModel.getLatitude(), searchModel.getLongitude()));
    }

    public void a1() {
        this.q.setVisibility(8);
    }

    public final void b1(List list) {
        if (PoiSearchManager.f().e() > 1) {
            this.i.notifyDataSetChanged();
            return;
        }
        if (this.j.size() == 0) {
            m1(getString(R.string.poi_search_none), false);
        } else {
            Z0((SearchModel) this.j.get(0));
            n1((SearchModel) this.j.get(0));
        }
        SearchModel searchModel = (SearchModel) this.j.get(this.j.size() - 1);
        if (this.j.size() < 10 && searchModel.getType() == 0 && list.size() == 0) {
            CLog.a(u, "onPoiSearched: VIEW_TYPE_NO_RECORD");
            SearchModel searchModel2 = new SearchModel();
            searchModel2.setType(3);
            this.j.add(searchModel2);
        }
        this.i.notifyDataSetChanged();
        this.s.setMaxOffset(DensityUtils.b(this) / 2);
        this.s.u();
    }

    public final void c1() {
        this.p = new AnimationSet(true);
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 359.0f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setRepeatCount(-1);
        rotateAnimation.setStartOffset(0);
        rotateAnimation.setDuration(1000);
        this.p.setInterpolator(new LinearInterpolator());
        this.p.addAnimation(rotateAnimation);
    }

    public void d(RecyclerView recyclerView, View view, int i2, SearchModel searchModel) {
        String str = u;
        CLog.a(str, "onItemClick getType=" + searchModel.getType());
        if (searchModel.getType() == 0) {
            w1(searchModel);
        } else if (searchModel.getType() == 2) {
            PoiSearchManager.f().k(PoiSearchManager.f().e() + 1);
            q1(LocationManager.f().g());
        }
    }

    public final void d1() {
        this.h.f();
        this.h.setCameraChangeListener(this);
        o1();
        this.h.setPoiClickListener(new a0(this));
    }

    public final void e1() {
        ScrollLayout scrollLayout = (ScrollLayout) findViewById(R.id.layout_scroll);
        this.s = scrollLayout;
        scrollLayout.setVisibility(0);
        this.s.setMinOffset(0);
        this.s.setIsSupportExit(false);
        this.s.setAllowHorizontalScroll(true);
        this.s.t();
        this.s.setOnScrollChangedListener(this);
        this.t = (ContentRecyclerView) findViewById(R.id.search_result_recycler);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, 1);
        dividerItemDecoration.setDrawable(getDrawable(R.drawable.divider_bg));
        this.t.addItemDecoration(dividerItemDecoration);
        this.t.setLayoutManager(new LinearLayoutManager(this));
        MapPoiListAdapter mapPoiListAdapter = new MapPoiListAdapter(this, this.j);
        this.i = mapPoiListAdapter;
        mapPoiListAdapter.m(this);
        this.t.setAdapter(this.i);
        PoiSearchManager.f().k(1);
        q1(LocationManager.f().g());
    }

    public final void f1() {
        this.r.addView(DensityUtils.d(this));
    }

    public final void g1(Bundle bundle) {
        BaseMapView baseMapView = (BaseMapView) findViewById(R.id.map);
        this.h = baseMapView;
        baseMapView.i(bundle);
        this.r = (FrameLayout) findViewById(R.id.location_statusBarFrame);
        findViewById(R.id.my_location).setOnClickListener(new b0(this));
        ((TitleView) findViewById(R.id.title_panel)).setTitleSummary(this.m);
        ((TitleView) findViewById(R.id.title_panel)).setTitleName("");
        TextView textView = (TextView) findViewById(R.id.reload);
        this.q = textView;
        textView.setOnClickListener(new c0(this));
    }

    public void initViewModel() {
        BaseViewModel baseViewModel = new BaseViewModel(getString(R.string.map_location));
        this.c = baseViewModel;
        baseViewModel.c(false);
    }

    public final /* synthetic */ void k1(List list) {
        if (list == null) {
            m1(getString(R.string.poi_search_reload), true);
            this.i.notifyDataSetChanged();
            return;
        }
        u1();
        String str = u;
        CLog.a(str, "onPlaceSearched list.size()=" + list.size());
        v1();
        s1(list);
        b1(list);
        list.clear();
    }

    public final /* synthetic */ void l1(float f) {
        ULocation g = LocationManager.f().g();
        if (g != null && this.h != null) {
            g.setBearing(((double) f) * 1.0d);
            this.h.p(g, false, false);
        }
    }

    public final void m1(String str, boolean z) {
        this.q.setText(str);
        this.q.setVisibility(0);
        this.q.setClickable(z);
        this.q.setTextColor(getColor(z ? R.color.text_blue : R.color.text_black));
    }

    public final void n1(SearchModel searchModel) {
        if (searchModel != null) {
            this.h.h(new ULatLng(searchModel.getLatitude(), searchModel.getLongitude()));
        }
    }

    public void o1() {
        this.k = false;
        this.n = false;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ActivityManager.getInstance().add(this);
        setContentView(R.layout.activity_map_location);
        ILocationManager.b().a(this);
        initData();
        g1(bundle);
        d1();
        f1();
        e1();
        I0();
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

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
    }

    public void p(ScrollLayout.Status status) {
    }

    /* renamed from: p1 */
    public final void h1(PlaceBean placeBean) {
        PoiSearchManager.f().k(1);
        r1(placeBean.getCity(), placeBean.getLatitude(), placeBean.getLongitude());
    }

    public void q(ULocation uLocation, PlaceBean placeBean) {
        if (uLocation != null && !this.o) {
            this.o = true;
            O0(1003);
        }
        if (uLocation != null && uLocation.getErrorCode() == 0) {
            Y0(uLocation, false);
        }
    }

    public void q1(ULocation uLocation) {
        if (uLocation != null) {
            t1();
            r1(uLocation.getCity(), uLocation.getLatitude(), uLocation.getLongitude());
        }
    }

    public final void r1(String str, double d, double d2) {
        double d3 = d;
        double d4 = d2;
        String str2 = u;
        CLog.a(str2, "searchPoi  city=" + str + " latitude=" + d3 + " longitude=" + d4);
        PoiSearchManager.f().d(getApplicationContext(), str, this.m, "", new ULatLng(d3, d4), 1, false, new z(this));
    }

    public final void s1(List list) {
        int e = PoiSearchManager.f().e();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            SearchModel h2 = PoiSearchManager.f().h((PlaceBean) it.next());
            h2.setKeywords(this.m);
            h2.setType(0);
            this.j.add(h2);
        }
        String str = u;
        CLog.d(str, "setResultData: mapPoiList.size()=" + this.j.size() + " list.size()=" + list.size() + " curPage=" + e);
        if (list.size() < 10) {
            CLog.d(str, "setResultData: VIEW_TYPE_NO_RECORD");
            SearchModel searchModel = new SearchModel();
            searchModel.setType(3);
            this.j.add(searchModel);
        } else {
            SearchModel searchModel2 = new SearchModel();
            searchModel2.setType(2);
            this.j.add(searchModel2);
        }
        this.i.l(this.j);
    }

    public final void t1() {
        if (this.p == null) {
            c1();
        }
        this.q.setVisibility(8);
    }

    public final void u1() {
        if (this.p == null) {
            c1();
        }
        this.p.cancel();
    }

    public final void v1() {
        int e = PoiSearchManager.f().e();
        String str = u;
        CLog.a(str, "updataListData curPage=" + e);
        if (e == 1) {
            this.j.clear();
            return;
        }
        int size = this.j.size() - 1;
        SearchModel searchModel = (SearchModel) this.j.get(size);
        if (searchModel.getType() == 2 || searchModel.getType() == 3) {
            this.j.remove(size);
        }
    }
}
