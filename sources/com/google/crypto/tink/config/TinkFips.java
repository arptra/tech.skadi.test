package com.google.crypto.tink.config;

public final class TinkFips {

    public enum AlgorithmFipsCompatibility {
        ALGORITHM_NOT_FIPS {
            public boolean isCompatible() {
                return !TinkFipsStatus.useOnlyFips();
            }
        },
        ALGORITHM_REQUIRES_BORINGCRYPTO {
            public boolean isCompatible() {
                return !TinkFipsStatus.useOnlyFips() || TinkFipsStatus.fipsModuleAvailable();
            }
        };

        public abstract boolean isCompatible();
    }

    private TinkFips() {
    }

    public static boolean fipsModuleAvailable() {
        return TinkFipsStatus.fipsModuleAvailable();
    }

    public static boolean useOnlyFips() {
        return TinkFipsStatus.useOnlyFips();
    }
}
