package com.upuphone.ar.transcribe.phone;

import com.upuphone.ar.transcribe.ext.LogExt;
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
@DebugMetadata(c = "com.upuphone.ar.transcribe.phone.TranscribeManager$storeTranslateResult$1", f = "TranscribeManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class TranscribeManager$storeTranslateResult$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $ownerType;
    final /* synthetic */ String $result;
    int label;
    final /* synthetic */ TranscribeManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TranscribeManager$storeTranslateResult$1(TranscribeManager transcribeManager, String str, int i, Continuation<? super TranscribeManager$storeTranslateResult$1> continuation) {
        super(2, continuation);
        this.this$0 = transcribeManager;
        this.$result = str;
        this.$ownerType = i;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new TranscribeManager$storeTranslateResult$1(this.this$0, this.$result, this.$ownerType, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            LogExt.g("storeTranslateResult in coroutineScope", "TranscribeManager");
            this.this$0.r(this.$result, this.$ownerType);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((TranscribeManager$storeTranslateResult$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
