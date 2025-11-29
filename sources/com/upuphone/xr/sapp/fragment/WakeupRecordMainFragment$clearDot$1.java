package com.upuphone.xr.sapp.fragment;

import android.content.Context;
import com.upuphone.ai.ttsengine.base.utils.SpUtils;
import com.upuphone.xr.sapp.context.SdkContext;
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
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.fragment.WakeupRecordMainFragment$clearDot$1", f = "WakeupRecordMainFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class WakeupRecordMainFragment$clearDot$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ WakeupRecordMainFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WakeupRecordMainFragment$clearDot$1(WakeupRecordMainFragment wakeupRecordMainFragment, Continuation<? super WakeupRecordMainFragment$clearDot$1> continuation) {
        super(2, continuation);
        this.this$0 = wakeupRecordMainFragment;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new WakeupRecordMainFragment$clearDot$1(this.this$0, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            Context requireContext = this.this$0.requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
            Context requireContext2 = this.this$0.requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext2, "requireContext(...)");
            SpUtils.d(requireContext2, "wakeup_record_id", "", (String) null, 8, (Object) null);
            SdkContext.f6675a.d().reportEvent("VoiceWake-up_Voiceprint_Clear", MapsKt.mapOf(TuplesKt.to("vuid", (String) SpUtils.b(requireContext, "wakeup_record_id", "", (String) null, 8, (Object) null))));
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((WakeupRecordMainFragment$clearDot$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
