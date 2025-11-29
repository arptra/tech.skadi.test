package com.here.odnp.wifi.util;

import android.net.wifi.WifiManager;

public class WifiScanLock {
    private static final String TAG = "odnp.wifi.util.WifiScanLock";
    private static final String WIFILOCK_TAG = "com.here.odnp.wifi.util.WifiScanLock";
    private long mAcquiredAt;
    private WifiManager.WifiLock mWifiLock;

    public WifiScanLock(WifiManager wifiManager) {
        WifiManager.WifiLock createWifiLock = wifiManager.createWifiLock(2, WIFILOCK_TAG);
        this.mWifiLock = createWifiLock;
        createWifiLock.setReferenceCounted(false);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001f, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void acquire() {
        /*
            r3 = this;
            monitor-enter(r3)
            android.net.wifi.WifiManager$WifiLock r0 = r3.mWifiLock     // Catch:{ all -> 0x0011 }
            if (r0 != 0) goto L_0x0013
            r0 = 0
            java.lang.Object[] r0 = new java.lang.Object[r0]     // Catch:{ all -> 0x0011 }
            java.lang.String r1 = "odnp.wifi.util.WifiScanLock"
            java.lang.String r2 = "acquire: WifiLock is closed"
            com.here.odnp.util.Log.w(r1, r2, r0)     // Catch:{ all -> 0x0011 }
            monitor-exit(r3)
            return
        L_0x0011:
            r0 = move-exception
            goto L_0x0020
        L_0x0013:
            boolean r0 = r0.isHeld()     // Catch:{ all -> 0x0011 }
            if (r0 != 0) goto L_0x001e
            android.net.wifi.WifiManager$WifiLock r0 = r3.mWifiLock     // Catch:{ all -> 0x0011 }
            r0.acquire()     // Catch:{ all -> 0x0011 }
        L_0x001e:
            monitor-exit(r3)
            return
        L_0x0020:
            monitor-exit(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.here.odnp.wifi.util.WifiScanLock.acquire():void");
    }

    public synchronized void close() {
        release();
        this.mWifiLock = null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001f, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void release() {
        /*
            r3 = this;
            monitor-enter(r3)
            android.net.wifi.WifiManager$WifiLock r0 = r3.mWifiLock     // Catch:{ all -> 0x0011 }
            if (r0 != 0) goto L_0x0013
            r0 = 0
            java.lang.Object[] r0 = new java.lang.Object[r0]     // Catch:{ all -> 0x0011 }
            java.lang.String r1 = "odnp.wifi.util.WifiScanLock"
            java.lang.String r2 = "release: WifiLock is closed"
            com.here.odnp.util.Log.w(r1, r2, r0)     // Catch:{ all -> 0x0011 }
            monitor-exit(r3)
            return
        L_0x0011:
            r0 = move-exception
            goto L_0x0020
        L_0x0013:
            boolean r0 = r0.isHeld()     // Catch:{ all -> 0x0011 }
            if (r0 == 0) goto L_0x001e
            android.net.wifi.WifiManager$WifiLock r0 = r3.mWifiLock     // Catch:{ all -> 0x0011 }
            r0.release()     // Catch:{ all -> 0x0011 }
        L_0x001e:
            monitor-exit(r3)
            return
        L_0x0020:
            monitor-exit(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.here.odnp.wifi.util.WifiScanLock.release():void");
    }
}
