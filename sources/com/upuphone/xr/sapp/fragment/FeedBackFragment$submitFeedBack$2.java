package com.upuphone.xr.sapp.fragment;

import com.upuphone.ar.transcribe.utils.GsonUtils;
import com.upuphone.runasone.constant.Constants;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.utils.GetRing2DeviceInfoUtils;
import com.xjmz.myvu.flutter.pigeon.AndroidBindingDeviceApi;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.fragment.FeedBackFragment$submitFeedBack$2", f = "FeedBackFragment.kt", i = {}, l = {701}, m = "invokeSuspend", n = {}, s = {})
public final class FeedBackFragment$submitFeedBack$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.ObjectRef<String> $firstRingName;
    final /* synthetic */ HashMap<String, Object> $paramsHashMap;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FeedBackFragment$submitFeedBack$2(HashMap<String, Object> hashMap, Ref.ObjectRef<String> objectRef, Continuation<? super FeedBackFragment$submitFeedBack$2> continuation) {
        super(2, continuation);
        this.$paramsHashMap = hashMap;
        this.$firstRingName = objectRef;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new FeedBackFragment$submitFeedBack$2(this.$paramsHashMap, this.$firstRingName, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            GetRing2DeviceInfoUtils.Companion companion = GetRing2DeviceInfoUtils.f7887a;
            this.label = 1;
            obj = companion.a(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        AndroidBindingDeviceApi.Ring2DeviceInfo ring2DeviceInfo = (AndroidBindingDeviceApi.Ring2DeviceInfo) obj;
        this.$paramsHashMap.put("deviceInfoList", new Map[]{MapsKt.mapOf(TuplesKt.to(Constants.DEVICE_ID, ring2DeviceInfo.c()), TuplesKt.to("deviceModel", ring2DeviceInfo.b()), TuplesKt.to("deviceVersion", ring2DeviceInfo.d()), TuplesKt.to("displayDeviceName", this.$firstRingName.element))});
        ULog.Delegate delegate = ULog.f6446a;
        String d = GsonUtils.d(ring2DeviceInfo);
        String d2 = GsonUtils.d(this.$paramsHashMap);
        delegate.a("FeedBackFragment", "submitData -> ring2Info:" + d + " paramsHashMap:" + d2);
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((FeedBackFragment$submitFeedBack$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
