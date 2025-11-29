package com.upuphone.ar.tici.phone.epoxy;

import android.view.ViewParent;
import com.airbnb.epoxy.EpoxyController;
import com.airbnb.epoxy.EpoxyViewHolder;
import com.airbnb.epoxy.GeneratedModel;
import com.airbnb.epoxy.OnModelBoundListener;
import com.airbnb.epoxy.OnModelUnboundListener;
import com.airbnb.epoxy.OnModelVisibilityChangedListener;
import com.airbnb.epoxy.OnModelVisibilityStateChangedListener;
import com.upuphone.ar.tici.phone.data.TiciHistory;
import com.upuphone.ar.tici.phone.listener.TiciHistoryItemListener;

public class TiciHistoryFileModel_ extends TiciHistoryFileModel implements GeneratedModel<TiciHistoryFileHolder>, TiciHistoryFileModelBuilder {
    public OnModelBoundListener t;
    public OnModelUnboundListener u;
    public OnModelVisibilityStateChangedListener v;
    public OnModelVisibilityChangedListener w;

    /* renamed from: A0 */
    public TiciHistoryFileModel_ E(long j) {
        super.E(j);
        return this;
    }

    /* renamed from: B0 */
    public TiciHistoryFileModel_ a(CharSequence charSequence) {
        super.F(charSequence);
        return this;
    }

    /* renamed from: C0 */
    public TiciHistoryFileModel_ j(boolean z) {
        J();
        super.r0(z);
        return this;
    }

    /* renamed from: D0 */
    public TiciHistoryFileModel_ c(boolean z) {
        J();
        super.t0(z);
        return this;
    }

    /* renamed from: E0 */
    public TiciHistoryFileModel_ n(boolean z) {
        J();
        super.v0(z);
        return this;
    }

    /* renamed from: F0 */
    public TiciHistoryFileModel_ m(boolean z) {
        J();
        super.w0(z);
        return this;
    }

    /* renamed from: G0 */
    public TiciHistoryFileModel_ b(int i) {
        J();
        super.s0(i);
        return this;
    }

    /* renamed from: H0 */
    public TiciHistoryFileModel_ i(TiciHistoryItemListener ticiHistoryItemListener) {
        J();
        super.u0(ticiHistoryItemListener);
        return this;
    }

    /* renamed from: I0 */
    public void a0(float f, float f2, int i, int i2, TiciHistoryFileHolder ticiHistoryFileHolder) {
        OnModelVisibilityChangedListener onModelVisibilityChangedListener = this.w;
        if (onModelVisibilityChangedListener != null) {
            onModelVisibilityChangedListener.a(this, ticiHistoryFileHolder, f, f2, i, i2);
        }
        super.M(f, f2, i, i2, ticiHistoryFileHolder);
    }

    /* renamed from: J0 */
    public void b0(int i, TiciHistoryFileHolder ticiHistoryFileHolder) {
        OnModelVisibilityStateChangedListener onModelVisibilityStateChangedListener = this.v;
        if (onModelVisibilityStateChangedListener != null) {
            onModelVisibilityStateChangedListener.a(this, ticiHistoryFileHolder, i);
        }
        super.N(i, ticiHistoryFileHolder);
    }

    /* renamed from: K0 */
    public TiciHistoryFileModel_ g(TiciHistory ticiHistory) {
        J();
        this.m = ticiHistory;
        return this;
    }

    /* renamed from: L0 */
    public void c0(TiciHistoryFileHolder ticiHistoryFileHolder) {
        super.R(ticiHistoryFileHolder);
        OnModelUnboundListener onModelUnboundListener = this.u;
        if (onModelUnboundListener != null) {
            onModelUnboundListener.a(this, ticiHistoryFileHolder);
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TiciHistoryFileModel_) || !super.equals(obj)) {
            return false;
        }
        TiciHistoryFileModel_ ticiHistoryFileModel_ = (TiciHistoryFileModel_) obj;
        if ((this.t == null) != (ticiHistoryFileModel_.t == null)) {
            return false;
        }
        if ((this.u == null) != (ticiHistoryFileModel_.u == null)) {
            return false;
        }
        if ((this.v == null) != (ticiHistoryFileModel_.v == null)) {
            return false;
        }
        if ((this.w == null) != (ticiHistoryFileModel_.w == null)) {
            return false;
        }
        TiciHistory ticiHistory = this.m;
        if (ticiHistory == null ? ticiHistoryFileModel_.m != null : !ticiHistory.equals(ticiHistoryFileModel_.m)) {
            return false;
        }
        if (k0() != ticiHistoryFileModel_.k0() || p0() != ticiHistoryFileModel_.p0() || q0() != ticiHistoryFileModel_.q0() || n0() != ticiHistoryFileModel_.n0() || o0() != ticiHistoryFileModel_.o0()) {
            return false;
        }
        return (l0() == null) == (ticiHistoryFileModel_.l0() == null);
    }

    public int hashCode() {
        int i = 1;
        int hashCode = ((((((((super.hashCode() * 31) + (this.t != null ? 1 : 0)) * 31) + (this.u != null ? 1 : 0)) * 31) + (this.v != null ? 1 : 0)) * 31) + (this.w != null ? 1 : 0)) * 31;
        TiciHistory ticiHistory = this.m;
        int hashCode2 = (((((((((((hashCode + (ticiHistory != null ? ticiHistory.hashCode() : 0)) * 31) + k0()) * 31) + (p0() ? 1 : 0)) * 31) + (q0() ? 1 : 0)) * 31) + (n0() ? 1 : 0)) * 31) + (o0() ? 1 : 0)) * 31;
        if (l0() == null) {
            i = 0;
        }
        return hashCode2 + i;
    }

    public void r(EpoxyController epoxyController) {
        super.r(epoxyController);
        s(epoxyController);
    }

    public String toString() {
        return "TiciHistoryFileModel_{ticiHistory=" + this.m + ", itemBgRes=" + k0() + ", isLoading=" + p0() + ", isRunning=" + q0() + ", isImpatient=" + n0() + ", isLastItem=" + o0() + ", listener=" + l0() + "}" + super.toString();
    }

    /* renamed from: x0 */
    public TiciHistoryFileHolder W(ViewParent viewParent) {
        return new TiciHistoryFileHolder();
    }

    /* renamed from: y0 */
    public void d(TiciHistoryFileHolder ticiHistoryFileHolder, int i) {
        OnModelBoundListener onModelBoundListener = this.t;
        if (onModelBoundListener != null) {
            onModelBoundListener.a(this, ticiHistoryFileHolder, i);
        }
        S("The model was changed during the bind call.", i);
    }

    /* renamed from: z0 */
    public void k(EpoxyViewHolder epoxyViewHolder, TiciHistoryFileHolder ticiHistoryFileHolder, int i) {
        S("The model was changed between being added to the controller and being bound.", i);
    }
}
