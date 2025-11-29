package com.xjsd.ai.assistant.common;

import com.xjsd.ai.assistant.core.api.tts.TtsListener;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u0012\u0010\u0005\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\b\u001a\u00020\u0003H\u0016¨\u0006\t"}, d2 = {"com/xjsd/ai/assistant/common/UnSupportFeatureManager$handle$1", "Lcom/xjsd/ai/assistant/core/api/tts/TtsListener;", "onDiscard", "", "onSpeakEnd", "onSpeakError", "error", "", "onSpeakStart", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class UnSupportFeatureManager$handle$1 implements TtsListener {
    public void onDiscard() {
        UnSupportFeatureHandler a2 = UnSupportFeatureManager.b;
        if (a2 != null) {
            a2.a(4);
        }
    }

    public void onSpeakEnd() {
        UnSupportFeatureHandler a2 = UnSupportFeatureManager.b;
        if (a2 != null) {
            a2.a(2);
        }
        UnSupportFeatureManager.f8414a.d();
    }

    public void onSpeakError(String str) {
        UnSupportFeatureHandler a2 = UnSupportFeatureManager.b;
        if (a2 != null) {
            a2.a(3);
        }
        UnSupportFeatureHandler a3 = UnSupportFeatureManager.b;
        if (a3 != null) {
            a3.c();
        }
    }

    public void onSpeakStart() {
        UnSupportFeatureHandler a2 = UnSupportFeatureManager.b;
        if (a2 != null) {
            a2.a(1);
        }
    }
}
