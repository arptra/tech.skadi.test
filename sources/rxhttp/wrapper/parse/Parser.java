package rxhttp.wrapper.parse;

import okhttp3.Response;

public interface Parser<T> {
    Object a(Response response);
}
