package io.ktor.websocket;

import io.ktor.util.cio.ChannelIOException;
import io.ktor.utils.io.pool.ObjectPool;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.channels.SendChannel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.websocket.WebSocketReader$readerJob$1", f = "WebSocketReader.kt", i = {0}, l = {40}, m = "invokeSuspend", n = {"buffer"}, s = {"L$0"})
final class WebSocketReader$readerJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ObjectPool<ByteBuffer> $pool;
    Object L$0;
    int label;
    final /* synthetic */ WebSocketReader this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WebSocketReader$readerJob$1(ObjectPool<ByteBuffer> objectPool, WebSocketReader webSocketReader, Continuation<? super WebSocketReader$readerJob$1> continuation) {
        super(2, continuation);
        this.$pool = objectPool;
        this.this$0 = webSocketReader;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new WebSocketReader$readerJob$1(this.$pool, this.this$0, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        ByteBuffer byteBuffer;
        FrameTooBigException e;
        ProtocolViolationException e2;
        Throwable th;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            ByteBuffer byteBuffer2 = (ByteBuffer) this.$pool.h0();
            try {
                WebSocketReader webSocketReader = this.this$0;
                this.L$0 = byteBuffer2;
                this.label = 1;
                if (webSocketReader.h(byteBuffer2, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } catch (ClosedChannelException | CancellationException unused) {
            } catch (ChannelIOException unused2) {
                byteBuffer = byteBuffer2;
                ReceiveChannel.DefaultImpls.a(this.this$0.g, (CancellationException) null, 1, (Object) null);
                this.$pool.recycle(byteBuffer);
                SendChannel.DefaultImpls.a(this.this$0.g, (Throwable) null, 1, (Object) null);
                return Unit.INSTANCE;
            } catch (FrameTooBigException e3) {
                FrameTooBigException frameTooBigException = e3;
                byteBuffer = byteBuffer2;
                e = frameTooBigException;
                this.this$0.g.h(e);
                this.$pool.recycle(byteBuffer);
                SendChannel.DefaultImpls.a(this.this$0.g, (Throwable) null, 1, (Object) null);
                return Unit.INSTANCE;
            } catch (ProtocolViolationException e4) {
                ProtocolViolationException protocolViolationException = e4;
                byteBuffer = byteBuffer2;
                e2 = protocolViolationException;
                this.this$0.g.h(e2);
                this.$pool.recycle(byteBuffer);
                SendChannel.DefaultImpls.a(this.this$0.g, (Throwable) null, 1, (Object) null);
                return Unit.INSTANCE;
            } catch (Throwable th2) {
                Throwable th3 = th2;
                byteBuffer = byteBuffer2;
                th = th3;
                throw th;
            }
            byteBuffer = byteBuffer2;
        } else if (i == 1) {
            byteBuffer = (ByteBuffer) this.L$0;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (ClosedChannelException | CancellationException unused3) {
            } catch (ChannelIOException unused4) {
                ReceiveChannel.DefaultImpls.a(this.this$0.g, (CancellationException) null, 1, (Object) null);
            } catch (FrameTooBigException e5) {
                e = e5;
                this.this$0.g.h(e);
            } catch (ProtocolViolationException e6) {
                e2 = e6;
                this.this$0.g.h(e2);
            } catch (Throwable th4) {
                th = th4;
                try {
                    throw th;
                } catch (Throwable th5) {
                    this.$pool.recycle(byteBuffer);
                    SendChannel.DefaultImpls.a(this.this$0.g, (Throwable) null, 1, (Object) null);
                    throw th5;
                }
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.$pool.recycle(byteBuffer);
        SendChannel.DefaultImpls.a(this.this$0.g, (Throwable) null, 1, (Object) null);
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((WebSocketReader$readerJob$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
