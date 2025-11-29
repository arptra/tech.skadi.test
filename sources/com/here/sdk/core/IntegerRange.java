package com.here.sdk.core;

import androidx.annotation.Nullable;
import java.util.Objects;

public final class IntegerRange {
    @Nullable
    public Integer max = null;
    public int min;

    public IntegerRange(int i) {
        this.min = i;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof IntegerRange)) {
            return false;
        }
        IntegerRange integerRange = (IntegerRange) obj;
        return this.min == integerRange.min && Objects.equals(this.max, integerRange.max);
    }

    public int hashCode() {
        int i = (217 + this.min) * 31;
        Integer num = this.max;
        return i + (num != null ? num.hashCode() : 0);
    }
}
