package com.upuphone.ar.tici.phone.utils;

import android.content.Context;
import android.net.Uri;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.tici.phone.utils.TiciHelper", f = "TiciHelper.kt", i = {0, 0, 0, 0, 1, 1, 1, 2}, l = {259, 290, 301}, m = "importTiciUri", n = {"this", "context", "uri", "supportLargeFile", "this", "supportLargeFile", "fileSize", "file"}, s = {"L$0", "L$1", "L$2", "Z$0", "L$0", "Z$0", "J$0", "L$0"})
public final class TiciHelper$importTiciUri$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ TiciHelper this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TiciHelper$importTiciUri$1(TiciHelper ticiHelper, Continuation<? super TiciHelper$importTiciUri$1> continuation) {
        super(continuation);
        this.this$0 = ticiHelper;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.i((Context) null, (Uri) null, false, this);
    }
}
