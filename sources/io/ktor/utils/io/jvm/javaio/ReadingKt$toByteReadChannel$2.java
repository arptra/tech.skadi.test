package io.ktor.utils.io.jvm.javaio;

import io.ktor.utils.io.WriterScope;
import io.ktor.utils.io.pool.ObjectPool;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lio/ktor/utils/io/WriterScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.utils.io.jvm.javaio.ReadingKt$toByteReadChannel$2", f = "Reading.kt", i = {0, 0}, l = {90}, m = "invokeSuspend", n = {"$this$writer", "buffer"}, s = {"L$0", "L$1"})
public final class ReadingKt$toByteReadChannel$2 extends SuspendLambda implements Function2<WriterScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ObjectPool<byte[]> $pool;
    final /* synthetic */ InputStream $this_toByteReadChannel;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ReadingKt$toByteReadChannel$2(ObjectPool<byte[]> objectPool, InputStream inputStream, Continuation<? super ReadingKt$toByteReadChannel$2> continuation) {
        super(2, continuation);
        this.$pool = objectPool;
        this.$this_toByteReadChannel = inputStream;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        ReadingKt$toByteReadChannel$2 readingKt$toByteReadChannel$2 = new ReadingKt$toByteReadChannel$2(this.$pool, this.$this_toByteReadChannel, continuation);
        readingKt$toByteReadChannel$2.L$0 = obj;
        return readingKt$toByteReadChannel$2;
    }

    @Nullable
    public final Object invoke(@NotNull WriterScope writerScope, @Nullable Continuation<? super Unit> continuation) {
        return ((ReadingKt$toByteReadChannel$2) create(writerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x003b A[Catch:{ all -> 0x0017, all -> 0x0069 }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x004e A[SYNTHETIC] */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r7) {
        /*
            r6 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.label
            r2 = 1
            if (r1 == 0) goto L_0x0021
            if (r1 != r2) goto L_0x0019
            java.lang.Object r1 = r6.L$1
            byte[] r1 = (byte[]) r1
            java.lang.Object r3 = r6.L$0
            io.ktor.utils.io.WriterScope r3 = (io.ktor.utils.io.WriterScope) r3
            kotlin.ResultKt.throwOnFailure(r7)     // Catch:{ all -> 0x0017 }
            goto L_0x0031
        L_0x0017:
            r7 = move-exception
            goto L_0x0059
        L_0x0019:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0021:
            kotlin.ResultKt.throwOnFailure(r7)
            java.lang.Object r7 = r6.L$0
            io.ktor.utils.io.WriterScope r7 = (io.ktor.utils.io.WriterScope) r7
            io.ktor.utils.io.pool.ObjectPool<byte[]> r1 = r6.$pool
            java.lang.Object r1 = r1.h0()
            byte[] r1 = (byte[]) r1
            r3 = r7
        L_0x0031:
            java.io.InputStream r7 = r6.$this_toByteReadChannel     // Catch:{ all -> 0x0017 }
            int r4 = r1.length     // Catch:{ all -> 0x0017 }
            r5 = 0
            int r7 = r7.read(r1, r5, r4)     // Catch:{ all -> 0x0017 }
            if (r7 < 0) goto L_0x004e
            if (r7 == 0) goto L_0x0031
            io.ktor.utils.io.ByteWriteChannel r4 = r3.b()     // Catch:{ all -> 0x0017 }
            r6.L$0 = r3     // Catch:{ all -> 0x0017 }
            r6.L$1 = r1     // Catch:{ all -> 0x0017 }
            r6.label = r2     // Catch:{ all -> 0x0017 }
            java.lang.Object r7 = r4.I(r1, r5, r7, r6)     // Catch:{ all -> 0x0017 }
            if (r7 != r0) goto L_0x0031
            return r0
        L_0x004e:
            io.ktor.utils.io.pool.ObjectPool<byte[]> r7 = r6.$pool
            r7.recycle(r1)
        L_0x0053:
            java.io.InputStream r6 = r6.$this_toByteReadChannel
            r6.close()
            goto L_0x0066
        L_0x0059:
            io.ktor.utils.io.ByteWriteChannel r0 = r3.b()     // Catch:{ all -> 0x0069 }
            r0.h(r7)     // Catch:{ all -> 0x0069 }
            io.ktor.utils.io.pool.ObjectPool<byte[]> r7 = r6.$pool
            r7.recycle(r1)
            goto L_0x0053
        L_0x0066:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        L_0x0069:
            r7 = move-exception
            io.ktor.utils.io.pool.ObjectPool<byte[]> r0 = r6.$pool
            r0.recycle(r1)
            java.io.InputStream r6 = r6.$this_toByteReadChannel
            r6.close()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.jvm.javaio.ReadingKt$toByteReadChannel$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
