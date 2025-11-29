package androidx.fragment.app;

import android.util.Log;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import com.upuphone.ar.fastrecord.phone.ui.activity.FastRecordHistoryDetailActivity;
import java.io.PrintWriter;
import java.util.ArrayList;

final class BackStackRecord extends FragmentTransaction implements FragmentManager.BackStackEntry, FragmentManager.OpGenerator {
    public final FragmentManager t;
    public boolean u;
    public int v;
    public boolean w;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BackStackRecord(FragmentManager fragmentManager) {
        super(fragmentManager.D0(), fragmentManager.G0() != null ? fragmentManager.G0().f().getClassLoader() : null);
        this.v = -1;
        this.w = false;
        this.t = fragmentManager;
    }

    public FragmentTransaction B(Fragment fragment) {
        FragmentManager fragmentManager = fragment.mFragmentManager;
        if (fragmentManager == null || fragmentManager == this.t) {
            return super.B(fragment);
        }
        throw new IllegalStateException("Cannot show Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    public void C(int i) {
        if (this.i) {
            if (FragmentManager.T0(2)) {
                Log.v("FragmentManager", "Bump nesting in " + this + " by " + i);
            }
            int size = this.c.size();
            for (int i2 = 0; i2 < size; i2++) {
                FragmentTransaction.Op op = (FragmentTransaction.Op) this.c.get(i2);
                Fragment fragment = op.b;
                if (fragment != null) {
                    fragment.mBackStackNesting += i;
                    if (FragmentManager.T0(2)) {
                        Log.v("FragmentManager", "Bump nesting of " + op.b + " to " + op.b.mBackStackNesting);
                    }
                }
            }
        }
    }

    public void D() {
        int size = this.c.size() - 1;
        while (size >= 0) {
            FragmentTransaction.Op op = (FragmentTransaction.Op) this.c.get(size);
            if (op.c) {
                if (op.f1306a == 8) {
                    op.c = false;
                    this.c.remove(size - 1);
                    size--;
                } else {
                    int i = op.b.mContainerId;
                    op.f1306a = 2;
                    op.c = false;
                    for (int i2 = size - 1; i2 >= 0; i2--) {
                        FragmentTransaction.Op op2 = (FragmentTransaction.Op) this.c.get(i2);
                        if (op2.c && op2.b.mContainerId == i) {
                            this.c.remove(i2);
                            size--;
                        }
                    }
                }
            }
            size--;
        }
    }

    public int E(boolean z, boolean z2) {
        if (!this.u) {
            if (FragmentManager.T0(2)) {
                Log.v("FragmentManager", "Commit: " + this);
                PrintWriter printWriter = new PrintWriter(new LogWriter("FragmentManager"));
                F(FastRecordHistoryDetailActivity.TAG_SPLIT, printWriter);
                printWriter.close();
            }
            this.u = true;
            if (this.i) {
                this.v = this.t.p();
            } else {
                this.v = -1;
            }
            if (z2) {
                this.t.f0(this, z);
            }
            return this.v;
        }
        throw new IllegalStateException("commit already called");
    }

    public void F(String str, PrintWriter printWriter) {
        G(str, printWriter, true);
    }

    public void G(String str, PrintWriter printWriter, boolean z) {
        String str2;
        if (z) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.k);
            printWriter.print(" mIndex=");
            printWriter.print(this.v);
            printWriter.print(" mCommitted=");
            printWriter.println(this.u);
            if (this.h != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.h));
            }
            if (!(this.d == 0 && this.e == 0)) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.d));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.e));
            }
            if (!(this.f == 0 && this.g == 0)) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.g));
            }
            if (!(this.l == 0 && this.m == null)) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.l));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.m);
            }
            if (!(this.n == 0 && this.o == null)) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.n));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.o);
            }
        }
        if (!this.c.isEmpty()) {
            printWriter.print(str);
            printWriter.println("Operations:");
            int size = this.c.size();
            for (int i = 0; i < size; i++) {
                FragmentTransaction.Op op = (FragmentTransaction.Op) this.c.get(i);
                switch (op.f1306a) {
                    case 0:
                        str2 = "NULL";
                        break;
                    case 1:
                        str2 = "ADD";
                        break;
                    case 2:
                        str2 = "REPLACE";
                        break;
                    case 3:
                        str2 = "REMOVE";
                        break;
                    case 4:
                        str2 = "HIDE";
                        break;
                    case 5:
                        str2 = "SHOW";
                        break;
                    case 6:
                        str2 = "DETACH";
                        break;
                    case 7:
                        str2 = "ATTACH";
                        break;
                    case 8:
                        str2 = "SET_PRIMARY_NAV";
                        break;
                    case 9:
                        str2 = "UNSET_PRIMARY_NAV";
                        break;
                    case 10:
                        str2 = "OP_SET_MAX_LIFECYCLE";
                        break;
                    default:
                        str2 = "cmd=" + op.f1306a;
                        break;
                }
                printWriter.print(str);
                printWriter.print("  Op #");
                printWriter.print(i);
                printWriter.print(": ");
                printWriter.print(str2);
                printWriter.print(" ");
                printWriter.println(op.b);
                if (z) {
                    if (!(op.d == 0 && op.e == 0)) {
                        printWriter.print(str);
                        printWriter.print("enterAnim=#");
                        printWriter.print(Integer.toHexString(op.d));
                        printWriter.print(" exitAnim=#");
                        printWriter.println(Integer.toHexString(op.e));
                    }
                    if (op.f != 0 || op.g != 0) {
                        printWriter.print(str);
                        printWriter.print("popEnterAnim=#");
                        printWriter.print(Integer.toHexString(op.f));
                        printWriter.print(" popExitAnim=#");
                        printWriter.println(Integer.toHexString(op.g));
                    }
                }
            }
        }
    }

    public void H() {
        int size = this.c.size();
        for (int i = 0; i < size; i++) {
            FragmentTransaction.Op op = (FragmentTransaction.Op) this.c.get(i);
            Fragment fragment = op.b;
            if (fragment != null) {
                fragment.mBeingSaved = this.w;
                fragment.setPopDirection(false);
                fragment.setNextTransition(this.h);
                fragment.setSharedElementNames(this.p, this.q);
            }
            switch (op.f1306a) {
                case 1:
                    fragment.setAnimations(op.d, op.e, op.f, op.g);
                    this.t.N1(fragment, false);
                    this.t.l(fragment);
                    break;
                case 3:
                    fragment.setAnimations(op.d, op.e, op.f, op.g);
                    this.t.A1(fragment);
                    break;
                case 4:
                    fragment.setAnimations(op.d, op.e, op.f, op.g);
                    this.t.Q0(fragment);
                    break;
                case 5:
                    fragment.setAnimations(op.d, op.e, op.f, op.g);
                    this.t.N1(fragment, false);
                    this.t.R1(fragment);
                    break;
                case 6:
                    fragment.setAnimations(op.d, op.e, op.f, op.g);
                    this.t.D(fragment);
                    break;
                case 7:
                    fragment.setAnimations(op.d, op.e, op.f, op.g);
                    this.t.N1(fragment, false);
                    this.t.r(fragment);
                    break;
                case 8:
                    this.t.P1(fragment);
                    break;
                case 9:
                    this.t.P1((Fragment) null);
                    break;
                case 10:
                    this.t.O1(fragment, op.i);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + op.f1306a);
            }
        }
    }

    public void I() {
        for (int size = this.c.size() - 1; size >= 0; size--) {
            FragmentTransaction.Op op = (FragmentTransaction.Op) this.c.get(size);
            Fragment fragment = op.b;
            if (fragment != null) {
                fragment.mBeingSaved = this.w;
                fragment.setPopDirection(true);
                fragment.setNextTransition(FragmentManager.H1(this.h));
                fragment.setSharedElementNames(this.q, this.p);
            }
            switch (op.f1306a) {
                case 1:
                    fragment.setAnimations(op.d, op.e, op.f, op.g);
                    this.t.N1(fragment, true);
                    this.t.A1(fragment);
                    break;
                case 3:
                    fragment.setAnimations(op.d, op.e, op.f, op.g);
                    this.t.l(fragment);
                    break;
                case 4:
                    fragment.setAnimations(op.d, op.e, op.f, op.g);
                    this.t.R1(fragment);
                    break;
                case 5:
                    fragment.setAnimations(op.d, op.e, op.f, op.g);
                    this.t.N1(fragment, true);
                    this.t.Q0(fragment);
                    break;
                case 6:
                    fragment.setAnimations(op.d, op.e, op.f, op.g);
                    this.t.r(fragment);
                    break;
                case 7:
                    fragment.setAnimations(op.d, op.e, op.f, op.g);
                    this.t.N1(fragment, true);
                    this.t.D(fragment);
                    break;
                case 8:
                    this.t.P1((Fragment) null);
                    break;
                case 9:
                    this.t.P1(fragment);
                    break;
                case 10:
                    this.t.O1(fragment, op.h);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + op.f1306a);
            }
        }
    }

    public Fragment J(ArrayList arrayList, Fragment fragment) {
        ArrayList arrayList2 = arrayList;
        Fragment fragment2 = fragment;
        int i = 0;
        while (i < this.c.size()) {
            FragmentTransaction.Op op = (FragmentTransaction.Op) this.c.get(i);
            int i2 = op.f1306a;
            if (i2 != 1) {
                if (i2 == 2) {
                    Fragment fragment3 = op.b;
                    int i3 = fragment3.mContainerId;
                    boolean z = false;
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        Fragment fragment4 = (Fragment) arrayList2.get(size);
                        if (fragment4.mContainerId == i3) {
                            if (fragment4 == fragment3) {
                                z = true;
                            } else {
                                if (fragment4 == fragment2) {
                                    this.c.add(i, new FragmentTransaction.Op(9, fragment4, true));
                                    i++;
                                    fragment2 = null;
                                }
                                FragmentTransaction.Op op2 = new FragmentTransaction.Op(3, fragment4, true);
                                op2.d = op.d;
                                op2.f = op.f;
                                op2.e = op.e;
                                op2.g = op.g;
                                this.c.add(i, op2);
                                arrayList2.remove(fragment4);
                                i++;
                            }
                        }
                    }
                    if (z) {
                        this.c.remove(i);
                        i--;
                    } else {
                        op.f1306a = 1;
                        op.c = true;
                        arrayList2.add(fragment3);
                    }
                } else if (i2 == 3 || i2 == 6) {
                    arrayList2.remove(op.b);
                    Fragment fragment5 = op.b;
                    if (fragment5 == fragment2) {
                        this.c.add(i, new FragmentTransaction.Op(9, fragment5));
                        i++;
                        fragment2 = null;
                    }
                } else if (i2 != 7) {
                    if (i2 == 8) {
                        this.c.add(i, new FragmentTransaction.Op(9, fragment2, true));
                        op.c = true;
                        i++;
                        fragment2 = op.b;
                    }
                }
                i++;
            }
            arrayList2.add(op.b);
            i++;
        }
        return fragment2;
    }

    public String K() {
        return this.k;
    }

    public void L() {
        if (this.s != null) {
            for (int i = 0; i < this.s.size(); i++) {
                ((Runnable) this.s.get(i)).run();
            }
            this.s = null;
        }
    }

    public Fragment M(ArrayList arrayList, Fragment fragment) {
        for (int size = this.c.size() - 1; size >= 0; size--) {
            FragmentTransaction.Op op = (FragmentTransaction.Op) this.c.get(size);
            int i = op.f1306a;
            if (i != 1) {
                if (i != 3) {
                    switch (i) {
                        case 6:
                            break;
                        case 7:
                            break;
                        case 8:
                            fragment = null;
                            break;
                        case 9:
                            fragment = op.b;
                            break;
                        case 10:
                            op.i = op.h;
                            break;
                    }
                }
                arrayList.add(op.b);
            }
            arrayList.remove(op.b);
        }
        return fragment;
    }

    public boolean a(ArrayList arrayList, ArrayList arrayList2) {
        if (FragmentManager.T0(2)) {
            Log.v("FragmentManager", "Run: " + this);
        }
        arrayList.add(this);
        arrayList2.add(Boolean.FALSE);
        if (!this.i) {
            return true;
        }
        this.t.k(this);
        return true;
    }

    public int getId() {
        return this.v;
    }

    public int j() {
        return E(false, true);
    }

    public int k() {
        return E(true, true);
    }

    public void l() {
        o();
        this.t.i0(this, false);
    }

    public void m() {
        o();
        this.t.i0(this, true);
    }

    public FragmentTransaction n(Fragment fragment) {
        FragmentManager fragmentManager = fragment.mFragmentManager;
        if (fragmentManager == null || fragmentManager == this.t) {
            return super.n(fragment);
        }
        throw new IllegalStateException("Cannot detach Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    public void p(int i, Fragment fragment, String str, int i2) {
        super.p(i, fragment, str, i2);
        fragment.mFragmentManager = this.t;
    }

    public FragmentTransaction q(Fragment fragment) {
        FragmentManager fragmentManager = fragment.mFragmentManager;
        if (fragmentManager == null || fragmentManager == this.t) {
            return super.q(fragment);
        }
        throw new IllegalStateException("Cannot hide Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    public boolean r() {
        return this.c.isEmpty();
    }

    public FragmentTransaction s(Fragment fragment) {
        FragmentManager fragmentManager = fragment.mFragmentManager;
        if (fragmentManager == null || fragmentManager == this.t) {
            return super.s(fragment);
        }
        throw new IllegalStateException("Cannot remove Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("BackStackEntry{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.v >= 0) {
            sb.append(" #");
            sb.append(this.v);
        }
        if (this.k != null) {
            sb.append(" ");
            sb.append(this.k);
        }
        sb.append("}");
        return sb.toString();
    }

    public FragmentTransaction x(Fragment fragment, Lifecycle.State state) {
        if (fragment.mFragmentManager != this.t) {
            throw new IllegalArgumentException("Cannot setMaxLifecycle for Fragment not attached to FragmentManager " + this.t);
        } else if (state == Lifecycle.State.INITIALIZED && fragment.mState > -1) {
            throw new IllegalArgumentException("Cannot set maximum Lifecycle to " + state + " after the Fragment has been created");
        } else if (state != Lifecycle.State.DESTROYED) {
            return super.x(fragment, state);
        } else {
            throw new IllegalArgumentException("Cannot set maximum Lifecycle to " + state + ". Use remove() to remove the fragment from the FragmentManager and trigger its destruction.");
        }
    }

    public FragmentTransaction y(Fragment fragment) {
        FragmentManager fragmentManager;
        if (fragment == null || (fragmentManager = fragment.mFragmentManager) == null || fragmentManager == this.t) {
            return super.y(fragment);
        }
        throw new IllegalStateException("Cannot setPrimaryNavigation for Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BackStackRecord(BackStackRecord backStackRecord) {
        super(backStackRecord.t.D0(), backStackRecord.t.G0() != null ? backStackRecord.t.G0().f().getClassLoader() : null, backStackRecord);
        this.v = -1;
        this.w = false;
        this.t = backStackRecord.t;
        this.u = backStackRecord.u;
        this.v = backStackRecord.v;
        this.w = backStackRecord.w;
    }
}
