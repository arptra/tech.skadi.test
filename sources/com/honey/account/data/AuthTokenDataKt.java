package com.honey.account.data;

import android.content.Context;
import com.google.android.gms.common.Scopes;
import com.honey.account.AccountHelper;
import com.honey.account.constant.AccountConstantKt;
import com.honey.account.utils.log.LogUtils;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.upuphone.xr.sapp.contract.ProtocolCategory;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0001\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"TAG", "", "analysisAuthToken", "Lcom/honey/account/data/AuthTokenData;", "context", "Landroid/content/Context;", "responseBody", "CoreLibrary_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class AuthTokenDataKt {
    @NotNull
    private static final String TAG = "AuthTokenData";

    @NotNull
    public static final AuthTokenData analysisAuthToken(@NotNull Context context, @NotNull String str) {
        String str2;
        int i;
        int i2;
        String str3 = str;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str3, "responseBody");
        try {
            JSONObject jSONObject = new JSONObject(str3);
            if (jSONObject.has("access_token")) {
                i = 200;
                str2 = jSONObject.getString("access_token");
            } else {
                i = 0;
                str2 = null;
            }
            String string = jSONObject.has("token_type") ? jSONObject.getString("token_type") : null;
            String string2 = jSONObject.has(Oauth2AccessToken.KEY_REFRESH_TOKEN) ? jSONObject.getString(Oauth2AccessToken.KEY_REFRESH_TOKEN) : null;
            Integer valueOf = jSONObject.has(Oauth2AccessToken.KEY_EXPIRES_IN) ? Integer.valueOf(jSONObject.getInt(Oauth2AccessToken.KEY_EXPIRES_IN)) : null;
            String string3 = jSONObject.has("scope") ? jSONObject.getString("scope") : null;
            String string4 = jSONObject.has("icon") ? jSONObject.getString("icon") : null;
            String string5 = jSONObject.has("phone") ? jSONObject.getString("phone") : null;
            String string6 = jSONObject.has(Scopes.EMAIL) ? jSONObject.getString(Scopes.EMAIL) : null;
            String string7 = jSONObject.has("nickname") ? jSONObject.getString("nickname") : null;
            Integer valueOf2 = jSONObject.has("user_id") ? Integer.valueOf(jSONObject.getInt("user_id")) : null;
            String string8 = jSONObject.has(ProtocolCategory.FLYME) ? jSONObject.getString(ProtocolCategory.FLYME) : null;
            if (Intrinsics.areEqual((Object) AccountConstantKt.ACCOUNT_STATUS_DELETE, (Object) jSONObject.optString("error"))) {
                AccountHelper.INSTANCE.logout();
                i2 = 990001;
            } else {
                i2 = i;
            }
            return new AuthTokenData(i2, "", str2, string, string2, valueOf, string3, string4, string5, string6, string7, valueOf2, string8);
        } catch (Exception e) {
            e.printStackTrace();
            LogUtils.INSTANCE.e(TAG, "AuthTokenData analysis error, " + e.getMessage());
            int intValue = AccountConstantKt.getRESULT_PROGRAM_EXCEPTION().getFirst().intValue();
            StringBuilder sb = new StringBuilder();
            sb.append(AccountConstantKt.getRESULT_PROGRAM_EXCEPTION().getSecond());
            String message = e.getMessage();
            Intrinsics.checkNotNull(message);
            sb.append(message);
            return new AuthTokenData(intValue, sb.toString(), (String) null, (String) null, (String) null, (Integer) null, (String) null, (String) null, (String) null, (String) null, (String) null, (Integer) null, (String) null, 8188, (DefaultConstructorMarker) null);
        }
    }
}
