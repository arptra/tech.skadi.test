package com.upuphone.xr.sapp.vu.vm;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.vu.vm.VuGlassControlModel$requestPermission$2$2", f = "VuGlassControlModel.kt", i = {0}, l = {259}, m = "invokeSuspend", n = {"count"}, s = {"I$0"})
public final class VuGlassControlModel$requestPermission$2$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ CancellableContinuation<Boolean> $continuation;
    int I$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VuGlassControlModel$requestPermission$2$2(CancellableContinuation<? super Boolean> cancellableContinuation, Continuation<? super VuGlassControlModel$requestPermission$2$2> continuation) {
        super(2, continuation);
        this.$continuation = cancellableContinuation;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new VuGlassControlModel$requestPermission$2$2(this.$continuation, continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0058  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r6) {
        /*
            r5 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r5.label
            r2 = 1
            if (r1 == 0) goto L_0x001a
            if (r1 != r2) goto L_0x0012
            int r1 = r5.I$0
            kotlin.ResultKt.throwOnFailure(r6)
        L_0x0010:
            r6 = r1
            goto L_0x001f
        L_0x0012:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x001a:
            kotlin.ResultKt.throwOnFailure(r6)
            r6 = 200(0xc8, float:2.8E-43)
        L_0x001f:
            int r1 = r6 + -1
            if (r6 <= 0) goto L_0x0050
            kotlinx.coroutines.CancellableContinuation<java.lang.Boolean> r6 = r5.$continuation
            boolean r6 = r6.isActive()
            if (r6 == 0) goto L_0x0050
            com.upuphone.xr.sapp.vu.vm.VuGlassControlModel r6 = com.upuphone.xr.sapp.vu.vm.VuGlassControlModel.f8109a
            boolean r6 = r6.w()
            if (r6 == 0) goto L_0x0043
            kotlinx.coroutines.CancellableContinuation<java.lang.Boolean> r6 = r5.$continuation
            kotlin.Result$Companion r0 = kotlin.Result.Companion
            java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r2)
            java.lang.Object r0 = kotlin.Result.m20constructorimpl(r0)
            r6.resumeWith(r0)
            goto L_0x0050
        L_0x0043:
            r5.I$0 = r1
            r5.label = r2
            r3 = 100
            java.lang.Object r6 = kotlinx.coroutines.DelayKt.b(r3, r5)
            if (r6 != r0) goto L_0x0010
            return r0
        L_0x0050:
            kotlinx.coroutines.CancellableContinuation<java.lang.Boolean> r6 = r5.$continuation
            boolean r6 = r6.isActive()
            if (r6 == 0) goto L_0x0068
            kotlinx.coroutines.CancellableContinuation<java.lang.Boolean> r5 = r5.$continuation
            kotlin.Result$Companion r6 = kotlin.Result.Companion
            r6 = 0
            java.lang.Boolean r6 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r6)
            java.lang.Object r6 = kotlin.Result.m20constructorimpl(r6)
            r5.resumeWith(r6)
        L_0x0068:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.vu.vm.VuGlassControlModel$requestPermission$2$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((VuGlassControlModel$requestPermission$2$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
