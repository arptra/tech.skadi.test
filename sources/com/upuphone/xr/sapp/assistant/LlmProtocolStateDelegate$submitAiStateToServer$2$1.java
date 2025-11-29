package com.upuphone.xr.sapp.assistant;

import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.entity.AIModelResult;
import java.io.IOException;
import java.net.SocketTimeoutException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"com/upuphone/xr/sapp/assistant/LlmProtocolStateDelegate$submitAiStateToServer$2$1", "Lokhttp3/Callback;", "onFailure", "", "call", "Lokhttp3/Call;", "e", "Ljava/io/IOException;", "onResponse", "response", "Lokhttp3/Response;", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class LlmProtocolStateDelegate$submitAiStateToServer$2$1 implements Callback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CancellableContinuation f6639a;
    public final /* synthetic */ LlmProtocolStateDelegate b;
    public final /* synthetic */ int c;

    public LlmProtocolStateDelegate$submitAiStateToServer$2$1(CancellableContinuation cancellableContinuation, LlmProtocolStateDelegate llmProtocolStateDelegate, int i) {
        this.f6639a = cancellableContinuation;
        this.b = llmProtocolStateDelegate;
        this.c = i;
    }

    public void onFailure(Call call, IOException iOException) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(iOException, "e");
        ULog.f6446a.d("LlmProtocolStateDelegate", "submitAiStateToServer: failed", iOException);
        if (iOException instanceof SocketTimeoutException) {
            CancellableContinuation cancellableContinuation = this.f6639a;
            Result.Companion companion = Result.Companion;
            cancellableContinuation.resumeWith(Result.m20constructorimpl(this.b.n()));
            return;
        }
        CancellableContinuation cancellableContinuation2 = this.f6639a;
        Result.Companion companion2 = Result.Companion;
        cancellableContinuation2.resumeWith(Result.m20constructorimpl(this.b.k()));
    }

    public void onResponse(Call call, Response response) {
        AIModelResult aIModelResult;
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(response, "response");
        if (response.code() == 200) {
            ResponseBody body = response.body();
            Intrinsics.checkNotNull(body);
            String string = body.string();
            ULog.Delegate delegate = ULog.f6446a;
            delegate.a("LlmProtocolStateDelegate", "submitAiStateToServer: response->" + string);
            boolean areEqual = Intrinsics.areEqual(new JSONObject(string).get("code"), (Object) 0);
            this.b.h(this.c);
            this.b.w(this.c);
            this.b.x(true);
            aIModelResult = new AIModelResult(areEqual, this.c, false);
        } else {
            aIModelResult = this.b.k();
        }
        this.f6639a.resumeWith(Result.m20constructorimpl(aIModelResult));
    }
}
