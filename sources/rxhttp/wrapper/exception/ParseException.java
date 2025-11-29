package rxhttp.wrapper.exception;

import java.io.IOException;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ParseException extends IOException {
    private final String errorCode;
    private final HttpUrl httpUrl;
    private final String requestMethod;
    private final Headers responseHeaders;

    public ParseException(@NotNull String str, String str2, Response response) {
        super(str2);
        this.errorCode = str;
        Request request = response.request();
        this.requestMethod = request.method();
        this.httpUrl = request.url();
        this.responseHeaders = response.headers();
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public HttpUrl getHttpUrl() {
        return this.httpUrl;
    }

    @Nullable
    public String getLocalizedMessage() {
        return this.errorCode;
    }

    public String getRequestMethod() {
        return this.requestMethod;
    }

    public String getRequestUrl() {
        return this.httpUrl.toString();
    }

    public Headers getResponseHeaders() {
        return this.responseHeaders;
    }

    public String toString() {
        String str = getClass().getName() + ": code is " + this.errorCode;
        String message = getMessage();
        if (message == null || message.trim().isEmpty()) {
            return str;
        }
        return str + ", " + message;
    }
}
