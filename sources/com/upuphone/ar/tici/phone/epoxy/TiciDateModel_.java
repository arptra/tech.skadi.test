package com.upuphone.ar.tici.phone.epoxy;

import android.view.ViewParent;
import com.airbnb.epoxy.EpoxyController;
import com.airbnb.epoxy.EpoxyViewHolder;
import com.airbnb.epoxy.GeneratedModel;
import com.airbnb.epoxy.OnModelBoundListener;
import com.airbnb.epoxy.OnModelUnboundListener;
import com.airbnb.epoxy.OnModelVisibilityChangedListener;
import com.airbnb.epoxy.OnModelVisibilityStateChangedListener;

public class TiciDateModel_ extends TiciDateModel implements GeneratedModel<TiciDateHolder>, TiciDateModelBuilder {
    public OnModelBoundListener o;
    public OnModelUnboundListener p;
    public OnModelVisibilityStateChangedListener q;
    public OnModelVisibilityChangedListener r;

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TiciDateModel_) || !super.equals(obj)) {
            return false;
        }
        TiciDateModel_ ticiDateModel_ = (TiciDateModel_) obj;
        if ((this.o == null) != (ticiDateModel_.o == null)) {
            return false;
        }
        if ((this.p == null) != (ticiDateModel_.p == null)) {
            return false;
        }
        if ((this.q == null) != (ticiDateModel_.q == null)) {
            return false;
        }
        if ((this.r == null) != (ticiDateModel_.r == null)) {
            return false;
        }
        String str = this.m;
        if (str == null ? ticiDateModel_.m == null : str.equals(ticiDateModel_.m)) {
            return f0() == ticiDateModel_.f0();
        }
        return false;
    }

    /* renamed from: h0 */
    public TiciDateHolder W(ViewParent viewParent) {
        return new TiciDateHolder();
    }

    public int hashCode() {
        int i = 1;
        int i2 = 0;
        int hashCode = ((((((super.hashCode() * 31) + (this.o != null ? 1 : 0)) * 31) + (this.p != null ? 1 : 0)) * 31) + (this.q != null ? 1 : 0)) * 31;
        if (this.r == null) {
            i = 0;
        }
        int i3 = (hashCode + i) * 31;
        String str = this.m;
        if (str != null) {
            i2 = str.hashCode();
        }
        return ((i3 + i2) * 31) + (f0() ? 1 : 0);
    }

    /* renamed from: i0 */
    public TiciDateModel_ f(String str) {
        J();
        this.m = str;
        return this;
    }

    /* renamed from: j0 */
    public void d(TiciDateHolder ticiDateHolder, int i) {
        OnModelBoundListener onModelBoundListener = this.o;
        if (onModelBoundListener != null) {
            onModelBoundListener.a(this, ticiDateHolder, i);
        }
        S("The model was changed during the bind call.", i);
    }

    /* renamed from: k0 */
    public void k(EpoxyViewHolder epoxyViewHolder, TiciDateHolder ticiDateHolder, int i) {
        S("The model was changed between being added to the controller and being bound.", i);
    }

    /* renamed from: l0 */
    public TiciDateModel_ E(long j) {
        super.E(j);
        return this;
    }

    /* renamed from: m0 */
    public TiciDateModel_ a(CharSequence charSequence) {
        super.F(charSequence);
        return this;
    }

    /* renamed from: n0 */
    public TiciDateModel_ l(boolean z) {
        J();
        super.g0(z);
        return this;
    }

    /* renamed from: o0 */
    public void a0(float f, float f2, int i, int i2, TiciDateHolder ticiDateHolder) {
        OnModelVisibilityChangedListener onModelVisibilityChangedListener = this.r;
        if (onModelVisibilityChangedListener != null) {
            onModelVisibilityChangedListener.a(this, ticiDateHolder, f, f2, i, i2);
        }
        super.M(f, f2, i, i2, ticiDateHolder);
    }

    /* renamed from: p0 */
    public void b0(int i, TiciDateHolder ticiDateHolder) {
        OnModelVisibilityStateChangedListener onModelVisibilityStateChangedListener = this.q;
        if (onModelVisibilityStateChangedListener != null) {
            onModelVisibilityStateChangedListener.a(this, ticiDateHolder, i);
        }
        super.N(i, ticiDateHolder);
    }

    /* renamed from: q0 */
    public void c0(TiciDateHolder ticiDateHolder) {
        super.R(ticiDateHolder);
        OnModelUnboundListener onModelUnboundListener = this.p;
        if (onModelUnboundListener != null) {
            onModelUnboundListener.a(this, ticiDateHolder);
        }
    }

    public void r(EpoxyController epoxyController) {
        super.r(epoxyController);
        s(epoxyController);
    }

    public String toString() {
        return "TiciDateModel_{date=" + this.m + ", isFirstItem=" + f0() + "}" + super.toString();
    }
}
