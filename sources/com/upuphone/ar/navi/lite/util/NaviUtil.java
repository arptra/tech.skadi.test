package com.upuphone.ar.navi.lite.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import android.view.View;
import com.honey.account.n4.d;
import com.honey.account.n4.e;
import com.honey.account.n4.f;
import com.meizu.common.widget.MzContactsContract;
import com.meizu.net.pedometerprovider.util.Constants;
import com.upuphone.ar.fastrecord.phone.ui.adapter.FastRecordSearchViewAdapter;
import com.upuphone.ar.navi.lite.BuildConfig;
import com.upuphone.ar.navi.lite.R;
import com.upuphone.ar.navi.lite.base.CommonAddress;
import com.upuphone.ar.navi.lite.base.FreqAddress;
import com.upuphone.ar.navi.lite.base.NaviAbnormalRecod;
import com.upuphone.ar.navi.lite.base.NaviHomeBean;
import com.upuphone.ar.navi.lite.base.NaviRecord;
import com.upuphone.ar.navi.lite.base.PlaceBean;
import com.upuphone.ar.navi.lite.base.Record;
import com.upuphone.ar.navi.lite.base.SearchModel;
import com.upuphone.ar.navi.lite.base.ULatLng;
import com.upuphone.ar.navi.lite.base.ULocation;
import com.upuphone.ar.navi.lite.base.UNaviPoi;
import com.upuphone.ar.navi.lite.dao.NaviDatabase;
import com.upuphone.ar.navi.lite.location.LocationManager;
import com.upuphone.ar.navi.lite.manger.NaviOperatorManager;
import com.upuphone.ar.navi.lite.manger.StarryNetManger;
import com.upuphone.ar.navi.lite.model.ICheckPermission;
import com.upuphone.ar.navi.lite.model.IPlace;
import com.upuphone.ar.navi.lite.navi.NaviControlManager;
import com.upuphone.ar.navi.lite.protocol.NaviInfoBean;
import com.upuphone.ar.navi.lite.protocol.NotifyUtils;
import com.upuphone.ar.navi.lite.protocol.ProtocolUtils;
import com.upuphone.ar.navi.lite.protocol.WeatherBean;
import com.upuphone.ar.navi.lite.search.PoiSearchManager;
import com.upuphone.ar.navi.lite.service.NaviDocerService;
import com.upuphone.ar.navi.lite.view.CustomDialog;
import com.upuphone.star.common.phone.UToast;
import com.upuphone.xr.interconnect.entity.PoiResult;
import com.upuphone.xr.interconnect.listener.SendMessageListener;
import com.upuphone.xr.sapp.context.SdkContext;
import io.reactivex.rxjava3.annotations.SchedulerSupport;
import java.lang.reflect.InvocationTargetException;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;

public final class NaviUtil {

    /* renamed from: a  reason: collision with root package name */
    public static final String f5809a = ("NAVI-" + NaviUtil.class.getSimpleName());
    public static final String[] b = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"};
    public static final String[] c = {"android.permission.ACCESS_BACKGROUND_LOCATION"};
    public static boolean d = true;
    public static boolean e = true;
    public static boolean f = false;
    public static boolean g = false;
    public static boolean h = false;
    public static boolean i = false;
    public static boolean j = false;
    public static WeatherBean k;
    public static boolean l = true;
    public static boolean m = false;
    public static String[] n;
    public static boolean o = false;
    public static boolean p = false;
    public static boolean q = false;
    public static String r = "";
    public static String s = "";
    public static NaviHomeBean t;
    public static NaviInfoBean u;

    public static String A(Context context, SearchModel searchModel, boolean z, String str) {
        String str2 = "";
        String str3 = str2;
        for (CommonAddress commonAddress : NaviOperatorManager.getInstance(context.getApplicationContext()).getNaviDatabase().d().d(t())) {
            String str4 = f5809a;
            CLog.a(str4, "getDialogInfo  model=" + str + " addr=" + commonAddress.toString() + " data=" + searchModel.toString());
            if (!commonAddress.d().equals(str) && (TextUtils.isEmpty(commonAddress.d()) || TextUtils.isEmpty(str) || !commonAddress.d().contains(SchedulerSupport.CUSTOM) || !str.contains(SchedulerSupport.CUSTOM))) {
                if (J().equals(commonAddress.d()) && searchModel.getName().equals(commonAddress.j())) {
                    str3 = context.getString(R.string.sure_add_address);
                    str2 = String.format(context.getString(R.string.update_match_address_message), new Object[]{context.getString(R.string.home_setting_title)});
                }
                if (w().equalsIgnoreCase(commonAddress.d()) && searchModel.getName().equals(commonAddress.j())) {
                    str3 = context.getString(R.string.sure_add_address);
                    str2 = String.format(context.getString(R.string.update_match_address_message), new Object[]{context.getString(R.string.company_setting_title)});
                }
                if (!TextUtils.isEmpty(commonAddress.d()) && commonAddress.d().contains(SchedulerSupport.CUSTOM) && searchModel.getName().equals(commonAddress.j())) {
                    str3 = context.getString(R.string.sure_add_address);
                    str2 = String.format(context.getString(R.string.update_match_address_message), new Object[]{context.getString(R.string.more_address)});
                }
            }
        }
        return z ? str3 : str2;
    }

    public static boolean A0() {
        return p;
    }

    public static void A1(Context context) {
        NaviAbnormalRecod B = B(context);
        if (B != null) {
            try {
                U0(context);
                String str = f5809a;
                CLog.b(str, "startNaviFromDisConnectTask naviAbnormalRecod:" + B.toString());
                W0(context.getApplicationContext(), B);
            } catch (Exception e2) {
                String str2 = f5809a;
                CLog.b(str2, "startNaviFromDisConnectTask exception:" + e2);
            }
        }
    }

    public static NaviAbnormalRecod B(Context context) {
        try {
            NaviAbnormalRecod naviAbnormalRecod = (NaviAbnormalRecod) JsonUtil.b(CSharedPreferences.l(context.getApplicationContext(), "navi_disconnect_task", ""), NaviAbnormalRecod.class);
            String str = f5809a;
            CLog.b(str, "getDisConnectNaviTask NaviTask:" + naviAbnormalRecod.toString());
            return naviAbnormalRecod;
        } catch (Exception e2) {
            String str2 = f5809a;
            CLog.b(str2, "getDisConnectNaviTask exception:" + e2);
            return null;
        }
    }

    public static boolean B0() {
        return h;
    }

    public static void B1(Context context) {
        NaviAbnormalRecod E = E(context);
        if (E != null) {
            try {
                NotifyUtils.g(CSharedPreferences.f(context.getApplicationContext(), "navi_abnormal_exit_mode", 0));
                T0(context);
                String str = f5809a;
                CLog.b(str, "startNaviFromExitRecod naviAbnormalRecod:" + E.toString());
                W0(context.getApplicationContext(), E);
            } catch (Exception e2) {
                String str2 = f5809a;
                CLog.b(str2, "startNaviFromExitRecod exception:" + e2);
            }
        }
    }

    public static String C(String str, String str2) {
        int i2 = 0;
        while (true) {
            String[] strArr = Constant.f5807a;
            if (i2 >= strArr.length) {
                return str + str2;
            } else if (strArr[i2].equals(str)) {
                return str;
            } else {
                i2++;
            }
        }
    }

