package com.upuphone.starrynet.api;

import android.util.Log;
import androidx.core.util.Pair;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class StConfiguration {
    private static final String TAG = "StConfiguration";
    private static final List<String> carWithPadList = new CopyOnWriteArrayList();
    private static final List<Pair<String, String>> iccoaBlackList = new CopyOnWriteArrayList();
    private static final List<String> iccoaWhiteApps = new CopyOnWriteArrayList();
    private static final List<String> whiteMusicApps = new CopyOnWriteArrayList();

    public static List<String> getCarWithPadList() {
        return carWithPadList;
    }

    public static List<Pair<String, String>> getIccoaBlackList() {
        return iccoaBlackList;
    }

    public static List<String> getIccoaWhiteApps() {
        return iccoaWhiteApps;
    }

    public static List<String> getWhiteMusicApps() {
        return whiteMusicApps;
    }

    public static void updateCarWithPadList(List<String> list) {
        if (list != null) {
            Log.d("[StLog]", "StConfiguration:updateCarWithPadList, size=" + list.size() + ", list = " + list);
            List<String> list2 = carWithPadList;
            list2.clear();
            list2.addAll(list);
        }
    }

    public static void updateICCOABlackList(List<Pair<String, String>> list) {
        if (list != null) {
            Log.d("[StLog]", "StConfiguration:updateIccoaBlackList, size=" + list.size());
            List<Pair<String, String>> list2 = iccoaBlackList;
            list2.clear();
            list2.addAll(list);
        }
    }

    public static void updateIccoaWhiteApps(List<String> list) {
        if (list != null) {
            Log.d("[StLog]", "StConfiguration:updateIccoaWhiteApps, size=" + list.size());
            List<String> list2 = iccoaWhiteApps;
            list2.clear();
            list2.addAll(list);
        }
    }

    public static void updateWhiteMusicApps(List<String> list) {
        if (list != null) {
            Log.d("[StLog]", "StConfiguration:updateWhiteMusicApps, size=" + list.size());
            List<String> list2 = whiteMusicApps;
            list2.clear();
            list2.addAll(list);
        }
    }
}
