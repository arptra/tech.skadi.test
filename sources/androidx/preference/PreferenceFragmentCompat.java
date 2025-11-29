package androidx.preference;

import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.preference.DialogPreference;
import androidx.preference.PreferenceGroup;
import androidx.preference.PreferenceManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public abstract class PreferenceFragmentCompat extends Fragment implements PreferenceManager.OnPreferenceTreeClickListener, PreferenceManager.OnDisplayPreferenceDialogListener, PreferenceManager.OnNavigateToScreenListener, DialogPreference.TargetFragment {

    /* renamed from: a  reason: collision with root package name */
    public final DividerDecoration f1672a = new DividerDecoration();
    public PreferenceManager b;
    public RecyclerView c;
    public boolean d;
    public boolean e;
    public int f = R.layout.preference_list_fragment;
    public Runnable g;
    public final Handler h = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message message) {
            if (message.what == 1) {
                PreferenceFragmentCompat.this.g0();
            }
        }
    };
    public final Runnable i = new Runnable() {
        public void run() {
            RecyclerView recyclerView = PreferenceFragmentCompat.this.c;
            recyclerView.focusableViewAvailable(recyclerView);
        }
    };

    /* renamed from: androidx.preference.PreferenceFragmentCompat$3  reason: invalid class name */
    class AnonymousClass3 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Preference f1675a;
        public final /* synthetic */ String b;
        public final /* synthetic */ PreferenceFragmentCompat c;

        public void run() {
            RecyclerView.Adapter adapter = this.c.c.getAdapter();
            if (adapter instanceof PreferenceGroup.PreferencePositionCallback) {
                Preference preference = this.f1675a;
                int b2 = preference != null ? ((PreferenceGroup.PreferencePositionCallback) adapter).b(preference) : ((PreferenceGroup.PreferencePositionCallback) adapter).e(this.b);
                if (b2 != -1) {
                    this.c.c.scrollToPosition(b2);
                } else {
                    adapter.registerAdapterDataObserver(new ScrollToPreferenceObserver(adapter, this.c.c, this.f1675a, this.b));
                }
            } else if (adapter != null) {
                throw new IllegalStateException("Adapter must implement PreferencePositionCallback");
            }
        }
    }

    public class DividerDecoration extends RecyclerView.ItemDecoration {

        /* renamed from: a  reason: collision with root package name */
        public Drawable f1676a;
        public int b;
        public boolean c = true;

        public DividerDecoration() {
        }

        private boolean b(View view, RecyclerView recyclerView) {
            RecyclerView.ViewHolder childViewHolder = recyclerView.getChildViewHolder(view);
            boolean z = false;
            if (!(childViewHolder instanceof PreferenceViewHolder) || !((PreferenceViewHolder) childViewHolder).c()) {
                return false;
            }
            boolean z2 = this.c;
            int indexOfChild = recyclerView.indexOfChild(view);
            if (indexOfChild >= recyclerView.getChildCount() - 1) {
                return z2;
            }
            RecyclerView.ViewHolder childViewHolder2 = recyclerView.getChildViewHolder(recyclerView.getChildAt(indexOfChild + 1));
            if ((childViewHolder2 instanceof PreferenceViewHolder) && ((PreferenceViewHolder) childViewHolder2).b()) {
                z = true;
            }
            return z;
        }

        public void a(boolean z) {
            this.c = z;
        }

        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            if (b(view, recyclerView)) {
                rect.bottom = this.b;
            }
        }

        public void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
            if (this.f1676a != null) {
                int childCount = recyclerView.getChildCount();
                int width = recyclerView.getWidth();
                for (int i = 0; i < childCount; i++) {
                    View childAt = recyclerView.getChildAt(i);
                    if (b(childAt, recyclerView)) {
                        int y = ((int) childAt.getY()) + childAt.getHeight();
                        this.f1676a.setBounds(0, y, width, this.b + y);
                        this.f1676a.draw(canvas);
                    }
                }
            }
        }

        public void setDivider(Drawable drawable) {
            if (drawable != null) {
                this.b = drawable.getIntrinsicHeight();
            } else {
                this.b = 0;
            }
            this.f1676a = drawable;
            PreferenceFragmentCompat.this.c.invalidateItemDecorations();
        }

        public void setDividerHeight(int i) {
            this.b = i;
            PreferenceFragmentCompat.this.c.invalidateItemDecorations();
        }
    }

    public interface OnPreferenceDisplayDialogCallback {
        boolean a(PreferenceFragmentCompat preferenceFragmentCompat, Preference preference);
    }

    public interface OnPreferenceStartFragmentCallback {
        boolean t(PreferenceFragmentCompat preferenceFragmentCompat, Preference preference);
    }

    public interface OnPreferenceStartScreenCallback {
        boolean a(PreferenceFragmentCompat preferenceFragmentCompat, PreferenceScreen preferenceScreen);
    }

    public static class ScrollToPreferenceObserver extends RecyclerView.AdapterDataObserver {

        /* renamed from: a  reason: collision with root package name */
        public final RecyclerView.Adapter f1677a;
        public final RecyclerView b;
        public final Preference c;
        public final String d;

        public ScrollToPreferenceObserver(RecyclerView.Adapter adapter, RecyclerView recyclerView, Preference preference, String str) {
            this.f1677a = adapter;
            this.b = recyclerView;
            this.c = preference;
            this.d = str;
        }

        private void a() {
            this.f1677a.unregisterAdapterDataObserver(this);
            Preference preference = this.c;
            int b2 = preference != null ? ((PreferenceGroup.PreferencePositionCallback) this.f1677a).b(preference) : ((PreferenceGroup.PreferencePositionCallback) this.f1677a).e(this.d);
            if (b2 != -1) {
                this.b.scrollToPosition(b2);
            }
        }

        public void onChanged() {
            a();
        }

        public void onItemRangeChanged(int i, int i2) {
            a();
        }

        public void onItemRangeInserted(int i, int i2) {
            a();
        }

        public void onItemRangeMoved(int i, int i2, int i3) {
            a();
        }

        public void onItemRangeRemoved(int i, int i2) {
            a();
        }

        public void onItemRangeChanged(int i, int i2, Object obj) {
            a();
        }
    }

    public boolean A(Preference preference) {
        if (preference.getFragment() == null) {
            return false;
        }
        boolean t = h0() instanceof OnPreferenceStartFragmentCallback ? ((OnPreferenceStartFragmentCallback) h0()).t(this, preference) : false;
        Fragment fragment = this;
        while (!t && fragment != null) {
            if (fragment instanceof OnPreferenceStartFragmentCallback) {
                t = ((OnPreferenceStartFragmentCallback) fragment).t(this, preference);
            }
            fragment = fragment.getParentFragment();
        }
        if (!t && (getContext() instanceof OnPreferenceStartFragmentCallback)) {
            t = ((OnPreferenceStartFragmentCallback) getContext()).t(this, preference);
        }
        if (!t && (getActivity() instanceof OnPreferenceStartFragmentCallback)) {
            t = ((OnPreferenceStartFragmentCallback) getActivity()).t(this, preference);
        }
        if (t) {
            return true;
        }
        Log.w("PreferenceFragment", "onPreferenceStartFragment is not implemented in the parent activity - attempting to use a fallback implementation. You should implement this method so that you can configure the new fragment that will be displayed, and set a transition between the fragments.");
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Bundle extras = preference.getExtras();
        Fragment a2 = parentFragmentManager.D0().a(requireActivity().getClassLoader(), preference.getFragment());
        a2.setArguments(extras);
        a2.setTargetFragment(this, 0);
        parentFragmentManager.s().t(((View) requireView().getParent()).getId(), a2).h((String) null).j();
        return true;
    }

    public void M(PreferenceScreen preferenceScreen) {
        boolean a2 = h0() instanceof OnPreferenceStartScreenCallback ? ((OnPreferenceStartScreenCallback) h0()).a(this, preferenceScreen) : false;
        Fragment fragment = this;
        while (!a2 && fragment != null) {
            if (fragment instanceof OnPreferenceStartScreenCallback) {
                a2 = ((OnPreferenceStartScreenCallback) fragment).a(this, preferenceScreen);
            }
            fragment = fragment.getParentFragment();
        }
        if (!a2 && (getContext() instanceof OnPreferenceStartScreenCallback)) {
            a2 = ((OnPreferenceStartScreenCallback) getContext()).a(this, preferenceScreen);
        }
        if (!a2 && (getActivity() instanceof OnPreferenceStartScreenCallback)) {
            ((OnPreferenceStartScreenCallback) getActivity()).a(this, preferenceScreen);
        }
    }

    public void g0() {
        PreferenceScreen j0 = j0();
        if (j0 != null) {
            i0().setAdapter(l0(j0));
            j0.onAttached();
        }
        k0();
    }

    public Fragment h0() {
        return null;
    }

    public final RecyclerView i0() {
        return this.c;
    }

    public PreferenceScreen j0() {
        return this.b.k();
    }

    public void k0() {
    }

    public RecyclerView.Adapter l0(PreferenceScreen preferenceScreen) {
        return new PreferenceGroupAdapter(preferenceScreen);
    }

    public RecyclerView.LayoutManager m0() {
        return new LinearLayoutManager(requireContext());
    }

    public Preference n(CharSequence charSequence) {
        PreferenceManager preferenceManager = this.b;
        if (preferenceManager == null) {
            return null;
        }
        return preferenceManager.a(charSequence);
    }

    public abstract void n0(Bundle bundle, String str);

    public RecyclerView o0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        RecyclerView recyclerView;
        if (requireContext().getPackageManager().hasSystemFeature("android.hardware.type.automotive") && (recyclerView = (RecyclerView) viewGroup.findViewById(R.id.recycler_view)) != null) {
            return recyclerView;
        }
        RecyclerView recyclerView2 = (RecyclerView) layoutInflater.inflate(R.layout.preference_recyclerview, viewGroup, false);
        recyclerView2.setLayoutManager(m0());
        recyclerView2.setAccessibilityDelegateCompat(new PreferenceRecyclerViewAccessibilityDelegate(recyclerView2));
        return recyclerView2;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        TypedValue typedValue = new TypedValue();
        requireContext().getTheme().resolveAttribute(R.attr.preferenceTheme, typedValue, true);
        int i2 = typedValue.resourceId;
        if (i2 == 0) {
            i2 = R.style.PreferenceThemeOverlay;
        }
        requireContext().getTheme().applyStyle(i2, false);
        PreferenceManager preferenceManager = new PreferenceManager(requireContext());
        this.b = preferenceManager;
        preferenceManager.n(this);
        n0(bundle, getArguments() != null ? getArguments().getString("androidx.preference.PreferenceFragmentCompat.PREFERENCE_ROOT") : null);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        TypedArray obtainStyledAttributes = requireContext().obtainStyledAttributes((AttributeSet) null, R.styleable.PreferenceFragmentCompat, R.attr.preferenceFragmentCompatStyle, 0);
        this.f = obtainStyledAttributes.getResourceId(R.styleable.PreferenceFragmentCompat_android_layout, this.f);
        Drawable drawable = obtainStyledAttributes.getDrawable(R.styleable.PreferenceFragmentCompat_android_divider);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.PreferenceFragmentCompat_android_dividerHeight, -1);
        boolean z = obtainStyledAttributes.getBoolean(R.styleable.PreferenceFragmentCompat_allowDividerAfterLastItem, true);
        obtainStyledAttributes.recycle();
        LayoutInflater cloneInContext = layoutInflater.cloneInContext(requireContext());
        View inflate = cloneInContext.inflate(this.f, viewGroup, false);
        View findViewById = inflate.findViewById(16908351);
        if (findViewById instanceof ViewGroup) {
            ViewGroup viewGroup2 = (ViewGroup) findViewById;
            RecyclerView o0 = o0(cloneInContext, viewGroup2, bundle);
            if (o0 != null) {
                this.c = o0;
                o0.addItemDecoration(this.f1672a);
                u0(drawable);
                if (dimensionPixelSize != -1) {
                    v0(dimensionPixelSize);
                }
                this.f1672a.a(z);
                if (this.c.getParent() == null) {
                    viewGroup2.addView(this.c);
                }
                this.h.post(this.i);
                return inflate;
            }
            throw new RuntimeException("Could not create RecyclerView");
        }
        throw new IllegalStateException("Content has view with id attribute 'android.R.id.list_container' that is not a ViewGroup class");
    }

    public void onDestroyView() {
        this.h.removeCallbacks(this.i);
        this.h.removeMessages(1);
        if (this.d) {
            w0();
        }
        this.c = null;
        super.onDestroyView();
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        PreferenceScreen j0 = j0();
        if (j0 != null) {
            Bundle bundle2 = new Bundle();
            j0.saveHierarchyState(bundle2);
            bundle.putBundle("android:preferences", bundle2);
        }
    }

    public void onStart() {
        super.onStart();
        this.b.o(this);
        this.b.m(this);
    }

    public void onStop() {
        super.onStop();
        this.b.o((PreferenceManager.OnPreferenceTreeClickListener) null);
        this.b.m((PreferenceManager.OnDisplayPreferenceDialogListener) null);
    }

    public void onViewCreated(View view, Bundle bundle) {
        Bundle bundle2;
        PreferenceScreen j0;
        super.onViewCreated(view, bundle);
        if (!(bundle == null || (bundle2 = bundle.getBundle("android:preferences")) == null || (j0 = j0()) == null)) {
            j0.restoreHierarchyState(bundle2);
        }
        if (this.d) {
            g0();
            Runnable runnable = this.g;
            if (runnable != null) {
                runnable.run();
                this.g = null;
            }
        }
        this.e = true;
    }

    public void s0() {
    }

    public void u0(Drawable drawable) {
        this.f1672a.setDivider(drawable);
    }

    public void v0(int i2) {
        this.f1672a.setDividerHeight(i2);
    }

    public void w(Preference preference) {
        DialogFragment dialogFragment;
        boolean a2 = h0() instanceof OnPreferenceDisplayDialogCallback ? ((OnPreferenceDisplayDialogCallback) h0()).a(this, preference) : false;
        Fragment fragment = this;
        while (!a2 && fragment != null) {
            if (fragment instanceof OnPreferenceDisplayDialogCallback) {
                a2 = ((OnPreferenceDisplayDialogCallback) fragment).a(this, preference);
            }
            fragment = fragment.getParentFragment();
        }
        if (!a2 && (getContext() instanceof OnPreferenceDisplayDialogCallback)) {
            a2 = ((OnPreferenceDisplayDialogCallback) getContext()).a(this, preference);
        }
        if (!a2 && (getActivity() instanceof OnPreferenceDisplayDialogCallback)) {
            a2 = ((OnPreferenceDisplayDialogCallback) getActivity()).a(this, preference);
        }
        if (!a2 && getParentFragmentManager().p0("androidx.preference.PreferenceFragment.DIALOG") == null) {
            if (preference instanceof EditTextPreference) {
                dialogFragment = EditTextPreferenceDialogFragmentCompat.w0(preference.getKey());
            } else if (preference instanceof ListPreference) {
                dialogFragment = ListPreferenceDialogFragmentCompat.v0(preference.getKey());
            } else if (preference instanceof MultiSelectListPreference) {
                dialogFragment = MultiSelectListPreferenceDialogFragmentCompat.v0(preference.getKey());
            } else {
                throw new IllegalArgumentException("Cannot display dialog for an unknown Preference type: " + preference.getClass().getSimpleName() + ". Make sure to implement onPreferenceDisplayDialog() to handle displaying a custom dialog for this Preference.");
            }
            dialogFragment.setTargetFragment(this, 0);
            dialogFragment.show(getParentFragmentManager(), "androidx.preference.PreferenceFragment.DIALOG");
        }
    }

    public final void w0() {
        i0().setAdapter((RecyclerView.Adapter) null);
        PreferenceScreen j0 = j0();
        if (j0 != null) {
            j0.onDetached();
        }
        s0();
    }
}
