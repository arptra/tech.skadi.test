package com.upuphone.ar.navi.lite;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AutoCompleteTextView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.honey.account.d4.h;
import com.honey.account.d4.i;
import com.honey.account.d4.j;
import com.honey.account.d4.k;
import com.honey.account.d4.l;
import com.honey.account.d4.m;
import com.honey.account.d4.n;
import com.honey.account.d4.o;
import com.honey.account.d4.p;
import com.honey.account.d4.q;
import com.honey.account.d4.r;
import com.honey.account.d4.s;
import com.honey.account.d4.t;
import com.upuphone.ar.navi.lite.adapter.HistoryListAdapter;
import com.upuphone.ar.navi.lite.base.BaseViewModel;
import com.upuphone.ar.navi.lite.base.CommonAddress;
import com.upuphone.ar.navi.lite.base.PlaceBean;
import com.upuphone.ar.navi.lite.base.Record;
import com.upuphone.ar.navi.lite.base.SearchModel;
import com.upuphone.ar.navi.lite.base.ULatLng;
import com.upuphone.ar.navi.lite.base.ULocation;
import com.upuphone.ar.navi.lite.location.LocationManager;
import com.upuphone.ar.navi.lite.manger.ActivityManager;
import com.upuphone.ar.navi.lite.manger.NaviOperatorManager;
import com.upuphone.ar.navi.lite.search.PoiSearchManager;
import com.upuphone.ar.navi.lite.util.CLog;
import com.upuphone.ar.navi.lite.util.JsonUtil;
import com.upuphone.ar.navi.lite.util.LocationUtil;
import com.upuphone.ar.navi.lite.util.NaviUtil;
import com.upuphone.ar.navi.lite.view.CustomDialog;
import com.upuphone.star.common.phone.UToast;
import io.reactivex.rxjava3.annotations.SchedulerSupport;
import java.util.ArrayList;
import java.util.List;

public class AddressSettingActivity extends BaseActivity implements HistoryListAdapter.ItemClickListener, TextWatcher {
    public static final String p = ("NAVI-" + AddressSettingActivity.class.getSimpleName());
    public RecyclerView h;
    public HistoryListAdapter i;
    public LinearLayout j;
    public AutoCompleteTextView k;
    public String l = "";
    public String m = "";
    public List n = new ArrayList();
    public int o = 1;

