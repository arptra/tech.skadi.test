package com.upuphone.xr.sapp.fragment;

import android.content.Context;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.utils.DataStoreUtils;
import com.xjsd.ai.assistant.common.data.DataStoreUtils;
import com.xjsd.ai.assistant.phone.helper.AssistantSettingUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.fragment.HearingAssistFragment$resetNotification$1", f = "HearingAssistFragment.kt", i = {}, l = {526, 550}, m = "invokeSuspend", n = {}, s = {})
public final class HearingAssistFragment$resetNotification$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ HearingAssistFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HearingAssistFragment$resetNotification$1(HearingAssistFragment hearingAssistFragment, Continuation<? super HearingAssistFragment$resetNotification$1> continuation) {
        super(2, continuation);
        this.this$0 = hearingAssistFragment;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new HearingAssistFragment$resetNotification$1(this.this$0, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            DataStoreUtils dataStoreUtils = DataStoreUtils.f8415a;
            Context m0 = this.this$0.m0();
            this.label = 1;
            obj = dataStoreUtils.l(m0, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else if (i == 2) {
            ResultKt.throwOnFailure(obj);
            boolean booleanValue = ((Boolean) obj).booleanValue();
            DataStoreUtils.Companion companion = com.upuphone.xr.sapp.utils.DataStoreUtils.e;
            boolean booleanValue2 = ((Boolean) com.upuphone.xr.sapp.utils.DataStoreUtils.j(companion.a(), "hearing_assist_gpt_card_status", Boxing.boxBoolean(booleanValue), true, (Context) null, 8, (Object) null)).booleanValue();
            ULog.Delegate delegate = ULog.f6446a;
            delegate.o("HearingAssistFragment", "resetNotification  isChatGptCardDisplay=" + booleanValue + " gptTextPlayStatus=" + booleanValue2);
            AssistantSettingUtils.b.c(this.this$0.m0(), "chat_gpt_card_display", booleanValue2);
            companion.a().p("hearing_assist_gpt_card_status_change", Boxing.boxBoolean(true), true);
            return Unit.INSTANCE;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        boolean booleanValue3 = ((Boolean) obj).booleanValue();
        DataStoreUtils.Companion companion2 = com.upuphone.xr.sapp.utils.DataStoreUtils.e;
        boolean booleanValue4 = ((Boolean) com.upuphone.xr.sapp.utils.DataStoreUtils.j(companion2.a(), "hearing_assist_gpt_tts_status", Boxing.boxBoolean(booleanValue3), true, (Context) null, 8, (Object) null)).booleanValue();
        ULog.Delegate delegate2 = ULog.f6446a;
        delegate2.o("HearingAssistFragment", "resetNotification  isChatGptTTSPlay=" + booleanValue3 + " gptTTSPlayStatus=" + booleanValue4);
        AssistantSettingUtils.b.c(this.this$0.m0(), "chat_gpt_tts_play", booleanValue4);
        companion2.a().p("hearing_assist_gpt_tts_status_change", Boxing.boxBoolean(true), true);
        com.xjsd.ai.assistant.common.data.DataStoreUtils dataStoreUtils2 = com.xjsd.ai.assistant.common.data.DataStoreUtils.f8415a;
        Context m02 = this.this$0.m0();
        this.label = 2;
        obj = dataStoreUtils2.k(m02, this);
        if (obj == coroutine_suspended) {
            return coroutine_suspended;
        }
        boolean booleanValue5 = ((Boolean) obj).booleanValue();
        DataStoreUtils.Companion companion3 = com.upuphone.xr.sapp.utils.DataStoreUtils.e;
        boolean booleanValue22 = ((Boolean) com.upuphone.xr.sapp.utils.DataStoreUtils.j(companion3.a(), "hearing_assist_gpt_card_status", Boxing.boxBoolean(booleanValue5), true, (Context) null, 8, (Object) null)).booleanValue();
        ULog.Delegate delegate3 = ULog.f6446a;
        delegate3.o("HearingAssistFragment", "resetNotification  isChatGptCardDisplay=" + booleanValue5 + " gptTextPlayStatus=" + booleanValue22);
        AssistantSettingUtils.b.c(this.this$0.m0(), "chat_gpt_card_display", booleanValue22);
        companion3.a().p("hearing_assist_gpt_card_status_change", Boxing.boxBoolean(true), true);
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((HearingAssistFragment$resetNotification$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
