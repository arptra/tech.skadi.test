package com.xjsd.ai.assistant.phone.session.interceptor;

import androidx.lifecycle.Lifecycle;
import com.xjsd.ai.assistant.phone.session.interceptor.TtsInterceptor2;
import com.xjsd.ai.assistant.phone.session.utils.SeesionExtensionsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.xjsd.ai.assistant.phone.session.interceptor.TtsInterceptor2$TtsPlayCallback$launchAndRun$1", f = "TtsInterceptor2.kt", i = {}, l = {146}, m = "invokeSuspend", n = {}, s = {})
public final class TtsInterceptor2$TtsPlayCallback$launchAndRun$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<Unit> $block;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ TtsInterceptor2.TtsPlayCallback this$0;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.xjsd.ai.assistant.phone.session.interceptor.TtsInterceptor2$TtsPlayCallback$launchAndRun$1$1", f = "TtsInterceptor2.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.xjsd.ai.assistant.phone.session.interceptor.TtsInterceptor2$TtsPlayCallback$launchAndRun$1$1  reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(function0, continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                function0.invoke();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TtsInterceptor2$TtsPlayCallback$launchAndRun$1(TtsInterceptor2.TtsPlayCallback ttsPlayCallback, Function0<Unit> function0, Continuation<? super TtsInterceptor2$TtsPlayCallback$launchAndRun$1> continuation) {
        super(2, continuation);
        this.this$0 = ttsPlayCallback;
        this.$block = function0;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        TtsInterceptor2$TtsPlayCallback$launchAndRun$1 ttsInterceptor2$TtsPlayCallback$launchAndRun$1 = new TtsInterceptor2$TtsPlayCallback$launchAndRun$1(this.this$0, this.$block, continuation);
        ttsInterceptor2$TtsPlayCallback$launchAndRun$1.L$0 = obj;
        return ttsInterceptor2$TtsPlayCallback$launchAndRun$1;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScopeKt.g((CoroutineScope) this.L$0);
            Lifecycle a2 = this.this$0.d;
            Lifecycle.State state = Lifecycle.State.RESUMED;
            final Function0<Unit> function0 = this.$block;
            AnonymousClass1 r3 = new AnonymousClass1((Continuation<? super AnonymousClass1>) null);
            this.label = 1;
            if (SeesionExtensionsKt.c(a2, state, r3, this) == coroutine_suspended) {
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
        return ((TtsInterceptor2$TtsPlayCallback$launchAndRun$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
