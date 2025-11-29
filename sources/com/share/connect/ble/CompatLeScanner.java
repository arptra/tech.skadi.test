package com.share.connect.ble;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanResult;
import android.bluetooth.le.ScanSettings;
import androidx.annotation.RequiresApi;
import androidx.collection.ArrayMap;
import com.easy.logger.EasyLog;
import java.util.List;

@RequiresApi
class CompatLeScanner {

    /* renamed from: a  reason: collision with root package name */
    public BluetoothLeScanner f9898a;
    public ScanCallback b;
    public ArrayMap c = new ArrayMap();
    public boolean d = false;
    public android.bluetooth.le.ScanCallback e = new android.bluetooth.le.ScanCallback() {
        public void onScanFailed(int i) {
            EasyLog.c("CompatLeScanner", "MatchCallback: onScanFailed with reason: " + i);
            CompatLeScanner.this.e(i);
        }

        public void onScanResult(int i, ScanResult scanResult) {
            CompatLeScanner.this.g(scanResult);
        }
    };
    public android.bluetooth.le.ScanCallback f = new android.bluetooth.le.ScanCallback() {
        public void onScanFailed(int i) {
            EasyLog.c("CompatLeScanner", "LostCallback: onScanFailed with reason: " + i);
            CompatLeScanner.this.e(i);
        }

        public void onScanResult(int i, ScanResult scanResult) {
            BluetoothDevice device = scanResult.getDevice();
            if (i == 4 && CompatLeScanner.this.c.containsKey(device)) {
                CompatLeScanner.this.f(scanResult);
            }
        }
    };

    public interface ScanCallback {
        void a(int i, ScanResult scanResult);

        void b(int i);
    }

    public static CompatLeScanner h(BluetoothLeScanner bluetoothLeScanner) {
        if (bluetoothLeScanner == null) {
            return null;
        }
        CompatLeScanner compatLeScanner = new CompatLeScanner();
        compatLeScanner.f9898a = bluetoothLeScanner;
        return compatLeScanner;
    }

    public final synchronized void e(int i) {
        try {
            if (!this.d) {
                ScanCallback scanCallback = this.b;
                if (scanCallback != null) {
                    scanCallback.b(i);
                }
                this.d = true;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0023, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void f(android.bluetooth.le.ScanResult r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            androidx.collection.ArrayMap r0 = r2.c     // Catch:{ all -> 0x0018 }
            android.bluetooth.BluetoothDevice r3 = r3.getDevice()     // Catch:{ all -> 0x0018 }
            java.lang.Object r3 = r0.remove(r3)     // Catch:{ all -> 0x0018 }
            android.bluetooth.le.ScanResult r3 = (android.bluetooth.le.ScanResult) r3     // Catch:{ all -> 0x0018 }
            if (r3 != 0) goto L_0x001a
            java.lang.String r3 = "CompatLeScanner"
            java.lang.String r0 = "CompatLeScanner doLost can not find Map key, result is null"
            com.easy.logger.EasyLog.a(r3, r0)     // Catch:{ all -> 0x0018 }
            monitor-exit(r2)
            return
        L_0x0018:
            r3 = move-exception
            goto L_0x0024
        L_0x001a:
            com.share.connect.ble.CompatLeScanner$ScanCallback r0 = r2.b     // Catch:{ all -> 0x0018 }
            if (r0 == 0) goto L_0x0022
            r1 = 0
            r0.a(r1, r3)     // Catch:{ all -> 0x0018 }
        L_0x0022:
            monitor-exit(r2)
            return
        L_0x0024:
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.share.connect.ble.CompatLeScanner.f(android.bluetooth.le.ScanResult):void");
    }

    public final synchronized void g(ScanResult scanResult) {
        this.c.put(scanResult.getDevice(), scanResult);
        ScanCallback scanCallback = this.b;
        if (scanCallback != null) {
            scanCallback.a(1, scanResult);
        }
    }

    public void i(List list, ScanSettings scanSettings, ScanCallback scanCallback) {
        EasyLog.a("CompatLeScanner", "startScan...");
        synchronized (this) {
            this.b = scanCallback;
            this.d = false;
        }
        ScanSettings build = new ScanSettings.Builder().setScanMode(scanSettings.getScanMode()).setCallbackType(1).build();
        ScanSettings build2 = new ScanSettings.Builder().setScanMode(scanSettings.getScanMode()).setCallbackType(4).build();
        try {
            EasyLog.a("CompatLeScanner", "Start match scanner...");
            this.f9898a.startScan(list, build, this.e);
            EasyLog.a("CompatLeScanner", "Start lost scanner...");
            this.f9898a.startScan(list, build2, this.f);
        } catch (IllegalStateException e2) {
            EasyLog.j("CompatLeScanner", "Scan start failed because of illegal state.", e2);
        }
    }

    public void j() {
        EasyLog.a("CompatLeScanner", "stopScan...");
        try {
            this.f9898a.stopScan(this.e);
            this.f9898a.stopScan(this.f);
        } catch (IllegalStateException e2) {
            EasyLog.j("CompatLeScanner", "Scan stop failed because of illegal state, not a problem.", e2);
        }
        synchronized (this) {
            this.b = null;
        }
        this.c.clear();
    }
}
