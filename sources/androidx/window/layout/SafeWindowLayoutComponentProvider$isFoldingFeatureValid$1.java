package androidx.window.layout;

import android.graphics.Rect;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class SafeWindowLayoutComponentProvider$isFoldingFeatureValid$1 extends Lambda implements Function0<Boolean> {
    final /* synthetic */ ClassLoader $classLoader;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SafeWindowLayoutComponentProvider$isFoldingFeatureValid$1(ClassLoader classLoader) {
        super(0);
        this.$classLoader = classLoader;
    }

    @NotNull
    public final Boolean invoke() {
        boolean z;
        SafeWindowLayoutComponentProvider safeWindowLayoutComponentProvider = SafeWindowLayoutComponentProvider.f2029a;
        Class d = safeWindowLayoutComponentProvider.l(this.$classLoader);
        Method method = d.getMethod("getBounds", (Class[]) null);
        Method method2 = d.getMethod("getType", (Class[]) null);
        Method method3 = d.getMethod("getState", (Class[]) null);
        Intrinsics.checkNotNullExpressionValue(method, "getBoundsMethod");
        if (safeWindowLayoutComponentProvider.k(method, Reflection.getOrCreateKotlinClass(Rect.class)) && safeWindowLayoutComponentProvider.o(method)) {
            Intrinsics.checkNotNullExpressionValue(method2, "getTypeMethod");
            Class cls = Integer.TYPE;
            if (safeWindowLayoutComponentProvider.k(method2, Reflection.getOrCreateKotlinClass(cls)) && safeWindowLayoutComponentProvider.o(method2)) {
                Intrinsics.checkNotNullExpressionValue(method3, "getStateMethod");
                if (safeWindowLayoutComponentProvider.k(method3, Reflection.getOrCreateKotlinClass(cls)) && safeWindowLayoutComponentProvider.o(method3)) {
                    z = true;
                    return Boolean.valueOf(z);
                }
            }
        }
        z = false;
        return Boolean.valueOf(z);
    }
}
