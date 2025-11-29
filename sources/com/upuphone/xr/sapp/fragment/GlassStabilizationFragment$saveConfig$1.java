package com.upuphone.xr.sapp.fragment;

import android.content.Context;
import com.meizu.common.app.LoadingDialog;
import com.upuphone.star.common.phone.UToast;
import com.upuphone.xr.interconnect.listener.SendMessageListener;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.databinding.FragmentGlassStabilizationBinding;
import com.upuphone.xr.sapp.entity.StabilizationMode;
import com.upuphone.xr.sapp.utils.ControlUtils;
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
@DebugMetadata(c = "com.upuphone.xr.sapp.fragment.GlassStabilizationFragment$saveConfig$1", f = "GlassStabilizationFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class GlassStabilizationFragment$saveConfig$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ GlassStabilizationFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GlassStabilizationFragment$saveConfig$1(GlassStabilizationFragment glassStabilizationFragment, Continuation<? super GlassStabilizationFragment$saveConfig$1> continuation) {
        super(2, continuation);
        this.this$0 = glassStabilizationFragment;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new GlassStabilizationFragment$saveConfig$1(this.this$0, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.showLoading();
            ControlUtils controlUtils = ControlUtils.f7858a;
            String packageName = this.this$0.m0().getPackageName();
            Intrinsics.checkNotNullExpressionValue(packageName, "getPackageName(...)");
            FragmentGlassStabilizationBinding E0 = this.this$0.j;
            FragmentGlassStabilizationBinding fragmentGlassStabilizationBinding = null;
            if (E0 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                E0 = null;
            }
            boolean isChecked = E0.c.getBinding().i.isChecked();
            FragmentGlassStabilizationBinding E02 = this.this$0.j;
            if (E02 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                fragmentGlassStabilizationBinding = E02;
            }
            StabilizationMode stabilizationMode = new StabilizationMode(isChecked, fragmentGlassStabilizationBinding.d.getBinding().i.isChecked());
            final GlassStabilizationFragment glassStabilizationFragment = this.this$0;
            controlUtils.d0(packageName, stabilizationMode, new SendMessageListener() {
                public void onFail(@Nullable String str, int i) {
                    LoadingDialog F0 = glassStabilizationFragment.n;
                    if (F0 != null) {
                        GlassStabilizationFragment glassStabilizationFragment = glassStabilizationFragment;
                        if (F0.isShowing()) {
                            LoadingDialog F02 = glassStabilizationFragment.n;
                            if (F02 != null) {
                                F02.dismiss();
                            }
                            UToast.Companion companion = UToast.f6444a;
                            Context requireContext = glassStabilizationFragment.requireContext();
                            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
                            String string = glassStabilizationFragment.getString(R.string.switch_language_fail);
                            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                            companion.d(requireContext, string);
                        }
                    }
                }

                public void onSuccess(@Nullable String str) {
                }
            });
            String packageName2 = this.this$0.m0().getPackageName();
            Intrinsics.checkNotNullExpressionValue(packageName2, "getPackageName(...)");
            controlUtils.L(packageName2);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((GlassStabilizationFragment$saveConfig$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
