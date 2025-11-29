package com.upuphone.xr.sapp.monitor.notification;

import android.widget.Button;
import android.widget.LinearLayout;
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
@DebugMetadata(c = "com.upuphone.xr.sapp.monitor.notification.NotificationMockActivity$initView$1$3", f = "NotificationMockActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class NotificationMockActivity$initView$1$3 extends SuspendLambda implements Function2<Button, Continuation<? super Unit>, Object> {
    final /* synthetic */ LinearLayout $this_apply;
    int label;
    final /* synthetic */ NotificationMockActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NotificationMockActivity$initView$1$3(LinearLayout linearLayout, NotificationMockActivity notificationMockActivity, Continuation<? super NotificationMockActivity$initView$1$3> continuation) {
        super(2, continuation);
        this.$this_apply = linearLayout;
        this.this$0 = notificationMockActivity;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new NotificationMockActivity$initView$1$3(this.$this_apply, this.this$0, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull Button button, @Nullable Continuation<? super Unit> continuation) {
        return ((NotificationMockActivity$initView$1$3) create(button, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.$this_apply.getContext().stopService(this.this$0.f7747a);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
