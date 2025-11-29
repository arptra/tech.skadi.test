package com.upuphone.ar.translation.phone.vm;

import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.translation.phone.vm.TranslatorRecordViewModel", f = "TranslatorRecordViewModel.kt", i = {0, 0, 0, 0, 0, 0, 0, 0}, l = {539}, m = "getUpdatedTextRecord", n = {"this", "text", "list", "spanBuilder", "transRecordIndex", "content", "textLen", "end"}, s = {"L$0", "L$1", "L$2", "L$3", "L$5", "L$6", "I$0", "I$2"})
public final class TranslatorRecordViewModel$getUpdatedTextRecord$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    int I$2;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ TranslatorRecordViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TranslatorRecordViewModel$getUpdatedTextRecord$1(TranslatorRecordViewModel translatorRecordViewModel, Continuation<? super TranslatorRecordViewModel$getUpdatedTextRecord$1> continuation) {
        super(continuation);
        this.this$0 = translatorRecordViewModel;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.H((String) null, (List) null, this);
    }
}
