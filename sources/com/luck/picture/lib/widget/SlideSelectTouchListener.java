package com.luck.picture.lib.widget;

import android.content.Context;
import android.content.res.Resources;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.OverScroller;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;

public class SlideSelectTouchListener implements RecyclerView.OnItemTouchListener {

    /* renamed from: a  reason: collision with root package name */
    public boolean f9486a;
    public int b;
    public int c;
    public boolean d;
    public boolean e;
    public int f;
    public float g;
    public float h;
    public int i;
    public int j;
    public OnSlideSelectListener k;
    public RecyclerView l;
    public OverScroller m;
    public final Runnable n = new Runnable() {
        public void run() {
            if (SlideSelectTouchListener.this.m != null && SlideSelectTouchListener.this.m.computeScrollOffset()) {
                SlideSelectTouchListener slideSelectTouchListener = SlideSelectTouchListener.this;
                slideSelectTouchListener.l(slideSelectTouchListener.f);
                ViewCompat.l0(SlideSelectTouchListener.this.l, SlideSelectTouchListener.this.n);
            }
        }
    };
    public int o;
    public int p;
    public int q;
    public int r;
    public int s = 16;
    public int t = ((int) (Resources.getSystem().getDisplayMetrics().density * 56.0f));
    public int u = 0;
    public int v = 0;
    public boolean w = true;
    public boolean x = true;
    public int y;

    public interface OnAdvancedSlideSelectListener extends OnSlideSelectListener {
        void a(int i);

        void b(int i);
    }

    public interface OnSlideSelectListener {
        void c(int i, int i2, boolean z);
    }

    public SlideSelectTouchListener() {
        k();
    }

    public final void f(RecyclerView recyclerView, float f2, float f3) {
        int childAdapterPosition;
        View findChildViewUnder = recyclerView.findChildViewUnder(f2, f3);
        if (findChildViewUnder != null && (childAdapterPosition = recyclerView.getChildAdapterPosition(findChildViewUnder) - this.y) != -1 && this.c != childAdapterPosition) {
            this.c = childAdapterPosition;
            i();
        }
    }

    public final void g(RecyclerView recyclerView, MotionEvent motionEvent) {
        f(recyclerView, motionEvent.getX(), motionEvent.getY());
    }

    public final void h(Context context) {
        if (this.m == null) {
            this.m = new OverScroller(context, new LinearInterpolator());
        }
    }

    public final void i() {
        int i2;
        int i3;
        if (this.k != null && (i2 = this.b) != -1 && (i3 = this.c) != -1) {
            int min = Math.min(i2, i3);
            int max = Math.max(this.b, this.c);
            if (min >= 0) {
                int i4 = this.i;
                if (i4 != -1 && this.j != -1) {
                    if (min > i4) {
                        this.k.c(i4, min - 1, false);
                    } else if (min < i4) {
                        this.k.c(min, i4 - 1, true);
                    }
                    int i5 = this.j;
                    if (max > i5) {
                        this.k.c(i5 + 1, max, true);
                    } else if (max < i5) {
                        this.k.c(max + 1, i5, false);
                    }
                } else if (max - min == 1) {
                    this.k.c(min, min, true);
                } else {
                    this.k.c(min, max, true);
                }
                this.i = min;
                this.j = max;
            }
        }
    }

