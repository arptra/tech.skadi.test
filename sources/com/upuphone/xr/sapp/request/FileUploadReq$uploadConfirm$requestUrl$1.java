package com.upuphone.xr.sapp.request;

import com.upuphone.xr.sapp.config.NetConfig;
import java.net.URLDecoder;
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

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001*\u00020\u0003H@"}, d2 = {"<anonymous>", "", "kotlin.jvm.PlatformType", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.request.FileUploadReq$uploadConfirm$requestUrl$1", f = "FileUploadReq.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class FileUploadReq$uploadConfirm$requestUrl$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    final /* synthetic */ String $fileName;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FileUploadReq$uploadConfirm$requestUrl$1(String str, Continuation<? super FileUploadReq$uploadConfirm$requestUrl$1> continuation) {
        super(2, continuation);
        this.$fileName = str;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new FileUploadReq$uploadConfirm$requestUrl$1(this.$fileName, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            String v = NetConfig.f6666a.v("myvuFileService");
            String str = this.$fileName;
            return URLDecoder.decode(v + "/api/v2/files/presign/upload/confirm?filename=" + str, "UTF-8");
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super String> continuation) {
        return ((FileUploadReq$uploadConfirm$requestUrl$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
