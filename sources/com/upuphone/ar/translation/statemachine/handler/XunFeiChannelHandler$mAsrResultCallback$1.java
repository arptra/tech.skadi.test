package com.upuphone.ar.translation.statemachine.handler;

import com.honey.account.k5.a;
import com.honey.account.k5.b;
import com.honey.account.k5.c;
import com.honey.account.k5.d;
import com.upuphone.ar.translation.audio.debug.AudioDebugHelper;
import com.upuphone.ar.translation.ext.IntExtKt;
import com.upuphone.ar.translation.ext.LogExt;
import com.upuphone.ar.translation.phone.helper.TtsToGlassHelper;
import com.upuphone.ar.translation.statemachine.bean.AsrTtsResult;
import com.upuphone.ar.translation.utils.JsonUtils;
import com.upuphone.oggopus.OggOpus;
import com.xjsd.xr.sapp.asr.callback.AsrResultCallback;
import com.xjsd.xr.sapp.asr.dao.AsrMessageState;
import com.xjsd.xr.sapp.asr.dao.AsrResult;
import com.xjsd.xr.sapp.asr.dao.ResultExt;
import com.xjsd.xr.sapp.asr.dao.Src;
import com.xjsd.xr.sapp.asr.dao.TtsData;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import okhttp3.Response;

