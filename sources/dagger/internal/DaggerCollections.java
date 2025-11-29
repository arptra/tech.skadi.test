package dagger.internal;

import java.util.HashSet;
import java.util.LinkedHashMap;

public final class DaggerCollections {
    public static int a(int i) {
        if (i < 3) {
            return i + 1;
        }
        if (i < 1073741824) {
            return (int) ((((float) i) / 0.75f) + 1.0f);
        }
        return Integer.MAX_VALUE;
    }

    public static HashSet b(int i) {
        return new HashSet(a(i));
    }

    public static LinkedHashMap c(int i) {
        return new LinkedHashMap(a(i));
    }
}
