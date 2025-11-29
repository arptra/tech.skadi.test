package androidx.fragment.app;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

class FragmentStore {

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList f1301a = new ArrayList();
    public final HashMap b = new HashMap();
    public final HashMap c = new HashMap();
    public FragmentManagerViewModel d;

    public void A(FragmentManagerViewModel fragmentManagerViewModel) {
        this.d = fragmentManagerViewModel;
    }

    public Bundle B(String str, Bundle bundle) {
        return bundle != null ? (Bundle) this.c.put(str, bundle) : (Bundle) this.c.remove(str);
    }

    public void a(Fragment fragment) {
        if (!this.f1301a.contains(fragment)) {
            synchronized (this.f1301a) {
                this.f1301a.add(fragment);
            }
            fragment.mAdded = true;
            return;
        }
        throw new IllegalStateException("Fragment already added: " + fragment);
    }

    public void b() {
        this.b.values().removeAll(Collections.singleton((Object) null));
    }

    public boolean c(String str) {
        return this.b.get(str) != null;
    }

    public void d(int i) {
        for (FragmentStateManager fragmentStateManager : this.b.values()) {
            if (fragmentStateManager != null) {
                fragmentStateManager.t(i);
            }
        }
    }

    public void e(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        String str2 = str + "    ";
        if (!this.b.isEmpty()) {
            printWriter.print(str);
            printWriter.println("Active Fragments:");
            for (FragmentStateManager fragmentStateManager : this.b.values()) {
                printWriter.print(str);
                if (fragmentStateManager != null) {
                    Fragment k = fragmentStateManager.k();
                    printWriter.println(k);
                    k.dump(str2, fileDescriptor, printWriter, strArr);
                } else {
                    printWriter.println("null");
                }
            }
        }
        int size = this.f1301a.size();
        if (size > 0) {
            printWriter.print(str);
            printWriter.println("Added Fragments:");
            for (int i = 0; i < size; i++) {
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i);
                printWriter.print(": ");
                printWriter.println(((Fragment) this.f1301a.get(i)).toString());
            }
        }
    }

    public Fragment f(String str) {
        FragmentStateManager fragmentStateManager = (FragmentStateManager) this.b.get(str);
        if (fragmentStateManager != null) {
            return fragmentStateManager.k();
        }
        return null;
    }

    public Fragment g(int i) {
        for (int size = this.f1301a.size() - 1; size >= 0; size--) {
            Fragment fragment = (Fragment) this.f1301a.get(size);
            if (fragment != null && fragment.mFragmentId == i) {
                return fragment;
            }
        }
        for (FragmentStateManager fragmentStateManager : this.b.values()) {
            if (fragmentStateManager != null) {
                Fragment k = fragmentStateManager.k();
                if (k.mFragmentId == i) {
                    return k;
                }
            }
        }
        return null;
    }

    public Fragment h(String str) {
        if (str != null) {
            for (int size = this.f1301a.size() - 1; size >= 0; size--) {
                Fragment fragment = (Fragment) this.f1301a.get(size);
                if (fragment != null && str.equals(fragment.mTag)) {
                    return fragment;
                }
            }
        }
        if (str == null) {
            return null;
        }
        for (FragmentStateManager fragmentStateManager : this.b.values()) {
            if (fragmentStateManager != null) {
                Fragment k = fragmentStateManager.k();
                if (str.equals(k.mTag)) {
                    return k;
                }
            }
        }
        return null;
    }

    public Fragment i(String str) {
        Fragment findFragmentByWho;
        for (FragmentStateManager fragmentStateManager : this.b.values()) {
            if (fragmentStateManager != null && (findFragmentByWho = fragmentStateManager.k().findFragmentByWho(str)) != null) {
                return findFragmentByWho;
            }
        }
        return null;
    }

    public int j(Fragment fragment) {
        View view;
        View view2;
        ViewGroup viewGroup = fragment.mContainer;
        if (viewGroup == null) {
            return -1;
        }
        int indexOf = this.f1301a.indexOf(fragment);
        for (int i = indexOf - 1; i >= 0; i--) {
            Fragment fragment2 = (Fragment) this.f1301a.get(i);
            if (fragment2.mContainer == viewGroup && (view2 = fragment2.mView) != null) {
                return viewGroup.indexOfChild(view2) + 1;
            }
        }
        while (true) {
            indexOf++;
            if (indexOf >= this.f1301a.size()) {
                return -1;
            }
            Fragment fragment3 = (Fragment) this.f1301a.get(indexOf);
            if (fragment3.mContainer == viewGroup && (view = fragment3.mView) != null) {
                return viewGroup.indexOfChild(view);
            }
        }
    }

    public List k() {
        ArrayList arrayList = new ArrayList();
        for (FragmentStateManager fragmentStateManager : this.b.values()) {
            if (fragmentStateManager != null) {
                arrayList.add(fragmentStateManager);
            }
        }
        return arrayList;
    }

    public List l() {
        ArrayList arrayList = new ArrayList();
        for (FragmentStateManager fragmentStateManager : this.b.values()) {
            if (fragmentStateManager != null) {
                arrayList.add(fragmentStateManager.k());
            } else {
                arrayList.add((Object) null);
            }
        }
        return arrayList;
    }

    public HashMap m() {
        return this.c;
    }

    public FragmentStateManager n(String str) {
        return (FragmentStateManager) this.b.get(str);
    }

    public List o() {
        ArrayList arrayList;
        if (this.f1301a.isEmpty()) {
            return Collections.emptyList();
        }
        synchronized (this.f1301a) {
            arrayList = new ArrayList(this.f1301a);
        }
        return arrayList;
    }

    public FragmentManagerViewModel p() {
        return this.d;
    }

    public Bundle q(String str) {
        return (Bundle) this.c.get(str);
    }

    public void r(FragmentStateManager fragmentStateManager) {
        Fragment k = fragmentStateManager.k();
        if (!c(k.mWho)) {
            this.b.put(k.mWho, fragmentStateManager);
            if (k.mRetainInstanceChangedWhileDetached) {
                if (k.mRetainInstance) {
                    this.d.c(k);
                } else {
                    this.d.n(k);
                }
                k.mRetainInstanceChangedWhileDetached = false;
            }
            if (FragmentManager.T0(2)) {
                Log.v("FragmentManager", "Added fragment to active set " + k);
            }
        }
    }

    public void s(FragmentStateManager fragmentStateManager) {
        Fragment k = fragmentStateManager.k();
        if (k.mRetainInstance) {
            this.d.n(k);
        }
        if (this.b.get(k.mWho) == fragmentStateManager && ((FragmentStateManager) this.b.put(k.mWho, (Object) null)) != null && FragmentManager.T0(2)) {
            Log.v("FragmentManager", "Removed fragment from active set " + k);
        }
    }

    public void t() {
        Iterator it = this.f1301a.iterator();
        while (it.hasNext()) {
            FragmentStateManager fragmentStateManager = (FragmentStateManager) this.b.get(((Fragment) it.next()).mWho);
            if (fragmentStateManager != null) {
                fragmentStateManager.m();
            }
        }
        for (FragmentStateManager fragmentStateManager2 : this.b.values()) {
            if (fragmentStateManager2 != null) {
                fragmentStateManager2.m();
                Fragment k = fragmentStateManager2.k();
                if (k.mRemoving && !k.isInBackStack()) {
                    if (k.mBeingSaved && !this.c.containsKey(k.mWho)) {
                        B(k.mWho, fragmentStateManager2.r());
                    }
                    s(fragmentStateManager2);
                }
            }
        }
    }

    public void u(Fragment fragment) {
        synchronized (this.f1301a) {
            this.f1301a.remove(fragment);
        }
        fragment.mAdded = false;
    }

    public void v() {
        this.b.clear();
    }

    public void w(List list) {
        this.f1301a.clear();
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                Fragment f = f(str);
                if (f != null) {
                    if (FragmentManager.T0(2)) {
                        Log.v("FragmentManager", "restoreSaveState: added (" + str + "): " + f);
                    }
                    a(f);
                } else {
                    throw new IllegalStateException("No instantiated fragment for (" + str + ")");
                }
            }
        }
    }

    public void x(HashMap hashMap) {
        this.c.clear();
        this.c.putAll(hashMap);
    }

    public ArrayList y() {
        ArrayList arrayList = new ArrayList(this.b.size());
        for (FragmentStateManager fragmentStateManager : this.b.values()) {
            if (fragmentStateManager != null) {
                Fragment k = fragmentStateManager.k();
                B(k.mWho, fragmentStateManager.r());
                arrayList.add(k.mWho);
                if (FragmentManager.T0(2)) {
                    Log.v("FragmentManager", "Saved state of " + k + ": " + k.mSavedFragmentState);
                }
            }
        }
        return arrayList;
    }

    public ArrayList z() {
        synchronized (this.f1301a) {
            try {
                if (this.f1301a.isEmpty()) {
                    return null;
                }
                ArrayList arrayList = new ArrayList(this.f1301a.size());
                Iterator it = this.f1301a.iterator();
                while (it.hasNext()) {
                    Fragment fragment = (Fragment) it.next();
                    arrayList.add(fragment.mWho);
                    if (FragmentManager.T0(2)) {
                        Log.v("FragmentManager", "saveAllState: adding fragment (" + fragment.mWho + "): " + fragment);
                    }
                }
                return arrayList;
            } finally {
            }
        }
    }
}
