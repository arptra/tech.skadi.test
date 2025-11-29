package com.upuphone.ar.navi.lite.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Point;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.WindowManager;
import android.view.animation.Interpolator;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.Scroller;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.honey.account.o4.u;
import com.upuphone.ar.navi.lite.R;

public class ScrollLayout extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    public final GestureDetector.OnGestureListener f5844a = new GestureDetector.SimpleOnGestureListener() {
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (f2 > 80.0f) {
                Status b = ScrollLayout.this.g;
                Status status = Status.OPENED;
                if (!b.equals(status) || (-ScrollLayout.this.getScrollY()) <= ScrollLayout.this.q) {
                    ScrollLayout.this.r();
                    ScrollLayout.this.g = status;
                } else {
                    ScrollLayout.this.g = Status.EXIT;
                    ScrollLayout.this.q();
                }
                return true;
            }
            int i = (f2 > 80.0f ? 1 : (f2 == 80.0f ? 0 : -1));
            if (i < 0 && ScrollLayout.this.getScrollY() <= (-ScrollLayout.this.q)) {
                ScrollLayout.this.r();
                ScrollLayout.this.g = Status.OPENED;
                return true;
            } else if (i >= 0 || ScrollLayout.this.getScrollY() <= (-ScrollLayout.this.q)) {
                return false;
            } else {
                ScrollLayout.this.p();
                ScrollLayout.this.g = Status.CLOSED;
                return true;
            }
        }
    };
    public final AbsListView.OnScrollListener b = new AbsListView.OnScrollListener() {
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            ScrollLayout.this.v(absListView);
        }

        public void onScrollStateChanged(AbsListView absListView, int i) {
            ScrollLayout.this.v(absListView);
        }
    };
    public final RecyclerView.OnScrollListener c = new RecyclerView.OnScrollListener() {
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            ScrollLayout.this.w(recyclerView);
        }

        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            ScrollLayout.this.w(recyclerView);
        }
    };
    public float d;
    public float e;
    public float f;
    public Status g = Status.CLOSED;
    public Scroller h;
    public GestureDetector i;
    public boolean j = true;
    public boolean k = false;
    public boolean l = true;
    public boolean m = true;
    public boolean n = true;
    public boolean o = false;
    public InnerStatus p = InnerStatus.OPENED;
    public int q = 0;
    public int r = 0;
    public int s = 0;
    public OnScrollChangedListener t;
    public ContentScrollView u;
    public OnTouchEventListener v;

    /* renamed from: com.upuphone.ar.navi.lite.view.ScrollLayout$4  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass4 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f5848a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.upuphone.ar.navi.lite.view.ScrollLayout$InnerStatus[] r0 = com.upuphone.ar.navi.lite.view.ScrollLayout.InnerStatus.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f5848a = r0
                com.upuphone.ar.navi.lite.view.ScrollLayout$InnerStatus r1 = com.upuphone.ar.navi.lite.view.ScrollLayout.InnerStatus.CLOSED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f5848a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.upuphone.ar.navi.lite.view.ScrollLayout$InnerStatus r1 = com.upuphone.ar.navi.lite.view.ScrollLayout.InnerStatus.OPENED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f5848a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.upuphone.ar.navi.lite.view.ScrollLayout$InnerStatus r1 = com.upuphone.ar.navi.lite.view.ScrollLayout.InnerStatus.EXIT     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.navi.lite.view.ScrollLayout.AnonymousClass4.<clinit>():void");
        }
    }

    public enum InnerStatus {
        EXIT,
        OPENED,
        CLOSED,
        MOVING,
        SCROLLING
    }

    public interface OnScrollChangedListener {
        void H(float f);

        void I(int i);

        void p(Status status);
    }

    public interface OnTouchEventListener {
        void a(MotionEvent motionEvent);
    }

    public enum Status {
        EXIT,
        OPENED,
        CLOSED
    }

    public ScrollLayout(Context context) {
        super(context);
        l();
    }

    public void computeScroll() {
        if (!this.h.isFinished() && this.h.computeScrollOffset()) {
            int currY = this.h.getCurrY();
            scrollTo(0, currY);
            if (currY == (-this.r) || currY == (-this.q) || (this.k && currY == (-this.s))) {
                this.h.abortAnimation();
            } else {
                invalidate();
            }
        }
    }

    public final void g() {
        float f2 = -(((float) (this.q - this.r)) * 0.5f);
        if (((float) getScrollY()) > f2) {
            p();
        } else if (this.k) {
            int i2 = this.s;
            int i3 = this.q;
            float f3 = -((((float) (i2 - i3)) * 0.8f) + ((float) i3));
            if (((float) getScrollY()) > f2 || ((float) getScrollY()) <= f3) {
                q();
            } else {
                r();
            }
        } else {
            r();
        }
    }

    public Status getCurrentStatus() {
        int i2 = AnonymousClass4.f5848a[this.p.ordinal()];
        return i2 != 1 ? i2 != 2 ? i2 != 3 ? Status.OPENED : Status.EXIT : Status.OPENED : Status.CLOSED;
    }

    public int getExitOffset() {
        return this.s;
    }

    public int getMaxOffset() {
        return this.q;
    }

    public int getMinOffset() {
        return this.r;
    }

    public int getScreenHeight() {
        Display defaultDisplay = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics);
        int i2 = displayMetrics.heightPixels;
        try {
            Point point = new Point();
            Display.class.getMethod("getRealSize", new Class[]{Point.class}).invoke(defaultDisplay, new Object[]{point});
            i2 = point.y;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        Resources resources = getContext().getResources();
        int identifier = resources.getIdentifier("status_bar_height", "dimen", "android");
        return i2 - (identifier > 0 ? resources.getDimensionPixelSize(identifier) : 0);
    }

    public final boolean h(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        this.d = y;
        this.e = x;
        this.f = y;
        this.n = true;
        this.o = false;
        if (this.h.isFinished()) {
            return false;
        }
        this.h.forceFinished(true);
        this.p = InnerStatus.MOVING;
        this.o = true;
        return true;
    }

    public final boolean i(MotionEvent motionEvent) {
        if (!this.n) {
            return false;
        }
        if (this.o) {
            return true;
        }
        int y = (int) (motionEvent.getY() - this.f);
        int x = (int) (motionEvent.getX() - this.e);
        if (Math.abs(y) < 10) {
            return false;
        }
        if (Math.abs(y) >= Math.abs(x) || !this.l) {
            InnerStatus innerStatus = this.p;
            if (innerStatus == InnerStatus.CLOSED) {
                if (y < 0) {
                    return false;
                }
            } else if (innerStatus == InnerStatus.OPENED && !this.k && y > 0) {
                return false;
            }
            this.o = true;
            return true;
        }
        this.n = false;
        this.o = false;
        return false;
    }

    public final boolean j(int i2) {
        return this.k ? (i2 <= 0 && getScrollY() >= (-this.r)) || (i2 >= 0 && getScrollY() <= (-this.s)) : (i2 <= 0 && getScrollY() >= (-this.r)) || (i2 >= 0 && getScrollY() <= (-this.q));
    }

    public final void k(Context context, AttributeSet attributeSet) {
        int dimensionPixelOffset;
        int dimensionPixelOffset2;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ScrollLayout);
        if (obtainStyledAttributes.hasValue(R.styleable.ScrollLayout_maxOffset) && (dimensionPixelOffset2 = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.ScrollLayout_maxOffset, this.q)) != getScreenHeight()) {
            this.q = getScreenHeight() - dimensionPixelOffset2;
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ScrollLayout_minOffset)) {
            this.r = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.ScrollLayout_minOffset, this.r);
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ScrollLayout_exitOffset) && (dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.ScrollLayout_exitOffset, getScreenHeight())) != getScreenHeight()) {
            this.s = getScreenHeight() - dimensionPixelOffset;
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ScrollLayout_allowHorizontalScroll)) {
            this.l = obtainStyledAttributes.getBoolean(R.styleable.ScrollLayout_allowHorizontalScroll, true);
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ScrollLayout_isSupportExit)) {
            this.k = obtainStyledAttributes.getBoolean(R.styleable.ScrollLayout_isSupportExit, true);
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ScrollLayout_mode)) {
            int integer = obtainStyledAttributes.getInteger(R.styleable.ScrollLayout_mode, 0);
            if (integer == 0) {
                u();
            } else if (integer == 1) {
                s();
            } else if (integer != 2) {
                s();
            } else {
                t();
            }
        }
        obtainStyledAttributes.recycle();
    }

    public final void l() {
        this.h = new Scroller(getContext(), (Interpolator) null, true);
        this.i = new GestureDetector(getContext(), this.f5844a);
    }

    public final /* synthetic */ void m(int i2, int i3, int i4, int i5) {
        if (this.u != null) {
            OnScrollChangedListener onScrollChangedListener = this.t;
            if (onScrollChangedListener != null) {
                onScrollChangedListener.I(i5);
            }
            setDraggable(this.u.getScrollY() == 0);
        }
    }

    public final void n(Status status) {
        OnScrollChangedListener onScrollChangedListener = this.t;
        if (onScrollChangedListener != null) {
            onScrollChangedListener.p(status);
        }
    }

    public final void o(float f2) {
        OnScrollChangedListener onScrollChangedListener = this.t;
        if (onScrollChangedListener != null) {
            onScrollChangedListener.H(f2);
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.j) {
            return false;
        }
        if (!this.m && this.p == InnerStatus.CLOSED) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            return h(motionEvent);
        }
        if (action != 1) {
            if (action == 2) {
                return i(motionEvent);
            }
            if (action != 3) {
                return false;
            }
        }
        this.n = true;
        this.o = false;
        return this.p == InnerStatus.MOVING;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.o) {
            return false;
        }
        OnTouchEventListener onTouchEventListener = this.v;
        if (onTouchEventListener != null) {
            onTouchEventListener.a(motionEvent);
        }
        this.i.onTouchEvent(motionEvent);
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    int y = (int) ((motionEvent.getY() - this.d) * 1.2f);
                    int signum = ((int) Math.signum((float) y)) * Math.min(Math.abs(y), 30);
                    if (j(signum)) {
                        return true;
                    }
                    this.p = InnerStatus.MOVING;
                    int scrollY = getScrollY() - signum;
                    int i2 = this.r;
                    if (scrollY >= (-i2)) {
                        scrollTo(0, -i2);
                    } else {
                        int i3 = this.q;
                        if (scrollY > (-i3) || this.k) {
                            scrollTo(0, scrollY);
                        } else {
                            scrollTo(0, -i3);
                        }
                    }
                    this.d = motionEvent.getY();
                    return true;
                } else if (action != 3) {
                    return false;
                }
            }
            if (this.p != InnerStatus.MOVING) {
                return false;
            }
            g();
            return true;
        }
        this.d = motionEvent.getY();
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000e, code lost:
        r1 = r8.r;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void p() {
        /*
            r8 = this;
            com.upuphone.ar.navi.lite.view.ScrollLayout$InnerStatus r0 = r8.p
            com.upuphone.ar.navi.lite.view.ScrollLayout$InnerStatus r1 = com.upuphone.ar.navi.lite.view.ScrollLayout.InnerStatus.CLOSED
            if (r0 != r1) goto L_0x0007
            return
        L_0x0007:
            int r0 = r8.q
            int r1 = r8.r
            if (r0 != r1) goto L_0x000e
            return
        L_0x000e:
            int r0 = r8.getScrollY()
            int r0 = -r0
            int r1 = r8.r
            int r6 = r0 - r1
            if (r6 != 0) goto L_0x001a
            return
        L_0x001a:
            com.upuphone.ar.navi.lite.view.ScrollLayout$InnerStatus r0 = com.upuphone.ar.navi.lite.view.ScrollLayout.InnerStatus.SCROLLING
            r8.p = r0
            int r0 = r6 * 300
            int r2 = r8.q
            int r2 = r2 - r1
            int r0 = r0 / r2
            int r0 = java.lang.Math.abs(r0)
            int r7 = r0 + 100
            android.widget.Scroller r2 = r8.h
            int r4 = r8.getScrollY()
            r5 = 0
            r3 = 0
            r2.startScroll(r3, r4, r5, r6, r7)
            r8.invalidate()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.navi.lite.view.ScrollLayout.p():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0013, code lost:
        r1 = r8.s;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void q() {
        /*
            r8 = this;
            boolean r0 = r8.k
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            com.upuphone.ar.navi.lite.view.ScrollLayout$InnerStatus r0 = r8.p
            com.upuphone.ar.navi.lite.view.ScrollLayout$InnerStatus r1 = com.upuphone.ar.navi.lite.view.ScrollLayout.InnerStatus.EXIT
            if (r0 != r1) goto L_0x000c
            return
        L_0x000c:
            int r0 = r8.s
            int r1 = r8.q
            if (r0 != r1) goto L_0x0013
            return
        L_0x0013:
            int r0 = r8.getScrollY()
            int r0 = -r0
            int r1 = r8.s
            int r6 = r0 - r1
            if (r6 != 0) goto L_0x001f
            return
        L_0x001f:
            com.upuphone.ar.navi.lite.view.ScrollLayout$InnerStatus r0 = com.upuphone.ar.navi.lite.view.ScrollLayout.InnerStatus.SCROLLING
            r8.p = r0
            int r0 = r6 * 300
            int r2 = r8.q
            int r1 = r1 - r2
            int r0 = r0 / r1
            int r0 = java.lang.Math.abs(r0)
            int r7 = r0 + 100
            android.widget.Scroller r2 = r8.h
            int r4 = r8.getScrollY()
            r5 = 0
            r3 = 0
            r2.startScroll(r3, r4, r5, r6, r7)
            r8.invalidate()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.navi.lite.view.ScrollLayout.q():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000e, code lost:
        r1 = r8.q;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void r() {
        /*
            r8 = this;
            com.upuphone.ar.navi.lite.view.ScrollLayout$InnerStatus r0 = r8.p
            com.upuphone.ar.navi.lite.view.ScrollLayout$InnerStatus r1 = com.upuphone.ar.navi.lite.view.ScrollLayout.InnerStatus.OPENED
            if (r0 != r1) goto L_0x0007
            return
        L_0x0007:
            int r0 = r8.q
            int r1 = r8.r
            if (r0 != r1) goto L_0x000e
            return
        L_0x000e:
            int r0 = r8.getScrollY()
            int r0 = -r0
            int r1 = r8.q
            int r6 = r0 - r1
            if (r6 != 0) goto L_0x001a
            return
        L_0x001a:
            com.upuphone.ar.navi.lite.view.ScrollLayout$InnerStatus r0 = com.upuphone.ar.navi.lite.view.ScrollLayout.InnerStatus.SCROLLING
            r8.p = r0
            int r0 = r6 * 300
            int r2 = r8.r
            int r1 = r1 - r2
            int r0 = r0 / r1
            int r0 = java.lang.Math.abs(r0)
            int r7 = r0 + 100
            android.widget.Scroller r2 = r8.h
            int r4 = r8.getScrollY()
            r5 = 0
            r3 = 0
            r2.startScroll(r3, r4, r5, r6, r7)
            r8.invalidate()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.navi.lite.view.ScrollLayout.r():void");
    }

    public void s() {
        scrollTo(0, -this.r);
        this.p = InnerStatus.CLOSED;
        this.g = Status.CLOSED;
    }

    public void scrollTo(int i2, int i3) {
        InnerStatus innerStatus;
        super.scrollTo(i2, i3);
        int i4 = this.q;
        int i5 = this.r;
        if (i4 != i5) {
            int i6 = -i3;
            if (i6 <= i4) {
                o(((float) (i6 - i5)) / ((float) (i4 - i5)));
            } else {
                o(((float) (i6 - i4)) / ((float) (i4 - this.s)));
            }
            if (i3 == (-this.r)) {
                InnerStatus innerStatus2 = this.p;
                InnerStatus innerStatus3 = InnerStatus.CLOSED;
                if (innerStatus2 != innerStatus3) {
                    this.p = innerStatus3;
                    n(Status.CLOSED);
                }
            } else if (i3 == (-this.q)) {
                InnerStatus innerStatus4 = this.p;
                InnerStatus innerStatus5 = InnerStatus.OPENED;
                if (innerStatus4 != innerStatus5) {
                    this.p = innerStatus5;
                    n(Status.OPENED);
                }
            } else if (this.k && i3 == (-this.s) && this.p != (innerStatus = InnerStatus.EXIT)) {
                this.p = innerStatus;
                n(Status.EXIT);
            }
        }
    }

    public void setAllowHorizontalScroll(boolean z) {
        this.l = z;
    }

    public void setAssociatedListView(AbsListView absListView) {
        absListView.setOnScrollListener(this.b);
        v(absListView);
    }

    public void setAssociatedRecyclerView(RecyclerView recyclerView) {
        recyclerView.addOnScrollListener(this.c);
        w(recyclerView);
    }

    public void setAssociatedScrollView(ContentScrollView contentScrollView) {
        this.u = contentScrollView;
        contentScrollView.setScrollbarFadingEnabled(false);
        this.u.setOnScrollChangeListener(new u(this));
    }

    public void setDraggable(boolean z) {
        this.m = z;
    }

    public void setEnable(boolean z) {
        this.j = z;
    }

    public void setExitOffset(int i2) {
        this.s = getScreenHeight() - i2;
    }

    public void setIsSupportExit(boolean z) {
        this.k = z;
    }

    public void setMaxOffset(int i2) {
        this.q = getScreenHeight() - i2;
    }

    public void setMinOffset(int i2) {
        this.r = i2;
    }

    public void setOnScrollChangedListener(OnScrollChangedListener onScrollChangedListener) {
        this.t = onScrollChangedListener;
    }

    public void setOnTouchEventListener(OnTouchEventListener onTouchEventListener) {
        this.v = onTouchEventListener;
    }

    public void t() {
        if (this.k) {
            scrollTo(0, -this.s);
            this.p = InnerStatus.EXIT;
        }
    }

    public void u() {
        scrollTo(0, -this.q);
        this.p = InnerStatus.OPENED;
        this.g = Status.OPENED;
    }

    public final void v(AbsListView absListView) {
        if (absListView.getChildCount() == 0) {
            setDraggable(true);
        } else if (absListView.getFirstVisiblePosition() == 0 && absListView.getChildAt(0).getTop() == absListView.getPaddingTop()) {
            setDraggable(true);
        } else {
            setDraggable(false);
        }
    }

    public final void w(RecyclerView recyclerView) {
        if (recyclerView.getChildCount() == 0) {
            setDraggable(true);
            return;
        }
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        int[] iArr = new int[1];
        if ((layoutManager instanceof LinearLayoutManager) || (layoutManager instanceof GridLayoutManager)) {
            iArr[0] = ((LinearLayoutManager) layoutManager).findFirstVisibleItemPosition();
        } else if (layoutManager instanceof StaggeredGridLayoutManager) {
            iArr = ((StaggeredGridLayoutManager) layoutManager).findFirstVisibleItemPositions((int[]) null);
        }
        if (iArr[0] == 0 && recyclerView.getChildAt(0).getTop() == recyclerView.getPaddingTop()) {
            setDraggable(true);
        } else {
            setDraggable(false);
        }
    }

    public ScrollLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        l();
        k(context, attributeSet);
    }

    public ScrollLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        l();
        k(context, attributeSet);
    }
}
