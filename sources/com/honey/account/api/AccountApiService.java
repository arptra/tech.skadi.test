package com.honey.account.api;

import com.honey.account.data.AccountData;
import com.honey.account.data.LogoutData;
import com.honey.account.data.ResponseModel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J!\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0007J+\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00032\b\b\u0001\u0010\n\u001a\u00020\u00062\b\b\u0001\u0010\u0005\u001a\u00020\u0006H§@ø\u0001\u0000¢\u0006\u0002\u0010\u000b\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, d2 = {"Lcom/honey/account/api/AccountApiService;", "", "getDetail", "Lcom/honey/account/data/ResponseModel;", "Lcom/honey/account/data/AccountData;", "token", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "logout", "Lcom/honey/account/data/LogoutData;", "code", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "CoreLibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface AccountApiService {
    @FormUrlEncoded
    @Nullable
    @POST("https://i.in.meizu.com/uc/unirest/userInfoManage/basicInfo/getBasicUserInfo")
    Object getDetail(@NotNull @Field("access_token") String str, @NotNull Continuation<? super ResponseModel<AccountData>> continuation);

    @FormUrlEncoded
    @Nullable
    @POST("https://i.in.meizu.com/uc/unirest/userInfoManage/sdk/signout")
    Object logout(@NotNull @Field("validate_code") String str, @NotNull @Field("access_token") String str2, @NotNull Continuation<? super ResponseModel<LogoutData>> continuation);
}
