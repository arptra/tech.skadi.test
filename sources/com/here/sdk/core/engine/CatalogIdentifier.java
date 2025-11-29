package com.here.sdk.core.engine;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Objects;

public final class CatalogIdentifier {
    @NonNull
    public String hrn = "hrn:here:data::olp-here:ocm";
    @Nullable
    public Long version = null;

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CatalogIdentifier)) {
            return false;
        }
        CatalogIdentifier catalogIdentifier = (CatalogIdentifier) obj;
        return Objects.equals(this.hrn, catalogIdentifier.hrn) && Objects.equals(this.version, catalogIdentifier.version);
    }

    public int hashCode() {
        String str = this.hrn;
        int i = 0;
        int hashCode = (217 + (str != null ? str.hashCode() : 0)) * 31;
        Long l = this.version;
        if (l != null) {
            i = l.hashCode();
        }
        return hashCode + i;
    }
}
