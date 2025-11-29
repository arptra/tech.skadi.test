package com.airbnb.epoxy;

import java.util.List;

public abstract class EpoxyAdapter extends BaseEpoxyAdapter {
    public final HiddenEpoxyModel f;
    public final List g;

    public List j() {
        return this.g;
    }

    public EpoxyModel k(int i) {
        EpoxyModel epoxyModel = (EpoxyModel) this.g.get(i);
        return epoxyModel.H() ? epoxyModel : this.f;
    }
}
