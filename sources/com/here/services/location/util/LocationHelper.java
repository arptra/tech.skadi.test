package com.here.services.location.util;

import android.location.Location;
import android.os.Bundle;
import com.here.posclient.UpdateOptions;
import com.here.services.common.Types;
import java.util.EnumSet;

public class LocationHelper {
    private static final String KEY_ACTIVITY_CONFIDENCE = "com.here.services.location:activityConfidence";
    private static final String KEY_ACTIVITY_TYPE = "com.here.services.location:activityType";
    private static final String KEY_BUILDING_ID = "com.here.services.location:buildingId";
    private static final String KEY_BUILDING_NAME = "com.here.services.location:buildingName";
    private static final String KEY_FLOOR_ID = "com.here.services.location:floorId";
    private static final String KEY_GNSS_TIME = "com.here.services.location:gnssTime";
    private static final String KEY_IS_RELIABLE_FIX = "com.here.services.location:isReliableFix";
    private static final String KEY_MEASUREMENT_ID = "com.here.services.location:measurementId";
    private static final String KEY_SITUATION = "com.here.services.location:situation";
    private static final String KEY_SOURCE = "com.here.services.location:positionSource";
    private static final String KEY_TECHNOLOGY = "com.here.services.location:positionTechnology";
    private static final String KEY_TIME_SINCE_BOOT = "com.here.services.location:timeSinceBoot";
    private static final String KEY_WLAN_AP_COUNT = "com.here.services.location:wlanApCount";
    private static final String KEY_WLAN_AP_TIMESTAMP_SINCE_BOOT = "com.here.services.location:wlanApSinceBoot";
    private static final String KEY_WLAN_AP_TIMESTAMP_UTC = "com.here.services.location:wlanApUtc";
    private static final long SOURCE_UNSPECIFIED = 0;
    private static final long TECHNOLOGY_UNSPECIFIED = 0;

    public static Integer getActivity(Location location) {
        if (location != null) {
            Bundle extras = location.getExtras();
            if (extras == null || !extras.containsKey("com.here.services.location:activityType")) {
                return null;
            }
            return Integer.valueOf(extras.getInt("com.here.services.location:activityType"));
        }
        throw new IllegalArgumentException();
    }

    public static Double getActivityConfidence(Location location) {
        if (location != null) {
            Bundle extras = location.getExtras();
            if (extras == null || !extras.containsKey("com.here.services.location:activityConfidence")) {
                return null;
            }
            return Double.valueOf(extras.getDouble("com.here.services.location:activityConfidence"));
        }
        throw new IllegalArgumentException();
    }

    public static String getBuildingId(Location location) {
        if (location != null) {
            Bundle extras = location.getExtras();
            if (extras == null) {
                return null;
            }
            return extras.getString("com.here.services.location:buildingId");
        }
        throw new IllegalArgumentException();
    }

    public static String getBuildingName(Location location) {
        if (location != null) {
            Bundle extras = location.getExtras();
            if (extras == null || !extras.containsKey("com.here.services.location:buildingName")) {
                return null;
            }
            return extras.getString("com.here.services.location:buildingName");
        }
        throw new IllegalArgumentException();
    }

    public static Boolean getFixReliability(Location location) {
        if (location != null) {
            Bundle extras = location.getExtras();
            boolean z = true;
            if (extras != null) {
                z = extras.getBoolean("com.here.services.location:isReliableFix", true);
            }
            return Boolean.valueOf(z);
        }
        throw new IllegalArgumentException();
    }

    public static Integer getFloorId(Location location) {
        if (location != null) {
            Bundle extras = location.getExtras();
            if (extras == null || !extras.containsKey("com.here.services.location:floorId")) {
                return null;
            }
            return Integer.valueOf(extras.getInt("com.here.services.location:floorId"));
        }
        throw new IllegalArgumentException();
    }

    public static Long getGnssTime(Location location) {
        if (location != null) {
            Bundle extras = location.getExtras();
            if (extras == null || !extras.containsKey("com.here.services.location:gnssTime")) {
                return null;
            }
            return Long.valueOf(extras.getLong("com.here.services.location:gnssTime"));
        }
        throw new IllegalArgumentException();
    }

    public static Long getMeasurementId(Location location) {
        if (location != null) {
            Bundle extras = location.getExtras();
            if (extras == null || !extras.containsKey("com.here.services.location:measurementId")) {
                return null;
            }
            return Long.valueOf(extras.getLong("com.here.services.location:measurementId"));
        }
        throw new IllegalArgumentException();
    }

    public static EnumSet<Types.Source> getSources(Location location) {
        if (location != null) {
            Bundle extras = location.getExtras();
            return UpdateOptions.getSourceSet(extras != null ? extras.getLong("com.here.services.location:positionSource") : 0);
        }
        throw new IllegalArgumentException("location is null");
    }

    public static EnumSet<Types.Technology> getTechnologies(Location location) {
        if (location != null) {
            Bundle extras = location.getExtras();
            return UpdateOptions.getTechnologySet(extras != null ? extras.getLong("com.here.services.location:positionTechnology") : 0);
        }
        throw new IllegalArgumentException("location is null");
    }

    public static Long getTimeSinceBoot(Location location) {
        if (location != null) {
            Bundle extras = location.getExtras();
            if (extras == null || !extras.containsKey("com.here.services.location:timeSinceBoot")) {
                return null;
            }
            return Long.valueOf(extras.getLong("com.here.services.location:timeSinceBoot"));
        }
        throw new IllegalArgumentException();
    }

    public static Long getWlanApCount(Location location) {
        if (location != null) {
            Bundle extras = location.getExtras();
            if (extras == null || !extras.containsKey("com.here.services.location:wlanApCount")) {
                return null;
            }
            return Long.valueOf(extras.getLong("com.here.services.location:wlanApCount"));
        }
        throw new IllegalArgumentException();
    }

    public static Long getWlanApSinceBootTimeStamp(Location location) {
        if (location != null) {
            Bundle extras = location.getExtras();
            if (extras == null || !extras.containsKey("com.here.services.location:wlanApSinceBoot")) {
                return null;
            }
            return Long.valueOf(extras.getLong("com.here.services.location:wlanApSinceBoot"));
        }
        throw new IllegalArgumentException();
    }

    public static Long getWlanApUtcTimeStamp(Location location) {
        if (location != null) {
            Bundle extras = location.getExtras();
            if (extras == null || !extras.containsKey("com.here.services.location:wlanApUtc")) {
                return null;
            }
            return Long.valueOf(extras.getLong("com.here.services.location:wlanApUtc"));
        }
        throw new IllegalArgumentException();
    }
}
