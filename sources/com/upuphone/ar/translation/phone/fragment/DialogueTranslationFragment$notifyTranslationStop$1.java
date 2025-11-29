package com.upuphone.ar.translation.phone.fragment;

import com.upuphone.ar.translation.ext.LogExt;
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
@DebugMetadata(c = "com.upuphone.ar.translation.phone.fragment.DialogueTranslationFragment$notifyTranslationStop$1", f = "DialogueTranslationFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class DialogueTranslationFragment$notifyTranslationStop$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ DialogueTranslationFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DialogueTranslationFragment$notifyTranslationStop$1(DialogueTranslationFragment dialogueTranslationFragment, Continuation<? super DialogueTranslationFragment$notifyTranslationStop$1> continuation) {
        super(2, continuation);
        this.this$0 = dialogueTranslationFragment;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new DialogueTranslationFragment$notifyTranslationStop$1(this.this$0, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.e = false;
            if (!this.this$0.g) {
                this.this$0.g = false;
                return Unit.INSTANCE;
            }
            LogExt.g("notifyTranslationStop 启动对话翻译", "DialogueTranslationFragment");
            this.this$0.I1();
            this.this$0.g = false;
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((DialogueTranslationFragment$notifyTranslationStop$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
