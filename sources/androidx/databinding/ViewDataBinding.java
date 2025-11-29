package androidx.databinding;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.Choreographer;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.CallbackRegistry;
import androidx.databinding.Observable;
import androidx.databinding.ObservableList;
import androidx.databinding.ObservableMap;
import androidx.databinding.library.R;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.viewbinding.ViewBinding;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

public abstract class ViewDataBinding extends BaseObservable implements ViewBinding {
    public static int p = Build.VERSION.SDK_INT;
    public static final int q = 8;
    public static final boolean r = true;
    public static final CreateWeakListener s = new CreateWeakListener() {
    };
    public static final CreateWeakListener t = new CreateWeakListener() {
    };
    public static final CreateWeakListener u = new CreateWeakListener() {
    };
    public static final CreateWeakListener v = new CreateWeakListener() {
    };
    public static final CallbackRegistry.NotifierCallback w = new CallbackRegistry.NotifierCallback<OnRebindCallback, ViewDataBinding, Void>() {
        /* renamed from: b */
        public void a(OnRebindCallback onRebindCallback, ViewDataBinding viewDataBinding, int i, Void voidR) {
            if (i != 1) {
                if (i == 2) {
                    onRebindCallback.b(viewDataBinding);
                } else if (i == 3) {
                    onRebindCallback.a(viewDataBinding);
                }
            } else if (!onRebindCallback.c(viewDataBinding)) {
                boolean unused = viewDataBinding.c = true;
            }
        }
    };
    public static final ReferenceQueue x = new ReferenceQueue();
    public static final View.OnAttachStateChangeListener y = new View.OnAttachStateChangeListener() {
        public void onViewAttachedToWindow(View view) {
            ViewDataBinding.q(view).f971a.run();
            view.removeOnAttachStateChangeListener(this);
        }

        public void onViewDetachedFromWindow(View view) {
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public final Runnable f971a;
    public boolean b;
    public boolean c;
    public WeakListener[] d;
    public final View e;
    public CallbackRegistry f;
    public boolean g;
    public Choreographer h;
    public final Choreographer.FrameCallback i;
    public Handler j;
    public final DataBindingComponent k;
    public ViewDataBinding l;
    public LifecycleOwner m;
    public boolean n;
    public boolean o;

    public static class IncludedLayouts {

        /* renamed from: a  reason: collision with root package name */
        public final String[][] f974a;
        public final int[][] b;
        public final int[][] c;
    }

    public static class LiveDataListener implements Observer, ObservableReference<LiveData<?>> {

        /* renamed from: a  reason: collision with root package name */
        public final WeakListener f975a;

        /* renamed from: a */
        public void b(LiveData liveData) {
            liveData.removeObserver(this);
        }

        public void onChanged(Object obj) {
            ViewDataBinding a2 = this.f975a.a();
            if (a2 != null) {
                WeakListener weakListener = this.f975a;
                a2.r(weakListener.b, weakListener.b(), 0);
            }
        }
    }

    public static class OnStartListener implements LifecycleObserver {

        /* renamed from: a  reason: collision with root package name */
        public final WeakReference f976a;

        @OnLifecycleEvent(Lifecycle.Event.ON_START)
        public void onStart() {
            ViewDataBinding viewDataBinding = (ViewDataBinding) this.f976a.get();
            if (viewDataBinding != null) {
                viewDataBinding.l();
            }
        }
    }

    public static abstract class PropertyChangedInverseListener extends Observable.OnPropertyChangedCallback implements InverseBindingListener {

        /* renamed from: a  reason: collision with root package name */
        public final int f977a;

        public void c(Observable observable, int i) {
            if (i == this.f977a || i == 0) {
                a();
            }
        }
    }

    public static class WeakListListener extends ObservableList.OnListChangedCallback implements ObservableReference<ObservableList> {

        /* renamed from: a  reason: collision with root package name */
        public final WeakListener f978a;

        public void a(ObservableList observableList) {
            ObservableList observableList2;
            ViewDataBinding a2 = this.f978a.a();
            if (a2 != null && (observableList2 = (ObservableList) this.f978a.b()) == observableList) {
                a2.r(this.f978a.b, observableList2, 0);
            }
        }

        public void c(ObservableList observableList, int i, int i2) {
            a(observableList);
        }

        public void d(ObservableList observableList, int i, int i2) {
            a(observableList);
        }

        public void e(ObservableList observableList, int i, int i2, int i3) {
            a(observableList);
        }

        public void f(ObservableList observableList, int i, int i2) {
            a(observableList);
        }

        /* renamed from: g */
        public void b(ObservableList observableList) {
            observableList.removeOnListChangedCallback(this);
        }
    }

    public static class WeakMapListener extends ObservableMap.OnMapChangedCallback implements ObservableReference<ObservableMap> {

        /* renamed from: a  reason: collision with root package name */
        public final WeakListener f979a;

        public void a(ObservableMap observableMap, Object obj) {
            ViewDataBinding a2 = this.f979a.a();
            if (a2 != null && observableMap == this.f979a.b()) {
                a2.r(this.f979a.b, observableMap, 0);
            }
        }

        /* renamed from: c */
        public void b(ObservableMap observableMap) {
            observableMap.b(this);
        }
    }

    public static class WeakPropertyListener extends Observable.OnPropertyChangedCallback implements ObservableReference<Observable> {

        /* renamed from: a  reason: collision with root package name */
        public final WeakListener f980a;

        public void c(Observable observable, int i) {
            ViewDataBinding a2 = this.f980a.a();
            if (a2 != null && ((Observable) this.f980a.b()) == observable) {
                a2.r(this.f980a.b, observable, i);
            }
        }

        /* renamed from: d */
        public void b(Observable observable) {
            observable.removeOnPropertyChangedCallback(this);
        }
    }

    public ViewDataBinding(DataBindingComponent dataBindingComponent, View view, int i2) {
        this.f971a = new Runnable() {
            public void run() {
                synchronized (this) {
                    boolean unused = ViewDataBinding.this.b = false;
                }
                ViewDataBinding.z();
                if (!ViewDataBinding.this.e.isAttachedToWindow()) {
                    ViewDataBinding.this.e.removeOnAttachStateChangeListener(ViewDataBinding.y);
                    ViewDataBinding.this.e.addOnAttachStateChangeListener(ViewDataBinding.y);
                    return;
                }
                ViewDataBinding.this.l();
            }
        };
        this.b = false;
        this.c = false;
        this.k = dataBindingComponent;
        this.d = new WeakListener[i2];
        this.e = view;
        if (Looper.myLooper() == null) {
            throw new IllegalStateException("DataBinding must be created in view's UI Thread");
        } else if (r) {
            this.h = Choreographer.getInstance();
            this.i = new Choreographer.FrameCallback() {
                public void doFrame(long j) {
                    ViewDataBinding.this.f971a.run();
                }
            };
        } else {
            this.i = null;
            this.j = new Handler(Looper.myLooper());
        }
    }

    public static DataBindingComponent i(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof DataBindingComponent) {
            return (DataBindingComponent) obj;
        }
        throw new IllegalArgumentException("The provided bindingComponent parameter must be an instance of DataBindingComponent. See  https://issuetracker.google.com/issues/116541301 for details of why this parameter is not defined as DataBindingComponent");
    }

    public static int m(String str, int i2, IncludedLayouts includedLayouts, int i3) {
        CharSequence subSequence = str.subSequence(str.indexOf(47) + 1, str.length() - 2);
        String[] strArr = includedLayouts.f974a[i3];
        int length = strArr.length;
        while (i2 < length) {
            if (TextUtils.equals(subSequence, strArr[i2])) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    public static int n(ViewGroup viewGroup, int i2) {
        String str = (String) viewGroup.getChildAt(i2).getTag();
        String substring = str.substring(0, str.length() - 1);
        int length = substring.length();
        int childCount = viewGroup.getChildCount();
        for (int i3 = i2 + 1; i3 < childCount; i3++) {
            View childAt = viewGroup.getChildAt(i3);
            String str2 = childAt.getTag() instanceof String ? (String) childAt.getTag() : null;
            if (str2 != null && str2.startsWith(substring)) {
                if (str2.length() == str.length() && str2.charAt(str2.length() - 1) == '0') {
                    return i2;
                }
                if (u(str2, length)) {
                    i2 = i3;
                }
            }
        }
        return i2;
    }

    public static ViewDataBinding q(View view) {
        if (view != null) {
            return (ViewDataBinding) view.getTag(R.id.dataBinding);
        }
        return null;
    }

    public static boolean u(String str, int i2) {
        int length = str.length();
        if (length == i2) {
            return false;
        }
        while (i2 < length) {
            if (!Character.isDigit(str.charAt(i2))) {
                return false;
            }
            i2++;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:68:0x0106  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0113 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void v(androidx.databinding.DataBindingComponent r17, android.view.View r18, java.lang.Object[] r19, androidx.databinding.ViewDataBinding.IncludedLayouts r20, android.util.SparseIntArray r21, boolean r22) {
        /*
            r6 = r17
            r0 = r18
            r7 = r20
            r8 = r21
            androidx.databinding.ViewDataBinding r1 = q(r18)
            if (r1 == 0) goto L_0x000f
            return
        L_0x000f:
            java.lang.Object r1 = r18.getTag()
            boolean r2 = r1 instanceof java.lang.String
            if (r2 == 0) goto L_0x001a
            java.lang.String r1 = (java.lang.String) r1
            goto L_0x001b
        L_0x001a:
            r1 = 0
        L_0x001b:
            java.lang.String r9 = "layout"
            r2 = -1
            r11 = 1
            if (r22 == 0) goto L_0x004b
            if (r1 == 0) goto L_0x004b
            boolean r3 = r1.startsWith(r9)
            if (r3 == 0) goto L_0x004b
            r3 = 95
            int r3 = r1.lastIndexOf(r3)
            if (r3 <= 0) goto L_0x0047
            int r3 = r3 + r11
            boolean r4 = u(r1, r3)
            if (r4 == 0) goto L_0x0047
            int r1 = y(r1, r3)
            r3 = r19[r1]
            if (r3 != 0) goto L_0x0042
            r19[r1] = r0
        L_0x0042:
            if (r7 != 0) goto L_0x0045
            r1 = r2
        L_0x0045:
            r3 = r11
            goto L_0x0049
        L_0x0047:
            r1 = r2
            r3 = 0
        L_0x0049:
            r12 = r1
            goto L_0x0069
        L_0x004b:
            if (r1 == 0) goto L_0x0067
            java.lang.String r3 = "binding_"
            boolean r3 = r1.startsWith(r3)
            if (r3 == 0) goto L_0x0067
            int r3 = q
            int r1 = y(r1, r3)
            r3 = r19[r1]
            if (r3 != 0) goto L_0x0061
            r19[r1] = r0
        L_0x0061:
            if (r7 != 0) goto L_0x0064
            r1 = r2
        L_0x0064:
            r12 = r1
            r3 = r11
            goto L_0x0069
        L_0x0067:
            r12 = r2
            r3 = 0
        L_0x0069:
            if (r3 != 0) goto L_0x007f
            int r1 = r18.getId()
            if (r1 <= 0) goto L_0x007f
            if (r8 == 0) goto L_0x007f
            int r1 = r8.get(r1, r2)
            if (r1 < 0) goto L_0x007f
            r2 = r19[r1]
            if (r2 != 0) goto L_0x007f
            r19[r1] = r0
        L_0x007f:
            boolean r1 = r0 instanceof android.view.ViewGroup
            if (r1 == 0) goto L_0x011e
            r13 = r0
            android.view.ViewGroup r13 = (android.view.ViewGroup) r13
            int r14 = r13.getChildCount()
            r0 = 0
            r1 = 0
        L_0x008c:
            if (r0 >= r14) goto L_0x011e
            android.view.View r2 = r13.getChildAt(r0)
            if (r12 < 0) goto L_0x0101
            java.lang.Object r3 = r2.getTag()
            boolean r3 = r3 instanceof java.lang.String
            if (r3 == 0) goto L_0x0101
            java.lang.Object r3 = r2.getTag()
            java.lang.String r3 = (java.lang.String) r3
            java.lang.String r4 = "_0"
            boolean r4 = r3.endsWith(r4)
            if (r4 == 0) goto L_0x0101
            boolean r4 = r3.startsWith(r9)
            if (r4 == 0) goto L_0x0101
            r4 = 47
            int r4 = r3.indexOf(r4)
            if (r4 <= 0) goto L_0x0101
            int r3 = m(r3, r1, r7, r12)
            if (r3 < 0) goto L_0x0101
            int r1 = r3 + 1
            int[][] r4 = r7.b
            r4 = r4[r12]
            r4 = r4[r3]
            int[][] r5 = r7.c
            r5 = r5[r12]
            r3 = r5[r3]
            int r5 = n(r13, r0)
            if (r5 != r0) goto L_0x00dc
            androidx.databinding.ViewDataBinding r3 = androidx.databinding.DataBindingUtil.a(r6, r2, r3)
            r19[r4] = r3
            r10 = r0
            r0 = r11
            r11 = r1
            goto L_0x0104
        L_0x00dc:
            int r5 = r5 - r0
            int r15 = r5 + 1
            android.view.View[] r10 = new android.view.View[r15]
            r11 = 0
        L_0x00e2:
            if (r11 >= r15) goto L_0x00f3
            r18 = r1
            int r1 = r0 + r11
            android.view.View r1 = r13.getChildAt(r1)
            r10[r11] = r1
            int r11 = r11 + 1
            r1 = r18
            goto L_0x00e2
        L_0x00f3:
            r18 = r1
            androidx.databinding.ViewDataBinding r1 = androidx.databinding.DataBindingUtil.b(r6, r10, r3)
            r19[r4] = r1
            int r0 = r0 + r5
            r11 = r18
            r10 = r0
            r0 = 1
            goto L_0x0104
        L_0x0101:
            r10 = r0
            r11 = r1
            r0 = 0
        L_0x0104:
            if (r0 != 0) goto L_0x0113
            r5 = 0
            r0 = r17
            r1 = r2
            r2 = r19
            r3 = r20
            r4 = r21
            v(r0, r1, r2, r3, r4, r5)
        L_0x0113:
            r0 = 1
            int r1 = r10 + 1
            r16 = r11
            r11 = r0
            r0 = r1
            r1 = r16
            goto L_0x008c
        L_0x011e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.databinding.ViewDataBinding.v(androidx.databinding.DataBindingComponent, android.view.View, java.lang.Object[], androidx.databinding.ViewDataBinding$IncludedLayouts, android.util.SparseIntArray, boolean):void");
    }

    public static Object[] w(DataBindingComponent dataBindingComponent, View view, int i2, IncludedLayouts includedLayouts, SparseIntArray sparseIntArray) {
        Object[] objArr = new Object[i2];
        v(dataBindingComponent, view, objArr, includedLayouts, sparseIntArray, true);
        return objArr;
    }

    public static int y(String str, int i2) {
        int length = str.length();
        int i3 = 0;
        while (i2 < length) {
            i3 = (i3 * 10) + (str.charAt(i2) - '0');
            i2++;
        }
        return i3;
    }

    public static void z() {
        while (true) {
            Reference poll = x.poll();
            if (poll == null) {
                return;
            }
            if (poll instanceof WeakListener) {
                ((WeakListener) poll).c();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x002c, code lost:
        if (r == false) goto L_0x0036;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x002e, code lost:
        r2.h.postFrameCallback(r2.i);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0036, code lost:
        r2.j.post(r2.f971a);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void A() {
        /*
            r2 = this;
            androidx.databinding.ViewDataBinding r0 = r2.l
            if (r0 == 0) goto L_0x0008
            r0.A()
            goto L_0x003d
        L_0x0008:
            androidx.lifecycle.LifecycleOwner r0 = r2.m
            if (r0 == 0) goto L_0x001d
            androidx.lifecycle.Lifecycle r0 = r0.getLifecycle()
            androidx.lifecycle.Lifecycle$State r0 = r0.b()
            androidx.lifecycle.Lifecycle$State r1 = androidx.lifecycle.Lifecycle.State.STARTED
            boolean r0 = r0.isAtLeast(r1)
            if (r0 != 0) goto L_0x001d
            return
        L_0x001d:
            monitor-enter(r2)
            boolean r0 = r2.b     // Catch:{ all -> 0x0024 }
            if (r0 == 0) goto L_0x0026
            monitor-exit(r2)     // Catch:{ all -> 0x0024 }
            return
        L_0x0024:
            r0 = move-exception
            goto L_0x003e
        L_0x0026:
            r0 = 1
            r2.b = r0     // Catch:{ all -> 0x0024 }
            monitor-exit(r2)     // Catch:{ all -> 0x0024 }
            boolean r0 = r
            if (r0 == 0) goto L_0x0036
            android.view.Choreographer r0 = r2.h
            android.view.Choreographer$FrameCallback r2 = r2.i
            r0.postFrameCallback(r2)
            goto L_0x003d
        L_0x0036:
            android.os.Handler r0 = r2.j
            java.lang.Runnable r2 = r2.f971a
            r0.post(r2)
        L_0x003d:
            return
        L_0x003e:
            monitor-exit(r2)     // Catch:{ all -> 0x0024 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.databinding.ViewDataBinding.A():void");
    }

    public void B(View view) {
        view.setTag(R.id.dataBinding, this);
    }

    public View getRoot() {
        return this.e;
    }

    public abstract void j();

    public final void k() {
        if (this.g) {
            A();
        } else if (s()) {
            this.g = true;
            this.c = false;
            CallbackRegistry callbackRegistry = this.f;
            if (callbackRegistry != null) {
                callbackRegistry.e(this, 1, (Object) null);
                if (this.c) {
                    this.f.e(this, 2, (Object) null);
                }
            }
            if (!this.c) {
                j();
                CallbackRegistry callbackRegistry2 = this.f;
                if (callbackRegistry2 != null) {
                    callbackRegistry2.e(this, 3, (Object) null);
                }
            }
            this.g = false;
        }
    }

    public void l() {
        ViewDataBinding viewDataBinding = this.l;
        if (viewDataBinding == null) {
            k();
        } else {
            viewDataBinding.l();
        }
    }

    public void p() {
        j();
    }

    public void r(int i2, Object obj, int i3) {
        if (!this.n && !this.o && x(i2, obj, i3)) {
            A();
        }
    }

    public abstract boolean s();

    public abstract void t();

    public abstract boolean x(int i2, Object obj, int i3);

    public ViewDataBinding(Object obj, View view, int i2) {
        this(i(obj), view, i2);
    }
}
