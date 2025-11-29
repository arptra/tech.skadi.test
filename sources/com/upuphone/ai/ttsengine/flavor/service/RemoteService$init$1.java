package com.upuphone.ai.ttsengine.flavor.service;

import com.upuphone.ai.ttsengine.TtsCallback;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J$\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\tH\u0016J\u001c\u0010\n\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u000b"}, d2 = {"com/upuphone/ai/ttsengine/flavor/service/RemoteService$init$1", "Lcom/upuphone/ai/ttsengine/TtsCallback;", "onDone", "", "caller", "", "id", "onError", "code", "", "onStart", "aar_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class RemoteService$init$1 implements TtsCallback {
    public void onDone(String str, String str2) {
        RemoteService.f5563a.n(str, str2);
    }

    public void onError(String str, String str2, int i) {
        RemoteService.f5563a.o(str, str2, i);
    }

    public void onStart(String str, String str2) {
        RemoteService.f5563a.m(str, str2);
    }
}
