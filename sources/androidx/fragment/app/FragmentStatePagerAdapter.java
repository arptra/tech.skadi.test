package androidx.fragment.app;

import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager.widget.PagerAdapter;
import java.util.ArrayList;

@Deprecated
public abstract class FragmentStatePagerAdapter extends PagerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final FragmentManager f1300a;
    public final int b;
    public FragmentTransaction c;
    public ArrayList d;
    public ArrayList e;
    public Fragment f;
    public boolean g;

    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        Fragment fragment = (Fragment) obj;
        if (this.c == null) {
            this.c = this.f1300a.s();
        }
        while (this.d.size() <= i) {
            this.d.add((Object) null);
        }
        this.d.set(i, fragment.isAdded() ? this.f1300a.L1(fragment) : null);
        this.e.set(i, (Object) null);
        this.c.s(fragment);
        if (fragment.equals(this.f)) {
            this.f = null;
        }
    }

    /* JADX INFO: finally extract failed */
    public void finishUpdate(ViewGroup viewGroup) {
        FragmentTransaction fragmentTransaction = this.c;
        if (fragmentTransaction != null) {
            if (!this.g) {
                try {
                    this.g = true;
                    fragmentTransaction.m();
                    this.g = false;
                } catch (Throwable th) {
                    this.g = false;
                    throw th;
                }
            }
            this.c = null;
        }
    }

    public abstract Fragment getItem(int i);

    public Object instantiateItem(ViewGroup viewGroup, int i) {
        Fragment.SavedState savedState;
        Fragment fragment;
        if (this.e.size() > i && (fragment = (Fragment) this.e.get(i)) != null) {
            return fragment;
        }
        if (this.c == null) {
            this.c = this.f1300a.s();
        }
        Fragment item = getItem(i);
        if (this.d.size() > i && (savedState = (Fragment.SavedState) this.d.get(i)) != null) {
            item.setInitialSavedState(savedState);
        }
        while (this.e.size() <= i) {
            this.e.add((Object) null);
        }
        item.setMenuVisibility(false);
        if (this.b == 0) {
            item.setUserVisibleHint(false);
        }
        this.e.set(i, item);
        this.c.b(viewGroup.getId(), item);
        if (this.b == 1) {
            this.c.x(item, Lifecycle.State.STARTED);
        }
        return item;
    }

    public boolean isViewFromObject(View view, Object obj) {
        return ((Fragment) obj).getView() == view;
    }

    public void restoreState(Parcelable parcelable, ClassLoader classLoader) {
        if (parcelable != null) {
            Bundle bundle = (Bundle) parcelable;
            bundle.setClassLoader(classLoader);
            Parcelable[] parcelableArray = bundle.getParcelableArray("states");
            this.d.clear();
            this.e.clear();
            if (parcelableArray != null) {
                for (Parcelable parcelable2 : parcelableArray) {
                    this.d.add((Fragment.SavedState) parcelable2);
                }
            }
            for (String str : bundle.keySet()) {
                if (str.startsWith("f")) {
                    int parseInt = Integer.parseInt(str.substring(1));
                    Fragment B0 = this.f1300a.B0(bundle, str);
                    if (B0 != null) {
                        while (this.e.size() <= parseInt) {
                            this.e.add((Object) null);
                        }
                        B0.setMenuVisibility(false);
                        this.e.set(parseInt, B0);
                    } else {
                        Log.w("FragmentStatePagerAdapt", "Bad fragment at key " + str);
                    }
                }
            }
        }
    }

    public Parcelable saveState() {
        Bundle bundle;
        if (this.d.size() > 0) {
            bundle = new Bundle();
            Fragment.SavedState[] savedStateArr = new Fragment.SavedState[this.d.size()];
            this.d.toArray(savedStateArr);
            bundle.putParcelableArray("states", savedStateArr);
        } else {
            bundle = null;
        }
        for (int i = 0; i < this.e.size(); i++) {
            Fragment fragment = (Fragment) this.e.get(i);
            if (fragment != null && fragment.isAdded()) {
                if (bundle == null) {
                    bundle = new Bundle();
                }
                this.f1300a.y1(bundle, "f" + i, fragment);
            }
        }
        return bundle;
    }

    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        Fragment fragment = (Fragment) obj;
        Fragment fragment2 = this.f;
        if (fragment != fragment2) {
            if (fragment2 != null) {
                fragment2.setMenuVisibility(false);
                if (this.b == 1) {
                    if (this.c == null) {
                        this.c = this.f1300a.s();
                    }
                    this.c.x(this.f, Lifecycle.State.STARTED);
                } else {
                    this.f.setUserVisibleHint(false);
                }
            }
            fragment.setMenuVisibility(true);
            if (this.b == 1) {
                if (this.c == null) {
                    this.c = this.f1300a.s();
                }
                this.c.x(fragment, Lifecycle.State.RESUMED);
            } else {
                fragment.setUserVisibleHint(true);
            }
            this.f = fragment;
        }
    }

    public void startUpdate(ViewGroup viewGroup) {
        if (viewGroup.getId() == -1) {
            throw new IllegalStateException("ViewPager with adapter " + this + " requires a view id");
        }
    }
}
