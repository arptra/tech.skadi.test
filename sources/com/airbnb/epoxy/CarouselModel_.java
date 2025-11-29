package com.airbnb.epoxy;

import android.view.ViewGroup;
import com.airbnb.epoxy.Carousel;
import java.util.BitSet;
import java.util.List;

public class CarouselModel_ extends EpoxyModel<Carousel> implements GeneratedModel<Carousel>, CarouselModelBuilder {
    public final BitSet l;
    public OnModelBoundListener m;
    public OnModelUnboundListener n;
    public OnModelVisibilityStateChangedListener o;
    public OnModelVisibilityChangedListener p;
    public boolean q;
    public float r;
    public int s;
    public int t;
    public int u;
    public Carousel.Padding v;
    public List w;

    public int A(int i, int i2, int i3) {
        return i;
    }

    public int B() {
        return 0;
    }

    public boolean P() {
        return true;
    }

    /* renamed from: T */
    public void t(Carousel carousel) {
        super.t(carousel);
        if (this.l.get(3)) {
            carousel.setPaddingRes(this.t);
        } else if (this.l.get(4)) {
            carousel.setPaddingDp(this.u);
        } else if (this.l.get(5)) {
            carousel.setPadding(this.v);
        } else {
            carousel.setPaddingDp(this.u);
        }
        carousel.setHasFixedSize(this.q);
        if (this.l.get(1)) {
            carousel.setNumViewsToShowOnScreen(this.r);
        } else if (this.l.get(2)) {
            carousel.setInitialPrefetchItemCount(this.s);
        } else {
            carousel.setNumViewsToShowOnScreen(this.r);
        }
        carousel.setModels(this.w);
    }

    /* renamed from: U */
    public void u(Carousel carousel, EpoxyModel epoxyModel) {
        Carousel.Padding padding;
        if (!(epoxyModel instanceof CarouselModel_)) {
            t(carousel);
            return;
        }
        CarouselModel_ carouselModel_ = (CarouselModel_) epoxyModel;
        super.t(carousel);
        if (this.l.get(3)) {
            int i = this.t;
            if (i != carouselModel_.t) {
                carousel.setPaddingRes(i);
            }
        } else if (this.l.get(4)) {
            int i2 = this.u;
            if (i2 != carouselModel_.u) {
                carousel.setPaddingDp(i2);
            }
        } else if (this.l.get(5)) {
            if (!carouselModel_.l.get(5) || ((padding = this.v) == null ? carouselModel_.v != null : !padding.equals(carouselModel_.v))) {
                carousel.setPadding(this.v);
            }
        } else if (carouselModel_.l.get(3) || carouselModel_.l.get(4) || carouselModel_.l.get(5)) {
            carousel.setPaddingDp(this.u);
        }
        boolean z = this.q;
        if (z != carouselModel_.q) {
            carousel.setHasFixedSize(z);
        }
        if (this.l.get(1)) {
            if (Float.compare(carouselModel_.r, this.r) != 0) {
                carousel.setNumViewsToShowOnScreen(this.r);
            }
        } else if (this.l.get(2)) {
            int i3 = this.s;
            if (i3 != carouselModel_.s) {
                carousel.setInitialPrefetchItemCount(i3);
            }
        } else if (carouselModel_.l.get(1) || carouselModel_.l.get(2)) {
            carousel.setNumViewsToShowOnScreen(this.r);
        }
        List list = this.w;
        List list2 = carouselModel_.w;
        if (list != null) {
            if (list.equals(list2)) {
                return;
            }
        } else if (list2 == null) {
            return;
        }
        carousel.setModels(this.w);
    }

    /* renamed from: V */
    public Carousel w(ViewGroup viewGroup) {
        Carousel carousel = new Carousel(viewGroup.getContext());
        carousel.setLayoutParams(new ViewGroup.MarginLayoutParams(-1, -2));
        return carousel;
    }

    /* renamed from: W */
    public void d(Carousel carousel, int i) {
        OnModelBoundListener onModelBoundListener = this.m;
        if (onModelBoundListener != null) {
            onModelBoundListener.a(this, carousel, i);
        }
        S("The model was changed during the bind call.", i);
    }

