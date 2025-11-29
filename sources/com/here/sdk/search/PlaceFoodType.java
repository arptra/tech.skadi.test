package com.here.sdk.search;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Objects;

public final class PlaceFoodType {
    @NonNull
    public String id;
    @Nullable
    public String name = null;
    public boolean primary = false;

    public PlaceFoodType(@NonNull String str) {
        this.id = str;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PlaceFoodType)) {
            return false;
        }
        PlaceFoodType placeFoodType = (PlaceFoodType) obj;
        return Objects.equals(this.id, placeFoodType.id) && Objects.equals(this.name, placeFoodType.name) && this.primary == placeFoodType.primary;
    }

    public int hashCode() {
        String str = this.id;
        int i = 0;
        int hashCode = (217 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.name;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return ((hashCode + i) * 31) + (this.primary ? 79 : 97);
    }
}
