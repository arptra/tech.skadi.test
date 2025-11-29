package com.upuphone.ar.navi.lite.service;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.text.TextUtils;
import com.honey.account.m4.a;
import com.honey.account.m4.b;
import com.upuphone.ar.navi.lite.R;
import com.upuphone.ar.navi.lite.base.FreqAddress;
import com.upuphone.ar.navi.lite.base.PlaceBean;
import com.upuphone.ar.navi.lite.base.SearchModel;
import com.upuphone.ar.navi.lite.base.ULatLng;
import com.upuphone.ar.navi.lite.base.ULocation;
import com.upuphone.ar.navi.lite.location.LocationManager;
import com.upuphone.ar.navi.lite.manger.NaviManager;
import com.upuphone.ar.navi.lite.manger.NaviOperatorManager;
import com.upuphone.ar.navi.lite.manger.StarryNetManger;
import com.upuphone.ar.navi.lite.model.IConnection;
import com.upuphone.ar.navi.lite.model.IConnectionManager;
import com.upuphone.ar.navi.lite.model.INavigation;
import com.upuphone.ar.navi.lite.model.INavigationManager;
import com.upuphone.ar.navi.lite.model.INetDevice;
import com.upuphone.ar.navi.lite.model.INetDeviceManager;
import com.upuphone.ar.navi.lite.protocol.DataBean;
import com.upuphone.ar.navi.lite.protocol.NotifyUtils;
import com.upuphone.ar.navi.lite.protocol.ProtocolUtils;
import com.upuphone.ar.navi.lite.search.PoiSearchManager;
import com.upuphone.ar.navi.lite.util.CLog;
import com.upuphone.ar.navi.lite.util.CSharedPreferences;
import com.upuphone.ar.navi.lite.util.JsonUtil;
import com.upuphone.ar.navi.lite.util.LocationUtil;
import com.upuphone.ar.navi.lite.util.NaviUtil;
import com.upuphone.xr.interconnect.entity.StarryNetMessage;
import com.upuphone.xr.interconnect.listener.SendMessageListener;
import com.upuphone.xr.sapp.monitor.starry.cmd.CmdAction;
import java.util.ArrayList;
import java.util.List;

public class NaviDocerService extends Service implements INetDevice, IConnection {
    public static final String b = ("NAVI-" + NaviDocerService.class.getSimpleName());

    /* renamed from: a  reason: collision with root package name */
    public Handler f5802a = new Handler();

    private void c() {
        CLog.b(b, "continueNavi Enter.");
        ArrayList c = INavigationManager.b().c();
        for (int i = 0; i < c.size(); i++) {
            ((INavigation) c.get(i)).E();
        }
    }

    private void e() {
        INetDeviceManager.b().d(this);
        IConnectionManager.c().d(this);
        NaviOperatorManager.getInstance(getApplicationContext()).stopLocation();
    }

    public void A(boolean z) {
        String str = b;
        CLog.b(str, "onDeviceConnectState  isOnline=" + z);
        if (!z) {
            stopSelf();
        }
    }

    public final void d(PlaceBean placeBean) {
        if (placeBean != null) {
            String address = placeBean.getAddress();
            String poiName = placeBean.getPoiName();
            if (!TextUtils.isEmpty(poiName)) {
                poiName = String.format(NaviUtil.s0() ? getString(R.string.navi_location_desp) : NaviUtil.c0(this, R.string.navi_location_desp), new Object[]{poiName});
            }
            String e = ProtocolUtils.e(address, poiName);
            String str = b;
            CLog.b(str, "dealRegeocodeResult  address:" + address + " getDescription=" + poiName + " regeocodeResult  data:" + e);
            StarryNetManger.getInstance().sendMessage(e, (SendMessageListener) null);
            return;
        }
        CLog.b(b, "dealRegeocodeResult  is null.");
    }

    public final int f(SearchModel searchModel, int i) {
        if (i > 2) {
            int U = NaviUtil.U(getApplicationContext(), new ULatLng(searchModel.getLatitude(), searchModel.getLongitude()));
            String str = b;
            CLog.b(str, "getSelectAddressNaviMode()  ############ alias=" + i + " naviMode=" + U);
            return U;
        }
        int a0 = NaviUtil.a0(getApplicationContext(), searchModel);
        int S = NaviUtil.S(searchModel.getDistance(), a0);
        String str2 = b;
        CLog.b(str2, "getSelectAddressNaviMode()  @@@@@@@@@@@@  tmpMode=" + a0 + " alias=" + i + " naviMode=" + S);
        return S;
    }

