package io.ktor.utils.io;

import io.ktor.utils.io.internal.ReadSessionImpl;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lio/ktor/utils/io/LookAheadSuspendSession;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.utils.io.ByteBufferChannel$readSuspendableSession$2", f = "ByteBufferChannel.kt", i = {}, l = {1630}, m = "invokeSuspend", n = {}, s = {})
final class ByteBufferChannel$readSuspendableSession$2 extends SuspendLambda implements Function2<LookAheadSuspendSession, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<SuspendableReadSession, Continuation<? super Unit>, Object> $consumer;
    int label;
    final /* synthetic */ ByteBufferChannel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ByteBufferChannel$readSuspendableSession$2(Function2<? super SuspendableReadSession, ? super Continuation<? super Unit>, ? extends Object> function2, ByteBufferChannel byteBufferChannel, Continuation<? super ByteBufferChannel$readSuspendableSession$2> continuation) {
        super(2, continuation);
        this.$consumer = function2;
        this.this$0 = byteBufferChannel;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new ByteBufferChannel$readSuspendableSession$2(this.$consumer, this.this$0, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull LookAheadSuspendSession lookAheadSuspendSession, @Nullable Continuation<? super Unit> continuation) {
        return ((ByteBufferChannel$readSuspendableSession$2) create(lookAheadSuspendSession, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Function2<SuspendableReadSession, Continuation<? super Unit>, Object> function2 = this.$consumer;
            ReadSessionImpl W = this.this$0.g;
            this.label = 1;
            if (function2.invoke(W, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Throwable th) {
                this.this$0.g.c();
                throw th;
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.this$0.g.c();
        return Unit.INSTANCE;
    }
}
