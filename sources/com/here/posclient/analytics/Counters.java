package com.here.posclient.analytics;

import com.here.odnp.util.Log;

public class Counters {
    private static final String TAG = "posclient.analytics.Counters";
    public final int event;

    public interface Handler {
        void onHandlePositioningCounters(PositioningCounters positioningCounters);

        void onHandleRadiomapCounters(RadiomapCounters radiomapCounters);
    }

    public Counters(int i) {
        this.event = i;
    }

    public static void parse(int i, long[] jArr, Handler handler) {
        if (i == 111 || i == 121 || i == 131) {
            handler.onHandlePositioningCounters(new PositioningCounters(i, jArr));
        } else if (i == 211 || i == 221) {
            handler.onHandleRadiomapCounters(new RadiomapCounters(i, jArr));
        } else {
            Log.w(TAG, "Unknown tracker event: %d", Integer.valueOf(i));
        }
    }
}
