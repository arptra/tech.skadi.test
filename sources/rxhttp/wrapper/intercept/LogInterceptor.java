package rxhttp.wrapper.intercept;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import rxhttp.wrapper.OkHttpCompat;
import rxhttp.wrapper.utils.LogTime;
import rxhttp.wrapper.utils.LogUtil;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lrxhttp/wrapper/intercept/LogInterceptor;", "Lokhttp3/Interceptor;", "Lokhttp3/OkHttpClient;", "okClient", "<init>", "(Lokhttp3/OkHttpClient;)V", "Lokhttp3/Interceptor$Chain;", "chain", "Lokhttp3/Response;", "intercept", "(Lokhttp3/Interceptor$Chain;)Lokhttp3/Response;", "a", "Lokhttp3/OkHttpClient;", "rxhttp"}, k = 1, mv = {1, 9, 0})
public final class LogInterceptor implements Interceptor {

    /* renamed from: a  reason: collision with root package name */
    public final OkHttpClient f3560a;

    public LogInterceptor(OkHttpClient okHttpClient) {
        Intrinsics.checkNotNullParameter(okHttpClient, "okClient");
        this.f3560a = okHttpClient;
    }

    public Response intercept(Interceptor.Chain chain) {
        Intrinsics.checkNotNullParameter(chain, "chain");
        Request request = chain.request();
        LogUtil.l(request, OkHttpCompat.c(this.f3560a));
        LogTime logTime = new LogTime();
        Response proceed = chain.proceed(request);
        LogUtil.m(proceed, logTime);
        return proceed;
    }
}
