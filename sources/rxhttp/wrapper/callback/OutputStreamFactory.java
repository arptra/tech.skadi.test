package rxhttp.wrapper.callback;

import kotlin.Metadata;
import okhttp3.Response;
import rxhttp.wrapper.entity.ExpandOutputStream;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\n2\u0006\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lrxhttp/wrapper/callback/OutputStreamFactory;", "T", "", "<init>", "()V", "", "a", "()J", "Lokhttp3/Response;", "response", "Lrxhttp/wrapper/entity/ExpandOutputStream;", "b", "(Lokhttp3/Response;)Lrxhttp/wrapper/entity/ExpandOutputStream;", "rxhttp"}, k = 1, mv = {1, 9, 0})
public abstract class OutputStreamFactory<T> {
    public long a() {
        return 0;
    }

    public abstract ExpandOutputStream b(Response response);
}
