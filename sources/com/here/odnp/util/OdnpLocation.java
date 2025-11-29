package com.here.odnp.util;

import android.location.Location;
import android.os.Bundle;

public final class OdnpLocation {
    private OdnpLocation() {
    }

    public static void clearExtras(Location location) {
        location.setExtras(new Bundle());
    }

    private static Bundle getExtrasOrEmpty(Location location) {
        Bundle extras = location.getExtras();
        if (extras != null) {
            return extras;
        }
        clearExtras(location);
        return location.getExtras();
    }

    public static void putExtraString(Location location, String str, String str2) {
        Bundle extrasOrEmpty = getExtrasOrEmpty(location);
        extrasOrEmpty.putString(str, str2);
        location.setExtras(extrasOrEmpty);
    }
}
