package com.google.crypto.tink.config;

final class TinkFipsStatus {
    private TinkFipsStatus() {
    }

    public static boolean fipsModuleAvailable() {
        return false;
    }

    public static boolean useOnlyFips() {
        return false;
    }
}
