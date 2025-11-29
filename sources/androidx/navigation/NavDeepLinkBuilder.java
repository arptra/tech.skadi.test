package androidx.navigation;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.core.app.TaskStackBuilder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0002)*B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0010\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0004\u0010\bJ%\u0010\r\u001a\u00020\u00002\b\b\u0001\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0007¢\u0006\u0004\b\r\u0010\u000eJ%\u0010\u000f\u001a\u00020\u00002\b\b\u0001\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0007¢\u0006\u0004\b\u000f\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\u00002\b\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0010\u0010\u0011J\r\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0013\u0010\u0014J\u001b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\b\u0001\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0019\u001a\u00020\u0018H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0018H\u0002¢\u0006\u0004\b\u001b\u0010\u001aR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u001cR\u0014\u0010\u001f\u001a\u00020\u001d8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u001eR\u0018\u0010\"\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010!R\u001a\u0010&\u001a\b\u0012\u0004\u0012\u00020$0#8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010%R\u0018\u0010(\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010'¨\u0006+"}, d2 = {"Landroidx/navigation/NavDeepLinkBuilder;", "", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroidx/navigation/NavController;", "navController", "(Landroidx/navigation/NavController;)V", "", "destId", "Landroid/os/Bundle;", "args", "f", "(ILandroid/os/Bundle;)Landroidx/navigation/NavDeepLinkBuilder;", "a", "e", "(Landroid/os/Bundle;)Landroidx/navigation/NavDeepLinkBuilder;", "Landroidx/core/app/TaskStackBuilder;", "b", "()Landroidx/core/app/TaskStackBuilder;", "Landroidx/navigation/NavDestination;", "d", "(I)Landroidx/navigation/NavDestination;", "", "h", "()V", "c", "Landroid/content/Context;", "Landroid/content/Intent;", "Landroid/content/Intent;", "intent", "Landroidx/navigation/NavGraph;", "Landroidx/navigation/NavGraph;", "graph", "", "Landroidx/navigation/NavDeepLinkBuilder$DeepLinkDestination;", "Ljava/util/List;", "destinations", "Landroid/os/Bundle;", "globalArgs", "DeepLinkDestination", "PermissiveNavigatorProvider", "navigation-runtime_release"}, k = 1, mv = {1, 6, 0})
public final class NavDeepLinkBuilder {

    /* renamed from: a  reason: collision with root package name */
    public final Context f1481a;
    public final Intent b;
    public NavGraph c;
    public final List d;
    public Bundle e;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\n\u0010\f\u001a\u0004\b\b\u0010\r¨\u0006\u000e"}, d2 = {"Landroidx/navigation/NavDeepLinkBuilder$DeepLinkDestination;", "", "", "destinationId", "Landroid/os/Bundle;", "arguments", "<init>", "(ILandroid/os/Bundle;)V", "a", "I", "b", "()I", "Landroid/os/Bundle;", "()Landroid/os/Bundle;", "navigation-runtime_release"}, k = 1, mv = {1, 6, 0})
    public static final class DeepLinkDestination {

        /* renamed from: a  reason: collision with root package name */
        public final int f1482a;
        public final Bundle b;

        public DeepLinkDestination(int i, Bundle bundle) {
            this.f1482a = i;
            this.b = bundle;
        }

        public final Bundle a() {
            return this.b;
        }

        public final int b() {
            return this.f1482a;
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001J)\u0010\u0007\u001a\u00028\u0000\"\u0010\b\u0000\u0010\u0004*\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\t¨\u0006\u000b"}, d2 = {"Landroidx/navigation/NavDeepLinkBuilder$PermissiveNavigatorProvider;", "Landroidx/navigation/NavigatorProvider;", "Landroidx/navigation/Navigator;", "Landroidx/navigation/NavDestination;", "T", "", "name", "d", "(Ljava/lang/String;)Landroidx/navigation/Navigator;", "Landroidx/navigation/Navigator;", "mDestNavigator", "navigation-runtime_release"}, k = 1, mv = {1, 6, 0})
    public static final class PermissiveNavigatorProvider extends NavigatorProvider {
        public final Navigator d;

        public Navigator d(String str) {
            Intrinsics.checkNotNullParameter(str, "name");
            try {
                return super.d(str);
            } catch (IllegalStateException unused) {
                return this.d;
            }
        }
    }

    public NavDeepLinkBuilder(Context context) {
        Intent intent;
        Intrinsics.checkNotNullParameter(context, "context");
        this.f1481a = context;
        if (context instanceof Activity) {
            intent = new Intent(context, context.getClass());
        } else {
            intent = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
            if (intent == null) {
                intent = new Intent();
            }
        }
        intent.addFlags(268468224);
        this.b = intent;
        this.d = new ArrayList();
    }

    public static /* synthetic */ NavDeepLinkBuilder g(NavDeepLinkBuilder navDeepLinkBuilder, int i, Bundle bundle, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            bundle = null;
        }
        return navDeepLinkBuilder.f(i, bundle);
    }

    public final NavDeepLinkBuilder a(int i, Bundle bundle) {
        this.d.add(new DeepLinkDestination(i, bundle));
        if (this.c != null) {
            h();
        }
        return this;
    }

    public final TaskStackBuilder b() {
        if (this.c == null) {
            throw new IllegalStateException("You must call setGraph() before constructing the deep link".toString());
        } else if (!this.d.isEmpty()) {
            c();
            TaskStackBuilder b2 = TaskStackBuilder.e(this.f1481a).b(new Intent(this.b));
            Intrinsics.checkNotNullExpressionValue(b2, "create(context)\n        …rentStack(Intent(intent))");
            int h = b2.h();
            int i = 0;
            while (i < h) {
                int i2 = i + 1;
                Intent f = b2.f(i);
                if (f != null) {
                    f.putExtra("android-support-nav:controller:deepLinkIntent", this.b);
                }
                i = i2;
            }
            return b2;
        } else {
            throw new IllegalStateException("You must call setDestination() or addDestination() before constructing the deep link".toString());
        }
    }

    public final void c() {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        NavDestination navDestination = null;
        for (DeepLinkDestination deepLinkDestination : this.d) {
            int b2 = deepLinkDestination.b();
            Bundle a2 = deepLinkDestination.a();
            NavDestination d2 = d(b2);
            if (d2 != null) {
                int[] e2 = d2.e(navDestination);
                int length = e2.length;
                int i = 0;
                while (i < length) {
                    int i2 = e2[i];
                    i++;
                    arrayList.add(Integer.valueOf(i2));
                    arrayList2.add(a2);
                }
                navDestination = d2;
            } else {
                String b3 = NavDestination.j.b(this.f1481a, b2);
                throw new IllegalArgumentException("Navigation destination " + b3 + " cannot be found in the navigation graph " + this.c);
            }
        }
        this.b.putExtra("android-support-nav:controller:deepLinkIds", CollectionsKt.toIntArray(arrayList));
        this.b.putParcelableArrayListExtra("android-support-nav:controller:deepLinkArgs", arrayList2);
    }

    public final NavDestination d(int i) {
        ArrayDeque arrayDeque = new ArrayDeque();
        NavGraph navGraph = this.c;
        Intrinsics.checkNotNull(navGraph);
        arrayDeque.add(navGraph);
        while (!arrayDeque.isEmpty()) {
            NavDestination navDestination = (NavDestination) arrayDeque.removeFirst();
            if (navDestination.k() == i) {
                return navDestination;
            }
            if (navDestination instanceof NavGraph) {
                Iterator it = ((NavGraph) navDestination).iterator();
                while (it.hasNext()) {
                    arrayDeque.add((NavDestination) it.next());
                }
            }
        }
        return null;
    }

    public final NavDeepLinkBuilder e(Bundle bundle) {
        this.e = bundle;
        this.b.putExtra("android-support-nav:controller:deepLinkExtras", bundle);
        return this;
    }

    public final NavDeepLinkBuilder f(int i, Bundle bundle) {
        this.d.clear();
        this.d.add(new DeepLinkDestination(i, bundle));
        if (this.c != null) {
            h();
        }
        return this;
    }

    public final void h() {
        for (DeepLinkDestination b2 : this.d) {
            int b3 = b2.b();
            if (d(b3) == null) {
                String b4 = NavDestination.j.b(this.f1481a, b3);
                throw new IllegalArgumentException("Navigation destination " + b4 + " cannot be found in the navigation graph " + this.c);
            }
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public NavDeepLinkBuilder(NavController navController) {
        this(navController.A());
        Intrinsics.checkNotNullParameter(navController, "navController");
        this.c = navController.E();
    }
}
