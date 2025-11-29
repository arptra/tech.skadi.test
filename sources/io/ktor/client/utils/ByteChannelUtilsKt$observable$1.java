package io.ktor.client.utils;

import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.WriterScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nByteChannelUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ByteChannelUtils.kt\nio/ktor/client/utils/ByteChannelUtilsKt$observable$1\n+ 2 Pool.kt\nio/ktor/utils/io/pool/PoolKt\n*L\n1#1,35:1\n159#2,5:36\n*S KotlinDebug\n*F\n+ 1 ByteChannelUtils.kt\nio/ktor/client/utils/ByteChannelUtilsKt$observable$1\n*L\n19#1:36,5\n*E\n"})
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lio/ktor/utils/io/WriterScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.utils.ByteChannelUtilsKt$observable$1", f = "ByteChannelUtils.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 3, 3}, l = {23, 24, 26, 31}, m = "invokeSuspend", n = {"$this$writer", "$this$useInstance$iv", "instance$iv", "byteArray", "total", "bytesSend", "$this$writer", "$this$useInstance$iv", "instance$iv", "byteArray", "total", "bytesSend", "read", "$this$writer", "$this$useInstance$iv", "instance$iv", "byteArray", "total", "bytesSend", "$this$useInstance$iv", "instance$iv"}, s = {"L$0", "L$1", "L$4", "L$5", "J$0", "J$1", "L$0", "L$1", "L$4", "L$5", "J$0", "J$1", "I$0", "L$0", "L$1", "L$4", "L$5", "J$0", "J$1", "L$0", "L$1"})
public final class ByteChannelUtilsKt$observable$1 extends SuspendLambda implements Function2<WriterScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Long $contentLength;
    final /* synthetic */ Function3<Long, Long, Continuation<? super Unit>, Object> $listener;
    final /* synthetic */ ByteReadChannel $this_observable;
    int I$0;
    long J$0;
    long J$1;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ByteChannelUtilsKt$observable$1(Long l, ByteReadChannel byteReadChannel, Function3<? super Long, ? super Long, ? super Continuation<? super Unit>, ? extends Object> function3, Continuation<? super ByteChannelUtilsKt$observable$1> continuation) {
        super(2, continuation);
        this.$contentLength = l;
        this.$this_observable = byteReadChannel;
        this.$listener = function3;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        ByteChannelUtilsKt$observable$1 byteChannelUtilsKt$observable$1 = new ByteChannelUtilsKt$observable$1(this.$contentLength, this.$this_observable, this.$listener, continuation);
        byteChannelUtilsKt$observable$1.L$0 = obj;
        return byteChannelUtilsKt$observable$1;
    }

    @Nullable
    public final Object invoke(@NotNull WriterScope writerScope, @Nullable Continuation<? super Unit> continuation) {
        return ((ByteChannelUtilsKt$observable$1) create(writerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v15, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v25, resolved type: io.ktor.utils.io.pool.ObjectPool} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0130  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0163  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r20) {
        /*
            r19 = this;
            r0 = r19
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r5 = 4
            r6 = 3
            r7 = 2
            r8 = 1
            if (r2 == 0) goto L_0x00b6
            if (r2 == r8) goto L_0x008f
            if (r2 == r7) goto L_0x0061
            if (r2 == r6) goto L_0x002d
            if (r2 != r5) goto L_0x0025
            java.lang.Object r1 = r0.L$1
            java.lang.Object r0 = r0.L$0
            r2 = r0
            io.ktor.utils.io.pool.ObjectPool r2 = (io.ktor.utils.io.pool.ObjectPool) r2
            kotlin.ResultKt.throwOnFailure(r20)     // Catch:{ all -> 0x0022 }
            goto L_0x01ab
        L_0x0022:
            r0 = move-exception
            goto L_0x01b3
        L_0x0025:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x002d:
            long r9 = r0.J$1
            long r11 = r0.J$0
            java.lang.Object r2 = r0.L$5
            byte[] r2 = (byte[]) r2
            java.lang.Object r13 = r0.L$4
            java.lang.Object r14 = r0.L$3
            kotlin.jvm.functions.Function3 r14 = (kotlin.jvm.functions.Function3) r14
            java.lang.Object r15 = r0.L$2
            io.ktor.utils.io.ByteReadChannel r15 = (io.ktor.utils.io.ByteReadChannel) r15
            java.lang.Object r5 = r0.L$1
            io.ktor.utils.io.pool.ObjectPool r5 = (io.ktor.utils.io.pool.ObjectPool) r5
            java.lang.Object r3 = r0.L$0
            io.ktor.utils.io.WriterScope r3 = (io.ktor.utils.io.WriterScope) r3
            kotlin.ResultKt.throwOnFailure(r20)     // Catch:{ all -> 0x005c }
            r16 = r3
            r3 = r2
            r2 = r5
            r4 = r11
            r11 = r14
            r12 = r15
            r14 = r16
            r15 = r7
            r17 = r9
            r9 = r6
            r6 = r17
            r10 = r13
            goto L_0x016d
        L_0x005c:
            r0 = move-exception
            r2 = r5
            r1 = r13
            goto L_0x01b3
        L_0x0061:
            int r2 = r0.I$0
            long r3 = r0.J$1
            long r9 = r0.J$0
            java.lang.Object r5 = r0.L$5
            byte[] r5 = (byte[]) r5
            java.lang.Object r11 = r0.L$4
            java.lang.Object r12 = r0.L$3
            kotlin.jvm.functions.Function3 r12 = (kotlin.jvm.functions.Function3) r12
            java.lang.Object r13 = r0.L$2
            io.ktor.utils.io.ByteReadChannel r13 = (io.ktor.utils.io.ByteReadChannel) r13
            java.lang.Object r14 = r0.L$1
            io.ktor.utils.io.pool.ObjectPool r14 = (io.ktor.utils.io.pool.ObjectPool) r14
            java.lang.Object r15 = r0.L$0
            io.ktor.utils.io.WriterScope r15 = (io.ktor.utils.io.WriterScope) r15
            kotlin.ResultKt.throwOnFailure(r20)     // Catch:{ all -> 0x008a }
            r6 = r15
            r15 = r7
            r7 = r12
            r16 = r9
            r10 = r11
            r11 = r16
            goto L_0x013e
        L_0x008a:
            r0 = move-exception
            r1 = r11
        L_0x008c:
            r2 = r14
            goto L_0x01b3
        L_0x008f:
            long r2 = r0.J$1
            long r4 = r0.J$0
            java.lang.Object r9 = r0.L$5
            byte[] r9 = (byte[]) r9
            java.lang.Object r10 = r0.L$4
            java.lang.Object r11 = r0.L$3
            kotlin.jvm.functions.Function3 r11 = (kotlin.jvm.functions.Function3) r11
            java.lang.Object r12 = r0.L$2
            io.ktor.utils.io.ByteReadChannel r12 = (io.ktor.utils.io.ByteReadChannel) r12
            java.lang.Object r13 = r0.L$1
            io.ktor.utils.io.pool.ObjectPool r13 = (io.ktor.utils.io.pool.ObjectPool) r13
            java.lang.Object r14 = r0.L$0
            io.ktor.utils.io.WriterScope r14 = (io.ktor.utils.io.WriterScope) r14
            kotlin.ResultKt.throwOnFailure(r20)     // Catch:{ all -> 0x00b1 }
            r6 = r2
            r2 = r13
            r3 = r20
            goto L_0x0109
        L_0x00b1:
            r0 = move-exception
            r1 = r10
            r2 = r13
            goto L_0x01b3
        L_0x00b6:
            kotlin.ResultKt.throwOnFailure(r20)
            java.lang.Object r2 = r0.L$0
            io.ktor.utils.io.WriterScope r2 = (io.ktor.utils.io.WriterScope) r2
            io.ktor.utils.io.pool.ObjectPool r3 = io.ktor.utils.io.pool.ByteArrayPoolKt.a()
            java.lang.Long r4 = r0.$contentLength
            io.ktor.utils.io.ByteReadChannel r5 = r0.$this_observable
            kotlin.jvm.functions.Function3<java.lang.Long, java.lang.Long, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> r9 = r0.$listener
            java.lang.Object r10 = r3.h0()
            r11 = r10
            byte[] r11 = (byte[]) r11     // Catch:{ all -> 0x00d5 }
            if (r4 == 0) goto L_0x00da
            long r12 = r4.longValue()     // Catch:{ all -> 0x00d5 }
            goto L_0x00dc
        L_0x00d5:
            r0 = move-exception
            r2 = r3
        L_0x00d7:
            r1 = r10
            goto L_0x01b3
        L_0x00da:
            r12 = -1
        L_0x00dc:
            r14 = r2
            r2 = r3
            r6 = 0
            r16 = r12
            r12 = r5
            r4 = r16
            r18 = r11
            r11 = r9
            r9 = r18
        L_0x00ea:
            boolean r3 = r12.Q()     // Catch:{ all -> 0x0175 }
            if (r3 != 0) goto L_0x0178
            r0.L$0 = r14     // Catch:{ all -> 0x0175 }
            r0.L$1 = r2     // Catch:{ all -> 0x0175 }
            r0.L$2 = r12     // Catch:{ all -> 0x0175 }
            r0.L$3 = r11     // Catch:{ all -> 0x0175 }
            r0.L$4 = r10     // Catch:{ all -> 0x0175 }
            r0.L$5 = r9     // Catch:{ all -> 0x0175 }
            r0.J$0 = r4     // Catch:{ all -> 0x0175 }
            r0.J$1 = r6     // Catch:{ all -> 0x0175 }
            r0.label = r8     // Catch:{ all -> 0x0175 }
            java.lang.Object r3 = io.ktor.utils.io.ByteReadChannelKt.g(r12, r9, r0)     // Catch:{ all -> 0x0175 }
            if (r3 != r1) goto L_0x0109
            return r1
        L_0x0109:
            java.lang.Number r3 = (java.lang.Number) r3     // Catch:{ all -> 0x0175 }
            int r3 = r3.intValue()     // Catch:{ all -> 0x0175 }
            io.ktor.utils.io.ByteWriteChannel r8 = r14.b()     // Catch:{ all -> 0x0175 }
            r0.L$0 = r14     // Catch:{ all -> 0x0175 }
            r0.L$1 = r2     // Catch:{ all -> 0x0175 }
            r0.L$2 = r12     // Catch:{ all -> 0x0175 }
            r0.L$3 = r11     // Catch:{ all -> 0x0175 }
            r0.L$4 = r10     // Catch:{ all -> 0x0175 }
            r0.L$5 = r9     // Catch:{ all -> 0x0175 }
            r0.J$0 = r4     // Catch:{ all -> 0x0175 }
            r0.J$1 = r6     // Catch:{ all -> 0x0175 }
            r0.I$0 = r3     // Catch:{ all -> 0x0175 }
            r15 = 2
            r0.label = r15     // Catch:{ all -> 0x0175 }
            r13 = 0
            java.lang.Object r8 = r8.I(r9, r13, r3, r0)     // Catch:{ all -> 0x0175 }
            if (r8 != r1) goto L_0x0130
            return r1
        L_0x0130:
            r13 = r12
            r16 = r14
            r14 = r2
            r2 = r3
            r17 = r4
            r5 = r9
            r3 = r6
            r7 = r11
            r6 = r16
            r11 = r17
        L_0x013e:
            long r8 = (long) r2
            long r2 = r3 + r8
            java.lang.Long r4 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r2)     // Catch:{ all -> 0x0171 }
            java.lang.Long r8 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r11)     // Catch:{ all -> 0x0171 }
            r0.L$0 = r6     // Catch:{ all -> 0x0171 }
            r0.L$1 = r14     // Catch:{ all -> 0x0171 }
            r0.L$2 = r13     // Catch:{ all -> 0x0171 }
            r0.L$3 = r7     // Catch:{ all -> 0x0171 }
            r0.L$4 = r10     // Catch:{ all -> 0x0171 }
            r0.L$5 = r5     // Catch:{ all -> 0x0171 }
            r0.J$0 = r11     // Catch:{ all -> 0x0171 }
            r0.J$1 = r2     // Catch:{ all -> 0x0171 }
            r9 = 3
            r0.label = r9     // Catch:{ all -> 0x0171 }
            java.lang.Object r4 = r7.invoke(r4, r8, r0)     // Catch:{ all -> 0x0171 }
            if (r4 != r1) goto L_0x0163
            return r1
        L_0x0163:
            r16 = r2
            r3 = r5
            r4 = r11
            r12 = r13
            r2 = r14
            r14 = r6
            r11 = r7
            r6 = r16
        L_0x016d:
            r9 = r3
            r8 = 1
            goto L_0x00ea
        L_0x0171:
            r0 = move-exception
            r1 = r10
            goto L_0x008c
        L_0x0175:
            r0 = move-exception
            goto L_0x00d7
        L_0x0178:
            java.lang.Throwable r3 = r12.f()     // Catch:{ all -> 0x0175 }
            io.ktor.utils.io.ByteWriteChannel r8 = r14.b()     // Catch:{ all -> 0x0175 }
            r8.h(r3)     // Catch:{ all -> 0x0175 }
            if (r3 != 0) goto L_0x01aa
            r8 = 0
            int r3 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r3 != 0) goto L_0x01aa
            java.lang.Long r3 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r6)     // Catch:{ all -> 0x0175 }
            java.lang.Long r4 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r4)     // Catch:{ all -> 0x0175 }
            r0.L$0 = r2     // Catch:{ all -> 0x0175 }
            r0.L$1 = r10     // Catch:{ all -> 0x0175 }
            r5 = 0
            r0.L$2 = r5     // Catch:{ all -> 0x0175 }
            r0.L$3 = r5     // Catch:{ all -> 0x0175 }
            r0.L$4 = r5     // Catch:{ all -> 0x0175 }
            r0.L$5 = r5     // Catch:{ all -> 0x0175 }
            r5 = 4
            r0.label = r5     // Catch:{ all -> 0x0175 }
            java.lang.Object r0 = r11.invoke(r3, r4, r0)     // Catch:{ all -> 0x0175 }
            if (r0 != r1) goto L_0x01aa
            return r1
        L_0x01aa:
            r1 = r10
        L_0x01ab:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0022 }
            r2.recycle(r1)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x01b3:
            r2.recycle(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.utils.ByteChannelUtilsKt$observable$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
