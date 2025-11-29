package com.upuphone.xr.sapp.request;

import java.io.File;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.request.FileUploadReq", f = "FileUploadReq.kt", i = {0, 0, 0, 0, 1}, l = {117, 151}, m = "uploadFile", n = {"this", "file", "fileName", "progressCall", "uploadInfo"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0"})
public final class FileUploadReq$uploadFile$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FileUploadReq this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FileUploadReq$uploadFile$1(FileUploadReq fileUploadReq, Continuation<? super FileUploadReq$uploadFile$1> continuation) {
        super(continuation);
        this.this$0 = fileUploadReq;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.l((File) null, (String) null, (Function1) null, this);
    }
}
