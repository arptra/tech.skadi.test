package no.nordicsemi.android.dfu.internal.scanner;

public class BootloaderScannerFactory {
    public static BootloaderScanner getScanner() {
        return new BootloaderScannerLollipop();
    }
}
