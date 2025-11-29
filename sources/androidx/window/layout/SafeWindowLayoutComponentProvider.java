package androidx.window.layout;

import androidx.window.extensions.layout.WindowLayoutComponent;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.KClass;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\bJ\u0017\u0010\n\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\n\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000b\u0010\bJ\u0017\u0010\f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0003¢\u0006\u0004\b\f\u0010\bJ\u001d\u0010\u000f\u001a\u00020\u00062\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0014\u001a\u00020\u0006*\u00020\u00112\n\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\u0012H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0017\u001a\u00020\u0006*\u00020\u00112\n\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\u0016H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J'\u0010\u001a\u001a\u0012\u0012\u0002\b\u0003 \u0019*\b\u0012\u0002\b\u0003\u0018\u00010\u00160\u00162\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ'\u0010\u001c\u001a\u0012\u0012\u0002\b\u0003 \u0019*\b\u0012\u0002\b\u0003\u0018\u00010\u00160\u00162\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001c\u0010\u001bJ'\u0010\u001d\u001a\u0012\u0012\u0002\b\u0003 \u0019*\b\u0012\u0002\b\u0003\u0018\u00010\u00160\u00162\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001d\u0010\u001bJ'\u0010\u001e\u001a\u0012\u0012\u0002\b\u0003 \u0019*\b\u0012\u0002\b\u0003\u0018\u00010\u00160\u00162\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001e\u0010\u001bR\u001d\u0010$\u001a\u0004\u0018\u00010\u001f8FX\u0002¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u0018\u0010'\u001a\u00020\u0006*\u00020\u00118BX\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&¨\u0006("}, d2 = {"Landroidx/window/layout/SafeWindowLayoutComponentProvider;", "", "<init>", "()V", "Ljava/lang/ClassLoader;", "classLoader", "", "i", "(Ljava/lang/ClassLoader;)Z", "r", "p", "n", "q", "Lkotlin/Function0;", "block", "s", "(Lkotlin/jvm/functions/Function0;)Z", "Ljava/lang/reflect/Method;", "Lkotlin/reflect/KClass;", "clazz", "k", "(Ljava/lang/reflect/Method;Lkotlin/reflect/KClass;)Z", "Ljava/lang/Class;", "j", "(Ljava/lang/reflect/Method;Ljava/lang/Class;)Z", "kotlin.jvm.PlatformType", "u", "(Ljava/lang/ClassLoader;)Ljava/lang/Class;", "t", "l", "v", "Landroidx/window/extensions/layout/WindowLayoutComponent;", "b", "Lkotlin/Lazy;", "m", "()Landroidx/window/extensions/layout/WindowLayoutComponent;", "windowLayoutComponent", "o", "(Ljava/lang/reflect/Method;)Z", "isPublic", "window_release"}, k = 1, mv = {1, 6, 0})
public final class SafeWindowLayoutComponentProvider {

    /* renamed from: a  reason: collision with root package name */
    public static final SafeWindowLayoutComponentProvider f2029a = new SafeWindowLayoutComponentProvider();
    public static final Lazy b = LazyKt.lazy(SafeWindowLayoutComponentProvider$windowLayoutComponent$2.INSTANCE);

    public final boolean i(ClassLoader classLoader) {
        return r(classLoader) && p(classLoader) && q(classLoader) && n(classLoader);
    }

    public final boolean j(Method method, Class cls) {
        return method.getReturnType().equals(cls);
    }

    public final boolean k(Method method, KClass kClass) {
        return j(method, JvmClassMappingKt.getJavaClass(kClass));
    }

    public final Class l(ClassLoader classLoader) {
        return classLoader.loadClass("androidx.window.extensions.layout.FoldingFeature");
    }

    public final WindowLayoutComponent m() {
        return (WindowLayoutComponent) b.getValue();
    }

    public final boolean n(ClassLoader classLoader) {
        return s(new SafeWindowLayoutComponentProvider$isFoldingFeatureValid$1(classLoader));
    }

    public final boolean o(Method method) {
        return Modifier.isPublic(method.getModifiers());
    }

    public final boolean p(ClassLoader classLoader) {
        return s(new SafeWindowLayoutComponentProvider$isWindowExtensionsValid$1(classLoader));
    }

    public final boolean q(ClassLoader classLoader) {
        return s(new SafeWindowLayoutComponentProvider$isWindowLayoutComponentValid$1(classLoader));
    }

    public final boolean r(ClassLoader classLoader) {
        return s(new SafeWindowLayoutComponentProvider$isWindowLayoutProviderValid$1(classLoader));
    }

    public final boolean s(Function0 function0) {
        try {
            return ((Boolean) function0.invoke()).booleanValue();
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            return false;
        }
    }

    public final Class t(ClassLoader classLoader) {
        return classLoader.loadClass("androidx.window.extensions.WindowExtensions");
    }

    public final Class u(ClassLoader classLoader) {
        return classLoader.loadClass("androidx.window.extensions.WindowExtensionsProvider");
    }

    public final Class v(ClassLoader classLoader) {
        return classLoader.loadClass("androidx.window.extensions.layout.WindowLayoutComponent");
    }
}
