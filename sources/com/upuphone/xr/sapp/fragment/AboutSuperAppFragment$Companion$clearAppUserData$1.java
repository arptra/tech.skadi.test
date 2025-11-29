package com.upuphone.xr.sapp.fragment;

import android.content.Context;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.utils.AppUtils;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import okhttp3.ResponseBody;

@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"com/upuphone/xr/sapp/fragment/AboutSuperAppFragment$Companion$clearAppUserData$1", "Lokhttp3/Callback;", "onFailure", "", "call", "Lokhttp3/Call;", "e", "Ljava/io/IOException;", "onResponse", "response", "Lokhttp3/Response;", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class AboutSuperAppFragment$Companion$clearAppUserData$1 implements Callback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f6940a;

    public AboutSuperAppFragment$Companion$clearAppUserData$1(Context context) {
        this.f6940a = context;
    }

    public void onFailure(Call call, IOException iOException) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(iOException, "e");
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("AboutSuperAppFragment", "clearAppUserData, onFailure e:" + iOException);
        AppUtils.f7842a.b(this.f6940a);
    }

    public void onResponse(Call call, Response response) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(response, "response");
        ULog.Delegate delegate = ULog.f6446a;
        String message = response.message();
        int code = response.code();
        ResponseBody body = response.body();
        Intrinsics.checkNotNull(body);
        String string = body.string();
        delegate.a("AboutSuperAppFragment", "clearAppUserData, onResponse  response.message=" + message + " response.code=" + code + " response.body.string()=" + string);
        AppUtils.f7842a.b(this.f6940a);
    }
}
