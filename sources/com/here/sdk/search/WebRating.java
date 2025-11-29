package com.here.sdk.search;

import androidx.annotation.NonNull;
import java.util.Objects;

public final class WebRating {
    public double average;
    public int count;
    @NonNull
    public WebSource source;

    public WebRating(int i, double d, @NonNull WebSource webSource) {
        this.count = i;
        this.average = d;
        this.source = webSource;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof WebRating)) {
            return false;
        }
        WebRating webRating = (WebRating) obj;
        return this.count == webRating.count && Double.compare(this.average, webRating.average) == 0 && Objects.equals(this.source, webRating.source);
    }

    public int hashCode() {
        int doubleToLongBits = (((217 + this.count) * 31) + ((int) (Double.doubleToLongBits(this.average) ^ (Double.doubleToLongBits(this.average) >>> 32)))) * 31;
        WebSource webSource = this.source;
        return doubleToLongBits + (webSource != null ? webSource.hashCode() : 0);
    }

    public WebRating() {
        this.count = 0;
        this.average = 0.0d;
        this.source = new WebSource();
    }
}
