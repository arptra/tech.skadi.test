package rxhttp.wrapper.cookie;

import java.util.List;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;

public interface ICookieJar extends CookieJar {
    List a(HttpUrl httpUrl);

    void b(HttpUrl httpUrl, List list);

    List loadForRequest(HttpUrl httpUrl) {
        return a(httpUrl);
    }

    void saveFromResponse(HttpUrl httpUrl, List list) {
        b(httpUrl, list);
    }
}
