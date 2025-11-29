package com.xjsd.ai.assistant.phone.vui;

import com.google.android.gms.actions.SearchIntents;
import com.upuphone.ai.ttsengine.TtsSdk;
import com.xjsd.ai.assistant.common.handler.VuiHandler;
import com.xjsd.ai.assistant.core.AbilityManager;
import com.xjsd.ai.assistant.core.api.cache.CacheAbility;
import com.xjsd.ai.assistant.log.ILog;
import com.xjsd.ai.assistant.protocol.VuiModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 \n2\u00020\u0001:\u0001\fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"Lcom/xjsd/ai/assistant/phone/vui/LlmVuiHandler;", "Lcom/xjsd/ai/assistant/common/handler/VuiHandler;", "<init>", "()V", "", "getHandleType", "()Ljava/lang/String;", "Lcom/xjsd/ai/assistant/protocol/VuiModel;", "model", "", "a", "(Lcom/xjsd/ai/assistant/protocol/VuiModel;)Z", "Companion", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class LlmVuiHandler implements VuiHandler {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f8625a = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/xjsd/ai/assistant/phone/vui/LlmVuiHandler$Companion;", "", "()V", "TAG", "", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public boolean a(VuiModel vuiModel) {
        String str;
        Intrinsics.checkNotNullParameter(vuiModel, "model");
        String string = vuiModel.getPayload().getString(SearchIntents.EXTRA_QUERY);
        CacheAbility cacheAbility = (CacheAbility) AbilityManager.b.b(CacheAbility.class);
        if (cacheAbility != null) {
            cacheAbility.cache("isInChatGptScene", Boolean.TRUE);
        }
        String name = vuiModel.getHeader().getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        if (StringsKt.startsWith$default(name, "in_scenario_", false, 2, (Object) null)) {
            if (cacheAbility != null) {
                cacheAbility.cache("isGptCosplay", Boolean.TRUE);
            }
            str = vuiModel.getPayload().getJSONObject("utterance").getString("screen");
        } else {
            str = string;
        }
        ILog.a("LlmVuiHandler", "chatGpt rawQuery->" + string + ", query->" + str);
        TtsSdk.f5490a.m();
        return false;
    }

    public String getHandleType() {
        return "llm";
    }
}