    public final void j(MotionEvent motionEvent) {
        int y2 = (int) motionEvent.getY();
        int i2 = this.o;
        if (y2 >= i2 && y2 <= this.p) {
            this.g = motionEvent.getX();
            this.h = motionEvent.getY();
            int i3 = this.p;
            int i4 = this.o;
            this.f = (int) (((float) this.s) * (((((float) i3) - ((float) i4)) - (((float) y2) - ((float) i4))) / (((float) i3) - ((float) i4))) * -1.0f);
            if (!this.d) {
                this.d = true;
                o();
            }
        } else if (this.w && y2 < i2) {
            this.g = motionEvent.getX();
            this.h = motionEvent.getY();
            this.f = this.s * -1;
            if (!this.d) {
                this.d = true;
                o();
            }
        } else if (y2 >= this.q && y2 <= this.r) {
            this.g = motionEvent.getX();
            this.h = motionEvent.getY();
            float f2 = (float) y2;
            int i5 = this.q;
            this.f = (int) (((float) this.s) * ((f2 - ((float) i5)) / (((float) this.r) - ((float) i5))));
            if (!this.e) {
                this.e = true;
                o();
            }
        } else if (!this.x || y2 <= this.r) {
            this.e = false;
            this.d = false;
            this.g = Float.MIN_VALUE;
            this.h = Float.MIN_VALUE;
            q();
        } else {
            this.g = motionEvent.getX();
            this.h = motionEvent.getY();
            this.f = this.s;
            if (!this.d) {
                this.d = true;
                o();
            }
        }
    }

    public final void k() {
        m(false);
        OnSlideSelectListener onSlideSelectListener = this.k;
        if (onSlideSelectListener != null && (onSlideSelectListener instanceof OnAdvancedSlideSelectListener)) {
            ((OnAdvancedSlideSelectListener) onSlideSelectListener).a(this.c);
        }
        this.b = -1;
        this.c = -1;
        this.i = -1;
        this.j = -1;
        this.d = false;
        this.e = false;
        this.g = Float.MIN_VALUE;
        this.h = Float.MIN_VALUE;
        q();
    }

    public final void l(int i2) {
        this.l.scrollBy(0, i2 > 0 ? Math.min(i2, this.s) : Math.max(i2, -this.s));
        float f2 = this.g;
        if (f2 != Float.MIN_VALUE) {
            float f3 = this.h;
            if (f3 != Float.MIN_VALUE) {
                f(this.l, f2, f3);
            }
        }
    }

    public void m(boolean z) {
        this.f9486a = z;
    }

    public SlideSelectTouchListener n(int i2) {
        this.y = i2;
        return this;
    }

    public void o() {
        RecyclerView recyclerView = this.l;
        if (recyclerView != null) {
            h(recyclerView.getContext());
            if (this.m.isFinished()) {
                this.l.removeCallbacks(this.n);
                OverScroller overScroller = this.m;
                overScroller.startScroll(0, overScroller.getCurrY(), 0, 5000, 100000);
                ViewCompat.l0(this.l, this.n);
            }
        }
    }

    public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        if (!this.f9486a || recyclerView.getAdapter() == null || recyclerView.getAdapter().getItemCount() == 0) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 0 || action == 5) {
            k();
        }
        this.l = recyclerView;
        int height = recyclerView.getHeight();
        int i2 = this.u;
        this.o = i2;
        int i3 = this.t;
        this.p = i2 + i3;
        int i4 = this.v;
        this.q = (height + i4) - i3;
        this.r = height + i4;
        return true;
    }

    public void onRequestDisallowInterceptTouchEvent(boolean z) {
    }

    public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        if (!this.f9486a) {
            k();
            return;
        }
        int action = motionEvent.getAction();
        if (action != 1) {
            if (action == 2) {
                if (!this.d && !this.e) {
                    g(recyclerView, motionEvent);
                }
                j(motionEvent);
                return;
            } else if (!(action == 3 || action == 6)) {
                return;
            }
        }
        k();
    }

    public void p(int i2) {
        m(true);
        this.b = i2;
        this.c = i2;
        this.i = i2;
        this.j = i2;
        OnSlideSelectListener onSlideSelectListener = this.k;
        if (onSlideSelectListener != null && (onSlideSelectListener instanceof OnAdvancedSlideSelectListener)) {
            ((OnAdvancedSlideSelectListener) onSlideSelectListener).b(i2);
        }
    }

    public void q() {
        try {
            OverScroller overScroller = this.m;
            if (overScroller != null && !overScroller.isFinished()) {
                this.l.removeCallbacks(this.n);
                this.m.abortAnimation();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public SlideSelectTouchListener r(OnSlideSelectListener onSlideSelectListener) {
        this.k = onSlideSelectListener;
        return this;
    }
}
