package dagger.hilt.internal;

public final class UnsafeCasts {
    private UnsafeCasts() {
    }

    public static <T> T unsafeCast(Object obj) {
        return obj;
    }
}
