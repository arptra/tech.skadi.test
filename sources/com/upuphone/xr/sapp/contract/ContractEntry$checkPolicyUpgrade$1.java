package com.upuphone.xr.sapp.contract;

import android.content.Context;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.contract.PolicyIdentify;
import com.upuphone.xr.sapp.utils.DataStoreUtils;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"com/upuphone/xr/sapp/contract/ContractEntry$checkPolicyUpgrade$1", "Lokhttp3/Callback;", "onFailure", "", "call", "Lokhttp3/Call;", "e", "Ljava/io/IOException;", "onResponse", "response", "Lokhttp3/Response;", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ContractEntry$checkPolicyUpgrade$1 implements Callback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function2 f6692a;

    public ContractEntry$checkPolicyUpgrade$1(Function2 function2) {
        this.f6692a = function2;
    }

    public void onFailure(Call call, IOException iOException) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(iOException, "e");
        ULog.Delegate delegate = ULog.f6446a;
        String b = ContractEntry.b;
        delegate.a(b, "[checkPolicyUpgrade] e->" + iOException);
        Function2 function2 = this.f6692a;
        if (function2 != null) {
            function2.invoke(Boolean.FALSE, iOException.toString());
        }
    }

    public void onResponse(Call call, Response response) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(response, "response");
        ULog.Delegate delegate = ULog.f6446a;
        String b = ContractEntry.b;
        Request request = call.request();
        int code = response.code();
        delegate.g(b, "checkPolicyUpgrade() request->" + request + ", response code->" + code);
        try {
            if (response.code() == 200) {
                ResponseBody body = response.body();
                Intrinsics.checkNotNull(body);
                String string = body.string();
                String b2 = ContractEntry.b;
                delegate.g(b2, "checkPolicyUpgrade()  body->" + string);
                JSONObject jSONObject = new JSONObject(string);
                if (jSONObject.getInt("code") == 200) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject("data");
                    boolean z = jSONObject2.getBoolean("newest");
                    JSONObject jSONObject3 = jSONObject2.getJSONObject("data");
                    int i = jSONObject3.getInt("regrantFlag");
                    jSONObject3.getLong("id");
                    String string2 = jSONObject3.getString("policyMd5");
                    DataStoreUtils.Companion companion = DataStoreUtils.e;
                    String str = (String) DataStoreUtils.i(companion.a(), "PRIVACY_LATEST_MD5_KEY", PolicyIdentify.PHONE_MARS.ZH_MD5.getMd5(), (Context) null, 4, (Object) null);
                    DataStoreUtils a2 = companion.a();
                    Boolean bool = Boolean.TRUE;
                    boolean booleanValue = ((Boolean) DataStoreUtils.i(a2, "privacy_first_ugrade_regrant_key", bool, (Context) null, 4, (Object) null)).booleanValue();
                    String b3 = ContractEntry.b;
                    delegate.c(b3, "checkPolicyUpgrade(), newest=" + z + " regrantFlag=" + i + "latestMd5=" + str + " policyMd5=" + string2 + " firstRegrant=" + booleanValue);
                    Intrinsics.checkNotNull(string2);
                    if (string2.length() <= 0 || string2.equals(str) || i != 1 || booleanValue) {
                        Function2 function2 = this.f6692a;
                        if (function2 != null) {
                            function2.invoke(Boolean.FALSE, "no need upgrade");
                        }
                    } else {
                        companion.a().o("sp_user_agreement_state", Boolean.FALSE);
                        Function2 function22 = this.f6692a;
                        if (function22 != null) {
                            function22.invoke(bool, string2);
                        }
                    }
                    if (booleanValue) {
                        companion.a().o("privacy_first_ugrade_regrant_key", Boolean.FALSE);
                        return;
                    }
                    return;
                }
                Function2 function23 = this.f6692a;
                if (function23 != null) {
                    function23.invoke(Boolean.FALSE, "data code error.");
                    return;
                }
                return;
            }
            Function2 function24 = this.f6692a;
            if (function24 != null) {
                function24.invoke(Boolean.FALSE, "response code error.");
            }
        } catch (Exception e) {
            ULog.Delegate delegate2 = ULog.f6446a;
            String b4 = ContractEntry.b;
            Request request2 = call.request();
            delegate2.c(b4, "checkPolicyUpgrade(), request->" + request2 + " failed, e->" + e);
            Function2 function25 = this.f6692a;
            if (function25 != null) {
                function25.invoke(Boolean.FALSE, e.toString());
            }
        }
    }
}
