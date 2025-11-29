package rxhttp.wrapper.exception;

import java.io.IOException;
import okhttp3.Request;

public class ProxyException extends IOException {
    private final Throwable proxyCause;

    public ProxyException(Request request, Throwable th) {
        this(request.url().toString(), th);
    }

    public String toString() {
        return this.proxyCause.toString() + ", " + getMessage();
    }

    public ProxyException(String str, Throwable th) {
        super(str);
        this.proxyCause = th;
        setStackTrace(th.getStackTrace());
    }
}
