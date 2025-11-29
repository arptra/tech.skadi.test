package rxhttp.wrapper.entity;

import java.util.Objects;
import okhttp3.Response;
import okhttp3.ResponseBody;

public final class OkResponse<T> {

    /* renamed from: a  reason: collision with root package name */
    public final Response f3555a;
    public final Object b;
    public final ResponseBody c;

    public OkResponse(Response response, Object obj, ResponseBody responseBody) {
        this.f3555a = response;
        this.b = obj;
        this.c = responseBody;
    }

    public static OkResponse a(ResponseBody responseBody, Response response) {
        Objects.requireNonNull(responseBody, "body == null");
        Objects.requireNonNull(response, "rawResponse == null");
        if (!response.isSuccessful()) {
            return new OkResponse(response, (Object) null, responseBody);
        }
        throw new IllegalArgumentException("rawResponse should not be successful response");
    }

    public static OkResponse b(Object obj, Response response) {
        Objects.requireNonNull(response, "rawResponse == null");
        if (response.isSuccessful()) {
            return new OkResponse(response, obj, (ResponseBody) null);
        }
        throw new IllegalArgumentException("rawResponse must be successful response");
    }

    public String toString() {
        return this.f3555a.toString();
    }
}
