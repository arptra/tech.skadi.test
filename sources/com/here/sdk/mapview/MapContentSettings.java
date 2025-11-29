package com.here.sdk.mapview;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.here.NativeBase;
import com.here.sdk.traffic.TrafficIncidentType;
import com.here.sdk.transport.HazardousMaterial;
import com.here.sdk.transport.TruckSpecifications;
import com.here.sdk.transport.TunnelCategory;
import com.here.time.Duration;
import java.util.List;

public final class MapContentSettings extends NativeBase {

    public enum TrafficRefreshPeriodErrorCode {
        INTERNAL_ERROR(1),
        VALUE_OUTSIDE_ALLOWED_RANGE(2);
        
        public final int value;

        private TrafficRefreshPeriodErrorCode(int i) {
            this.value = i;
        }
    }

    public static final class TrafficRefreshPeriodException extends Exception {
        public final TrafficRefreshPeriodErrorCode error;

        public TrafficRefreshPeriodException(TrafficRefreshPeriodErrorCode trafficRefreshPeriodErrorCode) {
            super(trafficRefreshPeriodErrorCode.toString());
            this.error = trafficRefreshPeriodErrorCode;
        }
    }

    public MapContentSettings(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                MapContentSettings.disposeNativeHandle(j);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    public static native void filterTrafficIncidents(@NonNull List<TrafficIncidentType> list);

    public static native void filterVehicleRestrictions(@NonNull TruckSpecifications truckSpecifications, @Nullable List<HazardousMaterial> list, @Nullable TunnelCategory tunnelCategory);

    public static native void resetTrafficIncidentFilter();

    public static native void resetTrafficRefreshPeriod();

    public static native void resetVehicleRestrictionFilter();

    public static native void setTrafficRefreshPeriod(@NonNull Duration duration) throws TrafficRefreshPeriodException;
}
