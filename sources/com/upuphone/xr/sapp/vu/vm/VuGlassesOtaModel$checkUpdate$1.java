package com.upuphone.xr.sapp.vu.vm;

import com.upuphone.xr.sapp.entity.DeviceInfo;
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
@DebugMetadata(c = "com.upuphone.xr.sapp.vu.vm.VuGlassesOtaModel$checkUpdate$1", f = "VuGlassesOtaModel.kt", i = {0, 1, 2, 2}, l = {107, 108, 109, 116, 118}, m = "invokeSuspend", n = {"deviceInfo", "deviceInfo", "deviceInfo", "otaInfo"}, s = {"L$0", "L$0", "L$0", "L$1"})
public final class VuGlassesOtaModel$checkUpdate$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ DeviceInfo $info;
    Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VuGlassesOtaModel$checkUpdate$1(DeviceInfo deviceInfo, Continuation<? super VuGlassesOtaModel$checkUpdate$1> continuation) {
        super(2, continuation);
        this.$info = deviceInfo;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new VuGlassesOtaModel$checkUpdate$1(this.$info, continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x0093 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00ed  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r10) {
        /*
            r9 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r9.label
            r2 = 5
            r3 = 4
            r4 = 3
            r5 = 1
            r6 = 2
            r7 = 0
            if (r1 == 0) goto L_0x0042
            if (r1 == r5) goto L_0x003a
            if (r1 == r6) goto L_0x0032
            if (r1 == r4) goto L_0x0026
            if (r1 == r3) goto L_0x0021
            if (r1 != r2) goto L_0x0019
            goto L_0x0021
        L_0x0019:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x0021:
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x0102
        L_0x0026:
            java.lang.Object r1 = r9.L$1
            com.upuphone.xr.sapp.vu.ota.VuUpdateInfo r1 = (com.upuphone.xr.sapp.vu.ota.VuUpdateInfo) r1
            java.lang.Object r4 = r9.L$0
            com.upuphone.xr.sapp.entity.DeviceInfo r4 = (com.upuphone.xr.sapp.entity.DeviceInfo) r4
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x0096
        L_0x0032:
            java.lang.Object r1 = r9.L$0
            com.upuphone.xr.sapp.entity.DeviceInfo r1 = (com.upuphone.xr.sapp.entity.DeviceInfo) r1
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x0083
        L_0x003a:
            java.lang.Object r1 = r9.L$0
            com.upuphone.xr.sapp.entity.DeviceInfo r1 = (com.upuphone.xr.sapp.entity.DeviceInfo) r1
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x0074
        L_0x0042:
            kotlin.ResultKt.throwOnFailure(r10)
            com.upuphone.xr.sapp.entity.DeviceInfo r10 = r9.$info
            if (r10 != 0) goto L_0x004f
            com.upuphone.xr.sapp.vu.vm.VuGlassesDeviceInfoModel r10 = com.upuphone.xr.sapp.vu.vm.VuGlassesDeviceInfoModel.f8112a
            com.upuphone.xr.sapp.entity.DeviceInfo r10 = r10.d()
        L_0x004f:
            r1 = r10
            com.upuphone.xr.sapp.vu.vm.VuGlassesOtaModel r10 = com.upuphone.xr.sapp.vu.vm.VuGlassesOtaModel.f8117a
            boolean r8 = r10.I(r1)
            if (r8 != 0) goto L_0x0064
            com.upuphone.star.core.log.ULog$Delegate r9 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.String r10 = "VuGlassesOtaModel"
            java.lang.String r0 = "should not check update"
            r9.a(r10, r0)
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        L_0x0064:
            com.upuphone.xr.sapp.vu.ota.VuUpdateStatus r8 = new com.upuphone.xr.sapp.vu.ota.VuUpdateStatus
            r8.<init>(r5, r7, r6, r7)
            r9.L$0 = r1
            r9.label = r5
            java.lang.Object r10 = r10.C(r8, r9)
            if (r10 != r0) goto L_0x0074
            return r0
        L_0x0074:
            com.upuphone.xr.sapp.vu.ota.VuGlassUpdateHelper r10 = com.upuphone.xr.sapp.vu.vm.VuGlassesOtaModel.e
            r9.L$0 = r1
            r9.label = r6
            java.lang.Object r10 = r10.b(r1, r9)
            if (r10 != r0) goto L_0x0083
            return r0
        L_0x0083:
            com.upuphone.xr.sapp.vu.ota.VuUpdateInfo r10 = (com.upuphone.xr.sapp.vu.ota.VuUpdateInfo) r10
            com.upuphone.xr.sapp.vu.vm.VuGlassesOtaModel r8 = com.upuphone.xr.sapp.vu.vm.VuGlassesOtaModel.f8117a
            r9.L$0 = r1
            r9.L$1 = r10
            r9.label = r4
            java.lang.Object r4 = r8.D(r10, r9)
            if (r4 != r0) goto L_0x0094
            return r0
        L_0x0094:
            r4 = r1
            r1 = r10
        L_0x0096:
            if (r1 == 0) goto L_0x00ed
            boolean r10 = r1.h()
            if (r10 != r5) goto L_0x00ed
            com.upuphone.xr.sapp.vu.vm.VuGlassesOtaModel$GlassUpdateReportInfo r10 = com.upuphone.xr.sapp.vu.vm.VuGlassesOtaModel.j
            java.lang.String r2 = r4.getSerialNo()
            if (r2 != 0) goto L_0x00aa
            java.lang.String r2 = ""
        L_0x00aa:
            r10.q(r2)
            com.upuphone.xr.sapp.vu.vm.VuGlassesOtaModel$GlassUpdateReportInfo r10 = com.upuphone.xr.sapp.vu.vm.VuGlassesOtaModel.j
            java.lang.String r2 = r1.a()
            r10.p(r2)
            com.upuphone.xr.sapp.vu.vm.VuGlassesOtaModel$GlassUpdateReportInfo r10 = com.upuphone.xr.sapp.vu.vm.VuGlassesOtaModel.j
            java.lang.String r2 = r4.getModel()
            r10.m(r2)
            com.upuphone.xr.sapp.vu.vm.VuGlassesOtaModel$GlassUpdateReportInfo r10 = com.upuphone.xr.sapp.vu.vm.VuGlassesOtaModel.j
            java.lang.String r2 = r1.a()
            r10.s(r2)
            com.upuphone.xr.sapp.vu.vm.VuGlassesOtaModel$GlassUpdateReportInfo r10 = com.upuphone.xr.sapp.vu.vm.VuGlassesOtaModel.j
            java.lang.String r1 = r1.g()
            r10.l(r1)
            com.upuphone.xr.sapp.vu.vm.VuGlassesOtaModel r10 = com.upuphone.xr.sapp.vu.vm.VuGlassesOtaModel.f8117a
            com.upuphone.xr.sapp.vu.ota.VuUpdateStatus r1 = new com.upuphone.xr.sapp.vu.ota.VuUpdateStatus
            r1.<init>(r6, r7, r6, r7)
            r9.L$0 = r7
            r9.L$1 = r7
            r9.label = r3
            java.lang.Object r9 = r10.C(r1, r9)
            if (r9 != r0) goto L_0x0102
            return r0
        L_0x00ed:
            com.upuphone.xr.sapp.vu.vm.VuGlassesOtaModel r10 = com.upuphone.xr.sapp.vu.vm.VuGlassesOtaModel.f8117a
            com.upuphone.xr.sapp.vu.ota.VuUpdateStatus r1 = new com.upuphone.xr.sapp.vu.ota.VuUpdateStatus
            r3 = 0
            r1.<init>(r3, r7, r6, r7)
            r9.L$0 = r7
            r9.L$1 = r7
            r9.label = r2
            java.lang.Object r9 = r10.C(r1, r9)
            if (r9 != r0) goto L_0x0102
            return r0
        L_0x0102:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.vu.vm.VuGlassesOtaModel$checkUpdate$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((VuGlassesOtaModel$checkUpdate$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
