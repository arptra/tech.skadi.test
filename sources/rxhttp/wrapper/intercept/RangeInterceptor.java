package rxhttp.wrapper.intercept;

import com.meizu.common.util.LunarCalendar;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import rxhttp.wrapper.callback.OutputStreamFactory;
import rxhttp.wrapper.entity.DownloadOffSize;

public class RangeInterceptor implements Interceptor {
    public Response intercept(Interceptor.Chain chain) {
        Request request = chain.request();
        OutputStreamFactory outputStreamFactory = (OutputStreamFactory) request.tag(OutputStreamFactory.class);
        if (outputStreamFactory != null) {
            long a2 = outputStreamFactory.a();
            if (a2 >= 0) {
                request = request.newBuilder().addHeader("Range", "bytes=" + a2 + LunarCalendar.DATE_SEPARATOR).tag(DownloadOffSize.class, new DownloadOffSize(a2)).build();
            }
        }
        return chain.proceed(request);
    }
}
