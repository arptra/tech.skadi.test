package com.upuphone.ar.navi.lite.manger;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.View;
import androidx.room.Room;
import com.honey.account.h4.j;
import com.honey.account.h4.k;
import com.upuphone.ar.navi.lite.AddressActivity;
import com.upuphone.ar.navi.lite.AddressSettingActivity;
import com.upuphone.ar.navi.lite.NaviFragmentActivity;
import com.upuphone.ar.navi.lite.PermissionsActivity;
import com.upuphone.ar.navi.lite.R;
import com.upuphone.ar.navi.lite.SettingActivity;
import com.upuphone.ar.navi.lite.base.AccountInfoBean;
import com.upuphone.ar.navi.lite.base.CommonAddress;
import com.upuphone.ar.navi.lite.base.NaviRecord;
import com.upuphone.ar.navi.lite.base.PlaceBean;
import com.upuphone.ar.navi.lite.base.Record;
import com.upuphone.ar.navi.lite.base.SearchModel;
import com.upuphone.ar.navi.lite.dao.NaviDatabase;
import com.upuphone.ar.navi.lite.location.LocationManager;
import com.upuphone.ar.navi.lite.model.ILocation;
import com.upuphone.ar.navi.lite.model.INaviOperator;
import com.upuphone.ar.navi.lite.model.INaviState;
import com.upuphone.ar.navi.lite.model.INaviVoiceStateChanged;
import com.upuphone.ar.navi.lite.model.IPlaceInfo;
import com.upuphone.ar.navi.lite.navi.NaviControlManager;
import com.upuphone.ar.navi.lite.offlinemap.OfflineMapManager;
import com.upuphone.ar.navi.lite.protocol.NotifyUtils;
import com.upuphone.ar.navi.lite.search.PoiSearchManager;
import com.upuphone.ar.navi.lite.service.NaviService;
import com.upuphone.ar.navi.lite.util.CLog;
import com.upuphone.ar.navi.lite.util.CSharedPreferences;
import com.upuphone.ar.navi.lite.util.JsonUtil;
import com.upuphone.ar.navi.lite.util.LocationUtil;
import com.upuphone.ar.navi.lite.util.NaviUtil;
import com.upuphone.ar.navi.lite.util.RegionUtils;
import com.upuphone.ar.navi.lite.view.CustomDialog;
import com.upuphone.runasone.uupcast.CaptureType;
import com.upuphone.star.common.phone.UToast;
import com.upuphone.xr.interconnect.common.INaviActionResult;
import com.upuphone.xr.interconnect.common.INaviLocationCallback;
import com.upuphone.xr.interconnect.common.INaviPoiCallback;
import com.upuphone.xr.interconnect.entity.NaviLocationInfo;
import com.upuphone.xr.interconnect.entity.PoiResult;
import com.upuphone.xr.interconnect.listener.SendMessageListener;
import io.reactivex.rxjava3.annotations.SchedulerSupport;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class NaviOperatorManager {
    private static final String TAG = ("NAVI-" + NaviOperatorManager.class.getSimpleName());
    private static NaviOperatorManager instance;
    private static Context mContext;
    private INaviActionResult companyActionResult;
    private SearchModel companyModel = new SearchModel();
    private SearchModel customModel = new SearchModel();
    private int enterType = 0;
    private INaviActionResult homeActionResult;
    private SearchModel homeModel = new SearchModel();
    private ILocation locationListener;
    private NaviDatabase naviDatabase;
    private Map<String, INaviLocationCallback> naviLocationCallbacks = new ConcurrentHashMap();
    private INaviOperator naviOperator;
    private IPlaceInfo naviPlace;
    private INaviState naviStateListener;
    private INaviVoiceStateChanged naviVoiceStateChanged;
    private INaviActionResult poiActionResult;

    public NaviOperatorManager(Context context) {
        mContext = context.getApplicationContext();
    }

    private void companyAddress(Context context) {
        if (this.companyModel.getLatitude() == 0.0d && this.companyModel.getLongitude() == 0.0d) {
            setEnterType(2);
            Intent intent = new Intent(context, AddressSettingActivity.class);
            intent.setFlags(CaptureType.CAPTURE_VIRTUAL_DISPLAY_WHEN_SCREEN_LOCKED);
            intent.putExtra("MODEL", NaviUtil.w());
            intent.putExtra("name", "");
            context.startActivity(intent);
        } else if (NaviUtil.x0(this.companyModel)) {
            UToast.e(context.getApplicationContext(), R.string.near_location_info, 0);
        } else {
            startNavigationFromSuperApp(context, this.companyModel);
        }
    }

    public static Context getContext() {
        return mContext;
    }

    public static NaviOperatorManager getInstance(Context context) {
        if (instance == null) {
            instance = new NaviOperatorManager(context);
        }
        return instance;
    }

    private boolean hasCompanyAddress() {
        SearchModel companyModel2 = getCompanyModel();
        return (companyModel2.getLatitude() == 0.0d && companyModel2.getLongitude() == 0.0d) ? false : true;
    }

    private boolean hasHomeAddress() {
        SearchModel homeModel2 = getHomeModel();
        return (homeModel2.getLatitude() == 0.0d && homeModel2.getLongitude() == 0.0d) ? false : true;
    }

    private void homeAddress(Context context) {
        if (this.homeModel.getLatitude() == 0.0d && this.homeModel.getLongitude() == 0.0d) {
            setEnterType(2);
            Intent intent = new Intent(context, AddressSettingActivity.class);
            intent.setFlags(CaptureType.CAPTURE_VIRTUAL_DISPLAY_WHEN_SCREEN_LOCKED);
            intent.putExtra("MODEL", NaviUtil.J());
            intent.putExtra("name", "");
            context.startActivity(intent);
        } else if (NaviUtil.x0(this.homeModel)) {
            UToast.e(context.getApplicationContext(), R.string.near_location_info, 0);
        } else {
            startNavigationFromSuperApp(context, this.homeModel);
        }
    }

    private void initDatabase() {
        this.naviDatabase = (NaviDatabase) Room.a(mContext, NaviDatabase.class, "navi_lite.db").c().b(NaviDatabase.f5678a, NaviDatabase.b, NaviDatabase.c, NaviDatabase.d, NaviDatabase.e).d();
    }

    private void initNaviOperator() {
        setNaviOperator(new NaviOperator(this));
    }

    private void initPrivacyCompliance() {
        NaviControlManager.k().y(mContext);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$company$1(CustomDialog customDialog, Context context, View view) {
        customDialog.dismiss();
        companyAddress(context);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$home$0(CustomDialog customDialog, Context context, View view) {
        customDialog.dismiss();
        homeAddress(context);
    }

    private boolean matchOtherAddress(CommonAddress commonAddress) {
        for (CommonAddress commonAddress2 : this.naviDatabase.d().d(NaviUtil.t())) {
            String str = TAG;
            CLog.a(str, "matchOtherAddress: " + JsonUtil.a(commonAddress2));
            if (!commonAddress2.d().equals(commonAddress.d())) {
                if (NaviUtil.J().equals(commonAddress2.d()) && commonAddress.j().equals(commonAddress2.j())) {
                    return true;
                }
                if (NaviUtil.w().equals(commonAddress2.d()) && commonAddress.j().equals(commonAddress2.j())) {
                    return true;
                }
            }
        }
        return false;
    }

    private void migrationAddressData() {
        String t = NaviUtil.t();
        List g = this.naviDatabase.d().g();
        for (int i = 0; i < g.size(); i++) {
            CommonAddress commonAddress = (CommonAddress) g.get(i);
            if ("home".equals(commonAddress.d())) {
                this.naviDatabase.d().b(commonAddress);
                commonAddress.p(NaviUtil.J());
                commonAddress.m(t);
                this.naviDatabase.d().c(commonAddress);
            } else if ("company".equals(commonAddress.d())) {
                this.naviDatabase.d().b(commonAddress);
                commonAddress.p(NaviUtil.w());
                commonAddress.m(t);
                this.naviDatabase.d().c(commonAddress);
            } else {
                commonAddress.m(t);
                this.naviDatabase.d().e(commonAddress);
            }
        }
    }

    private void migrationDataBase() {
        String str = TAG;
        CLog.b(str, "migrationAddressData NaviUtil.getAccountId(): " + NaviUtil.t());
        migrationAddressData();
        migrationNaviRecordData();
        migrationRecordData();
    }

    private void migrationNaviRecordData() {
        List d = this.naviDatabase.e().d();
        for (int i = 0; i < d.size(); i++) {
            NaviRecord naviRecord = (NaviRecord) d.get(i);
            naviRecord.n(NaviUtil.t());
            this.naviDatabase.e().f(naviRecord);
        }
    }

    private void migrationPreferences() {
        CLog.b(TAG, "migrationPreferences Enter.");
        Context context = mContext;
        for (Map.Entry next : context.getSharedPreferences(context.getPackageName(), 0).getAll().entrySet()) {
            String str = (String) next.getKey();
            Object value = next.getValue();
            String str2 = TAG;
            CLog.b(str2, "migrationPreferences Key: " + str + " Value: " + value);
            if (!"navi_migrated".equals(str)) {
                if (value instanceof Integer) {
                    CSharedPreferences.t(mContext, str, ((Integer) value).intValue());
                } else if (value instanceof String) {
                    CSharedPreferences.y(mContext, str, String.valueOf(value));
                } else if (value instanceof Boolean) {
                    CSharedPreferences.o(mContext, str, ((Boolean) value).booleanValue());
                } else if (value instanceof Long) {
                    CSharedPreferences.u(mContext, str, ((Long) value).longValue());
                }
            }
        }
    }

    private void migrationRecordData() {
        List h = this.naviDatabase.f().h();
        for (int i = 0; i < h.size(); i++) {
            Record record = (Record) h.get(i);
            record.r(NaviUtil.t());
            this.naviDatabase.f().j(record);
        }
    }

    private void startNaviToCmpany(Context context, INaviActionResult iNaviActionResult) {
        this.companyActionResult = iNaviActionResult;
        SearchModel companyModel2 = getCompanyModel();
        companyModel2.setNaviMode(CSharedPreferences.j(context));
        if (companyModel2.getLatitude() == 0.0d || companyModel2.getLongitude() == 0.0d) {
            CLog.b(TAG, "startNaviToAddress()  There is no company address record.");
        } else {
            startNavigation(context, companyModel2, 2);
        }
    }

    private void startNaviToHome(Context context, INaviActionResult iNaviActionResult) {
        this.homeActionResult = iNaviActionResult;
        SearchModel homeModel2 = getHomeModel();
        homeModel2.setNaviMode(CSharedPreferences.j(context));
        if (homeModel2.getLatitude() == 0.0d || homeModel2.getLongitude() == 0.0d) {
            CLog.b(TAG, "startNaviToAddress()  There is no home address record.");
        } else {
            startNavigation(context, homeModel2, 2);
        }
    }

    private void updateAddressMode() {
        CLog.b(TAG, "updateAddressMode()  Enter.");
        for (CommonAddress commonAddress : this.naviDatabase.d().d(NaviUtil.t())) {
            if (NaviUtil.J().equalsIgnoreCase(commonAddress.d())) {
                setDataAddr(this.homeModel, commonAddress);
            } else if (NaviUtil.w().equalsIgnoreCase(commonAddress.d())) {
                setDataAddr(this.companyModel, commonAddress);
            } else if (SchedulerSupport.CUSTOM.equalsIgnoreCase(commonAddress.d())) {
                setDataAddr(this.customModel, commonAddress);
            }
        }
    }

    public void addNaviOperatorCallback(INaviLocationCallback iNaviLocationCallback) {
        if (iNaviLocationCallback != null) {
            String str = TAG;
            CLog.b(str, "addNaviOperatorCallback()  callback=" + iNaviLocationCallback.toString() + " size=" + this.naviLocationCallbacks.size());
            if (!this.naviLocationCallbacks.containsKey(iNaviLocationCallback.toString())) {
                this.naviLocationCallbacks.put(iNaviLocationCallback.toString(), iNaviLocationCallback);
                return;
            }
            return;
        }
        CLog.b(TAG, "addNaviOperatorCallback()  callback is null.");
    }

    public void clearNaviOperatorCallback() {
        this.naviLocationCallbacks.clear();
    }

    public void company(Context context) {
        if (CSharedPreferences.b(context.getApplicationContext(), "navi_commom_address_guide", false) || hasCompanyAddress()) {
            companyAddress(context);
            return;
        }
        CSharedPreferences.p(context.getApplicationContext(), "navi_commom_address_guide", true);
        CustomDialog customDialog = new CustomDialog(context);
        customDialog.c(true);
        customDialog.j(context.getString(R.string.add_address_guide)).f(context.getString(R.string.go_add_address), new k(this, customDialog, context)).show();
    }

    public void custom(Context context) {
        if (this.customModel.getLatitude() == 0.0d && this.customModel.getLongitude() == 0.0d) {
            setEnterType(2);
            Intent intent = new Intent(context, AddressActivity.class);
            intent.setFlags(CaptureType.CAPTURE_VIRTUAL_DISPLAY_WHEN_SCREEN_LOCKED);
            context.startActivity(intent);
            return;
        }
        startNavigationFromSuperApp(context, this.customModel);
    }

    public void disableBackgroundLocation(boolean z) {
        LocationManager.f().b(z);
    }

    public void enableBackgroundLocation(int i, Notification notification) {
        LocationManager.f().c(i, notification);
    }

    public List<String> findDeniedPermissions() {
        List<String> p = NaviUtil.p(mContext);
        if (StarryNetManger.getInstance().getOperatorManager() == null) {
            StarryNetManger.getInstance().init(mContext);
        }
        String str = TAG;
        CLog.b(str, "findDeniedPermissions.size() is:" + p.size());
        if (p.size() > 0) {
            StarryNetManger.getInstance().sendMessage(NotifyUtils.d(NaviUtil.L(mContext, NaviUtil.s0() ? R.string.navi_permissions_desp_intl : R.string.navi_permissions_desp)), "com.upuphone.star.launcher", (SendMessageListener) null);
        }
        if (p.size() > 0 && !NaviUtil.t0()) {
            StarryNetManger.getInstance().requestPermission();
        }
        return p;
    }

    public INaviActionResult getCompanyActionResult() {
        return this.companyActionResult;
    }

    public SearchModel getCompanyModel() {
        return this.companyModel;
    }

    public String getCompanyName() {
        SearchModel searchModel = this.companyModel;
        return searchModel != null ? searchModel.getName() : "";
    }

    public SearchModel getCustomModel() {
        return this.customModel;
    }

    public String getCustomName() {
        SearchModel searchModel = this.customModel;
        return searchModel != null ? TextUtils.isEmpty(searchModel.getName()) ? mContext.getString(R.string.custom) : this.customModel.getName() : mContext.getString(R.string.custom);
    }

    public int getEnterType() {
        return this.enterType;
    }

    public INaviActionResult getHomeActionResult() {
        return this.homeActionResult;
    }

    public SearchModel getHomeModel() {
        return this.homeModel;
    }

    public String getHomeName() {
        SearchModel searchModel = this.homeModel;
        return searchModel != null ? searchModel.getName() : "";
    }

    public double[] getLocation() {
        if (LocationManager.f().g() == null) {
            return new double[2];
        }
        return new double[]{LocationManager.f().g().getLatitude(), LocationManager.f().g().getLongitude()};
    }

    public void getLocationInfo(Context context, IPlaceInfo iPlaceInfo) {
        String str = TAG;
        CLog.b(str, "getLocationInfo() ### place=" + iPlaceInfo);
        PlaceBean j = LocationManager.f().j();
        this.naviPlace = iPlaceInfo;
        if (iPlaceInfo == null) {
            stopLocation();
        } else if (j != null) {
            onLocationInfoChange(j);
        }
    }

    public ILocation getLocationListener() {
        return this.locationListener;
    }

    public NaviDatabase getNaviDatabase() {
        if (this.naviDatabase == null) {
            initDatabase();
        }
        return this.naviDatabase;
    }

    public Map<String, INaviLocationCallback> getNaviLocationCallbacks() {
        return this.naviLocationCallbacks;
    }

    public INaviOperator getNaviOperator() {
        return this.naviOperator;
    }

    public IPlaceInfo getNaviPlace() {
        return this.naviPlace;
    }

    public INaviState getNaviStateListener() {
        return this.naviStateListener;
    }

    public INaviVoiceStateChanged getNaviVoiceStateChanged() {
        return this.naviVoiceStateChanged;
    }

    public INaviActionResult getPoiActionResult() {
        return this.poiActionResult;
    }

    public boolean hasAddress(int i) {
        if (i == 1) {
            return hasHomeAddress();
        }
        if (i == 2) {
            return hasCompanyAddress();
        }
        return false;
    }

    public void home(Context context) {
        if (CSharedPreferences.b(context.getApplicationContext(), "navi_commom_address_guide", false) || hasHomeAddress()) {
            homeAddress(context);
            return;
        }
        CSharedPreferences.p(context.getApplicationContext(), "navi_commom_address_guide", true);
        CustomDialog customDialog = new CustomDialog(context);
        customDialog.c(true);
        customDialog.j(context.getString(R.string.add_address_guide)).f(context.getString(R.string.go_add_address), new j(this, customDialog, context)).show();
    }

    public void init() {
        initNaviOperator();
        initPrivacyCompliance();
        initDatabase();
        initCommonAddr();
        OfflineMapManager.b().f(mContext);
        OfflineMapManager.b().e();
    }

    public void initCommonAddr() {
        this.homeModel = new SearchModel();
        this.companyModel = new SearchModel();
        this.customModel = new SearchModel();
        for (CommonAddress commonAddress : this.naviDatabase.d().d(NaviUtil.t())) {
            if (NaviUtil.J().equalsIgnoreCase(commonAddress.d())) {
                setDataAddr(this.homeModel, commonAddress);
            } else if (NaviUtil.w().equalsIgnoreCase(commonAddress.d())) {
                setDataAddr(this.companyModel, commonAddress);
            } else if (SchedulerSupport.CUSTOM.equalsIgnoreCase(commonAddress.d())) {
                setDataAddr(this.customModel, commonAddress);
            }
        }
    }

    public boolean isDriveRegion(int i, INaviActionResult iNaviActionResult) {
        if (!RegionUtils.d() || i != 0) {
            return true;
        }
        CLog.b(TAG, "isDriveRegion()  Current Region is not support drive navigation.");
        try {
            iNaviActionResult.actionFailure("Current Region is not support drive navigation.", 100001);
            return false;
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean isNaviSpeakOn() {
        return CSharedPreferences.m(mContext);
    }

    public void naviSetting(Context context) {
        setEnterType(3);
        Intent intent = new Intent(context, SettingActivity.class);
        intent.setFlags(CaptureType.CAPTURE_VIRTUAL_DISPLAY_WHEN_SCREEN_LOCKED);
        context.startActivity(intent);
    }

    public void onLocationInfoChange(PlaceBean placeBean) {
        IPlaceInfo iPlaceInfo = this.naviPlace;
        if (iPlaceInfo != null) {
            iPlaceInfo.a(placeBean);
        }
    }

    public void operatorLocationChanged(PlaceBean placeBean) {
        NaviLocationInfo naviLocationInfo = new NaviLocationInfo();
        if (placeBean != null) {
            naviLocationInfo.setAdCode(placeBean.getAdCode());
            naviLocationInfo.setAddress(placeBean.getAddress());
            naviLocationInfo.setCity(placeBean.getCity());
            naviLocationInfo.setCityCode(placeBean.getCityCode());
            naviLocationInfo.setDistrict(placeBean.getDistrict());
            naviLocationInfo.setErrorCode(placeBean.getErrorCode());
            naviLocationInfo.setErrorInfo("success");
            naviLocationInfo.setLatitude(placeBean.getLatitude());
            naviLocationInfo.setLongitude(placeBean.getLongitude());
            naviLocationInfo.setProvince(placeBean.getProvince());
            naviLocationInfo.setPoiName(placeBean.getPoiName());
            naviLocationInfo.setStreet(placeBean.getStreet());
        }
        for (String next : this.naviLocationCallbacks.keySet()) {
            try {
                String str = TAG;
                CLog.b(str, "operatorLocationChanged()  key=" + next + " value=" + this.naviLocationCallbacks.get(next));
                INaviLocationCallback iNaviLocationCallback = this.naviLocationCallbacks.get(next);
                if (iNaviLocationCallback != null) {
                    iNaviLocationCallback.onLocationChanged(naviLocationInfo);
                    removeNaviOperatorCallback(iNaviLocationCallback);
                } else {
                    this.naviLocationCallbacks.remove(next, iNaviLocationCallback);
                }
            } catch (RemoteException e) {
                String str2 = TAG;
                CLog.b(str2, "operatorLocationChanged()  excep=" + e);
            }
        }
    }

    public void poiSearch(Context context, String str, INaviPoiCallback iNaviPoiCallback) {
        PoiSearchManager.f().j(context, str, iNaviPoiCallback);
    }

    public void removeNaviOperatorCallback(INaviLocationCallback iNaviLocationCallback) {
        if (iNaviLocationCallback != null) {
            String str = TAG;
            CLog.b(str, "removeNaviOperatorCallback()  callback=" + iNaviLocationCallback.toString() + " size=" + this.naviLocationCallbacks.size());
            if (this.naviLocationCallbacks.containsKey(iNaviLocationCallback.toString())) {
                this.naviLocationCallbacks.remove(iNaviLocationCallback.toString());
                return;
            }
            return;
        }
        CLog.b(TAG, "removeNaviOperatorCallback()  callback is null.");
    }

    public boolean saveNaviAddress(PoiResult poiResult, int i) {
        String str = TAG;
        CLog.b(str, "saveNaviAddress Enter");
        CommonAddress commonAddress = new CommonAddress();
        commonAddress.q("");
        commonAddress.o(poiResult.getAddress());
        commonAddress.n(poiResult.getPoiId());
        commonAddress.p(i == 1 ? NaviUtil.J() : NaviUtil.w());
        commonAddress.t(poiResult.getLatitude());
        commonAddress.u(poiResult.getLongitude());
        commonAddress.s("");
        commonAddress.v(poiResult.getName());
        NaviDatabase naviDatabase2 = getNaviDatabase();
        if (naviDatabase2 == null) {
            CLog.b(str, "saveNaviAddress naviDatabase is null.");
            return false;
        }
        if (matchOtherAddress(commonAddress)) {
            naviDatabase2.d().a(NaviUtil.t(), i == 1 ? NaviUtil.w() : NaviUtil.J());
            getInstance(mContext).initCommonAddr();
            naviDatabase2.d().c(commonAddress);
        } else {
            naviDatabase2.d().c(commonAddress);
        }
        updateAddressMode();
        NaviUtil.E1(mContext.getApplicationContext());
        return true;
    }

    public void setAccountInfo(String str) {
        String str2 = TAG;
        CLog.b(str2, "setAccountInfo  ######## info=" + str);
        try {
            AccountInfoBean accountInfoBean = (AccountInfoBean) JsonUtil.b(str, AccountInfoBean.class);
            CLog.b(str2, "setAccountInfo   accountInfo.toString()=" + accountInfoBean.toString());
            String id = accountInfoBean.getId();
            NaviUtil.c1(id);
            if (!TextUtils.isEmpty(id) && !CSharedPreferences.h(mContext).booleanValue()) {
                CSharedPreferences.v(mContext, true);
                migrationPreferences();
                migrationDataBase();
            }
        } catch (Exception e) {
            String str3 = TAG;
            CLog.b(str3, "setAccountInfo  ######## exception=" + e);
            NaviUtil.c1("");
        }
    }

    public void setCompanyActionResult(INaviActionResult iNaviActionResult) {
        this.companyActionResult = iNaviActionResult;
    }

    public void setDataAddr(SearchModel searchModel, CommonAddress commonAddress) {
        searchModel.setAcode(commonAddress.b());
        searchModel.setAddress(commonAddress.c());
        searchModel.setCity(commonAddress.e());
        searchModel.setDistrict(commonAddress.g());
        searchModel.setLatitude(commonAddress.h());
        searchModel.setLongitude(commonAddress.i());
        searchModel.setName(commonAddress.j());
    }

    public void setEnterType(int i) {
        this.enterType = i;
    }

    public void setGlassLanguage(String str, String str2) {
        CSharedPreferences.y(mContext, "navi_glass_locale_country", str);
        CSharedPreferences.y(mContext, "navi_glass_locale_language", str2);
        NaviUtil.j1(new String[]{str, str2});
    }

    public void setHomeActionResult(INaviActionResult iNaviActionResult) {
        this.homeActionResult = iNaviActionResult;
    }

    public void setLocationListener(ILocation iLocation) {
        this.locationListener = iLocation;
    }

    public void setNaviOperator(INaviOperator iNaviOperator) {
        this.naviOperator = iNaviOperator;
    }

    public void setNaviStateChangedListener(INaviState iNaviState) {
        this.naviStateListener = iNaviState;
    }

    public void setNaviVoiceStateChanged(INaviVoiceStateChanged iNaviVoiceStateChanged) {
        this.naviVoiceStateChanged = iNaviVoiceStateChanged;
    }

    public void setPoiActionResult(INaviActionResult iNaviActionResult) {
        this.poiActionResult = iNaviActionResult;
    }

    public void startContinueLocation(Context context, ILocation iLocation) {
        if (context == null) {
            CLog.b(TAG, "startContinueLocation() context is empty!");
            return;
        }
        String str = TAG;
        CLog.b(str, "startContinueLocation()   location=" + iLocation);
        setLocationListener(iLocation);
        LocationManager.f().p(2);
        startLocation(context);
    }

    public void startLocation(Context context) {
        if (context == null) {
            CLog.b(TAG, "startLocation() ### context is empty!");
            return;
        }
        boolean S0 = NaviUtil.S0(context);
        boolean j = LocationUtil.j(context);
        String str = TAG;
        CLog.b(str, "startLocation() @@@ isStarted=" + LocationManager.f().m() + "  isInited=" + LocationManager.f().l() + "  needSetPermission=" + S0 + " openGps=" + j);
        if (S0 || !j) {
            CLog.b(str, "startLocation() @@@ needSetPermission or GPS not opened!");
        } else if (!LocationManager.f().l()) {
            LocationManager.f().k(context, false);
        } else {
            LocationManager.f().q();
        }
    }

    public void startMap(Context context) {
        String str = TAG;
        CLog.b(str, "startMap()  Enter. NaviTaskState=" + NaviControlManager.k().n());
        Intent intent = new Intent(context, NaviFragmentActivity.class);
        intent.putExtra("map_navi_key", true);
        intent.setFlags(CaptureType.CAPTURE_VIRTUAL_DISPLAY_WHEN_SCREEN_LOCKED);
        if (!(NaviControlManager.k().n() == 0 || NaviControlManager.k().n() == 5)) {
            boolean B0 = NaviUtil.B0();
            NaviManager.getInstance(context).stopNavi();
            NaviUtil.q1(B0);
            intent.putExtra("search_info_key", NaviService.C());
            intent.putExtra("direct_navi_key", true);
            intent.putExtra("navi_from_quik_key", NaviService.H());
        }
        NaviControlManager.k().K(0);
        context.startActivity(intent);
    }

    public void startNavi(Context context, int i, int i2, PoiResult poiResult, INaviActionResult iNaviActionResult) {
        if (!isDriveRegion(i, iNaviActionResult)) {
            CLog.b(TAG, "startNavi()  Current Region is not support drive.");
            return;
        }
        NaviTtsManager.getInstance(context.getApplicationContext()).speakNormal();
        this.poiActionResult = iNaviActionResult;
        if (poiResult == null) {
            CLog.b(TAG, "startNavi()  destPoi is empty.");
            this.poiActionResult = null;
            return;
        }
        String str = TAG;
        CLog.b(str, "startNavi getLatitude:" + poiResult.getLatitude() + " getLongitude=" + poiResult.getLongitude() + " getName=" + poiResult.getName() + "startNavi()  naviMode=" + i + " strategy=" + i2);
        startLocation(context);
        SearchModel searchModel = new SearchModel();
        searchModel.setName(poiResult.getName());
        searchModel.setLatitude(poiResult.getLatitude());
        searchModel.setLongitude(poiResult.getLongitude());
        searchModel.setAddress(poiResult.getAddress());
        searchModel.setDistance(poiResult.getDistance());
        searchModel.setAcode(poiResult.getPoiId());
        searchModel.setNaviMode(i);
        searchModel.setStrategy(i2);
        if (searchModel.getLatitude() == 0.0d || searchModel.getLongitude() == 0.0d) {
            CLog.b(str, "startNavi()  Latitude and Longitude value is invalid.");
        } else {
            startNavigation(context, searchModel, 2);
        }
    }

    public void startNaviActivity(Context context, SearchModel searchModel, int i, boolean z) {
        Intent intent = new Intent(context, NaviFragmentActivity.class);
        intent.setFlags(CaptureType.CAPTURE_VIRTUAL_DISPLAY_WHEN_SCREEN_LOCKED);
        intent.putExtra("search_info_key", searchModel);
        intent.putExtra("direct_navi_key", z);
        intent.putExtra("navi_from_quik_key", i);
        context.startActivity(intent);
    }

    public void startNaviFromAI(Context context) {
        if (!NaviUtil.H0()) {
            CLog.b(TAG, "startNaviFromAI()  last SearchActivity has not Destoryed.");
        }
        Intent intent = new Intent(context, NaviFragmentActivity.class);
        intent.setFlags(CaptureType.CAPTURE_VIRTUAL_DISPLAY_WHEN_SCREEN_LOCKED);
        intent.putExtra("open_navi_ai_key", true);
        context.startActivity(intent);
    }

    public void startNaviService(Context context, SearchModel searchModel, int i) {
        Intent intent = new Intent(context, NaviService.class);
        intent.putExtra("search_info_key", searchModel);
        intent.putExtra("direct_navi_key", true);
        intent.putExtra("navi_from_quik_key", i);
        context.startService(intent);
    }

    public void startNaviToAddress(Context context, int i, INaviActionResult iNaviActionResult) {
        NaviTtsManager.getInstance(context.getApplicationContext()).speakNormal();
        if (i == 1) {
            startNaviToHome(context, iNaviActionResult);
        } else if (i == 2) {
            startNaviToCmpany(context, iNaviActionResult);
        }
    }

    public void startNavigation(Context context, SearchModel searchModel, int i) {
        String str = TAG;
        CLog.b(str, "startNavigation()  isIsNaviOpened=" + NaviUtil.t0() + " isIsNewTaskNavi=" + NaviUtil.v0() + " NaviUtil.isAppForeground()=" + NaviUtil.l0() + " isNaviHome=" + NaviUtil.z0() + " isIsNaving=" + NaviUtil.u0());
        if (i == 2) {
            OfflineMapManager.b().f(context);
            OfflineMapManager.b().h();
        }
        NaviUtil.i1(!NaviUtil.t0());
        setEnterType(1);
        NaviUtil.T0(context);
        if (!NaviUtil.t0()) {
            startNaviService(context, searchModel, i);
        } else if (NaviUtil.u0()) {
            NaviManager.getInstance(context).restartNaviTask(searchModel, i, true);
        } else if (!NaviUtil.l0()) {
            ActivityManager.getInstance().finishAll();
            startNaviService(context, searchModel, i);
        } else {
            startNaviActivity(context, searchModel, i, true);
        }
        NaviUtil.h0(context, searchModel);
    }

    public void startNavigationFromSuperApp(Context context, SearchModel searchModel) {
        setEnterType(1);
        searchModel.setNaviMode(CSharedPreferences.j(context.getApplicationContext()));
        if (NaviUtil.t0()) {
            startNaviActivity(context, searchModel, 1, false);
        } else {
            startNaviService(context, searchModel, 1);
        }
        NaviUtil.h0(context, searchModel);
    }

    public void startOnceLocation(Context context) {
        if (context == null) {
            CLog.b(TAG, "startOnceLocation() @@@ context is empty!");
            return;
        }
        boolean S0 = NaviUtil.S0(context);
        boolean j = LocationUtil.j(context);
        String str = TAG;
        CLog.b(str, "startOnceLocation() @@@ isStarted=" + LocationManager.f().m() + "  isInited=" + LocationManager.f().l() + "  needSetPermission=" + S0 + " openGps=" + j);
        if (S0 || !j) {
            CLog.b(str, "startOnceLocation() @@@ needSetPermission or GPS not opened!");
        } else if (!LocationManager.f().l()) {
            LocationManager.f().k(context, true);
        } else if (!LocationManager.f().m()) {
            LocationManager.f().r();
        }
    }

    public void startPermissionsActivity(Context context) {
        Intent intent = new Intent(context, PermissionsActivity.class);
        intent.setFlags(CaptureType.CAPTURE_VIRTUAL_DISPLAY_WHEN_SCREEN_LOCKED);
        context.startActivity(intent);
    }

    public void startSearch(Context context) {
        if (!NaviUtil.H0()) {
            CLog.b(TAG, "startSearch()  last SearchActivity has not Destoryed.");
        }
        Intent intent = new Intent(context, NaviFragmentActivity.class);
        intent.setFlags(CaptureType.CAPTURE_VIRTUAL_DISPLAY_WHEN_SCREEN_LOCKED);
        context.startActivity(intent);
    }

    public void stopContinueLocation(ILocation iLocation) {
        String str = TAG;
        CLog.b(str, "stopContinueLocation() ###  location=" + iLocation);
        setLocationListener((ILocation) null);
        LocationManager.f().p(0);
        stopLocation();
    }

    public void stopLocation() {
        String str = TAG;
        CLog.b(str, "stopLocation() @@@ isStarted=" + LocationManager.f().m() + "  isInited=" + LocationManager.f().l());
        LocationManager.f().s();
    }

    public void stopNaviService(Context context) {
        context.stopService(new Intent(context, NaviService.class));
    }

    public void stopLocation(INaviLocationCallback iNaviLocationCallback) {
        String str = TAG;
        CLog.b(str, "stopLocation() ### isStarted=" + LocationManager.f().m() + "  isInited=" + LocationManager.f().l() + " naviLocation=" + iNaviLocationCallback);
        removeNaviOperatorCallback(iNaviLocationCallback);
        LocationManager.f().s();
    }

    public void startLocation(Context context, INaviLocationCallback iNaviLocationCallback) {
        if (context == null) {
            CLog.b(TAG, "startLocation() context is empty!");
            return;
        }
        boolean S0 = NaviUtil.S0(context);
        boolean j = LocationUtil.j(context);
        String str = TAG;
        CLog.b(str, "startLocation()  isStarted=" + LocationManager.f().m() + "  needSetPermission=" + S0 + " isInited=" + LocationManager.f().l() + " openGps=" + j);
        addNaviOperatorCallback(iNaviLocationCallback);
        if (S0 || !j) {
            CLog.b(str, "startLocation() ### needSetPermission  or GPS not opened!");
        } else if (!LocationManager.f().l()) {
            LocationManager.f().k(context, true);
        } else {
            LocationManager.f().r();
        }
    }
}
