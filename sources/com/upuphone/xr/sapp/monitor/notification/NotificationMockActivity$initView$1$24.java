package com.upuphone.xr.sapp.monitor.notification;

import android.widget.Button;
import com.upuphone.xr.sapp.monitor.NotificationMock;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H@"}, d2 = {"<anonymous>", "", "it", "Landroid/widget/Button;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.monitor.notification.NotificationMockActivity$initView$1$24", f = "NotificationMockActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class NotificationMockActivity$initView$1$24 extends SuspendLambda implements Function2<Button, Continuation<? super Unit>, Object> {
    int label;

    public NotificationMockActivity$initView$1$24(Continuation<? super NotificationMockActivity$initView$1$24> continuation) {
        super(2, continuation);
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new NotificationMockActivity$initView$1$24(continuation);
    }

    @Nullable
    public final Object invoke(@NotNull Button button, @Nullable Continuation<? super Unit> continuation) {
        return ((NotificationMockActivity$initView$1$24) create(button, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            NotificationMock.f7736a.a(System.currentTimeMillis(), "com.autonavi.minimap", 100088, "神州专车已完成本次服务", "下车请带好随身物品，本次行程共19.23元，点击确认账单");
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
