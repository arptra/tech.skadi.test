package com.here.sdk.routing;

import androidx.annotation.NonNull;
import com.here.time.Duration;
import java.util.Objects;

public final class PreAction {
    @NonNull
    public PreActionType action = PreActionType.BOARD;
    @NonNull
    public Duration duration = Duration.ofSeconds(0);

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PreAction)) {
            return false;
        }
        PreAction preAction = (PreAction) obj;
        return Objects.equals(this.action, preAction.action) && Objects.equals(this.duration, preAction.duration);
    }

    public int hashCode() {
        PreActionType preActionType = this.action;
        int i = 0;
        int hashCode = (217 + (preActionType != null ? preActionType.hashCode() : 0)) * 31;
        Duration duration2 = this.duration;
        if (duration2 != null) {
            i = duration2.hashCode();
        }
        return hashCode + i;
    }
}
