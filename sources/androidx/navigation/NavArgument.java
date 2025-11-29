package androidx.navigation;

import android.os.Bundle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u000f\u0018\u00002\u00020\u0001:\u0001$B3\b\u0000\u0012\u000e\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001\u0012\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0014\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018R\u001f\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0019\u0010\u001bR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0017\u0010 \u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001d\u001a\u0004\b\u001c\u0010\u001fR\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00018\u0006¢\u0006\f\n\u0004\b\u000f\u0010!\u001a\u0004\b\"\u0010#¨\u0006%"}, d2 = {"Landroidx/navigation/NavArgument;", "", "Landroidx/navigation/NavType;", "type", "", "isNullable", "defaultValue", "defaultValuePresent", "<init>", "(Landroidx/navigation/NavType;ZLjava/lang/Object;Z)V", "", "name", "Landroid/os/Bundle;", "bundle", "", "d", "(Ljava/lang/String;Landroid/os/Bundle;)V", "e", "(Ljava/lang/String;Landroid/os/Bundle;)Z", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "a", "Landroidx/navigation/NavType;", "()Landroidx/navigation/NavType;", "b", "Z", "c", "()Z", "isDefaultValuePresent", "Ljava/lang/Object;", "getDefaultValue", "()Ljava/lang/Object;", "Builder", "navigation-common_release"}, k = 1, mv = {1, 6, 0})
public final class NavArgument {

    /* renamed from: a  reason: collision with root package name */
    public final NavType f1470a;
    public final boolean b;
    public final boolean c;
    public final Object d;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\u0007\u001a\u00020\u0000\"\u0004\b\u0000\u0010\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u000b\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\u00002\b\u0010\r\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0011\u0010\u0012R \u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0013R\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u0014R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\u0015R\u0016\u0010\u0016\u001a\u00020\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\u0014¨\u0006\u0017"}, d2 = {"Landroidx/navigation/NavArgument$Builder;", "", "<init>", "()V", "T", "Landroidx/navigation/NavType;", "type", "d", "(Landroidx/navigation/NavType;)Landroidx/navigation/NavArgument$Builder;", "", "isNullable", "c", "(Z)Landroidx/navigation/NavArgument$Builder;", "defaultValue", "b", "(Ljava/lang/Object;)Landroidx/navigation/NavArgument$Builder;", "Landroidx/navigation/NavArgument;", "a", "()Landroidx/navigation/NavArgument;", "Landroidx/navigation/NavType;", "Z", "Ljava/lang/Object;", "defaultValuePresent", "navigation-common_release"}, k = 1, mv = {1, 6, 0})
    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        public NavType f1471a;
        public boolean b;
        public Object c;
        public boolean d;

        public final NavArgument a() {
            NavType navType = this.f1471a;
            if (navType == null) {
                navType = NavType.c.c(this.c);
            }
            return new NavArgument(navType, this.b, this.c, this.d);
        }

        public final Builder b(Object obj) {
            this.c = obj;
            this.d = true;
            return this;
        }

        public final Builder c(boolean z) {
            this.b = z;
            return this;
        }

        public final Builder d(NavType navType) {
            Intrinsics.checkNotNullParameter(navType, "type");
            this.f1471a = navType;
            return this;
        }
    }

    public NavArgument(NavType navType, boolean z, Object obj, boolean z2) {
        Intrinsics.checkNotNullParameter(navType, "type");
        if (!navType.c() && z) {
            throw new IllegalArgumentException(Intrinsics.stringPlus(navType.b(), " does not allow nullable values").toString());
        } else if (z || !z2 || obj != null) {
            this.f1470a = navType;
            this.b = z;
            this.d = obj;
            this.c = z2;
        } else {
            throw new IllegalArgumentException(("Argument with type " + navType.b() + " has null value but is not nullable.").toString());
        }
    }

    public final NavType a() {
        return this.f1470a;
    }

    public final boolean b() {
        return this.c;
    }

    public final boolean c() {
        return this.b;
    }

    public final void d(String str, Bundle bundle) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        if (this.c) {
            this.f1470a.f(bundle, str, this.d);
        }
    }

    public final boolean e(String str, Bundle bundle) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        if (!this.b && bundle.containsKey(str) && bundle.get(str) == null) {
            return false;
        }
        try {
            this.f1470a.a(bundle, str);
            return true;
        } catch (ClassCastException unused) {
            return false;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            if (Intrinsics.areEqual((Object) NavArgument.class, (Object) obj.getClass())) {
                NavArgument navArgument = (NavArgument) obj;
                if (this.b != navArgument.b || this.c != navArgument.c || !Intrinsics.areEqual((Object) this.f1470a, (Object) navArgument.f1470a)) {
                    return false;
                }
                Object obj2 = this.d;
                return obj2 != null ? Intrinsics.areEqual(obj2, navArgument.d) : navArgument.d == null;
            }
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((((this.f1470a.hashCode() * 31) + (this.b ? 1 : 0)) * 31) + (this.c ? 1 : 0)) * 31;
        Object obj = this.d;
        return hashCode + (obj == null ? 0 : obj.hashCode());
    }
}
