package com.upuphone.starrynet.tracker.reporter;

import android.app.Application;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.meizu.personal.info.IPersonalInfoListener;
import com.meizu.personal.info.PersonalInfoHelper;
import com.meizu.statsapp.v3.InitConfig;
import com.meizu.statsapp.v3.PkgType;
import com.meizu.statsapp.v3.UsageStatsProxy3;
import com.upuphone.starrynet.tracker.TrackerConfig;
import java.util.HashMap;
import java.util.Map;

public class SelfPhoneReporter implements IReporter {
    /* access modifiers changed from: private */
    public TrackerConfig config;

    private Map<String, String> convertProperties(Map<String, Object> map) {
        if (map == null || map.isEmpty()) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (Map.Entry next : map.entrySet()) {
            hashMap.put((String) next.getKey(), String.valueOf(next.getValue()));
        }
        return hashMap;
    }

    private void initPersonalInfo() {
        PersonalInfoHelper.setPersonalInfoListener(new IPersonalInfoListener() {
            public Object onOutputInfo(int i) {
                if (i != 2) {
                    return null;
                }
                return SelfPhoneReporter.this.config.getOwnDeviceID();
            }
        });
    }

    public boolean init(Context context, TrackerConfig trackerConfig) {
        this.config = trackerConfig;
        InitConfig initConfig = new InitConfig();
        initConfig.setOffline(true);
        initPersonalInfo();
        UsageStatsProxy3.init((Application) context, PkgType.APP, "0OFAAUAZ4FELEK2CCVEW9F35", initConfig);
        return true;
    }

    public boolean report3rdEvent(@NonNull String str, @Nullable Map<String, Object> map, String str2, String str3, String str4) {
        return false;
    }

    public boolean reportEvent(@NonNull String str, @Nullable Map<String, Object> map) {
        UsageStatsProxy3.getInstance().onEvent(str, "自研手机", convertProperties(map));
        return true;
    }

    public boolean reportEventRealtime(@NonNull String str, @Nullable Map<String, Object> map) {
        UsageStatsProxy3.getInstance().onEventRealtime(str, "自研手机", convertProperties(map));
        return true;
    }
}
