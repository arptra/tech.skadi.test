package com.upuphone.ar.fastrecord.phone.starrynet;

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
@DebugMetadata(c = "com.upuphone.ar.fastrecord.phone.starrynet.RecordConnectManager$startCheckLocationJob$1", f = "RecordConnectManager.kt", i = {}, l = {216}, m = "invokeSuspend", n = {}, s = {})
public final class RecordConnectManager$startCheckLocationJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int I$0;
    int I$1;
    Object L$0;
    int label;
    final /* synthetic */ RecordConnectManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RecordConnectManager$startCheckLocationJob$1(RecordConnectManager recordConnectManager, Continuation<? super RecordConnectManager$startCheckLocationJob$1> continuation) {
        super(2, continuation);
        this.this$0 = recordConnectManager;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new RecordConnectManager$startCheckLocationJob$1(this.this$0, continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002e  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r9) {
        /*
            r8 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r8.label
            r2 = 1
            if (r1 == 0) goto L_0x001f
            if (r1 != r2) goto L_0x0017
            int r1 = r8.I$1
            int r3 = r8.I$0
            java.lang.Object r4 = r8.L$0
            com.upuphone.ar.fastrecord.phone.starrynet.RecordConnectManager r4 = (com.upuphone.ar.fastrecord.phone.starrynet.RecordConnectManager) r4
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x0062
        L_0x0017:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x001f:
            kotlin.ResultKt.throwOnFailure(r9)
            com.upuphone.ar.fastrecord.phone.starrynet.RecordConnectManager r9 = r8.this$0
            r1 = 2147483647(0x7fffffff, float:NaN)
            r3 = 0
            r4 = r9
            r7 = r3
            r3 = r1
            r1 = r7
        L_0x002c:
            if (r1 >= r3) goto L_0x0064
            com.upuphone.xr.interconnect.entity.NaviLocationInfo r9 = r4.location
            java.lang.String r5 = "FastRecordInterConnectHelper"
            if (r9 != 0) goto L_0x003f
            java.lang.String r9 = "null == location startLocation"
            com.upuphone.ar.fastrecord.phone.ext.LogExt.logW(r9, r5)
            r4.startLocation()
            goto L_0x0051
        L_0x003f:
            java.lang.String r9 = "checkLocation?.cancel()"
            com.upuphone.ar.fastrecord.phone.ext.LogExt.logW(r9, r5)
            kotlinx.coroutines.Job r9 = r4.checkLocationJob
            r5 = 0
            if (r9 == 0) goto L_0x004e
            kotlinx.coroutines.Job.DefaultImpls.a(r9, r5, r2, r5)
        L_0x004e:
            r4.checkLocationJob = r5
        L_0x0051:
            r8.L$0 = r4
            r8.I$0 = r3
            r8.I$1 = r1
            r8.label = r2
            r5 = 5000(0x1388, double:2.4703E-320)
            java.lang.Object r9 = kotlinx.coroutines.DelayKt.b(r5, r8)
            if (r9 != r0) goto L_0x0062
            return r0
        L_0x0062:
            int r1 = r1 + r2
            goto L_0x002c
        L_0x0064:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.fastrecord.phone.starrynet.RecordConnectManager$startCheckLocationJob$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((RecordConnectManager$startCheckLocationJob$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
