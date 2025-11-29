package com.xjsd.ai.assistant.phone.vui;

import com.xjsd.ai.assistant.common.handler.VuiHandler;
import com.xjsd.ai.assistant.core.ContextHelper;
import com.xjsd.ai.assistant.phone.NewFunctionCompact;
import com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder;
import com.xjsd.ai.assistant.phone.vui.settings.SettingsHelper;
import com.xjsd.ai.assistant.protocol.VuiModel;
import com.xjsd.ai.assistant.protocol.VuiModelType;
import com.xjsd.ai.assistant.template.TtsSettingTemplate;
import java.util.HashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bR\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\f8\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\r¨\u0006\u000f"}, d2 = {"Lcom/xjsd/ai/assistant/phone/vui/SettingsVuiHandler;", "Lcom/xjsd/ai/assistant/common/handler/VuiHandler;", "<init>", "()V", "", "getHandleType", "()Ljava/lang/String;", "Lcom/xjsd/ai/assistant/protocol/VuiModel;", "model", "", "a", "(Lcom/xjsd/ai/assistant/protocol/VuiModel;)Z", "", "Ljava/util/Set;", "mSupportTarget", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class SettingsVuiHandler implements VuiHandler {

    /* renamed from: a  reason: collision with root package name */
    public final Set f8626a;

    public SettingsVuiHandler() {
        HashSet hashSet = new HashSet();
        this.f8626a = hashSet;
        hashSet.add("no_disturb");
        hashSet.add("keep_dialog");
        hashSet.add("wake_up");
    }

    public boolean a(VuiModel vuiModel) {
        Intrinsics.checkNotNullParameter(vuiModel, "model");
        String name = vuiModel.getHeader().getName();
        String string = vuiModel.getPayload().getString("target");
        if (StringsKt.equals("SwitchSound", name, true) || StringsKt.equals("Switch", name, false)) {
            if (!NewFunctionCompact.d()) {
                return false;
            }
            Job unused = BuildersKt__Builders_commonKt.d(CoroutineScopeKt.a(Dispatchers.b()), (CoroutineContext) null, (CoroutineStart) null, new SettingsVuiHandler$handle$1(ContextHelper.a(), (Continuation<? super SettingsVuiHandler$handle$1>) null), 3, (Object) null);
            new PhoneTtsPlayBuilder().e(TtsSettingTemplate.SET05_P01).a().c();
            return true;
        } else if (!this.f8626a.contains(string) || (!Intrinsics.areEqual((Object) "TurnOff", (Object) name) && !Intrinsics.areEqual((Object) "TurnOn", (Object) name))) {
            return false;
        } else {
            Intrinsics.checkNotNull(string);
            SettingsHelper.a(string, Intrinsics.areEqual((Object) "TurnOn", (Object) name));
            return true;
        }
    }

    public String getHandleType() {
        return VuiModelType.SYSTEM_SETTING;
    }
}
