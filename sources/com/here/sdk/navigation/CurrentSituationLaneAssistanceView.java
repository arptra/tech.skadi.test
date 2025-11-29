package com.here.sdk.navigation;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class CurrentSituationLaneAssistanceView {
    @NonNull
    public List<CurrentSituationLaneView> lanes = new ArrayList();

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CurrentSituationLaneAssistanceView)) {
            return false;
        }
        return Objects.equals(this.lanes, ((CurrentSituationLaneAssistanceView) obj).lanes);
    }

    public int hashCode() {
        List<CurrentSituationLaneView> list = this.lanes;
        return 217 + (list != null ? list.hashCode() : 0);
    }
}
