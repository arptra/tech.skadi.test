package rxhttp.wrapper.param;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lrxhttp/wrapper/param/RxHttpNoBodyParam;", "Lrxhttp/wrapper/param/RxHttp;", "Lrxhttp/wrapper/param/NoBodyParam;", "param", "<init>", "(Lrxhttp/wrapper/param/NoBodyParam;)V", "lib_download_manager_release"}, k = 1, mv = {1, 9, 0})
public class RxHttpNoBodyParam extends RxHttp<NoBodyParam, RxHttpNoBodyParam> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RxHttpNoBodyParam(NoBodyParam noBodyParam) {
        super(noBodyParam);
        Intrinsics.checkNotNullParameter(noBodyParam, "param");
    }
}
