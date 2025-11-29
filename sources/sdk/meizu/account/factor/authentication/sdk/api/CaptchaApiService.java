package sdk.meizu.account.factor.authentication.sdk.api;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import okhttp3.ResponseBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.Response;
import retrofit2.http.POST;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0005\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006"}, d2 = {"Lsdk/meizu/account/factor/authentication/sdk/api/CaptchaApiService;", "", "init", "Lretrofit2/Response;", "Lokhttp3/ResponseBody;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface CaptchaApiService {
    @POST("https://i.flyme.cn/sec/geetest3")
    @Nullable
    Object init(@NotNull Continuation<? super Response<ResponseBody>> continuation);
}
