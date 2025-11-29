package com.xjsd.ai.assistant.phone.vui;

import com.xjsd.ai.assistant.common.UnSupportFeatureManager;
import com.xjsd.ai.assistant.common.handler.VuiHandler;
import com.xjsd.ai.assistant.core.AbilityManager;
import com.xjsd.ai.assistant.core.api.cache.CacheAbility;
import com.xjsd.ai.assistant.log.ILog;
import com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder;
import com.xjsd.ai.assistant.protocol.VuiModel;
import com.xjsd.ai.assistant.template.TtsGlobalTemplate;
import com.xjsd.ai.assistant.template.TtsWechatTemplate;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 \n2\u00020\u0001:\u0001\fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"Lcom/xjsd/ai/assistant/phone/vui/WechatVuiHandler;", "Lcom/xjsd/ai/assistant/common/handler/VuiHandler;", "<init>", "()V", "", "getHandleType", "()Ljava/lang/String;", "Lcom/xjsd/ai/assistant/protocol/VuiModel;", "model", "", "a", "(Lcom/xjsd/ai/assistant/protocol/VuiModel;)Z", "Companion", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class WechatVuiHandler implements VuiHandler {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f8629a = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/xjsd/ai/assistant/phone/vui/WechatVuiHandler$Companion;", "", "()V", "TAG", "", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public boolean a(VuiModel vuiModel) {
        Intrinsics.checkNotNullParameter(vuiModel, "model");
        Locale locale = Locale.getDefault();
        ILog.a("WechatInterceptorHandler", "手机当前语言为->" + locale);
        CacheAbility cacheAbility = (CacheAbility) AbilityManager.b.b(CacheAbility.class);
        if (Intrinsics.areEqual((Object) cacheAbility != null ? (Boolean) cacheAbility.getCacheWithDefault("isThirdPlatform", Boolean.FALSE) : null, (Object) Boolean.TRUE) || !Intrinsics.areEqual((Object) locale.toString(), (Object) "zh_CN")) {
            ILog.a("WechatInterceptorHandler", "intercept cause third platform");
            UnSupportFeatureManager.f8414a.c();
            return true;
        }
        String name = vuiModel.getHeader().getName();
        if (Intrinsics.areEqual((Object) "Open", (Object) name)) {
            new PhoneTtsPlayBuilder().e(TtsWechatTemplate.Wechat09_R01).a().c();
            return true;
        } else if (!Intrinsics.areEqual((Object) "SwitchPage", (Object) name)) {
            return false;
        } else {
            new PhoneTtsPlayBuilder().e(TtsGlobalTemplate.GLOBAL03_P06).g(2).a().c();
            return true;
        }
    }

    public String getHandleType() {
        return "wechat";
    }
}
