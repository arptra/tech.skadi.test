package com.upuphone.xr.sapp.utils;

import android.content.Context;
import com.google.gson.Gson;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.entity.PolicyInfo;
import com.upuphone.xr.sapp.utils.DataStoreUtils;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONObject;

@Metadata(d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J#\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\f\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"com/upuphone/xr/sapp/utils/HttpRequestUtil$reportOperateRecordToServer$2", "Lokhttp3/Callback;", "Lokhttp3/Call;", "call", "Ljava/io/IOException;", "Lokio/IOException;", "e", "", "onFailure", "(Lokhttp3/Call;Ljava/io/IOException;)V", "Lokhttp3/Response;", "response", "onResponse", "(Lokhttp3/Call;Lokhttp3/Response;)V", "", "success", "a", "(Z)V", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class HttpRequestUtil$reportOperateRecordToServer$2 implements Callback {
    public final void a(boolean z) {
        ULog.Delegate delegate = ULog.f6446a;
        delegate.g("HttpRequestUtil", "requestOperateRecordSuccess() called with: success = " + z);
        Gson gson = new Gson();
        DataStoreUtils.Companion companion = DataStoreUtils.e;
        PolicyInfo policyInfo = (PolicyInfo) gson.fromJson((String) DataStoreUtils.i(companion.a(), "policy_operate_policy_info", "", (Context) null, 4, (Object) null), PolicyInfo.class);
        policyInfo.setReported(z);
        companion.a().o("policy_operate_policy_info", gson.toJson((Object) policyInfo));
    }

    public void onFailure(Call call, IOException iOException) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(iOException, "e");
        ULog.Delegate delegate = ULog.f6446a;
        delegate.c("HttpRequestUtil", "reportOperateRecord failed, e: " + iOException);
        a(false);
    }

    public void onResponse(Call call, Response response) {
        ResponseBody body;
        String string;
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(response, "response");
        boolean z = false;
        try {
            if (!(response.code() != 200 || (body = response.body()) == null || (string = body.string()) == null)) {
                ULog.Delegate delegate = ULog.f6446a;
                delegate.g("HttpRequestUtil", "reportOperateRecord res body: " + string);
                if (new JSONObject(string).getInt("code") == 200) {
                    z = true;
                }
            }
        } catch (Exception e) {
            ULog.Delegate delegate2 = ULog.f6446a;
            delegate2.c("HttpRequestUtil", "reportOperateRecord failed, e: " + e);
        }
        a(z);
    }
}
