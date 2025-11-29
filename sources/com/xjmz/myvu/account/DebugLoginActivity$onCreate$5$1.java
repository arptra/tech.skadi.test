package com.xjmz.myvu.account;

import com.upuphone.star.core.log.ULog;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import okhttp3.ResponseBody;

@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"com/xjmz/myvu/account/DebugLoginActivity$onCreate$5$1", "Lokhttp3/Callback;", "onFailure", "", "call", "Lokhttp3/Call;", "e", "Ljava/io/IOException;", "onResponse", "response", "Lokhttp3/Response;", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class DebugLoginActivity$onCreate$5$1 implements Callback {
    public void onFailure(Call call, IOException iOException) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(iOException, "e");
        ULog.Delegate delegate = ULog.f6446a;
        delegate.g("DebugLoginActivity", "onFailure() called with: e = " + iOException);
    }

    public void onResponse(Call call, Response response) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(response, "response");
        ULog.Delegate delegate = ULog.f6446a;
        int code = response.code();
        ResponseBody body = response.body();
        String string = body != null ? body.string() : null;
        delegate.g("DebugLoginActivity", "onResponse() called with: response = " + code + " - " + string);
    }
}
