package com.upuphone.ar.navi.lite.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import com.honey.account.m4.c;
import com.honey.account.m4.d;
import com.honey.account.m4.e;
import com.upuphone.ar.navi.lite.BuildConfig;
import com.upuphone.ar.navi.lite.R;
import com.upuphone.ar.navi.lite.base.NaviHomeBean;
import com.upuphone.ar.navi.lite.base.NaviLaneInfo;
import com.upuphone.ar.navi.lite.base.PlaceBean;
import com.upuphone.ar.navi.lite.base.SearchModel;
import com.upuphone.ar.navi.lite.base.UNaviPoi;
import com.upuphone.ar.navi.lite.location.LocationManager;
import com.upuphone.ar.navi.lite.manger.ConnectionManager;
import com.upuphone.ar.navi.lite.manger.NaviDataTrackManager;
import com.upuphone.ar.navi.lite.manger.NaviManager;
import com.upuphone.ar.navi.lite.manger.NaviOperatorManager;
import com.upuphone.ar.navi.lite.manger.NaviTtsManager;
import com.upuphone.ar.navi.lite.manger.StarryNetManger;
import com.upuphone.ar.navi.lite.model.IConnection;
import com.upuphone.ar.navi.lite.model.IConnectionManager;
import com.upuphone.ar.navi.lite.model.INaviEvent;
import com.upuphone.ar.navi.lite.model.INavigation;
import com.upuphone.ar.navi.lite.model.INavigationManager;
import com.upuphone.ar.navi.lite.model.INetDevice;
import com.upuphone.ar.navi.lite.model.INetDeviceManager;
import com.upuphone.ar.navi.lite.navi.NaviControlManager;
import com.upuphone.ar.navi.lite.naviview.NaviView;
import com.upuphone.ar.navi.lite.protocol.DataBean;
import com.upuphone.ar.navi.lite.protocol.NaviInfoBean;
import com.upuphone.ar.navi.lite.protocol.NotifyUtils;
import com.upuphone.ar.navi.lite.protocol.ProtocolUtils;
import com.upuphone.ar.navi.lite.util.CLog;
import com.upuphone.ar.navi.lite.util.CSharedPreferences;
import com.upuphone.ar.navi.lite.util.JsonUtil;
import com.upuphone.ar.navi.lite.util.LocationUtil;
import com.upuphone.ar.navi.lite.util.NaviExitType;
import com.upuphone.ar.navi.lite.util.NaviUtil;
import com.upuphone.star.common.phone.UToast;
import com.upuphone.xr.interconnect.common.INaviActionResult;
import com.upuphone.xr.interconnect.entity.StarryNetMessage;
import com.upuphone.xr.interconnect.listener.SendMessageListener;
import com.upuphone.xr.sapp.monitor.starry.cmd.CmdAction;
import java.lang.ref.WeakReference;
import sdk.meizu.account.factor.authentication.sdk.FactorAuthenticationUtil;

public class NaviService extends Service implements INaviEvent, INavigation, INetDevice, IConnection {
    public static final String q = ("NAVI-" + NaviService.class.getSimpleName());
    public static SearchModel r;
    public static boolean s = false;
    public static int t = 0;

    /* renamed from: a  reason: collision with root package name */
    public NaviView f5803a;
    public int[] b;
    public SearchModel c;
    public UNaviPoi d;
    public UNaviPoi e;
    public boolean f = false;
    public boolean g = false;
    public int h = -1;
    public int i = -1;
    public int j = 10;
    public INaviActionResult k;
    public INaviActionResult l;
    public boolean m = false;
    public boolean n = false;
    public ServiceHandler o = null;
    public final IBinder p = new LocalBinder();

    public class LocalBinder extends Binder {
        public LocalBinder() {
        }

        public NaviService getService() {
            return NaviService.this;
        }
    }

    public static class ServiceHandler extends Handler {

        /* renamed from: a  reason: collision with root package name */
        public WeakReference f5804a;

        public ServiceHandler(NaviService naviService) {
            this.f5804a = new WeakReference(naviService);
        }

        public void handleMessage(Message message) {
            NaviService naviService = (NaviService) this.f5804a.get();
            if (naviService != null) {
                int i = message.what;
                if (i != 5100) {
                    if (i == 5200) {
                        removeMessages(5200);
                        naviService.E0(true);
                    } else if (i == 5300) {
                        removeMessages(5300);
                        naviService.E0(false);
                    } else if (i != 5400) {
                        CLog.b(NaviService.q, "default  handleMessage");
                    } else {
                        removeMessages(5400);
                        naviService.N();
                        naviService.O();
                    }
                } else if (NaviControlManager.k().A()) {
                    NaviControlManager.k().Q();
                    NaviControlManager.k().P();
                    naviService.B(NaviExitType.PHONE_NAVI_COMPLETE_EXIT);
                } else {
                    removeMessages(5100);
                    sendEmptyMessageDelayed(5100, 1000);
                }
            }
        }
    }

    public static SearchModel C() {
        return r;
    }

    public static int H() {
        return t;
    }

    public static boolean R() {
        return s;
    }

    public void A(boolean z) {
        String str = q;
        CLog.b(str, "onDeviceConnectState isOnline=" + z + " isNaving=" + this.f + " isDeviceConnected()=" + Q() + " startedNavi=" + this.g + " isNaviReconnectDialogShow=" + NaviUtil.A0());
        this.g = !z ? false : this.g;
        if (!z && Q() && this.f) {
            long g2 = CSharedPreferences.g(this, "navi_disconnect_time", 0);
            if (!NaviUtil.A0()) {
                g2 = System.currentTimeMillis();
            }
            CSharedPreferences.u(this, "navi_disconnect_time", g2);
            new Handler().post(new e(this));
            NaviUtil.Y0(getApplicationContext().getApplicationContext(), r);
            Context applicationContext = getApplicationContext();
            NaviExitType naviExitType = NaviExitType.PHONE_MANUAL_EXIT;
            NaviUtil.f(applicationContext, naviExitType);
            B(naviExitType);
        }
        u0(z);
    }

