package com.upuphone.ar.navi.lite;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.honey.account.d4.e0;
import com.honey.account.d4.f0;
import com.honey.account.d4.g0;
import com.honey.account.d4.h0;
import com.honey.account.d4.i0;
import com.honey.account.d4.j0;
import com.honey.account.d4.k0;
import com.honey.account.d4.l0;
import com.honey.account.d4.m0;
import com.honey.account.d4.n0;
import com.honey.account.d4.o0;
import com.honey.account.d4.p0;
import com.honey.account.d4.q0;
import com.honey.account.d4.r0;
import com.upuphone.ar.navi.lite.base.NaviHomeBean;
import com.upuphone.ar.navi.lite.base.PlaceBean;
import com.upuphone.ar.navi.lite.base.SearchModel;
import com.upuphone.ar.navi.lite.base.ULocation;
import com.upuphone.ar.navi.lite.fragment.BaseFragment;
import com.upuphone.ar.navi.lite.fragment.NaviFragment;
import com.upuphone.ar.navi.lite.fragment.SearchFragment;
import com.upuphone.ar.navi.lite.location.LocationManager;
import com.upuphone.ar.navi.lite.manger.ActivityManager;
import com.upuphone.ar.navi.lite.manger.ConnectionManager;
import com.upuphone.ar.navi.lite.manger.NaviManager;
import com.upuphone.ar.navi.lite.manger.NaviOperatorManager;
import com.upuphone.ar.navi.lite.manger.StarryNetManger;
import com.upuphone.ar.navi.lite.model.IConnection;
import com.upuphone.ar.navi.lite.model.IConnectionManager;
import com.upuphone.ar.navi.lite.model.ILocation;
import com.upuphone.ar.navi.lite.model.ILocationManager;
import com.upuphone.ar.navi.lite.model.INavigation;
import com.upuphone.ar.navi.lite.model.INavigationManager;
import com.upuphone.ar.navi.lite.model.INetDevice;
import com.upuphone.ar.navi.lite.model.INetDeviceManager;
import com.upuphone.ar.navi.lite.navi.NaviControlManager;
import com.upuphone.ar.navi.lite.protocol.NotifyUtils;
import com.upuphone.ar.navi.lite.protocol.ProtocolUtils;
import com.upuphone.ar.navi.lite.util.CLog;
import com.upuphone.ar.navi.lite.util.CSharedPreferences;
import com.upuphone.ar.navi.lite.util.LocationUtil;
import com.upuphone.ar.navi.lite.util.NaviUtil;
import com.upuphone.ar.navi.lite.util.PermissionUtil;
import com.upuphone.ar.navi.lite.view.CustomDialog;
import com.upuphone.star.common.phone.UToast;
import com.upuphone.xr.interconnect.common.INaviActionResult;
import com.upuphone.xr.interconnect.entity.StarryNetMessage;
import com.upuphone.xr.interconnect.listener.SendMessageListener;
import com.upuphone.xr.sapp.monitor.starry.cmd.CmdAction;

public class NaviFragmentActivity extends BaseActivity implements INavigation, INetDevice, ILocation, IConnection {
    public static final String v = ("NAVI-" + NaviFragmentActivity.class.getSimpleName());
    public FragmentManager h;
    public FragmentTransaction i;
    public BaseFragment j;
    public BaseFragment k;
    public SearchModel l;
    public boolean m = false;
    public int n = 0;
    public boolean o = false;
    public boolean p = false;
    public CustomDialog q = null;
    public CustomDialog r = null;
    public boolean s = false;
    public BaseFragment.FragmentActionListener t = new h0(this);
    public BaseFragment.FragmentActionListener u = new i0(this);

    public void A(boolean z) {
        BaseFragment baseFragment = this.j;
        if (baseFragment != null) {
            baseFragment.C0(z);
        }
        BaseFragment baseFragment2 = this.k;
        if (baseFragment2 != null) {
            baseFragment2.C0(z);
        }
    }

    public final /* synthetic */ void A1(View view) {
        CLog.b(v, "showBackGroundPermissionDialog setsConfirm Enter.");
        this.r.dismiss();
        this.r = null;
        PermissionUtil.c(this, 10006);
    }

