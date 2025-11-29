package com.upuphone.ar.translation.phone.helper;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.translation.phone.helper.TelephoneTransHelper$feedProximalAudio$1", f = "TelephoneTransHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class TelephoneTransHelper$feedProximalAudio$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ byte[] $bytes;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TelephoneTransHelper$feedProximalAudio$1(byte[] bArr, Continuation<? super TelephoneTransHelper$feedProximalAudio$1> continuation) {
        super(2, continuation);
        this.$bytes = bArr;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new TelephoneTransHelper$feedProximalAudio$1(this.$bytes, continuation);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0032, code lost:
        if (r8 == null) goto L_0x0034;
     */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r9) {
        /*
            r8 = this;
            kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r0 = r8.label
            if (r0 != 0) goto L_0x00a5
            kotlin.ResultKt.throwOnFailure(r9)
            com.upuphone.ar.translation.audio.debug.AudioDebugHelper r9 = com.upuphone.ar.translation.audio.debug.AudioDebugHelper.f6196a
            byte[] r0 = r8.$bytes
            java.lang.String r1 = "teleopus_proximal_audio_phone.pcm"
            r9.t(r0, r1)
            com.upuphone.ar.translation.phone.TranslationManager$Companion r9 = com.upuphone.ar.translation.phone.TranslationManager.q
            com.upuphone.ar.translation.phone.TranslationManager r9 = r9.a()
            com.upuphone.ar.translation.phone.helper.TranslatorOpusCodec r9 = r9.l()
            r0 = 0
            java.lang.String r1 = "copyOf(...)"
            if (r9 == 0) goto L_0x0034
            byte[] r8 = r8.$bytes
            int r2 = r8.length
            byte[] r8 = java.util.Arrays.copyOf(r8, r2)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r1)
            r2 = 60
            byte[] r8 = r9.a(r8, r2)
            if (r8 != 0) goto L_0x0036
        L_0x0034:
            byte[] r8 = new byte[r0]
        L_0x0036:
            com.upuphone.ar.translation.phone.helper.TelephoneTransHelper r9 = com.upuphone.ar.translation.phone.helper.TelephoneTransHelper.f6305a
            int r2 = r8.length
            byte[] r2 = java.util.Arrays.copyOf(r8, r2)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r1)
            r9.s(r2)
            byte[] r9 = com.upuphone.ar.translation.phone.helper.TelephoneTransHelper.f
            int r2 = r8.length
            byte[] r8 = java.util.Arrays.copyOf(r8, r2)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r1)
            byte[] r8 = kotlin.collections.ArraysKt.plus((byte[]) r9, (byte[]) r8)
            com.upuphone.ar.translation.phone.helper.TelephoneTransHelper.f = r8
        L_0x0056:
            byte[] r8 = com.upuphone.ar.translation.phone.helper.TelephoneTransHelper.f
            int r8 = r8.length
            r9 = 512(0x200, float:7.175E-43)
            if (r8 < r9) goto L_0x00a2
            byte[] r8 = com.upuphone.ar.translation.phone.helper.TelephoneTransHelper.f
            kotlin.ranges.IntRange r2 = kotlin.ranges.RangesKt.until((int) r0, (int) r9)
            byte[] r8 = kotlin.collections.ArraysKt.sliceArray((byte[]) r8, (kotlin.ranges.IntRange) r2)
            r6 = 4
            r7 = 0
            java.lang.String r2 = "发送佩戴者音频到算法"
            java.lang.String r3 = "TelephoneTransHelper"
            java.lang.String r4 = "feedRemoteAudio"
            r5 = 0
            com.upuphone.ar.translation.ext.LogExt.f(r2, r3, r4, r5, r6, r7)
            com.xjsd.ai.voice.VoiceAdapter r2 = com.upuphone.ar.translation.phone.helper.TelephoneTransHelper.n
            if (r2 == 0) goto L_0x008d
            int r3 = r8.length
            byte[] r8 = java.util.Arrays.copyOf(r8, r3)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r1)
            int r8 = r2.Feed(r8)
            kotlin.coroutines.jvm.internal.Boxing.boxInt(r8)
        L_0x008d:
            byte[] r8 = com.upuphone.ar.translation.phone.helper.TelephoneTransHelper.f
            byte[] r2 = com.upuphone.ar.translation.phone.helper.TelephoneTransHelper.f
            int r2 = r2.length
            kotlin.ranges.IntRange r9 = kotlin.ranges.RangesKt.until((int) r9, (int) r2)
            byte[] r8 = kotlin.collections.ArraysKt.sliceArray((byte[]) r8, (kotlin.ranges.IntRange) r9)
            com.upuphone.ar.translation.phone.helper.TelephoneTransHelper.f = r8
            goto L_0x0056
        L_0x00a2:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        L_0x00a5:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.translation.phone.helper.TelephoneTransHelper$feedProximalAudio$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((TelephoneTransHelper$feedProximalAudio$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
