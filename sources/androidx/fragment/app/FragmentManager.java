package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.activity.BackEventCompat;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.IntentSenderRequest;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.annotation.NonNull;
import androidx.core.app.MultiWindowModeChangedInfo;
import androidx.core.app.OnMultiWindowModeChangedProvider;
import androidx.core.app.OnPictureInPictureModeChangedProvider;
import androidx.core.app.PictureInPictureModeChangedInfo;
import androidx.core.content.OnConfigurationChangedProvider;
import androidx.core.content.OnTrimMemoryProvider;
import androidx.core.util.Consumer;
import androidx.core.view.MenuHost;
import androidx.core.view.MenuProvider;
import androidx.fragment.R;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.strictmode.FragmentStrictMode;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import com.honey.account.v.g;
import com.honey.account.v.h;
import com.honey.account.v.i;
import com.honey.account.v.j;
import com.honey.account.v.l;
import com.upuphone.ar.fastrecord.phone.ui.activity.FastRecordHistoryDetailActivity;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import no.nordicsemi.android.dfu.DfuBaseService;

public abstract class FragmentManager implements FragmentResultOwner {
    public static boolean U = false;
    public static boolean V = true;
    public Fragment A;
    public FragmentFactory B = null;
    public FragmentFactory C = new FragmentFactory() {
        public Fragment a(ClassLoader classLoader, String str) {
            return FragmentManager.this.G0().b(FragmentManager.this.G0().f(), str, (Bundle) null);
        }
    };
    public SpecialEffectsControllerFactory D = null;
    public SpecialEffectsControllerFactory E = new SpecialEffectsControllerFactory() {
        public SpecialEffectsController a(ViewGroup viewGroup) {
            return new DefaultSpecialEffectsController(viewGroup);
        }
    };
    public ActivityResultLauncher F;
    public ActivityResultLauncher G;
    public ActivityResultLauncher H;
    public ArrayDeque I = new ArrayDeque();
    public boolean J;
    public boolean K;
    public boolean L;
    public boolean M;
    public boolean N;
    public ArrayList O;
    public ArrayList P;
    public ArrayList Q;
    public FragmentManagerViewModel R;
    public FragmentStrictMode.Policy S;
    public Runnable T = new Runnable() {
        public void run() {
            FragmentManager.this.h0(true);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList f1280a = new ArrayList();
    public boolean b;
    public final FragmentStore c = new FragmentStore();
    public ArrayList d = new ArrayList();
    public ArrayList e;
    public final FragmentLayoutInflaterFactory f = new FragmentLayoutInflaterFactory(this);
    public OnBackPressedDispatcher g;
    public BackStackRecord h = null;
    public boolean i = false;
    public final OnBackPressedCallback j = new OnBackPressedCallback(false) {
        public void handleOnBackCancelled() {
            if (FragmentManager.T0(3)) {
                Log.d("FragmentManager", "handleOnBackCancelled. PREDICTIVE_BACK = " + FragmentManager.V + " fragment manager " + FragmentManager.this);
            }
            if (FragmentManager.V) {
                FragmentManager.this.t();
            }
        }

        public void handleOnBackPressed() {
            if (FragmentManager.T0(3)) {
                Log.d("FragmentManager", "handleOnBackPressed. PREDICTIVE_BACK = " + FragmentManager.V + " fragment manager " + FragmentManager.this);
            }
            FragmentManager.this.P0();
        }

        public void handleOnBackProgressed(BackEventCompat backEventCompat) {
            if (FragmentManager.T0(2)) {
                Log.v("FragmentManager", "handleOnBackProgressed. PREDICTIVE_BACK = " + FragmentManager.V + " fragment manager " + FragmentManager.this);
            }
            FragmentManager fragmentManager = FragmentManager.this;
            if (fragmentManager.h != null) {
                for (SpecialEffectsController A : fragmentManager.B(new ArrayList(Collections.singletonList(FragmentManager.this.h)), 0, 1)) {
                    A.A(backEventCompat);
                }
                Iterator it = FragmentManager.this.o.iterator();
                while (it.hasNext()) {
                    ((OnBackStackChangedListener) it.next()).d(backEventCompat);
                }
            }
        }

        public void handleOnBackStarted(BackEventCompat backEventCompat) {
            if (FragmentManager.T0(3)) {
                Log.d("FragmentManager", "handleOnBackStarted. PREDICTIVE_BACK = " + FragmentManager.V + " fragment manager " + FragmentManager.this);
            }
            if (FragmentManager.V) {
                FragmentManager.this.e0();
                FragmentManager.this.x1();
            }
        }
    };
    public final AtomicInteger k = new AtomicInteger();
    public final Map l = Collections.synchronizedMap(new HashMap());
    public final Map m = Collections.synchronizedMap(new HashMap());
    public final Map n = Collections.synchronizedMap(new HashMap());
    public ArrayList o = new ArrayList();
    public final FragmentLifecycleCallbacksDispatcher p = new FragmentLifecycleCallbacksDispatcher(this);
    public final CopyOnWriteArrayList q = new CopyOnWriteArrayList();
    public final Consumer r = new g(this);
    public final Consumer s = new h(this);
    public final Consumer t = new i(this);
    public final Consumer u = new j(this);
    public final MenuProvider v = new MenuProvider() {
        public void a(Menu menu, MenuInflater menuInflater) {
            FragmentManager.this.J(menu, menuInflater);
        }

        public void b(Menu menu) {
            FragmentManager.this.R(menu);
        }

        public void c(Menu menu) {
            FragmentManager.this.V(menu);
        }

        public boolean d(MenuItem menuItem) {
            return FragmentManager.this.Q(menuItem);
        }
    };
    public int w = -1;
    public FragmentHostCallback x;
    public FragmentContainer y;
    public Fragment z;

    /* renamed from: androidx.fragment.app.FragmentManager$6  reason: invalid class name */
    class AnonymousClass6 implements LifecycleEventObserver {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f1286a;
        public final /* synthetic */ FragmentResultListener b;
        public final /* synthetic */ Lifecycle c;
        public final /* synthetic */ FragmentManager d;

        public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
            Bundle bundle;
            if (event == Lifecycle.Event.ON_START && (bundle = (Bundle) this.d.m.get(this.f1286a)) != null) {
                this.b.a(this.f1286a, bundle);
                this.d.z(this.f1286a);
            }
            if (event == Lifecycle.Event.ON_DESTROY) {
                this.c.d(this);
                this.d.n.remove(this.f1286a);
            }
        }
    }

    public interface BackStackEntry {
        int getId();
    }

    public class ClearBackStackState implements OpGenerator {

        /* renamed from: a  reason: collision with root package name */
        public final String f1290a;
        public final /* synthetic */ FragmentManager b;

        public boolean a(ArrayList arrayList, ArrayList arrayList2) {
            return this.b.x(arrayList, arrayList2, this.f1290a);
        }
    }

    public static class FragmentIntentSenderContract extends ActivityResultContract<IntentSenderRequest, ActivityResult> {
        /* renamed from: d */
        public Intent a(Context context, IntentSenderRequest intentSenderRequest) {
            Bundle bundleExtra;
            Intent intent = new Intent("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST");
            Intent fillInIntent = intentSenderRequest.getFillInIntent();
            if (!(fillInIntent == null || (bundleExtra = fillInIntent.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE")) == null)) {
                intent.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundleExtra);
                fillInIntent.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
                if (fillInIntent.getBooleanExtra("androidx.fragment.extra.ACTIVITY_OPTIONS_BUNDLE", false)) {
                    intentSenderRequest = new IntentSenderRequest.Builder(intentSenderRequest.getIntentSender()).b((Intent) null).c(intentSenderRequest.getFlagsValues(), intentSenderRequest.getFlagsMask()).a();
                }
            }
            intent.putExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST", intentSenderRequest);
            if (FragmentManager.T0(2)) {
                Log.v("FragmentManager", "CreateIntent created the following intent: " + intent);
            }
            return intent;
        }

        /* renamed from: e */
        public ActivityResult c(int i, Intent intent) {
            return new ActivityResult(i, intent);
        }
    }

    public static abstract class FragmentLifecycleCallbacks {
        public void a(FragmentManager fragmentManager, Fragment fragment, Bundle bundle) {
        }

        public void b(FragmentManager fragmentManager, Fragment fragment, Context context) {
        }

        public void c(FragmentManager fragmentManager, Fragment fragment, Bundle bundle) {
        }

        public void d(FragmentManager fragmentManager, Fragment fragment) {
        }

        public void e(FragmentManager fragmentManager, Fragment fragment) {
        }

        public void f(FragmentManager fragmentManager, Fragment fragment) {
        }

        public void g(FragmentManager fragmentManager, Fragment fragment, Context context) {
        }

        public void h(FragmentManager fragmentManager, Fragment fragment, Bundle bundle) {
        }

        public void i(FragmentManager fragmentManager, Fragment fragment) {
        }

        public void j(FragmentManager fragmentManager, Fragment fragment, Bundle bundle) {
        }

        public void k(FragmentManager fragmentManager, Fragment fragment) {
        }

        public void l(FragmentManager fragmentManager, Fragment fragment) {
        }

        public void m(FragmentManager fragmentManager, Fragment fragment, View view, Bundle bundle) {
        }

        public void n(FragmentManager fragmentManager, Fragment fragment) {
        }
    }

    public static class LifecycleAwareResultListener implements FragmentResultListener {

        /* renamed from: a  reason: collision with root package name */
        public final FragmentResultListener f1291a;

        public void a(String str, Bundle bundle) {
            this.f1291a.a(str, bundle);
        }
    }

    public interface OnBackStackChangedListener {
        void a(Fragment fragment, boolean z) {
        }

        void b() {
        }

        void c();

        void d(BackEventCompat backEventCompat) {
        }

        void e(Fragment fragment, boolean z) {
        }
    }

    public interface OpGenerator {
        boolean a(ArrayList arrayList, ArrayList arrayList2);
    }

    public class PopBackStackState implements OpGenerator {

        /* renamed from: a  reason: collision with root package name */
        public final String f1292a;
        public final int b;
        public final int c;

        public PopBackStackState(String str, int i, int i2) {
            this.f1292a = str;
            this.b = i;
            this.c = i2;
        }

        public boolean a(ArrayList arrayList, ArrayList arrayList2) {
            Fragment fragment = FragmentManager.this.A;
            if (fragment != null && this.b < 0 && this.f1292a == null && fragment.getChildFragmentManager().s1()) {
                return false;
            }
            return FragmentManager.this.v1(arrayList, arrayList2, this.f1292a, this.b, this.c);
        }
    }

    public class PrepareBackStackTransitionState implements OpGenerator {
        public PrepareBackStackTransitionState() {
        }

        public boolean a(ArrayList arrayList, ArrayList arrayList2) {
            boolean w1 = FragmentManager.this.w1(arrayList, arrayList2);
            if (!FragmentManager.this.o.isEmpty() && arrayList.size() > 0) {
                boolean booleanValue = ((Boolean) arrayList2.get(arrayList.size() - 1)).booleanValue();
                LinkedHashSet<Fragment> linkedHashSet = new LinkedHashSet<>();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    linkedHashSet.addAll(FragmentManager.this.u0((BackStackRecord) it.next()));
                }
                Iterator it2 = FragmentManager.this.o.iterator();
                while (it2.hasNext()) {
                    OnBackStackChangedListener onBackStackChangedListener = (OnBackStackChangedListener) it2.next();
                    for (Fragment a2 : linkedHashSet) {
                        onBackStackChangedListener.a(a2, booleanValue);
                    }
                }
            }
            return w1;
        }
    }

    public class RestoreBackStackState implements OpGenerator {

        /* renamed from: a  reason: collision with root package name */
        public final String f1294a;

        public RestoreBackStackState(String str) {
            this.f1294a = str;
        }

        public boolean a(ArrayList arrayList, ArrayList arrayList2) {
            return FragmentManager.this.F1(arrayList, arrayList2, this.f1294a);
        }
    }

    public class SaveBackStackState implements OpGenerator {

        /* renamed from: a  reason: collision with root package name */
        public final String f1295a;

        public SaveBackStackState(String str) {
            this.f1295a = str;
        }

        public boolean a(ArrayList arrayList, ArrayList arrayList2) {
            return FragmentManager.this.K1(arrayList, arrayList2, this.f1295a);
        }
    }

    public static int H1(int i2) {
        int i3 = DfuBaseService.ERROR_FILE_NOT_FOUND;
        if (i2 == 4097) {
            return 8194;
        }
        if (i2 != 8194) {
            i3 = 8197;
            if (i2 == 8197) {
                return DfuBaseService.ERROR_FILE_IO_EXCEPTION;
            }
            if (i2 == 4099) {
                return DfuBaseService.ERROR_FILE_INVALID;
            }
            if (i2 != 4100) {
                return 0;
            }
        }
        return i3;
    }

    public static Fragment N0(View view) {
        Object tag = view.getTag(R.id.fragment_container_view_tag);
        if (tag instanceof Fragment) {
            return (Fragment) tag;
        }
        return null;
    }

    public static boolean T0(int i2) {
        return U || Log.isLoggable("FragmentManager", i2);
    }

    public static void j0(ArrayList arrayList, ArrayList arrayList2, int i2, int i3) {
        while (i2 < i3) {
            BackStackRecord backStackRecord = (BackStackRecord) arrayList.get(i2);
            if (((Boolean) arrayList2.get(i2)).booleanValue()) {
                backStackRecord.C(-1);
                backStackRecord.I();
            } else {
                backStackRecord.C(1);
                backStackRecord.H();
            }
            i2++;
        }
    }

    public static FragmentManager r0(View view) {
        FragmentActivity fragmentActivity;
        Fragment s0 = s0(view);
        if (s0 == null) {
            Context context = view.getContext();
            while (true) {
                if (!(context instanceof ContextWrapper)) {
                    fragmentActivity = null;
                    break;
                } else if (context instanceof FragmentActivity) {
                    fragmentActivity = (FragmentActivity) context;
                    break;
                } else {
                    context = ((ContextWrapper) context).getBaseContext();
                }
            }
            if (fragmentActivity != null) {
                return fragmentActivity.getSupportFragmentManager();
            }
            throw new IllegalStateException("View " + view + " is not within a subclass of FragmentActivity.");
        } else if (s0.isAdded()) {
            return s0.getChildFragmentManager();
        } else {
            throw new IllegalStateException("The Fragment " + s0 + " that owns View " + view + " has already been destroyed. Nested fragments should always use the child FragmentManager.");
        }
    }

    public static Fragment s0(View view) {
        while (view != null) {
            Fragment N0 = N0(view);
            if (N0 != null) {
                return N0;
            }
            ViewParent parent = view.getParent();
            view = parent instanceof View ? (View) parent : null;
        }
        return null;
    }

    public final Set A() {
        HashSet hashSet = new HashSet();
        for (FragmentStateManager k2 : this.c.k()) {
            ViewGroup viewGroup = k2.k().mContainer;
            if (viewGroup != null) {
                hashSet.add(SpecialEffectsController.v(viewGroup, L0()));
            }
        }
        return hashSet;
    }

    public FragmentContainer A0() {
        return this.y;
    }

    public void A1(Fragment fragment) {
        if (T0(2)) {
            Log.v("FragmentManager", "remove: " + fragment + " nesting=" + fragment.mBackStackNesting);
        }
        boolean z2 = !fragment.isInBackStack();
        if (!fragment.mDetached || z2) {
            this.c.u(fragment);
            if (U0(fragment)) {
                this.J = true;
            }
            fragment.mRemoving = true;
            Q1(fragment);
        }
    }

    public Set B(ArrayList arrayList, int i2, int i3) {
        ViewGroup viewGroup;
        HashSet hashSet = new HashSet();
        while (i2 < i3) {
            Iterator it = ((BackStackRecord) arrayList.get(i2)).c.iterator();
            while (it.hasNext()) {
                Fragment fragment = ((FragmentTransaction.Op) it.next()).b;
                if (!(fragment == null || (viewGroup = fragment.mContainer) == null)) {
                    hashSet.add(SpecialEffectsController.u(viewGroup, this));
                }
            }
            i2++;
        }
        return hashSet;
    }

    public Fragment B0(Bundle bundle, String str) {
        String string = bundle.getString(str);
        if (string == null) {
            return null;
        }
        Fragment m0 = m0(string);
        if (m0 == null) {
            T1(new IllegalStateException("Fragment no longer exists for key " + str + ": unique id " + string));
        }
        return m0;
    }

    public final void B1(ArrayList arrayList, ArrayList arrayList2) {
        if (!arrayList.isEmpty()) {
            if (arrayList.size() == arrayList2.size()) {
                int size = arrayList.size();
                int i2 = 0;
                int i3 = 0;
                while (i2 < size) {
                    if (!((BackStackRecord) arrayList.get(i2)).r) {
                        if (i3 != i2) {
                            k0(arrayList, arrayList2, i3, i2);
                        }
                        i3 = i2 + 1;
                        if (((Boolean) arrayList2.get(i2)).booleanValue()) {
                            while (i3 < size && ((Boolean) arrayList2.get(i3)).booleanValue() && !((BackStackRecord) arrayList.get(i3)).r) {
                                i3++;
                            }
                        }
                        k0(arrayList, arrayList2, i2, i3);
                        i2 = i3 - 1;
                    }
                    i2++;
                }
                if (i3 != size) {
                    k0(arrayList, arrayList2, i3, size);
                    return;
                }
                return;
            }
            throw new IllegalStateException("Internal error with the back stack records");
        }
    }

    public FragmentStateManager C(Fragment fragment) {
        FragmentStateManager n2 = this.c.n(fragment.mWho);
        if (n2 != null) {
            return n2;
        }
        FragmentStateManager fragmentStateManager = new FragmentStateManager(this.p, this.c, fragment);
        fragmentStateManager.o(this.x.f().getClassLoader());
        fragmentStateManager.t(this.w);
        return fragmentStateManager;
    }

    public final ViewGroup C0(Fragment fragment) {
        ViewGroup viewGroup = fragment.mContainer;
        if (viewGroup != null) {
            return viewGroup;
        }
        if (fragment.mContainerId > 0 && this.y.d()) {
            View c2 = this.y.c(fragment.mContainerId);
            if (c2 instanceof ViewGroup) {
                return (ViewGroup) c2;
            }
        }
        return null;
    }

    public void C1(Fragment fragment) {
        this.R.n(fragment);
    }

    public void D(Fragment fragment) {
        if (T0(2)) {
            Log.v("FragmentManager", "detach: " + fragment);
        }
        if (!fragment.mDetached) {
            fragment.mDetached = true;
            if (fragment.mAdded) {
                if (T0(2)) {
                    Log.v("FragmentManager", "remove from detach: " + fragment);
                }
                this.c.u(fragment);
                if (U0(fragment)) {
                    this.J = true;
                }
                Q1(fragment);
            }
        }
    }

    public FragmentFactory D0() {
        FragmentFactory fragmentFactory = this.B;
        if (fragmentFactory != null) {
            return fragmentFactory;
        }
        Fragment fragment = this.z;
        return fragment != null ? fragment.mFragmentManager.D0() : this.C;
    }

    public final void D1() {
        for (int i2 = 0; i2 < this.o.size(); i2++) {
            ((OnBackStackChangedListener) this.o.get(i2)).c();
        }
    }

    public void E() {
        this.K = false;
        this.L = false;
        this.R.p(false);
        Z(4);
    }

    public FragmentStore E0() {
        return this.c;
    }

    public void E1(String str) {
        f0(new RestoreBackStackState(str), false);
    }

    public void F() {
        this.K = false;
        this.L = false;
        this.R.p(false);
        Z(0);
    }

    public List F0() {
        return this.c.o();
    }

    public boolean F1(ArrayList arrayList, ArrayList arrayList2, String str) {
        BackStackState backStackState = (BackStackState) this.l.remove(str);
        if (backStackState == null) {
            return false;
        }
        HashMap hashMap = new HashMap();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            BackStackRecord backStackRecord = (BackStackRecord) it.next();
            if (backStackRecord.w) {
                Iterator it2 = backStackRecord.c.iterator();
                while (it2.hasNext()) {
                    Fragment fragment = ((FragmentTransaction.Op) it2.next()).b;
                    if (fragment != null) {
                        hashMap.put(fragment.mWho, fragment);
                    }
                }
            }
        }
        Iterator<BackStackRecord> it3 = backStackState.instantiate(this, hashMap).iterator();
        while (true) {
            boolean z2 = false;
            while (true) {
                if (!it3.hasNext()) {
                    return z2;
                }
                if (it3.next().a(arrayList, arrayList2) || z2) {
                    z2 = true;
                }
            }
        }
    }