    public final /* synthetic */ void B1() {
        BaseFragment baseFragment = this.k;
        if (baseFragment != null) {
            baseFragment.R0();
        }
        if (NaviUtil.B0()) {
            StarryNetManger.getInstance().sendMessage(ProtocolUtils.g("navi_event", -1, "navi_stop"), (SendMessageListener) null);
            NaviUtil.q1(false);
        }
        finish();
    }

    public final void C1(Intent intent) {
        boolean booleanExtra = intent.getBooleanExtra("open_navi_ai_key", false);
        NaviUtil.d1(booleanExtra);
        String str = v;
        CLog.b(str, "openNaviDock aiOpen=" + booleanExtra + " isNaviStarted()=" + NaviUtil.B0() + " isIsNaving=" + NaviUtil.u0());
        if (booleanExtra && !NaviUtil.B0()) {
            NaviUtil.z1(getApplicationContext());
        }
        if (booleanExtra) {
            NaviUtil.a1();
        }
    }

    public final void D1() {
        if (NaviUtil.d0(getApplicationContext())) {
            String format = String.format(getString(R.string.restore_navi_desp), new Object[]{NaviUtil.E(this).getName()});
            CustomDialog customDialog = new CustomDialog(this);
            this.q = customDialog;
            customDialog.j(format).e(getString(R.string.navi_cancel_tilte), new k0(this)).f(getString(R.string.navi_confirm_tilte), new l0(this)).show();
        }
    }

    public void E() {
        runOnUiThread(new q0(this));
    }

    public final void E1(SearchModel searchModel, boolean z, int i2, int i3) {
        String str = v;
        CLog.b(str, "selection from=" + i2 + " to=" + i3 + " direct" + z);
        F1(searchModel, z, this.n, i3);
    }

    public final void F1(SearchModel searchModel, boolean z, int i2, int i3) {
        String str = v;
        CLog.b(str, "selection category.getName()=" + i3);
        FragmentTransaction s2 = this.h.s();
        this.i = s2;
        n1(s2, i3);
        i1();
        if (i3 == 0) {
            l1();
            if (this.j == null) {
                SearchFragment searchFragment = new SearchFragment();
                this.j = searchFragment;
                searchFragment.L0(this.t);
                StringBuilder sb = new StringBuilder();
                sb.append("selection SearchFragment.isAdded()=");
                sb.append(this.j.isAdded());
                sb.append(" findFragmentByTag=");
                Class<SearchFragment> cls = SearchFragment.class;
                sb.append(this.h.p0(cls.getSimpleName()));
                CLog.b(str, sb.toString());
                if (!this.j.isAdded()) {
                    this.i.c(R.id.fragement_container_layout, this.j, cls.getSimpleName());
                    J1(this.j, this.o);
                }
            } else {
                CLog.b(str, "selection SearchFragment() has added!");
                this.j.S0((SearchModel) null, z, -1);
                this.i.B(this.j);
            }
        } else if (i3 == 1) {
            if (this.k == null) {
                NaviFragment naviFragment = new NaviFragment();
                this.k = naviFragment;
                naviFragment.L0(this.u);
                StringBuilder sb2 = new StringBuilder();
                sb2.append("selection naviFragment.isAdded()=");
                sb2.append(this.k.isAdded());
                sb2.append(" findFragmentByTag=");
                Class<NaviFragment> cls2 = NaviFragment.class;
                sb2.append(this.h.p0(cls2.getSimpleName()));
                CLog.b(str, sb2.toString());
                if (!this.k.isAdded()) {
                    this.i.c(R.id.fragement_container_layout, this.k, cls2.getSimpleName());
                    G1(this.k, searchModel, z, i2);
                }
            } else {
                CLog.b(str, "selection isIsNaving()=" + NaviUtil.u0());
                this.k.S0(searchModel, z, i2);
                this.i.B(this.k);
            }
        }
        this.h.l0();
        this.i.k();
    }

    public final void G1(BaseFragment baseFragment, SearchModel searchModel, boolean z, int i2) {
        try {
            Bundle bundle = new Bundle();
            bundle.putBoolean("direct_navi_key", z);
            bundle.putSerializable("search_info_key", searchModel);
            bundle.putSerializable("navi_from_quik_key", Integer.valueOf(i2));
            if (baseFragment != null) {
                baseFragment.setArguments(bundle);
            }
        } catch (IllegalStateException e) {
            String str = v;
            CLog.b(str, "setArgumentsData excep is:" + e);
        }
    }

