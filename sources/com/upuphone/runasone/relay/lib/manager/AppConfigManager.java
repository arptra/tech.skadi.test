package com.upuphone.runasone.relay.lib.manager;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.honey.account.i6.a;
import com.upuphone.ar.fastrecord.phone.ui.activity.FastRecordHistoryDetailActivity;
import com.upuphone.runasone.relay.lib.BuildConfig;
import com.upuphone.runasone.relay.lib.application.RelayApplication;
import com.upuphone.runasone.relay.lib.utils.LogUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiConsumer;

public class AppConfigManager {
    public static final int ADD_CODE = 1;
    private static final String META_DATA_KEY = "app_unite_code";
    public static final int REMOVE_CODE = 2;
    private static AppConfigManager manager = new AppConfigManager();
    private static int mapCodeNum = 1;
    private Set<BiConsumer<Integer, Map<String, Integer>>> callbackList = Collections.synchronizedSet(new LinkedHashSet());
    private ConcurrentHashMap<Integer, String> codeMap = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, MetaBean> metaInfo = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, Integer> metaMap = new ConcurrentHashMap<>();

    private AppConfigManager() {
    }

    public static AppConfigManager getInstance() {
        return manager;
    }

    private int getMapCodeNum() {
        if (mapCodeNum == Integer.MAX_VALUE) {
            mapCodeNum = 1;
        }
        while (this.metaMap.contains(Integer.valueOf(mapCodeNum))) {
            mapCodeNum++;
        }
        return mapCodeNum;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$addAppUnitCode$0(String str, MetaBean metaBean) {
        if (this.metaInfo.putIfAbsent(metaBean.getAppUniteCode(), metaBean) == null) {
            this.metaInfo.put(str, metaBean);
            this.metaMap.put(str, Integer.valueOf(metaBean.getMapCode()));
            this.codeMap.put(Integer.valueOf(metaBean.getMapCode()), str);
            LogUtil.dPrimary("AppConfigManager", metaBean.getMapCode() + FastRecordHistoryDetailActivity.TAG_SPLIT + str);
        }
    }

    private HashMap<String, MetaBean> parserMeta(String str, String str2) {
        if (str == null) {
            return null;
        }
        MetaBean metaBean = new MetaBean();
        metaBean.setAppUniteCode(str);
        metaBean.setPackageName(str2);
        metaBean.setMapCode(getMapCodeNum());
        HashMap<String, MetaBean> hashMap = new HashMap<>();
        hashMap.put(str, metaBean);
        return hashMap;
    }

    public void addAppChangeCall(BiConsumer<Integer, Map<String, Integer>> biConsumer) {
        this.callbackList.add(biConsumer);
    }

    public void addAppUnitCode(Map<String, MetaBean> map, boolean z) {
        if (map != null && map.size() != 0) {
            if (z) {
                HashMap hashMap = new HashMap();
                for (MetaBean next : map.values()) {
                    if (this.metaInfo.putIfAbsent(next.getAppUniteCode(), next) == null) {
                        hashMap.put(next.getAppUniteCode(), Integer.valueOf(next.getMapCode()));
                        this.metaMap.put(next.getAppUniteCode(), Integer.valueOf(next.getMapCode()));
                        this.codeMap.put(Integer.valueOf(next.getMapCode()), next.getAppUniteCode());
                    }
                }
                if (hashMap.size() > 0) {
                    for (BiConsumer<Integer, Map<String, Integer>> accept : this.callbackList) {
                        accept.accept(1, hashMap);
                    }
                }
                RelayApplication.updateRelayAbility();
                return;
            }
            map.forEach(new a(this));
        }
    }

    public void getAllMetaData(Context context) {
        if (!BuildConfig.IS_THIRD.booleanValue()) {
            PackageManager packageManager = context.getPackageManager();
            for (PackageInfo metaDataByPackageInfo : packageManager.getInstalledPackages(0)) {
                addAppUnitCode(getMetaDataByPackageInfo(context, packageManager, metaDataByPackageInfo), false);
            }
        }
    }

    public List<String> getAppUnitCodeList() {
        return new ArrayList(this.metaInfo.keySet());
    }

    public ConcurrentHashMap<Integer, String> getCodeMap() {
        return this.codeMap;
    }

    public HashMap<String, MetaBean> getMetaDataByPackageInfo(Context context, PackageManager packageManager, PackageInfo packageInfo) {
        String str = packageInfo.packageName;
        if (str == null) {
            return null;
        }
        try {
            Bundle bundle = packageManager.getApplicationInfo(str, 128).metaData;
            if (bundle != null) {
                return parserMeta(bundle.getString(META_DATA_KEY), packageInfo.packageName);
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ConcurrentHashMap<String, MetaBean> getMetaInfo() {
        return this.metaInfo;
    }

    public ConcurrentHashMap<String, Integer> getMetaMap() {
        return this.metaMap;
    }

    public String getPackageName(String str) {
        MetaBean metaBean = this.metaInfo.get(str);
        if (metaBean != null) {
            return metaBean.getPackageName();
        }
        return null;
    }

    public String getReceiveAUC(int i) {
        return this.codeMap.get(Integer.valueOf(i));
    }

    public int getSendMappingCode(String str) {
        Integer num = this.metaMap.get(str);
        if (num != null) {
            return num.intValue();
        }
        return -1;
    }

    public boolean hasAppUniteCode(String str) {
        return this.metaInfo.get(str) != null;
    }

    public void removeAppChangeCall(BiConsumer<Integer, Set<String>> biConsumer) {
        this.callbackList.remove(biConsumer);
    }

    public boolean removeAppUnitCode(String str) {
        if (this.metaInfo.get(str) == null) {
            return false;
        }
        this.metaInfo.remove(str);
        Integer remove = this.metaMap.remove(str);
        if (remove == null) {
            return true;
        }
        this.codeMap.remove(remove);
        return true;
    }

    public void removeAppUnitCodeByPkgName(String str) {
        HashMap hashMap = new HashMap();
        for (MetaBean next : this.metaInfo.values()) {
            if (next != null && str != null && str.equals(next.getPackageName()) && removeAppUnitCode(next.getAppUniteCode())) {
                hashMap.put(next.getAppUniteCode(), Integer.valueOf(next.getMapCode()));
            }
        }
        RelayApplication.updateRelayAbility();
        if (hashMap.size() > 0) {
            for (BiConsumer<Integer, Map<String, Integer>> accept : this.callbackList) {
                accept.accept(2, hashMap);
            }
        }
    }
}
