package com.honey.account.bridge;

import android.content.Context;
import com.honey.account.constant.AccountConstantKt;
import com.honey.account.data.UploadAvatarData;
import com.honey.account.data.UploadAvatarDataKt;
import com.honey.account.utils.log.LogUtils;
import com.honey.account.utils.network.NetworkUtilsKt;
import com.honey.account.utils.network.Response;
import java.io.File;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001a&\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\t\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"TAG", "", "networkRequestUploadAvatar", "Lcom/honey/account/data/UploadAvatarData;", "context", "Landroid/content/Context;", "accessToken", "belong", "file", "Ljava/io/File;", "CoreLibrary_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class UserInfoBridgeKt {
    @NotNull
    private static final String TAG = "UserInfoBridge";

    @NotNull
    public static final UploadAvatarData networkRequestUploadAvatar(@NotNull Context context, @NotNull String str, @NotNull String str2, @NotNull File file) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "accessToken");
        Intrinsics.checkNotNullParameter(str2, "belong");
        Intrinsics.checkNotNullParameter(file, "file");
        HashMap hashMap = new HashMap();
        hashMap.put("access_token", str);
        hashMap.put(AccountConstantKt.REQUEST_PARAM_ACCOUNT_BELONG, str2);
        Response networkRequestUploadImage = NetworkUtilsKt.networkRequestUploadImage(AccountConstantKt.UPDATE_AVATAR, hashMap, (HashMap<String, String>) null, file);
        String body = networkRequestUploadImage.getBody();
        if (body != null && body.length() != 0) {
            return UploadAvatarDataKt.analysisUploadAvatar(context, networkRequestUploadImage.getBody());
        }
        LogUtils logUtils = LogUtils.INSTANCE;
        logUtils.e(TAG, "networkRequestUploadAvatar error, result: " + networkRequestUploadImage);
        int intValue = AccountConstantKt.getRESULT_RESPONSE_ERROR().getFirst().intValue();
        return new UploadAvatarData(intValue, AccountConstantKt.getRESULT_RESPONSE_ERROR().getSecond() + networkRequestUploadImage.getMessage(), (String) null, 4, (DefaultConstructorMarker) null);
    }
}