    public static boolean C0(ULatLng uLatLng, ULatLng uLatLng2) {
        int round = Math.round(e(new ULatLng(uLatLng.latitude, uLatLng.longitude), new ULatLng(uLatLng2.latitude, uLatLng2.longitude)));
        String str = f5809a;
        CLog.b(str, " isNearLocation distance=" + round);
        return round <= 100 && round != -1;
    }

    public static void C1(Context context, String str, boolean z) {
        if (str.equals("voice_state")) {
            CSharedPreferences.z(context, z);
        } else {
            CSharedPreferences.p(context, str, z);
        }
    }

    public static int D(int i2) {
        if (!RegionUtils.d()) {
            return i2;
        }
        int i3 = i2 == 0 ? 1 : i2;
        String str = f5809a;
        CLog.b(str, "getEuaNaviMode  ######## navMode=" + i2 + " tmpNavMode=" + i3);
        return i3;
    }

    public static boolean D0(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isAvailable();
    }

    public static void D1(Context context) {
        String l2 = CSharedPreferences.l(context.getApplicationContext(), "navi_abnormal_exit_record", "");
        long g2 = CSharedPreferences.g(context.getApplicationContext(), "navi_abnormal_exit_time", 0);
        String str = f5809a;
        CLog.b(str, "updateAbnormalExitRecodTime Enter naviRecord=" + l2 + " lastTime=" + g2 + " currentTimeMillis=" + System.currentTimeMillis());
        if (TextUtils.isEmpty(l2) || g2 == 0) {
            CLog.b(str, "updateAbnormalExitRecod No abnormal record exists.");
        } else {
            CSharedPreferences.u(context.getApplicationContext(), "navi_abnormal_exit_time", System.currentTimeMillis());
        }
    }

    public static NaviAbnormalRecod E(Context context) {
        try {
            NaviAbnormalRecod naviAbnormalRecod = (NaviAbnormalRecod) JsonUtil.b(CSharedPreferences.l(context.getApplicationContext(), "navi_abnormal_exit_record", ""), NaviAbnormalRecod.class);
            String str = f5809a;
            CLog.b(str, "getExitNaviRecord naviAbnormalRecod:" + naviAbnormalRecod.toString());
            return naviAbnormalRecod;
        } catch (Exception e2) {
            String str2 = f5809a;
            CLog.b(str2, "getExitNaviRecord exception:" + e2);
            return null;
        }
    }

    public static boolean E0(Context context) {
        try {
            int i2 = context.getResources().getConfiguration().uiMode;
            int i3 = i2 & 48;
            boolean z = i3 == 32;
            String str = f5809a;
            CLog.b(str, "isNightMode uiMode=" + i2 + " isNightMode=" + z + " mSysThemeConfig=" + i3);
            return z;
        } catch (Exception e2) {
            String str2 = f5809a;
            CLog.b(str2, "isNightMode Exception is:" + e2);
            return false;
        }
    }

    public static void E1(Context context) {
        List H = H(context.getApplicationContext());
        if (H.size() < 1) {
            CLog.b(f5809a, "updateNaviAddress freqAddressList is 0!");
            return;
        }
        String k2 = ProtocolUtils.k(H);
        String str = f5809a;
        CLog.b(str, "updateNaviAddress reqMsg is:" + k2 + " data.length() is:" + k2.length());
        StarryNetManger.getInstance().sendMessage(k2, (SendMessageListener) null);
    }

    public static List F(NaviDatabase naviDatabase, List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        int i2 = -1;
        while (it.hasNext()) {
            NaviRecord naviRecord = (NaviRecord) it.next();
            if (i2 != naviRecord.f()) {
                i2 = naviRecord.f();
                arrayList.addAll(naviDatabase.e().c(t(), i2));
            }
        }
        return arrayList;
    }

    public static boolean F0(UNaviPoi uNaviPoi, UNaviPoi uNaviPoi2) {
        if (uNaviPoi != null && uNaviPoi2 != null) {
            return true;
        }
        CLog.b(f5809a, "isPoiAvailable() Navi Poi is null .");
        return false;
    }

    public static void F1(final Context context, final SearchModel searchModel) {
        PoiSearchManager.f().c(context.getApplicationContext(), new ULatLng(searchModel.getLatitude(), searchModel.getLongitude()), new IPlace() {
            public void a(List list) {
                if (list != null && list.size() > 0) {
                    PlaceBean placeBean = (PlaceBean) list.get(0);
                    SearchModel.this.setCity(placeBean.getCity());
                    SearchModel searchModel = SearchModel.this;
                    searchModel.setDistrict(NaviUtil.C(placeBean.getProvince(), placeBean.getCity()) + placeBean.getDistrict());
                    NaviUtil.i0(context, SearchModel.this);
                    list.clear();
                }
            }
        });
    }

