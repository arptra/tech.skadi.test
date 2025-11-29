package androidx.webkit.internal;

import android.webkit.WebResourceError;
import androidx.webkit.WebResourceErrorCompat;
import androidx.webkit.internal.ApiFeature;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import org.chromium.support_lib_boundary.WebResourceErrorBoundaryInterface;
import org.chromium.support_lib_boundary.util.BoundaryInterfaceReflectionUtil;

public class WebResourceErrorImpl extends WebResourceErrorCompat {

    /* renamed from: a  reason: collision with root package name */
    public WebResourceError f1983a;
    public WebResourceErrorBoundaryInterface b;

    public WebResourceErrorImpl(InvocationHandler invocationHandler) {
        this.b = (WebResourceErrorBoundaryInterface) BoundaryInterfaceReflectionUtil.a(WebResourceErrorBoundaryInterface.class, invocationHandler);
    }

    public CharSequence a() {
        ApiFeature.M m = WebViewFeatureInternal.v;
        if (m.b()) {
            return ApiHelperForM.e(d());
        }
        if (m.c()) {
            return c().getDescription();
        }
        throw WebViewFeatureInternal.a();
    }

    public int b() {
        ApiFeature.M m = WebViewFeatureInternal.w;
        if (m.b()) {
            return ApiHelperForM.f(d());
        }
        if (m.c()) {
            return c().getErrorCode();
        }
        throw WebViewFeatureInternal.a();
    }

    public final WebResourceErrorBoundaryInterface c() {
        if (this.b == null) {
            this.b = (WebResourceErrorBoundaryInterface) BoundaryInterfaceReflectionUtil.a(WebResourceErrorBoundaryInterface.class, WebViewGlueCommunicator.c().g(this.f1983a));
        }
        return this.b;
    }

    public final WebResourceError d() {
        if (this.f1983a == null) {
            this.f1983a = WebViewGlueCommunicator.c().f(Proxy.getInvocationHandler(this.b));
        }
        return this.f1983a;
    }

    public WebResourceErrorImpl(WebResourceError webResourceError) {
        this.f1983a = webResourceError;
    }
}
