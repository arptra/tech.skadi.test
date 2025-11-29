package com.here.odnp.posclient.analytics;

import com.here.odnp.posclient.ICloseableSession;
import com.here.posclient.Status;
import com.here.posclient.analytics.Tracker;
import com.here.posclient.analytics.UsageTrackingListener;
import java.util.EnumSet;

public interface IUsageTrackingSession extends ICloseableSession {
    EnumSet<Tracker> getSupportedTrackers();

    Status subscribe(UsageTrackingListener usageTrackingListener, Tracker... trackerArr);

    Status unsubscribe();
}
