package com.upuphone.xr.sapp.request;

import android.net.Uri;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.request.FileUploadReq", f = "FileUploadReq.kt", i = {0, 0}, l = {296, 298}, m = "uriToOssFileUrl", n = {"this", "expiration"}, s = {"L$0", "J$0"})
public final class FileUploadReq$uriToOssFileUrl$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FileUploadReq this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FileUploadReq$uriToOssFileUrl$1(FileUploadReq fileUploadReq, Continuation<? super FileUploadReq$uriToOssFileUrl$1> continuation) {
        super(continuation);
        this.this$0 = fileUploadReq;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.n((Uri) null, (String) null, 0, (Function1) null, this);
    }
}
