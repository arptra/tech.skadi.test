package androidx.webkit.internal;

import android.webkit.ServiceWorkerClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import androidx.annotation.RequiresApi;
import androidx.webkit.ServiceWorkerClientCompat;

@RequiresApi
public class FrameworkServiceWorkerClient extends ServiceWorkerClient {

    /* renamed from: a  reason: collision with root package name */
    public final ServiceWorkerClientCompat f1967a;

    public FrameworkServiceWorkerClient(ServiceWorkerClientCompat serviceWorkerClientCompat) {
        this.f1967a = serviceWorkerClientCompat;
    }

    public WebResourceResponse shouldInterceptRequest(WebResourceRequest webResourceRequest) {
        return this.f1967a.a(webResourceRequest);
    }
}
