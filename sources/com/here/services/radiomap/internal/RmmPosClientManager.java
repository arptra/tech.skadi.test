package com.here.services.radiomap.internal;

import com.here.odnp.posclient.IPosClientManager;
import com.here.odnp.posclient.rmm.IRmDownloadSession;
import com.here.odnp.util.Log;
import com.here.posclient.RadioMapManager;
import com.here.services.radiomap.common.GeoArea;
import java.util.HashMap;
import java.util.Map;

class RmmPosClientManager implements IRmmPosClientManager {
    private static final String TAG = "services.radiomap.internal.RmmPosClientManager";
    private final IPosClientManager mPosClientManager;
    private final Map<RadioMapManager.IRadioMapStorageActionListener, IRmDownloadSession> mRmDownloaders = new HashMap();

    private RmmPosClientManager(IPosClientManager iPosClientManager) {
        this.mPosClientManager = iPosClientManager;
    }

    public static IRmmPosClientManager create(IPosClientManager iPosClientManager) {
        return new RmmPosClientManager(iPosClientManager);
    }

    private IRmDownloadSession getRmDownload(RadioMapManager.IRadioMapStorageActionListener iRadioMapStorageActionListener, boolean z) {
        IRmDownloadSession iRmDownloadSession = this.mRmDownloaders.get(iRadioMapStorageActionListener);
        if (iRmDownloadSession != null || !z) {
            return iRmDownloadSession;
        }
        IRmDownloadSession createRmDownloaderSession = this.mPosClientManager.createRmDownloaderSession(iRadioMapStorageActionListener);
        this.mRmDownloaders.put(iRadioMapStorageActionListener, createRmDownloaderSession);
        return createRmDownloaderSession;
    }

    private void releaseRmDownload(RadioMapManager.IRadioMapStorageActionListener iRadioMapStorageActionListener) {
        IRmDownloadSession remove = this.mRmDownloaders.remove(iRadioMapStorageActionListener);
        if (remove != null) {
            remove.close();
        }
    }

    public void close() {
        for (Map.Entry<RadioMapManager.IRadioMapStorageActionListener, IRmDownloadSession> value : this.mRmDownloaders.entrySet()) {
            ((IRmDownloadSession) value.getValue()).close();
        }
        this.mRmDownloaders.clear();
    }

    public boolean startRadioMapQuery(RadioMapManager.RadioMapQueryAction radioMapQueryAction, long j, GeoArea[] geoAreaArr, int i, RadioMapManager.IRadioMapStorageActionListener iRadioMapStorageActionListener) {
        IRmDownloadSession rmDownload = getRmDownload(iRadioMapStorageActionListener, true);
        if (!rmDownload.open()) {
            Log.w(TAG, "startRadioMapQuery: RmDownload.open: failed.", new Object[0]);
            releaseRmDownload(iRadioMapStorageActionListener);
            return false;
        } else if (rmDownload.startRadioMapQuery(radioMapQueryAction, j, geoAreaArr, i)) {
            return true;
        } else {
            Log.w(TAG, "startRadioMapQuery: RmDownload.startRadioMapQuery: failed.", new Object[0]);
            releaseRmDownload(iRadioMapStorageActionListener);
            return false;
        }
    }

    public boolean startRadioMapUpdate(RadioMapManager.RadioMapStorageAction radioMapStorageAction, long j, GeoArea[] geoAreaArr, int i, long j2, RadioMapManager.IRadioMapStorageActionListener iRadioMapStorageActionListener) {
        RadioMapManager.IRadioMapStorageActionListener iRadioMapStorageActionListener2 = iRadioMapStorageActionListener;
        IRmDownloadSession rmDownload = getRmDownload(iRadioMapStorageActionListener2, true);
        if (!rmDownload.open()) {
            Log.w(TAG, "startRadioMapUpdate: RmDownload.open: failed.", new Object[0]);
            releaseRmDownload(iRadioMapStorageActionListener2);
            return false;
        } else if (rmDownload.updateRadioMapCoverage(radioMapStorageAction, j, geoAreaArr, i, j2)) {
            return true;
        } else {
            Log.w(TAG, "startRadioMapUpdate: RmDownload.updateRadioMapCoverage: failed.", new Object[0]);
            releaseRmDownload(iRadioMapStorageActionListener2);
            return false;
        }
    }

    public void stopRadioMapActions(RadioMapManager.IRadioMapStorageActionListener iRadioMapStorageActionListener) {
        IRmDownloadSession rmDownload = getRmDownload(iRadioMapStorageActionListener, false);
        if (rmDownload == null) {
            Log.w(TAG, "stopRadioMapUpdate: RmDownload is null.", new Object[0]);
            return;
        }
        rmDownload.stopRadioMapUpdate();
        releaseRmDownload(iRadioMapStorageActionListener);
    }
}
