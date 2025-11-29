package com.upuphone.ar.transcribe.asr;

import android.content.Context;
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
@DebugMetadata(c = "com.upuphone.ar.transcribe.asr.AbsAsrImpl$loadAudioMuteData$1", f = "AbsAsrImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class AbsAsrImpl$loadAudioMuteData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    int label;
    final /* synthetic */ AbsAsrImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AbsAsrImpl$loadAudioMuteData$1(Context context, AbsAsrImpl absAsrImpl, Continuation<? super AbsAsrImpl$loadAudioMuteData$1> continuation) {
        super(2, continuation);
        this.$context = context;
        this.this$0 = absAsrImpl;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new AbsAsrImpl$loadAudioMuteData$1(this.$context, this.this$0, continuation);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x007d, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x007e, code lost:
        kotlin.io.CloseableKt.closeFinally(r1, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0081, code lost:
        throw r3;
     */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r3) {
        /*
            r2 = this;
            kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r0 = r2.label
            if (r0 != 0) goto L_0x0082
            kotlin.ResultKt.throwOnFailure(r3)
            android.content.Context r3 = r2.$context
            android.content.res.AssetManager r3 = r3.getAssets()
            java.lang.String r0 = "base64_mute_audio_data"
            java.io.InputStream r3 = r3.open(r0)
            java.lang.String r0 = "open(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r0)
            java.nio.charset.Charset r0 = kotlin.text.Charsets.UTF_8
            java.io.InputStreamReader r1 = new java.io.InputStreamReader
            r1.<init>(r3, r0)
            boolean r3 = r1 instanceof java.io.BufferedReader
            if (r3 == 0) goto L_0x0029
            java.io.BufferedReader r1 = (java.io.BufferedReader) r1
            goto L_0x0031
        L_0x0029:
            java.io.BufferedReader r3 = new java.io.BufferedReader
            r0 = 8192(0x2000, float:1.14794E-41)
            r3.<init>(r1, r0)
            r1 = r3
        L_0x0031:
            java.lang.String r3 = kotlin.io.TextStreamsKt.readText(r1)     // Catch:{ all -> 0x007b }
            r0 = 0
            kotlin.io.CloseableKt.closeFinally(r1, r0)
            com.upuphone.ar.transcribe.asr.AbsAsrImpl r0 = r2.this$0
            byte[] r3 = r0.c(r3)
            r0.o(r3)
            com.upuphone.ar.transcribe.asr.AbsAsrImpl r3 = r2.this$0
            byte[] r3 = r3.e()
            int r3 = r3.length
            com.upuphone.ar.transcribe.asr.AbsAsrImpl r2 = r2.this$0
            byte[] r2 = r2.e()
            java.lang.String r2 = java.util.Arrays.toString(r2)
            java.lang.String r0 = "toString(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "加载静音数据 "
            r0.append(r1)
            r0.append(r3)
            java.lang.String r3 = ", "
            r0.append(r3)
            r0.append(r2)
            java.lang.String r2 = r0.toString()
            java.lang.String r3 = "AbsAsrImpl"
            com.upuphone.ar.transcribe.ext.LogExt.g(r2, r3)
            kotlin.Unit r2 = kotlin.Unit.INSTANCE
            return r2
        L_0x007b:
            r2 = move-exception
            throw r2     // Catch:{ all -> 0x007d }
        L_0x007d:
            r3 = move-exception
            kotlin.io.CloseableKt.closeFinally(r1, r2)
            throw r3
        L_0x0082:
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
            java.lang.String r3 = "call to 'resume' before 'invoke' with coroutine"
            r2.<init>(r3)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.transcribe.asr.AbsAsrImpl$loadAudioMuteData$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((AbsAsrImpl$loadAudioMuteData$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
