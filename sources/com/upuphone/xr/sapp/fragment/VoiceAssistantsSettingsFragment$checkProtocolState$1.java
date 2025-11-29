package com.upuphone.xr.sapp.fragment;

import androidx.fragment.app.FragmentActivity;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.assistant.LlmProtocolStateDelegate;
import com.upuphone.xr.sapp.contract.ContractEntry;
import com.upuphone.xr.sapp.contract.UserGuideAuthResult;
import com.upuphone.xr.sapp.entity.AIModelResult;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.fragment.VoiceAssistantsSettingsFragment$checkProtocolState$1", f = "VoiceAssistantsSettingsFragment.kt", i = {}, l = {466}, m = "invokeSuspend", n = {}, s = {})
public final class VoiceAssistantsSettingsFragment$checkProtocolState$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ VoiceAssistantsSettingsFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VoiceAssistantsSettingsFragment$checkProtocolState$1(VoiceAssistantsSettingsFragment voiceAssistantsSettingsFragment, Continuation<? super VoiceAssistantsSettingsFragment$checkProtocolState$1> continuation) {
        super(2, continuation);
        this.this$0 = voiceAssistantsSettingsFragment;
    }

    /* access modifiers changed from: private */
    public static final void invokeSuspend$lambda$0(VoiceAssistantsSettingsFragment voiceAssistantsSettingsFragment, UserGuideAuthResult userGuideAuthResult) {
        voiceAssistantsSettingsFragment.K0("status_LLMProtocol", MapsKt.mapOf(TuplesKt.to("type", userGuideAuthResult.a() == 1 ? "1" : "0")));
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new VoiceAssistantsSettingsFragment$checkProtocolState$1(this.this$0, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            LlmProtocolStateDelegate llmProtocolStateDelegate = new LlmProtocolStateDelegate();
            this.label = 1;
            obj = llmProtocolStateDelegate.p(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        AIModelResult aIModelResult = (AIModelResult) obj;
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("VoiceAssistantsFragment", "读取大模型协议状态返回->" + aIModelResult);
        int state = aIModelResult.getState();
        if (state == -1) {
            delegate.a("VoiceAssistantsFragment", "读取大模型协议状态超时");
            this.this$0.h = false;
            this.this$0.O0(false);
        } else if (state == -2) {
            delegate.a("VoiceAssistantsFragment", "读取大模型协议状态出错");
            this.this$0.h = false;
            this.this$0.O0(true);
        } else if (state == Integer.parseInt("1")) {
            delegate.a("VoiceAssistantsFragment", "读取大模型协议状态为已授权");
            this.this$0.h = true;
        } else {
            delegate.a("VoiceAssistantsFragment", "读取大模型协议状态为未授权");
            this.this$0.h = false;
            ContractEntry contractEntry = ContractEntry.f6691a;
            FragmentActivity requireActivity = this.this$0.requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
            contractEntry.x(requireActivity, 1, new f(this.this$0));
        }
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((VoiceAssistantsSettingsFragment$checkProtocolState$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
