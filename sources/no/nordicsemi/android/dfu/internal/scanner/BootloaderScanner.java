package no.nordicsemi.android.dfu.internal.scanner;

import androidx.annotation.Nullable;

public interface BootloaderScanner {
    public static final int ADDRESS_DIFF = 1;
    public static final long TIMEOUT = 5000;

    @Nullable
    String searchFor(String str);
}
