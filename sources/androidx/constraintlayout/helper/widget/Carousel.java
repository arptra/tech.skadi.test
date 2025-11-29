package androidx.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import androidx.constraintlayout.motion.widget.MotionHelper;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.motion.widget.MotionScene;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.R;
import com.honey.account.j.a;
import java.util.ArrayList;

public class Carousel extends MotionHelper {
    public int A = 4;
    public int B = 1;
    public float C = 2.0f;
    public int D = -1;
    public int E = 200;
    public int F = -1;
    public Runnable G = new Runnable() {
        public void run() {
            Carousel.this.r.setProgress(0.0f);
            Carousel.this.R();
            Carousel.this.n.a(Carousel.this.q);
            float velocity = Carousel.this.r.getVelocity();
            if (Carousel.this.B == 2 && velocity > Carousel.this.C && Carousel.this.q < Carousel.this.n.count() - 1) {
                final float M = velocity * Carousel.this.y;
                if (Carousel.this.q == 0 && Carousel.this.p > Carousel.this.q) {
                    return;
                }
                if (Carousel.this.q != Carousel.this.n.count() - 1 || Carousel.this.p >= Carousel.this.q) {
                    Carousel.this.r.post(new Runnable() {
                        public void run() {
                            Carousel.this.r.h0(5, 1.0f, M);
                        }
                    });
                }
            }
        }
    };
    public Adapter n = null;
    public final ArrayList o = new ArrayList();
    public int p = 0;
    public int q = 0;
    public MotionLayout r;
    public int s = -1;
    public boolean t = false;
    public int u = -1;
    public int v = -1;
    public int w = -1;
    public int x = -1;
    public float y = 0.9f;
    public int z = 0;

    public interface Adapter {
        void a(int i);

        void b(View view, int i);

        int count();
    }

    public Carousel(Context context) {
        super(context);
    }

    public final boolean O(int i, boolean z2) {
        MotionLayout motionLayout;
        MotionScene.Transition U;
        if (i == -1 || (motionLayout = this.r) == null || (U = motionLayout.U(i)) == null || z2 == U.C()) {
            return false;
        }
        U.F(z2);
        return true;
    }

