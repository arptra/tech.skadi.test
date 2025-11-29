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
@DebugMetadata(c = "com.upuphone.xr.sapp.glass.StarGlassUpdater$transferFileInner$1", f = "StarGlassUpdater.kt", i = {0, 1}, l = {293, 314}, m = "invokeSuspend", n = {"uid", "uid"}, s = {"L$0", "L$0"})
public final class StarGlassUpdater$transferFileInner$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ File $downloadFile;
    final /* synthetic */ GlassUpdateInfo $glassUpdateInfo;
    final /* synthetic */ boolean $isFirstTime;
    Object L$0;
    int label;
    final /* synthetic */ StarGlassUpdater this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StarGlassUpdater$transferFileInner$1(GlassUpdateInfo glassUpdateInfo, StarGlassUpdater starGlassUpdater, boolean z, File file, Continuation<? super StarGlassUpdater$transferFileInner$1> continuation) {
        super(2, continuation);
        this.$glassUpdateInfo = glassUpdateInfo;
        this.this$0 = starGlassUpdater;
        this.$isFirstTime = z;
        this.$downloadFile = file;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new StarGlassUpdater$transferFileInner$1(this.$glassUpdateInfo, this.this$0, this.$isFirstTime, this.$downloadFile, continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x00ed  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x013c  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r15) {
        /*
            r14 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r14.label
            r2 = 2
            r3 = 0
            r4 = 1
            if (r1 == 0) goto L_0x002c
            if (r1 == r4) goto L_0x0023
            if (r1 != r2) goto L_0x001b
            java.lang.Object r0 = r14.L$0
            java.lang.String r0 = (java.lang.String) r0
            kotlin.ResultKt.throwOnFailure(r15)     // Catch:{ Exception -> 0x0018 }
            goto L_0x00c8
        L_0x0018:
            r15 = move-exception
            goto L_0x00d2
        L_0x001b:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r15 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r15)
            throw r14
        L_0x0023:
            java.lang.Object r1 = r14.L$0
            java.lang.String r1 = (java.lang.String) r1
            kotlin.ResultKt.throwOnFailure(r15)
            r6 = r1
            goto L_0x005c
        L_0x002c:
            kotlin.ResultKt.throwOnFailure(r15)
            java.util.UUID r15 = java.util.UUID.randomUUID()
            java.lang.String r6 = r15.toString()
            java.lang.String r15 = "toString(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r15)
            com.upuphone.star.fota.phone.GlassUpdateInfo r15 = r14.$glassUpdateInfo
            java.lang.String r15 = r15.getDigest()
            com.upuphone.star.fota.phone.GlassUpdateInfo r1 = r14.$glassUpdateInfo
            java.lang.String r1 = r1.getLatestVersion()
            if (r15 == 0) goto L_0x01e7
            if (r1 != 0) goto L_0x004f
            goto L_0x01e7
        L_0x004f:
            com.upuphone.xr.sapp.glass.StarGlassUpdater r5 = r14.this$0
            r14.L$0 = r6
            r14.label = r4
            java.lang.Object r15 = r5.D(r1, r15, r14)
            if (r15 != r0) goto L_0x005c
            return r0
        L_0x005c:
            java.lang.Boolean r15 = (java.lang.Boolean) r15
            com.upuphone.xr.sapp.glass.StarGlassUpdater$Companion r1 = com.upuphone.xr.sapp.glass.StarGlassUpdater.j
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r7 = "transferFileInner, fileExist: "
            r5.append(r7)
            r5.append(r15)
            java.lang.String r5 = r5.toString()
            r1.c(r5)
            if (r15 != 0) goto L_0x0091
            com.upuphone.xr.sapp.glass.StarGlassUpdater r15 = r14.this$0
            kotlin.jvm.functions.Function1 r15 = r15.f7070a
            com.upuphone.xr.sapp.entity.GlassUpdateState$TransferFail r0 = new com.upuphone.xr.sapp.entity.GlassUpdateState$TransferFail
            com.upuphone.star.fota.phone.GlassUpdateInfo r7 = r14.$glassUpdateInfo
            r10 = 8
            r11 = 0
            r8 = 115(0x73, float:1.61E-43)
            r9 = 0
            r5 = r0
            r5.<init>(r6, r7, r8, r9, r10, r11)
            r15.invoke(r0)
            kotlin.Unit r14 = kotlin.Unit.INSTANCE
            return r14
        L_0x0091:
            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r4)
            boolean r15 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r15, (java.lang.Object) r5)
            if (r15 == 0) goto L_0x00ad
            java.lang.String r15 = "transferFileInner, fileExist=true, installUpdate"
            r1.c(r15)
            com.upuphone.xr.sapp.glass.StarGlassUpdater r15 = r14.this$0
            com.upuphone.star.fota.phone.GlassUpdateInfo r14 = r14.$glassUpdateInfo
            r0 = 0
            r15.G(r14, r6, r0)
            kotlin.Unit r14 = kotlin.Unit.INSTANCE
            return r14
        L_0x00ad:
            java.lang.String r15 = "transferFileInner, enableP2pConnection start"
            r1.c(r15)     // Catch:{ Exception -> 0x00d0 }
            com.upuphone.xr.sapp.glass.GlassHelper r7 = com.upuphone.xr.sapp.glass.GlassHelper.f7049a     // Catch:{ Exception -> 0x00d0 }
            java.lang.String r8 = "StarGlassUpdater"
            r14.L$0 = r6     // Catch:{ Exception -> 0x00d0 }
            r14.label = r2     // Catch:{ Exception -> 0x00d0 }
            r9 = 0
            r12 = 2
            r13 = 0
            r11 = r14
            java.lang.Object r15 = com.upuphone.xr.sapp.glass.GlassHelper.v(r7, r8, r9, r11, r12, r13)     // Catch:{ Exception -> 0x00d0 }
            if (r15 != r0) goto L_0x00c7
            return r0
        L_0x00c7:
            r0 = r6
        L_0x00c8:
            java.lang.Boolean r15 = (java.lang.Boolean) r15     // Catch:{ Exception -> 0x0018 }
            boolean r15 = r15.booleanValue()     // Catch:{ Exception -> 0x0018 }
            r6 = r0
            goto L_0x00eb
        L_0x00d0:
            r15 = move-exception
            r0 = r6
        L_0x00d2:
            com.upuphone.xr.sapp.glass.StarGlassUpdater$Companion r1 = com.upuphone.xr.sapp.glass.StarGlassUpdater.j
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r5 = "transferFileInner, enableP2pConnection error: "
            r2.append(r5)
            r2.append(r15)
            java.lang.String r15 = r2.toString()
            r1.d(r15)
            r6 = r0
            r15 = r3
        L_0x00eb:
            if (r15 != 0) goto L_0x013c
            com.upuphone.xr.sapp.glass.StarGlassUpdater$Companion r15 = com.upuphone.xr.sapp.glass.StarGlassUpdater.j
            com.upuphone.xr.sapp.utils.PermissionAndStateCheckUtils r0 = com.upuphone.xr.sapp.utils.PermissionAndStateCheckUtils.f7907a
            boolean r1 = r0.B()
            boolean r2 = r0.w()
            java.lang.Boolean r0 = r0.x()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "transferFileInner, enableP2pConnection fail, isGPSEnabled: "
            r3.append(r4)
            r3.append(r1)
            java.lang.String r1 = ", hasFineLocationPermission: "
            r3.append(r1)
            r3.append(r2)
            java.lang.String r1 = ", hasNearbyWifiDevicesPermission: "
            r3.append(r1)
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            r15.c(r0)
            com.upuphone.xr.sapp.glass.StarGlassUpdater r15 = r14.this$0
            kotlin.jvm.functions.Function1 r15 = r15.f7070a
            com.upuphone.xr.sapp.entity.GlassUpdateState$TransferFail r0 = new com.upuphone.xr.sapp.entity.GlassUpdateState$TransferFail
            com.upuphone.star.fota.phone.GlassUpdateInfo r7 = r14.$glassUpdateInfo
            r10 = 8
            r11 = 0
            r8 = 113(0x71, float:1.58E-43)
            r9 = 0
            r5 = r0
            r5.<init>(r6, r7, r8, r9, r10, r11)
            r15.invoke(r0)
            kotlin.Unit r14 = kotlin.Unit.INSTANCE
            return r14
        L_0x013c:
            com.upuphone.xr.sapp.glass.StarGlassUpdater$Companion r15 = com.upuphone.xr.sapp.glass.StarGlassUpdater.j
            java.lang.String r0 = "transferFileInner, enableP2pConnection success"
            r15.c(r0)
            com.upuphone.xr.sapp.glass.GlassHelper r0 = com.upuphone.xr.sapp.glass.GlassHelper.f7049a
            com.upuphone.xr.interconnect.entity.StarryNetDevice r0 = r0.x()
            if (r0 != 0) goto L_0x016c
            java.lang.String r0 = "transferFileInner, connectedDevice is null"
            r15.c(r0)
            com.upuphone.xr.sapp.glass.StarGlassUpdater r15 = r14.this$0
            kotlin.jvm.functions.Function1 r15 = r15.f7070a
            com.upuphone.xr.sapp.entity.GlassUpdateState$TransferFail r0 = new com.upuphone.xr.sapp.entity.GlassUpdateState$TransferFail
            com.upuphone.star.fota.phone.GlassUpdateInfo r7 = r14.$glassUpdateInfo
            r10 = 8
            r11 = 0
            r8 = 101(0x65, float:1.42E-43)
            r9 = 0
            r5 = r0
            r5.<init>(r6, r7, r8, r9, r10, r11)
            r15.invoke(r0)
            kotlin.Unit r14 = kotlin.Unit.INSTANCE
            return r14
        L_0x016c:
            boolean r1 = r14.$isFirstTime
            if (r1 == 0) goto L_0x0185
            com.upuphone.xr.sapp.glass.StarGlassUpdater r1 = r14.this$0
            r1.g = r3
            com.upuphone.xr.sapp.glass.StarGlassUpdater r1 = r14.this$0
            kotlin.jvm.functions.Function1 r1 = r1.f7070a
            com.upuphone.xr.sapp.entity.GlassUpdateState$StarTransferring r2 = new com.upuphone.xr.sapp.entity.GlassUpdateState$StarTransferring
            com.upuphone.star.fota.phone.GlassUpdateInfo r5 = r14.$glassUpdateInfo
            r2.<init>(r5, r6)
            r1.invoke(r2)
        L_0x0185:
            com.upuphone.xr.sapp.glass.StarGlassUpdater r1 = r14.this$0
            int r2 = r1.g
            int r2 = r2 + r4
            r1.g = r2
            com.upuphone.xr.sapp.glass.GlassUpdateAdapter r1 = com.upuphone.xr.sapp.glass.GlassUpdateAdapter.b
            java.io.File r2 = r14.$downloadFile
            android.net.Uri r1 = r1.j(r2)
            android.net.Uri[] r1 = new android.net.Uri[]{r1}
            com.upuphone.xr.sapp.glass.StarGlassUpdater$transferFileInner$1$shareListener$1 r2 = new com.upuphone.xr.sapp.glass.StarGlassUpdater$transferFileInner$1$shareListener$1
            com.upuphone.xr.sapp.glass.StarGlassUpdater r4 = r14.this$0
            com.upuphone.star.fota.phone.GlassUpdateInfo r5 = r14.$glassUpdateInfo
            java.io.File r7 = r14.$downloadFile
            r2.<init>(r4, r5, r6, r7)
            com.upuphone.xr.sapp.glass.StarGlassUpdater r4 = r14.this$0
            r4.h = r3
            com.upuphone.xr.sapp.glass.StarGlassUpdater r3 = r14.this$0
            com.upuphone.starrynetsdk.ability.share.ShareAbility r3 = r3.F()
            java.lang.String r0 = r0.getDeviceId()
            r4 = 0
            java.lang.String r0 = r3.send(r0, r1, r4)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "transferFileInner, ShareAbility#send, pendingTaskId="
            r1.append(r3)
            r1.append(r0)
            java.lang.String r1 = r1.toString()
            r15.c(r1)
            if (r0 != 0) goto L_0x01db
            com.upuphone.xr.sapp.glass.StarGlassUpdater r15 = r14.this$0
            java.io.File r0 = r14.$downloadFile
            com.upuphone.star.fota.phone.GlassUpdateInfo r14 = r14.$glassUpdateInfo
            r15.H(r0, r14, r6)
            goto L_0x01e4
        L_0x01db:
            com.upuphone.xr.sapp.glass.StarGlassUpdater r14 = r14.this$0
            com.upuphone.xr.sapp.glass.FilterShareListener r14 = r14.d
            r14.a(r2, r0)
        L_0x01e4:
            kotlin.Unit r14 = kotlin.Unit.INSTANCE
            return r14
        L_0x01e7:
            com.upuphone.xr.sapp.glass.StarGlassUpdater$Companion r0 = com.upuphone.xr.sapp.glass.StarGlassUpdater.j
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "transferFileInner wrong info, digest: "
            r2.append(r3)
            r2.append(r15)
            java.lang.String r15 = ", latestVersion: "
            r2.append(r15)
            r2.append(r1)
            java.lang.String r15 = r2.toString()
            r0.d(r15)
            com.upuphone.xr.sapp.glass.StarGlassUpdater r15 = r14.this$0
            kotlin.jvm.functions.Function1 r15 = r15.f7070a
            com.upuphone.xr.sapp.entity.GlassUpdateState$TransferFail r0 = new com.upuphone.xr.sapp.entity.GlassUpdateState$TransferFail
            com.upuphone.star.fota.phone.GlassUpdateInfo r7 = r14.$glassUpdateInfo
            r10 = 8
            r11 = 0
            r8 = 112(0x70, float:1.57E-43)
            r9 = 0
            r5 = r0
            r5.<init>(r6, r7, r8, r9, r10, r11)
            r15.invoke(r0)
            kotlin.Unit r14 = kotlin.Unit.INSTANCE
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.glass.StarGlassUpdater$transferFileInner$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((StarGlassUpdater$transferFileInner$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
