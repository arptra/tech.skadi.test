package io.ktor.utils.io;

import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u001aS\u0010\u000b\u001a\u00020\n*\u00020\u00002:\u0010\t\u001a6\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\u00060\u0001j\u0002`\bHHø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\f*j\u0010\r\"2\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\u00060\u000122\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\u00060\u0001\u0002\u0004\n\u0002\b\u0019¨\u0006\u000e"}, d2 = {"Lio/ktor/utils/io/ByteReadChannel;", "Lkotlin/Function2;", "Ljava/nio/ByteBuffer;", "Lkotlin/ParameterName;", "name", "buffer", "", "last", "Lio/ktor/utils/io/ConsumeEachBufferVisitor;", "visitor", "", "a", "(Lio/ktor/utils/io/ByteReadChannel;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ConsumeEachBufferVisitor", "ktor-io"}, k = 2, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nConsumeEach.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ConsumeEach.kt\nio/ktor/utils/io/ConsumeEachKt\n+ 2 ReadSession.kt\nio/ktor/utils/io/ReadSessionKt\n*L\n1#1,41:1\n20#2,13:42\n*S KotlinDebug\n*F\n+ 1 ConsumeEach.kt\nio/ktor/utils/io/ConsumeEachKt\n*L\n24#1:42,13\n*E\n"})
public final class ConsumeEachKt {
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00b2  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00bb  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00d4 A[Catch:{ all -> 0x00da }] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00dd A[Catch:{ all -> 0x00da }] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00f3 A[Catch:{ all -> 0x00da }] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00f5 A[Catch:{ all -> 0x00da }] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0123  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0135  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0138  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0151 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0029  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object a(io.ktor.utils.io.ByteReadChannel r18, kotlin.jvm.functions.Function2 r19, kotlin.coroutines.Continuation r20) {
        /*
            r0 = r20
            boolean r1 = r0 instanceof io.ktor.utils.io.ConsumeEachKt$consumeEachBufferRange$1
            if (r1 == 0) goto L_0x0015
            r1 = r0
            io.ktor.utils.io.ConsumeEachKt$consumeEachBufferRange$1 r1 = (io.ktor.utils.io.ConsumeEachKt$consumeEachBufferRange$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L_0x0015
            int r2 = r2 - r3
            r1.label = r2
            goto L_0x001a
        L_0x0015:
            io.ktor.utils.io.ConsumeEachKt$consumeEachBufferRange$1 r1 = new io.ktor.utils.io.ConsumeEachKt$consumeEachBufferRange$1
            r1.<init>(r0)
        L_0x001a:
            java.lang.Object r0 = r1.result
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r1.label
            r4 = 3
            r5 = 2
            r6 = 0
            r7 = 1
            r8 = 0
            if (r3 == 0) goto L_0x0087
            if (r3 == r7) goto L_0x0069
            if (r3 == r5) goto L_0x0040
            if (r3 == r4) goto L_0x0037
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0037:
            java.lang.Object r1 = r1.L$0
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            kotlin.ResultKt.throwOnFailure(r0)
            goto L_0x0152
        L_0x0040:
            java.lang.Object r3 = r1.L$5
            io.ktor.utils.io.core.Buffer r3 = (io.ktor.utils.io.core.Buffer) r3
            java.lang.Object r9 = r1.L$4
            io.ktor.utils.io.ByteReadChannel r9 = (io.ktor.utils.io.ByteReadChannel) r9
            java.lang.Object r10 = r1.L$3
            kotlin.jvm.internal.Ref$BooleanRef r10 = (kotlin.jvm.internal.Ref.BooleanRef) r10
            java.lang.Object r11 = r1.L$2
            kotlin.jvm.internal.Ref$BooleanRef r11 = (kotlin.jvm.internal.Ref.BooleanRef) r11
            java.lang.Object r12 = r1.L$1
            kotlin.jvm.functions.Function2 r12 = (kotlin.jvm.functions.Function2) r12
            java.lang.Object r13 = r1.L$0
            io.ktor.utils.io.ByteReadChannel r13 = (io.ktor.utils.io.ByteReadChannel) r13
            kotlin.ResultKt.throwOnFailure(r0)     // Catch:{ all -> 0x0061 }
            r9 = r1
            r3 = r11
            r1 = r12
            r0 = r13
            goto L_0x0126
        L_0x0061:
            r0 = move-exception
        L_0x0062:
            r17 = r1
            r1 = r0
            r0 = r17
            goto L_0x013c
        L_0x0069:
            java.lang.Object r3 = r1.L$4
            io.ktor.utils.io.ByteReadChannel r3 = (io.ktor.utils.io.ByteReadChannel) r3
            java.lang.Object r9 = r1.L$3
            kotlin.jvm.internal.Ref$BooleanRef r9 = (kotlin.jvm.internal.Ref.BooleanRef) r9
            java.lang.Object r10 = r1.L$2
            kotlin.jvm.internal.Ref$BooleanRef r10 = (kotlin.jvm.internal.Ref.BooleanRef) r10
            java.lang.Object r11 = r1.L$1
            kotlin.jvm.functions.Function2 r11 = (kotlin.jvm.functions.Function2) r11
            java.lang.Object r12 = r1.L$0
            io.ktor.utils.io.ByteReadChannel r12 = (io.ktor.utils.io.ByteReadChannel) r12
            kotlin.ResultKt.throwOnFailure(r0)
            r17 = r9
            r9 = r3
            r3 = r10
            r10 = r17
            goto L_0x00b7
        L_0x0087:
            kotlin.ResultKt.throwOnFailure(r0)
            kotlin.jvm.internal.Ref$BooleanRef r0 = new kotlin.jvm.internal.Ref$BooleanRef
            r0.<init>()
            kotlin.jvm.internal.Ref$BooleanRef r3 = new kotlin.jvm.internal.Ref$BooleanRef
            r3.<init>()
            r9 = r1
            r10 = r3
            r1 = r19
            r3 = r0
            r0 = r18
        L_0x009b:
            r3.element = r6
            r9.L$0 = r0
            r9.L$1 = r1
            r9.L$2 = r3
            r9.L$3 = r10
            r9.L$4 = r0
            r9.L$5 = r8
            r9.label = r7
            java.lang.Object r11 = io.ktor.utils.io.ReadSessionKt.f(r0, r7, r9)
            if (r11 != r2) goto L_0x00b2
            return r2
        L_0x00b2:
            r12 = r0
            r0 = r11
            r11 = r1
            r1 = r9
            r9 = r12
        L_0x00b7:
            io.ktor.utils.io.core.Buffer r0 = (io.ktor.utils.io.core.Buffer) r0
            if (r0 != 0) goto L_0x00c1
            io.ktor.utils.io.core.Buffer$Companion r0 = io.ktor.utils.io.core.Buffer.g
            io.ktor.utils.io.core.Buffer r0 = r0.a()
        L_0x00c1:
            r13 = r0
            java.nio.ByteBuffer r0 = r13.h()     // Catch:{ all -> 0x00da }
            int r14 = r13.i()     // Catch:{ all -> 0x00da }
            long r14 = (long) r14     // Catch:{ all -> 0x00da }
            int r7 = r13.k()     // Catch:{ all -> 0x00da }
            long r6 = (long) r7     // Catch:{ all -> 0x00da }
            int r16 = (r6 > r14 ? 1 : (r6 == r14 ? 0 : -1))
            if (r16 <= 0) goto L_0x00dd
            long r6 = r6 - r14
            java.nio.ByteBuffer r0 = io.ktor.utils.io.bits.Memory.i(r0, r14, r6)     // Catch:{ all -> 0x00da }
            goto L_0x00e3
        L_0x00da:
            r0 = move-exception
            r3 = r13
            goto L_0x0062
        L_0x00dd:
            io.ktor.utils.io.bits.Memory$Companion r0 = io.ktor.utils.io.bits.Memory.b     // Catch:{ all -> 0x00da }
            java.nio.ByteBuffer r0 = r0.a()     // Catch:{ all -> 0x00da }
        L_0x00e3:
            int r6 = r0.remaining()     // Catch:{ all -> 0x00da }
            int r7 = r12.i()     // Catch:{ all -> 0x00da }
            if (r6 != r7) goto L_0x00f5
            boolean r6 = r12.g()     // Catch:{ all -> 0x00da }
            if (r6 == 0) goto L_0x00f5
            r6 = 1
            goto L_0x00f6
        L_0x00f5:
            r6 = 0
        L_0x00f6:
            r10.element = r6     // Catch:{ all -> 0x00da }
            java.lang.Boolean r6 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r6)     // Catch:{ all -> 0x00da }
            java.lang.Object r6 = r11.invoke(r0, r6)     // Catch:{ all -> 0x00da }
            java.lang.Boolean r6 = (java.lang.Boolean) r6     // Catch:{ all -> 0x00da }
            boolean r6 = r6.booleanValue()     // Catch:{ all -> 0x00da }
            r3.element = r6     // Catch:{ all -> 0x00da }
            int r0 = r0.position()     // Catch:{ all -> 0x00da }
            r1.L$0 = r12     // Catch:{ all -> 0x00da }
            r1.L$1 = r11     // Catch:{ all -> 0x00da }
            r1.L$2 = r3     // Catch:{ all -> 0x00da }
            r1.L$3 = r10     // Catch:{ all -> 0x00da }
            r1.L$4 = r9     // Catch:{ all -> 0x00da }
            r1.L$5 = r13     // Catch:{ all -> 0x00da }
            r1.I$0 = r0     // Catch:{ all -> 0x00da }
            r1.label = r5     // Catch:{ all -> 0x00da }
            java.lang.Object r0 = io.ktor.utils.io.ReadSessionKt.c(r9, r13, r0, r1)     // Catch:{ all -> 0x00da }
            if (r0 != r2) goto L_0x0123
            return r2
        L_0x0123:
            r9 = r1
            r1 = r11
            r0 = r12
        L_0x0126:
            boolean r6 = r10.element
            if (r6 == 0) goto L_0x0131
            boolean r6 = r0.Q()
            if (r6 == 0) goto L_0x0131
            goto L_0x0135
        L_0x0131:
            boolean r6 = r3.element
            if (r6 != 0) goto L_0x0138
        L_0x0135:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x0138:
            r6 = 0
            r7 = 1
            goto L_0x009b
        L_0x013c:
            r0.L$0 = r1
            r0.L$1 = r8
            r0.L$2 = r8
            r0.L$3 = r8
            r0.L$4 = r8
            r0.L$5 = r8
            r0.label = r4
            r4 = 0
            java.lang.Object r0 = io.ktor.utils.io.ReadSessionKt.c(r9, r3, r4, r0)
            if (r0 != r2) goto L_0x0152
            return r2
        L_0x0152:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ConsumeEachKt.a(io.ktor.utils.io.ByteReadChannel, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
