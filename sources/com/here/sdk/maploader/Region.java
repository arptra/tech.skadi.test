package com.here.sdk.maploader;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.List;
import java.util.Objects;

public final class Region {
    @Nullable
    public List<Region> childRegions = null;
    @NonNull
    public String name = "";
    @NonNull
    RegionId parentId = new RegionId(0);
    @NonNull
    public RegionId regionId;
    public long sizeOnDiskInBytes = 0;
    public long sizeOnNetworkInBytes = 0;

    public Region(@NonNull RegionId regionId2) {
        this.regionId = regionId2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Region)) {
            return false;
        }
        Region region = (Region) obj;
        return Objects.equals(this.regionId, region.regionId) && Objects.equals(this.parentId, region.parentId) && Objects.equals(this.name, region.name) && this.sizeOnDiskInBytes == region.sizeOnDiskInBytes && this.sizeOnNetworkInBytes == region.sizeOnNetworkInBytes && Objects.equals(this.childRegions, region.childRegions);
    }

    public int hashCode() {
        RegionId regionId2 = this.regionId;
        int i = 0;
        int hashCode = (217 + (regionId2 != null ? regionId2.hashCode() : 0)) * 31;
        RegionId regionId3 = this.parentId;
        int hashCode2 = (hashCode + (regionId3 != null ? regionId3.hashCode() : 0)) * 31;
        String str = this.name;
        int hashCode3 = str != null ? str.hashCode() : 0;
        long j = this.sizeOnDiskInBytes;
        long j2 = this.sizeOnNetworkInBytes;
        int i2 = (((((hashCode2 + hashCode3) * 31) + ((int) (j ^ (j >>> 32)))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31;
        List<Region> list = this.childRegions;
        if (list != null) {
            i = list.hashCode();
        }
        return i2 + i;
    }
}
