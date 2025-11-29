package com.upuphone.xr.sapp.vu.vm;

import android.hardware.usb.UsbDevice;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.vu.vm.VuGlassControlModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.vu.vm.VuGlassControlModel$checkConnectedGlasses$1", f = "VuGlassControlModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class VuGlassControlModel$checkConnectedGlasses$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    public VuGlassControlModel$checkConnectedGlasses$1(Continuation<? super VuGlassControlModel$checkConnectedGlasses$1> continuation) {
        super(2, continuation);
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new VuGlassControlModel$checkConnectedGlasses$1(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        String str;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            VuGlassControlModel vuGlassControlModel = VuGlassControlModel.f8109a;
            VuGlassControlModel.ViewGlassesInfo viewGlassesInfo = (VuGlassControlModel.ViewGlassesInfo) VuGlassControlModel.b.getValue();
            if (viewGlassesInfo == null || (str = viewGlassesInfo.b()) == null) {
                str = VuGlassControlModel.h;
            }
            VuGlassControlModel.ViewGlassesInfo e = vuGlassControlModel.q(str);
            ULog.Delegate delegate = ULog.f6446a;
            delegate.a("VuGlassControlModel", "checkGlasses: connectedGlassesInfo=" + e);
            if (e == null) {
                VuGlassControlModel.ViewGlassesInfo viewGlassesInfo2 = (VuGlassControlModel.ViewGlassesInfo) VuGlassControlModel.b.getValue();
                if (viewGlassesInfo2 != null) {
                    VuGlassControlModel.b.postValue(new VuGlassControlModel.ViewGlassesInfo((UsbDevice) null, 0, viewGlassesInfo2.b(), 0, 0, 24, (DefaultConstructorMarker) null));
                }
            } else if (!Intrinsics.areEqual((Object) e, VuGlassControlModel.b.getValue())) {
                VuGlassControlModel.b.postValue(e);
                vuGlassControlModel.n();
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((VuGlassControlModel$checkConnectedGlasses$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
