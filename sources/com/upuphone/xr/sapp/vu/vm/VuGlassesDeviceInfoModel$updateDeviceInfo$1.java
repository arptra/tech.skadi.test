package com.upuphone.xr.sapp.vu.vm;

import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.entity.DeviceInfo;
import com.upuphone.xr.sapp.utils.DataStoreUtils;
import com.upuphone.xr.sapp.utils.JsonUtils;
import com.upuphone.xr.sapp.vu.utils.VuGlassesHidUtil;
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
@DebugMetadata(c = "com.upuphone.xr.sapp.vu.vm.VuGlassesDeviceInfoModel$updateDeviceInfo$1", f = "VuGlassesDeviceInfoModel.kt", i = {0, 0, 0}, l = {57}, m = "invokeSuspend", n = {"deviceName", "model", "sn"}, s = {"L$0", "L$1", "L$2"})
public final class VuGlassesDeviceInfoModel$updateDeviceInfo$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;

    public VuGlassesDeviceInfoModel$updateDeviceInfo$1(Continuation<? super VuGlassesDeviceInfoModel$updateDeviceInfo$1> continuation) {
        super(2, continuation);
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new VuGlassesDeviceInfoModel$updateDeviceInfo$1(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        String str;
        String str2;
        String str3;
        Object obj2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            VuGlassesHidUtil vuGlassesHidUtil = VuGlassesHidUtil.f8104a;
            String d = vuGlassesHidUtil.d();
            ULog.Delegate delegate = ULog.f6446a;
            delegate.a("VuGlassesDeviceInfoModel", "deviceName: " + d);
            String g = vuGlassesHidUtil.g();
            delegate.a("VuGlassesDeviceInfoModel", "model: " + g);
            String j = vuGlassesHidUtil.j();
            this.L$0 = d;
            this.L$1 = g;
            this.L$2 = j;
            this.label = 1;
            obj2 = vuGlassesHidUtil.l(this);
            if (obj2 == coroutine_suspended) {
                return coroutine_suspended;
            }
            str2 = j;
            str3 = d;
            str = g;
        } else if (i == 1) {
            String str4 = (String) this.L$2;
            String str5 = (String) this.L$1;
            String str6 = (String) this.L$0;
            try {
                ResultKt.throwOnFailure(obj);
                str2 = str4;
                str = str5;
                str3 = str6;
                obj2 = obj;
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        DeviceInfo deviceInfo = new DeviceInfo(str3, "", str2, str, "", "", "", "", (String) obj2);
        DataStoreUtils.e.a().o("sp_vu_device_info", JsonUtils.f7893a.d(deviceInfo));
        VuGlassesDeviceInfoModel.b.postValue(deviceInfo);
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((VuGlassesDeviceInfoModel$updateDeviceInfo$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
