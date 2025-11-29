package com.upuphone.starrynet.strategy.config;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.util.Consumer;
import androidx.core.util.Pair;
import com.honey.account.d7.a;
import com.upuphone.starrynet.api.StConfiguration;
import com.upuphone.starrynet.api.bean.StDevice;
import com.upuphone.starrynet.common.StLog;
import com.upuphone.starrynet.strategy.StarryNetData;
import com.upuphone.starrynet.strategy.SysActionManager;
import com.upuphone.starrynet.strategy.utils.FileUtil;
import com.upuphone.starrynet.strategy.utils.HttpUtil;
import com.upuphone.starrynet.strategy.utils.ThreadUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class StConfigLoader {
    private static final String ASSETS_ST_CONFIG_NAME = "st_configs.json";
    private static final String LOCAL_CACHE_ST_CONFIG_NAME_SUFFIX = "st_remote_configs.json";
    private static final long MIN_REQUEST_CONFIG_INTERVAL = 72000000;
    private static final String TAG = "StConfigLoader";
    private final Map<String, String> hmCategory = new HashMap();
    private final Map<String, String> hmCompany = new HashMap();
    private final Map<String, StDevice> hmDevice = new HashMap();
    private int mCurrentDevicesConfigVersion = -1;
    /* access modifiers changed from: private */
    public volatile boolean mIsRequestRemoteConfig = false;
    private long mLastRequestRemoteConfigTime = -1;

    public StConfigLoader() {
        SysActionManager.getInstance().registerSysAction(new SysActionManager.StateChangeSimpleCallback() {
            public void onBluetoothEnabled() {
                if (StConfigLoader.this.canRequest()) {
                    StLog.d(StConfigLoader.TAG, "onBluetoothEnable, after wait 300ms request config");
                    StConfigLoader.this.requestRemoteStarryNetConfig(StarryNetData.getInstance().getApplicationContext(), 300);
                }
            }

            public void onScreenOn() {
                if (StConfigLoader.this.canRequest()) {
                    StLog.d(StConfigLoader.TAG, "onScreenOn, after wait 3s request config");
                    StConfigLoader.this.requestRemoteStarryNetConfig(StarryNetData.getInstance().getApplicationContext(), 3000);
                }
            }

            public void onWiFiEnabled() {
                if (StConfigLoader.this.canRequest()) {
                    StLog.d(StConfigLoader.TAG, "onWifiEnable, after wait 3s request config");
                    StConfigLoader.this.requestRemoteStarryNetConfig(StarryNetData.getInstance().getApplicationContext(), 3000);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public boolean canRequest() {
        long currentTimeMillis = System.currentTimeMillis();
        long j = this.mLastRequestRemoteConfigTime;
        return j < 0 || currentTimeMillis - j > MIN_REQUEST_CONFIG_INTERVAL;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$requestRemoteStarryNetConfig$0(final Context context) {
        HttpUtil.downloadContent(HttpUtil.ST_CONFIG_URL, new Consumer<byte[]>() {
            public void accept(byte[] bArr) {
                boolean unused = StConfigLoader.this.mIsRequestRemoteConfig = false;
                if (bArr != null) {
                    StConfigLoader.this.loadRemoteConfig(context, new String(bArr));
                } else {
                    StLog.d(StConfigLoader.TAG, "loadRemoteStarryNetConfig fail, content is null");
                }
            }
        });
    }

    private int loadJsonConfig(String str) {
        if (TextUtils.isEmpty(str)) {
            StLog.e(TAG, "loadJsonConfig, content is empty!");
            return -1;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            int optInt = jSONObject.optInt("version", -1);
            if (optInt <= this.mCurrentDevicesConfigVersion) {
                StLog.d(TAG, "no config update, new version =" + optInt + ",current version=" + this.mCurrentDevicesConfigVersion);
                return 0;
            }
            StLog.d(TAG, "start loadJsonConfig, version=" + optInt);
            JSONObject optJSONObject = jSONObject.optJSONObject("devices");
            if (optJSONObject == null) {
                StLog.d(TAG, "devices is null");
                return -1;
            }
            JSONArray optJSONArray = optJSONObject.optJSONArray("company");
            if (optJSONArray != null) {
                if (optJSONArray.length() != 0) {
                    parseDevices(optJSONArray);
                    JSONArray optJSONArray2 = jSONObject.optJSONArray("iccoaBlackList");
                    if (optJSONArray2 == null) {
                        StLog.d(TAG, "iccoa black list is null");
                        return -1;
                    }
                    parseICCOABlackList(optJSONArray2);
                    JSONArray optJSONArray3 = jSONObject.optJSONArray("whiteMusicApps");
                    if (optJSONArray3 == null) {
                        StLog.d(TAG, "white music apps is null");
                        return -1;
                    }
                    parseWhiteMusicApps(optJSONArray3);
                    JSONArray optJSONArray4 = jSONObject.optJSONArray("carWithPadList");
                    if (optJSONArray4 == null) {
                        StLog.d(TAG, "car with pad list is null");
                        return -1;
                    }
                    parseCarWithPadList(optJSONArray4);
                    JSONArray optJSONArray5 = jSONObject.optJSONArray("iccoaWhiteApps");
                    if (optJSONArray5 == null) {
                        StLog.d(TAG, "iccoa white apps is null");
                        return -1;
                    }
                    parseIccoaWhiteApps(optJSONArray5);
                    this.mCurrentDevicesConfigVersion = optInt;
                    StLog.d(TAG, "finish load config, current version=" + this.mCurrentDevicesConfigVersion);
                    return optInt;
                }
            }
            StLog.d(TAG, "company is empty");
            return -1;
        } catch (JSONException e) {
            StLog.d(TAG, "loadConfigJson error: " + Log.getStackTraceString(e));
            return -1;
        }
    }

    private int loadLocalCacheConfig(Context context, String str) {
        StLog.d(TAG, "loadLocalCacheConfig");
        return loadJsonConfig(FileUtil.readFile(context, str));
    }

    private void parseCarWithPadList(JSONArray jSONArray) {
        if (jSONArray != null && jSONArray.length() != 0) {
            try {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.add(jSONArray.getString(i));
                }
                StConfiguration.updateCarWithPadList(arrayList);
            } catch (JSONException e) {
                StLog.e(TAG, "parseCarWithPadList error:" + Log.getStackTraceString(e));
            }
        }
    }

    private void parseDevices(JSONArray jSONArray) {
        String str;
        JSONArray jSONArray2;
        String str2 = "-id";
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        HashMap hashMap3 = new HashMap();
        int length = jSONArray.length();
        int i = 0;
        while (i < length) {
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                String string = jSONObject.getString(str2);
                String string2 = jSONObject.getString("companyName");
                hashMap.put(string, string2);
                JSONArray optJSONArray = jSONObject.optJSONArray("category");
                int length2 = optJSONArray != null ? optJSONArray.length() : 0;
                if (length2 != 0) {
                    int i2 = 0;
                    while (i2 < length2) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
                        String string3 = jSONObject2.getString(str2);
                        int i3 = length;
                        String string4 = jSONObject2.getString("categoryName");
                        hashMap2.put(string3, string4);
                        JSONArray optJSONArray2 = jSONObject2.optJSONArray("model");
                        if (optJSONArray2 == null || optJSONArray2.length() == 0) {
                            str = str2;
                            jSONArray2 = optJSONArray;
                        } else {
                            jSONArray2 = optJSONArray;
                            int i4 = 0;
                            while (i4 < optJSONArray2.length()) {
                                JSONObject jSONObject3 = optJSONArray2.getJSONObject(i4);
                                JSONArray jSONArray3 = optJSONArray2;
                                String string5 = jSONObject3.getString(str2);
                                String str3 = str2;
                                String string6 = jSONObject3.getString("modelName");
                                StDevice stDevice = new StDevice();
                                stDevice.setCompanyID(string);
                                stDevice.setCompanyName(string2);
                                stDevice.setCategoryID(string3);
                                stDevice.setCategoryName(string4);
                                stDevice.setModelID(string5);
                                stDevice.setModelName(string6);
                                stDevice.setTerminalType(StarryNetData.getTerminalType(string3));
                                hashMap3.put(string5, stDevice);
                                i4++;
                                optJSONArray2 = jSONArray3;
                                str2 = str3;
                            }
                            str = str2;
                        }
                        i2++;
                        JSONArray jSONArray4 = jSONArray;
                        length = i3;
                        optJSONArray = jSONArray2;
                        str2 = str;
                    }
                }
                i++;
                length = length;
                str2 = str2;
            } catch (JSONException e) {
                StLog.e(TAG, "parseDevices error:" + Log.getStackTraceString(e));
                return;
            }
        }
        StLog.d(TAG, " after load devices config company size=" + hashMap.size() + ",category size=" + hashMap2.size() + ",device size=" + hashMap3.size());
        this.hmCategory.clear();
        this.hmCategory.putAll(hashMap2);
        this.hmDevice.clear();
        this.hmDevice.putAll(hashMap3);
        this.hmCompany.clear();
        this.hmCompany.putAll(hashMap);
    }

    private void parseICCOABlackList(JSONArray jSONArray) {
        if (jSONArray != null && jSONArray.length() != 0) {
            try {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    arrayList.add(new Pair(jSONObject.getString("vid"), jSONObject.getString("pid")));
                }
                StConfiguration.updateICCOABlackList(arrayList);
            } catch (JSONException e) {
                StLog.e(TAG, "parseICCOABlackList error:" + Log.getStackTraceString(e));
            }
        }
    }

    private void parseIccoaWhiteApps(JSONArray jSONArray) {
        if (jSONArray != null && jSONArray.length() != 0) {
            try {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.add(jSONArray.getString(i));
                }
                StConfiguration.updateIccoaWhiteApps(arrayList);
            } catch (JSONException e) {
                StLog.e(TAG, "parseWhiteMusicApps error:" + Log.getStackTraceString(e));
            }
        }
    }

    private void parseWhiteMusicApps(JSONArray jSONArray) {
        if (jSONArray != null && jSONArray.length() != 0) {
            try {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.add(jSONArray.getString(i));
                }
                StConfiguration.updateWhiteMusicApps(arrayList);
            } catch (JSONException e) {
                StLog.e(TAG, "parseWhiteMusicApps error:" + Log.getStackTraceString(e));
            }
        }
    }

    public StDevice buildOwnDevice(String str, String str2) {
        if (!this.hmCompany.containsValue(str2)) {
            return null;
        }
        for (Map.Entry next : this.hmDevice.entrySet()) {
            if (TextUtils.equals(((StDevice) next.getValue()).getModelName(), str)) {
                return (StDevice) next.getValue();
            }
        }
        return null;
    }

    public StDevice buildStDevice(String str, String str2, String str3) {
        StDevice stDevice = new StDevice();
        stDevice.setCompanyID(getCompanyID(str));
        stDevice.setCompanyName(str);
        stDevice.setCategoryID(getCategoryID(str2));
        stDevice.setCategoryName(str2);
        stDevice.setModelID(getModelID(str3));
        stDevice.setModelName(str3);
        return stDevice;
    }

    public String getCategoryID(String str) {
        if (!this.hmCategory.containsValue(str)) {
            return "";
        }
        for (Map.Entry next : this.hmCategory.entrySet()) {
            if (Objects.equals(next.getValue(), str)) {
                return (String) next.getKey();
            }
        }
        return "";
    }

    public String getCategoryName(String str) {
        return this.hmCategory.get(str);
    }

    public String getCompanyID(String str) {
        if (!this.hmCompany.containsValue(str)) {
            return "";
        }
        for (Map.Entry next : this.hmCompany.entrySet()) {
            if (Objects.equals(next.getValue(), str)) {
                return (String) next.getKey();
            }
        }
        return "";
    }

    public String getCompanyName(String str) {
        return this.hmCompany.get(str);
    }

    public String getModelID(String str) {
        for (Map.Entry next : this.hmDevice.entrySet()) {
            StDevice stDevice = (StDevice) next.getValue();
            if (stDevice != null && stDevice.getModelName().equals(str)) {
                return (String) next.getKey();
            }
        }
        return "";
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x000b, code lost:
        r2 = r2.hmDevice.get(r3);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String getModelName(java.lang.String r3) {
        /*
            r2 = this;
            java.util.Map<java.lang.String, com.upuphone.starrynet.api.bean.StDevice> r0 = r2.hmDevice
            boolean r0 = r0.containsKey(r3)
            java.lang.String r1 = ""
            if (r0 != 0) goto L_0x000b
            return r1
        L_0x000b:
            java.util.Map<java.lang.String, com.upuphone.starrynet.api.bean.StDevice> r2 = r2.hmDevice
            java.lang.Object r2 = r2.get(r3)
            com.upuphone.starrynet.api.bean.StDevice r2 = (com.upuphone.starrynet.api.bean.StDevice) r2
            if (r2 != 0) goto L_0x0016
            return r1
        L_0x0016:
            java.lang.String r2 = r2.getModelName()
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.starrynet.strategy.config.StConfigLoader.getModelName(java.lang.String):java.lang.String");
    }

    public void loadAssetsConfigFile(Context context) {
        StLog.d(TAG, "start loadAssetsConfigFile");
        loadJsonConfig(FileUtil.readAssetFile2String(context, ASSETS_ST_CONFIG_NAME));
    }

    public void loadLocalConfig(Context context) {
        int i = -1;
        for (File file : context.getFilesDir().listFiles()) {
            if (file.getName().endsWith(LOCAL_CACHE_ST_CONFIG_NAME_SUFFIX)) {
                String replace = file.getName().replace(LOCAL_CACHE_ST_CONFIG_NAME_SUFFIX, "");
                StLog.d(TAG, "local version =" + replace);
                if (!TextUtils.isEmpty(replace)) {
                    try {
                        i = Integer.parseInt(replace);
                    } catch (Exception e) {
                        StLog.e(TAG, "parseInt error:" + Log.getStackTraceString(e));
                    }
                }
            }
        }
        StLog.d(TAG, "assetConfigVersion=" + 32 + ",localCacheConfigVersion=" + i);
        if (32 > i || i < 0) {
            loadAssetsConfigFile(context);
            return;
        }
        loadLocalCacheConfig(context, i + LOCAL_CACHE_ST_CONFIG_NAME_SUFFIX);
    }

    public void loadRemoteConfig(Context context, String str) {
        int loadJsonConfig = loadJsonConfig(str);
        StLog.d(TAG, "load remote Config result= " + loadJsonConfig);
        if (loadJsonConfig >= 0) {
            this.mLastRequestRemoteConfigTime = System.currentTimeMillis();
        }
        if (loadJsonConfig > 0) {
            String str2 = this.mCurrentDevicesConfigVersion + LOCAL_CACHE_ST_CONFIG_NAME_SUFFIX;
            FileUtil.saveFile(context, str2, str);
            File[] listFiles = context.getFilesDir().listFiles();
            int length = listFiles.length;
            int i = 0;
            while (i < length) {
                File file = listFiles[i];
                if (!file.getName().endsWith(LOCAL_CACHE_ST_CONFIG_NAME_SUFFIX) || file.getName().equals(str2)) {
                    i++;
                } else {
                    file.delete();
                    return;
                }
            }
        }
    }

    public void requestRemoteStarryNetConfig(Context context, int i) {
        StLog.d(TAG, "requestRemoteStarryNetConfig, delay=" + i);
        StDevice ownDevice = StarryNetData.getInstance().getOwnDevice();
        if (ownDevice.getTerminalType() != 1 && ownDevice.getTerminalType() != 9) {
            return;
        }
        if (this.mIsRequestRemoteConfig) {
            StLog.d(TAG, "RequestRemoteConfig on going");
            return;
        }
        this.mIsRequestRemoteConfig = true;
        ThreadUtils.runOnWorkerThreadDelay(new a(this, context), (long) i);
    }
}
