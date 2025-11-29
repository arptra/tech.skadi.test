package com.here.sdk.routing;

import androidx.annotation.NonNull;
import java.util.List;
import java.util.Objects;

public final class Signpost {
    @NonNull
    public List<SignpostLabel> labels;

    public Signpost(@NonNull List<SignpostLabel> list) {
        this.labels = list;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Signpost)) {
            return false;
        }
        return Objects.equals(this.labels, ((Signpost) obj).labels);
    }

    public int hashCode() {
        List<SignpostLabel> list = this.labels;
        return 217 + (list != null ? list.hashCode() : 0);
    }
}
