package com.here.sdk.mapdata;

public final class SegmentDataLoaderOptions {
    public boolean loadAllowedTransportModes = false;
    public boolean loadBaseSpeeds = false;
    public boolean loadFunctionalRoadClass = false;
    public boolean loadLocalRoadCharacteristics = false;
    public boolean loadRoadAttributes = false;
    public boolean loadSpeedLimits = false;
    public boolean loadStreetNamesAndRoadNumbers = false;
    public boolean loadTravelDirection = false;

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SegmentDataLoaderOptions)) {
            return false;
        }
        SegmentDataLoaderOptions segmentDataLoaderOptions = (SegmentDataLoaderOptions) obj;
        return this.loadTravelDirection == segmentDataLoaderOptions.loadTravelDirection && this.loadFunctionalRoadClass == segmentDataLoaderOptions.loadFunctionalRoadClass && this.loadAllowedTransportModes == segmentDataLoaderOptions.loadAllowedTransportModes && this.loadSpeedLimits == segmentDataLoaderOptions.loadSpeedLimits && this.loadBaseSpeeds == segmentDataLoaderOptions.loadBaseSpeeds && this.loadLocalRoadCharacteristics == segmentDataLoaderOptions.loadLocalRoadCharacteristics && this.loadStreetNamesAndRoadNumbers == segmentDataLoaderOptions.loadStreetNamesAndRoadNumbers && this.loadRoadAttributes == segmentDataLoaderOptions.loadRoadAttributes;
    }

    public int hashCode() {
        int i = 97;
        int i2 = (((((((((((((217 + (this.loadTravelDirection ? 79 : 97)) * 31) + (this.loadFunctionalRoadClass ? 79 : 97)) * 31) + (this.loadAllowedTransportModes ? 79 : 97)) * 31) + (this.loadSpeedLimits ? 79 : 97)) * 31) + (this.loadBaseSpeeds ? 79 : 97)) * 31) + (this.loadLocalRoadCharacteristics ? 79 : 97)) * 31) + (this.loadStreetNamesAndRoadNumbers ? 79 : 97)) * 31;
        if (this.loadRoadAttributes) {
            i = 79;
        }
        return i2 + i;
    }
}
