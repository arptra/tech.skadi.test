package com.upuphone.ar.navi.lite;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import com.honey.account.d4.a;
import com.honey.account.d4.b;
import com.honey.account.d4.c;
import com.honey.account.d4.d;
import com.honey.account.d4.e;
import com.honey.account.d4.f;
import com.honey.account.d4.g;
import com.upuphone.ar.fastrecord.phone.ui.activity.FastRecordHistoryDetailActivity;
import com.upuphone.ar.navi.lite.base.BaseViewModel;
import com.upuphone.ar.navi.lite.base.CommonAddress;
import com.upuphone.ar.navi.lite.base.SearchModel;
import com.upuphone.ar.navi.lite.databinding.ActivityAddressBinding;
import com.upuphone.ar.navi.lite.manger.ActivityManager;
import com.upuphone.ar.navi.lite.manger.NaviManager;
import com.upuphone.ar.navi.lite.manger.NaviOperatorManager;
import com.upuphone.ar.navi.lite.manger.StarryNetManger;
import com.upuphone.ar.navi.lite.util.CLog;
import com.upuphone.ar.navi.lite.util.CSharedPreferences;
import com.upuphone.ar.navi.lite.util.JsonUtil;
import com.upuphone.ar.navi.lite.util.NaviUtil;
import com.upuphone.ar.navi.lite.util.RegionUtils;
import com.upuphone.ar.navi.lite.view.AddressAddMenuView;
import com.upuphone.ar.navi.lite.view.AddressView;
import com.upuphone.ar.navi.lite.view.BottomMenu;
import com.upuphone.ar.navi.lite.view.CustomDialog;
import com.upuphone.runasone.uupcast.CaptureType;
import com.upuphone.star.common.phone.UToast;
import io.reactivex.rxjava3.annotations.SchedulerSupport;
import java.util.List;

public class AddressActivity extends BaseActivity implements BottomMenu.OnClickListener, View.OnClickListener {
    public static final String u = ("NAVI-" + AddressActivity.class.getSimpleName());
    public SearchModel h = new SearchModel();
    public SearchModel i = new SearchModel();
    public View j;
    public TextView k;
    public ImageView l;
    public TextView m;
    public ImageView n;
    public TextView o;
    public TextView p;
    public TextView q;
    public TextView r;
    public TextView s;
    public LinearLayout t;

    private void initData() {
        x1(CSharedPreferences.j(this));
        w1();
    }

