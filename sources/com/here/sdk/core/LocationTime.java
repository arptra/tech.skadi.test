package com.here.sdk.core;

import androidx.annotation.NonNull;
import com.here.time.Duration;
import java.util.Date;
import java.util.Objects;

public final class LocationTime {
    @NonNull
    public final Date localTime;
    @NonNull
    public final Duration utcOffset;
    @NonNull
    public final Date utcTime;

    public LocationTime(@NonNull Date date, @NonNull Date date2, @NonNull Duration duration) {
        this.localTime = date;
        this.utcTime = date2;
        this.utcOffset = duration;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LocationTime)) {
            return false;
        }
        LocationTime locationTime = (LocationTime) obj;
        return Objects.equals(this.localTime, locationTime.localTime) && Objects.equals(this.utcTime, locationTime.utcTime) && Objects.equals(this.utcOffset, locationTime.utcOffset);
    }

    public int hashCode() {
        Date date = this.localTime;
        int i = 0;
        int hashCode = (217 + (date != null ? date.hashCode() : 0)) * 31;
        Date date2 = this.utcTime;
        int hashCode2 = (hashCode + (date2 != null ? date2.hashCode() : 0)) * 31;
        Duration duration = this.utcOffset;
        if (duration != null) {
            i = duration.hashCode();
        }
        return hashCode2 + i;
    }
}
