package com.xjsd.ai.assistant.common.data;

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
@DebugMetadata(c = "com.xjsd.ai.assistant.common.data.DataStoreUtils$updateAssistantSettings$1", f = "DataStoreUtils.kt", i = {}, l = {249, 253, 257, 261, 265, 269}, m = "invokeSuspend", n = {}, s = {})
public final class DataStoreUtils$updateAssistantSettings$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ boolean $switchOn;
    final /* synthetic */ String $type;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DataStoreUtils$updateAssistantSettings$1(String str, Context context, boolean z, Continuation<? super DataStoreUtils$updateAssistantSettings$1> continuation) {
        super(2, continuation);
        this.$type = str;
        this.$context = context;
        this.$switchOn = z;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new DataStoreUtils$updateAssistantSettings$1(this.$type, this.$context, this.$switchOn, continuation);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r5) {
        /*
            r4 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r4.label
            switch(r1) {
                case 0: goto L_0x0016;
                case 1: goto L_0x0011;
                case 2: goto L_0x0011;
                case 3: goto L_0x0011;
                case 4: goto L_0x0011;
                case 5: goto L_0x0011;
                case 6: goto L_0x0011;
                default: goto L_0x0009;
            }
        L_0x0009:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0011:
            kotlin.ResultKt.throwOnFailure(r5)
            goto L_0x00d4
        L_0x0016:
            kotlin.ResultKt.throwOnFailure(r5)
            java.lang.String r5 = r4.$type
            int r1 = r5.hashCode()
            switch(r1) {
                case -2089748325: goto L_0x00a2;
                case -1948256433: goto L_0x0089;
                case -1536739064: goto L_0x0070;
                case -1406570633: goto L_0x0057;
                case -597320786: goto L_0x003e;
                case 1320798916: goto L_0x0024;
                default: goto L_0x0022;
            }
        L_0x0022:
            goto L_0x00aa
        L_0x0024:
            java.lang.String r1 = "low_power_wakeup"
            boolean r5 = r5.equals(r1)
            if (r5 != 0) goto L_0x002e
            goto L_0x00aa
        L_0x002e:
            com.xjsd.ai.assistant.common.data.DataStoreUtils r5 = com.xjsd.ai.assistant.common.data.DataStoreUtils.f8415a
            android.content.Context r1 = r4.$context
            boolean r2 = r4.$switchOn
            r3 = 1
            r4.label = r3
            java.lang.Object r4 = r5.u(r1, r2, r4)
            if (r4 != r0) goto L_0x00d4
            return r0
        L_0x003e:
            java.lang.String r1 = "chat_gpt_card_display"
            boolean r5 = r5.equals(r1)
            if (r5 != 0) goto L_0x0047
            goto L_0x00aa
        L_0x0047:
            com.xjsd.ai.assistant.common.data.DataStoreUtils r5 = com.xjsd.ai.assistant.common.data.DataStoreUtils.f8415a
            android.content.Context r1 = r4.$context
            boolean r2 = r4.$switchOn
            r3 = 6
            r4.label = r3
            java.lang.Object r4 = r5.r(r1, r2, r4)
            if (r4 != r0) goto L_0x00d4
            return r0
        L_0x0057:
            java.lang.String r1 = "low_power_wakeup_screen_off"
            boolean r5 = r5.equals(r1)
            if (r5 != 0) goto L_0x0060
            goto L_0x00aa
        L_0x0060:
            com.xjsd.ai.assistant.common.data.DataStoreUtils r5 = com.xjsd.ai.assistant.common.data.DataStoreUtils.f8415a
            android.content.Context r1 = r4.$context
            boolean r2 = r4.$switchOn
            r3 = 2
            r4.label = r3
            java.lang.Object r4 = r5.v(r1, r2, r4)
            if (r4 != r0) goto L_0x00d4
            return r0
        L_0x0070:
            java.lang.String r1 = "continuous_dialogue"
            boolean r5 = r5.equals(r1)
            if (r5 != 0) goto L_0x0079
            goto L_0x00aa
        L_0x0079:
            com.xjsd.ai.assistant.common.data.DataStoreUtils r5 = com.xjsd.ai.assistant.common.data.DataStoreUtils.f8415a
            android.content.Context r1 = r4.$context
            boolean r2 = r4.$switchOn
            r3 = 3
            r4.label = r3
            java.lang.Object r4 = r5.t(r1, r2, r4)
            if (r4 != r0) goto L_0x00d4
            return r0
        L_0x0089:
            java.lang.String r1 = "asr_result_screen"
            boolean r5 = r5.equals(r1)
            if (r5 != 0) goto L_0x0092
            goto L_0x00aa
        L_0x0092:
            com.xjsd.ai.assistant.common.data.DataStoreUtils r5 = com.xjsd.ai.assistant.common.data.DataStoreUtils.f8415a
            android.content.Context r1 = r4.$context
            boolean r2 = r4.$switchOn
            r3 = 4
            r4.label = r3
            java.lang.Object r4 = r5.q(r1, r2, r4)
            if (r4 != r0) goto L_0x00d4
            return r0
        L_0x00a2:
            java.lang.String r1 = "chat_gpt_tts_play"
            boolean r5 = r5.equals(r1)
            if (r5 != 0) goto L_0x00c4
        L_0x00aa:
            java.lang.String r4 = r4.$type
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r0 = "updateAssistantSettings: 不支持该设置项->"
            r5.append(r0)
            r5.append(r4)
            java.lang.String r4 = r5.toString()
            java.lang.String r5 = "DataStoreUtils"
            com.xjsd.ai.assistant.log.ILog.a(r5, r4)
            goto L_0x00d4
        L_0x00c4:
            com.xjsd.ai.assistant.common.data.DataStoreUtils r5 = com.xjsd.ai.assistant.common.data.DataStoreUtils.f8415a
            android.content.Context r1 = r4.$context
            boolean r2 = r4.$switchOn
            r3 = 5
            r4.label = r3
            java.lang.Object r4 = r5.s(r1, r2, r4)
            if (r4 != r0) goto L_0x00d4
            return r0
        L_0x00d4:
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xjsd.ai.assistant.common.data.DataStoreUtils$updateAssistantSettings$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((DataStoreUtils$updateAssistantSettings$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