    public final void A0() {
        long currentTimeMillis = System.currentTimeMillis();
        boolean isAssistantWakeup = ConnectionManager.getInstance(getApplicationContext()).isAssistantWakeup();
        String str = q;
        CLog.b(str, "startNavi  begin! startAck=" + currentTimeMillis + " assistantWakeup=" + isAssistantWakeup + " isNaving=" + this.f + " routeIdArray=" + this.b);
        NaviControlManager.k().K(5);
        I(true);
        NaviControlManager.k().L(this.f5803a);
        NaviControlManager.k().N(this.h);
        if (this.f || this.b == null) {
            x(F(), false);
            return;
        }
        boolean m2 = CSharedPreferences.m(getApplicationContext().getApplicationContext());
        CLog.b(str, "startNavi   voiceState=" + m2);
        C0(m2);
        if (isAssistantWakeup) {
            NaviControlManager.k().Q();
        }
        p0(currentTimeMillis);
        this.f = true;
        y0(true);
        x(F(), false);
        if (this.m) {
            this.m = false;
        } else {
            NaviControlManager.k().M();
        }
        CLog.b(str, "startNavi enter navMode=" + this.h + " quikEnterType= " + t + " startNaviPoiName()=" + this.d.getName() + " endNaviPoiName()=" + this.e.getName() + " getCurPosition() =" + LocationManager.f().d());
        NaviDataTrackManager.reportStartNaviTask(String.valueOf(t), String.valueOf(this.h), this.d.getName(), this.e.getName());
        NaviDataTrackManager.reportCommonAddressesNavTaskForBackThread(getApplicationContext(), r, LocationManager.f().d());
    }

    public final void B(NaviExitType naviExitType) {
        String str = q;
        CLog.b(str, "exitNavi: ####### naviExitType= " + naviExitType + " isIsNaviOpened=" + NaviUtil.t0());
        if (!NaviUtil.t0()) {
            k0(naviExitType);
            f0();
            NaviControlManager.k().d(this.f5803a);
            NaviControlManager.k().I((INaviEvent) null);
            y();
            NaviOperatorManager.getInstance(getApplicationContext()).stopLocation();
        }
        NaviDataTrackManager.reportCancelNaviTask(naviExitType, LocationManager.f().d(), "0");
        NaviControlManager.k().K(0);
        stopSelf();
    }

    public final void B0(boolean z) {
        boolean m2 = CSharedPreferences.m(getApplicationContext().getApplicationContext());
        String str = q;
        CLog.b(str, "updateNaviSpeakState: isWakeup=" + z + " voiceState" + m2);
        if (!m2) {
            return;
        }
        if (z) {
            NaviControlManager.k().Q();
        } else {
            NaviControlManager.k().O();
        }
    }

    public final void C0(boolean z) {
        if (z) {
            NaviControlManager.k().O();
        } else {
            NaviControlManager.k().Q();
        }
    }

    public void D(int i2, String str) {
        String str2 = q;
        CLog.b(str2, "onGetNavigationText  Enter!  text=" + str);
        boolean m2 = CSharedPreferences.m(getApplicationContext());
        if (!BuildConfig.b.booleanValue() && m2) {
            NaviTtsManager.getInstance(getApplicationContext()).startSpeak(str);
        }
    }

    public final void D0(String str) {
        if (!NaviUtil.t0()) {
            CSharedPreferences.z(getApplicationContext().getApplicationContext(), "1".equals(((DataBean) JsonUtil.b(str, DataBean.class)).getData()));
            new Handler().post(new c(this));
        }
    }

    public void E() {
        String str = q;
        CLog.b(str, "continueNavi startedNavi is:" + this.g + " isIsNaviOpened()=" + NaviUtil.t0());
        if (!this.g && !NaviUtil.t0()) {
            String i2 = ProtocolUtils.i(this.h, !CSharedPreferences.b(getApplicationContext().getApplicationContext(), "msg_mask", false), CSharedPreferences.e(getApplicationContext().getApplicationContext()), CSharedPreferences.b(getApplicationContext().getApplicationContext(), "navi_brightness", true), F(), System.currentTimeMillis());
            String c2 = NotifyUtils.c(getApplicationContext().getApplicationContext(), i2);
            CLog.b(str, "continueNavi dataMsg length is:" + i2.length() + " reqMsg length is:" + c2.length());
            StarryNetManger.getInstance().sendMessage(c2, "com.upuphone.star.launcher", (SendMessageListener) null);
        }
    }

    public final void E0(boolean z) {
        int i2 = 5200;
        this.o.removeMessages(5200);
        this.o.removeMessages(5300);
        if (t != 2 || NaviTtsManager.getInstance(getApplicationContext()).isPlayDone()) {
            CLog.b(q, "waitStartNavi, ######### success:" + z);
            W(z);
            if (z) {
                A0();
                return;
            }
            return;
        }
        Message message = new Message();
        if (!z) {
            i2 = 5300;
        }
        message.what = i2;
        this.o.sendMessageDelayed(message, 50);
    }

    public final NaviInfoBean F() {
        NaviInfoBean o2 = NaviControlManager.k().o();
        if (o2 != null) {
            String str = q;
            CLog.b(str, "getPreNaviInfo naviInfoBean=" + o2.toString());
            o2.setRouteRemainLightCount(NaviUtil.K(this.h));
        }
        return o2;
    }

