package androidx.preference;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.OnBackPressedDispatcherOwner;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentFactory;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LifecycleOwner;
import androidx.preference.PreferenceFragmentCompat;
import androidx.slidingpanelayout.widget.SlidingPaneLayout;
import com.honey.account.a0.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import no.nordicsemi.android.dfu.DfuBaseService;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u00002\u00020\u00012\u00020\u0002:\u00014B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0017¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0017¢\u0006\u0004\b\u000f\u0010\u0010J+\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0017¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0005H&¢\u0006\u0004\b\u001a\u0010\u001bJ!\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0017¢\u0006\u0004\b\u001d\u0010\u001eJ\u0019\u0010\u001f\u001a\u00020\u000e2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016¢\u0006\u0004\b\u001f\u0010 J\u0011\u0010!\u001a\u0004\u0018\u00010\u0001H\u0016¢\u0006\u0004\b!\u0010\"J\u0017\u0010$\u001a\u00020#2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b$\u0010%J\u0017\u0010'\u001a\u00020\u000e2\u0006\u0010&\u001a\u00020\u0007H\u0002¢\u0006\u0004\b'\u0010(J\u0019\u0010+\u001a\u00020\u000e2\b\u0010*\u001a\u0004\u0018\u00010)H\u0002¢\u0006\u0004\b+\u0010,R\u0018\u00100\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u0011\u00103\u001a\u00020#8F¢\u0006\u0006\u001a\u0004\b1\u00102¨\u00065"}, d2 = {"Landroidx/preference/PreferenceHeaderFragmentCompat;", "Landroidx/fragment/app/Fragment;", "Landroidx/preference/PreferenceFragmentCompat$OnPreferenceStartFragmentCallback;", "<init>", "()V", "Landroidx/preference/PreferenceFragmentCompat;", "caller", "Landroidx/preference/Preference;", "pref", "", "t", "(Landroidx/preference/PreferenceFragmentCompat;Landroidx/preference/Preference;)Z", "Landroid/content/Context;", "context", "", "onAttach", "(Landroid/content/Context;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "l0", "()Landroidx/preference/PreferenceFragmentCompat;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onViewStateRestored", "(Landroid/os/Bundle;)V", "k0", "()Landroidx/fragment/app/Fragment;", "Landroidx/slidingpanelayout/widget/SlidingPaneLayout;", "i0", "(Landroid/view/LayoutInflater;)Landroidx/slidingpanelayout/widget/SlidingPaneLayout;", "header", "o0", "(Landroidx/preference/Preference;)V", "Landroid/content/Intent;", "intent", "n0", "(Landroid/content/Intent;)V", "Landroidx/activity/OnBackPressedCallback;", "a", "Landroidx/activity/OnBackPressedCallback;", "onBackPressedCallback", "j0", "()Landroidx/slidingpanelayout/widget/SlidingPaneLayout;", "slidingPaneLayout", "InnerOnBackPressedCallback", "preference_release"}, k = 1, mv = {1, 6, 0})
public abstract class PreferenceHeaderFragmentCompat extends Fragment implements PreferenceFragmentCompat.OnPreferenceStartFragmentCallback {

    /* renamed from: a  reason: collision with root package name */
    public OnBackPressedCallback f1685a;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0012\u0010\u0011R\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0013¨\u0006\u0014"}, d2 = {"Landroidx/preference/PreferenceHeaderFragmentCompat$InnerOnBackPressedCallback;", "Landroidx/activity/OnBackPressedCallback;", "Landroidx/slidingpanelayout/widget/SlidingPaneLayout$PanelSlideListener;", "Landroidx/preference/PreferenceHeaderFragmentCompat;", "caller", "<init>", "(Landroidx/preference/PreferenceHeaderFragmentCompat;)V", "", "handleOnBackPressed", "()V", "Landroid/view/View;", "panel", "", "slideOffset", "c", "(Landroid/view/View;F)V", "a", "(Landroid/view/View;)V", "b", "Landroidx/preference/PreferenceHeaderFragmentCompat;", "preference_release"}, k = 1, mv = {1, 6, 0})
    public static final class InnerOnBackPressedCallback extends OnBackPressedCallback implements SlidingPaneLayout.PanelSlideListener {

        /* renamed from: a  reason: collision with root package name */
        public final PreferenceHeaderFragmentCompat f1687a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public InnerOnBackPressedCallback(PreferenceHeaderFragmentCompat preferenceHeaderFragmentCompat) {
            super(true);
            Intrinsics.checkNotNullParameter(preferenceHeaderFragmentCompat, "caller");
            this.f1687a = preferenceHeaderFragmentCompat;
            preferenceHeaderFragmentCompat.j0().a(this);
        }

        public void a(View view) {
            Intrinsics.checkNotNullParameter(view, "panel");
            setEnabled(true);
        }

        public void b(View view) {
            Intrinsics.checkNotNullParameter(view, "panel");
            setEnabled(false);
        }

        public void c(View view, float f) {
            Intrinsics.checkNotNullParameter(view, "panel");
        }

        public void handleOnBackPressed() {
            this.f1687a.j0().b();
        }
    }

    public static final void m0(PreferenceHeaderFragmentCompat preferenceHeaderFragmentCompat) {
        Intrinsics.checkNotNullParameter(preferenceHeaderFragmentCompat, "this$0");
        OnBackPressedCallback onBackPressedCallback = preferenceHeaderFragmentCompat.f1685a;
        Intrinsics.checkNotNull(onBackPressedCallback);
        onBackPressedCallback.setEnabled(preferenceHeaderFragmentCompat.getChildFragmentManager().y0() == 0);
    }

    public final SlidingPaneLayout i0(LayoutInflater layoutInflater) {
        SlidingPaneLayout slidingPaneLayout = new SlidingPaneLayout(layoutInflater.getContext());
        slidingPaneLayout.setId(R.id.preferences_sliding_pane_layout);
        FragmentContainerView fragmentContainerView = new FragmentContainerView(layoutInflater.getContext());
        fragmentContainerView.setId(R.id.preferences_header);
        SlidingPaneLayout.LayoutParams layoutParams = new SlidingPaneLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.preferences_header_width), -1);
        layoutParams.f1788a = (float) getResources().getInteger(R.integer.preferences_header_pane_weight);
        slidingPaneLayout.addView(fragmentContainerView, layoutParams);
        FragmentContainerView fragmentContainerView2 = new FragmentContainerView(layoutInflater.getContext());
        fragmentContainerView2.setId(R.id.preferences_detail);
        SlidingPaneLayout.LayoutParams layoutParams2 = new SlidingPaneLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.preferences_detail_width), -1);
        layoutParams2.f1788a = (float) getResources().getInteger(R.integer.preferences_detail_pane_weight);
        slidingPaneLayout.addView(fragmentContainerView2, layoutParams2);
        return slidingPaneLayout;
    }

    public final SlidingPaneLayout j0() {
        return (SlidingPaneLayout) requireView();
    }

    public Fragment k0() {
        Fragment o0 = getChildFragmentManager().o0(R.id.preferences_header);
        if (o0 != null) {
            PreferenceFragmentCompat preferenceFragmentCompat = (PreferenceFragmentCompat) o0;
            if (preferenceFragmentCompat.j0().p() <= 0) {
                return null;
            }
            int p = preferenceFragmentCompat.j0().p();
            int i = 0;
            while (i < p) {
                int i2 = i + 1;
                Preference o = preferenceFragmentCompat.j0().o(i);
                Intrinsics.checkNotNullExpressionValue(o, "headerFragment.preferenc…reen.getPreference(index)");
                if (o.getFragment() == null) {
                    i = i2;
                } else {
                    String fragment = o.getFragment();
                    if (fragment == null) {
                        return null;
                    }
                    return getChildFragmentManager().D0().a(requireContext().getClassLoader(), fragment);
                }
            }
            return null;
        }
        throw new NullPointerException("null cannot be cast to non-null type androidx.preference.PreferenceFragmentCompat");
    }

    public abstract PreferenceFragmentCompat l0();

    public final void n0(Intent intent) {
        if (intent != null) {
            startActivity(intent);
        }
    }

    public final void o0(Preference preference) {
        if (preference.getFragment() == null) {
            n0(preference.getIntent());
            return;
        }
        String fragment = preference.getFragment();
        Fragment a2 = fragment == null ? null : getChildFragmentManager().D0().a(requireContext().getClassLoader(), fragment);
        if (a2 != null) {
            a2.setArguments(preference.getExtras());
        }
        if (getChildFragmentManager().y0() > 0) {
            FragmentManager.BackStackEntry x0 = getChildFragmentManager().x0(0);
            Intrinsics.checkNotNullExpressionValue(x0, "childFragmentManager.getBackStackEntryAt(0)");
            getChildFragmentManager().p1(x0.getId(), 1);
        }
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        FragmentTransaction s = childFragmentManager.s();
        Intrinsics.checkNotNullExpressionValue(s, "beginTransaction()");
        s.z(true);
        int i = R.id.preferences_detail;
        Intrinsics.checkNotNull(a2);
        s.t(i, a2);
        if (j0().m()) {
            s.A(DfuBaseService.ERROR_FILE_INVALID);
        }
        j0().q();
        s.j();
    }

    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        FragmentTransaction s = parentFragmentManager.s();
        Intrinsics.checkNotNullExpressionValue(s, "beginTransaction()");
        s.y(this);
        s.j();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        SlidingPaneLayout i0 = i0(layoutInflater);
        if (getChildFragmentManager().o0(R.id.preferences_header) == null) {
            PreferenceFragmentCompat l0 = l0();
            FragmentManager childFragmentManager = getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
            FragmentTransaction s = childFragmentManager.s();
            Intrinsics.checkNotNullExpressionValue(s, "beginTransaction()");
            s.z(true);
            s.b(R.id.preferences_header, l0);
            s.j();
        }
        i0.setLockMode(3);
        return i0;
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        this.f1685a = new InnerOnBackPressedCallback(this);
        SlidingPaneLayout j0 = j0();
        if (!ViewCompat.W(j0) || j0.isLayoutRequested()) {
            j0.addOnLayoutChangeListener(new PreferenceHeaderFragmentCompat$onViewCreated$$inlined$doOnLayout$1(this));
        } else {
            OnBackPressedCallback h0 = this.f1685a;
            Intrinsics.checkNotNull(h0);
            h0.setEnabled(j0().n() && j0().m());
        }
        getChildFragmentManager().n(new a(this));
        Context requireContext = requireContext();
        OnBackPressedDispatcherOwner onBackPressedDispatcherOwner = requireContext instanceof OnBackPressedDispatcherOwner ? (OnBackPressedDispatcherOwner) requireContext : null;
        if (onBackPressedDispatcherOwner != null) {
            OnBackPressedDispatcher onBackPressedDispatcher = onBackPressedDispatcherOwner.getOnBackPressedDispatcher();
            LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
            OnBackPressedCallback onBackPressedCallback = this.f1685a;
            Intrinsics.checkNotNull(onBackPressedCallback);
            onBackPressedDispatcher.i(viewLifecycleOwner, onBackPressedCallback);
        }
    }

    public void onViewStateRestored(Bundle bundle) {
        Fragment k0;
        super.onViewStateRestored(bundle);
        if (bundle == null && (k0 = k0()) != null) {
            FragmentManager childFragmentManager = getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
            FragmentTransaction s = childFragmentManager.s();
            Intrinsics.checkNotNullExpressionValue(s, "beginTransaction()");
            s.z(true);
            s.t(R.id.preferences_detail, k0);
            s.j();
        }
    }

    public boolean t(PreferenceFragmentCompat preferenceFragmentCompat, Preference preference) {
        Intrinsics.checkNotNullParameter(preferenceFragmentCompat, "caller");
        Intrinsics.checkNotNullParameter(preference, "pref");
        if (preferenceFragmentCompat.getId() == R.id.preferences_header) {
            o0(preference);
            return true;
        } else if (preferenceFragmentCompat.getId() != R.id.preferences_detail) {
            return false;
        } else {
            FragmentFactory D0 = getChildFragmentManager().D0();
            ClassLoader classLoader = requireContext().getClassLoader();
            String fragment = preference.getFragment();
            Intrinsics.checkNotNull(fragment);
            Fragment a2 = D0.a(classLoader, fragment);
            Intrinsics.checkNotNullExpressionValue(a2, "childFragmentManager.fra….fragment!!\n            )");
            a2.setArguments(preference.getExtras());
            FragmentManager childFragmentManager = getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
            FragmentTransaction s = childFragmentManager.s();
            Intrinsics.checkNotNullExpressionValue(s, "beginTransaction()");
            s.z(true);
            s.t(R.id.preferences_detail, a2);
            s.A(DfuBaseService.ERROR_FILE_INVALID);
            s.h((String) null);
            s.j();
            return true;
        }
    }
}