    /* access modifiers changed from: private */
    public /* synthetic */ void H1(View view) {
        k1();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void I1(View view) {
        j1();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void J1(View view) {
        O0(1003);
    }

    private void initView() {
        ((TextView) findViewById(R.id.text_title)).setText(x1(this.l));
        this.j = (LinearLayout) findViewById(R.id.right_menu_layout);
        AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) findViewById(R.id.keyWord);
        this.k = autoCompleteTextView;
        autoCompleteTextView.addTextChangedListener(this);
        this.k.setHint(p1(this.l));
        this.k.setOnEditorActionListener(new l(this));
        findViewById(R.id.content_clean).setOnClickListener(new m(this));
        findViewById(R.id.address_search).setOnClickListener(new n(this));
        findViewById(R.id.btn_my_loc).setOnClickListener(new o(this));
        findViewById(R.id.top_action_bar).setOnTouchListener(new p(this));
        findViewById(R.id.addressSettingLayout).setOnTouchListener(new q(this));
    }

    private SearchModel v1(int i2, String str) {
        SearchModel searchModel = new SearchModel();
        searchModel.setName(str);
        searchModel.setType(i2);
        return searchModel;
    }

    public final boolean A1(int i2) {
        if (i2 != 6) {
            return false;
        }
        j1();
        return false;
    }

    /* renamed from: B1 */
    public final void M1(List list) {
        String str = p;
        CLog.b(str, "inputTipQueryResult  default. list.size()=" + list.size());
        if (TextUtils.isEmpty(this.k.getText().toString())) {
            CLog.b(str, "inputTipQueryResult() @@@@@@@@@@@");
            this.i.k().clear();
            R1(r1());
            return;
        }
        o1(list);
    }

    public final /* synthetic */ void D1(CustomDialog customDialog, View view) {
        customDialog.dismiss();
        l1();
    }

    public final /* synthetic */ void E1(List list) {
        CLog.b(p, "getPositionPoi  onRegeocodeSearched");
        if (list != null && list.size() > 0) {
            Q1(s1((PlaceBean) list.get(0)));
            list.clear();
        }
    }

    public void F0() {
        super.F0();
    }

    public final /* synthetic */ boolean F1(View view, MotionEvent motionEvent) {
        return S1();
    }

    public final /* synthetic */ boolean G1(TextView textView, int i2, KeyEvent keyEvent) {
        return A1(i2);
    }

    public final /* synthetic */ boolean K1(View view, MotionEvent motionEvent) {
        return S1();
    }

    public final /* synthetic */ boolean L1(View view, MotionEvent motionEvent) {
        return S1();
    }

    public void O0(final int i2) {
        if (!NaviUtil.D0(this)) {
            UToast.e(getApplicationContext(), R.string.network_no_available, 1);
        } else {
            LocationUtil.e(this, i2, new LocationUtil.LocationCallback() {
                public void a() {
                    UToast.e(AddressSettingActivity.this.getApplicationContext(), R.string.open_gps_title, 1);
                }

                public void b() {
                    int i = i2;
                    if (i == 1003) {
                        AddressSettingActivity.this.u1();
                    } else if (i == 1004) {
                        Intent intent = new Intent(AddressSettingActivity.this, MapLocationActivity.class);
                        intent.putExtra("MODEL", AddressSettingActivity.this.l);
                        intent.putExtra("name", AddressSettingActivity.this.k.getText().toString());
                        AddressSettingActivity.this.startActivityForResult(intent, 1000);
                    }
                }
            });
        }
    }

    public final /* synthetic */ void O1(CustomDialog customDialog, SearchModel searchModel, View view) {
        customDialog.dismiss();
        B0(searchModel.getName(), searchModel.getAddress());
        T1(searchModel);
    }

    public final void P1() {
        List r1 = r1();
        String str = p;
        CLog.a(str, "clickContentClean: " + r1.size());
        R1(r1);
    }

    public final void Q1(SearchModel searchModel) {
        if (NaviUtil.P0(this, searchModel, this.l)) {
            CustomDialog customDialog = new CustomDialog(this);
            customDialog.j(NaviUtil.A(this, searchModel, true, this.l)).i(NaviUtil.A(this, searchModel, false, this.l)).e(getString(17039360), new s(customDialog)).f(getString(17039370), new t(this, customDialog, searchModel)).show();
        } else if (y1(this.l, searchModel)) {
            UToast.e(getApplicationContext(), R.string.addr_has_added, 1);
            finish();
        } else {
            T1(searchModel);
        }
    }

    public final void R1(List list) {
        this.i.u(list);
        this.i.notifyDataSetChanged();
    }

    public boolean S1() {
        CLog.b(p, "touchCloseInputMethod");
        closeInputMethod();
        return false;
    }

    public final void T1(SearchModel searchModel) {
        String str;
        CommonAddress commonAddress = new CommonAddress();
        commonAddress.q(searchModel.getCity());
        commonAddress.o(searchModel.getAddress());
        commonAddress.n(searchModel.getAcode());
        if (this.l.equals(SchedulerSupport.CUSTOM)) {
            str = "custom_" + System.currentTimeMillis();
        } else {
            str = this.l;
        }
        commonAddress.p(str);
        commonAddress.t(searchModel.getLatitude());
        commonAddress.u(searchModel.getLongitude());
        commonAddress.s(searchModel.getDistrict());
        commonAddress.v(PoiSearchManager.f().i(searchModel.getName()) ? searchModel.getAddress() : searchModel.getName());
        commonAddress.x(System.currentTimeMillis());
        this.f5635a.d().c(commonAddress);
        this.k.setText(commonAddress.j());
        setResult(1);
        UToast.g(getApplicationContext(), getString(TextUtils.isEmpty(this.m) ? R.string.add_addr_success : R.string.update_addr_success), 1);
        startActivity(new Intent(this, AddressActivity.class));
        finish();
    }

    public void afterTextChanged(Editable editable) {
    }

    public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
    }

