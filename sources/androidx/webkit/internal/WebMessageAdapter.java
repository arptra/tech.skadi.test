package androidx.webkit.internal;

import androidx.webkit.WebMessageCompat;
import androidx.webkit.WebMessagePortCompat;
import java.lang.reflect.InvocationHandler;
import java.util.Objects;
import org.chromium.support_lib_boundary.WebMessageBoundaryInterface;
import org.chromium.support_lib_boundary.WebMessagePayloadBoundaryInterface;
import org.chromium.support_lib_boundary.util.BoundaryInterfaceReflectionUtil;

public class WebMessageAdapter implements WebMessageBoundaryInterface {
    public static final String[] b = {"WEB_MESSAGE_ARRAY_BUFFER"};

    /* renamed from: a  reason: collision with root package name */
    public WebMessageCompat f1978a;

    public static WebMessagePortCompat[] a(InvocationHandler[] invocationHandlerArr) {
        WebMessagePortCompat[] webMessagePortCompatArr = new WebMessagePortCompat[invocationHandlerArr.length];
        for (int i = 0; i < invocationHandlerArr.length; i++) {
            webMessagePortCompatArr[i] = new WebMessagePortImpl(invocationHandlerArr[i]);
        }
        return webMessagePortCompatArr;
    }

    public static WebMessageCompat b(WebMessageBoundaryInterface webMessageBoundaryInterface) {
        WebMessagePortCompat[] a2 = a(webMessageBoundaryInterface.getPorts());
        if (!WebViewFeatureInternal.C.c()) {
            return new WebMessageCompat(webMessageBoundaryInterface.getData(), a2);
        }
        WebMessagePayloadBoundaryInterface webMessagePayloadBoundaryInterface = (WebMessagePayloadBoundaryInterface) BoundaryInterfaceReflectionUtil.a(WebMessagePayloadBoundaryInterface.class, webMessageBoundaryInterface.getMessagePayload());
        int type = webMessagePayloadBoundaryInterface.getType();
        if (type == 0) {
            return new WebMessageCompat(webMessagePayloadBoundaryInterface.getAsString(), a2);
        }
        if (type != 1) {
            return null;
        }
        return new WebMessageCompat(webMessagePayloadBoundaryInterface.getAsArrayBuffer(), a2);
    }

    public String getData() {
        return this.f1978a.c();
    }

    public InvocationHandler getMessagePayload() {
        WebMessagePayloadAdapter webMessagePayloadAdapter;
        int e = this.f1978a.e();
        if (e == 0) {
            webMessagePayloadAdapter = new WebMessagePayloadAdapter(this.f1978a.c());
        } else if (e == 1) {
            byte[] b2 = this.f1978a.b();
            Objects.requireNonNull(b2);
            webMessagePayloadAdapter = new WebMessagePayloadAdapter(b2);
        } else {
            throw new IllegalStateException("Unknown web message payload type: " + this.f1978a.e());
        }
        return BoundaryInterfaceReflectionUtil.c(webMessagePayloadAdapter);
    }

    public InvocationHandler[] getPorts() {
        WebMessagePortCompat[] d = this.f1978a.d();
        if (d == null) {
            return null;
        }
        InvocationHandler[] invocationHandlerArr = new InvocationHandler[d.length];
        for (int i = 0; i < d.length; i++) {
            invocationHandlerArr[i] = d[i].b();
        }
        return invocationHandlerArr;
    }

    public String[] getSupportedFeatures() {
        return b;
    }
}
