package rxhttp.wrapper.param;

import java.util.List;
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

public class JsonArrayParam extends AbstractBodyParam<JsonArrayParam> {
    public List k;

    public RequestBody c() {
        List list = this.k;
        return list == null ? RequestBody.create((MediaType) null, new byte[0]) : k(list);
    }

    public String j() {
        HttpUrl d = BuildUtil.d(q(), CacheUtil.b(o()), n());
        return d.newBuilder().addQueryParameter("json", GsonUtil.o(CacheUtil.b(this.k))).toString();
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
        return "JsonArrayParam{url = " + q + " bodyParam = " + this.k + '}';
    }
}
