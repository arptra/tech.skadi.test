package com.upuphone.xr.sapp.monitor.notification.business;

import android.service.notification.StatusBarNotification;
import com.upuphone.xr.sapp.monitor.notification.mode.AiSdkResult;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "Lcom/upuphone/xr/sapp/monitor/notification/mode/AiSdkResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.monitor.notification.business.ReminderBusinessHandle$dealNotification$2$handleDataAsync$1", f = "ReminderBusinessHandle.kt", i = {}, l = {144}, m = "invokeSuspend", n = {}, s = {})
public final class ReminderBusinessHandle$dealNotification$2$handleDataAsync$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super AiSdkResult>, Object> {
    final /* synthetic */ Ref.ObjectRef<String> $content;
    final /* synthetic */ String $packageName;
    final /* synthetic */ StatusBarNotification $sbn;
    final /* synthetic */ Ref.ObjectRef<String> $title;
    int label;
    final /* synthetic */ ReminderBusinessHandle this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ReminderBusinessHandle$dealNotification$2$handleDataAsync$1(ReminderBusinessHandle reminderBusinessHandle, StatusBarNotification statusBarNotification, Ref.ObjectRef<String> objectRef, Ref.ObjectRef<String> objectRef2, String str, Continuation<? super ReminderBusinessHandle$dealNotification$2$handleDataAsync$1> continuation) {
        super(2, continuation);
        this.this$0 = reminderBusinessHandle;
        this.$sbn = statusBarNotification;
        this.$title = objectRef;
        this.$content = objectRef2;
        this.$packageName = str;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new ReminderBusinessHandle$dealNotification$2$handleDataAsync$1(this.this$0, this.$sbn, this.$title, this.$content, this.$packageName, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            ReminderBusinessHandle reminderBusinessHandle = this.this$0;
            StatusBarNotification statusBarNotification = this.$sbn;
            String str = this.$packageName;
            this.label = 1;
            obj = reminderBusinessHandle.o(statusBarNotification, (String) this.$title.element, (String) this.$content.element, str, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return obj;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super AiSdkResult> continuation) {
        return ((ReminderBusinessHandle$dealNotification$2$handleDataAsync$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
