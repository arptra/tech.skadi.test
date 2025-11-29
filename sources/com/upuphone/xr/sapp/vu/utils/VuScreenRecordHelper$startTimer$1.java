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
@DebugMetadata(c = "com.upuphone.xr.sapp.vu.utils.VuScreenRecordHelper$startTimer$1", f = "VuScreenRecordHelper.kt", i = {}, l = {245, 252}, m = "invokeSuspend", n = {}, s = {})
public final class VuScreenRecordHelper$startTimer$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ VuScreenRecordHelper this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VuScreenRecordHelper$startTimer$1(VuScreenRecordHelper vuScreenRecordHelper, Continuation<? super VuScreenRecordHelper$startTimer$1> continuation) {
        super(2, continuation);
        this.this$0 = vuScreenRecordHelper;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new VuScreenRecordHelper$startTimer$1(this.this$0, continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0063  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r9) {
        /*
            r8 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r8.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x001e
            if (r1 == r3) goto L_0x001a
            if (r1 != r2) goto L_0x0012
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x0076
        L_0x0012:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x001a:
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x0047
        L_0x001e:
            kotlin.ResultKt.throwOnFailure(r9)
            com.upuphone.xr.sapp.vu.utils.VuScreenRecordHelper r9 = r8.this$0
            r1 = 0
            r9.h = r1
        L_0x0027:
            com.upuphone.xr.sapp.vu.utils.VuScreenRecordHelper r9 = r8.this$0
            boolean r9 = r9.f
            if (r9 == 0) goto L_0x0063
            com.upuphone.xr.sapp.vu.utils.VuScreenRecordHelper r9 = r8.this$0
            int r9 = r9.h
            long r4 = (long) r9
            r6 = 60
            int r9 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r9 >= 0) goto L_0x0063
            r8.label = r3
            r4 = 1000(0x3e8, double:4.94E-321)
            java.lang.Object r9 = kotlinx.coroutines.DelayKt.b(r4, r8)
            if (r9 != r0) goto L_0x0047
            return r0
        L_0x0047:
            com.upuphone.xr.sapp.vu.utils.VuScreenRecordHelper r9 = r8.this$0
            int r1 = r9.h
            int r1 = r1 + r3
            r9.h = r1
            com.upuphone.xr.sapp.vu.utils.VuScreenRecordHelper r9 = r8.this$0
            boolean r9 = r9.f
            if (r9 == 0) goto L_0x0027
            com.upuphone.xr.sapp.vu.utils.VuScreenRecordHelper r9 = r8.this$0
            int r1 = r9.h
            r9.U(r1)
            goto L_0x0027
        L_0x0063:
            com.upuphone.xr.sapp.vu.utils.VuScreenRecordHelper r9 = r8.this$0
            boolean r9 = r9.f
            if (r9 == 0) goto L_0x0076
            com.upuphone.xr.sapp.vu.utils.VuScreenRecordHelper r9 = r8.this$0
            r8.label = r2
            java.lang.Object r8 = r9.A(r8)
            if (r8 != r0) goto L_0x0076
            return r0
        L_0x0076:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.vu.utils.VuScreenRecordHelper$startTimer$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((VuScreenRecordHelper$startTimer$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
