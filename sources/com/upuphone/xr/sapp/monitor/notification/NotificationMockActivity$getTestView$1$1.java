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
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nNotificationMockActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NotificationMockActivity.kt\ncom/upuphone/xr/sapp/monitor/notification/NotificationMockActivity$getTestView$1$1\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,319:1\n254#2,4:320\n*S KotlinDebug\n*F\n+ 1 NotificationMockActivity.kt\ncom/upuphone/xr/sapp/monitor/notification/NotificationMockActivity$getTestView$1$1\n*L\n283#1:320,4\n*E\n"})
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H@"}, d2 = {"<anonymous>", "", "it", "Landroid/widget/Button;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.monitor.notification.NotificationMockActivity$getTestView$1$1", f = "NotificationMockActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class NotificationMockActivity$getTestView$1$1 extends SuspendLambda implements Function2<Button, Continuation<? super Unit>, Object> {
    final /* synthetic */ LinearLayout $extraView;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NotificationMockActivity$getTestView$1$1(LinearLayout linearLayout, Continuation<? super NotificationMockActivity$getTestView$1$1> continuation) {
        super(2, continuation);
        this.$extraView = linearLayout;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new NotificationMockActivity$getTestView$1$1(this.$extraView, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull Button button, @Nullable Continuation<? super Unit> continuation) {
        return ((NotificationMockActivity$getTestView$1$1) create(button, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            LinearLayout linearLayout = this.$extraView;
            int i = 0;
            if (!(!(linearLayout.getVisibility() == 0))) {
                i = 8;
            }
            linearLayout.setVisibility(i);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
