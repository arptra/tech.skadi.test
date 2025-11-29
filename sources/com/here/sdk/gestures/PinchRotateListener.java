package com.here.sdk.gestures;

import androidx.annotation.NonNull;
import com.here.sdk.core.Angle;
import com.here.sdk.core.Point2D;

public interface PinchRotateListener {
    void onPinchRotate(@NonNull GestureState gestureState, @NonNull Point2D point2D, @NonNull Point2D point2D2, double d, @NonNull Angle angle);
}
