package io.ktor.http.content;

import io.ktor.utils.io.ByteWriteChannel;
import io.ktor.utils.io.jvm.javaio.BlockingKt;
import java.io.Closeable;
import java.io.OutputStream;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.http.content.OutputStreamContent$writeTo$2", f = "OutputStreamContent.kt", i = {}, l = {28}, m = "invokeSuspend", n = {}, s = {})
public final class OutputStreamContent$writeTo$2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ ByteWriteChannel $channel;
    Object L$0;
    int label;
    final /* synthetic */ OutputStreamContent this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OutputStreamContent$writeTo$2(ByteWriteChannel byteWriteChannel, OutputStreamContent outputStreamContent, Continuation<? super OutputStreamContent$writeTo$2> continuation) {
        super(1, continuation);
        this.$channel = byteWriteChannel;
        this.this$0 = outputStreamContent;
    }

    @NotNull
    public final Continuation<Unit> create(@NotNull Continuation<?> continuation) {
        return new OutputStreamContent$writeTo$2(this.$channel, this.this$0, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Throwable th;
        OutputStream outputStream;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            OutputStream g = BlockingKt.g(this.$channel, (Job) null, 1, (Object) null);
            try {
                Function2 e = this.this$0.f8995a;
                this.L$0 = g;
                this.label = 1;
                if (e.invoke(g, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                outputStream = g;
            } catch (Throwable th2) {
                OutputStream outputStream2 = g;
                th = th2;
                outputStream = outputStream2;
                try {
                    throw th;
                } catch (Throwable th3) {
                    CloseableKt.closeFinally(outputStream, th);
                    throw th3;
                }
            }
        } else if (i == 1) {
            outputStream = (Closeable) this.L$0;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Throwable th4) {
                th = th4;
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Unit unit = Unit.INSTANCE;
        CloseableKt.closeFinally(outputStream, (Throwable) null);
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@Nullable Continuation<? super Unit> continuation) {
        return ((OutputStreamContent$writeTo$2) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
