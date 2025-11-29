package com.upuphone.xr.sapp.vu;

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
@DebugMetadata(c = "com.upuphone.xr.sapp.vu.VuTouchpadActivity$openArSpace$1", f = "VuTouchpadActivity.kt", i = {}, l = {253, 255, 256, 258}, m = "invokeSuspend", n = {}, s = {})
public final class VuTouchpadActivity$openArSpace$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $displayId;
    final /* synthetic */ boolean $showTip;
    int label;
    final /* synthetic */ VuTouchpadActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VuTouchpadActivity$openArSpace$1(VuTouchpadActivity vuTouchpadActivity, int i, boolean z, Continuation<? super VuTouchpadActivity$openArSpace$1> continuation) {
        super(2, continuation);
        this.this$0 = vuTouchpadActivity;
        this.$displayId = i;
        this.$showTip = z;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new VuTouchpadActivity$openArSpace$1(this.this$0, this.$displayId, this.$showTip, continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x006d A[RETURN] */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r8) {
        /*
            r7 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r7.label
            r2 = 4
            r3 = 3
            r4 = 2
            r5 = 1
            if (r1 == 0) goto L_0x0028
            if (r1 == r5) goto L_0x0024
            if (r1 == r4) goto L_0x0020
            if (r1 == r3) goto L_0x0014
            if (r1 != r2) goto L_0x0018
        L_0x0014:
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x006e
        L_0x0018:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x0020:
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x005f
        L_0x0024:
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0036
        L_0x0028:
            kotlin.ResultKt.throwOnFailure(r8)
            r7.label = r5
            r5 = 50
            java.lang.Object r8 = kotlinx.coroutines.DelayKt.b(r5, r7)
            if (r8 != r0) goto L_0x0036
            return r0
        L_0x0036:
            com.upuphone.xr.sapp.utils.PhoneTypeUtils r8 = com.upuphone.xr.sapp.utils.PhoneTypeUtils.f7912a
            boolean r1 = r8.d()
            if (r1 != 0) goto L_0x0054
            boolean r8 = r8.g()
            if (r8 == 0) goto L_0x0045
            goto L_0x0054
        L_0x0045:
            com.upuphone.xr.sapp.vu.VuTouchpadActivity r8 = r7.this$0
            int r1 = r7.$displayId
            boolean r3 = r7.$showTip
            r7.label = r2
            java.lang.Object r7 = r8.u1(r1, r3, r7)
            if (r7 != r0) goto L_0x006e
            return r0
        L_0x0054:
            r7.label = r4
            r1 = 200(0xc8, double:9.9E-322)
            java.lang.Object r8 = kotlinx.coroutines.DelayKt.b(r1, r7)
            if (r8 != r0) goto L_0x005f
            return r0
        L_0x005f:
            com.upuphone.xr.sapp.vu.VuTouchpadActivity r8 = r7.this$0
            int r1 = r7.$displayId
            boolean r2 = r7.$showTip
            r7.label = r3
            java.lang.Object r7 = r8.u1(r1, r2, r7)
            if (r7 != r0) goto L_0x006e
            return r0
        L_0x006e:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.vu.VuTouchpadActivity$openArSpace$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((VuTouchpadActivity$openArSpace$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
