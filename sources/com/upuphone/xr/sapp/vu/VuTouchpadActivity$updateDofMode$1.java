package com.upuphone.xr.sapp.vu;

import com.upuphone.xr.sapp.databinding.FragmentVuTouchpadBinding;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.vu.VuTouchpadActivity$updateDofMode$1", f = "VuTouchpadActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class VuTouchpadActivity$updateDofMode$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Integer $dofMode;
    int label;
    final /* synthetic */ VuTouchpadActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VuTouchpadActivity$updateDofMode$1(Integer num, VuTouchpadActivity vuTouchpadActivity, Continuation<? super VuTouchpadActivity$updateDofMode$1> continuation) {
        super(2, continuation);
        this.$dofMode = num;
        this.this$0 = vuTouchpadActivity;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new VuTouchpadActivity$updateDofMode$1(this.$dofMode, this.this$0, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            Integer num = this.$dofMode;
            FragmentVuTouchpadBinding fragmentVuTouchpadBinding = null;
            if (num != null && num.intValue() == 1) {
                FragmentVuTouchpadBinding I0 = this.this$0.c;
                if (I0 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    I0 = null;
                }
                I0.c.setSelected(true);
                FragmentVuTouchpadBinding I02 = this.this$0.c;
                if (I02 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                } else {
                    fragmentVuTouchpadBinding = I02;
                }
                fragmentVuTouchpadBinding.d.setSelected(false);
            } else {
                FragmentVuTouchpadBinding I03 = this.this$0.c;
                if (I03 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    I03 = null;
                }
                I03.d.setSelected(true);
                FragmentVuTouchpadBinding I04 = this.this$0.c;
                if (I04 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                } else {
                    fragmentVuTouchpadBinding = I04;
                }
                fragmentVuTouchpadBinding.c.setSelected(false);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((VuTouchpadActivity$updateDofMode$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
