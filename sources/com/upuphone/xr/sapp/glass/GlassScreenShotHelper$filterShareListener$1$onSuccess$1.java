package com.upuphone.xr.sapp.glass;

import android.net.Uri;
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
@DebugMetadata(c = "com.upuphone.xr.sapp.glass.GlassScreenShotHelper$filterShareListener$1$onSuccess$1", f = "GlassScreenShotHelper.kt", i = {}, l = {131, 133}, m = "invokeSuspend", n = {}, s = {})
public final class GlassScreenShotHelper$filterShareListener$1$onSuccess$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Uri $receiveUri;
    final /* synthetic */ String $taskId;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GlassScreenShotHelper$filterShareListener$1$onSuccess$1(Uri uri, String str, Continuation<? super GlassScreenShotHelper$filterShareListener$1$onSuccess$1> continuation) {
        super(2, continuation);
        this.$receiveUri = uri;
        this.$taskId = str;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new GlassScreenShotHelper$filterShareListener$1$onSuccess$1(this.$receiveUri, this.$taskId, continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00a9  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r8) {
        /*
            r7 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r7.label
            r2 = 2
            java.lang.String r3 = "GlassScreenShotHelper"
            r4 = 1
            if (r1 == 0) goto L_0x0022
            if (r1 == r4) goto L_0x001e
            if (r1 != r2) goto L_0x0016
            kotlin.ResultKt.throwOnFailure(r8)     // Catch:{ Exception -> 0x0014 }
            goto L_0x0072
        L_0x0014:
            r8 = move-exception
            goto L_0x0075
        L_0x0016:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x001e:
            kotlin.ResultKt.throwOnFailure(r8)     // Catch:{ Exception -> 0x0014 }
            goto L_0x0062
        L_0x0022:
            kotlin.ResultKt.throwOnFailure(r8)
            com.upuphone.star.core.log.ULog$Delegate r8 = com.upuphone.star.core.log.ULog.f6446a
            android.net.Uri r1 = r7.$receiveUri
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "saveToAlbum, start, receiveUri: "
            r5.append(r6)
            r5.append(r1)
            java.lang.String r1 = r5.toString()
            r8.a(r3, r1)
            com.upuphone.xr.sapp.utils.DynamicAdapterUtils r8 = com.upuphone.xr.sapp.utils.DynamicAdapterUtils.f7879a     // Catch:{ Exception -> 0x0014 }
            java.lang.String r8 = r8.a()     // Catch:{ Exception -> 0x0014 }
            boolean r8 = com.upuphone.xr.sapp.utils.ModelIdExtKt.a(r8)     // Catch:{ Exception -> 0x0014 }
            if (r8 == 0) goto L_0x0065
            com.upuphone.xr.sapp.glass.GlassScreenShotHelper r8 = com.upuphone.xr.sapp.glass.GlassScreenShotHelper.b     // Catch:{ Exception -> 0x0014 }
            android.net.Uri r1 = r7.$receiveUri     // Catch:{ Exception -> 0x0014 }
            java.lang.Boolean r2 = com.upuphone.xr.sapp.glass.GlassScreenShotHelper.e     // Catch:{ Exception -> 0x0014 }
            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r4)     // Catch:{ Exception -> 0x0014 }
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r5)     // Catch:{ Exception -> 0x0014 }
            r7.label = r4     // Catch:{ Exception -> 0x0014 }
            java.lang.Object r8 = r8.K(r1, r2, r7)     // Catch:{ Exception -> 0x0014 }
            if (r8 != r0) goto L_0x0062
            return r0
        L_0x0062:
            android.net.Uri r8 = (android.net.Uri) r8     // Catch:{ Exception -> 0x0014 }
            goto L_0x008c
        L_0x0065:
            com.upuphone.xr.sapp.glass.GlassScreenShotHelper r8 = com.upuphone.xr.sapp.glass.GlassScreenShotHelper.b     // Catch:{ Exception -> 0x0014 }
            android.net.Uri r1 = r7.$receiveUri     // Catch:{ Exception -> 0x0014 }
            r7.label = r2     // Catch:{ Exception -> 0x0014 }
            java.lang.Object r8 = r8.L(r1, r7)     // Catch:{ Exception -> 0x0014 }
            if (r8 != r0) goto L_0x0072
            return r0
        L_0x0072:
            android.net.Uri r8 = (android.net.Uri) r8     // Catch:{ Exception -> 0x0014 }
            goto L_0x008c
        L_0x0075:
            com.upuphone.star.core.log.ULog$Delegate r0 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "saveToAlbum, error: "
            r1.append(r2)
            r1.append(r8)
            java.lang.String r8 = r1.toString()
            r0.c(r3, r8)
            r8 = 0
        L_0x008c:
            com.upuphone.star.core.log.ULog$Delegate r0 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "saveToAlbum, result: "
            r1.append(r2)
            r1.append(r8)
            java.lang.String r1 = r1.toString()
            r0.a(r3, r1)
            com.upuphone.xr.sapp.glass.GlassScreenShotHelper.c = r8
            if (r8 == 0) goto L_0x00a9
            r8 = 0
            goto L_0x00ab
        L_0x00a9:
            r8 = 999(0x3e7, float:1.4E-42)
        L_0x00ab:
            com.upuphone.xr.sapp.glass.GlassScreenShotHelper r0 = com.upuphone.xr.sapp.glass.GlassScreenShotHelper.b
            java.lang.String r7 = r7.$taskId
            r0.H(r7, r8)
            com.upuphone.xr.sapp.glass.GlassMessageHelper r7 = com.upuphone.xr.sapp.glass.GlassMessageHelper.f7054a
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>()
            java.lang.String r1 = "code"
            r0.put(r1, r8)
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            java.lang.String r8 = r0.toString()
            java.lang.String r0 = "screenshot"
            java.lang.String r1 = "show_screenshot_save_result"
            r7.h(r0, r1, r8)
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.glass.GlassScreenShotHelper$filterShareListener$1$onSuccess$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((GlassScreenShotHelper$filterShareListener$1$onSuccess$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
