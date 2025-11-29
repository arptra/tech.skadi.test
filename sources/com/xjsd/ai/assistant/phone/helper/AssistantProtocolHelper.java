package com.xjsd.ai.assistant.phone.helper;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.honey.account.constant.AccountConstantKt;
import com.honey.account.view.web.WebJs;
import com.upuphone.xr.interconnect.entity.StarryNetMessage;
import com.xjsd.ai.assistant.connect.InterconnectAbility;
import com.xjsd.ai.assistant.core.AbilityManager;
import com.xjsd.ai.assistant.core.api.cache.CacheAbility;
import com.xjsd.ai.assistant.phone.VoiceAssistantApi;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CancellableContinuationImpl;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0004H@¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\t\u0010\bJ\u000f\u0010\n\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\n\u0010\bJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u000b\u0010\bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0004¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0004¢\u0006\u0004\b\u0014\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0004H@¢\u0006\u0004\b\u0015\u0010\u0006R\u0016\u0010\u0017\u001a\u00020\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0016R\u0016\u0010\u0018\u001a\u00020\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0016R\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00198\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u001b¨\u0006\u001d"}, d2 = {"Lcom/xjsd/ai/assistant/phone/helper/AssistantProtocolHelper;", "", "<init>", "()V", "", "e", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "f", "()Z", "i", "h", "g", "", "pkg", "", "j", "(I)V", "isAuth", "c", "(Z)V", "b", "d", "Z", "isNavProtocolAuthed", "isAiProtocolAuthed", "", "", "Ljava/util/Set;", "specificCountrySet", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nAssistantProtocolHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AssistantProtocolHelper.kt\ncom/xjsd/ai/assistant/phone/helper/AssistantProtocolHelper\n+ 2 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,156:1\n314#2,11:157\n*S KotlinDebug\n*F\n+ 1 AssistantProtocolHelper.kt\ncom/xjsd/ai/assistant/phone/helper/AssistantProtocolHelper\n*L\n48#1:157,11\n*E\n"})
public final class AssistantProtocolHelper {

    /* renamed from: a  reason: collision with root package name */
    public static final AssistantProtocolHelper f8558a = new AssistantProtocolHelper();
    public static boolean b;
    public static boolean c;
    public static final Set d = SetsKt.setOf("TH", "ID", "PH");

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object e(kotlin.coroutines.Continuation r4) {
        /*
            boolean r0 = r4 instanceof com.xjsd.ai.assistant.phone.helper.AssistantProtocolHelper$isUserAgreeLlmProtocol$1
            if (r0 == 0) goto L_0x0013
            r0 = r4
            com.xjsd.ai.assistant.phone.helper.AssistantProtocolHelper$isUserAgreeLlmProtocol$1 r0 = (com.xjsd.ai.assistant.phone.helper.AssistantProtocolHelper$isUserAgreeLlmProtocol$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.xjsd.ai.assistant.phone.helper.AssistantProtocolHelper$isUserAgreeLlmProtocol$1 r0 = new com.xjsd.ai.assistant.phone.helper.AssistantProtocolHelper$isUserAgreeLlmProtocol$1
            r0.<init>(r4)
        L_0x0018:
            java.lang.Object r4 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0031
            if (r2 != r3) goto L_0x0029
            kotlin.ResultKt.throwOnFailure(r4)
            goto L_0x004b
        L_0x0029:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r0)
            throw r4
        L_0x0031:
            kotlin.ResultKt.throwOnFailure(r4)
            boolean r4 = f()
            if (r4 == 0) goto L_0x0064
            com.xjsd.ai.assistant.phone.helper.AssistantProtocolHelper$isUserAgreeLlmProtocol$isAuth$1 r4 = new com.xjsd.ai.assistant.phone.helper.AssistantProtocolHelper$isUserAgreeLlmProtocol$isAuth$1
            r2 = 0
            r4.<init>(r2)
            r0.label = r3
            r2 = 3000(0xbb8, double:1.482E-320)
            java.lang.Object r4 = kotlinx.coroutines.TimeoutKt.d(r2, r4, r0)
            if (r4 != r1) goto L_0x004b
            return r1
        L_0x004b:
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "isUserAgreeLlmProtocol: 授权返回->"
            r0.append(r1)
            r0.append(r4)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "AssistantProtocolHelper"
            com.xjsd.ai.assistant.log.ILog.a(r1, r0)
            return r4
        L_0x0064:
            java.lang.Boolean r4 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xjsd.ai.assistant.phone.helper.AssistantProtocolHelper.e(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final boolean f() {
        return true;
    }

    public static final boolean g() {
        return VoiceAssistantApi.isOversea && d.contains(LocaleUtil.f8565a.a().getCountry());
    }

    public static final boolean h() {
        return c;
    }

    public static final boolean i() {
        return b;
    }

    public static final void j(int i) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(WebJs.ACTION, (Object) "system");
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put(WebJs.ACTION, (Object) "notify_statement_change_response");
        jSONObject2.put("type", (Object) "privacy_agreement");
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put(AccountConstantKt.REQUEST_HEADER_PKG, (Object) Integer.valueOf(i));
        jSONObject3.put("status", (Object) Boolean.FALSE);
        jSONArray.add(jSONObject3);
        Unit unit = Unit.INSTANCE;
        jSONObject2.put(AccountConstantKt.RESPONSE_VALUE, (Object) jSONArray);
        jSONObject.put("data", (Object) jSONObject2);
        StarryNetMessage starryNetMessage = new StarryNetMessage();
        starryNetMessage.setReceiverPkg("com.upuphone.star.launcher");
        starryNetMessage.setMessage(jSONObject.toJSONString());
        starryNetMessage.setTarget(1);
        InterconnectAbility interconnectAbility = (InterconnectAbility) AbilityManager.b.b(InterconnectAbility.class);
        Intrinsics.checkNotNull(interconnectAbility);
        interconnectAbility.getOperatorManager().getMessageOperator().sendMessage2(starryNetMessage, new AssistantProtocolHelper$showAlert$1$1());
    }

    public final void b(boolean z) {
        if (c != z) {
            c = z;
            CacheAbility cacheAbility = (CacheAbility) AbilityManager.b.b(CacheAbility.class);
            if (cacheAbility != null) {
                cacheAbility.cache("aiProtocolState", Boolean.valueOf(z));
            }
        }
    }

    public final void c(boolean z) {
        if (b != z) {
            b = z;
            CacheAbility cacheAbility = (CacheAbility) AbilityManager.b.b(CacheAbility.class);
            if (cacheAbility != null) {
                cacheAbility.cache("navProtocolState", Boolean.valueOf(z));
            }
        }
    }

    public final Object d(Continuation continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.x();
        InterconnectAbility interconnectAbility = (InterconnectAbility) AbilityManager.b.b(InterconnectAbility.class);
        Intrinsics.checkNotNull(interconnectAbility);
        interconnectAbility.getOperatorManager().getSappAbilityOperator().requestAIState(new AssistantProtocolHelper$isUserAgreeLlmAgreement$2$1(cancellableContinuationImpl));
        Object u = cancellableContinuationImpl.u();
        if (u == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return u;
    }
}
