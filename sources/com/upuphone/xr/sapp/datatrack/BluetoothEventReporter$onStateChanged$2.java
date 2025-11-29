package com.upuphone.xr.sapp.datatrack;

import com.upuphone.xr.sapp.utils.DataTrackUtil;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.apache.commons.lang3.BooleanUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.datatrack.BluetoothEventReporter$onStateChanged$2", f = "BluetoothEventReporter.kt", i = {}, l = {36}, m = "invokeSuspend", n = {}, s = {})
public final class BluetoothEventReporter$onStateChanged$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    public BluetoothEventReporter$onStateChanged$2(Continuation<? super BluetoothEventReporter$onStateChanged$2> continuation) {
        super(2, continuation);
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new BluetoothEventReporter$onStateChanged$2(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            DataTrackEventHelper dataTrackEventHelper = DataTrackEventHelper.f6915a;
            this.label = 1;
            obj = dataTrackEventHelper.a(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Map map = (Map) obj;
        map.put("bt_state", BooleanUtils.OFF);
        DataTrackUtil.n(DataTrackUtil.f7875a, "bt_state_changed", map, false, 4, (Object) null);
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((BluetoothEventReporter$onStateChanged$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
