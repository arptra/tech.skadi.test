package androidx.webkit.internal;

import android.webkit.SafeBrowsingResponse;
import android.webkit.WebMessagePort;
import android.webkit.WebResourceError;
import android.webkit.WebSettings;
import java.lang.reflect.InvocationHandler;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;
import org.chromium.support_lib_boundary.WebkitToCompatConverterBoundaryInterface;
import org.chromium.support_lib_boundary.util.BoundaryInterfaceReflectionUtil;

public class WebkitToCompatConverter {

    /* renamed from: a  reason: collision with root package name */
    public final WebkitToCompatConverterBoundaryInterface f1995a;

    public WebkitToCompatConverter(WebkitToCompatConverterBoundaryInterface webkitToCompatConverterBoundaryInterface) {
        this.f1995a = webkitToCompatConverterBoundaryInterface;
    }

    public SafeBrowsingResponse a(InvocationHandler invocationHandler) {
        return (SafeBrowsingResponse) this.f1995a.convertSafeBrowsingResponse(invocationHandler);
    }

    public InvocationHandler b(SafeBrowsingResponse safeBrowsingResponse) {
        return this.f1995a.convertSafeBrowsingResponse((Object) safeBrowsingResponse);
    }

    public WebSettingsAdapter c(WebSettings webSettings) {
        return new WebSettingsAdapter((WebSettingsBoundaryInterface) BoundaryInterfaceReflectionUtil.a(WebSettingsBoundaryInterface.class, this.f1995a.convertSettings(webSettings)));
    }

    public WebMessagePort d(InvocationHandler invocationHandler) {
        return (WebMessagePort) this.f1995a.convertWebMessagePort(invocationHandler);
    }

    public InvocationHandler e(WebMessagePort webMessagePort) {
        return this.f1995a.convertWebMessagePort((Object) webMessagePort);
    }

    public WebResourceError f(InvocationHandler invocationHandler) {
        return (WebResourceError) this.f1995a.convertWebResourceError(invocationHandler);
    }

    public InvocationHandler g(WebResourceError webResourceError) {
        return this.f1995a.convertWebResourceError((Object) webResourceError);
    }
}
