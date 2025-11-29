package com.xjsd.xr.sapp.asr.callback;

import com.xjsd.xr.sapp.asr.dao.AsrMessageState;
import com.xjsd.xr.sapp.asr.dao.AsrResult;
import com.xjsd.xr.sapp.asr.dao.TtsData;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH&J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH&J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH&¨\u0006\u0010"}, d2 = {"Lcom/xjsd/xr/sapp/asr/callback/AsrMessageCallback;", "", "onAsrReconnectStart", "", "onAsrReconnectSuccess", "onAsrRunningState", "state", "Lcom/xjsd/xr/sapp/asr/dao/AsrMessageState;", "onProximalAsrResult", "asrResult", "Lcom/xjsd/xr/sapp/asr/dao/AsrResult;", "onProximalTts", "ttsData", "Lcom/xjsd/xr/sapp/asr/dao/TtsData;", "onRemoteAsrResult", "onRemoteTts", "asr_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface AsrMessageCallback {
    void onAsrReconnectStart();

    void onAsrReconnectSuccess();

    void onAsrRunningState(@NotNull AsrMessageState asrMessageState);

    void onProximalAsrResult(@NotNull AsrResult asrResult);

    void onProximalTts(@NotNull TtsData ttsData);

    void onRemoteAsrResult(@NotNull AsrResult asrResult);

    void onRemoteTts(@NotNull TtsData ttsData);
}
