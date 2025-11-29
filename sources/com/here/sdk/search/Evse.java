package com.here.sdk.search;

import androidx.annotation.Nullable;
import java.util.Objects;

public final class Evse {
    @Nullable
    public String cpoId = null;
    @Nullable
    public String id = null;

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Evse)) {
            return false;
        }
        Evse evse = (Evse) obj;
        return Objects.equals(this.id, evse.id) && Objects.equals(this.cpoId, evse.cpoId);
    }

    public int hashCode() {
        String str = this.id;
        int i = 0;
        int hashCode = (217 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.cpoId;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }
}
