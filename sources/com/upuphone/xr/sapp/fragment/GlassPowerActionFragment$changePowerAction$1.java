package com.upuphone.xr.sapp.fragment;

import android.content.Context;
import com.meizu.common.app.LoadingDialog;
import com.upuphone.star.common.phone.UToast;
import com.upuphone.xr.interconnect.listener.SendMessageListener;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.utils.ControlUtils;
import com.xjsd.ai.assistant.protocol.AssistantConstants;
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
import kotlinx.coroutines.DelayKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.fragment.GlassPowerActionFragment$changePowerAction$1", f = "GlassPowerActionFragment.kt", i = {}, l = {178}, m = "invokeSuspend", n = {}, s = {})
public final class GlassPowerActionFragment$changePowerAction$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $appPackage;
    int label;
    final /* synthetic */ GlassPowerActionFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GlassPowerActionFragment$changePowerAction$1(GlassPowerActionFragment glassPowerActionFragment, String str, Continuation<? super GlassPowerActionFragment$changePowerAction$1> continuation) {
        super(2, continuation);
        this.this$0 = glassPowerActionFragment;
        this.$appPackage = str;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new GlassPowerActionFragment$changePowerAction$1(this.this$0, this.$appPackage, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.showLoading();
            ControlUtils controlUtils = ControlUtils.f7858a;
            String packageName = this.this$0.m0().getPackageName();
            Intrinsics.checkNotNullExpressionValue(packageName, "getPackageName(...)");
            String str = this.$appPackage;
            final GlassPowerActionFragment glassPowerActionFragment = this.this$0;
            controlUtils.Q(packageName, str, new SendMessageListener() {
                public void onFail(@Nullable String str, int i) {
                    LoadingDialog G0 = glassPowerActionFragment.m;
                    if (G0 != null) {
                        GlassPowerActionFragment glassPowerActionFragment = glassPowerActionFragment;
                        if (G0.isShowing()) {
                            LoadingDialog G02 = glassPowerActionFragment.m;
                            if (G02 != null) {
                                G02.dismiss();
                            }
                            UToast.Companion companion = UToast.f6444a;
                            Context requireContext = glassPowerActionFragment.requireContext();
                            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
                            String string = glassPowerActionFragment.getString(R.string.switch_language_fail);
                            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                            companion.d(requireContext, string);
                        }
                    }
                }

                public void onSuccess(@Nullable String str) {
                }
            });
            this.label = 1;
            if (DelayKt.b(AssistantConstants.TIMEOUT_VAD_MUTE, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ControlUtils controlUtils2 = ControlUtils.f7858a;
        String packageName2 = this.this$0.m0().getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName2, "getPackageName(...)");
        controlUtils2.G(packageName2);
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((GlassPowerActionFragment$changePowerAction$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
