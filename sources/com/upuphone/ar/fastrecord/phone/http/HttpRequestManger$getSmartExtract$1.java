package com.upuphone.ar.fastrecord.phone.http;

import com.upuphone.ar.fastrecord.phone.ext.LogExt;
import com.upuphone.ar.fastrecord.phone.listener.IHttpResponse;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"com/upuphone/ar/fastrecord/phone/http/HttpRequestManger$getSmartExtract$1", "Lokhttp3/Callback;", "onFailure", "", "call", "Lokhttp3/Call;", "e", "Ljava/io/IOException;", "onResponse", "response", "Lokhttp3/Response;", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class HttpRequestManger$getSmartExtract$1 implements Callback {
    final /* synthetic */ IHttpResponse $httpResponse;

    public HttpRequestManger$getSmartExtract$1(IHttpResponse iHttpResponse) {
        this.$httpResponse = iHttpResponse;
    }

    public void onFailure(@NotNull Call call, @NotNull IOException iOException) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(iOException, "e");
        LogExt.logE("callback failed, e: " + iOException, "HttpRequestManger");
        this.$httpResponse.onResponseFailure(iOException.toString(), -1);
    }

    public void onResponse(@NotNull Call call, @NotNull Response response) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(response, "response");
        LogExt.logI("callback res body: " + response, "HttpRequestManger");
        if (response.code() == 200) {
            ResponseBody body = response.body();
            Intrinsics.checkNotNull(body);
            String string = body.string();
            LogExt.logI("callback response body: " + string, "HttpRequestManger");
            this.$httpResponse.onResponseSuccess(string, response.code());
            return;
        }
        IHttpResponse iHttpResponse = this.$httpResponse;
        ResponseBody body2 = response.body();
        Intrinsics.checkNotNull(body2);
        iHttpResponse.onResponseFailure(body2.string(), response.code());
    }
}
