package com.here.posclient.ext;

import com.here.odnp.util.Log;
import com.here.posclient.Status;
import com.here.posclient.analytics.Tracker;
import com.here.posclient.analytics.UsageTrackingListener;
import java.util.EnumSet;
import java.util.HashSet;

public class UsageTracking {
    private static final String TAG = "posclient.ext.UsageTracking";

    private UsageTracking() {
    }

    public static EnumSet<Tracker> getSupportedTrackers() {
        return trackersFromBitmask(supportedTrackers());
    }

    private static native int subscribe(UsageTrackingListener usageTrackingListener, long j);

    public static Status subscribe(UsageTrackingListener usageTrackingListener, Tracker... trackerArr) {
        long trackersToBitmask = trackersToBitmask(trackerArr);
        if (trackersToBitmask == 0) {
            return Status.UsageError;
        }
        return Status.fromInt(subscribe(usageTrackingListener, trackersToBitmask));
    }

    private static native long supportedTrackers();

    private static EnumSet<Tracker> trackersFromBitmask(long j) {
        Log.v(TAG, "trackersToBitmask: trackers: 0x%s", Long.toHexString(j));
        if (j == 0) {
            return EnumSet.noneOf(Tracker.class);
        }
        HashSet hashSet = new HashSet();
        for (Tracker tracker : Tracker.values()) {
            long j2 = tracker.mValue;
            if ((j & j2) == j2) {
                hashSet.add(tracker);
            }
        }
        return EnumSet.copyOf(hashSet);
    }

    private static long trackersToBitmask(Tracker[] trackerArr) {
        Log.v(TAG, "trackersToBitmask: trackers.length: %d", Integer.valueOf(trackerArr.length));
        long j = 0;
        for (Tracker tracker : trackerArr) {
            if (tracker == null) {
                return 0;
            }
            j |= tracker.mValue;
        }
        return j;
    }

    public static native int unsubscribe();
}
