package com.upuphone.ar.translation.phone.helper;

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
@DebugMetadata(c = "com.upuphone.ar.translation.phone.helper.TranslationAsrHelper$loadAudioMuteData$1", f = "TranslationAsrHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class TranslationAsrHelper$loadAudioMuteData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TranslationAsrHelper$loadAudioMuteData$1(Context context, Continuation<? super TranslationAsrHelper$loadAudioMuteData$1> continuation) {
        super(2, continuation);
        this.$context = context;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new TranslationAsrHelper$loadAudioMuteData$1(this.$context, continuation);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0079, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x007a, code lost:
        kotlin.io.CloseableKt.closeFinally(r0, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x007d, code lost:
        throw r3;
     */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r3) {
        /*
            r2 = this;
            kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r0 = r2.label
            if (r0 != 0) goto L_0x007e
            kotlin.ResultKt.throwOnFailure(r3)
            android.content.Context r2 = r2.$context
            android.content.res.AssetManager r2 = r2.getAssets()
            java.lang.String r3 = "base64_mute_audio_data"
            java.io.InputStream r2 = r2.open(r3)
            java.lang.String r3 = "open(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            java.nio.charset.Charset r3 = kotlin.text.Charsets.UTF_8
            java.io.InputStreamReader r0 = new java.io.InputStreamReader
            r0.<init>(r2, r3)
            boolean r2 = r0 instanceof java.io.BufferedReader
            if (r2 == 0) goto L_0x0029
            java.io.BufferedReader r0 = (java.io.BufferedReader) r0
            goto L_0x0031
        L_0x0029:
            java.io.BufferedReader r2 = new java.io.BufferedReader
            r3 = 8192(0x2000, float:1.14794E-41)
            r2.<init>(r0, r3)
            r0 = r2
        L_0x0031:
            java.lang.String r2 = kotlin.io.TextStreamsKt.readText(r0)     // Catch:{ all -> 0x0077 }
            r3 = 0
            kotlin.io.CloseableKt.closeFinally(r0, r3)
            com.upuphone.ar.translation.phone.helper.TranslationAsrHelper r3 = com.upuphone.ar.translation.phone.helper.TranslationAsrHelper.f6306a
            byte[] r2 = r3.e(r2)
            com.upuphone.ar.translation.phone.helper.TranslationAsrHelper.b = r2
            byte[] r2 = com.upuphone.ar.translation.phone.helper.TranslationAsrHelper.b
            int r2 = r2.length
            byte[] r3 = com.upuphone.ar.translation.phone.helper.TranslationAsrHelper.b
            java.lang.String r3 = java.util.Arrays.toString(r3)
            java.lang.String r0 = "toString(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "加载静音数据 "
            r0.append(r1)
            r0.append(r2)
            java.lang.String r2 = ", "
            r0.append(r2)
            r0.append(r3)
            java.lang.String r2 = r0.toString()
            java.lang.String r3 = "TranslationAsrHelper"
            com.upuphone.ar.translation.ext.LogExt.j(r2, r3)
            kotlin.Unit r2 = kotlin.Unit.INSTANCE
            return r2
        L_0x0077:
            r2 = move-exception
            throw r2     // Catch:{ all -> 0x0079 }
        L_0x0079:
            r3 = move-exception
            kotlin.io.CloseableKt.closeFinally(r0, r2)
            throw r3
        L_0x007e:
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
            java.lang.String r3 = "call to 'resume' before 'invoke' with coroutine"
            r2.<init>(r3)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.translation.phone.helper.TranslationAsrHelper$loadAudioMuteData$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((TranslationAsrHelper$loadAudioMuteData$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
