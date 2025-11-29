package com.ucar.vehiclesdk.camera;

import android.content.Context;
import android.hardware.camera2.CameraManager;
import android.util.Log;
import android.util.Range;
import android.util.Size;
import androidx.core.content.ContextCompat;
import com.easy.logger.EasyLog;
import com.ucar.vehiclesdk.UCarAdapter;
import com.ucar.vehiclesdk.UCarCommon;
import com.ucar.vehiclesdk.camera.VideoEncoder;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class CameraProvider {
    public static short h;

    /* renamed from: a  reason: collision with root package name */
    public Context f5411a;
    public CameraManager b;
    public final Map c;
    public VideoEncoder d;
    public String e;
    public String f;
    public final VideoEncoder.Callback g;

    /* renamed from: com.ucar.vehiclesdk.camera.CameraProvider$1  reason: invalid class name */
    class AnonymousClass1 extends CameraManager.AvailabilityCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CameraProvider f5412a;

        public void onCameraAvailable(String str) {
            EasyLog.a("CameraProvider", "onCameraAvailable " + str);
            if (str.equals(this.f5412a.f)) {
                String unused = this.f5412a.f = null;
            } else if (str.equals(this.f5412a.e)) {
                UCarAdapter.R0().F1(str, UCarCommon.CameraState.CAMERA_STATE_PREEMPTED);
            }
        }

        public void onCameraUnavailable(String str) {
            EasyLog.a("CameraProvider", "onCameraUnavailable " + str);
        }
    }

    /* renamed from: com.ucar.vehiclesdk.camera.CameraProvider$2  reason: invalid class name */
    public class AnonymousClass2 implements VideoEncoder.Callback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CameraProvider f5413a;

        public void a(ByteBuffer byteBuffer, int i) {
            UCarAdapter.R0().e2(UCarCommon.VideoType.STREAM_CAMERA_PREVIEW, byteBuffer, CameraProvider.d());
        }

        public void b(String str) {
            UCarAdapter.R0().F1(this.f5413a.e, UCarCommon.CameraState.CAMERA_STATE_ERROR);
        }
    }

    /* renamed from: com.ucar.vehiclesdk.camera.CameraProvider$4  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass4 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f5415a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.ucar.vehiclesdk.UCarCommon$CameraAction[] r0 = com.ucar.vehiclesdk.UCarCommon.CameraAction.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f5415a = r0
                com.ucar.vehiclesdk.UCarCommon$CameraAction r1 = com.ucar.vehiclesdk.UCarCommon.CameraAction.CAMERA_OPEN     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f5415a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.ucar.vehiclesdk.UCarCommon$CameraAction r1 = com.ucar.vehiclesdk.UCarCommon.CameraAction.CAMERA_CLOSE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.ucar.vehiclesdk.camera.CameraProvider.AnonymousClass4.<clinit>():void");
        }
    }

    public interface ICameraStateCallback {
        void a();

        void onClosed();

        void onDisconnected();

        void onError(int i, String str);
    }

    public static /* synthetic */ short d() {
        short s = h;
        h = (short) (s + 1);
        return s;
    }

    public void finalize() {
        try {
            n();
        } finally {
            super.finalize();
        }
    }

    public void h(AbstractCamera abstractCamera) {
        try {
            UCarAdapter.R0().J0(abstractCamera.getInfo());
            this.c.put(abstractCamera.getInfo().b(), abstractCamera);
        } catch (Exception e2) {
            EasyLog.c("CameraProvider", "addCamera" + e2.getMessage());
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002f, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void i(java.lang.String r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            if (r3 != 0) goto L_0x0005
            monitor-exit(r2)
            return
        L_0x0005:
            r2.f = r3     // Catch:{ all -> 0x0023 }
            r0 = 0
            r2.e = r0     // Catch:{ all -> 0x0023 }
            r1 = 0
            h = r1     // Catch:{ all -> 0x0023 }
            java.util.Map r1 = r2.c     // Catch:{ all -> 0x0023 }
            boolean r1 = r1.containsKey(r3)     // Catch:{ all -> 0x0023 }
            if (r1 == 0) goto L_0x0025
            java.util.Map r1 = r2.c     // Catch:{ all -> 0x0023 }
            java.lang.Object r3 = r1.get(r3)     // Catch:{ all -> 0x0023 }
            com.ucar.vehiclesdk.camera.AbstractCamera r3 = (com.ucar.vehiclesdk.camera.AbstractCamera) r3     // Catch:{ all -> 0x0023 }
            if (r3 == 0) goto L_0x0025
            r3.close()     // Catch:{ all -> 0x0023 }
            goto L_0x0025
        L_0x0023:
            r3 = move-exception
            goto L_0x0030
        L_0x0025:
            com.ucar.vehiclesdk.camera.VideoEncoder r3 = r2.d     // Catch:{ all -> 0x0023 }
            if (r3 == 0) goto L_0x002e
            r3.d()     // Catch:{ all -> 0x0023 }
            r2.d = r0     // Catch:{ all -> 0x0023 }
        L_0x002e:
            monitor-exit(r2)
            return
        L_0x0030:
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ucar.vehiclesdk.camera.CameraProvider.i(java.lang.String):void");
    }

    public void j(String str, UCarCommon.CameraAction cameraAction, Size size, Range range) {
        Log.d("CameraProvider", "onCarCameraRequest action = " + cameraAction);
        int i = AnonymousClass4.f5415a[cameraAction.ordinal()];
        if (i != 1) {
            if (i == 2) {
                i(str);
            }
        } else if (ContextCompat.checkSelfPermission(this.f5411a, "android.permission.CAMERA") != 0) {
            UCarAdapter.R0().F1(str, UCarCommon.CameraState.CAMERA_STATE_NO_PERMISSION);
        } else {
            k(str, size, range);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00d3, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void k(java.lang.String r9, android.util.Size r10, android.util.Range r11) {
        /*
            r8 = this;
            monitor-enter(r8)
            java.lang.String r0 = "CameraProvider"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x005f }
            r1.<init>()     // Catch:{ all -> 0x005f }
            java.lang.String r2 = "openCamera cameraId="
            r1.append(r2)     // Catch:{ all -> 0x005f }
            r1.append(r9)     // Catch:{ all -> 0x005f }
            java.lang.String r2 = ", width="
            r1.append(r2)     // Catch:{ all -> 0x005f }
            int r2 = r10.getWidth()     // Catch:{ all -> 0x005f }
            r1.append(r2)     // Catch:{ all -> 0x005f }
            java.lang.String r2 = ", height="
            r1.append(r2)     // Catch:{ all -> 0x005f }
            int r2 = r10.getHeight()     // Catch:{ all -> 0x005f }
            r1.append(r2)     // Catch:{ all -> 0x005f }
            java.lang.String r2 = ", fpsRange=("
            r1.append(r2)     // Catch:{ all -> 0x005f }
            java.lang.Comparable r2 = r11.getLower()     // Catch:{ all -> 0x005f }
            r1.append(r2)     // Catch:{ all -> 0x005f }
            java.lang.String r2 = ", "
            r1.append(r2)     // Catch:{ all -> 0x005f }
            java.lang.Comparable r2 = r11.getUpper()     // Catch:{ all -> 0x005f }
            r1.append(r2)     // Catch:{ all -> 0x005f }
            java.lang.String r2 = ")"
            r1.append(r2)     // Catch:{ all -> 0x005f }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x005f }
            com.easy.logger.EasyLog.a(r0, r1)     // Catch:{ all -> 0x005f }
            java.lang.String r0 = r9.trim()     // Catch:{ all -> 0x005f }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x005f }
            if (r0 == 0) goto L_0x0062
            java.lang.String r9 = "CameraProvider"
            java.lang.String r10 = "openCamera: cameraId should never be empty"
            com.easy.logger.EasyLog.i(r9, r10)     // Catch:{ all -> 0x005f }
            monitor-exit(r8)
            return
        L_0x005f:
            r9 = move-exception
            goto L_0x0100
        L_0x0062:
            java.util.Map r0 = r8.c     // Catch:{ all -> 0x005f }
            java.lang.Object r0 = r0.get(r9)     // Catch:{ all -> 0x005f }
            com.ucar.vehiclesdk.camera.AbstractCamera r0 = (com.ucar.vehiclesdk.camera.AbstractCamera) r0     // Catch:{ all -> 0x005f }
            if (r0 != 0) goto L_0x0089
            java.lang.String r10 = "CameraProvider"
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x005f }
            r11.<init>()     // Catch:{ all -> 0x005f }
            java.lang.String r0 = "openCamera: camera:"
            r11.append(r0)     // Catch:{ all -> 0x005f }
            r11.append(r9)     // Catch:{ all -> 0x005f }
            java.lang.String r9 = " is not available"
            r11.append(r9)     // Catch:{ all -> 0x005f }
            java.lang.String r9 = r11.toString()     // Catch:{ all -> 0x005f }
            com.easy.logger.EasyLog.i(r10, r9)     // Catch:{ all -> 0x005f }
            monitor-exit(r8)
            return
        L_0x0089:
            java.lang.String r1 = r8.e     // Catch:{ all -> 0x005f }
            boolean r1 = r9.equals(r1)     // Catch:{ all -> 0x005f }
            if (r1 == 0) goto L_0x00d4
            java.lang.String r1 = "CameraProvider"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x005f }
            r2.<init>()     // Catch:{ all -> 0x005f }
            java.lang.String r3 = "openCamera: already exist, configure camera:"
            r2.append(r3)     // Catch:{ all -> 0x005f }
            r2.append(r9)     // Catch:{ all -> 0x005f }
            java.lang.String r9 = r2.toString()     // Catch:{ all -> 0x005f }
            com.easy.logger.EasyLog.a(r1, r9)     // Catch:{ all -> 0x005f }
            com.ucar.vehiclesdk.camera.VideoEncoder r9 = r8.d     // Catch:{ all -> 0x005f }
            if (r9 == 0) goto L_0x00b1
            r9.d()     // Catch:{ all -> 0x005f }
            r9 = 0
            r8.d = r9     // Catch:{ all -> 0x005f }
        L_0x00b1:
            com.ucar.vehiclesdk.camera.VideoEncoder r9 = new com.ucar.vehiclesdk.camera.VideoEncoder     // Catch:{ all -> 0x005f }
            java.lang.Comparable r1 = r11.getUpper()     // Catch:{ all -> 0x005f }
            java.lang.Integer r1 = (java.lang.Integer) r1     // Catch:{ all -> 0x005f }
            int r1 = r1.intValue()     // Catch:{ all -> 0x005f }
            com.ucar.vehiclesdk.camera.VideoEncoder$Callback r2 = r8.g     // Catch:{ all -> 0x005f }
            r9.<init>(r10, r1, r2)     // Catch:{ all -> 0x005f }
            r8.d = r9     // Catch:{ all -> 0x005f }
            android.view.Surface r9 = r9.a()     // Catch:{ all -> 0x005f }
            if (r9 == 0) goto L_0x00d2
            r0.b(r9, r10, r11)     // Catch:{ all -> 0x005f }
            com.ucar.vehiclesdk.camera.VideoEncoder r9 = r8.d     // Catch:{ all -> 0x005f }
            r9.c()     // Catch:{ all -> 0x005f }
        L_0x00d2:
            monitor-exit(r8)
            return
        L_0x00d4:
            java.lang.String r1 = r8.e     // Catch:{ all -> 0x005f }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x005f }
            if (r1 != 0) goto L_0x00eb
            java.util.Map r1 = r8.c     // Catch:{ all -> 0x005f }
            java.lang.String r2 = r8.e     // Catch:{ all -> 0x005f }
            java.lang.Object r1 = r1.get(r2)     // Catch:{ all -> 0x005f }
            com.ucar.vehiclesdk.camera.AbstractCamera r1 = (com.ucar.vehiclesdk.camera.AbstractCamera) r1     // Catch:{ all -> 0x005f }
            if (r1 == 0) goto L_0x00eb
            r1.close()     // Catch:{ all -> 0x005f }
        L_0x00eb:
            r1 = 0
            h = r1     // Catch:{ all -> 0x005f }
            com.ucar.vehiclesdk.camera.CameraProvider$3 r7 = new com.ucar.vehiclesdk.camera.CameraProvider$3     // Catch:{ all -> 0x005f }
            r1 = r7
            r2 = r8
            r3 = r9
            r4 = r10
            r5 = r11
            r6 = r0
            r1.<init>(r3, r4, r5, r6)     // Catch:{ all -> 0x005f }
            r0.c(r7)     // Catch:{ all -> 0x005f }
            r8.e = r9     // Catch:{ all -> 0x005f }
            monitor-exit(r8)
            return
        L_0x0100:
            monitor-exit(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ucar.vehiclesdk.camera.CameraProvider.k(java.lang.String, android.util.Size, android.util.Range):void");
    }

    public void l(ArrayList arrayList) {
        EasyLog.a("CameraProvider", "registerCarCameras: register android builtin Cameras");
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            UCarCommon.CameraInfo cameraInfo = (UCarCommon.CameraInfo) it.next();
            String b2 = cameraInfo.b();
            if (!this.c.containsKey(b2)) {
                h(new BuiltInCamera(this.b, b2, cameraInfo.d()));
            }
        }
    }

    public void m(ArrayList arrayList) {
        EasyLog.i("CameraProvider", "registerExternalCarCameras: This feature is not implemented yet");
    }

    public void n() {
        i(this.e);
        this.c.clear();
    }

    public void o() {
        try {
            EasyLog.a("CameraProvider", "unregister all Cameras");
            UCarAdapter.R0().b2((String[]) this.c.keySet().toArray(new String[this.c.size()]));
            n();
        } catch (Exception e2) {
            EasyLog.c("CameraProvider", "unregisterCameras" + e2.getMessage());
        }
    }
}
