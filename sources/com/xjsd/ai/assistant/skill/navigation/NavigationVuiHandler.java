package com.xjsd.ai.assistant.skill.navigation;

import android.content.Context;
import com.alibaba.fastjson.JSONObject;
import com.upuphone.star.core.log.ULog;
import com.xjsd.ai.assistant.common.handler.VuiHandler;
import com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder;
import com.xjsd.ai.assistant.protocol.VuiModel;
import com.xjsd.ai.assistant.protocol.VuiModelType;
import com.xjsd.ai.assistant.skill.navigation.checknavi.VoiceCheckNaviSupportCallback;
import com.xjsd.ai.assistant.skill.navigation.custom.CustomizedNavManager;
import com.xjsd.ai.assistant.skill.navigation.enums.NavUnusableReason;
import com.xjsd.ai.assistant.skill.navigation.process.MapRouteSetProcessor;
import com.xjsd.ai.assistant.skill.navigation.process.NavCmdProcessor;
import com.xjsd.ai.assistant.skill.navigation.process.NaviDirectiveProcessor;
import com.xjsd.ai.assistant.skill.navigation.process.NavigateProcessor;
import com.xjsd.ai.assistant.skill.navigation.process.QueryProcessor;
import com.xjsd.ai.assistant.skill.navigation.process.TurnOffProcessor;
import com.xjsd.ai.assistant.skill.navigation.process.TurnOnProcessor;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0006\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001cB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0013R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00060\u00148\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0015R \u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000e0\u00178\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001d"}, d2 = {"Lcom/xjsd/ai/assistant/skill/navigation/NavigationVuiHandler;", "Lcom/xjsd/ai/assistant/common/handler/VuiHandler;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "", "getHandleType", "()Ljava/lang/String;", "Lcom/xjsd/ai/assistant/protocol/VuiModel;", "model", "", "a", "(Lcom/xjsd/ai/assistant/protocol/VuiModel;)Z", "Lcom/xjsd/ai/assistant/skill/navigation/process/NavCmdProcessor;", "processor", "", "b", "(Lcom/xjsd/ai/assistant/skill/navigation/process/NavCmdProcessor;)V", "Landroid/content/Context;", "", "Ljava/util/Set;", "mSupportCommandSet", "", "c", "Ljava/util/Map;", "mNavCmdProcessorMap", "d", "Companion", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class NavigationVuiHandler implements VuiHandler {
    public static final Companion d = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public final Context f8686a;
    public final Set b;
    public final Map c = new HashMap();

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/xjsd/ai/assistant/skill/navigation/NavigationVuiHandler$Companion;", "", "()V", "TAG", "", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public NavigationVuiHandler(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f8686a = context;
        HashSet hashSet = new HashSet();
        this.b = hashSet;
        b(new MapRouteSetProcessor());
        b(new NaviDirectiveProcessor());
        b(new NavigateProcessor());
        b(new QueryProcessor());
        b(new TurnOffProcessor());
        b(new TurnOnProcessor());
        hashSet.add("MapOpen");
    }

    public boolean a(VuiModel vuiModel) {
        NavUnusableReason navUnusableReason;
        Intrinsics.checkNotNullParameter(vuiModel, "model");
        String name = vuiModel.getHeader().getName();
        if (Intrinsics.areEqual((Object) "Select", (Object) name)) {
            return CustomizedNavManager.c().g(vuiModel);
        }
        if (!this.b.contains(name)) {
            return false;
        }
        boolean z = this.f8686a.getSharedPreferences("navi_support_preferences", 0).getBoolean("isSupport", true);
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("NavigationVuiHandler", "--isSupport-- " + z);
        if (z) {
            navUnusableReason = NavUtil.a();
        } else {
            navUnusableReason = NavUnusableReason.REGION_NOT_SUPPORT;
            VoiceCheckNaviSupportCallback a2 = VoiceCheckNaviSupportManager.f42a.a();
            if (a2 != null) {
                a2.a(3);
            }
        }
        if (navUnusableReason != null) {
            if (navUnusableReason == NavUnusableReason.NOT_AGREE_PROTOCOL) {
                new PhoneTtsPlayBuilder().e(navUnusableReason.getTemplate()).h(NavigationVuiHandler$handle$1.INSTANCE).i(NavigationVuiHandler$handle$2.INSTANCE).a().c();
            } else if (navUnusableReason == NavUnusableReason.REGION_NOT_SUPPORT) {
                delegate.a("NavigationVuiHandler", "region_not_support");
            } else {
                new PhoneTtsPlayBuilder().e(navUnusableReason.getTemplate()).a().c();
            }
            return true;
        }
        CustomizedNavManager.c().a();
        if (StringsKt.equals("MapOpen", name, true)) {
            return false;
        }
        JSONObject payload = vuiModel.getPayload();
        NavCmdProcessor navCmdProcessor = (NavCmdProcessor) this.c.get(name);
        if (navCmdProcessor != null) {
            navCmdProcessor.a(payload);
        }
        return true;
    }

    public final void b(NavCmdProcessor navCmdProcessor) {
        Set set = this.b;
        String b2 = navCmdProcessor.b();
        Intrinsics.checkNotNullExpressionValue(b2, "getProcessType(...)");
        set.add(b2);
        Map map = this.c;
        String b3 = navCmdProcessor.b();
        Intrinsics.checkNotNullExpressionValue(b3, "getProcessType(...)");
        map.put(b3, navCmdProcessor);
    }

    public String getHandleType() {
        return VuiModelType.NAVIGATION;
    }
}
