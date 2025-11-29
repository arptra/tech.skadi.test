package com.here.sdk.routing;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

public final class LocalizedRoadNumbers {
    @NonNull
    public List<LocalizedRoadNumber> items = new ArrayList();

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LocalizedRoadNumbers)) {
            return false;
        }
        return Objects.equals(this.items, ((LocalizedRoadNumbers) obj).items);
    }

    @Nullable
    public native String getDefaultValue();

    @Nullable
    public native String getPreferredValueForLocales(@NonNull List<Locale> list);

    public int hashCode() {
        List<LocalizedRoadNumber> list = this.items;
        return 217 + (list != null ? list.hashCode() : 0);
    }
}
