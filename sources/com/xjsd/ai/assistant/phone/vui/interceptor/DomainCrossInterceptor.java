package com.xjsd.ai.assistant.phone.vui.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.xjsd.ai.assistant.common.Communicator;
import com.xjsd.ai.assistant.common.handler.VuiInterceptor;
import com.xjsd.ai.assistant.core.AbilityManager;
import com.xjsd.ai.assistant.core.ContextHelper;
import com.xjsd.ai.assistant.core.api.cache.CacheAbility;
import com.xjsd.ai.assistant.core.api.tts.TtsAbility;
import com.xjsd.ai.assistant.core.api.tts.TtsData;
import com.xjsd.ai.assistant.log.ILog;
import com.xjsd.ai.assistant.phone.VoiceAssistantApi;
import com.xjsd.ai.assistant.phone.tts.TtsDataTransform;
import com.xjsd.ai.assistant.phone.tts.TtsManager;
import com.xjsd.ai.assistant.protocol.VuiModel;
import com.xjsd.ai.assistant.protocol.VuiModelType;
import com.xjsd.ai.assistant.protocol.vui.Utterance;
import com.xjsd.ai.assistant.template.TtsGlobalTemplate;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \n2\u00020\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ!\u0010\u0011\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0013\u0010\u0003¨\u0006\u0015"}, d2 = {"Lcom/xjsd/ai/assistant/phone/vui/interceptor/DomainCrossInterceptor;", "Lcom/xjsd/ai/assistant/common/handler/VuiInterceptor;", "<init>", "()V", "", "getIdentifier", "()Ljava/lang/String;", "Lcom/xjsd/ai/assistant/protocol/VuiModel;", "vuiModel", "", "a", "(Lcom/xjsd/ai/assistant/protocol/VuiModel;)Z", "Lcom/xjsd/ai/assistant/core/api/cache/CacheAbility;", "cacheAbility", "Lcom/xjsd/ai/assistant/protocol/vui/Utterance;", "utterance", "", "c", "(Lcom/xjsd/ai/assistant/core/api/cache/CacheAbility;Lcom/xjsd/ai/assistant/protocol/vui/Utterance;)V", "d", "Companion", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class DomainCrossInterceptor implements VuiInterceptor {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f8630a = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/xjsd/ai/assistant/phone/vui/interceptor/DomainCrossInterceptor$Companion;", "", "()V", "TAG", "", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public boolean a(VuiModel vuiModel) {
        boolean z;
        boolean z2;
        Intrinsics.checkNotNullParameter(vuiModel, "vuiModel");
        CacheAbility cacheAbility = (CacheAbility) AbilityManager.b.b(CacheAbility.class);
        if (cacheAbility != null) {
            Object cacheWithDefault = cacheAbility.getCacheWithDefault("continuous_dialogue", Boolean.FALSE);
            Intrinsics.checkNotNullExpressionValue(cacheWithDefault, "getCacheWithDefault(...)");
            boolean booleanValue = ((Boolean) cacheWithDefault).booleanValue();
            if (booleanValue) {
                if (VoiceAssistantApi.isOversea || !vuiModel.isReject()) {
                    Communicator.b(112, Boolean.TRUE, new DomainCrossInterceptor$intercept$1());
                } else {
                    c(cacheAbility, vuiModel.getUtterance());
                    return true;
                }
            }
            JSONObject payload = vuiModel.getPayload();
            if (payload != null) {
                z = payload.containsKey("isSoundOpened") ? payload.getBooleanValue("isSoundOpened") : false;
                if (payload.containsKey("isNextRecorded")) {
                    Boolean bool = payload.getBoolean("isNextRecorded");
                    Intrinsics.checkNotNullExpressionValue(bool, "getBoolean(...)");
                    z2 = bool.booleanValue();
                } else {
                    z2 = false;
                }
            } else {
                z2 = false;
                z = false;
            }
            cacheAbility.cache("isSoundOpened", Boolean.valueOf(z));
            ILog.a("DomainCrossInterceptor", "云端返回的控制强多伦参数->" + (z && z2));
            if (!Intrinsics.areEqual((Object) VuiModelType.CURRENT_NOT_ALLOWED, (Object) vuiModel.getHeader().getName())) {
                return false;
            }
            ILog.a("DomainCrossInterceptor", "强制多轮，根据是否开启连续对话进行提示");
            Utterance utterance = vuiModel.getUtterance();
            String str = null;
            if (VoiceAssistantApi.isOversea) {
                TtsData ttsData = new TtsData();
                ttsData.setText(utterance != null ? utterance.getSpeech() : null);
                if (utterance != null) {
                    str = utterance.getId();
                }
                ttsData.setFunctionId(str);
                ttsData.setNextStep(2);
                TtsManager.g.f(ttsData);
            } else if (booleanValue) {
                c(cacheAbility, utterance);
            } else {
                TtsData ttsData2 = new TtsData();
                ttsData2.setText(utterance != null ? utterance.getSpeech() : null);
                if (utterance != null) {
                    str = utterance.getId();
                }
                ttsData2.setFunctionId(str);
                ttsData2.setNextStep(2);
                TtsManager.g.f(ttsData2);
            }
            return true;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public final void c(CacheAbility cacheAbility, Utterance utterance) {
        String speech;
        Integer num = (Integer) cacheAbility.getCacheWithDefault("rejectTimesInRound", 0);
        cacheAbility.cache("rejectTimesInRound", Integer.valueOf(num.intValue() + 1));
        Integer num2 = (Integer) cacheAbility.getCacheWithDefault("roundTimes", 0);
        ILog.a("DomainCrossInterceptor", "rejectInRound: " + num + ", rejectRound: " + num2);
        Intrinsics.checkNotNull(num2);
        if (num2.intValue() >= 3 || num.intValue() != 0) {
            d();
            return;
        }
        ILog.a("DomainCrossInterceptor", "播报拒识提示");
        TtsData ttsData = new TtsData();
        if (utterance == null || (speech = utterance.getSpeech()) == null || speech.length() <= 0) {
            TtsGlobalTemplate ttsGlobalTemplate = TtsGlobalTemplate.GLOBAL03_P06;
            ttsData.setText(ContextHelper.b(ttsGlobalTemplate.getResId(), new Object[0]));
            ttsData.setFunctionId(ttsGlobalTemplate.getFunctionId());
        } else {
            ttsData.setText(utterance.getSpeech());
            ttsData.setFunctionId(utterance.getId());
        }
        TtsDataTransform.f8607a.a(ttsData, false);
        TtsAbility ttsAbility = (TtsAbility) AbilityManager.b.b(TtsAbility.class);
        if (ttsAbility != null) {
            ttsAbility.startSpeak(ttsData, new DomainCrossInterceptor$showReject$1(this));
        }
    }

    public final void d() {
        Communicator.b(106, 10, new DomainCrossInterceptor$syncRejectStateToGlass$1());
    }

    public String getIdentifier() {
        return "domain-cross";
    }
}
