package com.xjsd.ai.assistant.phone.vui.llm;

import android.os.Message;
import com.upuphone.xr.interconnect.common.IPermissonResult;
import com.xjsd.ai.assistant.connect.InterconnectAbility;
import com.xjsd.ai.assistant.core.AbilityManager;
import com.xjsd.ai.assistant.phone.VuiHandleDelegate;
import com.xjsd.ai.assistant.phone.helper.AssistantProtocolHelper;
import com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder;
import com.xjsd.ai.assistant.protocol.VuiModel;
import com.xjsd.ai.assistant.template.TtsGlobalTemplate;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.xjsd.ai.assistant.phone.vui.llm.LlmAnswerSynchronizer$handler$2$1$handleMessage$1", f = "LlmAnswerSynchronizer.kt", i = {0}, l = {43}, m = "invokeSuspend", n = {"vuiModel"}, s = {"L$0"})
public final class LlmAnswerSynchronizer$handler$2$1$handleMessage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Message $msg;
    Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LlmAnswerSynchronizer$handler$2$1$handleMessage$1(Message message, Continuation<? super LlmAnswerSynchronizer$handler$2$1$handleMessage$1> continuation) {
        super(2, continuation);
        this.$msg = message;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new LlmAnswerSynchronizer$handler$2$1$handleMessage$1(this.$msg, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        VuiModel vuiModel;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Object obj2 = this.$msg.obj;
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type com.xjsd.ai.assistant.protocol.VuiModel");
            VuiModel vuiModel2 = (VuiModel) obj2;
            this.L$0 = vuiModel2;
            this.label = 1;
            Object e = AssistantProtocolHelper.e(this);
            if (e == coroutine_suspended) {
                return coroutine_suspended;
            }
            VuiModel vuiModel3 = vuiModel2;
            obj = e;
            vuiModel = vuiModel3;
        } else if (i == 1) {
            vuiModel = (VuiModel) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Boolean bool = (Boolean) obj;
        LlmAnswerSynchronizer llmAnswerSynchronizer = LlmAnswerSynchronizer.f8634a;
        String sessionId = vuiModel.getSessionId();
        Intrinsics.checkNotNullExpressionValue(sessionId, "getSessionId(...)");
        LlmAnswerSynchronizer.b = sessionId;
        LlmAnswerSynchronizer.c = bool != null && Intrinsics.areEqual((Object) bool, (Object) Boxing.boxBoolean(true));
        if (LlmAnswerSynchronizer.c) {
            VuiHandleDelegate.f8537a.c(vuiModel);
            return Unit.INSTANCE;
        }
        new PhoneTtsPlayBuilder().e(TtsGlobalTemplate.GLOBAL01_P24).g(1).a().c();
        InterconnectAbility interconnectAbility = (InterconnectAbility) AbilityManager.b.b(InterconnectAbility.class);
        if (interconnectAbility == null) {
            return null;
        }
        interconnectAbility.getOperatorManager().getSappAbilityOperator().requestPermission(CollectionsKt.listOf("permission_ai_model"), (IPermissonResult) null);
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((LlmAnswerSynchronizer$handler$2$1$handleMessage$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
