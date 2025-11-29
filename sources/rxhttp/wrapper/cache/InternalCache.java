package rxhttp.wrapper.cache;

import okhttp3.Request;
import okhttp3.Response;

public interface InternalCache {
    Response a(Response response, String str);

    Response b(Request request, String str);
}
