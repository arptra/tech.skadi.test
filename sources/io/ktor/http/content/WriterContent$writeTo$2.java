package io.ktor.http.content;

import io.ktor.util.cio.OutputStreamAdaptersKt;
import io.ktor.utils.io.ByteWriteChannel;
import java.io.Closeable;
import java.io.Writer;
import java.nio.charset.Charset;
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
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.http.content.WriterContent$writeTo$2", f = "WriterContent.kt", i = {}, l = {26}, m = "invokeSuspend", n = {}, s = {})
public final class WriterContent$writeTo$2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ ByteWriteChannel $channel;
    final /* synthetic */ Charset $charset;
    Object L$0;
    int label;
    final /* synthetic */ WriterContent this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WriterContent$writeTo$2(ByteWriteChannel byteWriteChannel, Charset charset, WriterContent writerContent, Continuation<? super WriterContent$writeTo$2> continuation) {
        super(1, continuation);
        this.$channel = byteWriteChannel;
        this.$charset = charset;
        this.this$0 = writerContent;
    }

    @NotNull
    public final Continuation<Unit> create(@NotNull Continuation<?> continuation) {
        return new WriterContent$writeTo$2(this.$channel, this.$charset, this.this$0, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Throwable th;
        Writer writer;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Writer a2 = OutputStreamAdaptersKt.a(this.$channel, this.$charset);
            try {
                Function2 e = this.this$0.f9000a;
                this.L$0 = a2;
                this.label = 1;
                if (e.invoke(a2, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                writer = a2;
            } catch (Throwable th2) {
                Writer writer2 = a2;
                th = th2;
                writer = writer2;
                try {
                    throw th;
                } catch (Throwable th3) {
                    CloseableKt.closeFinally(writer, th);
                    throw th3;
                }
            }
        } else if (i == 1) {
            writer = (Closeable) this.L$0;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Throwable th4) {
                th = th4;
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Unit unit = Unit.INSTANCE;
        CloseableKt.closeFinally(writer, (Throwable) null);
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@Nullable Continuation<? super Unit> continuation) {
        return ((WriterContent$writeTo$2) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
