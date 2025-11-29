package com.here.sdk.maploader;

import androidx.annotation.NonNull;
import java.util.Objects;

public final class InstalledRegion {
    @NonNull
    public RegionId parentId;
    @NonNull
    public RegionId regionId;
    public long sizeOnDiskInBytes;
    @NonNull
    public InstalledRegionStatus status;

    public InstalledRegion(@NonNull RegionId regionId2, @NonNull RegionId regionId3, long j, @NonNull InstalledRegionStatus installedRegionStatus) {
        this.regionId = regionId2;
        this.parentId = regionId3;
        this.sizeOnDiskInBytes = j;
        this.status = installedRegionStatus;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof InstalledRegion)) {
            return false;
        }
        InstalledRegion installedRegion = (InstalledRegion) obj;
        return Objects.equals(this.regionId, installedRegion.regionId) && Objects.equals(this.parentId, installedRegion.parentId) && this.sizeOnDiskInBytes == installedRegion.sizeOnDiskInBytes && Objects.equals(this.status, installedRegion.status);
    }

    public int hashCode() {
        RegionId regionId2 = this.regionId;
        int i = 0;
        int hashCode = (217 + (regionId2 != null ? regionId2.hashCode() : 0)) * 31;
        RegionId regionId3 = this.parentId;
        int hashCode2 = regionId3 != null ? regionId3.hashCode() : 0;
        long j = this.sizeOnDiskInBytes;
        int i2 = (((hashCode + hashCode2) * 31) + ((int) (j ^ (j >>> 32)))) * 31;
        InstalledRegionStatus installedRegionStatus = this.status;
        if (installedRegionStatus != null) {
            i = installedRegionStatus.hashCode();
        }
        return i2 + i;
    }
}
