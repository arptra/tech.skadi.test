package rxhttp.wrapper.param;

import kotlin.Metadata;
import okhttp3.RequestBody;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lrxhttp/wrapper/param/BodyParam;", "Lrxhttp/wrapper/param/AbstractBodyParam;", "Lokhttp3/RequestBody;", "c", "()Lokhttp3/RequestBody;", "", "k", "Ljava/lang/Object;", "body", "l", "Lokhttp3/RequestBody;", "requestBody", "rxhttp"}, k = 1, mv = {1, 9, 0})
public final class BodyParam extends AbstractBodyParam<BodyParam> {
    public Object k;
    public RequestBody l;

    public RequestBody c() {
        Object obj = this.k;
        if (obj != null) {
            this.l = k(obj);
        }
        RequestBody requestBody = this.l;
        if (requestBody != null) {
            return requestBody;
        }
        throw new NullPointerException("requestBody cannot be null, please call the setBody series methods");
    }
}
