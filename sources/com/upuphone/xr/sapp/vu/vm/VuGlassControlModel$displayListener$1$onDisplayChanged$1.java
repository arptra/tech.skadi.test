package com.upuphone.xr.sapp.vu.vm;

import android.graphics.Point;
import android.hardware.usb.UsbDevice;
import android.view.Display;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.utils.DataStoreUtils;
import com.upuphone.xr.sapp.vu.utils.VuGlassesHelper;
import com.upuphone.xr.sapp.vu.vm.VuGlassControlModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.vu.vm.VuGlassControlModel$displayListener$1$onDisplayChanged$1", f = "VuGlassControlModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class VuGlassControlModel$displayListener$1$onDisplayChanged$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $displayId;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VuGlassControlModel$displayListener$1$onDisplayChanged$1(int i, Continuation<? super VuGlassControlModel$displayListener$1$onDisplayChanged$1> continuation) {
        super(2, continuation);
        this.$displayId = i;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new VuGlassControlModel$displayListener$1$onDisplayChanged$1(this.$displayId, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            Display display = VuGlassControlModel.f8109a.t().getDisplay(this.$displayId);
            VuGlassesHelper vuGlassesHelper = VuGlassesHelper.f8099a;
            if (vuGlassesHelper.e(display)) {
                UsbDevice b = vuGlassesHelper.b();
                Point d = vuGlassesHelper.d(display);
                ULog.Delegate delegate = ULog.f6446a;
                String name = display.getName();
                delegate.g("VuGlassControlModel", "onDisplayChanged: device: " + b + ", projectInfo: " + name + ", " + d);
                VuGlassControlModel.ViewGlassesInfo viewGlassesInfo = new VuGlassControlModel.ViewGlassesInfo((VuGlassControlModel.ViewGlassesInfo) VuGlassControlModel.b.getValue());
                viewGlassesInfo.k(b);
                viewGlassesInfo.h(this.$displayId);
                viewGlassesInfo.l(d.x);
                viewGlassesInfo.i(d.y);
                VuGlassControlModel.b.postValue(viewGlassesInfo);
                DataStoreUtils.e.a().o("vu_connected_view_glass", viewGlassesInfo.m());
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((VuGlassControlModel$displayListener$1$onDisplayChanged$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
