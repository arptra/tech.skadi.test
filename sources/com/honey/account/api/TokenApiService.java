package com.honey.account.api;

import com.honey.account.view.oauth.data.OAuthTokenData;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J'\u0010\u0002\u001a\u00020\u00032\u0014\b\u0001\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0007\u0002\u0004\n\u0002\b\u0019¨\u0006\b"}, d2 = {"Lcom/honey/account/api/TokenApiService;", "", "getAuthToken", "Lcom/honey/account/view/oauth/data/OAuthTokenData;", "fields", "", "", "(Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "CoreLibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface TokenApiService {
    @FormUrlEncoded
    @Nullable
    @POST("https://api.in.meizu.com/oauth/token")
    Object getAuthToken(@NotNull @FieldMap Map<String, String> map, @NotNull Continuation<? super OAuthTokenData> continuation);
}
