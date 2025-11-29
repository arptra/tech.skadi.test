package com.upuphone.ar.fastrecord.phone.utils;

import com.upuphone.ar.fastrecord.phone.db.RecordEntity;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.fastrecord.phone.utils.RecordVoiceUtils", f = "RecordVoiceUtils.kt", i = {0, 0, 0, 1, 1, 1}, l = {130, 133}, m = "checkWordState", n = {"isHasWord", "record", "voiceWordList", "isHasWord", "voiceWordList", "mRecordSummaryEntity"}, s = {"L$0", "L$2", "L$3", "L$0", "L$2", "L$3"})
public final class RecordVoiceUtils$checkWordState$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RecordVoiceUtils this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RecordVoiceUtils$checkWordState$1(RecordVoiceUtils recordVoiceUtils, Continuation<? super RecordVoiceUtils$checkWordState$1> continuation) {
        super(continuation);
        this.this$0 = recordVoiceUtils;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.checkWordState((ArrayList<RecordEntity>) null, this);
    }
}
