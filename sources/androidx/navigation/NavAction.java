package androidx.navigation;

import android.os.Bundle;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u00002\u00020\u0001B+\b\u0007\u0012\b\b\u0001\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR$\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0013\u001a\u0004\b\n\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Landroidx/navigation/NavAction;", "", "", "destinationId", "Landroidx/navigation/NavOptions;", "navOptions", "Landroid/os/Bundle;", "defaultArguments", "<init>", "(ILandroidx/navigation/NavOptions;Landroid/os/Bundle;)V", "a", "I", "b", "()I", "Landroidx/navigation/NavOptions;", "c", "()Landroidx/navigation/NavOptions;", "e", "(Landroidx/navigation/NavOptions;)V", "Landroid/os/Bundle;", "()Landroid/os/Bundle;", "d", "(Landroid/os/Bundle;)V", "navigation-common_release"}, k = 1, mv = {1, 6, 0})
public final class NavAction {

    /* renamed from: a  reason: collision with root package name */
    public final int f1467a;
    public NavOptions b;
    public Bundle c;

    public NavAction(int i, NavOptions navOptions, Bundle bundle) {
        this.f1467a = i;
        this.b = navOptions;
        this.c = bundle;
    }

    public final Bundle a() {
        return this.c;
    }

    public final int b() {
        return this.f1467a;
    }

    public final NavOptions c() {
        return this.b;
    }

    public final void d(Bundle bundle) {
        this.c = bundle;
    }

    public final void e(NavOptions navOptions) {
        this.b = navOptions;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ NavAction(int i, NavOptions navOptions, Bundle bundle, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i2 & 2) != 0 ? null : navOptions, (i2 & 4) != 0 ? null : bundle);
    }
}
