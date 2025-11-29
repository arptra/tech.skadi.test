package com.upuphone.xr.sapp.contract;

import com.upuphone.ar.navi.lite.base.ULocation;
import com.upuphone.star.core.log.ULog;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.contract.ReceiveLocationEventManager$startNaviCheckSupportWork$1", f = "ReceiveLocationEventManager.kt", i = {1}, l = {46, 49}, m = "invokeSuspend", n = {"countryCode"}, s = {"L$0"})
public final class ReceiveLocationEventManager$startNaviCheckSupportWork$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ULocation $location;
    Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ReceiveLocationEventManager$startNaviCheckSupportWork$1(ULocation uLocation, Continuation<? super ReceiveLocationEventManager$startNaviCheckSupportWork$1> continuation) {
        super(2, continuation);
        this.$location = uLocation;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new ReceiveLocationEventManager$startNaviCheckSupportWork$1(this.$location, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        String str;
        String str2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            ReceiveLocationEventManager receiveLocationEventManager = ReceiveLocationEventManager.f6703a;
            ULocation uLocation = this.$location;
            this.label = 1;
            obj = receiveLocationEventManager.e(uLocation, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else if (i == 2) {
            str2 = (String) this.L$0;
            try {
                ResultKt.throwOnFailure(obj);
                str = str2;
                ReceiveLocationEventManager.f6703a.i(str);
                ULog.Delegate delegate = ULog.f6446a;
                delegate.a("ReceiveLocationEventManager", "getCountryCode = " + str);
            } catch (Exception e) {
                ULog.Delegate delegate2 = ULog.f6446a;
                String message = e.getMessage();
                delegate2.c("ReceiveLocationEventManager", "getCountryCode异常：" + message);
            }
            return Unit.INSTANCE;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        str = (String) obj;
        if (str.length() > 0) {
            ReceiveLocationEventManager receiveLocationEventManager2 = ReceiveLocationEventManager.f6703a;
            if (!Intrinsics.areEqual((Object) receiveLocationEventManager2.f(), (Object) str)) {
                this.L$0 = str;
                this.label = 2;
                if (receiveLocationEventManager2.d(str, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                str2 = str;
                str = str2;
                ReceiveLocationEventManager.f6703a.i(str);
            } else {
                ULog.f6446a.a("ReceiveLocationEventManager", "countryCode无变化");
                ReceiveLocationEventManager.f6703a.i(str);
            }
        }
        ULog.Delegate delegate3 = ULog.f6446a;
        delegate3.a("ReceiveLocationEventManager", "getCountryCode = " + str);
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((ReceiveLocationEventManager$startNaviCheckSupportWork$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
