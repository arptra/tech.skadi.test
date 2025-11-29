package com.upuphone.xr.sapp.glass;

import com.upuphone.star.fota.phone.GlassUpdateInfo;
import com.upuphone.xr.sapp.entity.GlassUpdateState;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.glass.GlassUpdateAdapter$sendShowUpdateDialogCmd$1", f = "GlassUpdateAdapter.kt", i = {0, 0, 1}, l = {195, 208}, m = "invokeSuspend", n = {"uid", "connectedDevice", "uid"}, s = {"L$0", "L$1", "L$0"})
public final class GlassUpdateAdapter$sendShowUpdateDialogCmd$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ File $downloadFile;
    final /* synthetic */ GlassUpdateInfo $glassUpdateInfo;
    final /* synthetic */ Function1<GlassUpdateState, Unit> $stateCallback;
    Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GlassUpdateAdapter$sendShowUpdateDialogCmd$1(Function1<? super GlassUpdateState, Unit> function1, GlassUpdateInfo glassUpdateInfo, File file, Continuation<? super GlassUpdateAdapter$sendShowUpdateDialogCmd$1> continuation) {
        super(2, continuation);
        this.$stateCallback = function1;
        this.$glassUpdateInfo = glassUpdateInfo;
        this.$downloadFile = file;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new GlassUpdateAdapter$sendShowUpdateDialogCmd$1(this.$stateCallback, this.$glassUpdateInfo, this.$downloadFile, continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:43:0x00f0  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0106  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r13) {
        /*
            r12 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r12.label
            java.lang.String r2 = "sendShowUpdateDialogCmd, error: "
            r3 = 0
            r4 = 2
            r5 = 1
            if (r1 == 0) goto L_0x0036
            if (r1 == r5) goto L_0x0029
            if (r1 != r4) goto L_0x0021
            java.lang.Object r0 = r12.L$0
            java.lang.String r0 = (java.lang.String) r0
            kotlin.ResultKt.throwOnFailure(r13)     // Catch:{ TimeoutCancellationException -> 0x001d, Exception -> 0x001a }
            goto L_0x00b1
        L_0x001a:
            r13 = move-exception
            goto L_0x00bc
        L_0x001d:
            r13 = move-exception
            r4 = r0
            goto L_0x011c
        L_0x0021:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L_0x0029:
            java.lang.Object r1 = r12.L$1
            com.upuphone.xr.interconnect.entity.StarryNetDevice r1 = (com.upuphone.xr.interconnect.entity.StarryNetDevice) r1
            java.lang.Object r5 = r12.L$0
            java.lang.String r5 = (java.lang.String) r5
            kotlin.ResultKt.throwOnFailure(r13)
            r6 = r5
            goto L_0x007c
        L_0x0036:
            kotlin.ResultKt.throwOnFailure(r13)
            java.util.UUID r13 = java.util.UUID.randomUUID()
            java.lang.String r13 = r13.toString()
            java.lang.String r1 = "toString(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r13, r1)
            com.upuphone.xr.sapp.glass.GlassHelper r1 = com.upuphone.xr.sapp.glass.GlassHelper.f7049a
            com.upuphone.xr.interconnect.entity.StarryNetDevice r1 = r1.x()
            if (r1 != 0) goto L_0x0065
            com.upuphone.xr.sapp.glass.GlassUpdateAdapter r13 = com.upuphone.xr.sapp.glass.GlassUpdateAdapter.b
            java.lang.String r0 = "sendShowUpdateDialogCmd, device is null"
            r13.v(r0)
            kotlin.jvm.functions.Function1<com.upuphone.xr.sapp.entity.GlassUpdateState, kotlin.Unit> r13 = r12.$stateCallback
            com.upuphone.xr.sapp.entity.GlassUpdateState$UpdateDisconnected r0 = new com.upuphone.xr.sapp.entity.GlassUpdateState$UpdateDisconnected
            com.upuphone.star.fota.phone.GlassUpdateInfo r12 = r12.$glassUpdateInfo
            r0.<init>(r12)
            r13.invoke(r0)
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        L_0x0065:
            com.upuphone.xr.sapp.glass.GlassUpdateAdapter r6 = com.upuphone.xr.sapp.glass.GlassUpdateAdapter.b
            com.upuphone.star.fota.phone.GlassUpdateInfo r7 = r12.$glassUpdateInfo
            long r7 = com.upuphone.xr.sapp.glass.GlassExtKt.a(r7)
            r12.L$0 = r13
            r12.L$1 = r1
            r12.label = r5
            java.lang.Object r5 = r6.e(r1, r7, r12)
            if (r5 != r0) goto L_0x007a
            return r0
        L_0x007a:
            r6 = r13
            r13 = r5
        L_0x007c:
            java.lang.Number r13 = (java.lang.Number) r13
            int r8 = r13.intValue()
            if (r8 == 0) goto L_0x0098
            kotlin.jvm.functions.Function1<com.upuphone.xr.sapp.entity.GlassUpdateState, kotlin.Unit> r13 = r12.$stateCallback
            com.upuphone.xr.sapp.entity.GlassUpdateState$TransferFail r0 = new com.upuphone.xr.sapp.entity.GlassUpdateState$TransferFail
            com.upuphone.star.fota.phone.GlassUpdateInfo r7 = r12.$glassUpdateInfo
            r10 = 8
            r11 = 0
            r9 = 0
            r5 = r0
            r5.<init>(r6, r7, r8, r9, r10, r11)
            r13.invoke(r0)
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        L_0x0098:
            com.upuphone.xr.sapp.glass.GlassUpdateAdapter r13 = com.upuphone.xr.sapp.glass.GlassUpdateAdapter.b     // Catch:{ TimeoutCancellationException -> 0x00b9, Exception -> 0x00b6 }
            java.lang.String r5 = "sendShowUpdateDialogCmd, start"
            r13.t(r5)     // Catch:{ TimeoutCancellationException -> 0x00b9, Exception -> 0x00b6 }
            com.upuphone.xr.sapp.glass.IGlassUpdater r13 = r13.q(r1)     // Catch:{ TimeoutCancellationException -> 0x00b9, Exception -> 0x00b6 }
            r12.L$0 = r6     // Catch:{ TimeoutCancellationException -> 0x00b9, Exception -> 0x00b6 }
            r12.L$1 = r3     // Catch:{ TimeoutCancellationException -> 0x00b9, Exception -> 0x00b6 }
            r12.label = r4     // Catch:{ TimeoutCancellationException -> 0x00b9, Exception -> 0x00b6 }
            java.lang.Object r13 = r13.a(r12)     // Catch:{ TimeoutCancellationException -> 0x00b9, Exception -> 0x00b6 }
            if (r13 != r0) goto L_0x00b0
            return r0
        L_0x00b0:
            r0 = r6
        L_0x00b1:
            com.upuphone.xr.sapp.entity.BasicGlassResponse r13 = (com.upuphone.xr.sapp.entity.BasicGlassResponse) r13     // Catch:{ TimeoutCancellationException -> 0x001d, Exception -> 0x001a }
            r3 = r13
        L_0x00b4:
            r5 = r0
            goto L_0x00d1
        L_0x00b6:
            r13 = move-exception
            r0 = r6
            goto L_0x00bc
        L_0x00b9:
            r13 = move-exception
            r4 = r6
            goto L_0x011c
        L_0x00bc:
            com.upuphone.xr.sapp.glass.GlassUpdateAdapter r1 = com.upuphone.xr.sapp.glass.GlassUpdateAdapter.b
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r2)
            r4.append(r13)
            java.lang.String r13 = r4.toString()
            r1.v(r13)
            goto L_0x00b4
        L_0x00d1:
            com.upuphone.xr.sapp.glass.GlassUpdateAdapter r13 = com.upuphone.xr.sapp.glass.GlassUpdateAdapter.b
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "sendShowUpdateDialogCmd, response: "
            r0.append(r1)
            r0.append(r3)
            java.lang.String r0 = r0.toString()
            r13.t(r0)
            if (r3 == 0) goto L_0x0106
            boolean r0 = r3.isSuccess()
            if (r0 != 0) goto L_0x00f0
            goto L_0x0106
        L_0x00f0:
            kotlin.jvm.functions.Function1<com.upuphone.xr.sapp.entity.GlassUpdateState, kotlin.Unit> r0 = r12.$stateCallback
            com.upuphone.xr.sapp.entity.GlassUpdateState$WaitingUpdateDialogResult r1 = new com.upuphone.xr.sapp.entity.GlassUpdateState$WaitingUpdateDialogResult
            com.upuphone.star.fota.phone.GlassUpdateInfo r2 = r12.$glassUpdateInfo
            java.io.File r12 = r12.$downloadFile
            r1.<init>(r2, r12)
            r0.invoke(r1)
            java.lang.String r12 = "sendShowUpdateDialogCmd, WaitingUpdateDialogResult"
            r13.t(r12)
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        L_0x0106:
            kotlin.jvm.functions.Function1<com.upuphone.xr.sapp.entity.GlassUpdateState, kotlin.Unit> r13 = r12.$stateCallback
            com.upuphone.xr.sapp.entity.GlassUpdateState$TransferFail r0 = new com.upuphone.xr.sapp.entity.GlassUpdateState$TransferFail
            com.upuphone.star.fota.phone.GlassUpdateInfo r6 = r12.$glassUpdateInfo
            r9 = 8
            r10 = 0
            r7 = 107(0x6b, float:1.5E-43)
            r8 = 0
            r4 = r0
            r4.<init>(r5, r6, r7, r8, r9, r10)
            r13.invoke(r0)
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        L_0x011c:
            com.upuphone.xr.sapp.glass.GlassUpdateAdapter r0 = com.upuphone.xr.sapp.glass.GlassUpdateAdapter.b
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r2)
            r1.append(r13)
            java.lang.String r13 = r1.toString()
            r0.v(r13)
            kotlin.jvm.functions.Function1<com.upuphone.xr.sapp.entity.GlassUpdateState, kotlin.Unit> r13 = r12.$stateCallback
            com.upuphone.xr.sapp.entity.GlassUpdateState$TransferFail r0 = new com.upuphone.xr.sapp.entity.GlassUpdateState$TransferFail
            com.upuphone.star.fota.phone.GlassUpdateInfo r5 = r12.$glassUpdateInfo
            r8 = 8
            r9 = 0
            r6 = 108(0x6c, float:1.51E-43)
            r7 = 0
            r3 = r0
            r3.<init>(r4, r5, r6, r7, r8, r9)
            r13.invoke(r0)
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.glass.GlassUpdateAdapter$sendShowUpdateDialogCmd$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((GlassUpdateAdapter$sendShowUpdateDialogCmd$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
