package com.upuphone.ar.fastrecord.phone.utils;

import android.content.Context;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.fastrecord.phone.utils.RecordVoiceUtils", f = "RecordVoiceUtils.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1}, l = {394, 397}, m = "getRecordWordShareFile", n = {"this", "context", "fileName", "voiceWordList", "recordId", "this", "context", "fileName", "voiceWordList", "mRecordSummaryEntity"}, s = {"L$0", "L$1", "L$2", "L$3", "J$0", "L$0", "L$1", "L$2", "L$3", "L$4"})
public final class RecordVoiceUtils$getRecordWordShareFile$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RecordVoiceUtils this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RecordVoiceUtils$getRecordWordShareFile$1(RecordVoiceUtils recordVoiceUtils, Continuation<? super RecordVoiceUtils$getRecordWordShareFile$1> continuation) {
        super(continuation);
        this.this$0 = recordVoiceUtils;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getRecordWordShareFile((Context) null, 0, (String) null, this);
    }
}
