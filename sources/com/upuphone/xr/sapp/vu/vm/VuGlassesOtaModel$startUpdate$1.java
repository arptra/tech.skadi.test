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
@DebugMetadata(c = "com.upuphone.xr.sapp.vu.vm.VuGlassesOtaModel$startUpdate$1", f = "VuGlassesOtaModel.kt", i = {0, 4, 8, 12, 14, 14, 15}, l = {131, 136, 137, 138, 151, 163, 164, 165, 168, 173, 174, 175, 180, 181, 184, 188, 191, 193, 194, 197}, m = "invokeSuspend", n = {"$this$launch", "updateInfo", "updateInfo", "updateInfo", "result", "success", "result"}, s = {"L$0", "L$0", "L$0", "L$0", "L$0", "I$0", "L$0"})
public final class VuGlassesOtaModel$startUpdate$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int I$0;
    private /* synthetic */ Object L$0;
    int label;

    public VuGlassesOtaModel$startUpdate$1(Continuation<? super VuGlassesOtaModel$startUpdate$1> continuation) {
        super(2, continuation);
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        VuGlassesOtaModel$startUpdate$1 vuGlassesOtaModel$startUpdate$1 = new VuGlassesOtaModel$startUpdate$1(continuation);
        vuGlassesOtaModel$startUpdate$1.L$0 = obj;
        return vuGlassesOtaModel$startUpdate$1;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0097, code lost:
        r11 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00be, code lost:
        if (((java.lang.Boolean) r10).booleanValue() != false) goto L_0x0115;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00c0, code lost:
        com.upuphone.xr.sapp.vu.vm.VuGlassesOtaModel.j.k(java.lang.System.currentTimeMillis());
        com.upuphone.xr.sapp.vu.vm.VuGlassesOtaModel.j.o(false);
        com.upuphone.xr.sapp.vu.vm.VuGlassesOtaModel.j.n("usb not opened");
        r2 = com.upuphone.xr.sapp.vu.vm.VuGlassesOtaModel.f8117a;
        r4 = new com.upuphone.xr.sapp.vu.ota.VuUpdateStatus(5, kotlin.coroutines.jvm.internal.Boxing.boxBoolean(false));
        r0.L$0 = null;
        r0.label = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00ef, code lost:
        if (r2.C(r4, r0) != r1) goto L_0x00f2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00f1, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00f2, code lost:
        r2 = com.upuphone.xr.sapp.vu.vm.VuGlassesOtaModel.f8117a;
        r4 = new com.upuphone.xr.sapp.vu.ota.VuUpdateStatus(2, (java.lang.Object) null, 2, (kotlin.jvm.internal.DefaultConstructorMarker) null);
        r0.label = 3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0100, code lost:
        if (r2.C(r4, r0) != r1) goto L_0x0103;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0102, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0103, code lost:
        r2 = com.upuphone.xr.sapp.vu.vm.VuGlassesOtaModel.f8117a;
        r4 = com.upuphone.xr.sapp.vu.vm.VuGlassesOtaModel.j;
        r0.label = 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x010f, code lost:
        if (r2.G(r4, r0) != r1) goto L_0x0112;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0111, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0114, code lost:
        return kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0115, code lost:
        r2 = com.upuphone.xr.sapp.vu.vm.VuGlassesOtaModel.f8117a;
        r2.B();
        r2 = r2.w();
        kotlin.jvm.internal.Intrinsics.checkNotNull(r2);
        com.upuphone.xr.sapp.vu.vm.VuGlassesOtaModel.g = kotlinx.coroutines.BuildersKt__Builders_commonKt.b(r11, (kotlin.coroutines.CoroutineContext) null, (kotlinx.coroutines.CoroutineStart) null, new com.upuphone.xr.sapp.vu.vm.VuGlassesOtaModel$startUpdate$1.AnonymousClass1((kotlin.coroutines.Continuation<? super com.upuphone.xr.sapp.vu.vm.VuGlassesOtaModel$startUpdate$1.AnonymousClass1>) null), 3, (java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:?, code lost:
        r10 = com.upuphone.xr.sapp.vu.vm.VuGlassesOtaModel.g;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0136, code lost:
        if (r10 == null) goto L_0x0152;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0138, code lost:
        r0.L$0 = r2;
        r0.label = 5;
        r10 = r10.c(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0140, code lost:
        if (r10 != r1) goto L_0x0143;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0142, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0143, code lost:
        r10 = ((java.lang.Boolean) r10).booleanValue();
     */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r19) {
        /*
            r18 = this;
            r0 = r18
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 4
            r4 = 1
            java.lang.String r5 = "VuGlassesOtaModel"
            r6 = 5
            r7 = 2
            r8 = 0
            r9 = 0
            switch(r2) {
                case 0: goto L_0x0099;
                case 1: goto L_0x008e;
                case 2: goto L_0x008a;
                case 3: goto L_0x0085;
                case 4: goto L_0x0080;
                case 5: goto L_0x0075;
                case 6: goto L_0x0070;
                case 7: goto L_0x006b;
                case 8: goto L_0x0066;
                case 9: goto L_0x005d;
                case 10: goto L_0x0058;
                case 11: goto L_0x0053;
                case 12: goto L_0x004e;
                case 13: goto L_0x0045;
                case 14: goto L_0x003e;
                case 15: goto L_0x0033;
                case 16: goto L_0x002a;
                case 17: goto L_0x0025;
                case 18: goto L_0x0020;
                case 19: goto L_0x001b;
                case 20: goto L_0x001b;
                default: goto L_0x0013;
            }
        L_0x0013:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x001b:
            kotlin.ResultKt.throwOnFailure(r19)
            goto L_0x034c
        L_0x0020:
            kotlin.ResultKt.throwOnFailure(r19)
            goto L_0x0326
        L_0x0025:
            kotlin.ResultKt.throwOnFailure(r19)
            goto L_0x030f
        L_0x002a:
            java.lang.Object r2 = r0.L$0
            com.upuphone.xr.sapp.vu.ota.VuUpdateResult r2 = (com.upuphone.xr.sapp.vu.ota.VuUpdateResult) r2
            kotlin.ResultKt.throwOnFailure(r19)
            goto L_0x02f3
        L_0x0033:
            int r2 = r0.I$0
            java.lang.Object r3 = r0.L$0
            com.upuphone.xr.sapp.vu.ota.VuUpdateResult r3 = (com.upuphone.xr.sapp.vu.ota.VuUpdateResult) r3
            kotlin.ResultKt.throwOnFailure(r19)
            goto L_0x02be
        L_0x003e:
            kotlin.ResultKt.throwOnFailure(r19)
            r2 = r19
            goto L_0x027d
        L_0x0045:
            java.lang.Object r2 = r0.L$0
            com.upuphone.xr.sapp.vu.ota.VuUpdateInfo r2 = (com.upuphone.xr.sapp.vu.ota.VuUpdateInfo) r2
            kotlin.ResultKt.throwOnFailure(r19)
            goto L_0x026a
        L_0x004e:
            kotlin.ResultKt.throwOnFailure(r19)
            goto L_0x0236
        L_0x0053:
            kotlin.ResultKt.throwOnFailure(r19)
            goto L_0x0225
        L_0x0058:
            kotlin.ResultKt.throwOnFailure(r19)
            goto L_0x0213
        L_0x005d:
            java.lang.Object r2 = r0.L$0
            com.upuphone.xr.sapp.vu.ota.VuUpdateInfo r2 = (com.upuphone.xr.sapp.vu.ota.VuUpdateInfo) r2
            kotlin.ResultKt.throwOnFailure(r19)
            goto L_0x01d8
        L_0x0066:
            kotlin.ResultKt.throwOnFailure(r19)
            goto L_0x01c6
        L_0x006b:
            kotlin.ResultKt.throwOnFailure(r19)
            goto L_0x01b5
        L_0x0070:
            kotlin.ResultKt.throwOnFailure(r19)
            goto L_0x01a4
        L_0x0075:
            java.lang.Object r2 = r0.L$0
            com.upuphone.xr.sapp.vu.ota.VuUpdateInfo r2 = (com.upuphone.xr.sapp.vu.ota.VuUpdateInfo) r2
            kotlin.ResultKt.throwOnFailure(r19)     // Catch:{ CancellationException -> 0x014a }
            r10 = r19
            goto L_0x0143
        L_0x0080:
            kotlin.ResultKt.throwOnFailure(r19)
            goto L_0x0112
        L_0x0085:
            kotlin.ResultKt.throwOnFailure(r19)
            goto L_0x0103
        L_0x008a:
            kotlin.ResultKt.throwOnFailure(r19)
            goto L_0x00f2
        L_0x008e:
            java.lang.Object r2 = r0.L$0
            kotlinx.coroutines.CoroutineScope r2 = (kotlinx.coroutines.CoroutineScope) r2
            kotlin.ResultKt.throwOnFailure(r19)
            r10 = r19
        L_0x0097:
            r11 = r2
            goto L_0x00b8
        L_0x0099:
            kotlin.ResultKt.throwOnFailure(r19)
            java.lang.Object r2 = r0.L$0
            kotlinx.coroutines.CoroutineScope r2 = (kotlinx.coroutines.CoroutineScope) r2
            com.upuphone.xr.sapp.vu.vm.VuGlassesOtaModel$GlassUpdateReportInfo r10 = com.upuphone.xr.sapp.vu.vm.VuGlassesOtaModel.j
            long r11 = java.lang.System.currentTimeMillis()
            r10.r(r11)
            com.upuphone.xr.sapp.vu.utils.VuGlassesHidManager r10 = com.upuphone.xr.sapp.vu.utils.VuGlassesHidManager.f8100a
            r0.L$0 = r2
            r0.label = r4
            java.lang.Object r10 = r10.y(r0)
            if (r10 != r1) goto L_0x0097
            return r1
        L_0x00b8:
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r2 = r10.booleanValue()
            if (r2 != 0) goto L_0x0115
            com.upuphone.xr.sapp.vu.vm.VuGlassesOtaModel$GlassUpdateReportInfo r2 = com.upuphone.xr.sapp.vu.vm.VuGlassesOtaModel.j
            long r4 = java.lang.System.currentTimeMillis()
            r2.k(r4)
            com.upuphone.xr.sapp.vu.vm.VuGlassesOtaModel$GlassUpdateReportInfo r2 = com.upuphone.xr.sapp.vu.vm.VuGlassesOtaModel.j
            r2.o(r8)
            com.upuphone.xr.sapp.vu.vm.VuGlassesOtaModel$GlassUpdateReportInfo r2 = com.upuphone.xr.sapp.vu.vm.VuGlassesOtaModel.j
            java.lang.String r4 = "usb not opened"
            r2.n(r4)
            com.upuphone.xr.sapp.vu.vm.VuGlassesOtaModel r2 = com.upuphone.xr.sapp.vu.vm.VuGlassesOtaModel.f8117a
            com.upuphone.xr.sapp.vu.ota.VuUpdateStatus r4 = new com.upuphone.xr.sapp.vu.ota.VuUpdateStatus
            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r8)
            r4.<init>(r6, r5)
            r0.L$0 = r9
            r0.label = r7
            java.lang.Object r2 = r2.C(r4, r0)
            if (r2 != r1) goto L_0x00f2
            return r1
        L_0x00f2:
            com.upuphone.xr.sapp.vu.vm.VuGlassesOtaModel r2 = com.upuphone.xr.sapp.vu.vm.VuGlassesOtaModel.f8117a
            com.upuphone.xr.sapp.vu.ota.VuUpdateStatus r4 = new com.upuphone.xr.sapp.vu.ota.VuUpdateStatus
            r4.<init>(r7, r9, r7, r9)
            r5 = 3
            r0.label = r5
            java.lang.Object r2 = r2.C(r4, r0)
            if (r2 != r1) goto L_0x0103
            return r1
        L_0x0103:
            com.upuphone.xr.sapp.vu.vm.VuGlassesOtaModel r2 = com.upuphone.xr.sapp.vu.vm.VuGlassesOtaModel.f8117a
            com.upuphone.xr.sapp.vu.vm.VuGlassesOtaModel$GlassUpdateReportInfo r4 = com.upuphone.xr.sapp.vu.vm.VuGlassesOtaModel.j
            r0.label = r3
            java.lang.Object r0 = r2.G(r4, r0)
            if (r0 != r1) goto L_0x0112
            return r1
        L_0x0112:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x0115:
            com.upuphone.xr.sapp.vu.vm.VuGlassesOtaModel r2 = com.upuphone.xr.sapp.vu.vm.VuGlassesOtaModel.f8117a
            r2.B()
            com.upuphone.xr.sapp.vu.ota.VuUpdateInfo r2 = r2.w()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            com.upuphone.xr.sapp.vu.vm.VuGlassesOtaModel$startUpdate$1$1 r14 = new com.upuphone.xr.sapp.vu.vm.VuGlassesOtaModel$startUpdate$1$1
            r14.<init>(r2, r9)
            r15 = 3
            r16 = 0
            r12 = 0
            r13 = 0
            kotlinx.coroutines.Deferred r10 = kotlinx.coroutines.BuildersKt__Builders_commonKt.b(r11, r12, r13, r14, r15, r16)
            com.upuphone.xr.sapp.vu.vm.VuGlassesOtaModel.g = r10
            kotlinx.coroutines.Deferred r10 = com.upuphone.xr.sapp.vu.vm.VuGlassesOtaModel.g     // Catch:{ CancellationException -> 0x014a }
            if (r10 == 0) goto L_0x0152
            r0.L$0 = r2     // Catch:{ CancellationException -> 0x014a }
            r0.label = r6     // Catch:{ CancellationException -> 0x014a }
            java.lang.Object r10 = r10.c(r0)     // Catch:{ CancellationException -> 0x014a }
            if (r10 != r1) goto L_0x0143
            return r1
        L_0x0143:
            java.lang.Boolean r10 = (java.lang.Boolean) r10     // Catch:{ CancellationException -> 0x014a }
            boolean r10 = r10.booleanValue()     // Catch:{ CancellationException -> 0x014a }
            goto L_0x0153
        L_0x014a:
            com.upuphone.star.core.log.ULog$Delegate r10 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.String r11 = "update canceled"
            r10.a(r5, r11)
        L_0x0152:
            r10 = r8
        L_0x0153:
            com.upuphone.star.core.log.ULog$Delegate r11 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r13 = "startUpdate updateResult="
            r12.append(r13)
            r12.append(r10)
            java.lang.String r12 = r12.toString()
            r11.a(r5, r12)
            com.upuphone.xr.sapp.vu.vm.VuGlassesOtaModel.g = r9
            com.upuphone.xr.sapp.vu.vm.VuGlassesOtaModel r11 = com.upuphone.xr.sapp.vu.vm.VuGlassesOtaModel.f8117a
            r11.K()
            if (r10 != 0) goto L_0x01c9
            com.upuphone.xr.sapp.vu.vm.VuGlassesOtaModel$GlassUpdateReportInfo r2 = com.upuphone.xr.sapp.vu.vm.VuGlassesOtaModel.j
            long r3 = java.lang.System.currentTimeMillis()
            r2.k(r3)
            com.upuphone.xr.sapp.vu.vm.VuGlassesOtaModel$GlassUpdateReportInfo r2 = com.upuphone.xr.sapp.vu.vm.VuGlassesOtaModel.j
            r2.o(r8)
            com.upuphone.xr.sapp.vu.vm.VuGlassesOtaModel$GlassUpdateReportInfo r2 = com.upuphone.xr.sapp.vu.vm.VuGlassesOtaModel.j
            java.lang.String r3 = "install rom fail"
            r2.n(r3)
            com.upuphone.xr.sapp.vu.ota.VuUpdateStatus r2 = new com.upuphone.xr.sapp.vu.ota.VuUpdateStatus
            java.lang.Boolean r3 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r8)
            r2.<init>(r6, r3)
            r0.L$0 = r9
            r3 = 6
            r0.label = r3
            java.lang.Object r2 = r11.C(r2, r0)
            if (r2 != r1) goto L_0x01a4
            return r1
        L_0x01a4:
            com.upuphone.xr.sapp.vu.vm.VuGlassesOtaModel r2 = com.upuphone.xr.sapp.vu.vm.VuGlassesOtaModel.f8117a
            com.upuphone.xr.sapp.vu.ota.VuUpdateStatus r3 = new com.upuphone.xr.sapp.vu.ota.VuUpdateStatus
            r3.<init>(r7, r9, r7, r9)
            r4 = 7
            r0.label = r4
            java.lang.Object r2 = r2.C(r3, r0)
            if (r2 != r1) goto L_0x01b5
            return r1
        L_0x01b5:
            com.upuphone.xr.sapp.vu.vm.VuGlassesOtaModel r2 = com.upuphone.xr.sapp.vu.vm.VuGlassesOtaModel.f8117a
            com.upuphone.xr.sapp.vu.vm.VuGlassesOtaModel$GlassUpdateReportInfo r3 = com.upuphone.xr.sapp.vu.vm.VuGlassesOtaModel.j
            r4 = 8
            r0.label = r4
            java.lang.Object r0 = r2.G(r3, r0)
            if (r0 != r1) goto L_0x01c6
            return r1
        L_0x01c6:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x01c9:
            r0.L$0 = r2
            r10 = 9
            r0.label = r10
            r10 = 100
            java.lang.Object r10 = kotlinx.coroutines.DelayKt.b(r10, r0)
            if (r10 != r1) goto L_0x01d8
            return r1
        L_0x01d8:
            com.upuphone.xr.sapp.vu.vm.VuGlassControlModel r10 = com.upuphone.xr.sapp.vu.vm.VuGlassControlModel.f8109a
            boolean r10 = r10.z()
            if (r10 != 0) goto L_0x0239
            com.upuphone.xr.sapp.vu.vm.VuGlassesOtaModel$GlassUpdateReportInfo r2 = com.upuphone.xr.sapp.vu.vm.VuGlassesOtaModel.j
            long r3 = java.lang.System.currentTimeMillis()
            r2.k(r3)
            com.upuphone.xr.sapp.vu.vm.VuGlassesOtaModel$GlassUpdateReportInfo r2 = com.upuphone.xr.sapp.vu.vm.VuGlassesOtaModel.j
            r2.o(r8)
            com.upuphone.xr.sapp.vu.vm.VuGlassesOtaModel$GlassUpdateReportInfo r2 = com.upuphone.xr.sapp.vu.vm.VuGlassesOtaModel.j
            java.lang.String r3 = "glasses disconnected"
            r2.n(r3)
            com.upuphone.xr.sapp.vu.vm.VuGlassesOtaModel r2 = com.upuphone.xr.sapp.vu.vm.VuGlassesOtaModel.f8117a
            com.upuphone.xr.sapp.vu.ota.VuUpdateStatus r3 = new com.upuphone.xr.sapp.vu.ota.VuUpdateStatus
            java.lang.Boolean r4 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r8)
            r3.<init>(r6, r4)
            r0.L$0 = r9
            r4 = 10
            r0.label = r4
            java.lang.Object r2 = r2.C(r3, r0)
            if (r2 != r1) goto L_0x0213
            return r1
        L_0x0213:
            com.upuphone.xr.sapp.vu.vm.VuGlassesOtaModel r2 = com.upuphone.xr.sapp.vu.vm.VuGlassesOtaModel.f8117a
            com.upuphone.xr.sapp.vu.ota.VuUpdateStatus r3 = new com.upuphone.xr.sapp.vu.ota.VuUpdateStatus
            r3.<init>(r7, r9, r7, r9)
            r4 = 11
            r0.label = r4
            java.lang.Object r2 = r2.C(r3, r0)
            if (r2 != r1) goto L_0x0225
            return r1
        L_0x0225:
            com.upuphone.xr.sapp.vu.vm.VuGlassesOtaModel r2 = com.upuphone.xr.sapp.vu.vm.VuGlassesOtaModel.f8117a
            com.upuphone.xr.sapp.vu.vm.VuGlassesOtaModel$GlassUpdateReportInfo r3 = com.upuphone.xr.sapp.vu.vm.VuGlassesOtaModel.j
            r4 = 12
            r0.label = r4
            java.lang.Object r0 = r2.G(r3, r0)
            if (r0 != r1) goto L_0x0236
            return r1
        L_0x0236:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x0239:
            com.upuphone.xr.sapp.vu.utils.VuGlassesHidUtil r10 = com.upuphone.xr.sapp.vu.utils.VuGlassesHidUtil.f8104a
            int r10 = r10.t()
            com.upuphone.star.core.log.ULog$Delegate r11 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r13 = "startUpdate rebootResult: "
            r12.append(r13)
            r12.append(r10)
            java.lang.String r10 = r12.toString()
            r11.a(r5, r10)
            com.upuphone.xr.sapp.vu.vm.VuGlassesOtaModel r10 = com.upuphone.xr.sapp.vu.vm.VuGlassesOtaModel.f8117a
            com.upuphone.xr.sapp.vu.ota.VuUpdateStatus r11 = new com.upuphone.xr.sapp.vu.ota.VuUpdateStatus
            r11.<init>(r3, r9, r7, r9)
            r0.L$0 = r2
            r3 = 13
            r0.label = r3
            java.lang.Object r3 = r10.C(r11, r0)
            if (r3 != r1) goto L_0x026a
            return r1
        L_0x026a:
            com.upuphone.xr.sapp.vu.vm.VuGlassesOtaModel r3 = com.upuphone.xr.sapp.vu.vm.VuGlassesOtaModel.f8117a
            java.lang.String r2 = r2.g()
            r0.L$0 = r9
            r10 = 14
            r0.label = r10
            java.lang.Object r2 = r3.t(r2, r0)
            if (r2 != r1) goto L_0x027d
            return r1
        L_0x027d:
            com.upuphone.xr.sapp.vu.ota.VuUpdateResult r2 = (com.upuphone.xr.sapp.vu.ota.VuUpdateResult) r2
            com.upuphone.star.core.log.ULog$Delegate r3 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r11 = "startUpdate checkVersion result="
            r10.append(r11)
            r10.append(r2)
            java.lang.String r10 = r10.toString()
            r3.a(r5, r10)
            int r3 = r2.a()
            if (r3 != 0) goto L_0x029e
            r3 = r4
            goto L_0x029f
        L_0x029e:
            r3 = r8
        L_0x029f:
            com.upuphone.xr.sapp.vu.vm.VuGlassesOtaModel r10 = com.upuphone.xr.sapp.vu.vm.VuGlassesOtaModel.f8117a
            com.upuphone.xr.sapp.vu.ota.VuUpdateStatus r11 = new com.upuphone.xr.sapp.vu.ota.VuUpdateStatus
            java.lang.Boolean r12 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)
            r11.<init>(r6, r12)
            r0.L$0 = r2
            r0.I$0 = r3
            r12 = 15
            r0.label = r12
            java.lang.Object r10 = r10.C(r11, r0)
            if (r10 != r1) goto L_0x02b9
            return r1
        L_0x02b9:
            r17 = r3
            r3 = r2
            r2 = r17
        L_0x02be:
            com.upuphone.xr.sapp.vu.vm.VuGlassesOtaModel$GlassUpdateReportInfo r10 = com.upuphone.xr.sapp.vu.vm.VuGlassesOtaModel.j
            if (r2 == 0) goto L_0x02c5
            goto L_0x02c6
        L_0x02c5:
            r4 = r8
        L_0x02c6:
            r10.o(r4)
            com.upuphone.xr.sapp.vu.vm.VuGlassesOtaModel$GlassUpdateReportInfo r2 = com.upuphone.xr.sapp.vu.vm.VuGlassesOtaModel.j
            long r10 = java.lang.System.currentTimeMillis()
            r2.k(r10)
            com.upuphone.xr.sapp.vu.vm.VuGlassesOtaModel$GlassUpdateReportInfo r2 = com.upuphone.xr.sapp.vu.vm.VuGlassesOtaModel.j
            java.lang.String r4 = r3.b()
            r2.n(r4)
            com.upuphone.xr.sapp.vu.vm.VuGlassesOtaModel r2 = com.upuphone.xr.sapp.vu.vm.VuGlassesOtaModel.f8117a
            com.upuphone.xr.sapp.vu.vm.VuGlassesOtaModel$GlassUpdateReportInfo r4 = com.upuphone.xr.sapp.vu.vm.VuGlassesOtaModel.j
            r0.L$0 = r3
            r10 = 16
            r0.label = r10
            java.lang.Object r2 = r2.G(r4, r0)
            if (r2 != r1) goto L_0x02f2
            return r1
        L_0x02f2:
            r2 = r3
        L_0x02f3:
            int r2 = r2.a()
            if (r2 != 0) goto L_0x0338
            com.upuphone.xr.sapp.vu.ota.VuGlassUpdateHelper r2 = com.upuphone.xr.sapp.vu.vm.VuGlassesOtaModel.e
            r2.c()
            r0.L$0 = r9
            r2 = 17
            r0.label = r2
            r2 = 2000(0x7d0, double:9.88E-321)
            java.lang.Object r2 = kotlinx.coroutines.DelayKt.b(r2, r0)
            if (r2 != r1) goto L_0x030f
            return r1
        L_0x030f:
            com.upuphone.xr.sapp.vu.ota.VuUpdateStatus r2 = com.upuphone.xr.sapp.vu.vm.VuGlassesOtaModel.c
            int r2 = r2.b()
            if (r2 != r6) goto L_0x034c
            com.upuphone.xr.sapp.vu.vm.VuGlassesOtaModel r2 = com.upuphone.xr.sapp.vu.vm.VuGlassesOtaModel.f8117a
            r3 = 18
            r0.label = r3
            java.lang.Object r2 = r2.D(r9, r0)
            if (r2 != r1) goto L_0x0326
            return r1
        L_0x0326:
            com.upuphone.xr.sapp.vu.vm.VuGlassesOtaModel r2 = com.upuphone.xr.sapp.vu.vm.VuGlassesOtaModel.f8117a
            com.upuphone.xr.sapp.vu.ota.VuUpdateStatus r3 = new com.upuphone.xr.sapp.vu.ota.VuUpdateStatus
            r3.<init>(r8, r9, r7, r9)
            r4 = 19
            r0.label = r4
            java.lang.Object r0 = r2.C(r3, r0)
            if (r0 != r1) goto L_0x034c
            return r1
        L_0x0338:
            com.upuphone.xr.sapp.vu.vm.VuGlassesOtaModel r2 = com.upuphone.xr.sapp.vu.vm.VuGlassesOtaModel.f8117a
            com.upuphone.xr.sapp.vu.ota.VuUpdateStatus r3 = new com.upuphone.xr.sapp.vu.ota.VuUpdateStatus
            r3.<init>(r7, r9, r7, r9)
            r0.L$0 = r9
            r4 = 20
            r0.label = r4
            java.lang.Object r0 = r2.C(r3, r0)
            if (r0 != r1) goto L_0x034c
            return r1
        L_0x034c:
            com.upuphone.star.core.log.ULog$Delegate r0 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.String r1 = "startUpdate end"
            r0.a(r5, r1)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.vu.vm.VuGlassesOtaModel$startUpdate$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((VuGlassesOtaModel$startUpdate$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
