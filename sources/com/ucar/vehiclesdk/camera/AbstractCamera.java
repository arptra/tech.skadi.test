package com.ucar.vehiclesdk.camera;

import android.util.Range;
import android.util.Size;
import android.view.Surface;
import com.ucar.vehiclesdk.UCarCommon;
import com.ucar.vehiclesdk.camera.CameraProvider;

public interface AbstractCamera {
    void a(Surface surface, Range range);

    void b(Surface surface, Size size, Range range);

    void c(CameraProvider.ICameraStateCallback iCameraStateCallback);

    void close();

    UCarCommon.CameraInfo getInfo();
}
