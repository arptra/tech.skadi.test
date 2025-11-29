package com.here.sdk.navigation;

import androidx.annotation.NonNull;
import java.util.Objects;

public final class RealisticViewWarningOptions {
    @NonNull
    public AspectRatio aspectRatio = AspectRatio.ASPECT_RATIO_3_X_4;
    public boolean darkTheme = false;

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RealisticViewWarningOptions)) {
            return false;
        }
        RealisticViewWarningOptions realisticViewWarningOptions = (RealisticViewWarningOptions) obj;
        return Objects.equals(this.aspectRatio, realisticViewWarningOptions.aspectRatio) && this.darkTheme == realisticViewWarningOptions.darkTheme;
    }

    public int hashCode() {
        AspectRatio aspectRatio2 = this.aspectRatio;
        return ((217 + (aspectRatio2 != null ? aspectRatio2.hashCode() : 0)) * 31) + (this.darkTheme ? 79 : 97);
    }
}
