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

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.xjsd.ai.assistant.phone.helper.AssistantSettingUtils$isSettingOn$1", f = "AssistantSettingUtils.kt", i = {}, l = {53, 57, 61, 65, 69, 73}, m = "invokeSuspend", n = {}, s = {})
public final class AssistantSettingUtils$isSettingOn$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ String $mark;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AssistantSettingUtils$isSettingOn$1(String str, Context context, Continuation<? super AssistantSettingUtils$isSettingOn$1> continuation) {
        super(2, continuation);
        this.$mark = str;
        this.$context = context;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new AssistantSettingUtils$isSettingOn$1(this.$mark, this.$context, continuation);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0052, code lost:
        r3 = ((java.lang.Boolean) r4).booleanValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0072, code lost:
        r3 = ((java.lang.Boolean) r4).booleanValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0091, code lost:
        r3 = ((java.lang.Boolean) r4).booleanValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00af, code lost:
        r3 = ((java.lang.Boolean) r4).booleanValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00cd, code lost:
        r3 = ((java.lang.Boolean) r4).booleanValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00dc, code lost:
        r3 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00ec, code lost:
        r3 = ((java.lang.Boolean) r4).booleanValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00f6, code lost:
        return kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3);
     */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r4) {
        /*
            r3 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r3.label
            switch(r1) {
                case 0: goto L_0x002c;
                case 1: goto L_0x0028;
                case 2: goto L_0x0024;
                case 3: goto L_0x001f;
                case 4: goto L_0x001a;
                case 5: goto L_0x0015;
                case 6: goto L_0x0011;
                default: goto L_0x0009;
            }
        L_0x0009:
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
            java.lang.String r4 = "call to 'resume' before 'invoke' with coroutine"
            r3.<init>(r4)
            throw r3
        L_0x0011:
            kotlin.ResultKt.throwOnFailure(r4)
            goto L_0x0072
        L_0x0015:
            kotlin.ResultKt.throwOnFailure(r4)
            goto L_0x00ec
        L_0x001a:
            kotlin.ResultKt.throwOnFailure(r4)
            goto L_0x00cd
        L_0x001f:
            kotlin.ResultKt.throwOnFailure(r4)
            goto L_0x00af
        L_0x0024:
            kotlin.ResultKt.throwOnFailure(r4)
            goto L_0x0091
        L_0x0028:
            kotlin.ResultKt.throwOnFailure(r4)
            goto L_0x0052
        L_0x002c:
            kotlin.ResultKt.throwOnFailure(r4)
            java.lang.String r4 = r3.$mark
            int r1 = r4.hashCode()
            switch(r1) {
                case -2089748325: goto L_0x00d4;
                case -1948256433: goto L_0x00b6;
                case -1536739064: goto L_0x0098;
                case -1406570633: goto L_0x007a;
                case -597320786: goto L_0x005a;
                case 1320798916: goto L_0x003a;
                default: goto L_0x0038;
            }
        L_0x0038:
            goto L_0x00dc
        L_0x003a:
            java.lang.String r1 = "low_power_wakeup"
            boolean r4 = r4.equals(r1)
            if (r4 != 0) goto L_0x0044
            goto L_0x00dc
        L_0x0044:
            com.xjsd.ai.assistant.common.data.DataStoreUtils r4 = com.xjsd.ai.assistant.common.data.DataStoreUtils.f8415a
            android.content.Context r1 = r3.$context
            r2 = 1
            r3.label = r2
            java.lang.Object r4 = r4.n(r1, r3)
            if (r4 != r0) goto L_0x0052
            return r0
        L_0x0052:
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            boolean r3 = r4.booleanValue()
            goto L_0x00f2
        L_0x005a:
            java.lang.String r1 = "chat_gpt_card_display"
            boolean r4 = r4.equals(r1)
            if (r4 != 0) goto L_0x0064
            goto L_0x00dc
        L_0x0064:
            com.xjsd.ai.assistant.common.data.DataStoreUtils r4 = com.xjsd.ai.assistant.common.data.DataStoreUtils.f8415a
            android.content.Context r1 = r3.$context
            r2 = 6
            r3.label = r2
            java.lang.Object r4 = r4.k(r1, r3)
            if (r4 != r0) goto L_0x0072
            return r0
        L_0x0072:
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            boolean r3 = r4.booleanValue()
            goto L_0x00f2
        L_0x007a:
            java.lang.String r1 = "low_power_wakeup_screen_off"
            boolean r4 = r4.equals(r1)
            if (r4 != 0) goto L_0x0083
            goto L_0x00dc
        L_0x0083:
            com.xjsd.ai.assistant.common.data.DataStoreUtils r4 = com.xjsd.ai.assistant.common.data.DataStoreUtils.f8415a
            android.content.Context r1 = r3.$context
            r2 = 2
            r3.label = r2
            java.lang.Object r4 = r4.o(r1, r3)
            if (r4 != r0) goto L_0x0091
            return r0
        L_0x0091:
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            boolean r3 = r4.booleanValue()
            goto L_0x00f2
        L_0x0098:
            java.lang.String r1 = "continuous_dialogue"
            boolean r4 = r4.equals(r1)
            if (r4 != 0) goto L_0x00a1
            goto L_0x00dc
        L_0x00a1:
            com.xjsd.ai.assistant.common.data.DataStoreUtils r4 = com.xjsd.ai.assistant.common.data.DataStoreUtils.f8415a
            android.content.Context r1 = r3.$context
            r2 = 3
            r3.label = r2
            java.lang.Object r4 = r4.m(r1, r3)
            if (r4 != r0) goto L_0x00af
            return r0
        L_0x00af:
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            boolean r3 = r4.booleanValue()
            goto L_0x00f2
        L_0x00b6:
            java.lang.String r1 = "asr_result_screen"
            boolean r4 = r4.equals(r1)
            if (r4 != 0) goto L_0x00bf
            goto L_0x00dc
        L_0x00bf:
            com.xjsd.ai.assistant.common.data.DataStoreUtils r4 = com.xjsd.ai.assistant.common.data.DataStoreUtils.f8415a
            android.content.Context r1 = r3.$context
            r2 = 4
            r3.label = r2
            java.lang.Object r4 = r4.j(r1, r3)
            if (r4 != r0) goto L_0x00cd
            return r0
        L_0x00cd:
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            boolean r3 = r4.booleanValue()
            goto L_0x00f2
        L_0x00d4:
            java.lang.String r1 = "chat_gpt_tts_play"
            boolean r4 = r4.equals(r1)
            if (r4 != 0) goto L_0x00de
        L_0x00dc:
            r3 = 0
            goto L_0x00f2
        L_0x00de:
            com.xjsd.ai.assistant.common.data.DataStoreUtils r4 = com.xjsd.ai.assistant.common.data.DataStoreUtils.f8415a
            android.content.Context r1 = r3.$context
            r2 = 5
            r3.label = r2
            java.lang.Object r4 = r4.l(r1, r3)
            if (r4 != r0) goto L_0x00ec
            return r0
        L_0x00ec:
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            boolean r3 = r4.booleanValue()
        L_0x00f2:
            java.lang.Boolean r3 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xjsd.ai.assistant.phone.helper.AssistantSettingUtils$isSettingOn$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Boolean> continuation) {
        return ((AssistantSettingUtils$isSettingOn$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
