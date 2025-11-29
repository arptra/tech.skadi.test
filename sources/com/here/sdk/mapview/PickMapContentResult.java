package com.here.sdk.mapview;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.here.NativeBase;
import com.here.sdk.core.GeoCoordinates;
import com.here.sdk.core.LocalizedText;
import com.here.sdk.traffic.TrafficIncidentBase;
import com.here.sdk.traffic.TrafficIncidentImpact;
import com.here.sdk.traffic.TrafficIncidentType;
import java.util.Date;
import java.util.List;

public final class PickMapContentResult extends NativeBase {

    public static final class PoiResult {
        @NonNull
        public GeoCoordinates coordinates;
        @NonNull
        public String name;
        @NonNull
        public String offlineSearchId;
        @NonNull
        public String placeCategoryId;

        public PoiResult(@NonNull String str, @NonNull GeoCoordinates geoCoordinates, @NonNull String str2, @NonNull String str3) {
            this.name = str;
            this.coordinates = geoCoordinates;
            this.placeCategoryId = str2;
            this.offlineSearchId = str3;
        }
    }

    public static final class TrafficIncidentResult extends NativeBase implements TrafficIncidentBase {
        public TrafficIncidentResult(long j, Object obj) {
            super(j, new NativeBase.Disposer() {
                public void disposeNative(long j) {
                    TrafficIncidentResult.disposeNativeHandle(j);
                }
            });
        }

        /* access modifiers changed from: private */
        public static native void disposeNativeHandle(long j);

        @NonNull
        public native GeoCoordinates getCoordinates();

        @NonNull
        public native LocalizedText getDescription();

        @Nullable
        public native Date getEndTime();

        @NonNull
        public native TrafficIncidentImpact getImpact();

        @NonNull
        public native String getOriginalId();

        @Nullable
        public native Date getStartTime();

        @NonNull
        public native TrafficIncidentType getType();
    }

    public static final class VehicleRestrictionResult {
        @NonNull
        public GeoCoordinates coordinates;
        @NonNull
        public String restrictionType;
        @NonNull
        public String text;
        @NonNull
        public String timeIntervals;

        public VehicleRestrictionResult(@NonNull String str, @NonNull GeoCoordinates geoCoordinates, @NonNull String str2, @NonNull String str3) {
            this.text = str;
            this.coordinates = geoCoordinates;
            this.restrictionType = str2;
            this.timeIntervals = str3;
        }
    }

    public PickMapContentResult(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                PickMapContentResult.disposeNativeHandle(j);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    @NonNull
    public native List<PoiResult> getPois();

    @NonNull
    public native List<TrafficIncidentResult> getTrafficIncidents();

    @NonNull
    public native List<VehicleRestrictionResult> getVehicleRestrictions();
}
