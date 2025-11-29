package com.xjmz.myvu.flutter.pigeon.impl;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.xjmz.myvu.flutter.pigeon.impl.FragmentAppApiHandler$openNamedPage$1", f = "FragmentAppApiHandler.kt", i = {}, l = {92}, m = "invokeSuspend", n = {}, s = {})
public final class FragmentAppApiHandler$openNamedPage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $name;
    int label;
    final /* synthetic */ FragmentAppApiHandler this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FragmentAppApiHandler$openNamedPage$1(FragmentAppApiHandler fragmentAppApiHandler, String str, Continuation<? super FragmentAppApiHandler$openNamedPage$1> continuation) {
        super(2, continuation);
        this.this$0 = fragmentAppApiHandler;
        this.$name = str;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new FragmentAppApiHandler$openNamedPage$1(this.this$0, this.$name, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineDispatcher b = Dispatchers.b();
            FragmentAppApiHandler$openNamedPage$1$openResult$1 fragmentAppApiHandler$openNamedPage$1$openResult$1 = new FragmentAppApiHandler$openNamedPage$1$openResult$1((Continuation<? super FragmentAppApiHandler$openNamedPage$1$openResult$1>) null);
            this.label = 1;
            obj = BuildersKt.g(b, fragmentAppApiHandler$openNamedPage$1$openResult$1, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        if (((Boolean) obj).booleanValue()) {
            this.this$0.w(this.$name);
        }
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((FragmentAppApiHandler$openNamedPage$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
