package androidx.preference;

import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.RestrictTo;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.view.ViewCompat;
import androidx.preference.Preference;
import androidx.preference.PreferenceGroup;
import androidx.preference.PreferenceManager;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

@RestrictTo
public class PreferenceGroupAdapter extends RecyclerView.Adapter<PreferenceViewHolder> implements Preference.OnPreferenceChangeInternalListener, PreferenceGroup.PreferencePositionCallback {

    /* renamed from: a  reason: collision with root package name */
    public final PreferenceGroup f1680a;
    public List b;
    public List c;
    public final List d;
    public final Handler e;
    public final Runnable f = new Runnable() {
        public void run() {
            PreferenceGroupAdapter.this.n();
        }
    };

    public static class PreferenceResourceDescriptor {

        /* renamed from: a  reason: collision with root package name */
        public int f1684a;
        public int b;
        public String c;

        public PreferenceResourceDescriptor(Preference preference) {
            this.c = preference.getClass().getName();
            this.f1684a = preference.getLayoutResource();
            this.b = preference.getWidgetLayoutResource();
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof PreferenceResourceDescriptor)) {
                return false;
            }
            PreferenceResourceDescriptor preferenceResourceDescriptor = (PreferenceResourceDescriptor) obj;
            return this.f1684a == preferenceResourceDescriptor.f1684a && this.b == preferenceResourceDescriptor.b && TextUtils.equals(this.c, preferenceResourceDescriptor.c);
        }

        public int hashCode() {
            return ((((527 + this.f1684a) * 31) + this.b) * 31) + this.c.hashCode();
        }
    }

    public PreferenceGroupAdapter(PreferenceGroup preferenceGroup) {
        this.f1680a = preferenceGroup;
        this.e = new Handler(Looper.getMainLooper());
        preferenceGroup.setOnPreferenceChangeInternalListener(this);
        this.b = new ArrayList();
        this.c = new ArrayList();
        this.d = new ArrayList();
        if (preferenceGroup instanceof PreferenceScreen) {
            setHasStableIds(((PreferenceScreen) preferenceGroup).t());
        } else {
            setHasStableIds(true);
        }
        n();
    }

    public void a(Preference preference) {
        f(preference);
    }

    public int b(Preference preference) {
        int size = this.c.size();
        for (int i = 0; i < size; i++) {
            Preference preference2 = (Preference) this.c.get(i);
            if (preference2 != null && preference2.equals(preference)) {
                return i;
            }
        }
        return -1;
    }

    public void d(Preference preference) {
        int indexOf = this.c.indexOf(preference);
        if (indexOf != -1) {
            notifyItemChanged(indexOf, preference);
        }
    }

    public int e(String str) {
        int size = this.c.size();
        for (int i = 0; i < size; i++) {
            if (TextUtils.equals(str, ((Preference) this.c.get(i)).getKey())) {
                return i;
            }
        }
        return -1;
    }

    public void f(Preference preference) {
        this.e.removeCallbacks(this.f);
        this.e.post(this.f);
    }

    public final ExpandButton g(final PreferenceGroup preferenceGroup, List list) {
        ExpandButton expandButton = new ExpandButton(preferenceGroup.getContext(), list, preferenceGroup.getId());
        expandButton.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            public boolean a(Preference preference) {
                preferenceGroup.r(Integer.MAX_VALUE);
                PreferenceGroupAdapter.this.f(preference);
                PreferenceGroup.OnExpandButtonClickListener n = preferenceGroup.n();
                if (n == null) {
                    return true;
                }
                n.a();
                return true;
            }
        });
        return expandButton;
    }

    public int getItemCount() {
        return this.c.size();
    }

    public long getItemId(int i) {
        if (!hasStableIds()) {
            return -1;
        }
        return j(i).getId();
    }

    public int getItemViewType(int i) {
        PreferenceResourceDescriptor preferenceResourceDescriptor = new PreferenceResourceDescriptor(j(i));
        int indexOf = this.d.indexOf(preferenceResourceDescriptor);
        if (indexOf != -1) {
            return indexOf;
        }
        int size = this.d.size();
        this.d.add(preferenceResourceDescriptor);
        return size;
    }

    public final List h(PreferenceGroup preferenceGroup) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int p = preferenceGroup.p();
        int i = 0;
        for (int i2 = 0; i2 < p; i2++) {
            Preference o = preferenceGroup.o(i2);
            if (o.isVisible()) {
                if (!k(preferenceGroup) || i < preferenceGroup.m()) {
                    arrayList.add(o);
                } else {
                    arrayList2.add(o);
                }
                if (!(o instanceof PreferenceGroup)) {
                    i++;
                } else {
                    PreferenceGroup preferenceGroup2 = (PreferenceGroup) o;
                    if (!preferenceGroup2.q()) {
                        continue;
                    } else if (!k(preferenceGroup) || !k(preferenceGroup2)) {
                        for (Preference preference : h(preferenceGroup2)) {
                            if (!k(preferenceGroup) || i < preferenceGroup.m()) {
                                arrayList.add(preference);
                            } else {
                                arrayList2.add(preference);
                            }
                            i++;
                        }
                    } else {
                        throw new IllegalStateException("Nesting an expandable group inside of another expandable group is not supported!");
                    }
                }
            }
        }
        if (k(preferenceGroup) && i > preferenceGroup.m()) {
            arrayList.add(g(preferenceGroup, arrayList2));
        }
        return arrayList;
    }

    public final void i(List list, PreferenceGroup preferenceGroup) {
        preferenceGroup.s();
        int p = preferenceGroup.p();
        for (int i = 0; i < p; i++) {
            Preference o = preferenceGroup.o(i);
            list.add(o);
            PreferenceResourceDescriptor preferenceResourceDescriptor = new PreferenceResourceDescriptor(o);
            if (!this.d.contains(preferenceResourceDescriptor)) {
                this.d.add(preferenceResourceDescriptor);
            }
            if (o instanceof PreferenceGroup) {
                PreferenceGroup preferenceGroup2 = (PreferenceGroup) o;
                if (preferenceGroup2.q()) {
                    i(list, preferenceGroup2);
                }
            }
            o.setOnPreferenceChangeInternalListener(this);
        }
    }

    public Preference j(int i) {
        if (i < 0 || i >= getItemCount()) {
            return null;
        }
        return (Preference) this.c.get(i);
    }

    public final boolean k(PreferenceGroup preferenceGroup) {
        return preferenceGroup.m() != Integer.MAX_VALUE;
    }

    /* renamed from: l */
    public void onBindViewHolder(PreferenceViewHolder preferenceViewHolder, int i) {
        Preference j = j(i);
        preferenceViewHolder.d();
        j.onBindViewHolder(preferenceViewHolder);
    }

    /* renamed from: m */
    public PreferenceViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        PreferenceResourceDescriptor preferenceResourceDescriptor = (PreferenceResourceDescriptor) this.d.get(i);
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        TypedArray obtainStyledAttributes = viewGroup.getContext().obtainStyledAttributes((AttributeSet) null, R.styleable.BackgroundStyle);
        Drawable drawable = obtainStyledAttributes.getDrawable(R.styleable.BackgroundStyle_android_selectableItemBackground);
        if (drawable == null) {
            drawable = AppCompatResources.b(viewGroup.getContext(), 17301602);
        }
        obtainStyledAttributes.recycle();
        View inflate = from.inflate(preferenceResourceDescriptor.f1684a, viewGroup, false);
        if (inflate.getBackground() == null) {
            ViewCompat.z0(inflate, drawable);
        }
        ViewGroup viewGroup2 = (ViewGroup) inflate.findViewById(16908312);
        if (viewGroup2 != null) {
            int i2 = preferenceResourceDescriptor.b;
            if (i2 != 0) {
                from.inflate(i2, viewGroup2);
            } else {
                viewGroup2.setVisibility(8);
            }
        }
        return new PreferenceViewHolder(inflate);
    }

    public void n() {
        for (Preference onPreferenceChangeInternalListener : this.b) {
            onPreferenceChangeInternalListener.setOnPreferenceChangeInternalListener((Preference.OnPreferenceChangeInternalListener) null);
        }
        ArrayList arrayList = new ArrayList(this.b.size());
        this.b = arrayList;
        i(arrayList, this.f1680a);
        final List list = this.c;
        final List h = h(this.f1680a);
        this.c = h;
        PreferenceManager preferenceManager = this.f1680a.getPreferenceManager();
        if (preferenceManager == null || preferenceManager.i() == null) {
            notifyDataSetChanged();
        } else {
            final PreferenceManager.PreferenceComparisonCallback i = preferenceManager.i();
            DiffUtil.calculateDiff(new DiffUtil.Callback() {
                public boolean areContentsTheSame(int i, int i2) {
                    return i.a((Preference) list.get(i), (Preference) h.get(i2));
                }

                public boolean areItemsTheSame(int i, int i2) {
                    return i.b((Preference) list.get(i), (Preference) h.get(i2));
                }

                public int getNewListSize() {
                    return h.size();
                }

                public int getOldListSize() {
                    return list.size();
                }
            }).dispatchUpdatesTo((RecyclerView.Adapter) this);
        }
        for (Preference clearWasDetached : this.b) {
            clearWasDetached.clearWasDetached();
        }
    }
}
