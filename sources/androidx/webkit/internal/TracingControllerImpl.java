package androidx.webkit.internal;

import androidx.webkit.TracingController;
import androidx.webkit.internal.ApiFeature;
import org.chromium.support_lib_boundary.TracingControllerBoundaryInterface;

public class TracingControllerImpl extends TracingController {

    /* renamed from: a  reason: collision with root package name */
    public android.webkit.TracingController f1976a;
    public TracingControllerBoundaryInterface b;

    public TracingControllerImpl() {
        ApiFeature.P p = WebViewFeatureInternal.L;
        if (p.b()) {
            this.f1976a = ApiHelperForP.a();
            this.b = null;
        } else if (p.c()) {
            this.f1976a = null;
            this.b = WebViewGlueCommunicator.d().getTracingController();
        } else {
            throw WebViewFeatureInternal.a();
        }
    }
}
