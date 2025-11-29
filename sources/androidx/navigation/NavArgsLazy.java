package androidx.navigation;

import android.os.Bundle;
import androidx.navigation.NavArgs;
import java.lang.reflect.Method;
import java.util.Arrays;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u00078\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0018\u0010\u0012\u001a\u0004\u0018\u00018\u00008\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0014\u001a\u00028\u00008VX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0013¨\u0006\u0015"}, d2 = {"Landroidx/navigation/NavArgsLazy;", "Landroidx/navigation/NavArgs;", "Args", "Lkotlin/Lazy;", "", "isInitialized", "()Z", "Lkotlin/reflect/KClass;", "a", "Lkotlin/reflect/KClass;", "navArgsClass", "Lkotlin/Function0;", "Landroid/os/Bundle;", "b", "Lkotlin/jvm/functions/Function0;", "argumentProducer", "c", "Landroidx/navigation/NavArgs;", "cached", "()Landroidx/navigation/NavArgs;", "value", "navigation-common_release"}, k = 1, mv = {1, 6, 0})
public final class NavArgsLazy<Args extends NavArgs> implements Lazy<Args> {

    /* renamed from: a  reason: collision with root package name */
    public final KClass f1468a;
    public final Function0 b;
    public NavArgs c;

    /* renamed from: a */
    public NavArgs getValue() {
        NavArgs navArgs = this.c;
        if (navArgs != null) {
            return navArgs;
        }
        Bundle bundle = (Bundle) this.b.invoke();
        Method method = (Method) NavArgsLazyKt.a().get(this.f1468a);
        if (method == null) {
            Class javaClass = JvmClassMappingKt.getJavaClass(this.f1468a);
            Class[] b2 = NavArgsLazyKt.b();
            method = javaClass.getMethod("fromBundle", (Class[]) Arrays.copyOf(b2, b2.length));
            NavArgsLazyKt.a().put(this.f1468a, method);
            Intrinsics.checkNotNullExpressionValue(method, "navArgsClass.java.getMet…hod\n                    }");
        }
        Object invoke = method.invoke((Object) null, new Object[]{bundle});
        if (invoke != null) {
            NavArgs navArgs2 = (NavArgs) invoke;
            this.c = navArgs2;
            return navArgs2;
        }
        throw new NullPointerException("null cannot be cast to non-null type Args of androidx.navigation.NavArgsLazy");
    }

    public boolean isInitialized() {
        return this.c != null;
    }
}
