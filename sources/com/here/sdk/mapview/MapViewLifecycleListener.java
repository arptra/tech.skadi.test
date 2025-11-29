package com.here.sdk.mapview;

import androidx.annotation.NonNull;

public interface MapViewLifecycleListener {
    void onAttach(@NonNull MapViewBase mapViewBase);

    void onDestroy();

    void onDetach(@NonNull MapViewBase mapViewBase);

    void onPause();

    void onResume();
}
