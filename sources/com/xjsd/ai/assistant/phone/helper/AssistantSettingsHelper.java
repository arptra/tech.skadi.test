package com.xjsd.ai.assistant.phone.helper;

import android.content.Context;
import com.upuphone.ai.ttsengine.TtsSdk;
import com.xjsd.ai.assistant.common.Communicator;
import com.xjsd.ai.assistant.common.data.DataStoreUtils;
import com.xjsd.ai.assistant.core.AbilityManager;
import com.xjsd.ai.assistant.core.api.cache.CacheAbility;
import com.xjsd.ai.assistant.log.ILog;
import com.xjsd.ai.assistant.phone.tts.TtsTimbreConvert;
import com.xjsd.ai.assistant.protocol.setting.AssistantSettings;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0015\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ'\u0010\u000e\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0012\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0010H\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0010H\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u001a\u0010\u0019J\u0017\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u001b\u0010\u0016J \u0010\u001c\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0010H@¢\u0006\u0004\b\u001c\u0010\u001dJ'\u0010\u001e\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u001e\u0010\u000fR\u0016\u0010!\u001a\u00020\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010$\u001a\u00020\u00108\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\"\u0010#¨\u0006%"}, d2 = {"Lcom/xjsd/ai/assistant/phone/helper/AssistantSettingsHelper;", "", "<init>", "()V", "", "accountId", "", "l", "(Ljava/lang/String;)V", "Landroid/content/Context;", "context", "settings", "", "isOn", "n", "(Landroid/content/Context;Ljava/lang/String;Z)V", "", "timbreValue", "o", "(Landroid/content/Context;I)V", "ttsTimbre", "k", "(I)V", "value", "i", "(I)I", "j", "m", "h", "(Landroid/content/Context;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "g", "b", "Ljava/lang/String;", "mAccountId", "c", "I", "mSettingsOrigin", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class AssistantSettingsHelper {

    /* renamed from: a  reason: collision with root package name */
    public static final AssistantSettingsHelper f8560a = new AssistantSettingsHelper();
    public static String b = "";
    public static int c;

    public static final void k(int i) {
        String a2 = TtsTimbreConvert.a(i);
        CacheAbility cacheAbility = (CacheAbility) AbilityManager.b.b(CacheAbility.class);
        if (cacheAbility != null) {
            cacheAbility.cache("tts_timbre_type", a2);
            cacheAbility.cache("tts_timbre", Integer.valueOf(i));
        }
        TtsSdk.f5490a.n(a2);
    }

    public static final void l(String str) {
        Intrinsics.checkNotNullParameter(str, "accountId");
        ILog.a("AssistantSettingsHelper", "reloadSettingsData: accountId->" + str);
        if (!Intrinsics.areEqual((Object) b, (Object) str)) {
            b = str;
            Job unused = BuildersKt__Builders_commonKt.d(CoroutineScopeKt.a(Dispatchers.b()), (CoroutineContext) null, (CoroutineStart) null, new AssistantSettingsHelper$reloadSettingsData$1(str, (Continuation<? super AssistantSettingsHelper$reloadSettingsData$1>) null), 3, (Object) null);
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void n(android.content.Context r4, java.lang.String r5, boolean r6) {
        /*
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "settings"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            int r0 = r5.hashCode()
            r1 = -1
            r2 = 1
            switch(r0) {
                case -2089748325: goto L_0x004b;
                case -1948256433: goto L_0x0040;
                case -1536739064: goto L_0x0035;
                case -1406570633: goto L_0x002a;
                case -597320786: goto L_0x001f;
                case 1320798916: goto L_0x0014;
                default: goto L_0x0013;
            }
        L_0x0013:
            goto L_0x0053
        L_0x0014:
            java.lang.String r0 = "low_power_wakeup"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x001d
            goto L_0x0053
        L_0x001d:
            r0 = 0
            goto L_0x006d
        L_0x001f:
            java.lang.String r0 = "chat_gpt_card_display"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x0028
            goto L_0x0053
        L_0x0028:
            r0 = 5
            goto L_0x006d
        L_0x002a:
            java.lang.String r0 = "low_power_wakeup_screen_off"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x0033
            goto L_0x0053
        L_0x0033:
            r0 = r2
            goto L_0x006d
        L_0x0035:
            java.lang.String r0 = "continuous_dialogue"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x003e
            goto L_0x0053
        L_0x003e:
            r0 = 2
            goto L_0x006d
        L_0x0040:
            java.lang.String r0 = "asr_result_screen"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x0049
            goto L_0x0053
        L_0x0049:
            r0 = 3
            goto L_0x006d
        L_0x004b:
            java.lang.String r0 = "chat_gpt_tts_play"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x006c
        L_0x0053:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r3 = "updateOriginGenericSettings: not support->"
            r0.append(r3)
            r0.append(r5)
            java.lang.String r0 = r0.toString()
            java.lang.String r3 = "AssistantSettingsHelper"
            com.xjsd.ai.assistant.log.ILog.a(r3, r0)
            r0 = r1
            goto L_0x006d
        L_0x006c:
            r0 = 4
        L_0x006d:
            if (r0 != r1) goto L_0x0070
            return
        L_0x0070:
            if (r6 == 0) goto L_0x0078
            int r1 = c
            int r0 = r2 << r0
            r0 = r0 | r1
            goto L_0x007e
        L_0x0078:
            int r1 = c
            int r0 = r2 << r0
            int r0 = ~r0
            r0 = r0 & r1
        L_0x007e:
            com.xjsd.ai.assistant.phone.helper.AssistantSettingsHelper r1 = f8560a
            r1.m(r0)
            r1.g(r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xjsd.ai.assistant.phone.helper.AssistantSettingsHelper.n(android.content.Context, java.lang.String, boolean):void");
    }

    public static final void o(Context context, int i) {
        Intrinsics.checkNotNullParameter(context, "context");
        int i2 = c;
        int i3 = (i2 >> 16) & 65280;
        AssistantSettingsHelper assistantSettingsHelper = f8560a;
        int i4 = assistantSettingsHelper.i(i2);
        String binaryString = Integer.toBinaryString(i3);
        ILog.a("AssistantSettingsHelper", "updateOriginTtsTimbreSettings: 高位->" + binaryString);
        String binaryString2 = Integer.toBinaryString(i4);
        ILog.a("AssistantSettingsHelper", "updateOriginTtsTimbreSettings: 低位->" + binaryString2);
        int i5 = ((i3 + i) << 16) + i4;
        String binaryString3 = Integer.toBinaryString(i5);
        ILog.a("AssistantSettingsHelper", "updateOriginTtsTimbreSettings: 计算后->" + binaryString3);
        assistantSettingsHelper.m(i5);
        Job unused = BuildersKt__Builders_commonKt.d(CoroutineScopeKt.a(Dispatchers.b()), (CoroutineContext) null, (CoroutineStart) null, new AssistantSettingsHelper$updateOriginTtsTimbreSettings$1(context, i, (Continuation<? super AssistantSettingsHelper$updateOriginTtsTimbreSettings$1>) null), 3, (Object) null);
    }

    public final void g(Context context, String str, boolean z) {
        DataStoreUtils.f8415a.w(context, str, z);
        CacheAbility cacheAbility = (CacheAbility) AbilityManager.b.b(CacheAbility.class);
        if (cacheAbility != null) {
            cacheAbility.cache(str, Boolean.valueOf(z));
        }
        Communicator.b(111, new AssistantSettings(str, z, 0, 4, (DefaultConstructorMarker) null), new AssistantSettingsHelper$cacheAndSyncGenericSettings$2());
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object h(android.content.Context r5, int r6, kotlin.coroutines.Continuation r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof com.xjsd.ai.assistant.phone.helper.AssistantSettingsHelper$cacheAndSyncTtsTimbreSettings$1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            com.xjsd.ai.assistant.phone.helper.AssistantSettingsHelper$cacheAndSyncTtsTimbreSettings$1 r0 = (com.xjsd.ai.assistant.phone.helper.AssistantSettingsHelper$cacheAndSyncTtsTimbreSettings$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.xjsd.ai.assistant.phone.helper.AssistantSettingsHelper$cacheAndSyncTtsTimbreSettings$1 r0 = new com.xjsd.ai.assistant.phone.helper.AssistantSettingsHelper$cacheAndSyncTtsTimbreSettings$1
            r0.<init>(r4, r7)
        L_0x0018:
            java.lang.Object r4 = r0.result
            java.lang.Object r7 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r0.label
            r2 = 1
            if (r1 == 0) goto L_0x0033
            if (r1 != r2) goto L_0x002b
            int r6 = r0.I$0
            kotlin.ResultKt.throwOnFailure(r4)
            goto L_0x0043
        L_0x002b:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0033:
            kotlin.ResultKt.throwOnFailure(r4)
            com.xjsd.ai.assistant.common.data.DataStoreUtils r4 = com.xjsd.ai.assistant.common.data.DataStoreUtils.f8415a
            r0.I$0 = r6
            r0.label = r2
            java.lang.Object r4 = r4.p(r5, r6, r0)
            if (r4 != r7) goto L_0x0043
            return r7
        L_0x0043:
            k(r6)
            com.xjsd.ai.assistant.protocol.setting.AssistantSettings r4 = new com.xjsd.ai.assistant.protocol.setting.AssistantSettings
            java.lang.String r5 = "tts_timbre"
            r4.<init>(r5, r2, r6)
            com.xjsd.ai.assistant.phone.helper.AssistantSettingsHelper$cacheAndSyncTtsTimbreSettings$2$1 r5 = new com.xjsd.ai.assistant.phone.helper.AssistantSettingsHelper$cacheAndSyncTtsTimbreSettings$2$1
            r5.<init>()
            r6 = 111(0x6f, float:1.56E-43)
            com.xjsd.ai.assistant.common.Communicator.b(r6, r4, r5)
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xjsd.ai.assistant.phone.helper.AssistantSettingsHelper.h(android.content.Context, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final int i(int i) {
        return 65535 & i;
    }

    public final int j(int i) {
        return (i >> 16) & 255;
    }

    public final void m(int i) {
        String binaryString = Integer.toBinaryString(c);
        ILog.a("AssistantSettingsHelper", "storeOriginSettings: old->" + binaryString);
        String binaryString2 = Integer.toBinaryString(i);
        ILog.a("AssistantSettingsHelper", "storeOriginSettings: new->" + binaryString2);
        c = i;
        Job unused = BuildersKt__Builders_commonKt.d(CoroutineScopeKt.a(Dispatchers.b()), (CoroutineContext) null, (CoroutineStart) null, new AssistantSettingsHelper$storeOriginSettings$1(i, (Continuation<? super AssistantSettingsHelper$storeOriginSettings$1>) null), 3, (Object) null);
    }
}
