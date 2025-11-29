package com.upuphone.xr.sapp.monitor.notification.business;

import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.monitor.notification.cache.NotificationDataBase;
import com.upuphone.xr.sapp.monitor.notification.cache.WechatMissedCallDao;
import com.upuphone.xr.sapp.monitor.notification.model.WechatMissedCallModel;
import com.upuphone.xr.sapp.monitor.notification.utils.NotificationHelper;
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
@DebugMetadata(c = "com.upuphone.xr.sapp.monitor.notification.business.MissedCallBusinessHandle$clearWechatMissedCall$1", f = "MissedCallBusinessHandle.kt", i = {}, l = {69}, m = "invokeSuspend", n = {}, s = {})
public final class MissedCallBusinessHandle$clearWechatMissedCall$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ WechatMissedCallModel $model;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MissedCallBusinessHandle$clearWechatMissedCall$1(WechatMissedCallModel wechatMissedCallModel, Continuation<? super MissedCallBusinessHandle$clearWechatMissedCall$1> continuation) {
        super(2, continuation);
        this.$model = wechatMissedCallModel;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new MissedCallBusinessHandle$clearWechatMissedCall$1(this.$model, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            ULog.Delegate delegate = ULog.f6446a;
            String h = NotificationHelper.f7775a.h(this.$model.getName());
            delegate.a("MissedCallBusinessHandle", "clearWechatMissedCall: " + h);
            WechatMissedCallDao f = NotificationDataBase.f7758a.a().f();
            String name = this.$model.getName();
            this.label = 1;
            if (f.a(name, this) == coroutine_suspended) {
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
        return ((MissedCallBusinessHandle$clearWechatMissedCall$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
