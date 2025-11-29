package com.here.services.positioning.analytics;

import com.here.posclient.Status;
import com.here.posclient.analytics.PositioningCounters;
import com.here.posclient.analytics.RadiomapCounters;
import com.here.posclient.analytics.Tracker;
import com.here.services.HereLocationApiClient;
import java.util.EnumSet;

public interface UsageTrackingApi {

    public interface Listener {
        void onPositioningCountersUpdated(PositioningCounters positioningCounters);

        void onRadiomapCountersUpdated(RadiomapCounters radiomapCounters);
    }

    EnumSet<Tracker> getSupportedTrackers(HereLocationApiClient hereLocationApiClient);

    Status subscribe(HereLocationApiClient hereLocationApiClient, Listener listener, Tracker... trackerArr);
}
