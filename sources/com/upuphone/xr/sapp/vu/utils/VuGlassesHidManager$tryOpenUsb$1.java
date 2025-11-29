package com.upuphone.xr.sapp.vu.utils;

import com.upuphone.xr.sapp.vu.utils.VuGlassesHidManager;
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
@DebugMetadata(c = "com.upuphone.xr.sapp.vu.utils.VuGlassesHidManager$tryOpenUsb$1", f = "VuGlassesHidManager.kt", i = {1}, l = {137, 145}, m = "invokeSuspend", n = {"openResult"}, s = {"I$0"})
public final class VuGlassesHidManager$tryOpenUsb$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ VuGlassesHidManager.UsbOpenResultListener $openResultListener;
    int I$0;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VuGlassesHidManager$tryOpenUsb$1(VuGlassesHidManager.UsbOpenResultListener usbOpenResultListener, Continuation<? super VuGlassesHidManager$tryOpenUsb$1> continuation) {
        super(2, continuation);
        this.$openResultListener = usbOpenResultListener;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        VuGlassesHidManager$tryOpenUsb$1 vuGlassesHidManager$tryOpenUsb$1 = new VuGlassesHidManager$tryOpenUsb$1(this.$openResultListener, continuation);
        vuGlassesHidManager$tryOpenUsb$1.L$0 = obj;
        return vuGlassesHidManager$tryOpenUsb$1;
    }

    /* JADX INFO: finally extract failed */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v3, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v9, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v10, resolved type: boolean} */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0062 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0096  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r13) {
        /*
            r12 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r12.label
            java.lang.String r2 = "VuGlassesHidManager"
            r3 = 2
            r4 = 1
            r5 = 0
            if (r1 == 0) goto L_0x0027
            if (r1 == r4) goto L_0x0020
            if (r1 != r3) goto L_0x0018
            int r12 = r12.I$0
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x0093
        L_0x0018:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L_0x0020:
            kotlin.ResultKt.throwOnFailure(r13)     // Catch:{ CancellationException -> 0x0062 }
            goto L_0x0058
        L_0x0024:
            r12 = move-exception
            goto L_0x009e
        L_0x0027:
            kotlin.ResultKt.throwOnFailure(r13)
            java.lang.Object r13 = r12.L$0
            r6 = r13
            kotlinx.coroutines.CoroutineScope r6 = (kotlinx.coroutines.CoroutineScope) r6
            kotlinx.coroutines.Deferred r13 = com.upuphone.xr.sapp.vu.utils.VuGlassesHidManager.f
            if (r13 == 0) goto L_0x0038
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        L_0x0038:
            com.upuphone.xr.sapp.vu.utils.VuGlassesHidManager$tryOpenUsb$1$1 r9 = new com.upuphone.xr.sapp.vu.utils.VuGlassesHidManager$tryOpenUsb$1$1
            r9.<init>(r5)
            r10 = 3
            r11 = 0
            r7 = 0
            r8 = 0
            kotlinx.coroutines.Deferred r13 = kotlinx.coroutines.BuildersKt__Builders_commonKt.b(r6, r7, r8, r9, r10, r11)
            com.upuphone.xr.sapp.vu.utils.VuGlassesHidManager.f = r13
            kotlinx.coroutines.Deferred r13 = com.upuphone.xr.sapp.vu.utils.VuGlassesHidManager.f     // Catch:{ CancellationException -> 0x0062 }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r13)     // Catch:{ CancellationException -> 0x0062 }
            r12.label = r4     // Catch:{ CancellationException -> 0x0062 }
            java.lang.Object r13 = r13.c(r12)     // Catch:{ CancellationException -> 0x0062 }
            if (r13 != r0) goto L_0x0058
            return r0
        L_0x0058:
            java.lang.Boolean r13 = (java.lang.Boolean) r13     // Catch:{ CancellationException -> 0x0062 }
            boolean r13 = r13.booleanValue()     // Catch:{ CancellationException -> 0x0062 }
            com.upuphone.xr.sapp.vu.utils.VuGlassesHidManager.f = r5
            goto L_0x006d
        L_0x0062:
            com.upuphone.star.core.log.ULog$Delegate r13 = com.upuphone.star.core.log.ULog.f6446a     // Catch:{ all -> 0x0024 }
            java.lang.String r1 = "openUsb cancelled"
            r13.a(r2, r1)     // Catch:{ all -> 0x0024 }
            com.upuphone.xr.sapp.vu.utils.VuGlassesHidManager.f = r5
            r13 = 0
        L_0x006d:
            com.upuphone.star.core.log.ULog$Delegate r1 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "open usb result: "
            r4.append(r5)
            r4.append(r13)
            java.lang.String r4 = r4.toString()
            r1.a(r2, r4)
            com.upuphone.xr.sapp.vu.utils.VuGlassesHidManager$UsbOpenResultListener r1 = r12.$openResultListener
            if (r1 == 0) goto L_0x0094
            r12.I$0 = r13
            r12.label = r3
            java.lang.Object r12 = r1.b(r13, r12)
            if (r12 != r0) goto L_0x0092
            return r0
        L_0x0092:
            r12 = r13
        L_0x0093:
            r13 = r12
        L_0x0094:
            if (r13 == 0) goto L_0x009b
            com.upuphone.xr.sapp.vu.utils.VuGlassesActiveHelper r12 = com.upuphone.xr.sapp.vu.utils.VuGlassesActiveHelper.f8097a
            r12.j()
        L_0x009b:
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        L_0x009e:
            com.upuphone.xr.sapp.vu.utils.VuGlassesHidManager.f = r5
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.vu.utils.VuGlassesHidManager$tryOpenUsb$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((VuGlassesHidManager$tryOpenUsb$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
