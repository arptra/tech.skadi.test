package io.ktor.util;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.util.NonceKt$nonceGeneratorJob$1", f = "Nonce.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0}, l = {76}, m = "invokeSuspend", n = {"seedChannel", "previousRoundNonceList", "secureInstance", "weakRandom", "secureBytes", "weakBytes", "randomNonceList", "lastReseed", "index"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "J$0", "I$0"})
public final class NonceKt$nonceGeneratorJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int I$0;
    int I$1;
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    int label;

    public NonceKt$nonceGeneratorJob$1(Continuation<? super NonceKt$nonceGeneratorJob$1> continuation) {
        super(2, continuation);
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new NonceKt$nonceGeneratorJob$1(continuation);
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x007e A[Catch:{ all -> 0x0040, all -> 0x0121 }, LOOP:0: B:13:0x007c->B:14:0x007e, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0093 A[Catch:{ all -> 0x0040, all -> 0x0121 }] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x00a1 A[Catch:{ all -> 0x0040, all -> 0x0121 }] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00d3 A[Catch:{ all -> 0x0040, all -> 0x0121 }] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00f3 A[Catch:{ all -> 0x0040, all -> 0x0121 }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00f6 A[Catch:{ all -> 0x0040, all -> 0x0121 }] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0105 A[Catch:{ all -> 0x0040, all -> 0x0121 }] */
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r24) {
        /*
            r23 = this;
            r0 = r23
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x004b
            if (r2 != r3) goto L_0x0043
            int r2 = r0.I$1
            int r4 = r0.I$0
            long r5 = r0.J$0
            java.lang.Object r7 = r0.L$6
            java.util.List r7 = (java.util.List) r7
            java.lang.Object r8 = r0.L$5
            byte[] r8 = (byte[]) r8
            java.lang.Object r9 = r0.L$4
            byte[] r9 = (byte[]) r9
            java.lang.Object r10 = r0.L$3
            java.security.SecureRandom r10 = (java.security.SecureRandom) r10
            java.lang.Object r11 = r0.L$2
            java.security.SecureRandom r11 = (java.security.SecureRandom) r11
            java.lang.Object r12 = r0.L$1
            java.util.ArrayList r12 = (java.util.ArrayList) r12
            java.lang.Object r13 = r0.L$0
            kotlinx.coroutines.channels.Channel r13 = (kotlinx.coroutines.channels.Channel) r13
            kotlin.ResultKt.throwOnFailure(r24)     // Catch:{ all -> 0x0040 }
            r20 = r8
            r8 = r7
            r7 = r10
            r10 = r20
            r21 = r5
            r6 = r11
            r5 = r12
            r11 = r21
            goto L_0x00f4
        L_0x0040:
            r0 = move-exception
            goto L_0x0117
        L_0x0043:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x004b:
            kotlin.ResultKt.throwOnFailure(r24)
            kotlinx.coroutines.channels.Channel r2 = io.ktor.util.NonceKt.e()
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            java.security.SecureRandom r5 = io.ktor.util.NonceKt.f()
            java.lang.String r6 = "SHA1PRNG"
            java.security.SecureRandom r6 = java.security.SecureRandom.getInstance(r6)
            r7 = 128(0x80, float:1.794E-43)
            byte[] r8 = new byte[r7]
            r9 = 512(0x200, float:7.175E-43)
            byte[] r9 = new byte[r9]
            byte[] r7 = r5.generateSeed(r7)
            r6.setSeed(r7)
            r10 = 0
            r13 = r2
        L_0x0073:
            r5.nextBytes(r8)     // Catch:{ all -> 0x0040 }
            r6.nextBytes(r9)     // Catch:{ all -> 0x0040 }
            int r2 = r8.length     // Catch:{ all -> 0x0040 }
            r7 = 0
            r12 = r7
        L_0x007c:
            if (r12 >= r2) goto L_0x0087
            int r14 = r12 * 4
            byte r15 = r8[r12]     // Catch:{ all -> 0x0040 }
            r9[r14] = r15     // Catch:{ all -> 0x0040 }
            int r12 = r12 + 1
            goto L_0x007c
        L_0x0087:
            long r14 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0040 }
            long r16 = r14 - r10
            r18 = 30000(0x7530, double:1.4822E-319)
            int r2 = (r16 > r18 ? 1 : (r16 == r18 ? 0 : -1))
            if (r2 <= 0) goto L_0x00a1
            long r10 = r10 - r14
            r6.setSeed(r10)     // Catch:{ all -> 0x0040 }
            int r2 = r8.length     // Catch:{ all -> 0x0040 }
            byte[] r2 = r5.generateSeed(r2)     // Catch:{ all -> 0x0040 }
            r6.setSeed(r2)     // Catch:{ all -> 0x0040 }
            r10 = r14
            goto L_0x00a4
        L_0x00a1:
            r6.setSeed(r8)     // Catch:{ all -> 0x0040 }
        L_0x00a4:
            java.lang.String r2 = io.ktor.util.CryptoKt.c(r9)     // Catch:{ all -> 0x0040 }
            r12 = 16
            java.util.List r2 = kotlin.text.StringsKt.chunked(r2, r12)     // Catch:{ all -> 0x0040 }
            java.util.List r2 = kotlin.collections.CollectionsKt.plus(r2, r4)     // Catch:{ all -> 0x0040 }
            java.lang.String r12 = "weakRandom"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r12)     // Catch:{ all -> 0x0040 }
            java.util.List r2 = kotlin.collections.CollectionsKt.shuffled(r2, r6)     // Catch:{ all -> 0x0040 }
            int r12 = r2.size()     // Catch:{ all -> 0x0040 }
            int r12 = r12 / 2
            r20 = r8
            r8 = r2
            r2 = r12
            r11 = r10
            r10 = r9
            r9 = r20
            r21 = r5
            r5 = r4
            r4 = r7
            r7 = r6
            r6 = r21
        L_0x00d1:
            if (r4 >= r2) goto L_0x00f6
            java.lang.Object r14 = r8.get(r4)     // Catch:{ all -> 0x0040 }
            r0.L$0 = r13     // Catch:{ all -> 0x0040 }
            r0.L$1 = r5     // Catch:{ all -> 0x0040 }
            r0.L$2 = r6     // Catch:{ all -> 0x0040 }
            r0.L$3 = r7     // Catch:{ all -> 0x0040 }
            r0.L$4 = r9     // Catch:{ all -> 0x0040 }
            r0.L$5 = r10     // Catch:{ all -> 0x0040 }
            r0.L$6 = r8     // Catch:{ all -> 0x0040 }
            r0.J$0 = r11     // Catch:{ all -> 0x0040 }
            r0.I$0 = r4     // Catch:{ all -> 0x0040 }
            r0.I$1 = r2     // Catch:{ all -> 0x0040 }
            r0.label = r3     // Catch:{ all -> 0x0040 }
            java.lang.Object r14 = r13.L(r14, r0)     // Catch:{ all -> 0x0040 }
            if (r14 != r1) goto L_0x00f4
            return r1
        L_0x00f4:
            int r4 = r4 + r3
            goto L_0x00d1
        L_0x00f6:
            r5.clear()     // Catch:{ all -> 0x0040 }
            int r2 = r8.size()     // Catch:{ all -> 0x0040 }
            int r2 = r2 / 2
            int r4 = r8.size()     // Catch:{ all -> 0x0040 }
        L_0x0103:
            if (r2 >= r4) goto L_0x010f
            java.lang.Object r14 = r8.get(r2)     // Catch:{ all -> 0x0040 }
            r5.add(r14)     // Catch:{ all -> 0x0040 }
            int r2 = r2 + 1
            goto L_0x0103
        L_0x010f:
            r4 = r5
            r5 = r6
            r6 = r7
            r8 = r9
            r9 = r10
            r10 = r11
            goto L_0x0073
        L_0x0117:
            r1 = 0
            r13.h(r0)     // Catch:{ all -> 0x0121 }
            kotlinx.coroutines.channels.SendChannel.DefaultImpls.a(r13, r1, r3, r1)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x0121:
            r0 = move-exception
            r2 = r0
            kotlinx.coroutines.channels.SendChannel.DefaultImpls.a(r13, r1, r3, r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.util.NonceKt$nonceGeneratorJob$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((NonceKt$nonceGeneratorJob$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
