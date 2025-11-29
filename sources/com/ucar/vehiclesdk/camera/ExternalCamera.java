package com.ucar.vehiclesdk.camera;

import android.util.Range;
import android.util.Size;
import android.view.Surface;
import com.easy.logger.EasyLog;
import com.ucar.vehiclesdk.UCarCommon;
import com.ucar.vehiclesdk.camera.CameraProvider;

public class ExternalCamera implements AbstractCamera {
    public void a(Surface surface, Range range) {
        EasyLog.i("ExternalCamera", "startPreview is not implemented yet");
    }

    public void b(Surface surface, Size size, Range range) {
        EasyLog.i("ExternalCamera", "changeConfiguration is not implemented yet");
    }

    public void c(CameraProvider.ICameraStateCallback iCameraStateCallback) {
        EasyLog.i("ExternalCamera", "open is not implemented yet");
    }

    public void close() {
        EasyLog.i("ExternalCamera", "close is not implemented yet");
    }

    public UCarCommon.CameraInfo getInfo() {
        return null;
    }
}
