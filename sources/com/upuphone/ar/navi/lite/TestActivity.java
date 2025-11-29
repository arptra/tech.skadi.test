package com.upuphone.ar.navi.lite;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.upuphone.ar.navi.lite.base.SearchModel;
import com.upuphone.ar.navi.lite.manger.NaviManager;
import com.upuphone.ar.navi.lite.model.ICheckPermission;
import com.upuphone.ar.navi.lite.util.NaviUtil;
import com.upuphone.xr.interconnect.common.INaviActionResult;
import com.upuphone.xr.interconnect.entity.PoiResult;

public class TestActivity extends BaseActivity implements View.OnClickListener {
    private void initView() {
        ((Button) findViewById(R.id.search)).setOnClickListener(this);
        ((Button) findViewById(R.id.home)).setOnClickListener(this);
        ((Button) findViewById(R.id.company)).setOnClickListener(this);
        ((Button) findViewById(R.id.custom)).setOnClickListener(this);
        ((Button) findViewById(R.id.nav_setting)).setOnClickListener(this);
        ((Button) findViewById(R.id.other_setting)).setOnClickListener(this);
    }

    public final PoiResult S0() {
        SearchModel searchModel = new SearchModel();
        searchModel.setName("新世纪环球购物中心");
        searchModel.setLatitude(30.568744d);
        searchModel.setLongitude(104.063402d);
        searchModel.setAcode("510107");
        searchModel.setAddress("天府大道北段1700号");
        searchModel.setCity("'成都市'");
        PoiResult poiResult = new PoiResult();
        poiResult.setName("新世纪环球购物中心");
        poiResult.setLatitude(30.568744d);
        poiResult.setLongitude(104.063402d);
        poiResult.setAddress("天府大道北段1700号");
        return poiResult;
    }

    public final void T0() {
        NaviManager.getInstance(this).startNavi(this, 0, 10, S0(), (INaviActionResult) null);
    }

    public final void U0() {
        startActivity(new Intent(this, NaviFragmentActivity.class));
    }

    public final void V0() {
        startActivity(new Intent(this, NaviFragmentActivity.class));
    }

    public final void W0() {
        startActivity(new Intent(this, SettingActivity.class));
    }

    public final void X0() {
        startActivity(new Intent(this, SettingActivity.class));
    }

    public final void Y0() {
        startActivity(new Intent(this, NaviFragmentActivity.class));
    }

    public void initViewModel() {
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.search) {
            Y0();
        } else if (id == R.id.home) {
            V0();
        } else if (id == R.id.company) {
            T0();
        } else if (id == R.id.custom) {
            U0();
        } else if (id == R.id.nav_setting) {
            W0();
        } else if (id == R.id.other_setting) {
            X0();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_test);
        NaviUtil.g0(this, true, (ICheckPermission) null);
        initView();
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public void onPause() {
        super.onPause();
    }

    public void onResume() {
        super.onResume();
    }

    public void onStart() {
        super.onStart();
    }

    public void onStop() {
        super.onStop();
    }
}
