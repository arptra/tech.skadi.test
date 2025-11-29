package com.upuphone.ar.navi.lite.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationSet;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.AutoCompleteTextView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.ConnectionResult;
import com.honey.account.g4.b;
import com.honey.account.g4.c;
import com.honey.account.g4.d;
import com.honey.account.g4.e;
import com.honey.account.g4.f;
import com.honey.account.g4.g;
import com.honey.account.g4.h;
import com.honey.account.g4.i;
import com.honey.account.g4.j;
import com.honey.account.g4.k;
import com.honey.account.g4.l;
import com.honey.account.g4.m;
import com.honey.account.g4.n;
import com.honey.account.g4.o;
import com.meizu.common.widget.MzContactsContract;
import com.meizu.net.pedometerprovider.util.Constants;
import com.upuphone.ar.navi.lite.BuildConfig;
import com.upuphone.ar.navi.lite.NaviPoiMarkActivity;
import com.upuphone.ar.navi.lite.R;
import com.upuphone.ar.navi.lite.SettingActivity;
import com.upuphone.ar.navi.lite.adapter.HistoryListAdapter;
import com.upuphone.ar.navi.lite.base.NaviHomeBean;
import com.upuphone.ar.navi.lite.base.NaviLaneInfo;
import com.upuphone.ar.navi.lite.base.PlaceBean;
import com.upuphone.ar.navi.lite.base.Record;
import com.upuphone.ar.navi.lite.base.SearchModel;
import com.upuphone.ar.navi.lite.base.ULatLng;
import com.upuphone.ar.navi.lite.base.ULocation;
import com.upuphone.ar.navi.lite.base.UNaviPoi;
import com.upuphone.ar.navi.lite.location.LocationManager;
import com.upuphone.ar.navi.lite.manger.ConnectionManager;
import com.upuphone.ar.navi.lite.manger.NaviDataTrackManager;
import com.upuphone.ar.navi.lite.manger.NaviOperatorManager;
import com.upuphone.ar.navi.lite.manger.NaviTtsManager;
import com.upuphone.ar.navi.lite.manger.StarryNetManger;
import com.upuphone.ar.navi.lite.map.NaviMap;
import com.upuphone.ar.navi.lite.model.INaviEvent;
import com.upuphone.ar.navi.lite.model.INaviMenu;
import com.upuphone.ar.navi.lite.navi.NaviControlManager;
import com.upuphone.ar.navi.lite.naviview.NaviView;
import com.upuphone.ar.navi.lite.protocol.DataBean;
import com.upuphone.ar.navi.lite.protocol.NaviInfoBean;
import com.upuphone.ar.navi.lite.protocol.NotifyUtils;
import com.upuphone.ar.navi.lite.protocol.ProtocolUtils;
import com.upuphone.ar.navi.lite.search.PoiSearchManager;
import com.upuphone.ar.navi.lite.service.NaviService;
import com.upuphone.ar.navi.lite.util.CLog;
import com.upuphone.ar.navi.lite.util.CSharedPreferences;
import com.upuphone.ar.navi.lite.util.DensityUtils;
import com.upuphone.ar.navi.lite.util.JsonUtil;
import com.upuphone.ar.navi.lite.util.LocationUtil;
import com.upuphone.ar.navi.lite.util.NaviExitType;
import com.upuphone.ar.navi.lite.util.NaviUtil;
import com.upuphone.ar.navi.lite.util.SensorEventHelper;
import com.upuphone.ar.navi.lite.view.AvoidLimitPopView;
import com.upuphone.ar.navi.lite.view.CustomDialog;
import com.upuphone.ar.navi.lite.view.DrawableCenterTextView;
import com.upuphone.ar.navi.lite.view.DriveWayLinear;
import com.upuphone.ar.navi.lite.view.NavInfoView;
import com.upuphone.ar.navi.lite.view.NaviFloatMenu;
import com.upuphone.ar.navi.lite.view.NaviMenuView;
import com.upuphone.ar.navi.lite.view.NaviProgressView;
import com.upuphone.ar.navi.lite.view.NaviStrategyMenu;
import com.upuphone.ar.navi.lite.view.NaviStrategyView;
import com.upuphone.ar.navi.lite.view.NaviTopView;
import com.upuphone.ar.navi.lite.view.RouteItemView;
import com.upuphone.ar.navi.lite.view.TitleView;
import com.upuphone.star.common.phone.UToast;
import com.upuphone.starrynet.common.utils.tracker.Ring2TrackerConstant;
import com.upuphone.xr.interconnect.common.INaviActionResult;
import com.upuphone.xr.interconnect.entity.StarryNetMessage;
import com.upuphone.xr.interconnect.listener.SendMessageListener;
import com.upuphone.xr.sapp.monitor.starry.cmd.CmdAction;
import com.xjsd.ai.assistant.protocol.AssistantConstants;
import com.xjsd.ai.assistant.protocol.CmdCode;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import sdk.meizu.account.factor.authentication.sdk.FactorAuthenticationUtil;

public class NaviFragment extends BaseFragment implements View.OnClickListener, View.OnTouchListener, INaviMenu, INaviEvent, NaviStrategyView.StrategyChangeListener, NaviTopView.NaviTopViewActionistener, NaviFloatMenu.INaviFloatMenu, HistoryListAdapter.ItemClickListener {
    public static final String w0 = ("NAVI-" + NaviFragment.class.getSimpleName());
    public TextView A;
    public NaviFloatMenu B;
    public View C;
    public RouteItemView D;
    public RouteItemView E;
    public RouteItemView F;
    public TitleView G;
    public NavInfoView H;
    public NaviMenuView I;
    public RelativeLayout J;
    public TextView K;
    public DriveWayLinear L;
    public NaviStrategyMenu M;
    public NaviStrategyView N;
    public int[] O;
    public UNaviPoi P;
    public UNaviPoi Q;
    public boolean R = false;
    public int S = -1;
    public int T = -1;
    public int U = -1;
    public SearchModel V;
    public SearchModel W;
    public boolean X = false;
    public int Y = 0;
    public boolean Z = false;
    public AnimationSet g0;
    public boolean h0 = false;
    public NaviView i;
    public boolean i0 = false;
    public DrawableCenterTextView j;
    public boolean j0 = false;
    public View k;
    public boolean k0 = false;
    public ImageView l;
    public AppHandler l0 = null;
    public NaviTopView m;
    public NaviMap m0;
    public RecyclerView n;
    public RelativeLayout n0;
    public HistoryListAdapter o;
    public boolean o0 = true;
    public boolean p = false;
    public int p0 = 10;
    public View q;
    public INaviActionResult q0;
    public View r;
    public INaviActionResult r0;
    public LinearLayout s;
    public int s0 = 0;
    public TextView t;
    public NaviExitType t0 = NaviExitType.NONE;
    public RelativeLayout u;
    public TextView u0;
    public RelativeLayout v;
    public boolean v0 = false;
    public ImageView w;
    public ImageView x;
    public TextView y;
    public TextView z;

    public static class AppHandler extends Handler {

        /* renamed from: a  reason: collision with root package name */
        public WeakReference f5765a;

        public AppHandler(NaviFragment naviFragment) {
            this.f5765a = new WeakReference(naviFragment);
        }

        public void handleMessage(Message message) {
            NaviFragment naviFragment = (NaviFragment) this.f5765a.get();
            if (naviFragment != null) {
                switch (message.what) {
                    case 200:
                        naviFragment.U3(true);
                        return;
                    case 300:
                        naviFragment.m.D();
                        return;
                    case CmdCode.CODE_WAKEUP_RECORDING /*400*/:
                        if (!NaviControlManager.k().A() || naviFragment.o0() == null) {
                            removeMessages(CmdCode.CODE_WAKEUP_RECORDING);
                            sendEmptyMessageDelayed(CmdCode.CODE_WAKEUP_RECORDING, 1000);
                            return;
                        }
                        NaviControlManager.k().Q();
                        NaviControlManager.k().P();
                        naviFragment.x2();
                        if (NaviUtil.z0() && naviFragment.getActivity() != null) {
                            naviFragment.getActivity().finish();
                            return;
                        }
                        return;
                    case 500:
                        naviFragment.j0 = false;
                        return;
                    case 600:
                        boolean m = CSharedPreferences.m(naviFragment.getContext().getApplicationContext());
                        naviFragment.m4(m);
                        naviFragment.r4(m);
                        return;
                    case 700:
                        NaviControlManager.k().M();
                        return;
                    case Constants.ANIMATION_DURATION /*800*/:
                        naviFragment.k0 = false;
                        return;
                    case 900:
                        naviFragment.k.findViewById(R.id.navi_fragement_mask).setVisibility(8);
                        return;
                    case 1000:
                        naviFragment.s3();
                        return;
                    case Ring2TrackerConstant.MSG_CONNECT_TIMEOUT /*1100*/:
                        naviFragment.Y3();
                        return;
                    case 1200:
                        naviFragment.j3();
                        return;
                    case 1300:
                        naviFragment.d3();
                        return;
                    case 1400:
                        naviFragment.r3();
                        return;
                    case ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED /*1500*/:
                        StarryNetManger.getInstance().sendMessage((String) message.obj, (SendMessageListener) null);
                        return;
                    case 1600:
                        naviFragment.O1();
                        return;
                    case 1700:
                        naviFragment.o4();
                        return;
                    case 1800:
                        removeMessages(1800);
                        naviFragment.t4(true);
                        return;
                    case 1900:
                        removeMessages(1900);
                        naviFragment.t4(false);
                        return;
                    default:
                        CLog.b(NaviFragment.w0, "default  handleMessage");
                        return;
                }
            }
        }
    }

