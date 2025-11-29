package androidx.webkit.internal;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import org.chromium.support_lib_boundary.WebViewProviderFactoryBoundaryInterface;
import org.chromium.support_lib_boundary.util.BoundaryInterfaceReflectionUtil;

public class WebViewGlueCommunicator {

    public static class LAZY_COMPAT_CONVERTER_HOLDER {

        /* renamed from: a  reason: collision with root package name */
        public static final WebkitToCompatConverter f1986a = new WebkitToCompatConverter(WebViewGlueCommunicator.d().getWebkitToCompatConverter());
    }

    public static class LAZY_FACTORY_HOLDER {

        /* renamed from: a  reason: collision with root package name */
        public static final WebViewProviderFactory f1987a = WebViewGlueCommunicator.a();
    }

    public static WebViewProviderFactory a() {
        try {
            return new WebViewProviderFactoryAdapter((WebViewProviderFactoryBoundaryInterface) BoundaryInterfaceReflectionUtil.a(WebViewProviderFactoryBoundaryInterface.class, b()));
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e2) {
            throw new RuntimeException(e2);
        } catch (ClassNotFoundException unused) {
            return new IncompatibleApkWebViewProviderFactory();
        } catch (NoSuchMethodException e3) {
            throw new RuntimeException(e3);
        }
    }

    public static InvocationHandler b() {
        return (InvocationHandler) Class.forName("org.chromium.support_lib_glue.SupportLibReflectionUtil", false, e()).getDeclaredMethod("createWebViewProviderFactory", (Class[]) null).invoke((Object) null, (Object[]) null);
    }

    public static WebkitToCompatConverter c() {
        return LAZY_COMPAT_CONVERTER_HOLDER.f1986a;
    }

    public static WebViewProviderFactory d() {
        return LAZY_FACTORY_HOLDER.f1987a;
    }

    public static ClassLoader e() {
        return ApiHelperForP.b();
    }
}