    public final FreqAddress g(String str) {
        DataBean dataBean = (DataBean) JsonUtil.b(str, DataBean.class);
        FreqAddress freqAddress = null;
        if (dataBean == null) {
            CLog.b(b, "getSelectFreqAddress: naviEvent == null");
            return null;
        }
        int h = h(dataBean.getData());
        List<FreqAddress> H = NaviUtil.H(getApplicationContext());
        String str2 = b;
        CLog.b(str2, "getSelectFreqAddress:  index=" + h + " freqAddressList.size=" + H.size());
        for (FreqAddress freqAddress2 : H) {
            if (freqAddress2.b() == h) {
                freqAddress = freqAddress2;
            }
        }
        return freqAddress;
    }

    public final int h(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            String str2 = b;
            CLog.b(str2, "getSelectedIndex: excep=" + e);
            return -1;
        }
    }

    public final boolean i() {
        if (!LocationUtil.j(getApplicationContext())) {
            StarryNetManger.getInstance().sendMessage(NotifyUtils.d(NaviUtil.L(getApplicationContext(), R.string.open_gps_tips)), "com.upuphone.star.launcher", (SendMessageListener) null);
            return false;
        }
        List o = NaviUtil.o(getApplicationContext());
        if (!NaviUtil.l0() && o.size() > 0) {
            StarryNetManger.getInstance().sendMessage(NotifyUtils.d(NaviUtil.L(getApplicationContext(), NaviUtil.s0() ? R.string.background_local_toast_intl : R.string.background_local_toast)), "com.upuphone.star.launcher", (SendMessageListener) null);
            return false;
        } else if (NaviManager.getInstance(getApplicationContext()).findDeniedPermissions().size() > 0) {
            return false;
        } else {
            NaviOperatorManager.getInstance(getApplicationContext()).startLocation(getApplicationContext());
            return m() || !NaviUtil.B0();
        }
    }

    public void j(boolean z) {
        String str = b;
        CLog.b(str, "onAssistantWakeupChanged  isWakeup=" + z);
    }

    public void k(boolean z) {
        String str = b;
        CLog.b(str, "onBleConnectState  connected=" + z);
    }

    public final void l() {
        NaviManager.getInstance(getApplicationContext());
        if (StarryNetManger.getInstance().getOperatorManager() == null) {
            StarryNetManger.getInstance().init(getApplicationContext());
        }
    }

    public final boolean m() {
        boolean D0 = NaviUtil.D0(getApplicationContext());
        StarryNetManger.getInstance().sendMessage(ProtocolUtils.g("network_state", 0, D0 ? "1" : "0"), (SendMessageListener) null);
        return D0;
    }

    public final /* synthetic */ void o(List list) {
        if (list != null && list.size() > 0) {
            d((PlaceBean) list.get(0));
            list.clear();
        }
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        super.onCreate();
        INetDeviceManager.b().a(this);
        IConnectionManager.c().a(this);
        CLog.b(b, "onCreate  @@@@@@@@@ ");
    }

    public void onDestroy() {
        super.onDestroy();
        CLog.b(b, "onDestroy  &&&&&&&&&&&&& ");
        e();
    }

    public void onMessageReceive(StarryNetMessage starryNetMessage) {
        String str = b;
        CLog.b(str, "onMessageReceive: starryNetMessage.getMessage():" + starryNetMessage.getMessage());
        if (!TextUtils.isEmpty(starryNetMessage.getMessage())) {
            this.f5802a.post(new a(this, starryNetMessage));
        }
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        String str = b;
        CLog.b(str, "onStartCommand  #########  Enter. getDeviceId=" + LocationManager.f().e(this));
        l();
        p();
        return 2;
    }

    public void onTaskRemoved(Intent intent) {
        super.onTaskRemoved(intent);
        stopSelf();
    }

    public final void p() {
        if (i()) {
            if (NaviUtil.u0()) {
                NaviUtil.n();
                c();
            } else if (NaviUtil.d0(this)) {
                NaviUtil.y1(this, "restore_navi");
            } else {
                v();
            }
        }
    }

    public final void q(SearchModel searchModel) {
        if (NaviUtil.x0(searchModel)) {
            CLog.b(b, "naviToAddress()  show near place toast.");
            StarryNetManger.getInstance().sendMessage(NotifyUtils.d(NaviUtil.L(getApplicationContext(), R.string.near_location_info)), "com.upuphone.star.launcher", (SendMessageListener) null);
            return;
        }
        NaviOperatorManager.getInstance(getApplicationContext()).startNavigation(getApplicationContext(), searchModel, 3);
    }

    /* renamed from: r */
    public final void n(StarryNetMessage starryNetMessage) {
        String message = starryNetMessage.getMessage();
        if (message.contains("navi_start_rsp")) {
            CLog.b(b, "onMessageReceive: NAVI_EVENT_START_RSP");
            NaviUtil.q1(true);
            u();
            m();
        } else if (message.contains("freq_adr_s")) {
            CLog.b(b, "onMessageReceive: FREQ_ADDRESS_SELECT ");
            NaviUtil.q1(true);
            if (i()) {
                y(message);
            }
        } else if (message.contains("navi_stop")) {
            String str = b;
            CLog.b(str, "onMessageReceive: NAVI_EVENT_STOP isIsNaviOpened=" + NaviUtil.t0());
            x();
        } else if (message.contains(CmdAction.CMD_DIALOG_CONFIRM) && message.contains("restore_navi")) {
            CLog.b(b, "onMessageReceive: NOTIFICATION_RSP_CONFIRM");
            if (i()) {
                NaviUtil.B1(getApplicationContext());
            }
        } else if (message.contains(CmdAction.CMD_DIALOG_CANCEL) && message.contains("restore_navi")) {
            CLog.b(b, "onMessageReceive: NOTIFICATION_RSP_CANCEL");
            NaviUtil.T0(getApplicationContext());
            NotifyUtils.g(0);
            if (i()) {
                v();
            }
        } else if ("System".equals(starryNetMessage.getSenderPkg())) {
            NaviUtil.V0();
        }
    }

    public final void s(ULocation uLocation) {
        String str = b;
        CLog.b(str, "positionSearch  Enter! uLocation=" + uLocation);
        PoiSearchManager.f().c(getApplicationContext(), new ULatLng(uLocation.getLatitude(), uLocation.getLongitude()), new b(this));
    }

    public void t(boolean z) {
        String str = b;
        CLog.b(str, "onNetConnectState  isAvailable=" + z);
    }

    public final void u() {
        if (NaviUtil.u0()) {
            CLog.b(b, "sendLocationInfo()  is naving state not send message!");
            return;
        }
        ULocation g = LocationManager.f().g();
        if (g == null) {
            CLog.b(b, "sendLocationInfo()  aMapLocation is invalide not send message!");
            return;
        }
        String str = b;
        CLog.b(str, "sendLocationInfo  getAddress()=" + g.getAddress() + " getDescription=" + g.getDescription());
        if (!TextUtils.isEmpty(g.getAddress())) {
            StarryNetManger.getInstance().sendMessage(ProtocolUtils.e(g.getAddress(), g.getDescription()), (SendMessageListener) null);
            return;
        }
        s(g);
    }

    public final void v() {
        String c = NotifyUtils.c(getApplicationContext(), NaviUtil.k(getApplicationContext()));
        String str = b;
        CLog.b(str, "sendNaviReqMessage reqMsg is:" + c + " length is:" + c.length());
        StarryNetManger.getInstance().sendMessage(c, "com.upuphone.star.launcher", (SendMessageListener) null);
        CSharedPreferences.t(getApplicationContext(), "open_address_tiems", CSharedPreferences.f(getApplicationContext(), "open_address_tiems", 0) + 1);
    }

    public void w() {
        CLog.b(b, "onGpsStateChanged  ");
    }

    public final void x() {
        NaviUtil.d1(false);
        NaviUtil.q1(false);
        if (!NaviUtil.t0()) {
            NaviOperatorManager.getInstance(getApplicationContext()).stopLocation();
        }
    }

    public final void y(String str) {
        String str2 = b;
        CLog.b(str2, "usuallyAddressNavi: data=" + str);
        FreqAddress g = g(str);
        if (g == null) {
            CLog.b(str2, "usuallyAddressNavi: freqAddress is empty!");
            return;
        }
        CLog.b(str2, "usuallyAddressNavi freqAddress:" + g.toString());
        SearchModel searchModel = new SearchModel();
        searchModel.setName(g.f());
        searchModel.setLatitude(g.d());
        searchModel.setLongitude(g.e());
        searchModel.setAddress(g.a());
        searchModel.setDistance(g.c());
        searchModel.setAcode(g.g());
        searchModel.setNaviMode(f(searchModel, g.b()));
        if (searchModel.getLatitude() == 0.0d || searchModel.getLongitude() == 0.0d) {
            CLog.b(str2, "usuallyAddressNavi()  There is no home address record.");
        } else {
            q(searchModel);
        }
    }
}
