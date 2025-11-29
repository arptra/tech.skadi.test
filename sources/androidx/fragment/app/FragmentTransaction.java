package androidx.fragment.app;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.strictmode.FragmentStrictMode;
import androidx.lifecycle.Lifecycle;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class FragmentTransaction {

    /* renamed from: a  reason: collision with root package name */
    public final FragmentFactory f1305a;
    public final ClassLoader b;
    public ArrayList c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public boolean i;
    public boolean j;
    public String k;
    public int l;
    public CharSequence m;
    public int n;
    public CharSequence o;
    public ArrayList p;
    public ArrayList q;
    public boolean r;
    public ArrayList s;

    public static final class Op {

        /* renamed from: a  reason: collision with root package name */
        public int f1306a;
        public Fragment b;
        public boolean c;
        public int d;
        public int e;
        public int f;
        public int g;
        public Lifecycle.State h;
        public Lifecycle.State i;

        public Op() {
        }

        public Op(int i2, Fragment fragment) {
            this.f1306a = i2;
            this.b = fragment;
            this.c = false;
            Lifecycle.State state = Lifecycle.State.RESUMED;
            this.h = state;
            this.i = state;
        }

        public Op(int i2, Fragment fragment, boolean z) {
            this.f1306a = i2;
            this.b = fragment;
            this.c = z;
            Lifecycle.State state = Lifecycle.State.RESUMED;
            this.h = state;
            this.i = state;
        }

        public Op(int i2, Fragment fragment, Lifecycle.State state) {
            this.f1306a = i2;
            this.b = fragment;
            this.c = false;
            this.h = fragment.mMaxState;
            this.i = state;
        }

        public Op(Op op) {
            this.f1306a = op.f1306a;
            this.b = op.b;
            this.c = op.c;
            this.d = op.d;
            this.e = op.e;
            this.f = op.f;
            this.g = op.g;
            this.h = op.h;
            this.i = op.i;
        }
    }

    public FragmentTransaction(FragmentFactory fragmentFactory, ClassLoader classLoader) {
        this.c = new ArrayList();
        this.j = true;
        this.r = false;
        this.f1305a = fragmentFactory;
        this.b = classLoader;
    }

    public FragmentTransaction A(int i2) {
        this.h = i2;
        return this;
    }

    public FragmentTransaction B(Fragment fragment) {
        f(new Op(5, fragment));
        return this;
    }

    public FragmentTransaction b(int i2, Fragment fragment) {
        p(i2, fragment, (String) null, 1);
        return this;
    }

    public FragmentTransaction c(int i2, Fragment fragment, String str) {
        p(i2, fragment, str, 1);
        return this;
    }

    public final FragmentTransaction d(ViewGroup viewGroup, Fragment fragment, String str) {
        fragment.mContainer = viewGroup;
        fragment.mInDynamicContainer = true;
        return c(viewGroup.getId(), fragment, str);
    }

    public FragmentTransaction e(Fragment fragment, String str) {
        p(0, fragment, str, 1);
        return this;
    }

    public void f(Op op) {
        this.c.add(op);
        op.d = this.d;
        op.e = this.e;
        op.f = this.f;
        op.g = this.g;
    }

    public FragmentTransaction g(View view, String str) {
        if (FragmentTransition.f()) {
            String J = ViewCompat.J(view);
            if (J != null) {
                if (this.p == null) {
                    this.p = new ArrayList();
                    this.q = new ArrayList();
                } else if (this.q.contains(str)) {
                    throw new IllegalArgumentException("A shared element with the target name '" + str + "' has already been added to the transaction.");
                } else if (this.p.contains(J)) {
                    throw new IllegalArgumentException("A shared element with the source name '" + J + "' has already been added to the transaction.");
                }
                this.p.add(J);
                this.q.add(str);
            } else {
                throw new IllegalArgumentException("Unique transitionNames are required for all sharedElements");
            }
        }
        return this;
    }

    public FragmentTransaction h(String str) {
        if (this.j) {
            this.i = true;
            this.k = str;
            return this;
        }
        throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
    }

    public FragmentTransaction i(Fragment fragment) {
        f(new Op(7, fragment));
        return this;
    }

    public abstract int j();

    public abstract int k();

    public abstract void l();

    public abstract void m();

    public FragmentTransaction n(Fragment fragment) {
        f(new Op(6, fragment));
        return this;
    }

    public FragmentTransaction o() {
        if (!this.i) {
            this.j = false;
            return this;
        }
        throw new IllegalStateException("This transaction is already being added to the back stack");
    }

    public void p(int i2, Fragment fragment, String str, int i3) {
        String str2 = fragment.mPreviousWho;
        if (str2 != null) {
            FragmentStrictMode.h(fragment, str2);
        }
        Class<?> cls = fragment.getClass();
        int modifiers = cls.getModifiers();
        if (cls.isAnonymousClass() || !Modifier.isPublic(modifiers) || (cls.isMemberClass() && !Modifier.isStatic(modifiers))) {
            throw new IllegalStateException("Fragment " + cls.getCanonicalName() + " must be a public static class to be  properly recreated from instance state.");
        }
        if (str != null) {
            String str3 = fragment.mTag;
            if (str3 == null || str.equals(str3)) {
                fragment.mTag = str;
            } else {
                throw new IllegalStateException("Can't change tag of fragment " + fragment + ": was " + fragment.mTag + " now " + str);
            }
        }
        if (i2 != 0) {
            if (i2 != -1) {
                int i4 = fragment.mFragmentId;
                if (i4 == 0 || i4 == i2) {
                    fragment.mFragmentId = i2;
                    fragment.mContainerId = i2;
                } else {
                    throw new IllegalStateException("Can't change container ID of fragment " + fragment + ": was " + fragment.mFragmentId + " now " + i2);
                }
            } else {
                throw new IllegalArgumentException("Can't add fragment " + fragment + " with tag " + str + " to container view with no id");
            }
        }
        f(new Op(i3, fragment));
    }

    public FragmentTransaction q(Fragment fragment) {
        f(new Op(4, fragment));
        return this;
    }

    public boolean r() {
        return this.c.isEmpty();
    }

    public FragmentTransaction s(Fragment fragment) {
        f(new Op(3, fragment));
        return this;
    }

    public FragmentTransaction t(int i2, Fragment fragment) {
        return u(i2, fragment, (String) null);
    }

    public FragmentTransaction u(int i2, Fragment fragment, String str) {
        if (i2 != 0) {
            p(i2, fragment, str, 2);
            return this;
        }
        throw new IllegalArgumentException("Must use non-zero containerViewId");
    }

    public FragmentTransaction v(boolean z, Runnable runnable) {
        if (!z) {
            o();
        }
        if (this.s == null) {
            this.s = new ArrayList();
        }
        this.s.add(runnable);
        return this;
    }

    public FragmentTransaction w(int i2, int i3, int i4, int i5) {
        this.d = i2;
        this.e = i3;
        this.f = i4;
        this.g = i5;
        return this;
    }

    public FragmentTransaction x(Fragment fragment, Lifecycle.State state) {
        f(new Op(10, fragment, state));
        return this;
    }

    public FragmentTransaction y(Fragment fragment) {
        f(new Op(8, fragment));
        return this;
    }

    public FragmentTransaction z(boolean z) {
        this.r = z;
        return this;
    }

    public FragmentTransaction(FragmentFactory fragmentFactory, ClassLoader classLoader, FragmentTransaction fragmentTransaction) {
        this(fragmentFactory, classLoader);
        Iterator it = fragmentTransaction.c.iterator();
        while (it.hasNext()) {
            this.c.add(new Op((Op) it.next()));
        }
        this.d = fragmentTransaction.d;
        this.e = fragmentTransaction.e;
        this.f = fragmentTransaction.f;
        this.g = fragmentTransaction.g;
        this.h = fragmentTransaction.h;
        this.i = fragmentTransaction.i;
        this.j = fragmentTransaction.j;
        this.k = fragmentTransaction.k;
        this.n = fragmentTransaction.n;
        this.o = fragmentTransaction.o;
        this.l = fragmentTransaction.l;
        this.m = fragmentTransaction.m;
        if (fragmentTransaction.p != null) {
            ArrayList arrayList = new ArrayList();
            this.p = arrayList;
            arrayList.addAll(fragmentTransaction.p);
        }
        if (fragmentTransaction.q != null) {
            ArrayList arrayList2 = new ArrayList();
            this.q = arrayList2;
            arrayList2.addAll(fragmentTransaction.q);
        }
        this.r = fragmentTransaction.r;
    }
}
