package com.ucar.vehiclesdk.control;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Range;
import android.util.Size;
import com.easy.logger.EasyLog;
import com.google.protobuf.ByteString;
import com.honey.account.j3.a;
import com.honey.account.j3.b;
import com.share.connect.channel.ConnectChannel;
import com.ucar.databus.proto.UCarProto;
import com.ucar.protocol.ProtocolParser;
import com.ucar.protocol.UCarControlProtocol;
import com.ucar.protocol.UCarMessage;
import com.ucar.protocol.channel.ChannelType;
import com.ucar.protocol.channel.FutureCallback;
import com.ucar.protocol.channel.SendFutureCallback;
import com.ucar.vehiclesdk.MDevice;
import com.ucar.vehiclesdk.UCarCommon;
import com.ucar.vehiclesdk.UCarConfig;
import com.ucar.vehiclesdk.audio.UCarAudioManager;
import com.xjsd.ai.assistant.protocol.AssistantConstants;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class ControlManager {

    /* renamed from: a  reason: collision with root package name */
    public ConnectChannel f5424a;
    public HandlerThread b;
    public Handler c;
    public boolean d = false;
    public Thread e;
    public boolean f;
    public final Object g = new Object();
    public UCarCommon.PhoneStateInfo h;
    public UCarCommon.CallState i;
    public String j = null;
    public UCarCommon.MusicInfo k;
    public CountDownLatch l;
    public int m;
    public volatile boolean n = false;
    public IPhoneCmdListener o;

    /* renamed from: com.ucar.vehiclesdk.control.ControlManager$17  reason: invalid class name */
    class AnonymousClass17 implements FutureCallback<UCarProto.GetAppListResponse> {
        public void c(Exception exc) {
            EasyLog.f("ControlManager", "GetAppList failed: ", exc);
        }

        /* renamed from: e */
        public void a(UCarProto.GetAppListResponse getAppListResponse) {
            EasyLog.e("ControlManager", "GetAppList succeed");
        }

        /* renamed from: f */
        public UCarProto.GetAppListResponse b(UCarMessage uCarMessage) {
            return UCarControlProtocol.I(uCarMessage);
        }
    }

    /* renamed from: com.ucar.vehiclesdk.control.ControlManager$18  reason: invalid class name */
    class AnonymousClass18 implements FutureCallback<UCarProto.GetAppDetailInfoResponse> {
        public void c(Exception exc) {
            EasyLog.f("ControlManager", "getAppDetailInfo failed: ", exc);
        }

        /* renamed from: e */
        public void a(UCarProto.GetAppDetailInfoResponse getAppDetailInfoResponse) {
            EasyLog.e("ControlManager", "getAppDetailInfo succeed");
        }

        /* renamed from: f */
        public UCarProto.GetAppDetailInfoResponse b(UCarMessage uCarMessage) {
            return UCarControlProtocol.H(uCarMessage);
        }
    }

    /* renamed from: com.ucar.vehiclesdk.control.ControlManager$19  reason: invalid class name */
    class AnonymousClass19 implements SendFutureCallback {
        public void c(Exception exc) {
            EasyLog.d("ControlManager", "invokeApp failed: ", exc);
        }

        /* renamed from: d */
        public void a(Boolean bool) {
            EasyLog.e("ControlManager", "invokeApp succeed");
        }
    }

    /* renamed from: com.ucar.vehiclesdk.control.ControlManager$2  reason: invalid class name */
    class AnonymousClass2 implements SendFutureCallback {
        public void c(Exception exc) {
            EasyLog.d("ControlManager", "sendGotoForeground failed: ", exc);
        }

        /* renamed from: d */
        public void a(Boolean bool) {
            EasyLog.e("ControlManager", "sendGotoForeground succeed");
        }
    }

    /* renamed from: com.ucar.vehiclesdk.control.ControlManager$20  reason: invalid class name */
    class AnonymousClass20 implements SendFutureCallback {
        public void c(Exception exc) {
            EasyLog.d("ControlManager", "sendCallPickUp failed: ", exc);
        }

        /* renamed from: d */
        public void a(Boolean bool) {
            EasyLog.e("ControlManager", "sendCallPickUp succeed");
        }
    }

    /* renamed from: com.ucar.vehiclesdk.control.ControlManager$21  reason: invalid class name */
    class AnonymousClass21 implements SendFutureCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f5432a;

        public void c(Exception exc) {
            EasyLog.d("ControlManager", "notifyCarVrState failed: ", exc);
        }

        /* renamed from: d */
        public void a(Boolean bool) {
            EasyLog.e("ControlManager", "notifyCarVrState " + this.f5432a + " succeed");
        }
    }

    public interface IPhoneCmdListener {
        void a(UCarAudioManager.AudioPlayerControl audioPlayerControl);

        void b();

        void c(UCarCommon.CameraAction cameraAction, UCarCommon.CameraActionArgs cameraActionArgs);

        void d(List list, UCarCommon.AppListState appListState);

        void e(UCarCommon.AudioType audioType, UCarCommon.AudioFormat audioFormat, UCarAudioManager.PlayerState playerState);

        void f(UCarCommon.POIAddress pOIAddress);

        void g(UCarCommon.CallInfo callInfo);

        void h(List list);

        void i(UCarCommon.PhoneStateInfo phoneStateInfo);

        void j(boolean z, UCarCommon.AudioFormat audioFormat, boolean z2, boolean z3, boolean z4);

        void k(UCarProto.AddNotification addNotification);

        void l(UCarCommon.MusicInfo musicInfo);

        void m();

        void n(UCarCommon.BluetoothMacInfo bluetoothMacInfo);

        void o();

        void p(int i, boolean z, int i2, UCarCommon.AppState appState, long j, UCarCommon.VisibleRegion visibleRegion);

        void q(UCarMessage uCarMessage);

        void r(long j);

        void s(UCarCommon.NavigationInfo navigationInfo);

        void t();
    }

    public interface ISendHeartBeatErrorCallback {
        void a();
    }

    public ControlManager() {
        g();
        AnonymousClass1 r1 = new ConnectChannel(ChannelType.CONTROL, false, true) {
            public void H0() {
                super.H0();
                synchronized (ControlManager.this.g) {
                    try {
                        if (ControlManager.this.l != null) {
                            ControlManager.this.l.countDown();
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        };
        this.f5424a = r1;
        r1.S0(new a(this));
        this.h = new UCarCommon.PhoneStateInfo();
    }

    public static UCarCommon.CallState O(int i2) {
        return i2 == 1 ? UCarCommon.CallState.IDLE : i2 == 2 ? UCarCommon.CallState.INCOMING : i2 == 3 ? UCarCommon.CallState.ACTIVE : i2 == 4 ? UCarCommon.CallState.INCOMING : i2 == 5 ? UCarCommon.CallState.DIALING : i2 == 6 ? UCarCommon.CallState.ALERTING : i2 == 7 ? UCarCommon.CallState.ACTIVE : i2 == 8 ? UCarCommon.CallState.HOLDING : UCarCommon.CallState.UNKNOWN_STATE;
    }

    public static String j(UCarProto.NotifyMusicInfo notifyMusicInfo) {
        return notifyMusicInfo.getTitle() + notifyMusicInfo.getAlbumName() + notifyMusicInfo.getArtistName() + notifyMusicInfo.getPlayingTimesMs();
    }

    public final void A(UCarMessage uCarMessage) {
        EasyLog.a("ControlManager", "handlePhoneHeartbeat");
        UCarProto.Heartbeat J = UCarControlProtocol.J(uCarMessage);
        if (J == null) {
            EasyLog.c("ControlManager", "heart beat cannot be null");
            return;
        }
        IPhoneCmdListener iPhoneCmdListener = this.o;
        if (iPhoneCmdListener != null) {
            iPhoneCmdListener.r(J.getTimestamp());
        }
    }

    public final void B(UCarMessage uCarMessage) {
        EasyLog.a("ControlManager", "handlePhoneState");
        UCarProto.NotifyPhoneState P = UCarControlProtocol.P(uCarMessage);
        if (P == null) {
            EasyLog.c("ControlManager", "phone state cannot be null");
            return;
        }
        this.h.e(O(P.getCsValue()));
        this.h.g(P.getIsScreenLocked());
        this.h.j(P.getIsWechatQqCall());
        this.h.i(P.getIsVoiceAssistantActive());
        this.h.d(P.getIsLowPower());
        this.h.f(P.getIsOverheat());
        j0();
        i0(this.h.a());
    }

    /* renamed from: C */
    public final void I(UCarMessage uCarMessage) {
        if (!H()) {
            EasyLog.c("ControlManager", "control socket channel not ready, please check!");
            return;
        }
        int i2 = uCarMessage.i();
        if (i2 == 1) {
            A(uCarMessage);
        } else if (i2 == 17) {
            n(uCarMessage);
        } else if (i2 == 20) {
            r(uCarMessage);
        } else if (i2 == 22) {
            p(uCarMessage);
        } else if (i2 == 24) {
            s(uCarMessage);
        } else if (i2 == 36) {
            x(uCarMessage);
        } else if (i2 == 38) {
            y(uCarMessage);
        } else if (i2 != 39) {
            switch (i2) {
                case 6:
                    t(uCarMessage);
                    return;
                case 7:
                    u(uCarMessage);
                    return;
                case 8:
                    o(uCarMessage);
                    return;
                case 9:
                    B(uCarMessage);
                    return;
                case 10:
                    v(uCarMessage);
                    return;
                case 11:
                    w(uCarMessage);
                    return;
                default:
                    switch (i2) {
                        case 31:
                            m(uCarMessage);
                            return;
                        case 32:
                            l(uCarMessage);
                            return;
                        case 33:
                            z(uCarMessage);
                            return;
                        case 34:
                            q(uCarMessage);
                            return;
                        default:
                            EasyLog.c("ControlManager", "unknown message method type: " + i2);
                            return;
                    }
            }
        } else {
            D(uCarMessage);
        }
    }

    public final void D(UCarMessage uCarMessage) {
        EasyLog.a("ControlManager", "handleTouchPadVibrator");
        UCarProto.TouchPadVibrator S = UCarControlProtocol.S(uCarMessage);
        if (S == null) {
            EasyLog.c("ControlManager", "touchPadVibrator info cannot be null");
            return;
        }
        EasyLog.a("ControlManager", "vibrator:" + S.getVibrator());
    }

    public final UCarProto.ChannelMask E(int i2) {
        if (i2 != 4) {
            if (i2 == 12) {
                return UCarProto.ChannelMask.CHANNEL_STEREO;
            }
            if (i2 != 16) {
                return UCarProto.ChannelMask.UNKNOWN_CHANNEL;
            }
        }
        return UCarProto.ChannelMask.CHANNEL_MONO;
    }

    public final UCarProto.EncodingFormat F(int i2) {
        return i2 != 2 ? i2 != 3 ? i2 != 4 ? i2 != 268435456 ? i2 != 536870912 ? UCarProto.EncodingFormat.UNKNOWN_FORMAT : UCarProto.EncodingFormat.ENCODING_PCM_32BIT : UCarProto.EncodingFormat.ENCODING_PCM_24BIT_PACKED : UCarProto.EncodingFormat.ENCODING_PCM_FLOAT : UCarProto.EncodingFormat.ENCODING_PCM_8BIT : UCarProto.EncodingFormat.ENCODING_PCM_16BIT;
    }

    public final UCarProto.SampleRate G(int i2) {
        return UCarProto.SampleRate.forNumber(i2);
    }

    public final boolean H() {
        ConnectChannel connectChannel = this.f5424a;
        return connectChannel != null && connectChannel.p0();
    }

    public final /* synthetic */ void J(UCarMessage uCarMessage) {
        if (uCarMessage == null) {
            EasyLog.c("ControlManager", "received message cannot be null");
            return;
        }
        Handler handler = this.c;
        if (handler != null) {
            handler.post(new b(this, uCarMessage));
        }
    }

    public final int K(UCarProto.ChannelMask channelMask) {
        if (channelMask.equals(UCarProto.ChannelMask.CHANNEL_MONO)) {
            return 16;
        }
        return channelMask.equals(UCarProto.ChannelMask.CHANNEL_STEREO) ? 12 : -1;
    }

    public boolean L(UCarProto.NotifyAddCamera notifyAddCamera) {
        if (!H()) {
            EasyLog.c("ControlManager", "notifyAddCamera, Channel not ready");
            return false;
        }
        try {
            return ((Boolean) this.f5424a.O0(UCarControlProtocol.s(notifyAddCamera), new SendFutureCallback() {
                public void c(Exception exc) {
                    EasyLog.d("ControlManager", "notifyAddCamera failed: ", exc);
                }

                /* renamed from: d */
                public void a(Boolean bool) {
                    EasyLog.a("ControlManager", "notifyAddCamera succeeded");
                }
            }).get(50, TimeUnit.MILLISECONDS)).booleanValue();
        } catch (TimeoutException unused) {
            EasyLog.c("ControlManager", "notifyAddCamera get ack time out");
            return true;
        } catch (InterruptedException | ExecutionException e2) {
            EasyLog.d("ControlManager", "notifyAddCamera exception:", e2);
            return true;
        }
    }

    public boolean M(String str, UCarCommon.CameraState cameraState) {
        EasyLog.e("ControlManager", "notifyCameraStateChanged, state: " + cameraState);
        if (H()) {
            this.f5424a.O0(UCarControlProtocol.m(UCarProto.NotifyCameraStateChanged.newBuilder().setCameraId(str).setStateValue(cameraState.getValue()).build()), new SendFutureCallback() {
                public void c(Exception exc) {
                    EasyLog.d("ControlManager", "notifyCameraStateChanged failed: ", exc);
                }

                /* renamed from: d */
                public void a(Boolean bool) {
                    EasyLog.a("ControlManager", "notifyCameraStateChanged succeeded");
                }
            });
            return true;
        }
        EasyLog.c("ControlManager", "notifyCameraStateChanged, Channel not ready");
        return false;
    }

    public boolean N(UCarProto.NotifyRemoveCamera notifyRemoveCamera) {
        if (H()) {
            this.f5424a.O0(UCarControlProtocol.v(notifyRemoveCamera), new SendFutureCallback() {
                public void c(Exception exc) {
                    EasyLog.d("ControlManager", "notifyRemoveCamera failed: ", exc);
                }

                /* renamed from: d */
                public void a(Boolean bool) {
                    EasyLog.a("ControlManager", "notifyRemoveCamera succeeded");
                }
            });
            return true;
        }
        EasyLog.c("ControlManager", "notifyRemoveCamera, Channel not ready");
        return false;
    }

    public final int P(UCarProto.ChannelMask channelMask) {
        if (channelMask.equals(UCarProto.ChannelMask.CHANNEL_MONO)) {
            return 4;
        }
        return channelMask.equals(UCarProto.ChannelMask.CHANNEL_STEREO) ? 12 : -1;
    }

    public void Q(IPhoneCmdListener iPhoneCmdListener) {
        this.o = iPhoneCmdListener;
    }

    public final int R(UCarProto.SampleRate sampleRate) {
        return sampleRate.getNumber();
    }

    public boolean S(byte[] bArr, UCarCommon.AudioFormat audioFormat, String str) {
        if (H()) {
            UCarProto.SampleRate G = G(audioFormat.d());
            UCarProto.ChannelMask E = E(audioFormat.a());
            this.f5424a.O0(UCarControlProtocol.l(UCarProto.AwakenVoiceAssistant.newBuilder().setPcmData(ByteString.copyFrom(bArr)).setSampleRate(G).setChannelMask(E).setEncodingFormat(F(audioFormat.b())).setTimestamp(k()).setSource(str).build()), new SendFutureCallback() {
                public void c(Exception exc) {
                    EasyLog.d("ControlManager", "sendAwakenVoiceAssistant failed: ", exc);
                }

                /* renamed from: d */
                public void a(Boolean bool) {
                    EasyLog.e("ControlManager", "sendAwakenVoiceAssistant succeed");
                }
            });
            return true;
        }
        EasyLog.c("ControlManager", "sendAwakenVoiceAssistant, Channel not ready");
        return false;
    }

    public boolean T() {
        if (H()) {
            this.f5424a.O0(UCarControlProtocol.t(UCarProto.NotifyCallHungUp.newBuilder().setTimestamp(k()).build()), new SendFutureCallback() {
                public void c(Exception exc) {
                    EasyLog.d("ControlManager", "sendCallHungUp failed: ", exc);
                }

                /* renamed from: d */
                public void a(Boolean bool) {
                    EasyLog.e("ControlManager", "sendCallHungUp succeed");
                }
            });
            return true;
        }
        EasyLog.c("ControlManager", "sendCallHungUp, Channel not ready");
        return false;
    }

    public boolean U() {
        UCarProto.Disconnect build = UCarProto.Disconnect.newBuilder().build();
        if (H()) {
            try {
                return ((Boolean) this.f5424a.P0(UCarControlProtocol.p(build), new SendFutureCallback() {
                    public void c(Exception exc) {
                        EasyLog.d("ControlManager", "sendDisconnect failed: ", exc);
                    }

                    /* renamed from: d */
                    public void a(Boolean bool) {
                        EasyLog.e("ControlManager", "sendDisconnect succeed");
                    }
                }, true, 500).get(500, TimeUnit.MILLISECONDS)).booleanValue();
            } catch (TimeoutException unused) {
                EasyLog.c("ControlManager", "sendDisconnect get ack time out");
                return false;
            } catch (InterruptedException | ExecutionException e2) {
                EasyLog.d("ControlManager", "sendDisconnect exception: ", e2);
                return false;
            }
        } else {
            EasyLog.c("ControlManager", "sendDisconnect, Channel not ready");
            return false;
        }
    }

    public boolean V(UCarConfig uCarConfig, MDevice mDevice, UCarMessage uCarMessage) {
        if (H()) {
            this.f5424a.O0(UCarControlProtocol.q(UCarProto.GetUCarConfigResponse.newBuilder().setCarBrMac(ByteString.copyFrom(uCarConfig.getCarBrMac())).setScreenWidth(uCarConfig.getScreenWidth()).setScreenHeight(uCarConfig.getScreenHeight()).setDpi(uCarConfig.getDpi()).setVideoDisplayWidth(uCarConfig.getVideoDisplayWidth()).setVideoDisplayHeight(uCarConfig.getVideoDisplayHeight()).setFps(uCarConfig.getFps()).setIsSupportP2P(uCarConfig.isSupportP2P()).setIsSupportSoftAP(uCarConfig.isSupportSoftAP()).setIsDataTransMode(mDevice.getSelectedWorkMode() == 2).setDefault5GChannel(uCarConfig.getAllowed5gChannels()[0]).setIsSupportCamera(uCarConfig.isSupportCamera()).setIsSupportMic(uCarConfig.isSupportMic()).setIsSupportLowLatencyDecodingMode(uCarConfig.isSupportLowLatencyDecodingMode()).setIsSupportVoiceWaken(uCarConfig.isSupportVoiceWaken()).setCarCustomField(ByteString.copyFrom(uCarConfig.getCarCustomField())).setSdkVersion("v1.6.4-202412022001-f3ed7b9").setWorkModes(uCarConfig.getSupportWorkModesInt()).setIsSupportPOINav(uCarConfig.isIsSupportPOINav()).setIsSupportRotation(uCarConfig.isSupportRotation()).setIsSupportHomeKey(uCarConfig.isSupportHomeKey()).setIsSupportBackKey(uCarConfig.isSupportBackKey()).setIsSupportHevc(uCarConfig.isSupportHevc()).setRealDpi(uCarConfig.getRealDpi()).build(), uCarMessage.k()), new SendFutureCallback() {
                public void c(Exception exc) {
                    EasyLog.d("ControlManager", "sendGetUCarConfigResponse failed: ", exc);
                }

                /* renamed from: d */
                public void a(Boolean bool) {
                    EasyLog.e("ControlManager", "sendGetUCarConfigResponse succeed");
                }
            });
            return true;
        }
        EasyLog.c("ControlManager", "sendGetUCarConfigResponse, Channel not ready");
        return false;
    }

    public boolean W() {
        this.n = false;
        if (H()) {
            try {
                return ((Boolean) this.f5424a.O0(UCarControlProtocol.u(), new SendFutureCallback() {
                    public void c(Exception exc) {
                        EasyLog.d("ControlManager", "sendGotoBackground failed: ", exc);
                    }

                    /* renamed from: d */
                    public void a(Boolean bool) {
                        EasyLog.e("ControlManager", "sendGotoBackground succeed");
                    }
                }).get(500, TimeUnit.MILLISECONDS)).booleanValue();
            } catch (TimeoutException unused) {
                EasyLog.c("ControlManager", "sendGotoBackground get ack time out");
                return false;
            } catch (InterruptedException | ExecutionException e2) {
                EasyLog.d("ControlManager", "sendGotoBackground exception: ", e2);
                return false;
            }
        } else {
            EasyLog.c("ControlManager", "sendGotoBackground, Channel not ready");
            return false;
        }
    }

    public final void X(final ISendHeartBeatErrorCallback iSendHeartBeatErrorCallback) {
        EasyLog.a("ControlManager", "sendHeartBeat");
        if (H()) {
            final UCarProto.Heartbeat build = UCarProto.Heartbeat.newBuilder().setTimestamp(System.currentTimeMillis()).build();
            this.f5424a.O0(UCarControlProtocol.r(build), new SendFutureCallback() {
                public void c(Exception exc) {
                    EasyLog.d("ControlManager", "sendHeartBeat failed: ", exc);
                    ISendHeartBeatErrorCallback iSendHeartBeatErrorCallback = iSendHeartBeatErrorCallback;
                    if (iSendHeartBeatErrorCallback != null) {
                        iSendHeartBeatErrorCallback.a();
                    }
                    ControlManager.this.g0();
                }

                /* renamed from: d */
                public void a(Boolean bool) {
                    EasyLog.a("ControlManager", "sendHeartBeat succeeded, " + build.getTimestamp());
                }
            });
        }
    }

    public boolean Y(UCarCommon.KeyEventActionType keyEventActionType, UCarCommon.KeyCodeType keyCodeType, int i2) {
        if (keyEventActionType == null || keyCodeType == null || keyEventActionType == UCarCommon.KeyEventActionType.KEY_EVENT_ACTION_UNDEFINED || keyCodeType == UCarCommon.KeyCodeType.KEY_CODE_UNDEFINED) {
            EasyLog.c("ControlManager", "sendKeyEventToPhone() args error");
            return false;
        } else if (H()) {
            this.f5424a.O0(UCarControlProtocol.o(UCarProto.CustomKeyEvent.newBuilder().setTimestamp(k()).setAction(keyEventActionType.getValue()).setKeycodeValue(keyCodeType.getValue()).setMetaState(i2).build()), new SendFutureCallback() {
                public void c(Exception exc) {
                    EasyLog.d("ControlManager", "sendKeyEventToPhone failed: ", exc);
                }

                /* renamed from: d */
                public void a(Boolean bool) {
                    EasyLog.e("ControlManager", "sendKeyEventToPhone succeed");
                }
            });
            return true;
        } else {
            EasyLog.c("ControlManager", "sendKeyEventToPhone, Channel not ready");
            return false;
        }
    }

    public boolean Z(int i2, int i3) {
        if (!H()) {
            EasyLog.c("ControlManager", "sendNotificationClickToPhone, Channel not ready");
            return false;
        }
        try {
            return ((Boolean) this.f5424a.P0(UCarControlProtocol.n(UCarProto.ClickNotification.newBuilder().setId(i2).setActionPendingIntentId(i3).build()), new SendFutureCallback() {
                public void c(Exception exc) {
                    EasyLog.d("ControlManager", "sendNotificationClickToPhone failed: ", exc);
                }

                /* renamed from: d */
                public void a(Boolean bool) {
                    EasyLog.e("ControlManager", "sendNotificationClickToPhone succeed");
                }
            }, true, 500).get(500, TimeUnit.MILLISECONDS)).booleanValue();
        } catch (TimeoutException unused) {
            EasyLog.c("ControlManager", "sendNotificationClickToPhone get ack time out");
            return false;
        } catch (InterruptedException | ExecutionException e2) {
            EasyLog.d("ControlManager", "sendNotificationClickToPhone exception:", e2);
            return false;
        }
    }

    public boolean a0(UCarCommon.DayNightMode dayNightMode) {
        if (dayNightMode == null || dayNightMode == UCarCommon.DayNightMode.UNKNOWN_MODE) {
            EasyLog.c("ControlManager", " sendSwitchDayOrNight() args error");
            return false;
        } else if (H()) {
            this.f5424a.O0(UCarControlProtocol.w(UCarProto.NotifySwitchDayOrNight.newBuilder().setModeValue(dayNightMode.getValue()).build()), new SendFutureCallback() {
                public void c(Exception exc) {
                    EasyLog.d("ControlManager", "sendSwitchDayOrNight failed: ", exc);
                }

                /* renamed from: d */
                public void a(Boolean bool) {
                    EasyLog.e("ControlManager", "sendSwitchDayOrNight succeed");
                }
            });
            return true;
        } else {
            EasyLog.c("ControlManager", "sendSwitchDayOrNight, Channel not ready");
            return false;
        }
    }

    public boolean b0(UCarCommon.VRCmdType vRCmdType, String str) {
        if (vRCmdType == null || str == null) {
            EasyLog.c("ControlManager", "sendVRCmdToPhone() args error");
            return false;
        } else if (H()) {
            this.f5424a.O0(UCarControlProtocol.x(UCarProto.VRCmdToPhone.newBuilder().setCmdValue(vRCmdType.getValue()).setSource(str).build()), new SendFutureCallback() {
                public void c(Exception exc) {
                    EasyLog.d("ControlManager", "sendVRCmdToPhone failed: ", exc);
                }

                /* renamed from: d */
                public void a(Boolean bool) {
                    EasyLog.e("ControlManager", "sendVRCmdToPhone succeed");
                }
            });
            return true;
        } else {
            EasyLog.c("ControlManager", "sendVRCmdToPhone, Channel not ready");
            return false;
        }
    }

    public void c0(int i2) {
        this.m = i2;
    }

    public void d0(String str) {
        g();
        ConnectChannel connectChannel = this.f5424a;
        if (connectChannel == null) {
            EasyLog.c("ControlManager", "control socket channel init failed");
        } else if (connectChannel.p0()) {
            EasyLog.c("ControlManager", "control socket channel has opened");
        } else {
            EasyLog.e("ControlManager", "start control channel");
            try {
                HashMap hashMap = new HashMap();
                hashMap.put("TcpNoDelay", 1);
                hashMap.put("ReuseAddress", 1);
                hashMap.put("SoLingerMode", 1);
                hashMap.put("Linger", 0);
                hashMap.put("TrafficClass", 192);
                this.f5424a.X0(0, str, hashMap);
            } catch (IOException e2) {
                EasyLog.d("ControlManager", "start control channel error.", e2);
            }
        }
    }

    public void e0(final ISendHeartBeatErrorCallback iSendHeartBeatErrorCallback) {
        EasyLog.a("ControlManager", "startSendHeartBeatThread");
        this.f = true;
        Thread thread = new Thread(new Runnable() {
            public void run() {
                while (ControlManager.this.f) {
                    try {
                        ControlManager.this.X(iSendHeartBeatErrorCallback);
                        Thread.sleep(AssistantConstants.TIMEOUT_VAD_MUTE);
                    } catch (Exception e) {
                        EasyLog.d("ControlManager", "startSendHeartBeatThread exception: ", e);
                    }
                }
            }
        });
        this.e = thread;
        thread.start();
    }

    public void f0() {
        synchronized (this.g) {
            try {
                g0();
                h0();
                if (this.f5424a != null) {
                    EasyLog.e("ControlManager", "close control channel");
                    this.f5424a.c0();
                }
                CountDownLatch countDownLatch = this.l;
                if (countDownLatch != null) {
                    countDownLatch.countDown();
                }
                this.l = null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void g() {
        if (!this.d) {
            EasyLog.a("ControlManager", "start worker thread");
            HandlerThread handlerThread = new HandlerThread("ControlManager_WorkerThread");
            this.b = handlerThread;
            handlerThread.start();
            Looper looper = this.b.getLooper();
            if (looper != null) {
                this.c = new Handler(looper);
                this.d = true;
                return;
            }
            EasyLog.c("ControlManager", "failed to get valid worker thread looper!");
            this.c = null;
            this.d = false;
        }
    }

    public void g0() {
        EasyLog.e("ControlManager", "stopSendHeartBeatThread");
        this.f = false;
        Thread thread = this.e;
        if (thread != null) {
            try {
                thread.interrupt();
                this.e.join();
                this.e = null;
            } catch (InterruptedException e2) {
                EasyLog.d("ControlManager", "stopSendHeartBeatThread exception", e2);
            }
        }
    }

    public final UCarCommon.MusicInfo h(UCarProto.NotifyMusicInfo notifyMusicInfo) {
        String j2 = j(notifyMusicInfo);
        boolean z = true;
        if (!TextUtils.equals(j2, this.j) || this.k == null) {
            UCarCommon.MusicInfo musicInfo = new UCarCommon.MusicInfo(notifyMusicInfo.getArtistName(), notifyMusicInfo.getAlbumName(), notifyMusicInfo.getCoverArt(), notifyMusicInfo.getLyrics(), notifyMusicInfo.getPlayingTimesMs(), notifyMusicInfo.getTitle(), notifyMusicInfo.getAuthorName(), notifyMusicInfo.getWriterName(), notifyMusicInfo.getComposerName(), notifyMusicInfo.getPlayingCurrentTimeMs(), notifyMusicInfo.getIsFavorite(), notifyMusicInfo.getIsPlaying());
            if (!notifyMusicInfo.getCoverArtBitmap().isEmpty()) {
                musicInfo.b(notifyMusicInfo.getCoverArtBitmap().toByteArray());
            }
            if (notifyMusicInfo.getId() != 0) {
                int id = notifyMusicInfo.getId();
                if (id != -1) {
                    z = false;
                }
                musicInfo.c(z);
                if (id == -1) {
                    musicInfo.f(false);
                } else {
                    musicInfo.a(id);
                }
            }
            this.j = j2;
            this.k = musicInfo;
            return musicInfo;
        }
        if (!notifyMusicInfo.getCoverArtBitmap().isEmpty()) {
            this.k.b(notifyMusicInfo.getCoverArtBitmap().toByteArray());
        }
        this.k.f(notifyMusicInfo.getIsPlaying());
        this.k.g(notifyMusicInfo.getPlayingCurrentTimeMs());
        this.k.e(notifyMusicInfo.getLyrics());
        this.k.d(notifyMusicInfo.getIsFavorite());
        if (notifyMusicInfo.getId() != 0) {
            int id2 = notifyMusicInfo.getId();
            UCarCommon.MusicInfo musicInfo2 = this.k;
            if (id2 != -1) {
                z = false;
            }
            musicInfo2.c(z);
            if (id2 == -1) {
                this.k.f(false);
            } else {
                this.k.a(id2);
            }
        }
        return this.k;
    }

    public final void h0() {
        HandlerThread handlerThread = this.b;
        if (handlerThread != null && this.d) {
            handlerThread.quitSafely();
            this.b = null;
            this.c = null;
            this.d = false;
        }
    }

    public final int i(UCarProto.EncodingFormat encodingFormat) {
        if (encodingFormat.equals(UCarProto.EncodingFormat.ENCODING_PCM_8BIT)) {
            return 3;
        }
        if (encodingFormat.equals(UCarProto.EncodingFormat.ENCODING_PCM_16BIT)) {
            return 2;
        }
        return (!encodingFormat.equals(UCarProto.EncodingFormat.ENCODING_PCM_24BIT_PACKED) && !encodingFormat.equals(UCarProto.EncodingFormat.ENCODING_PCM_32BIT) && encodingFormat.equals(UCarProto.EncodingFormat.ENCODING_PCM_FLOAT)) ? 4 : -1;
    }

    public final void i0(UCarCommon.CallState callState) {
        boolean z = true;
        if (ProtocolParser.a(this.m) <= 1 && ProtocolParser.b(this.m) < 5) {
            UCarCommon.CallState callState2 = this.i;
            if (callState2 == null || callState2 != callState) {
                this.i = callState;
                if (this.o != null) {
                    boolean c2 = this.h.c();
                    if (this.n || callState == UCarCommon.CallState.UNKNOWN_STATE || callState == UCarCommon.CallState.IDLE) {
                        z = false;
                    }
                    this.o.g(new UCarCommon.CallInfo(callState, "", "", c2, 0, z, 0));
                }
            }
        }
    }

    public final void j0() {
        if (this.o != null) {
            EasyLog.e("ControlManager", "update phone state: " + this.h);
            this.o.i(this.h);
        }
    }

    public final long k() {
        return System.currentTimeMillis();
    }

    public final void l(UCarMessage uCarMessage) {
        EasyLog.a("ControlManager", "handleAppListChanged");
        UCarProto.AppListChanged B = UCarControlProtocol.B(uCarMessage);
        if (B == null) {
            EasyLog.c("ControlManager", "app list state cannot be null");
        } else if (this.o != null && B.getStateValue() < UCarCommon.AppListState.values().length) {
            this.o.d(B.getIdList(), UCarCommon.AppListState.values()[B.getStateValue()]);
        }
    }

    public final void m(UCarMessage uCarMessage) {
        UCarCommon.VisibleRegion visibleRegion;
        EasyLog.a("ControlManager", "handleAppStateChanged");
        UCarProto.AppStateChanged C = UCarControlProtocol.C(uCarMessage);
        if (C == null) {
            EasyLog.c("ControlManager", "app state cannot be null");
        } else if (this.o != null && C.getStateValue() < UCarCommon.AppState.values().length) {
            if (C.hasVisibleRegion()) {
                UCarProto.DisplayVisibleRegion visibleRegion2 = C.getVisibleRegion();
                visibleRegion = new UCarCommon.VisibleRegion(visibleRegion2.getLeft(), visibleRegion2.getTop(), visibleRegion2.getRight(), visibleRegion2.getBottom(), visibleRegion2.getOriginWidth(), visibleRegion2.getOriginHeight(), UCarCommon.DisplayMode.from(visibleRegion2.getMode()));
            } else {
                visibleRegion = null;
            }
            this.o.p(C.getId(), C.getIsNeedShow(), C.getDisplayRotation(), UCarCommon.AppState.values()[C.getStateValue()], C.getTimestamp(), visibleRegion);
        }
    }

    public final void n(UCarMessage uCarMessage) {
        EasyLog.a("ControlManager", "handleAudioPlayerControl");
        UCarProto.AudioPlayerControl D = UCarControlProtocol.D(uCarMessage);
        if (D == null) {
            EasyLog.c("ControlManager", "audio player control cannot be null");
        } else if (this.o != null) {
            UCarCommon.AudioType fromInt = UCarCommon.AudioType.fromInt(D.getAudioType().getNumber());
            UCarAudioManager.AudioPlayerControl audioPlayerControl = new UCarAudioManager.AudioPlayerControl();
            audioPlayerControl.f(fromInt);
            audioPlayerControl.g(D.getBufferingCount());
            audioPlayerControl.h(D.getSpeedAdjustStep());
            audioPlayerControl.e(D.getPolicyMode() != 0);
            this.o.a(audioPlayerControl);
        }
    }

    public final void o(UCarMessage uCarMessage) {
        EasyLog.a("ControlManager", "handleAudioPlayerState");
        UCarProto.NotifyAudioPlayerState K = UCarControlProtocol.K(uCarMessage);
        if (K == null) {
            EasyLog.c("ControlManager", "audio player cannot be null");
            return;
        }
        int P = P(K.getChannelMask());
        int i2 = i(K.getEncodingFormat());
        int R = R(K.getSampleRate());
        UCarCommon.AudioType fromInt = UCarCommon.AudioType.fromInt(K.getTypeValue());
        UCarCommon.AudioFormat audioFormat = new UCarCommon.AudioFormat(!K.getMimeType().isEmpty() ? K.getMimeType() : "audio/pcm", i2, R, P);
        UCarAudioManager.PlayerState fromInt2 = UCarAudioManager.PlayerState.fromInt(K.getStateValue());
        IPhoneCmdListener iPhoneCmdListener = this.o;
        if (iPhoneCmdListener != null) {
            iPhoneCmdListener.e(fromInt, audioFormat, fromInt2);
        }
    }

    public final void p(UCarMessage uCarMessage) {
        EasyLog.a("ControlManager", "handleBluetoothMacInfo");
        UCarProto.BluetoothMacInfo E = UCarControlProtocol.E(uCarMessage);
        if (E == null) {
            EasyLog.c("ControlManager", "camera state cannot be null");
            return;
        }
        UCarCommon.BluetoothMacInfo bluetoothMacInfo = new UCarCommon.BluetoothMacInfo(UCarCommon.OPType.fromType(E.getOpTypeValue()), E.getBluetoothMac());
        IPhoneCmdListener iPhoneCmdListener = this.o;
        if (iPhoneCmdListener != null) {
            iPhoneCmdListener.n(bluetoothMacInfo);
        }
    }

    public final void q(UCarMessage uCarMessage) {
        EasyLog.a("ControlManager", "handleCallInfoReceived");
        UCarProto.CallInfo F = UCarControlProtocol.F(uCarMessage);
        if (F == null) {
            EasyLog.c("ControlManager", "call info cannot be null");
        } else if (this.o != null) {
            UCarCommon.CallInfo callInfo = new UCarCommon.CallInfo(O(F.getCallStateValue()), F.getNumber(), F.getName(), F.getIsIPCall(), F.getConnectedTime(), F.getIsNeedShowFloatingWindow(), F.getInCallAppId());
            EasyLog.e("ControlManager", "update call info: " + callInfo);
            this.o.g(callInfo);
        }
    }

    public final void r(UCarMessage uCarMessage) {
        EasyLog.a("ControlManager", "handleCameraState");
        UCarProto.SetCameraState R = UCarControlProtocol.R(uCarMessage);
        if (R == null) {
            EasyLog.c("ControlManager", "camera state cannot be null");
            return;
        }
        UCarCommon.CameraActionArgs cameraActionArgs = new UCarCommon.CameraActionArgs(R.getCameraId(), new Range(Integer.valueOf(R.getFpsRange().getMin()), Integer.valueOf(R.getFpsRange().getMax())), new Size(R.getPictureSize().getWidth(), R.getPictureSize().getHeight()));
        IPhoneCmdListener iPhoneCmdListener = this.o;
        if (iPhoneCmdListener != null) {
            iPhoneCmdListener.c(UCarCommon.CameraAction.fromInt(R.getActionValue()), cameraActionArgs);
        }
    }

    public final void s(UCarMessage uCarMessage) {
        IPhoneCmdListener iPhoneCmdListener = this.o;
        if (iPhoneCmdListener != null) {
            iPhoneCmdListener.q(uCarMessage);
        }
    }

    public final void t(UCarMessage uCarMessage) {
        EasyLog.a("ControlManager", "handleMicroPhoneState");
        UCarProto.NotifyMicrophoneState L = UCarControlProtocol.L(uCarMessage);
        if (L == null) {
            EasyLog.c("ControlManager", "micro phone state cannot be null");
            return;
        }
        int K = K(L.getChannelMask());
        int i2 = i(L.getEncodingFormat());
        int R = R(L.getSampleRate());
        boolean state = L.getState();
        UCarCommon.AudioFormat audioFormat = new UCarCommon.AudioFormat("audio/pcm", i2, R, K);
        boolean z = !UCarCommon.CallState.UNKNOWN_STATE.equals(this.h.a()) && !UCarCommon.CallState.IDLE.equals(this.h.a());
        boolean c2 = this.h.c();
        boolean b2 = this.h.b();
        IPhoneCmdListener iPhoneCmdListener = this.o;
        if (iPhoneCmdListener != null) {
            iPhoneCmdListener.j(state, audioFormat, c2, z, b2);
        }
        this.h.h(state);
        j0();
    }

    public final void u(UCarMessage uCarMessage) {
        EasyLog.a("ControlManager", "handleMirrorState");
        UCarProto.NotifyMirrorState M = UCarControlProtocol.M(uCarMessage);
        if (M == null) {
            EasyLog.c("ControlManager", "mirror state cannot be null");
        } else if (this.o != null) {
            int mirrorStateValue = M.getMirrorStateValue();
            EasyLog.a("ControlManager", "mirror state: " + mirrorStateValue);
            if (mirrorStateValue == 0) {
                this.o.t();
            } else if (mirrorStateValue == 1) {
                this.o.b();
            } else if (mirrorStateValue == 2) {
                this.o.m();
            } else if (mirrorStateValue == 3) {
                this.o.o();
            }
        }
    }

    public final void v(UCarMessage uCarMessage) {
        EasyLog.a("ControlManager", "handleMusicInfo");
        UCarProto.NotifyMusicInfo N = UCarControlProtocol.N(uCarMessage);
        if (N == null) {
            EasyLog.c("ControlManager", "music info cannot be null");
            return;
        }
        UCarCommon.MusicInfo h2 = h(N);
        if (this.o != null) {
            EasyLog.e("ControlManager", "update music info: " + h2);
            this.o.l(h2);
        }
    }

    public final void w(UCarMessage uCarMessage) {
        EasyLog.a("ControlManager", "handleNavigationInfo");
        UCarProto.NotifyNavigationInfo O = UCarControlProtocol.O(uCarMessage);
        if (O == null) {
            EasyLog.c("ControlManager", "navigation cannot be null");
            return;
        }
        UCarCommon.NavigationInfo navigationInfo = new UCarCommon.NavigationInfo(O.getIsNavigating(), O.getDirectionIcon().toByteArray(), O.getDistance(), O.getDistanceUnit(), O.getOperation(), O.getWhere(), O.getTitle1(), O.getTitle2(), O.getId() != 0 ? O.getId() : 0);
        if (this.o != null) {
            EasyLog.e("ControlManager", "update navigation info: " + navigationInfo);
            this.o.s(navigationInfo);
        }
    }

    public final void x(UCarMessage uCarMessage) {
        EasyLog.a("ControlManager", "handleNotificationAdded");
        UCarProto.AddNotification A = UCarControlProtocol.A(uCarMessage);
        if (A == null) {
            EasyLog.c("ControlManager", "add notification info cannot be null");
            return;
        }
        IPhoneCmdListener iPhoneCmdListener = this.o;
        if (iPhoneCmdListener != null) {
            iPhoneCmdListener.k(A);
        }
    }

    public final void y(UCarMessage uCarMessage) {
        EasyLog.a("ControlManager", "handleNotificationRemoved");
        UCarProto.DeleteNotification G = UCarControlProtocol.G(uCarMessage);
        if (G == null) {
            EasyLog.c("ControlManager", "delete notification info cannot be null");
            return;
        }
        IPhoneCmdListener iPhoneCmdListener = this.o;
        if (iPhoneCmdListener != null) {
            iPhoneCmdListener.h(G.getIdsList());
        }
    }

    public final void z(UCarMessage uCarMessage) {
        EasyLog.a("ControlManager", "handlePOIReceived");
        UCarProto.POIAddress Q = UCarControlProtocol.Q(uCarMessage);
        if (Q == null) {
            EasyLog.c("ControlManager", "poi address cannot be null");
        } else if (this.o != null) {
            UCarCommon.POIAddress pOIAddress = new UCarCommon.POIAddress(Q.getName());
            if (!Q.getAddress().isEmpty()) {
                pOIAddress.a(Q.getAddress());
            }
            if (Q.hasPoiInfo()) {
                UCarProto.POIDetailInfo poiInfo = Q.getPoiInfo();
                UCarCommon.POIDetailInfo pOIDetailInfo = new UCarCommon.POIDetailInfo(UCarCommon.CoordinateType.fromType(poiInfo.getTypeValue()), poiInfo.getLatitude(), poiInfo.getLongitude());
                if (poiInfo.getAltitude() != 0.0d) {
                    pOIDetailInfo.a(poiInfo.getAltitude());
                }
                pOIAddress.b(pOIDetailInfo);
            }
            EasyLog.e("ControlManager", "update poi address: " + pOIAddress);
            this.o.f(pOIAddress);
        }
    }
}
