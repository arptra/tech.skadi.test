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
@DebugMetadata(c = "com.upuphone.xr.sapp.glass.AirGlassUpdater$transferFileAndInstall$1", f = "AirGlassUpdater.kt", i = {0, 1}, l = {295, 324}, m = "invokeSuspend", n = {"uid", "uid"}, s = {"L$0", "L$0"})
public final class AirGlassUpdater$transferFileAndInstall$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ File $downloadFile;
    final /* synthetic */ GlassUpdateInfo $glassUpdateInfo;
    Object L$0;
    int label;
    final /* synthetic */ AirGlassUpdater this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AirGlassUpdater$transferFileAndInstall$1(AirGlassUpdater airGlassUpdater, GlassUpdateInfo glassUpdateInfo, File file, Continuation<? super AirGlassUpdater$transferFileAndInstall$1> continuation) {
        super(2, continuation);
        this.this$0 = airGlassUpdater;
        this.$glassUpdateInfo = glassUpdateInfo;
        this.$downloadFile = file;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new AirGlassUpdater$transferFileAndInstall$1(this.this$0, this.$glassUpdateInfo, this.$downloadFile, continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x00ec  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x011b  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r11) {
        /*
            r10 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r10.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x0029
            if (r1 == r3) goto L_0x0020
            if (r1 != r2) goto L_0x0018
            java.lang.Object r0 = r10.L$0
            java.lang.String r0 = (java.lang.String) r0
            kotlin.ResultKt.throwOnFailure(r11)
            r1 = r0
            goto L_0x00e4
        L_0x0018:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L_0x0020:
            java.lang.Object r1 = r10.L$0
            java.lang.String r1 = (java.lang.String) r1
            kotlin.ResultKt.throwOnFailure(r11)
            r4 = r1
            goto L_0x007e
        L_0x0029:
            kotlin.ResultKt.throwOnFailure(r11)
            java.util.UUID r11 = java.util.UUID.randomUUID()
            java.lang.String r11 = r11.toString()
            java.lang.String r1 = "toString(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r1)
            com.upuphone.xr.sapp.glass.AirGlassUpdater r1 = r10.this$0
            kotlin.jvm.functions.Function1 r1 = r1.H()
            com.upuphone.xr.sapp.entity.GlassUpdateState$AirTransferring r4 = new com.upuphone.xr.sapp.entity.GlassUpdateState$AirTransferring
            com.upuphone.star.fota.phone.GlassUpdateInfo r5 = r10.$glassUpdateInfo
            r4.<init>(r5, r11)
            r1.invoke(r4)
            com.upuphone.xr.sapp.glass.AirGlassUpdater$Companion r1 = com.upuphone.xr.sapp.glass.AirGlassUpdater.g
            java.io.File r4 = r10.$downloadFile
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "transferFileAndInstall, processUpdateFile: "
            r5.append(r6)
            r5.append(r4)
            java.lang.String r4 = r5.toString()
            r1.c(r4)
            kotlinx.coroutines.CoroutineDispatcher r1 = kotlinx.coroutines.Dispatchers.b()
            com.upuphone.xr.sapp.glass.AirGlassUpdater$transferFileAndInstall$1$fileInfo$1 r4 = new com.upuphone.xr.sapp.glass.AirGlassUpdater$transferFileAndInstall$1$fileInfo$1
            com.upuphone.xr.sapp.glass.AirGlassUpdater r5 = r10.this$0
            java.io.File r6 = r10.$downloadFile
            r7 = 0
            r4.<init>(r5, r6, r7)
            r10.L$0 = r11
            r10.label = r3
            java.lang.Object r1 = kotlinx.coroutines.BuildersKt.g(r1, r4, r10)
            if (r1 != r0) goto L_0x007c
            return r0
        L_0x007c:
            r4 = r11
            r11 = r1
        L_0x007e:
            java.util.List r11 = (java.util.List) r11
            com.upuphone.xr.sapp.glass.AirGlassUpdater$Companion r1 = com.upuphone.xr.sapp.glass.AirGlassUpdater.g
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r5 = "transferFileAndInstall, processUpdateFile fileInfo: "
            r3.append(r5)
            r3.append(r11)
            java.lang.String r3 = r3.toString()
            r1.c(r3)
            boolean r1 = r11.isEmpty()
            if (r1 == 0) goto L_0x00b7
            com.upuphone.xr.sapp.glass.AirGlassUpdater r11 = r10.this$0
            kotlin.jvm.functions.Function1 r11 = r11.H()
            com.upuphone.xr.sapp.entity.GlassUpdateState$TransferFail r0 = new com.upuphone.xr.sapp.entity.GlassUpdateState$TransferFail
            com.upuphone.star.fota.phone.GlassUpdateInfo r5 = r10.$glassUpdateInfo
            r8 = 8
            r9 = 0
            r6 = 109(0x6d, float:1.53E-43)
            r7 = 0
            r3 = r0
            r3.<init>(r4, r5, r6, r7, r8, r9)
            r11.invoke(r0)
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        L_0x00b7:
            com.upuphone.xr.sapp.glass.AirGlassUpdater r1 = r10.this$0
            com.upuphone.xr.sapp.entity.AirUpdateConfig r3 = new com.upuphone.xr.sapp.entity.AirUpdateConfig
            com.upuphone.star.fota.phone.GlassUpdateInfo r5 = r10.$glassUpdateInfo
            boolean r6 = r5.getExistsUpdate()
            com.upuphone.star.fota.phone.GlassUpdateInfo r7 = r10.$glassUpdateInfo
            java.lang.String r7 = r7.getDigest()
            r3.<init>(r5, r6, r7, r11)
            r1.e = r3
            com.upuphone.xr.sapp.glass.AirGlassUpdater r11 = r10.this$0
            java.util.concurrent.CopyOnWriteArraySet r11 = r11.f
            r11.clear()
            com.upuphone.xr.sapp.glass.AirGlassUpdater r11 = r10.this$0
            r10.L$0 = r4
            r10.label = r2
            java.lang.Object r11 = r11.R(r10)
            if (r11 != r0) goto L_0x00e3
            return r0
        L_0x00e3:
            r1 = r4
        L_0x00e4:
            java.lang.Number r11 = (java.lang.Number) r11
            int r3 = r11.intValue()
            if (r3 == 0) goto L_0x011b
            com.upuphone.xr.sapp.glass.AirGlassUpdater$Companion r11 = com.upuphone.xr.sapp.glass.AirGlassUpdater.g
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "transferFileAndInstall, waitForGlassReadyToTransferFile code: "
            r0.append(r2)
            r0.append(r3)
            java.lang.String r0 = r0.toString()
            r11.c(r0)
            com.upuphone.xr.sapp.glass.AirGlassUpdater r11 = r10.this$0
            kotlin.jvm.functions.Function1 r11 = r11.H()
            com.upuphone.xr.sapp.entity.GlassUpdateState$TransferFail r7 = new com.upuphone.xr.sapp.entity.GlassUpdateState$TransferFail
            com.upuphone.star.fota.phone.GlassUpdateInfo r2 = r10.$glassUpdateInfo
            r5 = 8
            r6 = 0
            r4 = 0
            r0 = r7
            r0.<init>(r1, r2, r3, r4, r5, r6)
            r11.invoke(r7)
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        L_0x011b:
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.glass.AirGlassUpdater$transferFileAndInstall$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((AirGlassUpdater$transferFileAndInstall$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
