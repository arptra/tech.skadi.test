package com.here.services.positioning.analytics.internal;

import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import com.here.odnp.posclient.IPosClientManager;
import com.here.odnp.posclient.analytics.IUsageTrackingSession;
import com.here.odnp.util.Log;
import com.here.posclient.analytics.Tracker;
import com.here.posclient.analytics.UsageTrackingListener;
import com.here.services.internal.IBoundService;
import com.here.services.positioning.analytics.internal.IUsageTrackingClient;

public class UsageTrackingClientService extends IUsageTrackingClient.Stub implements IBoundService {
    private static final String TAG = "services.positioning.analytics.internal.UsageTrackingClientService";
    private final IUsageTrackingSession mSession;

    public static class ListenerBridge implements UsageTrackingListener {
        private UsageTrackingListener mListener;

        public ListenerBridge(UsageTrackingListener usageTrackingListener) {
            this.mListener = usageTrackingListener;
        }

        public void onTrackerUpdated(int i, long[] jArr) {
            Log.i(UsageTrackingClientService.TAG, "onTrackerUpdated: event: %d counter.length: %d", Integer.valueOf(i), Integer.valueOf(jArr.length));
            UsageTrackingListener usageTrackingListener = this.mListener;
            if (usageTrackingListener != null) {
                try {
                    usageTrackingListener.onTrackerUpdated(UsageTrackingUtils.trackerUpdateToBundle(i, jArr));
                } catch (RemoteException unused) {
                    this.mListener = null;
                }
            }
        }
    }

    public UsageTrackingClientService(IPosClientManager iPosClientManager, Intent intent) {
        Log.i(TAG, "UsageTrackingClientService", new Object[0]);
        if (iPosClientManager != null) {
            this.mSession = iPosClientManager.createUsageTrackingSession();
            return;
        }
        throw new IllegalArgumentException("posClientManager is null");
    }

    public Bundle getSupportedTrackers() throws RemoteException {
        Log.i(TAG, "getSupportedTrackers", new Object[0]);
        Tracker[] trackerArr = (Tracker[]) this.mSession.getSupportedTrackers().toArray(new Tracker[0]);
        return trackerArr.length < 1 ? new Bundle() : UsageTrackingUtils.trackersToBundle(trackerArr);
    }

    public int subscribe(UsageTrackingListener usageTrackingListener, Bundle bundle) throws RemoteException {
        Log.i(TAG, "subscribe", new Object[0]);
        return this.mSession.subscribe(new ListenerBridge(usageTrackingListener), UsageTrackingUtils.bundleToArray(bundle)).toInt();
    }

    public void unBind() {
        try {
            unsubscribe();
        } catch (RemoteException e) {
            Log.e(TAG, "onUnbind error", e);
        }
    }

    public int unsubscribe() throws RemoteException {
        Log.i(TAG, "unsubscribe", new Object[0]);
        return this.mSession.unsubscribe().toInt();
    }
}
