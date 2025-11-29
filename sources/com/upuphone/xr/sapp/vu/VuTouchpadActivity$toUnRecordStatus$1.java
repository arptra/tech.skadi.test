package com.upuphone.xr.sapp.vu;

import android.content.res.ColorStateList;
import androidx.core.widget.TextViewCompat;
import com.upuphone.xr.sapp.R;
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
@DebugMetadata(c = "com.upuphone.xr.sapp.vu.VuTouchpadActivity$toUnRecordStatus$1", f = "VuTouchpadActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class VuTouchpadActivity$toUnRecordStatus$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ VuTouchpadActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VuTouchpadActivity$toUnRecordStatus$1(VuTouchpadActivity vuTouchpadActivity, Continuation<? super VuTouchpadActivity$toUnRecordStatus$1> continuation) {
        super(2, continuation);
        this.this$0 = vuTouchpadActivity;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new VuTouchpadActivity$toUnRecordStatus$1(this.this$0, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            FragmentVuTouchpadBinding I0 = this.this$0.c;
            FragmentVuTouchpadBinding fragmentVuTouchpadBinding = null;
            if (I0 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                I0 = null;
            }
            ColorStateList colorStateList = I0.l.getContext().getColorStateList(R.color.title_icon_color);
            Intrinsics.checkNotNullExpressionValue(colorStateList, "getColorStateList(...)");
            FragmentVuTouchpadBinding I02 = this.this$0.c;
            if (I02 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                fragmentVuTouchpadBinding = I02;
            }
            TextViewCompat.g(fragmentVuTouchpadBinding.l, colorStateList);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((VuTouchpadActivity$toUnRecordStatus$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
