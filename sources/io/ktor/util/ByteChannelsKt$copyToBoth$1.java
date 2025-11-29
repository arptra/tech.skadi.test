package io.ktor.util;

import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteWriteChannel;
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

@SourceDebugExtension({"SMAP\nByteChannels.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ByteChannels.kt\nio/ktor/util/ByteChannelsKt$copyToBoth$1\n+ 2 Closeable.kt\nio/ktor/utils/io/core/CloseableKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,92:1\n8#2,4:93\n22#2,4:97\n12#2,9:101\n1#3:110\n*S KotlinDebug\n*F\n+ 1 ByteChannels.kt\nio/ktor/util/ByteChannelsKt$copyToBoth$1\n*L\n61#1:93,4\n61#1:97,4\n61#1:101,9\n*E\n"})
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.util.ByteChannelsKt$copyToBoth$1", f = "ByteChannels.kt", i = {1, 1, 1, 2, 2}, l = {61, 63, 64}, m = "invokeSuspend", n = {"$this$use$iv", "it", "closed$iv", "$this$use$iv", "closed$iv"}, s = {"L$0", "L$4", "I$0", "L$0", "I$0"})
final class ByteChannelsKt$copyToBoth$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ByteWriteChannel $first;
    final /* synthetic */ ByteWriteChannel $second;
    final /* synthetic */ ByteReadChannel $this_copyToBoth;
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ByteChannelsKt$copyToBoth$1(ByteReadChannel byteReadChannel, ByteWriteChannel byteWriteChannel, ByteWriteChannel byteWriteChannel2, Continuation<? super ByteChannelsKt$copyToBoth$1> continuation) {
        super(2, continuation);
        this.$this_copyToBoth = byteReadChannel;
        this.$first = byteWriteChannel;
        this.$second = byteWriteChannel2;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new ByteChannelsKt$copyToBoth$1(this.$this_copyToBoth, this.$first, this.$second, continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x007b A[Catch:{ all -> 0x005d, all -> 0x0114 }] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00b7 A[Catch:{ all -> 0x0027 }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00d0 A[Catch:{ all -> 0x0027 }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00f2 A[Catch:{ all -> 0x005d, all -> 0x0114 }] */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r12) {
        /*
            r11 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r11.label
            r2 = 3
            r3 = 2
            r4 = 1
            r5 = 0
            if (r1 == 0) goto L_0x0060
            if (r1 == r4) goto L_0x0059
            if (r1 == r3) goto L_0x0032
            if (r1 != r2) goto L_0x002a
            java.lang.Object r1 = r11.L$3
            io.ktor.utils.io.ByteReadChannel r1 = (io.ktor.utils.io.ByteReadChannel) r1
            java.lang.Object r6 = r11.L$2
            io.ktor.utils.io.ByteWriteChannel r6 = (io.ktor.utils.io.ByteWriteChannel) r6
            java.lang.Object r7 = r11.L$1
            io.ktor.utils.io.ByteWriteChannel r7 = (io.ktor.utils.io.ByteWriteChannel) r7
            java.lang.Object r8 = r11.L$0
            java.io.Closeable r8 = (java.io.Closeable) r8
            kotlin.ResultKt.throwOnFailure(r12)     // Catch:{ all -> 0x0027 }
            goto L_0x00d1
        L_0x0027:
            r12 = move-exception
            goto L_0x00d4
        L_0x002a:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L_0x0032:
            int r1 = r11.I$0
            java.lang.Object r6 = r11.L$4
            io.ktor.utils.io.core.ByteReadPacket r6 = (io.ktor.utils.io.core.ByteReadPacket) r6
            java.lang.Object r7 = r11.L$3
            io.ktor.utils.io.ByteReadChannel r7 = (io.ktor.utils.io.ByteReadChannel) r7
            java.lang.Object r8 = r11.L$2
            io.ktor.utils.io.ByteWriteChannel r8 = (io.ktor.utils.io.ByteWriteChannel) r8
            java.lang.Object r9 = r11.L$1
            io.ktor.utils.io.ByteWriteChannel r9 = (io.ktor.utils.io.ByteWriteChannel) r9
            java.lang.Object r10 = r11.L$0
            java.io.Closeable r10 = (java.io.Closeable) r10
            kotlin.ResultKt.throwOnFailure(r12)     // Catch:{ all -> 0x0052 }
            r12 = r6
            r6 = r8
            r8 = r10
            r10 = r1
            r1 = r7
            r7 = r9
            goto L_0x00b8
        L_0x0052:
            r12 = move-exception
            r1 = r7
            r6 = r8
            r7 = r9
            r8 = r10
            goto L_0x00d4
        L_0x0059:
            kotlin.ResultKt.throwOnFailure(r12)     // Catch:{ all -> 0x005d }
            goto L_0x0092
        L_0x005d:
            r12 = move-exception
            goto L_0x0106
        L_0x0060:
            kotlin.ResultKt.throwOnFailure(r12)
        L_0x0063:
            io.ktor.utils.io.ByteReadChannel r12 = r11.$this_copyToBoth     // Catch:{ all -> 0x005d }
            boolean r12 = r12.Q()     // Catch:{ all -> 0x005d }
            if (r12 != 0) goto L_0x00f2
            io.ktor.utils.io.ByteWriteChannel r12 = r11.$first     // Catch:{ all -> 0x005d }
            boolean r12 = r12.g()     // Catch:{ all -> 0x005d }
            if (r12 == 0) goto L_0x007b
            io.ktor.utils.io.ByteWriteChannel r12 = r11.$second     // Catch:{ all -> 0x005d }
            boolean r12 = r12.g()     // Catch:{ all -> 0x005d }
            if (r12 != 0) goto L_0x00f2
        L_0x007b:
            io.ktor.utils.io.ByteReadChannel r12 = r11.$this_copyToBoth     // Catch:{ all -> 0x005d }
            r11.L$0 = r5     // Catch:{ all -> 0x005d }
            r11.L$1 = r5     // Catch:{ all -> 0x005d }
            r11.L$2 = r5     // Catch:{ all -> 0x005d }
            r11.L$3 = r5     // Catch:{ all -> 0x005d }
            r11.L$4 = r5     // Catch:{ all -> 0x005d }
            r11.label = r4     // Catch:{ all -> 0x005d }
            r6 = 4096(0x1000, double:2.0237E-320)
            java.lang.Object r12 = r12.A(r6, r11)     // Catch:{ all -> 0x005d }
            if (r12 != r0) goto L_0x0092
            return r0
        L_0x0092:
            r8 = r12
            java.io.Closeable r8 = (java.io.Closeable) r8     // Catch:{ all -> 0x005d }
            io.ktor.utils.io.ByteWriteChannel r7 = r11.$first     // Catch:{ all -> 0x005d }
            io.ktor.utils.io.ByteWriteChannel r6 = r11.$second     // Catch:{ all -> 0x005d }
            io.ktor.utils.io.ByteReadChannel r1 = r11.$this_copyToBoth     // Catch:{ all -> 0x005d }
            r12 = r8
            io.ktor.utils.io.core.ByteReadPacket r12 = (io.ktor.utils.io.core.ByteReadPacket) r12     // Catch:{ all -> 0x00e6 }
            io.ktor.utils.io.core.ByteReadPacket r9 = r12.V0()     // Catch:{ all -> 0x0027 }
            r11.L$0 = r8     // Catch:{ all -> 0x0027 }
            r11.L$1 = r7     // Catch:{ all -> 0x0027 }
            r11.L$2 = r6     // Catch:{ all -> 0x0027 }
            r11.L$3 = r1     // Catch:{ all -> 0x0027 }
            r11.L$4 = r12     // Catch:{ all -> 0x0027 }
            r10 = 0
            r11.I$0 = r10     // Catch:{ all -> 0x0027 }
            r11.label = r3     // Catch:{ all -> 0x0027 }
            java.lang.Object r9 = r7.w(r9, r11)     // Catch:{ all -> 0x0027 }
            if (r9 != r0) goto L_0x00b8
            return r0
        L_0x00b8:
            io.ktor.utils.io.core.ByteReadPacket r12 = r12.V0()     // Catch:{ all -> 0x0027 }
            r11.L$0 = r8     // Catch:{ all -> 0x0027 }
            r11.L$1 = r7     // Catch:{ all -> 0x0027 }
            r11.L$2 = r6     // Catch:{ all -> 0x0027 }
            r11.L$3 = r1     // Catch:{ all -> 0x0027 }
            r11.L$4 = r5     // Catch:{ all -> 0x0027 }
            r11.I$0 = r10     // Catch:{ all -> 0x0027 }
            r11.label = r2     // Catch:{ all -> 0x0027 }
            java.lang.Object r12 = r6.w(r12, r11)     // Catch:{ all -> 0x0027 }
            if (r12 != r0) goto L_0x00d1
            return r0
        L_0x00d1:
            kotlin.Unit r12 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0027 }
            goto L_0x00e1
        L_0x00d4:
            r1.e(r12)     // Catch:{ all -> 0x00e6 }
            r7.h(r12)     // Catch:{ all -> 0x00e6 }
            boolean r12 = r6.h(r12)     // Catch:{ all -> 0x00e6 }
            kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r12)     // Catch:{ all -> 0x00e6 }
        L_0x00e1:
            r8.close()     // Catch:{ all -> 0x005d }
            goto L_0x0063
        L_0x00e6:
            r12 = move-exception
            r8.close()     // Catch:{ all -> 0x00eb }
            goto L_0x00ef
        L_0x00eb:
            r0 = move-exception
            io.ktor.utils.io.core.CloseableJVMKt.a(r12, r0)     // Catch:{ all -> 0x00f0 }
        L_0x00ef:
            throw r12     // Catch:{ all -> 0x00f0 }
        L_0x00f0:
            r12 = move-exception
            throw r12     // Catch:{ all -> 0x005d }
        L_0x00f2:
            io.ktor.utils.io.ByteReadChannel r12 = r11.$this_copyToBoth     // Catch:{ all -> 0x005d }
            java.lang.Throwable r12 = r12.f()     // Catch:{ all -> 0x005d }
            if (r12 != 0) goto L_0x0105
        L_0x00fa:
            io.ktor.utils.io.ByteWriteChannel r12 = r11.$first
            io.ktor.utils.io.ByteWriteChannelKt.a(r12)
            io.ktor.utils.io.ByteWriteChannel r11 = r11.$second
            io.ktor.utils.io.ByteWriteChannelKt.a(r11)
            goto L_0x0111
        L_0x0105:
            throw r12     // Catch:{ all -> 0x005d }
        L_0x0106:
            io.ktor.utils.io.ByteWriteChannel r0 = r11.$first     // Catch:{ all -> 0x0114 }
            r0.h(r12)     // Catch:{ all -> 0x0114 }
            io.ktor.utils.io.ByteWriteChannel r0 = r11.$second     // Catch:{ all -> 0x0114 }
            r0.h(r12)     // Catch:{ all -> 0x0114 }
            goto L_0x00fa
        L_0x0111:
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        L_0x0114:
            r12 = move-exception
            io.ktor.utils.io.ByteWriteChannel r0 = r11.$first
            io.ktor.utils.io.ByteWriteChannelKt.a(r0)
            io.ktor.utils.io.ByteWriteChannel r11 = r11.$second
            io.ktor.utils.io.ByteWriteChannelKt.a(r11)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.util.ByteChannelsKt$copyToBoth$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((ByteChannelsKt$copyToBoth$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
