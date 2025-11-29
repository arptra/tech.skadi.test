package com.upuphone.xr.sapp.ability;

import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.entity.PermissionNote;
import com.upuphone.xr.sapp.utils.GenericWindowExtKt;
import com.upuphone.xr.sapp.utils.GenericWindowResult;
import com.upuphone.xr.sapp.utils.StaticMethodUtilsKt;
import com.xjmz.myvu.MYVUActivity;
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
@DebugMetadata(c = "com.upuphone.xr.sapp.ability.PhoneSappAbility$showPermissionRejectWindow$1", f = "PhoneSappAbility.kt", i = {}, l = {453}, m = "invokeSuspend", n = {}, s = {})
public final class PhoneSappAbility$showPermissionRejectWindow$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MYVUActivity $activity;
    final /* synthetic */ PermissionNote $rejectPermissionNote;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PhoneSappAbility$showPermissionRejectWindow$1(MYVUActivity mYVUActivity, PermissionNote permissionNote, Continuation<? super PhoneSappAbility$showPermissionRejectWindow$1> continuation) {
        super(2, continuation);
        this.$activity = mYVUActivity;
        this.$rejectPermissionNote = permissionNote;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new PhoneSappAbility$showPermissionRejectWindow$1(this.$activity, this.$rejectPermissionNote, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            MYVUActivity mYVUActivity = this.$activity;
            PermissionNote permissionNote = this.$rejectPermissionNote;
            this.label = 1;
            obj = GenericWindowExtKt.b(mYVUActivity, 2008, permissionNote, false, false, this, 12, (Object) null);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        GenericWindowResult.ButtonAction buttonAction = (GenericWindowResult.ButtonAction) obj;
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("PhoneSappAbility", "showPermissionRejectWindow, buttonAction: " + buttonAction);
        if (buttonAction.getActionType() == 1101) {
            StaticMethodUtilsKt.o(this.$activity);
        }
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((PhoneSappAbility$showPermissionRejectWindow$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
