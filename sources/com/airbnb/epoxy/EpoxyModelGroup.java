package com.airbnb.epoxy;

import android.view.ViewParent;
import java.util.Collections;
import java.util.List;

public class EpoxyModelGroup extends EpoxyModelWithHolder<ModelGroupHolder> {
    public final List l;
    public boolean m;
    public Boolean n;

    public interface IterateModelsCallback {
        void a(EpoxyModel epoxyModel, EpoxyViewHolder epoxyViewHolder, int i);
    }

    public static void m0(EpoxyModel epoxyModel, EpoxyViewHolder epoxyViewHolder) {
        if (epoxyModel.H()) {
            epoxyViewHolder.itemView.setVisibility(0);
        } else {
            epoxyViewHolder.itemView.setVisibility(8);
        }
    }

    public int A(int i, int i2, int i3) {
        return ((EpoxyModel) this.l.get(0)).Q(i, i2, i3);
    }

    public boolean P() {
        Boolean bool = this.n;
        return bool != null ? bool.booleanValue() : this.m;
    }

    public void e0(EpoxyModel epoxyModel) {
        this.m |= epoxyModel.P();
        this.l.add(epoxyModel);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof EpoxyModelGroup) && super.equals(obj)) {
            return this.l.equals(((EpoxyModelGroup) obj).l);
        }
        return false;
    }

    /* renamed from: f0 */
    public void t(ModelGroupHolder modelGroupHolder) {
        j0(modelGroupHolder, new IterateModelsCallback() {
            public void a(EpoxyModel epoxyModel, EpoxyViewHolder epoxyViewHolder, int i) {
                EpoxyModelGroup.m0(epoxyModel, epoxyViewHolder);
                epoxyViewHolder.b(epoxyModel, (EpoxyModel) null, Collections.emptyList(), i);
            }
        });
    }

    /* renamed from: g0 */
    public void u(ModelGroupHolder modelGroupHolder, EpoxyModel epoxyModel) {
        if (!(epoxyModel instanceof EpoxyModelGroup)) {
            t(modelGroupHolder);
            return;
        }
        final EpoxyModelGroup epoxyModelGroup = (EpoxyModelGroup) epoxyModel;
        j0(modelGroupHolder, new IterateModelsCallback() {
            public void a(EpoxyModel epoxyModel, EpoxyViewHolder epoxyViewHolder, int i) {
                EpoxyModelGroup.m0(epoxyModel, epoxyViewHolder);
                if (i < epoxyModelGroup.l.size()) {
                    EpoxyModel epoxyModel2 = (EpoxyModel) epoxyModelGroup.l.get(i);
                    if (epoxyModel2.D() == epoxyModel.D()) {
                        epoxyViewHolder.b(epoxyModel, epoxyModel2, Collections.emptyList(), i);
                        return;
                    }
                }
                epoxyViewHolder.b(epoxyModel, (EpoxyModel) null, Collections.emptyList(), i);
            }
        });
    }

    /* renamed from: h0 */
    public void v(ModelGroupHolder modelGroupHolder, List list) {
        j0(modelGroupHolder, new IterateModelsCallback() {
            public void a(EpoxyModel epoxyModel, EpoxyViewHolder epoxyViewHolder, int i) {
                EpoxyModelGroup.m0(epoxyModel, epoxyViewHolder);
                epoxyViewHolder.b(epoxyModel, (EpoxyModel) null, Collections.emptyList(), i);
            }
        });
    }

    public int hashCode() {
        return (super.hashCode() * 31) + this.l.hashCode();
    }

    /* renamed from: i0 */
    public final ModelGroupHolder W(ViewParent viewParent) {
        return new ModelGroupHolder(viewParent);
    }

    public final void j0(ModelGroupHolder modelGroupHolder, IterateModelsCallback iterateModelsCallback) {
        modelGroupHolder.c(this);
        int size = this.l.size();
        for (int i = 0; i < size; i++) {
            iterateModelsCallback.a((EpoxyModel) this.l.get(i), (EpoxyViewHolder) modelGroupHolder.i().get(i), i);
        }
    }

    /* renamed from: k0 */
    public void Y(ModelGroupHolder modelGroupHolder) {
        j0(modelGroupHolder, new IterateModelsCallback() {
            public void a(EpoxyModel epoxyModel, EpoxyViewHolder epoxyViewHolder, int i) {
                epoxyModel.K(epoxyViewHolder.e());
            }
        });
    }

    /* renamed from: l0 */
    public void Z(ModelGroupHolder modelGroupHolder) {
        j0(modelGroupHolder, new IterateModelsCallback() {
            public void a(EpoxyModel epoxyModel, EpoxyViewHolder epoxyViewHolder, int i) {
                epoxyModel.L(epoxyViewHolder.e());
            }
        });
    }

    /* renamed from: n0 */
    public void c0(ModelGroupHolder modelGroupHolder) {
        modelGroupHolder.k();
    }

    public boolean o0(EpoxyModel epoxyModel, int i) {
        return true;
    }

    public final int x() {
        throw new UnsupportedOperationException("You should set a layout with layout(...) instead of using this.");
    }
}
