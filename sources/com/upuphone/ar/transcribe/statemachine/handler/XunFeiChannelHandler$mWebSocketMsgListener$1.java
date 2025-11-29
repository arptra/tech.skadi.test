package com.upuphone.ar.transcribe.statemachine.handler;

import com.honey.account.b5.a;
import com.upuphone.ar.transcribe.ext.ByteArrayExtKt;
import com.upuphone.ar.transcribe.ext.InterconnectMsgCodExtKt;
import com.upuphone.ar.transcribe.ext.LogExt;
import com.upuphone.ar.transcribe.phone.helper.TtsDataSender;
import com.upuphone.ar.transcribe.utils.JsonUtils;
import com.upuphone.oggopus.OggOpus;
import com.xjsd.xr.sapp.asr.callback.AsrResultCallback;
import com.xjsd.xr.sapp.asr.dao.AsrMessageState;
import com.xjsd.xr.sapp.asr.dao.AsrResult;
import com.xjsd.xr.sapp.asr.dao.TtsData;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Response;

@Metadata(d1 = {"\u0000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u001a\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u0012\u0010\u0011\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0014H\u0016¨\u0006\u0019"}, d2 = {"com/upuphone/ar/transcribe/statemachine/handler/XunFeiChannelHandler$mWebSocketMsgListener$1", "Lcom/xjsd/xr/sapp/asr/callback/AsrResultCallback;", "onAsrRunningState", "", "state", "Lcom/xjsd/xr/sapp/asr/dao/AsrMessageState;", "onClosed", "code", "", "reason", "", "onClosing", "onFailure", "throwable", "", "response", "Lokhttp3/Response;", "onOpen", "onProximalAsrResult", "asrResult", "Lcom/xjsd/xr/sapp/asr/dao/AsrResult;", "onProximalTts", "ttsData", "Lcom/xjsd/xr/sapp/asr/dao/TtsData;", "onRemoteAsrResult", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class XunFeiChannelHandler$mWebSocketMsgListener$1 extends AsrResultCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ XunFeiChannelHandler f6166a;

    public XunFeiChannelHandler$mWebSocketMsgListener$1(XunFeiChannelHandler xunFeiChannelHandler) {
        this.f6166a = xunFeiChannelHandler;
    }

    public static final void b(TtsData ttsData, byte[] bArr, long j) {
        Intrinsics.checkNotNullParameter(ttsData, "$ttsData");
        Intrinsics.checkNotNullParameter(bArr, "data");
        if (j != -1) {
            if (j == -2) {
                TtsDataSender.f6112a.c(new TtsDataSender.OpusTtsData(bArr, true, ttsData.getTime()));
            } else {
                TtsDataSender.f6112a.c(new TtsDataSender.OpusTtsData(ArraysKt.plus(ByteArrayExtKt.d(bArr.length, 0, false, 3, (Object) null), bArr), false, ttsData.getTime()));
            }
        }
    }

    public void onAsrRunningState(AsrMessageState asrMessageState) {
        Intrinsics.checkNotNullParameter(asrMessageState, "state");
        LogExt.g("onTranslateRunningState state=" + asrMessageState, "XunFeiChannelHandler");
        if (Intrinsics.areEqual((Object) asrMessageState.getCode(), (Object) "0")) {
            this.f6166a.f6165a.G(asrMessageState);
        } else {
            this.f6166a.f6165a.y(0);
        }
    }

    public void onClosed(int i, String str) {
        Intrinsics.checkNotNullParameter(str, "reason");
        super.onClosed(i, str);
        String e = InterconnectMsgCodExtKt.e(this.f6166a.f6165a.e());
        LogExt.g("Server channel onClosed, state=" + e, "XunFeiChannelHandler");
        this.f6166a.f6165a.F();
    }

    public void onClosing(int i, String str) {
        Intrinsics.checkNotNullParameter(str, "reason");
        super.onClosing(i, str);
        LogExt.g("Server channel onClosing", "XunFeiChannelHandler");
    }

    public void onFailure(Throwable th, Response response) {
        Intrinsics.checkNotNullParameter(th, "throwable");
        LogExt.g("Server channel onFailure", "XunFeiChannelHandler");
        this.f6166a.r();
    }

    public void onOpen(Response response) {
        super.onOpen(response);
        LogExt.g("Server channel onOpen", "XunFeiChannelHandler");
        this.f6166a.f6165a.B();
        this.f6166a.f6165a.z();
    }

    public void onProximalAsrResult(AsrResult asrResult) {
        Intrinsics.checkNotNullParameter(asrResult, "asrResult");
        LogExt.d("收到云端近端结果: " + asrResult, "XunFeiChannelHandler");
        this.f6166a.f6165a.C(JsonUtils.b(asrResult));
    }

    public void onProximalTts(TtsData ttsData) {
        Intrinsics.checkNotNullParameter(ttsData, "ttsData");
        super.onProximalTts(ttsData);
        byte[] tts = ttsData.getTts();
        int length = tts.length;
        long time = ttsData.getTime();
        LogExt.g("AsrResultCallback proximalTts size=" + length + ", time=" + time, "XunFeiChannelHandler");
        if (tts.length != 0) {
            OggOpus d = this.f6166a.e;
            if (d != null) {
                d.decodeAsync(tts, (long) tts.length, new a(ttsData));
            }
            this.f6166a.f = true;
        }
    }

    public void onRemoteAsrResult(AsrResult asrResult) {
        Intrinsics.checkNotNullParameter(asrResult, "asrResult");
        LogExt.d("收到云端远端结果: " + asrResult, "XunFeiChannelHandler");
        this.f6166a.f6165a.D(JsonUtils.b(asrResult));
    }
}
