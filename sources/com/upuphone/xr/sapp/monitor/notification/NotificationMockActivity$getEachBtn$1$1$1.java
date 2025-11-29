package com.upuphone.xr.sapp.monitor.notification;

import android.view.View;
import android.widget.Button;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
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
@DebugMetadata(c = "com.upuphone.xr.sapp.monitor.notification.NotificationMockActivity$getEachBtn$1$1$1", f = "NotificationMockActivity.kt", i = {}, l = {299, 300}, m = "invokeSuspend", n = {}, s = {})
public final class NotificationMockActivity$getEachBtn$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<Button, Continuation<? super Unit>, Object> $function;
    final /* synthetic */ View $it;
    final /* synthetic */ Button $this_apply;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NotificationMockActivity$getEachBtn$1$1$1(Function2<? super Button, ? super Continuation<? super Unit>, ? extends Object> function2, Button button, View view, Continuation<? super NotificationMockActivity$getEachBtn$1$1$1> continuation) {
        super(2, continuation);
        this.$function = function2;
        this.$this_apply = button;
        this.$it = view;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new NotificationMockActivity$getEachBtn$1$1$1(this.$function, this.$this_apply, this.$it, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Function2<Button, Continuation<? super Unit>, Object> function2 = this.$function;
            Button button = this.$this_apply;
            this.label = 1;
            if (function2.invoke(button, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else if (i == 2) {
            ResultKt.throwOnFailure(obj);
            this.$it.requestFocus();
            this.$it.requestFocusFromTouch();
            return Unit.INSTANCE;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.label = 2;
        if (DelayKt.b(5000, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        this.$it.requestFocus();
        this.$it.requestFocusFromTouch();
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((NotificationMockActivity$getEachBtn$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
