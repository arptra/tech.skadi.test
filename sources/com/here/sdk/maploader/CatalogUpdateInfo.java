package com.here.sdk.maploader;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Objects;

public final class CatalogUpdateInfo {
    @Nullable
    final Long catalogHandle;
    public final long diskSizeInBytes;
    @NonNull
    public final InstalledCatalog installedCatalog;
    public final long latestVersion;
    public final long networkSizeInBytes;
    @NonNull
    public final CatalogUpdateState state;

    public CatalogUpdateInfo(@NonNull InstalledCatalog installedCatalog2, long j) {
        this.installedCatalog = installedCatalog2;
        this.latestVersion = j;
        this.state = CatalogUpdateState.UNKNOWN_STATE;
        this.catalogHandle = null;
        this.networkSizeInBytes = 0;
        this.diskSizeInBytes = 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CatalogUpdateInfo)) {
            return false;
        }
        CatalogUpdateInfo catalogUpdateInfo = (CatalogUpdateInfo) obj;
        return Objects.equals(this.installedCatalog, catalogUpdateInfo.installedCatalog) && this.latestVersion == catalogUpdateInfo.latestVersion && Objects.equals(this.state, catalogUpdateInfo.state) && Objects.equals(this.catalogHandle, catalogUpdateInfo.catalogHandle) && this.networkSizeInBytes == catalogUpdateInfo.networkSizeInBytes && this.diskSizeInBytes == catalogUpdateInfo.diskSizeInBytes;
    }

    public int hashCode() {
        InstalledCatalog installedCatalog2 = this.installedCatalog;
        int i = 0;
        int hashCode = installedCatalog2 != null ? installedCatalog2.hashCode() : 0;
        long j = this.latestVersion;
        int i2 = (((217 + hashCode) * 31) + ((int) (j ^ (j >>> 32)))) * 31;
        CatalogUpdateState catalogUpdateState = this.state;
        int hashCode2 = (i2 + (catalogUpdateState != null ? catalogUpdateState.hashCode() : 0)) * 31;
        Long l = this.catalogHandle;
        if (l != null) {
            i = l.hashCode();
        }
        long j2 = this.networkSizeInBytes;
        long j3 = this.diskSizeInBytes;
        return ((((hashCode2 + i) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + ((int) ((j3 >>> 32) ^ j3));
    }

    public CatalogUpdateInfo(@NonNull InstalledCatalog installedCatalog2, long j, @NonNull CatalogUpdateState catalogUpdateState, @Nullable Long l, long j2, long j3) {
        this.installedCatalog = installedCatalog2;
        this.latestVersion = j;
        this.state = catalogUpdateState;
        this.catalogHandle = l;
        this.networkSizeInBytes = j2;
        this.diskSizeInBytes = j3;
    }
}
