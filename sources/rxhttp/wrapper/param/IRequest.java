package rxhttp.wrapper.param;

import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.RequestBody;

public interface IRequest {
    Headers a();

    RequestBody c();

    HttpUrl d();

    Request f();

    RequestBody g() {
        return c();
    }

    Method getMethod();
}
