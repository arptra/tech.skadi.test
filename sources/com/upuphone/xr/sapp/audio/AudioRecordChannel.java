package com.upuphone.xr.sapp.audio;

import android.media.AudioRecord;
import com.upuphone.star.core.log.ULog;
import io.flutter.plugin.platform.PlatformPlugin;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.concurrent.ThreadsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0011\u0018\u0000 12\u00020\u0001:\u00012B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J|\u0010\u0012\u001a\u00020\f2\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042!\u0010\r\u001a\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u000726\u0010\u0011\u001a2\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\f0\u000e¢\u0006\u0004\b\u0012\u0010\u0013J\r\u0010\u0014\u001a\u00020\f¢\u0006\u0004\b\u0014\u0010\u0003J\r\u0010\u0015\u001a\u00020\f¢\u0006\u0004\b\u0015\u0010\u0003J\r\u0010\u0016\u001a\u00020\f¢\u0006\u0004\b\u0016\u0010\u0003J\u000f\u0010\u0017\u001a\u00020\fH\u0003¢\u0006\u0004\b\u0017\u0010\u0003J\u000f\u0010\u0018\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0018\u0010\u0003J\u001f\u0010\u001a\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u001f\u0010\u001c\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001c\u0010\u001dR\u0018\u0010!\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010(\u001a\u00020\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010*\u001a\u00020\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b)\u0010'R3\u0010-\u001a\u001f\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b+\u0010,RH\u00100\u001a4\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\f\u0018\u00010\u000e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b.\u0010/¨\u00063"}, d2 = {"Lcom/upuphone/xr/sapp/audio/AudioRecordChannel;", "", "<init>", "()V", "", "channel", "bufferSize", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "bytes", "", "audioData", "Lkotlin/Function2;", "process", "expCode", "audioException", "k", "(IILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)V", "o", "p", "m", "i", "n", "readLen", "j", "([BI)V", "h", "(II)V", "Landroid/media/AudioRecord;", "a", "Landroid/media/AudioRecord;", "mAudioRecord", "", "b", "Z", "mIsStartRecord", "c", "I", "mMinBufferSize", "d", "channelConfig", "e", "Lkotlin/jvm/functions/Function1;", "mAudioData", "f", "Lkotlin/jvm/functions/Function2;", "mAudioException", "g", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class AudioRecordChannel {
    public static final Companion g = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public volatile AudioRecord f6644a;
    public volatile boolean b;
    public int c;
    public int d = 16;
    public Function1 e;
    public Function2 f;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/upuphone/xr/sapp/audio/AudioRecordChannel$Companion;", "", "()V", "RECORD_BUFFER_SIZE", "", "SAMPLE_RATE_HZ", "TAG", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public static /* synthetic */ void l(AudioRecordChannel audioRecordChannel, int i, int i2, Function1 function1, Function2 function2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 16;
        }
        if ((i3 & 2) != 0) {
            i2 = PlatformPlugin.DEFAULT_SYSTEM_UI;
        }
        audioRecordChannel.k(i, i2, function1, function2);
    }

    public final void h(int i, int i2) {
        Function2 function2 = this.f;
        if (function2 != null) {
            function2.invoke(Integer.valueOf(i), Integer.valueOf(i2));
        }
    }

    public final void i() {
        try {
            this.f6644a = new AudioRecord(6, 16000, this.d, 2, this.c);
            ULog.Delegate delegate = ULog.f6446a;
            AudioRecord audioRecord = this.f6644a;
            Integer valueOf = audioRecord != null ? Integer.valueOf(audioRecord.getState()) : null;
            delegate.g("AudioRecordChannel", "handleAudioInit init audioRecord state=" + valueOf);
        } catch (Exception e2) {
            ULog.Delegate delegate2 = ULog.f6446a;
            String stackTraceToString = ExceptionsKt.stackTraceToString(e2);
            delegate2.g("AudioRecordChannel", "初始化AudioRecord异常！error=" + stackTraceToString);
            h(1, 101);
        }
    }

    public final void j(byte[] bArr, int i) {
        Function1 function1;
        if (i >= 0) {
            byte[] bArr2 = new byte[i];
            System.arraycopy(bArr, 0, bArr2, 0, i);
            if (i > 0 && (function1 = this.e) != null) {
                function1.invoke(bArr2);
            }
        } else if (i == -3) {
            ULog.Delegate delegate = ULog.f6446a;
            delegate.g("AudioRecordChannel", "handleRecordAudio 对象未正确初始化:: " + i);
            h(3, 104);
        } else if (i == -2) {
            ULog.Delegate delegate2 = ULog.f6446a;
            delegate2.g("AudioRecordChannel", "handleRecordAudio 参数未解析为有效数据和索引:: " + i);
            h(3, 105);
        } else if (i == -6) {
            ULog.Delegate delegate3 = ULog.f6446a;
            delegate3.g("AudioRecordChannel", "handleRecordAudio 对象不再有效并且需要重新创建:: " + i);
            h(3, 106);
        } else if (i == -1) {
            ULog.Delegate delegate4 = ULog.f6446a;
            delegate4.g("AudioRecordChannel", "handleRecordAudio 其他错误:: " + i);
            h(3, 103);
        } else {
            ULog.Delegate delegate5 = ULog.f6446a;
            delegate5.g("AudioRecordChannel", "handleRecordAudio 未知错误:: " + i);
            h(3, 103);
        }
    }

    public final void k(int i, int i2, Function1 function1, Function2 function2) {
        Intrinsics.checkNotNullParameter(function1, "audioData");
        Intrinsics.checkNotNullParameter(function2, "audioException");
        ULog.f6446a.g("AudioRecordChannel", "init 初始化录音资源");
        this.d = i;
        this.c = i2;
        this.e = function1;
        this.f = function2;
        i();
    }

    public final void m() {
        ULog.f6446a.g("AudioRecordChannel", "release 释放录音资源");
        this.b = false;
        AudioRecord audioRecord = this.f6644a;
        if (audioRecord != null) {
            audioRecord.release();
        }
        this.f6644a = null;
        this.e = null;
        this.f = null;
    }

    public final void n() {
        ThreadsKt.thread$default(false, false, (ClassLoader) null, (String) null, 0, new AudioRecordChannel$startReadingThread$1(this), 31, (Object) null);
    }

    public final void o() {
        if (this.b) {
            ULog.f6446a.g("AudioRecordChannel", "startRecord 录音已经开启，请不要重复开启！");
            return;
        }
        ULog.Delegate delegate = ULog.f6446a;
        delegate.g("AudioRecordChannel", "startRecord 开始录音！");
        try {
            if (this.f6644a == null) {
                delegate.o("AudioRecordChannel", "startRecord 开始录音异常，AudioRecord未被初始化！");
                i();
            }
            AudioRecord audioRecord = this.f6644a;
            if (audioRecord != null) {
                audioRecord.startRecording();
            }
            this.b = true;
            n();
        } catch (Exception e2) {
            ULog.Delegate delegate2 = ULog.f6446a;
            String stackTraceToString = ExceptionsKt.stackTraceToString(e2);
            delegate2.g("AudioRecordChannel", "开始录音异常！exception=" + stackTraceToString);
            h(2, 102);
            this.b = false;
            this.f6644a = null;
        }
    }

    public final void p() {
        ULog.f6446a.g("AudioRecordChannel", "stopRecord 停止录音！");
        this.b = false;
        try {
            AudioRecord audioRecord = this.f6644a;
            if (audioRecord != null) {
                audioRecord.stop();
            }
        } catch (Exception e2) {
            ULog.Delegate delegate = ULog.f6446a;
            String stackTraceToString = ExceptionsKt.stackTraceToString(e2);
            delegate.g("AudioRecordChannel", "停止录音异常！exception=" + stackTraceToString);
            h(4, 107);
            this.f6644a = null;
        }
    }
}
