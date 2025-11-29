package androidx.webkit.internal;

import android.webkit.ServiceWorkerWebSettings;
import androidx.webkit.ServiceWorkerWebSettingsCompat;
import java.lang.reflect.InvocationHandler;
import org.chromium.support_lib_boundary.ServiceWorkerWebSettingsBoundaryInterface;
import org.chromium.support_lib_boundary.util.BoundaryInterfaceReflectionUtil;

public class ServiceWorkerWebSettingsImpl extends ServiceWorkerWebSettingsCompat {

    /* renamed from: a  reason: collision with root package name */
    public ServiceWorkerWebSettings f1974a;
    public ServiceWorkerWebSettingsBoundaryInterface b;

    public ServiceWorkerWebSettingsImpl(ServiceWorkerWebSettings serviceWorkerWebSettings) {
        this.f1974a = serviceWorkerWebSettings;
    }

    public ServiceWorkerWebSettingsImpl(InvocationHandler invocationHandler) {
        this.b = (ServiceWorkerWebSettingsBoundaryInterface) BoundaryInterfaceReflectionUtil.a(ServiceWorkerWebSettingsBoundaryInterface.class, invocationHandler);
    }
}
