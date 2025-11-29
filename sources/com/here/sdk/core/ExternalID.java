package com.here.sdk.core;

import androidx.annotation.NonNull;
import java.util.Objects;

public final class ExternalID {
    @NonNull
    public String id = "";
    @NonNull
    public String source = "";

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ExternalID)) {
            return false;
        }
        ExternalID externalID = (ExternalID) obj;
        return Objects.equals(this.source, externalID.source) && Objects.equals(this.id, externalID.id);
    }

    public int hashCode() {
        String str = this.source;
        int i = 0;
        int hashCode = (217 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.id;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }
}
