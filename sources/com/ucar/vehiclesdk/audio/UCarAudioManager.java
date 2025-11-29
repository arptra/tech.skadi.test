package com.ucar.vehiclesdk.audio;

import com.easy.logger.EasyLog;
import com.honey.account.i3.a;
import com.honey.account.i3.b;
import com.share.connect.channel.ConnectChannel;
import com.ucar.databus.proto.UCarProto;
import com.ucar.protocol.MemUtil;
import com.ucar.protocol.UCarMessage;
import com.ucar.protocol.UCarRawProtocol;
import com.ucar.vehiclesdk.ICarAudioRecorderListener;
import com.ucar.vehiclesdk.UCarAdapter;
import com.ucar.vehiclesdk.UCarCommon;
import com.ucar.vehiclesdk.player.AudioPlayerMgr;
import com.ucar.vehiclesdk.recorder.AudioConfig;
import com.ucar.vehiclesdk.recorder.CarAudioRecorder;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.concurrent.Future;

public class UCarAudioManager {

    /* renamed from: a  reason: collision with root package name */
    public final ConnectChannel f5402a;
    public final AudioPlayerMgr b;
    public final boolean c;
    public boolean d;
    public Future e;
    public CarAudioRecorder f;
    public ICarAudioRecorderListener g;
    public boolean h;

    /* renamed from: com.ucar.vehiclesdk.audio.UCarAudioManager$1  reason: invalid class name */
    class AnonymousClass1 extends ConnectChannel {
        public final /* synthetic */ UCarAudioManager r;

        public void H0() {
            EasyLog.a("UCarAudioManager", "audio channel ready.");
            boolean unused = this.r.d = true;
        }

        public void J0(boolean z) {
            EasyLog.a("UCarAudioManager", "audio channel closed.");
            boolean unused = this.r.d = false;
        }

        public void K0(UCarMessage uCarMessage) {
            super.K0(uCarMessage);
            if (uCarMessage != null && UCarRawProtocol.k(uCarMessage)) {
                UCarCommon.AudioType fromInt = UCarCommon.AudioType.fromInt(UCarRawProtocol.n(uCarMessage).getNumber());
                byte[] m = UCarRawProtocol.m(uCarMessage);
                this.r.f(fromInt, m.length, m);
            }
        }
    }

    public static class AudioPlayerControl {

        /* renamed from: a  reason: collision with root package name */
        public UCarCommon.AudioType f5403a = UCarCommon.AudioType.STREAM_UNDEFINED;
        public int b = -1;
        public int c = -1;
        public boolean d = false;

        public UCarCommon.AudioType a() {
            return this.f5403a;
        }

        public int b() {
            return this.b;
        }

        public int c() {
            return this.c;
        }

        public boolean d() {
            return this.d;
        }

        public void e(boolean z) {
            this.d = z;
        }

        public void f(UCarCommon.AudioType audioType) {
            this.f5403a = audioType;
        }

        public void g(int i) {
            this.b = i;
        }

        public void h(int i) {
            this.c = i;
        }

        public String toString() {
            return "AudioPlayerControl{mAudioType=" + this.f5403a + ", mBufferingCount=" + this.b + ", mSpeedAdjustStep=" + this.c + '}';
        }
    }

    public interface IUCarAudioListener {
        void a(UCarCommon.AudioType audioType, int i);
    }

    public enum PlayerState {
        START_PLAYER(0),
        STOP_PLAYER(1),
        PAUSE_PLAYER(2),
        RESUME_PLAYER(3);
        
        private static PlayerState[] values;
        private final int mValue;

        static {
            values = null;
        }

        private PlayerState(int i) {
            this.mValue = i;
        }

        public static PlayerState fromInt(int i) {
            if (values == null) {
                values = values();
            }
            int i2 = 0;
            while (true) {
                PlayerState[] playerStateArr = values;
                if (i2 >= playerStateArr.length) {
                    return STOP_PLAYER;
                }
                PlayerState playerState = playerStateArr[i2];
                if (playerState.mValue == i) {
                    return playerState;
                }
                i2++;
            }
        }

        public int getValue() {
            return this.mValue;
        }
    }

    public static /* synthetic */ void l(short[] sArr, int i) {
        EasyLog.e("UCarAudioManager", "onCarAudioRtpDataCallback, bodyLen: " + i);
        UCarAdapter.R0().l2(i, sArr, 0);
    }

    public void d(boolean z) {
        this.b.o(z);
    }

    public final void e(boolean z) {
        EasyLog.a("UCarAudioManager", "clearAudioResources. isUseCustomAudioRecord: " + z);
        q(z);
        this.b.N();
    }

    public void f(UCarCommon.AudioType audioType, int i, byte[] bArr) {
        this.b.S(audioType, ByteBuffer.wrap(bArr, 0, i));
    }

