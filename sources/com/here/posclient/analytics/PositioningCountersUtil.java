package com.here.posclient.analytics;

import android.os.Bundle;
import com.here.odnp.util.Log;

public class PositioningCountersUtil {
    static final String POS_MODE_HYBRID = "hybrid";
    static final String POS_MODE_OFFLINE = "offline";
    static final String POS_MODE_ONLINE = "online";
    static final String POS_NAMESPACE = "positioning";
    static final String POS_RM_CATEGORY_OUTDOOR = "outdoor";
    static final String POS_RM_NAMESPACE_DEMAND = "odnp_rm_demand";
    static final String POS_RM_NAMESPACE_MANUAL = "odnp_rm_manual";
    static final String POS_RM_VALUE_DOWNLOADS = "downloadCount";
    static final String POS_RM_VALUE_DOWNLOAD_SIZE = "downloadFileSize";
    static final String POS_RM_VALUE_ERRORS = "errors";
    static final String POS_SEPARATOR = "-";
    static final String POS_SESSION_OUTDOOR = "outdoor";
    static final String POS_VALUE_BUILDING_AWARE = "buildingAwareCount";
    static final String POS_VALUE_CELL_BASED = "cellBasedCount";
    static final String POS_VALUE_ERRORS = "errorCount";
    static final String POS_VALUE_ESTIMATES = "estimates";
    static final String POS_VALUE_EXTERNALS = "externals";
    static final String POS_VALUE_FALLBACKS = "fallbacks";
    static final String POS_VALUE_FLOOR_AWARE = "floorAwareCount";
    static final String POS_VALUE_ONLINES = "onlineCount";
    static final String POS_VALUE_UPDATES = "updates";
    static final String POS_VALUE_WLAN_BASED = "wlanBasedCount";
    private static final String TAG = "posclient.analytics.PositioningCountersUtil";

    public static Bundle convertToAnalyticsBundle(RadiomapCounters radiomapCounters) {
        Bundle bundle = new Bundle();
        long j = radiomapCounters.errors;
        if (j > 0) {
            bundle.putLong(POS_RM_VALUE_ERRORS, j);
        }
        long j2 = radiomapCounters.downloadCount;
        if (j2 > 0) {
            bundle.putLong(POS_RM_VALUE_DOWNLOADS, j2);
        }
        long j3 = radiomapCounters.downloadFileSize;
        if (j3 > 0) {
            bundle.putLong(POS_RM_VALUE_DOWNLOAD_SIZE, j3);
        }
        return bundle;
    }

    public static String getSessionName(RadiomapCounters radiomapCounters) {
        if (radiomapCounters == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        int i = radiomapCounters.event;
        if (i == 211) {
            sb.append(POS_RM_NAMESPACE_DEMAND);
            sb.append("-");
            sb.append("outdoor");
        } else if (i != 221) {
            Log.e(TAG, "getSessionName: unknown rm event type: %d", Integer.valueOf(i));
            return null;
        } else {
            sb.append(POS_RM_NAMESPACE_MANUAL);
            sb.append("-");
            sb.append("outdoor");
        }
        return sb.toString();
    }

    public static Bundle convertToAnalyticsBundle(PositioningCounters positioningCounters) {
        if (positioningCounters == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        long j = positioningCounters.updates;
        if (j > 0) {
            bundle.putLong(POS_VALUE_UPDATES, j);
        }
        long j2 = positioningCounters.updateErrors;
        if (j2 > 0) {
            bundle.putLong(POS_VALUE_ERRORS, j2);
        }
        long j3 = positioningCounters.fallbacks;
        if (j3 > 0) {
            bundle.putLong(POS_VALUE_FALLBACKS, j3);
        }
        long j4 = positioningCounters.estimates;
        if (j4 > 0) {
            bundle.putLong(POS_VALUE_ESTIMATES, j4);
        }
        long j5 = positioningCounters.externals;
        if (j5 > 0) {
            bundle.putLong(POS_VALUE_EXTERNALS, j5);
        }
        long j6 = positioningCounters.withBuilding;
        if (j6 > 0) {
            bundle.putLong(POS_VALUE_BUILDING_AWARE, j6);
        }
        long j7 = positioningCounters.withFloor;
        if (j7 > 0) {
            bundle.putLong(POS_VALUE_FLOOR_AWARE, j7);
        }
        long j8 = positioningCounters.byCell;
        if (j8 > 0) {
            bundle.putLong(POS_VALUE_CELL_BASED, j8);
        }
        long j9 = positioningCounters.byWlan;
        if (j9 > 0) {
            bundle.putLong(POS_VALUE_WLAN_BASED, j9);
        }
        long j10 = positioningCounters.onlines;
        if (j10 > 0) {
            bundle.putLong(POS_VALUE_ONLINES, j10);
        }
        return bundle;
    }

    public static String getSessionName(PositioningCounters positioningCounters) {
        if (positioningCounters == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(POS_NAMESPACE);
        sb.append("-");
        int i = positioningCounters.event;
        if (i == 111) {
            sb.append(POS_MODE_ONLINE);
            sb.append("-");
            sb.append("outdoor");
        } else if (i == 121) {
            sb.append(POS_MODE_HYBRID);
            sb.append("-");
            sb.append("outdoor");
        } else if (i != 131) {
            Log.e(TAG, "getSessionName: unknown pos event type: %d", Integer.valueOf(i));
            return null;
        } else {
            sb.append(POS_MODE_OFFLINE);
            sb.append("-");
            sb.append("outdoor");
        }
        return sb.toString();
    }
}
