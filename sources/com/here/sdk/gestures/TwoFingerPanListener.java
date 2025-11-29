package com.here.sdk.gestures;

import androidx.annotation.NonNull;
import com.here.sdk.core.Point2D;

public interface TwoFingerPanListener {
    void onTwoFingerPan(@NonNull GestureState gestureState, @NonNull Point2D point2D, @NonNull Point2D point2D2, double d);
}