    public final void P(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Carousel);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == R.styleable.Carousel_carousel_firstView) {
                    this.s = obtainStyledAttributes.getResourceId(index, this.s);
                } else if (index == R.styleable.Carousel_carousel_backwardTransition) {
                    this.u = obtainStyledAttributes.getResourceId(index, this.u);
                } else if (index == R.styleable.Carousel_carousel_forwardTransition) {
                    this.v = obtainStyledAttributes.getResourceId(index, this.v);
                } else if (index == R.styleable.Carousel_carousel_emptyViewsBehavior) {
                    this.A = obtainStyledAttributes.getInt(index, this.A);
                } else if (index == R.styleable.Carousel_carousel_previousState) {
                    this.w = obtainStyledAttributes.getResourceId(index, this.w);
                } else if (index == R.styleable.Carousel_carousel_nextState) {
                    this.x = obtainStyledAttributes.getResourceId(index, this.x);
                } else if (index == R.styleable.Carousel_carousel_touchUp_dampeningFactor) {
                    this.y = obtainStyledAttributes.getFloat(index, this.y);
                } else if (index == R.styleable.Carousel_carousel_touchUpMode) {
                    this.B = obtainStyledAttributes.getInt(index, this.B);
                } else if (index == R.styleable.Carousel_carousel_touchUp_velocityThreshold) {
                    this.C = obtainStyledAttributes.getFloat(index, this.C);
                } else if (index == R.styleable.Carousel_carousel_infinite) {
                    this.t = obtainStyledAttributes.getBoolean(index, this.t);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public final /* synthetic */ void Q() {
        this.r.setTransitionDuration(this.E);
        if (this.D < this.q) {
            this.r.m0(this.w, this.E);
        } else {
            this.r.m0(this.x, this.E);
        }
    }

    public final void R() {
        Adapter adapter = this.n;
        if (adapter != null && this.r != null && adapter.count() != 0) {
            int size = this.o.size();
            for (int i = 0; i < size; i++) {
                View view = (View) this.o.get(i);
                int i2 = (this.q + i) - this.z;
                if (this.t) {
                    if (i2 < 0) {
                        int i3 = this.A;
                        if (i3 != 4) {
                            T(view, i3);
                        } else {
                            T(view, 0);
                        }
                        if (i2 % this.n.count() == 0) {
                            this.n.b(view, 0);
                        } else {
                            Adapter adapter2 = this.n;
                            adapter2.b(view, adapter2.count() + (i2 % this.n.count()));
                        }
                    } else if (i2 >= this.n.count()) {
                        if (i2 == this.n.count()) {
                            i2 = 0;
                        } else if (i2 > this.n.count()) {
                            i2 %= this.n.count();
                        }
                        int i4 = this.A;
                        if (i4 != 4) {
                            T(view, i4);
                        } else {
                            T(view, 0);
                        }
                        this.n.b(view, i2);
                    } else {
                        T(view, 0);
                        this.n.b(view, i2);
                    }
                } else if (i2 < 0) {
                    T(view, this.A);
                } else if (i2 >= this.n.count()) {
                    T(view, this.A);
                } else {
                    T(view, 0);
                    this.n.b(view, i2);
                }
            }
            int i5 = this.D;
            if (i5 != -1 && i5 != this.q) {
                this.r.post(new a(this));
            } else if (i5 == this.q) {
                this.D = -1;
            }
            if (this.u == -1 || this.v == -1) {
                Log.w("Carousel", "No backward or forward transitions defined for Carousel!");
            } else if (!this.t) {
                int count = this.n.count();
                if (this.q == 0) {
                    O(this.u, false);
                } else {
                    O(this.u, true);
                    this.r.setTransition(this.u);
                }
                if (this.q == count - 1) {
                    O(this.v, false);
                    return;
                }
                O(this.v, true);
                this.r.setTransition(this.v);
            }
        }
    }

    public final boolean S(int i, View view, int i2) {
        ConstraintSet.Constraint w2;
        ConstraintSet S = this.r.S(i);
        if (S == null || (w2 = S.w(view.getId())) == null) {
            return false;
        }
        w2.c.c = 1;
        view.setVisibility(i2);
        return true;
    }

    public final boolean T(View view, int i) {
        MotionLayout motionLayout = this.r;
        if (motionLayout == null) {
            return false;
        }
        int[] constraintSetIds = motionLayout.getConstraintSetIds();
        boolean z2 = false;
        for (int S : constraintSetIds) {
            z2 |= S(S, view, i);
        }
        return z2;
    }

    public void a(MotionLayout motionLayout, int i, int i2, float f) {
        this.F = i;
    }

    public void b(MotionLayout motionLayout, int i) {
        int i2 = this.q;
        this.p = i2;
        if (i == this.x) {
            this.q = i2 + 1;
        } else if (i == this.w) {
            this.q = i2 - 1;
        }
        if (this.t) {
            if (this.q >= this.n.count()) {
                this.q = 0;
            }
            if (this.q < 0) {
                this.q = this.n.count() - 1;
            }
        } else {
            if (this.q >= this.n.count()) {
                this.q = this.n.count() - 1;
            }
            if (this.q < 0) {
                this.q = 0;
            }
        }
        if (this.p != this.q) {
            this.r.post(this.G);
        }
    }

    public int getCount() {
        Adapter adapter = this.n;
        if (adapter != null) {
            return adapter.count();
        }
        return 0;
    }

    public int getCurrentIndex() {
        return this.q;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (getParent() instanceof MotionLayout) {
            MotionLayout motionLayout = (MotionLayout) getParent();
            for (int i = 0; i < this.b; i++) {
                int i2 = this.f601a[i];
                View viewById = motionLayout.getViewById(i2);
                if (this.s == i2) {
                    this.z = i;
                }
                this.o.add(viewById);
            }
            this.r = motionLayout;
            if (this.B == 2) {
                MotionScene.Transition U = motionLayout.U(this.v);
                if (U != null) {
                    U.H(5);
                }
                MotionScene.Transition U2 = this.r.U(this.u);
                if (U2 != null) {
                    U2.H(5);
                }
            }
            R();
        }
    }

    public void setAdapter(Adapter adapter) {
        this.n = adapter;
    }

    public Carousel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        P(context, attributeSet);
    }

    public Carousel(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        P(context, attributeSet);
    }
}
