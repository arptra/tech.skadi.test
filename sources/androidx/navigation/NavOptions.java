package androidx.navigation;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u001a\u0018\u00002\u00020\u0001:\u0001(B[\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\b\b\u0001\u0010\t\u001a\u00020\u0005\u0012\b\b\u0001\u0010\n\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u000b\u001a\u00020\u0005\u0012\b\b\u0001\u0010\f\u001a\u00020\u0005¢\u0006\u0004\b\r\u0010\u000eBS\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\u0005¢\u0006\u0004\b\r\u0010\u0011J\r\u0010\u0012\u001a\u00020\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\r\u0010\u0014\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0013J\r\u0010\u0015\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0013J\r\u0010\u0016\u001a\u00020\u0002¢\u0006\u0004\b\u0016\u0010\u0013J\u001a\u0010\u0018\u001a\u00020\u00022\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001a\u0010\u001bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\u0004\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001dR\u001a\u0010\u0006\u001a\u00020\u00058\u0007X\u0004¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\u001bR\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010\u001dR\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\u001dR\u0017\u0010\t\u001a\u00020\u00058\u0007¢\u0006\f\n\u0004\b\u0015\u0010 \u001a\u0004\b\u001c\u0010\u001bR\u0017\u0010\n\u001a\u00020\u00058\u0007¢\u0006\f\n\u0004\b\u0012\u0010 \u001a\u0004\b\u001e\u0010\u001bR\u0017\u0010\u000b\u001a\u00020\u00058\u0007¢\u0006\f\n\u0004\b\u0016\u0010 \u001a\u0004\b\u001f\u0010\u001bR\u0017\u0010\f\u001a\u00020\u00058\u0007¢\u0006\f\n\u0004\b\u0014\u0010 \u001a\u0004\b\"\u0010\u001bR(\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010#\u001a\u0004\u0018\u00010\u000f8\u0006@BX\u000e¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'¨\u0006)"}, d2 = {"Landroidx/navigation/NavOptions;", "", "", "singleTop", "restoreState", "", "popUpToId", "popUpToInclusive", "popUpToSaveState", "enterAnim", "exitAnim", "popEnterAnim", "popExitAnim", "<init>", "(ZZIZZIIII)V", "", "popUpToRoute", "(ZZLjava/lang/String;ZZIIII)V", "g", "()Z", "i", "f", "h", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "a", "Z", "b", "c", "I", "e", "d", "<set-?>", "j", "Ljava/lang/String;", "getPopUpToRoute", "()Ljava/lang/String;", "Builder", "navigation-common_release"}, k = 1, mv = {1, 6, 0})
public final class NavOptions {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f1489a;
    public final boolean b;
    public final int c;
    public final boolean d;
    public final boolean e;
    public final int f;
    public final int g;
    public final int h;
    public final int i;
    public String j;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\t\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\u0007J+\u0010\u000e\u001a\u00020\u00002\b\b\u0001\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00042\b\b\u0002\u0010\r\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ+\u0010\u0012\u001a\u00020\u00002\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\f\u001a\u00020\u00042\b\b\u0002\u0010\r\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0015\u001a\u00020\u00002\b\b\u0001\u0010\u0014\u001a\u00020\n¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0018\u001a\u00020\u00002\b\b\u0001\u0010\u0017\u001a\u00020\n¢\u0006\u0004\b\u0018\u0010\u0016J\u0017\u0010\u001a\u001a\u00020\u00002\b\b\u0001\u0010\u0019\u001a\u00020\n¢\u0006\u0004\b\u001a\u0010\u0016J\u0017\u0010\u001c\u001a\u00020\u00002\b\b\u0001\u0010\u001b\u001a\u00020\n¢\u0006\u0004\b\u001c\u0010\u0016J\r\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\u001e\u0010\u001fR\u0016\u0010\u0005\u001a\u00020\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010 R\u0016\u0010\b\u001a\u00020\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010 R\u0016\u0010\"\u001a\u00020\n8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010!R\u0018\u0010$\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010#R\u0016\u0010%\u001a\u00020\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010 R\u0016\u0010&\u001a\u00020\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010 R\u0016\u0010\u0014\u001a\u00020\n8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010!R\u0016\u0010\u0017\u001a\u00020\n8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010!R\u0016\u0010\u0019\u001a\u00020\n8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b'\u0010!R\u0016\u0010\u001b\u001a\u00020\n8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\t\u0010!¨\u0006("}, d2 = {"Landroidx/navigation/NavOptions$Builder;", "", "<init>", "()V", "", "singleTop", "d", "(Z)Landroidx/navigation/NavOptions$Builder;", "restoreState", "j", "", "destinationId", "inclusive", "saveState", "g", "(IZZ)Landroidx/navigation/NavOptions$Builder;", "", "route", "h", "(Ljava/lang/String;ZZ)Landroidx/navigation/NavOptions$Builder;", "enterAnim", "b", "(I)Landroidx/navigation/NavOptions$Builder;", "exitAnim", "c", "popEnterAnim", "e", "popExitAnim", "f", "Landroidx/navigation/NavOptions;", "a", "()Landroidx/navigation/NavOptions;", "Z", "I", "popUpToId", "Ljava/lang/String;", "popUpToRoute", "popUpToInclusive", "popUpToSaveState", "i", "navigation-common_release"}, k = 1, mv = {1, 6, 0})
    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        public boolean f1490a;
        public boolean b;
        public int c = -1;
        public String d;
        public boolean e;
        public boolean f;
        public int g = -1;
        public int h = -1;
        public int i = -1;
        public int j = -1;

        public static /* synthetic */ Builder i(Builder builder, int i2, boolean z, boolean z2, int i3, Object obj) {
            if ((i3 & 4) != 0) {
                z2 = false;
            }
            return builder.g(i2, z, z2);
        }

        public final NavOptions a() {
            String str = this.d;
            if (str != null) {
                return new NavOptions(this.f1490a, this.b, str, this.e, this.f, this.g, this.h, this.i, this.j);
            }
            return new NavOptions(this.f1490a, this.b, this.c, this.e, this.f, this.g, this.h, this.i, this.j);
        }

        public final Builder b(int i2) {
            this.g = i2;
            return this;
        }

        public final Builder c(int i2) {
            this.h = i2;
            return this;
        }

        public final Builder d(boolean z) {
            this.f1490a = z;
            return this;
        }

        public final Builder e(int i2) {
            this.i = i2;
            return this;
        }

        public final Builder f(int i2) {
            this.j = i2;
            return this;
        }

        public final Builder g(int i2, boolean z, boolean z2) {
            this.c = i2;
            this.d = null;
            this.e = z;
            this.f = z2;
            return this;
        }

        public final Builder h(String str, boolean z, boolean z2) {
            this.d = str;
            this.c = -1;
            this.e = z;
            this.f = z2;
            return this;
        }

        public final Builder j(boolean z) {
            this.b = z;
            return this;
        }
    }

    public NavOptions(boolean z, boolean z2, int i2, boolean z3, boolean z4, int i3, int i4, int i5, int i6) {
        this.f1489a = z;
        this.b = z2;
        this.c = i2;
        this.d = z3;
        this.e = z4;
        this.f = i3;
        this.g = i4;
        this.h = i5;
        this.i = i6;
    }

    public final int a() {
        return this.f;
    }

    public final int b() {
        return this.g;
    }

    public final int c() {
        return this.h;
    }

    public final int d() {
        return this.i;
    }

    public final int e() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            if (Intrinsics.areEqual((Object) NavOptions.class, (Object) obj.getClass())) {
                NavOptions navOptions = (NavOptions) obj;
                return this.f1489a == navOptions.f1489a && this.b == navOptions.b && this.c == navOptions.c && Intrinsics.areEqual((Object) this.j, (Object) navOptions.j) && this.d == navOptions.d && this.e == navOptions.e && this.f == navOptions.f && this.g == navOptions.g && this.h == navOptions.h && this.i == navOptions.i;
            }
        }
        return false;
    }

    public final boolean f() {
        return this.d;
    }

    public final boolean g() {
        return this.f1489a;
    }

    public final boolean h() {
        return this.e;
    }

    public int hashCode() {
        int i2 = (((((g() ? 1 : 0) * true) + (i() ? 1 : 0)) * 31) + this.c) * 31;
        String str = this.j;
        return ((((((((((((i2 + (str == null ? 0 : str.hashCode())) * 31) + (f() ? 1 : 0)) * 31) + (h() ? 1 : 0)) * 31) + this.f) * 31) + this.g) * 31) + this.h) * 31) + this.i;
    }

    public final boolean i() {
        return this.b;
    }

    public NavOptions(boolean z, boolean z2, String str, boolean z3, boolean z4, int i2, int i3, int i4, int i5) {
        this(z, z2, NavDestination.j.a(str).hashCode(), z3, z4, i2, i3, i4, i5);
        this.j = str;
    }
}