    private void B3() {
        if (this.h0) {
            StarryNetManger.getInstance().sendMessage(ProtocolUtils.g("navi_event", this.S, "navi_stop"), (SendMessageListener) null);
            this.h0 = false;
            NaviUtil.q1(false);
            this.t0 = NaviExitType.PHONE_MANUAL_EXIT;
            NaviUtil.f(getContext(), this.t0);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void D2(float f) {
        ULocation g = LocationManager.f().g();
        if (g != null && this.i != null) {
            g.setBearing(((double) f) * 1.0d);
            this.i.p(g, false, true);
        }
    }

    private void E3(String str) {
        String str2 = w0;
        CLog.b(str2, "setLaunchMode: data=" + str);
        try {
            CSharedPreferences.t(getContext(), "navi_latest_launch_mode", "1".equals(((DataBean) JsonUtil.b(str, DataBean.class)).getData()) ? 1 : 0);
        } catch (Exception e) {
            String str3 = w0;
            CLog.b(str3, "setLaunchMode: excep=" + e);
        }
    }

    private void G1(int i2) {
        String str = w0;
        CLog.b(str, "calculateNaviRoute   directNavi=" + this.X + " isNaviModeSwitch=" + this.Z + " mode=" + i2 + " isIsNaving=" + NaviUtil.u0());
        int i3 = 8;
        this.u.setVisibility(NaviUtil.u0() ? 8 : 0);
        this.s.setVisibility(NaviUtil.u0() ? 8 : 0);
        this.q.setVisibility(NaviUtil.u0() ? 8 : 0);
        this.r.setVisibility(NaviUtil.u0() ? 8 : 0);
        if (!NaviUtil.u0()) {
            this.i.j();
        }
        if (!NaviUtil.F0(this.P, this.Q)) {
            CLog.b(str, "calculateNaviRoute   Poi is not  Available ");
            this.l0.sendEmptyMessageDelayed(200, 1500);
            V2(false);
            return;
        }
        CLog.b(str, "calculateNaviRoute   mode=" + i2 + " startNaviPoi=" + this.P.toString() + "  endNaviPoi=" + this.Q.toString());
        int Y2 = NaviUtil.Y(getContext().getApplicationContext(), this.V, i2);
        this.S = Y2;
        if (this.v0 && i2 != Y2) {
            this.U = Y2;
        }
        this.v0 = true;
        CLog.b(str, "calculateNaviRoute    navMode=" + this.S);
        this.m.F(this.S);
        this.m.setNavModeSelect(this.S);
        NaviStrategyMenu naviStrategyMenu = this.M;
        if (this.S == 0 && !NaviUtil.u0()) {
            i3 = 0;
        }
        naviStrategyMenu.setVisibility(i3);
        int i4 = this.S;
        if (i4 == 0) {
            NaviControlManager.k().a(this.P, this.Q, this.p0);
        } else if (i4 == 1) {
            NaviControlManager.k().b(this.P, this.Q);
        } else if (i4 == 2) {
            NaviControlManager.k().c(this.P, this.Q);
        }
        CLog.b(str, "calculateNaviRoute   End, directNavi:" + this.X);
    }

    private void G2(boolean z2) {
        INaviActionResult homeActionResult = NaviOperatorManager.getInstance(getContext().getApplicationContext()).getHomeActionResult();
        if (homeActionResult != null) {
            CLog.b(w0, "naviCalculateRouteResult  homeActionResult is not null.");
            S1(homeActionResult, z2, false);
        }
        INaviActionResult companyActionResult = NaviOperatorManager.getInstance(getContext().getApplicationContext()).getCompanyActionResult();
        if (companyActionResult != null) {
            CLog.b(w0, "naviCalculateRouteResult  companyActionResult is not null.");
            S1(companyActionResult, z2, false);
        }
        INaviActionResult poiActionResult = NaviOperatorManager.getInstance(getContext().getApplicationContext()).getPoiActionResult();
        if (poiActionResult != null) {
            CLog.b(w0, "naviCalculateRouteResult  poiActionResult is not null.");
            S1(poiActionResult, z2, false);
        }
        if (!(homeActionResult == null && companyActionResult == null && poiActionResult == null)) {
            l3(z2);
        }
        NaviOperatorManager.getInstance(getContext().getApplicationContext()).setHomeActionResult((INaviActionResult) null);
        NaviOperatorManager.getInstance(getContext().getApplicationContext()).setCompanyActionResult((INaviActionResult) null);
        NaviOperatorManager.getInstance(getContext().getApplicationContext()).setPoiActionResult((INaviActionResult) null);
    }

    private boolean H1(boolean z2) {
        String str = w0;
        CLog.b(str, "canSendSwitchResultMessage  success=" + z2 + " isNaviModeSwitch=" + this.Z);
        return !z2 && this.Z;
    }

    private void H2(NaviInfoBean naviInfoBean) {
        if (NaviOperatorManager.getInstance(getContext().getApplicationContext()).getNaviStateListener() != null) {
            UNaviPoi uNaviPoi = this.Q;
            String name = uNaviPoi != null ? uNaviPoi.getName() : "";
            int i2 = 0;
            int pathRetainDistance = naviInfoBean != null ? naviInfoBean.getPathRetainDistance() : 0;
            if (naviInfoBean != null) {
                i2 = naviInfoBean.getPathRemainTime();
            }
            NaviOperatorManager.getInstance(getContext().getApplicationContext()).getNaviStateListener().a(name, pathRetainDistance, i2);
        }
    }

    private void H3(boolean z2) {
        String str = w0;
        CLog.b(str, "setNaviState isNaving=" + z2);
        NaviUtil.h1(z2);
        if (NaviOperatorManager.getInstance(getContext().getApplicationContext()).getNaviStateListener() != null) {
            NaviOperatorManager.getInstance(getContext().getApplicationContext()).getNaviStateListener().c(z2);
        } else {
            CLog.b(str, "setNaviState getNaviStateListener is empty.");
        }
    }

    private void I1() {
        NaviUtil.q1(false);
        if (this.R) {
            NaviControlManager.k().P();
        }
        if (getActivity() != null) {
            getActivity().runOnUiThread(new n(this));
        }
    }

    /* access modifiers changed from: private */
    public void J2(int i2) {
        String str = w0;
        CLog.b(str, "naviModeChange   navMode=" + this.S + " mode=" + i2);
        this.S = i2;
        L1();
        this.D.setNaviMode(this.S);
        this.E.setNaviMode(this.S);
        this.F.setNaviMode(this.S);
        this.D.setItemSelect(true);
        this.E.setItemSelect(false);
        this.F.setItemSelect(false);
        G1(i2);
        this.m.setNavModeSelect(i2);
        this.m.F(i2);
    }

    private void L2() {
        this.h0 = this.R ? true : this.h0;
        if (getContext() != null) {
            getContext().getApplicationContext().sendBroadcast(new Intent("com.upuphone.action_close_ar_media"));
        }
        this.l0.sendEmptyMessage(700);
    }

    private void L3(SearchModel searchModel) {
        String str = w0;
        CLog.b(str, "setRealNaviMode directNavi =" + this.X + " quikEnterType=" + this.Y + " navMode=" + this.S);
        this.S = NaviUtil.X(getContext().getApplicationContext(), searchModel);
        StringBuilder sb = new StringBuilder();
        sb.append("setRealNaviMode ###### complated! navMode=");
        sb.append(this.S);
        CLog.b(str, sb.toString());
    }

    private void M2(String str) {
        this.t0 = "1".equals(((DataBean) JsonUtil.b(str, DataBean.class)).getData()) ? NaviExitType.GLASS_ABNORMAL_EXIT : NaviExitType.GLASS_MANUAL_EXIT;
        NaviUtil.f(getContext(), this.t0);
        NaviUtil.q1(false);
        NaviControlManager.k().P();
        if (getActivity() != null) {
            getActivity().runOnUiThread(new o(this));
        }
        if (NaviUtil.z0() && getActivity() != null) {
            getActivity().runOnUiThread(new c(this));
        }
    }

    private void N1() {
        NaviOperatorManager.getInstance(getContext().getApplicationContext()).getNaviDatabase().f().c(NaviUtil.t());
        NaviUtil.i(getContext().getApplicationContext());
        this.e.clear();
        this.f = 1;
        i3();
    }

    private void N2(boolean z2) {
        if (H1(z2)) {
            if (NaviControlManager.k().z()) {
                int i2 = this.S;
                String g = i2 == 2 ? ProtocolUtils.g("navi_switch_rsp", i2, FactorAuthenticationUtil.CODE_ERROR_TOKEN_NULL) : i2 == 1 ? ProtocolUtils.g("navi_switch_rsp", i2, FactorAuthenticationUtil.CODE_ERROR_MODE_NULL) : "";
                this.Z = false;
                x3(g);
                e3();
                J2(0);
                return;
            }
            x3(ProtocolUtils.g("navi_switch_rsp", this.S, "0"));
        }
    }

    private void P1() {
        this.h0 = false;
        NaviUtil.V0();
        CSharedPreferences.u(getContext(), "navi_disconnect_time", System.currentTimeMillis());
    }

    private void Q1(String str) {
        String str2 = w0;
        CLog.b(str2, "dealNaviComplete()  Enter.  startedNavi=" + this.h0 + " cmd=" + str + " isNaving=" + this.R + " isIsNaving=" + NaviUtil.u0());
        StarryNetManger.getInstance().sendMessage(ProtocolUtils.g("navi_event", this.S, str), (SendMessageListener) null);
        this.t0 = NaviExitType.PHONE_NAVI_COMPLETE_EXIT;
        NaviUtil.f(getContext(), this.t0);
        this.h0 = false;
        NaviUtil.q1(false);
        this.R = false;
        NaviUtil.h1(false);
        this.G.setVisibility(8);
        this.H.setVisibility(8);
        this.J.setVisibility(8);
        this.I.k();
        NaviUtil.m();
        NaviUtil.U0(getContext());
        this.l0.sendEmptyMessageDelayed(CmdCode.CODE_WAKEUP_RECORDING, 1000);
        NaviDataTrackManager.reportCancelNaviTask(this.t0, LocationManager.f().d(), "1");
    }

    private void Q2(boolean z2, INaviActionResult iNaviActionResult) {
        if (z2) {
            try {
                iNaviActionResult.actionFailure(getString(R.string.near_location_info), 10004);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        } else {
            iNaviActionResult.actionFailure(getString(R.string.calculate_route_failed), 3);
        }
    }

    private void R1() {
        NaviView naviView;
        if (NaviUtil.P() == null) {
            NaviControlManager.k().e();
        } else if (BuildConfig.b.booleanValue() || (naviView = this.i) == null) {
            CLog.b(w0, "destroyNavi no nothing");
        } else {
            naviView.c();
            NaviControlManager.k().G((NaviView) null);
        }
        NaviUtil.l1(true);
    }

    private void S1(INaviActionResult iNaviActionResult, boolean z2, boolean z3) {
        if (iNaviActionResult != null) {
            CLog.b(w0, "doActionResult  actionResult is not null.");
            try {
                String s2 = NaviControlManager.k().s();
                int r2 = NaviControlManager.k().r();
                if (z2) {
                    iNaviActionResult.actionSuceess(s2, r2);
                } else {
                    iNaviActionResult.actionFailure(s2, r2);
                }
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        } else {
            CLog.b(w0, "doActionResult  actionResult is null.");
        }
    }

    private void T2(NaviInfoBean naviInfoBean, boolean z2, int i2, boolean z3, long j2) {
        String str = w0;
        CLog.b(str, "openAndStartGlass  @@@@@@");
        String i3 = ProtocolUtils.i(this.S, z2, i2, z3, naviInfoBean, j2);
        String c = NotifyUtils.c(getContext().getApplicationContext(), i3);
        CLog.b(str, "openAndStartGlass dataMsg length is:" + i3.length() + " reqMsg length is:" + c.length());
        StarryNetManger.getInstance().sendMessage(c, "com.upuphone.star.launcher", (SendMessageListener) null);
        this.l0.sendEmptyMessage(1400);
    }

    private void U1() {
        String str = w0;
        CLog.b(str, "getBundleData() NaviUtil.isIsNaving()=" + NaviUtil.u0());
        if (NaviUtil.u0()) {
            SearchModel C2 = NaviService.C();
            this.V = C2;
            this.W = C2;
            this.X = NaviService.R();
            this.Y = NaviService.H();
        } else if (getArguments() != null) {
            this.V = (SearchModel) getArguments().getSerializable("search_info_key");
            this.X = getArguments().getBoolean("direct_navi_key", false);
            this.Y = getArguments().getInt("navi_from_quik_key", this.Y);
        }
        L3(this.V);
    }

    private void V2(boolean z2) {
        INaviActionResult poiActionResult = NaviOperatorManager.getInstance(getContext().getApplicationContext()).getPoiActionResult();
        if (poiActionResult != null) {
            Q2(z2, poiActionResult);
            l3(false);
            NaviOperatorManager.getInstance(getContext().getApplicationContext()).setPoiActionResult((INaviActionResult) null);
        } else {
            CLog.b(w0, "poiAiNaviFailedResult  Enter poiActionResult is null.");
        }
        INaviActionResult companyActionResult = NaviOperatorManager.getInstance(getContext().getApplicationContext()).getCompanyActionResult();
        if (companyActionResult != null) {
            Q2(z2, companyActionResult);
            l3(false);
            NaviOperatorManager.getInstance(getContext().getApplicationContext()).setCompanyActionResult((INaviActionResult) null);
        } else {
            CLog.b(w0, "poiAiNaviFailedResult  Enter companyActionResult is null.");
        }
        INaviActionResult homeActionResult = NaviOperatorManager.getInstance(getContext().getApplicationContext()).getHomeActionResult();
        if (homeActionResult != null) {
            Q2(z2, homeActionResult);
            l3(false);
            NaviOperatorManager.getInstance(getContext().getApplicationContext()).setHomeActionResult((INaviActionResult) null);
            return;
        }
        CLog.b(w0, "poiAiNaviFailedResult  Enter homeActionResult is null.");
    }

    private List W1(int i2) {
        List i3 = NaviOperatorManager.getInstance(getContext().getApplicationContext()).getNaviDatabase().f().i(NaviUtil.t(), i2, 12);
        int size = i3.size();
        ArrayList arrayList = new ArrayList();
        for (int i4 = 0; i4 < size; i4++) {
            arrayList.add(v0((Record) i3.get(i4)));
        }
        return arrayList;
    }

    private NaviInfoBean X1() {
        NaviInfoBean o2 = NaviControlManager.k().o();
        if (o2 != null) {
            o2.setRouteRemainLightCount(NaviUtil.K(this.S));
        }
        i4(o2);
        return o2;
    }

    private void a2(boolean z2) {
        this.i.g(this.S, z2);
    }

    private void b2() {
        NaviControlManager.k().v(getContext().getApplicationContext());
        NaviControlManager.k().I(this);
    }

    private void c2() {
        this.g0 = new AnimationSet(true);
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 359.0f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setRepeatCount(-1);
        rotateAnimation.setStartOffset(0);
        rotateAnimation.setDuration(1000);
        this.g0.setInterpolator(new LinearInterpolator());
        this.g0.addAnimation(rotateAnimation);
    }

    /* access modifiers changed from: private */
    public void c4() {
        long currentTimeMillis = System.currentTimeMillis();
        boolean isAssistantWakeup = ConnectionManager.getInstance(getContext()).isAssistantWakeup();
        int[] q2 = NaviControlManager.k().q();
        String str = w0;
        CLog.b(str, "startNavi  begin! startAck=" + currentTimeMillis + " assistantWakeup=" + isAssistantWakeup + " isNaving=" + this.R + " isIsNaving=" + NaviUtil.u0() + " routeIdArray=" + this.O + " routeId=" + q2);
        this.i.i();
        NaviControlManager.k().L(this.i);
        L1();
        this.i.g(this.S, true);
        NaviControlManager.k().J(0);
        if (q2 == null) {
            x(X1(), false);
            return;
        }
        boolean m2 = CSharedPreferences.m(getContext().getApplicationContext());
        CLog.b(str, "startNavi   voiceState=" + m2);
        r4(m2);
        if (isAssistantWakeup) {
            NaviControlManager.k().Q();
        }
        V3(true);
        if (!this.R) {
            NaviControlManager.k().N(this.S);
            w3(currentTimeMillis);
        } else if (NaviUtil.s0()) {
            w3(currentTimeMillis);
        }
        this.R = true;
        H3(true);
        C3();
        x(X1(), false);
        if (this.Z) {
            this.Z = false;
        } else {
            this.l0.sendEmptyMessageDelayed(700, 150);
        }
        CLog.b(str, "sendNaviReqMessage  quikEnterType= " + this.Y + " startNaviPoi=" + this.P.toString() + " endNaviPoi=" + this.Q.toString());
        NaviDataTrackManager.reportStartNaviTask(String.valueOf(this.Y), String.valueOf(this.S), this.P.getName(), this.Q.getName());
        NaviDataTrackManager.reportCommonAddressesNavTaskForBackThread(getContext().getApplicationContext(), this.V, LocationManager.f().d());
    }

    private void i2() {
        String str = w0;
        CLog.b(str, "initNavi() NaviUtil.isIsNaving()=" + NaviUtil.u0());
        if (NaviUtil.u0()) {
            this.R = true;
            this.h0 = true;
            V3(true);
            L1();
            NaviControlManager.k().J(0);
            C3();
            x(X1(), false);
            return;
        }
        m2();
        L3(this.V);
        h3();
        G1(this.S);
    }

    private void k2() {
        PlaceBean j2 = LocationManager.f().j();
        if (j2 == null || this.V == null) {
            UToast.e(getContext().getApplicationContext(), R.string.gps_position_failed, 1);
            return;
        }
        this.P = new UNaviPoi(j2.getPoiName(), j2.getPoiId(), j2.getLatitude(), j2.getLongitude());
        this.Q = new UNaviPoi(this.V.getName(), this.V.getAcode(), this.V.getLatitude(), this.V.getLongitude());
    }

    private void l2() {
        ((FrameLayout) this.k.findViewById(R.id.c_status_bar)).addView(DensityUtils.d(getContext()));
    }

    private void l3(boolean z2) {
        String str = w0;
        CLog.b(str, "resumeLastNavi  success=" + z2 + " startedNavi=" + this.h0);
        SearchModel searchModel = this.W;
        if (searchModel == null || !this.h0 || z2) {
            this.W = null;
            return;
        }
        this.V = searchModel;
        k2();
        L3(this.V);
        G1(this.S);
    }

    private void l4(boolean z2) {
        if (getContext() == null) {
            CLog.b(w0, "updateNaviSpeakState: this Context object is null.");
            return;
        }
        boolean m2 = CSharedPreferences.m(getContext().getApplicationContext());
        String str = w0;
        CLog.b(str, "updateNaviSpeakState: isWakeup=" + z2 + " voiceState" + m2);
        if (m2) {
            if (z2) {
                NaviControlManager.k().Q();
            } else {
                NaviControlManager.k().O();
            }
        }
    }

    private void m2() {
        this.S = -1;
        this.T = -1;
        SearchModel searchModel = this.V;
        this.p0 = searchModel != null ? searchModel.getStrategy() : this.p0;
        this.q0 = null;
        this.r0 = null;
        this.R = false;
        NaviUtil.h1(false);
        this.h0 = false;
        this.Z = false;
        this.c = StarryNetManger.getInstance().isDeviceConnected();
        NaviUtil.t1(true);
        H3(false);
    }

    private void m3() {
        NaviControlManager.k().J(0);
        if (NaviUtil.u0()) {
            a2(true);
        }
    }

    /* access modifiers changed from: private */
    public void m4(boolean z2) {
        Drawable drawable = getActivity().getDrawable(z2 ? R.drawable.ic_volume_on : R.drawable.ic_volume_off);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        this.z.setCompoundDrawablesRelative((Drawable) null, drawable, (Drawable) null, (Drawable) null);
        this.z.setText(z2 ? R.string.open_tts_broadcast : R.string.close_tts_broadcast);
        this.z.setTextColor(getActivity().getColor(z2 ? R.color.broadcast_color : R.color.not_network_color));
        if (z2) {
            NaviControlManager.k().O();
        } else {
            NaviControlManager.k().Q();
        }
    }

    private void p3() {
        SearchModel j2 = NaviUtil.j(this.V);
        j2.setNaviMode(this.S);
        NaviUtil.T0(getContext());
        NaviUtil.X0(getContext(), j2, CSharedPreferences.f(getContext(), "navi_latest_launch_mode", 0));
    }

    /* access modifiers changed from: private */
    public void r3() {
        NaviUtil.j0(getContext().getApplicationContext(), this.V);
        p3();
    }

    private void s4(String str) {
        CSharedPreferences.z(getContext().getApplicationContext(), "1".equals(((DataBean) JsonUtil.b(str, DataBean.class)).getData()));
        this.l0.sendEmptyMessage(600);
    }

    private void t3(boolean z2) {
        NaviControlManager.k().E(this.R, this.S, z2);
    }

    /* access modifiers changed from: private */
    public void t4(boolean z2) {
        int i2 = 1800;
        this.l0.removeMessages(1800);
        this.l0.removeMessages(1900);
        if (this.Y != 2 || NaviTtsManager.getInstance(getContext().getApplicationContext()).isPlayDone()) {
            CLog.b(w0, "waitStartNavi, ######### success:" + z2);
            G2(z2);
            if (z2) {
                c4();
                return;
            }
            return;
        }
        Message message = new Message();
        if (!z2) {
            i2 = 1900;
        }
        message.what = i2;
        this.l0.sendMessageDelayed(message, 50);
    }

    private void u3(NaviInfoBean naviInfoBean, boolean z2) {
        NaviUtil.a1();
        y3(z2);
        if (naviInfoBean != null && NaviUtil.r0(naviInfoBean.getIconType())) {
            String str = w0;
            CLog.b(str, "sendNaviChangeMessage  naviInfo.toString():" + naviInfoBean.toString());
            StarryNetManger.getInstance().sendMessage(ProtocolUtils.h(naviInfoBean), (SendMessageListener) null);
        }
    }

    private void v3() {
        NaviInfoBean W2 = NaviUtil.W();
        if (W2 == null) {
            W2 = X1();
        }
        if (W2 != null && NaviUtil.r0(W2.getIconType()) && this.R) {
            StarryNetManger.getInstance().sendMessage(ProtocolUtils.h(W2), (SendMessageListener) null);
        }
        NaviUtil.r1((NaviInfoBean) null);
    }

    private void w3(long j2) {
        NaviInfoBean X1 = X1();
        H2(X1);
        String str = w0;
        CLog.b(str, "sendNaviReqMessage enter directNavi=" + this.X + " quikEnterType= " + this.Y + " isNaving=" + this.R + " startedNavi=" + this.h0 + " isNaviModeSwitch=" + this.Z + " isNaviStarted() =" + NaviUtil.B0() + " isIsNaving=" + NaviUtil.u0());
        boolean b = CSharedPreferences.b(getContext().getApplicationContext(), "msg_mask", false) ^ true;
        int e = CSharedPreferences.e(getContext().getApplicationContext());
        boolean b2 = CSharedPreferences.b(getContext().getApplicationContext(), "navi_brightness", true);
        if (this.Z) {
            this.Z = false;
            u3(X1, true);
        } else if (this.Y == 2 && this.h0) {
            u3(X1, false);
            this.l0.sendEmptyMessage(1400);
            NaviUtil.a1();
        } else if (NaviUtil.B0()) {
            StarryNetManger.getInstance().sendMessage(ProtocolUtils.j(this.S, b, e, b2, X1, j2), (SendMessageListener) null);
            this.l0.sendEmptyMessage(1400);
        } else if (!NaviUtil.u0() || !this.h0) {
            T2(X1, b, e, b2, j2);
        } else {
            x(X1(), false);
        }
    }

    private void x3(String str) {
        Message message = new Message();
        message.obj = str;
        message.what = ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED;
        this.l0.sendMessageDelayed(message, 500);
    }

    private void y3(boolean z2) {
        String str = z2 ? "1" : FactorAuthenticationUtil.CODE_ERROR_CANCEL;
        String g = ProtocolUtils.g("navi_switch_rsp", this.S, str);
        String str2 = w0;
        CLog.b(str2, "sendNaviSwitchRspMsg  data:" + g + " event=" + str);
        StarryNetManger.getInstance().sendMessage(g, (SendMessageListener) null);
    }

    private void z3() {
        boolean m2 = CSharedPreferences.m(getContext().getApplicationContext());
        String str = w0;
        CLog.b(str, "sendNaviTtsPlayStatus   voiceState=" + m2 + " isNaving=" + this.R);
        if (this.R) {
            StarryNetManger.getInstance().sendMessage(ProtocolUtils.a("navi_tts", m2 ? "1" : "0"), (SendMessageListener) null);
        }
    }

    public void A0(boolean z2) {
        super.A0(z2);
        l4(z2);
    }

    public final /* synthetic */ void A2(List list) {
        if (getContext() != null) {
            F3(LocationManager.f().j(), list);
        }
        if (list != null) {
            list.clear();
        }
    }

    public final void A3() {
        if (this.h0) {
            StarryNetManger.getInstance().sendMessage(ProtocolUtils.g("navi_event", this.S, "navi_stop"), (SendMessageListener) null);
            this.h0 = false;
            NaviUtil.q1(false);
        }
    }

    public void B0(boolean z2) {
        String str = w0;
        CLog.b(str, "onBleConnectState connected=" + z2);
    }

    public final /* synthetic */ void B2(CustomDialog customDialog, View view) {
        customDialog.dismiss();
        k0();
    }

    public void C0(boolean z2) {
        String str = w0;
        CLog.b(str, "onDeviceConnectState isOnline=" + z2 + " this.isHidden()=" + isHidden() + " isNaving=" + this.R + " isDeviceConnected()=" + w0() + " startedNavi=" + this.h0 + " isNaviReconnectDialogShow=" + NaviUtil.A0());
        this.h0 = !z2 ? false : this.h0;
        if (getActivity() == null) {
            CLog.b(str, "onDeviceConnectState  this.getActivity() == null.");
            return;
        }
        if (!z2 && w0() && this.R) {
            long g = CSharedPreferences.g(getContext(), "navi_disconnect_time", 0);
            Context context = getContext();
            if (!NaviUtil.A0()) {
                g = System.currentTimeMillis();
            }
            CSharedPreferences.u(context, "navi_disconnect_time", g);
            getActivity().runOnUiThread(new m(this));
            k4(false);
            NaviUtil.Y0(getContext().getApplicationContext(), this.V);
            d4();
        } else if (z2 && NaviUtil.e0(getContext().getApplicationContext())) {
            k4(true);
        } else if (z2) {
            k4(ConnectionManager.isNetAvailable(getContext().getApplicationContext()));
        } else {
            k4(false);
        }
        K0(z2);
    }

    public final /* synthetic */ void C2(CustomDialog customDialog, View view) {
        customDialog.dismiss();
        k0();
        N1();
    }

    public final void C3() {
        int i2 = 8;
        this.l.setVisibility(8);
        this.m.setVisibility(8);
        this.M.setVisibility(8);
        this.N.setVisibility(8);
        this.D.setVisibility(8);
        this.E.setVisibility(8);
        this.F.setVisibility(8);
        this.r.setVisibility(8);
        this.q.setVisibility(8);
        this.G.setVisibility(8);
        this.H.setVisibility(0);
        this.I.setVisibility(0);
        RelativeLayout relativeLayout = this.J;
        if (this.S == 0) {
            i2 = 0;
        }
        relativeLayout.setVisibility(i2);
    }

    public void D(int i2, String str) {
        String str2 = w0;
        CLog.b(str2, "onGetNavigationText  Enter!  text=" + str);
        boolean m2 = CSharedPreferences.m(getContext().getApplicationContext());
        if (!BuildConfig.b.booleanValue() && m2) {
            NaviTtsManager.getInstance(getContext().getApplicationContext()).startSpeak(str);
        }
    }

    public void D0() {
        boolean j2 = LocationUtil.j(getContext().getApplicationContext());
        String str = w0;
        CLog.b(str, "onGpsStateChanged() isOpenGps=" + j2 + " isIsNaving=" + NaviUtil.u0());
        if (!j2 && NaviUtil.u0()) {
            b4();
        }
    }

    public final void D3() {
        NaviControlManager.k().H();
    }

    public void E0(ULocation uLocation, PlaceBean placeBean) {
        if (placeBean != null) {
            UNaviPoi uNaviPoi = this.P;
            if ((uNaviPoi != null && TextUtils.isEmpty(uNaviPoi.getName())) || this.P == null) {
                this.P = new UNaviPoi(placeBean.getPoiName(), placeBean.getPoiId(), placeBean.getLatitude(), placeBean.getLongitude());
            }
            UNaviPoi uNaviPoi2 = this.Q;
            if ((uNaviPoi2 != null && TextUtils.isEmpty(uNaviPoi2.getName())) || this.Q == null) {
                this.Q = new UNaviPoi(placeBean.getPoiName(), placeBean.getPoiId(), placeBean.getLatitude(), placeBean.getLongitude());
            }
        }
    }

    public final void E2() {
        boolean b = CSharedPreferences.b(getContext().getApplicationContext(), "msg_mask", false);
        CSharedPreferences.p(getContext().getApplicationContext(), "msg_mask", b);
        h4(b);
    }

    public void F0(StarryNetMessage starryNetMessage) {
        String str = w0;
        CLog.b(str, "onMessageReceive: starryNetMessage.getMessage():" + starryNetMessage.getMessage() + " getSenderPkg=" + starryNetMessage.getSenderPkg());
        String message = starryNetMessage.getMessage();
        if (!TextUtils.isEmpty(message)) {
            CLog.b(str, "onMessageReceive: startedNavi:" + this.h0 + " isNaviStarted()=" + NaviUtil.B0() + " isNaving=" + this.R + " isIsNaving=" + NaviUtil.u0());
            if (message.contains("navi_start_rsp")) {
                CLog.b(str, "onMessageReceive: NAVI_EVENT_START_RSP");
                NotifyUtils.g(0);
                L2();
                z3();
                v3();
                NaviControlManager.k().F();
                NaviUtil.b1(getContext().getApplicationContext(), this.h0);
            } else if (message.contains("navi_stop") && ((this.h0 || NaviUtil.B0()) && NaviUtil.u0())) {
                CLog.b(str, "onMessageReceive: NAVI_EVENT_STOP  data:navi_stop");
                NotifyUtils.g(0);
                M2(message);
            } else if (message.contains("speechMode") && this.h0) {
                CLog.b(str, "onMessageReceive: NAVI_SETTINGS_SPEECH_MODE");
                s4(message);
            } else if (message.contains("show_map_partial_rsp") && this.h0) {
                I2();
            } else if (message.contains(CmdAction.CMD_DIALOG_CONFIRM) && message.contains("reconnection_navi")) {
                CLog.b(str, "onMessageReceive: NOTIFICATION_RSP_CONFIRM");
            } else if (message.contains(CmdAction.CMD_DIALOG_CANCEL) && message.contains("reconnection_navi")) {
                CLog.b(str, "onMessageReceive: NOTIFICATION_RSP_CANCEL");
                I1();
            } else if ("System".equals(starryNetMessage.getSenderPkg())) {
                CLog.b(str, "onMessageReceive: System");
                P1();
            } else if (message.contains("navi_launch_mode")) {
                CLog.b(str, "onMessageReceive: IDENTITY_NAVI_LAUNCH_MODE isNaving=" + this.R + " isIsNaving=" + NaviUtil.u0());
                E3(message);
                if (NaviUtil.u0()) {
                    p3();
                } else {
                    NaviUtil.T0(getContext().getApplicationContext());
                }
            }
        }
    }

    public final void F1(AutoCompleteTextView autoCompleteTextView, List list) {
        String str = w0;
        CLog.b(str, "addressQueryResult  default. hasInputTips=" + this.p);
        M0(false);
        if (TextUtils.isEmpty(autoCompleteTextView.getText().toString())) {
            CLog.b(str, "addressQueryResult() @@@@@@@@@@@");
            this.p = false;
            this.o.k().clear();
            this.o.u(X2());
            this.o.notifyDataSetChanged();
            this.n.setVisibility(0);
        } else if (list == null || list.size() <= 0) {
            this.p = false;
            this.o.notifyDataSetChanged();
            this.n.setVisibility(0);
        } else {
            W3(autoCompleteTextView, list);
            this.p = true;
        }
        if (list != null) {
            list.clear();
        }
    }

    public final void F2() {
        ULocation g = LocationManager.f().g();
        if (g != null) {
            this.i.o(g, (SensorEventHelper) null, true, true, true);
            T0(this.d);
        }
    }

    public final void F3(PlaceBean placeBean, List list) {
        if (list == null || list.size() <= 0) {
            J3(m0(placeBean), placeBean.getPoiName(), placeBean.getPoiId(), new ULatLng(placeBean.getLatitude(), placeBean.getLongitude()));
        } else {
            PlaceBean placeBean2 = (PlaceBean) list.get(0);
            J3(n0(new AutoCompleteTextView(getContext()), placeBean2), placeBean2.getPoiName(), placeBean2.getPoiId(), new ULatLng(placeBean2.getLatitude(), placeBean2.getLongitude()));
        }
        M0(false);
    }

    public void G() {
        String str = w0;
        CLog.b(str, "onCalculateRouteFailure()  Enter.  isNaving=" + this.R + " isIsNaving=" + NaviUtil.u0());
        m3();
        if (!Z2()) {
            this.s0 = 0;
            t3(false);
            U3(false);
            S1(this.q0, false, true);
            this.q0 = null;
            N2(false);
            S1(this.r0, false, true);
            this.r0 = null;
            t4(false);
        }
    }

    public void G0(boolean z2) {
        StarryNetManger.getInstance().sendMessage(ProtocolUtils.g("network_state", this.S, z2 ? "1" : "0"), (SendMessageListener) null);
        if (isHidden()) {
            CLog.b(w0, "onNetConnectState  this.isHidden().");
        } else if (getContext() == null) {
            CLog.b(w0, "onNetConnectState  his.getContext() == null.");
        } else {
            boolean D0 = NaviUtil.D0(getContext().getApplicationContext());
            CLog.b(w0, "onNetConnectState ###############isNaving=" + this.R);
            int i2 = 8;
            if (!D0) {
                UToast.e(getContext().getApplicationContext(), R.string.network_anomaly, 0);
                this.v.setVisibility(8);
                this.w.setVisibility(0);
                this.u0.setVisibility(8);
            } else {
                this.v.setVisibility(this.R ? 8 : 0);
                this.B.setVisibility(this.R ? 0 : 8);
                this.w.setVisibility(this.R ? 8 : 0);
                TextView textView = this.u0;
                if (this.R) {
                    i2 = 0;
                }
                textView.setVisibility(i2);
            }
            if (!z2 || !StarryNetManger.getInstance().isDeviceConnected()) {
                k4(false);
            } else {
                k4(true);
            }
        }
    }

    public final void G3() {
        NaviHomeBean naviHomeBean = new NaviHomeBean();
        naviHomeBean.setChangeRouteResult(this.q0);
        naviHomeBean.setChangeNaviResult(this.r0);
        naviHomeBean.setDirectNavi(this.X);
        naviHomeBean.setNavMode(this.S);
        naviHomeBean.setSwitchMode(this.T);
        naviHomeBean.setStrategy(this.p0);
        naviHomeBean.setStartedNavi(this.h0);
        naviHomeBean.setNaviModeSwitch(this.Z);
        naviHomeBean.setDeviceConnected(this.c);
        NaviUtil.o1(naviHomeBean);
    }

    public boolean H0(int i2) {
        return NaviControlManager.k().B(i2);
    }

    public boolean I0() {
        CLog.b(w0, "refreshNavi  Enter.");
        this.s0 = 2;
        return Y2();
    }

    public final void I2() {
        this.m0.c(true);
        this.o0 = true;
        this.m0.b();
        this.m0.a();
    }

    public final void I3() {
        boolean z2 = !CSharedPreferences.m(getContext().getApplicationContext());
        CSharedPreferences.z(getContext().getApplicationContext(), z2);
        m4(z2);
    }

    public void J0(SearchModel searchModel, int i2, boolean z2) {
        String str = w0;
        CLog.b(str, "restartNaviTask Enter. quik=" + i2 + " direct=" + z2);
        k3(searchModel, z2, i2);
    }

    public final void J1() {
        if (!StarryNetManger.getInstance().isDeviceConnected()) {
            getActivity().runOnUiThread(new j(this));
        } else if (!NaviUtil.D0(getContext().getApplicationContext())) {
            UToast.e(getContext().getApplicationContext(), R.string.network_anomaly, 0);
        } else if (getActivity() != null) {
            LocationUtil.e(getActivity(), 1003, new LocationUtil.LocationCallback() {
                public void a() {
                    CLog.b(NaviFragment.w0, "checkAndStartNavi : onRefuseOpenGps");
                }

                public void b() {
                    if (NaviFragment.this.o2()) {
                        UToast.e(NaviFragment.this.getContext().getApplicationContext(), R.string.near_location_info, 0);
                    } else {
                        NaviFragment.this.c4();
                    }
                }
            });
        }
    }

    public final void J3(SearchModel searchModel, String str, String str2, ULatLng uLatLng) {
        if (!NaviUtil.F0(this.P, this.Q)) {
            CLog.b(w0, "setPositionPoi() ####### poi object is invailde!");
            return;
        }
        this.m.setEditMode(false);
        ULatLng uLatLng2 = this.m.v() ? uLatLng : new ULatLng(this.P.getLatitude(), this.P.getLongitude());
        if (this.m.v()) {
            uLatLng = new ULatLng(this.Q.getLatitude(), this.Q.getLongitude());
        }
        String str3 = w0;
        CLog.b(str3, "setPositionPoi() ####### startPoiPos=[" + uLatLng2.latitude + MzContactsContract.MzGroups.GROUP_SPLIT_MARK_EXTRA + uLatLng2.longitude + "] endPoiPos=[" + uLatLng.latitude + MzContactsContract.MzGroups.GROUP_SPLIT_MARK_EXTRA + uLatLng.longitude + "]");
        if (NaviUtil.y0(uLatLng2, uLatLng)) {
            UToast.e(getContext().getApplicationContext(), R.string.match_location_tips, 0);
            return;
        }
        if (this.m.v()) {
            this.P.setPoiId(str2);
            this.P.setName(str);
            this.P.setLatitude(uLatLng2.latitude);
            this.P.setLongitude(uLatLng2.longitude);
        } else {
            this.Q.setPoiId(str2);
            this.Q.setName(str);
            this.Q.setLatitude(uLatLng.latitude);
            this.Q.setLongitude(uLatLng.longitude);
            this.V = searchModel;
            this.S = NaviUtil.R(getContext(), searchModel);
        }
        this.m.getCurEdit().setText(str);
        this.m.getCurEdit().clearFocus();
        M1();
        h3();
        K3();
        G1(this.S);
    }

    public void K(boolean z2) {
        String str = w0;
        CLog.b(str, "onAddressTouch  isStartPos=" + z2);
        this.n.setVisibility(0);
        List X2 = X2();
        HistoryListAdapter historyListAdapter = this.o;
        if (historyListAdapter == null) {
            HistoryListAdapter historyListAdapter2 = new HistoryListAdapter(getContext(), X2);
            this.o = historyListAdapter2;
            historyListAdapter2.v(this);
            this.n.setAdapter(this.o);
        } else {
            historyListAdapter.k().clear();
            this.o.u(X2);
        }
        this.o.notifyDataSetChanged();
    }

    public final void K1() {
        this.l0.removeMessages(200);
        this.l0.removeMessages(300);
        this.l0.removeMessages(CmdCode.CODE_WAKEUP_RECORDING);
        this.l0.removeMessages(500);
        this.l0.removeMessages(600);
        this.l0.removeMessages(700);
        this.l0.removeMessages(Constants.ANIMATION_DURATION);
        this.l0.removeMessages(900);
        this.l0.removeMessages(1000);
        this.l0.removeMessages(Ring2TrackerConstant.MSG_CONNECT_TIMEOUT);
        this.l0.removeMessages(1200);
        this.l0.removeMessages(1300);
        this.l0.removeMessages(1400);
        this.l0.removeMessages(ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED);
        this.l0.removeMessages(1600);
        this.l0.removeMessages(1700);
        this.l0.removeMessages(1800);
        this.l0.removeMessages(1900);
    }

    public void K2(int i2) {
        Intent intent = new Intent(getContext().getApplicationContext(), NaviPoiMarkActivity.class);
        String obj = this.m.getCurEdit().getText().toString();
        intent.putExtra("need_sort", NaviUtil.R0(this.g));
        intent.putExtra("type_code", NaviUtil.V(this.g));
        intent.putExtra("ext_keyword", obj);
        intent.putExtra("is_start", this.m.v());
        startActivityForResult(intent, i2);
        M0(false);
    }

    public final void K3() {
        if (NaviUtil.F0(this.P, this.Q)) {
            this.i.b();
            this.i.a(new ULatLng(this.P.getLatitude(), this.P.getLongitude()), R.drawable.navi_start);
            this.i.a(new ULatLng(this.Q.getLatitude(), this.Q.getLongitude()), R.drawable.navi_end);
        }
    }

    public void L() {
        CLog.b(w0, "onExitNavi");
        NaviUtil.q1(false);
        this.h0 = false;
        StarryNetManger.getInstance().sendMessage(ProtocolUtils.g("navi_event", this.S, "navi_stop"), (SendMessageListener) null);
        NaviUtil.m();
        if (!NaviUtil.e0(getContext())) {
            CSharedPreferences.u(getContext(), "navi_disconnect_time", 0);
        }
        Z1();
    }

    public final void L1() {
        NaviControlManager.k().d(this.i);
    }

    public final void M1() {
        HistoryListAdapter historyListAdapter = this.o;
        if (historyListAdapter != null && historyListAdapter.k() != null) {
            this.o.k().clear();
            this.o.notifyDataSetChanged();
            this.n.setVisibility(8);
        }
    }

    public final void M3(int[] iArr) {
        if (iArr.length == 1) {
            this.D.setVisibility(0);
            this.E.setVisibility(8);
            this.F.setVisibility(8);
            this.D.setItemSelect(true);
            this.D.setRouteId(iArr[0]);
            this.D.setNaviMode(this.S);
            N3(this.D, iArr[0]);
        } else if (iArr.length == 2) {
            this.D.setVisibility(0);
            this.D.setItemSelect(true);
            this.D.setRouteId(iArr[0]);
            this.D.setNaviMode(this.S);
            N3(this.D, iArr[0]);
            this.E.setVisibility(0);
            this.E.setRouteId(iArr[1]);
            this.E.setNaviMode(this.S);
            N3(this.E, iArr[1]);
            this.F.setVisibility(8);
        } else if (iArr.length >= 3) {
            this.D.setVisibility(0);
            this.D.setItemSelect(true);
            this.D.setRouteId(iArr[0]);
            this.D.setNaviMode(this.S);
            N3(this.D, iArr[0]);
            this.E.setVisibility(0);
            this.E.setRouteId(iArr[1]);
            this.E.setNaviMode(this.S);
            N3(this.E, iArr[1]);
            this.F.setVisibility(0);
            this.F.setRouteId(iArr[2]);
            this.F.setNaviMode(this.S);
            N3(this.F, iArr[2]);
        }
    }

    public void N0(boolean z2) {
        String str = w0;
        CLog.b(str, "setNaviSpeak  isOn=" + z2);
        CSharedPreferences.z(getContext().getApplicationContext(), z2);
        this.l0.sendEmptyMessage(600);
    }

    public final void N3(RouteItemView routeItemView, int i2) {
        String str;
        if (routeItemView != null) {
            routeItemView.setLabel(NaviControlManager.k().l(i2) + "");
            routeItemView.setDistance(NaviUtil.r(getContext().getApplicationContext(), NaviControlManager.k().g(i2)) + "");
            routeItemView.setTime(NaviUtil.s(getContext().getApplicationContext(), NaviControlManager.k().h(i2)) + "");
            if (this.S == 0) {
                str = NaviControlManager.k().u(i2) + "";
            } else {
                str = NaviControlManager.k().t(i2) + "";
            }
            routeItemView.setLights(str);
        }
    }

    public void O(TextView textView) {
        boolean z2 = !CSharedPreferences.m(getContext().getApplicationContext());
        CSharedPreferences.z(getContext().getApplicationContext(), z2);
        r4(z2);
        if (NaviOperatorManager.getInstance(getContext()).getNaviVoiceStateChanged() != null) {
            NaviOperatorManager.getInstance(getContext()).getNaviVoiceStateChanged().NaviVoiceStateChanged(z2);
        }
    }

    public final void O1() {
        if (this.R) {
            NaviInfoBean X1 = X1();
            H2(X1);
            T2(X1, !CSharedPreferences.b(getContext().getApplicationContext(), "msg_mask", false), CSharedPreferences.e(getContext().getApplicationContext()), CSharedPreferences.b(getContext().getApplicationContext(), "navi_brightness", true), System.currentTimeMillis());
        }
    }

    public final void O2() {
        G3();
        Context applicationContext = getContext().getApplicationContext();
        NaviOperatorManager.getInstance(applicationContext).startNaviService(applicationContext, this.V, this.Y);
    }

    public final void O3() {
        boolean b = CSharedPreferences.b(getContext().getApplicationContext(), "navi_traffic_state", true);
        String str = w0;
        CLog.b(str, " onHiddenChanged() navMode=" + this.S + " trafficState=" + b);
        if (this.S == 0) {
            this.x.setSelected(b);
            this.i.n(b);
        }
    }

    public void P() {
        CLog.b(w0, "onBackAction ");
        if (this.n.isShown()) {
            S3();
        } else {
            Z1();
        }
    }

    public final void P2() {
        String str = w0;
        CLog.b(str, "navingBack  Enter!  ");
        LinearLayout exitMenu = this.I.getExitMenu();
        TextView cancelNavi = this.I.getCancelNavi();
        CLog.b(str, "navingBack  exitMenu.isShown()=" + exitMenu.isShown() + " cancelNavi.isShown()=" + cancelNavi.isShown());
        if (exitMenu.isShown()) {
            exitMenu.performClick();
        } else if (cancelNavi.isShown()) {
            cancelNavi.performClick();
        }
    }

    public final void P3(boolean z2) {
        boolean z3 = true;
        boolean b = CSharedPreferences.b(getContext().getApplicationContext(), "navi_traffic_state", true);
        NaviView naviView = this.i;
        if (!z2 || !b) {
            z3 = false;
        }
        naviView.n(z3);
        this.x.setVisibility(8);
        ImageView imageView = this.x;
        imageView.setImageResource(imageView.isSelected() ? R.drawable.traffic_on : R.drawable.traffic_off);
    }

    public void Q() {
        CLog.b(w0, "onHomeNavi");
        NaviUtil.n1(true);
        NaviUtil.f1(true);
        O2();
        if (getActivity() != null) {
            getActivity().finish();
        }
    }

    public void Q0(boolean z2) {
        String str = w0;
        CLog.b(str, "setTrafficMap  enabled=" + z2);
        if (!this.k0) {
            this.k0 = true;
            this.i.n(z2);
            this.x.setSelected(z2);
            q4(!z2);
            this.l0.removeMessages(Constants.ANIMATION_DURATION);
            this.l0.sendEmptyMessageDelayed(Constants.ANIMATION_DURATION, AssistantConstants.TIMEOUT_VAD_MUTE);
        }
    }

    public final void Q3() {
        if (!this.k0) {
            this.k0 = true;
            boolean trafficstatus = this.i.getTrafficstatus();
            this.i.n(!trafficstatus);
            this.x.setSelected(!trafficstatus);
            q4(trafficstatus);
            this.l0.removeMessages(Constants.ANIMATION_DURATION);
            this.l0.sendEmptyMessageDelayed(Constants.ANIMATION_DURATION, AssistantConstants.TIMEOUT_VAD_MUTE);
        }
    }

    public void R(AutoCompleteTextView autoCompleteTextView, CharSequence charSequence, boolean z2) {
        String str = w0;
        CLog.b(str, "onAddressEditChanged    isStartPos=" + z2);
        if (!TextUtils.isEmpty(charSequence.toString().trim())) {
            T1(autoCompleteTextView);
        } else {
            i3();
        }
    }

    public void R0() {
        CLog.b(w0, "stopNavi Enter.");
        this.t0 = NaviExitType.PHONE_MANUAL_EXIT;
        NaviUtil.f(getContext(), this.t0);
        c3();
    }

    public void R2(int i2) {
        if (!NaviUtil.D0(getContext().getApplicationContext())) {
            if (!this.j0) {
                this.j0 = true;
                UToast.e(getContext().getApplicationContext(), R.string.network_no_available, 0);
                this.l0.sendEmptyMessageDelayed(500, AssistantConstants.TIMEOUT_VAD_MUTE);
            }
        } else if (getActivity() != null) {
            LocationUtil.e(getActivity(), i2, new LocationUtil.LocationCallback() {
                public void a() {
                    CLog.b(NaviFragment.w0, "onClickLocation : onRefuseOpenGps");
                }

                public void b() {
                    NaviFragment.this.F2();
                }
            });
        }
    }

    public final void R3(boolean z2) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.x.getLayoutParams();
        layoutParams.topMargin = z2 ? getResources().getDimensionPixelOffset(R.dimen.size_dp_10) : getResources().getDimensionPixelOffset(R.dimen.size_dp_156);
        this.x.setLayoutParams(layoutParams);
    }

    public void S(TextView textView) {
        n3();
    }

    public void S0(SearchModel searchModel, boolean z2, int i2) {
        CLog.b(w0, "updateFragmentData Enter!");
        k3(searchModel, z2, i2);
    }

    public final void S2(SearchModel searchModel, int i2) {
        String str = w0;
        CLog.b(str, "onMoreItemClick  hasInputTips=" + this.p + " position=" + i2 + " data=" + searchModel.toString());
        k0();
        if (this.p) {
            M0(true);
            K2(2000);
            return;
        }
        this.f = W1(this.f + 1).size() > 0 ? this.f + 1 : this.f;
        this.o.u(X2());
        this.o.notifyDataSetChanged();
    }

    public final void S3() {
        CLog.b(w0, "setViewStatus  Enter!  ");
        k0();
        this.p = false;
        this.m.setEditMode(false);
        if (NaviUtil.F0(this.P, this.Q)) {
            this.m.setStartPostion(p2() ? getContext().getString(R.string.my_position) : this.P.getName());
            this.m.setEndPostionName(this.Q.getName());
        }
        this.m.setEditSelectAllOnFocus(false);
        M1();
        h3();
        G1(this.S);
    }

    public void T0(float f) {
        super.T0(f);
        if (getActivity() != null) {
            getActivity().runOnUiThread(new k(this, f));
        }
    }

    public final void T1(AutoCompleteTextView autoCompleteTextView) {
        ULocation g = LocationManager.f().g();
        if (g == null) {
            CLog.b(w0, " doInputQuery() location is null object.");
            return;
        }
        M0(true);
        PoiSearchManager.f().b(getContext().getApplicationContext(), g.getCity(), j0(autoCompleteTextView), new ULatLng(g.getLatitude(), g.getLongitude()), 1, new l(this, autoCompleteTextView));
    }

    public void T3() {
        CustomDialog customDialog = new CustomDialog(getActivity());
        customDialog.c(true);
        customDialog.j(getString(R.string.clear_history_title)).e(getString(R.string.navi_cancel), new e(this, customDialog)).f(getString(R.string.clear_desp), new f(this, customDialog)).show();
    }

    public void U() {
        boolean z2;
        String str = w0;
        CLog.b(str, "onCalculateRouteSuccess()  Enter.  directNavi=" + this.X + " isDeviceConnected=" + StarryNetManger.getInstance().isDeviceConnected() + " isNaving=" + this.R + " isNaviModeSwitch=" + this.Z + " isIsNaving=" + NaviUtil.u0());
        m3();
        if (!Z2()) {
            S1(this.q0, true, true);
            this.q0 = null;
            S1(this.r0, true, true);
            this.r0 = null;
            this.u.setVisibility(8);
            this.s.setVisibility(8);
            int[] q2 = NaviControlManager.k().q();
            this.O = q2;
            if (q2 == null) {
                UToast.e(getContext().getApplicationContext(), R.string.calculate_route_result_none, 1);
            } else if (q2.length < 1) {
                UToast.e(getContext().getApplicationContext(), R.string.calculate_route_result_none, 1);
            } else {
                NaviUtil.k1(getContext(), this.V, this.S, this.Z);
                a4();
                int i2 = 0;
                if ((this.X && !StarryNetManger.getInstance().isDeviceConnected()) || !(z2 = this.X)) {
                    M3(this.O);
                    Z3(this.O[0]);
                } else if (z2) {
                    NaviControlManager.k().D(this.O[0]);
                }
                RelativeLayout relativeLayout = this.J;
                if (this.S != 0 || !NaviUtil.u0()) {
                    i2 = 8;
                }
                relativeLayout.setVisibility(i2);
                if (!this.X) {
                    return;
                }
                if (StarryNetManger.getInstance().isDeviceConnected()) {
                    CLog.b(str, " onCalculateRouteSuccess()  ##################");
                    this.q.setVisibility(8);
                    this.r.setVisibility(8);
                    t4(true);
                    return;
                }
                j4();
            }
        }
    }

    public final void U2() {
        final View findViewById = this.k.findViewById(R.id.navi_mask);
        if (getActivity() != null) {
            new AvoidLimitPopView(getActivity(), new AvoidLimitPopView.OnClickListener() {
                public void f(boolean z) {
                    findViewById.setVisibility(z ? 0 : 8);
                }

                public void g(View view, int i) {
                    String E1 = NaviFragment.w0;
                    CLog.b(E1, "onCarMenuClick  Enter. index=" + i);
                    NaviFragment.this.m.setNavModeSelect(NaviFragment.this.S);
                    NaviFragment naviFragment = NaviFragment.this;
                    naviFragment.J2(naviFragment.S);
                }
            }).x((FrameLayout) this.k.findViewById(R.id.c_status_bar));
            findViewById.setVisibility(0);
        }
    }

    public final void U3(boolean z2) {
        if (!this.R) {
            ((ImageView) this.k.findViewById(R.id.result_img)).setVisibility(8);
            if (z2) {
                this.u.setVisibility(8);
                this.s.setVisibility(0);
                this.t.setText(getString(R.string.calculate_route_failed));
                return;
            }
            this.t.setText(NaviControlManager.k().j(V1()));
            this.u.setVisibility(8);
            this.s.setVisibility(0);
        }
    }

    public final String V1() {
        int i2 = this.S;
        return i2 == 0 ? getString(R.string.drive_title) : i2 == 1 ? getString(R.string.ride_title) : i2 == 2 ? getString(R.string.walk_title) : "";
    }

    public final void V3(boolean z2) {
        p4(z2);
        int i2 = 0;
        if (ConnectionManager.isNetAvailable(getContext().getApplicationContext())) {
            this.v.setVisibility(z2 ? 8 : 0);
            this.B.setVisibility(z2 ? 0 : 8);
            this.w.setVisibility(z2 ? 8 : 0);
            TextView textView = this.u0;
            if (!z2) {
                i2 = 8;
            }
            textView.setVisibility(i2);
        } else {
            this.v.setVisibility(8);
            this.w.setVisibility(8);
            this.u0.setVisibility(0);
        }
        this.x.setVisibility(8);
        this.y.setVisibility(8);
        this.z.setVisibility(8);
        this.A.setVisibility(8);
    }

    public final void W2() {
        ULocation g = LocationManager.f().g();
        if (g == null) {
            CLog.b(w0, "queryNearPoi amapLocation is null!");
            return;
        }
        PoiSearchManager.f().b(getContext().getApplicationContext(), g.getCity(), g.getPoiName(), new ULatLng(g.getLatitude(), g.getLongitude()), 1, new d(this));
    }

    public final void W3(AutoCompleteTextView autoCompleteTextView, List list) {
        O0(list);
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            arrayList.add(n0(autoCompleteTextView, (PlaceBean) list.get(i2)));
        }
        this.n.setVisibility(0);
        if (arrayList.size() > 0) {
            arrayList.add(u0(2, getString(R.string.more_search_results)));
            this.o.u(arrayList);
            this.o.notifyDataSetChanged();
            return;
        }
        this.o.k().clear();
        this.o.u(X2());
        this.o.notifyDataSetChanged();
    }

    public final List X2() {
        int i2;
        this.e.clear();
        this.e.add(u0(5, getString(R.string.my_position)));
        int i3 = 1;
        while (true) {
            i2 = this.f;
            if (i3 > i2) {
                break;
            }
            this.e.addAll(W1(i3));
            i3++;
        }
        if (W1(i2 + 1).size() > 0) {
            this.e.add(u0(2, getString(R.string.more_history)));
            this.e.add(u0(3, getString(R.string.clear_history)));
        } else if (this.e.size() > 1) {
            this.e.add(u0(3, getString(R.string.clear_history)));
        } else if (this.e.size() <= 1) {
            this.e.add(u0(4, getString(R.string.no_history_title)));
        }
        return this.e;
    }

    public final void X3() {
        this.M.setVisibility(8);
        this.N.setVisibility(0);
        this.m.setVisibility(8);
        this.l.setVisibility(0);
        R3(true);
    }

    /* renamed from: Y1 */
    public final void x2() {
        int i2;
        String str = w0;
        CLog.b(str, "hideFragment  Enter!");
        int i3 = 8;
        this.I.setVisibility(8);
        boolean z2 = this.R;
        boolean z3 = this.X;
        if (z2) {
            NaviControlManager.k().Q();
            NaviControlManager.k().P();
            NaviUtil.h1(false);
            NaviUtil.t1(true);
            NaviDataTrackManager.reportCancelNaviTask(this.t0, LocationManager.f().d(), "0");
        }
        V3(false);
        this.i.setShowMode(1);
        NotifyUtils.g(0);
        this.H.setVisibility(8);
        this.I.setVisibility(8);
        this.J.setVisibility(8);
        this.m.setVisibility(0);
        this.q.setVisibility(0);
        this.r.setVisibility(0);
        NaviStrategyMenu naviStrategyMenu = this.M;
        if (this.S == 0) {
            i3 = 0;
        }
        naviStrategyMenu.setVisibility(i3);
        a2(false);
        this.i0 = false;
        e3();
        NaviTopView naviTopView = this.m;
        UNaviPoi uNaviPoi = this.Q;
        naviTopView.C(uNaviPoi != null ? uNaviPoi.getName() : "");
        c3();
        CLog.b(str, "hideFragment   directNavi=" + this.X + " isNaving=" + this.R + " isNavingOn=" + z2 + " isDirect=" + z3 + " isIsNewTaskNavi=" + NaviUtil.v0() + " quikEnterType=" + this.Y + " isHasGoHome()=" + NaviUtil.p0());
        if (NaviUtil.v0() || ((i2 = this.Y) == 1 && !z2)) {
            getActivity().finish();
        } else if ((z2 && !z3) || (i2 == 1 && z2)) {
            J2(this.S);
        } else if (o0() != null) {
            o0().a((SearchModel) null, false, 1, 0);
        }
    }

    public final boolean Y2() {
        this.s0 = 2;
        boolean C2 = NaviControlManager.k().C(this.S, this.p0);
        String str = w0;
        CLog.b(str, "refreshNaviPath refresh  refreshType=" + this.s0 + "  success=" + C2 + " navMode=" + this.S);
        return C2;
    }

    public final void Y3() {
        this.u.setVisibility(8);
        this.s.setVisibility(0);
        ((ImageView) this.k.findViewById(R.id.result_img)).setVisibility(8);
        this.t.setText(getString(R.string.near_location_info));
    }

    public final void Z1() {
        String str = w0;
        CLog.b(str, "hideOrExitNavi ########### quikEnterType=" + this.Y + " isNaving=" + this.R);
        this.t0 = NaviExitType.PHONE_MANUAL_EXIT;
        NaviUtil.f(getContext(), this.t0);
        int i2 = this.Y;
        if (!(i2 == 0 || i2 == 1 || getActivity() == null)) {
            H3(this.R);
        }
        x2();
    }

    public final boolean Z2() {
        String str = w0;
        CLog.b(str, "resetAMapNaviView() ## navMode=" + this.S + " preNaviMode=" + this.U + " refreshType=" + this.s0 + " isCalculating=" + this.v0);
        if (this.s0 == 2) {
            this.v0 = false;
            return false;
        } else if (this.v0 || this.U == this.S) {
            a2(false);
            this.v0 = false;
            return false;
        } else {
            a2(true);
            L1();
            return true;
        }
    }

    public final void Z3(int i2) {
        NaviControlManager.k().D(i2);
        NaviControlManager.k().d(this.i);
        NaviControlManager.k().f(this.i, this.S);
    }

    public final void a3() {
        AnimationSet animationSet = this.g0;
        if (animationSet != null) {
            animationSet.cancel();
            this.g0.getAnimations().clear();
        }
    }

    public final void a4() {
        String str = w0;
        CLog.b(str, "showRefreshToast()   refreshType=" + this.s0);
        String p2 = NaviControlManager.k().p(false, this.s0);
        if (!TextUtils.isEmpty(p2)) {
            UToast.g(getContext().getApplicationContext(), p2, 0);
            t3(true);
        }
        this.s0 = 0;
    }

    public final void b3() {
        this.X = true;
        this.i0 = false;
        NaviTopView naviTopView = this.m;
        SearchModel searchModel = this.V;
        naviTopView.C(searchModel != null ? searchModel.getName() : "");
        this.l0.removeMessages(1300);
        this.l0.sendEmptyMessage(1300);
    }

    public final void b4() {
        NaviControlManager.k().P();
        B3();
        this.R = false;
        this.X = false;
        H3(false);
        int i2 = 8;
        this.H.setVisibility(8);
        this.I.setVisibility(8);
        this.J.setVisibility(8);
        this.m.setVisibility(0);
        this.q.setVisibility(0);
        this.r.setVisibility(0);
        NaviStrategyMenu naviStrategyMenu = this.M;
        if (this.S == 0) {
            i2 = 0;
        }
        naviStrategyMenu.setVisibility(i2);
        V3(false);
        a2(false);
        e3();
        J2(this.S);
        if (getActivity() != null) {
            LocationUtil.e(getActivity(), 1003, new LocationUtil.LocationCallback() {
                public void a() {
                    CLog.b(NaviFragment.w0, "showSetGpsDialog: onRefuseOpenGps");
                }

                public void b() {
                    CLog.b(NaviFragment.w0, "showSetGpsDialog: onStatusOk");
                }
            });
        }
    }

    public void c3() {
        this.R = false;
        this.X = false;
        this.Z = false;
        H3(false);
        this.l0.sendEmptyMessage(1200);
        int enterType = NaviOperatorManager.getInstance(getContext().getApplicationContext()).getEnterType();
        String str = w0;
        CLog.b(str, "resetNaviAction startedNavi=" + this.h0 + " enterType=" + enterType);
        if (this.h0) {
            StarryNetManger.getInstance().sendMessage(ProtocolUtils.g("navi_event", this.S, "navi_stop"), (SendMessageListener) null);
            this.h0 = false;
            NaviUtil.q1(false);
        }
        CLog.b(str, "resetNaviAction End.");
    }

    public void d(RecyclerView recyclerView, View view, int i2, SearchModel searchModel) {
        String str = w0;
        CLog.b(str, "  onItemClick()  position=" + i2);
        int type = searchModel.getType();
        CLog.b(str, "onItemClick() ####### other. viewType=" + type);
        if (type == 0 || type == 1) {
            k0();
            n4(searchModel);
        } else if (type == 2) {
            S2(searchModel, i2);
        } else if (type == 3) {
            k0();
            T3();
        } else if (type != 5) {
            CLog.b(str, "onItemClick default ############## viewType=" + type);
        } else {
            k0();
            M0(true);
            W2();
        }
    }

    public final void d2() {
        this.q = this.k.findViewById(R.id.bottm_panel);
        this.r = this.k.findViewById(R.id.bottom_empty);
        DrawableCenterTextView drawableCenterTextView = (DrawableCenterTextView) this.k.findViewById(R.id.navi);
        this.j = drawableCenterTextView;
        drawableCenterTextView.setOnClickListener(this);
        RouteItemView routeItemView = (RouteItemView) this.k.findViewById(R.id.tab_a);
        this.D = routeItemView;
        routeItemView.setOnClickListener(this);
        RouteItemView routeItemView2 = (RouteItemView) this.k.findViewById(R.id.tab_b);
        this.E = routeItemView2;
        routeItemView2.setOnClickListener(this);
        RouteItemView routeItemView3 = (RouteItemView) this.k.findViewById(R.id.tab_c);
        this.F = routeItemView3;
        routeItemView3.setOnClickListener(this);
        LinearLayout linearLayout = (LinearLayout) this.k.findViewById(R.id.calculate_result);
        this.s = linearLayout;
        linearLayout.setOnClickListener((View.OnClickListener) null);
        this.t = (TextView) this.k.findViewById(R.id.result_desp);
        ((ImageView) this.k.findViewById(R.id.result_img)).setOnClickListener(this);
        this.u = (RelativeLayout) this.k.findViewById(R.id.calculate_loading);
        ((ImageView) this.k.findViewById(R.id.img_loading)).startAnimation(this.g0);
        NaviMenuView naviMenuView = (NaviMenuView) this.k.findViewById(R.id.naviMenuView);
        this.I = naviMenuView;
        naviMenuView.setNaviMenu(this);
        RelativeLayout relativeLayout = (RelativeLayout) this.k.findViewById(R.id.naviSpeedLayout);
        this.J = relativeLayout;
        relativeLayout.setOnClickListener(new h(this));
        this.K = (TextView) this.k.findViewById(R.id.naviSpeed);
        this.L = (DriveWayLinear) this.k.findViewById(R.id.myDriveWayView);
        NaviStrategyMenu naviStrategyMenu = (NaviStrategyMenu) this.k.findViewById(R.id.naviStrategy);
        this.M = naviStrategyMenu;
        naviStrategyMenu.setOnClickListener(new i(this));
        this.M.setVisibility(this.S == 0 ? 0 : 8);
        NaviStrategyView naviStrategyView = (NaviStrategyView) this.k.findViewById(R.id.naviStrategyView);
        this.N = naviStrategyView;
        naviStrategyView.setStrategyChangeListener(this);
        this.M.setStrategyText(this.N.getNaviStrategyDesp());
        this.b = (NaviProgressView) this.k.findViewById(R.id.loadingProgress);
    }

    public final void d3() {
        this.L.setVisibility(8);
        StarryNetManger.getInstance().sendMessage(ProtocolUtils.a("hide_lane_info", ""), (SendMessageListener) null);
    }

    public final void d4() {
        if (NaviUtil.p0()) {
            this.t0 = NaviExitType.PHONE_MANUAL_EXIT;
            NaviUtil.f(getContext(), this.t0);
            NaviControlManager.k().Q();
            NaviControlManager.k().P();
            NaviUtil.h1(false);
            NaviUtil.t1(true);
            NaviDataTrackManager.reportCancelNaviTask(this.t0, LocationManager.f().d(), "0");
            getActivity().finish();
            return;
        }
        Z1();
    }

    public void e(RecyclerView recyclerView, View view, int i2, SearchModel searchModel) {
        String str = w0;
        CLog.b(str, "ItemClickListener  onRouteClick()  position=" + i2);
    }

    public final void e2() {
        ImageView imageView = (ImageView) this.k.findViewById(R.id.my_location);
        this.w = imageView;
        imageView.setOnClickListener(this);
        RelativeLayout relativeLayout = (RelativeLayout) this.k.findViewById(R.id.route_refresh);
        this.v = relativeLayout;
        relativeLayout.setOnClickListener(this);
        ImageView imageView2 = (ImageView) this.k.findViewById(R.id.trafficSwitch);
        this.x = imageView2;
        imageView2.setOnClickListener(new g(this));
        TextView textView = (TextView) this.k.findViewById(R.id.navi_mode_switch);
        this.y = textView;
        textView.setOnClickListener(this);
        TextView textView2 = (TextView) this.k.findViewById(R.id.navi_tts_play);
        this.z = textView2;
        textView2.setOnClickListener(this);
        TextView textView3 = (TextView) this.k.findViewById(R.id.msg_mask);
        this.A = textView3;
        textView3.setOnClickListener(this);
        NaviFloatMenu naviFloatMenu = (NaviFloatMenu) this.k.findViewById(R.id.navifloatmenu);
        this.B = naviFloatMenu;
        naviFloatMenu.setNaviFloatMenuListener(this);
        this.C = this.k.findViewById(R.id.bottomWightView);
        this.u0 = (TextView) this.k.findViewById(R.id.refresh_text);
    }

    public final void e3() {
        PlaceBean j2 = LocationManager.f().j();
        if (j2 == null) {
            CLog.b(w0, "resetNaviStartPoi() place is null .");
        } else if (j2.getLatitude() == 0.0d || j2.getLongitude() == 0.0d) {
            CLog.b(w0, "resetNaviStartPoi() Latitude or Longitude is 0.0.");
        } else {
            String str = w0;
            CLog.b(str, "resetNaviStartPoi() isPosReversed=" + this.i0);
            if (this.i0) {
                this.Q = new UNaviPoi(j2.getPoiName(), j2.getPoiId(), j2.getLatitude(), j2.getLongitude());
            } else {
                this.P = new UNaviPoi(j2.getPoiName(), j2.getPoiId(), j2.getLatitude(), j2.getLongitude());
            }
        }
    }

    public final void e4() {
        CLog.b(w0, "switchNaviMode function enter,here is begin to switch navi mode");
        NaviControlManager.k().P();
        this.R = false;
        this.X = true;
        this.Z = true;
        e3();
        if (this.S == 0) {
            J2(2);
        } else {
            J2(0);
        }
    }

    public void f(boolean z2) {
        String str = w0;
        CLog.b(str, "onRefreshRouteResult()  Enter.  success=" + z2 + " refreshType=" + this.s0 + "isNaving=" + this.R + " isIsNaving=" + NaviUtil.u0());
        String p2 = NaviControlManager.k().p(true, this.s0);
        if (!TextUtils.isEmpty(p2)) {
            UToast.g(getContext().getApplicationContext(), p2, 0);
        }
        this.s0 = 0;
        t3(z2);
    }

    public final void f2() {
        m4(CSharedPreferences.m(getContext().getApplicationContext()));
        h4(!CSharedPreferences.b(getContext().getApplicationContext(), "msg_mask", false));
    }

    public final void f3() {
        this.R = false;
        this.X = false;
        H3(false);
    }

    public final void f4() {
        String str = w0;
        CLog.b(str, "switchNaviPosition   navMode=" + this.S);
        this.m.B();
        this.l0.sendEmptyMessageDelayed(300, 150);
        L1();
        g4();
        K3();
        G1(this.S);
    }

    public void g(int i2) {
        int i3 = this.S;
        if (i2 == i3 && i2 == 0) {
            U2();
        } else if (i2 != i3) {
            this.x.setVisibility(8);
            boolean z2 = false;
            this.M.setVisibility(i2 == 0 ? 0 : 8);
            this.M.setStrategyText(this.N.getNaviStrategyDesp());
            this.N.setVisibility(8);
            J2(i2);
            j4();
            if (i2 == 0) {
                z2 = true;
            }
            P3(z2);
        }
    }

    public final void g2() {
        this.l0.sendEmptyMessageDelayed(900, 150);
    }

    public final void g3() {
        NaviView naviView = this.i;
        if (naviView != null) {
            naviView.b();
        }
    }

    public final void g4() {
        if (NaviUtil.F0(this.P, this.Q)) {
            String name = this.P.getName();
            String poiId = this.P.getPoiId();
            double latitude = this.P.getLatitude();
            double longitude = this.P.getLongitude();
            String name2 = this.Q.getName();
            String poiId2 = this.Q.getPoiId();
            double latitude2 = this.Q.getLatitude();
            double longitude2 = this.Q.getLongitude();
            this.P.setPoiId(poiId2);
            this.P.setName(name2);
            this.P.setLatitude(latitude2);
            this.P.setLongitude(longitude2);
            this.Q.setPoiId(poiId);
            this.Q.setName(name);
            this.Q.setLatitude(latitude);
            this.Q.setLongitude(longitude);
            this.i0 = !this.i0;
        }
    }

    public void h(int i2) {
        String str = w0;
        CLog.b(str, "onRouteDeviation()  Enter.  meters=" + i2);
        this.X = true;
        this.i0 = false;
        NaviTopView naviTopView = this.m;
        SearchModel searchModel = this.V;
        naviTopView.C(searchModel != null ? searchModel.getName() : "");
        this.l0.removeMessages(1300);
        this.l0.sendEmptyMessage(1300);
        e3();
        J2(this.S);
    }

    public void h0(int i2, INaviActionResult iNaviActionResult) {
        String str = w0;
        CLog.b(str, "changeNavi  naviMode=" + i2);
        StarryNetManger.getInstance().sendMessage(ProtocolUtils.g("navi_mode_switch", i2, " " + this.S), (SendMessageListener) null);
        NaviDataTrackManager.reportChangeWaysModeTask(String.valueOf(this.S), String.valueOf(i2), LocationManager.f().d());
        if (!NaviUtil.s0()) {
            NaviControlManager.k().P();
            this.R = false;
        }
        this.q0 = iNaviActionResult;
        this.Z = true;
        this.T = i2;
        b3();
        e3();
        J2(i2);
    }

    public final void h2(Bundle bundle) {
        String str = w0;
        CLog.b(str, "initMapView() NaviUtil.isIsNaving()=" + NaviUtil.u0());
        NaviView naviView = (NaviView) this.k.findViewById(R.id.navi_view);
        this.i = naviView;
        naviView.k(bundle);
        this.i.f();
    }

    public final void h3() {
        this.D.setVisibility(0);
        this.D.setItemSelect(false);
        this.E.setVisibility(0);
        this.E.setItemSelect(false);
        this.F.setVisibility(0);
        this.F.setItemSelect(false);
    }

    public final void h4(boolean z2) {
        Drawable drawable = getContext().getApplicationContext().getDrawable(z2 ? R.mipmap.ic_mask_on : R.drawable.ic_notifications_on);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        this.A.setCompoundDrawablesRelative((Drawable) null, drawable, (Drawable) null, (Drawable) null);
    }

    public void i0(int i2, INaviActionResult iNaviActionResult) {
        String str = w0;
        CLog.b(str, "changeRoute  strategy=" + i2);
        this.r0 = iNaviActionResult;
        this.p0 = i2;
        b3();
        e3();
        G1(this.S);
    }

    public final void i3() {
        this.p = false;
        HistoryListAdapter historyListAdapter = this.o;
        if (historyListAdapter != null && historyListAdapter.k() != null) {
            this.o.k().clear();
            List X2 = X2();
            this.o.u(X2);
            this.o.notifyDataSetChanged();
            if (X2.size() > 0) {
                this.n.setVisibility(0);
            } else {
                this.n.setVisibility(8);
            }
        }
    }

    public final void i4(NaviInfoBean naviInfoBean) {
        if (naviInfoBean != null) {
            if (NaviUtil.r0(naviInfoBean.getIconType())) {
                this.H.c(naviInfoBean);
            }
            this.I.l(naviInfoBean, this.S);
        }
    }

    public void j(TextView textView) {
        if (getActivity() != null) {
            getActivity().startActivityForResult(new Intent(getActivity(), SettingActivity.class), 0);
        }
    }

    public final void j2() {
        this.n0 = (RelativeLayout) this.k.findViewById(R.id.rlt_map);
        this.m0 = new NaviMap(getContext().getApplicationContext(), this.n0);
        this.n0.setVisibility(4);
    }

    public final void j3() {
        this.L.setVisibility(8);
        StarryNetManger.getInstance().sendMessage(ProtocolUtils.a("hide_lane_info", ""), (SendMessageListener) null);
        this.I.j();
        this.I.i();
    }

    public final void j4() {
        if (getActivity() == null) {
            return;
        }
        if (!ConnectionManager.isNetAvailable(getContext().getApplicationContext()) || !StarryNetManger.getInstance().isDeviceConnected()) {
            k4(false);
        } else {
            k4(true);
        }
    }

    public void k() {
        f4();
    }

    public void k0() {
        ((InputMethodManager) getContext().getApplicationContext().getSystemService("input_method")).hideSoftInputFromWindow(this.m.getCurEdit().getWindowToken(), 0);
    }

    public final void k3(SearchModel searchModel, boolean z2, int i2) {
        if (this.M == null) {
            CLog.b(w0, "restartNavi Abnormal protection avtion!");
        } else if (searchModel != null) {
            String str = w0;
            CLog.b(str, "restartNavi enter directNavi=" + this.X + " quikType = " + i2 + " model=" + searchModel.toString());
            this.W = this.V;
            if (this.R) {
                NaviControlManager.k().Q();
                NaviControlManager.k().P();
                this.R = false;
            }
            this.V = searchModel;
            this.X = z2;
            this.Y = i2;
            k2();
            K3();
            if (!this.Z) {
                L3(this.V);
            }
            SearchModel searchModel2 = this.V;
            this.p0 = searchModel2 != null ? searchModel2.getStrategy() : this.p0;
            this.l0.sendEmptyMessage(1700);
            G1(this.S);
        } else {
            String str2 = w0;
            CLog.b(str2, "restartNavi enter directNavi=" + this.X + " quikType = " + i2);
        }
    }

    public final void k4(boolean z2) {
        String str = w0;
        CLog.b(str, "updateNaviBtnState: isEnabled=" + z2 + " navMode=" + this.S);
        int i2 = this.S;
        if (i2 == 0) {
            this.j.setCompoundDrawablesRelativeWithIntrinsicBounds(getContext().getApplicationContext().getResources().getDrawable(z2 ? R.drawable.car : R.drawable.car_icon, (Resources.Theme) null), (Drawable) null, (Drawable) null, (Drawable) null);
            this.j.setBackgroundResource(z2 ? R.drawable.navi_drive_btn_bg : R.drawable.navi_btn_gray);
            this.j.setTextColor(getContext().getApplicationContext().getResources().getColor(z2 ? R.color.theme_color_1 : R.color.theme_white_alpha_color));
        } else if (i2 == 1) {
            this.j.setCompoundDrawablesRelativeWithIntrinsicBounds(getContext().getApplicationContext().getResources().getDrawable(z2 ? R.drawable.bike : R.drawable.bike_icon, (Resources.Theme) null), (Drawable) null, (Drawable) null, (Drawable) null);
            this.j.setBackgroundResource(z2 ? R.drawable.navi_ride_btn_bg : R.drawable.navi_btn_gray);
            this.j.setTextColor(getContext().getApplicationContext().getResources().getColor(z2 ? R.color.theme_color_1 : R.color.theme_white_alpha_color));
        } else if (i2 != 2) {
            CLog.b(str, "setNavModeSelect  default.");
        } else {
            this.j.setCompoundDrawablesRelativeWithIntrinsicBounds(getContext().getApplicationContext().getResources().getDrawable(z2 ? R.drawable.walk : R.drawable.walk_icon, (Resources.Theme) null), (Drawable) null, (Drawable) null, (Drawable) null);
            this.j.setBackgroundResource(z2 ? R.drawable.navi_walk_btn_bg : R.drawable.navi_btn_gray);
            this.j.setTextColor(getContext().getApplicationContext().getResources().getColor(z2 ? R.color.theme_color_1 : R.color.theme_white_alpha_color));
        }
    }

    public void l() {
        Q1("arrive_destination");
    }

    public void l0() {
        String str = w0;
        CLog.b(str, "continueNavi startedNavi is:" + this.h0);
        if (!this.h0) {
            String i2 = ProtocolUtils.i(this.S, !CSharedPreferences.b(getContext().getApplicationContext(), "msg_mask", false), CSharedPreferences.e(getContext().getApplicationContext()), CSharedPreferences.b(getContext().getApplicationContext(), "navi_brightness", true), X1(), System.currentTimeMillis());
            String c = NotifyUtils.c(getContext().getApplicationContext(), i2);
            CLog.b(str, "continueNavi dataMsg length is:" + i2.length() + " reqMsg length is:" + c.length());
            StarryNetManger.getInstance().sendMessage(c, "com.upuphone.star.launcher", (SendMessageListener) null);
        }
    }

    public void m(NaviLaneInfo naviLaneInfo) {
        CLog.b(w0, "showLaneInfo ");
        this.L.setVisibility(0);
        this.L.e(naviLaneInfo);
    }

    public final void n2() {
        this.G = (TitleView) this.k.findViewById(R.id.naviTitleView);
        ImageView imageView = (ImageView) this.k.findViewById(R.id.downBack);
        this.l = imageView;
        imageView.setVisibility(8);
        this.l.setOnClickListener(new b(this));
        NaviTopView naviTopView = (NaviTopView) this.k.findViewById(R.id.top_panel);
        this.m = naviTopView;
        SearchModel searchModel = this.V;
        naviTopView.setEndPostionName(searchModel != null ? searchModel.getName() : "");
        SearchModel searchModel2 = this.V;
        this.p0 = searchModel2 != null ? searchModel2.getStrategy() : this.p0;
        this.m.setViewActionListener(this);
        RecyclerView recyclerView = (RecyclerView) this.k.findViewById(R.id.input_tips_list);
        this.n = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext().getApplicationContext()));
        this.H = (NavInfoView) this.k.findViewById(R.id.nav_info_view);
    }

