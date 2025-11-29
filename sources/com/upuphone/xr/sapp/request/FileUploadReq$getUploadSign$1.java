package com.upuphone.xr.sapp.request;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.request.FileUploadReq", f = "FileUploadReq.kt", i = {}, l = {47, 327}, m = "getUploadSign", n = {}, s = {})
public final class FileUploadReq$getUploadSign$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FileUploadReq this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FileUploadReq$getUploadSign$1(FileUploadReq fileUploadReq, Continuation<? super FileUploadReq$getUploadSign$1> continuation) {
        super(continuation);
        this.this$0 = fileUploadReq;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.i((String) null, 0, this);
    }
}
