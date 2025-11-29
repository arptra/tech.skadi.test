package io.ktor.util;

import io.ktor.utils.io.ByteChannel;
import io.ktor.utils.io.ByteReadChannel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nByteChannels.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ByteChannels.kt\nio/ktor/util/ByteChannelsKt$split$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,92:1\n1#2:93\n*E\n"})
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.util.ByteChannelsKt$split$1", f = "ByteChannels.kt", i = {0, 0, 1, 1}, l = {27, 31}, m = "invokeSuspend", n = {"$this$launch", "buffer", "$this$launch", "buffer"}, s = {"L$0", "L$1", "L$0", "L$1"})
public final class ByteChannelsKt$split$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ByteChannel $first;
    final /* synthetic */ ByteChannel $second;
    final /* synthetic */ ByteReadChannel $this_split;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ByteChannelsKt$split$1(ByteReadChannel byteReadChannel, ByteChannel byteChannel, ByteChannel byteChannel2, Continuation<? super ByteChannelsKt$split$1> continuation) {
        super(2, continuation);
        this.$this_split = byteReadChannel;
        this.$first = byteChannel;
        this.$second = byteChannel2;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        ByteChannelsKt$split$1 byteChannelsKt$split$1 = new ByteChannelsKt$split$1(this.$this_split, this.$first, this.$second, continuation);
        byteChannelsKt$split$1.L$0 = obj;
        return byteChannelsKt$split$1;
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x009c A[Catch:{ all -> 0x001b, all -> 0x00d3 }] */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r14) {
        /*
            r13 = this;
            r0 = 1
            r1 = 2
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r13.label
            if (r3 == 0) goto L_0x0033
            if (r3 == r0) goto L_0x0026
            if (r3 != r1) goto L_0x001e
            java.lang.Object r3 = r13.L$1
            byte[] r3 = (byte[]) r3
            java.lang.Object r4 = r13.L$0
            kotlinx.coroutines.CoroutineScope r4 = (kotlinx.coroutines.CoroutineScope) r4
            kotlin.ResultKt.throwOnFailure(r14)     // Catch:{ all -> 0x001b }
            r14 = r4
            goto L_0x0044
        L_0x001b:
            r14 = move-exception
            goto L_0x00b9
        L_0x001e:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r14)
            throw r13
        L_0x0026:
            java.lang.Object r3 = r13.L$1
            byte[] r3 = (byte[]) r3
            java.lang.Object r4 = r13.L$0
            kotlinx.coroutines.CoroutineScope r4 = (kotlinx.coroutines.CoroutineScope) r4
            kotlin.ResultKt.throwOnFailure(r14)     // Catch:{ all -> 0x001b }
            r10 = r4
            goto L_0x005d
        L_0x0033:
            kotlin.ResultKt.throwOnFailure(r14)
            java.lang.Object r14 = r13.L$0
            kotlinx.coroutines.CoroutineScope r14 = (kotlinx.coroutines.CoroutineScope) r14
            io.ktor.utils.io.pool.ObjectPool r3 = io.ktor.utils.io.pool.ByteArrayPoolKt.a()
            java.lang.Object r3 = r3.h0()
            byte[] r3 = (byte[]) r3
        L_0x0044:
            io.ktor.utils.io.ByteReadChannel r4 = r13.$this_split     // Catch:{ all -> 0x001b }
            boolean r4 = r4.Q()     // Catch:{ all -> 0x001b }
            if (r4 != 0) goto L_0x009e
            io.ktor.utils.io.ByteReadChannel r4 = r13.$this_split     // Catch:{ all -> 0x001b }
            r13.L$0 = r14     // Catch:{ all -> 0x001b }
            r13.L$1 = r3     // Catch:{ all -> 0x001b }
            r13.label = r0     // Catch:{ all -> 0x001b }
            java.lang.Object r4 = io.ktor.utils.io.ByteReadChannelKt.g(r4, r3, r13)     // Catch:{ all -> 0x001b }
            if (r4 != r2) goto L_0x005b
            return r2
        L_0x005b:
            r10 = r14
            r14 = r4
        L_0x005d:
            java.lang.Number r14 = (java.lang.Number) r14     // Catch:{ all -> 0x001b }
            int r14 = r14.intValue()     // Catch:{ all -> 0x001b }
            io.ktor.util.ByteChannelsKt$split$1$1 r7 = new io.ktor.util.ByteChannelsKt$split$1$1     // Catch:{ all -> 0x001b }
            io.ktor.utils.io.ByteChannel r4 = r13.$first     // Catch:{ all -> 0x001b }
            r11 = 0
            r7.<init>(r4, r3, r14, r11)     // Catch:{ all -> 0x001b }
            r8 = 3
            r9 = 0
            r5 = 0
            r6 = 0
            r4 = r10
            kotlinx.coroutines.Deferred r12 = kotlinx.coroutines.BuildersKt__Builders_commonKt.b(r4, r5, r6, r7, r8, r9)     // Catch:{ all -> 0x001b }
            io.ktor.util.ByteChannelsKt$split$1$2 r7 = new io.ktor.util.ByteChannelsKt$split$1$2     // Catch:{ all -> 0x001b }
            io.ktor.utils.io.ByteChannel r4 = r13.$second     // Catch:{ all -> 0x001b }
            r7.<init>(r4, r3, r14, r11)     // Catch:{ all -> 0x001b }
            r8 = 3
            r9 = 0
            r5 = 0
            r6 = 0
            r4 = r10
            kotlinx.coroutines.Deferred r14 = kotlinx.coroutines.BuildersKt__Builders_commonKt.b(r4, r5, r6, r7, r8, r9)     // Catch:{ all -> 0x001b }
            kotlinx.coroutines.Deferred[] r4 = new kotlinx.coroutines.Deferred[r1]     // Catch:{ all -> 0x001b }
            r5 = 0
            r4[r5] = r12     // Catch:{ all -> 0x001b }
            r4[r0] = r14     // Catch:{ all -> 0x001b }
            java.util.List r14 = kotlin.collections.CollectionsKt.listOf(r4)     // Catch:{ all -> 0x001b }
            r13.L$0 = r10     // Catch:{ all -> 0x001b }
            r13.L$1 = r3     // Catch:{ all -> 0x001b }
            r13.label = r1     // Catch:{ all -> 0x001b }
            java.lang.Object r14 = kotlinx.coroutines.AwaitKt.a(r14, r13)     // Catch:{ all -> 0x001b }
            if (r14 != r2) goto L_0x009c
            return r2
        L_0x009c:
            r14 = r10
            goto L_0x0044
        L_0x009e:
            io.ktor.utils.io.ByteReadChannel r14 = r13.$this_split     // Catch:{ all -> 0x001b }
            java.lang.Throwable r14 = r14.f()     // Catch:{ all -> 0x001b }
            if (r14 != 0) goto L_0x00b8
            io.ktor.utils.io.pool.ObjectPool r14 = io.ktor.utils.io.pool.ByteArrayPoolKt.a()
            r14.recycle(r3)
        L_0x00ad:
            io.ktor.utils.io.ByteChannel r14 = r13.$first
            io.ktor.utils.io.ByteWriteChannelKt.a(r14)
            io.ktor.utils.io.ByteChannel r13 = r13.$second
            io.ktor.utils.io.ByteWriteChannelKt.a(r13)
            goto L_0x00d0
        L_0x00b8:
            throw r14     // Catch:{ all -> 0x001b }
        L_0x00b9:
            io.ktor.utils.io.ByteReadChannel r0 = r13.$this_split     // Catch:{ all -> 0x00d3 }
            r0.e(r14)     // Catch:{ all -> 0x00d3 }
            io.ktor.utils.io.ByteChannel r0 = r13.$first     // Catch:{ all -> 0x00d3 }
            r0.e(r14)     // Catch:{ all -> 0x00d3 }
            io.ktor.utils.io.ByteChannel r0 = r13.$second     // Catch:{ all -> 0x00d3 }
            r0.e(r14)     // Catch:{ all -> 0x00d3 }
            io.ktor.utils.io.pool.ObjectPool r14 = io.ktor.utils.io.pool.ByteArrayPoolKt.a()
            r14.recycle(r3)
            goto L_0x00ad
        L_0x00d0:
            kotlin.Unit r13 = kotlin.Unit.INSTANCE
            return r13
        L_0x00d3:
            r14 = move-exception
            io.ktor.utils.io.pool.ObjectPool r0 = io.ktor.utils.io.pool.ByteArrayPoolKt.a()
            r0.recycle(r3)
            io.ktor.utils.io.ByteChannel r0 = r13.$first
            io.ktor.utils.io.ByteWriteChannelKt.a(r0)
            io.ktor.utils.io.ByteChannel r13 = r13.$second
            io.ktor.utils.io.ByteWriteChannelKt.a(r13)
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.util.ByteChannelsKt$split$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((ByteChannelsKt$split$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