    public void closeInputMethod() {
        CLog.b(p, "closeInputMethod");
        ((InputMethodManager) getApplicationContext().getSystemService("input_method")).hideSoftInputFromWindow(this.k.getWindowToken(), 0);
    }

    public void d(RecyclerView recyclerView, View view, int i2, SearchModel searchModel) {
        int type = searchModel.getType();
        CLog.b(p, "onItemClick   viewType=" + type + " data: " + searchModel);
        if (type == 0 || type == 1) {
            if (searchModel.getDistance() == -2) {
                this.k.setText(searchModel.getName());
            } else {
                Q1(searchModel);
            }
        } else if (type != 2) {
            if (type == 3) {
                i1();
            }
        } else if (TextUtils.isEmpty(this.k.getText())) {
            if (t1(this.o + 1).size() > 0) {
                this.o++;
            }
            R1(q1());
        } else {
            j1();
        }
    }

    public void e(RecyclerView recyclerView, View view, int i2, SearchModel searchModel) {
    }

    public final void i1() {
        if (getApplicationContext() != null) {
            CustomDialog customDialog = new CustomDialog(this);
            customDialog.c(true);
            customDialog.j(getString(R.string.clear_history_title)).e(getString(R.string.navi_cancel), new i(customDialog)).f(getString(R.string.clear_desp), new j(this, customDialog)).show();
        }
    }

    public void initViewModel() {
        Intent intent = getIntent();
        this.l = intent.getStringExtra("MODEL");
        this.m = intent.getStringExtra("name").trim();
        this.c = new BaseViewModel(x1(this.l));
        String str = p;
        CLog.b(str, "&&&&&&& initViewModel  model=" + this.l + " name=" + this.m);
    }

    public void j1() {
        if (TextUtils.isEmpty(this.k.getText().toString())) {
            UToast.e(getApplicationContext().getApplicationContext(), R.string.navi_search_keyword_desp, 1);
            return;
        }
        NaviUtil.k0(this, this.k.getText().toString());
        O0(1004);
    }

    public void k1() {
        this.k.setText("");
        P1();
    }

    public final void l1() {
        NaviOperatorManager.getInstance(getApplicationContext()).getNaviDatabase().f().c(NaviUtil.t());
        this.n.clear();
        this.o = 1;
        List r1 = r1();
        if (r1.size() <= 0) {
            r1.add(v1(4, getString(R.string.no_history_title)));
        }
        this.i.k().clear();
        R1(r1);
    }

    public final SearchModel m1(int i2, String str) {
        SearchModel searchModel = new SearchModel();
        searchModel.setName(str);
        searchModel.setType(i2);
        return searchModel;
    }

    public final SearchModel n1(PlaceBean placeBean) {
        SearchModel searchModel = new SearchModel();
        searchModel.setName(placeBean.getPoiName());
        searchModel.setAcode(placeBean.getAdCode());
        searchModel.setAddress(placeBean.getDistrict() + placeBean.getAddress());
        searchModel.setDistrict(placeBean.getDistrict());
        searchModel.setKeywords(this.k.getText().toString());
        searchModel.setLatitude(placeBean.getLatitude());
        searchModel.setLongitude(placeBean.getLongitude());
        searchModel.setDistance(placeBean.getDistance());
        searchModel.setAlias(NaviUtil.v(getApplicationContext(), searchModel));
        searchModel.setType(0);
        return searchModel;
    }