@Metadata(d1 = {"\u0000S\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0006\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\u0006J\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\f\u0010\nJ\u0017\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0013\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u001f\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u001b\u0010\u001aJ!\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001c2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u0004H\u0016¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\"\u0010!J\u001f\u0010'\u001a\u00020\u00042\u0006\u0010$\u001a\u00020#2\u0006\u0010&\u001a\u00020%H\u0002¢\u0006\u0004\b'\u0010(¨\u0006)"}, d2 = {"com/upuphone/ar/translation/statemachine/handler/XunFeiChannelHandler$mAsrResultCallback$1", "Lcom/xjsd/xr/sapp/asr/callback/AsrResultCallback;", "Lcom/xjsd/xr/sapp/asr/dao/AsrResult;", "asrResult", "", "onRemoteAsrResult", "(Lcom/xjsd/xr/sapp/asr/dao/AsrResult;)V", "Lcom/xjsd/xr/sapp/asr/dao/TtsData;", "ttsData", "onRemoteTts", "(Lcom/xjsd/xr/sapp/asr/dao/TtsData;)V", "onProximalAsrResult", "onProximalTts", "Lcom/xjsd/xr/sapp/asr/dao/AsrMessageState;", "state", "onAsrRunningState", "(Lcom/xjsd/xr/sapp/asr/dao/AsrMessageState;)V", "Lokhttp3/Response;", "response", "onOpen", "(Lokhttp3/Response;)V", "", "code", "", "reason", "onClosing", "(ILjava/lang/String;)V", "onClosed", "", "throwable", "onFailure", "(Ljava/lang/Throwable;Lokhttp3/Response;)V", "onAsrReconnectStart", "()V", "onAsrReconnectSuccess", "", "oggBytes", "", "ttsTime", "e", "([BJ)V", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class XunFeiChannelHandler$mAsrResultCallback$1 extends AsrResultCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ XunFeiChannelHandler f6355a;

    public XunFeiChannelHandler$mAsrResultCallback$1(XunFeiChannelHandler xunFeiChannelHandler) {
        this.f6355a = xunFeiChannelHandler;
    }

    public static final void f(long j, byte[] bArr, long j2) {
        Intrinsics.checkNotNullParameter(bArr, "data");
        if (j2 != -1) {
            TtsToGlassHelper ttsToGlassHelper = TtsToGlassHelper.f6315a;
            int i = (j2 > -2 ? 1 : (j2 == -2 ? 0 : -1));
            boolean z = false;
            if (i != 0) {
                bArr = ArraysKt.plus(IntExtKt.d(bArr.length, 0, false, 3, (Object) null), bArr);
            }
            if (i == 0) {
                z = true;
            }
            ttsToGlassHelper.k(new TtsToGlassHelper.OpusTtsData(bArr, z, j));
        }
    }

    public static final void g(Ref.IntRef intRef, XunFeiChannelHandler$mAsrResultCallback$1 xunFeiChannelHandler$mAsrResultCallback$1, byte[] bArr, byte[] bArr2, long j) {
        Intrinsics.checkNotNullParameter(intRef, "$ttsCount");
        Intrinsics.checkNotNullParameter(xunFeiChannelHandler$mAsrResultCallback$1, "this$0");
        Intrinsics.checkNotNullParameter(bArr, "$bytes");
        Intrinsics.checkNotNullParameter(bArr2, "<anonymous parameter 0>");
        if (j != -1) {
            if (j != -2) {
                intRef.element++;
            } else {
                xunFeiChannelHandler$mAsrResultCallback$1.e(bArr, ((long) intRef.element) * 20);
            }
        }
    }

    public static final void h(byte[] bArr, long j) {
        Intrinsics.checkNotNullParameter(bArr, "data");
        if (j != -1) {
            int i = (j > -2 ? 1 : (j == -2 ? 0 : -1));
            TtsToGlassHelper.f6315a.i(new TtsToGlassHelper.OpusTtsData(i == 0 ? bArr : ArraysKt.plus(IntExtKt.d(bArr.length, 0, false, 3, (Object) null), bArr), i == 0, 0, 4, (DefaultConstructorMarker) null));
            AudioDebugHelper audioDebugHelper = AudioDebugHelper.f6196a;
            audioDebugHelper.x(bArr, "tele_proximal_tts_opus.pcm");
            audioDebugHelper.w(bArr, "tele_proximal_tts.pcm");
        }
    }

    public static final void i(byte[] bArr, long j) {
        Intrinsics.checkNotNullParameter(bArr, "data");
        if (j != -1) {
            int i = (j > -2 ? 1 : (j == -2 ? 0 : -1));
            TtsToGlassHelper.f6315a.m(new TtsToGlassHelper.OpusTtsData(i == 0 ? bArr : ArraysKt.plus(IntExtKt.d(bArr.length, 0, false, 3, (Object) null), bArr), i == 0, 0, 4, (DefaultConstructorMarker) null));
            AudioDebugHelper audioDebugHelper = AudioDebugHelper.f6196a;
            audioDebugHelper.A(bArr, "tele_remote_tts_opus.pcm");
            audioDebugHelper.z(bArr, "tele_remote_tts.pcm");
        }
    }

    public final void e(byte[] bArr, long j) {
        LogExt.j("handleReminderTtsData oggBytes=" + bArr + ", ttsTime=" + j, "XunFeiChannelHandler");
        OggOpus e = this.f6355a.h;
        if (e != null) {
            e.decodeAsync(bArr, (long) bArr.length, new d(j));
        }
    }

    public void onAsrReconnectStart() {
        super.onAsrReconnectStart();
        this.f6355a.p();
    }

    public void onAsrReconnectSuccess() {
        super.onAsrReconnectSuccess();
        this.f6355a.q();
    }

    public void onAsrRunningState(AsrMessageState asrMessageState) {
        Intrinsics.checkNotNullParameter(asrMessageState, "state");
        super.onAsrRunningState(asrMessageState);
        LogExt.j("AsrResultCallback onAsrRunningState=" + asrMessageState, "XunFeiChannelHandler");
        if (Intrinsics.areEqual((Object) asrMessageState.getCode(), (Object) "0")) {
            this.f6355a.f6354a.A(JsonUtils.d(asrMessageState));
        } else {
            this.f6355a.f6354a.s(0);
        }
    }

    public void onClosed(int i, String str) {
        Intrinsics.checkNotNullParameter(str, "reason");
        super.onClosed(i, str);
        LogExt.j("AsrResultCallback onClosed=" + i + ", reason=" + str, "XunFeiChannelHandler");
    }

    public void onClosing(int i, String str) {
        Intrinsics.checkNotNullParameter(str, "reason");
        super.onClosing(i, str);
        LogExt.j("AsrResultCallback onClosing code=" + i + ", reason=" + str, "XunFeiChannelHandler");
    }

    public void onFailure(Throwable th, Response response) {
        Intrinsics.checkNotNullParameter(th, "throwable");
        super.onFailure(th, response);
        this.f6355a.x(response);
    }

    public void onOpen(Response response) {
        super.onOpen(response);
        this.f6355a.y();
    }

    public void onProximalAsrResult(AsrResult asrResult) {
        Long consumeTime;
        Intrinsics.checkNotNullParameter(asrResult, "asrResult");
        super.onProximalAsrResult(asrResult);
        Long l = null;
        this.f6355a.f6354a.w(new AsrTtsResult(JsonUtils.d(asrResult), (byte[]) null));
        ResultExt ext = asrResult.getExt();
        if (ext != null && (consumeTime = ext.getConsumeTime()) != null) {
            long longValue = consumeTime.longValue();
            Long sendAudioTime = ext.getSendAudioTime();
            Src src = asrResult.getSrc();
            if (src != null) {
                l = Long.valueOf(src.getEndTime());
            }
            LogExt.j("ProximalEachResult consumeTime=" + longValue + ", sendAudioTime=" + sendAudioTime + ", endTime=" + l, "XunFeiChannelHandler");
        }
    }

    public void onProximalTts(TtsData ttsData) {
        Intrinsics.checkNotNullParameter(ttsData, "ttsData");
        super.onProximalTts(ttsData);
        byte[] tts = ttsData.getTts();
        int length = tts.length;
        long time = ttsData.getTime();
        boolean d = this.f6355a.i;
        LogExt.j("AsrResultCallback proximalTts size=" + length + ", time=" + time + ", isUserReminderTts=" + d, "XunFeiChannelHandler");
        if (tts.length != 0) {
            int b = this.f6355a.f6354a.b();
            if (this.f6355a.i || b != 4) {
                OggOpus e = this.f6355a.h;
                if (e != null) {
                    e.decodeAsync(tts, (long) tts.length, new b());
                    return;
                }
                return;
            }
            LogExt.j("AsrResultCallback proximalTts user reminder", "XunFeiChannelHandler");
            Ref.IntRef intRef = new Ref.IntRef();
            OggOpus e2 = this.f6355a.h;
            if (e2 != null) {
                e2.decodeAsync(tts, (long) tts.length, new a(intRef, this, tts));
            }
            this.f6355a.i = true;
        }
    }

    public void onRemoteAsrResult(AsrResult asrResult) {
        Long consumeTime;
        Intrinsics.checkNotNullParameter(asrResult, "asrResult");
        super.onRemoteAsrResult(asrResult);
        Long l = null;
        this.f6355a.f6354a.x(new AsrTtsResult(JsonUtils.d(asrResult), (byte[]) null));
        ResultExt ext = asrResult.getExt();
        if (ext != null && (consumeTime = ext.getConsumeTime()) != null) {
            long longValue = consumeTime.longValue();
            Long sendAudioTime = ext.getSendAudioTime();
            Src src = asrResult.getSrc();
            if (src != null) {
                l = Long.valueOf(src.getEndTime());
            }
            LogExt.j("RemoteEachResult consumeTime=" + longValue + ", sendAudioTime=" + sendAudioTime + ", endTime=" + l, "XunFeiChannelHandler");
        }
    }

    public void onRemoteTts(TtsData ttsData) {
        OggOpus f;
        Intrinsics.checkNotNullParameter(ttsData, "ttsData");
        super.onRemoteTts(ttsData);
        byte[] tts = ttsData.getTts();
        int length = tts.length;
        long time = ttsData.getTime();
        LogExt.j("AsrResultCallback remoteTts size=" + length + ", time=" + time, "XunFeiChannelHandler");
        if (tts.length != 0 && (f = this.f6355a.g) != null) {
            f.decodeAsync(tts, (long) tts.length, new c());
        }
    }
}
