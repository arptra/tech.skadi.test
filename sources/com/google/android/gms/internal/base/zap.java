package com.google.android.gms.internal.base;

import android.os.Build;
import com.here.posclient.PositionEstimate;

public final class zap {
    public static final int zaa = (Build.VERSION.SDK_INT >= 31 ? PositionEstimate.Value.GNSS_TIME : 0);
}
