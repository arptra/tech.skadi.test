package com.upuphone.ar.translation.phone.activity;

import com.upuphone.ar.translation.phone.databinding.ItemDetailListHeadBinding;
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
@DebugMetadata(c = "com.upuphone.ar.translation.phone.activity.TranslatorRecordActivity$updateListRecord$1$1$3", f = "TranslatorRecordActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class TranslatorRecordActivity$updateListRecord$1$1$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ TranslatorRecordActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TranslatorRecordActivity$updateListRecord$1$1$3(TranslatorRecordActivity translatorRecordActivity, Continuation<? super TranslatorRecordActivity$updateListRecord$1$1$3> continuation) {
        super(2, continuation);
        this.this$0 = translatorRecordActivity;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new TranslatorRecordActivity$updateListRecord$1$1$3(this.this$0, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            TranslatorRecordActivity translatorRecordActivity = this.this$0;
            ItemDetailListHeadBinding access$getMListHeadBinding$p = translatorRecordActivity.mListHeadBinding;
            if (access$getMListHeadBinding$p == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mListHeadBinding");
                access$getMListHeadBinding$p = null;
            }
            translatorRecordActivity.updateEditStatus(2, access$getMListHeadBinding$p.b.q(), this.this$0.isListRecordEdited(), this.this$0.isListTitleUpdated() || this.this$0.isListRecordUpdated());
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((TranslatorRecordActivity$updateListRecord$1$1$3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
