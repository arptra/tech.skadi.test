package com.here.sdk.navigation;

import androidx.annotation.NonNull;
import java.util.List;
import java.util.Objects;

public final class JunctionViewLaneAssistance {
    @NonNull
    public List<Lane> lanesForNextJunction;

    public JunctionViewLaneAssistance(@NonNull List<Lane> list) {
        this.lanesForNextJunction = list;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof JunctionViewLaneAssistance)) {
            return false;
        }
        return Objects.equals(this.lanesForNextJunction, ((JunctionViewLaneAssistance) obj).lanesForNextJunction);
    }

    public int hashCode() {
        List<Lane> list = this.lanesForNextJunction;
        return 217 + (list != null ? list.hashCode() : 0);
    }
}
