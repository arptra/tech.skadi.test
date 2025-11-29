package androidx.navigation.fragment;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.navigation.FloatingWindow;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavDestination;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigator;
import androidx.navigation.NavigatorState;
import com.honey.account.z.a;
import com.honey.account.z.b;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 ,2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002-.B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J1\u0010\u0018\u001a\u00020\r2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\t0\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001f\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\tH\u0002¢\u0006\u0004\b\u001f\u0010 R\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u001a\u0010(\u001a\b\u0012\u0004\u0012\u00020&0%8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010'R\u0014\u0010+\u001a\u00020)8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010*¨\u0006/"}, d2 = {"Landroidx/navigation/fragment/DialogFragmentNavigator;", "Landroidx/navigation/Navigator;", "Landroidx/navigation/fragment/DialogFragmentNavigator$Destination;", "Landroid/content/Context;", "context", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "<init>", "(Landroid/content/Context;Landroidx/fragment/app/FragmentManager;)V", "Landroidx/navigation/NavBackStackEntry;", "popUpTo", "", "savedState", "", "j", "(Landroidx/navigation/NavBackStackEntry;Z)V", "n", "()Landroidx/navigation/fragment/DialogFragmentNavigator$Destination;", "", "entries", "Landroidx/navigation/NavOptions;", "navOptions", "Landroidx/navigation/Navigator$Extras;", "navigatorExtras", "e", "(Ljava/util/List;Landroidx/navigation/NavOptions;Landroidx/navigation/Navigator$Extras;)V", "Landroidx/navigation/NavigatorState;", "state", "f", "(Landroidx/navigation/NavigatorState;)V", "entry", "o", "(Landroidx/navigation/NavBackStackEntry;)V", "c", "Landroid/content/Context;", "d", "Landroidx/fragment/app/FragmentManager;", "", "", "Ljava/util/Set;", "restoredTagsAwaitingAttach", "Landroidx/lifecycle/LifecycleEventObserver;", "Landroidx/lifecycle/LifecycleEventObserver;", "observer", "g", "Companion", "Destination", "navigation-fragment_release"}, k = 1, mv = {1, 6, 0})
@Navigator.Name("dialog")
public final class DialogFragmentNavigator extends Navigator<Destination> {
    public static final Companion g = new Companion((DefaultConstructorMarker) null);
    public final Context c;
    public final FragmentManager d;
    public final Set e = new LinkedHashSet();
    public final LifecycleEventObserver f = new a(this);

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Landroidx/navigation/fragment/DialogFragmentNavigator$Companion;", "", "()V", "TAG", "", "navigation-fragment_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0017\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00000\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0017¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0011\u0010\u000f\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, d2 = {"Landroidx/navigation/fragment/DialogFragmentNavigator$Destination;", "Landroidx/navigation/NavDestination;", "Landroidx/navigation/FloatingWindow;", "Landroidx/navigation/Navigator;", "fragmentNavigator", "<init>", "(Landroidx/navigation/Navigator;)V", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "q", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "className", "y", "(Ljava/lang/String;)Landroidx/navigation/fragment/DialogFragmentNavigator$Destination;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "l", "Ljava/lang/String;", "_className", "x", "()Ljava/lang/String;", "navigation-fragment_release"}, k = 1, mv = {1, 6, 0})
    @NavDestination.ClassType
    public static class Destination extends NavDestination implements FloatingWindow {
        public String l;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Destination(Navigator navigator) {
            super(navigator);
            Intrinsics.checkNotNullParameter(navigator, "fragmentNavigator");
        }

        public boolean equals(Object obj) {
            return obj != null && (obj instanceof Destination) && super.equals(obj) && Intrinsics.areEqual((Object) this.l, (Object) ((Destination) obj).l);
        }

        public int hashCode() {
            int hashCode = super.hashCode() * 31;
            String str = this.l;
            return hashCode + (str == null ? 0 : str.hashCode());
        }

        public void q(Context context, AttributeSet attributeSet) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(attributeSet, "attrs");
            super.q(context, attributeSet);
            TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, R.styleable.DialogFragmentNavigator);
            Intrinsics.checkNotNullExpressionValue(obtainAttributes, "context.resources.obtain…ntNavigator\n            )");
            String string = obtainAttributes.getString(R.styleable.DialogFragmentNavigator_android_name);
            if (string != null) {
                y(string);
            }
            obtainAttributes.recycle();
        }

        public final String x() {
            String str = this.l;
            if (str == null) {
                throw new IllegalStateException("DialogFragment class was not set".toString());
            } else if (str != null) {
                return str;
            } else {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
        }

        public final Destination y(String str) {
            Intrinsics.checkNotNullParameter(str, "className");
            this.l = str;
            return this;
        }
    }

    public DialogFragmentNavigator(Context context, FragmentManager fragmentManager) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
        this.c = context;
        this.d = fragmentManager;
    }

    public static final void p(DialogFragmentNavigator dialogFragmentNavigator, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        Object obj;
        Intrinsics.checkNotNullParameter(dialogFragmentNavigator, "this$0");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "source");
        Intrinsics.checkNotNullParameter(event, "event");
        if (event == Lifecycle.Event.ON_CREATE) {
            DialogFragment dialogFragment = (DialogFragment) lifecycleOwner;
            Iterable<NavBackStackEntry> iterable = (Iterable) dialogFragmentNavigator.b().b().getValue();
            if (!(iterable instanceof Collection) || !((Collection) iterable).isEmpty()) {
                for (NavBackStackEntry g2 : iterable) {
                    if (Intrinsics.areEqual((Object) g2.g(), (Object) dialogFragment.getTag())) {
                        return;
                    }
                }
            }
            dialogFragment.dismiss();
        } else if (event == Lifecycle.Event.ON_STOP) {
            DialogFragment dialogFragment2 = (DialogFragment) lifecycleOwner;
            if (!dialogFragment2.requireDialog().isShowing()) {
                List list = (List) dialogFragmentNavigator.b().b().getValue();
                ListIterator listIterator = list.listIterator(list.size());
                while (true) {
                    if (!listIterator.hasPrevious()) {
                        obj = null;
                        break;
                    }
                    obj = listIterator.previous();
                    if (Intrinsics.areEqual((Object) ((NavBackStackEntry) obj).g(), (Object) dialogFragment2.getTag())) {
                        break;
                    }
                }
                if (obj != null) {
                    NavBackStackEntry navBackStackEntry = (NavBackStackEntry) obj;
                    if (!Intrinsics.areEqual(CollectionsKt.lastOrNull(list), (Object) navBackStackEntry)) {
                        Log.i("DialogFragmentNavigator", "Dialog " + dialogFragment2 + " was dismissed while it was not the top of the back stack, popping all dialogs above this dismissed dialog");
                    }
                    dialogFragmentNavigator.j(navBackStackEntry, false);
                    return;
                }
                throw new IllegalStateException(("Dialog " + dialogFragment2 + " has already been popped off of the Navigation back stack").toString());
            }
        }
    }

    public static final void q(DialogFragmentNavigator dialogFragmentNavigator, FragmentManager fragmentManager, Fragment fragment) {
        Intrinsics.checkNotNullParameter(dialogFragmentNavigator, "this$0");
        Intrinsics.checkNotNullParameter(fragmentManager, "$noName_0");
        Intrinsics.checkNotNullParameter(fragment, "childFragment");
        if (dialogFragmentNavigator.e.remove(fragment.getTag())) {
            fragment.getLifecycle().a(dialogFragmentNavigator.f);
        }
    }

    public void e(List list, NavOptions navOptions, Navigator.Extras extras) {
        Intrinsics.checkNotNullParameter(list, "entries");
        if (this.d.a1()) {
            Log.i("DialogFragmentNavigator", "Ignoring navigate() call: FragmentManager has already saved its state");
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            o((NavBackStackEntry) it.next());
        }
    }

    public void f(NavigatorState navigatorState) {
        Lifecycle lifecycle;
        Intrinsics.checkNotNullParameter(navigatorState, "state");
        super.f(navigatorState);
        for (NavBackStackEntry navBackStackEntry : (List) navigatorState.b().getValue()) {
            DialogFragment dialogFragment = (DialogFragment) this.d.p0(navBackStackEntry.g());
            Unit unit = null;
            if (!(dialogFragment == null || (lifecycle = dialogFragment.getLifecycle()) == null)) {
                lifecycle.a(this.f);
                unit = Unit.INSTANCE;
            }
            if (unit == null) {
                this.e.add(navBackStackEntry.g());
            }
        }
        this.d.m(new b(this));
    }

    public void j(NavBackStackEntry navBackStackEntry, boolean z) {
        Intrinsics.checkNotNullParameter(navBackStackEntry, "popUpTo");
        if (this.d.a1()) {
            Log.i("DialogFragmentNavigator", "Ignoring popBackStack() call: FragmentManager has already saved its state");
            return;
        }
        List list = (List) b().b().getValue();
        for (NavBackStackEntry g2 : CollectionsKt.reversed(list.subList(list.indexOf(navBackStackEntry), list.size()))) {
            Fragment p0 = this.d.p0(g2.g());
            if (p0 != null) {
                p0.getLifecycle().d(this.f);
                ((DialogFragment) p0).dismiss();
            }
        }
        b().g(navBackStackEntry, z);
    }

    /* renamed from: n */
    public Destination a() {
        return new Destination(this);
    }

    public final void o(NavBackStackEntry navBackStackEntry) {
        Destination destination = (Destination) navBackStackEntry.f();
        String x = destination.x();
        if (x.charAt(0) == '.') {
            x = Intrinsics.stringPlus(this.c.getPackageName(), x);
        }
        Fragment a2 = this.d.D0().a(this.c.getClassLoader(), x);
        Intrinsics.checkNotNullExpressionValue(a2, "fragmentManager.fragment…ader, className\n        )");
        if (DialogFragment.class.isAssignableFrom(a2.getClass())) {
            DialogFragment dialogFragment = (DialogFragment) a2;
            dialogFragment.setArguments(navBackStackEntry.d());
            dialogFragment.getLifecycle().a(this.f);
            dialogFragment.show(this.d, navBackStackEntry.g());
            b().h(navBackStackEntry);
            return;
        }
        throw new IllegalArgumentException(("Dialog destination " + destination.x() + " is not an instance of DialogFragment").toString());
    }
}
