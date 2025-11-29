package com.upuphone.ar.translation.phone.vm;

import android.media.AudioManager;
import android.os.Build;
import com.upuphone.ar.translation.ext.LogExt;
import com.upuphone.ar.translation.utils.RomUtils;
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
@DebugMetadata(c = "com.upuphone.ar.translation.phone.vm.DialogueTranslationViewModel$resetAudioDevice$1", f = "DialogueTranslationViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class DialogueTranslationViewModel$resetAudioDevice$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ DialogueTranslationViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DialogueTranslationViewModel$resetAudioDevice$1(DialogueTranslationViewModel dialogueTranslationViewModel, Continuation<? super DialogueTranslationViewModel$resetAudioDevice$1> continuation) {
        super(2, continuation);
        this.this$0 = dialogueTranslationViewModel;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new DialogueTranslationViewModel$resetAudioDevice$1(this.this$0, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            AudioManager j = this.this$0.g;
            if (j != null) {
                DialogueTranslationViewModel dialogueTranslationViewModel = this.this$0;
                if (dialogueTranslationViewModel.h) {
                    int i = Build.VERSION.SDK_INT;
                    LogExt.j("resetAudioDevice version=" + i, "DialogueTranslationViewModel");
                    dialogueTranslationViewModel.h = false;
                    j.setMode(0);
                    if (i >= 31) {
                        j.clearCommunicationDevice();
                    }
                    if (!RomUtils.f6371a.f()) {
                        dialogueTranslationViewModel.c0();
                    }
                } else {
                    LogExt.j("resetAudioDevice not switch to speaker", "DialogueTranslationViewModel");
                }
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((DialogueTranslationViewModel$resetAudioDevice$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
