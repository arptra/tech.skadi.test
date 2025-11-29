package com.here.sdk.core.engine;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.here.sdk.core.SDKLibraryLoader;
import com.here.time.Duration;
import java.util.Objects;

public final class CatalogConfiguration {
    static final SDKLibraryLoader LIBRARY_LOADER = new SDKLibraryLoader("SDK");
    public boolean allowDownload = true;
    @Nullable
    public Duration cacheExpirationPeriod = null;
    @NonNull
    public DesiredCatalog catalog;
    @Nullable
    public String patchHrn = null;

    public CatalogConfiguration(@NonNull DesiredCatalog desiredCatalog) {
        this.catalog = desiredCatalog;
    }

    @NonNull
    public static native CatalogConfiguration getDefault(@NonNull CatalogType catalogType);

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CatalogConfiguration)) {
            return false;
        }
        CatalogConfiguration catalogConfiguration = (CatalogConfiguration) obj;
        return Objects.equals(this.catalog, catalogConfiguration.catalog) && Objects.equals(this.patchHrn, catalogConfiguration.patchHrn) && Objects.equals(this.cacheExpirationPeriod, catalogConfiguration.cacheExpirationPeriod) && this.allowDownload == catalogConfiguration.allowDownload;
    }

    public int hashCode() {
        DesiredCatalog desiredCatalog = this.catalog;
        int i = 0;
        int hashCode = (217 + (desiredCatalog != null ? desiredCatalog.hashCode() : 0)) * 31;
        String str = this.patchHrn;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        Duration duration = this.cacheExpirationPeriod;
        if (duration != null) {
            i = duration.hashCode();
        }
        return ((hashCode2 + i) * 31) + (this.allowDownload ? 79 : 97);
    }
}
