package com.here.services.test.internal;

import android.content.Intent;
import android.os.RemoteException;
import com.here.odnp.posclient.IPosClientManager;
import com.here.odnp.util.Log;
import com.here.posclient.ClientConfiguration;
import com.here.services.internal.IBoundService;
import com.here.services.test.internal.ILocationTestClient;

public class LocationTestClientService extends ILocationTestClient.Stub implements IBoundService {
    private static final String TAG = "services.test.internal.PositioningTestClientService";
    private final IPosClientTestManager mPosClientTestManager;

    public LocationTestClientService(IPosClientManager iPosClientManager, Intent intent) {
        Log.v(TAG, "PositioningTestClientService", new Object[0]);
        this.mPosClientTestManager = PosClientTestManager.create(iPosClientManager);
    }

    public int availableFeatures() throws RemoteException {
        return this.mPosClientTestManager.availableFeatures();
    }

    public void clearData(int i) {
        this.mPosClientTestManager.clearData(i);
    }

    public void dumpCachedData() {
        this.mPosClientTestManager.dumpCachedData();
    }

    public void dumpData() {
        this.mPosClientTestManager.dumpData();
    }

    public void dumpFingerprints() {
        this.mPosClientTestManager.dumpFingerprints();
    }

    public void dumpHeapData() {
        this.mPosClientTestManager.dumpHeapData();
    }

    public void dumpRemoteConfiguration() throws RemoteException {
        this.mPosClientTestManager.dumpRemoteConfiguration();
    }

    public int enabledFeatures() throws RemoteException {
        return this.mPosClientTestManager.enabledFeatures();
    }

    public boolean getActiveCollection() {
        return this.mPosClientTestManager.getActiveCollection();
    }

    public boolean getAutoUpload() {
        return this.mPosClientTestManager.getAutoUpload();
    }

    public ClientConfiguration getClientConfiguration() throws RemoteException {
        return this.mPosClientTestManager.getClientConfiguration();
    }

    public int getCollectionStats(FingerprintStatsListener fingerprintStatsListener) throws RemoteException {
        return this.mPosClientTestManager.getCollectionStats(fingerprintStatsListener);
    }

    public boolean getCollectionStatus() {
        return this.mPosClientTestManager.getCollectionStatus();
    }

    public long getGnssFingerprintCount() {
        return this.mPosClientTestManager.getGnssFingerprintCount();
    }

    public long getNonGnssFingerprintCount() {
        return this.mPosClientTestManager.getNonGnssFingerprintCount();
    }

    public void logLta(String str) throws RemoteException {
        this.mPosClientTestManager.logLta(str);
    }

    public void overrideConfiguration(String str) {
        this.mPosClientTestManager.overrideConfiguration(str);
    }

    public void refreshRemoteConfiguration() throws RemoteException {
        this.mPosClientTestManager.refreshRemoteConfiguration();
    }

    public boolean registerHdWifiStateListener(HdWifiStateListener hdWifiStateListener) throws RemoteException {
        return this.mPosClientTestManager.registerHDWifiStateListener(hdWifiStateListener);
    }

    public void sendFingerprints() {
        this.mPosClientTestManager.sendFingerprints();
    }

    public boolean setActiveCollection(boolean z) {
        return this.mPosClientTestManager.setActiveCollection(z);
    }

    public boolean setAutoUpload(boolean z) {
        return this.mPosClientTestManager.setAutoUpload(z);
    }

    public void setUsername(String str) {
        this.mPosClientTestManager.setUsername(str);
    }

    public void toggleFeature(String str, boolean z) throws RemoteException {
        this.mPosClientTestManager.toggleFeature(str, z);
    }

    public void unBind() {
        Log.v(TAG, "unBind", new Object[0]);
        this.mPosClientTestManager.close();
    }

    public void unregisterHdWifiStateListener(HdWifiStateListener hdWifiStateListener) throws RemoteException {
        this.mPosClientTestManager.unregisterHDWifiStateListener(hdWifiStateListener);
    }
}
