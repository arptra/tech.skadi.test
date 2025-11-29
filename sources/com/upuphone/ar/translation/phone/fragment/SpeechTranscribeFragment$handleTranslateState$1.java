package com.upuphone.ar.translation.phone.fragment;

import com.upuphone.ar.translation.ext.LogExt;
import com.upuphone.ar.translation.phone.TranslationManager;
import com.upuphone.ar.translation.phone.bean.TransStateEvent;
import com.upuphone.ar.translation.statemachine.machine.TranslateStateManager;
import com.upuphone.ar.translation.utils.PreferencesUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.translation.phone.fragment.SpeechTranscribeFragment$handleTranslateState$1", f = "SpeechTranscribeFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class SpeechTranscribeFragment$handleTranslateState$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ TransStateEvent $transStateEvent;
    int label;
    final /* synthetic */ SpeechTranscribeFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SpeechTranscribeFragment$handleTranslateState$1(TransStateEvent transStateEvent, SpeechTranscribeFragment speechTranscribeFragment, Continuation<? super SpeechTranscribeFragment$handleTranslateState$1> continuation) {
        super(2, continuation);
        this.$transStateEvent = transStateEvent;
        this.this$0 = speechTranscribeFragment;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new SpeechTranscribeFragment$handleTranslateState$1(this.$transStateEvent, this.this$0, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            int transState = this.$transStateEvent.getTransState().getTransState();
            int extCode = this.$transStateEvent.getTransState().getExtCode();
            TransStateEvent transStateEvent = this.$transStateEvent;
            LogExt.j("handleTranslateState " + transStateEvent, "SpeechTranscribeFragment");
            TranslationManager.Companion companion = TranslationManager.q;
            if (companion.a().z()) {
                LogExt.j("handleTranslateState stateMachine not started", "SpeechTranscribeFragment");
                return Unit.INSTANCE;
            }
            TranslateStateManager p = companion.a().p();
            if (p != null && p.g()) {
                this.this$0.c = PreferencesUtils.m();
            }
            SpeechTranscribeFragment speechTranscribeFragment = this.this$0;
            TranslateStateManager p2 = companion.a().p();
            speechTranscribeFragment.d = !(p2 != null ? p2.f(transState) : false);
            if (this.this$0.c != 1) {
                return Unit.INSTANCE;
            }
            if (extCode == -1) {
                this.this$0.K0(this.$transStateEvent.getTransState());
            } else {
                this.this$0.J0(this.$transStateEvent.getTransState());
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((SpeechTranscribeFragment$handleTranslateState$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
