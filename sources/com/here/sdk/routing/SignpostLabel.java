package com.here.sdk.routing;

import androidx.annotation.Nullable;
import com.here.sdk.core.LocalizedText;
import java.util.Objects;

public final class SignpostLabel {
    @Nullable
    public LocalizedRoadNumber localizedRoadNumber = null;
    @Nullable
    public LocalizedText localizedText = null;

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SignpostLabel)) {
            return false;
        }
        SignpostLabel signpostLabel = (SignpostLabel) obj;
        return Objects.equals(this.localizedText, signpostLabel.localizedText) && Objects.equals(this.localizedRoadNumber, signpostLabel.localizedRoadNumber);
    }

    public int hashCode() {
        LocalizedText localizedText2 = this.localizedText;
        int i = 0;
        int hashCode = (217 + (localizedText2 != null ? localizedText2.hashCode() : 0)) * 31;
        LocalizedRoadNumber localizedRoadNumber2 = this.localizedRoadNumber;
        if (localizedRoadNumber2 != null) {
            i = localizedRoadNumber2.hashCode();
        }
        return hashCode + i;
    }
}
