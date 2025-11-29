package com.honey.account.controller;

import android.content.Context;
import com.honey.account.AccountHelper;
import com.honey.account.bridge.AccountAttributeBridgeKt;
import com.honey.account.constant.AccountConstantKt;
import com.honey.account.data.UpdateNickNameData;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/honey/account/data/UpdateNickNameData;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class UserInfoConstant$updateNickName$2 extends Lambda implements Function0<UpdateNickNameData> {
    final /* synthetic */ Context $context;
    final /* synthetic */ String $nickName;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UserInfoConstant$updateNickName$2(Context context, String str) {
        super(0);
        this.$context = context;
        this.$nickName = str;
    }

    @NotNull
    public final UpdateNickNameData invoke() {
        String str = Locale.getDefault().getLanguage() + '_' + Locale.getDefault().getCountry();
        String mBelong = AccountHelper.INSTANCE.getMBelong();
        String authToken = LoginController.INSTANCE.getAuthToken(this.$context);
        if (authToken == null || authToken.length() == 0) {
            return new UpdateNickNameData(AccountConstantKt.getRESULT_PARAMETER_ERROR().getFirst().intValue(), AccountConstantKt.getRESULT_PARAMETER_ERROR().getSecond() + "token is null", false, 4, (DefaultConstructorMarker) null);
        }
        UpdateNickNameData networkRequestUpdateNickName = AccountAttributeBridgeKt.networkRequestUpdateNickName(this.$context, authToken, this.$nickName, mBelong, str);
        networkRequestUpdateNickName.getCode();
        return networkRequestUpdateNickName;
    }
}
