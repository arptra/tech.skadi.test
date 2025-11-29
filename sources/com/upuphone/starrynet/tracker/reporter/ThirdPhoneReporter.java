package com.upuphone.starrynet.tracker.reporter;

import android.app.Application;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.upuphone.datatrack.sdk.XJDataTrack;
import com.upuphone.starrynet.tracker.TrackerConfig;
import java.util.Map;

public class ThirdPhoneReporter implements IReporter {
    public boolean init(Context context, TrackerConfig trackerConfig) {
        XJDataTrack.i(6, (Application) context, "StarryNet", trackerConfig.isDebug());
        return true;
    }

    public boolean report3rdEvent(@NonNull String str, @Nullable Map<String, Object> map, String str2, String str3, String str4) {
        XJDataTrack.h().l(str, map, str2, str3, str4);
        return true;
    }

    public boolean reportEvent(@NonNull String str, @Nullable Map<String, Object> map) {
        XJDataTrack.h().k(str, map);
        return true;
    }

    public boolean reportEventRealtime(@NonNull String str, @Nullable Map<String, Object> map) {
        XJDataTrack.h().k(str, map);
        return true;
    }
}
