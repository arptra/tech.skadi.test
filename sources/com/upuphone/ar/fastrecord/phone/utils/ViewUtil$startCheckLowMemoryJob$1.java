package com.upuphone.ar.fastrecord.phone.utils;

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
@DebugMetadata(c = "com.upuphone.ar.fastrecord.phone.utils.ViewUtil$startCheckLowMemoryJob$1", f = "ViewUtil.kt", i = {}, l = {76}, m = "invokeSuspend", n = {}, s = {})
public final class ViewUtil$startCheckLowMemoryJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int I$0;
    int I$1;
    int label;

    public ViewUtil$startCheckLowMemoryJob$1(Continuation<? super ViewUtil$startCheckLowMemoryJob$1> continuation) {
        super(2, continuation);
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new ViewUtil$startCheckLowMemoryJob$1(continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r11) {
        /*
            r10 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r10.label
            r2 = 1
            if (r1 == 0) goto L_0x001b
            if (r1 != r2) goto L_0x0013
            int r1 = r10.I$1
            int r3 = r10.I$0
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x0034
        L_0x0013:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L_0x001b:
            kotlin.ResultKt.throwOnFailure(r11)
            r11 = 2147483647(0x7fffffff, float:NaN)
            r1 = 0
            r3 = r11
        L_0x0023:
            if (r1 >= r3) goto L_0x00ac
            r10.I$0 = r3
            r10.I$1 = r1
            r10.label = r2
            r4 = 10000(0x2710, double:4.9407E-320)
            java.lang.Object r11 = kotlinx.coroutines.DelayKt.b(r4, r10)
            if (r11 != r0) goto L_0x0034
            return r0
        L_0x0034:
            boolean r11 = com.upuphone.ar.fastrecord.phone.utils.MemoryUtils.checkFreeDiskIsLack()
            if (r11 == 0) goto L_0x00a9
            com.upuphone.ar.fastrecord.phone.starrynet.RecordInterConnectHelper$Companion r11 = com.upuphone.ar.fastrecord.phone.starrynet.RecordInterConnectHelper.Companion
            com.upuphone.ar.fastrecord.phone.starrynet.RecordInterConnectHelper r11 = r11.getInstance()
            r11.sendMsgLowMemory()
            com.upuphone.ar.fastrecord.phone.FastRecordManager$Companion r11 = com.upuphone.ar.fastrecord.phone.FastRecordManager.Companion
            com.upuphone.ar.fastrecord.phone.FastRecordManager r4 = r11.getInstance()
            com.upuphone.ar.fastrecord.phone.ui.viewmodel.FastRecordAppViewModel r4 = r4.appViewModel()
            long r4 = r4.getRecordIngId()
            com.upuphone.ar.fastrecord.phone.FastRecordManager r6 = r11.getInstance()
            com.upuphone.ar.fastrecord.phone.ui.viewmodel.FastRecordAppViewModel r6 = r6.appViewModel()
            int r6 = r6.getRecordIngType()
            com.upuphone.ar.fastrecord.phone.FastRecordManager r7 = r11.getInstance()
            com.upuphone.ar.fastrecord.phone.db.FastRecordDao r7 = r7.fastRecordDao()
            r8 = 2
            r7.updateRecordIngState(r4, r8)
            com.upuphone.ar.fastrecord.phone.starrynet.bean.glass.RecordGlassStatus r7 = new com.upuphone.ar.fastrecord.phone.starrynet.bean.glass.RecordGlassStatus
            r7.<init>(r6, r8, r4)
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "checkFreeDiskIsLack send sendMsgLowMemory recordId = "
            r8.append(r9)
            r8.append(r4)
            java.lang.String r4 = ",type = "
            r8.append(r4)
            r8.append(r6)
            java.lang.String r4 = " status = "
            r8.append(r4)
            r8.append(r7)
            java.lang.String r4 = r8.toString()
            java.lang.String r5 = "ViewUtil"
            com.upuphone.ar.fastrecord.phone.ext.LogExt.logE(r4, r5)
            com.upuphone.ar.fastrecord.phone.FastRecordManager r11 = r11.getInstance()
            com.upuphone.ar.fastrecord.phone.ui.viewmodel.FastRecordAppViewModel r11 = r11.appViewModel()
            r11.updateStartRecordDetailIng(r7)
            kotlinx.coroutines.Job r11 = com.upuphone.ar.fastrecord.phone.utils.ViewUtil.checkMemoryJob
            if (r11 == 0) goto L_0x00a9
            r4 = 0
            kotlinx.coroutines.Job.DefaultImpls.a(r11, r4, r2, r4)
        L_0x00a9:
            int r1 = r1 + r2
            goto L_0x0023
        L_0x00ac:
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.fastrecord.phone.utils.ViewUtil$startCheckLowMemoryJob$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((ViewUtil$startCheckLowMemoryJob$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
