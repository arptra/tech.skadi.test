package com.xjsd.ai.assistant.phone.helper;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nAssistantSettingsHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AssistantSettingsHelper.kt\ncom/xjsd/ai/assistant/phone/helper/AssistantSettingsHelper$reloadSettingsData$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 3 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt\n+ 4 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt\n*L\n1#1,261:1\n53#2:262\n55#2:266\n50#3:263\n55#3:265\n106#4:264\n*S KotlinDebug\n*F\n+ 1 AssistantSettingsHelper.kt\ncom/xjsd/ai/assistant/phone/helper/AssistantSettingsHelper$reloadSettingsData$1\n*L\n113#1:262\n113#1:266\n113#1:263\n113#1:265\n113#1:264\n*E\n"})
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.xjsd.ai.assistant.phone.helper.AssistantSettingsHelper$reloadSettingsData$1", f = "AssistantSettingsHelper.kt", i = {0}, l = {115, 154}, m = "invokeSuspend", n = {"context"}, s = {"L$0"})
public final class AssistantSettingsHelper$reloadSettingsData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $accountId;
    Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AssistantSettingsHelper$reloadSettingsData$1(String str, Continuation<? super AssistantSettingsHelper$reloadSettingsData$1> continuation) {
        super(2, continuation);
        this.$accountId = str;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new AssistantSettingsHelper$reloadSettingsData$1(this.$accountId, continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00bf  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00c9  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00cb  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00d7  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00d9  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00e4  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00e6  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00f2  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00f4  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0100  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0111 A[RETURN] */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r11) {
        /*
            r10 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r10.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x0023
            if (r1 == r3) goto L_0x001b
            if (r1 != r2) goto L_0x0013
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x0112
        L_0x0013:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L_0x001b:
            java.lang.Object r1 = r10.L$0
            android.content.Context r1 = (android.content.Context) r1
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x0058
        L_0x0023:
            kotlin.ResultKt.throwOnFailure(r11)
            android.content.Context r1 = com.xjsd.ai.assistant.core.ContextHelper.a()
            boolean r11 = com.xjsd.ai.assistant.core.util.DeviceUtils.c()
            if (r11 == 0) goto L_0x0033
            r11 = 59
            goto L_0x0035
        L_0x0033:
            r11 = 57
        L_0x0035:
            java.lang.String r4 = r10.$accountId
            if (r4 == 0) goto L_0x005e
            androidx.datastore.preferences.core.Preferences$Key r4 = androidx.datastore.preferences.core.PreferencesKeys.d(r4)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            androidx.datastore.core.DataStore r5 = com.xjsd.ai.assistant.common.data.DataStoreUtilsKt.a(r1)
            kotlinx.coroutines.flow.Flow r5 = r5.getData()
            com.xjsd.ai.assistant.phone.helper.AssistantSettingsHelper$reloadSettingsData$1$invokeSuspend$lambda$1$$inlined$map$1 r6 = new com.xjsd.ai.assistant.phone.helper.AssistantSettingsHelper$reloadSettingsData$1$invokeSuspend$lambda$1$$inlined$map$1
            r6.<init>(r5, r4, r11)
            r10.L$0 = r1
            r10.label = r3
            java.lang.Object r11 = kotlinx.coroutines.flow.FlowKt.w(r6, r10)
            if (r11 != r0) goto L_0x0058
            return r0
        L_0x0058:
            java.lang.Number r11 = (java.lang.Number) r11
            int r11 = r11.intValue()
        L_0x005e:
            com.xjsd.ai.assistant.phone.helper.AssistantSettingsHelper.c = r11
            com.xjsd.ai.assistant.phone.helper.AssistantSettingsHelper r4 = com.xjsd.ai.assistant.phone.helper.AssistantSettingsHelper.f8560a
            int r5 = r4.i(r11)
            int r6 = r4.j(r11)
            java.lang.String r11 = java.lang.Integer.toBinaryString(r11)
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "reloadSettingsData: origin->"
            r7.append(r8)
            r7.append(r11)
            java.lang.String r11 = r7.toString()
            java.lang.String r7 = "AssistantSettingsHelper"
            com.xjsd.ai.assistant.log.ILog.a(r7, r11)
            java.lang.String r11 = java.lang.Integer.toBinaryString(r5)
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "reloadSettingsData: generic->"
            r8.append(r9)
            r8.append(r11)
            java.lang.String r11 = r8.toString()
            com.xjsd.ai.assistant.log.ILog.a(r7, r11)
            java.lang.String r11 = java.lang.Integer.toBinaryString(r6)
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "reloadSettingsData: timbre->"
            r8.append(r9)
            r8.append(r11)
            java.lang.String r11 = r8.toString()
            com.xjsd.ai.assistant.log.ILog.a(r7, r11)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            r11 = r5 & 1
            r7 = 0
            if (r11 != r3) goto L_0x00bf
            r11 = r3
            goto L_0x00c0
        L_0x00bf:
            r11 = r7
        L_0x00c0:
            java.lang.String r8 = "low_power_wakeup"
            r4.g(r1, r8, r11)
            r11 = r5 & 2
            if (r11 != r2) goto L_0x00cb
            r11 = r3
            goto L_0x00cc
        L_0x00cb:
            r11 = r7
        L_0x00cc:
            java.lang.String r8 = "low_power_wakeup_screen_off"
            r4.g(r1, r8, r11)
            r11 = r5 & 8
            r8 = 8
            if (r11 != r8) goto L_0x00d9
            r11 = r3
            goto L_0x00da
        L_0x00d9:
            r11 = r7
        L_0x00da:
            java.lang.String r8 = "asr_result_screen"
            r4.g(r1, r8, r11)
            r11 = r5 & 4
            r8 = 4
            if (r11 != r8) goto L_0x00e6
            r11 = r3
            goto L_0x00e7
        L_0x00e6:
            r11 = r7
        L_0x00e7:
            java.lang.String r8 = "continuous_dialogue"
            r4.g(r1, r8, r11)
            r11 = r5 & 16
            r8 = 16
            if (r11 != r8) goto L_0x00f4
            r11 = r3
            goto L_0x00f5
        L_0x00f4:
            r11 = r7
        L_0x00f5:
            java.lang.String r8 = "chat_gpt_tts_play"
            r4.g(r1, r8, r11)
            r11 = 32
            r5 = r5 & r11
            if (r5 != r11) goto L_0x0100
            goto L_0x0101
        L_0x0100:
            r3 = r7
        L_0x0101:
            java.lang.String r11 = "chat_gpt_card_display"
            r4.g(r1, r11, r3)
            r11 = 0
            r10.L$0 = r11
            r10.label = r2
            java.lang.Object r10 = r4.h(r1, r6, r10)
            if (r10 != r0) goto L_0x0112
            return r0
        L_0x0112:
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xjsd.ai.assistant.phone.helper.AssistantSettingsHelper$reloadSettingsData$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((AssistantSettingsHelper$reloadSettingsData$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
