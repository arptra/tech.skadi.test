package com.xjsd.ai.assistant.phone.helper;

import android.content.Context;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.xjsd.ai.assistant.phone.helper.AssistantSettingUtils$cacheAssistantSettings$1", f = "AssistantSettingUtils.kt", i = {0, 1, 1, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6}, l = {90, 91, 92, 93, 94, 95, 96}, m = "invokeSuspend", n = {"it", "it", "asrResultScreen", "it", "asrResultScreen", "lowPowerWakeup", "it", "asrResultScreen", "lowPowerWakeup", "lowPowerWakeupScreenOff", "it", "asrResultScreen", "lowPowerWakeup", "lowPowerWakeupScreenOff", "continuousDialogue", "it", "asrResultScreen", "lowPowerWakeup", "lowPowerWakeupScreenOff", "continuousDialogue", "chatGptTtsPlay", "it", "asrResultScreen", "lowPowerWakeup", "lowPowerWakeupScreenOff", "continuousDialogue", "chatGptTtsPlay", "chatGptCardDisplay"}, s = {"L$1", "L$1", "Z$0", "L$1", "Z$0", "Z$1", "L$1", "Z$0", "Z$1", "Z$2", "L$1", "Z$0", "Z$1", "Z$2", "Z$3", "L$1", "Z$0", "Z$1", "Z$2", "Z$3", "Z$4", "L$0", "Z$0", "Z$1", "Z$2", "Z$3", "Z$4", "Z$5"})
public final class AssistantSettingUtils$cacheAssistantSettings$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    Object L$0;
    Object L$1;
    boolean Z$0;
    boolean Z$1;
    boolean Z$2;
    boolean Z$3;
    boolean Z$4;
    boolean Z$5;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AssistantSettingUtils$cacheAssistantSettings$1(Context context, Continuation<? super AssistantSettingUtils$cacheAssistantSettings$1> continuation) {
        super(2, continuation);
        this.$context = context;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new AssistantSettingUtils$cacheAssistantSettings$1(this.$context, continuation);
    }

    /* JADX WARNING: type inference failed for: r13v29, types: [com.xjsd.ai.assistant.core.Ability] */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x00c2, code lost:
        r13 = ((java.lang.Boolean) r13).booleanValue();
        r2 = com.xjsd.ai.assistant.common.data.DataStoreUtils.f8415a;
        r12.L$0 = r3;
        r12.L$1 = r1;
        r12.Z$0 = r13;
        r12.label = 2;
        r2 = r2.n(r3, r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x00d7, code lost:
        if (r2 != r0) goto L_0x00da;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x00d9, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x00da, code lost:
        r10 = r2;
        r2 = r13;
        r13 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x00dd, code lost:
        r13 = ((java.lang.Boolean) r13).booleanValue();
        r4 = com.xjsd.ai.assistant.common.data.DataStoreUtils.f8415a;
        r12.L$0 = r3;
        r12.L$1 = r1;
        r12.Z$0 = r2;
        r12.Z$1 = r13;
        r12.label = 3;
        r4 = r4.o(r3, r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x00f4, code lost:
        if (r4 != r0) goto L_0x00f7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00f6, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00f7, code lost:
        r5 = r3;
        r3 = r1;
        r1 = r13;
        r13 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00fb, code lost:
        r13 = ((java.lang.Boolean) r13).booleanValue();
        r4 = com.xjsd.ai.assistant.common.data.DataStoreUtils.f8415a;
        r12.L$0 = r5;
        r12.L$1 = r3;
        r12.Z$0 = r2;
        r12.Z$1 = r1;
        r12.Z$2 = r13;
        r12.label = 4;
        r4 = r4.m(r5, r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0114, code lost:
        if (r4 != r0) goto L_0x0117;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0116, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0117, code lost:
        r10 = r2;
        r2 = r13;
        r13 = r4;
        r4 = r10;
        r11 = r3;
        r3 = r1;
        r1 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x011e, code lost:
        r13 = ((java.lang.Boolean) r13).booleanValue();
        r6 = com.xjsd.ai.assistant.common.data.DataStoreUtils.f8415a;
        r12.L$0 = r5;
        r12.L$1 = r1;
        r12.Z$0 = r4;
        r12.Z$1 = r3;
        r12.Z$2 = r2;
        r12.Z$3 = r13;
        r12.label = 5;
        r6 = r6.l(r5, r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0139, code lost:
        if (r6 != r0) goto L_0x013c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x013b, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x013c, code lost:
        r7 = r5;
        r5 = r1;
        r1 = r13;
        r13 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0140, code lost:
        r13 = ((java.lang.Boolean) r13).booleanValue();
        r6 = com.xjsd.ai.assistant.common.data.DataStoreUtils.f8415a;
        r12.L$0 = r7;
        r12.L$1 = r5;
        r12.Z$0 = r4;
        r12.Z$1 = r3;
        r12.Z$2 = r2;
        r12.Z$3 = r1;
        r12.Z$4 = r13;
        r12.label = 6;
        r6 = r6.k(r7, r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x015d, code lost:
        if (r6 != r0) goto L_0x0160;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x015f, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0160, code lost:
        r10 = r1;
        r1 = r13;
        r13 = r6;
        r6 = r4;
        r4 = r3;
        r3 = r2;
        r2 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0167, code lost:
        r13 = ((java.lang.Boolean) r13).booleanValue();
        r8 = com.xjsd.ai.assistant.common.data.DataStoreUtils.f8415a;
        r12.L$0 = r5;
        r12.L$1 = null;
        r12.Z$0 = r6;
        r12.Z$1 = r4;
        r12.Z$2 = r3;
        r12.Z$3 = r2;
        r12.Z$4 = r1;
        r12.Z$5 = r13;
        r12.label = 7;
        r12 = r8.i(r7, r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0187, code lost:
        if (r12 != r0) goto L_0x018a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0189, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x018a, code lost:
        r0 = r13;
        r13 = r12;
        r12 = r5;
        r5 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x018e, code lost:
        r13 = ((java.lang.Number) r13).intValue();
        r12.cache("low_power_wakeup", kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r4));
        r12.cache("low_power_wakeup_screen_off", kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3));
        r12.cache("continuous_dialogue", kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r2));
        r12.cache("asr_result_screen", kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r5));
        r12.cache("chat_gpt_tts_play", kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r1));
        r12.cache("chat_gpt_card_display", kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r0));
        com.xjsd.ai.assistant.phone.helper.AssistantSettingsHelper.k(r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x01cf, code lost:
        return kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r13) {
        /*
            r12 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r12.label
            switch(r1) {
                case 0: goto L_0x009e;
                case 1: goto L_0x0091;
                case 2: goto L_0x0080;
                case 3: goto L_0x006e;
                case 4: goto L_0x0056;
                case 5: goto L_0x0040;
                case 6: goto L_0x0026;
                case 7: goto L_0x0011;
                default: goto L_0x0009;
            }
        L_0x0009:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L_0x0011:
            boolean r0 = r12.Z$5
            boolean r1 = r12.Z$4
            boolean r2 = r12.Z$3
            boolean r3 = r12.Z$2
            boolean r4 = r12.Z$1
            boolean r5 = r12.Z$0
            java.lang.Object r12 = r12.L$0
            com.xjsd.ai.assistant.core.api.cache.CacheAbility r12 = (com.xjsd.ai.assistant.core.api.cache.CacheAbility) r12
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x018e
        L_0x0026:
            boolean r1 = r12.Z$4
            boolean r2 = r12.Z$3
            boolean r3 = r12.Z$2
            boolean r4 = r12.Z$1
            boolean r5 = r12.Z$0
            java.lang.Object r6 = r12.L$1
            com.xjsd.ai.assistant.core.api.cache.CacheAbility r6 = (com.xjsd.ai.assistant.core.api.cache.CacheAbility) r6
            java.lang.Object r7 = r12.L$0
            android.content.Context r7 = (android.content.Context) r7
            kotlin.ResultKt.throwOnFailure(r13)
            r10 = r6
            r6 = r5
            r5 = r10
            goto L_0x0167
        L_0x0040:
            boolean r1 = r12.Z$3
            boolean r2 = r12.Z$2
            boolean r3 = r12.Z$1
            boolean r4 = r12.Z$0
            java.lang.Object r5 = r12.L$1
            com.xjsd.ai.assistant.core.api.cache.CacheAbility r5 = (com.xjsd.ai.assistant.core.api.cache.CacheAbility) r5
            java.lang.Object r6 = r12.L$0
            android.content.Context r6 = (android.content.Context) r6
            kotlin.ResultKt.throwOnFailure(r13)
            r7 = r6
            goto L_0x0140
        L_0x0056:
            boolean r1 = r12.Z$2
            boolean r2 = r12.Z$1
            boolean r3 = r12.Z$0
            java.lang.Object r4 = r12.L$1
            com.xjsd.ai.assistant.core.api.cache.CacheAbility r4 = (com.xjsd.ai.assistant.core.api.cache.CacheAbility) r4
            java.lang.Object r5 = r12.L$0
            android.content.Context r5 = (android.content.Context) r5
            kotlin.ResultKt.throwOnFailure(r13)
            r10 = r2
            r2 = r1
            r1 = r4
            r4 = r3
            r3 = r10
            goto L_0x011e
        L_0x006e:
            boolean r1 = r12.Z$1
            boolean r2 = r12.Z$0
            java.lang.Object r3 = r12.L$1
            com.xjsd.ai.assistant.core.api.cache.CacheAbility r3 = (com.xjsd.ai.assistant.core.api.cache.CacheAbility) r3
            java.lang.Object r4 = r12.L$0
            android.content.Context r4 = (android.content.Context) r4
            kotlin.ResultKt.throwOnFailure(r13)
            r5 = r4
            goto L_0x00fb
        L_0x0080:
            boolean r1 = r12.Z$0
            java.lang.Object r2 = r12.L$1
            com.xjsd.ai.assistant.core.api.cache.CacheAbility r2 = (com.xjsd.ai.assistant.core.api.cache.CacheAbility) r2
            java.lang.Object r3 = r12.L$0
            android.content.Context r3 = (android.content.Context) r3
            kotlin.ResultKt.throwOnFailure(r13)
            r10 = r2
            r2 = r1
            r1 = r10
            goto L_0x00dd
        L_0x0091:
            java.lang.Object r1 = r12.L$1
            com.xjsd.ai.assistant.core.api.cache.CacheAbility r1 = (com.xjsd.ai.assistant.core.api.cache.CacheAbility) r1
            java.lang.Object r2 = r12.L$0
            android.content.Context r2 = (android.content.Context) r2
            kotlin.ResultKt.throwOnFailure(r13)
            r3 = r2
            goto L_0x00c2
        L_0x009e:
            kotlin.ResultKt.throwOnFailure(r13)
            com.xjsd.ai.assistant.core.AbilityManager r13 = com.xjsd.ai.assistant.core.AbilityManager.b
            java.lang.Class<com.xjsd.ai.assistant.core.api.cache.CacheAbility> r1 = com.xjsd.ai.assistant.core.api.cache.CacheAbility.class
            com.xjsd.ai.assistant.core.Ability r13 = r13.b(r1)
            r1 = r13
            com.xjsd.ai.assistant.core.api.cache.CacheAbility r1 = (com.xjsd.ai.assistant.core.api.cache.CacheAbility) r1
            if (r1 == 0) goto L_0x01cd
            android.content.Context r13 = r12.$context
            com.xjsd.ai.assistant.common.data.DataStoreUtils r2 = com.xjsd.ai.assistant.common.data.DataStoreUtils.f8415a
            r12.L$0 = r13
            r12.L$1 = r1
            r3 = 1
            r12.label = r3
            java.lang.Object r2 = r2.j(r13, r12)
            if (r2 != r0) goto L_0x00c0
            return r0
        L_0x00c0:
            r3 = r13
            r13 = r2
        L_0x00c2:
            java.lang.Boolean r13 = (java.lang.Boolean) r13
            boolean r13 = r13.booleanValue()
            com.xjsd.ai.assistant.common.data.DataStoreUtils r2 = com.xjsd.ai.assistant.common.data.DataStoreUtils.f8415a
            r12.L$0 = r3
            r12.L$1 = r1
            r12.Z$0 = r13
            r4 = 2
            r12.label = r4
            java.lang.Object r2 = r2.n(r3, r12)
            if (r2 != r0) goto L_0x00da
            return r0
        L_0x00da:
            r10 = r2
            r2 = r13
            r13 = r10
        L_0x00dd:
            java.lang.Boolean r13 = (java.lang.Boolean) r13
            boolean r13 = r13.booleanValue()
            com.xjsd.ai.assistant.common.data.DataStoreUtils r4 = com.xjsd.ai.assistant.common.data.DataStoreUtils.f8415a
            r12.L$0 = r3
            r12.L$1 = r1
            r12.Z$0 = r2
            r12.Z$1 = r13
            r5 = 3
            r12.label = r5
            java.lang.Object r4 = r4.o(r3, r12)
            if (r4 != r0) goto L_0x00f7
            return r0
        L_0x00f7:
            r5 = r3
            r3 = r1
            r1 = r13
            r13 = r4
        L_0x00fb:
            java.lang.Boolean r13 = (java.lang.Boolean) r13
            boolean r13 = r13.booleanValue()
            com.xjsd.ai.assistant.common.data.DataStoreUtils r4 = com.xjsd.ai.assistant.common.data.DataStoreUtils.f8415a
            r12.L$0 = r5
            r12.L$1 = r3
            r12.Z$0 = r2
            r12.Z$1 = r1
            r12.Z$2 = r13
            r6 = 4
            r12.label = r6
            java.lang.Object r4 = r4.m(r5, r12)
            if (r4 != r0) goto L_0x0117
            return r0
        L_0x0117:
            r10 = r2
            r2 = r13
            r13 = r4
            r4 = r10
            r11 = r3
            r3 = r1
            r1 = r11
        L_0x011e:
            java.lang.Boolean r13 = (java.lang.Boolean) r13
            boolean r13 = r13.booleanValue()
            com.xjsd.ai.assistant.common.data.DataStoreUtils r6 = com.xjsd.ai.assistant.common.data.DataStoreUtils.f8415a
            r12.L$0 = r5
            r12.L$1 = r1
            r12.Z$0 = r4
            r12.Z$1 = r3
            r12.Z$2 = r2
            r12.Z$3 = r13
            r7 = 5
            r12.label = r7
            java.lang.Object r6 = r6.l(r5, r12)
            if (r6 != r0) goto L_0x013c
            return r0
        L_0x013c:
            r7 = r5
            r5 = r1
            r1 = r13
            r13 = r6
        L_0x0140:
            java.lang.Boolean r13 = (java.lang.Boolean) r13
            boolean r13 = r13.booleanValue()
            com.xjsd.ai.assistant.common.data.DataStoreUtils r6 = com.xjsd.ai.assistant.common.data.DataStoreUtils.f8415a
            r12.L$0 = r7
            r12.L$1 = r5
            r12.Z$0 = r4
            r12.Z$1 = r3
            r12.Z$2 = r2
            r12.Z$3 = r1
            r12.Z$4 = r13
            r8 = 6
            r12.label = r8
            java.lang.Object r6 = r6.k(r7, r12)
            if (r6 != r0) goto L_0x0160
            return r0
        L_0x0160:
            r10 = r1
            r1 = r13
            r13 = r6
            r6 = r4
            r4 = r3
            r3 = r2
            r2 = r10
        L_0x0167:
            java.lang.Boolean r13 = (java.lang.Boolean) r13
            boolean r13 = r13.booleanValue()
            com.xjsd.ai.assistant.common.data.DataStoreUtils r8 = com.xjsd.ai.assistant.common.data.DataStoreUtils.f8415a
            r12.L$0 = r5
            r9 = 0
            r12.L$1 = r9
            r12.Z$0 = r6
            r12.Z$1 = r4
            r12.Z$2 = r3
            r12.Z$3 = r2
            r12.Z$4 = r1
            r12.Z$5 = r13
            r9 = 7
            r12.label = r9
            java.lang.Object r12 = r8.i(r7, r12)
            if (r12 != r0) goto L_0x018a
            return r0
        L_0x018a:
            r0 = r13
            r13 = r12
            r12 = r5
            r5 = r6
        L_0x018e:
            java.lang.Number r13 = (java.lang.Number) r13
            int r13 = r13.intValue()
            java.lang.Boolean r4 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r4)
            java.lang.String r6 = "low_power_wakeup"
            r12.cache(r6, r4)
            java.lang.Boolean r3 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)
            java.lang.String r4 = "low_power_wakeup_screen_off"
            r12.cache(r4, r3)
            java.lang.Boolean r2 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r2)
            java.lang.String r3 = "continuous_dialogue"
            r12.cache(r3, r2)
            java.lang.Boolean r2 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r5)
            java.lang.String r3 = "asr_result_screen"
            r12.cache(r3, r2)
            java.lang.Boolean r1 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r1)
            java.lang.String r2 = "chat_gpt_tts_play"
            r12.cache(r2, r1)
            java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r0)
            java.lang.String r1 = "chat_gpt_card_display"
            r12.cache(r1, r0)
            com.xjsd.ai.assistant.phone.helper.AssistantSettingsHelper.k(r13)
        L_0x01cd:
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xjsd.ai.assistant.phone.helper.AssistantSettingUtils$cacheAssistantSettings$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((AssistantSettingUtils$cacheAssistantSettings$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