    public void G(Configuration configuration, boolean z2) {
        if (z2 && (this.x instanceof OnConfigurationChangedProvider)) {
            T1(new IllegalStateException("Do not call dispatchConfigurationChanged() on host. Host implements OnConfigurationChangedProvider and automatically dispatches configuration changes to fragments."));
        }
        for (Fragment fragment : this.c.o()) {
            if (fragment != null) {
                fragment.performConfigurationChanged(configuration);
                if (z2) {
                    fragment.mChildFragmentManager.G(configuration, true);
                }
            }
        }
    }

    public FragmentHostCallback G0() {
        return this.x;
    }

    public void G1(Parcelable parcelable) {
        FragmentStateManager fragmentStateManager;
        Bundle bundle;
        Bundle bundle2;
        if (parcelable != null) {
            Bundle bundle3 = (Bundle) parcelable;
            for (String next : bundle3.keySet()) {
                if (next.startsWith("result_") && (bundle2 = bundle3.getBundle(next)) != null) {
                    bundle2.setClassLoader(this.x.f().getClassLoader());
                    this.m.put(next.substring(7), bundle2);
                }
            }
            HashMap hashMap = new HashMap();
            for (String next2 : bundle3.keySet()) {
                if (next2.startsWith("fragment_") && (bundle = bundle3.getBundle(next2)) != null) {
                    bundle.setClassLoader(this.x.f().getClassLoader());
                    hashMap.put(next2.substring(9), bundle);
                }
            }
            this.c.x(hashMap);
            FragmentManagerState fragmentManagerState = (FragmentManagerState) bundle3.getParcelable("state");
            if (fragmentManagerState != null) {
                this.c.v();
                Iterator<String> it = fragmentManagerState.mActive.iterator();
                while (it.hasNext()) {
                    Bundle B2 = this.c.B(it.next(), (Bundle) null);
                    if (B2 != null) {
                        Fragment g2 = this.R.g(((FragmentState) B2.getParcelable("state")).mWho);
                        if (g2 != null) {
                            if (T0(2)) {
                                Log.v("FragmentManager", "restoreSaveState: re-attaching retained " + g2);
                            }
                            fragmentStateManager = new FragmentStateManager(this.p, this.c, g2, B2);
                        } else {
                            fragmentStateManager = new FragmentStateManager(this.p, this.c, this.x.f().getClassLoader(), D0(), B2);
                        }
                        Fragment k2 = fragmentStateManager.k();
                        k2.mSavedFragmentState = B2;
                        k2.mFragmentManager = this;
                        if (T0(2)) {
                            Log.v("FragmentManager", "restoreSaveState: active (" + k2.mWho + "): " + k2);
                        }
                        fragmentStateManager.o(this.x.f().getClassLoader());
                        this.c.r(fragmentStateManager);
                        fragmentStateManager.t(this.w);
                    }
                }
                for (Fragment fragment : this.R.k()) {
                    if (!this.c.c(fragment.mWho)) {
                        if (T0(2)) {
                            Log.v("FragmentManager", "Discarding retained Fragment " + fragment + " that was not found in the set of active Fragments " + fragmentManagerState.mActive);
                        }
                        this.R.n(fragment);
                        fragment.mFragmentManager = this;
                        FragmentStateManager fragmentStateManager2 = new FragmentStateManager(this.p, this.c, fragment);
                        fragmentStateManager2.t(1);
                        fragmentStateManager2.m();
                        fragment.mRemoving = true;
                        fragmentStateManager2.m();
                    }
                }
                this.c.w(fragmentManagerState.mAdded);
                if (fragmentManagerState.mBackStack != null) {
                    this.d = new ArrayList(fragmentManagerState.mBackStack.length);
                    int i2 = 0;
                    while (true) {
                        BackStackRecordState[] backStackRecordStateArr = fragmentManagerState.mBackStack;
                        if (i2 >= backStackRecordStateArr.length) {
                            break;
                        }
                        BackStackRecord instantiate = backStackRecordStateArr[i2].instantiate(this);
                        if (T0(2)) {
                            Log.v("FragmentManager", "restoreAllState: back stack #" + i2 + " (index " + instantiate.v + "): " + instantiate);
                            PrintWriter printWriter = new PrintWriter(new LogWriter("FragmentManager"));
                            instantiate.G(FastRecordHistoryDetailActivity.TAG_SPLIT, printWriter, false);
                            printWriter.close();
                        }
                        this.d.add(instantiate);
                        i2++;
                    }
                } else {
                    this.d = new ArrayList();
                }
                this.k.set(fragmentManagerState.mBackStackIndex);
                String str = fragmentManagerState.mPrimaryNavActiveWho;
                if (str != null) {
                    Fragment m0 = m0(str);
                    this.A = m0;
                    S(m0);
                }
                ArrayList<String> arrayList = fragmentManagerState.mBackStackStateKeys;
                if (arrayList != null) {
                    for (int i3 = 0; i3 < arrayList.size(); i3++) {
                        this.l.put(arrayList.get(i3), fragmentManagerState.mBackStackStates.get(i3));
                    }
                }
                this.I = new ArrayDeque(fragmentManagerState.mLaunchedFragments);
            }
        }
    }

