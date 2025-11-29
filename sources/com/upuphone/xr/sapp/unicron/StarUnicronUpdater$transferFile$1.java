package com.upuphone.xr.sapp.unicron;

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
@DebugMetadata(c = "com.upuphone.xr.sapp.unicron.StarUnicronUpdater$transferFile$1", f = "StarUnicronUpdater.kt", i = {0, 1}, l = {235, 251}, m = "invokeSuspend", n = {"connectedDevice", "connectedDevice"}, s = {"L$0", "L$0"})
public final class StarUnicronUpdater$transferFile$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ File $file;
    final /* synthetic */ GlassUpdateInfo $glassUpdateInfo;
    final /* synthetic */ boolean $isFirstTime;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StarUnicronUpdater$transferFile$1(boolean z, File file, GlassUpdateInfo glassUpdateInfo, Continuation<? super StarUnicronUpdater$transferFile$1> continuation) {
        super(2, continuation);
        this.$isFirstTime = z;
        this.$file = file;
        this.$glassUpdateInfo = glassUpdateInfo;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        StarUnicronUpdater$transferFile$1 starUnicronUpdater$transferFile$1 = new StarUnicronUpdater$transferFile$1(this.$isFirstTime, this.$file, this.$glassUpdateInfo, continuation);
        starUnicronUpdater$transferFile$1.L$0 = obj;
        return starUnicronUpdater$transferFile$1;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v47, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v18, resolved type: com.upuphone.xr.interconnect.entity.StarryNetDevice} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v50, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v21, resolved type: com.upuphone.xr.interconnect.entity.StarryNetDevice} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0192  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x01d5  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r15) {
        /*
            r14 = this;
            java.lang.Object r9 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r0 = r14.label
            r10 = 0
            r11 = 0
            r1 = 2
            java.lang.String r12 = "transferFile, transferTask isAlive, return"
            r2 = 1
            if (r0 == 0) goto L_0x0037
            if (r0 == r2) goto L_0x0029
            if (r0 != r1) goto L_0x0021
            java.lang.Object r0 = r14.L$0
            r1 = r0
            com.upuphone.xr.interconnect.entity.StarryNetDevice r1 = (com.upuphone.xr.interconnect.entity.StarryNetDevice) r1
            kotlin.ResultKt.throwOnFailure(r15)     // Catch:{ Exception -> 0x001e }
            r0 = r15
            goto L_0x0170
        L_0x001e:
            r0 = move-exception
            goto L_0x0179
        L_0x0021:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0029:
            java.lang.Object r0 = r14.L$0
            r3 = r0
            com.upuphone.xr.interconnect.entity.StarryNetDevice r3 = (com.upuphone.xr.interconnect.entity.StarryNetDevice) r3
            kotlin.ResultKt.throwOnFailure(r15)     // Catch:{ Exception -> 0x0034 }
            r0 = r15
            goto L_0x00f3
        L_0x0034:
            r0 = move-exception
            goto L_0x00f7
        L_0x0037:
            kotlin.ResultKt.throwOnFailure(r15)
            java.lang.Object r0 = r14.L$0
            kotlinx.coroutines.CoroutineScope r0 = (kotlinx.coroutines.CoroutineScope) r0
            com.upuphone.xr.sapp.glass.FilterShareListener r0 = com.upuphone.xr.sapp.unicron.StarUnicronUpdater.g
            boolean r0 = r0.c()
            if (r0 == 0) goto L_0x0050
            com.upuphone.xr.sapp.unicron.StarUnicronUpdater r0 = com.upuphone.xr.sapp.unicron.StarUnicronUpdater.b
            r0.x(r12)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x0050:
            boolean r0 = r14.$isFirstTime
            if (r0 == 0) goto L_0x0057
            com.upuphone.xr.sapp.unicron.StarUnicronUpdater.e = r11
        L_0x0057:
            int r0 = com.upuphone.xr.sapp.unicron.StarUnicronUpdater.e
            r3 = 3
            if (r0 <= r3) goto L_0x007c
            com.upuphone.xr.sapp.unicron.StarUnicronUpdater r0 = com.upuphone.xr.sapp.unicron.StarUnicronUpdater.b
            int r1 = com.upuphone.xr.sapp.unicron.StarUnicronUpdater.e
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "transferFile, reach max count: "
            r2.append(r3)
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            r0.w(r1)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x007c:
            int r0 = com.upuphone.xr.sapp.unicron.StarUnicronUpdater.e
            int r0 = r0 + r2
            com.upuphone.xr.sapp.unicron.StarUnicronUpdater.e = r0
            com.upuphone.xr.sapp.unicron.StarUnicronUpdater r0 = com.upuphone.xr.sapp.unicron.StarUnicronUpdater.b
            int r3 = com.upuphone.xr.sapp.unicron.StarUnicronUpdater.e
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "transferFile, transferCount: "
            r4.append(r5)
            r4.append(r3)
            java.lang.String r3 = r4.toString()
            r0.w(r3)
            com.upuphone.xr.sapp.glass.GlassHelper r3 = com.upuphone.xr.sapp.glass.GlassHelper.f7049a
            com.upuphone.xr.interconnect.entity.StarryNetDevice r3 = r3.y()
            if (r3 != 0) goto L_0x00b0
            java.lang.String r1 = "transferFile, glass not connected"
            r0.w(r1)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x00b0:
            java.io.File r4 = r14.$file
            boolean r4 = r4.exists()
            if (r4 != 0) goto L_0x00cc
            java.lang.String r1 = "transferFile, file not exist"
            r0.w(r1)
            com.upuphone.xr.sapp.unicron.UnicronUpdateHelper r2 = com.upuphone.xr.sapp.unicron.UnicronUpdateHelper.b
            com.upuphone.star.fota.phone.GlassUpdateInfo r3 = r14.$glassUpdateInfo
            r6 = 2
            r7 = 0
            r4 = 0
            com.upuphone.xr.sapp.unicron.UnicronUpdateHelper.W(r2, r3, r4, r6, r7)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x00cc:
            com.upuphone.star.fota.phone.GlassUpdateInfo r4 = r14.$glassUpdateInfo
            java.lang.String r4 = r4.getDigest()
            com.upuphone.star.fota.phone.GlassUpdateInfo r5 = r14.$glassUpdateInfo
            java.lang.String r5 = r5.getLatestVersion()
            if (r4 == 0) goto L_0x0249
            if (r5 != 0) goto L_0x00de
            goto L_0x0249
        L_0x00de:
            java.lang.String r6 = "checkUpdateFile start"
            r0.w(r6)     // Catch:{ Exception -> 0x0034 }
            com.upuphone.xr.sapp.entity.CheckUpdateFileReq r6 = new com.upuphone.xr.sapp.entity.CheckUpdateFileReq     // Catch:{ Exception -> 0x0034 }
            r6.<init>(r5, r4)     // Catch:{ Exception -> 0x0034 }
            r14.L$0 = r3     // Catch:{ Exception -> 0x0034 }
            r14.label = r2     // Catch:{ Exception -> 0x0034 }
            java.lang.Object r0 = r0.c(r6, r14)     // Catch:{ Exception -> 0x0034 }
            if (r0 != r9) goto L_0x00f3
            return r9
        L_0x00f3:
            com.upuphone.xr.sapp.entity.CheckUpdateFileResp r0 = (com.upuphone.xr.sapp.entity.CheckUpdateFileResp) r0     // Catch:{ Exception -> 0x0034 }
            r13 = r3
            goto L_0x010f
        L_0x00f7:
            com.upuphone.xr.sapp.unicron.StarUnicronUpdater r4 = com.upuphone.xr.sapp.unicron.StarUnicronUpdater.b
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "checkUpdateFile error: "
            r5.append(r6)
            r5.append(r0)
            java.lang.String r0 = r5.toString()
            r4.x(r0)
            r13 = r3
            r0 = r10
        L_0x010f:
            com.upuphone.xr.sapp.unicron.StarUnicronUpdater r3 = com.upuphone.xr.sapp.unicron.StarUnicronUpdater.b
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "checkUpdateFile result: "
            r4.append(r5)
            r4.append(r0)
            java.lang.String r4 = r4.toString()
            r3.w(r4)
            if (r0 == 0) goto L_0x0144
            boolean r4 = r0.isSuccess()
            if (r4 != r2) goto L_0x0144
            java.lang.Boolean r0 = r0.getExist()
            java.lang.Boolean r2 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r2)
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r2)
            if (r0 == 0) goto L_0x0144
            java.lang.String r0 = "transferFile, update file already exist on remote"
            r3.w(r0)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x0144:
            com.upuphone.xr.sapp.glass.FilterShareListener r0 = com.upuphone.xr.sapp.unicron.StarUnicronUpdater.g
            boolean r0 = r0.c()
            if (r0 == 0) goto L_0x0154
            r3.x(r12)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x0154:
            java.lang.String r0 = "transferFile, enableP2pConnection start"
            r3.w(r0)     // Catch:{ Exception -> 0x0177 }
            com.upuphone.xr.sapp.glass.GlassHelper r0 = com.upuphone.xr.sapp.glass.GlassHelper.f7049a     // Catch:{ Exception -> 0x0177 }
            java.lang.String r2 = "StarUnicronUpdater"
            r14.L$0 = r13     // Catch:{ Exception -> 0x0177 }
            r14.label = r1     // Catch:{ Exception -> 0x0177 }
            r3 = 0
            r6 = 2
            r7 = 0
            r1 = r0
            r5 = r14
            java.lang.Object r0 = com.upuphone.xr.sapp.glass.GlassHelper.v(r1, r2, r3, r5, r6, r7)     // Catch:{ Exception -> 0x0177 }
            if (r0 != r9) goto L_0x016f
            return r9
        L_0x016f:
            r1 = r13
        L_0x0170:
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ Exception -> 0x001e }
            boolean r11 = r0.booleanValue()     // Catch:{ Exception -> 0x001e }
            goto L_0x0190
        L_0x0177:
            r0 = move-exception
            r1 = r13
        L_0x0179:
            com.upuphone.xr.sapp.unicron.StarUnicronUpdater r2 = com.upuphone.xr.sapp.unicron.StarUnicronUpdater.b
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "transferFile, enableP2pConnection error: "
            r3.append(r4)
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            r2.x(r0)
        L_0x0190:
            if (r11 != 0) goto L_0x01d5
            com.upuphone.xr.sapp.unicron.StarUnicronUpdater r2 = com.upuphone.xr.sapp.unicron.StarUnicronUpdater.b
            com.upuphone.xr.sapp.utils.PermissionAndStateCheckUtils r0 = com.upuphone.xr.sapp.utils.PermissionAndStateCheckUtils.f7907a
            boolean r1 = r0.B()
            boolean r3 = r0.w()
            java.lang.Boolean r0 = r0.x()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "transferFile, enableP2pConnection fail, isGPSEnabled: "
            r4.append(r5)
            r4.append(r1)
            java.lang.String r1 = ", hasFineLocationPermission: "
            r4.append(r1)
            r4.append(r3)
            java.lang.String r1 = ", hasNearbyWifiDevicesPermission: "
            r4.append(r1)
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            r2.w(r0)
            java.io.File r3 = r14.$file
            com.upuphone.star.fota.phone.GlassUpdateInfo r4 = r14.$glassUpdateInfo
            r7 = 4
            r8 = 0
            r5 = 0
            com.upuphone.xr.sapp.unicron.StarUnicronUpdater.G(r2, r3, r4, r5, r7, r8)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x01d5:
            com.upuphone.xr.sapp.unicron.StarUnicronUpdater r0 = com.upuphone.xr.sapp.unicron.StarUnicronUpdater.b
            java.lang.String r2 = "transferFile, enableP2pConnection success"
            r0.w(r2)
            com.upuphone.xr.sapp.utils.AppUtils r2 = com.upuphone.xr.sapp.utils.AppUtils.f7842a
            java.io.File r3 = r14.$file
            com.upuphone.xr.sapp.common.Constants r4 = com.upuphone.xr.sapp.common.Constants.f6657a
            java.lang.String[] r4 = r4.b()
            android.net.Uri r2 = r2.d(r3, r4)
            com.upuphone.xr.sapp.unicron.StarUnicronUpdater$transferFile$1$shareListener$1 r3 = new com.upuphone.xr.sapp.unicron.StarUnicronUpdater$transferFile$1$shareListener$1
            java.io.File r4 = r14.$file
            com.upuphone.star.fota.phone.GlassUpdateInfo r5 = r14.$glassUpdateInfo
            r3.<init>(r4, r5)
            com.upuphone.xr.sapp.glass.FilterShareListener r4 = com.upuphone.xr.sapp.unicron.StarUnicronUpdater.g
            boolean r4 = r4.c()
            if (r4 == 0) goto L_0x0204
            r0.x(r12)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x0204:
            com.upuphone.starrynetsdk.ability.share.ShareAbility r4 = r0.t()
            java.lang.String r1 = r1.getDeviceId()
            android.net.Uri[] r2 = new android.net.Uri[]{r2}
            java.lang.String r1 = r4.send(r1, r2, r10)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r4 = "transferFile, ShareAbility#send, taskId="
            r2.append(r4)
            r2.append(r1)
            java.lang.String r2 = r2.toString()
            r0.w(r2)
            if (r1 != 0) goto L_0x0238
            java.io.File r2 = r14.$file
            com.upuphone.star.fota.phone.GlassUpdateInfo r3 = r14.$glassUpdateInfo
            r6 = 4
            r7 = 0
            r4 = 0
            r1 = r0
            com.upuphone.xr.sapp.unicron.StarUnicronUpdater.G(r1, r2, r3, r4, r6, r7)
            goto L_0x0246
        L_0x0238:
            com.upuphone.xr.sapp.glass.FilterShareListener r2 = com.upuphone.xr.sapp.unicron.StarUnicronUpdater.g
            r2.a(r3, r1)
            com.upuphone.star.fota.phone.GlassUpdateInfo r2 = r14.$glassUpdateInfo
            java.io.File r3 = r14.$file
            r0.H(r1, r2, r3)
        L_0x0246:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x0249:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "transferFile, wrong digest: "
            r1.append(r2)
            r1.append(r4)
            java.lang.String r2 = ", latestVersion: "
            r1.append(r2)
            r1.append(r5)
            java.lang.String r1 = r1.toString()
            r0.x(r1)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.unicron.StarUnicronUpdater$transferFile$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((StarUnicronUpdater$transferFile$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
