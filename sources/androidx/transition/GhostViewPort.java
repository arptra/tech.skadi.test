package androidx.transition;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.core.view.ViewCompat;

@SuppressLint({"ViewConstructor"})
class GhostViewPort extends ViewGroup implements GhostView {

    /* renamed from: a  reason: collision with root package name */
    public ViewGroup f1854a;
    public View b;
    public final View c;
    public int d;
    public Matrix e;
    public final ViewTreeObserver.OnPreDrawListener f = new ViewTreeObserver.OnPreDrawListener() {
        public boolean onPreDraw() {
            View view;
            ViewCompat.k0(GhostViewPort.this);
            GhostViewPort ghostViewPort = GhostViewPort.this;
            ViewGroup viewGroup = ghostViewPort.f1854a;
            if (viewGroup == null || (view = ghostViewPort.b) == null) {
                return true;
            }
            viewGroup.endViewTransition(view);
            ViewCompat.k0(GhostViewPort.this.f1854a);
            GhostViewPort ghostViewPort2 = GhostViewPort.this;
            ghostViewPort2.f1854a = null;
            ghostViewPort2.b = null;
            return true;
        }
    };

    public GhostViewPort(View view) {
        super(view.getContext());
        this.c = view;
        setWillNotDraw(false);
        setClipChildren(false);
        setLayerType(2, (Paint) null);
    }

    public static GhostViewPort b(View view, ViewGroup viewGroup, Matrix matrix) {
        int i;
        GhostViewHolder ghostViewHolder;
        if (view.getParent() instanceof ViewGroup) {
            GhostViewHolder b2 = GhostViewHolder.b(viewGroup);
            GhostViewPort e2 = e(view);
            if (e2 == null || (ghostViewHolder = (GhostViewHolder) e2.getParent()) == b2) {
                i = 0;
            } else {
                i = e2.d;
                ghostViewHolder.removeView(e2);
                e2 = null;
            }
            if (e2 == null) {
                if (matrix == null) {
                    matrix = new Matrix();
                    c(view, viewGroup, matrix);
                }
                e2 = new GhostViewPort(view);
                e2.h(matrix);
                if (b2 == null) {
                    b2 = new GhostViewHolder(viewGroup);
                } else {
                    b2.g();
                }
                d(viewGroup, b2);
                d(viewGroup, e2);
                b2.a(e2);
                e2.d = i;
            } else if (matrix != null) {
                e2.h(matrix);
            }
            e2.d++;
            return e2;
        }
        throw new IllegalArgumentException("Ghosted views must be parented by a ViewGroup");
    }

    public static void c(View view, ViewGroup viewGroup, Matrix matrix) {
        ViewGroup viewGroup2 = (ViewGroup) view.getParent();
        matrix.reset();
        ViewUtils.j(viewGroup2, matrix);
        matrix.preTranslate((float) (-viewGroup2.getScrollX()), (float) (-viewGroup2.getScrollY()));
        ViewUtils.k(viewGroup, matrix);
    }

    public static void d(View view, View view2) {
        ViewUtils.g(view2, view2.getLeft(), view2.getTop(), view2.getLeft() + view.getWidth(), view2.getTop() + view.getHeight());
    }

    public static GhostViewPort e(View view) {
        return (GhostViewPort) view.getTag(R.id.ghost_view);
    }

    public static void f(View view) {
        GhostViewPort e2 = e(view);
        if (e2 != null) {
            int i = e2.d - 1;
            e2.d = i;
            if (i <= 0) {
                ((GhostViewHolder) e2.getParent()).removeView(e2);
            }
        }
    }

    public static void g(View view, GhostViewPort ghostViewPort) {
        view.setTag(R.id.ghost_view, ghostViewPort);
    }

    public void a(ViewGroup viewGroup, View view) {
        this.f1854a = viewGroup;
        this.b = view;
    }

    public void h(Matrix matrix) {
        this.e = matrix;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        g(this.c, this);
        this.c.getViewTreeObserver().addOnPreDrawListener(this.f);
        ViewUtils.i(this.c, 4);
        if (this.c.getParent() != null) {
            ((View) this.c.getParent()).invalidate();
        }
    }

    public void onDetachedFromWindow() {
        this.c.getViewTreeObserver().removeOnPreDrawListener(this.f);
        ViewUtils.i(this.c, 0);
        g(this.c, (GhostViewPort) null);
        if (this.c.getParent() != null) {
            ((View) this.c.getParent()).invalidate();
        }
        super.onDetachedFromWindow();
    }

    public void onDraw(Canvas canvas) {
        CanvasUtils.a(canvas, true);
        canvas.setMatrix(this.e);
        ViewUtils.i(this.c, 0);
        this.c.invalidate();
        ViewUtils.i(this.c, 4);
        drawChild(canvas, this.c, getDrawingTime());
        CanvasUtils.a(canvas, false);
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
    }

    public void setVisibility(int i) {
        super.setVisibility(i);
        if (e(this.c) == this) {
            ViewUtils.i(this.c, i == 0 ? 4 : 0);
        }
    }
}
