package androidx.webkit.internal;

import android.webkit.WebMessage;
import android.webkit.WebMessagePort;
import androidx.webkit.WebMessageCompat;
import androidx.webkit.WebMessagePortCompat;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import org.chromium.support_lib_boundary.WebMessagePortBoundaryInterface;
import org.chromium.support_lib_boundary.util.BoundaryInterfaceReflectionUtil;

public class WebMessagePortImpl extends WebMessagePortCompat {

    /* renamed from: a  reason: collision with root package name */
    public WebMessagePort f1982a;
    public WebMessagePortBoundaryInterface b;

    public WebMessagePortImpl(WebMessagePort webMessagePort) {
        this.f1982a = webMessagePort;
    }

    public static WebMessagePort[] c(WebMessagePortCompat[] webMessagePortCompatArr) {
        if (webMessagePortCompatArr == null) {
            return null;
        }
        int length = webMessagePortCompatArr.length;
        WebMessagePort[] webMessagePortArr = new WebMessagePort[length];
        for (int i = 0; i < length; i++) {
            webMessagePortArr[i] = webMessagePortCompatArr[i].a();
        }
        return webMessagePortArr;
    }

    public static WebMessageCompat d(WebMessage webMessage) {
        return ApiHelperForM.d(webMessage);
    }

    public static WebMessagePortCompat[] g(WebMessagePort[] webMessagePortArr) {
        if (webMessagePortArr == null) {
            return null;
        }
        WebMessagePortCompat[] webMessagePortCompatArr = new WebMessagePortCompat[webMessagePortArr.length];
        for (int i = 0; i < webMessagePortArr.length; i++) {
            webMessagePortCompatArr[i] = new WebMessagePortImpl(webMessagePortArr[i]);
        }
        return webMessagePortCompatArr;
    }

    public WebMessagePort a() {
        return f();
    }

    public InvocationHandler b() {
        return Proxy.getInvocationHandler(e());
    }

    public final WebMessagePortBoundaryInterface e() {
        if (this.b == null) {
            this.b = (WebMessagePortBoundaryInterface) BoundaryInterfaceReflectionUtil.a(WebMessagePortBoundaryInterface.class, WebViewGlueCommunicator.c().e(this.f1982a));
        }
        return this.b;
    }

    public final WebMessagePort f() {
        if (this.f1982a == null) {
            this.f1982a = WebViewGlueCommunicator.c().d(Proxy.getInvocationHandler(this.b));
        }
        return this.f1982a;
    }

    public WebMessagePortImpl(InvocationHandler invocationHandler) {
        this.b = (WebMessagePortBoundaryInterface) BoundaryInterfaceReflectionUtil.a(WebMessagePortBoundaryInterface.class, invocationHandler);
    }
}
