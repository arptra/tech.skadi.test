package androidx.preference;

import android.app.DialogFragment;
import android.app.Fragment;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.res.TypedArrayUtils;
import androidx.preference.DialogPreference;
import androidx.preference.PreferenceGroup;
import androidx.preference.PreferenceManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

@Deprecated
public abstract class PreferenceFragment extends Fragment implements PreferenceManager.OnPreferenceTreeClickListener, PreferenceManager.OnDisplayPreferenceDialogListener, PreferenceManager.OnNavigateToScreenListener, DialogPreference.TargetFragment {

    /* renamed from: a  reason: collision with root package name */
    public final DividerDecoration f1666a = new DividerDecoration();
    public PreferenceManager b;
    public RecyclerView c;
    public boolean d;
    public boolean e;
    public Context f;
    public int g = R.layout.preference_list_fragment;
    public Runnable h;
    public final Handler i = new Handler() {
        public void handleMessage(Message message) {
            if (message.what == 1) {
                PreferenceFragment.this.a();
            }
        }
    };
    public final Runnable j = new Runnable() {
        public void run() {
            RecyclerView recyclerView = PreferenceFragment.this.c;
            recyclerView.focusableViewAvailable(recyclerView);
        }
    };

    /* renamed from: androidx.preference.PreferenceFragment$3  reason: invalid class name */
    class AnonymousClass3 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Preference f1669a;
        public final /* synthetic */ String b;
        public final /* synthetic */ PreferenceFragment c;

