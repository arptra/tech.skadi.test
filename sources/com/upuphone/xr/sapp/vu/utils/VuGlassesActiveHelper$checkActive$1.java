package com.upuphone.xr.sapp.vu.utils;

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
@DebugMetadata(c = "com.upuphone.xr.sapp.vu.utils.VuGlassesActiveHelper$checkActive$1", f = "VuGlassesActiveHelper.kt", i = {}, l = {40}, m = "invokeSuspend", n = {}, s = {})
public final class VuGlassesActiveHelper$checkActive$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    public VuGlassesActiveHelper$checkActive$1(Continuation<? super VuGlassesActiveHelper$checkActive$1> continuation) {
        super(2, continuation);
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new VuGlassesActiveHelper$checkActive$1(continuation);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:3|4|25|26|19|27|28) */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0070, code lost:
        com.upuphone.xr.sapp.vu.utils.VuGlassesActiveHelper.c = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0073, code lost:
        throw r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0012, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0065 */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r8) {
        /*
            r7 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r7.label
            java.lang.String r2 = "VuGlassesActiveHelper"
            r3 = 1
            r4 = 0
            if (r1 == 0) goto L_0x001c
            if (r1 != r3) goto L_0x0014
            kotlin.ResultKt.throwOnFailure(r8)     // Catch:{ CancellationException -> 0x0065 }
            goto L_0x0034
        L_0x0012:
            r7 = move-exception
            goto L_0x0070
        L_0x0014:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x001c:
            kotlin.ResultKt.throwOnFailure(r8)
            com.upuphone.xr.sapp.vu.utils.VuGlassesActiveHelper r8 = com.upuphone.xr.sapp.vu.utils.VuGlassesActiveHelper.f8097a     // Catch:{ CancellationException -> 0x0065 }
            long r5 = android.os.SystemClock.uptimeMillis()     // Catch:{ CancellationException -> 0x0065 }
            com.upuphone.xr.sapp.vu.utils.VuGlassesActiveHelper.e = r5     // Catch:{ CancellationException -> 0x0065 }
            r7.label = r3     // Catch:{ CancellationException -> 0x0065 }
            r5 = 300000(0x493e0, double:1.482197E-318)
            java.lang.Object r7 = kotlinx.coroutines.DelayKt.b(r5, r7)     // Catch:{ CancellationException -> 0x0065 }
            if (r7 != r0) goto L_0x0034
            return r0
        L_0x0034:
            com.upuphone.star.core.log.ULog$Delegate r7 = com.upuphone.star.core.log.ULog.f6446a     // Catch:{ CancellationException -> 0x0065 }
            java.lang.String r8 = "actived true"
            r7.a(r2, r8)     // Catch:{ CancellationException -> 0x0065 }
            com.upuphone.xr.sapp.vu.vm.VuGlassesDeviceInfoModel r8 = com.upuphone.xr.sapp.vu.vm.VuGlassesDeviceInfoModel.f8112a     // Catch:{ CancellationException -> 0x0065 }
            com.upuphone.xr.sapp.entity.DeviceInfo r8 = r8.d()     // Catch:{ CancellationException -> 0x0065 }
            java.lang.String r0 = r8.getSerialNo()     // Catch:{ CancellationException -> 0x0065 }
            if (r0 == 0) goto L_0x0057
            int r0 = r0.length()     // Catch:{ CancellationException -> 0x0065 }
            if (r0 != 0) goto L_0x004e
            goto L_0x0057
        L_0x004e:
            com.upuphone.xr.sapp.vu.utils.VuGlassesActiveHelper r7 = com.upuphone.xr.sapp.vu.utils.VuGlassesActiveHelper.f8097a     // Catch:{ CancellationException -> 0x0065 }
            r7.i(r8)     // Catch:{ CancellationException -> 0x0065 }
        L_0x0053:
            com.upuphone.xr.sapp.vu.utils.VuGlassesActiveHelper.c = r4
            goto L_0x006d
        L_0x0057:
            java.lang.String r8 = "report active sn is null"
            r7.a(r2, r8)     // Catch:{ CancellationException -> 0x0065 }
            com.upuphone.xr.sapp.vu.utils.VuGlassesActiveHelper.f = r3     // Catch:{ CancellationException -> 0x0065 }
            kotlin.Unit r7 = kotlin.Unit.INSTANCE     // Catch:{ CancellationException -> 0x0065 }
            com.upuphone.xr.sapp.vu.utils.VuGlassesActiveHelper.c = r4
            return r7
        L_0x0065:
            com.upuphone.star.core.log.ULog$Delegate r7 = com.upuphone.star.core.log.ULog.f6446a     // Catch:{ all -> 0x0012 }
            java.lang.String r8 = "check active job canceled"
            r7.a(r2, r8)     // Catch:{ all -> 0x0012 }
            goto L_0x0053
        L_0x006d:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        L_0x0070:
            com.upuphone.xr.sapp.vu.utils.VuGlassesActiveHelper.c = r4
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.vu.utils.VuGlassesActiveHelper$checkActive$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((VuGlassesActiveHelper$checkActive$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
