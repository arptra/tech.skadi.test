package com.upuphone.xr.sapp.vu.vm;

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
@DebugMetadata(c = "com.upuphone.xr.sapp.vu.vm.VuGlassesModel$openArSpace$1", f = "VuGlassesModel.kt", i = {2, 3}, l = {280, 290, 303, 324}, m = "invokeSuspend", n = {"modeResult", "displayId"}, s = {"I$0", "I$0"})
public final class VuGlassesModel$openArSpace$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $autoOpen;
    int I$0;
    int label;
    final /* synthetic */ VuGlassesModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VuGlassesModel$openArSpace$1(VuGlassesModel vuGlassesModel, boolean z, Continuation<? super VuGlassesModel$openArSpace$1> continuation) {
        super(2, continuation);
        this.this$0 = vuGlassesModel;
        this.$autoOpen = z;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new VuGlassesModel$openArSpace$1(this.this$0, this.$autoOpen, continuation);
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:55:0x01e2 */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00c3 A[Catch:{ CancellationException -> 0x01e2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00e5 A[Catch:{ CancellationException -> 0x01e2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0131 A[Catch:{ CancellationException -> 0x01e2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x016f A[Catch:{ CancellationException -> 0x01e2 }] */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r14) {
        /*
            r13 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r13.label
            r2 = 4
            r3 = 3
            java.lang.String r4 = "requireContext(...)"
            java.lang.String r5 = "requireActivity(...)"
            r6 = 2
            r7 = 1
            java.lang.String r8 = "VuGlassesModel"
            r9 = 0
            r10 = 0
            if (r1 == 0) goto L_0x003d
            if (r1 == r7) goto L_0x0039
            if (r1 == r6) goto L_0x0035
            if (r1 == r3) goto L_0x002e
            if (r1 != r2) goto L_0x0026
            int r0 = r13.I$0
            kotlin.ResultKt.throwOnFailure(r14)     // Catch:{ CancellationException -> 0x01e2 }
            goto L_0x0186
        L_0x0023:
            r14 = move-exception
            goto L_0x021a
        L_0x0026:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r14)
            throw r13
        L_0x002e:
            int r1 = r13.I$0
            kotlin.ResultKt.throwOnFailure(r14)     // Catch:{ CancellationException -> 0x01e2 }
            goto L_0x0112
        L_0x0035:
            kotlin.ResultKt.throwOnFailure(r14)     // Catch:{ CancellationException -> 0x01e2 }
            goto L_0x00a4
        L_0x0039:
            kotlin.ResultKt.throwOnFailure(r14)     // Catch:{ CancellationException -> 0x01e2 }
            goto L_0x0059
        L_0x003d:
            kotlin.ResultKt.throwOnFailure(r14)
            com.upuphone.xr.sapp.vu.vm.VuGlassesModel r14 = r13.this$0
            r14.h = r7
            kotlinx.coroutines.CoroutineDispatcher r14 = kotlinx.coroutines.Dispatchers.b()     // Catch:{ CancellationException -> 0x01e2 }
            com.upuphone.xr.sapp.vu.vm.VuGlassesModel$openArSpace$1$is7911Ready$1 r1 = new com.upuphone.xr.sapp.vu.vm.VuGlassesModel$openArSpace$1$is7911Ready$1     // Catch:{ CancellationException -> 0x01e2 }
            com.upuphone.xr.sapp.vu.vm.VuGlassesModel r11 = r13.this$0     // Catch:{ CancellationException -> 0x01e2 }
            r1.<init>(r11, r10)     // Catch:{ CancellationException -> 0x01e2 }
            r13.label = r7     // Catch:{ CancellationException -> 0x01e2 }
            java.lang.Object r14 = kotlinx.coroutines.BuildersKt.g(r14, r1, r13)     // Catch:{ CancellationException -> 0x01e2 }
            if (r14 != r0) goto L_0x0059
            return r0
        L_0x0059:
            java.lang.Boolean r14 = (java.lang.Boolean) r14     // Catch:{ CancellationException -> 0x01e2 }
            boolean r14 = r14.booleanValue()     // Catch:{ CancellationException -> 0x01e2 }
            if (r14 != 0) goto L_0x0090
            com.upuphone.star.common.phone.UToast$Companion r14 = com.upuphone.star.common.phone.UToast.f6444a     // Catch:{ CancellationException -> 0x01e2 }
            com.upuphone.xr.sapp.vu.vm.VuGlassesModel r0 = r13.this$0     // Catch:{ CancellationException -> 0x01e2 }
            com.xjmz.myvu.modules.home.HomeFragment r0 = r0.z()     // Catch:{ CancellationException -> 0x01e2 }
            android.content.Context r0 = r0.requireContext()     // Catch:{ CancellationException -> 0x01e2 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r4)     // Catch:{ CancellationException -> 0x01e2 }
            int r1 = com.upuphone.xr.sapp.R.string.switching_mode     // Catch:{ CancellationException -> 0x01e2 }
            r14.b(r0, r1)     // Catch:{ CancellationException -> 0x01e2 }
            com.upuphone.star.core.log.ULog$Delegate r14 = com.upuphone.star.core.log.ULog.f6446a     // Catch:{ CancellationException -> 0x01e2 }
            java.lang.String r0 = "openArSpace 7911 not ready"
            r14.a(r8, r0)     // Catch:{ CancellationException -> 0x01e2 }
            com.upuphone.xr.sapp.vu.utils.ArSpaceReportHelper r14 = com.upuphone.xr.sapp.vu.utils.ArSpaceReportHelper.f8088a     // Catch:{ CancellationException -> 0x01e2 }
            com.upuphone.xr.sapp.vu.utils.ArSpaceReportHelper$OpenArSpaceResult r0 = com.upuphone.xr.sapp.vu.utils.ArSpaceReportHelper.OpenArSpaceResult.DISPLAY_CHIP_NOT_READY     // Catch:{ CancellationException -> 0x01e2 }
            com.upuphone.xr.sapp.vu.utils.ArSpaceReportHelper.c(r14, r0, r10, r6, r10)     // Catch:{ CancellationException -> 0x01e2 }
            kotlin.Unit r14 = kotlin.Unit.INSTANCE     // Catch:{ CancellationException -> 0x01e2 }
        L_0x0085:
            com.upuphone.xr.sapp.vu.vm.VuGlassesModel r0 = r13.this$0
            r0.h = r9
            com.upuphone.xr.sapp.vu.vm.VuGlassesModel r13 = r13.this$0
            r13.P(r10)
            return r14
        L_0x0090:
            kotlinx.coroutines.CoroutineDispatcher r14 = kotlinx.coroutines.Dispatchers.b()     // Catch:{ CancellationException -> 0x01e2 }
            com.upuphone.xr.sapp.vu.vm.VuGlassesModel$openArSpace$1$modeResult$1 r1 = new com.upuphone.xr.sapp.vu.vm.VuGlassesModel$openArSpace$1$modeResult$1     // Catch:{ CancellationException -> 0x01e2 }
            com.upuphone.xr.sapp.vu.vm.VuGlassesModel r11 = r13.this$0     // Catch:{ CancellationException -> 0x01e2 }
            r1.<init>(r11, r10)     // Catch:{ CancellationException -> 0x01e2 }
            r13.label = r6     // Catch:{ CancellationException -> 0x01e2 }
            java.lang.Object r14 = kotlinx.coroutines.BuildersKt.g(r14, r1, r13)     // Catch:{ CancellationException -> 0x01e2 }
            if (r14 != r0) goto L_0x00a4
            return r0
        L_0x00a4:
            java.lang.Number r14 = (java.lang.Number) r14     // Catch:{ CancellationException -> 0x01e2 }
            int r1 = r14.intValue()     // Catch:{ CancellationException -> 0x01e2 }
            com.upuphone.star.core.log.ULog$Delegate r14 = com.upuphone.star.core.log.ULog.f6446a     // Catch:{ CancellationException -> 0x01e2 }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ CancellationException -> 0x01e2 }
            r11.<init>()     // Catch:{ CancellationException -> 0x01e2 }
            java.lang.String r12 = "mode result: "
            r11.append(r12)     // Catch:{ CancellationException -> 0x01e2 }
            r11.append(r1)     // Catch:{ CancellationException -> 0x01e2 }
            java.lang.String r11 = r11.toString()     // Catch:{ CancellationException -> 0x01e2 }
            r14.a(r8, r11)     // Catch:{ CancellationException -> 0x01e2 }
            r11 = -1
            if (r1 != r11) goto L_0x00e5
            com.upuphone.star.common.phone.UToast$Companion r14 = com.upuphone.star.common.phone.UToast.f6444a     // Catch:{ CancellationException -> 0x01e2 }
            com.upuphone.xr.sapp.vu.vm.VuGlassesModel r0 = r13.this$0     // Catch:{ CancellationException -> 0x01e2 }
            com.xjmz.myvu.modules.home.HomeFragment r0 = r0.z()     // Catch:{ CancellationException -> 0x01e2 }
            android.content.Context r0 = r0.requireContext()     // Catch:{ CancellationException -> 0x01e2 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r4)     // Catch:{ CancellationException -> 0x01e2 }
            int r2 = com.upuphone.xr.sapp.R.string.open_ar_space_error     // Catch:{ CancellationException -> 0x01e2 }
            r14.b(r0, r2)     // Catch:{ CancellationException -> 0x01e2 }
            com.upuphone.xr.sapp.vu.utils.ArSpaceReportHelper r14 = com.upuphone.xr.sapp.vu.utils.ArSpaceReportHelper.f8088a     // Catch:{ CancellationException -> 0x01e2 }
            com.upuphone.xr.sapp.vu.utils.ArSpaceReportHelper$OpenArSpaceResult r0 = com.upuphone.xr.sapp.vu.utils.ArSpaceReportHelper.OpenArSpaceResult.SET_3D_MODE_ERROR     // Catch:{ CancellationException -> 0x01e2 }
            java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch:{ CancellationException -> 0x01e2 }
            r14.b(r0, r1)     // Catch:{ CancellationException -> 0x01e2 }
            kotlin.Unit r14 = kotlin.Unit.INSTANCE     // Catch:{ CancellationException -> 0x01e2 }
            goto L_0x0085
        L_0x00e5:
            com.upuphone.xr.sapp.vu.VuTouchpadActivity$Companion r11 = com.upuphone.xr.sapp.vu.VuTouchpadActivity.w     // Catch:{ CancellationException -> 0x01e2 }
            com.upuphone.xr.sapp.vu.vm.VuGlassesModel r12 = r13.this$0     // Catch:{ CancellationException -> 0x01e2 }
            com.xjmz.myvu.modules.home.HomeFragment r12 = r12.z()     // Catch:{ CancellationException -> 0x01e2 }
            androidx.fragment.app.FragmentActivity r12 = r12.requireActivity()     // Catch:{ CancellationException -> 0x01e2 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, r5)     // Catch:{ CancellationException -> 0x01e2 }
            r11.e(r12)     // Catch:{ CancellationException -> 0x01e2 }
            java.lang.String r11 = "start touchpad activity"
            r14.a(r8, r11)     // Catch:{ CancellationException -> 0x01e2 }
            kotlinx.coroutines.MainCoroutineDispatcher r14 = kotlinx.coroutines.Dispatchers.c()     // Catch:{ CancellationException -> 0x01e2 }
            com.upuphone.xr.sapp.vu.vm.VuGlassesModel$openArSpace$1$displayId$1 r11 = new com.upuphone.xr.sapp.vu.vm.VuGlassesModel$openArSpace$1$displayId$1     // Catch:{ CancellationException -> 0x01e2 }
            com.upuphone.xr.sapp.vu.vm.VuGlassesModel r12 = r13.this$0     // Catch:{ CancellationException -> 0x01e2 }
            r11.<init>(r12, r10)     // Catch:{ CancellationException -> 0x01e2 }
            r13.I$0 = r1     // Catch:{ CancellationException -> 0x01e2 }
            r13.label = r3     // Catch:{ CancellationException -> 0x01e2 }
            java.lang.Object r14 = kotlinx.coroutines.BuildersKt.g(r14, r11, r13)     // Catch:{ CancellationException -> 0x01e2 }
            if (r14 != r0) goto L_0x0112
            return r0
        L_0x0112:
            java.lang.Number r14 = (java.lang.Number) r14     // Catch:{ CancellationException -> 0x01e2 }
            int r14 = r14.intValue()     // Catch:{ CancellationException -> 0x01e2 }
            com.upuphone.star.core.log.ULog$Delegate r3 = com.upuphone.star.core.log.ULog.f6446a     // Catch:{ CancellationException -> 0x01e2 }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ CancellationException -> 0x01e2 }
            r11.<init>()     // Catch:{ CancellationException -> 0x01e2 }
            java.lang.String r12 = "waitDisplayConnected result: "
            r11.append(r12)     // Catch:{ CancellationException -> 0x01e2 }
            r11.append(r14)     // Catch:{ CancellationException -> 0x01e2 }
            java.lang.String r11 = r11.toString()     // Catch:{ CancellationException -> 0x01e2 }
            r3.a(r8, r11)     // Catch:{ CancellationException -> 0x01e2 }
            if (r14 > 0) goto L_0x016f
            java.lang.String r14 = "openArSpace: set2D3DMode failed"
            r3.a(r8, r14)     // Catch:{ CancellationException -> 0x01e2 }
            boolean r14 = r13.$autoOpen     // Catch:{ CancellationException -> 0x01e2 }
            if (r14 != 0) goto L_0x014e
            com.upuphone.star.common.phone.UToast$Companion r14 = com.upuphone.star.common.phone.UToast.f6444a     // Catch:{ CancellationException -> 0x01e2 }
            com.upuphone.xr.sapp.vu.vm.VuGlassesModel r0 = r13.this$0     // Catch:{ CancellationException -> 0x01e2 }
            com.xjmz.myvu.modules.home.HomeFragment r0 = r0.z()     // Catch:{ CancellationException -> 0x01e2 }
            android.content.Context r0 = r0.requireContext()     // Catch:{ CancellationException -> 0x01e2 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r4)     // Catch:{ CancellationException -> 0x01e2 }
            int r2 = com.upuphone.xr.sapp.R.string.open_ar_space_error     // Catch:{ CancellationException -> 0x01e2 }
            r14.b(r0, r2)     // Catch:{ CancellationException -> 0x01e2 }
        L_0x014e:
            com.upuphone.xr.sapp.vu.VuTouchpadActivity$Companion r14 = com.upuphone.xr.sapp.vu.VuTouchpadActivity.w     // Catch:{ CancellationException -> 0x01e2 }
            com.upuphone.xr.sapp.vu.vm.VuGlassesModel r0 = r13.this$0     // Catch:{ CancellationException -> 0x01e2 }
            com.xjmz.myvu.modules.home.HomeFragment r0 = r0.z()     // Catch:{ CancellationException -> 0x01e2 }
            androidx.fragment.app.FragmentActivity r0 = r0.requireActivity()     // Catch:{ CancellationException -> 0x01e2 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r5)     // Catch:{ CancellationException -> 0x01e2 }
            r14.a(r0)     // Catch:{ CancellationException -> 0x01e2 }
            com.upuphone.xr.sapp.vu.utils.ArSpaceReportHelper r14 = com.upuphone.xr.sapp.vu.utils.ArSpaceReportHelper.f8088a     // Catch:{ CancellationException -> 0x01e2 }
            com.upuphone.xr.sapp.vu.utils.ArSpaceReportHelper$OpenArSpaceResult r0 = com.upuphone.xr.sapp.vu.utils.ArSpaceReportHelper.OpenArSpaceResult.SET_3D_MODE_ERROR     // Catch:{ CancellationException -> 0x01e2 }
            java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch:{ CancellationException -> 0x01e2 }
            r14.b(r0, r1)     // Catch:{ CancellationException -> 0x01e2 }
            kotlin.Unit r14 = kotlin.Unit.INSTANCE     // Catch:{ CancellationException -> 0x01e2 }
            goto L_0x0085
        L_0x016f:
            com.upuphone.xr.sapp.vu.utils.ArSpaceUtil r1 = com.upuphone.xr.sapp.vu.utils.ArSpaceUtil.f8089a     // Catch:{ CancellationException -> 0x01e2 }
            boolean r1 = r1.j()     // Catch:{ CancellationException -> 0x01e2 }
            if (r1 == 0) goto L_0x01c2
            com.upuphone.xr.sapp.vu.vm.VuGlassesModel r1 = r13.this$0     // Catch:{ CancellationException -> 0x01e2 }
            r13.I$0 = r14     // Catch:{ CancellationException -> 0x01e2 }
            r13.label = r2     // Catch:{ CancellationException -> 0x01e2 }
            java.lang.Object r1 = r1.x(r13)     // Catch:{ CancellationException -> 0x01e2 }
            if (r1 != r0) goto L_0x0184
            return r0
        L_0x0184:
            r0 = r14
            r14 = r1
        L_0x0186:
            java.lang.Boolean r14 = (java.lang.Boolean) r14     // Catch:{ CancellationException -> 0x01e2 }
            boolean r14 = r14.booleanValue()     // Catch:{ CancellationException -> 0x01e2 }
            if (r14 != 0) goto L_0x01c1
            com.upuphone.star.core.log.ULog$Delegate r0 = com.upuphone.star.core.log.ULog.f6446a     // Catch:{ CancellationException -> 0x01e2 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ CancellationException -> 0x01e2 }
            r1.<init>()     // Catch:{ CancellationException -> 0x01e2 }
            java.lang.String r2 = "openArSpace checkUsbAgain: "
            r1.append(r2)     // Catch:{ CancellationException -> 0x01e2 }
            r1.append(r14)     // Catch:{ CancellationException -> 0x01e2 }
            java.lang.String r14 = r1.toString()     // Catch:{ CancellationException -> 0x01e2 }
            r0.a(r8, r14)     // Catch:{ CancellationException -> 0x01e2 }
            com.upuphone.xr.sapp.vu.VuTouchpadActivity$Companion r14 = com.upuphone.xr.sapp.vu.VuTouchpadActivity.w     // Catch:{ CancellationException -> 0x01e2 }
            com.upuphone.xr.sapp.vu.vm.VuGlassesModel r0 = r13.this$0     // Catch:{ CancellationException -> 0x01e2 }
            com.xjmz.myvu.modules.home.HomeFragment r0 = r0.z()     // Catch:{ CancellationException -> 0x01e2 }
            androidx.fragment.app.FragmentActivity r0 = r0.requireActivity()     // Catch:{ CancellationException -> 0x01e2 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r5)     // Catch:{ CancellationException -> 0x01e2 }
            r14.a(r0)     // Catch:{ CancellationException -> 0x01e2 }
            com.upuphone.xr.sapp.vu.utils.ArSpaceReportHelper r14 = com.upuphone.xr.sapp.vu.utils.ArSpaceReportHelper.f8088a     // Catch:{ CancellationException -> 0x01e2 }
            com.upuphone.xr.sapp.vu.utils.ArSpaceReportHelper$OpenArSpaceResult r0 = com.upuphone.xr.sapp.vu.utils.ArSpaceReportHelper.OpenArSpaceResult.DOUBLE_CHECK_USB_FAIL     // Catch:{ CancellationException -> 0x01e2 }
            com.upuphone.xr.sapp.vu.utils.ArSpaceReportHelper.c(r14, r0, r10, r6, r10)     // Catch:{ CancellationException -> 0x01e2 }
            kotlin.Unit r14 = kotlin.Unit.INSTANCE     // Catch:{ CancellationException -> 0x01e2 }
            goto L_0x0085
        L_0x01c1:
            r14 = r0
        L_0x01c2:
            com.upuphone.xr.sapp.vu.VuTouchpadActivity$Companion r0 = com.upuphone.xr.sapp.vu.VuTouchpadActivity.w     // Catch:{ CancellationException -> 0x01e2 }
            com.upuphone.xr.sapp.vu.vm.VuGlassesModel r1 = r13.this$0     // Catch:{ CancellationException -> 0x01e2 }
            com.xjmz.myvu.modules.home.HomeFragment r1 = r1.z()     // Catch:{ CancellationException -> 0x01e2 }
            androidx.fragment.app.FragmentActivity r1 = r1.requireActivity()     // Catch:{ CancellationException -> 0x01e2 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r5)     // Catch:{ CancellationException -> 0x01e2 }
            boolean r2 = r13.$autoOpen     // Catch:{ CancellationException -> 0x01e2 }
            r2 = r2 ^ r7
            r0.d(r1, r14, r2)     // Catch:{ CancellationException -> 0x01e2 }
        L_0x01d7:
            com.upuphone.xr.sapp.vu.vm.VuGlassesModel r14 = r13.this$0
            r14.h = r9
            com.upuphone.xr.sapp.vu.vm.VuGlassesModel r13 = r13.this$0
            r13.P(r10)
            goto L_0x0217
        L_0x01e2:
            com.upuphone.star.core.log.ULog$Delegate r14 = com.upuphone.star.core.log.ULog.f6446a     // Catch:{ all -> 0x0023 }
            java.lang.String r0 = "openArSpaceJob canceled"
            r14.a(r8, r0)     // Catch:{ all -> 0x0023 }
            com.upuphone.star.common.phone.UToast$Companion r14 = com.upuphone.star.common.phone.UToast.f6444a     // Catch:{ all -> 0x0023 }
            com.upuphone.xr.sapp.vu.vm.VuGlassesModel r0 = r13.this$0     // Catch:{ all -> 0x0023 }
            com.xjmz.myvu.modules.home.HomeFragment r0 = r0.z()     // Catch:{ all -> 0x0023 }
            android.content.Context r0 = r0.requireContext()     // Catch:{ all -> 0x0023 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r4)     // Catch:{ all -> 0x0023 }
            int r1 = com.upuphone.xr.sapp.R.string.open_ar_space_error     // Catch:{ all -> 0x0023 }
            r14.b(r0, r1)     // Catch:{ all -> 0x0023 }
            com.upuphone.xr.sapp.vu.VuTouchpadActivity$Companion r14 = com.upuphone.xr.sapp.vu.VuTouchpadActivity.w     // Catch:{ all -> 0x0023 }
            com.upuphone.xr.sapp.vu.vm.VuGlassesModel r0 = r13.this$0     // Catch:{ all -> 0x0023 }
            com.xjmz.myvu.modules.home.HomeFragment r0 = r0.z()     // Catch:{ all -> 0x0023 }
            androidx.fragment.app.FragmentActivity r0 = r0.requireActivity()     // Catch:{ all -> 0x0023 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r5)     // Catch:{ all -> 0x0023 }
            r14.a(r0)     // Catch:{ all -> 0x0023 }
            com.upuphone.xr.sapp.vu.utils.ArSpaceReportHelper r14 = com.upuphone.xr.sapp.vu.utils.ArSpaceReportHelper.f8088a     // Catch:{ all -> 0x0023 }
            com.upuphone.xr.sapp.vu.utils.ArSpaceReportHelper$OpenArSpaceResult r0 = com.upuphone.xr.sapp.vu.utils.ArSpaceReportHelper.OpenArSpaceResult.CANCELED     // Catch:{ all -> 0x0023 }
            com.upuphone.xr.sapp.vu.utils.ArSpaceReportHelper.c(r14, r0, r10, r6, r10)     // Catch:{ all -> 0x0023 }
            goto L_0x01d7
        L_0x0217:
            kotlin.Unit r13 = kotlin.Unit.INSTANCE
            return r13
        L_0x021a:
            com.upuphone.xr.sapp.vu.vm.VuGlassesModel r0 = r13.this$0
            r0.h = r9
            com.upuphone.xr.sapp.vu.vm.VuGlassesModel r13 = r13.this$0
            r13.P(r10)
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.vu.vm.VuGlassesModel$openArSpace$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((VuGlassesModel$openArSpace$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