    public final void n3() {
        String str = w0;
        CLog.b(str, "routeRefresh refresh button clicked. navMode=" + this.S + " isNaving=" + this.R + " refreshType=" + this.s0);
        if (this.R) {
            NaviControlManager.k().J(0);
            Y2();
            return;
        }
        this.s0 = 1;
        J2(this.S);
    }

    public final void n4(SearchModel searchModel) {
        if (searchModel == null) {
            CLog.b(w0, "updatePositionPoi searchModel is null!");
            return;
        }
        String str = w0;
        CLog.b(str, "updatePositionPoi topPanel.isStartEdit()=" + this.m.v() + " searchModel=" + searchModel.toString());
        if (searchModel.getDistance() == -2) {
            this.m.setEditMode(true);
            this.m.getCurEdit().setText(searchModel.getName());
            return;
        }
        NaviUtil.h0(getContext(), searchModel);
        J3(searchModel, searchModel.getName(), searchModel.getAcode(), new ULatLng(searchModel.getLatitude(), searchModel.getLongitude()));
    }

    public final boolean o2() {
        String string = getContext().getString(R.string.my_position);
        String obj = this.m.getEndPostion().getText().toString();
        String str = w0;
        CLog.b(str, "isDestinationNear : baseValue=" + string + " endPostion=" + obj);
        return getContext().getString(R.string.my_position).equals(obj);
    }

