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
@DebugMetadata(c = "com.upuphone.xr.sapp.glass.StarGlassUpdater$installUpdate$1", f = "StarGlassUpdater.kt", i = {}, l = {547, 551}, m = "invokeSuspend", n = {}, s = {})
public final class StarGlassUpdater$installUpdate$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $delayTime;
    final /* synthetic */ GlassUpdateInfo $glassUpdateInfo;
    final /* synthetic */ String $uid;
    int label;
    final /* synthetic */ StarGlassUpdater this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StarGlassUpdater$installUpdate$1(long j, StarGlassUpdater starGlassUpdater, String str, GlassUpdateInfo glassUpdateInfo, Continuation<? super StarGlassUpdater$installUpdate$1> continuation) {
        super(2, continuation);
        this.$delayTime = j;
        this.this$0 = starGlassUpdater;
        this.$uid = str;
        this.$glassUpdateInfo = glassUpdateInfo;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new StarGlassUpdater$installUpdate$1(this.$delayTime, this.this$0, this.$uid, this.$glassUpdateInfo, continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0080  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0095  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r12) {
        /*
            r11 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r11.label
            java.lang.String r2 = "installUpdate, sendInstallUpdateCmd error: "
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L_0x0025
            if (r1 == r4) goto L_0x0021
            if (r1 != r3) goto L_0x0019
            kotlin.ResultKt.throwOnFailure(r12)     // Catch:{ TimeoutCancellationException -> 0x0016, Exception -> 0x0014 }
            goto L_0x004a
        L_0x0014:
            r12 = move-exception
            goto L_0x004d
        L_0x0016:
            r12 = move-exception
            goto L_0x00ac
        L_0x0019:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L_0x0021:
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x0033
        L_0x0025:
            kotlin.ResultKt.throwOnFailure(r12)
            long r5 = r11.$delayTime
            r11.label = r4
            java.lang.Object r12 = kotlinx.coroutines.DelayKt.b(r5, r11)
            if (r12 != r0) goto L_0x0033
            return r0
        L_0x0033:
            com.upuphone.xr.sapp.glass.StarGlassUpdater$Companion r12 = com.upuphone.xr.sapp.glass.StarGlassUpdater.j     // Catch:{ TimeoutCancellationException -> 0x0016, Exception -> 0x0014 }
            java.lang.String r1 = "installUpdate, sendInstallUpdateCmd start"
            r12.c(r1)     // Catch:{ TimeoutCancellationException -> 0x0016, Exception -> 0x0014 }
            com.upuphone.xr.sapp.glass.GlassHelper r5 = com.upuphone.xr.sapp.glass.GlassHelper.f7049a     // Catch:{ TimeoutCancellationException -> 0x0016, Exception -> 0x0014 }
            r11.label = r3     // Catch:{ TimeoutCancellationException -> 0x0016, Exception -> 0x0014 }
            r6 = 0
            r9 = 1
            r10 = 0
            r8 = r11
            java.lang.Object r12 = com.upuphone.xr.sapp.glass.GlassHelper.L(r5, r6, r8, r9, r10)     // Catch:{ TimeoutCancellationException -> 0x0016, Exception -> 0x0014 }
            if (r12 != r0) goto L_0x004a
            return r0
        L_0x004a:
            com.upuphone.xr.sapp.entity.BasicGlassResponse r12 = (com.upuphone.xr.sapp.entity.BasicGlassResponse) r12     // Catch:{ TimeoutCancellationException -> 0x0016, Exception -> 0x0014 }
            goto L_0x0062
        L_0x004d:
            com.upuphone.xr.sapp.glass.StarGlassUpdater$Companion r0 = com.upuphone.xr.sapp.glass.StarGlassUpdater.j
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r2)
            r1.append(r12)
            java.lang.String r12 = r1.toString()
            r0.d(r12)
            r12 = 0
        L_0x0062:
            com.upuphone.xr.sapp.glass.StarGlassUpdater$Companion r0 = com.upuphone.xr.sapp.glass.StarGlassUpdater.j
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "installUpdate, sendInstallUpdateCmd response: "
            r1.append(r2)
            r1.append(r12)
            java.lang.String r1 = r1.toString()
            r0.c(r1)
            if (r12 == 0) goto L_0x0095
            boolean r12 = r12.isSuccess()
            if (r12 != r4) goto L_0x0095
            com.upuphone.xr.sapp.glass.StarGlassUpdater r12 = r11.this$0
            kotlin.jvm.functions.Function1 r12 = r12.f7070a
            com.upuphone.xr.sapp.entity.GlassUpdateState$Installing r0 = new com.upuphone.xr.sapp.entity.GlassUpdateState$Installing
            com.upuphone.star.fota.phone.GlassUpdateInfo r1 = r11.$glassUpdateInfo
            java.lang.String r11 = r11.$uid
            r0.<init>(r1, r11)
            r12.invoke(r0)
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        L_0x0095:
            com.upuphone.xr.sapp.glass.StarGlassUpdater r12 = r11.this$0
            kotlin.jvm.functions.Function1 r12 = r12.f7070a
            com.upuphone.xr.sapp.entity.GlassUpdateState$InstallFail r0 = new com.upuphone.xr.sapp.entity.GlassUpdateState$InstallFail
            java.lang.String r1 = r11.$uid
            com.upuphone.star.fota.phone.GlassUpdateInfo r11 = r11.$glassUpdateInfo
            r2 = 115(0x73, float:1.61E-43)
            r0.<init>(r1, r11, r2)
            r12.invoke(r0)
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        L_0x00ac:
            com.upuphone.xr.sapp.glass.StarGlassUpdater$Companion r0 = com.upuphone.xr.sapp.glass.StarGlassUpdater.j
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r2)
            r1.append(r12)
            java.lang.String r12 = r1.toString()
            r0.d(r12)
            com.upuphone.xr.sapp.glass.StarGlassUpdater r12 = r11.this$0
            kotlin.jvm.functions.Function1 r12 = r12.f7070a
            com.upuphone.xr.sapp.entity.GlassUpdateState$InstallFail r0 = new com.upuphone.xr.sapp.entity.GlassUpdateState$InstallFail
            java.lang.String r1 = r11.$uid
            com.upuphone.star.fota.phone.GlassUpdateInfo r11 = r11.$glassUpdateInfo
            r2 = 116(0x74, float:1.63E-43)
            r0.<init>(r1, r11, r2)
            r12.invoke(r0)
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.glass.StarGlassUpdater$installUpdate$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((StarGlassUpdater$installUpdate$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
