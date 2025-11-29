package com.ucar.vehiclesdk.camera;

import android.util.Range;
import android.util.Size;
import com.easy.logger.EasyLog;
import com.share.connect.channel.ConnectChannel;
import com.ucar.databus.proto.UCarProto;
import com.ucar.protocol.CmdCategory;
import com.ucar.protocol.DataFormat;
import com.ucar.protocol.MessageType;
import com.ucar.protocol.ProtocolConfig;
import com.ucar.protocol.UCarMessage;
import com.ucar.protocol.channel.ChannelType;
import com.ucar.protocol.channel.SendFutureCallback;
import com.ucar.vehiclesdk.ICameraInfoListener;
import com.ucar.vehiclesdk.UCarCommon;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;

public class CameraManager {
    public static CameraProvider f;

    /* renamed from: a  reason: collision with root package name */
    public ICameraInfoListener f5409a;
    public ConnectChannel b;
    public Future c;
    public AtomicBoolean d;
    public AtomicBoolean e;

    public static UCarProto.NotifyAddCamera b(UCarCommon.CameraInfo cameraInfo) {
        try {
            Size[] e2 = cameraInfo.e();
            Range[] a2 = cameraInfo.a();
            UCarProto.NotifyAddCamera.Builder maxSize = UCarProto.NotifyAddCamera.newBuilder().setCameraId(cameraInfo.b()).setName(cameraInfo.d()).setLensFacingValue(cameraInfo.c().getValue()).setOrientationValue(UCarCommon.Orientation.ORIENTATION_0.getValue()).setMaxSize(UCarProto.PictureSize.newBuilder().setWidth(e2[0].getWidth()).setHeight(e2[0].getHeight()).build());
            for (Size size : e2) {
                maxSize.addSupportedSizes(UCarProto.PictureSize.newBuilder().setWidth(size.getWidth()).setHeight(size.getHeight()).build());
            }
            for (Range range : a2) {
                maxSize.addFpsRanges(UCarProto.FpsRange.newBuilder().setMax(((Integer) range.getUpper()).intValue()).setMin(((Integer) range.getLower()).intValue()).build());
            }
            return maxSize.build();
        } catch (Exception e3) {
            EasyLog.c("Vehicle_CameraManager", "createNotifyAddMessage" + e3.getMessage());
            return null;
        }
    }

    public static UCarProto.NotifyRemoveCamera c(String[] strArr) {
        try {
            return UCarProto.NotifyRemoveCamera.newBuilder().addAllIds(Arrays.asList(strArr)).build();
        } catch (Exception e2) {
            EasyLog.c("Vehicle_CameraManager", "createNotifyRemoveMessage" + e2.getMessage());
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0008, code lost:
        r1 = r1.b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean d() {
        /*
            r1 = this;
            java.util.concurrent.atomic.AtomicBoolean r0 = r1.e
            boolean r0 = r0.get()
            if (r0 == 0) goto L_0x0014
            com.share.connect.channel.ConnectChannel r1 = r1.b
            if (r1 == 0) goto L_0x0014
            boolean r1 = r1.p0()
            if (r1 == 0) goto L_0x0014
            r1 = 1
            goto L_0x0015
        L_0x0014:
            r1 = 0
        L_0x0015:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ucar.vehiclesdk.camera.CameraManager.d():boolean");
    }

    public void e(String str, UCarCommon.CameraAction cameraAction, UCarCommon.CameraActionArgs cameraActionArgs) {
        CameraProvider cameraProvider = f;
        if (cameraProvider != null) {
            cameraProvider.j(cameraActionArgs.a(), cameraAction, cameraActionArgs.c(), cameraActionArgs.b());
        }
    }

    public void f(int i) {
        ICameraInfoListener iCameraInfoListener;
        EasyLog.a("Vehicle_CameraManager", "onConnectStateChanged state= " + i);
        if (i == 2) {
            CameraProvider cameraProvider = f;
            if (!(cameraProvider == null || (iCameraInfoListener = this.f5409a) == null)) {
                cameraProvider.l(iCameraInfoListener.b());
                f.m(this.f5409a.a());
            }
            this.d.set(true);
        } else if (i == 1) {
            this.d.set(false);
            j();
            CameraProvider cameraProvider2 = f;
            if (cameraProvider2 != null) {
                cameraProvider2.o();
            }
        }
    }

    public boolean g(UCarCommon.VideoType videoType, ByteBuffer byteBuffer, short s) {
        if (!k()) {
            return false;
        }
        EasyLog.a("Vehicle_CameraManager", "sendCameraData len = " + byteBuffer.remaining() + ", frameNumber=" + s);
        h(byteBuffer, UCarProto.VideoType.forNumber(videoType.getValue()), s);
        return true;
    }

    public final void h(ByteBuffer byteBuffer, UCarProto.VideoType videoType, short s) {
        UCarMessage s2 = UCarMessage.s();
        s2.g().l(byteBuffer.remaining() + 20, s, ProtocolConfig.e(), DataFormat.RAW, MessageType.SEND, CmdCategory.VIDEO, videoType.getNumber());
        s2.w(byteBuffer, byteBuffer.remaining());
        ConnectChannel connectChannel = this.b;
        if (connectChannel != null) {
            connectChannel.O0(s2, new SendFutureCallback() {
                public void c(Exception exc) {
                    EasyLog.d("Vehicle_CameraManager", "send camera data error", exc);
                    CameraManager.this.e.set(false);
                    CameraManager.this.j();
                }

                /* renamed from: d */
                public void a(Boolean bool) {
                    if (!bool.booleanValue()) {
                        EasyLog.a("Vehicle_CameraManager", "send camera data failed");
                    }
                }
            });
        }
    }

    public synchronized void i(String str) {
        try {
            if (this.b == null) {
                this.b = new ConnectChannel(ChannelType.VIDEO, false, false) {
                    public void H0() {
                        EasyLog.a("Vehicle_CameraManager", "camera channel ready.");
                        CameraManager.this.e.set(true);
                    }

                    public void J0(boolean z) {
                        EasyLog.a("Vehicle_CameraManager", "camera channel closed.");
                        CameraManager.this.e.set(false);
                        CameraManager.this.j();
                    }
                };
            }
            if (this.c == null) {
                EasyLog.a("Vehicle_CameraManager", "startCameraChannel start address:" + str);
                this.b.U0(5);
                this.c = this.b.W0(0, str);
            }
        } catch (IOException e2) {
            EasyLog.d("Vehicle_CameraManager", "start camera channel error.", e2);
        } catch (Throwable th) {
            throw th;
        }
    }

    public void j() {
        EasyLog.a("Vehicle_CameraManager", "stopCameraChannel");
        ConnectChannel connectChannel = this.b;
        if (connectChannel != null) {
            connectChannel.c0();
            this.b = null;
        }
        this.c = null;
    }

    public final boolean k() {
        if (this.c != null && !d()) {
            try {
                this.c.get();
                this.c = null;
            } catch (Exception e2) {
                EasyLog.d("Vehicle_CameraManager", "Wait start camera channel error.", e2);
            }
        }
        return d();
    }
}
