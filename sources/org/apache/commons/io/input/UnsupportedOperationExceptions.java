package org.apache.commons.io.input;

class UnsupportedOperationExceptions {
    private static final String MARK_RESET = "mark/reset";

    public static UnsupportedOperationException mark() {
        return method(MARK_RESET);
    }

    public static UnsupportedOperationException method(String str) {
        return new UnsupportedOperationException(str + " not supported");
    }

    public static UnsupportedOperationException reset() {
        return method(MARK_RESET);
    }
}