    public void G() {
        String str = q;
        CLog.b(str, "onCalculateRouteFailure()  Enter.   isNaving=" + this.f + " isIsNaving=" + NaviUtil.u0());
        i0();
        m0(false);
        z(this.k, false, true);
        this.k = null;
        b0(false);
        z(this.l, false, true);
        this.l = null;
        E0(false);
        int n2 = NaviControlManager.k().n();
        NaviControlManager k2 = NaviControlManager.k();
        if (!NaviUtil.u0()) {
            n2 = 4;
        }
        k2.K(n2);
        if (!NaviUtil.u0()) {
            B(NaviExitType.PHONE_MANUAL_EXIT);
        }
    }

    public final void I(boolean z) {
        NaviControlManager.k().x(this.h, z);
    }

    public final void J() {
        NaviControlManager.k().v(getApplicationContext());
        NaviControlManager.k().I(this);
        new Handler().postDelayed(new d(this), 50);
    }

    public final void K(Intent intent) {
        this.c = NaviUtil.u0() ? r : null;
        r = (SearchModel) intent.getSerializableExtra("search_info_key");
        s = intent.getBooleanExtra("direct_navi_key", false);
        t = intent.getIntExtra("navi_from_quik_key", t);
    }

    public final void L(Context context) {
        if (BuildConfig.b.booleanValue()) {
            NaviView naviView = new NaviView(context.getApplicationContext());
            this.f5803a = naviView;
            naviView.k(new Bundle());
            NaviControlManager.k().w(this.f5803a);
        }
    }

    public final void M() {
        String str = q;
        CLog.b(str, "initNavi() NaviUtil.isIsNaving()=" + NaviUtil.u0() + " isNaving=" + this.f + " startedNavi=" + this.g);
        J();
        L(getApplicationContext());
        I(s);
    }

    public final void N() {
        PlaceBean j2 = LocationManager.f().j();
        if (j2 == null || r == null) {
            UToast.e(getApplicationContext(), R.string.gps_position_failed, 1);
            return;
        }
        this.d = new UNaviPoi(j2.getPoiName(), "", j2.getLatitude(), j2.getLongitude());
        this.e = new UNaviPoi(r.getName(), r.getAcode(), r.getLatitude(), r.getLongitude());
    }

    public final void O() {
        String str = q;
        CLog.b(str, "initNaviStart() isIsNaving()=" + NaviUtil.u0() + " isNaving=" + this.f + " startedNavi=" + this.g + " navMode=" + this.h);
        NaviHomeBean P = NaviUtil.P();
        if (P != null) {
            NaviManager.getInstance(getApplicationContext());
            x0(P);
            v0();
            x(F(), false);
        } else if (NaviUtil.u0()) {
            NaviUtil.o1((NaviHomeBean) null);
            NaviControlManager.k().Q();
            NaviControlManager.k().P();
            this.f = false;
            z0(r);
            o(this.h);
        } else {
            NaviUtil.o1((NaviHomeBean) null);
            P();
            z0(r);
            M();
        }
    }

    public final void P() {
        this.h = -1;
        this.i = -1;
        SearchModel searchModel = r;
        this.j = searchModel != null ? searchModel.getStrategy() : this.j;
        this.k = null;
        this.l = null;
        this.f = false;
        NaviUtil.h1(false);
        this.g = false;
        this.m = false;
        this.n = StarryNetManger.getInstance().isDeviceConnected();
        NaviUtil.t1(true);
        y0(false);
    }

    public boolean Q() {
        return this.n;
    }

    public final /* synthetic */ void S() {
        o(this.h);
    }

    public final /* synthetic */ void T() {
        UToast.e(getApplicationContext().getApplicationContext(), R.string.please_disconnected, 0);
    }

    public void U() {
        CLog.b(q, "onCalculateRouteSuccess()  Enter.  directNavi=" + s + " isDeviceConnected=" + StarryNetManger.getInstance().isDeviceConnected() + " isNaving=" + this.f + " isNaviModeSwitch=" + this.m + " isIsNaving=" + NaviUtil.u0());
        i0();
        z(this.k, true, true);
        this.k = null;
        z(this.l, true, true);
        this.l = null;
        int n2 = NaviControlManager.k().n();
        int[] q2 = NaviControlManager.k().q();
        this.b = q2;
        if (q2 == null) {
            NaviControlManager k2 = NaviControlManager.k();
            if (!NaviUtil.u0()) {
                n2 = 4;
            }
            k2.K(n2);
            UToast.e(getApplicationContext().getApplicationContext(), R.string.calculate_route_result_none, 1);
            if (!NaviUtil.u0()) {
                B(NaviExitType.PHONE_MANUAL_EXIT);
            }
        } else if (q2.length < 1) {
            NaviControlManager k3 = NaviControlManager.k();
            if (!NaviUtil.u0()) {
                n2 = 4;
            }
            k3.K(n2);
            UToast.e(getApplicationContext().getApplicationContext(), R.string.calculate_route_result_none, 1);
            if (!NaviUtil.u0()) {
                B(NaviExitType.PHONE_MANUAL_EXIT);
            }
        } else {
            NaviUtil.k1(getApplicationContext(), r, this.h, this.m);
            NaviControlManager k4 = NaviControlManager.k();
            if (!NaviUtil.u0()) {
                n2 = 3;
            }
            k4.K(n2);
            NaviControlManager.k().D(this.b[0]);
            if (s && StarryNetManger.getInstance().isDeviceConnected()) {
                E0(true);
            }
        }
    }

    public final /* synthetic */ void V() {
        C0(CSharedPreferences.m(getApplicationContext().getApplicationContext()));
    }

