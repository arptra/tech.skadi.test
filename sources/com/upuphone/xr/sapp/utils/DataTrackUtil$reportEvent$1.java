package com.upuphone.xr.sapp.utils;

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
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.utils.DataTrackUtil$reportEvent$1", f = "DataTrackUtil.kt", i = {}, l = {413}, m = "invokeSuspend", n = {}, s = {})
public final class DataTrackUtil$reportEvent$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Map<String, Object> $attributes;
    final /* synthetic */ String $eventName;
    final /* synthetic */ String $iotDeviceId;
    final /* synthetic */ String $iotDeviceModel;
    final /* synthetic */ String $iotDeviceRom;
    final /* synthetic */ boolean $isSync;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DataTrackUtil$reportEvent$1(String str, Map<String, ? extends Object> map, String str2, String str3, String str4, boolean z, Continuation<? super DataTrackUtil$reportEvent$1> continuation) {
        super(2, continuation);
        this.$eventName = str;
        this.$attributes = map;
        this.$iotDeviceId = str2;
        this.$iotDeviceModel = str3;
        this.$iotDeviceRom = str4;
        this.$isSync = z;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new DataTrackUtil$reportEvent$1(this.$eventName, this.$attributes, this.$iotDeviceId, this.$iotDeviceModel, this.$iotDeviceRom, this.$isSync, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            DataTrackUtil dataTrackUtil = DataTrackUtil.f7875a;
            String str = this.$eventName;
            Map<String, Object> map = this.$attributes;
            String str2 = this.$iotDeviceId;
            String str3 = this.$iotDeviceModel;
            String str4 = this.$iotDeviceRom;
            boolean z = this.$isSync;
            this.label = 1;
            if (dataTrackUtil.p(str, map, str2, str3, str4, z, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((DataTrackUtil$reportEvent$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
