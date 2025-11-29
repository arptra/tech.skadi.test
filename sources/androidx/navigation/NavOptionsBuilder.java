package androidx.navigation;

import androidx.navigation.NavOptions;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\u000e\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J2\u0010\u000b\u001a\u00020\b2\b\b\u0001\u0010\u0005\u001a\u00020\u00042\u0019\b\u0002\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\t¢\u0006\u0004\b\u000b\u0010\fJ&\u0010\u000f\u001a\u00020\b2\u0017\u0010\u000e\u001a\u0013\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\t¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0000¢\u0006\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0016\u001a\u00020\u00148\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0015R\"\u0010\u001d\u001a\u00020\u00178\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR*\u0010!\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u00178F@FX\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u0018\u001a\u0004\b\u001f\u0010\u001a\"\u0004\b \u0010\u001cR*\u0010(\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u00048\u0006@@X\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b#\u0010%\"\u0004\b&\u0010'R.\u0010/\u001a\u0004\u0018\u00010)2\b\u0010\"\u001a\u0004\u0018\u00010)8\u0006@BX\u000e¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b*\u0010,\"\u0004\b-\u0010.R\u0016\u00100\u001a\u00020\u00178\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010\u0018R\u0016\u00101\u001a\u00020\u00178\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\u0018¨\u00062"}, d2 = {"Landroidx/navigation/NavOptionsBuilder;", "", "<init>", "()V", "", "id", "Lkotlin/Function1;", "Landroidx/navigation/PopUpToBuilder;", "", "Lkotlin/ExtensionFunctionType;", "popUpToBuilder", "g", "(ILkotlin/jvm/functions/Function1;)V", "Landroidx/navigation/AnimBuilder;", "animBuilder", "a", "(Lkotlin/jvm/functions/Function1;)V", "Landroidx/navigation/NavOptions;", "b", "()Landroidx/navigation/NavOptions;", "Landroidx/navigation/NavOptions$Builder;", "Landroidx/navigation/NavOptions$Builder;", "builder", "", "Z", "c", "()Z", "h", "(Z)V", "launchSingleTop", "<set-?>", "f", "setRestoreState", "restoreState", "value", "d", "I", "()I", "i", "(I)V", "popUpToId", "", "e", "Ljava/lang/String;", "()Ljava/lang/String;", "j", "(Ljava/lang/String;)V", "popUpToRoute", "inclusive", "saveState", "navigation-common_release"}, k = 1, mv = {1, 6, 0})
@NavOptionsDsl
public final class NavOptionsBuilder {

    /* renamed from: a  reason: collision with root package name */
    public final NavOptions.Builder f1491a = new NavOptions.Builder();
    public boolean b;
    public boolean c;
    public int d = -1;
    public String e;
    public boolean f;
    public boolean g;

    public final void a(Function1 function1) {
        Intrinsics.checkNotNullParameter(function1, "animBuilder");
        AnimBuilder animBuilder = new AnimBuilder();
        function1.invoke(animBuilder);
        this.f1491a.b(animBuilder.a()).c(animBuilder.b()).e(animBuilder.c()).f(animBuilder.d());
    }

    public final NavOptions b() {
        NavOptions.Builder builder = this.f1491a;
        builder.d(c());
        builder.j(f());
        if (e() != null) {
            builder.h(e(), this.f, this.g);
        } else {
            builder.g(d(), this.f, this.g);
        }
        return builder.a();
    }

    public final boolean c() {
        return this.b;
    }

    public final int d() {
        return this.d;
    }

    public final String e() {
        return this.e;
    }

    public final boolean f() {
        return this.c;
    }

    public final void g(int i, Function1 function1) {
        Intrinsics.checkNotNullParameter(function1, "popUpToBuilder");
        i(i);
        j((String) null);
        PopUpToBuilder popUpToBuilder = new PopUpToBuilder();
        function1.invoke(popUpToBuilder);
        this.f = popUpToBuilder.a();
        this.g = popUpToBuilder.b();
    }

    public final void h(boolean z) {
        this.b = z;
    }

    public final void i(int i) {
        this.d = i;
        this.f = false;
    }

    public final void j(String str) {
        if (str == null) {
            return;
        }
        if (!StringsKt.isBlank(str)) {
            this.e = str;
            this.f = false;
            return;
        }
        throw new IllegalArgumentException("Cannot pop up to an empty route".toString());
    }
}