    private void initView() {
        this.j = findViewById(R.id.mask);
        TextView textView = (TextView) findViewById(R.id.home_address);
        this.k = textView;
        textView.setOnClickListener(this);
        ImageView imageView = (ImageView) findViewById(R.id.home_more);
        this.l = imageView;
        imageView.setOnClickListener(this);
        TextView textView2 = (TextView) findViewById(R.id.company_address);
        this.m = textView2;
        textView2.setOnClickListener(this);
        ImageView imageView2 = (ImageView) findViewById(R.id.company_more);
        this.n = imageView2;
        imageView2.setOnClickListener(this);
        this.o = (TextView) findViewById(R.id.navi_mode_set_hint);
        TextView textView3 = (TextView) findViewById(R.id.recommend_navi_mode);
        this.p = textView3;
        textView3.setOnClickListener(new d(this));
        TextView textView4 = (TextView) findViewById(R.id.navi_mode_drive);
        this.q = textView4;
        textView4.setOnClickListener(new e(this));
        this.q.setVisibility(RegionUtils.d() ? 8 : 0);
        TextView textView5 = (TextView) findViewById(R.id.navi_mode_ride);
        this.r = textView5;
        textView5.setOnClickListener(new f(this));
        TextView textView6 = (TextView) findViewById(R.id.navi_mode_walk);
        this.s = textView6;
        textView6.setOnClickListener(new g(this));
        this.t = (LinearLayout) findViewById(R.id.address_list);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void k1(View view) {
        x1(3);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void l1(View view) {
        x1(0);
    }

    public void A0(String str) {
        super.A0(str);
        v1();
    }

    public void B(boolean z) {
        this.j.setVisibility(z ? 0 : 8);
    }

    public final void d1(Context context, SearchModel searchModel, int i2) {
        if (NaviUtil.x0(searchModel)) {
            UToast.e(context.getApplicationContext(), i2 == 1 ? R.string.near_place_home_tips : R.string.near_place_company_tips, 0);
        } else if (NaviUtil.u0()) {
            s1(context);
        } else {
            t1(context, searchModel);
        }
    }

    public final void e1(String str) {
        SearchModel searchModel = str.equals(NaviUtil.J()) ? this.h : this.i;
        String str2 = u;
        CLog.b(str2, "editCommonAddr ######## model=" + searchModel.toString() + " alias=" + str);
        if (searchModel.getLatitude() == 0.0d && searchModel.getLongitude() == 0.0d) {
            Intent intent = new Intent(this, AddressSettingActivity.class);
            intent.putExtra("MODEL", str);
            intent.putExtra("name", i1(str));
            startActivityForResult(intent, 1002);
            return;
        }
        searchModel.setAlias(str);
        searchModel.setNaviMode(NaviUtil.R(this, searchModel));
        d1(this, searchModel, str.equals(NaviUtil.J()) ? 1 : 2);
    }

    public final void f1(SearchModel searchModel) {
        if (NaviUtil.x0(searchModel)) {
            UToast.e(getApplicationContext(), R.string.near_location_info, 0);
        } else if (NaviUtil.u0()) {
            s1(this);
        } else {
            Intent intent = new Intent(this, NaviFragmentActivity.class);
            intent.setFlags(CaptureType.CAPTURE_VIRTUAL_DISPLAY_WHEN_SCREEN_LOCKED);
            searchModel.setNaviMode(NaviUtil.R(getApplicationContext(), searchModel));
            intent.putExtra("search_info_key", searchModel);
            intent.putExtra("direct_navi_key", false);
            intent.putExtra("navi_from_quik_key", 0);
            startActivityForResult(intent, 100);
            NaviUtil.h0(getApplicationContext(), searchModel);
            finish();
        }
    }

    public final void g1(String str, SearchModel searchModel) {
        String str2;
        Intent intent = new Intent(this, AddressSettingActivity.class);
        if (searchModel != null) {
            String str3 = u;
            CLog.b(str3, "editCommonAddr data.getAlias()=" + searchModel.getAlias());
            if (!TextUtils.isEmpty(searchModel.getAlias()) && searchModel.getAlias().contains(SchedulerSupport.CUSTOM)) {
                str = searchModel.getAlias();
            }
            str2 = (TextUtils.isEmpty(searchModel.getAlias()) || !searchModel.getAlias().contains(SchedulerSupport.CUSTOM)) ? i1(str) : searchModel.getName();
        } else {
            str2 = "";
        }
        intent.putExtra("MODEL", str);
        intent.putExtra("name", str2);
        startActivityForResult(intent, 1002);
    }

    public final List h1() {
        List<CommonAddress> i2 = this.f5635a.d().i(NaviUtil.t());
        String str = u;
        CLog.a(str, "getAliasCustomInfo list.size(): " + i2.size());
        for (CommonAddress commonAddress : i2) {
            String str2 = u;
            CLog.a(str2, "getAliasCustomInfo: " + JsonUtil.a(commonAddress) + " addr.getAlias()=" + commonAddress.d());
        }
        return i2;
    }

    public final String i1(String str) {
        String str2 = u;
        CLog.b(str2, "getAutoCompleteText alias=" + str);
        return NaviUtil.J().equals(str) ? this.k.getText().toString() : NaviUtil.w().equals(str) ? this.m.getText().toString() : "";
    }

    public void initViewModel() {
        this.c = new BaseViewModel(getString(R.string.common_addr));
    }

    public final SearchModel j1(CommonAddress commonAddress) {
        CLog.a(u, "getSearchModelByAddress addressList.getChildCount(): ");
        SearchModel searchModel = new SearchModel();
        searchModel.setAcode(commonAddress.b());
        searchModel.setAddress(commonAddress.c());
        searchModel.setCity(commonAddress.e());
        searchModel.setDistrict(commonAddress.g());
        searchModel.setLatitude(commonAddress.h());
        searchModel.setLongitude(commonAddress.i());
        searchModel.setName(commonAddress.j());
        searchModel.setAlias(commonAddress.d());
        return searchModel;
    }

    public final /* synthetic */ void m1(View view) {
        x1(1);
    }

    public final /* synthetic */ void n1(View view) {
        x1(2);
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        String str = u;
        CLog.a(str, "onActivityResult: " + i2 + FastRecordHistoryDetailActivity.TAG_SPLIT + i3);
        if (1002 == i2 && i3 == 1) {
            v1();
        }
    }

    public void onClick(View view) {
        if (view.getId() == R.id.home_address) {
            e1(NaviUtil.J());
            return;
        }
        int i2 = 1;
        if (view.getId() == R.id.home_more) {
            String J = NaviUtil.J();
            SearchModel searchModel = this.h;
            if (TextUtils.isEmpty(searchModel.getName())) {
                i2 = 3;
            }
            r1(J, searchModel, i2);
        } else if (view.getId() == R.id.company_address) {
            e1(NaviUtil.w());
        } else if (view.getId() == R.id.company_more) {
            String w = NaviUtil.w();
            SearchModel searchModel2 = this.i;
            if (TextUtils.isEmpty(searchModel2.getName())) {
                i2 = 3;
            }
            r1(w, searchModel2, i2);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ActivityManager.getInstance().add(this);
        NaviManager.getInstance(getApplicationContext());
        H0();
        ((ActivityAddressBinding) DataBindingUtil.e(this, R.layout.activity_address)).C(this.c);
        initView();
        initData();
        v1();
        F0();
    }

    public void onDestroy() {
        super.onDestroy();
        ActivityManager.getInstance().remove(this);
        if (NaviOperatorManager.getInstance(getApplicationContext()).getEnterType() == 2 && !NaviUtil.u0() && !NaviUtil.B0()) {
            StarryNetManger.getInstance().unRegister();
            NaviOperatorManager.getInstance(getApplicationContext()).stopLocation();
        }
    }

    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        v1();
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i2, strArr, iArr);
        String str = u;
        CLog.b(str, "onRequestPermissionsResult  requestCode " + i2);
        if (508 == i2) {
            NaviOperatorManager.getInstance(getApplicationContext()).startLocation(getApplicationContext());
        }
    }

    public void onResume() {
        super.onResume();
        NaviOperatorManager.getInstance(getApplicationContext()).initCommonAddr();
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        View view = this.j;
        if (view != null && z) {
            view.setVisibility(8);
        }
    }

    public final /* synthetic */ void p1(CustomDialog customDialog, Context context, View view) {
        customDialog.dismiss();
        startActivity(new Intent(context, NaviFragmentActivity.class));
    }

    public final /* synthetic */ void q1(View view) {
        g1(SchedulerSupport.CUSTOM, (SearchModel) null);
    }

    public void r(View view, String str, SearchModel searchModel) {
        String str2 = u;
        CLog.a(str2, "onClick: " + view.getId());
        int id = view.getId();
        if (id == R.id.menu_add) {
            CLog.a(str2, "onClick: menu add");
            g1(str, searchModel);
        } else if (id == R.id.menu_edit) {
            g1(str, searchModel);
            CLog.a(str2, "onClick: menu edit");
        } else if (id == R.id.menu_delete) {
            CLog.a(str2, "onClick: menu delete");
            A0(str);
        }
    }

    public final void r1(String str, SearchModel searchModel, int i2) {
        String str2 = u;
        CLog.b(str2, "openBottomMenu alias=" + str + " model=" + i2 + " data=" + searchModel.toString());
        new BottomMenu(this, str, searchModel, i2, this).a();
    }

    public final void s1(Context context) {
        CustomDialog customDialog = new CustomDialog(this);
        customDialog.c(true);
        customDialog.j(getString(R.string.Navigation_check)).i(getString(R.string.start_new_itinerary)).e(getString(R.string.navi_cancel), new b(customDialog)).f(getString(R.string.go_to), new c(this, customDialog, context)).show();
    }

    public final void t1(Context context, SearchModel searchModel) {
        Intent intent = new Intent(context, NaviFragmentActivity.class);
        intent.setFlags(CaptureType.CAPTURE_VIRTUAL_DISPLAY_WHEN_SCREEN_LOCKED);
        searchModel.setNaviMode(CSharedPreferences.j(context));
        intent.putExtra("search_info_key", searchModel);
        intent.putExtra("direct_navi_key", false);
        intent.putExtra("navi_from_quik_key", 0);
        startActivityForResult(intent, 100);
        NaviUtil.h0(getApplicationContext(), searchModel);
        finish();
    }

    public final void u1() {
        String str = u;
        CLog.a(str, "updateAddressData homeModel.getName()=" + this.h.getName() + " companyModel.getName()=" + this.i.getName());
        String str2 = "";
        this.k.setText(TextUtils.isEmpty(this.h.getName()) ? str2 : this.h.getName());
        TextView textView = this.m;
        if (!TextUtils.isEmpty(this.i.getName())) {
            str2 = this.i.getName();
        }
        textView.setText(str2);
        this.k.setCompoundDrawablesRelativeWithIntrinsicBounds(getResources().getDrawable(TextUtils.isEmpty(this.h.getName()) ? R.drawable.commute_helper_home_grey : R.drawable.commute_helper_home, (Resources.Theme) null), (Drawable) null, (Drawable) null, (Drawable) null);
        this.m.setCompoundDrawablesRelativeWithIntrinsicBounds(getResources().getDrawable(TextUtils.isEmpty(this.i.getName()) ? R.drawable.commute_helper_company_grey : R.drawable.commute_helper_company, (Resources.Theme) null), (Drawable) null, (Drawable) null, (Drawable) null);
    }

    public final void v1() {
        List<CommonAddress> d = this.f5635a.d().d(NaviUtil.t());
        SearchModel searchModel = new SearchModel();
        SearchModel searchModel2 = new SearchModel();
        SearchModel searchModel3 = new SearchModel();
        for (CommonAddress commonAddress : d) {
            String str = u;
            CLog.a(str, "updateCommonAddrView: " + JsonUtil.a(commonAddress));
            if (NaviUtil.J().equalsIgnoreCase(commonAddress.d())) {
                searchModel.setAcode(commonAddress.b());
                searchModel.setAddress(commonAddress.c());
                searchModel.setCity(commonAddress.e());
                searchModel.setDistrict(commonAddress.g());
                searchModel.setLatitude(commonAddress.h());
                searchModel.setLongitude(commonAddress.i());
                searchModel.setName(commonAddress.j());
            } else if (NaviUtil.w().equalsIgnoreCase(commonAddress.d())) {
                searchModel2.setAcode(commonAddress.b());
                searchModel2.setAddress(commonAddress.c());
                searchModel2.setCity(commonAddress.e());
                searchModel2.setDistrict(commonAddress.g());
                searchModel2.setLatitude(commonAddress.h());
                searchModel2.setLongitude(commonAddress.i());
                searchModel2.setName(commonAddress.j());
            } else if (SchedulerSupport.CUSTOM.contains(commonAddress.d())) {
                searchModel3.setAcode(commonAddress.b());
                searchModel3.setAddress(commonAddress.c());
                searchModel3.setCity(commonAddress.e());
                searchModel3.setDistrict(commonAddress.g());
                searchModel3.setLatitude(commonAddress.h());
                searchModel3.setLongitude(commonAddress.i());
                searchModel3.setName(commonAddress.j());
            }
        }
        this.h = searchModel;
        this.i = searchModel2;
        u1();
        w1();
        NaviUtil.E1(getApplicationContext());
    }

    public final void w1() {
        this.t.removeAllViews();
        List h1 = h1();
        for (int i2 = 0; i2 < h1.size(); i2++) {
            AddressView addressView = new AddressView((Context) this, (CommonAddress) h1.get(i2));
            addressView.setViewActionListener(new AddressView.AddressViewActionistener() {
                public void a(CommonAddress commonAddress) {
                    String c1 = AddressActivity.u;
                    CLog.a(c1, "addressItemClick address: " + commonAddress.toString());
                    AddressActivity addressActivity = AddressActivity.this;
                    addressActivity.f1(addressActivity.j1(commonAddress));
                }

                public void b(CommonAddress commonAddress) {
                    String c1 = AddressActivity.u;
                    CLog.a(c1, "addressMenuClick address: " + commonAddress.toString());
                    AddressActivity.this.r1(commonAddress.d(), AddressActivity.this.j1(commonAddress), 1);
                }
            });
            this.t.addView(addressView);
        }
        AddressAddMenuView addressAddMenuView = new AddressAddMenuView(this);
        if (h1.size() >= 12) {
            addressAddMenuView.setInfoVisible(true);
            addressAddMenuView.setOnClickListener((View.OnClickListener) null);
            this.t.addView(addressAddMenuView);
            return;
        }
        addressAddMenuView.setInfoVisible(false);
        addressAddMenuView.setOnClickListener(new a(this));
        this.t.addView(addressAddMenuView);
    }

    public final void x1(int i2) {
        if (i2 == 0) {
            this.o.setHint(String.format(getString(R.string.navi_travel_mode_hint), new Object[]{getString(R.string.drive_title)}));
            this.q.setBackgroundResource(R.drawable.navi_mode_btn_bg);
            this.q.setTextColor(getResources().getColor(R.color.theme_color_1, (Resources.Theme) null));
            this.r.setBackgroundResource(R.drawable.navi_mode_btn_bg_n);
            this.r.setTextColor(getResources().getColor(R.color.theme_color_2, (Resources.Theme) null));
            this.s.setBackgroundResource(R.drawable.navi_mode_btn_bg_n);
            this.s.setTextColor(getResources().getColor(R.color.theme_color_2, (Resources.Theme) null));
            this.p.setBackgroundResource(R.drawable.navi_mode_btn_bg_n);
            this.p.setTextColor(getResources().getColor(R.color.theme_color_2, (Resources.Theme) null));
        } else if (i2 == 1) {
            this.o.setHint(String.format(getString(R.string.navi_travel_mode_hint), new Object[]{getString(R.string.ride_title)}));
            this.q.setBackgroundResource(R.drawable.navi_mode_btn_bg_n);
            this.q.setTextColor(getResources().getColor(R.color.theme_color_2, (Resources.Theme) null));
            this.r.setBackgroundResource(R.drawable.navi_mode_btn_bg);
            this.r.setTextColor(getResources().getColor(R.color.theme_color_1, (Resources.Theme) null));
            this.s.setBackgroundResource(R.drawable.navi_mode_btn_bg_n);
            this.s.setTextColor(getResources().getColor(R.color.theme_color_2, (Resources.Theme) null));
            this.p.setBackgroundResource(R.drawable.navi_mode_btn_bg_n);
            this.p.setTextColor(getResources().getColor(R.color.theme_color_2, (Resources.Theme) null));
        } else if (i2 == 2) {
            this.o.setHint(String.format(getString(R.string.navi_travel_mode_hint), new Object[]{getString(R.string.walk_title)}));
            this.q.setBackgroundResource(R.drawable.navi_mode_btn_bg_n);
            this.q.setTextColor(getResources().getColor(R.color.theme_color_2, (Resources.Theme) null));
            this.r.setBackgroundResource(R.drawable.navi_mode_btn_bg_n);
            this.r.setTextColor(getResources().getColor(R.color.theme_color_2, (Resources.Theme) null));
            this.s.setBackgroundResource(R.drawable.navi_mode_btn_bg);
            this.s.setTextColor(getResources().getColor(R.color.theme_color_1, (Resources.Theme) null));
            this.p.setBackgroundResource(R.drawable.navi_mode_btn_bg_n);
            this.p.setTextColor(getResources().getColor(R.color.theme_color_2, (Resources.Theme) null));
        } else if (i2 == 3) {
            this.o.setHint(R.string.navi_mode_set_hint);
            this.q.setBackgroundResource(R.drawable.navi_mode_btn_bg_n);
            this.q.setTextColor(getResources().getColor(R.color.theme_color_2, (Resources.Theme) null));
            this.r.setBackgroundResource(R.drawable.navi_mode_btn_bg_n);
            this.r.setTextColor(getResources().getColor(R.color.theme_color_2, (Resources.Theme) null));
            this.s.setBackgroundResource(R.drawable.navi_mode_btn_bg_n);
            this.s.setTextColor(getResources().getColor(R.color.theme_color_2, (Resources.Theme) null));
            this.p.setBackgroundResource(R.drawable.navi_mode_btn_bg);
            this.p.setTextColor(getResources().getColor(R.color.theme_color_1, (Resources.Theme) null));
        }
        CSharedPreferences.x(this, i2);
    }
}
