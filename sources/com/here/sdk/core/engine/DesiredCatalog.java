package com.here.sdk.core.engine;

import androidx.annotation.NonNull;
import java.util.Objects;

public final class DesiredCatalog {
    @NonNull
    public CatalogIdentifier id;

    public DesiredCatalog(@NonNull String str, @NonNull CatalogVersionHint catalogVersionHint) {
        this.id = make(str, catalogVersionHint).id;
    }

    private static native DesiredCatalog make(@NonNull String str, @NonNull CatalogVersionHint catalogVersionHint);

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DesiredCatalog)) {
            return false;
        }
        return Objects.equals(this.id, ((DesiredCatalog) obj).id);
    }

    public int hashCode() {
        CatalogIdentifier catalogIdentifier = this.id;
        return 217 + (catalogIdentifier != null ? catalogIdentifier.hashCode() : 0);
    }
}
