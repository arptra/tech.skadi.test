package rxhttp.wrapper.param;

import rxhttp.wrapper.param.Param;

public abstract class Param<P extends Param<P>> implements IParam<P>, IHeaders<P>, ICache<P>, IRequest {

    /* renamed from: a  reason: collision with root package name */
    public static String f3561a = "data-decrypt";

    public static NoBodyParam i(String str) {
        return new NoBodyParam(str, Method.GET);
    }
}