    public final void o1(List list) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            PlaceBean placeBean = (PlaceBean) list.get(i2);
            CLog.b(p, "dealWithInputqueryResult  item[" + i2 + "] getPoiName=" + placeBean.getPoiName() + " getAddress=" + placeBean.getAddress() + " getDistrict=" + placeBean.getDistrict() + " getAdcode=" + placeBean.getAdCode() + " getPoiID=" + placeBean.getPoiId() + " getLatitude=" + placeBean.getLatitude() + " getLongitude=" + placeBean.getLongitude());
        }
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < list.size(); i3++) {
            PlaceBean placeBean2 = (PlaceBean) list.get(i3);
            if (placeBean2 != null) {
                arrayList.add(n1(placeBean2));
            }
        }
        if (arrayList.size() > 0) {
            this.n.clear();
            if (arrayList.size() > 8) {
                for (int i4 = 0; i4 < 8; i4++) {
                    this.n.add((SearchModel) arrayList.get(i4));
                }
            } else {
                this.n.addAll(arrayList);
            }
            this.n.add(v1(2, getString(R.string.more_search_results)));
            R1(this.n);
            return;
        }
        this.i.k().clear();
        R1(arrayList);
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        String str = p;
        CLog.a(str, "onActivityResult: " + i2 + " " + i3);
        if (i2 == 1000 && i3 == 1) {
            setResult(1);
            UToast.g(getApplicationContext(), getString(TextUtils.isEmpty(this.m) ? R.string.add_addr_success : R.string.update_addr_success), 1);
            startActivity(new Intent(this, AddressActivity.class));
            finish();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ActivityManager.getInstance().add(this);
        setContentView(R.layout.activity_address_setting);
        initView();
        z1();
        F0();
    }

    public void onDestroy() {
        super.onDestroy();
        ActivityManager.getInstance().remove(this);
        ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(this.k.getWindowToken(), 0);
    }

    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        String trim = charSequence.toString().trim();
        if (!TextUtils.isEmpty(trim)) {
            ULocation g = LocationManager.f().g();
            if (g == null) {
                CLog.b(p, "onTextChanged() location object is null.");
                return;
            }
            this.j.setVisibility(0);
            AutoCompleteTextView autoCompleteTextView = this.k;
            autoCompleteTextView.setSelection(autoCompleteTextView.getText().length());
            PoiSearchManager.f().b(getApplicationContext(), g.getCity(), trim, new ULatLng(g.getLatitude(), g.getLongitude()), 10, new h(this));
            return;
        }
        this.j.setVisibility(8);
        if (this.i != null) {
            P1();
        }
    }

    public final int p1(String str) {
        return TextUtils.isEmpty(str) ? R.string.custom_setting_hint : str.contains("home") ? R.string.home_setting_hint : str.contains("company") ? R.string.company_setting_hint : str.contains(SchedulerSupport.CUSTOM) ? R.string.custom_setting_hint : R.string.custom_setting_hint;
    }

    public final List q1() {
        int i2 = 0;
        while (i2 < this.n.size()) {
            SearchModel searchModel = (SearchModel) this.n.get(i2);
            if (searchModel != null && (searchModel.getType() == 3 || searchModel.getType() == 2)) {
                this.n.remove(searchModel);
                i2 = 0;
            }
            i2++;
        }
        List t1 = t1(this.o);
        if (t1(this.o + 1).size() > 0) {
            t1.add(m1(2, getString(R.string.more_history)));
            t1.add(m1(3, getString(R.string.clear_history)));
        } else if (t1.size() > 0) {
            t1.add(m1(3, getString(R.string.clear_history)));
        }
        this.n.addAll(t1);
        return this.n;
    }

    public final List r1() {
        ArrayList arrayList = new ArrayList();
        List g = NaviOperatorManager.getInstance(getApplicationContext()).getNaviDatabase().f().g(NaviUtil.t());
        for (int i2 = 0; i2 < g.size(); i2++) {
            arrayList.add(w1((Record) g.get(i2)));
        }
        return arrayList;
    }

    public final SearchModel s1(PlaceBean placeBean) {
        SearchModel searchModel = new SearchModel();
        searchModel.setName(placeBean.getPoiName());
        searchModel.setKeywords(placeBean.getPoiName());
        searchModel.setAcode(placeBean.getAdCode());
        searchModel.setAddress(placeBean.getAddress());
        searchModel.setDistrict(placeBean.getDistrict());
        searchModel.setLatitude(placeBean.getLatitude());
        searchModel.setLongitude(placeBean.getLongitude());
        searchModel.setType(0);
        return searchModel;
    }

    public final List t1(int i2) {
        List i3 = NaviOperatorManager.getInstance(getApplicationContext()).getNaviDatabase().f().i(NaviUtil.t(), i2, 12);
        int size = i3.size();
        ArrayList arrayList = new ArrayList();
        for (int i4 = 0; i4 < size; i4++) {
            arrayList.add(w1((Record) i3.get(i4)));
        }
        return arrayList;
    }

    public final void u1() {
        ULocation g = LocationManager.f().g();
        if (g != null) {
            String str = p;
            CLog.b(str, "getPositionPoi  location.getLatitude()=" + g.getLatitude() + " location.getLongitude()=" + g.getLongitude());
            PoiSearchManager.f().c(getApplicationContext(), new ULatLng(g.getLatitude(), g.getLongitude()), new k(this));
        }
    }

    public final SearchModel w1(Record record) {
        SearchModel searchModel = new SearchModel();
        searchModel.setName(record.getName());
        searchModel.setKeywords(record.getName());
        searchModel.setAcode(record.c());
        searchModel.setAddress(record.e());
        searchModel.setDistrict(record.k());
        searchModel.setLatitude(record.n());
        searchModel.setLongitude(record.p());
        searchModel.setDistance(record.j());
        searchModel.setType(1);
        return searchModel;
    }

    public final String x1(String str) {
        return TextUtils.isEmpty(str) ? getString(R.string.custom_setting_hint) : str.contains("home") ? getString(R.string.home_setting_hint) : str.contains("company") ? getString(R.string.company_setting_hint) : str.contains(SchedulerSupport.CUSTOM) ? getString(R.string.custom_setting_hint) : getString(R.string.custom_setting_hint);
    }

    public void y0() {
        CLog.a(p, "clickBarBack: click");
        finish();
    }

    public final boolean y1(String str, SearchModel searchModel) {
        if (!str.equals(SchedulerSupport.CUSTOM)) {
            return false;
        }
        List<CommonAddress> i2 = this.f5635a.d().i(NaviUtil.t());
        String str2 = p;
        CLog.a(str2, "hasExistAddress list.size(): " + i2.size());
        for (CommonAddress commonAddress : i2) {
            String str3 = p;
            CLog.a(str3, "hasExistAddress: " + JsonUtil.a(commonAddress) + " addr.getAlias()=" + commonAddress.d());
            if (commonAddress.j().equals(searchModel.getName()) && commonAddress.h() == searchModel.getLatitude() && commonAddress.i() == searchModel.getLongitude() && commonAddress.c().equals(searchModel.getAddress())) {
                return true;
            }
        }
        return false;
    }

    public final void z1() {
        List r1 = r1();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.history_list);
        this.h = recyclerView;
        recyclerView.setOnTouchListener(new r(this));
        this.h.setLayoutManager(new LinearLayoutManager(this));
        this.i = new HistoryListAdapter(this, r1);
        this.k.setText(this.m);
        if (!TextUtils.isEmpty(this.m)) {
            this.i.k().clear();
            this.k.setSelection(this.m.length());
        } else {
            this.k.setSelection(0);
        }
        this.k.requestFocus();
        this.i.u(q1());
        if (r1().size() <= 0) {
            l1();
        }
        this.i.v(this);
        this.h.setAdapter(this.i);
        ((InputMethodManager) getSystemService("input_method")).showSoftInput(this.k, 0);
    }
}
