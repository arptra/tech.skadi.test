package rxhttp.wrapper.param;

import java.util.ArrayList;
import java.util.List;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import org.eclipse.jetty.util.URIUtil;
import rxhttp.wrapper.utils.BuildUtil;
import rxhttp.wrapper.utils.CacheUtil;

public class FormParam extends AbstractBodyParam<FormParam> implements IPart<FormParam> {
    public MediaType k;
    public List l;
    public List m;

    public RequestBody c() {
        return v() ? BuildUtil.b(this.k, this.m, this.l) : BuildUtil.a(this.m);
    }

    public String j() {
        ArrayList arrayList = new ArrayList();
        List o = o();
        List list = this.m;
        if (o != null) {
            arrayList.addAll(o);
        }
        if (list != null) {
            arrayList.addAll(list);
        }
        return BuildUtil.d(q(), CacheUtil.b(arrayList), n()).toString();
    }

    public String toString() {
        String q = q();
        if (q.startsWith(URIUtil.HTTP)) {
            q = r();
        }
        return "FormParam{url = " + q + " bodyParam = " + this.m + '}';
    }

    public boolean v() {
        return this.k != null;
    }
}
