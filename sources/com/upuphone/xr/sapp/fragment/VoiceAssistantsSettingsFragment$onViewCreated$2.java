package com.upuphone.xr.sapp.fragment;

import android.content.Context;
import com.xjsd.ai.assistant.common.data.DataStoreUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.fragment.VoiceAssistantsSettingsFragment$onViewCreated$2", f = "VoiceAssistantsSettingsFragment.kt", i = {}, l = {114}, m = "invokeSuspend", n = {}, s = {})
public final class VoiceAssistantsSettingsFragment$onViewCreated$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ VoiceAssistantsSettingsFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VoiceAssistantsSettingsFragment$onViewCreated$2(VoiceAssistantsSettingsFragment voiceAssistantsSettingsFragment, Continuation<? super VoiceAssistantsSettingsFragment$onViewCreated$2> continuation) {
        super(2, continuation);
        this.this$0 = voiceAssistantsSettingsFragment;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new VoiceAssistantsSettingsFragment$onViewCreated$2(this.this$0, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Context context = this.this$0.getContext();
            if (context != null) {
                VoiceAssistantsSettingsFragment voiceAssistantsSettingsFragment = this.this$0;
                Flow data = DataStoreUtils.f8415a.h(context).getData();
                VoiceAssistantsSettingsFragment$onViewCreated$2$1$1 voiceAssistantsSettingsFragment$onViewCreated$2$1$1 = new VoiceAssistantsSettingsFragment$onViewCreated$2$1$1(voiceAssistantsSettingsFragment);
                this.label = 1;
                if (data.collect(voiceAssistantsSettingsFragment$onViewCreated$2$1$1, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((VoiceAssistantsSettingsFragment$onViewCreated$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
