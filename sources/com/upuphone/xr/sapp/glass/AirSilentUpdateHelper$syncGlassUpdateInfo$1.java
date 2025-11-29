package com.upuphone.xr.sapp.glass;

import com.upuphone.star.fota.phone.GlassUpdateInfo;
import java.io.File;
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
@DebugMetadata(c = "com.upuphone.xr.sapp.glass.AirSilentUpdateHelper$syncGlassUpdateInfo$1", f = "AirSilentUpdateHelper.kt", i = {}, l = {152, 172}, m = "invokeSuspend", n = {}, s = {})
public final class AirSilentUpdateHelper$syncGlassUpdateInfo$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ File $downloadFile;
    final /* synthetic */ GlassUpdateInfo $glassUpdateInfo;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AirSilentUpdateHelper$syncGlassUpdateInfo$1(File file, GlassUpdateInfo glassUpdateInfo, Continuation<? super AirSilentUpdateHelper$syncGlassUpdateInfo$1> continuation) {
        super(2, continuation);
        this.$downloadFile = file;
        this.$glassUpdateInfo = glassUpdateInfo;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new AirSilentUpdateHelper$syncGlassUpdateInfo$1(this.$downloadFile, this.$glassUpdateInfo, continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x006d A[Catch:{ Exception -> 0x0013 }, RETURN] */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r12) {
        /*
            r11 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r11.label
            r2 = 0
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L_0x0021
            if (r1 == r4) goto L_0x001d
            if (r1 != r3) goto L_0x0015
            kotlin.ResultKt.throwOnFailure(r12)     // Catch:{ Exception -> 0x0013 }
            goto L_0x006e
        L_0x0013:
            r11 = move-exception
            goto L_0x0071
        L_0x0015:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L_0x001d:
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x0043
        L_0x0021:
            kotlin.ResultKt.throwOnFailure(r12)
            com.upuphone.xr.sapp.glass.AirSilentUpdateHelper r12 = com.upuphone.xr.sapp.glass.AirSilentUpdateHelper.b
            java.lang.String r1 = "syncGlassUpdateInfo, start"
            r12.t(r1)
            java.io.File r12 = r11.$downloadFile
            if (r12 == 0) goto L_0x0046
            kotlinx.coroutines.CoroutineDispatcher r12 = kotlinx.coroutines.Dispatchers.b()
            com.upuphone.xr.sapp.glass.AirSilentUpdateHelper$syncGlassUpdateInfo$1$fileInfo$1 r1 = new com.upuphone.xr.sapp.glass.AirSilentUpdateHelper$syncGlassUpdateInfo$1$fileInfo$1
            java.io.File r5 = r11.$downloadFile
            r1.<init>(r5, r2)
            r11.label = r4
            java.lang.Object r12 = kotlinx.coroutines.BuildersKt.g(r12, r1, r11)
            if (r12 != r0) goto L_0x0043
            return r0
        L_0x0043:
            java.util.List r12 = (java.util.List) r12
            goto L_0x004a
        L_0x0046:
            java.util.List r12 = kotlin.collections.CollectionsKt.emptyList()
        L_0x004a:
            com.upuphone.xr.sapp.entity.AirSilentUpdateInfo r5 = new com.upuphone.xr.sapp.entity.AirSilentUpdateInfo
            com.upuphone.star.fota.phone.GlassUpdateInfo r1 = r11.$glassUpdateInfo
            boolean r1 = r1.getExistsUpdate()
            com.upuphone.star.fota.phone.GlassUpdateInfo r4 = r11.$glassUpdateInfo
            java.lang.String r4 = r4.getDigest()
            r5.<init>(r1, r4, r12)
            com.upuphone.xr.sapp.glass.AirSilentUpdateHelper.f = r5
            com.upuphone.xr.sapp.air.AirHelper r4 = com.upuphone.xr.sapp.air.AirHelper.b     // Catch:{ Exception -> 0x0013 }
            r11.label = r3     // Catch:{ Exception -> 0x0013 }
            r6 = 0
            r9 = 2
            r10 = 0
            r8 = r11
            java.lang.Object r11 = com.upuphone.xr.sapp.air.AirHelper.c0(r4, r5, r6, r8, r9, r10)     // Catch:{ Exception -> 0x0013 }
            if (r11 != r0) goto L_0x006e
            return r0
        L_0x006e:
            kotlin.Unit r2 = kotlin.Unit.INSTANCE     // Catch:{ Exception -> 0x0013 }
            goto L_0x0087
        L_0x0071:
            com.upuphone.xr.sapp.glass.AirSilentUpdateHelper r12 = com.upuphone.xr.sapp.glass.AirSilentUpdateHelper.b
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "syncGlassUpdateInfo, error: "
            r0.append(r1)
            r0.append(r11)
            java.lang.String r11 = r0.toString()
            r12.v(r11)
        L_0x0087:
            com.upuphone.xr.sapp.glass.AirSilentUpdateHelper r11 = com.upuphone.xr.sapp.glass.AirSilentUpdateHelper.b
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r0 = "syncGlassUpdateInfo, result: "
            r12.append(r0)
            r12.append(r2)
            java.lang.String r12 = r12.toString()
            r11.t(r12)
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.glass.AirSilentUpdateHelper$syncGlassUpdateInfo$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((AirSilentUpdateHelper$syncGlassUpdateInfo$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
