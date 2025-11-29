package com.xjsd.ai.assistant.common;

import com.xjsd.ai.assistant.core.AbilityManager;
import com.xjsd.ai.assistant.core.ContextHelper;
import com.xjsd.ai.assistant.core.api.cache.CacheAbility;
import com.xjsd.ai.assistant.core.api.tts.TtsAbility;
import com.xjsd.ai.assistant.core.api.tts.TtsData;
import com.xjsd.ai.assistant.log.ILog;
import com.xjsd.ai.assistant.template.TtsGlobalTemplate;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\u0003J\u000f\u0010\n\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\n\u0010\u0003R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u000e"}, d2 = {"Lcom/xjsd/ai/assistant/common/UnSupportFeatureManager;", "", "<init>", "()V", "Lcom/xjsd/ai/assistant/common/UnSupportFeatureHandler;", "handler", "", "e", "(Lcom/xjsd/ai/assistant/common/UnSupportFeatureHandler;)V", "c", "d", "b", "Lcom/xjsd/ai/assistant/common/UnSupportFeatureHandler;", "unSupportFeatureHandler", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class UnSupportFeatureManager {

    /* renamed from: a  reason: collision with root package name */
    public static final UnSupportFeatureManager f8414a = new UnSupportFeatureManager();
    public static UnSupportFeatureHandler b;

    public final void c() {
        TtsGlobalTemplate ttsGlobalTemplate = TtsGlobalTemplate.GLOBAL03_P06;
        TtsData ttsData = new TtsData();
        ttsData.setText(ContextHelper.b(ttsGlobalTemplate.getResId(), new Object[0]));
        ttsData.setFunctionId(ttsGlobalTemplate.getFunctionId());
        TtsAbility ttsAbility = (TtsAbility) AbilityManager.b.b(TtsAbility.class);
        if (ttsAbility != null) {
            ttsAbility.startSpeak(ttsData, new UnSupportFeatureManager$handle$1());
        }
    }

    public final void d() {
        CacheAbility cacheAbility = (CacheAbility) AbilityManager.b.b(CacheAbility.class);
        Boolean bool = cacheAbility != null ? (Boolean) cacheAbility.getCacheWithDefault("continuous_dialogue", Boolean.FALSE) : null;
        if (bool == null ? false : bool.booleanValue()) {
            ILog.a("UnSupportFeatureHandler", "连续对话开关打开，分发继续对话action");
            UnSupportFeatureHandler unSupportFeatureHandler = b;
            if (unSupportFeatureHandler != null) {
                unSupportFeatureHandler.e();
                return;
            }
            return;
        }
        ILog.a("UnSupportFeatureHandler", "连续对话开关关闭，分发退出action");
        UnSupportFeatureHandler unSupportFeatureHandler2 = b;
        if (unSupportFeatureHandler2 != null) {
            unSupportFeatureHandler2.c();
        }
    }

    public final void e(UnSupportFeatureHandler unSupportFeatureHandler) {
        Intrinsics.checkNotNullParameter(unSupportFeatureHandler, "handler");
        b = unSupportFeatureHandler;
    }
}
