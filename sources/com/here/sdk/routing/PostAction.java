package com.here.sdk.routing;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.here.time.Duration;
import java.util.Objects;

public final class PostAction {
    @NonNull
    public PostActionType action = PostActionType.CHARGING_SETUP;
    @Nullable
    public ChargingActionDetails chargingDetails = null;
    @NonNull
    public Duration duration = Duration.ofSeconds(0);

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PostAction)) {
            return false;
        }
        PostAction postAction = (PostAction) obj;
        return Objects.equals(this.action, postAction.action) && Objects.equals(this.duration, postAction.duration) && Objects.equals(this.chargingDetails, postAction.chargingDetails);
    }

    public int hashCode() {
        PostActionType postActionType = this.action;
        int i = 0;
        int hashCode = (217 + (postActionType != null ? postActionType.hashCode() : 0)) * 31;
        Duration duration2 = this.duration;
        int hashCode2 = (hashCode + (duration2 != null ? duration2.hashCode() : 0)) * 31;
        ChargingActionDetails chargingActionDetails = this.chargingDetails;
        if (chargingActionDetails != null) {
            i = chargingActionDetails.hashCode();
        }
        return hashCode2 + i;
    }
}
