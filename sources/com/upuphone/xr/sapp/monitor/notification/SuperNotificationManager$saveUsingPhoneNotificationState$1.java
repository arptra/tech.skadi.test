package com.upuphone.xr.sapp.monitor.notification;

import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.context.SdkContext;
import com.upuphone.xr.sapp.datatrack.ReminderDataTrackEvent;
import com.upuphone.xr.sapp.utils.DataStoreUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableStateFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.monitor.notification.SuperNotificationManager$saveUsingPhoneNotificationState$1", f = "SuperNotificationManager.kt", i = {}, l = {497}, m = "invokeSuspend", n = {}, s = {})
public final class SuperNotificationManager$saveUsingPhoneNotificationState$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $state;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SuperNotificationManager$saveUsingPhoneNotificationState$1(boolean z, Continuation<? super SuperNotificationManager$saveUsingPhoneNotificationState$1> continuation) {
        super(2, continuation);
        this.$state = z;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new SuperNotificationManager$saveUsingPhoneNotificationState$1(this.$state, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            ULog.Delegate delegate = ULog.f6446a;
            boolean z = this.$state;
            Object value = SuperNotificationManager.i.getValue();
            delegate.a("SuperNotificationManager", "saveUsingPhoneNotificationState state:" + z + " old:" + value);
            if (this.$state != ((Boolean) SuperNotificationManager.i.getValue()).booleanValue()) {
                MutableStateFlow b = SuperNotificationManager.i;
                Boolean boxBoolean = Boxing.boxBoolean(this.$state);
                this.label = 1;
                if (b.emit(boxBoolean, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        DataStoreUtils.e.a().p("using_phone_notification_state_key", Boxing.boxBoolean(this.$state), true);
        SdkContext.f6675a.d().reportEvent(ReminderDataTrackEvent.APP_CLICK_REMIND_REPEAT, MapsKt.hashMapOf(TuplesKt.to("status", this.$state ? "1" : "0")));
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((SuperNotificationManager$saveUsingPhoneNotificationState$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
