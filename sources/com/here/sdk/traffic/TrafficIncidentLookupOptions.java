package com.here.sdk.traffic;

import androidx.annotation.Nullable;
import com.here.sdk.core.LanguageCode;
import java.util.Objects;

public final class TrafficIncidentLookupOptions {
    @Nullable
    public LanguageCode languageCode = null;

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TrafficIncidentLookupOptions)) {
            return false;
        }
        return Objects.equals(this.languageCode, ((TrafficIncidentLookupOptions) obj).languageCode);
    }

    public int hashCode() {
        LanguageCode languageCode2 = this.languageCode;
        return 217 + (languageCode2 != null ? languageCode2.hashCode() : 0);
    }
}
