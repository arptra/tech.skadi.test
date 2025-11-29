package com.xjsd.ai.assistant.phone.codec;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.view.Surface;
import androidx.core.util.Consumer;
import com.meizu.common.widget.MzContactsContract;
import com.xjsd.ai.assistant.log.ILog;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.LinkedBlockingQueue;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u000b\u0018\u0000 ?2\u00020\u0001:\u0001@B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ'\u0010\r\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u001d\u0010\u001a\u001a\u00020\b2\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017¢\u0006\u0004\b\u001a\u0010\u001bJ\u001d\u0010\u001c\u001a\u00020\b2\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0017¢\u0006\u0004\b\u001c\u0010\u001bJ\r\u0010\u001d\u001a\u00020\b¢\u0006\u0004\b\u001d\u0010\u0003J\u0015\u0010\u001f\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u0018¢\u0006\u0004\b\u001f\u0010 J\r\u0010!\u001a\u00020\b¢\u0006\u0004\b!\u0010\u0003J\r\u0010\"\u001a\u00020\b¢\u0006\u0004\b\"\u0010\u0003J\u000f\u0010\u0010\u001a\u00020#H\u0002¢\u0006\u0004\b\u0010\u0010$R\u0014\u0010(\u001a\u00020%8\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u001b\u0010-\u001a\u00020)8BX\u0002¢\u0006\f\n\u0004\b\u001f\u0010*\u001a\u0004\b+\u0010,R\u001a\u00100\u001a\b\u0012\u0004\u0012\u00020\u00180.8\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010/R\u0014\u00102\u001a\u00020\u00138\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u00101R\u0016\u00104\u001a\u00020#8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0010\u00103R\u0016\u00105\u001a\u00020#8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001a\u00103R\u0016\u00108\u001a\u0002068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001c\u00107R\u0018\u0010:\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001d\u00109R\u001e\u0010<\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00178\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\"\u0010;R\u001e\u0010>\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00178\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b=\u0010;¨\u0006A"}, d2 = {"Lcom/xjsd/ai/assistant/phone/codec/PcmToAmrWbCoder;", "Landroid/media/MediaCodec$Callback;", "<init>", "()V", "Landroid/media/MediaCodec;", "codec", "", "index", "", "onInputBufferAvailable", "(Landroid/media/MediaCodec;I)V", "Landroid/media/MediaCodec$BufferInfo;", "info", "onOutputBufferAvailable", "(Landroid/media/MediaCodec;ILandroid/media/MediaCodec$BufferInfo;)V", "Landroid/media/MediaCodec$CodecException;", "e", "onError", "(Landroid/media/MediaCodec;Landroid/media/MediaCodec$CodecException;)V", "Landroid/media/MediaFormat;", "format", "onOutputFormatChanged", "(Landroid/media/MediaCodec;Landroid/media/MediaFormat;)V", "Landroidx/core/util/Consumer;", "", "consumer", "f", "(Landroidx/core/util/Consumer;)V", "g", "h", "data", "b", "([B)V", "c", "i", "", "()Z", "Landroid/os/HandlerThread;", "a", "Landroid/os/HandlerThread;", "mWorker", "Landroid/os/Handler;", "Lkotlin/Lazy;", "d", "()Landroid/os/Handler;", "mHandler", "Ljava/util/concurrent/LinkedBlockingQueue;", "Ljava/util/concurrent/LinkedBlockingQueue;", "mBufferQueue", "Landroid/media/MediaFormat;", "mMediaFormat", "Z", "isRunning", "isEncodeOver", "", "J", "startTime", "Landroid/media/MediaCodec;", "mMediaCodec", "Landroidx/core/util/Consumer;", "mDataConsumer", "j", "mStateConsumer", "k", "Companion", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class PcmToAmrWbCoder extends MediaCodec.Callback {
    public static final Companion k = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public final HandlerThread f8553a = new HandlerThread("pcmCodec");
    public final Lazy b = LazyKt.lazy(new PcmToAmrWbCoder$mHandler$2(this));
    public final LinkedBlockingQueue c = new LinkedBlockingQueue();
    public final MediaFormat d;
    public boolean e;
    public boolean f;
    public long g;
    public MediaCodec h;
    public Consumer i;
    public Consumer j;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/xjsd/ai/assistant/phone/codec/PcmToAmrWbCoder$Companion;", "", "()V", "BIT_RATE", "", "MIME_TYPE", "", "TAG", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public PcmToAmrWbCoder() {
        MediaFormat createAudioFormat = MediaFormat.createAudioFormat("audio/amr-wb", 16000, 1);
        createAudioFormat.setInteger("bitrate", 23850);
        Intrinsics.checkNotNullExpressionValue(createAudioFormat, "apply(...)");
        this.d = createAudioFormat;
        this.e = true;
    }

    public final void b(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "data");
        if (e()) {
            this.c.offer(bArr);
        }
    }

    public final void c() {
        ILog.a("PcmToAmrWbCoder", "flush");
        if (e()) {
            this.c.offer(new byte[0]);
        }
    }

    public final Handler d() {
        return (Handler) this.b.getValue();
    }

    public final boolean e() {
        return this.e && this.h != null;
    }

    public final void f(Consumer consumer) {
        this.i = consumer;
    }

    public final void g(Consumer consumer) {
        this.j = consumer;
    }

    public final void h() {
        ILog.a("PcmToAmrWbCoder", MzContactsContract.START_PARAM_KEY);
        if (this.h != null) {
            ILog.a("PcmToAmrWbCoder", "start: mMediaCodec is working, return");
            return;
        }
        this.g = SystemClock.elapsedRealtimeNanos();
        this.e = true;
        this.f = false;
        try {
            MediaCodec createEncoderByType = MediaCodec.createEncoderByType("audio/amr-wb");
            createEncoderByType.setCallback(this, d());
            createEncoderByType.configure(this.d, (Surface) null, (MediaCrypto) null, 1);
            createEncoderByType.start();
            this.h = createEncoderByType;
        } catch (IOException e2) {
            ILog.h("PcmToAmrWbCoder", "start异常", e2);
            this.h = null;
        }
    }

    public final void i() {
        ILog.a("PcmToAmrWbCoder", "stop");
        this.e = false;
        this.f = true;
        this.c.clear();
        try {
            MediaCodec mediaCodec = this.h;
            if (mediaCodec != null) {
                mediaCodec.stop();
            }
            MediaCodec mediaCodec2 = this.h;
            if (mediaCodec2 != null) {
                mediaCodec2.setCallback((MediaCodec.Callback) null);
            }
            MediaCodec mediaCodec3 = this.h;
            if (mediaCodec3 != null) {
                mediaCodec3.release();
            }
        } catch (Exception e2) {
            ILog.h("PcmToAmrWbCoder", "release: 异常", e2);
        } catch (Throwable th) {
            this.h = null;
            throw th;
        }
        this.h = null;
    }

    public void onError(MediaCodec mediaCodec, MediaCodec.CodecException codecException) {
        Intrinsics.checkNotNullParameter(mediaCodec, "codec");
        Intrinsics.checkNotNullParameter(codecException, "e");
        int errorCode = codecException.getErrorCode();
        ILog.a("PcmToAmrWbCoder", "onError: code->" + errorCode);
        this.e = false;
        Consumer consumer = this.j;
        if (consumer != null) {
            consumer.accept(-1);
        }
        i();
    }

    public void onInputBufferAvailable(MediaCodec mediaCodec, int i2) {
        Intrinsics.checkNotNullParameter(mediaCodec, "codec");
        long elapsedRealtimeNanos = (SystemClock.elapsedRealtimeNanos() - this.g) / ((long) 1000);
        if (this.f) {
            ILog.a("PcmToAmrWbCoder", "onInputBufferAvailable: queue end of stream, index->" + i2);
            mediaCodec.queueInputBuffer(i2, 0, 0, elapsedRealtimeNanos, 4);
            return;
        }
        byte[] bArr = (byte[]) this.c.take();
        Intrinsics.checkNotNull(bArr);
        if (bArr.length == 0) {
            ILog.a("PcmToAmrWbCoder", "onInputBufferAvailable: queue end of stream, index->" + i2);
            this.f = true;
            mediaCodec.queueInputBuffer(i2, 0, 0, elapsedRealtimeNanos, 4);
            return;
        }
        try {
            ByteBuffer inputBuffer = mediaCodec.getInputBuffer(i2);
            if (inputBuffer != null) {
                inputBuffer.clear();
                inputBuffer.put(bArr);
                mediaCodec.queueInputBuffer(i2, 0, bArr.length, elapsedRealtimeNanos, 0);
            }
        } catch (Exception e2) {
            ILog.h("PcmToAmrWbCoder", "onInputBufferAvailable: 写入编码数据异常", e2);
        }
    }

    public void onOutputBufferAvailable(MediaCodec mediaCodec, int i2, MediaCodec.BufferInfo bufferInfo) {
        Intrinsics.checkNotNullParameter(mediaCodec, "codec");
        Intrinsics.checkNotNullParameter(bufferInfo, "info");
        ByteBuffer outputBuffer = mediaCodec.getOutputBuffer(i2);
        if (outputBuffer != null) {
            byte[] bArr = new byte[bufferInfo.size];
            outputBuffer.get(bArr);
            outputBuffer.clear();
            Consumer consumer = this.i;
            if (consumer != null) {
                consumer.accept(bArr);
            }
            mediaCodec.releaseOutputBuffer(i2, false);
        }
        if ((bufferInfo.flags & 4) != 0) {
            ILog.a("PcmToAmrWbCoder", "encode pcm to amr_wb over");
            this.e = false;
            Consumer consumer2 = this.j;
            if (consumer2 != null) {
                consumer2.accept(200);
            }
            i();
        }
    }

    public void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        Intrinsics.checkNotNullParameter(mediaCodec, "codec");
        Intrinsics.checkNotNullParameter(mediaFormat, "format");
        ILog.a("PcmToAmrWbCoder", "onOutputFormatChanged: format->" + mediaFormat);
    }
}
