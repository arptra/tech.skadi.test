package com.upuphone.star.fota.phone.utils;

import java.io.IOException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"com/upuphone/star/fota/phone/utils/CallExtKt$awaitResponseResult$2$2", "Lokhttp3/Callback;", "onFailure", "", "call", "Lokhttp3/Call;", "e", "Ljava/io/IOException;", "onResponse", "response", "Lokhttp3/Response;", "ar-fota-lib_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class CallExtKt$awaitResponseResult$2$2 implements Callback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CancellableContinuation f6473a;

    public CallExtKt$awaitResponseResult$2$2(CancellableContinuation cancellableContinuation) {
        this.f6473a = cancellableContinuation;
    }

    public void onFailure(Call call, IOException iOException) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(iOException, "e");
        CancellableContinuation cancellableContinuation = this.f6473a;
        Result.Companion companion = Result.Companion;
        cancellableContinuation.resumeWith(Result.m20constructorimpl(Result.m19boximpl(Result.m20constructorimpl(ResultKt.createFailure(iOException)))));
    }

    public void onResponse(Call call, Response response) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(response, "response");
        this.f6473a.resumeWith(Result.m20constructorimpl(Result.m19boximpl(Result.m20constructorimpl(response))));
    }
}
