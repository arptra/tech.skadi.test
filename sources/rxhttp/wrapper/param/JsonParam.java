package rxhttp.wrapper.param;

import java.util.Map;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import org.eclipse.jetty.util.URIUtil;
import rxhttp.RxHttpPlugins;
import rxhttp.wrapper.callback.IConverter;
import rxhttp.wrapper.callback.JsonConverter;
import rxhttp.wrapper.utils.BuildUtil;
import rxhttp.wrapper.utils.CacheUtil;
import rxhttp.wrapper.utils.GsonUtil;

public class JsonParam extends AbstractBodyParam<JsonParam> {
    public Map k;

    public RequestBody c() {
        Map map = this.k;
        return map == null ? RequestBody.create((MediaType) null, new byte[0]) : k(map);
    }

    public String j() {
        HttpUrl d = BuildUtil.d(q(), CacheUtil.b(o()), n());
        return d.newBuilder().addQueryParameter("json", GsonUtil.o(CacheUtil.c(this.k))).toString();
    }

    public IConverter m() {
        IConverter m = super.m();
        return !(m instanceof JsonConverter) ? RxHttpPlugins.c() : m;
    }

    public String toString() {
        String q = q();
        if (q.startsWith(URIUtil.HTTP)) {
            q = r();
        }
        return "JsonParam{url = " + q + " bodyParam = " + this.k + '}';
    }
}