    /* renamed from: X */
    public void k(EpoxyViewHolder epoxyViewHolder, Carousel carousel, int i) {
        S("The model was changed between being added to the controller and being bound.", i);
    }

    /* renamed from: Y */
    public CarouselModel_ E(long j) {
        super.E(j);
        return this;
    }

    /* renamed from: Z */
    public void M(float f, float f2, int i, int i2, Carousel carousel) {
        OnModelVisibilityChangedListener onModelVisibilityChangedListener = this.p;
        if (onModelVisibilityChangedListener != null) {
            onModelVisibilityChangedListener.a(this, carousel, f, f2, i, i2);
        }
        super.M(f, f2, i, i2, carousel);
    }

    /* renamed from: a0 */
    public void N(int i, Carousel carousel) {
        OnModelVisibilityStateChangedListener onModelVisibilityStateChangedListener = this.o;
        if (onModelVisibilityStateChangedListener != null) {
            onModelVisibilityStateChangedListener.a(this, carousel, i);
        }
        super.N(i, carousel);
    }

    /* renamed from: b0 */
    public void R(Carousel carousel) {
        super.R(carousel);
        OnModelUnboundListener onModelUnboundListener = this.n;
        if (onModelUnboundListener != null) {
            onModelUnboundListener.a(this, carousel);
        }
        carousel.b();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CarouselModel_) || !super.equals(obj)) {
            return false;
        }
        CarouselModel_ carouselModel_ = (CarouselModel_) obj;
        if ((this.m == null) != (carouselModel_.m == null)) {
            return false;
        }
        if ((this.n == null) != (carouselModel_.n == null)) {
            return false;
        }
        if ((this.o == null) != (carouselModel_.o == null)) {
            return false;
        }
        if ((this.p == null) != (carouselModel_.p == null) || this.q != carouselModel_.q || Float.compare(carouselModel_.r, this.r) != 0 || this.s != carouselModel_.s || this.t != carouselModel_.t || this.u != carouselModel_.u) {
            return false;
        }
        Carousel.Padding padding = this.v;
        if (padding == null ? carouselModel_.v != null : !padding.equals(carouselModel_.v)) {
            return false;
        }
        List list = this.w;
        return list == null ? carouselModel_.w == null : list.equals(carouselModel_.w);
    }

    public int hashCode() {
        int i = 1;
        int i2 = 0;
        int hashCode = ((((((super.hashCode() * 31) + (this.m != null ? 1 : 0)) * 31) + (this.n != null ? 1 : 0)) * 31) + (this.o != null ? 1 : 0)) * 31;
        if (this.p == null) {
            i = 0;
        }
        int i3 = (((hashCode + i) * 31) + (this.q ? 1 : 0)) * 31;
        float f = this.r;
        int floatToIntBits = (((((((i3 + (f != 0.0f ? Float.floatToIntBits(f) : 0)) * 31) + this.s) * 31) + this.t) * 31) + this.u) * 31;
        Carousel.Padding padding = this.v;
        int hashCode2 = (floatToIntBits + (padding != null ? padding.hashCode() : 0)) * 31;
        List list = this.w;
        if (list != null) {
            i2 = list.hashCode();
        }
        return hashCode2 + i2;
    }

    public void r(EpoxyController epoxyController) {
        super.r(epoxyController);
        s(epoxyController);
        if (!this.l.get(6)) {
            throw new IllegalStateException("A value is required for setModels");
        }
    }

    public String toString() {
        return "CarouselModel_{hasFixedSize_Boolean=" + this.q + ", numViewsToShowOnScreen_Float=" + this.r + ", initialPrefetchItemCount_Int=" + this.s + ", paddingRes_Int=" + this.t + ", paddingDp_Int=" + this.u + ", padding_Padding=" + this.v + ", models_List=" + this.w + "}" + super.toString();
    }

    public int x() {
        throw new UnsupportedOperationException("Layout resources are unsupported for views created programmatically.");
    }
}
