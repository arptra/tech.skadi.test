package com.upuphone.ar.translation.phone.vm;

import com.upuphone.ar.translation.phone.bean.NoteBean;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.translation.phone.vm.TranslatorRecordViewModel", f = "TranslatorRecordViewModel.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1}, l = {146, 166}, m = "getTextRecordData", n = {"this", "srcRecords", "dstRecords", "spanBuilder", "i", "this", "srcRecords", "dstRecords", "spanBuilder", "updateRemoteSrc", "updateRemoteDst", "i"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0"})
public final class TranslatorRecordViewModel$getTextRecordData$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ TranslatorRecordViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TranslatorRecordViewModel$getTextRecordData$1(TranslatorRecordViewModel translatorRecordViewModel, Continuation<? super TranslatorRecordViewModel$getTextRecordData$1> continuation) {
        super(continuation);
        this.this$0 = translatorRecordViewModel;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.F((NoteBean) null, (String) null, (String) null, this);
    }
}
