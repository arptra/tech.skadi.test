package no.nordicsemi.android.dfu.internal.scanner;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import java.util.Locale;

public class BootloaderScannerJB implements BootloaderScanner, BluetoothAdapter.LeScanCallback {
    /* access modifiers changed from: private */
    public String mBootloaderAddress;
    private String mDeviceAddress;
    private String mDeviceAddressIncremented;
    /* access modifiers changed from: private */
    public boolean mFound;
    /* access modifiers changed from: private */
    public final Object mLock = new Object();

    public void onLeScan(BluetoothDevice bluetoothDevice, int i, byte[] bArr) {
        String address = bluetoothDevice.getAddress();
        if (this.mDeviceAddress.equals(address) || this.mDeviceAddressIncremented.equals(address)) {
            this.mBootloaderAddress = address;
            this.mFound = true;
            synchronized (this.mLock) {
                this.mLock.notifyAll();
            }
        }
    }

    public String searchFor(String str) {
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
                if (!BootloaderScannerJB.this.mFound) {
                    String unused2 = BootloaderScannerJB.this.mBootloaderAddress = null;
                    boolean unused3 = BootloaderScannerJB.this.mFound = true;
                    synchronized (BootloaderScannerJB.this.mLock) {
                        BootloaderScannerJB.this.mLock.notifyAll();
                    }
                }
            }
        }, "Scanner timer").start();
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (defaultAdapter == null || defaultAdapter.getState() != 12) {
            return null;
        }
        defaultAdapter.startLeScan(this);
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
        defaultAdapter.stopLeScan(this);
        return this.mBootloaderAddress;
    }
}
