package com.here.odnp.posclient.rmm;

import com.here.odnp.posclient.CloseableSession;
import com.here.odnp.posclient.PosClientManager;
import com.here.odnp.util.Log;
import com.here.posclient.RadioMapManager;
import com.here.services.radiomap.common.GeoArea;

public class RmDownloadSession extends CloseableSession implements IRmDownloadSession {
    private static final String TAG = "odnp.posclient.RmDownloadSession";
    private final RadioMapManager.IRadioMapStorageActionListener mListener;
    private boolean mStarted;

    public RmDownloadSession(PosClientManager posClientManager, RadioMapManager.IRadioMapStorageActionListener iRadioMapStorageActionListener) {
        super(posClientManager);
        if (iRadioMapStorageActionListener != null) {
            this.mListener = iRadioMapStorageActionListener;
            return;
        }
        throw new IllegalArgumentException("listener is null");
    }

    public void onClose() {
        if (!this.mPosClientManager.removeRmDownloader(this)) {
            Log.w(TAG, "RmDownloader.onClose: downloader not in downloader set.", new Object[0]);
        }
        this.mListener.onClosed();
    }

    public void onOpen() {
        this.mPosClientManager.addRmDownloader(this);
    }

    public boolean startRadioMapQuery(RadioMapManager.RadioMapQueryAction radioMapQueryAction, long j, GeoArea[] geoAreaArr, int i) {
        Log.v(TAG, "RmDownloader.startRadioMapQuery", new Object[0]);
        stopRadioMapUpdate();
        boolean onStartRadioMapQuery = this.mPosClientManager.onStartRadioMapQuery(radioMapQueryAction, j, geoAreaArr, i, this.mListener);
        this.mStarted = onStartRadioMapQuery;
        return onStartRadioMapQuery;
    }

    public void stopRadioMapUpdate() {
        Log.v(TAG, "RmDownloader.stopRadioMapUpdate", new Object[0]);
        if (this.mStarted) {
            this.mStarted = false;
            this.mPosClientManager.onStopRadioMapUpdate(this.mListener);
        }
    }

    public boolean updateRadioMapCoverage(RadioMapManager.RadioMapStorageAction radioMapStorageAction, long j, GeoArea[] geoAreaArr, int i, long j2) {
        Log.v(TAG, "RmDownloader.updateRadioMapCoverage", new Object[0]);
        stopRadioMapUpdate();
        boolean onUpdateRadioMapCoverage = this.mPosClientManager.onUpdateRadioMapCoverage(radioMapStorageAction, j, geoAreaArr, i, j2, this.mListener);
        this.mStarted = onUpdateRadioMapCoverage;
        return onUpdateRadioMapCoverage;
    }
}
