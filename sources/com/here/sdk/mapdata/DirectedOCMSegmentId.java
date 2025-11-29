package com.here.sdk.mapdata;

import androidx.annotation.NonNull;
import com.here.sdk.routing.TravelDirection;
import java.util.Objects;

public final class DirectedOCMSegmentId {
    @NonNull
    public OCMSegmentId id;
    @NonNull
    public TravelDirection travelDirection = TravelDirection.BIDIRECTIONAL;

    public DirectedOCMSegmentId(@NonNull OCMSegmentId oCMSegmentId) {
        this.id = oCMSegmentId;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DirectedOCMSegmentId)) {
            return false;
        }
        DirectedOCMSegmentId directedOCMSegmentId = (DirectedOCMSegmentId) obj;
        return Objects.equals(this.id, directedOCMSegmentId.id) && Objects.equals(this.travelDirection, directedOCMSegmentId.travelDirection);
    }

    public int hashCode() {
        OCMSegmentId oCMSegmentId = this.id;
        int i = 0;
        int hashCode = (217 + (oCMSegmentId != null ? oCMSegmentId.hashCode() : 0)) * 31;
        TravelDirection travelDirection2 = this.travelDirection;
        if (travelDirection2 != null) {
            i = travelDirection2.hashCode();
        }
        return hashCode + i;
    }
}
