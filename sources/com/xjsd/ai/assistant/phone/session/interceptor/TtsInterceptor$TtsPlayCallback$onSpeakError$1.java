package com.xjsd.ai.assistant.phone.session.interceptor;

import androidx.lifecycle.Lifecycle;
import com.xjsd.ai.assistant.log.ILog;
import com.xjsd.ai.assistant.phone.AudioFocusManageDelegate;
import com.xjsd.ai.assistant.phone.WakeupControlDelegate;
import com.xjsd.ai.assistant.phone.session.interceptor.TtsInterceptor;
import com.xjsd.ai.assistant.phone.session.utils.SeesionExtensionsKt;
import com.xjsd.ai.assistant.protocol.wakeup.WakeupControl;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.xjsd.ai.assistant.phone.session.interceptor.TtsInterceptor$TtsPlayCallback$onSpeakError$1", f = "TtsInterceptor.kt", i = {}, l = {135}, m = "invokeSuspend", n = {}, s = {})
public final class TtsInterceptor$TtsPlayCallback$onSpeakError$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $error;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ TtsInterceptor.TtsPlayCallback this$0;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.xjsd.ai.assistant.phone.session.interceptor.TtsInterceptor$TtsPlayCallback$onSpeakError$1$1", f = "TtsInterceptor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.xjsd.ai.assistant.phone.session.interceptor.TtsInterceptor$TtsPlayCallback$onSpeakError$1$1  reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(str, ttsPlayCallback, continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                String str = str;
                ILog.a("TtsInterceptor", "onSpeakError: " + str);
                AudioFocusManageDelegate.a(2);
                ttsPlayCallback.e(0);
                WakeupControlDelegate.g.i(new WakeupControl(0));
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
    public TtsInterceptor$TtsPlayCallback$onSpeakError$1(TtsInterceptor.TtsPlayCallback ttsPlayCallback, String str, Continuation<? super TtsInterceptor$TtsPlayCallback$onSpeakError$1> continuation) {
        super(2, continuation);
        this.this$0 = ttsPlayCallback;
        this.$error = str;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        TtsInterceptor$TtsPlayCallback$onSpeakError$1 ttsInterceptor$TtsPlayCallback$onSpeakError$1 = new TtsInterceptor$TtsPlayCallback$onSpeakError$1(this.this$0, this.$error, continuation);
        ttsInterceptor$TtsPlayCallback$onSpeakError$1.L$0 = obj;
        return ttsInterceptor$TtsPlayCallback$onSpeakError$1;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScopeKt.g((CoroutineScope) this.L$0);
            Lifecycle a2 = this.this$0.c;
            Lifecycle.State state = Lifecycle.State.RESUMED;
            final String str = this.$error;
            final TtsInterceptor.TtsPlayCallback ttsPlayCallback = this.this$0;
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
        return ((TtsInterceptor$TtsPlayCallback$onSpeakError$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
