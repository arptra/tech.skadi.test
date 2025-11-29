package com.here.sdk.navigation;

import androidx.annotation.NonNull;
import java.util.Objects;

public final class SpeedWarningOptions {
    @NonNull
    public SpeedLimitOffset speedLimitOffset;

    public SpeedWarningOptions(@NonNull SpeedLimitOffset speedLimitOffset2) {
        this.speedLimitOffset = speedLimitOffset2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SpeedWarningOptions)) {
            return false;
        }
        return Objects.equals(this.speedLimitOffset, ((SpeedWarningOptions) obj).speedLimitOffset);
    }

    public int hashCode() {
        SpeedLimitOffset speedLimitOffset2 = this.speedLimitOffset;
        return 217 + (speedLimitOffset2 != null ? speedLimitOffset2.hashCode() : 0);
    }
}
