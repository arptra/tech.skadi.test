package com.upuphone.xr.sapp.fragment;

import com.upuphone.xr.sapp.utils.SrVoiceprintStorageHelper;
import java.util.Arrays;
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

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0014\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.fragment.VoiceprintSrRecordFragment$generateVoiceprint$1$1$vpSrFloatArr$1", f = "VoiceprintSrRecordFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class VoiceprintSrRecordFragment$generateVoiceprint$1$1$vpSrFloatArr$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super float[]>, Object> {
    int label;
    final /* synthetic */ VoiceprintSrRecordFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VoiceprintSrRecordFragment$generateVoiceprint$1$1$vpSrFloatArr$1(VoiceprintSrRecordFragment voiceprintSrRecordFragment, Continuation<? super VoiceprintSrRecordFragment$generateVoiceprint$1$1$vpSrFloatArr$1> continuation) {
        super(2, continuation);
        this.this$0 = voiceprintSrRecordFragment;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new VoiceprintSrRecordFragment$generateVoiceprint$1$1$vpSrFloatArr$1(this.this$0, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            SrVoiceprintStorageHelper.f7916a.a();
            byte[] G0 = this.this$0.m;
            byte[] copyOf = Arrays.copyOf(G0, G0.length);
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
            SrVoiceprintStorageHelper.c(copyOf, "RecordRoleVprint.pcm");
            return this.this$0.e1().M(this.this$0.m);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super float[]> continuation) {
        return ((VoiceprintSrRecordFragment$generateVoiceprint$1$1$vpSrFloatArr$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
