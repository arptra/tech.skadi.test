package androidx.fragment.app;

import android.app.Activity;
import android.content.res.Resources;
import android.os.BadParcelableException;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.core.view.ViewCompat;
import androidx.fragment.R;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.SpecialEffectsController;
import androidx.fragment.app.strictmode.FragmentStrictMode;
import androidx.lifecycle.ViewModelStoreOwner;
import com.upuphone.starrynet.common.StarryNetConstant;

class FragmentStateManager {

    /* renamed from: a  reason: collision with root package name */
    public final FragmentLifecycleCallbacksDispatcher f1297a;
    public final FragmentStore b;
    public final Fragment c;
    public boolean d = false;
    public int e = -1;

    /* renamed from: androidx.fragment.app.FragmentStateManager$2  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f1299a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                androidx.lifecycle.Lifecycle$State[] r0 = androidx.lifecycle.Lifecycle.State.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f1299a = r0
                androidx.lifecycle.Lifecycle$State r1 = androidx.lifecycle.Lifecycle.State.RESUMED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f1299a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.lifecycle.Lifecycle$State r1 = androidx.lifecycle.Lifecycle.State.STARTED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f1299a     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.lifecycle.Lifecycle$State r1 = androidx.lifecycle.Lifecycle.State.CREATED     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f1299a     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.lifecycle.Lifecycle$State r1 = androidx.lifecycle.Lifecycle.State.INITIALIZED     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.FragmentStateManager.AnonymousClass2.<clinit>():void");
        }
    }

    public FragmentStateManager(FragmentLifecycleCallbacksDispatcher fragmentLifecycleCallbacksDispatcher, FragmentStore fragmentStore, Fragment fragment) {
        this.f1297a = fragmentLifecycleCallbacksDispatcher;
        this.b = fragmentStore;
        this.c = fragment;
    }

    public void a() {
        if (FragmentManager.T0(3)) {
            Log.d("FragmentManager", "moveto ACTIVITY_CREATED: " + this.c);
        }
        Bundle bundle = this.c.mSavedFragmentState;
        Bundle bundle2 = bundle != null ? bundle.getBundle("savedInstanceState") : null;
        this.c.performActivityCreated(bundle2);
        this.f1297a.a(this.c, bundle2, false);
    }

    public void b() {
        Fragment s0 = FragmentManager.s0(this.c.mContainer);
        Fragment parentFragment = this.c.getParentFragment();
        if (s0 != null && !s0.equals(parentFragment)) {
            Fragment fragment = this.c;
            FragmentStrictMode.q(fragment, s0, fragment.mContainerId);
        }
        int j = this.b.j(this.c);
        Fragment fragment2 = this.c;
        fragment2.mContainer.addView(fragment2.mView, j);
    }

    public void c() {
        if (FragmentManager.T0(3)) {
            Log.d("FragmentManager", "moveto ATTACHED: " + this.c);
        }
        Fragment fragment = this.c;
        Fragment fragment2 = fragment.mTarget;
        FragmentStateManager fragmentStateManager = null;
        if (fragment2 != null) {
            FragmentStateManager n = this.b.n(fragment2.mWho);
            if (n != null) {
                Fragment fragment3 = this.c;
                fragment3.mTargetWho = fragment3.mTarget.mWho;
                fragment3.mTarget = null;
                fragmentStateManager = n;
            } else {
                throw new IllegalStateException("Fragment " + this.c + " declared target fragment " + this.c.mTarget + " that does not belong to this FragmentManager!");
            }
        } else {
            String str = fragment.mTargetWho;
            if (str != null && (fragmentStateManager = this.b.n(str)) == null) {
                throw new IllegalStateException("Fragment " + this.c + " declared target fragment " + this.c.mTargetWho + " that does not belong to this FragmentManager!");
            }
        }
        if (fragmentStateManager != null) {
            fragmentStateManager.m();
        }
        Fragment fragment4 = this.c;
        fragment4.mHost = fragment4.mFragmentManager.G0();
        Fragment fragment5 = this.c;
        fragment5.mParentFragment = fragment5.mFragmentManager.J0();
        this.f1297a.g(this.c, false);
        this.c.performAttach();
        this.f1297a.b(this.c, false);
    }

    public int d() {
        Fragment fragment = this.c;
        if (fragment.mFragmentManager == null) {
            return fragment.mState;
        }
        int i = this.e;
        int i2 = AnonymousClass2.f1299a[fragment.mMaxState.ordinal()];
        if (i2 != 1) {
            i = i2 != 2 ? i2 != 3 ? i2 != 4 ? Math.min(i, -1) : Math.min(i, 0) : Math.min(i, 1) : Math.min(i, 5);
        }
        Fragment fragment2 = this.c;
        if (fragment2.mFromLayout) {
            if (fragment2.mInLayout) {
                i = Math.max(this.e, 2);
                View view = this.c.mView;
                if (view != null && view.getParent() == null) {
                    i = Math.min(i, 2);
                }
            } else {
                i = this.e < 4 ? Math.min(i, fragment2.mState) : Math.min(i, 1);
            }
        }
        Fragment fragment3 = this.c;
        if (fragment3.mInDynamicContainer && fragment3.mContainer == null) {
            i = Math.min(i, 4);
        }
        if (!this.c.mAdded) {
            i = Math.min(i, 1);
        }
        Fragment fragment4 = this.c;
        ViewGroup viewGroup = fragment4.mContainer;
        SpecialEffectsController.Operation.LifecycleImpact s = viewGroup != null ? SpecialEffectsController.u(viewGroup, fragment4.getParentFragmentManager()).s(this) : null;
        if (s == SpecialEffectsController.Operation.LifecycleImpact.ADDING) {
            i = Math.min(i, 6);
        } else if (s == SpecialEffectsController.Operation.LifecycleImpact.REMOVING) {
            i = Math.max(i, 3);
        } else {
            Fragment fragment5 = this.c;
            if (fragment5.mRemoving) {
                i = fragment5.isInBackStack() ? Math.min(i, 1) : Math.min(i, -1);
            }
        }
        Fragment fragment6 = this.c;
        if (fragment6.mDeferStart && fragment6.mState < 5) {
            i = Math.min(i, 4);
        }
        if (this.c.mTransitioning) {
            i = Math.max(i, 3);
        }
        if (FragmentManager.T0(2)) {
            Log.v("FragmentManager", "computeExpectedState() of " + i + " for " + this.c);
        }
        return i;
    }

    public void e() {
        if (FragmentManager.T0(3)) {
            Log.d("FragmentManager", "moveto CREATED: " + this.c);
        }
        Bundle bundle = this.c.mSavedFragmentState;
        Bundle bundle2 = bundle != null ? bundle.getBundle("savedInstanceState") : null;
        Fragment fragment = this.c;
        if (!fragment.mIsCreated) {
            this.f1297a.h(fragment, bundle2, false);
            this.c.performCreate(bundle2);
            this.f1297a.c(this.c, bundle2, false);
            return;
        }
        fragment.mState = 1;
        fragment.restoreChildFragmentState();
    }

    public void f() {
        String str;
        if (!this.c.mFromLayout) {
            if (FragmentManager.T0(3)) {
                Log.d("FragmentManager", "moveto CREATE_VIEW: " + this.c);
            }
            Bundle bundle = this.c.mSavedFragmentState;
            ViewGroup viewGroup = null;
            Bundle bundle2 = bundle != null ? bundle.getBundle("savedInstanceState") : null;
            LayoutInflater performGetLayoutInflater = this.c.performGetLayoutInflater(bundle2);
            Fragment fragment = this.c;
            ViewGroup viewGroup2 = fragment.mContainer;
            if (viewGroup2 != null) {
                viewGroup = viewGroup2;
            } else {
                int i = fragment.mContainerId;
                if (i != 0) {
                    if (i != -1) {
                        viewGroup = (ViewGroup) fragment.mFragmentManager.A0().c(this.c.mContainerId);
                        if (viewGroup == null) {
                            Fragment fragment2 = this.c;
                            if (!fragment2.mRestored && !fragment2.mInDynamicContainer) {
                                try {
                                    str = fragment2.getResources().getResourceName(this.c.mContainerId);
                                } catch (Resources.NotFoundException unused) {
                                    str = StarryNetConstant.DEVICE_NAME_UNKNOWN;
                                }
                                throw new IllegalArgumentException("No view found for id 0x" + Integer.toHexString(this.c.mContainerId) + " (" + str + ") for fragment " + this.c);
                            }
                        } else if (!(viewGroup instanceof FragmentContainerView)) {
                            FragmentStrictMode.p(this.c, viewGroup);
                        }
                    } else {
                        throw new IllegalArgumentException("Cannot create fragment " + this.c + " for a container view with no id");
                    }
                }
            }
            Fragment fragment3 = this.c;
            fragment3.mContainer = viewGroup;
            fragment3.performCreateView(performGetLayoutInflater, viewGroup, bundle2);
            if (this.c.mView != null) {
                if (FragmentManager.T0(3)) {
                    Log.d("FragmentManager", "moveto VIEW_CREATED: " + this.c);
                }
                this.c.mView.setSaveFromParentEnabled(false);
                Fragment fragment4 = this.c;
                fragment4.mView.setTag(R.id.fragment_container_view_tag, fragment4);
                if (viewGroup != null) {
                    b();
                }
                Fragment fragment5 = this.c;
                if (fragment5.mHidden) {
                    fragment5.mView.setVisibility(8);
                }
                if (this.c.mView.isAttachedToWindow()) {
                    ViewCompat.q0(this.c.mView);
                } else {
                    final View view = this.c.mView;
                    view.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() {
                        public void onViewAttachedToWindow(View view) {
                            view.removeOnAttachStateChangeListener(this);
                            ViewCompat.q0(view);
                        }

                        public void onViewDetachedFromWindow(View view) {
                        }
                    });
                }
                this.c.performViewCreated();
                FragmentLifecycleCallbacksDispatcher fragmentLifecycleCallbacksDispatcher = this.f1297a;
                Fragment fragment6 = this.c;
                fragmentLifecycleCallbacksDispatcher.m(fragment6, fragment6.mView, bundle2, false);
                int visibility = this.c.mView.getVisibility();
                this.c.setPostOnViewCreatedAlpha(this.c.mView.getAlpha());
                Fragment fragment7 = this.c;
                if (fragment7.mContainer != null && visibility == 0) {
                    View findFocus = fragment7.mView.findFocus();
                    if (findFocus != null) {
                        this.c.setFocusedView(findFocus);
                        if (FragmentManager.T0(2)) {
                            Log.v("FragmentManager", "requestFocus: Saved focused view " + findFocus + " for Fragment " + this.c);
                        }
                    }
                    this.c.mView.setAlpha(0.0f);
                }
            }
            this.c.mState = 2;
        }
    }

    public void g() {
        Fragment f;
        if (FragmentManager.T0(3)) {
            Log.d("FragmentManager", "movefrom CREATED: " + this.c);
        }
        Fragment fragment = this.c;
        boolean z = true;
        boolean z2 = fragment.mRemoving && !fragment.isInBackStack();
        if (z2) {
            Fragment fragment2 = this.c;
            if (!fragment2.mBeingSaved) {
                this.b.B(fragment2.mWho, (Bundle) null);
            }
        }
        if (z2 || this.b.p().q(this.c)) {
            FragmentHostCallback<?> fragmentHostCallback = this.c.mHost;
            if (fragmentHostCallback instanceof ViewModelStoreOwner) {
                z = this.b.p().m();
            } else if (fragmentHostCallback.f() instanceof Activity) {
                z = true ^ ((Activity) fragmentHostCallback.f()).isChangingConfigurations();
            }
            if ((z2 && !this.c.mBeingSaved) || z) {
                this.b.p().d(this.c, false);
            }
            this.c.performDestroy();
            this.f1297a.d(this.c, false);
            for (FragmentStateManager fragmentStateManager : this.b.k()) {
                if (fragmentStateManager != null) {
                    Fragment k = fragmentStateManager.k();
                    if (this.c.mWho.equals(k.mTargetWho)) {
                        k.mTarget = this.c;
                        k.mTargetWho = null;
                    }
                }
            }
            Fragment fragment3 = this.c;
            String str = fragment3.mTargetWho;
            if (str != null) {
                fragment3.mTarget = this.b.f(str);
            }
            this.b.s(this);
            return;
        }
        String str2 = this.c.mTargetWho;
        if (!(str2 == null || (f = this.b.f(str2)) == null || !f.mRetainInstance)) {
            this.c.mTarget = f;
        }
        this.c.mState = 0;
    }

    public void h() {
        View view;
        if (FragmentManager.T0(3)) {
            Log.d("FragmentManager", "movefrom CREATE_VIEW: " + this.c);
        }
        Fragment fragment = this.c;
        ViewGroup viewGroup = fragment.mContainer;
        if (!(viewGroup == null || (view = fragment.mView) == null)) {
            viewGroup.removeView(view);
        }
        this.c.performDestroyView();
        this.f1297a.n(this.c, false);
        Fragment fragment2 = this.c;
        fragment2.mContainer = null;
        fragment2.mView = null;
        fragment2.mViewLifecycleOwner = null;
        fragment2.mViewLifecycleOwnerLiveData.setValue((Object) null);
        this.c.mInLayout = false;
    }

    public void i() {
        if (FragmentManager.T0(3)) {
            Log.d("FragmentManager", "movefrom ATTACHED: " + this.c);
        }
        this.c.performDetach();
        this.f1297a.e(this.c, false);
        Fragment fragment = this.c;
        fragment.mState = -1;
        fragment.mHost = null;
        fragment.mParentFragment = null;
        fragment.mFragmentManager = null;
        if ((fragment.mRemoving && !fragment.isInBackStack()) || this.b.p().q(this.c)) {
            if (FragmentManager.T0(3)) {
                Log.d("FragmentManager", "initState called for fragment: " + this.c);
            }
            this.c.initState();
        }
    }

    public void j() {
        Fragment fragment = this.c;
        if (fragment.mFromLayout && fragment.mInLayout && !fragment.mPerformedCreateView) {
            if (FragmentManager.T0(3)) {
                Log.d("FragmentManager", "moveto CREATE_VIEW: " + this.c);
            }
            Bundle bundle = this.c.mSavedFragmentState;
            Bundle bundle2 = bundle != null ? bundle.getBundle("savedInstanceState") : null;
            Fragment fragment2 = this.c;
            fragment2.performCreateView(fragment2.performGetLayoutInflater(bundle2), (ViewGroup) null, bundle2);
            View view = this.c.mView;
            if (view != null) {
                view.setSaveFromParentEnabled(false);
                Fragment fragment3 = this.c;
                fragment3.mView.setTag(R.id.fragment_container_view_tag, fragment3);
                Fragment fragment4 = this.c;
                if (fragment4.mHidden) {
                    fragment4.mView.setVisibility(8);
                }
                this.c.performViewCreated();
                FragmentLifecycleCallbacksDispatcher fragmentLifecycleCallbacksDispatcher = this.f1297a;
                Fragment fragment5 = this.c;
                fragmentLifecycleCallbacksDispatcher.m(fragment5, fragment5.mView, bundle2, false);
                this.c.mState = 2;
            }
        }
    }

    public Fragment k() {
        return this.c;
    }

    public final boolean l(View view) {
        if (view == this.c.mView) {
            return true;
        }
        for (ViewParent parent = view.getParent(); parent != null; parent = parent.getParent()) {
            if (parent == this.c.mView) {
                return true;
            }
        }
        return false;
    }

    public void m() {
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        ViewGroup viewGroup3;
        if (!this.d) {
            try {
                this.d = true;
                boolean z = false;
                while (true) {
                    int d2 = d();
                    Fragment fragment = this.c;
                    int i = fragment.mState;
                    if (d2 != i) {
                        if (d2 <= i) {
                            switch (i - 1) {
                                case -1:
                                    i();
                                    break;
                                case 0:
                                    if (fragment.mBeingSaved && this.b.q(fragment.mWho) == null) {
                                        this.b.B(this.c.mWho, r());
                                    }
                                    g();
                                    break;
                                case 1:
                                    h();
                                    this.c.mState = 1;
                                    break;
                                case 2:
                                    fragment.mInLayout = false;
                                    fragment.mState = 2;
                                    break;
                                case 3:
                                    if (FragmentManager.T0(3)) {
                                        Log.d("FragmentManager", "movefrom ACTIVITY_CREATED: " + this.c);
                                    }
                                    Fragment fragment2 = this.c;
                                    if (fragment2.mBeingSaved) {
                                        this.b.B(fragment2.mWho, r());
                                    } else if (fragment2.mView != null && fragment2.mSavedViewState == null) {
                                        s();
                                    }
                                    Fragment fragment3 = this.c;
                                    if (!(fragment3.mView == null || (viewGroup2 = fragment3.mContainer) == null)) {
                                        SpecialEffectsController.u(viewGroup2, fragment3.getParentFragmentManager()).l(this);
                                    }
                                    this.c.mState = 3;
                                    break;
                                case 4:
                                    v();
                                    break;
                                case 5:
                                    fragment.mState = 5;
                                    break;
                                case 6:
                                    n();
                                    break;
                            }
                        } else {
                            switch (i + 1) {
                                case 0:
                                    c();
                                    break;
                                case 1:
                                    e();
                                    break;
                                case 2:
                                    j();
                                    f();
                                    break;
                                case 3:
                                    a();
                                    break;
                                case 4:
                                    if (!(fragment.mView == null || (viewGroup3 = fragment.mContainer) == null)) {
                                        SpecialEffectsController.u(viewGroup3, fragment.getParentFragmentManager()).j(SpecialEffectsController.Operation.State.from(this.c.mView.getVisibility()), this);
                                    }
                                    this.c.mState = 4;
                                    break;
                                case 5:
                                    u();
                                    break;
                                case 6:
                                    fragment.mState = 6;
                                    break;
                                case 7:
                                    p();
                                    break;
                            }
                        }
                        z = true;
                    } else {
                        if (!z && i == -1 && fragment.mRemoving && !fragment.isInBackStack() && !this.c.mBeingSaved) {
                            if (FragmentManager.T0(3)) {
                                Log.d("FragmentManager", "Cleaning up state of never attached fragment: " + this.c);
                            }
                            this.b.p().d(this.c, true);
                            this.b.s(this);
                            if (FragmentManager.T0(3)) {
                                Log.d("FragmentManager", "initState called for fragment: " + this.c);
                            }
                            this.c.initState();
                        }
                        Fragment fragment4 = this.c;
                        if (fragment4.mHiddenChanged) {
                            if (!(fragment4.mView == null || (viewGroup = fragment4.mContainer) == null)) {
                                SpecialEffectsController u = SpecialEffectsController.u(viewGroup, fragment4.getParentFragmentManager());
                                if (this.c.mHidden) {
                                    u.k(this);
                                } else {
                                    u.m(this);
                                }
                            }
                            Fragment fragment5 = this.c;
                            FragmentManager fragmentManager = fragment5.mFragmentManager;
                            if (fragmentManager != null) {
                                fragmentManager.R0(fragment5);
                            }
                            Fragment fragment6 = this.c;
                            fragment6.mHiddenChanged = false;
                            fragment6.onHiddenChanged(fragment6.mHidden);
                            this.c.mChildFragmentManager.P();
                        }
                        this.d = false;
                        return;
                    }
                }
            } catch (Throwable th) {
                this.d = false;
                throw th;
            }
        } else if (FragmentManager.T0(2)) {
            Log.v("FragmentManager", "Ignoring re-entrant call to moveToExpectedState() for " + k());
        }
    }

    public void n() {
        if (FragmentManager.T0(3)) {
            Log.d("FragmentManager", "movefrom RESUMED: " + this.c);
        }
        this.c.performPause();
        this.f1297a.f(this.c, false);
    }

    public void o(ClassLoader classLoader) {
        Bundle bundle = this.c.mSavedFragmentState;
        if (bundle != null) {
            bundle.setClassLoader(classLoader);
            if (this.c.mSavedFragmentState.getBundle("savedInstanceState") == null) {
                this.c.mSavedFragmentState.putBundle("savedInstanceState", new Bundle());
            }
            try {
                Fragment fragment = this.c;
                fragment.mSavedViewState = fragment.mSavedFragmentState.getSparseParcelableArray("viewState");
                Fragment fragment2 = this.c;
                fragment2.mSavedViewRegistryState = fragment2.mSavedFragmentState.getBundle("viewRegistryState");
                FragmentState fragmentState = (FragmentState) this.c.mSavedFragmentState.getParcelable("state");
                if (fragmentState != null) {
                    Fragment fragment3 = this.c;
                    fragment3.mTargetWho = fragmentState.mTargetWho;
                    fragment3.mTargetRequestCode = fragmentState.mTargetRequestCode;
                    Boolean bool = fragment3.mSavedUserVisibleHint;
                    if (bool != null) {
                        fragment3.mUserVisibleHint = bool.booleanValue();
                        this.c.mSavedUserVisibleHint = null;
                    } else {
                        fragment3.mUserVisibleHint = fragmentState.mUserVisibleHint;
                    }
                }
                Fragment fragment4 = this.c;
                if (!fragment4.mUserVisibleHint) {
                    fragment4.mDeferStart = true;
                }
            } catch (BadParcelableException e2) {
                throw new IllegalStateException("Failed to restore view hierarchy state for fragment " + k(), e2);
            }
        }
    }

    public void p() {
        if (FragmentManager.T0(3)) {
            Log.d("FragmentManager", "moveto RESUMED: " + this.c);
        }
        View focusedView = this.c.getFocusedView();
        if (focusedView != null && l(focusedView)) {
            boolean requestFocus = focusedView.requestFocus();
            if (FragmentManager.T0(2)) {
                StringBuilder sb = new StringBuilder();
                sb.append("requestFocus: Restoring focused view ");
                sb.append(focusedView);
                sb.append(" ");
                sb.append(requestFocus ? "succeeded" : "failed");
                sb.append(" on Fragment ");
                sb.append(this.c);
                sb.append(" resulting in focused view ");
                sb.append(this.c.mView.findFocus());
                Log.v("FragmentManager", sb.toString());
            }
        }
        this.c.setFocusedView((View) null);
        this.c.performResume();
        this.f1297a.i(this.c, false);
        this.b.B(this.c.mWho, (Bundle) null);
        Fragment fragment = this.c;
        fragment.mSavedFragmentState = null;
        fragment.mSavedViewState = null;
        fragment.mSavedViewRegistryState = null;
    }

    public Fragment.SavedState q() {
        if (this.c.mState > -1) {
            return new Fragment.SavedState(r());
        }
        return null;
    }

    public Bundle r() {
        Bundle bundle;
        Bundle bundle2 = new Bundle();
        Fragment fragment = this.c;
        if (fragment.mState == -1 && (bundle = fragment.mSavedFragmentState) != null) {
            bundle2.putAll(bundle);
        }
        bundle2.putParcelable("state", new FragmentState(this.c));
        if (this.c.mState > -1) {
            Bundle bundle3 = new Bundle();
            this.c.performSaveInstanceState(bundle3);
            if (!bundle3.isEmpty()) {
                bundle2.putBundle("savedInstanceState", bundle3);
            }
            this.f1297a.j(this.c, bundle3, false);
            Bundle bundle4 = new Bundle();
            this.c.mSavedStateRegistryController.e(bundle4);
            if (!bundle4.isEmpty()) {
                bundle2.putBundle("registryState", bundle4);
            }
            Bundle I1 = this.c.mChildFragmentManager.b1();
            if (!I1.isEmpty()) {
                bundle2.putBundle("childFragmentManager", I1);
            }
            if (this.c.mView != null) {
                s();
            }
            SparseArray<Parcelable> sparseArray = this.c.mSavedViewState;
            if (sparseArray != null) {
                bundle2.putSparseParcelableArray("viewState", sparseArray);
            }
            Bundle bundle5 = this.c.mSavedViewRegistryState;
            if (bundle5 != null) {
                bundle2.putBundle("viewRegistryState", bundle5);
            }
        }
        Bundle bundle6 = this.c.mArguments;
        if (bundle6 != null) {
            bundle2.putBundle("arguments", bundle6);
        }
        return bundle2;
    }

    public void s() {
        if (this.c.mView != null) {
            if (FragmentManager.T0(2)) {
                Log.v("FragmentManager", "Saving view state for fragment " + this.c + " with view " + this.c.mView);
            }
            SparseArray<Parcelable> sparseArray = new SparseArray<>();
            this.c.mView.saveHierarchyState(sparseArray);
            if (sparseArray.size() > 0) {
                this.c.mSavedViewState = sparseArray;
            }
            Bundle bundle = new Bundle();
            this.c.mViewLifecycleOwner.e(bundle);
            if (!bundle.isEmpty()) {
                this.c.mSavedViewRegistryState = bundle;
            }
        }
    }

    public void t(int i) {
        this.e = i;
    }

    public void u() {
        if (FragmentManager.T0(3)) {
            Log.d("FragmentManager", "moveto STARTED: " + this.c);
        }
        this.c.performStart();
        this.f1297a.k(this.c, false);
    }

    public void v() {
        if (FragmentManager.T0(3)) {
            Log.d("FragmentManager", "movefrom STARTED: " + this.c);
        }
        this.c.performStop();
        this.f1297a.l(this.c, false);
    }

    public FragmentStateManager(FragmentLifecycleCallbacksDispatcher fragmentLifecycleCallbacksDispatcher, FragmentStore fragmentStore, ClassLoader classLoader, FragmentFactory fragmentFactory, Bundle bundle) {
        this.f1297a = fragmentLifecycleCallbacksDispatcher;
        this.b = fragmentStore;
        Fragment instantiate = ((FragmentState) bundle.getParcelable("state")).instantiate(fragmentFactory, classLoader);
        this.c = instantiate;
        instantiate.mSavedFragmentState = bundle;
        Bundle bundle2 = bundle.getBundle("arguments");
        if (bundle2 != null) {
            bundle2.setClassLoader(classLoader);
        }
        instantiate.setArguments(bundle2);
        if (FragmentManager.T0(2)) {
            Log.v("FragmentManager", "Instantiated fragment " + instantiate);
        }
    }

    public FragmentStateManager(FragmentLifecycleCallbacksDispatcher fragmentLifecycleCallbacksDispatcher, FragmentStore fragmentStore, Fragment fragment, Bundle bundle) {
        this.f1297a = fragmentLifecycleCallbacksDispatcher;
        this.b = fragmentStore;
        this.c = fragment;
        fragment.mSavedViewState = null;
        fragment.mSavedViewRegistryState = null;
        fragment.mBackStackNesting = 0;
        fragment.mInLayout = false;
        fragment.mAdded = false;
        Fragment fragment2 = fragment.mTarget;
        fragment.mTargetWho = fragment2 != null ? fragment2.mWho : null;
        fragment.mTarget = null;
        fragment.mSavedFragmentState = bundle;
        fragment.mArguments = bundle.getBundle("arguments");
    }
}