    public final void W(boolean z) {
        INaviActionResult homeActionResult = NaviOperatorManager.getInstance(getApplicationContext().getApplicationContext()).getHomeActionResult();
        if (homeActionResult != null) {
            CLog.b(q, "naviCalculateRouteResult  homeActionResult is not null.");
            z(homeActionResult, z, false);
        }
        INaviActionResult companyActionResult = NaviOperatorManager.getInstance(getApplicationContext().getApplicationContext()).getCompanyActionResult();
        if (companyActionResult != null) {
            CLog.b(q, "naviCalculateRouteResult  companyActionResult is not null.");
            z(companyActionResult, z, false);
        }
        INaviActionResult poiActionResult = NaviOperatorManager.getInstance(getApplicationContext().getApplicationContext()).getPoiActionResult();
        if (poiActionResult != null) {
            CLog.b(q, "naviCalculateRouteResult  poiActionResult is not null.");
            z(poiActionResult, z, false);
        }
        if (!(homeActionResult == null && companyActionResult == null && poiActionResult == null)) {
            h0(z);
        }
        NaviOperatorManager.getInstance(getApplicationContext()).setHomeActionResult((INaviActionResult) null);
        NaviOperatorManager.getInstance(getApplicationContext()).setCompanyActionResult((INaviActionResult) null);
        NaviOperatorManager.getInstance(getApplicationContext()).setPoiActionResult((INaviActionResult) null);
    }

    public final void X(NaviInfoBean naviInfoBean) {
        if (NaviOperatorManager.getInstance(getApplicationContext().getApplicationContext()).getNaviStateListener() != null) {
            UNaviPoi uNaviPoi = this.e;
            String name = uNaviPoi != null ? uNaviPoi.getName() : "";
            int i2 = 0;
            int pathRetainDistance = naviInfoBean != null ? naviInfoBean.getPathRetainDistance() : 0;
            if (naviInfoBean != null) {
                i2 = naviInfoBean.getPathRemainTime();
            }
            NaviOperatorManager.getInstance(getApplicationContext().getApplicationContext()).getNaviStateListener().a(name, pathRetainDistance, i2);
        }
    }

    public final void Y(int i2) {
        String str = q;
        CLog.b(str, "naviModeChange   navMode=" + this.h);
        this.h = i2;
        o(i2);
    }

    public final void Z() {
        this.g = this.f ? true : this.g;
        if (getApplicationContext() != null) {
            getApplicationContext().getApplicationContext().sendBroadcast(new Intent("com.upuphone.action_close_ar_media"));
        }
    }

    public final void a0(String str) {
        String str2 = q;
        CLog.b(str2, "naviStopFromGlass: isIsNaviOpened()=" + NaviUtil.t0());
        NaviExitType naviExitType = "1".equals(((DataBean) JsonUtil.b(str, DataBean.class)).getData()) ? NaviExitType.GLASS_ABNORMAL_EXIT : NaviExitType.GLASS_MANUAL_EXIT;
        NaviUtil.f(getApplicationContext(), naviExitType);
        B(naviExitType);
    }

    public final void b0(boolean z) {
        if (p(z)) {
            if (NaviControlManager.k().z()) {
                int i2 = this.h;
                String g2 = i2 == 2 ? ProtocolUtils.g("navi_switch_rsp", i2, FactorAuthenticationUtil.CODE_ERROR_TOKEN_NULL) : i2 == 1 ? ProtocolUtils.g("navi_switch_rsp", i2, FactorAuthenticationUtil.CODE_ERROR_MODE_NULL) : "";
                this.m = false;
                q0(g2);
                g0(false);
                Y(0);
                return;
            }
            q0(ProtocolUtils.g("navi_switch_rsp", this.h, "0"));
        }
    }

