package io.ktor.utils.io;

import io.ktor.utils.io.core.BytePacketBuilder;
import io.ktor.utils.io.core.StringsKt;
import io.ktor.utils.io.pool.ObjectPool;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001f\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0011\u0010\u0007\u001a\u00020\u0006*\u00020\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a\u001f\u0010\u000b\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\n\u001a\u00020\tH@ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a@\u0010\u0013\u001a\u00020\u0003*\u00020\u00002'\u0010\u0012\u001a#\b\u0001\u0012\u0004\u0012\u00020\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00100\r¢\u0006\u0002\b\u0011H@ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u0002\u0004\n\u0002\b\u0019¨\u0006\u0015"}, d2 = {"Lio/ktor/utils/io/ByteWriteChannel;", "", "src", "", "b", "(Lio/ktor/utils/io/ByteWriteChannel;[BLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "a", "(Lio/ktor/utils/io/ByteWriteChannel;)Z", "", "s", "d", "(Lio/ktor/utils/io/ByteWriteChannel;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/Function2;", "Lio/ktor/utils/io/core/BytePacketBuilder;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "builder", "c", "(Lio/ktor/utils/io/ByteWriteChannel;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-io"}, k = 2, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nByteWriteChannel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ByteWriteChannel.kt\nio/ktor/utils/io/ByteWriteChannelKt\n+ 2 Builder.kt\nio/ktor/utils/io/core/BuilderKt\n*L\n1#1,211:1\n12#2,11:212\n12#2,11:223\n12#2,11:234\n12#2,11:245\n*S KotlinDebug\n*F\n+ 1 ByteWriteChannel.kt\nio/ktor/utils/io/ByteWriteChannelKt\n*L\n171#1:212,11\n179#1:223,11\n198#1:234,11\n202#1:245,11\n*E\n"})
public final class ByteWriteChannelKt {
    public static final boolean a(ByteWriteChannel byteWriteChannel) {
        Intrinsics.checkNotNullParameter(byteWriteChannel, "<this>");
        return byteWriteChannel.h((Throwable) null);
    }

    public static final Object b(ByteWriteChannel byteWriteChannel, byte[] bArr, Continuation continuation) {
        Object I = byteWriteChannel.I(bArr, 0, bArr.length, continuation);
        return I == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? I : Unit.INSTANCE;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0069 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object c(io.ktor.utils.io.ByteWriteChannel r6, kotlin.jvm.functions.Function2 r7, kotlin.coroutines.Continuation r8) {
        /*
            boolean r0 = r8 instanceof io.ktor.utils.io.ByteWriteChannelKt$writePacketSuspend$1
            if (r0 == 0) goto L_0x0013
            r0 = r8
            io.ktor.utils.io.ByteWriteChannelKt$writePacketSuspend$1 r0 = (io.ktor.utils.io.ByteWriteChannelKt$writePacketSuspend$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            io.ktor.utils.io.ByteWriteChannelKt$writePacketSuspend$1 r0 = new io.ktor.utils.io.ByteWriteChannelKt$writePacketSuspend$1
            r0.<init>(r8)
        L_0x0018:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L_0x0043
            if (r2 == r4) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x006a
        L_0x002d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0035:
            java.lang.Object r6 = r0.L$1
            io.ktor.utils.io.ByteWriteChannel r6 = (io.ktor.utils.io.ByteWriteChannel) r6
            java.lang.Object r7 = r0.L$0
            io.ktor.utils.io.core.BytePacketBuilder r7 = (io.ktor.utils.io.core.BytePacketBuilder) r7
            kotlin.ResultKt.throwOnFailure(r8)     // Catch:{ all -> 0x0041 }
            goto L_0x0059
        L_0x0041:
            r6 = move-exception
            goto L_0x006f
        L_0x0043:
            kotlin.ResultKt.throwOnFailure(r8)
            io.ktor.utils.io.core.BytePacketBuilder r8 = new io.ktor.utils.io.core.BytePacketBuilder
            r8.<init>(r5, r4, r5)
            r0.L$0 = r8     // Catch:{ all -> 0x006d }
            r0.L$1 = r6     // Catch:{ all -> 0x006d }
            r0.label = r4     // Catch:{ all -> 0x006d }
            java.lang.Object r7 = r7.invoke(r8, r0)     // Catch:{ all -> 0x006d }
            if (r7 != r1) goto L_0x0058
            return r1
        L_0x0058:
            r7 = r8
        L_0x0059:
            io.ktor.utils.io.core.ByteReadPacket r7 = r7.F0()     // Catch:{ all -> 0x0041 }
            r0.L$0 = r5
            r0.L$1 = r5
            r0.label = r3
            java.lang.Object r6 = r6.w(r7, r0)
            if (r6 != r1) goto L_0x006a
            return r1
        L_0x006a:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        L_0x006d:
            r6 = move-exception
            r7 = r8
        L_0x006f:
            r7.release()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteWriteChannelKt.c(io.ktor.utils.io.ByteWriteChannel, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final Object d(ByteWriteChannel byteWriteChannel, String str, Continuation continuation) {
        BytePacketBuilder bytePacketBuilder = new BytePacketBuilder((ObjectPool) null, 1, (DefaultConstructorMarker) null);
        try {
            StringsKt.m(bytePacketBuilder, str, 0, 0, (Charset) null, 14, (Object) null);
            Object w = byteWriteChannel.w(bytePacketBuilder.F0(), continuation);
            return w == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? w : Unit.INSTANCE;
        } catch (Throwable th) {
            bytePacketBuilder.release();
            throw th;
        }
    }
}