    public static String G(long j2) {
        try {
            return new SimpleDateFormat("HH:mm").format(new Date(j2));
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static boolean G0(Context context, SearchModel searchModel) {
        List g2 = NaviOperatorManager.getInstance(context.getApplicationContext()).getNaviDatabase().f().g(t());
        int i2 = 0;
        while (i2 < g2.size()) {
            Record record = (Record) g2.get(i2);
            if (!searchModel.getName().equals(record.getName()) || !searchModel.getAddress().equals(record.e()) || searchModel.getLatitude() != record.p() || searchModel.getLongitude() != record.p()) {
                i2++;
            } else {
                CLog.b(f5809a, "isRecordExist record is searched! record[" + i2 + "]=" + record.toString());
                return true;
            }
        }
        CLog.b(f5809a, "record is not searched");
        return false;
    }

    public static List H(Context context) {
        CommonAddress commonAddress;
        CommonAddress commonAddress2;
        CLog.b(f5809a, "getFreqNaviAddress **************** ");
        NaviDatabase naviDatabase = NaviOperatorManager.getInstance(context.getApplicationContext()).getNaviDatabase();
        ArrayList arrayList = new ArrayList();
        List f2 = naviDatabase.d().f(t(), J());
        if (f2.size() > 0) {
            commonAddress = (CommonAddress) f2.get(0);
            FreqAddress freqAddress = r6;
            FreqAddress freqAddress2 = new FreqAddress(((CommonAddress) f2.get(0)).j(), z(((CommonAddress) f2.get(0)).h(), ((CommonAddress) f2.get(0)).i()), ((CommonAddress) f2.get(0)).c(), ((CommonAddress) f2.get(0)).h(), ((CommonAddress) f2.get(0)).i(), ((CommonAddress) f2.get(0)).b(), 1);
            arrayList.add(freqAddress);
        } else {
            arrayList.add(new FreqAddress());
            commonAddress = null;
        }
        List f3 = naviDatabase.d().f(t(), w());
        if (f3.size() > 0) {
            commonAddress2 = (CommonAddress) f3.get(0);
            FreqAddress freqAddress3 = r6;
            FreqAddress freqAddress4 = new FreqAddress(((CommonAddress) f3.get(0)).j(), z(((CommonAddress) f3.get(0)).h(), ((CommonAddress) f3.get(0)).i()), ((CommonAddress) f3.get(0)).c(), ((CommonAddress) f3.get(0)).h(), ((CommonAddress) f3.get(0)).i(), ((CommonAddress) f3.get(0)).b(), 2);
            arrayList.add(freqAddress3);
        } else {
            arrayList.add(new FreqAddress());
            commonAddress2 = null;
        }
        List F = F(naviDatabase, naviDatabase.e().h(t()));
        ArrayList arrayList2 = new ArrayList();
        Iterator it = F.iterator();
        int i2 = 3;
        while (it.hasNext()) {
            NaviRecord naviRecord = (NaviRecord) it.next();
            if ((commonAddress == null || !L0(commonAddress.j(), naviRecord.l()) || commonAddress.h() != naviRecord.i() || commonAddress.i() != naviRecord.j()) && (commonAddress2 == null || !L0(commonAddress2.j(), naviRecord.l()) || commonAddress2.h() != naviRecord.i() || commonAddress2.i() != naviRecord.j())) {
                Iterator it2 = it;
                FreqAddress freqAddress5 = r6;
                FreqAddress freqAddress6 = new FreqAddress(naviRecord.l(), z(naviRecord.i(), naviRecord.j()), naviRecord.c(), naviRecord.i(), naviRecord.j(), naviRecord.b(), i2);
                arrayList2.add(freqAddress5);
                i2++;
                if (arrayList2.size() == 6) {
                    break;
                }
                it = it2;
            }
        }
        arrayList.addAll(arrayList2);
        return arrayList;
    }

    public static boolean H0() {
        return d;
    }

    public static List I(Context context) {
        CommonAddress commonAddress;
        CLog.b(f5809a, "getFreqVisitedAddress **************** ");
        NaviDatabase naviDatabase = NaviOperatorManager.getInstance(context.getApplicationContext()).getNaviDatabase();
        ArrayList arrayList = new ArrayList();
        List f2 = naviDatabase.d().f(t(), J());
        CommonAddress commonAddress2 = null;
        if (f2.size() > 0) {
            commonAddress = (CommonAddress) f2.get(0);
            arrayList.add(new PoiResult(((CommonAddress) f2.get(0)).j(), z(((CommonAddress) f2.get(0)).h(), ((CommonAddress) f2.get(0)).i()), ((CommonAddress) f2.get(0)).c(), ((CommonAddress) f2.get(0)).h(), ((CommonAddress) f2.get(0)).i(), J()));
        } else {
            arrayList.add(new PoiResult());
            commonAddress = null;
        }
        List f3 = naviDatabase.d().f(t(), w());
        if (f3.size() > 0) {
            commonAddress2 = (CommonAddress) f3.get(0);
            arrayList.add(new PoiResult(((CommonAddress) f3.get(0)).j(), z(((CommonAddress) f3.get(0)).h(), ((CommonAddress) f3.get(0)).i()), ((CommonAddress) f3.get(0)).c(), ((CommonAddress) f3.get(0)).h(), ((CommonAddress) f3.get(0)).i(), w()));
        } else {
            arrayList.add(new PoiResult());
        }
        List<NaviRecord> F = F(naviDatabase, naviDatabase.e().h(t()));
        ArrayList arrayList2 = new ArrayList();
        int i2 = 3;
        for (NaviRecord naviRecord : F) {
            if ((commonAddress == null || !L0(commonAddress.j(), naviRecord.l()) || commonAddress.h() != naviRecord.i() || commonAddress.i() != naviRecord.j()) && (commonAddress2 == null || !L0(commonAddress2.j(), naviRecord.l()) || commonAddress2.h() != naviRecord.i() || commonAddress2.i() != naviRecord.j())) {
                arrayList2.add(new PoiResult(naviRecord.l(), z(naviRecord.i(), naviRecord.j()), naviRecord.c(), naviRecord.i(), naviRecord.j(), "custom_" + i2));
                i2++;
                if (arrayList2.size() == 6) {
                    break;
                }
            }
        }
        arrayList.addAll(arrayList2);
        return arrayList;
    }

    public static boolean I0(Context context, Record record) {
        List g2 = NaviOperatorManager.getInstance(context.getApplicationContext()).getNaviDatabase().f().g(t());
        for (int i2 = 0; i2 < g2.size(); i2++) {
            Record record2 = (Record) g2.get(i2);
            if (record.getName().equals(record2.getName()) && record.j() == -2 && record.j() == record2.j()) {
                CLog.b(f5809a, "isSearchExist record is searched! itemBean[" + i2 + "]=" + record2.toString());
                return true;
            }
        }
        CLog.b(f5809a, "isSearchExist is not Search record");
        return false;
    }

    public static String J() {
        if (TextUtils.isEmpty(t())) {
            return "home";
        }
        return "home_" + t();
    }

    public static boolean J0() {
        return l;
    }

    public static int K(int i2) {
        return i2 == 0 ? NaviControlManager.k().u(-1) : NaviControlManager.k().t(-1);
    }

    public static boolean K0(Context context, SearchModel searchModel) {
        if (searchModel == null) {
            return false;
        }
        List d2 = NaviOperatorManager.getInstance(context.getApplicationContext()).getNaviDatabase().d().d(t());
        for (int i2 = 0; i2 < d2.size(); i2++) {
            CommonAddress commonAddress = (CommonAddress) d2.get(i2);
            if (searchModel.getName().equals(commonAddress.j()) && searchModel.getLatitude() == commonAddress.h() && searchModel.getLongitude() == commonAddress.i()) {
                return true;
            }
        }
        return false;
    }

    public static String L(Context context, int i2) {
        String l2 = CSharedPreferences.l(context, "navi_glass_locale_country", "");
        String l3 = CSharedPreferences.l(context, "navi_glass_locale_language", "");
        String str = f5809a;
        CLog.b(str, "getLocale ######### language=" + n + " country=" + l2 + " language=" + l3);
        if (TextUtils.isEmpty(l2) || TextUtils.isEmpty(l3)) {
            return context.getApplicationContext().getString(i2);
        }
        if (n == null) {
            n = new String[]{l2, l3};
        }
        String[] strArr = n;
        Locale locale = new Locale(strArr[1], strArr[0]);
        Configuration configuration = new Configuration(context.getResources().getConfiguration());
        configuration.setLocale(locale);
        String string = context.createConfigurationContext(configuration).getResources().getString(i2);
        CLog.b(str, "getLocale ######### langValue=" + string + " language=" + n[1] + " country=" + n[0]);
        return string;
    }

    public static boolean L0(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.equals(str2);
    }

    public static CommonAddress M(Context context, SearchModel searchModel) {
        String str = f5809a;
        CLog.b(str, "getMachAddress Enter!");
        CommonAddress commonAddress = null;
        if (searchModel == null) {
            CLog.b(str, "getMachAddress data is null!");
            return null;
        }
        CLog.b(str, "getMachAddress data=" + searchModel.toString());
        List d2 = NaviOperatorManager.getInstance(context.getApplicationContext()).getNaviDatabase().d().d(t());
        for (int i2 = 0; i2 < d2.size(); i2++) {
            CommonAddress commonAddress2 = (CommonAddress) d2.get(i2);
            if (searchModel.getName().equals(commonAddress2.j()) && searchModel.getLatitude() == commonAddress2.h() && searchModel.getLongitude() == commonAddress2.i()) {
                commonAddress = commonAddress2;
            }
        }
        if (commonAddress != null) {
            String str2 = f5809a;
            CLog.b(str2, "isAddressExist record is searched! machAddress=" + commonAddress.toString());
        }
        return commonAddress;
    }

    public static /* synthetic */ void M0(boolean z, ICheckPermission iCheckPermission, Context context, View view) {
        if (z) {
            if (iCheckPermission != null) {
                iCheckPermission.a();
            }
            h(context);
        }
    }

    public static SearchModel N(NaviAbnormalRecod naviAbnormalRecod) {
        SearchModel searchModel = new SearchModel();
        searchModel.setName(naviAbnormalRecod.getName());
        searchModel.setAcode(naviAbnormalRecod.getAcode());
        searchModel.setCity(naviAbnormalRecod.getCity());
        searchModel.setAddress(naviAbnormalRecod.getAddress());
        searchModel.setDistrict("");
        searchModel.setDistance(naviAbnormalRecod.getDistance());
        searchModel.setLatitude(naviAbnormalRecod.getLatitude());
        searchModel.setLongitude(naviAbnormalRecod.getLongitude());
        searchModel.setAlias(naviAbnormalRecod.getAlias());
        searchModel.setNaviMode(naviAbnormalRecod.getNaviMode());
        return searchModel;
    }

    public static /* synthetic */ void N0(CustomDialog customDialog, View.OnClickListener onClickListener, View view) {
        customDialog.dismiss();
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }

    public static String O() {
        return TextUtils.isEmpty(s) ? CSharedPreferences.i(NaviOperatorManager.getContext()) : s;
    }

    public static /* synthetic */ void O0(CustomDialog customDialog, View.OnClickListener onClickListener, View view) {
        customDialog.dismiss();
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }

    public static NaviHomeBean P() {
        return t;
    }

    public static boolean P0(Context context, SearchModel searchModel, String str) {
        for (CommonAddress commonAddress : NaviOperatorManager.getInstance(context.getApplicationContext()).getNaviDatabase().d().d(t())) {
            if (!commonAddress.d().equals(str) && (TextUtils.isEmpty(commonAddress.d()) || TextUtils.isEmpty(str) || !commonAddress.d().contains(SchedulerSupport.CUSTOM) || !str.contains(SchedulerSupport.CUSTOM))) {
                if (J().equals(commonAddress.d()) && searchModel.getName().equals(commonAddress.j()) && commonAddress.c().equals(searchModel.getAddress())) {
                    CLog.c(f5809a, "ALIAS_HOME is equal");
                    return true;
                } else if (w().equals(commonAddress.d()) && searchModel.getName().equals(commonAddress.j()) && commonAddress.c().equals(searchModel.getAddress())) {
                    CLog.c(f5809a, "ALIAS_COMPANY is equal");
                    return true;
                } else if (!TextUtils.isEmpty(commonAddress.d()) && commonAddress.d().contains(SchedulerSupport.CUSTOM) && searchModel.getName().equals(commonAddress.j()) && commonAddress.c().equals(searchModel.getAddress())) {
                    return true;
                }
            }
        }
        return false;
    }

    public static int Q(ULatLng uLatLng) {
        ULocation g2 = LocationManager.f().g();
        int round = g2 != null ? Math.round(e(new ULatLng(g2.getLatitude(), g2.getLongitude()), new ULatLng(uLatLng.latitude, uLatLng.longitude))) : -1;
        String str = f5809a;
        CLog.b(str, " getNaviModeByDistance distance=" + round);
        if (round < 1000) {
            CLog.b(str, " getNaviModeByDistance NAV_MODE_WALK");
            return 2;
        } else if (round < 3000) {
            CLog.b(str, " getNaviModeByDistance NAV_MODE_RIDE");
            return 1;
        } else {
            CLog.b(str, " getNaviModeByDistance NAV_MODE_DRIVE");
            return 0;
        }
    }

    public static boolean Q0(Context context) {
        return context.getApplicationInfo().targetSdkVersion > 28;
    }

    public static int R(Context context, SearchModel searchModel) {
        if (searchModel == null) {
            return D(CSharedPreferences.f(context.getApplicationContext(), "navi_mode_other", 0));
        }
        boolean q0 = q0(context.getApplicationContext(), searchModel);
        String str = f5809a;
        CLog.b(str, "getNaviModeFromAddress  isHomeOrCompanyAddress=" + q0);
        return q0 ? a0(context, searchModel) : U(context.getApplicationContext(), new ULatLng(searchModel.getLatitude(), searchModel.getLongitude()));
    }

    public static boolean R0(Set set) {
        Iterator it = set.iterator();
        boolean z = true;
        while (it.hasNext()) {
            String str = (String) it.next();
            if (!str.startsWith("050") && !str.startsWith("07") && !str.startsWith("180") && !str.startsWith("200") && !str.startsWith("15") && !str.startsWith("160") && !str.startsWith("01")) {
                z = false;
            }
        }
        return z;
    }

    public static int S(int i2, int i3) {
        String str = f5809a;
        CLog.b(str, " getNaviModeFromDistance distance=" + i2 + " naviMode=" + i3);
        return !BuildConfig.c.booleanValue() ? D(i3) : i3 == 2 ? i2 <= 100000 ? 2 : 0 : (i3 != 1 || i2 > 500000) ? 0 : 1;
    }

    public static boolean S0(Context context) {
        return p(context).size() > 0;
    }

    public static NaviRecord T(SearchModel searchModel) {
        NaviRecord naviRecord = new NaviRecord();
        naviRecord.y(searchModel.getName());
        naviRecord.p(searchModel.getAddress());
        naviRecord.o(searchModel.getAcode());
        naviRecord.r(searchModel.getCity());
        naviRecord.v(searchModel.getLatitude());
        naviRecord.w(searchModel.getLongitude());
        naviRecord.t(searchModel.getDistance());
        naviRecord.q(searchModel.getAlias());
        naviRecord.x(searchModel.getNaviMode());
        return naviRecord;
    }

    public static void T0(Context context) {
        CSharedPreferences.u(context.getApplicationContext(), "navi_abnormal_exit_time", 0);
        CSharedPreferences.y(context.getApplicationContext(), "navi_abnormal_exit_record", "");
        CSharedPreferences.t(context.getApplicationContext(), "navi_abnormal_exit_mode", 0);
    }

    public static int U(Context context, ULatLng uLatLng) {
        ULocation g2 = LocationManager.f().g();
        int round = g2 != null ? Math.round(e(new ULatLng(g2.getLatitude(), g2.getLongitude()), new ULatLng(uLatLng.latitude, uLatLng.longitude))) : -1;
        int f2 = CSharedPreferences.f(context.getApplicationContext(), "navi_mode_other", 0);
        String str = f5809a;
        CLog.b(str, " getOtherNaviMode distance=" + round + " naviMode=" + f2);
        return !BuildConfig.c.booleanValue() ? D(f2) : f2 == 2 ? round <= 100000 ? 2 : 0 : (f2 != 1 || round > 500000) ? 0 : 1;
    }

    public static void U0(Context context) {
        CSharedPreferences.u(context.getApplicationContext(), "navi_disconnect_time", 0);
        CSharedPreferences.y(context.getApplicationContext(), "navi_disconnect_task", "");
    }

    public static String V(Set set) {
        StringBuilder sb = new StringBuilder();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            sb.append((String) it.next());
            sb.append(MzContactsContract.MzGroups.GROUP_SPLIT_MARK_XML);
        }
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 1);
        }
        return sb.toString();
    }

    public static void V0() {
        d1(false);
        q1(false);
    }

    public static NaviInfoBean W() {
        return u;
    }

    public static void W0(Context context, NaviAbnormalRecod naviAbnormalRecod) {
        String str = f5809a;
        CLog.b(str, "restoreNavi Enter data=" + naviAbnormalRecod.toString());
        NaviOperatorManager.getInstance(context).startNavigation(context, N(naviAbnormalRecod), 0);
    }

    public static int X(Context context, SearchModel searchModel) {
        String str = f5809a;
        CLog.b(str, "getRealNaviMode Enter!");
        if (searchModel == null) {
            return D(CSharedPreferences.f(context.getApplicationContext(), "navi_mode_other", 0));
        }
        int naviMode = searchModel.getNaviMode();
        CLog.b(str, "getRealNaviMode ###### from SearchModel! navMode=" + naviMode);
        if (naviMode == -1 || naviMode == 3) {
            naviMode = R(context, searchModel);
        }
        CLog.b(str, "getRealNaviMode  &&&&&&&&&&& complated! navMode=" + naviMode);
        return D(naviMode);
    }

    public static void X0(Context context, SearchModel searchModel, int i2) {
        String f2 = ProtocolUtils.f(searchModel);
        CSharedPreferences.u(context.getApplicationContext(), "navi_abnormal_exit_time", System.currentTimeMillis());
        CSharedPreferences.y(context.getApplicationContext(), "navi_abnormal_exit_record", f2);
        CSharedPreferences.t(context.getApplicationContext(), "navi_abnormal_exit_mode", i2);
    }

    public static int Y(Context context, SearchModel searchModel, int i2) {
        String str = f5809a;
        CLog.b(str, "getRealNaviMode  enter! &&&&&& mode=" + i2);
        if (searchModel == null) {
            return D(CSharedPreferences.f(context.getApplicationContext(), "navi_mode_other", 0));
        }
        if (i2 == -1 || i2 == 3) {
            i2 = R(context, searchModel);
        }
        CLog.b(str, "updateRealNaviMode  end! &&&&&&&&& navMode=" + i2);
        return D(i2);
    }

    public static void Y0(Context context, SearchModel searchModel) {
        if (searchModel != null) {
            CSharedPreferences.y(context.getApplicationContext(), "navi_disconnect_task", ProtocolUtils.f(searchModel));
            return;
        }
        CLog.b(f5809a, "saveDisConnectNaviTask searchModel object is null.");
    }

    public static Record Z(String str) {
        Record record = new Record();
        record.E(str);
        record.t(str);
        ULocation g2 = LocationManager.f().g();
        record.v(g2 != null ? g2.getCity() : "");
        record.s("");
        record.z("");
        record.B(DateUtils.a());
        record.y(-2);
        record.D(0.0d);
        record.C(0.0d);
        String str2 = f5809a;
        CLog.b(str2, " getSeachRecord() bean=" + record.toString());
        return record;
    }

    public static void Z0(Context context, NaviExitType naviExitType) {
        if (naviExitType == NaviExitType.PHONE_ABNORMAL_EXIT || naviExitType == NaviExitType.GLASS_ABNORMAL_EXIT) {
            StarryNetManger.getInstance().sendMessage(NotifyUtils.d(L(context, R.string.navi_abnormal_exit)), "com.upuphone.star.launcher", (SendMessageListener) null);
            D1(context);
        }
    }

    public static int a0(Context context, SearchModel searchModel) {
        int j2 = CSharedPreferences.j(context.getApplicationContext());
        String str = f5809a;
        CLog.b(str, "getSmartNaviMode mode=" + j2);
        if (j2 == 3) {
            j2 = Q(new ULatLng(searchModel.getLatitude(), searchModel.getLongitude()));
        }
        return D(j2);
    }

    public static void a1() {
        String a2 = ProtocolUtils.a("navi_foreground", "");
        String str = f5809a;
        CLog.b(str, "sendNaviForegroundMsg  data:" + a2);
        StarryNetManger.getInstance().sendMessage(a2, (SendMessageListener) null);
    }

    public static WeatherBean b0() {
        return k;
    }

    public static void b1(Context context, boolean z) {
        String str = f5809a;
        CLog.b(str, "sendNaviNightTips   showNightTips=" + J0() + " isNaving=" + u0() + " startedNavi=" + z);
        if (u0() && J0() && z && !o0()) {
            StarryNetManger.getInstance().sendMessage(ProtocolUtils.a("navi_night_tips", "1"), (SendMessageListener) null);
            UToast.e(context.getApplicationContext(), R.string.navi_night_toast, 0);
            t1(false);
        }
    }

    public static String c0(Context context, int i2) {
        Locale locale = new Locale("zh", Constants.CHINA_COUNTRY);
        Configuration configuration = new Configuration(context.getResources().getConfiguration());
        configuration.setLocale(locale);
        String string = context.createConfigurationContext(configuration).getResources().getString(i2);
        String str = f5809a;
        CLog.b(str, "getZhLocale ######### langValue=" + string);
        return string;
    }

    public static void c1(String str) {
        r = str;
        Context context = NaviOperatorManager.getContext();
        if (context != null) {
            CSharedPreferences.n(context, str);
            return;
        }
        String str2 = f5809a;
        CLog.b(str2, "setAccountId  ######## context object is null. accountId is:" + str);
    }

    public static boolean d0(Context context) {
        String l2 = CSharedPreferences.l(context.getApplicationContext(), "navi_abnormal_exit_record", "");
        long g2 = CSharedPreferences.g(context.getApplicationContext(), "navi_abnormal_exit_time", 0);
        String str = f5809a;
        CLog.b(str, "checkAbnormalExitRecode Enter naviRecord=" + l2 + " lastTime=" + g2);
        if (TextUtils.isEmpty(l2) || g2 == 0) {
            CLog.b(str, "checkAbnormalExitRecode has no save abnormal exit recod.");
            return false;
        } else if (System.currentTimeMillis() - g2 <= 600000) {
            return true;
        } else {
            CLog.b(str, "checkAbnormalExitRecode dyTime greater than 10 minutes.");
            T0(context);
            return false;
        }
    }

    public static void d1(boolean z) {
        j = z;
    }

    public static float e(ULatLng uLatLng, ULatLng uLatLng2) {
        return PoiSearchManager.f().a(uLatLng, uLatLng2);
    }

    public static boolean e0(Context context) {
        if (!TextUtils.isEmpty(CSharedPreferences.l(context.getApplicationContext(), "navi_disconnect_task", ""))) {
            return true;
        }
        CLog.b(f5809a, "hasDisConnectNaviTask has no save disConnect navi task.");
        return false;
    }

    public static void e1(boolean z) {
        m = z;
    }

    public static void f(Context context, NaviExitType naviExitType) {
        if (naviExitType != NaviExitType.PHONE_ABNORMAL_EXIT && naviExitType != NaviExitType.GLASS_ABNORMAL_EXIT) {
            T0(context);
        }
    }

    public static NaviRecord f0(List list, NaviRecord naviRecord) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            NaviRecord naviRecord2 = (NaviRecord) it.next();
            if (!TextUtils.isEmpty(naviRecord.l()) && naviRecord.l().equals(naviRecord2.l()) && C0(new ULatLng(naviRecord.i(), naviRecord.j()), new ULatLng(naviRecord2.i(), naviRecord2.j()))) {
                return naviRecord2;
            }
        }
        return null;
    }

    public static void f1(boolean z) {
        q = z;
    }

    public static int g(Context context, String str) {
        try {
            return ((Integer) context.getClass().getMethod("checkSelfPermission", new Class[]{String.class}).invoke(context, new Object[]{str})).intValue();
        } catch (NoSuchMethodException e2) {
            e2.printStackTrace();
            return -1;
        } catch (SecurityException e3) {
            e3.printStackTrace();
            return -1;
        } catch (IllegalAccessException e4) {
            e4.printStackTrace();
            return -1;
        } catch (InvocationTargetException e5) {
            e5.printStackTrace();
            return -1;
        }
    }

    public static void g0(Context context, boolean z, ICheckPermission iCheckPermission) {
        if (context instanceof Activity) {
            if (!s0() && z) {
                h(context);
                if (iCheckPermission != null) {
                    iCheckPermission.a();
                }
            } else if (s0()) {
                x1(context, (View.OnClickListener) null, new d(z, iCheckPermission, context));
            }
        }
    }

    public static void g1(boolean z) {
        f = z;
    }

    public static void h(Context context) {
        List p2 = p(context);
        if (context.getApplicationInfo().targetSdkVersion >= 23 && !p2.isEmpty()) {
            try {
                context.getClass().getMethod("requestPermissions", new Class[]{String[].class, Integer.TYPE}).invoke(context, new Object[]{p2.toArray(new String[p2.size()]), 508});
            } catch (NoSuchMethodException e2) {
                e2.printStackTrace();
            } catch (SecurityException e3) {
                e3.printStackTrace();
            } catch (IllegalAccessException e4) {
                e4.printStackTrace();
            } catch (InvocationTargetException e5) {
                e5.printStackTrace();
            }
        }
    }

    public static void h0(Context context, SearchModel searchModel) {
        if (TextUtils.isEmpty(searchModel.getCity()) || TextUtils.isEmpty(searchModel.getDistrict())) {
            F1(context, searchModel);
        } else {
            i0(context, searchModel);
        }
    }

    public static void h1(boolean z) {
        g = z;
    }

    public static void i(Context context) {
        NaviOperatorManager.getInstance(context.getApplicationContext()).getNaviDatabase().e().i(t());
        E1(context);
    }

    public static void i0(Context context, SearchModel searchModel) {
        Record x = x(searchModel);
        String str = f5809a;
        CLog.b(str, "insertHistoryToDao recordBean= " + x.toString());
        NaviDatabase naviDatabase = NaviOperatorManager.getInstance(context.getApplicationContext()).getNaviDatabase();
        if (G0(context, searchModel)) {
            naviDatabase.f().b(x);
        }
        naviDatabase.f().e(x);
    }

    public static void i1(boolean z) {
        i = z;
    }

    public static SearchModel j(SearchModel searchModel) {
        SearchModel searchModel2 = new SearchModel();
        searchModel2.setName(searchModel.getName());
        searchModel2.setAcode(searchModel.getAcode());
        searchModel2.setAddress(searchModel.getAddress());
        searchModel2.setDistrict(searchModel.getDistrict());
        searchModel2.setCity(searchModel.getCity());
        searchModel2.setKeywords(searchModel.getKeywords());
        searchModel2.setDistance(searchModel.getDistance());
        searchModel2.setLatitude(searchModel.getLatitude());
        searchModel2.setLongitude(searchModel.getLongitude());
        searchModel2.setType(searchModel.getType());
        searchModel2.setAlias(searchModel.getAlias());
        return searchModel2;
    }

    public static void j0(Context context, SearchModel searchModel) {
        String str = f5809a;
        CLog.b(str, "insertNaviRecord **************** searchModel=" + searchModel.toString());
        NaviRecord T = T(searchModel);
        NaviDatabase naviDatabase = NaviOperatorManager.getInstance(context.getApplicationContext()).getNaviDatabase();
        if (naviDatabase == null) {
            CLog.b(str, "insertNaviRecord **************** naviDatabase is null!");
            return;
        }
        NaviRecord f0 = f0(naviDatabase.e().b(t()), T);
        if (f0 != null) {
            CLog.b(str, "insertNaviRecord @@@@@@@@@@@@@@@ matchRecord.toString()=" + f0.toString());
            f0.s(f0.f() + 1);
            f0.z(System.currentTimeMillis());
            naviDatabase.e().f(f0);
            return;
        }
        CLog.b(str, "insertNaviRecord ############## is not null");
        T.s(1);
        T.z(System.currentTimeMillis());
        naviDatabase.e().j(T);
    }

    public static void j1(String[] strArr) {
        n = strArr;
    }

    public static String k(Context context) {
        List<FreqAddress> H = H(context.getApplicationContext());
        for (FreqAddress freqAddress : H) {
            String str = f5809a;
            CLog.b(str, "createFreqAddresData() naviRecord= getName=" + freqAddress.f() + " getAddress=" + freqAddress.a() + " getLongitude=" + freqAddress.e() + " getLatitude=" + freqAddress.d() + " getPoiId=" + freqAddress.g() + " getDistance=" + freqAddress.c());
        }
        String c2 = ProtocolUtils.c(H);
        d1(false);
        String str2 = f5809a;
        CLog.b(str2, "****************** data.length()=" + c2.length());
        return c2;
    }

    public static void k0(Context context, String str) {
        NaviDatabase naviDatabase = NaviOperatorManager.getInstance(context.getApplicationContext()).getNaviDatabase();
        Record Z = Z(str);
        if (I0(context, Z)) {
            CLog.b(f5809a, "insertSearchRecord ########");
            naviDatabase.f().b(Z);
            naviDatabase.f().e(Z);
            return;
        }
        CLog.b(f5809a, "insertSearchRecord @@@@@@@@");
        naviDatabase.f().e(Z);
    }

    public static void k1(Context context, SearchModel searchModel, int i2, boolean z) {
        boolean q0 = searchModel != null ? q0(context.getApplicationContext(), searchModel) : false;
        int naviMode = searchModel != null ? searchModel.getNaviMode() : i2;
        String str = f5809a;
        StringBuilder sb = new StringBuilder();
        sb.append("setLatestNaviMode  travelMode=");
        sb.append(i2);
        sb.append(" isHomeOrCompanyAddress=");
        sb.append(q0);
        sb.append(" switchNaviMode=");
        sb.append(z);
        sb.append(" origainMode=");
        sb.append(naviMode);
        sb.append("  curSearchModel=");
        sb.append(searchModel != null ? searchModel.toString() : "MULL");
        CLog.b(str, sb.toString());
        if (q0) {
            return;
        }
        if (naviMode != -1 || z) {
            CSharedPreferences.t(context.getApplicationContext(), "navi_mode_other", i2);
        }
    }

    public static void l(Context context, SearchModel searchModel) {
        NaviRecord T = T(searchModel);
        NaviDatabase naviDatabase = NaviOperatorManager.getInstance(context.getApplicationContext()).getNaviDatabase();
        List a2 = naviDatabase.e().a(t(), T.l(), T.i(), T.j());
        String str = f5809a;
        CLog.b(str, "deleteNaviRecord *************** existlist.size()=" + a2.size());
        if (a2.size() > 0) {
            naviDatabase.e().e((NaviRecord) a2.get(0));
            E1(context);
        }
    }

    public static boolean l0() {
        return m;
    }

    public static void l1(boolean z) {
        e = z;
    }

    public static void m() {
        String b2 = NotifyUtils.b("reconnection_navi");
        String str = f5809a;
        CLog.b(str, "dismissionRestoreNaviDialog reqMsg is:" + b2 + " length is:" + b2.length());
        StarryNetManger.getInstance().sendMessage(b2, "com.upuphone.star.launcher", (SendMessageListener) null);
        p1(false);
    }

    public static boolean m0(Context context) {
        List i2 = NaviOperatorManager.getInstance(context.getApplicationContext()).getNaviDatabase().d().i(t());
        String str = f5809a;
        CLog.a(str, "AddressActivity list.size(): " + i2.size());
        return i2.size() >= 12;
    }

    public static void m1(Context context, String str) {
        if (!s.equals(str)) {
            CSharedPreferences.w(context, str);
        }
        s = str;
    }

    public static void n() {
        String b2 = NotifyUtils.b("restore_navi");
        String str = f5809a;
        CLog.b(str, "dismissionRestoreNaviDialog reqMsg is:" + b2 + " length is:" + b2.length());
        StarryNetManger.getInstance().sendMessage(b2, "com.upuphone.star.launcher", (SendMessageListener) null);
        p1(false);
    }

    public static boolean n0(String str) {
        return !TextUtils.isEmpty(str) && str.contains(SchedulerSupport.CUSTOM);
    }

    public static void n1(boolean z) {
        o = z;
    }

    public static List o(Context context) {
        ArrayList arrayList = new ArrayList();
        if (context.getApplicationInfo().targetSdkVersion >= 28) {
            for (String str : c) {
                if (g(context, str) != 0) {
                    CLog.b(f5809a, "findBackgroundPermissions @@@@@@@@@@ perm " + str);
                    arrayList.add(str);
                }
            }
        }
        return arrayList;
    }

    public static boolean o0() {
        return b0() != null ? DateUtils.b(y(b0().getSunriseTime()), y(b0().getSunsetTime())) : DateUtils.b("05:30:00", "19:30:00");
    }

    public static void o1(NaviHomeBean naviHomeBean) {
        t = naviHomeBean;
    }

    public static List p(Context context) {
        ArrayList arrayList = new ArrayList();
        if (context.getApplicationInfo().targetSdkVersion >= 23) {
            for (String str : b) {
                if (g(context, str) != 0 && (Q0(context) || !"android.permission.ACCESS_BACKGROUND_LOCATION".equals(str))) {
                    arrayList.add(str);
                }
            }
        }
        return arrayList;
    }

    public static boolean p0() {
        return q;
    }

    public static void p1(boolean z) {
        p = z;
    }

    public static String[] q(Context context, int i2) {
        String str;
        DecimalFormat decimalFormat = new DecimalFormat("#.#");
        decimalFormat.setRoundingMode(RoundingMode.DOWN);
        String[] strArr = new String[2];
        String str2 = "";
        if (i2 <= 10) {
            if (i2 <= 1) {
                str = "1";
            } else {
                str = i2 + str2;
            }
            if (!s0()) {
                str = context.getString(R.string.now);
            }
            strArr[0] = str;
            if (s0()) {
                str2 = context.getString(R.string.metre);
            }
            strArr[1] = str2;
        } else if (i2 < 1000) {
            strArr[0] = i2 + str2;
            strArr[1] = context.getString(R.string.metre);
        } else if (1000 <= i2 && i2 < 10000) {
            strArr[0] = decimalFormat.format(((((double) i2) / 10.0d) * 10.0d) / 1000.0d) + str2;
            strArr[1] = context.getString(R.string.kilometre);
        } else if (10000 > i2 || i2 >= 100000) {
            strArr[0] = decimalFormat.format(((double) i2) / 1000.0d) + str2;
            strArr[1] = context.getString(R.string.kilometre);
        } else {
            strArr[0] = decimalFormat.format(((((double) i2) / 100.0d) * 100.0d) / 1000.0d) + str2;
            strArr[1] = context.getString(R.string.kilometre);
        }
        return strArr;
    }

    public static boolean q0(Context context, SearchModel searchModel) {
        if (searchModel == null) {
            return false;
        }
        List d2 = NaviOperatorManager.getInstance(context.getApplicationContext()).getNaviDatabase().d().d(t());
        String str = f5809a;
        CLog.b(str, "isHomeOrCompanyAddress  model=" + searchModel.toString() + " addressList.size()=" + d2.size());
        for (int i2 = 0; i2 < d2.size(); i2++) {
            CommonAddress commonAddress = (CommonAddress) d2.get(i2);
            if (commonAddress.d().equals(J()) || commonAddress.d().equals(w())) {
                String str2 = f5809a;
                CLog.b(str2, "isHomeOrCompanyAddress  ######### address=" + commonAddress.toString());
                if (searchModel.getName().equals(commonAddress.j()) && searchModel.getLatitude() == commonAddress.h() && searchModel.getLongitude() == commonAddress.i()) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void q1(boolean z) {
        h = z;
    }

    public static String r(Context context, int i2) {
        DecimalFormat decimalFormat = new DecimalFormat("#.#");
        decimalFormat.setRoundingMode(RoundingMode.DOWN);
        if (i2 <= 10) {
            return context.getString(R.string.now);
        }
        if (i2 < 1000) {
            return i2 + context.getString(R.string.metre);
        } else if (1000 <= i2 && i2 < 10000) {
            return decimalFormat.format(((((double) i2) / 10.0d) * 10.0d) / 1000.0d) + context.getString(R.string.kilometre);
        } else if (10000 > i2 || i2 >= 100000) {
            return decimalFormat.format(((double) i2) / 1000.0d) + context.getString(R.string.kilometre);
        } else {
            return decimalFormat.format(((((double) i2) / 100.0d) * 100.0d) / 1000.0d) + context.getString(R.string.kilometre);
        }
    }

    public static boolean r0(int i2) {
        return BuildConfig.b.booleanValue() ? i2 >= 0 : i2 > 0;
    }

    public static void r1(NaviInfoBean naviInfoBean) {
        u = naviInfoBean;
    }

    public static String s(Context context, int i2) {
        int i3;
        int i4;
        int i5 = i2 % 3600;
        int i6 = 0;
        if (i2 >= 3600) {
            int i7 = i2 / 3600;
            if (i5 != 0) {
                i6 = i7;
                i3 = i5 % 60;
                i4 = i5 / 60;
            } else {
                i4 = 0;
                i6 = i7;
                i3 = 0;
            }
        } else {
            i4 = i2 / 60;
            i3 = i2 % 60;
        }
        int u2 = u(i6, i4, i3);
        if (u2 >= 60) {
            i6++;
            u2 %= 60;
        }
        if (i6 > 0) {
            return i6 + context.getString(R.string.hour) + u2 + context.getString(R.string.minute);
        } else if (u2 <= 0) {
            return context.getString(R.string.less_than) + "1" + context.getString(R.string.minute);
        } else {
            return u2 + context.getString(R.string.minute);
        }
    }

    public static boolean s0() {
        return BuildConfig.b.booleanValue();
    }

    public static void s1(boolean z) {
        d = z;
    }

    public static String t() {
        if (!TextUtils.isEmpty(r)) {
            return r;
        }
        Context context = NaviOperatorManager.getContext();
        if (context != null) {
            r = CSharedPreferences.a(context);
            String str = f5809a;
            CLog.b(str, "getAccountId  ****************** accountId=" + r);
        }
        if (TextUtils.isEmpty(r)) {
            CLog.b(f5809a, "getAccountId  ######## curent accountId is empty.");
        }
        return r;
    }

    public static boolean t0() {
        return f;
    }

    public static void t1(boolean z) {
        l = z;
    }

    public static int u(int i2, int i3, int i4) {
        String str = f5809a;
        CLog.b(str, " getAdjustSecond= h=" + i2 + " d=" + i3 + " s=" + i4);
        if (i2 < 1) {
            if (i3 <= 0) {
                return 0;
            }
            if (i4 <= 0) {
                return i3;
            }
        } else if (i4 <= 0) {
            return i3;
        }
        return i3 + 1;
    }

    public static boolean u0() {
        return g;
    }

    public static boolean u1(Context context, boolean z, String str) {
        C1(context, str, !CSharedPreferences.b(context, str, z));
        return CSharedPreferences.b(context, str, z);
    }

    public static String v(Context context, SearchModel searchModel) {
        if (searchModel == null || context == null) {
            CLog.b(f5809a, "getAliasFromModel **************** searchModel objecet is null!");
            return "";
        }
        for (CommonAddress commonAddress : NaviOperatorManager.getInstance(context.getApplicationContext()).getNaviDatabase().d().d(t())) {
            if (searchModel.getName().equals(commonAddress.j()) && commonAddress.h() == searchModel.getLatitude() && commonAddress.i() == searchModel.getLongitude() && searchModel.getAddress().equals(commonAddress.c())) {
                return commonAddress.d();
            }
        }
        return "";
    }

    public static boolean v0() {
        return i;
    }

    public static void v1(WeatherBean weatherBean) {
        k = weatherBean;
    }

    public static String w() {
        if (TextUtils.isEmpty(t())) {
            return "company";
        }
        return "company_" + t();
    }

    public static boolean w0(Context context, SearchModel searchModel) {
        if (searchModel == null) {
            return false;
        }
        List<NaviRecord> g2 = NaviOperatorManager.getInstance(context.getApplicationContext()).getNaviDatabase().e().g(t());
        String str = f5809a;
        CLog.b(str, "isLatestNaviRecordAddress **************** recordList=" + g2.size());
        for (NaviRecord naviRecord : g2) {
            if (naviRecord.l().equals(searchModel.getName()) && naviRecord.i() == searchModel.getLatitude() && naviRecord.j() == searchModel.getLongitude()) {
                return true;
            }
        }
        return false;
    }

    public static void w1(Context context, String str, String str2) {
        String a2 = NotifyUtils.a(context.getApplicationContext(), String.format(L(context, R.string.restore_navi_desp), new Object[]{str2}), str);
        String str3 = f5809a;
        CLog.b(str3, "showRestoreNaviDialog reqMsg is:" + a2 + " length is:" + a2.length());
        StarryNetManger.getInstance().sendMessage(a2, "com.upuphone.star.launcher", NotifyUtils.e(context.getApplicationContext(), R.drawable.navi_glass_icon), (SendMessageListener) null);
    }

    public static Record x(SearchModel searchModel) {
        Record record = new Record();
        record.E(searchModel.getName());
        record.t(searchModel.getAddress());
        record.v(searchModel.getCity());
        record.s(searchModel.getAcode());
        record.z(searchModel.getDistrict());
        record.B(DateUtils.a());
        record.y(searchModel.getDistance());
        record.D(searchModel.getLongitude());
        record.C(searchModel.getLatitude());
        record.u(searchModel.getAlias());
        return record;
    }

    public static boolean x0(SearchModel searchModel) {
        if (searchModel == null) {
            CLog.b(f5809a, " isMatchAddress ###### searchModel is null.");
            return false;
        }
        PlaceBean j2 = LocationManager.f().j();
        if (j2 == null) {
            CLog.b(f5809a, " isMatchAddress ###### place is null.");
            return false;
        } else if (j2.getLatitude() == searchModel.getLatitude() && j2.getLongitude() == searchModel.getLongitude()) {
            CLog.b(f5809a, " isMatchAddress ######");
            return true;
        } else {
            int round = Math.round(e(new ULatLng(j2.getLatitude(), j2.getLongitude()), new ULatLng(searchModel.getLatitude(), searchModel.getLongitude())));
            String str = f5809a;
            CLog.b(str, " isMatchAddress distance=" + round + " uLocation=" + j2.toString() + "\n searchModel=" + searchModel.toString());
            return j2.getAddress().equals(searchModel.getAddress()) && round < 10;
        }
    }

    public static void x1(Context context, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("android.permission.ACCESS_COARSE_LOCATION");
        HashMap b2 = SdkContext.f6675a.f().b(context, (String[]) arrayList.toArray(new String[0]));
        CustomDialog customDialog = new CustomDialog(context);
        customDialog.c(false);
        customDialog.a(true);
        customDialog.setCancelable(false);
        customDialog.d(false);
        customDialog.j((String) b2.getOrDefault("rejectTitle", "")).i((String) b2.getOrDefault("content", "")).e(context.getString(R.string.navi_permission_refuse), new e(customDialog, onClickListener)).f(context.getString(R.string.navi_agree), new f(customDialog, onClickListener2)).show();
    }

    public static String y(String str) {
        try {
            return new SimpleDateFormat(FastRecordSearchViewAdapter.TIME_FORMAT).format(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(str));
        } catch (ParseException e2) {
            String str2 = f5809a;
            CLog.b(str2, "getSunriseTime exception=" + e2);
            return "";
        }
    }

    public static boolean y0(ULatLng uLatLng, ULatLng uLatLng2) {
        if (uLatLng == null || uLatLng2 == null) {
            CLog.b(f5809a, " isMatchLocation startPos or endPos is empty.");
            return false;
        }
        String str = f5809a;
        CLog.b(str, "isMatchLocation() ####### startPos=[" + uLatLng.latitude + MzContactsContract.MzGroups.GROUP_SPLIT_MARK_EXTRA + uLatLng.longitude + "] endPos=[" + uLatLng2.latitude + MzContactsContract.MzGroups.GROUP_SPLIT_MARK_EXTRA + uLatLng2.longitude + "]");
        return uLatLng.latitude == uLatLng2.latitude && uLatLng.longitude == uLatLng2.longitude;
    }

    public static void y1(Context context, String str) {
        NaviAbnormalRecod E = E(context);
        if (E != null) {
            w1(context, str, E.getName());
        }
    }

    public static int z(double d2, double d3) {
        ULocation g2 = LocationManager.f().g();
        if (g2 == null) {
            return -1;
        }
        ULatLng uLatLng = new ULatLng(g2.getLatitude(), g2.getLongitude());
        ULatLng uLatLng2 = new ULatLng(d2, d3);
        int round = Math.round(e(uLatLng, uLatLng2));
        String str = f5809a;
        CLog.b(str, " getDestDistance() start=" + uLatLng + " end=" + uLatLng2 + "distance=" + round);
        return round;
    }

    public static boolean z0() {
        return o;
    }

    public static void z1(Context context) {
        context.startService(new Intent(context, NaviDocerService.class));
    }
}
