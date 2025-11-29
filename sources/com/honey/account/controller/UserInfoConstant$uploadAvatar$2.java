package com.honey.account.controller;

import android.content.Context;
import com.honey.account.AccountHelper;
import com.honey.account.bridge.UserInfoBridgeKt;
import com.honey.account.constant.AccountConstantKt;
import com.honey.account.data.UploadAvatarData;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/honey/account/data/UploadAvatarData;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class UserInfoConstant$uploadAvatar$2 extends Lambda implements Function0<UploadAvatarData> {
    final /* synthetic */ Context $context;
    final /* synthetic */ String $filePath;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UserInfoConstant$uploadAvatar$2(Context context, String str) {
        super(0);
        this.$context = context;
        this.$filePath = str;
    }

    @NotNull
    public final UploadAvatarData invoke() {
        String mBelong = AccountHelper.INSTANCE.getMBelong();
        String authToken = LoginController.INSTANCE.getAuthToken(this.$context);
        if (authToken == null || authToken.length() == 0) {
            int intValue = AccountConstantKt.getRESULT_PARAMETER_ERROR().getFirst().intValue();
            return new UploadAvatarData(intValue, AccountConstantKt.getRESULT_PARAMETER_ERROR().getSecond() + "token is null", (String) null, 4, (DefaultConstructorMarker) null);
        }
        File file = new File(this.$filePath);
        if (!file.exists()) {
            int intValue2 = AccountConstantKt.getRESULT_PARAMETER_ERROR().getFirst().intValue();
            return new UploadAvatarData(intValue2, AccountConstantKt.getRESULT_PARAMETER_ERROR().getSecond() + "file no exists", (String) null, 4, (DefaultConstructorMarker) null);
        }
        UploadAvatarData networkRequestUploadAvatar = UserInfoBridgeKt.networkRequestUploadAvatar(this.$context, authToken, mBelong, file);
        networkRequestUploadAvatar.getIcon();
        return networkRequestUploadAvatar;
    }
}
