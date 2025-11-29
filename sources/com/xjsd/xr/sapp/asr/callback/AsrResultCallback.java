package com.xjsd.xr.sapp.asr.callback;

import com.xjsd.xr.sapp.asr.dao.AsrMessageState;
import com.xjsd.xr.sapp.asr.dao.AsrResult;
import com.xjsd.xr.sapp.asr.dao.TtsData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u001a\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u0012\u0010\u0015\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u0010\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u001bH\u0016¨\u0006\u001e"}, d2 = {"Lcom/xjsd/xr/sapp/asr/callback/AsrResultCallback;", "Lcom/xjsd/xr/sapp/asr/callback/WebSocketCallback;", "Lcom/xjsd/xr/sapp/asr/callback/AsrMessageCallback;", "()V", "onAsrReconnectStart", "", "onAsrReconnectSuccess", "onAsrRunningState", "state", "Lcom/xjsd/xr/sapp/asr/dao/AsrMessageState;", "onClosed", "code", "", "reason", "", "onClosing", "onFailure", "throwable", "", "response", "Lokhttp3/Response;", "onOpen", "onProximalAsrResult", "asrResult", "Lcom/xjsd/xr/sapp/asr/dao/AsrResult;", "onProximalTts", "ttsData", "Lcom/xjsd/xr/sapp/asr/dao/TtsData;", "onRemoteAsrResult", "onRemoteTts", "asr_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class AsrResultCallback implements WebSocketCallback, AsrMessageCallback {
    public void onAsrReconnectStart() {
    }

    public void onAsrReconnectSuccess() {
    }

    public void onAsrRunningState(@NotNull AsrMessageState asrMessageState) {
        Intrinsics.checkNotNullParameter(asrMessageState, "state");
    }

    public void onClosed(int i, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "reason");
    }

    public void onClosing(int i, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "reason");
    }

    public void onFailure(@NotNull Throwable th, @Nullable Response response) {
        Intrinsics.checkNotNullParameter(th, "throwable");
    }

    public void onOpen(@Nullable Response response) {
    }

    public void onProximalAsrResult(@NotNull AsrResult asrResult) {
        Intrinsics.checkNotNullParameter(asrResult, "asrResult");
    }

    public void onProximalTts(@NotNull TtsData ttsData) {
        Intrinsics.checkNotNullParameter(ttsData, "ttsData");
    }

    public void onRemoteAsrResult(@NotNull AsrResult asrResult) {
        Intrinsics.checkNotNullParameter(asrResult, "asrResult");
    }

    public void onRemoteTts(@NotNull TtsData ttsData) {
        Intrinsics.checkNotNullParameter(ttsData, "ttsData");
    }
}
