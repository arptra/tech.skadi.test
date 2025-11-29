package rxhttp.wrapper.param;

import okhttp3.RequestBody;
import rxhttp.wrapper.callback.ProgressCallback;
import rxhttp.wrapper.callback.ProgressCallbackHelper;
import rxhttp.wrapper.param.AbstractBodyParam;
import rxhttp.wrapper.progress.ProgressRequestBody;

public abstract class AbstractBodyParam<P extends AbstractBodyParam<P>> extends AbstractParam<P> {
    public ProgressCallbackHelper j;

    public final RequestBody g() {
        RequestBody c = c();
        return this.j != null ? new ProgressRequestBody(c, this.j) : c;
    }

    public final AbstractBodyParam u(int i, ProgressCallback progressCallback) {
        this.j = new ProgressCallbackHelper(i, progressCallback);
        return (AbstractBodyParam) s();
    }
}
