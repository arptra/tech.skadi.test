package androidx.constraintlayout.motion.widget;

import android.graphics.Rect;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import androidx.constraintlayout.motion.widget.ViewTransition;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.SharedValues;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class ViewTransitionController {

    /* renamed from: a  reason: collision with root package name */
    public final MotionLayout f583a;
    public ArrayList b = new ArrayList();
    public HashSet c;
    public String d = "ViewTransitionController";
    public ArrayList e;
    public ArrayList f = new ArrayList();

    public ViewTransitionController(MotionLayout motionLayout) {
        this.f583a = motionLayout;
    }

    public void a(ViewTransition viewTransition) {
        this.b.add(viewTransition);
        this.c = null;
        if (viewTransition.i() == 4) {
            f(viewTransition, true);
        } else if (viewTransition.i() == 5) {
            f(viewTransition, false);
        }
    }

    public void b(ViewTransition.Animate animate) {
        if (this.e == null) {
            this.e = new ArrayList();
        }
        this.e.add(animate);
    }

    public void c() {
        ArrayList arrayList = this.e;
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((ViewTransition.Animate) it.next()).a();
            }
            this.e.removeAll(this.f);
            this.f.clear();
            if (this.e.isEmpty()) {
                this.e = null;
            }
        }
    }

    public boolean d(int i, MotionController motionController) {
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            ViewTransition viewTransition = (ViewTransition) it.next();
            if (viewTransition.e() == i) {
                viewTransition.f.a(motionController);
                return true;
            }
        }
        return false;
    }

    public void e() {
        this.f583a.invalidate();
    }

    public final void f(ViewTransition viewTransition, boolean z) {
        final int h = viewTransition.h();
        final int g = viewTransition.g();
        final ViewTransition viewTransition2 = viewTransition;
        final boolean z2 = z;
        ConstraintLayout.getSharedValues().a(viewTransition.h(), new SharedValues.SharedValuesListener() {
        });
    }

    public void g(ViewTransition.Animate animate) {
        this.f.add(animate);
    }

    public void h(MotionEvent motionEvent) {
        int currentState = this.f583a.getCurrentState();
        if (currentState != -1) {
            if (this.c == null) {
                this.c = new HashSet();
                Iterator it = this.b.iterator();
                while (it.hasNext()) {
                    ViewTransition viewTransition = (ViewTransition) it.next();
                    int childCount = this.f583a.getChildCount();
                    for (int i = 0; i < childCount; i++) {
                        View childAt = this.f583a.getChildAt(i);
                        if (viewTransition.k(childAt)) {
                            childAt.getId();
                            this.c.add(childAt);
                        }
                    }
                }
            }
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            Rect rect = new Rect();
            int action = motionEvent.getAction();
            ArrayList arrayList = this.e;
            if (arrayList != null && !arrayList.isEmpty()) {
                Iterator it2 = this.e.iterator();
                while (it2.hasNext()) {
                    ((ViewTransition.Animate) it2.next()).d(action, x, y);
                }
            }
            if (action == 0 || action == 1) {
                ConstraintSet S = this.f583a.S(currentState);
                Iterator it3 = this.b.iterator();
                while (it3.hasNext()) {
                    ViewTransition viewTransition2 = (ViewTransition) it3.next();
                    if (viewTransition2.m(action)) {
                        Iterator it4 = this.c.iterator();
                        while (it4.hasNext()) {
                            View view = (View) it4.next();
                            if (viewTransition2.k(view)) {
                                view.getHitRect(rect);
                                if (rect.contains((int) x, (int) y)) {
                                    View[] viewArr = {view};
                                    viewTransition2.c(this, this.f583a, currentState, S, viewArr);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public void i(int i, View... viewArr) {
        ArrayList arrayList = new ArrayList();
        Iterator it = this.b.iterator();
        ViewTransition viewTransition = null;
        while (it.hasNext()) {
            ViewTransition viewTransition2 = (ViewTransition) it.next();
            if (viewTransition2.e() == i) {
                for (View view : viewArr) {
                    if (viewTransition2.d(view)) {
                        arrayList.add(view);
                    }
                }
                if (!arrayList.isEmpty()) {
                    j(viewTransition2, (View[]) arrayList.toArray(new View[0]));
                    arrayList.clear();
                }
                viewTransition = viewTransition2;
            }
        }
        if (viewTransition == null) {
            Log.e(this.d, " Could not find ViewTransition");
        }
    }

    public final void j(ViewTransition viewTransition, View... viewArr) {
        int currentState = this.f583a.getCurrentState();
        if (viewTransition.e == 2) {
            viewTransition.c(this, this.f583a, currentState, (ConstraintSet) null, viewArr);
        } else if (currentState == -1) {
            String str = this.d;
            Log.w(str, "No support for ViewTransition within transition yet. Currently: " + this.f583a.toString());
        } else {
            ConstraintSet S = this.f583a.S(currentState);
            if (S != null) {
                viewTransition.c(this, this.f583a, currentState, S, viewArr);
            }
        }
    }
}