    public final void c0(boolean z, INaviActionResult iNaviActionResult) {
        if (z) {
            try {
                iNaviActionResult.actionFailure(getString(R.string.near_location_info), 10004);
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        } else {
            iNaviActionResult.actionFailure(getString(R.string.calculate_route_failed), 3);
        }
    }

    public void changeNavi(int i2, INaviActionResult iNaviActionResult) {
        String str = q;
        CLog.b(str, "changeNavi  naviMode=" + i2 + " NaviUtil.isIsNaviOpened()=" + NaviUtil.t0());
        if (!NaviUtil.t0()) {
            StarryNetManger.getInstance().sendMessage(ProtocolUtils.g("navi_mode_switch", i2, " " + this.h), (SendMessageListener) null);
            this.k = iNaviActionResult;
            s = true;
            this.m = true;
            this.i = i2;
            NaviDataTrackManager.reportChangeWaysModeTask(String.valueOf(this.h), String.valueOf(i2), LocationManager.f().d());
            NaviControlManager.k().P();
            this.f = false;
            g0(false);
            Y(i2);
        }
    }

    public void changeRoute(int i2, INaviActionResult iNaviActionResult) {
        String str = q;
        CLog.b(str, "changeRoute  strategy=" + i2 + " isIsNaviOpened=" + NaviUtil.t0());
        if (!NaviUtil.t0()) {
            this.l = iNaviActionResult;
            this.j = i2;
            o(this.h);
        }
    }

    public final void d0(NaviInfoBean naviInfoBean, boolean z, int i2, boolean z2, long j2) {
        String str = q;
        CLog.b(str, "openAndStartGlass  isIsNaviOpened()=" + NaviUtil.t0() + " naviInfo=" + naviInfoBean);
        if (!NaviUtil.t0() && naviInfoBean != null) {
            CLog.b(str, "openAndStartGlass  @@@@@@");
            String i3 = ProtocolUtils.i(this.h, z, i2, z2, naviInfoBean, j2);
            String c2 = NotifyUtils.c(getApplicationContext().getApplicationContext(), i3);
            CLog.b(str, "openAndStartGlass dataMsg length is:" + i3.length() + " reqMsg length is:" + c2.length());
            StarryNetManger.getInstance().sendMessage(c2, "com.upuphone.star.launcher", (SendMessageListener) null);
            l0();
        }
    }

    public final void e0(boolean z) {
        INaviActionResult poiActionResult = NaviOperatorManager.getInstance(getApplicationContext()).getPoiActionResult();
        if (poiActionResult != null) {
            c0(z, poiActionResult);
            h0(false);
            NaviOperatorManager.getInstance(getApplicationContext()).setPoiActionResult((INaviActionResult) null);
        } else {
            CLog.b(q, "poiAiNaviFailedResult  Enter poiActionResult is null.");
        }
        INaviActionResult companyActionResult = NaviOperatorManager.getInstance(getApplicationContext()).getCompanyActionResult();
        if (companyActionResult != null) {
            c0(z, companyActionResult);
            h0(false);
            NaviOperatorManager.getInstance(getApplicationContext()).setCompanyActionResult((INaviActionResult) null);
        } else {
            CLog.b(q, "poiAiNaviFailedResult  Enter companyActionResult is null.");
        }
        INaviActionResult homeActionResult = NaviOperatorManager.getInstance(getApplicationContext()).getHomeActionResult();
        if (homeActionResult != null) {
            c0(z, homeActionResult);
            h0(false);
            NaviOperatorManager.getInstance(getApplicationContext()).setHomeActionResult((INaviActionResult) null);
            return;
        }
        CLog.b(q, "poiAiNaviFailedResult  Enter homeActionResult is null.");
    }

    public void f(boolean z) {
        String str = q;
        CLog.b(str, "onRefreshRouteResult()  Enter.  success=" + z);
        if (!NaviUtil.t0()) {
            NaviControlManager.k().E(this.f, this.h, z);
        }
    }

    public void f0() {
        this.f = false;
        s = false;
        this.m = false;
        NaviUtil.q1(false);
        NaviUtil.h1(false);
        NaviUtil.t1(true);
        y0(false);
        if (this.g) {
            StarryNetManger.getInstance().sendMessage(ProtocolUtils.g("navi_event", this.h, "navi_stop"), (SendMessageListener) null);
            this.g = false;
        }
        NotifyUtils.g(0);
        g0(false);
    }

    public final void g0(boolean z) {
        boolean z2 = z;
        PlaceBean j2 = LocationManager.f().j();
        if (j2 == null) {
            CLog.b(q, "resetNaviStartPoi() place is null .");
        } else if (j2.getLatitude() == 0.0d || j2.getLongitude() == 0.0d) {
            CLog.b(q, "resetNaviStartPoi() Latitude or Longitude is 0.0.");
        } else {
            String str = q;
            CLog.b(str, "resetNaviStartPoi() isPosReversed=" + z2);
            if (z2) {
                this.e = new UNaviPoi(j2.getPoiName(), j2.getPoiId(), j2.getLatitude(), j2.getLongitude());
            } else {
                this.d = new UNaviPoi(j2.getPoiName(), j2.getPoiId(), j2.getLatitude(), j2.getLongitude());
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0008, code lost:
        r2 = r2.e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String getNaviDestination() {
        /*
            r2 = this;
            boolean r0 = com.upuphone.ar.navi.lite.util.NaviUtil.t0()
            java.lang.String r1 = ""
            if (r0 != 0) goto L_0x0010
            com.upuphone.ar.navi.lite.base.UNaviPoi r2 = r2.e
            if (r2 == 0) goto L_0x0010
            java.lang.String r1 = r2.getName()
        L_0x0010:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.navi.lite.service.NaviService.getNaviDestination():java.lang.String");
    }

    public void h(int i2) {
        String str = q;
        CLog.b(str, "onRouteDeviation()  Enter.  meters=" + i2);
        if (!NaviUtil.t0()) {
            s = true;
            NaviControlManager.k().P();
            g0(false);
            Y(this.h);
        }
    }

    public final void h0(boolean z) {
        String str = q;
        CLog.b(str, "resumeLastNavi  success=" + z + " startedNavi=" + this.g);
        SearchModel searchModel = this.c;
        if (searchModel == null || !this.g || z) {
            this.c = null;
            return;
        }
        r = searchModel;
        N();
        z0(r);
        o(this.h);
    }

    public final void i0() {
        NaviView naviView = this.f5803a;
        if (naviView != null) {
            naviView.setShowMode(1);
        }
    }

    public boolean isTrafficEnabled() {
        CLog.b(q, "isTrafficEnabled  ");
        NaviView naviView = this.f5803a;
        if (naviView != null) {
            return naviView.getTrafficstatus();
        }
        return false;
    }

    public void j(boolean z) {
        B0(z);
    }

    public final void j0() {
        SearchModel j2 = NaviUtil.j(r);
        j2.setNaviMode(this.h);
        NaviUtil.T0(getApplicationContext());
        NaviUtil.X0(getApplicationContext(), j2, CSharedPreferences.f(this, "navi_latest_launch_mode", 0));
    }

    public void k(boolean z) {
        String str = q;
        CLog.b(str, "onBleConnectState connected=" + z);
    }

    public final void k0(NaviExitType naviExitType) {
        if (naviExitType == NaviExitType.NONE) {
            naviExitType = NaviExitType.PHONE_ABNORMAL_EXIT;
        }
        if (this.f) {
            NaviUtil.Z0(getApplicationContext(), naviExitType);
            NaviUtil.f(getApplicationContext(), naviExitType);
        }
    }

    public void l() {
        u("arrive_destination");
    }

    public final void l0() {
        NaviUtil.j0(getApplicationContext().getApplicationContext(), r);
        j0();
    }

    public void m(NaviLaneInfo naviLaneInfo) {
        CLog.b(q, "showLaneInfo ");
    }

    public final void m0(boolean z) {
        NaviControlManager.k().E(this.f, this.h, z);
    }

    public final void n0(NaviInfoBean naviInfoBean, boolean z) {
        if (!NaviUtil.t0()) {
            NaviUtil.a1();
            r0(z);
            if (naviInfoBean != null && NaviUtil.r0(naviInfoBean.getIconType())) {
                String str = q;
                CLog.b(str, "sendNaviChangeMessage  naviInfo.toString():" + naviInfoBean.toString());
                StarryNetManger.getInstance().sendMessage(ProtocolUtils.h(naviInfoBean), (SendMessageListener) null);
            }
        }
    }

    public void o(int i2) {
        String str = q;
        CLog.b(str, "calculateNaviRoute   mode=" + i2 + " isIsNaving=" + NaviUtil.u0());
        if (!NaviUtil.F0(this.d, this.e)) {
            CLog.b(str, "calculateNaviRoute   Poi is not  Available ");
            NaviControlManager.k().K(4);
            e0(false);
            if (!NaviUtil.u0()) {
                B(NaviExitType.PHONE_MANUAL_EXIT);
                return;
            }
            return;
        }
        CLog.b(str, "calculateNaviRoute   navMode=" + this.h + " startNaviPoi=" + this.d.toString() + "  endNaviPoi=" + this.e.toString());
        NaviControlManager.k().K(2);
        int Y = NaviUtil.Y(getApplicationContext().getApplicationContext(), r, i2);
        this.h = Y;
        if (Y == 0) {
            NaviControlManager.k().a(this.d, this.e, this.j);
        } else if (Y == 1) {
            NaviControlManager.k().b(this.d, this.e);
        } else if (Y == 2) {
            NaviControlManager.k().c(this.d, this.e);
        }
        CLog.b(str, "calculateNaviRoute   End, ");
    }

    public final void o0() {
        NaviInfoBean W = NaviUtil.W();
        if (W == null) {
            W = F();
        }
        if (W != null && NaviUtil.r0(W.getIconType()) && this.f && !NaviUtil.t0()) {
            StarryNetManger.getInstance().sendMessage(ProtocolUtils.h(W), (SendMessageListener) null);
        }
        NaviUtil.r1((NaviInfoBean) null);
    }

    public IBinder onBind(Intent intent) {
        return this.p;
    }

    public void onCreate() {
        super.onCreate();
        CLog.b(q, "onCreate() Enter.");
        NaviManager.getInstance(getApplicationContext());
        NaviControlManager.k().y(getApplicationContext());
        if (NaviUtil.p(getApplicationContext()).size() <= 0) {
            NaviOperatorManager.getInstance(getApplicationContext()).startLocation(getApplicationContext());
        }
        ConnectionManager.getInstance(getApplicationContext()).registerConnectivityReceiver();
        IConnectionManager.c().a(this);
        INetDeviceManager.b().a(this);
        INavigationManager.b().a(this);
        this.o = new ServiceHandler(this);
    }

    public void onDestroy() {
        super.onDestroy();
        String str = q;
        CLog.b(str, "onDestroy() Enter. NaviUtil.isIsNaviOpened()=" + NaviUtil.t0());
        y();
        NaviUtil.o1((NaviHomeBean) null);
        r = null;
        this.c = null;
        s = false;
        t = 0;
        if (!NaviUtil.t0()) {
            NaviUtil.m();
        }
        if (!NaviUtil.e0(getApplicationContext())) {
            CSharedPreferences.u(this, "navi_disconnect_time", 0);
        }
        ConnectionManager.getInstance(getApplicationContext()).unregisterConnectivityReceiver();
        IConnectionManager.c().d(this);
        INetDeviceManager.b().d(this);
        INavigationManager.b().d(this);
        ServiceHandler serviceHandler = this.o;
        if (serviceHandler != null) {
            serviceHandler.removeMessages(5100);
            this.o.removeMessages(5200);
            this.o.removeMessages(5300);
            this.o.removeMessages(5400);
        }
    }

    public void onMessageReceive(StarryNetMessage starryNetMessage) {
        String str = q;
        CLog.b(str, "onMessageReceive: starryNetMessage.getMessage():" + starryNetMessage.getMessage() + " getSenderPkg=" + starryNetMessage.getSenderPkg());
        String message = starryNetMessage.getMessage();
        if (!TextUtils.isEmpty(message)) {
            CLog.b(str, "onMessageReceive: startedNavi:" + this.g + " isNaviStarted()=" + NaviUtil.B0() + " isNaving=" + this.f + " isIsNaving=" + NaviUtil.u0());
            if (message.contains("navi_start_rsp")) {
                CLog.b(str, "onMessageReceive: NAVI_EVENT_START_RSP");
                NotifyUtils.g(0);
                Z();
                s0();
                o0();
                NaviControlManager.k().F();
                if (!NaviUtil.t0()) {
                    NaviUtil.b1(getApplicationContext().getApplicationContext(), this.g);
                }
            } else if (message.contains("navi_stop") && ((this.g || NaviUtil.B0()) && NaviUtil.u0())) {
                CLog.b(str, "onMessageReceive: NAVI_EVENT_STOP  data:navi_stop");
                NotifyUtils.g(0);
                a0(message);
            } else if (message.contains("speechMode") && this.g) {
                CLog.b(str, "onMessageReceive: NAVI_SETTINGS_SPEECH_MODE");
                D0(message);
            } else if (message.contains("show_map_partial_rsp") && this.g) {
                CLog.b(str, "onMessageReceive: NAVI_SHOW_MAP_PARTIAL_RSP");
            } else if (message.contains(CmdAction.CMD_DIALOG_CONFIRM) && message.contains("reconnection_navi")) {
                CLog.b(str, "onMessageReceive: NOTIFICATION_RSP_CONFIRM");
            } else if (message.contains(CmdAction.CMD_DIALOG_CANCEL) && message.contains("reconnection_navi")) {
                CLog.b(str, "onMessageReceive: NOTIFICATION_RSP_CANCEL");
                q();
            } else if ("System".equals(starryNetMessage.getSenderPkg())) {
                r();
            } else if (message.contains("navi_launch_mode")) {
                w0(message);
                if (!NaviUtil.u0() || NaviUtil.t0()) {
                    NaviUtil.T0(getApplicationContext());
                } else {
                    j0();
                }
            }
        }
    }

    public void onRebind(Intent intent) {
        super.onRebind(intent);
    }

    public int onStartCommand(Intent intent, int i2, int i3) {
        String str = q;
        CLog.b(str, "onStartCommand() Enter. getDeviceId=" + LocationManager.f().e(this));
        NaviControlManager.k().K(1);
        if (intent != null) {
            K(intent);
            this.o.sendEmptyMessage(5400);
            return 2;
        }
        CLog.b(str, "initNaviStart() intent is null, do nothing!");
        return 2;
    }

    public void onTaskRemoved(Intent intent) {
        super.onTaskRemoved(intent);
        CLog.b(q, "onTaskRemoved() Enter.");
        B(NaviExitType.GLASS_ABNORMAL_EXIT);
    }

    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }

    public final boolean p(boolean z) {
        String str = q;
        CLog.b(str, "canSendSwitchResultMessage  success=" + z + " isNaviModeSwitch=" + this.m);
        return !z && this.m;
    }

    public final void p0(long j2) {
        NaviInfoBean F = F();
        X(F);
        String str = q;
        CLog.b(str, "sendNaviReqMessage enter directNavi=" + s + " quikEnterType= " + t + " isNaving=" + this.f + " startedNavi=" + this.g + " isNaviModeSwitch=" + this.m + " isNaviStarted() =" + NaviUtil.B0());
        boolean b2 = CSharedPreferences.b(getApplicationContext().getApplicationContext(), "msg_mask", false) ^ true;
        int e2 = CSharedPreferences.e(getApplicationContext().getApplicationContext());
        boolean b3 = CSharedPreferences.b(getApplicationContext().getApplicationContext(), "navi_brightness", true);
        if (this.m) {
            this.m = false;
            n0(F, true);
        } else if (t == 2 && this.g) {
            n0(F, false);
            NaviUtil.a1();
            l0();
        } else if (!NaviUtil.B0() || NaviUtil.t0()) {
            d0(F, b2, e2, b3, j2);
        } else {
            StarryNetManger.getInstance().sendMessage(ProtocolUtils.j(this.h, b2, e2, b3, F, j2), (SendMessageListener) null);
            l0();
        }
    }

    public final void q() {
        NaviUtil.q1(false);
        if (this.f) {
            NaviControlManager.k().P();
        }
        B(NaviExitType.GLASS_MANUAL_EXIT);
    }

    public final void q0(String str) {
        if (!NaviUtil.t0()) {
            StarryNetManger.getInstance().sendMessage(str, (SendMessageListener) null);
        }
    }

    public final void r() {
        this.g = false;
        NaviUtil.V0();
        CSharedPreferences.u(this, "navi_disconnect_time", System.currentTimeMillis());
    }

    public final void r0(boolean z) {
        if (!NaviUtil.t0()) {
            String str = z ? "1" : FactorAuthenticationUtil.CODE_ERROR_CANCEL;
            String g2 = ProtocolUtils.g("navi_switch_rsp", this.h, str);
            String str2 = q;
            CLog.b(str2, "sendNaviSwitchRspMsg  data:" + g2 + " event=" + str);
            StarryNetManger.getInstance().sendMessage(g2, (SendMessageListener) null);
        }
    }

    public boolean readTrafficInfo(int i2) {
        String str = q;
        CLog.b(str, "readTrafficInfo Enter." + NaviUtil.t0());
        return NaviControlManager.k().B(i2);
    }

    public boolean refreshNavi() {
        boolean C = NaviControlManager.k().C(this.h, this.j);
        String str = q;
        CLog.b(str, "refreshNaviPath refresh  curStrategy=" + this.j + "  success=" + C);
        return C;
    }

    public void restartNaviTask(SearchModel searchModel, int i2, boolean z) {
        String str = q;
        CLog.b(str, "restartNaviTask Enter. isIsNaviOpened=" + NaviUtil.t0());
    }

    public void s(int i2) {
    }

    public final void s0() {
        if (this.f && !NaviUtil.t0()) {
            boolean m2 = CSharedPreferences.m(getApplicationContext().getApplicationContext());
            String str = q;
            CLog.b(str, "sendNaviTtsPlayStatus   voiceState=" + m2 + " isNaving=" + this.f);
            StarryNetManger.getInstance().sendMessage(ProtocolUtils.a("navi_tts", m2 ? "1" : "0"), (SendMessageListener) null);
        }
    }

    public void setNaviSpeak(boolean z) {
        String str = q;
        CLog.b(str, "setNaviSpeak  isOn=" + z + " isIsNaviOpened=" + NaviUtil.t0());
        if (!NaviUtil.t0()) {
            CSharedPreferences.z(getApplicationContext().getApplicationContext(), z);
            C0(z);
        }
    }

    public void setTrafficEnabled(boolean z) {
        NaviView naviView;
        String str = q;
        CLog.b(str, "setTrafficMap  isOn=" + z + " isTrafficLayerEnabled= isIsNaviOpened=" + NaviUtil.t0());
        if (!NaviUtil.t0() && (naviView = this.f5803a) != null) {
            naviView.n(z);
        }
    }

    public void stopNavi() {
        String str = q;
        CLog.b(str, "stopNavi Enter." + NaviUtil.t0());
        if (!NaviUtil.t0()) {
            B(NaviExitType.PHONE_MANUAL_EXIT);
        }
    }

    public void t(boolean z) {
        if (!NaviUtil.t0()) {
            StarryNetManger.getInstance().sendMessage(ProtocolUtils.g("network_state", this.h, z ? "1" : "0"), (SendMessageListener) null);
            boolean D0 = NaviUtil.D0(getApplicationContext().getApplicationContext());
            String str = q;
            CLog.b(str, "onNetConnectState ###############isNaving=" + this.f);
            if (!D0) {
                UToast.e(getApplicationContext().getApplicationContext(), R.string.network_anomaly, 0);
            }
        }
    }

    public final void t0() {
        String str = q;
        CLog.b(str, "sendStopNaviMsg   startedNavi=" + this.g + " isIsNaviOpened=" + NaviUtil.t0());
        if (this.g && !NaviUtil.t0()) {
            StarryNetManger.getInstance().sendMessage(ProtocolUtils.g("navi_event", this.h, "navi_stop"), (SendMessageListener) null);
            this.g = false;
            NaviUtil.q1(false);
        }
    }

    public final void u(String str) {
        if (!NaviUtil.t0()) {
            String str2 = q;
            CLog.b(str2, "dealNaviComplete()  Enter.  startedNavi=" + this.g + " cmd=" + str);
            StarryNetManger.getInstance().sendMessage(ProtocolUtils.g("navi_event", this.h, str), (SendMessageListener) null);
        }
        NaviUtil.m();
        NaviUtil.f(getApplicationContext(), NaviExitType.PHONE_NAVI_COMPLETE_EXIT);
        this.g = false;
        NaviUtil.q1(false);
        this.f = false;
        NaviUtil.h1(false);
        NaviUtil.m();
        NaviUtil.U0(getApplicationContext());
        this.o.sendEmptyMessageDelayed(5100, 1000);
        NaviDataTrackManager.reportCancelNaviForCancelTypeTask("0", LocationManager.f().d(), "1");
    }

    public void u0(boolean z) {
        this.n = z;
    }

    public void v() {
        CLog.b(q, "hideLaneInfo ");
    }

    public final void v0() {
        CLog.b(q, "setHomeNavi() ");
        NaviControlManager.k().K(5);
        NaviControlManager.k().I(this);
        L(getApplicationContext());
        I(s);
    }

    public void w() {
        boolean j2 = LocationUtil.j(getApplicationContext().getApplicationContext());
        String str = q;
        CLog.b(str, "onGpsStateChanged() isOpenGps=" + j2 + " isIsNaving=" + NaviUtil.u0());
        if (!j2 && NaviUtil.u0()) {
            t0();
            B(NaviExitType.PHONE_MANUAL_EXIT);
        }
    }

    public final void w0(String str) {
        try {
            CSharedPreferences.t(this, "navi_latest_launch_mode", "1".equals(((DataBean) JsonUtil.b(str, DataBean.class)).getData()) ? 1 : 0);
        } catch (Exception e2) {
            String str2 = q;
            CLog.b(str2, "setLaunchMode: excep=" + e2);
        }
    }

    public void x(NaviInfoBean naviInfoBean, boolean z) {
        if (this.f && !this.g && z) {
            CLog.b(q, "onNaviInfoUpdate() ######## need set Previous navi info.");
            NaviUtil.r1(naviInfoBean);
        }
        if (naviInfoBean != null && NaviUtil.r0(naviInfoBean.getIconType())) {
            X(naviInfoBean);
        }
        NaviUtil.b1(getApplicationContext().getApplicationContext(), this.g);
    }

    public final void x0(NaviHomeBean naviHomeBean) {
        String str = q;
        CLog.b(str, "setNaviHomeStatus() naviHomeBean=" + naviHomeBean.toString());
        this.k = naviHomeBean.getChangeNaviResult();
        this.l = naviHomeBean.getChangeRouteResult();
        s = naviHomeBean.isDirectNavi();
        this.h = naviHomeBean.getNavMode();
        this.i = naviHomeBean.getSwitchMode();
        this.j = naviHomeBean.getStrategy();
        this.g = naviHomeBean.isStartedNavi();
        this.m = naviHomeBean.isNaviModeSwitch();
        this.n = naviHomeBean.isDeviceConnected();
        this.f = true;
        NaviUtil.h1(true);
        NaviUtil.t1(false);
        y0(true);
    }

    public final void y() {
        NaviControlManager.k().e();
    }

    public final void y0(boolean z) {
        String str = q;
        CLog.b(str, "setNaviState isNaving=" + z);
        NaviUtil.h1(z);
        if (NaviOperatorManager.getInstance(getApplicationContext().getApplicationContext()).getNaviStateListener() != null) {
            NaviOperatorManager.getInstance(getApplicationContext().getApplicationContext()).getNaviStateListener().c(z);
        } else {
            CLog.b(str, "setNaviState getNaviStateListener is empty.");
        }
    }

    public final void z(INaviActionResult iNaviActionResult, boolean z, boolean z2) {
        if (iNaviActionResult != null) {
            CLog.b(q, "doActionResult  naviActionResult is not null.");
            try {
                String s2 = NaviControlManager.k().s();
                int r2 = NaviControlManager.k().r();
                if (z) {
                    iNaviActionResult.actionSuceess(s2, r2);
                } else {
                    iNaviActionResult.actionFailure(s2, r2);
                }
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        } else {
            CLog.b(q, "doActionResult  naviActionResult is null.");
        }
    }

    public final void z0(SearchModel searchModel) {
        String str = q;
        CLog.b(str, "setRealNaviMode directNavi =" + s + " quikEnterType=" + t + " navMode=" + this.h);
        this.h = NaviUtil.X(getApplicationContext(), searchModel);
        StringBuilder sb = new StringBuilder();
        sb.append("setRealNaviMode ###### complated! navMode=");
        sb.append(this.h);
        CLog.b(str, sb.toString());
    }
}
