package com.here.posclient;

import android.location.Location;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.media.session.PlaybackStateCompat;
import com.here.odnp.util.Log;
import com.here.services.common.Types;
import com.here.services.location.util.LocationHelper;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class PositionEstimate {
    private static final String EXTRA_KEY_LOCATION_TYPE = "networkLocationType";
    private static final String EXTRA_KEY_LOCATION_TYPE_VALUE_CELL = "cell";
    private static final String EXTRA_KEY_LOCATION_TYPE_VALUE_WIFI = "wifi";
    public static final String EXTRA_NO_GPS_LOCATION = "noGPSLocation";
    public static final String KEY_ACTIVITY_CONFIDENCE = "com.here.services.location:activityConfidence";
    public static final String KEY_ACTIVITY_TYPE = "com.here.services.location:activityType";
    public static final String KEY_BUILDING_ID = "com.here.services.location:buildingId";
    public static final String KEY_BUILDING_NAME = "com.here.services.location:buildingName";
    public static final String KEY_FLOOR_ID = "com.here.services.location:floorId";
    public static final String KEY_GNSS_TIME = "com.here.services.location:gnssTime";
    public static final String KEY_IS_RELIABLE_FIX = "com.here.services.location:isReliableFix";
    public static final String KEY_MEASUREMENT_ID = "com.here.services.location:measurementId";
    private static final String KEY_NAMESPACE = "com.here.services.location";
    private static final String KEY_QUICK_GPS = "QUICKGPS";
    private static final String KEY_SATELLITES = "satellites";
    public static final String KEY_SITUATION = "com.here.services.location:situation";
    public static final String KEY_SOURCE = "com.here.services.location:positionSource";
    public static final String KEY_TECHNOLOGY = "com.here.services.location:positionTechnology";
    public static final String KEY_TIME_SINCE_BOOT = "com.here.services.location:timeSinceBoot";
    public static final String KEY_WLAN_AP_COUNT = "com.here.services.location:wlanApCount";
    public static final String KEY_WLAN_AP_TIMESTAMP_SINCE_BOOT = "com.here.services.location:wlanApSinceBoot";
    public static final String KEY_WLAN_AP_TIMESTAMP_UTC = "com.here.services.location:wlanApUtc";
    private static final int MIN_SATELLITES_REQUIRED_FOR_TECH_SATELLITE = 4;
    private static final String TAG = "posclient.PositionEstimate";
    public double activityConfidence;
    public int activityType;
    public double altitude;
    public double altitudeUncertainty;
    public String buildingId;
    public String buildingName;
    public double course;
    public double courseUncertainty;
    public int floorId = 0;
    public long gnssTime;
    public long gnssUsedSatelliteCount;
    public double horizontalCepUncertainty;
    public boolean isReliableFix = true;
    public double latitude;
    public double longitude;
    public long measurementId;
    public long source = 0;
    public double speed;
    public double speedUncertainty;
    public long technology = 0;
    public long timeSinceBoot;
    public long timestamp;
    public long valueMask = 0;
    public long wlanApCount;
    public long wlanApSinceBootTimeStamp;
    public long wlanApUtcTimeStamp;

    public interface Value {
        public static final int ACTIVITY = 8388608;
        public static final int ALTITUDE = 128;
        public static final int ALTITUDE_UNCERTAINTY = 256;
        public static final int BUILDING_ID = 65536;
        public static final int BUILDING_NAME = 262144;
        public static final int COURSE = 2048;
        public static final int COURSE_UNCERTAINTY = 4096;
        public static final int FLOOR_ID = 32768;
        public static final int GNSS_TIME = 33554432;
        public static final int GNSS_USED_SATELLITE_COUNT = 16777216;
        public static final int HORIZONTAL_CEP_UNCERTAINTY = 8;
        public static final int LATITUDE = 2;
        public static final int LONGITUDE = 4;
        public static final int MEASUREMENT_ID = 131072;
        public static final int NONE = 0;
        public static final int SITUATION = 1048576;
        public static final int SOURCE = 16384;
        public static final int SPEED = 512;
        public static final int SPEED_UNCERTAINTY = 1024;
        public static final int TECHNOLOGY = 8192;
        public static final int TIMESTAMP = 1;
        public static final int TIME_SINCE_BOOT = 524288;
        public static final int WLAN_AP_COUNT = 2097152;
        public static final int WLAN_AP_TIMESTAMPS = 4194304;
    }

    public PositionEstimate() {
        Log.v(TAG, "PositionEstimate", new Object[0]);
    }

    public static void addNoGpsLocationExtras(Location location) {
        if (location != null && !LocationHelper.getTechnologies(location).contains(Types.Technology.Gnss)) {
            if (location.getExtras() == null) {
                location.setExtras(new Bundle());
            }
            location.getExtras().putParcelable(EXTRA_NO_GPS_LOCATION, new Location(location));
        }
    }

    public static PositionEstimate fromAndroidLocation(Location location) {
        return new PositionEstimate(location);
    }

    private static Bundle getExtras(Location location, PositionEstimate positionEstimate) {
        PositionEstimate positionEstimate2 = positionEstimate;
        Bundle bundle = new Bundle();
        long j = positionEstimate2.source;
        long j2 = 4;
        if ((j & 1) != 0) {
            bundle.putLong(KEY_SOURCE, 1);
        } else if ((j & 4) != 0) {
            bundle.putLong(KEY_SOURCE, 4);
        } else if ((j & 2) != 0) {
            bundle.putLong(KEY_SOURCE, 2);
        } else if ((j & 16) != 0) {
            bundle.putLong(KEY_SOURCE, 16);
        } else if ((j & 64) != 0) {
            bundle.putLong(KEY_SOURCE, 64);
        } else if ((j & 128) != 0) {
            bundle.putLong(KEY_SOURCE, 128);
        } else if ((j & 256) != 0) {
            bundle.putLong(KEY_SOURCE, 256);
        } else if ((j & 1024) != 0) {
            bundle.putLong(KEY_SOURCE, 1024);
        }
        if ((positionEstimate2.technology & 4) != 0) {
            bundle.putString(EXTRA_KEY_LOCATION_TYPE, EXTRA_KEY_LOCATION_TYPE_VALUE_CELL);
        } else {
            j2 = 0;
        }
        if ((positionEstimate2.technology & 8) != 0) {
            j2 |= 8;
            bundle.putString(EXTRA_KEY_LOCATION_TYPE, EXTRA_KEY_LOCATION_TYPE_VALUE_CELL);
        }
        if ((positionEstimate2.technology & 16) != 0) {
            j2 |= 16;
            bundle.putString(EXTRA_KEY_LOCATION_TYPE, EXTRA_KEY_LOCATION_TYPE_VALUE_CELL);
        }
        if ((positionEstimate2.technology & 1024) != 0) {
            j2 |= 1024;
            bundle.putString(EXTRA_KEY_LOCATION_TYPE, EXTRA_KEY_LOCATION_TYPE_VALUE_CELL);
        }
        if ((positionEstimate2.technology & 2048) != 0) {
            j2 |= 2048;
            bundle.putString(EXTRA_KEY_LOCATION_TYPE, EXTRA_KEY_LOCATION_TYPE_VALUE_CELL);
        }
        if ((positionEstimate2.technology & 4096) != 0) {
            j2 |= 4096;
            bundle.putString(EXTRA_KEY_LOCATION_TYPE, EXTRA_KEY_LOCATION_TYPE_VALUE_CELL);
        }
        if ((positionEstimate2.technology & 2) != 0) {
            j2 |= 2;
            bundle.putString(EXTRA_KEY_LOCATION_TYPE, EXTRA_KEY_LOCATION_TYPE_VALUE_WIFI);
        }
        long j3 = positionEstimate2.technology;
        if ((j3 & 256) != 0) {
            j2 |= 256;
        }
        if ((j3 & 1) != 0) {
            j2 |= 1;
        }
        bundle.putLong(KEY_TECHNOLOGY, j2);
        if (positionEstimate2.isValueSet(65536)) {
            bundle.putString(KEY_BUILDING_ID, positionEstimate2.buildingId);
        }
        if (positionEstimate2.isValueSet(32768)) {
            bundle.putInt(KEY_FLOOR_ID, positionEstimate2.floorId);
        }
        if (positionEstimate2.isValueSet(Value.TIME_SINCE_BOOT)) {
            bundle.putLong(KEY_TIME_SINCE_BOOT, positionEstimate2.timeSinceBoot);
        }
        if (positionEstimate2.isValueSet(131072)) {
            bundle.putLong("com.here.services.location:measurementId", positionEstimate2.measurementId);
        }
        if (positionEstimate2.isValueSet(Value.BUILDING_NAME)) {
            bundle.putString(KEY_BUILDING_NAME, positionEstimate2.buildingName);
        }
        if (positionEstimate2.isValueSet(Value.WLAN_AP_COUNT)) {
            bundle.putLong(KEY_WLAN_AP_COUNT, positionEstimate2.wlanApCount);
        }
        if (positionEstimate2.isValueSet(Value.WLAN_AP_TIMESTAMPS)) {
            bundle.putLong(KEY_WLAN_AP_TIMESTAMP_UTC, positionEstimate2.wlanApUtcTimeStamp);
            bundle.putLong(KEY_WLAN_AP_TIMESTAMP_SINCE_BOOT, positionEstimate2.wlanApSinceBootTimeStamp);
        }
        if (positionEstimate2.isValueSet(Value.ACTIVITY)) {
            bundle.putInt(KEY_ACTIVITY_TYPE, positionEstimate2.activityType);
            bundle.putDouble(KEY_ACTIVITY_CONFIDENCE, positionEstimate2.activityConfidence);
        }
        bundle.putBoolean(KEY_IS_RELIABLE_FIX, positionEstimate2.isReliableFix);
        if (positionEstimate2.isValueSet(Value.GNSS_TIME)) {
            bundle.putLong(KEY_GNSS_TIME, positionEstimate2.gnssTime);
        }
        return bundle;
    }

    private boolean isValueSet(int i) {
        return (((long) i) & this.valueMask) != 0;
    }

    public static Location toAndroidLocation(PositionEstimate positionEstimate) {
        if (positionEstimate == null) {
            return null;
        }
        Location location = new Location("network");
        if (positionEstimate.isValueSet(2)) {
            location.setLatitude(positionEstimate.latitude);
            if (positionEstimate.isValueSet(4)) {
                location.setLongitude(positionEstimate.longitude);
                if (positionEstimate.isValueSet(8)) {
                    location.setAccuracy((float) positionEstimate.horizontalCepUncertainty);
                    if (positionEstimate.isValueSet(1)) {
                        location.setTime(positionEstimate.timestamp);
                    }
                    if (positionEstimate.isValueSet(128)) {
                        location.setAltitude(positionEstimate.altitude);
                    }
                    if ((positionEstimate.source & 1) == 0 && positionEstimate.isValueSet(Value.TIME_SINCE_BOOT)) {
                        location.setElapsedRealtimeNanos(TimeUnit.MILLISECONDS.toNanos(positionEstimate.timeSinceBoot));
                    } else if (positionEstimate.isValueSet(1)) {
                        Log.w(TAG, "estimating timeSinceBoot using timeStamp", new Object[0]);
                        long elapsedRealtime = SystemClock.elapsedRealtime();
                        location.setElapsedRealtimeNanos(TimeUnit.MILLISECONDS.toNanos(Math.min(Math.max(elapsedRealtime - (System.currentTimeMillis() - positionEstimate.timestamp), 0), elapsedRealtime)));
                    } else {
                        Log.w(TAG, "setting timeSinceBoot to current time", new Object[0]);
                        location.setElapsedRealtimeNanos(SystemClock.elapsedRealtimeNanos());
                    }
                    if (positionEstimate.isValueSet(512)) {
                        location.setSpeed((float) positionEstimate.speed);
                    }
                    if (positionEstimate.isValueSet(2048)) {
                        double d = positionEstimate.course;
                        if (d < 0.0d) {
                            d += 360.0d;
                        }
                        location.setBearing((float) d);
                    }
                    if (positionEstimate.isValueSet(1024)) {
                        location.setSpeedAccuracyMetersPerSecond((float) positionEstimate.speedUncertainty);
                    }
                    if (positionEstimate.isValueSet(4096)) {
                        location.setBearingAccuracyDegrees((float) positionEstimate.courseUncertainty);
                    }
                    if (positionEstimate.isValueSet(256)) {
                        location.setVerticalAccuracyMeters((float) positionEstimate.altitudeUncertainty);
                    }
                    location.setExtras(getExtras(location, positionEstimate));
                    return location;
                }
            }
        }
        return null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PositionEstimate[");
        Locale locale = Locale.US;
        sb.append(String.format(locale, "%.7f,%.7f", new Object[]{Double.valueOf(this.latitude), Double.valueOf(this.longitude)}));
        sb.append(String.format(locale, " acc=%.2f", new Object[]{Double.valueOf(this.horizontalCepUncertainty)}));
        if (this.timestamp == 0) {
            sb.append(" ts=?!?");
        } else {
            sb.append(" ts=");
            sb.append(this.timestamp);
            sb.append("ms");
        }
        if (this.timeSinceBoot == 0) {
            sb.append(" tsb=?!?");
        } else {
            sb.append(" tsb=");
            sb.append(this.timeSinceBoot);
            sb.append("ms");
        }
        String str = this.buildingId;
        if (str != null) {
            sb.append(String.format(" bldngId=%s", new Object[]{str}));
            int i = this.floorId;
            if (i > 0) {
                sb.append(String.format(locale, " flrId=%d", new Object[]{Integer.valueOf(i)}));
            }
        }
        sb.append(']');
        return sb.toString();
    }

    private PositionEstimate(Location location) {
        Log.v(TAG, "PositionEstimate", new Object[0]);
        if (location == null) {
            Log.w(TAG, "PositionEstimate: location is null", new Object[0]);
            return;
        }
        this.timeSinceBoot = TimeUnit.NANOSECONDS.toMillis(location.getElapsedRealtimeNanos());
        this.timeSinceBoot = Math.min(SystemClock.elapsedRealtime(), this.timeSinceBoot);
        long currentTimeMillis = System.currentTimeMillis();
        long j = this.timeSinceBoot;
        if (j == 0) {
            this.timestamp = Math.min(location.getTime(), currentTimeMillis);
            this.timeSinceBoot = SystemClock.elapsedRealtime();
        } else {
            this.timestamp = (currentTimeMillis + j) - SystemClock.elapsedRealtime();
        }
        this.valueMask = 524289;
        if ("gps".equals(location.getProvider())) {
            this.gnssTime = location.getTime();
            this.valueMask |= 33554432;
        }
        this.longitude = location.getLongitude();
        this.valueMask |= 4;
        this.latitude = location.getLatitude();
        this.valueMask |= 2;
        if (location.hasAccuracy()) {
            this.horizontalCepUncertainty = (double) location.getAccuracy();
            this.valueMask |= 8;
        }
        if (location.hasAltitude()) {
            this.altitude = location.getAltitude();
            this.valueMask |= 128;
        }
        if (location.hasSpeed()) {
            this.speed = (double) location.getSpeed();
            this.valueMask |= 512;
        }
        if (location.hasBearing()) {
            double bearing = (double) (location.getBearing() > 180.0f ? location.getBearing() - 360.0f : location.getBearing());
            this.course = bearing;
            Log.v(TAG, "PositionEstimate: course: %.1f", Double.valueOf(bearing));
            this.valueMask |= 2048;
        }
        if (location.hasVerticalAccuracy()) {
            this.altitudeUncertainty = (double) location.getVerticalAccuracyMeters();
            this.valueMask |= 256;
        }
        if (location.hasBearingAccuracy()) {
            double bearingAccuracyDegrees = (double) location.getBearingAccuracyDegrees();
            this.courseUncertainty = bearingAccuracyDegrees;
            Log.v(TAG, "PositionEstimate: courseUncertainty: %.1f", Double.valueOf(bearingAccuracyDegrees));
            this.valueMask |= 4096;
        }
        if (location.hasSpeedAccuracy()) {
            double speedAccuracyMetersPerSecond = (double) location.getSpeedAccuracyMetersPerSecond();
            this.speedUncertainty = speedAccuracyMetersPerSecond;
            Log.v(TAG, "PositionEstimate: speedUncertainty: %.1f", Double.valueOf(speedAccuracyMetersPerSecond));
            this.valueMask |= 1024;
        }
        if ("gps".equals(location.getProvider())) {
            this.technology = 1;
            this.valueMask |= 8192;
            Bundle extras = location.getExtras();
            if (extras != null) {
                int i = extras.getInt(KEY_SATELLITES, -1);
                if (i >= 0) {
                    this.gnssUsedSatelliteCount = (long) i;
                    this.valueMask |= 16777216;
                }
                if (this.gnssUsedSatelliteCount >= 4) {
                    Log.v(TAG, "PositionEstimate: Adding technology SATELLITES", new Object[0]);
                    this.technology |= 32768;
                }
            }
        } else if ("network".equals(location.getProvider())) {
            this.technology = 6;
            this.valueMask |= 8192;
        }
        Bundle extras2 = location.getExtras();
        if (extras2 != null && extras2.containsKey("com.here.services.location:measurementId")) {
            this.measurementId = extras2.getLong("com.here.services.location:measurementId");
            this.valueMask |= PlaybackStateCompat.ACTION_PREPARE_FROM_URI;
        }
    }
}
