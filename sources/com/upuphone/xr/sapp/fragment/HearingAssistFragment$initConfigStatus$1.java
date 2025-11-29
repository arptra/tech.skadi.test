package com.upuphone.xr.sapp.fragment;

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
@DebugMetadata(c = "com.upuphone.xr.sapp.fragment.HearingAssistFragment$initConfigStatus$1", f = "HearingAssistFragment.kt", i = {}, l = {161, 182}, m = "invokeSuspend", n = {}, s = {})
public final class HearingAssistFragment$initConfigStatus$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ HearingAssistFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HearingAssistFragment$initConfigStatus$1(HearingAssistFragment hearingAssistFragment, Continuation<? super HearingAssistFragment$initConfigStatus$1> continuation) {
        super(2, continuation);
        this.this$0 = hearingAssistFragment;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new HearingAssistFragment$initConfigStatus$1(this.this$0, continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x00be  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r14) {
        /*
            r13 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r13.label
            r2 = 0
            java.lang.String r3 = "HearingAssistFragment"
            r4 = 2
            r5 = 1
            if (r1 == 0) goto L_0x0022
            if (r1 == r5) goto L_0x001e
            if (r1 != r4) goto L_0x0016
            kotlin.ResultKt.throwOnFailure(r14)
            goto L_0x00cf
        L_0x0016:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r14)
            throw r13
        L_0x001e:
            kotlin.ResultKt.throwOnFailure(r14)
            goto L_0x0069
        L_0x0022:
            kotlin.ResultKt.throwOnFailure(r14)
            com.upuphone.xr.sapp.utils.DataStoreUtils$Companion r14 = com.upuphone.xr.sapp.utils.DataStoreUtils.e
            com.upuphone.xr.sapp.utils.DataStoreUtils r6 = r14.a()
            java.lang.Boolean r8 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r5)
            r11 = 8
            r12 = 0
            java.lang.String r7 = "hearing_assist_gpt_tts_status_change"
            r9 = 1
            r10 = 0
            java.lang.Object r14 = com.upuphone.xr.sapp.utils.DataStoreUtils.j(r6, r7, r8, r9, r10, r11, r12)
            java.lang.Boolean r14 = (java.lang.Boolean) r14
            boolean r14 = r14.booleanValue()
            com.upuphone.star.core.log.ULog$Delegate r1 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "initConfigStatus &&&&&&&&&&&&& gptTTSPlayChange="
            r6.append(r7)
            r6.append(r14)
            java.lang.String r6 = r6.toString()
            r1.c(r3, r6)
            if (r14 == 0) goto L_0x008b
            com.xjsd.ai.assistant.common.data.DataStoreUtils r14 = com.xjsd.ai.assistant.common.data.DataStoreUtils.f8415a
            com.upuphone.xr.sapp.fragment.HearingAssistFragment r1 = r13.this$0
            android.content.Context r1 = r1.m0()
            r13.label = r5
            java.lang.Object r14 = r14.l(r1, r13)
            if (r14 != r0) goto L_0x0069
            return r0
        L_0x0069:
            java.lang.Boolean r14 = (java.lang.Boolean) r14
            boolean r14 = r14.booleanValue()
            com.upuphone.xr.sapp.utils.DataStoreUtils$Companion r1 = com.upuphone.xr.sapp.utils.DataStoreUtils.e
            com.upuphone.xr.sapp.utils.DataStoreUtils r6 = r1.a()
            java.lang.Boolean r14 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r14)
            java.lang.String r7 = "hearing_assist_gpt_tts_status"
            r6.p(r7, r14, r5)
            com.upuphone.xr.sapp.utils.DataStoreUtils r14 = r1.a()
            java.lang.String r1 = "hearing_assist_gpt_tts_status_change"
            java.lang.Boolean r6 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r2)
            r14.p(r1, r6, r5)
        L_0x008b:
            com.upuphone.xr.sapp.utils.DataStoreUtils$Companion r14 = com.upuphone.xr.sapp.utils.DataStoreUtils.e
            com.upuphone.xr.sapp.utils.DataStoreUtils r6 = r14.a()
            java.lang.Boolean r8 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r5)
            r11 = 8
            r12 = 0
            java.lang.String r7 = "hearing_assist_gpt_card_status_change"
            r9 = 1
            r10 = 0
            java.lang.Object r14 = com.upuphone.xr.sapp.utils.DataStoreUtils.j(r6, r7, r8, r9, r10, r11, r12)
            java.lang.Boolean r14 = (java.lang.Boolean) r14
            boolean r14 = r14.booleanValue()
            com.upuphone.star.core.log.ULog$Delegate r1 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "initConfigStatus ########### gptTextPlayChange="
            r6.append(r7)
            r6.append(r14)
            java.lang.String r6 = r6.toString()
            r1.c(r3, r6)
            if (r14 == 0) goto L_0x00f1
            com.xjsd.ai.assistant.common.data.DataStoreUtils r14 = com.xjsd.ai.assistant.common.data.DataStoreUtils.f8415a
            com.upuphone.xr.sapp.fragment.HearingAssistFragment r1 = r13.this$0
            android.content.Context r1 = r1.m0()
            r13.label = r4
            java.lang.Object r14 = r14.k(r1, r13)
            if (r14 != r0) goto L_0x00cf
            return r0
        L_0x00cf:
            java.lang.Boolean r14 = (java.lang.Boolean) r14
            boolean r13 = r14.booleanValue()
            com.upuphone.xr.sapp.utils.DataStoreUtils$Companion r14 = com.upuphone.xr.sapp.utils.DataStoreUtils.e
            com.upuphone.xr.sapp.utils.DataStoreUtils r0 = r14.a()
            java.lang.Boolean r13 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r13)
            java.lang.String r1 = "hearing_assist_gpt_card_status"
            r0.p(r1, r13, r5)
            com.upuphone.xr.sapp.utils.DataStoreUtils r13 = r14.a()
            java.lang.String r14 = "hearing_assist_gpt_card_status_change"
            java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r2)
            r13.p(r14, r0, r5)
        L_0x00f1:
            kotlin.Unit r13 = kotlin.Unit.INSTANCE
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.fragment.HearingAssistFragment$initConfigStatus$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((HearingAssistFragment$initConfigStatus$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
