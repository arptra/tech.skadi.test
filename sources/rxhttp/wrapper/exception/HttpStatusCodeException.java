package rxhttp.wrapper.exception;

import java.io.IOException;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public final class HttpStatusCodeException extends IOException {
    private final ResponseBody body;
    private final HttpUrl httpUrl;
    private final Protocol protocol;
    private final String requestMethod;
    private final Headers responseHeaders;
    private String result;
    private final int statusCode;

    public HttpStatusCodeException(Response response) {
        super(response.message());
        this.protocol = response.protocol();
        this.statusCode = response.code();
        Request request = response.request();
        this.requestMethod = request.method();
        this.httpUrl = request.url();
        this.responseHeaders = response.headers();
        this.body = response.body();
    }

    public HttpUrl getHttpUrl() {
        return this.httpUrl;
    }

    public String getLocalizedMessage() {
        return String.valueOf(this.statusCode);
    }

    public String getRequestMethod() {
        return this.requestMethod;
    }

    public String getRequestUrl() {
        return this.httpUrl.toString();
    }

    public ResponseBody getResponseBody() {
        return this.body;
    }

    public Headers getResponseHeaders() {
        return this.responseHeaders;
    }

    public String getResult() throws IOException {
        if (this.result == null) {
            this.result = this.body.string();
        }
        return this.result;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public String toString() {
        return HttpStatusCodeException.class.getName() + ": " + this.protocol + " " + this.statusCode + " " + getMessage();
    }
}
