package com.upuphone.xr.sapp.vu;

import android.view.View;
import com.upuphone.xr.sapp.databinding.FragmentVuTouchpadBinding;
import com.upuphone.xr.sapp.vu.vm.VuGlassesModel;
import com.xjsd.ai.assistant.protocol.AssistantConstants;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nVuTouchpadActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VuTouchpadActivity.kt\ncom/upuphone/xr/sapp/vu/VuTouchpadActivity$delayCheckOpened$1\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,838:1\n254#2:839\n*S KotlinDebug\n*F\n+ 1 VuTouchpadActivity.kt\ncom/upuphone/xr/sapp/vu/VuTouchpadActivity$delayCheckOpened$1\n*L\n320#1:839\n*E\n"})
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.vu.VuTouchpadActivity$delayCheckOpened$1", f = "VuTouchpadActivity.kt", i = {}, l = {319}, m = "invokeSuspend", n = {}, s = {})
public final class VuTouchpadActivity$delayCheckOpened$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ VuTouchpadActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VuTouchpadActivity$delayCheckOpened$1(VuTouchpadActivity vuTouchpadActivity, Continuation<? super VuTouchpadActivity$delayCheckOpened$1> continuation) {
        super(2, continuation);
        this.this$0 = vuTouchpadActivity;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new VuTouchpadActivity$delayCheckOpened$1(this.this$0, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        VuGlassesModel.Companion companion;
        VuGlassesModel b;
        Job C;
        VuGlassesModel b2;
        Job C2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (DelayKt.b(AssistantConstants.TIMEOUT_VAD_MUTE, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        FragmentVuTouchpadBinding I0 = this.this$0.c;
        if (I0 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            I0 = null;
        }
        View view = I0.f;
        Intrinsics.checkNotNullExpressionValue(view, "maskView");
        if (!(view.getVisibility() != 0 || (b = (companion = VuGlassesModel.n).b()) == null || (C = b.C()) == null || !C.isActive() || (b2 = companion.b()) == null || (C2 = b2.C()) == null)) {
            Job.DefaultImpls.a(C2, (CancellationException) null, 1, (Object) null);
        }
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((VuTouchpadActivity$delayCheckOpened$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
