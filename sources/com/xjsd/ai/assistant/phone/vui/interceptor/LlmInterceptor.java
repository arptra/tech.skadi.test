package com.xjsd.ai.assistant.phone.vui.interceptor;

import com.xjsd.ai.assistant.common.handler.VuiInterceptor;
import com.xjsd.ai.assistant.core.AbilityManager;
import com.xjsd.ai.assistant.core.api.cache.CacheAbility;
import com.xjsd.ai.assistant.phone.vui.llm.LlmAnswerSynchronizer;
import com.xjsd.ai.assistant.protocol.VuiModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/xjsd/ai/assistant/phone/vui/interceptor/LlmInterceptor;", "Lcom/xjsd/ai/assistant/common/handler/VuiInterceptor;", "<init>", "()V", "", "getIdentifier", "()Ljava/lang/String;", "Lcom/xjsd/ai/assistant/protocol/VuiModel;", "vuiModel", "", "a", "(Lcom/xjsd/ai/assistant/protocol/VuiModel;)Z", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class LlmInterceptor implements VuiInterceptor {
    public boolean a(VuiModel vuiModel) {
        Intrinsics.checkNotNullParameter(vuiModel, "vuiModel");
        if (!Intrinsics.areEqual((Object) "llm", (Object) vuiModel.getHeader().getNamespace())) {
            return false;
        }
        CacheAbility cacheAbility = (CacheAbility) AbilityManager.b.b(CacheAbility.class);
        if (cacheAbility != null) {
            cacheAbility.cache("chatGptName", vuiModel.getHeader().getName());
        }
        LlmAnswerSynchronizer.f8634a.h(vuiModel);
        return true;
    }

    public String getIdentifier() {
        return "llm";
    }
}
