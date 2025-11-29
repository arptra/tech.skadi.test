package com.upuphone.ar.navi.lite.fragment;

import android.content.Context;
import android.os.Bundle;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import androidx.fragment.app.Fragment;
import com.honey.account.g4.a;
import com.upuphone.ar.navi.lite.base.PlaceBean;
import com.upuphone.ar.navi.lite.base.Record;
import com.upuphone.ar.navi.lite.base.SearchModel;
import com.upuphone.ar.navi.lite.base.ULatLng;
import com.upuphone.ar.navi.lite.base.ULocation;
import com.upuphone.ar.navi.lite.location.LocationManager;
import com.upuphone.ar.navi.lite.manger.StarryNetManger;
import com.upuphone.ar.navi.lite.search.PoiSearchManager;
import com.upuphone.ar.navi.lite.util.CLog;
import com.upuphone.ar.navi.lite.util.NaviUtil;
import com.upuphone.ar.navi.lite.view.NaviProgressView;
import com.upuphone.xr.interconnect.common.INaviActionResult;
import com.upuphone.xr.interconnect.entity.StarryNetMessage;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class BaseFragment extends Fragment {
    public static final String h = ("NAVI-" + BaseFragment.class.getSimpleName());

    /* renamed from: a  reason: collision with root package name */
    public FragmentActionListener f5760a;
    public NaviProgressView b;
    public boolean c = false;
    public float d = 0.0f;
    public List e = new ArrayList();
    public int f = 1;
    public Set g = new HashSet();

    public interface FragmentActionListener {
        void a(SearchModel searchModel, boolean z, int i, int i2);
    }

    public static /* synthetic */ void z0(SearchModel searchModel, List list) {
        if (list != null && list.size() > 0) {
            searchModel.setCity(((PlaceBean) list.get(0)).getCity());
        }
    }

    public void A0(boolean z) {
        String str = h;
        CLog.b(str, "onAssistantWakeupChanged  Enter. isWakeup=" + z);
    }

    public void B0(boolean z) {
        String str = h;
        CLog.b(str, "onBleConnectState  Enter. connected=" + z);
    }

    public void C0(boolean z) {
        String str = h;
        CLog.b(str, "onDeviceConnectState  Enter. isOnline=" + z);
    }

    public void D0() {
        CLog.b(h, "onGpsStateChanged  Enter.");
    }

    public void E0(ULocation uLocation, PlaceBean placeBean) {
        CLog.b(h, "onLocationChanged  Enter.");
    }

    public void F0(StarryNetMessage starryNetMessage) {
        CLog.b(h, "onMessageReceive  Enter.");
    }

    public void G0(boolean z) {
        String str = h;
        CLog.b(str, "onNetConnectState  Enter. isAvailable=" + z);
    }

    public boolean H0(int i) {
        return false;
    }

    public boolean I0() {
        return false;
    }

    public void J0(SearchModel searchModel, int i, boolean z) {
        CLog.b(h, "restartNaviTask  Enter. ");
    }

    public void K0(boolean z) {
        this.c = z;
    }

    public void L0(FragmentActionListener fragmentActionListener) {
        this.f5760a = fragmentActionListener;
    }

    public void M0(boolean z) {
        this.b.setVisibility(z ? 0 : 8);
    }

    public void N0(boolean z) {
        String str = h;
        CLog.b(str, "setNaviSpeak  Enter. isOn=" + z);
    }

    public void O0(List list) {
        this.g.clear();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            this.g.add(((PlaceBean) it.next()).getPoiTypeCode());
        }
    }

    public void P0(boolean z) {
        String str = h;
        CLog.b(str, "setShowMapState  isShowMap=" + z);
    }

    public void Q0(boolean z) {
        String str = h;
        CLog.b(str, "setTrafficEnabled  Enter. enabled=" + z);
    }

    public void R0() {
        CLog.b(h, "stopNavi  Enter.");
    }

    public void S0(SearchModel searchModel, boolean z, int i) {
        String str = h;
        CLog.b(str, "updateFragmentData  direct=" + z);
    }

    public void T0(float f2) {
        this.d = f2;
    }

    public final void U0(SearchModel searchModel, Record record) {
        ULocation g2;
        if (record.j() != -2 && (g2 = LocationManager.f().g()) != null) {
            searchModel.setDistance(Math.round(NaviUtil.e(new ULatLng(g2.getLatitude(), g2.getLongitude()), new ULatLng(record.n(), record.p()))));
        }
    }

    public void h0(int i, INaviActionResult iNaviActionResult) {
        String str = h;
        CLog.b(str, "onDestroy  naviMode=" + i);
    }

    public void i0(int i, INaviActionResult iNaviActionResult) {
        String str = h;
        CLog.b(str, "onDestroy  strategy=" + i);
    }

    public String j0(EditText editText) {
        return (editText == null || editText.getText() == null || editText.getText().toString().trim().equals("")) ? "" : editText.getText().toString().trim();
    }

    public void k0() {
        CLog.b(h, "closeInputMethod  Enter.");
    }

    public void l0() {
        CLog.b(h, "continueNavi  Enter.");
    }

    public SearchModel m0(PlaceBean placeBean) {
        SearchModel searchModel = new SearchModel();
        searchModel.setName(placeBean.getPoiName());
        searchModel.setAcode(placeBean.getAdCode());
        searchModel.setAddress(placeBean.getDistrict() + placeBean.getAddress());
        searchModel.setDistrict(placeBean.getDistrict());
        searchModel.setLatitude(placeBean.getLatitude());
        searchModel.setLongitude(placeBean.getLongitude());
        searchModel.setCity(placeBean.getCity());
        searchModel.setType(0);
        ULocation g2 = LocationManager.f().g();
        if (g2 != null) {
            searchModel.setDistance(Math.round(NaviUtil.e(new ULatLng(g2.getLatitude(), g2.getLongitude()), new ULatLng(placeBean.getLatitude(), placeBean.getLongitude()))));
        }
        searchModel.setAlias(NaviUtil.v(getContext().getApplicationContext(), searchModel));
        return searchModel;
    }

    public SearchModel n0(AutoCompleteTextView autoCompleteTextView, PlaceBean placeBean) {
        SearchModel searchModel = new SearchModel();
        PoiSearchManager.f().c(getContext(), new ULatLng(placeBean.getLatitude(), placeBean.getLongitude()), new a(searchModel));
        searchModel.setName(placeBean.getPoiName());
        searchModel.setAcode(placeBean.getPoiId());
        searchModel.setAddress(placeBean.getDistrict() + placeBean.getAddress());
        searchModel.setDistrict(placeBean.getDistrict());
        searchModel.setKeywords(autoCompleteTextView.getText().toString());
        searchModel.setLatitude(placeBean.getLatitude());
        searchModel.setLongitude(placeBean.getLongitude());
        searchModel.setType(0);
        ULocation g2 = LocationManager.f().g();
        if (g2 != null) {
            searchModel.setDistance(Math.round(NaviUtil.e(new ULatLng(g2.getLatitude(), g2.getLongitude()), new ULatLng(placeBean.getLatitude(), placeBean.getLongitude()))));
        }
        searchModel.setAlias(NaviUtil.v(getContext().getApplicationContext(), searchModel));
        return searchModel;
    }

    public FragmentActionListener o0() {
        return this.f5760a;
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        CLog.b(h, "onAttach  Enter.");
    }

    public void onBackPressed() {
        CLog.b(h, "onBackPressed  ");
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        CLog.b(h, "onCreate  Enter.");
        this.c = StarryNetManger.getInstance().isDeviceConnected();
    }

    public void onDestroy() {
        super.onDestroy();
        CLog.b(h, "onDestroy  Enter.");
    }

    public void onDestroyView() {
        super.onDestroyView();
        CLog.b(h, "onDestroyView  Enter.");
    }

    public void onDetach() {
        super.onDetach();
        CLog.b(h, "onDetach  Enter.");
    }

    public void onPause() {
        super.onPause();
        CLog.b(h, "onPause  Enter.");
    }

    public void onResume() {
        super.onResume();
        CLog.b(h, "onResume  Enter.");
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        CLog.b(h, "onSaveInstanceState  Enter.");
    }

    public void onStart() {
        super.onStart();
        CLog.b(h, "onStart  Enter.");
    }

    public void onStop() {
        super.onStop();
        CLog.b(h, "onStop  Enter.");
    }

    public String s0() {
        return "";
    }

    public SearchModel u0(int i, String str) {
        SearchModel searchModel = new SearchModel();
        searchModel.setName(str);
        searchModel.setType(i);
        return searchModel;
    }

    public SearchModel v0(Record record) {
        SearchModel searchModel = new SearchModel();
        searchModel.setName(record.getName());
        searchModel.setAcode(record.c());
        searchModel.setCity(record.g());
        searchModel.setAddress(record.e());
        searchModel.setDistrict(record.k());
        searchModel.setDistance(record.j());
        searchModel.setLatitude(record.n());
        searchModel.setLongitude(record.p());
        searchModel.setType(1);
        searchModel.setAlias(record.f());
        U0(searchModel, record);
        return searchModel;
    }

    public boolean w0() {
        return this.c;
    }

    public boolean y0() {
        return false;
    }
}
