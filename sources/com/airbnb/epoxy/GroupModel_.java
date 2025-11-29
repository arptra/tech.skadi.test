package com.airbnb.epoxy;

public class GroupModel_ extends GroupModel implements GeneratedModel<ModelGroupHolder>, GroupModelBuilder {
    public OnModelBoundListener o;
    public OnModelUnboundListener p;
    public OnModelVisibilityStateChangedListener q;
    public OnModelVisibilityChangedListener r;

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GroupModel_) || !super.equals(obj)) {
            return false;
        }
        GroupModel_ groupModel_ = (GroupModel_) obj;
        if ((this.o == null) != (groupModel_.o == null)) {
            return false;
        }
        if ((this.p == null) != (groupModel_.p == null)) {
            return false;
        }
        if ((this.q == null) != (groupModel_.q == null)) {
            return false;
        }
        return (this.r == null) == (groupModel_.r == null);
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((((((super.hashCode() * 31) + (this.o != null ? 1 : 0)) * 31) + (this.p != null ? 1 : 0)) * 31) + (this.q != null ? 1 : 0)) * 31;
        if (this.r != null) {
            i = 1;
        }
        return hashCode + i;
    }

    /* renamed from: n0 */
    public void c0(ModelGroupHolder modelGroupHolder) {
        super.c0(modelGroupHolder);
        OnModelUnboundListener onModelUnboundListener = this.p;
        if (onModelUnboundListener != null) {
            onModelUnboundListener.a(this, modelGroupHolder);
        }
    }

    /* renamed from: p0 */
    public void d(ModelGroupHolder modelGroupHolder, int i) {
        OnModelBoundListener onModelBoundListener = this.o;
        if (onModelBoundListener != null) {
            onModelBoundListener.a(this, modelGroupHolder, i);
        }
        S("The model was changed during the bind call.", i);
    }

    /* renamed from: q0 */
    public void k(EpoxyViewHolder epoxyViewHolder, ModelGroupHolder modelGroupHolder, int i) {
        S("The model was changed between being added to the controller and being bound.", i);
    }

    public void r(EpoxyController epoxyController) {
        super.r(epoxyController);
        s(epoxyController);
    }

    /* renamed from: r0 */
    public GroupModel_ E(long j) {
        super.E(j);
        return this;
    }

    /* renamed from: s0 */
    public void a0(float f, float f2, int i, int i2, ModelGroupHolder modelGroupHolder) {
        OnModelVisibilityChangedListener onModelVisibilityChangedListener = this.r;
        if (onModelVisibilityChangedListener != null) {
            onModelVisibilityChangedListener.a(this, modelGroupHolder, f, f2, i, i2);
        }
        super.M(f, f2, i, i2, modelGroupHolder);
    }

    /* renamed from: t0 */
    public void b0(int i, ModelGroupHolder modelGroupHolder) {
        OnModelVisibilityStateChangedListener onModelVisibilityStateChangedListener = this.q;
        if (onModelVisibilityStateChangedListener != null) {
            onModelVisibilityStateChangedListener.a(this, modelGroupHolder, i);
        }
        super.N(i, modelGroupHolder);
    }

    public String toString() {
        return "GroupModel_{}" + super.toString();
    }
}
