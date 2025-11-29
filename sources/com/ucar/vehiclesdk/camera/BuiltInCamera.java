package com.ucar.vehiclesdk.camera;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.os.Handler;
import android.util.Range;
import android.util.Size;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.easy.logger.EasyLog;
import com.ucar.vehiclesdk.UCarCommon;
import com.ucar.vehiclesdk.camera.CameraProvider;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicBoolean;

public class BuiltInCamera implements AbstractCamera {

    /* renamed from: a  reason: collision with root package name */
    public final CameraManager f5406a;
    public final String b;
    public final String c;
    public CameraDevice d = null;
    public CaptureRequest.Builder e = null;
    public CameraCaptureSession f = null;
    public Surface g;
    public final AtomicBoolean h = new AtomicBoolean(false);
    public final CameraCaptureSession.StateCallback i = new CameraCaptureSession.StateCallback() {
        public void onConfigureFailed(CameraCaptureSession cameraCaptureSession) {
            EasyLog.c("BuiltInCamera", "onConfigureFailed");
            BuiltInCamera.this.h.set(false);
        }

        public void onConfigured(CameraCaptureSession cameraCaptureSession) {
            if (!BuiltInCamera.this.h.get()) {
                EasyLog.a("BuiltInCamera", "onConfigured, camera " + BuiltInCamera.this.b + " has closed");
                return;
            }
            CameraCaptureSession unused = BuiltInCamera.this.f = cameraCaptureSession;
            try {
                BuiltInCamera.this.f.setRepeatingRequest(BuiltInCamera.this.e.build(), (CameraCaptureSession.CaptureCallback) null, (Handler) null);
            } catch (CameraAccessException | IllegalStateException e) {
                BuiltInCamera.this.h.set(false);
                EasyLog.c("BuiltInCamera", "onConfigured, setRepeatingRequest: " + e.getMessage());
            }
        }
    };

    public BuiltInCamera(CameraManager cameraManager, String str, String str2) {
        this.f5406a = cameraManager;
        this.b = str;
        this.c = str2;
    }

    public void a(Surface surface, Range range) {
        try {
            CaptureRequest.Builder createCaptureRequest = this.d.createCaptureRequest(1);
            this.e = createCaptureRequest;
            createCaptureRequest.set(CaptureRequest.CONTROL_AF_MODE, 3);
            this.e.set(CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE, range);
            this.e.addTarget(surface);
            this.g = surface;
            this.d.createCaptureSession(Collections.singletonList(surface), this.i, (Handler) null);
        } catch (CameraAccessException e2) {
            this.h.set(false);
            EasyLog.c("BuiltInCamera", "startPreview, createCaptureSession: " + e2.getMessage());
        }
    }

    public void b(Surface surface, Size size, Range range) {
        CameraCaptureSession cameraCaptureSession = this.f;
        if (cameraCaptureSession != null) {
            try {
                cameraCaptureSession.stopRepeating();
            } catch (CameraAccessException e2) {
                EasyLog.c("BuiltInCamera", "changeConfiguration, stopRepeating: " + e2.getMessage());
            }
        }
        CaptureRequest.Builder builder = this.e;
        if (builder != null && this.d != null) {
            builder.removeTarget(this.g);
            this.g = surface;
            this.e.addTarget(surface);
            try {
                this.d.createCaptureSession(Collections.singletonList(surface), this.i, (Handler) null);
            } catch (CameraAccessException e3) {
                this.h.set(false);
                EasyLog.c("BuiltInCamera", "changeConfiguration, createCaptureSession: " + e3.getMessage());
            }
        }
    }

    public void c(final CameraProvider.ICameraStateCallback iCameraStateCallback) {
        EasyLog.a("BuiltInCamera", "open");
        try {
            this.f5406a.openCamera(this.b, new CameraDevice.StateCallback() {
                public void onClosed(CameraDevice cameraDevice) {
                    BuiltInCamera.this.h.set(false);
                    CameraDevice unused = BuiltInCamera.this.d = null;
                    iCameraStateCallback.onClosed();
                }

                public void onDisconnected(CameraDevice cameraDevice) {
                    BuiltInCamera.this.h.set(false);
                    CameraDevice unused = BuiltInCamera.this.d = null;
                    iCameraStateCallback.onDisconnected();
                }

                public void onError(CameraDevice cameraDevice, int i) {
                    BuiltInCamera.this.h.set(false);
                    CameraDevice unused = BuiltInCamera.this.d = null;
                    iCameraStateCallback.onError(i, "");
                }

                public void onOpened(CameraDevice cameraDevice) {
                    BuiltInCamera.this.h.set(true);
                    CameraDevice unused = BuiltInCamera.this.d = cameraDevice;
                    iCameraStateCallback.a();
                }
            }, (Handler) null);
        } catch (CameraAccessException | IllegalArgumentException e2) {
            this.h.set(false);
            EasyLog.c("BuiltInCamera", "open, openCamera: " + e2.getMessage());
            iCameraStateCallback.onError(-1, e2.getMessage());
        }
    }

    public void close() {
        EasyLog.a("BuiltInCamera", "close");
        this.h.set(false);
        CameraCaptureSession cameraCaptureSession = this.f;
        if (cameraCaptureSession != null) {
            try {
                cameraCaptureSession.stopRepeating();
                this.f = null;
            } catch (CameraAccessException | IllegalStateException e2) {
                EasyLog.c("BuiltInCamera", "close, stopRepeating: " + e2.getMessage());
            }
        }
        CameraDevice cameraDevice = this.d;
        if (cameraDevice != null) {
            cameraDevice.close();
            this.d = null;
        }
    }

    public UCarCommon.CameraInfo getInfo() {
        CameraCharacteristics cameraCharacteristics = this.f5406a.getCameraCharacteristics(this.b);
        int intValue = ((Integer) cameraCharacteristics.get(CameraCharacteristics.LENS_FACING)).intValue();
        if (intValue == 0) {
            intValue = 1;
        } else if (intValue == 1) {
            intValue = 0;
        }
        return new UCarCommon.CameraInfo(this.b, this.c, UCarCommon.LensFacing.fromInt(intValue), UCarCommon.Orientation.fromInt(((Integer) cameraCharacteristics.get(CameraCharacteristics.SENSOR_ORIENTATION)).intValue()), ((StreamConfigurationMap) cameraCharacteristics.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP)).getOutputSizes(SurfaceHolder.class), (Range[]) cameraCharacteristics.get(CameraCharacteristics.CONTROL_AE_AVAILABLE_TARGET_FPS_RANGES));
    }
}
