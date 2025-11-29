package com.upuphone.xr.sapp.monitor.notification;

import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.interconnect.listener.SendMessageListener;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.monitor.starry.StarryMessageHelper;
import com.upuphone.xr.sapp.monitor.starry.StarryNotificationBase;
import com.upuphone.xr.sapp.utils.DataStoreUtils;
import com.upuphone.xr.sapp.utils.GlobalExtKt;
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
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.monitor.notification.SuperNotificationManager$checkUsingPhonePromptGlass$1", f = "SuperNotificationManager.kt", i = {}, l = {702}, m = "invokeSuspend", n = {}, s = {})
public final class SuperNotificationManager$checkUsingPhonePromptGlass$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    public SuperNotificationManager$checkUsingPhonePromptGlass$1(Continuation<? super SuperNotificationManager$checkUsingPhonePromptGlass$1> continuation) {
        super(2, continuation);
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new SuperNotificationManager$checkUsingPhonePromptGlass$1(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            ULog.f6446a.a("SuperNotificationManager", "checkUsingPhonePromptGlass the conditions are met");
            this.label = 1;
            if (DelayKt.b(10000, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        StarryMessageHelper.t(StarryMessageHelper.f7799a, (byte[]) null, new StarryNotificationBase("SHOW_DIALOG", MapsKt.hashMapOf(TuplesKt.to("title", GlobalExtKt.g(R.string.ar_application_wisdom_reminder, new Object[0])), TuplesKt.to("sendPackage", "com.upuphone.star.launcher"), TuplesKt.to("id", "using_phone_prompt_glass_id"), TuplesKt.to("content", GlobalExtKt.g(R.string.notification_using_phone_dialog_content, new Object[0])), TuplesKt.to("interactionPromptTxt", GlobalExtKt.g(R.string.notification_using_phone_dialog_trip, new Object[0])))), new SendMessageListener() {
            public void onFail(@Nullable String str, int i) {
            }

            public void onSuccess(@Nullable String str) {
                ULog.f6446a.a("SuperNotificationManager", "checkUsingPhonePromptGlass onSuccess");
                DataStoreUtils.e.a().p("using_phone_prompt_glass_id", Boolean.TRUE, true);
            }
        }, 1, (Object) null);
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((SuperNotificationManager$checkUsingPhonePromptGlass$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
