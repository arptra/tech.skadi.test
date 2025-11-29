package com.here.odnp.posclient.analytics;

import android.util.Log;
import com.here.odnp.posclient.CloseableSession;
import com.here.odnp.posclient.PosClientManager;

public abstract class UsageTrackingSession extends CloseableSession implements IUsageTrackingSession {
    private static final String TAG = "odnp.posclient.analytics.UsageTrackingSession";

    public UsageTrackingSession(PosClientManager posClientManager) {
        super(posClientManager);
    }

    public void onClose() {
        if (!this.mPosClientManager.removeUsageTrackingSession(this)) {
            Log.w(TAG, "RmDownloader.onClose: downloader not in downloader set.");
        }
    }

    public void onOpen() {
        this.mPosClientManager.addUsageTrackingSession(this);
    }
}
