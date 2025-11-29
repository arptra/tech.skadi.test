package com.here.odnp.config;

import android.location.Criteria;
import com.here.odnp.util.Log;

public final class OdnpProviderCriteria {
    private static final String TAG = "odnp.config.OdnpProviderCriteria";

    public static int getAccuracy() {
        Log.v(TAG, "getAccuracy: %d", 2);
        return 2;
    }

    public static int getPowerRequirement() {
        Log.v(TAG, "getPowerRequirement: %d", 1);
        return 1;
    }

    public static boolean hasMonetaryCost() {
        Log.v(TAG, "hasMonetaryCost: %b", Boolean.FALSE);
        return false;
    }

    public static boolean meetsCriteria(Criteria criteria) {
        if (criteria.isAltitudeRequired() && !supportsAltitude()) {
            return false;
        }
        if (criteria.isSpeedRequired() && !supportsSpeed()) {
            return false;
        }
        if (criteria.isBearingRequired() && !supportsBearing()) {
            return false;
        }
        if (criteria.getHorizontalAccuracy() == 0 || criteria.getAccuracy() >= getAccuracy()) {
            return criteria.getPowerRequirement() == 0 || criteria.getPowerRequirement() >= getPowerRequirement();
        }
        return false;
    }

    public static boolean requiresCell() {
        Log.v(TAG, "requiresCell: %b", Boolean.FALSE);
        return false;
    }

    public static boolean requiresNetwork() {
        Log.v(TAG, "requiresNetwork: %b", Boolean.FALSE);
        return false;
    }

    public static boolean requiresSatellite() {
        Log.v(TAG, "requiresSatellite: %b", Boolean.FALSE);
        return false;
    }

    public static boolean supportsAltitude() {
        Log.v(TAG, "supportsAltitude: %b", Boolean.FALSE);
        return false;
    }

    public static boolean supportsBearing() {
        Log.v(TAG, "supportsBearing: %b", Boolean.FALSE);
        return false;
    }

    public static boolean supportsSpeed() {
        Log.v(TAG, "supportsSpeed: %b", Boolean.FALSE);
        return false;
    }
}