    public void g(UCarCommon.AudioType audioType, UCarCommon.AudioFormat audioFormat, PlayerState playerState, UCarCommon.AudioAttributes audioAttributes, boolean z) {
        EasyLog.a("UCarAudioManager", "handleAudioStateChanged, type: " + audioType + ", format: " + audioFormat + ", state: " + playerState + ", attributes: " + audioAttributes + ", isWire: " + z);
        this.b.F(audioType, audioFormat, playerState, audioAttributes, z);
    }

    public void h(UCarCommon.AudioFormat audioFormat, boolean z, boolean z2, boolean z3, boolean z4, UCarCommon.AudioAttributes audioAttributes) {
        EasyLog.e("UCarAudioManager", "onMicRecordRequest, isTurnOn: " + z + ", isCallActive: " + z2 + ", isUseCustomAudioRecord: " + z3 + ", isAiActive: " + z4);
        if (z) {
            this.h = z3;
            if (z3) {
                ICarAudioRecorderListener iCarAudioRecorderListener = this.g;
                if (iCarAudioRecorderListener == null) {
                    EasyLog.c("UCarAudioManager", "handleMicRecordRequest use custom audio record, but mAudioRecordListener is null!!");
                } else {
                    iCarAudioRecorderListener.b(audioFormat, z2, z4);
                }
            } else {
                o(audioFormat, z2, z4, audioAttributes);
            }
        } else {
            q(this.h);
        }
    }

    public void i(AudioPlayerControl audioPlayerControl) {
        if (audioPlayerControl != null) {
            this.b.R(audioPlayerControl);
        }
    }

    public final boolean j() {
        Future future;
        if (!this.d && (future = this.e) != null) {
            try {
                future.get();
            } catch (Exception e2) {
                EasyLog.d("UCarAudioManager", "wait start audio channel error.", e2);
            }
        }
        return this.f5402a.p0();
    }

    public boolean m(int i, short[] sArr, long j) {
        if (!j()) {
            EasyLog.c("UCarAudioManager", "sendMicRecordData, Channel not ready");
            return false;
        }
        int i2 = i * 2;
        byte[] e2 = MemUtil.e(i2);
        ByteBuffer.wrap(e2).order(ByteOrder.LITTLE_ENDIAN).asShortBuffer().put(sArr);
        this.f5402a.O0(UCarRawProtocol.l(ByteBuffer.wrap(e2, 0, i2), UCarProto.AudioType.STREAM_MICROPHONE), new a());
        return true;
    }

    public void n(String str) {
        EasyLog.a("UCarAudioManager", "start, address: " + str);
        try {
            this.e = this.f5402a.W0(0, str);
        } catch (IOException e2) {
            EasyLog.d("UCarAudioManager", "start audio channel error.", e2);
        }
    }

    public void o(UCarCommon.AudioFormat audioFormat, boolean z, boolean z2, UCarCommon.AudioAttributes audioAttributes) {
        int i;
        EasyLog.a("UCarAudioManager", "startAudioRecord");
        CarAudioRecorder carAudioRecorder = this.f;
        if (carAudioRecorder != null) {
            carAudioRecorder.f();
            this.f = null;
        }
        AudioConfig carConfig = AudioConfig.getCarConfig(audioFormat);
        if (z) {
            carConfig.setSource(7);
            if (audioAttributes != null) {
                i = audioAttributes.d();
                CarAudioRecorder carAudioRecorder2 = new CarAudioRecorder(carConfig, this.c, new b(), i);
                this.f = carAudioRecorder2;
                carAudioRecorder2.e();
            }
        } else if (z2) {
            carConfig.setSource(7);
            if (audioAttributes != null) {
                i = audioAttributes.a();
                CarAudioRecorder carAudioRecorder22 = new CarAudioRecorder(carConfig, this.c, new b(), i);
                this.f = carAudioRecorder22;
                carAudioRecorder22.e();
            }
        }
        i = 0;
        CarAudioRecorder carAudioRecorder222 = new CarAudioRecorder(carConfig, this.c, new b(), i);
        this.f = carAudioRecorder222;
        carAudioRecorder222.e();
    }

    public void p() {
        EasyLog.a("UCarAudioManager", "stop");
        try {
            e(this.h);
            this.f5402a.c0();
        } catch (Exception e2) {
            EasyLog.c("UCarAudioManager", "stop audio channel error: " + e2);
        }
    }

    public void q(boolean z) {
        EasyLog.a("UCarAudioManager", "stopAudioRecord");
        if (z) {
            ICarAudioRecorderListener iCarAudioRecorderListener = this.g;
            if (iCarAudioRecorderListener == null) {
                EasyLog.c("UCarAudioManager", "stopAudioRecord use custom audio record, but mAudioRecordListener is null!!");
                return;
            }
            try {
                iCarAudioRecorderListener.a();
            } catch (Exception e2) {
                EasyLog.d("UCarAudioManager", "stopAudioRecord onStopRecorder error", e2);
            }
        } else {
            CarAudioRecorder carAudioRecorder = this.f;
            if (carAudioRecorder != null) {
                carAudioRecorder.f();
                this.f = null;
            }
        }
    }
}
