package com.upuphone.ar.transcribe.utils;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.transcribe.utils.NetworkUtils$isInternetAvailable$2", f = "NetworkUtils.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class NetworkUtils$isInternetAvailable$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    int label;

    public NetworkUtils$isInternetAvailable$2(Continuation<? super NetworkUtils$isInternetAvailable$2> continuation) {
        super(2, continuation);
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new NetworkUtils$isInternetAvailable$2(continuation);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0050, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r2, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0054, code lost:
        throw r0;
     */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r3) {
        /*
            r2 = this;
            kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r2.label
            if (r2 != 0) goto L_0x005b
            kotlin.ResultKt.throwOnFailure(r3)
            okhttp3.OkHttpClient$Builder r2 = new okhttp3.OkHttpClient$Builder
            r2.<init>()
            java.util.concurrent.TimeUnit r3 = java.util.concurrent.TimeUnit.SECONDS
            r0 = 2
            okhttp3.OkHttpClient$Builder r2 = r2.connectTimeout(r0, r3)
            okhttp3.OkHttpClient$Builder r2 = r2.readTimeout(r0, r3)
            okhttp3.OkHttpClient r2 = r2.build()
            okhttp3.Request$Builder r3 = new okhttp3.Request$Builder
            r3.<init>()
            com.upuphone.ar.transcribe.constants.TranscribeConstants r0 = com.upuphone.ar.transcribe.constants.TranscribeConstants.f6027a
            boolean r0 = r0.m()
            if (r0 == 0) goto L_0x002f
            java.lang.String r0 = "https://www.google.com"
            goto L_0x0031
        L_0x002f:
            java.lang.String r0 = "https://www.baidu.com"
        L_0x0031:
            okhttp3.Request$Builder r3 = r3.url((java.lang.String) r0)
            okhttp3.Request r3 = r3.build()
            okhttp3.Call r2 = r2.newCall(r3)     // Catch:{ Exception -> 0x0055 }
            okhttp3.Response r2 = r2.execute()     // Catch:{ Exception -> 0x0055 }
            boolean r3 = r2.isSuccessful()     // Catch:{ all -> 0x004e }
            r0 = 0
            kotlin.io.CloseableKt.closeFinally(r2, r0)     // Catch:{ Exception -> 0x0055 }
            java.lang.Boolean r2 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)
            return r2
        L_0x004e:
            r3 = move-exception
            throw r3     // Catch:{ all -> 0x0050 }
        L_0x0050:
            r0 = move-exception
            kotlin.io.CloseableKt.closeFinally(r2, r3)     // Catch:{ Exception -> 0x0055 }
            throw r0     // Catch:{ Exception -> 0x0055 }
        L_0x0055:
            r2 = 0
            java.lang.Boolean r2 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r2)
            return r2
        L_0x005b:
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
            java.lang.String r3 = "call to 'resume' before 'invoke' with coroutine"
            r2.<init>(r3)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.transcribe.utils.NetworkUtils$isInternetAvailable$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Boolean> continuation) {
        return ((NetworkUtils$isInternetAvailable$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