    public final void o3(int i2) {
        if (i2 == 0) {
            Z3(this.D.getRouteId());
            this.D.setItemSelect(true);
            this.E.setItemSelect(false);
            this.F.setItemSelect(false);
        } else if (i2 == 1) {
            Z3(this.E.getRouteId());
            this.D.setItemSelect(false);
            this.E.setItemSelect(true);
            this.F.setItemSelect(false);
        } else if (i2 == 2) {
            Z3(this.F.getRouteId());
            this.D.setItemSelect(false);
            this.E.setItemSelect(false);
            this.F.setItemSelect(true);
        }
    }

    public final void o4() {
        this.m.setEditSelectAllOnFocus(true);
        int i2 = 0;
        this.m.setEditMode(false);
        NaviStrategyMenu naviStrategyMenu = this.M;
        if (this.S != 0) {
            i2 = 8;
        }
        naviStrategyMenu.setVisibility(i2);
        h3();
        j4();
        f2();
        V3(this.R);
        NaviTopView naviTopView = this.m;
        SearchModel searchModel = this.V;
        naviTopView.C(searchModel != null ? searchModel.getName() : "");
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        SearchModel searchModel;
        super.onActivityResult(i2, i3, intent);
        if (2000 == i3 && intent != null && (searchModel = (SearchModel) intent.getSerializableExtra("result_data")) != null) {
            String str = w0;
            CLog.b(str, "onActivityResult  requestCode=" + i2 + " resultCode=" + i3 + "  isNaviModeSwitch=" + this.Z + " searchModel=" + searchModel.toString());
            n4(searchModel);
        }
    }

