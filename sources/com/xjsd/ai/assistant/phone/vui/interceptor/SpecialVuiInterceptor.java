package com.xjsd.ai.assistant.phone.vui.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.google.android.gms.actions.SearchIntents;
import com.xjsd.ai.assistant.chatgpt.model.LlmResponse;
import com.xjsd.ai.assistant.common.Communicator;
import com.xjsd.ai.assistant.common.handler.VuiInterceptor;
import com.xjsd.ai.assistant.common.manager.VuiHandlerManager;
import com.xjsd.ai.assistant.core.AbilityManager;
import com.xjsd.ai.assistant.core.ContextHelper;
import com.xjsd.ai.assistant.core.api.cache.CacheAbility;
import com.xjsd.ai.assistant.json.JsonUtil;
import com.xjsd.ai.assistant.log.ILog;
import com.xjsd.ai.assistant.phone.R;
import com.xjsd.ai.assistant.phone.VuiHandleDelegate;
import com.xjsd.ai.assistant.phone.helper.ExitTimer;
import com.xjsd.ai.assistant.protocol.VuiModel;
import com.xjsd.ai.assistant.protocol.VuiModelType;
import com.xjsd.ai.assistant.protocol.vui.Header;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \n2\u00020\u0001:\u0001\u0018B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\r\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\r\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000e\u0010\u000bJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0013\u0010\u0012J\u0017\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0016\u0010\u0017¨\u0006\u0019"}, d2 = {"Lcom/xjsd/ai/assistant/phone/vui/interceptor/SpecialVuiInterceptor;", "Lcom/xjsd/ai/assistant/common/handler/VuiInterceptor;", "<init>", "()V", "", "getIdentifier", "()Ljava/lang/String;", "Lcom/xjsd/ai/assistant/protocol/VuiModel;", "vuiModel", "", "a", "(Lcom/xjsd/ai/assistant/protocol/VuiModel;)Z", "model", "e", "d", "originVuiModel", "", "c", "(Lcom/xjsd/ai/assistant/protocol/VuiModel;)V", "f", "Lcom/xjsd/ai/assistant/chatgpt/model/LlmResponse;", "llmResponse", "b", "(Lcom/xjsd/ai/assistant/chatgpt/model/LlmResponse;)V", "Companion", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nSpecialVuiInterceptor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpecialVuiInterceptor.kt\ncom/xjsd/ai/assistant/phone/vui/interceptor/SpecialVuiInterceptor\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,150:1\n1#2:151\n*E\n"})
public final class SpecialVuiInterceptor implements VuiInterceptor {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f8633a = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/xjsd/ai/assistant/phone/vui/interceptor/SpecialVuiInterceptor$Companion;", "", "()V", "TAG", "", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public boolean a(VuiModel vuiModel) {
        Intrinsics.checkNotNullParameter(vuiModel, "vuiModel");
        CacheAbility cacheAbility = (CacheAbility) AbilityManager.b.b(CacheAbility.class);
        if (d(vuiModel)) {
            ExitTimer.f8563a.c();
            f(vuiModel);
            VuiHandlerManager.d.g("llm");
            if (cacheAbility != null) {
                cacheAbility.cache("isInChatGptScene", Boolean.TRUE);
            }
            return true;
        } else if (!e(vuiModel)) {
            return false;
        } else {
            ExitTimer.f8563a.c();
            c(vuiModel);
            return true;
        }
    }

    public final void b(LlmResponse llmResponse) {
        String c = JsonUtil.c(llmResponse);
        ILog.a("SpecialVuiInterceptor", "mock chatGpt response->" + c);
        Communicator.b(122, llmResponse, new SpecialVuiInterceptor$handleChatGptResponse$1());
    }

    public final void c(VuiModel vuiModel) {
        vuiModel.getHeader().setSpecialCmdInChatGptScene(true);
        VuiHandleDelegate.f8537a.b(vuiModel);
        f(vuiModel);
    }

    public final boolean d(VuiModel vuiModel) {
        return Intrinsics.areEqual((Object) VuiModelType.FREE_CHAT, (Object) vuiModel.getHeader().getNamespace());
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x006f, code lost:
        if (r4.equals("AdjustBrightness") == false) goto L_0x0097;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0078, code lost:
        if (r4.equals("AdjustVolume") == false) goto L_0x0097;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0081, code lost:
        if (r4.equals("TurnOff") != false) goto L_0x0096;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x008a, code lost:
        if (r4.equals("SetVolume") == false) goto L_0x0097;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0093, code lost:
        if (r4.equals("TurnOn") == false) goto L_0x0097;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0096, code lost:
        r0 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0066, code lost:
        if (r4.equals("SetBrightness") == false) goto L_0x0097;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean e(com.xjsd.ai.assistant.protocol.VuiModel r4) {
        /*
            r3 = this;
            com.xjsd.ai.assistant.core.AbilityManager r3 = com.xjsd.ai.assistant.core.AbilityManager.b
            java.lang.Class<com.xjsd.ai.assistant.core.api.cache.CacheAbility> r0 = com.xjsd.ai.assistant.core.api.cache.CacheAbility.class
            com.xjsd.ai.assistant.core.Ability r3 = r3.b(r0)
            com.xjsd.ai.assistant.core.api.cache.CacheAbility r3 = (com.xjsd.ai.assistant.core.api.cache.CacheAbility) r3
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3)
            java.lang.Boolean r0 = java.lang.Boolean.FALSE
            java.lang.String r1 = "isGptCosplay"
            java.lang.Object r3 = r3.getCacheWithDefault(r1, r0)
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            boolean r3 = r3.booleanValue()
            r0 = 0
            if (r3 != 0) goto L_0x001f
            return r0
        L_0x001f:
            com.xjsd.ai.assistant.protocol.vui.Header r3 = r4.getHeader()
            java.lang.String r3 = r3.getNamespace()
            com.xjsd.ai.assistant.protocol.vui.Header r4 = r4.getHeader()
            java.lang.String r4 = r4.getName()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "chatGpt specialHandle namespace->"
            r1.append(r2)
            r1.append(r3)
            java.lang.String r2 = ", name->"
            r1.append(r2)
            r1.append(r4)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "SpecialVuiInterceptor"
            com.xjsd.ai.assistant.log.ILog.a(r2, r1)
            java.lang.String r1 = "systemsetting"
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r1)
            if (r3 == 0) goto L_0x0097
            if (r4 == 0) goto L_0x0097
            int r3 = r4.hashCode()
            switch(r3) {
                case -1778562212: goto L_0x008d;
                case -1620484612: goto L_0x0084;
                case 699146130: goto L_0x007b;
                case 1118451625: goto L_0x0072;
                case 1901632864: goto L_0x0069;
                case 1923506739: goto L_0x0060;
                default: goto L_0x005f;
            }
        L_0x005f:
            goto L_0x0097
        L_0x0060:
            java.lang.String r3 = "SetBrightness"
            boolean r3 = r4.equals(r3)
            if (r3 != 0) goto L_0x0096
            goto L_0x0097
        L_0x0069:
            java.lang.String r3 = "AdjustBrightness"
            boolean r3 = r4.equals(r3)
            if (r3 != 0) goto L_0x0096
            goto L_0x0097
        L_0x0072:
            java.lang.String r3 = "AdjustVolume"
            boolean r3 = r4.equals(r3)
            if (r3 != 0) goto L_0x0096
            goto L_0x0097
        L_0x007b:
            java.lang.String r3 = "TurnOff"
            boolean r3 = r4.equals(r3)
            if (r3 == 0) goto L_0x0097
            goto L_0x0096
        L_0x0084:
            java.lang.String r3 = "SetVolume"
            boolean r3 = r4.equals(r3)
            if (r3 != 0) goto L_0x0096
            goto L_0x0097
        L_0x008d:
            java.lang.String r3 = "TurnOn"
            boolean r3 = r4.equals(r3)
            if (r3 != 0) goto L_0x0096
            goto L_0x0097
        L_0x0096:
            r0 = 1
        L_0x0097:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "chatGpt specialHandle result->"
            r3.append(r4)
            r3.append(r0)
            java.lang.String r3 = r3.toString()
            com.xjsd.ai.assistant.log.ILog.a(r2, r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xjsd.ai.assistant.phone.vui.interceptor.SpecialVuiInterceptor.e(com.xjsd.ai.assistant.protocol.VuiModel):boolean");
    }

    public final void f(VuiModel vuiModel) {
        VuiModel vuiModel2 = new VuiModel();
        Header header = new Header();
        header.setNamespace("llm");
        header.setName("default");
        header.setSpecialCmdInChatGptScene(true);
        vuiModel2.setHeader(header);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(SearchIntents.EXTRA_QUERY, vuiModel.getPayload().getString(SearchIntents.EXTRA_QUERY));
        vuiModel2.setPayload(jSONObject);
        Communicator.b(102, vuiModel2, new SpecialVuiInterceptor$mockLlmVui$1());
        String speech = d(vuiModel) ? vuiModel.getUtterance().getSpeech() : ContextHelper.b(R.string.tts_common_ok, new Object[0]);
        Intrinsics.checkNotNull(speech);
        LlmResponse llmResponse = new LlmResponse(1, speech, "0", true, (String) null, 16, (DefaultConstructorMarker) null);
        b(llmResponse);
        llmResponse.setBase_status(2);
        b(llmResponse);
    }

    public String getIdentifier() {
        return "special-vui";
    }
}
