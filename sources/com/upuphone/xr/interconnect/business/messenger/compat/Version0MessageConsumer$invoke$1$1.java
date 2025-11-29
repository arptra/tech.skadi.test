package com.upuphone.xr.interconnect.business.messenger.compat;

import com.upuphone.xr.interconnect.InterconnectManager;
import com.upuphone.xr.interconnect.entity.StarryNetMessage;
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
@DebugMetadata(c = "com.upuphone.xr.interconnect.business.messenger.compat.Version0MessageConsumer$invoke$1$1", f = "Version0MessageConsumer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class Version0MessageConsumer$invoke$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ StarryNetMessage $this_apply;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Version0MessageConsumer$invoke$1$1(StarryNetMessage starryNetMessage, Continuation<? super Version0MessageConsumer$invoke$1$1> continuation) {
        super(2, continuation);
        this.$this_apply = starryNetMessage;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new Version0MessageConsumer$invoke$1$1(this.$this_apply, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            InterconnectManager.getInstance().getMainDispatcher().dispatch(this.$this_apply);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((Version0MessageConsumer$invoke$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
