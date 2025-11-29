package com.honey.account.api;

import com.honey.account.data.ResponseModel;
import com.honey.account.view.login.data.LoggedData;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.POST;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J-\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0014\b\u0001\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006H§@ø\u0001\u0000¢\u0006\u0002\u0010\bJ7\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00032\u0014\b\u0001\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0001\u0010\u000b\u001a\u00020\u0007H§@ø\u0001\u0000¢\u0006\u0002\u0010\f\u0002\u0004\n\u0002\b\u0019¨\u0006\r"}, d2 = {"Lcom/honey/account/api/LoginApiService;", "", "getVCode", "Lcom/honey/account/data/ResponseModel;", "", "fields", "", "", "(Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loginByEmail", "Lcom/honey/account/view/login/data/LoggedData;", "auth", "(Ljava/util/Map;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "CoreLibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface LoginApiService {
    @FormUrlEncoded
    @Nullable
    @POST("/oauth/new/unirest/sendNoLoginVcode")
    Object getVCode(@NotNull @FieldMap Map<String, String> map, @NotNull Continuation<? super ResponseModel<Boolean>> continuation);

    @FormUrlEncoded
    @Nullable
    @POST("/oauth/new/sdk/access_token_email")
    Object loginByEmail(@NotNull @FieldMap Map<String, String> map, @NotNull @Header("Authorization") String str, @NotNull Continuation<? super ResponseModel<LoggedData>> continuation);
}
