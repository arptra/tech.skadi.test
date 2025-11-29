package com.upuphone.ar.navi.lite;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import androidx.appcompat.app.ActionBar;
import com.honey.account.d4.u;
import com.honey.account.d4.v;
import com.honey.account.d4.w;
import com.honey.account.d4.x;
import com.honey.account.d4.y;
import com.upuphone.ar.navi.lite.base.BaseViewModel;
import com.upuphone.ar.navi.lite.dao.NaviDatabase;
import com.upuphone.ar.navi.lite.manger.NaviManager;
import com.upuphone.ar.navi.lite.manger.NaviOperatorManager;
import com.upuphone.ar.navi.lite.model.LocationClickImpl;
import com.upuphone.ar.navi.lite.util.CLog;
import com.upuphone.ar.navi.lite.util.NaviUtil;
import com.upuphone.ar.navi.lite.util.SensorEventHelper;
import com.upuphone.ar.navi.lite.view.ActionBarView;
import com.upuphone.ar.navi.lite.view.TipsDialog;
import com.upuphone.star.common.phone.UBaseActivity;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.context.SdkContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public abstract class BaseActivity extends UBaseActivity implements LocationClickImpl {
    public static final String f = ("NAVI-" + BaseActivity.class.getSimpleName());
    public static float g = 1.0f;

    /* renamed from: a  reason: collision with root package name */
    public NaviDatabase f5635a;
    public SensorEventHelper b;
    public BaseViewModel c;
    public TipsDialog d;
    public boolean e = true;

    public interface ConfirmCallback {
    }

    public static void D0(Context context, View view) {
        try {
            int i = context.getResources().getConfiguration().uiMode & 48;
            String str = f;
            ULog.i(str, "dayNightModeSet, night mode = " + i);
            if (i == 32) {
                View.class.getDeclaredMethod("actInMzNightMode", new Class[]{Integer.TYPE}).invoke(view, new Object[]{2});
                ULog.i(str, "dayNightModeSet to 2");
            }
        } catch (Throwable th) {
            String str2 = f;
            ULog.f(str2, "dayNightModeSet, error: " + th);
        }
    }

    public void A0(String str) {
        this.f5635a.d().a(NaviUtil.t(), str);
        NaviOperatorManager.getInstance(getApplicationContext()).initCommonAddr();
    }

    public void B0(String str, String str2) {
        this.f5635a.d().h(NaviUtil.t(), str, str2);
        NaviOperatorManager.getInstance(getApplicationContext()).initCommonAddr();
    }

    public void C0() {
        TipsDialog tipsDialog = this.d;
        if (tipsDialog != null) {
            tipsDialog.dismiss();
            this.d = null;
        }
    }

    public final void E0() {
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.g();
        }
    }

    public void F0() {
        G0("");
    }

    public void G0(String str) {
        ActionBarView actionBarView = (ActionBarView) findViewById(R.id.top_action_bar);
        if (actionBarView != null) {
            actionBarView.setBackBtnClick(new w(this));
            actionBarView.setBarText(this.c.a());
            actionBarView.i(new x(this), str);
        }
    }

    public void H0() {
        List p = NaviUtil.p(this);
        if (p == null || p.size() <= 0) {
            NaviOperatorManager.getInstance(getApplicationContext()).startLocation(getApplicationContext());
            return;
        }
        CLog.b(f, "initCheckRequestPermisson  .");
        NaviUtil.g0(this, true, new v(this));
    }

    public void I0() {
        SensorEventHelper sensorEventHelper = new SensorEventHelper(getApplicationContext());
        this.b = sensorEventHelper;
        sensorEventHelper.d(new u(this));
    }

    public final /* synthetic */ void J0(View view) {
        y0();
    }

    public final /* synthetic */ void K0(View view) {
        z0();
    }

    public final /* synthetic */ void M0() {
        this.e = true;
        new Handler().postDelayed(new y(this), 350);
    }

    public void O0(int i) {
        CLog.a(f, "onClickLocation: Implement in subclass");
    }

    public final void P0(Context context) {
        if (context != null) {
            Configuration configuration = context.getResources().getConfiguration();
            configuration.fontScale = g;
            context.createConfigurationContext(configuration);
        }
    }

    /* renamed from: Q0 */
    public void L0() {
        if (!BuildConfig.d.booleanValue() || BuildConfig.b.booleanValue()) {
            CLog.b(f, "showLocationTipDialog  current version is not THIRD PLATFOM or COUNTRY_INTL.");
            return;
        }
        String str = f;
        CLog.b(str, "showLocationTipDialog  needShowTips=" + this.e);
        if (!this.e) {
            CLog.b(str, "showLocationTipDialog  app request permission not should show.");
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add("android.permission.ACCESS_COARSE_LOCATION");
        HashMap b2 = SdkContext.f6675a.f().b(this, (String[]) arrayList.toArray(new String[0]));
        TipsDialog tipsDialog = new TipsDialog(this);
        this.d = tipsDialog;
        tipsDialog.c(48);
        this.d.setCancelable(true);
        this.d.e((String) b2.getOrDefault("title", "")).d((String) b2.getOrDefault("content", "")).show();
    }

    /* renamed from: R0 */
    public void N0(float f2) {
        String str = f;
        CLog.a(str, "updateLocationBearing: angle=" + f2);
    }

    public void attachBaseContext(Context context) {
        P0(context);
        super.attachBaseContext(context);
    }

    public abstract void initViewModel();

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (1003 == i || 1004 == i) {
            O0(i);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        fitStatusBar(true);
        initViewModel();
        E0();
        NaviManager.getInstance(getApplicationContext());
        this.f5635a = NaviOperatorManager.getInstance(getApplicationContext()).getNaviDatabase();
        D0(this, getWindow().getDecorView());
    }

    public void onPause() {
        super.onPause();
        SensorEventHelper sensorEventHelper = this.b;
        if (sensorEventHelper != null) {
            sensorEventHelper.e();
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        C0();
        this.e = false;
    }

    public void onResume() {
        super.onResume();
        SensorEventHelper sensorEventHelper = this.b;
        if (sensorEventHelper != null) {
            sensorEventHelper.c();
        }
    }

    public void y0() {
        CLog.a(f, "clickBarBack: click");
        onBackPressed();
    }

    public void z0() {
        CLog.a(f, "clickBarBack: clickBarTextEnd");
    }
}
