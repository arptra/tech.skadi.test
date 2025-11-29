package androidx.appcompat.view;

import android.view.View;
import android.view.animation.Interpolator;
import androidx.annotation.RestrictTo;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListener;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;
import java.util.ArrayList;
import java.util.Iterator;

@RestrictTo
public class ViewPropertyAnimatorCompatSet {

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList f217a = new ArrayList();
    public long b = -1;
    public Interpolator c;
    public ViewPropertyAnimatorListener d;
    public boolean e;
    public final ViewPropertyAnimatorListenerAdapter f = new ViewPropertyAnimatorListenerAdapter() {

        /* renamed from: a  reason: collision with root package name */
        public boolean f218a = false;
        public int b = 0;

        public void a() {
            this.b = 0;
            this.f218a = false;
            ViewPropertyAnimatorCompatSet.this.b();
        }

        public void onAnimationEnd(View view) {
            int i = this.b + 1;
            this.b = i;
            if (i == ViewPropertyAnimatorCompatSet.this.f217a.size()) {
                ViewPropertyAnimatorListener viewPropertyAnimatorListener = ViewPropertyAnimatorCompatSet.this.d;
                if (viewPropertyAnimatorListener != null) {
                    viewPropertyAnimatorListener.onAnimationEnd((View) null);
                }
                a();
            }
        }

        public void onAnimationStart(View view) {
            if (!this.f218a) {
                this.f218a = true;
                ViewPropertyAnimatorListener viewPropertyAnimatorListener = ViewPropertyAnimatorCompatSet.this.d;
                if (viewPropertyAnimatorListener != null) {
                    viewPropertyAnimatorListener.onAnimationStart((View) null);
                }
            }
        }
    };

    public void a() {
        if (this.e) {
            Iterator it = this.f217a.iterator();
            while (it.hasNext()) {
                ((ViewPropertyAnimatorCompat) it.next()).c();
            }
            this.e = false;
        }
    }

    public void b() {
        this.e = false;
    }

    public ViewPropertyAnimatorCompatSet c(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat) {
        if (!this.e) {
            this.f217a.add(viewPropertyAnimatorCompat);
        }
        return this;
    }

    public ViewPropertyAnimatorCompatSet d(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, ViewPropertyAnimatorCompat viewPropertyAnimatorCompat2) {
        this.f217a.add(viewPropertyAnimatorCompat);
        viewPropertyAnimatorCompat2.m(viewPropertyAnimatorCompat.d());
        this.f217a.add(viewPropertyAnimatorCompat2);
        return this;
    }

    public ViewPropertyAnimatorCompatSet e(long j) {
        if (!this.e) {
            this.b = j;
        }
        return this;
    }

    public ViewPropertyAnimatorCompatSet f(Interpolator interpolator) {
        if (!this.e) {
            this.c = interpolator;
        }
        return this;
    }

    public ViewPropertyAnimatorCompatSet g(ViewPropertyAnimatorListener viewPropertyAnimatorListener) {
        if (!this.e) {
            this.d = viewPropertyAnimatorListener;
        }
        return this;
    }

    public void h() {
        if (!this.e) {
            Iterator it = this.f217a.iterator();
            while (it.hasNext()) {
                ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = (ViewPropertyAnimatorCompat) it.next();
                long j = this.b;
                if (j >= 0) {
                    viewPropertyAnimatorCompat.i(j);
                }
                Interpolator interpolator = this.c;
                if (interpolator != null) {
                    viewPropertyAnimatorCompat.j(interpolator);
                }
                if (this.d != null) {
                    viewPropertyAnimatorCompat.k(this.f);
                }
                viewPropertyAnimatorCompat.o();
            }
            this.e = true;
        }
    }
}
