package androidx.webkit.internal;

import android.webkit.SafeBrowsingResponse;
import androidx.webkit.SafeBrowsingResponseCompat;
import androidx.webkit.internal.ApiFeature;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import org.chromium.support_lib_boundary.SafeBrowsingResponseBoundaryInterface;
import org.chromium.support_lib_boundary.util.BoundaryInterfaceReflectionUtil;

public class SafeBrowsingResponseImpl extends SafeBrowsingResponseCompat {

    /* renamed from: a  reason: collision with root package name */
    public SafeBrowsingResponse f1971a;
    public SafeBrowsingResponseBoundaryInterface b;

    public SafeBrowsingResponseImpl(InvocationHandler invocationHandler) {
        this.b = (SafeBrowsingResponseBoundaryInterface) BoundaryInterfaceReflectionUtil.a(SafeBrowsingResponseBoundaryInterface.class, invocationHandler);
    }

    public void a(boolean z) {
        ApiFeature.O_MR1 o_mr1 = WebViewFeatureInternal.z;
        if (o_mr1.b()) {
            ApiHelperForOMR1.e(c(), z);
        } else if (o_mr1.c()) {
            b().showInterstitial(z);
        } else {
            throw WebViewFeatureInternal.a();
        }
    }

    public final SafeBrowsingResponseBoundaryInterface b() {
        if (this.b == null) {
            this.b = (SafeBrowsingResponseBoundaryInterface) BoundaryInterfaceReflectionUtil.a(SafeBrowsingResponseBoundaryInterface.class, WebViewGlueCommunicator.c().b(this.f1971a));
        }
        return this.b;
    }

    public final SafeBrowsingResponse c() {
        if (this.f1971a == null) {
            this.f1971a = WebViewGlueCommunicator.c().a(Proxy.getInvocationHandler(this.b));
        }
        return this.f1971a;
    }

    public SafeBrowsingResponseImpl(SafeBrowsingResponse safeBrowsingResponse) {
        this.f1971a = safeBrowsingResponse;
    }
}
