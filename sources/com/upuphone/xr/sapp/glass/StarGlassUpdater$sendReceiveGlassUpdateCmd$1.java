package com.upuphone.xr.sapp.glass;

import com.upuphone.star.fota.phone.GlassUpdateInfo;
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
@DebugMetadata(c = "com.upuphone.xr.sapp.glass.StarGlassUpdater$sendReceiveGlassUpdateCmd$1", f = "StarGlassUpdater.kt", i = {}, l = {486}, m = "invokeSuspend", n = {}, s = {})
public final class StarGlassUpdater$sendReceiveGlassUpdateCmd$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $delayFailTime;
    final /* synthetic */ GlassUpdateInfo $glassUpdateInfo;
    final /* synthetic */ String $taskId;
    final /* synthetic */ String $uid;
    int label;
    final /* synthetic */ StarGlassUpdater this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StarGlassUpdater$sendReceiveGlassUpdateCmd$1(GlassUpdateInfo glassUpdateInfo, StarGlassUpdater starGlassUpdater, String str, String str2, long j, Continuation<? super StarGlassUpdater$sendReceiveGlassUpdateCmd$1> continuation) {
        super(2, continuation);
        this.$glassUpdateInfo = glassUpdateInfo;
        this.this$0 = starGlassUpdater;
        this.$uid = str;
        this.$taskId = str2;
        this.$delayFailTime = j;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new StarGlassUpdater$sendReceiveGlassUpdateCmd$1(this.$glassUpdateInfo, this.this$0, this.$uid, this.$taskId, this.$delayFailTime, continuation);
    }

    /* JADX WARNING: type inference failed for: r14v9, types: [com.upuphone.xr.sapp.entity.GlassUpdateState$StarTransferring] */
    /* JADX WARNING: Multi-variable type inference failed */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r14) {
        /*
            r13 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r13.label
            r2 = 1
            if (r1 == 0) goto L_0x001b
            if (r1 != r2) goto L_0x0013
            kotlin.ResultKt.throwOnFailure(r14)     // Catch:{ Exception -> 0x0010 }
            goto L_0x0082
        L_0x0010:
            r14 = move-exception
            goto L_0x0085
        L_0x0013:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r14)
            throw r13
        L_0x001b:
            kotlin.ResultKt.throwOnFailure(r14)
            com.upuphone.star.fota.phone.GlassUpdateInfo r14 = r13.$glassUpdateInfo
            java.lang.String r5 = r14.getDigest()
            com.upuphone.star.fota.phone.GlassUpdateInfo r14 = r13.$glassUpdateInfo
            java.lang.String r4 = r14.getLatestVersion()
            if (r5 == 0) goto L_0x00f5
            if (r4 != 0) goto L_0x0030
            goto L_0x00f5
        L_0x0030:
            com.upuphone.xr.sapp.glass.GlassHelper r14 = com.upuphone.xr.sapp.glass.GlassHelper.f7049a
            com.upuphone.xr.interconnect.entity.StarryNetDevice r1 = r14.x()
            if (r1 != 0) goto L_0x005b
            com.upuphone.xr.sapp.glass.StarGlassUpdater$Companion r14 = com.upuphone.xr.sapp.glass.StarGlassUpdater.j
            java.lang.String r0 = "sendReceiveGlassUpdateCmd, connectedDevice is null"
            r14.c(r0)
            com.upuphone.xr.sapp.glass.StarGlassUpdater r14 = r13.this$0
            kotlin.jvm.functions.Function1 r14 = r14.f7070a
            com.upuphone.xr.sapp.entity.GlassUpdateState$TransferFail r7 = new com.upuphone.xr.sapp.entity.GlassUpdateState$TransferFail
            java.lang.String r1 = r13.$uid
            com.upuphone.star.fota.phone.GlassUpdateInfo r2 = r13.$glassUpdateInfo
            r5 = 8
            r6 = 0
            r3 = 101(0x65, float:1.42E-43)
            r4 = 0
            r0 = r7
            r0.<init>(r1, r2, r3, r4, r5, r6)
            r14.invoke(r7)
            kotlin.Unit r13 = kotlin.Unit.INSTANCE
            return r13
        L_0x005b:
            com.upuphone.xr.sapp.glass.StarGlassUpdater$Companion r1 = com.upuphone.xr.sapp.glass.StarGlassUpdater.j     // Catch:{ Exception -> 0x0010 }
            java.lang.String r3 = "sendReceiveGlassUpdateCmd start"
            r1.c(r3)     // Catch:{ Exception -> 0x0010 }
            com.upuphone.xr.sapp.entity.ReceiveGlassUpdate r1 = new com.upuphone.xr.sapp.entity.ReceiveGlassUpdate     // Catch:{ Exception -> 0x0010 }
            java.lang.String r6 = r13.$taskId     // Catch:{ Exception -> 0x0010 }
            long r7 = r13.$delayFailTime     // Catch:{ Exception -> 0x0010 }
            com.upuphone.star.fota.phone.GlassUpdateInfo r3 = r13.$glassUpdateInfo     // Catch:{ Exception -> 0x0010 }
            java.lang.Long r9 = r3.getFileSize()     // Catch:{ Exception -> 0x0010 }
            r3 = r1
            r3.<init>(r4, r5, r6, r7, r9)     // Catch:{ Exception -> 0x0010 }
            r13.label = r2     // Catch:{ Exception -> 0x0010 }
            r8 = 0
            r11 = 2
            r12 = 0
            r6 = r14
            r7 = r1
            r10 = r13
            java.lang.Object r14 = com.upuphone.xr.sapp.glass.GlassHelper.P(r6, r7, r8, r10, r11, r12)     // Catch:{ Exception -> 0x0010 }
            if (r14 != r0) goto L_0x0082
            return r0
        L_0x0082:
            com.upuphone.xr.sapp.entity.BasicGlassResponse r14 = (com.upuphone.xr.sapp.entity.BasicGlassResponse) r14     // Catch:{ Exception -> 0x0010 }
            goto L_0x009c
        L_0x0085:
            com.upuphone.xr.sapp.glass.StarGlassUpdater$Companion r0 = com.upuphone.xr.sapp.glass.StarGlassUpdater.j
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "sendReceiveGlassUpdateCmd error: "
            r1.append(r3)
            r1.append(r14)
            java.lang.String r14 = r1.toString()
            r0.d(r14)
            r14 = 0
        L_0x009c:
            com.upuphone.xr.sapp.glass.StarGlassUpdater$Companion r0 = com.upuphone.xr.sapp.glass.StarGlassUpdater.j
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "sendReceiveGlassUpdateCmd response: "
            r1.append(r3)
            r1.append(r14)
            java.lang.String r1 = r1.toString()
            r0.c(r1)
            com.upuphone.xr.sapp.glass.StarGlassUpdater r1 = r13.this$0
            kotlin.jvm.functions.Function1 r1 = r1.f7070a
            if (r14 == 0) goto L_0x00ca
            boolean r14 = r14.isSuccess()
            if (r14 != r2) goto L_0x00ca
            com.upuphone.xr.sapp.entity.GlassUpdateState$StarTransferring r14 = new com.upuphone.xr.sapp.entity.GlassUpdateState$StarTransferring
            com.upuphone.star.fota.phone.GlassUpdateInfo r0 = r13.$glassUpdateInfo
            java.lang.String r13 = r13.$uid
            r14.<init>(r0, r13)
            goto L_0x00ef
        L_0x00ca:
            java.lang.String r14 = "sendReceiveGlassUpdateCmd, shareAbility#cancel"
            r0.c(r14)
            com.upuphone.xr.sapp.glass.StarGlassUpdater r14 = r13.this$0
            r14.h = r2
            com.upuphone.xr.sapp.glass.StarGlassUpdater r14 = r13.this$0
            com.upuphone.starrynetsdk.ability.share.ShareAbility r14 = r14.F()
            java.lang.String r0 = r13.$taskId
            r14.cancel(r0, r2)
            com.upuphone.xr.sapp.entity.GlassUpdateState$TransferFail r14 = new com.upuphone.xr.sapp.entity.GlassUpdateState$TransferFail
            java.lang.String r4 = r13.$uid
            com.upuphone.star.fota.phone.GlassUpdateInfo r5 = r13.$glassUpdateInfo
            r8 = 8
            r9 = 0
            r6 = 114(0x72, float:1.6E-43)
            r7 = 0
            r3 = r14
            r3.<init>(r4, r5, r6, r7, r8, r9)
        L_0x00ef:
            r1.invoke(r14)
            kotlin.Unit r13 = kotlin.Unit.INSTANCE
            return r13
        L_0x00f5:
            com.upuphone.xr.sapp.glass.StarGlassUpdater$Companion r14 = com.upuphone.xr.sapp.glass.StarGlassUpdater.j
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "sendReceiveGlassUpdateCmd null info, digest: "
            r0.append(r1)
            r0.append(r5)
            java.lang.String r1 = ", latestVersion: "
            r0.append(r1)
            r0.append(r4)
            java.lang.String r0 = r0.toString()
            r14.d(r0)
            com.upuphone.xr.sapp.glass.StarGlassUpdater r14 = r13.this$0
            kotlin.jvm.functions.Function1 r14 = r14.f7070a
            com.upuphone.xr.sapp.entity.GlassUpdateState$TransferFail r7 = new com.upuphone.xr.sapp.entity.GlassUpdateState$TransferFail
            java.lang.String r1 = r13.$uid
            com.upuphone.star.fota.phone.GlassUpdateInfo r2 = r13.$glassUpdateInfo
            r5 = 8
            r6 = 0
            r3 = 112(0x70, float:1.57E-43)
            r4 = 0
            r0 = r7
            r0.<init>(r1, r2, r3, r4, r5, r6)
            r14.invoke(r7)
            kotlin.Unit r13 = kotlin.Unit.INSTANCE
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.glass.StarGlassUpdater$sendReceiveGlassUpdateCmd$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((StarGlassUpdater$sendReceiveGlassUpdateCmd$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
