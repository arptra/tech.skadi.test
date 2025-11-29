package com.upuphone.xr.sapp.fragment;

import com.meizu.common.widget.CircularProgressButton;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.interconnect.entity.StarryNetDevice;
import com.upuphone.xr.sapp.air.AirHelper;
import com.upuphone.xr.sapp.context.SdkContext;
import com.upuphone.xr.sapp.databinding.FragmentTouchpadBinding;
import com.upuphone.xr.sapp.glass.GlassHelper;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nTouchpadFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TouchpadFragment.kt\ncom/upuphone/xr/sapp/fragment/TouchpadFragment$checkScreenshotStatus$1\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,495:1\n256#2,2:496\n256#2,2:498\n*S KotlinDebug\n*F\n+ 1 TouchpadFragment.kt\ncom/upuphone/xr/sapp/fragment/TouchpadFragment$checkScreenshotStatus$1\n*L\n483#1:496,2\n489#1:498,2\n*E\n"})
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.fragment.TouchpadFragment$checkScreenshotStatus$1", f = "TouchpadFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class TouchpadFragment$checkScreenshotStatus$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ TouchpadFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TouchpadFragment$checkScreenshotStatus$1(TouchpadFragment touchpadFragment, Continuation<? super TouchpadFragment$checkScreenshotStatus$1> continuation) {
        super(2, continuation);
        this.this$0 = touchpadFragment;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new TouchpadFragment$checkScreenshotStatus$1(this.this$0, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            StarryNetDevice w = GlassHelper.f7049a.w();
            ULog.Delegate delegate = ULog.f6446a;
            delegate.a("TouchpadFragment", "checkScreenshotStatus, boundedGlass: " + w);
            int i = 8;
            CircularProgressButton circularProgressButton = null;
            if (w == null) {
                FragmentTouchpadBinding H0 = this.this$0.j;
                if (H0 != null) {
                    circularProgressButton = H0.d;
                }
                if (circularProgressButton != null) {
                    circularProgressButton.setVisibility(8);
                }
                return Unit.INSTANCE;
            }
            boolean I = AirHelper.b.I(w);
            Integer num = (Integer) SdkContext.f6675a.e().c().getValue();
            delegate.a("TouchpadFragment", "checkScreenshotStatus, isAirGlass: " + I + ", peerVersion: " + num);
            FragmentTouchpadBinding H02 = this.this$0.j;
            if (H02 != null) {
                circularProgressButton = H02.d;
            }
            if (circularProgressButton != null) {
                if (I && num != null && num.intValue() >= 3) {
                    i = 0;
                }
                circularProgressButton.setVisibility(i);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((TouchpadFragment$checkScreenshotStatus$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
