package com.here.sdk.gestures;

import androidx.annotation.NonNull;
import com.here.sdk.core.Point2D;

public interface LongPressListener {
    void onLongPress(@NonNull GestureState gestureState, @NonNull Point2D point2D);
}