    public final void H1() {
        if (this.l != null) {
            String str = v;
            CLog.b(str, "setData curSearchModel)=" + this.l.toString());
            BaseFragment baseFragment = this.j;
            if (baseFragment != null) {
                baseFragment.k0();
            }
            F1(this.l, this.m, this.n, 1);
            return;
        }
        String str2 = v;
        CLog.b(str2, "setData curSearchModel) isIsNaving()=" + NaviUtil.u0());
        F1((SearchModel) null, false, this.n, NaviUtil.u0() ? 1 : 0);
    }

    public final void I1(boolean z) {
        NaviUtil.g1(z);
        if (NaviOperatorManager.getInstance(this).getNaviStateListener() != null) {
            NaviOperatorManager.getInstance(this).getNaviStateListener().b(z);
        }
    }

    public final void J1(BaseFragment baseFragment, boolean z) {
        try {
            Bundle bundle = new Bundle();
            bundle.putBoolean("map_navi_key", z);
            if (baseFragment != null) {
                baseFragment.setArguments(bundle);
            }
        } catch (IllegalStateException e) {
            String str = v;
            CLog.b(str, "setSearchArguments excep is:" + e);
        }
    }

    public void K1() {
        boolean b = CSharedPreferences.b(this, "navi_show_back_ground_location_guid", true);
        String str = v;
        CLog.b(str, "showBackGroundPermissionDialog  showGuide=" + b + " NaviUtil.isIsNaving()=" + NaviUtil.u0() + " curSearchModel=" + this.l + " needSetPermission=" + NaviUtil.S0(this));
        if (!b || this.l != null || NaviUtil.u0()) {
            CLog.b(str, "showBackGroundPermissionDialog  Navi curSearchModel is null.");
        } else if (NaviUtil.o(this).size() <= 0) {
            CLog.b(str, "showBackGroundPermissionDialog  Navi has  Background Permissions.");
        } else {
            this.s = true;
            CustomDialog customDialog = new CustomDialog(this);
            this.r = customDialog;
            customDialog.c(true);
            this.r.a(false);
            this.r.setCancelable(false);
            this.r.d(true);
            this.r.j(getString(R.string.background_local_title)).i(getString(R.string.background_local_message)).b(new n0()).e(getString(R.string.navi_location_not_set), new o0(this)).f(getString(R.string.navi_location_update_set), new p0(this)).show();
        }
    }

    public final void L1() {
        PermissionUtil.f(this, 100008, new PermissionUtil.IPermissionSettings() {
            public void a() {
                CLog.b(NaviFragmentActivity.v, "onSettings   ");
                NaviFragmentActivity.this.p = true;
            }

            public void b() {
                CLog.b(NaviFragmentActivity.v, "onQuit   ");
            }
        });
    }

    public final boolean M1() {
        if (NaviUtil.S0(this) || NaviUtil.u0()) {
            return false;
        }
        CustomDialog customDialog = this.q;
        return customDialog == null || !customDialog.isShowing();
    }

    public void N1(boolean z) {
        String str = v;
        CLog.b(str, "updateFragmentShowMap  isIsNaving=" + NaviUtil.u0());
        if (this.j != null && NaviUtil.u0()) {
            this.j.P0(z);
        }
    }

    public void O0(int i2) {
        if (!NaviUtil.D0(getApplicationContext())) {
            UToast.e(getApplicationContext(), R.string.network_no_available, 0);
        } else {
            LocationUtil.e(this, i2, new LocationUtil.LocationCallback() {
                public void a() {
                    CLog.b(NaviFragmentActivity.v, "onClickLocation onRefuseOpenGps() ");
                }

                public void b() {
                }
            });
        }
    }

    public void R0(float f) {
        BaseFragment baseFragment = this.j;
        if (baseFragment != null) {
            baseFragment.T0(f);
        }
        BaseFragment baseFragment2 = this.k;
        if (baseFragment2 != null) {
            baseFragment2.T0(f);
        }
    }

    public void changeNavi(int i2, INaviActionResult iNaviActionResult) {
        runOnUiThread(new e0(this, i2, iNaviActionResult));
    }

    public void changeRoute(int i2, INaviActionResult iNaviActionResult) {
        runOnUiThread(new j0(this, i2, iNaviActionResult));
    }

