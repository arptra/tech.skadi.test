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

@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"com/upuphone/xr/sapp/assistant/LlmProtocolStateDelegate$getAiStateFromServer$2$1", "Lokhttp3/Callback;", "onFailure", "", "call", "Lokhttp3/Call;", "e", "Ljava/io/IOException;", "onResponse", "response", "Lokhttp3/Response;", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class LlmProtocolStateDelegate$getAiStateFromServer$2$1 implements Callback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CancellableContinuation f6638a;
    public final /* synthetic */ LlmProtocolStateDelegate b;

    public LlmProtocolStateDelegate$getAiStateFromServer$2$1(CancellableContinuation cancellableContinuation, LlmProtocolStateDelegate llmProtocolStateDelegate) {
        this.f6638a = cancellableContinuation;
        this.b = llmProtocolStateDelegate;
    }

    public void onFailure(Call call, IOException iOException) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(iOException, "e");
        ULog.f6446a.d("LlmProtocolStateDelegate", "getAiStateFromServer: failed", iOException);
        if (iOException instanceof SocketTimeoutException) {
            CancellableContinuation cancellableContinuation = this.f6638a;
            Result.Companion companion = Result.Companion;
            cancellableContinuation.resumeWith(Result.m20constructorimpl(this.b.n()));
            return;
        }
        CancellableContinuation cancellableContinuation2 = this.f6638a;
        Result.Companion companion2 = Result.Companion;
        cancellableContinuation2.resumeWith(Result.m20constructorimpl(this.b.k()));
    }

    public void onResponse(Call call, Response response) {
        AIModelResult aIModelResult;
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(response, "response");
        if (response.code() != 200) {
            CancellableContinuation cancellableContinuation = this.f6638a;
            Result.Companion companion = Result.Companion;
            cancellableContinuation.resumeWith(Result.m20constructorimpl(this.b.k()));
            return;
        }
        ResponseBody body = response.body();
        Intrinsics.checkNotNull(body);
        String string = body.string();
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("LlmProtocolStateDelegate", "getAiStateFromServer: response->" + string);
        JSONObject jSONObject = new JSONObject(string);
        if (jSONObject.getInt("code") == 0) {
            JSONObject jSONObject2 = new JSONObject(jSONObject.get("data").toString());
            int i = jSONObject2.getInt("status");
            boolean z = jSONObject2.getBoolean("visible");
            delegate.a("LlmProtocolStateDelegate", "getAiStateFromServer, status->" + i + ", visible->" + z);
            int i2 = 1;
            if (i != 1) {
                i2 = 2;
            }
            aIModelResult = new AIModelResult(false, i2, z);
        } else {
            aIModelResult = this.b.k();
        }
        this.f6638a.resumeWith(Result.m20constructorimpl(aIModelResult));
    }
}
