package com.upuphone.xr.sapp.utils;

import android.app.Activity;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CancellableContinuationImpl;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a<\u0010\t\u001a\u00020\b*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005H@¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Landroid/app/Activity;", "", "type", "", "extras", "", "touchOutsideDismiss", "backKeyDismiss", "Lcom/upuphone/xr/sapp/utils/GenericWindowResult$ButtonAction;", "a", "(Landroid/app/Activity;ILjava/lang/Object;ZZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_intlRelease"}, k = 2, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nGenericWindowExt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GenericWindowExt.kt\ncom/upuphone/xr/sapp/utils/GenericWindowExtKt\n+ 2 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,127:1\n314#2,11:128\n314#2,11:139\n314#2,11:150\n*S KotlinDebug\n*F\n+ 1 GenericWindowExt.kt\ncom/upuphone/xr/sapp/utils/GenericWindowExtKt\n*L\n29#1:128,11\n72#1:139,11\n104#1:150,11\n*E\n"})
public final class GenericWindowExtKt {
    public static final Object a(Activity activity, int i, Object obj, boolean z, boolean z2, Continuation continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.x();
        GenericWindowExtKt$waitForButtonAction$2$callback$1 genericWindowExtKt$waitForButtonAction$2$callback$1 = new GenericWindowExtKt$waitForButtonAction$2$callback$1(cancellableContinuationImpl);
        cancellableContinuationImpl.E(new GenericWindowExtKt$waitForButtonAction$2$1(i));
        StaticMethodUtilsKt.y(activity, i, obj, z, z2, genericWindowExtKt$waitForButtonAction$2$callback$1);
        Object u = cancellableContinuationImpl.u();
        if (u == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return u;
    }

    public static /* synthetic */ Object b(Activity activity, int i, Object obj, boolean z, boolean z2, Continuation continuation, int i2, Object obj2) {
        if ((i2 & 2) != 0) {
            obj = null;
        }
        return a(activity, i, obj, (i2 & 4) != 0 ? false : z, (i2 & 8) != 0 ? false : z2, continuation);
    }
}