    public String getNaviDestination() {
        BaseFragment baseFragment = this.k;
        return baseFragment != null ? baseFragment.s0() : "";
    }

    public final void i1() {
        if (this.j == null) {
            j1(SearchFragment.class.getSimpleName());
        }
        if (this.k == null) {
            j1(NaviFragment.class.getSimpleName());
        }
    }

    public void initViewModel() {
        CLog.b(v, "initViewModel  #### ");
    }

    public boolean isTrafficEnabled() {
        BaseFragment baseFragment = this.k;
        if (baseFragment != null) {
            return baseFragment.y0();
        }
        return false;
    }

    public void j(boolean z) {
        BaseFragment baseFragment = this.k;
        if (baseFragment != null) {
            baseFragment.A0(z);
        }
    }

    public final void j1(String str) {
        Fragment p0 = this.h.p0(str);
        String str2 = v;
        CLog.b(str2, "clearFragment  tag=" + str + " fragment=" + p0);
        if (p0 != null) {
            FragmentTransaction s2 = getSupportFragmentManager().s();
            s2.s(p0);
            s2.n(p0);
            s2.k();
            return;
        }
        CLog.b(str2, "clearFragment fragment is  null!");
    }

    public void k(boolean z) {
        BaseFragment baseFragment = this.j;
        if (baseFragment != null) {
            baseFragment.B0(z);
        }
        BaseFragment baseFragment2 = this.k;
        if (baseFragment2 != null) {
            baseFragment2.B0(z);
        }
    }

    public final void k1(StarryNetMessage starryNetMessage) {
        String message = starryNetMessage.getMessage();
        if (message.contains(CmdAction.CMD_DIALOG_CONFIRM) && message.contains("restore_navi")) {
            CLog.b(v, "dealAbnormalExitNaviMessage: NOTIFICATION_RSP_CONFIRM");
            CustomDialog customDialog = this.q;
            if (customDialog != null) {
                customDialog.dismiss();
            }
        } else if (message.contains(CmdAction.CMD_DIALOG_CANCEL) && message.contains("restore_navi")) {
            CLog.b(v, "dealAbnormalExitNaviMessage: NOTIFICATION_RSP_CANCEL");
            NaviUtil.T0(getApplicationContext());
            NotifyUtils.g(0);
            CustomDialog customDialog2 = this.q;
            if (customDialog2 != null) {
                customDialog2.dismiss();
            }
        }
    }

    public final void l1() {
        if (NaviUtil.s0() && this.k != null) {
            j1(NaviFragment.class.getSimpleName());
            this.k = null;
        }
    }

    public final void m1(Intent intent) {
        if (intent != null) {
            this.l = (SearchModel) intent.getSerializableExtra("search_info_key");
            this.m = intent.getBooleanExtra("direct_navi_key", false);
            this.n = intent.getIntExtra("navi_from_quik_key", 0);
            this.o = intent.getBooleanExtra("map_navi_key", false);
            String str = v;
            CLog.b(str, "getBundleData directNavi=" + this.m + " quikEnterType=" + this.n + " showMap=" + this.o);
            if (this.l != null) {
                CLog.b(str, "getBundleData curSearchModel)=" + this.l.toString());
            }
            N1(this.o);
            C1(intent);
        }
    }

    public final void n1(FragmentTransaction fragmentTransaction, int i2) {
        BaseFragment baseFragment;
        if (i2 == 0) {
            BaseFragment baseFragment2 = this.k;
            if (baseFragment2 != null) {
                fragmentTransaction.q(baseFragment2);
            }
        } else if (i2 == 1 && (baseFragment = this.j) != null) {
            fragmentTransaction.q(baseFragment);
        }
    }

    public final /* synthetic */ void o1(int i2, INaviActionResult iNaviActionResult) {
        BaseFragment baseFragment = this.k;
        if (baseFragment != null) {
            baseFragment.h0(i2, iNaviActionResult);
        }
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        CLog.b(v, "onActivityResult() &&&&&&& #######.");
        if (1003 == i2) {
            O0(i2);
        }
    }

