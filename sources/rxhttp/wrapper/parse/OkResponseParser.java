package rxhttp.wrapper.parse;

import okhttp3.Response;
import okhttp3.ResponseBody;
import rxhttp.wrapper.OkHttpCompat;
import rxhttp.wrapper.entity.EmptyResponseBody;
import rxhttp.wrapper.entity.OkResponse;

public class OkResponseParser<T> implements Parser<OkResponse<T>> {

    /* renamed from: a  reason: collision with root package name */
    public final Parser f3563a;

    /* renamed from: b */
    public OkResponse a(Response response) {
        ResponseBody body = response.body();
        Response build = response.newBuilder().body(new EmptyResponseBody(body.contentType(), body.contentLength())).build();
        if (!build.isSuccessful()) {
            try {
                return OkResponse.a(OkHttpCompat.a(body), build);
            } finally {
                body.close();
            }
        } else {
            int code = build.code();
            if (code != 204 && code != 205) {
                return OkResponse.b(this.f3563a.a(response), build);
            }
            body.close();
            return OkResponse.b((Object) null, build);
        }
    }
}
