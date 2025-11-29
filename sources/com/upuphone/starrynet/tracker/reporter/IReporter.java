package com.upuphone.starrynet.tracker.reporter;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.upuphone.starrynet.tracker.TrackerConfig;
import java.util.Map;

public interface IReporter {
    boolean init(Context context, TrackerConfig trackerConfig);

    boolean report3rdEvent(@NonNull String str, @Nullable Map<String, Object> map, String str2, String str3, String str4);

    boolean reportEvent(@NonNull String str, @Nullable Map<String, Object> map);

    boolean reportEventRealtime(@NonNull String str, @Nullable Map<String, Object> map);
}