        public void run() {
            RecyclerView.Adapter adapter = this.c.c.getAdapter();
            if (adapter instanceof PreferenceGroup.PreferencePositionCallback) {
                Preference preference = this.f1669a;
                int b2 = preference != null ? ((PreferenceGroup.PreferencePositionCallback) adapter).b(preference) : ((PreferenceGroup.PreferencePositionCallback) adapter).e(this.b);
                if (b2 != -1) {
                    this.c.c.scrollToPosition(b2);
                } else {
                    adapter.registerAdapterDataObserver(new ScrollToPreferenceObserver(adapter, this.c.c, this.f1669a, this.b));
                }
            } else if (adapter != null) {
                throw new IllegalStateException("Adapter must implement PreferencePositionCallback");
            }
        }
    }

    public class DividerDecoration extends RecyclerView.ItemDecoration {

        /* renamed from: a  reason: collision with root package name */
        public Drawable f1670a;
        public int b;
        public boolean c = true;

        public DividerDecoration() {
        }

        public void a(boolean z) {
            this.c = z;
        }

        public final boolean b(View view, RecyclerView recyclerView) {
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

        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            if (b(view, recyclerView)) {
                rect.bottom = this.b;
            }
        }

        public void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
            if (this.f1670a != null) {
                int childCount = recyclerView.getChildCount();
                int width = recyclerView.getWidth();
                for (int i = 0; i < childCount; i++) {
                    View childAt = recyclerView.getChildAt(i);
                    if (b(childAt, recyclerView)) {
                        int y = ((int) childAt.getY()) + childAt.getHeight();
                        this.f1670a.setBounds(0, y, width, this.b + y);
                        this.f1670a.draw(canvas);
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
            this.f1670a = drawable;
            PreferenceFragment.this.c.invalidateItemDecorations();
        }

        public void setDividerHeight(int i) {
            this.b = i;
            PreferenceFragment.this.c.invalidateItemDecorations();
        }
    }

    public interface OnPreferenceDisplayDialogCallback {
        boolean a(PreferenceFragment preferenceFragment, Preference preference);
    }

    public interface OnPreferenceStartFragmentCallback {
        boolean a(PreferenceFragment preferenceFragment, Preference preference);
    }

    public interface OnPreferenceStartScreenCallback {
        boolean a(PreferenceFragment preferenceFragment, PreferenceScreen preferenceScreen);
    }

    public static class ScrollToPreferenceObserver extends RecyclerView.AdapterDataObserver {

        /* renamed from: a  reason: collision with root package name */
        public final RecyclerView.Adapter f1671a;
        public final RecyclerView b;
        public final Preference c;
        public final String d;

        public ScrollToPreferenceObserver(RecyclerView.Adapter adapter, RecyclerView recyclerView, Preference preference, String str) {
            this.f1671a = adapter;
            this.b = recyclerView;
            this.c = preference;
            this.d = str;
        }

        public final void a() {
            this.f1671a.unregisterAdapterDataObserver(this);
            Preference preference = this.c;
            int b2 = preference != null ? ((PreferenceGroup.PreferencePositionCallback) this.f1671a).b(preference) : ((PreferenceGroup.PreferencePositionCallback) this.f1671a).e(this.d);
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

    private void m() {
        PreferenceScreen d2 = d();
        if (d2 != null) {
            d2.onDetached();
        }
        j();
    }

    public boolean A(Preference preference) {
        boolean z = false;
        if (preference.getFragment() == null) {
            return false;
        }
        if (b() instanceof OnPreferenceStartFragmentCallback) {
            z = ((OnPreferenceStartFragmentCallback) b()).a(this, preference);
        }
        return (z || !(getActivity() instanceof OnPreferenceStartFragmentCallback)) ? z : ((OnPreferenceStartFragmentCallback) getActivity()).a(this, preference);
    }

    public void M(PreferenceScreen preferenceScreen) {
        if (!(b() instanceof OnPreferenceStartScreenCallback ? ((OnPreferenceStartScreenCallback) b()).a(this, preferenceScreen) : false) && (getActivity() instanceof OnPreferenceStartScreenCallback)) {
            ((OnPreferenceStartScreenCallback) getActivity()).a(this, preferenceScreen);
        }
    }

    public void a() {
        PreferenceScreen d2 = d();
        if (d2 != null) {
            c().setAdapter(f(d2));
            d2.onAttached();
        }
        e();
    }

    public Fragment b() {
        return null;
    }

    public final RecyclerView c() {
        return this.c;
    }

    public PreferenceScreen d() {
        return this.b.k();
    }

    public void e() {
    }

    public RecyclerView.Adapter f(PreferenceScreen preferenceScreen) {
        return new PreferenceGroupAdapter(preferenceScreen);
    }

    public RecyclerView.LayoutManager g() {
        return new LinearLayoutManager(getActivity());
    }

    public abstract void h(Bundle bundle, String str);

    public RecyclerView i(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        RecyclerView recyclerView;
        if (this.f.getPackageManager().hasSystemFeature("android.hardware.type.automotive") && (recyclerView = (RecyclerView) viewGroup.findViewById(R.id.recycler_view)) != null) {
            return recyclerView;
        }
        RecyclerView recyclerView2 = (RecyclerView) layoutInflater.inflate(R.layout.preference_recyclerview, viewGroup, false);
        recyclerView2.setLayoutManager(g());
        recyclerView2.setAccessibilityDelegateCompat(new PreferenceRecyclerViewAccessibilityDelegate(recyclerView2));
        return recyclerView2;
    }

    public void j() {
    }

    public void k(Drawable drawable) {
        this.f1666a.setDivider(drawable);
    }

    public void l(int i2) {
        this.f1666a.setDividerHeight(i2);
    }

    public Preference n(CharSequence charSequence) {
        PreferenceManager preferenceManager = this.b;
        if (preferenceManager == null) {
            return null;
        }
        return preferenceManager.a(charSequence);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        TypedValue typedValue = new TypedValue();
        getActivity().getTheme().resolveAttribute(R.attr.preferenceTheme, typedValue, true);
        int i2 = typedValue.resourceId;
        if (i2 == 0) {
            i2 = R.style.PreferenceThemeOverlay;
        }
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(getActivity(), i2);
        this.f = contextThemeWrapper;
        PreferenceManager preferenceManager = new PreferenceManager(contextThemeWrapper);
        this.b = preferenceManager;
        preferenceManager.n(this);
        h(bundle, getArguments() != null ? getArguments().getString("androidx.preference.PreferenceFragmentCompat.PREFERENCE_ROOT") : null);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Context context = this.f;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes((AttributeSet) null, R.styleable.PreferenceFragment, TypedArrayUtils.a(context, R.attr.preferenceFragmentStyle, 16844038), 0);
        this.g = obtainStyledAttributes.getResourceId(R.styleable.PreferenceFragment_android_layout, this.g);
        Drawable drawable = obtainStyledAttributes.getDrawable(R.styleable.PreferenceFragment_android_divider);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.PreferenceFragment_android_dividerHeight, -1);
        boolean z = obtainStyledAttributes.getBoolean(R.styleable.PreferenceFragment_allowDividerAfterLastItem, true);
        obtainStyledAttributes.recycle();
        LayoutInflater cloneInContext = layoutInflater.cloneInContext(this.f);
        View inflate = cloneInContext.inflate(this.g, viewGroup, false);
        View findViewById = inflate.findViewById(16908351);
        if (findViewById instanceof ViewGroup) {
            ViewGroup viewGroup2 = (ViewGroup) findViewById;
            RecyclerView i2 = i(cloneInContext, viewGroup2, bundle);
            if (i2 != null) {
                this.c = i2;
                i2.addItemDecoration(this.f1666a);
                k(drawable);
                if (dimensionPixelSize != -1) {
                    l(dimensionPixelSize);
                }
                this.f1666a.a(z);
                if (this.c.getParent() == null) {
                    viewGroup2.addView(this.c);
                }
                this.i.post(this.j);
                return inflate;
            }
            throw new RuntimeException("Could not create RecyclerView");
        }
        throw new RuntimeException("Content has view with id attribute 'android.R.id.list_container' that is not a ViewGroup class");
    }

    public void onDestroyView() {
        this.i.removeCallbacks(this.j);
        this.i.removeMessages(1);
        if (this.d) {
            m();
        }
        this.c = null;
        super.onDestroyView();
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        PreferenceScreen d2 = d();
        if (d2 != null) {
            Bundle bundle2 = new Bundle();
            d2.saveHierarchyState(bundle2);
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
        PreferenceScreen d2;
        super.onViewCreated(view, bundle);
        if (!(bundle == null || (bundle2 = bundle.getBundle("android:preferences")) == null || (d2 = d()) == null)) {
            d2.restoreHierarchyState(bundle2);
        }
        if (this.d) {
            a();
            Runnable runnable = this.h;
            if (runnable != null) {
                runnable.run();
                this.h = null;
            }
        }
        this.e = true;
    }

    public void w(Preference preference) {
        DialogFragment dialogFragment;
        boolean a2 = b() instanceof OnPreferenceDisplayDialogCallback ? ((OnPreferenceDisplayDialogCallback) b()).a(this, preference) : false;
        if (!a2 && (getActivity() instanceof OnPreferenceDisplayDialogCallback)) {
            a2 = ((OnPreferenceDisplayDialogCallback) getActivity()).a(this, preference);
        }
        if (!a2 && getFragmentManager().findFragmentByTag("androidx.preference.PreferenceFragment.DIALOG") == null) {
            if (preference instanceof EditTextPreference) {
                dialogFragment = EditTextPreferenceDialogFragment.i(preference.getKey());
            } else if (preference instanceof ListPreference) {
                dialogFragment = ListPreferenceDialogFragment.i(preference.getKey());
            } else if (preference instanceof MultiSelectListPreference) {
                dialogFragment = MultiSelectListPreferenceDialogFragment.i(preference.getKey());
            } else {
                throw new IllegalArgumentException("Tried to display dialog for unknown preference type. Did you forget to override onDisplayPreferenceDialog()?");
            }
            dialogFragment.setTargetFragment(this, 0);
            dialogFragment.show(getFragmentManager(), "androidx.preference.PreferenceFragment.DIALOG");
        }
    }
}
