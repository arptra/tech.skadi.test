package com.xjsd.ai.assistant.phone.vui.interceptor;

import com.xjsd.ai.assistant.core.api.tts.TtsListener;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u0012\u0010\u0005\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\b\u001a\u00020\u0003H\u0016¨\u0006\t"}, d2 = {"com/xjsd/ai/assistant/phone/vui/interceptor/DomainCrossInterceptor$showReject$1", "Lcom/xjsd/ai/assistant/core/api/tts/TtsListener;", "onDiscard", "", "onSpeakEnd", "onSpeakError", "error", "", "onSpeakStart", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class DomainCrossInterceptor$showReject$1 implements TtsListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DomainCrossInterceptor f8631a;

    public DomainCrossInterceptor$showReject$1(DomainCrossInterceptor domainCrossInterceptor) {
        this.f8631a = domainCrossInterceptor;
    }

    public void onDiscard() {
    }

    public void onSpeakEnd() {
        this.f8631a.d();
    }

    public void onSpeakError(String str) {
        this.f8631a.d();
    }

    public void onSpeakStart() {
    }
}
