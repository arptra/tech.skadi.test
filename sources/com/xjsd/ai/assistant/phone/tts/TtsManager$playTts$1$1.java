package com.xjsd.ai.assistant.phone.tts;

import androidx.lifecycle.Lifecycle;
import com.xjsd.ai.assistant.core.api.tts.TtsData;
import com.xjsd.ai.assistant.log.ILog;
import com.xjsd.ai.assistant.phone.session.Session;
import com.xjsd.ai.assistant.phone.session.utils.SeesionExtensionsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableSharedFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.xjsd.ai.assistant.phone.tts.TtsManager$playTts$1$1", f = "TtsManager.kt", i = {}, l = {29}, m = "invokeSuspend", n = {}, s = {})
public final class TtsManager$playTts$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ TtsData $data;
    final /* synthetic */ Session $this_apply;
    int label;
    final /* synthetic */ TtsManager this$0;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.xjsd.ai.assistant.phone.tts.TtsManager$playTts$1$1$1", f = "TtsManager.kt", i = {}, l = {31}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.xjsd.ai.assistant.phone.tts.TtsManager$playTts$1$1$1  reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(ttsManager, ttsData, continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                ILog.a("TtsManager", "start emit tts");
                MutableSharedFlow b = ttsManager.f8608a;
                TtsData ttsData = ttsData;
                this.label = 1;
                if (b.emit(ttsData, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            TtsData ttsData2 = ttsData;
            ILog.a("TtsManager", "emit tts " + ttsData2);
            return Unit.INSTANCE;
        }

        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TtsManager$playTts$1$1(Session session, TtsManager ttsManager, TtsData ttsData, Continuation<? super TtsManager$playTts$1$1> continuation) {
        super(2, continuation);
        this.$this_apply = session;
        this.this$0 = ttsManager;
        this.$data = ttsData;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new TtsManager$playTts$1$1(this.$this_apply, this.this$0, this.$data, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Lifecycle lifecycle = this.$this_apply.getLifecycle();
            Lifecycle.State state = Lifecycle.State.RESUMED;
            final TtsManager ttsManager = this.this$0;
            final TtsData ttsData = this.$data;
            AnonymousClass1 r3 = new AnonymousClass1((Continuation<? super AnonymousClass1>) null);
            this.label = 1;
            if (SeesionExtensionsKt.c(lifecycle, state, r3, this) == coroutine_suspended) {
                return coroutine_suspended;
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
        return ((TtsManager$playTts$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
