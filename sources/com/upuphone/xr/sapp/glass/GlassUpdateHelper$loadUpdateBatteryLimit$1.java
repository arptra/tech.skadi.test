package com.upuphone.xr.sapp.glass;

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
@DebugMetadata(c = "com.upuphone.xr.sapp.glass.GlassUpdateHelper$loadUpdateBatteryLimit$1", f = "GlassUpdateHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class GlassUpdateHelper$loadUpdateBatteryLimit$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    public GlassUpdateHelper$loadUpdateBatteryLimit$1(Continuation<? super GlassUpdateHelper$loadUpdateBatteryLimit$1> continuation) {
        super(2, continuation);
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new GlassUpdateHelper$loadUpdateBatteryLimit$1(continuation);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00a4, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r1, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00a8, code lost:
        throw r4;
     */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r4) {
        /*
            r3 = this;
            kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r3.label
            if (r3 != 0) goto L_0x00c2
            kotlin.ResultKt.throwOnFailure(r4)
            android.content.Context r3 = com.upuphone.xr.sapp.utils.GlobalExtKt.f()     // Catch:{ all -> 0x001e }
            r4 = 0
            java.io.File r3 = r3.getExternalFilesDir(r4)     // Catch:{ all -> 0x001e }
            if (r3 != 0) goto L_0x0021
            android.content.Context r3 = com.upuphone.xr.sapp.utils.GlobalExtKt.f()     // Catch:{ all -> 0x001e }
            java.io.File r3 = r3.getFilesDir()     // Catch:{ all -> 0x001e }
            goto L_0x0021
        L_0x001e:
            r3 = move-exception
            goto L_0x00a9
        L_0x0021:
            java.io.File r0 = new java.io.File     // Catch:{ all -> 0x001e }
            java.lang.String r1 = "glass_ota_battery_limit"
            r0.<init>(r3, r1)     // Catch:{ all -> 0x001e }
            boolean r3 = r0.exists()     // Catch:{ all -> 0x001e }
            if (r3 != 0) goto L_0x0047
            com.upuphone.xr.sapp.glass.GlassUpdateHelper r3 = com.upuphone.xr.sapp.glass.GlassUpdateHelper.b     // Catch:{ all -> 0x001e }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x001e }
            r4.<init>()     // Catch:{ all -> 0x001e }
            java.lang.String r1 = "loadUpdateBatteryLimit, file not exist: "
            r4.append(r1)     // Catch:{ all -> 0x001e }
            r4.append(r0)     // Catch:{ all -> 0x001e }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x001e }
            r3.d1(r4)     // Catch:{ all -> 0x001e }
            kotlin.Unit r3 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x001e }
            return r3
        L_0x0047:
            java.nio.charset.Charset r3 = kotlin.text.Charsets.UTF_8     // Catch:{ all -> 0x001e }
            java.io.InputStreamReader r1 = new java.io.InputStreamReader     // Catch:{ all -> 0x001e }
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ all -> 0x001e }
            r2.<init>(r0)     // Catch:{ all -> 0x001e }
            r1.<init>(r2, r3)     // Catch:{ all -> 0x001e }
            boolean r3 = r1 instanceof java.io.BufferedReader     // Catch:{ all -> 0x001e }
            if (r3 == 0) goto L_0x005a
            java.io.BufferedReader r1 = (java.io.BufferedReader) r1     // Catch:{ all -> 0x001e }
            goto L_0x0062
        L_0x005a:
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch:{ all -> 0x001e }
            r0 = 8192(0x2000, float:1.14794E-41)
            r3.<init>(r1, r0)     // Catch:{ all -> 0x001e }
            r1 = r3
        L_0x0062:
            java.lang.String r3 = r1.readLine()     // Catch:{ all -> 0x00a2 }
            kotlin.io.CloseableKt.closeFinally(r1, r4)     // Catch:{ all -> 0x001e }
            com.upuphone.xr.sapp.glass.GlassUpdateHelper r4 = com.upuphone.xr.sapp.glass.GlassUpdateHelper.b     // Catch:{ all -> 0x001e }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x001e }
            r0.<init>()     // Catch:{ all -> 0x001e }
            java.lang.String r1 = "loadUpdateBatteryLimit, text: "
            r0.append(r1)     // Catch:{ all -> 0x001e }
            r0.append(r3)     // Catch:{ all -> 0x001e }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x001e }
            r4.d1(r0)     // Catch:{ all -> 0x001e }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3)     // Catch:{ all -> 0x001e }
            java.lang.Integer r3 = kotlin.text.StringsKt.toIntOrNull(r3)     // Catch:{ all -> 0x001e }
            com.upuphone.xr.sapp.glass.GlassUpdateHelper.v = r3     // Catch:{ all -> 0x001e }
            java.lang.Integer r3 = com.upuphone.xr.sapp.glass.GlassUpdateHelper.v     // Catch:{ all -> 0x001e }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x001e }
            r0.<init>()     // Catch:{ all -> 0x001e }
            java.lang.String r1 = "loadUpdateBatteryLimit, battery: "
            r0.append(r1)     // Catch:{ all -> 0x001e }
            r0.append(r3)     // Catch:{ all -> 0x001e }
            java.lang.String r3 = r0.toString()     // Catch:{ all -> 0x001e }
            r4.d1(r3)     // Catch:{ all -> 0x001e }
            goto L_0x00bf
        L_0x00a2:
            r3 = move-exception
            throw r3     // Catch:{ all -> 0x00a4 }
        L_0x00a4:
            r4 = move-exception
            kotlin.io.CloseableKt.closeFinally(r1, r3)     // Catch:{ all -> 0x001e }
            throw r4     // Catch:{ all -> 0x001e }
        L_0x00a9:
            com.upuphone.xr.sapp.glass.GlassUpdateHelper r4 = com.upuphone.xr.sapp.glass.GlassUpdateHelper.b
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "loadUpdateBatteryLimit, error: "
            r0.append(r1)
            r0.append(r3)
            java.lang.String r3 = r0.toString()
            r4.e1(r3)
        L_0x00bf:
            kotlin.Unit r3 = kotlin.Unit.INSTANCE
            return r3
        L_0x00c2:
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
            java.lang.String r4 = "call to 'resume' before 'invoke' with coroutine"
            r3.<init>(r4)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.glass.GlassUpdateHelper$loadUpdateBatteryLimit$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((GlassUpdateHelper$loadUpdateBatteryLimit$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
