package com.here.services.location.internal;

import android.content.Context;

public final class Positioning {
    private Positioning() {
    }

    public static IPositioning open(Context context) {
        return PositioningClient.open(context);
    }
}
