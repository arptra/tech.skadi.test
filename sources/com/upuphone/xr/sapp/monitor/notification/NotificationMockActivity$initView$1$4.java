package com.upuphone.xr.sapp.monitor.notification;

import android.app.ActivityManager;
import android.widget.Button;
import android.widget.LinearLayout;
import com.upuphone.star.core.log.ULog;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nNotificationMockActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NotificationMockActivity.kt\ncom/upuphone/xr/sapp/monitor/notification/NotificationMockActivity$initView$1$4\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,319:1\n1855#2,2:320\n*S KotlinDebug\n*F\n+ 1 NotificationMockActivity.kt\ncom/upuphone/xr/sapp/monitor/notification/NotificationMockActivity$initView$1$4\n*L\n59#1:320,2\n*E\n"})
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H@"}, d2 = {"<anonymous>", "", "it", "Landroid/widget/Button;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.monitor.notification.NotificationMockActivity$initView$1$4", f = "NotificationMockActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class NotificationMockActivity$initView$1$4 extends SuspendLambda implements Function2<Button, Continuation<? super Unit>, Object> {
    final /* synthetic */ LinearLayout $this_apply;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NotificationMockActivity$initView$1$4(LinearLayout linearLayout, Continuation<? super NotificationMockActivity$initView$1$4> continuation) {
        super(2, continuation);
        this.$this_apply = linearLayout;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new NotificationMockActivity$initView$1$4(this.$this_apply, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull Button button, @Nullable Continuation<? super Unit> continuation) {
        return ((NotificationMockActivity$initView$1$4) create(button, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            Object systemService = this.$this_apply.getContext().getSystemService("activity");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
            List<ActivityManager.RunningServiceInfo> runningServices = ((ActivityManager) systemService).getRunningServices(100);
            Intrinsics.checkNotNullExpressionValue(runningServices, "getRunningServices(...)");
            for (ActivityManager.RunningServiceInfo runningServiceInfo : runningServices) {
                ULog.f6446a.c("xiaohao", runningServiceInfo.service.getClassName());
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
