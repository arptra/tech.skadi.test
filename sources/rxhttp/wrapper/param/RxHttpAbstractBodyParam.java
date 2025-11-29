package rxhttp.wrapper.param;

import kotlin.Metadata;
import rxhttp.wrapper.BodyParamFactory;
import rxhttp.wrapper.param.AbstractBodyParam;
import rxhttp.wrapper.param.RxHttpAbstractBodyParam;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u0000*\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u00028\u00000\u0001*\u0014\b\u0001\u0010\u0003*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00042\u00020\u0005¨\u0006\u0006"}, d2 = {"Lrxhttp/wrapper/param/RxHttpAbstractBodyParam;", "Lrxhttp/wrapper/param/AbstractBodyParam;", "P", "R", "Lrxhttp/wrapper/param/RxHttp;", "Lrxhttp/wrapper/BodyParamFactory;", "lib_download_manager_release"}, k = 1, mv = {1, 9, 0})
public class RxHttpAbstractBodyParam<P extends AbstractBodyParam<P>, R extends RxHttpAbstractBodyParam<P, R>> extends RxHttp<P, R> implements BodyParamFactory {
    public /* bridge */ /* synthetic */ AbstractBodyParam c() {
        return (AbstractBodyParam) j();
    }
}
