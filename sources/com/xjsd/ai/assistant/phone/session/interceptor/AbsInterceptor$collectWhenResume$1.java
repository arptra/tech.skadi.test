package com.xjsd.ai.assistant.phone.session.interceptor;

import androidx.lifecycle.Lifecycle;
import com.xjsd.ai.assistant.phone.session.utils.SeesionExtensionsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H@"}, d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.xjsd.ai.assistant.phone.session.interceptor.AbsInterceptor$collectWhenResume$1", f = "AbsInterceptor.kt", i = {}, l = {62}, m = "invokeSuspend", n = {}, s = {})
public final class AbsInterceptor$collectWhenResume$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function3<CoroutineScope, Object, Continuation<? super Unit>, Object> $block;
    final /* synthetic */ Flow<Object> $this_collectWhenResume;
    int label;
    final /* synthetic */ AbsInterceptor this$0;

    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H@"}, d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.xjsd.ai.assistant.phone.session.interceptor.AbsInterceptor$collectWhenResume$1$1", f = "AbsInterceptor.kt", i = {}, l = {63}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.xjsd.ai.assistant.phone.session.interceptor.AbsInterceptor$collectWhenResume$1$1  reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            AnonymousClass1 r0 = new AnonymousClass1(flow, function3, continuation);
            r0.L$0 = obj;
            return r0;
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                final CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                Flow<Object> flow = flow;
                final Function3<CoroutineScope, Object, Continuation<? super Unit>, Object> function3 = function3;
                AnonymousClass1 r3 = new FlowCollector() {
                    public final Object emit(Object obj, Continuation continuation) {
                        Object invoke = function3.invoke(coroutineScope, obj, continuation);
                        return invoke == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? invoke : Unit.INSTANCE;
                    }
                };
                this.label = 1;
                if (flow.collect(r3, this) == coroutine_suspended) {
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
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AbsInterceptor$collectWhenResume$1(AbsInterceptor absInterceptor, Flow<Object> flow, Function3<? super CoroutineScope, Object, ? super Continuation<? super Unit>, ? extends Object> function3, Continuation<? super AbsInterceptor$collectWhenResume$1> continuation) {
        super(2, continuation);
        this.this$0 = absInterceptor;
        this.$this_collectWhenResume = flow;
        this.$block = function3;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new AbsInterceptor$collectWhenResume$1(this.this$0, this.$this_collectWhenResume, this.$block, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Lifecycle c = this.this$0.c();
            Lifecycle.State state = Lifecycle.State.RESUMED;
            final Flow<Object> flow = this.$this_collectWhenResume;
            final Function3<CoroutineScope, Object, Continuation<? super Unit>, Object> function3 = this.$block;
            AnonymousClass1 r3 = new AnonymousClass1((Continuation<? super AnonymousClass1>) null);
            this.label = 1;
            if (SeesionExtensionsKt.b(c, state, r3, this) == coroutine_suspended) {
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
        return ((AbsInterceptor$collectWhenResume$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