    public boolean H(MenuItem menuItem) {
        if (this.w < 1) {
            return false;
        }
        for (Fragment fragment : this.c.o()) {
            if (fragment != null && fragment.performContextItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public LayoutInflater.Factory2 H0() {
        return this.f;
    }

    public void I() {
        this.K = false;
        this.L = false;
        this.R.p(false);
        Z(1);
    }

    public FragmentLifecycleCallbacksDispatcher I0() {
        return this.p;
    }

    /* renamed from: I1 */
    public Bundle b1() {
        BackStackRecordState[] backStackRecordStateArr;
        Bundle bundle = new Bundle();
        t0();
        e0();
        h0(true);
        this.K = true;
        this.R.p(true);
        ArrayList<String> y2 = this.c.y();
        HashMap m2 = this.c.m();
        if (!m2.isEmpty()) {
            ArrayList<String> z2 = this.c.z();
            int size = this.d.size();
            if (size > 0) {
                backStackRecordStateArr = new BackStackRecordState[size];
                for (int i2 = 0; i2 < size; i2++) {
                    backStackRecordStateArr[i2] = new BackStackRecordState((BackStackRecord) this.d.get(i2));
                    if (T0(2)) {
                        Log.v("FragmentManager", "saveAllState: adding back stack #" + i2 + ": " + this.d.get(i2));
                    }
                }
            } else {
                backStackRecordStateArr = null;
            }
            FragmentManagerState fragmentManagerState = new FragmentManagerState();
            fragmentManagerState.mActive = y2;
            fragmentManagerState.mAdded = z2;
            fragmentManagerState.mBackStack = backStackRecordStateArr;
            fragmentManagerState.mBackStackIndex = this.k.get();
            Fragment fragment = this.A;
            if (fragment != null) {
                fragmentManagerState.mPrimaryNavActiveWho = fragment.mWho;
            }
            fragmentManagerState.mBackStackStateKeys.addAll(this.l.keySet());
            fragmentManagerState.mBackStackStates.addAll(this.l.values());
            fragmentManagerState.mLaunchedFragments = new ArrayList<>(this.I);
            bundle.putParcelable("state", fragmentManagerState);
            for (String str : this.m.keySet()) {
                bundle.putBundle("result_" + str, (Bundle) this.m.get(str));
            }
            for (String str2 : m2.keySet()) {
                bundle.putBundle("fragment_" + str2, (Bundle) m2.get(str2));
            }
        } else if (T0(2)) {
            Log.v("FragmentManager", "saveAllState: no fragments!");
        }
        return bundle;
    }

    public boolean J(Menu menu, MenuInflater menuInflater) {
        if (this.w < 1) {
            return false;
        }
        ArrayList arrayList = null;
        boolean z2 = false;
        for (Fragment fragment : this.c.o()) {
            if (fragment != null && X0(fragment) && fragment.performCreateOptionsMenu(menu, menuInflater)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(fragment);
                z2 = true;
            }
        }
        if (this.e != null) {
            for (int i2 = 0; i2 < this.e.size(); i2++) {
                Fragment fragment2 = (Fragment) this.e.get(i2);
                if (arrayList == null || !arrayList.contains(fragment2)) {
                    fragment2.onDestroyOptionsMenu();
                }
            }
        }
        this.e = arrayList;
        return z2;
    }

    public Fragment J0() {
        return this.z;
    }

    public void J1(String str) {
        f0(new SaveBackStackState(str), false);
    }

    public void K() {
        this.M = true;
        h0(true);
        e0();
        y();
        Z(-1);
        FragmentHostCallback fragmentHostCallback = this.x;
        if (fragmentHostCallback instanceof OnTrimMemoryProvider) {
            ((OnTrimMemoryProvider) fragmentHostCallback).removeOnTrimMemoryListener(this.s);
        }
        FragmentHostCallback fragmentHostCallback2 = this.x;
        if (fragmentHostCallback2 instanceof OnConfigurationChangedProvider) {
            ((OnConfigurationChangedProvider) fragmentHostCallback2).removeOnConfigurationChangedListener(this.r);
        }
        FragmentHostCallback fragmentHostCallback3 = this.x;
        if (fragmentHostCallback3 instanceof OnMultiWindowModeChangedProvider) {
            ((OnMultiWindowModeChangedProvider) fragmentHostCallback3).removeOnMultiWindowModeChangedListener(this.t);
        }
        FragmentHostCallback fragmentHostCallback4 = this.x;
        if (fragmentHostCallback4 instanceof OnPictureInPictureModeChangedProvider) {
            ((OnPictureInPictureModeChangedProvider) fragmentHostCallback4).removeOnPictureInPictureModeChangedListener(this.u);
        }
        FragmentHostCallback fragmentHostCallback5 = this.x;
        if ((fragmentHostCallback5 instanceof MenuHost) && this.z == null) {
            ((MenuHost) fragmentHostCallback5).removeMenuProvider(this.v);
        }
        this.x = null;
        this.y = null;
        this.z = null;
        if (this.g != null) {
            this.j.remove();
            this.g = null;
        }
        ActivityResultLauncher activityResultLauncher = this.F;
        if (activityResultLauncher != null) {
            activityResultLauncher.c();
            this.G.c();
            this.H.c();
        }
    }

    public Fragment K0() {
        return this.A;
    }

    public boolean K1(ArrayList arrayList, ArrayList arrayList2, String str) {
        String str2;
        int i2;
        String str3 = str;
        int n0 = n0(str3, -1, true);
        if (n0 < 0) {
            return false;
        }
        for (int i3 = n0; i3 < this.d.size(); i3++) {
            BackStackRecord backStackRecord = (BackStackRecord) this.d.get(i3);
            if (!backStackRecord.r) {
                T1(new IllegalArgumentException("saveBackStack(\"" + str3 + "\") included FragmentTransactions must use setReorderingAllowed(true) to ensure that the back stack can be restored as an atomic operation. Found " + backStackRecord + " that did not use setReorderingAllowed(true)."));
            }
        }
        HashSet hashSet = new HashSet();
        for (int i4 = n0; i4 < this.d.size(); i4++) {
            BackStackRecord backStackRecord2 = (BackStackRecord) this.d.get(i4);
            HashSet hashSet2 = new HashSet();
            HashSet hashSet3 = new HashSet();
            Iterator it = backStackRecord2.c.iterator();
            while (it.hasNext()) {
                FragmentTransaction.Op op = (FragmentTransaction.Op) it.next();
                Fragment fragment = op.b;
                if (fragment != null) {
                    if (!op.c || (i2 = op.f1306a) == 1 || i2 == 2 || i2 == 8) {
                        hashSet.add(fragment);
                        hashSet2.add(fragment);
                    }
                    int i5 = op.f1306a;
                    if (i5 == 1 || i5 == 2) {
                        hashSet3.add(fragment);
                    }
                }
            }
            hashSet2.removeAll(hashSet3);
            if (!hashSet2.isEmpty()) {
                StringBuilder sb = new StringBuilder();
                sb.append("saveBackStack(\"");
                sb.append(str3);
                sb.append("\") must be self contained and not reference fragments from non-saved FragmentTransactions. Found reference to fragment");
                if (hashSet2.size() == 1) {
                    str2 = " " + hashSet2.iterator().next();
                } else {
                    str2 = "s " + hashSet2;
                }
                sb.append(str2);
                sb.append(" in ");
                sb.append(backStackRecord2);
                sb.append(" that were previously added to the FragmentManager through a separate FragmentTransaction.");
                T1(new IllegalArgumentException(sb.toString()));
            }
        }
        ArrayDeque arrayDeque = new ArrayDeque(hashSet);
        while (!arrayDeque.isEmpty()) {
            Fragment fragment2 = (Fragment) arrayDeque.removeFirst();
            if (fragment2.mRetainInstance) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("saveBackStack(\"");
                sb2.append(str3);
                sb2.append("\") must not contain retained fragments. Found ");
                sb2.append(hashSet.contains(fragment2) ? "direct reference to retained " : "retained child ");
                sb2.append("fragment ");
                sb2.append(fragment2);
                T1(new IllegalArgumentException(sb2.toString()));
            }
            for (Fragment fragment3 : fragment2.mChildFragmentManager.w0()) {
                if (fragment3 != null) {
                    arrayDeque.addLast(fragment3);
                }
            }
        }
        ArrayList arrayList3 = new ArrayList();
        Iterator it2 = hashSet.iterator();
        while (it2.hasNext()) {
            arrayList3.add(((Fragment) it2.next()).mWho);
        }
        ArrayList arrayList4 = new ArrayList(this.d.size() - n0);
        for (int i6 = n0; i6 < this.d.size(); i6++) {
            arrayList4.add((Object) null);
        }
        BackStackState backStackState = new BackStackState(arrayList3, arrayList4);
        for (int size = this.d.size() - 1; size >= n0; size--) {
            BackStackRecord backStackRecord3 = (BackStackRecord) this.d.remove(size);
            BackStackRecord backStackRecord4 = new BackStackRecord(backStackRecord3);
            backStackRecord4.D();
            arrayList4.set(size - n0, new BackStackRecordState(backStackRecord4));
            backStackRecord3.w = true;
            arrayList.add(backStackRecord3);
            arrayList2.add(Boolean.TRUE);
        }
        this.l.put(str3, backStackState);
        return true;
    }

    public void L() {
        Z(1);
    }

    public SpecialEffectsControllerFactory L0() {
        SpecialEffectsControllerFactory specialEffectsControllerFactory = this.D;
        if (specialEffectsControllerFactory != null) {
            return specialEffectsControllerFactory;
        }
        Fragment fragment = this.z;
        return fragment != null ? fragment.mFragmentManager.L0() : this.E;
    }

    public Fragment.SavedState L1(Fragment fragment) {
        FragmentStateManager n2 = this.c.n(fragment.mWho);
        if (n2 == null || !n2.k().equals(fragment)) {
            T1(new IllegalStateException("Fragment " + fragment + " is not currently in the FragmentManager"));
        }
        return n2.q();
    }

    public void M(boolean z2) {
        if (z2 && (this.x instanceof OnTrimMemoryProvider)) {
            T1(new IllegalStateException("Do not call dispatchLowMemory() on host. Host implements OnTrimMemoryProvider and automatically dispatches low memory callbacks to fragments."));
        }
        for (Fragment fragment : this.c.o()) {
            if (fragment != null) {
                fragment.performLowMemory();
                if (z2) {
                    fragment.mChildFragmentManager.M(true);
                }
            }
        }
    }

    public FragmentStrictMode.Policy M0() {
        return this.S;
    }

    public void M1() {
        synchronized (this.f1280a) {
            try {
                if (this.f1280a.size() == 1) {
                    this.x.h().removeCallbacks(this.T);
                    this.x.h().post(this.T);
                    V1();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void N(boolean z2, boolean z3) {
        if (z3 && (this.x instanceof OnMultiWindowModeChangedProvider)) {
            T1(new IllegalStateException("Do not call dispatchMultiWindowModeChanged() on host. Host implements OnMultiWindowModeChangedProvider and automatically dispatches multi-window mode changes to fragments."));
        }
        for (Fragment fragment : this.c.o()) {
            if (fragment != null) {
                fragment.performMultiWindowModeChanged(z2);
                if (z3) {
                    fragment.mChildFragmentManager.N(z2, true);
                }
            }
        }
    }

    public void N1(Fragment fragment, boolean z2) {
        ViewGroup C0 = C0(fragment);
        if (C0 != null && (C0 instanceof FragmentContainerView)) {
            ((FragmentContainerView) C0).setDrawDisappearingViewsLast(!z2);
        }
    }

    public void O(Fragment fragment) {
        Iterator it = this.q.iterator();
        while (it.hasNext()) {
            ((FragmentOnAttachListener) it.next()).a(this, fragment);
        }
    }

    public ViewModelStore O0(Fragment fragment) {
        return this.R.l(fragment);
    }

    public void O1(Fragment fragment, Lifecycle.State state) {
        if (!fragment.equals(m0(fragment.mWho)) || !(fragment.mHost == null || fragment.mFragmentManager == this)) {
            throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
        }
        fragment.mMaxState = state;
    }

    public void P() {
        for (Fragment fragment : this.c.l()) {
            if (fragment != null) {
                fragment.onHiddenChanged(fragment.isHidden());
                fragment.mChildFragmentManager.P();
            }
        }
    }

    public void P0() {
        this.i = true;
        h0(true);
        this.i = false;
        if (V && this.h != null) {
            if (!this.o.isEmpty()) {
                LinkedHashSet<Fragment> linkedHashSet = new LinkedHashSet<>(u0(this.h));
                Iterator it = this.o.iterator();
                while (it.hasNext()) {
                    OnBackStackChangedListener onBackStackChangedListener = (OnBackStackChangedListener) it.next();
                    for (Fragment e2 : linkedHashSet) {
                        onBackStackChangedListener.e(e2, true);
                    }
                }
            }
            Iterator it2 = this.h.c.iterator();
            while (it2.hasNext()) {
                Fragment fragment = ((FragmentTransaction.Op) it2.next()).b;
                if (fragment != null) {
                    fragment.mTransitioning = false;
                }
            }
            for (SpecialEffectsController f2 : B(new ArrayList(Collections.singletonList(this.h)), 0, 1)) {
                f2.f();
            }
            Iterator it3 = this.h.c.iterator();
            while (it3.hasNext()) {
                Fragment fragment2 = ((FragmentTransaction.Op) it3.next()).b;
                if (fragment2 != null && fragment2.mContainer == null) {
                    C(fragment2).m();
                }
            }
            this.h = null;
            V1();
            if (T0(3)) {
                Log.d("FragmentManager", "Op is being set to null");
                Log.d("FragmentManager", "OnBackPressedCallback enabled=" + this.j.isEnabled() + " for  FragmentManager " + this);
            }
        } else if (this.j.isEnabled()) {
            if (T0(3)) {
                Log.d("FragmentManager", "Calling popBackStackImmediate via onBackPressed callback");
            }
            s1();
        } else {
            if (T0(3)) {
                Log.d("FragmentManager", "Calling onBackPressed via onBackPressed callback");
            }
            this.g.l();
        }
    }

    public void P1(Fragment fragment) {
        if (fragment == null || (fragment.equals(m0(fragment.mWho)) && (fragment.mHost == null || fragment.mFragmentManager == this))) {
            Fragment fragment2 = this.A;
            this.A = fragment;
            S(fragment2);
            S(this.A);
            return;
        }
        throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
    }

    public boolean Q(MenuItem menuItem) {
        if (this.w < 1) {
            return false;
        }
        for (Fragment fragment : this.c.o()) {
            if (fragment != null && fragment.performOptionsItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public void Q0(Fragment fragment) {
        if (T0(2)) {
            Log.v("FragmentManager", "hide: " + fragment);
        }
        if (!fragment.mHidden) {
            fragment.mHidden = true;
            fragment.mHiddenChanged = true ^ fragment.mHiddenChanged;
            Q1(fragment);
        }
    }

    public final void Q1(Fragment fragment) {
        ViewGroup C0 = C0(fragment);
        if (C0 != null && fragment.getEnterAnim() + fragment.getExitAnim() + fragment.getPopEnterAnim() + fragment.getPopExitAnim() > 0) {
            if (C0.getTag(R.id.visible_removing_fragment_view_tag) == null) {
                C0.setTag(R.id.visible_removing_fragment_view_tag, fragment);
            }
            ((Fragment) C0.getTag(R.id.visible_removing_fragment_view_tag)).setPopDirection(fragment.getPopDirection());
        }
    }

    public void R(Menu menu) {
        if (this.w >= 1) {
            for (Fragment fragment : this.c.o()) {
                if (fragment != null) {
                    fragment.performOptionsMenuClosed(menu);
                }
            }
        }
    }

    public void R0(Fragment fragment) {
        if (fragment.mAdded && U0(fragment)) {
            this.J = true;
        }
    }

    public void R1(Fragment fragment) {
        if (T0(2)) {
            Log.v("FragmentManager", "show: " + fragment);
        }
        if (fragment.mHidden) {
            fragment.mHidden = false;
            fragment.mHiddenChanged = !fragment.mHiddenChanged;
        }
    }

    public final void S(Fragment fragment) {
        if (fragment != null && fragment.equals(m0(fragment.mWho))) {
            fragment.performPrimaryNavigationFragmentChanged();
        }
    }

    public boolean S0() {
        return this.M;
    }

    public final void S1() {
        for (FragmentStateManager n1 : this.c.k()) {
            n1(n1);
        }
    }

    public void T() {
        Z(5);
    }

    public final void T1(RuntimeException runtimeException) {
        Log.e("FragmentManager", runtimeException.getMessage());
        Log.e("FragmentManager", "Activity state:");
        PrintWriter printWriter = new PrintWriter(new LogWriter("FragmentManager"));
        FragmentHostCallback fragmentHostCallback = this.x;
        if (fragmentHostCallback != null) {
            try {
                fragmentHostCallback.i(FastRecordHistoryDetailActivity.TAG_SPLIT, (FileDescriptor) null, printWriter, new String[0]);
            } catch (Exception e2) {
                Log.e("FragmentManager", "Failed dumping state", e2);
            }
        } else {
            try {
                d0(FastRecordHistoryDetailActivity.TAG_SPLIT, (FileDescriptor) null, printWriter, new String[0]);
            } catch (Exception e3) {
                Log.e("FragmentManager", "Failed dumping state", e3);
            }
        }
        throw runtimeException;
    }

    public void U(boolean z2, boolean z3) {
        if (z3 && (this.x instanceof OnPictureInPictureModeChangedProvider)) {
            T1(new IllegalStateException("Do not call dispatchPictureInPictureModeChanged() on host. Host implements OnPictureInPictureModeChangedProvider and automatically dispatches picture-in-picture mode changes to fragments."));
        }
        for (Fragment fragment : this.c.o()) {
            if (fragment != null) {
                fragment.performPictureInPictureModeChanged(z2);
                if (z3) {
                    fragment.mChildFragmentManager.U(z2, true);
                }
            }
        }
    }

    public final boolean U0(Fragment fragment) {
        return (fragment.mHasMenu && fragment.mMenuVisible) || fragment.mChildFragmentManager.u();
    }

    public void U1(FragmentLifecycleCallbacks fragmentLifecycleCallbacks) {
        this.p.p(fragmentLifecycleCallbacks);
    }

    public boolean V(Menu menu) {
        boolean z2 = false;
        if (this.w < 1) {
            return false;
        }
        for (Fragment fragment : this.c.o()) {
            if (fragment != null && X0(fragment) && fragment.performPrepareOptionsMenu(menu)) {
                z2 = true;
            }
        }
        return z2;
    }

    public final boolean V0() {
        Fragment fragment = this.z;
        if (fragment == null) {
            return true;
        }
        return fragment.isAdded() && this.z.getParentFragmentManager().V0();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0037, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x003d, code lost:
        if (y0() <= 0) goto L_0x0048;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0045, code lost:
        if (Y0(r4.z) == false) goto L_0x0048;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0048, code lost:
        r3 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x004d, code lost:
        if (T0(3) == false) goto L_0x006d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x004f, code lost:
        android.util.Log.d("FragmentManager", "OnBackPressedCallback for FragmentManager " + r4 + " enabled state is " + r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x006d, code lost:
        r4.j.setEnabled(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0072, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void V1() {
        /*
            r4 = this;
            java.util.ArrayList r0 = r4.f1280a
            monitor-enter(r0)
            java.util.ArrayList r1 = r4.f1280a     // Catch:{ all -> 0x0034 }
            boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x0034 }
            r2 = 3
            r3 = 1
            if (r1 != 0) goto L_0x0038
            androidx.activity.OnBackPressedCallback r1 = r4.j     // Catch:{ all -> 0x0034 }
            r1.setEnabled(r3)     // Catch:{ all -> 0x0034 }
            boolean r1 = T0(r2)     // Catch:{ all -> 0x0034 }
            if (r1 == 0) goto L_0x0036
            java.lang.String r1 = "FragmentManager"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0034 }
            r2.<init>()     // Catch:{ all -> 0x0034 }
            java.lang.String r3 = "FragmentManager "
            r2.append(r3)     // Catch:{ all -> 0x0034 }
            r2.append(r4)     // Catch:{ all -> 0x0034 }
            java.lang.String r4 = " enabling OnBackPressedCallback, caused by non-empty pending actions"
            r2.append(r4)     // Catch:{ all -> 0x0034 }
            java.lang.String r4 = r2.toString()     // Catch:{ all -> 0x0034 }
            android.util.Log.d(r1, r4)     // Catch:{ all -> 0x0034 }
            goto L_0x0036
        L_0x0034:
            r4 = move-exception
            goto L_0x0073
        L_0x0036:
            monitor-exit(r0)     // Catch:{ all -> 0x0034 }
            return
        L_0x0038:
            monitor-exit(r0)     // Catch:{ all -> 0x0034 }
            int r0 = r4.y0()
            if (r0 <= 0) goto L_0x0048
            androidx.fragment.app.Fragment r0 = r4.z
            boolean r0 = r4.Y0(r0)
            if (r0 == 0) goto L_0x0048
            goto L_0x0049
        L_0x0048:
            r3 = 0
        L_0x0049:
            boolean r0 = T0(r2)
            if (r0 == 0) goto L_0x006d
            java.lang.String r0 = "FragmentManager"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "OnBackPressedCallback for FragmentManager "
            r1.append(r2)
            r1.append(r4)
            java.lang.String r2 = " enabled state is "
            r1.append(r2)
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            android.util.Log.d(r0, r1)
        L_0x006d:
            androidx.activity.OnBackPressedCallback r4 = r4.j
            r4.setEnabled(r3)
            return
        L_0x0073:
            monitor-exit(r0)     // Catch:{ all -> 0x0034 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.FragmentManager.V1():void");
    }

    public void W() {
        V1();
        S(this.A);
    }

    public boolean W0(Fragment fragment) {
        if (fragment == null) {
            return false;
        }
        return fragment.isHidden();
    }

    public void X() {
        this.K = false;
        this.L = false;
        this.R.p(false);
        Z(7);
    }

    public boolean X0(Fragment fragment) {
        if (fragment == null) {
            return true;
        }
        return fragment.isMenuVisible();
    }

    public void Y() {
        this.K = false;
        this.L = false;
        this.R.p(false);
        Z(5);
    }

    public boolean Y0(Fragment fragment) {
        if (fragment == null) {
            return true;
        }
        FragmentManager fragmentManager = fragment.mFragmentManager;
        return fragment.equals(fragmentManager.K0()) && Y0(fragmentManager.z);
    }

    /* JADX INFO: finally extract failed */
    public final void Z(int i2) {
        try {
            this.b = true;
            this.c.d(i2);
            k1(i2, false);
            for (SpecialEffectsController q2 : A()) {
                q2.q();
            }
            this.b = false;
            h0(true);
        } catch (Throwable th) {
            this.b = false;
            throw th;
        }
    }

    public boolean Z0(int i2) {
        return this.w >= i2;
    }

    public void a0() {
        this.L = true;
        this.R.p(true);
        Z(4);
    }

    public boolean a1() {
        return this.K || this.L;
    }

    public void b0() {
        Z(2);
    }

    public final void c0() {
        if (this.N) {
            this.N = false;
            S1();
        }
    }

    public final /* synthetic */ void c1() {
        Iterator it = this.o.iterator();
        while (it.hasNext()) {
            ((OnBackStackChangedListener) it.next()).b();
        }
    }

    public void d0(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        String str2 = str + "    ";
        this.c.e(str, fileDescriptor, printWriter, strArr);
        ArrayList arrayList = this.e;
        if (arrayList != null && (size = arrayList.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Fragments Created Menus:");
            for (int i2 = 0; i2 < size; i2++) {
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i2);
                printWriter.print(": ");
                printWriter.println(((Fragment) this.e.get(i2)).toString());
            }
        }
        int size2 = this.d.size();
        if (size2 > 0) {
            printWriter.print(str);
            printWriter.println("Back Stack:");
            for (int i3 = 0; i3 < size2; i3++) {
                BackStackRecord backStackRecord = (BackStackRecord) this.d.get(i3);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i3);
                printWriter.print(": ");
                printWriter.println(backStackRecord.toString());
                backStackRecord.F(str2, printWriter);
            }
        }
        printWriter.print(str);
        printWriter.println("Back Stack Index: " + this.k.get());
        synchronized (this.f1280a) {
            try {
                int size3 = this.f1280a.size();
                if (size3 > 0) {
                    printWriter.print(str);
                    printWriter.println("Pending Actions:");
                    for (int i4 = 0; i4 < size3; i4++) {
                        printWriter.print(str);
                        printWriter.print("  #");
                        printWriter.print(i4);
                        printWriter.print(": ");
                        printWriter.println((OpGenerator) this.f1280a.get(i4));
                    }
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(this.x);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.y);
        if (this.z != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.z);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.w);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.K);
        printWriter.print(" mStopped=");
        printWriter.print(this.L);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.M);
        if (this.J) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.J);
        }
    }

    public final /* synthetic */ void d1(Configuration configuration) {
        if (V0()) {
            G(configuration, false);
        }
    }

    public final void e0() {
        for (SpecialEffectsController q2 : A()) {
            q2.q();
        }
    }

    public final /* synthetic */ void e1(Integer num) {
        if (V0() && num.intValue() == 80) {
            M(false);
        }
    }

    public void f0(OpGenerator opGenerator, boolean z2) {
        if (!z2) {
            if (this.x != null) {
                v();
            } else if (this.M) {
                throw new IllegalStateException("FragmentManager has been destroyed");
            } else {
                throw new IllegalStateException("FragmentManager has not been attached to a host.");
            }
        }
        synchronized (this.f1280a) {
            try {
                if (this.x != null) {
                    this.f1280a.add(opGenerator);
                    M1();
                } else if (!z2) {
                    throw new IllegalStateException("Activity has been destroyed");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final /* synthetic */ void f1(MultiWindowModeChangedInfo multiWindowModeChangedInfo) {
        if (V0()) {
            N(multiWindowModeChangedInfo.a(), false);
        }
    }

    public final void g0(boolean z2) {
        if (this.b) {
            throw new IllegalStateException("FragmentManager is already executing transactions");
        } else if (this.x == null) {
            if (this.M) {
                throw new IllegalStateException("FragmentManager has been destroyed");
            }
            throw new IllegalStateException("FragmentManager has not been attached to a host.");
        } else if (Looper.myLooper() == this.x.h().getLooper()) {
            if (!z2) {
                v();
            }
            if (this.O == null) {
                this.O = new ArrayList();
                this.P = new ArrayList();
            }
        } else {
            throw new IllegalStateException("Must be called from main thread of fragment host");
        }
    }

    public final /* synthetic */ void g1(PictureInPictureModeChangedInfo pictureInPictureModeChangedInfo) {
        if (V0()) {
            U(pictureInPictureModeChangedInfo.a(), false);
        }
    }

    public boolean h0(boolean z2) {
        BackStackRecord backStackRecord;
        g0(z2);
        boolean z3 = false;
        if (!this.i && (backStackRecord = this.h) != null) {
            backStackRecord.u = false;
            if (T0(3)) {
                Log.d("FragmentManager", "Reversing mTransitioningOp " + this.h + " as part of execPendingActions for actions " + this.f1280a);
            }
            this.h.E(false, false);
            this.f1280a.add(0, this.h);
            Iterator it = this.h.c.iterator();
            while (it.hasNext()) {
                Fragment fragment = ((FragmentTransaction.Op) it.next()).b;
                if (fragment != null) {
                    fragment.mTransitioning = false;
                }
            }
            this.h = null;
        }
        while (v0(this.O, this.P)) {
            z3 = true;
            this.b = true;
            try {
                B1(this.O, this.P);
            } finally {
                w();
            }
        }
        V1();
        c0();
        this.c.b();
        return z3;
    }

    public void h1(Fragment fragment, String[] strArr, int i2) {
        if (this.H != null) {
            this.I.addLast(new LaunchedFragmentInfo(fragment.mWho, i2));
            this.H.a(strArr);
            return;
        }
        this.x.l(fragment, strArr, i2);
    }

    public void i0(OpGenerator opGenerator, boolean z2) {
        if (!z2 || (this.x != null && !this.M)) {
            g0(z2);
            BackStackRecord backStackRecord = this.h;
            boolean z3 = false;
            if (backStackRecord != null) {
                backStackRecord.u = false;
                if (T0(3)) {
                    Log.d("FragmentManager", "Reversing mTransitioningOp " + this.h + " as part of execSingleAction for action " + opGenerator);
                }
                this.h.E(false, false);
                boolean a2 = this.h.a(this.O, this.P);
                Iterator it = this.h.c.iterator();
                while (it.hasNext()) {
                    Fragment fragment = ((FragmentTransaction.Op) it.next()).b;
                    if (fragment != null) {
                        fragment.mTransitioning = false;
                    }
                }
                this.h = null;
                z3 = a2;
            }
            boolean a3 = opGenerator.a(this.O, this.P);
            if (z3 || a3) {
                this.b = true;
                try {
                    B1(this.O, this.P);
                } finally {
                    w();
                }
            }
            V1();
            c0();
            this.c.b();
        }
    }

    public void i1(Fragment fragment, Intent intent, int i2, Bundle bundle) {
        if (this.F != null) {
            this.I.addLast(new LaunchedFragmentInfo(fragment.mWho, i2));
            if (bundle != null) {
                intent.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundle);
            }
            this.F.a(intent);
            return;
        }
        this.x.n(fragment, intent, i2, bundle);
    }

    public void j1(Fragment fragment, IntentSender intentSender, int i2, Intent intent, int i3, int i4, int i5, Bundle bundle) {
        Intent intent2;
        Fragment fragment2 = fragment;
        Bundle bundle2 = bundle;
        if (this.G != null) {
            if (bundle2 != null) {
                if (intent == null) {
                    intent2 = new Intent();
                    intent2.putExtra("androidx.fragment.extra.ACTIVITY_OPTIONS_BUNDLE", true);
                } else {
                    intent2 = intent;
                }
                if (T0(2)) {
                    Log.v("FragmentManager", "ActivityOptions " + bundle2 + " were added to fillInIntent " + intent2 + " for fragment " + fragment);
                }
                intent2.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundle2);
            } else {
                intent2 = intent;
            }
            IntentSender intentSender2 = intentSender;
            int i6 = i3;
            IntentSenderRequest a2 = new IntentSenderRequest.Builder(intentSender).b(intent2).c(i4, i3).a();
            int i7 = i2;
            this.I.addLast(new LaunchedFragmentInfo(fragment2.mWho, i2));
            if (T0(2)) {
                Log.v("FragmentManager", "Fragment " + fragment + "is launching an IntentSender for result ");
            }
            this.G.a(a2);
            return;
        }
        IntentSender intentSender3 = intentSender;
        int i8 = i2;
        int i9 = i4;
        this.x.o(fragment, intentSender, i2, intent, i3, i4, i5, bundle);
    }

    public void k(BackStackRecord backStackRecord) {
        this.d.add(backStackRecord);
    }

    public final void k0(ArrayList arrayList, ArrayList arrayList2, int i2, int i3) {
        boolean z2 = ((BackStackRecord) arrayList.get(i2)).r;
        ArrayList arrayList3 = this.Q;
        if (arrayList3 == null) {
            this.Q = new ArrayList();
        } else {
            arrayList3.clear();
        }
        this.Q.addAll(this.c.o());
        Fragment K0 = K0();
        boolean z3 = false;
        for (int i4 = i2; i4 < i3; i4++) {
            BackStackRecord backStackRecord = (BackStackRecord) arrayList.get(i4);
            K0 = !((Boolean) arrayList2.get(i4)).booleanValue() ? backStackRecord.J(this.Q, K0) : backStackRecord.M(this.Q, K0);
            z3 = z3 || backStackRecord.i;
        }
        this.Q.clear();
        if (!z2 && this.w >= 1) {
            for (int i5 = i2; i5 < i3; i5++) {
                Iterator it = ((BackStackRecord) arrayList.get(i5)).c.iterator();
                while (it.hasNext()) {
                    Fragment fragment = ((FragmentTransaction.Op) it.next()).b;
                    if (!(fragment == null || fragment.mFragmentManager == null)) {
                        this.c.r(C(fragment));
                    }
                }
            }
        }
        j0(arrayList, arrayList2, i2, i3);
        boolean booleanValue = ((Boolean) arrayList2.get(i3 - 1)).booleanValue();
        if (z3 && !this.o.isEmpty()) {
            LinkedHashSet<Fragment> linkedHashSet = new LinkedHashSet<>();
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                linkedHashSet.addAll(u0((BackStackRecord) it2.next()));
            }
            if (this.h == null) {
                Iterator it3 = this.o.iterator();
                while (it3.hasNext()) {
                    OnBackStackChangedListener onBackStackChangedListener = (OnBackStackChangedListener) it3.next();
                    for (Fragment a2 : linkedHashSet) {
                        onBackStackChangedListener.a(a2, booleanValue);
                    }
                }
                Iterator it4 = this.o.iterator();
                while (it4.hasNext()) {
                    OnBackStackChangedListener onBackStackChangedListener2 = (OnBackStackChangedListener) it4.next();
                    for (Fragment e2 : linkedHashSet) {
                        onBackStackChangedListener2.e(e2, booleanValue);
                    }
                }
            }
        }
        for (int i6 = i2; i6 < i3; i6++) {
            BackStackRecord backStackRecord2 = (BackStackRecord) arrayList.get(i6);
            if (booleanValue) {
                for (int size = backStackRecord2.c.size() - 1; size >= 0; size--) {
                    Fragment fragment2 = ((FragmentTransaction.Op) backStackRecord2.c.get(size)).b;
                    if (fragment2 != null) {
                        C(fragment2).m();
                    }
                }
            } else {
                Iterator it5 = backStackRecord2.c.iterator();
                while (it5.hasNext()) {
                    Fragment fragment3 = ((FragmentTransaction.Op) it5.next()).b;
                    if (fragment3 != null) {
                        C(fragment3).m();
                    }
                }
            }
        }
        k1(this.w, true);
        for (SpecialEffectsController specialEffectsController : B(arrayList, i2, i3)) {
            specialEffectsController.D(booleanValue);
            specialEffectsController.z();
            specialEffectsController.n();
        }
        while (i2 < i3) {
            BackStackRecord backStackRecord3 = (BackStackRecord) arrayList.get(i2);
            if (((Boolean) arrayList2.get(i2)).booleanValue() && backStackRecord3.v >= 0) {
                backStackRecord3.v = -1;
            }
            backStackRecord3.L();
            i2++;
        }
        if (z3) {
            D1();
        }
    }

    public void k1(int i2, boolean z2) {
        FragmentHostCallback fragmentHostCallback;
        if (this.x == null && i2 != -1) {
            throw new IllegalStateException("No activity");
        } else if (z2 || i2 != this.w) {
            this.w = i2;
            this.c.t();
            S1();
            if (this.J && (fragmentHostCallback = this.x) != null && this.w == 7) {
                fragmentHostCallback.p();
                this.J = false;
            }
        }
    }

    public FragmentStateManager l(Fragment fragment) {
        String str = fragment.mPreviousWho;
        if (str != null) {
            FragmentStrictMode.h(fragment, str);
        }
        if (T0(2)) {
            Log.v("FragmentManager", "add: " + fragment);
        }
        FragmentStateManager C2 = C(fragment);
        fragment.mFragmentManager = this;
        this.c.r(C2);
        if (!fragment.mDetached) {
            this.c.a(fragment);
            fragment.mRemoving = false;
            if (fragment.mView == null) {
                fragment.mHiddenChanged = false;
            }
            if (U0(fragment)) {
                this.J = true;
            }
        }
        return C2;
    }

    public boolean l0() {
        boolean h0 = h0(true);
        t0();
        return h0;
    }

    public void l1() {
        if (this.x != null) {
            this.K = false;
            this.L = false;
            this.R.p(false);
            for (Fragment fragment : this.c.o()) {
                if (fragment != null) {
                    fragment.noteStateNotSaved();
                }
            }
        }
    }

    public void m(FragmentOnAttachListener fragmentOnAttachListener) {
        this.q.add(fragmentOnAttachListener);
    }

    public Fragment m0(String str) {
        return this.c.f(str);
    }

    public final void m1(FragmentContainerView fragmentContainerView) {
        View view;
        for (FragmentStateManager fragmentStateManager : this.c.k()) {
            Fragment k2 = fragmentStateManager.k();
            if (k2.mContainerId == fragmentContainerView.getId() && (view = k2.mView) != null && view.getParent() == null) {
                k2.mContainer = fragmentContainerView;
                fragmentStateManager.b();
                fragmentStateManager.m();
            }
        }
    }

    public void n(OnBackStackChangedListener onBackStackChangedListener) {
        this.o.add(onBackStackChangedListener);
    }

    public final int n0(String str, int i2, boolean z2) {
        if (this.d.isEmpty()) {
            return -1;
        }
        if (str != null || i2 >= 0) {
            int size = this.d.size() - 1;
            while (size >= 0) {
                BackStackRecord backStackRecord = (BackStackRecord) this.d.get(size);
                if ((str != null && str.equals(backStackRecord.K())) || (i2 >= 0 && i2 == backStackRecord.v)) {
                    break;
                }
                size--;
            }
            if (size < 0) {
                return size;
            }
            if (z2) {
                while (size > 0) {
                    BackStackRecord backStackRecord2 = (BackStackRecord) this.d.get(size - 1);
                    if ((str == null || !str.equals(backStackRecord2.K())) && (i2 < 0 || i2 != backStackRecord2.v)) {
                        return size;
                    }
                    size--;
                }
                return size;
            } else if (size == this.d.size() - 1) {
                return -1;
            } else {
                return size + 1;
            }
        } else if (z2) {
            return 0;
        } else {
            return this.d.size() - 1;
        }
    }

    public void n1(FragmentStateManager fragmentStateManager) {
        Fragment k2 = fragmentStateManager.k();
        if (!k2.mDeferStart) {
            return;
        }
        if (this.b) {
            this.N = true;
            return;
        }
        k2.mDeferStart = false;
        fragmentStateManager.m();
    }

    public void o(Fragment fragment) {
        this.R.c(fragment);
    }

    public Fragment o0(int i2) {
        return this.c.g(i2);
    }

    public void o1() {
        f0(new PopBackStackState((String) null, -1, 0), false);
    }

    public int p() {
        return this.k.getAndIncrement();
    }

    public Fragment p0(String str) {
        return this.c.h(str);
    }

    public void p1(int i2, int i3) {
        q1(i2, i3, false);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v27, resolved type: androidx.activity.OnBackPressedDispatcherOwner} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v28, resolved type: androidx.fragment.app.Fragment} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v29, resolved type: androidx.fragment.app.Fragment} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v34, resolved type: androidx.fragment.app.Fragment} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void q(androidx.fragment.app.FragmentHostCallback r4, androidx.fragment.app.FragmentContainer r5, final androidx.fragment.app.Fragment r6) {
        /*
            r3 = this;
            androidx.fragment.app.FragmentHostCallback r0 = r3.x
            if (r0 != 0) goto L_0x016c
            r3.x = r4
            r3.y = r5
            r3.z = r6
            if (r6 == 0) goto L_0x0015
            androidx.fragment.app.FragmentManager$7 r5 = new androidx.fragment.app.FragmentManager$7
            r5.<init>(r6)
            r3.m(r5)
            goto L_0x001f
        L_0x0015:
            boolean r5 = r4 instanceof androidx.fragment.app.FragmentOnAttachListener
            if (r5 == 0) goto L_0x001f
            r5 = r4
            androidx.fragment.app.FragmentOnAttachListener r5 = (androidx.fragment.app.FragmentOnAttachListener) r5
            r3.m(r5)
        L_0x001f:
            androidx.fragment.app.Fragment r5 = r3.z
            if (r5 == 0) goto L_0x0026
            r3.V1()
        L_0x0026:
            boolean r5 = r4 instanceof androidx.activity.OnBackPressedDispatcherOwner
            if (r5 == 0) goto L_0x003b
            r5 = r4
            androidx.activity.OnBackPressedDispatcherOwner r5 = (androidx.activity.OnBackPressedDispatcherOwner) r5
            androidx.activity.OnBackPressedDispatcher r0 = r5.getOnBackPressedDispatcher()
            r3.g = r0
            if (r6 == 0) goto L_0x0036
            r5 = r6
        L_0x0036:
            androidx.activity.OnBackPressedCallback r1 = r3.j
            r0.i(r5, r1)
        L_0x003b:
            if (r6 == 0) goto L_0x0046
            androidx.fragment.app.FragmentManager r4 = r6.mFragmentManager
            androidx.fragment.app.FragmentManagerViewModel r4 = r4.z0(r6)
            r3.R = r4
            goto L_0x005f
        L_0x0046:
            boolean r5 = r4 instanceof androidx.lifecycle.ViewModelStoreOwner
            if (r5 == 0) goto L_0x0057
            androidx.lifecycle.ViewModelStoreOwner r4 = (androidx.lifecycle.ViewModelStoreOwner) r4
            androidx.lifecycle.ViewModelStore r4 = r4.getViewModelStore()
            androidx.fragment.app.FragmentManagerViewModel r4 = androidx.fragment.app.FragmentManagerViewModel.j(r4)
            r3.R = r4
            goto L_0x005f
        L_0x0057:
            androidx.fragment.app.FragmentManagerViewModel r4 = new androidx.fragment.app.FragmentManagerViewModel
            r5 = 0
            r4.<init>(r5)
            r3.R = r4
        L_0x005f:
            androidx.fragment.app.FragmentManagerViewModel r4 = r3.R
            boolean r5 = r3.a1()
            r4.p(r5)
            androidx.fragment.app.FragmentStore r4 = r3.c
            androidx.fragment.app.FragmentManagerViewModel r5 = r3.R
            r4.A(r5)
            androidx.fragment.app.FragmentHostCallback r4 = r3.x
            boolean r5 = r4 instanceof androidx.savedstate.SavedStateRegistryOwner
            if (r5 == 0) goto L_0x0090
            if (r6 != 0) goto L_0x0090
            androidx.savedstate.SavedStateRegistryOwner r4 = (androidx.savedstate.SavedStateRegistryOwner) r4
            androidx.savedstate.SavedStateRegistry r4 = r4.getSavedStateRegistry()
            com.honey.account.v.k r5 = new com.honey.account.v.k
            r5.<init>(r3)
            java.lang.String r0 = "android:support:fragments"
            r4.h(r0, r5)
            android.os.Bundle r4 = r4.b(r0)
            if (r4 == 0) goto L_0x0090
            r3.G1(r4)
        L_0x0090:
            androidx.fragment.app.FragmentHostCallback r4 = r3.x
            boolean r5 = r4 instanceof androidx.activity.result.ActivityResultRegistryOwner
            if (r5 == 0) goto L_0x0128
            androidx.activity.result.ActivityResultRegistryOwner r4 = (androidx.activity.result.ActivityResultRegistryOwner) r4
            androidx.activity.result.ActivityResultRegistry r4 = r4.getActivityResultRegistry()
            if (r6 == 0) goto L_0x00b2
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r0 = r6.mWho
            r5.append(r0)
            java.lang.String r0 = ":"
            r5.append(r0)
            java.lang.String r5 = r5.toString()
            goto L_0x00b4
        L_0x00b2:
            java.lang.String r5 = ""
        L_0x00b4:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "FragmentManager:"
            r0.append(r1)
            r0.append(r5)
            java.lang.String r5 = r0.toString()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r5)
            java.lang.String r1 = "StartActivityForResult"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            androidx.activity.result.contract.ActivityResultContracts$StartActivityForResult r1 = new androidx.activity.result.contract.ActivityResultContracts$StartActivityForResult
            r1.<init>()
            androidx.fragment.app.FragmentManager$8 r2 = new androidx.fragment.app.FragmentManager$8
            r2.<init>()
            androidx.activity.result.ActivityResultLauncher r0 = r4.l(r0, r1, r2)
            r3.F = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r5)
            java.lang.String r1 = "StartIntentSenderForResult"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            androidx.fragment.app.FragmentManager$FragmentIntentSenderContract r1 = new androidx.fragment.app.FragmentManager$FragmentIntentSenderContract
            r1.<init>()
            androidx.fragment.app.FragmentManager$9 r2 = new androidx.fragment.app.FragmentManager$9
            r2.<init>()
            androidx.activity.result.ActivityResultLauncher r0 = r4.l(r0, r1, r2)
            r3.G = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r5)
            java.lang.String r5 = "RequestPermissions"
            r0.append(r5)
            java.lang.String r5 = r0.toString()
            androidx.activity.result.contract.ActivityResultContracts$RequestMultiplePermissions r0 = new androidx.activity.result.contract.ActivityResultContracts$RequestMultiplePermissions
            r0.<init>()
            androidx.fragment.app.FragmentManager$10 r1 = new androidx.fragment.app.FragmentManager$10
            r1.<init>()
            androidx.activity.result.ActivityResultLauncher r4 = r4.l(r5, r0, r1)
            r3.H = r4
        L_0x0128:
            androidx.fragment.app.FragmentHostCallback r4 = r3.x
            boolean r5 = r4 instanceof androidx.core.content.OnConfigurationChangedProvider
            if (r5 == 0) goto L_0x0135
            androidx.core.content.OnConfigurationChangedProvider r4 = (androidx.core.content.OnConfigurationChangedProvider) r4
            androidx.core.util.Consumer r5 = r3.r
            r4.addOnConfigurationChangedListener(r5)
        L_0x0135:
            androidx.fragment.app.FragmentHostCallback r4 = r3.x
            boolean r5 = r4 instanceof androidx.core.content.OnTrimMemoryProvider
            if (r5 == 0) goto L_0x0142
            androidx.core.content.OnTrimMemoryProvider r4 = (androidx.core.content.OnTrimMemoryProvider) r4
            androidx.core.util.Consumer r5 = r3.s
            r4.addOnTrimMemoryListener(r5)
        L_0x0142:
            androidx.fragment.app.FragmentHostCallback r4 = r3.x
            boolean r5 = r4 instanceof androidx.core.app.OnMultiWindowModeChangedProvider
            if (r5 == 0) goto L_0x014f
            androidx.core.app.OnMultiWindowModeChangedProvider r4 = (androidx.core.app.OnMultiWindowModeChangedProvider) r4
            androidx.core.util.Consumer r5 = r3.t
            r4.addOnMultiWindowModeChangedListener(r5)
        L_0x014f:
            androidx.fragment.app.FragmentHostCallback r4 = r3.x
            boolean r5 = r4 instanceof androidx.core.app.OnPictureInPictureModeChangedProvider
            if (r5 == 0) goto L_0x015c
            androidx.core.app.OnPictureInPictureModeChangedProvider r4 = (androidx.core.app.OnPictureInPictureModeChangedProvider) r4
            androidx.core.util.Consumer r5 = r3.u
            r4.addOnPictureInPictureModeChangedListener(r5)
        L_0x015c:
            androidx.fragment.app.FragmentHostCallback r4 = r3.x
            boolean r5 = r4 instanceof androidx.core.view.MenuHost
            if (r5 == 0) goto L_0x016b
            if (r6 != 0) goto L_0x016b
            androidx.core.view.MenuHost r4 = (androidx.core.view.MenuHost) r4
            androidx.core.view.MenuProvider r3 = r3.v
            r4.addMenuProvider(r3)
        L_0x016b:
            return
        L_0x016c:
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
            java.lang.String r4 = "Already attached"
            r3.<init>(r4)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.FragmentManager.q(androidx.fragment.app.FragmentHostCallback, androidx.fragment.app.FragmentContainer, androidx.fragment.app.Fragment):void");
    }

    public Fragment q0(String str) {
        return this.c.i(str);
    }

    public void q1(int i2, int i3, boolean z2) {
        if (i2 >= 0) {
            f0(new PopBackStackState((String) null, i2, i3), z2);
            return;
        }
        throw new IllegalArgumentException("Bad id: " + i2);
    }

    public void r(Fragment fragment) {
        if (T0(2)) {
            Log.v("FragmentManager", "attach: " + fragment);
        }
        if (fragment.mDetached) {
            fragment.mDetached = false;
            if (!fragment.mAdded) {
                this.c.a(fragment);
                if (T0(2)) {
                    Log.v("FragmentManager", "add from attach: " + fragment);
                }
                if (U0(fragment)) {
                    this.J = true;
                }
            }
        }
    }

    public void r1(String str, int i2) {
        f0(new PopBackStackState(str, -1, i2), false);
    }

    public FragmentTransaction s() {
        return new BackStackRecord(this);
    }

    public boolean s1() {
        return u1((String) null, -1, 0);
    }

    public void t() {
        if (T0(3)) {
            Log.d("FragmentManager", "cancelBackStackTransition for transition " + this.h);
        }
        BackStackRecord backStackRecord = this.h;
        if (backStackRecord != null) {
            backStackRecord.u = false;
            backStackRecord.v(true, new l(this));
            this.h.j();
            this.i = true;
            l0();
            this.i = false;
            this.h = null;
        }
    }

    public final void t0() {
        for (SpecialEffectsController r2 : A()) {
            r2.r();
        }
    }

    public boolean t1(int i2, int i3) {
        if (i2 >= 0) {
            return u1((String) null, i2, i3);
        }
        throw new IllegalArgumentException("Bad id: " + i2);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        Fragment fragment = this.z;
        if (fragment != null) {
            sb.append(fragment.getClass().getSimpleName());
            sb.append("{");
            sb.append(Integer.toHexString(System.identityHashCode(this.z)));
            sb.append("}");
        } else {
            FragmentHostCallback fragmentHostCallback = this.x;
            if (fragmentHostCallback != null) {
                sb.append(fragmentHostCallback.getClass().getSimpleName());
                sb.append("{");
                sb.append(Integer.toHexString(System.identityHashCode(this.x)));
                sb.append("}");
            } else {
                sb.append("null");
            }
        }
        sb.append("}}");
        return sb.toString();
    }

    public boolean u() {
        boolean z2 = false;
        for (Fragment fragment : this.c.l()) {
            if (fragment != null) {
                z2 = U0(fragment);
                continue;
            }
            if (z2) {
                return true;
            }
        }
        return false;
    }

    public Set u0(BackStackRecord backStackRecord) {
        HashSet hashSet = new HashSet();
        for (int i2 = 0; i2 < backStackRecord.c.size(); i2++) {
            Fragment fragment = ((FragmentTransaction.Op) backStackRecord.c.get(i2)).b;
            if (fragment != null && backStackRecord.i) {
                hashSet.add(fragment);
            }
        }
        return hashSet;
    }

    public final boolean u1(String str, int i2, int i3) {
        h0(false);
        g0(true);
        Fragment fragment = this.A;
        if (fragment != null && i2 < 0 && str == null && fragment.getChildFragmentManager().s1()) {
            return true;
        }
        boolean v1 = v1(this.O, this.P, str, i2, i3);
        if (v1) {
            this.b = true;
            try {
                B1(this.O, this.P);
            } finally {
                w();
            }
        }
        V1();
        c0();
        this.c.b();
        return v1;
    }

    public final void v() {
        if (a1()) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
    }

    public final boolean v0(ArrayList arrayList, ArrayList arrayList2) {
        synchronized (this.f1280a) {
            if (this.f1280a.isEmpty()) {
                return false;
            }
            try {
                int size = this.f1280a.size();
                boolean z2 = false;
                for (int i2 = 0; i2 < size; i2++) {
                    z2 |= ((OpGenerator) this.f1280a.get(i2)).a(arrayList, arrayList2);
                }
                return z2;
            } finally {
                this.f1280a.clear();
                this.x.h().removeCallbacks(this.T);
            }
        }
    }

    public boolean v1(ArrayList arrayList, ArrayList arrayList2, String str, int i2, int i3) {
        int n0 = n0(str, i2, (i3 & 1) != 0);
        if (n0 < 0) {
            return false;
        }
        for (int size = this.d.size() - 1; size >= n0; size--) {
            arrayList.add((BackStackRecord) this.d.remove(size));
            arrayList2.add(Boolean.TRUE);
        }
        return true;
    }

    public final void w() {
        this.b = false;
        this.P.clear();
        this.O.clear();
    }

    public List w0() {
        return this.c.l();
    }

    public boolean w1(ArrayList arrayList, ArrayList arrayList2) {
        if (T0(2)) {
            Log.v("FragmentManager", "FragmentManager has the following pending actions inside of prepareBackStackState: " + this.f1280a);
        }
        if (this.d.isEmpty()) {
            Log.i("FragmentManager", "Ignoring call to start back stack pop because the back stack is empty.");
            return false;
        }
        ArrayList arrayList3 = this.d;
        BackStackRecord backStackRecord = (BackStackRecord) arrayList3.get(arrayList3.size() - 1);
        this.h = backStackRecord;
        Iterator it = backStackRecord.c.iterator();
        while (it.hasNext()) {
            Fragment fragment = ((FragmentTransaction.Op) it.next()).b;
            if (fragment != null) {
                fragment.mTransitioning = true;
            }
        }
        return v1(arrayList, arrayList2, (String) null, -1, 0);
    }

    public boolean x(ArrayList arrayList, ArrayList arrayList2, String str) {
        if (!F1(arrayList, arrayList2, str)) {
            return false;
        }
        return v1(arrayList, arrayList2, str, -1, 1);
    }

    public BackStackEntry x0(int i2) {
        if (i2 != this.d.size()) {
            return (BackStackEntry) this.d.get(i2);
        }
        BackStackRecord backStackRecord = this.h;
        if (backStackRecord != null) {
            return backStackRecord;
        }
        throw new IndexOutOfBoundsException();
    }

    public void x1() {
        f0(new PrepareBackStackTransitionState(), false);
    }

    public final void y() {
        FragmentHostCallback fragmentHostCallback = this.x;
        if (fragmentHostCallback instanceof ViewModelStoreOwner ? this.c.p().m() : fragmentHostCallback.f() instanceof Activity ? !((Activity) this.x.f()).isChangingConfigurations() : true) {
            for (BackStackState backStackState : this.l.values()) {
                for (String e2 : backStackState.mFragments) {
                    this.c.p().e(e2, false);
                }
            }
        }
    }

    public int y0() {
        return this.d.size() + (this.h != null ? 1 : 0);
    }

    public void y1(Bundle bundle, String str, Fragment fragment) {
        if (fragment.mFragmentManager != this) {
            T1(new IllegalStateException("Fragment " + fragment + " is not currently in the FragmentManager"));
        }
        bundle.putString(str, fragment.mWho);
    }

    public final void z(String str) {
        this.m.remove(str);
        if (T0(2)) {
            Log.v("FragmentManager", "Clearing fragment result with key " + str);
        }
    }

    public final FragmentManagerViewModel z0(Fragment fragment) {
        return this.R.h(fragment);
    }

    public void z1(FragmentLifecycleCallbacks fragmentLifecycleCallbacks, boolean z2) {
        this.p.o(fragmentLifecycleCallbacks, z2);
    }

    @SuppressLint({"BanParcelableUsage"})
    public static class LaunchedFragmentInfo implements Parcelable {
        public static final Parcelable.Creator<LaunchedFragmentInfo> CREATOR = new Parcelable.Creator<LaunchedFragmentInfo>() {
            /* renamed from: a */
            public LaunchedFragmentInfo createFromParcel(Parcel parcel) {
                return new LaunchedFragmentInfo(parcel);
            }

            /* renamed from: b */
            public LaunchedFragmentInfo[] newArray(int i) {
                return new LaunchedFragmentInfo[i];
            }
        };
        int mRequestCode;
        String mWho;

        public LaunchedFragmentInfo(@NonNull String str, int i) {
            this.mWho = str;
            this.mRequestCode = i;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.mWho);
            parcel.writeInt(this.mRequestCode);
        }

        public LaunchedFragmentInfo(@NonNull Parcel parcel) {
            this.mWho = parcel.readString();
            this.mRequestCode = parcel.readInt();
        }
    }
}
