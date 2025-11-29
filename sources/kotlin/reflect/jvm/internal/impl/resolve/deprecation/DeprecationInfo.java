package kotlin.reflect.jvm.internal.impl.resolve.deprecation;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public abstract class DeprecationInfo implements Comparable<DeprecationInfo> {
    @NotNull
    public abstract DeprecationLevelValue getDeprecationLevel();

    public abstract boolean getPropagatesToOverrides();

    public int compareTo(@NotNull DeprecationInfo deprecationInfo) {
        Intrinsics.checkNotNullParameter(deprecationInfo, "other");
        int compareTo = getDeprecationLevel().compareTo(deprecationInfo.getDeprecationLevel());
        if (compareTo != 0 || getPropagatesToOverrides() || !deprecationInfo.getPropagatesToOverrides()) {
            return compareTo;
        }
        return 1;
    }
}
