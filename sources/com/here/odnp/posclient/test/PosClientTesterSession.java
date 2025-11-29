package com.here.odnp.posclient.test;

import com.here.odnp.cell.ICellManager;
import com.here.odnp.gnss.IGnssManager;
import com.here.odnp.posclient.CloseableSession;
import com.here.odnp.posclient.PosClientManager;
import com.here.odnp.posclient.test.IPosClientTesterSession;
import com.here.odnp.util.Log;
import com.here.odnp.wifi.IWifiManager;
import com.here.posclient.ClientConfiguration;
import com.here.posclient.PositioningFeature;
import com.here.posclient.Status;

public class PosClientTesterSession extends CloseableSession implements IPosClientTesterSession {
    private static final String TAG = "odnp.posclient.test.PosClientTesterSession";
    private ICellManager mSavedCellManager;
    private IGnssManager mSavedGnssManager;
    private IWifiManager mSavedWifiManager;

    public PosClientTesterSession(PosClientManager posClientManager) {
        super(posClientManager);
        Log.v(TAG, "PosClientTester.ctor", new Object[0]);
        this.mPosClientManager.addTesterSession(this);
    }

    public int availableFeatures() {
        return this.mPosClientManager.availableFeatures();
    }

    public void clearData(int i) {
        this.mPosClientManager.clearData(i);
    }

    public void dumpCachedData() {
        this.mPosClientManager.dumpCachedData();
    }

    public void dumpFingerprints() {
        this.mPosClientManager.dumpFingerprints();
    }

    public void dumpRemoteConfiguration() {
        this.mPosClientManager.dumpRemoteConfiguration();
    }

    public int enabledFeatures() {
        return this.mPosClientManager.enabledFeatures();
    }

    public boolean getActiveCollection() {
        return this.mPosClientManager.getActiveCollection();
    }

    public boolean getAutoUpload() {
        return this.mPosClientManager.getAutoUpload();
    }

    public ClientConfiguration getClientConfiguration() {
        return this.mPosClientManager.getClientConfiguration();
    }

    public Status getCollectionStats(IPosClientTesterSession.FingerprintStatsListener fingerprintStatsListener) {
        return this.mPosClientManager.getCollectionStats(fingerprintStatsListener);
    }

    public boolean getCollectionStatus() {
        return this.mPosClientManager.getCollectionStatus();
    }

    public long getGnssFingerprintCount() {
        return this.mPosClientManager.getGnssFingerprintCount();
    }

    public long getNonGnssFingerprintCount() {
        return this.mPosClientManager.getNonGnssFingerprintCount();
    }

    public void logLta(String str) {
        this.mPosClientManager.logLta(str);
    }

    public void onClose() {
        Log.v(TAG, "onClose", new Object[0]);
        if (restoreMeasurementManagers()) {
            resetPositioningFilter();
        }
        this.mPosClientManager.removeTesterSession(this);
    }

    public void onOpen() {
        Log.v(TAG, "onOpen", new Object[0]);
    }

    public void overrideConfiguration(String str) {
        this.mPosClientManager.overrideConfiguration(str);
    }

    public void refreshRemoteConfiguration() {
        this.mPosClientManager.refreshRemoteConfiguration();
    }

    public boolean registerHDWifiStateListener(IPosClientTesterSession.HDWifiStateListener hDWifiStateListener) {
        return this.mPosClientManager.startHDWifiStateMonitoring(hDWifiStateListener);
    }

    public void resetPositioningFilter() {
        this.mPosClientManager.resetPositioningFilter();
    }

    public boolean restoreMeasurementManagers() {
        boolean z;
        Log.v(TAG, "restoreMeasurementManagers", new Object[0]);
        try {
            ICellManager iCellManager = this.mSavedCellManager;
            if (iCellManager == null || iCellManager.equals(this.mPosClientManager.getCellManager())) {
                z = false;
            } else {
                Log.v(TAG, "restoreMeasurementManagers: restoring cell manager", new Object[0]);
                this.mPosClientManager.setCellManager(this.mSavedCellManager);
                z = true;
            }
            IWifiManager iWifiManager = this.mSavedWifiManager;
            if (iWifiManager != null && !iWifiManager.equals(this.mPosClientManager.getWifiManager())) {
                Log.v(TAG, "restoreMeasurementManagers: restoring Wi-Fi manager", new Object[0]);
                this.mPosClientManager.setWifiManager(this.mSavedWifiManager);
                z = true;
            }
            IGnssManager iGnssManager = this.mSavedGnssManager;
            if (iGnssManager == null || iGnssManager.equals(this.mPosClientManager.getGnssManager())) {
                return z;
            }
            Log.v(TAG, "restoreMeasurementManagers: restoring GNSS manager", new Object[0]);
            this.mPosClientManager.setGnssManager(this.mSavedGnssManager);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public void sendFingerprints() {
        this.mPosClientManager.sendFingerprints();
    }

    public boolean setActiveCollection(boolean z) {
        return this.mPosClientManager.setActiveCollection(z);
    }

    public boolean setAutoUpload(boolean z) {
        return this.mPosClientManager.setAutoUpload(z);
    }

    public boolean setCellManager(ICellManager iCellManager) {
        return this.mPosClientManager.setCellManager(iCellManager);
    }

    public boolean setGnssManager(IGnssManager iGnssManager) {
        return this.mPosClientManager.setGnssManager(iGnssManager);
    }

    public void setRadioMapDownloadPath(String str) {
        this.mPosClientManager.setRadioMapPath(str);
    }

    public void setUsername(String str) {
        this.mPosClientManager.setUsername(str);
    }

    public boolean setWifiManager(IWifiManager iWifiManager) {
        return this.mPosClientManager.setWifiManager(iWifiManager);
    }

    public void storeMeasurementManagers() {
        if (this.mSavedCellManager == null) {
            this.mSavedCellManager = this.mPosClientManager.getCellManager();
        }
        if (this.mSavedWifiManager == null) {
            this.mSavedWifiManager = this.mPosClientManager.getWifiManager();
        }
        if (this.mSavedGnssManager == null) {
            this.mSavedGnssManager = this.mPosClientManager.getGnssManager();
        }
    }

    public void toggleFeature(PositioningFeature positioningFeature, boolean z) {
        this.mPosClientManager.toggleFeature(positioningFeature, z);
    }

    public void unregisterHDWifiStateListener(IPosClientTesterSession.HDWifiStateListener hDWifiStateListener) {
        this.mPosClientManager.stopHDWifiStateMonitoring(hDWifiStateListener);
    }
}
