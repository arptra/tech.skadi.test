package com.honey.account.bridge;

import android.content.Context;
import android.util.Pair;
import com.honey.account.AccountHelper;
import com.honey.account.constant.AccountConstantKt;
import com.honey.account.data.AuthTokenData;
import com.honey.account.data.AuthTokenDataKt;
import com.honey.account.data.RememberMeToPasswordData;
import com.honey.account.data.RememberMeToPasswordDataKt;
import com.honey.account.data.RememberMeToVerificationCodeData;
import com.honey.account.data.RememberMeToVerificationCodeDataKt;
import com.honey.account.utils.encrypt.Base64Coder;
import com.honey.account.utils.encrypt.MD5Kt;
import com.honey.account.utils.log.LogUtils;
import com.honey.account.utils.network.NetworkUtilsKt;
import com.honey.account.utils.network.Response;
import com.honey.account.utils.system.DeviceUtilsKt;
import com.honey.account.utils.system.PackageUtilsKt;
import java.util.HashMap;
import java.util.Random;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a*\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0001\u001a\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005\u001a>\u0010\t\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u0001\u001aV\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u00012\u0006\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u00012\u0006\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u0001\u001a.\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"TAG", "", "getAllHeader", "Ljava/util/HashMap;", "context", "Landroid/content/Context;", "param1", "param2", "getMustHeader", "networkRequestAuthToken", "Lcom/honey/account/data/AuthTokenData;", "scope", "rememberMe", "grantType", "clientId", "belong", "clientSecret", "networkRequestRememberMeToPassword", "Lcom/honey/account/data/RememberMeToPasswordData;", "phone", "password", "authMode", "appVersion", "lang", "appId", "secret", "vCode", "networkRequestRememberMeToVerificationCode", "Lcom/honey/account/data/RememberMeToVerificationCodeData;", "verificationCode", "CoreLibrary_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class LoginBridgeKt {
    @NotNull
    private static final String TAG = "LoginBridge";

    @NotNull
    public static final HashMap<String, String> getAllHeader(@NotNull Context context, @NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "param1");
        Intrinsics.checkNotNullParameter(str2, "param2");
        HashMap<String, String> mustHeader = getMustHeader(context);
        mustHeader.put("imei", DeviceUtilsKt.getImeiOr0(context));
        AccountHelper accountHelper = AccountHelper.INSTANCE;
        mustHeader.put(AccountConstantKt.REQUEST_HEADER_APP_ID, accountHelper.getMAppId());
        String valueOf = String.valueOf((System.currentTimeMillis() / ((long) 1000)) + ((long) new Random().nextInt()));
        mustHeader.put("nonce", valueOf);
        String format = String.format("%s%s%s%s", new Object[]{accountHelper.getMAppId(), valueOf, str, str2});
        String encodeString = Base64Coder.encodeString(MD5Kt.MD5Encode(format + accountHelper.getMSecret(), "UTF-8"));
        Intrinsics.checkNotNullExpressionValue(encodeString, "encodeString(...)");
        mustHeader.put(AccountConstantKt.REQUEST_HEADER_SIGN, encodeString);
        return mustHeader;
    }

    @NotNull
    public static final HashMap<String, String> getMustHeader(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        HashMap<String, String> hashMap = new HashMap<>();
        String packageName = context.getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName, "getPackageName(...)");
        hashMap.put(AccountConstantKt.REQUEST_HEADER_PKG, packageName);
        hashMap.put(AccountConstantKt.REQUEST_HEADER_APP_VER, PackageUtilsKt.getAppVersionName(context));
        hashMap.put(AccountConstantKt.REQUEST_HEADER_OS_VER, DeviceUtilsKt.getOsVersion());
        hashMap.put("model", DeviceUtilsKt.getModel());
        hashMap.put("brand", DeviceUtilsKt.getBrand());
        hashMap.put(AccountConstantKt.REQUEST_HEADER_OAID, DeviceUtilsKt.getOaidOrOtherId(context));
        return hashMap;
    }

    @NotNull
    public static final AuthTokenData networkRequestAuthToken(@NotNull Context context, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6) {
        Context context2 = context;
        String str7 = str;
        String str8 = str2;
        String str9 = str3;
        String str10 = str4;
        String str11 = str5;
        String str12 = str6;
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(str7, "scope");
        Intrinsics.checkNotNullParameter(str8, "rememberMe");
        Intrinsics.checkNotNullParameter(str9, "grantType");
        Intrinsics.checkNotNullParameter(str10, "clientId");
        Intrinsics.checkNotNullParameter(str11, "belong");
        Intrinsics.checkNotNullParameter(str12, "clientSecret");
        HashMap hashMap = new HashMap();
        hashMap.put("scope", str7);
        hashMap.put("remember_me", str8);
        hashMap.put(AccountConstantKt.REQUEST_PARAM_GRANT_TYPE, str9);
        hashMap.put("client_id", str10);
        hashMap.put(AccountConstantKt.REQUEST_PARAM_ACCOUNT_BELONG, str11);
        hashMap.put(AccountConstantKt.REQUEST_PARAM_CLIENT_SECRET, str12);
        hashMap.put("device_id", DeviceUtilsKt.getOaidOrOtherId(context));
        Response networkRequestToPostForm$default = NetworkUtilsKt.networkRequestToPostForm$default(AccountConstantKt.URL_OAUTH_TOKEN, hashMap, (HashMap) null, 4, (Object) null);
        String body = networkRequestToPostForm$default.getBody();
        if (body != null && body.length() != 0) {
            return AuthTokenDataKt.analysisAuthToken(context2, networkRequestToPostForm$default.getBody());
        }
        LogUtils logUtils = LogUtils.INSTANCE;
        logUtils.e(TAG, "networkRequestAuthToken error, result: " + networkRequestToPostForm$default);
        int intValue = AccountConstantKt.getRESULT_RESPONSE_ERROR().getFirst().intValue();
        return new AuthTokenData(intValue, AccountConstantKt.getRESULT_RESPONSE_ERROR().getSecond() + networkRequestToPostForm$default.getMessage(), (String) null, (String) null, (String) null, (Integer) null, (String) null, (String) null, (String) null, (String) null, (String) null, (Integer) null, (String) null, 8188, (DefaultConstructorMarker) null);
    }

    @NotNull
    public static final RememberMeToPasswordData networkRequestRememberMeToPassword(@NotNull Context context, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, @NotNull String str7, @NotNull String str8, @NotNull String str9) {
        Context context2 = context;
        String str10 = str;
        String str11 = str3;
        String str12 = str4;
        String str13 = str5;
        String str14 = str6;
        String str15 = str7;
        String str16 = str8;
        String str17 = str9;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "phone");
        String str18 = str2;
        Intrinsics.checkNotNullParameter(str2, AccountConstantKt.INTENT_PARAM_PASSWORD);
        Intrinsics.checkNotNullParameter(str11, "authMode");
        Intrinsics.checkNotNullParameter(str12, "appVersion");
        Intrinsics.checkNotNullParameter(str13, "belong");
        Intrinsics.checkNotNullParameter(str14, "lang");
        Intrinsics.checkNotNullParameter(str15, "appId");
        Intrinsics.checkNotNullParameter(str16, "secret");
        Intrinsics.checkNotNullParameter(str17, "vCode");
        Pair<String, String> xSValue = OAuthManager.getXSValue(str2);
        HashMap hashMap = new HashMap();
        hashMap.put(AccountConstantKt.REQUEST_PARAM_X_AUTH_MODE, str11);
        hashMap.put(AccountConstantKt.REQUEST_PARAM_X_AUTH_SN, DeviceUtilsKt.getSn());
        hashMap.put(AccountConstantKt.REQUEST_PARAM_FIRMWARE, DeviceUtilsKt.getSystemVersion());
        hashMap.put("imei", DeviceUtilsKt.getImeiOr0(context));
        hashMap.put(AccountConstantKt.REQUEST_PARAM_APP_VERSION, str12);
        hashMap.put(AccountConstantKt.REQUEST_PARAM_DEVICE_MODEL, DeviceUtilsKt.getModel());
        hashMap.put(AccountConstantKt.REQUEST_PARAM_ACCOUNT_BELONG, str13);
        hashMap.put("lang", str14);
        hashMap.put("brand", DeviceUtilsKt.getBrand());
        hashMap.put(AccountConstantKt.REQUEST_PARAM_X_USER_NAME, str);
        Object obj = xSValue.second;
        Intrinsics.checkNotNullExpressionValue(obj, "second");
        hashMap.put(AccountConstantKt.REQUEST_PARAM_X_USER_PASSWORD, obj);
        hashMap.put(AccountConstantKt.REQUEST_PARAM_V_CODE, str17);
        HashMap hashMap2 = new HashMap();
        Object obj2 = xSValue.first;
        Intrinsics.checkNotNullExpressionValue(obj2, "first");
        hashMap2.put(AccountConstantKt.REQUEST_HEADER_X_S, obj2);
        String authorization = OAuthManager.getAuthorization(AccountConstantKt.URL_REMEMBER_ME_TO_PASSWORD, str15, str16, true, hashMap);
        Intrinsics.checkNotNullExpressionValue(authorization, "getAuthorization(...)");
        hashMap2.put("Authorization", authorization);
        hashMap2.put("Accept-Language", str14);
        hashMap2.put(AccountConstantKt.REQUEST_HEADER_NETWORK, String.valueOf(NetworkUtilsKt.getNetworkInfo(context)));
        HashMap hashMap3 = new HashMap();
        hashMap3.putAll(hashMap);
        Response networkRequestToPostForm = NetworkUtilsKt.networkRequestToPostForm(AccountConstantKt.URL_REMEMBER_ME_TO_PASSWORD, hashMap3, hashMap2);
        String body = networkRequestToPostForm.getBody();
        if (body != null && body.length() != 0) {
            return RememberMeToPasswordDataKt.analysisRememberMeToPassword(context, networkRequestToPostForm.getBody());
        }
        LogUtils logUtils = LogUtils.INSTANCE;
        logUtils.e(TAG, "networkRequestRememberMeToPassword error, result: " + networkRequestToPostForm);
        int intValue = AccountConstantKt.getRESULT_RESPONSE_ERROR().getFirst().intValue();
        return new RememberMeToPasswordData(intValue, AccountConstantKt.getRESULT_RESPONSE_ERROR().getSecond() + networkRequestToPostForm.getMessage(), false, (String) null, 12, (DefaultConstructorMarker) null);
    }

    @NotNull
    public static final RememberMeToVerificationCodeData networkRequestRememberMeToVerificationCode(@NotNull Context context, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "phone");
        Intrinsics.checkNotNullParameter(str2, "verificationCode");
        Intrinsics.checkNotNullParameter(str3, "belong");
        Intrinsics.checkNotNullParameter(str4, "lang");
        HashMap hashMap = new HashMap();
        hashMap.put("phone", str);
        hashMap.put(AccountConstantKt.REQUEST_PARAM_V_CODE, str2);
        hashMap.put(AccountConstantKt.REQUEST_PARAM_ACCOUNT_BELONG, str3);
        hashMap.put("lang", str4);
        Response networkRequestToPostForm = NetworkUtilsKt.networkRequestToPostForm(AccountConstantKt.URL_REMEMBER_ME_TO_VERIFICATION_CODE, hashMap, getAllHeader(context, str, str2));
        String body = networkRequestToPostForm.getBody();
        if (body != null && body.length() != 0) {
            return RememberMeToVerificationCodeDataKt.analysisRememberMeToVerificationCode(context, networkRequestToPostForm.getBody());
        }
        LogUtils logUtils = LogUtils.INSTANCE;
        logUtils.e(TAG, "networkRequestRememberMeToVerificationCode error, result: " + networkRequestToPostForm);
        int intValue = AccountConstantKt.getRESULT_RESPONSE_ERROR().getFirst().intValue();
        return new RememberMeToVerificationCodeData(intValue, AccountConstantKt.getRESULT_RESPONSE_ERROR().getSecond() + networkRequestToPostForm.getMessage(), false, (String) null, 12, (DefaultConstructorMarker) null);
    }
}
