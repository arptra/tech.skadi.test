package com.here.sdk.transport;

import androidx.annotation.Nullable;
import java.util.Objects;

public final class WeightPerAxleGroup {
    @Nullable
    public Integer quadAxleGroupInKilograms = null;
    @Nullable
    public Integer quintAxleGroupInKilograms = null;
    @Nullable
    public Integer singleAxleGroupInKilograms = null;
    @Nullable
    public Integer tandemAxleGroupInKilograms = null;
    @Nullable
    public Integer tripleAxleGroupInKilograms = null;

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof WeightPerAxleGroup)) {
            return false;
        }
        WeightPerAxleGroup weightPerAxleGroup = (WeightPerAxleGroup) obj;
        return Objects.equals(this.singleAxleGroupInKilograms, weightPerAxleGroup.singleAxleGroupInKilograms) && Objects.equals(this.tandemAxleGroupInKilograms, weightPerAxleGroup.tandemAxleGroupInKilograms) && Objects.equals(this.tripleAxleGroupInKilograms, weightPerAxleGroup.tripleAxleGroupInKilograms) && Objects.equals(this.quadAxleGroupInKilograms, weightPerAxleGroup.quadAxleGroupInKilograms) && Objects.equals(this.quintAxleGroupInKilograms, weightPerAxleGroup.quintAxleGroupInKilograms);
    }

    public int hashCode() {
        Integer num = this.singleAxleGroupInKilograms;
        int i = 0;
        int hashCode = (217 + (num != null ? num.hashCode() : 0)) * 31;
        Integer num2 = this.tandemAxleGroupInKilograms;
        int hashCode2 = (hashCode + (num2 != null ? num2.hashCode() : 0)) * 31;
        Integer num3 = this.tripleAxleGroupInKilograms;
        int hashCode3 = (hashCode2 + (num3 != null ? num3.hashCode() : 0)) * 31;
        Integer num4 = this.quadAxleGroupInKilograms;
        int hashCode4 = (hashCode3 + (num4 != null ? num4.hashCode() : 0)) * 31;
        Integer num5 = this.quintAxleGroupInKilograms;
        if (num5 != null) {
            i = num5.hashCode();
        }
        return hashCode4 + i;
    }
}
