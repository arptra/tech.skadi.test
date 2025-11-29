package com.here.services.positioning.analytics;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.here.odnp.util.Log;
import com.here.posclient.Status;
import com.here.posclient.analytics.Counters;
import com.here.posclient.analytics.PositioningCounters;
import com.here.posclient.analytics.RadiomapCounters;
import com.here.posclient.analytics.Tracker;
import com.here.services.HereLocationApiClient;
import com.here.services.internal.ServiceController;
import com.here.services.positioning.analytics.UsageTrackingApi;
import com.here.services.positioning.analytics.internal.UsageTrackingClient;
import com.here.services.positioning.analytics.internal.UsageTrackingListener;
import com.here.services.positioning.analytics.internal.UsageTrackingServicesController;
import com.here.services.positioning.analytics.internal.UsageTrackingUtils;
import java.util.EnumSet;

public class UsageTrackingProvider implements UsageTrackingApi {
    private static final String TAG = "services.positioning.analytics.UsageTrackingProvider";
    private final ServiceController.Provider<UsageTrackingServicesController> mProvider;

    public static class ListenerBridge extends UsageTrackingListener.Stub {
        final UsageTrackingApi.Listener mListener;

        public ListenerBridge(UsageTrackingApi.Listener listener) {
            this.mListener = listener;
        }

        public void onTrackerUpdated(Bundle bundle) throws RemoteException {
            if (this.mListener != null) {
                UsageTrackingUtils.trackerUpdateFromBundle(bundle, new Counters.Handler() {
                    public void onHandlePositioningCounters(PositioningCounters positioningCounters) {
                        ListenerBridge.this.mListener.onPositioningCountersUpdated(positioningCounters);
                    }

                    public void onHandleRadiomapCounters(RadiomapCounters radiomapCounters) {
                        ListenerBridge.this.mListener.onRadiomapCountersUpdated(radiomapCounters);
                    }
                });
            }
        }
    }

    public UsageTrackingProvider(Context context, ServiceController.Provider<UsageTrackingServicesController> provider) {
        if (provider != null) {
            this.mProvider = provider;
            return;
        }
        throw new IllegalArgumentException("provider is null");
    }

    public UsageTrackingClient getClient(HereLocationApiClient hereLocationApiClient) {
        UsageTrackingServicesController controller = this.mProvider.getController(hereLocationApiClient);
        if (controller != null) {
            return controller.getUsageTrackingClient();
        }
        Log.e(TAG, "getClient: controller is null, usagetracking client instance not available", new Object[0]);
        return null;
    }

    public EnumSet<Tracker> getSupportedTrackers(HereLocationApiClient hereLocationApiClient) {
        UsageTrackingClient client = getClient(hereLocationApiClient);
        if (client == null) {
            return null;
        }
        return client.getSupportedTrackers();
    }

    public Status subscribe(HereLocationApiClient hereLocationApiClient, UsageTrackingApi.Listener listener, Tracker... trackerArr) {
        UsageTrackingClient client = getClient(hereLocationApiClient);
        return client == null ? Status.UsageError : client.subscribe(new ListenerBridge(listener), trackerArr);
    }
}
