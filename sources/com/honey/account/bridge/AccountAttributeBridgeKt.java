package com.honey.account.bridge;

import android.content.Context;
import com.honey.account.constant.AccountConstantKt;
import com.honey.account.data.UpdateNickNameData;
import com.honey.account.data.UpdateNickNameDataKt;
import com.honey.account.utils.log.LogUtils;
import com.honey.account.utils.network.NetworkUtilsKt;
import com.honey.account.utils.network.Response;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a.\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u0001\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"TAG", "", "networkRequestUpdateNickName", "Lcom/honey/account/data/UpdateNickNameData;", "context", "Landroid/content/Context;", "accessToken", "nickName", "belong", "lang", "CoreLibrary_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class AccountAttributeBridgeKt {
    @NotNull
    private static final String TAG = "AccountAttributeStateBridge";

    @NotNull
    public static final UpdateNickNameData networkRequestUpdateNickName(@NotNull Context context, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "accessToken");
        Intrinsics.checkNotNullParameter(str2, "nickName");
        Intrinsics.checkNotNullParameter(str3, "belong");
        Intrinsics.checkNotNullParameter(str4, "lang");
        HashMap hashMap = new HashMap();
        hashMap.put("access_token", str);
        hashMap.put("nickname", str2);
        hashMap.put(AccountConstantKt.REQUEST_PARAM_ACCOUNT_BELONG, str3);
        hashMap.put("lang", str4);
        Response networkRequestToPostForm$default = NetworkUtilsKt.networkRequestToPostForm$default(AccountConstantKt.UPDATE_NICK_NAME, hashMap, (HashMap) null, 4, (Object) null);
        String body = networkRequestToPostForm$default.getBody();
        if (body != null && body.length() != 0) {
            return UpdateNickNameDataKt.analysisUpdateNickName(context, networkRequestToPostForm$default.getBody());
        }
        LogUtils logUtils = LogUtils.INSTANCE;
        logUtils.e(TAG, "networkRequestUpdateNickName error, result: " + networkRequestToPostForm$default);
        int intValue = AccountConstantKt.getRESULT_RESPONSE_ERROR().getFirst().intValue();
        return new UpdateNickNameData(intValue, AccountConstantKt.getRESULT_RESPONSE_ERROR().getSecond() + networkRequestToPostForm$default.getMessage(), false, 4, (DefaultConstructorMarker) null);
    }
}
