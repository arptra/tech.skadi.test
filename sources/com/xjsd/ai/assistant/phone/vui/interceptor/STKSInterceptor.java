package com.xjsd.ai.assistant.phone.vui.interceptor;

import android.text.TextUtils;
import com.xjsd.ai.assistant.common.handler.VuiInterceptor;
import com.xjsd.ai.assistant.core.AbilityManager;
import com.xjsd.ai.assistant.core.api.cache.CacheAbility;
import com.xjsd.ai.assistant.core.util.DotUtil;
import com.xjsd.ai.assistant.json.GsonUtils;
import com.xjsd.ai.assistant.log.ILog;
import com.xjsd.ai.assistant.phone.VoiceAssistantApi;
import com.xjsd.ai.assistant.phone.helper.VrStateSynchronizer;
import com.xjsd.ai.assistant.protocol.AssistantConstants;
import com.xjsd.ai.assistant.protocol.Scene;
import com.xjsd.ai.assistant.protocol.VuiModel;
import com.xjsd.ai.assistant.protocol.vui.Header;
import com.xjsd.ai.assistant.stks.dto.STKSResponse;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0007\u0018\u0000 \u00192\u00020\u0001:\u0001\u001aB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ)\u0010\u000f\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u00118\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0012R&\u0010\u0016\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00110\u00148\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0015R&\u0010\u0018\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00110\u00148\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0015¨\u0006\u001b"}, d2 = {"Lcom/xjsd/ai/assistant/phone/vui/interceptor/STKSInterceptor;", "Lcom/xjsd/ai/assistant/common/handler/VuiInterceptor;", "<init>", "()V", "", "getIdentifier", "()Ljava/lang/String;", "Lcom/xjsd/ai/assistant/protocol/VuiModel;", "vuiModel", "", "a", "(Lcom/xjsd/ai/assistant/protocol/VuiModel;)Z", "isStks", "scene", "stksData", "b", "(ZLjava/lang/String;Ljava/lang/String;)Z", "", "Ljava/util/List;", "specialScenes", "", "Ljava/util/Map;", "sceneFuncMap", "c", "sceneIdMap", "d", "Companion", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class STKSInterceptor implements VuiInterceptor {
    public static final Companion d = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public final List f8632a = CollectionsKt.listOf(Scene.CALL, Scene.WECHAT_RELAY);
    public final Map b = MapsKt.mapOf(TuplesKt.to(Scene.WECHAT_RELAY, CollectionsKt.listOf("wechat_send", "global_cancel", "global_confirm", "rephrase")));
    public final Map c = MapsKt.mapOf(TuplesKt.to(Scene.CALL, CollectionsKt.listOf(Scene.CALL, "global_ignore")));

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/xjsd/ai/assistant/phone/vui/interceptor/STKSInterceptor$Companion;", "", "()V", "TAG", "", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public boolean a(VuiModel vuiModel) {
        Intrinsics.checkNotNullParameter(vuiModel, "vuiModel");
        if (VoiceAssistantApi.isOversea) {
            ILog.a("STKSInterceptor", "海外版本不拦截");
            return false;
        }
        CacheAbility cacheAbility = (CacheAbility) AbilityManager.b.b(CacheAbility.class);
        String str = Scene.NORMAL;
        String str2 = cacheAbility != null ? (String) cacheAbility.getCacheWithDefault(AssistantConstants.Key.SCENE_ID, str) : null;
        if (str2 != null) {
            str = str2;
        }
        Header header = vuiModel.getHeader();
        if (!b((header == null || header.getName() == null || !Intrinsics.areEqual((Object) "SayVisible", (Object) header.getName())) ? false : true, str, vuiModel.getPayload().getString("stks"))) {
            return false;
        }
        ILog.m("STKSInterceptor", str + " need hit special stks");
        VrStateSynchronizer.a(str);
        return true;
    }

    public final boolean b(boolean z, String str, String str2) {
        ILog.a("STKSInterceptor", "isSpecialSceneNotHit scene=" + str + " isStks=" + z + " stksData=" + str2);
        if (this.f8632a.contains(str)) {
            if (!z || TextUtils.isEmpty(str2)) {
                return true;
            }
            Intrinsics.checkNotNull(str2);
            List<STKSResponse> b2 = GsonUtils.b(str2, STKSResponse.class);
            if (b2.isEmpty()) {
                return true;
            }
            if (Intrinsics.areEqual((Object) str, (Object) Scene.WECHAT_RELAY)) {
                for (STKSResponse sTKSResponse : b2) {
                    List list = (List) this.b.get(str);
                    if (list != null && list.contains(sTKSResponse.getFunc())) {
                        return false;
                    }
                }
            }
            if (Intrinsics.areEqual((Object) str, (Object) Scene.CALL)) {
                for (STKSResponse sTKSResponse2 : b2) {
                    List list2 = (List) this.c.get(str);
                    if (list2 != null && list2.contains(sTKSResponse2.getSceneId())) {
                        DotUtil.b("vad_end", "在线电话指令匹配耗时");
                        return false;
                    }
                }
            }
        }
        return false;
    }

    public String getIdentifier() {
        return "stks";
    }
}
