package com.xjsd.ai.assistant.nlu;

import android.text.TextUtils;
import com.upuphone.runasone.relay.api.IntentKey;
import com.xjsd.ai.assistant.core.Ability;
import com.xjsd.ai.assistant.core.AbilityManager;
import com.xjsd.ai.assistant.core.api.cache.CacheAbility;
import com.xjsd.ai.assistant.json.GsonUtils;
import com.xjsd.ai.assistant.log.ILog;
import com.xjsd.ai.assistant.nlu.bean.ContextData;
import com.xjsd.ai.assistant.nlu.util.AutoExcludeNullArrayList;
import com.xjsd.ai.assistant.protocol.AssistantConstants;
import com.xjsd.ai.assistant.protocol.Scene;
import com.xjsd.ai.assistant.protocol.VuiModelType;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.lang3.BooleanUtils;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\fJ\u0013\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013R0\u0010\u0017\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\u0014j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0006`\u00158\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u0016R\u001c\u0010\u001a\u001a\n \u0018*\u0004\u0018\u00010\u00060\u00068\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0019R\u0014\u0010\u001d\u001a\u00020\u001b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u001c¨\u0006\u001e"}, d2 = {"Lcom/xjsd/ai/assistant/nlu/NluContextDataMaintainer;", "", "<init>", "()V", "", "key", "Lcom/xjsd/ai/assistant/nlu/bean/ContextData;", "data", "", "a", "(Ljava/lang/String;Lcom/xjsd/ai/assistant/nlu/bean/ContextData;)V", "d", "(Ljava/lang/String;)V", "", "b", "()Ljava/util/List;", "Lcom/xjsd/ai/assistant/core/api/cache/CacheAbility;", "cacheAbility", "c", "(Lcom/xjsd/ai/assistant/core/api/cache/CacheAbility;)Lcom/xjsd/ai/assistant/nlu/bean/ContextData;", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "mContextDataMap", "kotlin.jvm.PlatformType", "Lcom/xjsd/ai/assistant/nlu/bean/ContextData;", "mNavStateContextData", "Lcom/xjsd/ai/assistant/nlu/bean/ContextData$AssistantInfo;", "Lcom/xjsd/ai/assistant/nlu/bean/ContextData$AssistantInfo;", "mAssistantInfo", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class NluContextDataMaintainer {

    /* renamed from: a  reason: collision with root package name */
    public static final NluContextDataMaintainer f8512a = new NluContextDataMaintainer();
    public static final HashMap b = new HashMap();
    public static final ContextData c = new ContextData(VuiModelType.APPLICATION, "naving").appendPayload("naving", Boolean.TRUE);
    public static final ContextData.AssistantInfo d;

    static {
        ContextData.AssistantInfo assistantInfo = new ContextData.AssistantInfo();
        ContextData.Wakeup wakeup = new ContextData.Wakeup();
        wakeup.setStatus(true);
        wakeup.setType("voice");
        wakeup.setDeviceType("eyeglasses");
        wakeup.setWakeupWord("嗨，小纪");
        assistantInfo.setWakeup(wakeup);
        ContextData.Personalization personalization = new ContextData.Personalization();
        personalization.setTtsSpeaker("潇洒诗仙");
        personalization.setWakeupWord("你好，大白");
        assistantInfo.setPersonalization(personalization);
        d = assistantInfo;
    }

    public final void a(String str, ContextData contextData) {
        Intrinsics.checkNotNullParameter(str, IntentKey.ACTIVITY.ACTION_KEY);
        Intrinsics.checkNotNullParameter(contextData, "data");
        String e = GsonUtils.e(contextData);
        ILog.a("NluContextDataMaintainer", "addContextData: 追加->" + str + "上下文数据->" + e);
        b.put(str, contextData);
    }

    public final List b() {
        String str;
        AutoExcludeNullArrayList autoExcludeNullArrayList = new AutoExcludeNullArrayList();
        AbilityManager abilityManager = AbilityManager.b;
        Class<CacheAbility> cls = CacheAbility.class;
        Ability b2 = abilityManager.b(cls);
        Intrinsics.checkNotNull(b2);
        CacheAbility cacheAbility = (CacheAbility) b2;
        Boolean bool = Boolean.FALSE;
        Boolean bool2 = (Boolean) cacheAbility.getCacheWithDefault(AssistantConstants.Key.CLEAN_CONTEXT, bool);
        ContextData.AssistantInfo assistantInfo = d;
        ContextData.Wakeup wakeup = assistantInfo.getWakeup();
        CacheAbility cacheAbility2 = (CacheAbility) abilityManager.b(cls);
        String str2 = "";
        if (!(cacheAbility2 == null || (str = (String) cacheAbility2.getCacheWithDefault("nlu_device_type", str2)) == null)) {
            str2 = str;
        }
        wakeup.setDeviceType(str2);
        Intrinsics.checkNotNull(bool2);
        if (bool2.booleanValue()) {
            ILog.a("NluContextDataMaintainer", "getContextData: 清除上下文");
            autoExcludeNullArrayList.add(new ContextData("context", "clean_context").appendPayload("assistantInfo", assistantInfo));
        } else {
            ILog.a("NluContextDataMaintainer", "getContextData: 保持上下文");
            autoExcludeNullArrayList.add(new ContextData("env", "assistant").appendPayload("assistantInfo", assistantInfo));
        }
        String str3 = (String) cacheAbility.getCacheWithDefault(AssistantConstants.Key.SCENE_ID, Scene.NORMAL);
        if (!(str3 == null || str3.length() == 0 || Intrinsics.areEqual((Object) str3, (Object) Scene.NORMAL))) {
            autoExcludeNullArrayList.add(new ContextData(AssistantConstants.Key.SCENE_ID, str3));
        }
        Object cacheWithDefault = cacheAbility.getCacheWithDefault("isNavigating", bool);
        Intrinsics.checkNotNullExpressionValue(cacheWithDefault, "getCacheWithDefault(...)");
        if (((Boolean) cacheWithDefault).booleanValue()) {
            autoExcludeNullArrayList.add(c);
        }
        ContextData appendPayload = new ContextData(VuiModelType.FREE_CHAT, "scenario").appendPayload("isUseGPT", 0);
        Object cacheWithDefault2 = cacheAbility.getCacheWithDefault("isGptCosplay", bool);
        Intrinsics.checkNotNullExpressionValue(cacheWithDefault2, "getCacheWithDefault(...)");
        if (((Boolean) cacheWithDefault2).booleanValue()) {
            appendPayload.appendPayload("play_status", 1);
        } else {
            appendPayload.appendPayload("play_status", 0);
        }
        autoExcludeNullArrayList.add(appendPayload);
        autoExcludeNullArrayList.add(c(cacheAbility));
        autoExcludeNullArrayList.addAll(b.values());
        return autoExcludeNullArrayList;
    }

    public final ContextData c(CacheAbility cacheAbility) {
        Boolean bool = Boolean.FALSE;
        if (!((Boolean) cacheAbility.getCacheWithDefault("continuous_dialogue", bool)).booleanValue()) {
            return null;
        }
        Boolean bool2 = (Boolean) cacheAbility.getCacheWithDefault("isSoundOpened", bool);
        int i = (Integer) cacheAbility.getCacheWithDefault("roundTimes", 0);
        int i2 = (Integer) cacheAbility.getCacheWithDefault("rejectTimesInRound", 0);
        boolean isEmpty = TextUtils.isEmpty((String) cacheAbility.getCacheWithDefault("lastNluQuery", ""));
        ContextData contextData = new ContextData("dialog_status", "status");
        String str = BooleanUtils.TRUE;
        ContextData appendPayload = contextData.appendPayload("continueDialogue", isEmpty ? BooleanUtils.FALSE : str);
        Intrinsics.checkNotNull(bool2);
        if (!bool2.booleanValue()) {
            str = BooleanUtils.FALSE;
        }
        ContextData appendPayload2 = appendPayload.appendPayload("strongMultiWheel", str);
        if (isEmpty) {
            i = 0;
        }
        ContextData appendPayload3 = appendPayload2.appendPayload("roundTimes", i);
        if (isEmpty) {
            i2 = 0;
        }
        return appendPayload3.appendPayload("rejectTimesInRound", i2);
    }

    public final void d(String str) {
        Intrinsics.checkNotNullParameter(str, IntentKey.ACTIVITY.ACTION_KEY);
        if (b.remove(str) != null) {
            ILog.a("NluContextDataMaintainer", "removeContextData: 移除->" + str + "上下文数据");
        }
    }
}
