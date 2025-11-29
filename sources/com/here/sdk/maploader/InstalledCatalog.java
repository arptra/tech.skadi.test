package com.here.sdk.maploader;

import androidx.annotation.NonNull;
import com.here.sdk.core.engine.CatalogIdentifier;
import java.util.Objects;

public final class InstalledCatalog {
    @NonNull
    public CatalogIdentifier catalogIdentifier;

    public InstalledCatalog(@NonNull String str, long j) {
        this.catalogIdentifier = make(str, j).catalogIdentifier;
    }

    private static native InstalledCatalog make(@NonNull String str, long j);

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof InstalledCatalog)) {
            return false;
        }
        return Objects.equals(this.catalogIdentifier, ((InstalledCatalog) obj).catalogIdentifier);
    }

    public int hashCode() {
        CatalogIdentifier catalogIdentifier2 = this.catalogIdentifier;
        return 217 + (catalogIdentifier2 != null ? catalogIdentifier2.hashCode() : 0);
    }
}
