package androidx.fragment.app;

import android.util.Log;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

final class FragmentManagerViewModel extends ViewModel {
    public static final ViewModelProvider.Factory h = new ViewModelProvider.Factory() {
        public ViewModel create(Class cls) {
            return new FragmentManagerViewModel(true);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public final HashMap f1296a = new HashMap();
    public final HashMap b = new HashMap();
    public final HashMap c = new HashMap();
    public final boolean d;
    public boolean e = false;
    public boolean f = false;
    public boolean g = false;

    public FragmentManagerViewModel(boolean z) {
        this.d = z;
    }

    public static FragmentManagerViewModel j(ViewModelStore viewModelStore) {
        return (FragmentManagerViewModel) new ViewModelProvider(viewModelStore, h).get(FragmentManagerViewModel.class);
    }

    public void c(Fragment fragment) {
        if (this.g) {
            if (FragmentManager.T0(2)) {
                Log.v("FragmentManager", "Ignoring addRetainedFragment as the state is already saved");
            }
        } else if (!this.f1296a.containsKey(fragment.mWho)) {
            this.f1296a.put(fragment.mWho, fragment);
            if (FragmentManager.T0(2)) {
                Log.v("FragmentManager", "Updating retained Fragments: Added " + fragment);
            }
        }
    }

    public void d(Fragment fragment, boolean z) {
        if (FragmentManager.T0(3)) {
            Log.d("FragmentManager", "Clearing non-config state for " + fragment);
        }
        f(fragment.mWho, z);
    }

    public void e(String str, boolean z) {
        if (FragmentManager.T0(3)) {
            Log.d("FragmentManager", "Clearing non-config state for saved state of Fragment " + str);
        }
        f(str, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || FragmentManagerViewModel.class != obj.getClass()) {
            return false;
        }
        FragmentManagerViewModel fragmentManagerViewModel = (FragmentManagerViewModel) obj;
        return this.f1296a.equals(fragmentManagerViewModel.f1296a) && this.b.equals(fragmentManagerViewModel.b) && this.c.equals(fragmentManagerViewModel.c);
    }

    public final void f(String str, boolean z) {
        FragmentManagerViewModel fragmentManagerViewModel = (FragmentManagerViewModel) this.b.get(str);
        if (fragmentManagerViewModel != null) {
            if (z) {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(fragmentManagerViewModel.b.keySet());
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    fragmentManagerViewModel.e((String) it.next(), true);
                }
            }
            fragmentManagerViewModel.onCleared();
            this.b.remove(str);
        }
        ViewModelStore viewModelStore = (ViewModelStore) this.c.get(str);
        if (viewModelStore != null) {
            viewModelStore.clear();
            this.c.remove(str);
        }
    }

    public Fragment g(String str) {
        return (Fragment) this.f1296a.get(str);
    }

    public FragmentManagerViewModel h(Fragment fragment) {
        FragmentManagerViewModel fragmentManagerViewModel = (FragmentManagerViewModel) this.b.get(fragment.mWho);
        if (fragmentManagerViewModel != null) {
            return fragmentManagerViewModel;
        }
        FragmentManagerViewModel fragmentManagerViewModel2 = new FragmentManagerViewModel(this.d);
        this.b.put(fragment.mWho, fragmentManagerViewModel2);
        return fragmentManagerViewModel2;
    }

    public int hashCode() {
        return (((this.f1296a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
    }

    public Collection k() {
        return new ArrayList(this.f1296a.values());
    }

    public ViewModelStore l(Fragment fragment) {
        ViewModelStore viewModelStore = (ViewModelStore) this.c.get(fragment.mWho);
        if (viewModelStore != null) {
            return viewModelStore;
        }
        ViewModelStore viewModelStore2 = new ViewModelStore();
        this.c.put(fragment.mWho, viewModelStore2);
        return viewModelStore2;
    }

    public boolean m() {
        return this.e;
    }

    public void n(Fragment fragment) {
        if (this.g) {
            if (FragmentManager.T0(2)) {
                Log.v("FragmentManager", "Ignoring removeRetainedFragment as the state is already saved");
            }
        } else if (this.f1296a.remove(fragment.mWho) != null && FragmentManager.T0(2)) {
            Log.v("FragmentManager", "Updating retained Fragments: Removed " + fragment);
        }
    }

    public void onCleared() {
        if (FragmentManager.T0(3)) {
            Log.d("FragmentManager", "onCleared called for " + this);
        }
        this.e = true;
    }

    public void p(boolean z) {
        this.g = z;
    }

    public boolean q(Fragment fragment) {
        if (!this.f1296a.containsKey(fragment.mWho)) {
            return true;
        }
        return this.d ? this.e : !this.f;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("FragmentManagerViewModel{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("} Fragments (");
        Iterator it = this.f1296a.values().iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") Child Non Config (");
        Iterator it2 = this.b.keySet().iterator();
        while (it2.hasNext()) {
            sb.append((String) it2.next());
            if (it2.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") ViewModelStores (");
        Iterator it3 = this.c.keySet().iterator();
        while (it3.hasNext()) {
            sb.append((String) it3.next());
            if (it3.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(')');
        return sb.toString();
    }
}
