package com.here.services.radiomap.internal;

import com.here.odnp.util.Log;

public class Utility {
    private static final double EARTH_ECCENTRICITY = 0.08181919092890624d;
    private static final double EARTH_MAJOR = 6378137.0d;
    private static final double EPSILON = 1.0E-19d;
    private static final String TAG = "services.radiomap.internal.Utility";

    public static class MeterInDegrees {
        public double se = 0.0d;
        public double sn = 0.0d;
    }

    private static boolean isClose(double d, double d2) {
        return Math.abs(d - d2) < EPSILON;
    }

    public static MeterInDegrees meterInDegrees(double d) {
        double d2 = (d * 3.141592653589793d) / 180.0d;
        if (isClose(d2, 1.5707963267948966d) || isClose(d2, -1.5707963267948966d)) {
            Log.e(TAG, "meterInDegrees: ERROR: latitude at Pole", new Object[0]);
            return null;
        }
        double sqrt = Math.sqrt(1.0d - ((Math.sin(d2) * 0.006694380004260814d) * Math.sin(d2)));
        MeterInDegrees meterInDegrees = new MeterInDegrees();
        double d3 = 57.29577951308232d * sqrt;
        meterInDegrees.sn = d3 * sqrt * sqrt * 1.578422502929283E-7d;
        meterInDegrees.se = d3 * (1.0d / (Math.cos(d2) * EARTH_MAJOR));
        return meterInDegrees;
    }
}
