package com.here.sdk.navigation;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.here.sdk.core.LocalizedTexts;
import java.util.Objects;

public final class EnvironmentalZoneWarning {
    @NonNull
    public LocalizedTexts description = new LocalizedTexts();
    public double distanceInMeters;
    @NonNull
    public DistanceType distanceType;
    @NonNull
    public String name;
    @Nullable
    public String websiteUrl = null;
    @NonNull
    public String zoneId;

    public EnvironmentalZoneWarning(double d, @NonNull DistanceType distanceType2, @NonNull String str, @NonNull String str2) {
        this.distanceInMeters = d;
        this.distanceType = distanceType2;
        this.zoneId = str;
        this.name = str2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof EnvironmentalZoneWarning)) {
            return false;
        }
        EnvironmentalZoneWarning environmentalZoneWarning = (EnvironmentalZoneWarning) obj;
        return Double.compare(this.distanceInMeters, environmentalZoneWarning.distanceInMeters) == 0 && Objects.equals(this.distanceType, environmentalZoneWarning.distanceType) && Objects.equals(this.zoneId, environmentalZoneWarning.zoneId) && Objects.equals(this.name, environmentalZoneWarning.name) && Objects.equals(this.description, environmentalZoneWarning.description) && Objects.equals(this.websiteUrl, environmentalZoneWarning.websiteUrl);
    }

    public int hashCode() {
        int doubleToLongBits = (217 + ((int) (Double.doubleToLongBits(this.distanceInMeters) ^ (Double.doubleToLongBits(this.distanceInMeters) >>> 32)))) * 31;
        DistanceType distanceType2 = this.distanceType;
        int i = 0;
        int hashCode = (doubleToLongBits + (distanceType2 != null ? distanceType2.hashCode() : 0)) * 31;
        String str = this.zoneId;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.name;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        LocalizedTexts localizedTexts = this.description;
        int hashCode4 = (hashCode3 + (localizedTexts != null ? localizedTexts.hashCode() : 0)) * 31;
        String str3 = this.websiteUrl;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return hashCode4 + i;
    }
}
