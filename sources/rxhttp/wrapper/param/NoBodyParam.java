package rxhttp.wrapper.param;

import okhttp3.RequestBody;
import org.eclipse.jetty.util.URIUtil;

public class NoBodyParam extends AbstractParam<NoBodyParam> {
    public NoBodyParam(String str, Method method) {
        super(str, method);
    }

    public final RequestBody c() {
        return null;
    }

    public String toString() {
        String q = q();
        return q.startsWith(URIUtil.HTTP) ? r() : q;
    }
}