    public void onBackPressed() {
        String str = v;
        CLog.b(str, "onBackPressed  Enter ");
        BaseFragment baseFragment = this.k;
        if (baseFragment == null || !baseFragment.isVisible()) {
            BaseFragment baseFragment2 = this.j;
            if (baseFragment2 == null || !baseFragment2.isVisible()) {
                CLog.b(str, "onBackPressed  &&&&&&&&&& ");
                return;
            }
            CLog.b(str, "onBackPressed  ### ");
            this.j.onBackPressed();
            return;
        }
        CLog.b(str, "onBackPressed  $$$$$$$ ");
        this.k.onBackPressed();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String str = v;
        CLog.b(str, "onCreate getDeviceId=" + LocationManager.f().e(this));
        NaviControlManager.k().y(getApplicationContext());
        ActivityManager.getInstance().add(this);
        setContentView(R.layout.activity_navi_fragement);
        I1(true);
        NaviUtil.o1((NaviHomeBean) null);
        NaviManager.getInstance(getApplicationContext());
        IConnectionManager.c().a(this);
        ConnectionManager.getInstance(getApplicationContext()).registerConnectivityReceiver();
        INetDeviceManager.b().a(this);
        ILocationManager.b().a(this);
        INavigationManager.b().a(this);
        m1(getIntent());
        H0();
        this.h = getSupportFragmentManager();
        H1();
        if (!NaviUtil.S0(this)) {
            K1();
        }
        I0();
    }

    public void onDestroy() {
        super.onDestroy();
        String str = v;
        CLog.b(str, " onDestroy() isNaviStarted=" + NaviUtil.B0() + " isFinishing()=" + isFinishing());
        ActivityManager.getInstance().remove(this);
        ActivityManager.getInstance().finishAll();
        NaviUtil.d1(false);
        I1(false);
        NaviUtil.i1(false);
        NaviUtil.n1(false);
        NaviUtil.f1(false);
        NaviUtil.m();
        ConnectionManager.getInstance(getApplicationContext()).unregisterConnectivityReceiver();
        INavigationManager.b().d(this);
        INetDeviceManager.b().d(this);
        ILocationManager.b().d(this);
        IConnectionManager.c().d(this);
        CLog.b(str, " onDestroy() isIsNaving=" + NaviUtil.u0() + " getNaviHomeBean=" + NaviUtil.P());
        if (!NaviUtil.B0() && NaviUtil.P() == null) {
            StarryNetManger.getInstance().unRegister();
            NaviOperatorManager.getInstance(getApplicationContext()).stopLocation();
        }
    }

