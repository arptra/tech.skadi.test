package com.upuphone.xr.sapp.vm;

import android.content.Context;
import com.upuphone.xr.sapp.context.SdkContext;
import com.xjmz.ai.voice.SpeakerVerificationType;
import com.xjmz.ai.voice.VoiceManager;
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
@DebugMetadata(c = "com.upuphone.xr.sapp.vm.RoleVprintViewModel$init$1", f = "RoleVprintViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class RoleVprintViewModel$init$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ RoleVprintViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RoleVprintViewModel$init$1(RoleVprintViewModel roleVprintViewModel, Continuation<? super RoleVprintViewModel$init$1> continuation) {
        super(2, continuation);
        this.this$0 = roleVprintViewModel;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new RoleVprintViewModel$init$1(this.this$0, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            RoleVprintViewModel roleVprintViewModel = this.this$0;
            Context context = SdkContext.f6675a.c().getContext();
            VoiceManager.Companion companion = VoiceManager.Companion;
            companion.getInstance().init(context);
            roleVprintViewModel.f = VoiceManager.spkRecogInit$default(companion.getInstance(), context, SpeakerVerificationType.SV_SSP_EMB, false, 4, (Object) null);
            RoleVprintViewModel roleVprintViewModel2 = this.this$0;
            long l = roleVprintViewModel2.f;
            roleVprintViewModel2.S("mSrVoiceprintEngine=" + l);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((RoleVprintViewModel$init$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
