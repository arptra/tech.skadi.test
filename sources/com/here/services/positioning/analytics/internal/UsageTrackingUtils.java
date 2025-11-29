package com.here.services.positioning.analytics.internal;

import android.os.Bundle;
import com.here.posclient.analytics.Counters;
import com.here.posclient.analytics.Tracker;
import java.util.Arrays;
import java.util.EnumSet;

public class UsageTrackingUtils {
    private static final String KEY_COUNTERS = "tracker.counters";
    private static final String KEY_EVENT = "tracker.event";
    private static final String KEY_TRACKERS = "trackers.list";

    public static Tracker[] bundleToArray(Bundle bundle) {
        return bundle == null ? new Tracker[0] : (Tracker[]) bundleToEnumSet(bundle).toArray(new Tracker[0]);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x000a, code lost:
        r2 = (java.util.EnumSet) r2.getSerializable(KEY_TRACKERS);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.EnumSet<com.here.posclient.analytics.Tracker> bundleToEnumSet(android.os.Bundle r2) {
        /*
            if (r2 == 0) goto L_0x0013
            java.lang.String r0 = "trackers.list"
            boolean r1 = r2.containsKey(r0)
            if (r1 == 0) goto L_0x0013
            java.io.Serializable r2 = r2.getSerializable(r0)
            java.util.EnumSet r2 = (java.util.EnumSet) r2
            if (r2 == 0) goto L_0x0013
            return r2
        L_0x0013:
            java.lang.Class<com.here.posclient.analytics.Tracker> r2 = com.here.posclient.analytics.Tracker.class
            java.util.EnumSet r2 = java.util.EnumSet.noneOf(r2)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.here.services.positioning.analytics.internal.UsageTrackingUtils.bundleToEnumSet(android.os.Bundle):java.util.EnumSet");
    }

    public static void trackerUpdateFromBundle(Bundle bundle, Counters.Handler handler) {
        if (bundle != null && bundle.containsKey(KEY_COUNTERS) && bundle.containsKey(KEY_EVENT)) {
            Counters.parse(bundle.getInt(KEY_EVENT), bundle.getLongArray(KEY_COUNTERS), handler);
        }
    }

    public static Bundle trackerUpdateToBundle(int i, long[] jArr) {
        Bundle bundle = new Bundle();
        bundle.putInt(KEY_EVENT, i);
        bundle.putLongArray(KEY_COUNTERS, jArr);
        return bundle;
    }

    public static Bundle trackersToBundle(Tracker... trackerArr) {
        Bundle bundle = new Bundle();
        if (!(trackerArr == null || trackerArr.length == 0)) {
            bundle.putSerializable(KEY_TRACKERS, EnumSet.copyOf(Arrays.asList(trackerArr)));
        }
        return bundle;
    }

    public static Bundle trackersToBundle(EnumSet<Tracker> enumSet) {
        if (enumSet == null) {
            return new Bundle();
        }
        return trackersToBundle((Tracker[]) enumSet.toArray(new Tracker[0]));
    }
}