    public void onMessageReceive(StarryNetMessage starryNetMessage) {
        k1(starryNetMessage);
        BaseFragment baseFragment = this.j;
        if (baseFragment != null) {
            baseFragment.F0(starryNetMessage);
        }
        BaseFragment baseFragment2 = this.k;
        if (baseFragment2 != null) {
            baseFragment2.F0(starryNetMessage);
        }
    }

    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent != null) {
            CLog.b(v, "onNewIntent  ####### ");
            m1(intent);
            H1();
            return;
        }
        CLog.b(v, "onNewIntent  intent is null");
    }

    public void onPause() {
        super.onPause();
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i2, strArr, iArr);
        CLog.b(v, "onRequestPermissionsResult  requestCode " + i2 + " hasBgDialogShow=" + this.s);
        if (1003 == i2) {
            for (int i3 : iArr) {
                if (i3 == -1) {
                    L1();
                    return;
                }
            }
            O0(i2);
        }
        if (508 == i2 && NaviUtil.S0(this)) {
            L1();
        } else if (!NaviUtil.S0(this) && !this.s) {
            K1();
        }
        NaviOperatorManager.getInstance(getApplicationContext()).startLocation(getApplicationContext());
    }

    public void onResume() {
        super.onResume();
        String str = v;
        CLog.b(str, "onResume Enter! showSettings=" + this.p);
        if (this.p && NaviUtil.S0(this)) {
            CLog.b(str, "onResume  @@@@@@ ");
            this.p = false;
            L1();
        } else if (!NaviUtil.S0(this)) {
            CLog.b(str, "onResume  #### ");
            NaviOperatorManager.getInstance(getApplicationContext()).startLocation(getApplicationContext());
            if (!this.s) {
                K1();
            }
        }
        if (M1()) {
            D1();
        }
    }

    public void onStart() {
        super.onStart();
        String str = v;
        CLog.b(str, " onStart() isNaviHome=" + NaviUtil.z0());
        NaviUtil.n1(false);
    }

    public void onStop() {
        super.onStop();
        String str = v;
        CLog.b(str, " onStop() isNaviHome=" + NaviUtil.z0());
    }

    public final /* synthetic */ void p1(int i2, INaviActionResult iNaviActionResult) {
        BaseFragment baseFragment = this.k;
        if (baseFragment != null) {
            baseFragment.i0(i2, iNaviActionResult);
        }
    }

    public void q(ULocation uLocation, PlaceBean placeBean) {
        BaseFragment baseFragment = this.j;
        if (baseFragment != null) {
            baseFragment.E0(uLocation, placeBean);
        }
        BaseFragment baseFragment2 = this.k;
        if (baseFragment2 != null) {
            baseFragment2.E0(uLocation, placeBean);
        }
    }

    public final /* synthetic */ void q1() {
        BaseFragment baseFragment = this.k;
        if (baseFragment != null) {
            baseFragment.l0();
        }
    }

    public final /* synthetic */ void r1(SearchModel searchModel, boolean z, int i2, int i3) {
        String str = v;
        CLog.b(str, "searchFragment onFragmentChanged from=" + i2 + " to=" + i3 + " directShow=" + z);
        E1(searchModel, z, i2, i3);
    }

    public boolean readTrafficInfo(int i2) {
        String str = v;
        CLog.b(str, "readTrafficInfo Enter frontDistance=" + i2);
        BaseFragment baseFragment = this.k;
        if (baseFragment != null) {
            return baseFragment.H0(i2);
        }
        return false;
    }

    public boolean refreshNavi() {
        BaseFragment baseFragment = this.k;
        if (baseFragment != null) {
            return baseFragment.I0();
        }
        return false;
    }

    public void restartNaviTask(SearchModel searchModel, int i2, boolean z) {
        runOnUiThread(new m0(this, searchModel, i2, z));
    }

    public final /* synthetic */ void s1(SearchModel searchModel, boolean z, int i2, int i3) {
        String str = v;
        CLog.b(str, "naviFragment onFragmentChanged from=" + i2 + " to=" + i3 + " directShow=" + z);
        E1(searchModel, z, i2, i3);
    }

    public void setNaviSpeak(boolean z) {
        runOnUiThread(new f0(this, z));
    }

    public void setTrafficEnabled(boolean z) {
        runOnUiThread(new g0(this, z));
    }

    public void stopNavi() {
        String str = v;
        CLog.b(str, "stopNavi  isNaviStarted()=" + NaviUtil.B0() + " isIsNaving=" + NaviUtil.u0());
        runOnUiThread(new r0(this));
    }

    public void t(boolean z) {
        BaseFragment baseFragment = this.j;
        if (baseFragment != null) {
            baseFragment.G0(z);
        }
        BaseFragment baseFragment2 = this.k;
        if (baseFragment2 != null) {
            baseFragment2.G0(z);
        }
    }

    public final /* synthetic */ void t1(SearchModel searchModel, int i2, boolean z) {
        BaseFragment baseFragment = this.k;
        if (baseFragment != null) {
            baseFragment.J0(searchModel, i2, z);
        }
    }

    public final /* synthetic */ void u1(View view) {
        this.q.dismiss();
        NaviUtil.B1(getApplicationContext());
        NaviUtil.n();
        CustomDialog customDialog = this.r;
        if (customDialog != null) {
            customDialog.dismiss();
        }
    }

    public final /* synthetic */ void v1(View view) {
        this.q.dismiss();
        NotifyUtils.g(0);
        NaviUtil.T0(getApplicationContext());
        NaviUtil.n();
    }

    public void w() {
        BaseFragment baseFragment = this.j;
        if (baseFragment != null) {
            baseFragment.D0();
        }
        BaseFragment baseFragment2 = this.k;
        if (baseFragment2 != null) {
            baseFragment2.D0();
        }
    }

    public final /* synthetic */ void w1(boolean z) {
        BaseFragment baseFragment = this.k;
        if (baseFragment != null) {
            baseFragment.N0(z);
        }
    }

    public final /* synthetic */ void x1(boolean z) {
        BaseFragment baseFragment = this.k;
        if (baseFragment != null) {
            baseFragment.Q0(z);
        }
    }

    public final /* synthetic */ void z1(View view) {
        this.r.dismiss();
        this.r = null;
        CLog.b(v, "showBackGroundPermissionDialog setsCancel Enter.");
    }
}
