package androidx.navigation.fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.NavHost;
import androidx.navigation.NavHostController;
import androidx.navigation.Navigation;
import androidx.navigation.Navigator;
import androidx.navigation.NavigatorProvider;
import androidx.navigation.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u000e\b\u0016\u0018\u0000 C2\u00020\u00012\u00020\u0002:\u0001DB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0017¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\f\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0017¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000eH\u0015¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0012H\u0015¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0016H\u0017¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001c\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001b0\u001aH\u0015¢\u0006\u0004\b\u001c\u0010\u001dJ-\u0010#\u001a\u0004\u0018\u00010\"2\u0006\u0010\u001f\u001a\u00020\u001e2\b\u0010!\u001a\u0004\u0018\u00010 2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b#\u0010$J!\u0010&\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\"2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b&\u0010'J)\u0010*\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010)\u001a\u00020(2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0017¢\u0006\u0004\b*\u0010+J\u0017\u0010-\u001a\u00020\u00072\u0006\u0010,\u001a\u00020\nH\u0017¢\u0006\u0004\b-\u0010\rJ\u000f\u0010.\u001a\u00020\u0007H\u0016¢\u0006\u0004\b.\u0010\u0004R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u0018\u00103\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b1\u00102R\u0018\u00106\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b4\u00105R\u0016\u0010:\u001a\u0002078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010=\u001a\u00020\u00168\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b;\u0010<R\u0011\u0010\u0013\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\b>\u0010?R\u0014\u0010B\u001a\u0002078BX\u0004¢\u0006\u0006\u001a\u0004\b@\u0010A¨\u0006E"}, d2 = {"Landroidx/navigation/fragment/NavHostFragment;", "Landroidx/fragment/app/Fragment;", "Landroidx/navigation/NavHost;", "<init>", "()V", "Landroid/content/Context;", "context", "", "onAttach", "(Landroid/content/Context;)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Landroidx/navigation/NavHostController;", "navHostController", "l0", "(Landroidx/navigation/NavHostController;)V", "Landroidx/navigation/NavController;", "navController", "k0", "(Landroidx/navigation/NavController;)V", "", "isPrimaryNavigationFragment", "onPrimaryNavigationFragmentChanged", "(Z)V", "Landroidx/navigation/Navigator;", "Landroidx/navigation/fragment/FragmentNavigator$Destination;", "h0", "()Landroidx/navigation/Navigator;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Landroid/util/AttributeSet;", "attrs", "onInflate", "(Landroid/content/Context;Landroid/util/AttributeSet;Landroid/os/Bundle;)V", "outState", "onSaveInstanceState", "onDestroyView", "a", "Landroidx/navigation/NavHostController;", "b", "Ljava/lang/Boolean;", "isPrimaryBeforeOnCreate", "c", "Landroid/view/View;", "viewParent", "", "d", "I", "graphId", "e", "Z", "defaultNavHost", "j0", "()Landroidx/navigation/NavController;", "i0", "()I", "containerId", "f", "Companion", "navigation-fragment_release"}, k = 1, mv = {1, 6, 0})
public class NavHostFragment extends Fragment implements NavHost {
    public static final Companion f = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public NavHostController f1502a;
    public Boolean b;
    public View c;
    public int d;
    public boolean e;

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ%\u0010\u000e\u001a\u00020\r2\b\b\u0001\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0007¢\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u00108\u0002XT¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00108\u0006XT¢\u0006\u0006\n\u0004\b\u0013\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\u00108\u0002XT¢\u0006\u0006\n\u0004\b\u0014\u0010\u0012R\u0014\u0010\u0015\u001a\u00020\u00108\u0006XT¢\u0006\u0006\n\u0004\b\u0015\u0010\u0012¨\u0006\u0016"}, d2 = {"Landroidx/navigation/fragment/NavHostFragment$Companion;", "", "<init>", "()V", "Landroidx/fragment/app/Fragment;", "fragment", "Landroidx/navigation/NavController;", "c", "(Landroidx/fragment/app/Fragment;)Landroidx/navigation/NavController;", "", "graphResId", "Landroid/os/Bundle;", "startDestinationArgs", "Landroidx/navigation/fragment/NavHostFragment;", "a", "(ILandroid/os/Bundle;)Landroidx/navigation/fragment/NavHostFragment;", "", "KEY_DEFAULT_NAV_HOST", "Ljava/lang/String;", "KEY_GRAPH_ID", "KEY_NAV_CONTROLLER_STATE", "KEY_START_DESTINATION_ARGS", "navigation-fragment_release"}, k = 1, mv = {1, 6, 0})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ NavHostFragment b(Companion companion, int i, Bundle bundle, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                bundle = null;
            }
            return companion.a(i, bundle);
        }

        public final NavHostFragment a(int i, Bundle bundle) {
            Bundle bundle2;
            if (i != 0) {
                bundle2 = new Bundle();
                bundle2.putInt("android-support-nav:fragment:graphId", i);
            } else {
                bundle2 = null;
            }
            if (bundle != null) {
                if (bundle2 == null) {
                    bundle2 = new Bundle();
                }
                bundle2.putBundle("android-support-nav:fragment:startDestinationArgs", bundle);
            }
            NavHostFragment navHostFragment = new NavHostFragment();
            if (bundle2 != null) {
                navHostFragment.setArguments(bundle2);
            }
            return navHostFragment;
        }

        public final NavController c(Fragment fragment) {
            Dialog dialog;
            Window window;
            Intrinsics.checkNotNullParameter(fragment, "fragment");
            for (Fragment fragment2 = fragment; fragment2 != null; fragment2 = fragment2.getParentFragment()) {
                if (fragment2 instanceof NavHostFragment) {
                    NavHostController g0 = ((NavHostFragment) fragment2).f1502a;
                    if (g0 != null) {
                        return g0;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type androidx.navigation.NavController");
                }
                Fragment K0 = fragment2.getParentFragmentManager().K0();
                if (K0 instanceof NavHostFragment) {
                    NavHostController g02 = ((NavHostFragment) K0).f1502a;
                    if (g02 != null) {
                        return g02;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type androidx.navigation.NavController");
                }
            }
            View view = fragment.getView();
            if (view != null) {
                return Navigation.c(view);
            }
            View view2 = null;
            DialogFragment dialogFragment = fragment instanceof DialogFragment ? (DialogFragment) fragment : null;
            if (!(dialogFragment == null || (dialog = dialogFragment.getDialog()) == null || (window = dialog.getWindow()) == null)) {
                view2 = window.getDecorView();
            }
            if (view2 != null) {
                return Navigation.c(view2);
            }
            throw new IllegalStateException("Fragment " + fragment + " does not have a NavController set");
        }

        public Companion() {
        }
    }

    public Navigator h0() {
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        return new FragmentNavigator(requireContext, childFragmentManager, i0());
    }

    public final int i0() {
        int id = getId();
        return (id == 0 || id == -1) ? R.id.nav_host_fragment_container : id;
    }

    public final NavController j0() {
        NavHostController navHostController = this.f1502a;
        if (navHostController == null) {
            throw new IllegalStateException("NavController is not available before onCreate()".toString());
        } else if (navHostController != null) {
            return navHostController;
        } else {
            throw new NullPointerException("null cannot be cast to non-null type androidx.navigation.NavHostController");
        }
    }

    public void k0(NavController navController) {
        Intrinsics.checkNotNullParameter(navController, "navController");
        NavigatorProvider H = navController.H();
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        H.b(new DialogFragmentNavigator(requireContext, childFragmentManager));
        navController.H().b(h0());
    }

    public void l0(NavHostController navHostController) {
        Intrinsics.checkNotNullParameter(navHostController, "navHostController");
        k0(navHostController);
    }

    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        if (this.e) {
            getParentFragmentManager().s().y(this).j();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00a5  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00a8  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00b4  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00bf  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(android.os.Bundle r7) {
        /*
            r6 = this;
            android.content.Context r0 = r6.requireContext()
            java.lang.String r1 = "requireContext()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            androidx.navigation.NavHostController r1 = new androidx.navigation.NavHostController
            r1.<init>(r0)
            r6.f1502a = r1
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            r1.m0(r6)
        L_0x0016:
            boolean r1 = r0 instanceof android.content.ContextWrapper
            if (r1 == 0) goto L_0x003e
            boolean r1 = r0 instanceof androidx.activity.OnBackPressedDispatcherOwner
            if (r1 == 0) goto L_0x0032
            androidx.navigation.NavHostController r1 = r6.f1502a
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            androidx.activity.OnBackPressedDispatcherOwner r0 = (androidx.activity.OnBackPressedDispatcherOwner) r0
            androidx.activity.OnBackPressedDispatcher r0 = r0.getOnBackPressedDispatcher()
            java.lang.String r2 = "context as OnBackPressed…).onBackPressedDispatcher"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)
            r1.n0(r0)
            goto L_0x003e
        L_0x0032:
            android.content.ContextWrapper r0 = (android.content.ContextWrapper) r0
            android.content.Context r0 = r0.getBaseContext()
            java.lang.String r1 = "context.baseContext"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            goto L_0x0016
        L_0x003e:
            androidx.navigation.NavHostController r0 = r6.f1502a
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            java.lang.Boolean r1 = r6.b
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L_0x005b
            if (r1 == 0) goto L_0x0053
            boolean r1 = r1.booleanValue()
            if (r1 == 0) goto L_0x005b
            r1 = r2
            goto L_0x005c
        L_0x0053:
            java.lang.NullPointerException r6 = new java.lang.NullPointerException
            java.lang.String r7 = "null cannot be cast to non-null type kotlin.Boolean"
            r6.<init>(r7)
            throw r6
        L_0x005b:
            r1 = r3
        L_0x005c:
            r0.t(r1)
            r0 = 0
            r6.b = r0
            androidx.navigation.NavHostController r1 = r6.f1502a
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            androidx.lifecycle.ViewModelStore r4 = r6.getViewModelStore()
            java.lang.String r5 = "viewModelStore"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)
            r1.o0(r4)
            androidx.navigation.NavHostController r1 = r6.f1502a
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            r6.l0(r1)
            java.lang.String r1 = "android-support-nav:fragment:graphId"
            if (r7 == 0) goto L_0x00a5
            java.lang.String r4 = "android-support-nav:fragment:navControllerState"
            android.os.Bundle r4 = r7.getBundle(r4)
            java.lang.String r5 = "android-support-nav:fragment:defaultHost"
            boolean r5 = r7.getBoolean(r5, r3)
            if (r5 == 0) goto L_0x009e
            r6.e = r2
            androidx.fragment.app.FragmentManager r2 = r6.getParentFragmentManager()
            androidx.fragment.app.FragmentTransaction r2 = r2.s()
            androidx.fragment.app.FragmentTransaction r2 = r2.y(r6)
            r2.j()
        L_0x009e:
            int r2 = r7.getInt(r1)
            r6.d = r2
            goto L_0x00a6
        L_0x00a5:
            r4 = r0
        L_0x00a6:
            if (r4 == 0) goto L_0x00b0
            androidx.navigation.NavHostController r2 = r6.f1502a
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            r2.g0(r4)
        L_0x00b0:
            int r2 = r6.d
            if (r2 == 0) goto L_0x00bf
            androidx.navigation.NavHostController r0 = r6.f1502a
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            int r1 = r6.d
            r0.j0(r1)
            goto L_0x00dd
        L_0x00bf:
            android.os.Bundle r2 = r6.getArguments()
            if (r2 != 0) goto L_0x00c6
            goto L_0x00ca
        L_0x00c6:
            int r3 = r2.getInt(r1)
        L_0x00ca:
            if (r2 != 0) goto L_0x00cd
            goto L_0x00d3
        L_0x00cd:
            java.lang.String r0 = "android-support-nav:fragment:startDestinationArgs"
            android.os.Bundle r0 = r2.getBundle(r0)
        L_0x00d3:
            if (r3 == 0) goto L_0x00dd
            androidx.navigation.NavHostController r1 = r6.f1502a
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            r1.k0(r3, r0)
        L_0x00dd:
            super.onCreate(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.fragment.NavHostFragment.onCreate(android.os.Bundle):void");
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        Context context = layoutInflater.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "inflater.context");
        FragmentContainerView fragmentContainerView = new FragmentContainerView(context);
        fragmentContainerView.setId(i0());
        return fragmentContainerView;
    }

    public void onDestroyView() {
        super.onDestroyView();
        View view = this.c;
        if (view != null && Navigation.c(view) == this.f1502a) {
            Navigation.f(view, (NavController) null);
        }
        this.c = null;
    }

    public void onInflate(Context context, AttributeSet attributeSet, Bundle bundle) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attrs");
        super.onInflate(context, attributeSet, bundle);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.NavHost);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr…yleable.NavHost\n        )");
        int resourceId = obtainStyledAttributes.getResourceId(R.styleable.NavHost_navGraph, 0);
        if (resourceId != 0) {
            this.d = resourceId;
        }
        Unit unit = Unit.INSTANCE;
        obtainStyledAttributes.recycle();
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, R.styleable.NavHostFragment);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes2, "context.obtainStyledAttr…tyleable.NavHostFragment)");
        if (obtainStyledAttributes2.getBoolean(R.styleable.NavHostFragment_defaultNavHost, false)) {
            this.e = true;
        }
        obtainStyledAttributes2.recycle();
    }

    public void onPrimaryNavigationFragmentChanged(boolean z) {
        NavHostController navHostController = this.f1502a;
        if (navHostController == null) {
            this.b = Boolean.valueOf(z);
        } else if (navHostController != null) {
            navHostController.t(z);
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        super.onSaveInstanceState(bundle);
        NavHostController navHostController = this.f1502a;
        Intrinsics.checkNotNull(navHostController);
        Bundle i0 = navHostController.i0();
        if (i0 != null) {
            bundle.putBundle("android-support-nav:fragment:navControllerState", i0);
        }
        if (this.e) {
            bundle.putBoolean("android-support-nav:fragment:defaultHost", true);
        }
        int i = this.d;
        if (i != 0) {
            bundle.putInt("android-support-nav:fragment:graphId", i);
        }
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        if (view instanceof ViewGroup) {
            Navigation.f(view, this.f1502a);
            if (view.getParent() != null) {
                ViewParent parent = view.getParent();
                if (parent != null) {
                    View view2 = (View) parent;
                    this.c = view2;
                    Intrinsics.checkNotNull(view2);
                    if (view2.getId() == getId()) {
                        View view3 = this.c;
                        Intrinsics.checkNotNull(view3);
                        Navigation.f(view3, this.f1502a);
                        return;
                    }
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type android.view.View");
            }
            return;
        }
        throw new IllegalStateException(("created host view " + view + " is not a ViewGroup").toString());
    }
}
