package com.ucar.vehiclesdk.camera;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Size;
import android.view.Surface;
import com.easy.logger.EasyLog;
import com.google.android.gms.common.Scopes;
import java.io.IOException;
import java.nio.ByteBuffer;

public class VideoEncoder extends MediaCodec.Callback {

    /* renamed from: a  reason: collision with root package name */
    public final Size f5416a;
    public final int b;
    public final Callback c;
    public MediaCodec d;
    public HandlerThread e;

    public interface Callback {
        void a(ByteBuffer byteBuffer, int i);

        void b(String str);
    }

    public VideoEncoder(Size size, int i, Callback callback) {
        this.f5416a = size;
        if (i <= 0 || i >= 60) {
            this.b = 60;
        } else {
            this.b = i;
        }
        this.c = callback;
    }

    public final Surface a() {
        try {
            MediaCodec createEncoderByType = MediaCodec.createEncoderByType("video/avc");
            this.d = createEncoderByType;
            createEncoderByType.configure(b(), (Surface) null, (MediaCrypto) null, 1);
            return this.d.createInputSurface();
        } catch (IOException e2) {
            EasyLog.c("VideoEncoder", "createInputSurface" + e2.getMessage());
            return null;
        }
    }

    public final MediaFormat b() {
        MediaFormat createVideoFormat = MediaFormat.createVideoFormat("video/avc", this.f5416a.getWidth(), this.f5416a.getHeight());
        createVideoFormat.setInteger("bitrate", (this.f5416a.getWidth() < 1920 || this.f5416a.getHeight() < 1080) ? 5242880 : 10485760);
        createVideoFormat.setInteger("bitrate-mode", 1);
        createVideoFormat.setInteger("frame-rate", this.b);
        createVideoFormat.setInteger("color-format", 2130708361);
        createVideoFormat.setInteger("i-frame-interval", 15);
        createVideoFormat.setInteger(Scopes.PROFILE, 1);
        createVideoFormat.setInteger("level", 1);
        createVideoFormat.setInteger("max-bframes", 0);
        return createVideoFormat;
    }

    public void c() {
        try {
            HandlerThread handlerThread = new HandlerThread("VideoEncoder");
            this.e = handlerThread;
            handlerThread.start();
            this.d.setCallback(this, new Handler(this.e.getLooper()));
            this.d.start();
            EasyLog.a("VideoEncoder", "started");
        } catch (Exception unused) {
            EasyLog.c("VideoEncoder", "start failed");
        }
    }

    public void d() {
        try {
            MediaCodec mediaCodec = this.d;
            if (mediaCodec != null) {
                mediaCodec.stop();
                this.d.release();
                this.d = null;
            }
            HandlerThread handlerThread = this.e;
            if (handlerThread != null) {
                handlerThread.quitSafely();
                this.e = null;
            }
            EasyLog.a("VideoEncoder", "stopped");
        } catch (Exception unused) {
            EasyLog.c("VideoEncoder", "stop failed");
        }
    }

    public void onError(MediaCodec mediaCodec, MediaCodec.CodecException codecException) {
        EasyLog.a("VideoEncoder", "onError " + codecException.getMessage());
        this.c.b(codecException.getMessage());
    }

    public void onInputBufferAvailable(MediaCodec mediaCodec, int i) {
        EasyLog.a("VideoEncoder", "onInputBufferAvailable");
    }

    public void onOutputBufferAvailable(MediaCodec mediaCodec, int i, MediaCodec.BufferInfo bufferInfo) {
        try {
            EasyLog.a("VideoEncoder", "onOutputBufferAvailable " + i + ", timestamps = " + System.currentTimeMillis());
            this.c.a(mediaCodec.getOutputBuffer(i), bufferInfo.flags);
            mediaCodec.releaseOutputBuffer(i, false);
        } catch (Exception e2) {
            EasyLog.c("VideoEncoder", "onOutputBufferAvailable exception : " + e2.getMessage());
        }
    }

    public void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        EasyLog.a("VideoEncoder", "onOutputFormatChanged " + mediaFormat);
    }
}
