package no.nordicsemi.android.dfu.internal.scanner;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanResult;
import android.bluetooth.le.ScanSettings;
import java.util.List;
import java.util.Locale;

@TargetApi(21)
public class BootloaderScannerLollipop extends ScanCallback implements BootloaderScanner {
    /* access modifiers changed from: private */
    public String mBootloaderAddress;
    private String mDeviceAddress;
    private String mDeviceAddressIncremented;
    /* access modifiers changed from: private */
    public boolean mFound;
    /* access modifiers changed from: private */
    public final Object mLock = new Object();

    public void onScanResult(int i, ScanResult scanResult) {
        String address = scanResult.getDevice().getAddress();
        if (this.mDeviceAddress.equals(address) || this.mDeviceAddressIncremented.equals(address)) {
            this.mBootloaderAddress = address;
            this.mFound = true;
            synchronized (this.mLock) {
                this.mLock.notifyAll();
            }
        }
    }

    public String searchFor(String str) {
        BluetoothLeScanner bluetoothLeScanner;
        String substring = str.substring(0, 15);
        String format = String.format(Locale.US, "%02X", new Object[]{Integer.valueOf((Integer.valueOf(str.substring(15), 16).intValue() + 1) & 255)});
        this.mDeviceAddress = str;
        this.mDeviceAddressIncremented = substring + format;
        this.mBootloaderAddress = null;
        this.mFound = false;
        new Thread(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException unused) {
                }
                if (!BootloaderScannerLollipop.this.mFound) {
                    String unused2 = BootloaderScannerLollipop.this.mBootloaderAddress = null;
                    boolean unused3 = BootloaderScannerLollipop.this.mFound = true;
                    synchronized (BootloaderScannerLollipop.this.mLock) {
                        BootloaderScannerLollipop.this.mLock.notifyAll();
                    }
                }
            }
        }, "Scanner timer").start();
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (defaultAdapter == null || defaultAdapter.getState() != 12 || (bluetoothLeScanner = defaultAdapter.getBluetoothLeScanner()) == null) {
            return null;
        }
        bluetoothLeScanner.startScan((List) null, new ScanSettings.Builder().setScanMode(2).build(), this);
        try {
            synchronized (this.mLock) {
                while (!this.mFound) {
                    this.mLock.wait();
                }
            }
        } catch (InterruptedException unused) {
        } catch (Throwable th) {
            throw th;
        }
        bluetoothLeScanner.stopScan(this);
        return this.mBootloaderAddress;
    }
}
