package androidx.webkit.internal;

import android.webkit.ServiceWorkerController;
import androidx.webkit.ServiceWorkerControllerCompat;
import androidx.webkit.ServiceWorkerWebSettingsCompat;
import androidx.webkit.internal.ApiFeature;
import org.chromium.support_lib_boundary.ServiceWorkerControllerBoundaryInterface;

public class ServiceWorkerControllerImpl extends ServiceWorkerControllerCompat {

    /* renamed from: a  reason: collision with root package name */
    public ServiceWorkerController f1973a;
    public ServiceWorkerControllerBoundaryInterface b;
    public final ServiceWorkerWebSettingsCompat c;

    public ServiceWorkerControllerImpl() {
        ApiFeature.N n = WebViewFeatureInternal.k;
        if (n.b()) {
            this.f1973a = ApiHelperForN.g();
            this.b = null;
            this.c = ApiHelperForN.i(a());
        } else if (n.c()) {
            this.f1973a = null;
            ServiceWorkerControllerBoundaryInterface serviceWorkerController = WebViewGlueCommunicator.d().getServiceWorkerController();
            this.b = serviceWorkerController;
            this.c = new ServiceWorkerWebSettingsImpl(serviceWorkerController.getServiceWorkerWebSettings());
        } else {
            throw WebViewFeatureInternal.a();
        }
    }

    public final ServiceWorkerController a() {
        if (this.f1973a == null) {
            this.f1973a = ApiHelperForN.g();
        }
        return this.f1973a;
    }
}
