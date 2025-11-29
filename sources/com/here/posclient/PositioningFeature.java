package com.here.posclient;

import android.support.v4.media.session.PlaybackStateCompat;
import java.util.HashSet;
import java.util.Set;

public enum PositioningFeature {
    None(0),
    Offline(1),
    Online(2),
    Cache(4),
    Learning(16),
    Collector(256),
    ActiveStorage(512),
    RadioMapDownload(1024),
    RadioMapDownloadApi(2048),
    SensorFusion(4096),
    HDWifiCollector(8192),
    HDWifiPositioning(16384),
    HDGnssPositioning(32768),
    RemoteConfiguration(PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH),
    All(UpdateOptions.SOURCE_ANY);
    
    public final long value;

    private PositioningFeature(long j) {
        this.value = j;
    }

    public static Set<PositioningFeature> fromMask(long j) {
        HashSet hashSet = new HashSet();
        for (PositioningFeature positioningFeature : values()) {
            if ((((long) ((int) positioningFeature.value)) & j) != 0) {
                hashSet.add(positioningFeature);
            }
        }
        return hashSet;
    }

    public static boolean isFeatureSet(long j, PositioningFeature positioningFeature) {
        long j2 = positioningFeature.value;
        return (j & j2) == j2;
    }
}