    public void onBackPressed() {
        if (this.R) {
            P2();
        } else if (this.n.isShown()) {
            S3();
        } else {
            Z1();
        }
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.navi) {
            J1();
        } else if (id == R.id.tab_a) {
            o3(0);
        } else if (id == R.id.tab_b) {
            o3(1);
        } else if (id == R.id.tab_c) {
            o3(2);
        } else if (id == R.id.route_refresh) {
            n3();
        } else if (id == R.id.my_location) {
            R2(1003);
        } else if (id == R.id.navi_mode_switch) {
            e4();
        } else if (id == R.id.navi_tts_play) {
            I3();
        } else if (id == R.id.msg_mask) {
            E2();
        } else if (id == R.id.result_img) {
            G1(this.S);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        CLog.b(w0, "onCreate");
        NaviUtil.l1(false);
        this.l0 = new AppHandler(this);
        U1();
        k2();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_navi, viewGroup, false);
        this.k = inflate;
        return inflate;
    }

    public void onDestroy() {
        super.onDestroy();
        int enterType = NaviOperatorManager.getInstance(getContext().getApplicationContext()).getEnterType();
        String str = w0;
        CLog.b(str, "onDestroy startedNavi=" + this.h0 + " enterType=" + enterType + " naviExitType=" + this.t0 + " directNavi=" + this.X + " isNaving=" + this.R + " isNaviHome()=" + NaviUtil.z0() + " getNaviHomeBean=" + NaviUtil.P());
        if (this.t0 == NaviExitType.NONE && NaviUtil.u0()) {
            O2();
        }
        if (NaviUtil.P() == null) {
            Context applicationContext = getContext().getApplicationContext();
            NaviOperatorManager.getInstance(applicationContext).stopNaviService(applicationContext);
            q3();
            A3();
            f3();
        }
        a3();
        L1();
        g3();
        K1();
        NaviControlManager.k().I((INaviEvent) null);
        long currentTimeMillis = System.currentTimeMillis();
        R1();
        CLog.b(str, "onDestroy finish. Destroy time is:" + (System.currentTimeMillis() - currentTimeMillis));
    }

    public void onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
        if (i2 == 6 && this.p) {
            M0(true);
            K2(2000);
        }
    }

    public void onPause() {
        super.onPause();
        this.i.l();
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i2, strArr, iArr);
        String str = w0;
        CLog.b(str, "onRequestPermissionsResult  requestCode " + i2);
        if (508 == i2) {
            NaviOperatorManager.getInstance(getContext().getApplicationContext()).startLocation(getContext().getApplicationContext());
        }
    }

    public void onResume() {
        super.onResume();
        this.i.m();
        this.i.setNaviMode(NaviUtil.u0() ^ true ? 1 : 0);
        f2();
        V3(NaviUtil.u0());
        O3();
    }

    public void onStart() {
        super.onStart();
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        return false;
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        b2();
        g2();
        h2(bundle);
        a2(this.X || NaviUtil.u0());
        K3();
        l2();
        n2();
        c2();
        d2();
        e2();
        f2();
        j4();
        j2();
        i2();
        T0(this.d);
    }

    public final boolean p2() {
        ULocation g = LocationManager.f().g();
        if (g != null && NaviUtil.F0(this.P, this.Q)) {
            return NaviUtil.C0(new ULatLng(g.getLatitude(), g.getLongitude()), new ULatLng(this.P.getLatitude(), this.P.getLongitude()));
        }
        return true;
    }

    public final void p4(boolean z2) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.C.getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = z2 ? getResources().getDimensionPixelOffset(R.dimen.size_dp_74) : getResources().getDimensionPixelOffset(R.dimen.size_dp_180);
        this.C.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.v.getLayoutParams();
        layoutParams2.bottomMargin = z2 ? getResources().getDimensionPixelOffset(R.dimen.size_dp_2) : getResources().getDimensionPixelOffset(R.dimen.size_dp_74);
        this.v.setLayoutParams(layoutParams2);
    }

    public final void q3() {
        NaviExitType naviExitType = this.t0;
        if (naviExitType == NaviExitType.NONE) {
            naviExitType = NaviExitType.PHONE_ABNORMAL_EXIT;
        }
        this.t0 = naviExitType;
        if (this.R) {
            NaviUtil.Z0(getContext(), this.t0);
            NaviUtil.f(getContext(), this.t0);
        }
    }

    public final void q4(boolean z2) {
        this.x.setImageResource(z2 ? R.drawable.traffic_off : R.drawable.traffic_on);
        UToast.e(getContext().getApplicationContext(), !z2 ? R.string.traffic_on_msg : R.string.traffic_off_msg, 0);
    }

    public void r() {
        this.M.setVisibility(0);
        this.M.setStrategyText(this.N.getNaviStrategyDesp());
        this.N.setVisibility(8);
        this.m.setVisibility(0);
        this.l.setVisibility(8);
        R3(false);
    }

    public final /* synthetic */ void r2() {
        UToast.e(getContext().getApplicationContext(), R.string.please_disconnected, 0);
    }

    public final void r4(boolean z2) {
        TextView menuTtsPlay = this.B.getMenuTtsPlay();
        if (menuTtsPlay == null) {
            CLog.b(w0, "updateTtsMenuStatus enter. view is null!");
            return;
        }
        Drawable drawable = getActivity().getDrawable(z2 ? R.drawable.ic_volume_on : R.drawable.ic_volume_off);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        menuTtsPlay.setCompoundDrawablesRelative((Drawable) null, drawable, (Drawable) null, (Drawable) null);
        menuTtsPlay.setText(z2 ? R.string.open_tts_broadcast : R.string.close_tts_broadcast);
        menuTtsPlay.setTextColor(getActivity().getColor(z2 ? R.color.broadcast_color : R.color.not_network_color));
        if (z2) {
            NaviControlManager.k().O();
        } else {
            NaviControlManager.k().Q();
        }
    }

    public void s(int i2) {
        TextView textView = this.K;
        textView.setText(i2 + "");
    }

    public String s0() {
        UNaviPoi uNaviPoi = this.Q;
        return uNaviPoi != null ? uNaviPoi.getName() : "";
    }

    public final /* synthetic */ void s2(AutoCompleteTextView autoCompleteTextView, List list) {
        if (getContext() != null) {
            F1(autoCompleteTextView, list);
        }
        if (list != null) {
            list.clear();
        }
    }

    public final void s3() {
        StarryNetManger.getInstance().sendMessage(ProtocolUtils.g("navi_heartbeat_check", this.S, "com.upuphone.ar.navi.lite"), (SendMessageListener) null);
        this.l0.removeMessages(1000);
        this.l0.sendEmptyMessageDelayed(1000, 250);
    }

    public final /* synthetic */ void t2(View view) {
        D3();
    }

    public final /* synthetic */ void u2(View view) {
        X3();
    }

    public void v() {
        CLog.b(w0, "hideLaneInfo ");
        this.L.setVisibility(8);
    }

    public final /* synthetic */ void v2(View view) {
        Q3();
    }

    public final /* synthetic */ void w2(View view) {
        r();
    }

    public void x(NaviInfoBean naviInfoBean, boolean z2) {
        if (this.R && !this.h0 && z2) {
            CLog.b(w0, "onNaviInfoUpdate() @@@@@@@@@@@ need set Previous navi info.");
            NaviUtil.r1(naviInfoBean);
        }
        if (naviInfoBean != null) {
            this.I.l(naviInfoBean, this.S);
            this.K.setText(naviInfoBean.getNaviSpeed());
        }
        if (naviInfoBean != null && NaviUtil.r0(naviInfoBean.getIconType())) {
            H2(naviInfoBean);
            this.H.c(naviInfoBean);
        }
        NaviUtil.b1(getContext().getApplicationContext(), this.h0);
    }

    public void y(int i2) {
        this.p0 = i2;
        h3();
        G1(this.S);
    }

    public final /* synthetic */ void y2() {
        getActivity().finish();
    }

    public final /* synthetic */ void z2() {
        UToast.e(getContext().getApplicationContext(), R.string.please_disconnected, 0);
    }
}
